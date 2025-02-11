package controller;

import java.util.Scanner;
import service.UserService;
import model.User;

public class UserController {
    private UserService userService;
    private Scanner sc;

    public UserController(UserService userService) {
        this.userService = userService;
        this.sc = new Scanner(System.in);
    }

    // 회원가입 처리: 사용자 입력을 받고 Service에 전달
    public void MAKE_USER() {
        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();

        System.out.print("사용하실 아이디를 입력하세요: ");
        String id = sc.nextLine();

        String pw = ParsePassword();

        if (userService.isDuplicatedUser(name, id, pw)) {
            System.out.println("회원가입이 완료되었습니다.");
        } else {
            System.out.println("회원가입에 실패했습니다. 아이디 중복이나 비밀번호 조건을 확인하세요.");
        }
    }

    // 로그인 처리: 사용자 입력을 받고 Service에 전달
    public boolean isLogin() {
        System.out.print("아이디를 입력하세요: ");
        String id = sc.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String pw = sc.nextLine();
    
        User user = userService.loginUser(id, pw);
        if (user != null) {
            System.out.printf("%s 님 환영합니다!\n", user.getName());
            return true;
        } else {
            System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
            return false;
        }
    }
    

    // 비밀번호 입력 및 확인 로직
    private String ParsePassword() {
        String pw;
        while (true) {
            System.out.print("사용하실 비밀번호를 입력하세요 (8자 이상, 대문자 1개 이상 포함): ");
            pw = sc.nextLine();
            System.out.print("비밀번호 확인: ");
            String confirmPW = sc.nextLine();
            if (pw.equals(confirmPW)) {
                break;
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.\n");
            }
        }
        return pw;
    }
}
