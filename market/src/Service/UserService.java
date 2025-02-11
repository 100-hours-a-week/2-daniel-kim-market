package service;

import model.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static final String INFO_FILE = "users.txt";
    private List<User> users;

    public UserService() {
        this.users = loadUsers();
    }

    public boolean isDuplicatedUser(String name, String id, String pw) {
        if (!isIDAvailable(id) || !isPWValid(pw)) {
            return false;
        }
        User newUser = new User(name, id, pw);
        users.add(newUser);
        return saveUser(newUser);
    }

    public User loginUser(String id, String pw) {
        return users.stream()
                .filter(user -> user.getId().equals(id) && user.getPw().equals(pw))
                .findFirst().orElse(null);
    }

    private boolean isIDAvailable(String id) {
        return users.stream().noneMatch(user -> user.getId().equals(id));
    }

    private boolean isPWValid(String pw) {
        return pw.length() >= 8 && pw.chars().anyMatch(Character::isUpperCase);
    }

    private boolean saveUser(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(INFO_FILE, true))) {
            writer.write(user.getName() + "," + user.getId() + "," + user.getPw());
            writer.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("사용자 정보를 저장하는 동안 오류가 발생했습니다: " + e.getMessage());
            return false;
        }
    }

    private List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(INFO_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    users.add(new User(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("사용자 정보를 불러오는 동안 오류가 발생했습니다.");
        }
        return users;
    }
}
