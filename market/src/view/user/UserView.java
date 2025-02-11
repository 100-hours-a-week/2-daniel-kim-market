package view.user;

import controller.UserController;
import service.UserService;
import view.market.MarketView;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class UserView {
    private final UserService userService;
    private final UserController userController;
    private final Scanner sc;
    private final AtomicBoolean isRunning;
    private MarketView marketView;

    public UserView() {
        this.userService = new UserService();
        this.userController = new UserController(userService);
        this.sc = new Scanner(System.in);
        this.isRunning = new AtomicBoolean(true);
    }

    public void startUserMenu() {
        AtomicBoolean loggedIn = new AtomicBoolean(false);

        while (isRunning.get()) {
            System.out.println("\n=== Hun's Book ===");
            System.out.println("[1] 로그인");
            System.out.println("[2] 회원가입");
            System.out.println("[3] 종료");
            System.out.print("메뉴를 선택하세요: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (userController.isLogin()) {
                        loggedIn.set(true);
                        isRunning.set(false);
                    }
                    break;
                case 2:
                    userController.MAKE_USER();
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    isRunning.set(false);
                    break;
                default:
                    System.out.println("올바른 선택이 아닙니다.");
            }
        }

        if (loggedIn.get()) {
            marketView = new MarketView();
            marketView.marketMenu(this);
        }
    }

    public void returnToUserMenu() {
        System.out.println("로그아웃되었습니다. 사용자 메뉴로 돌아갑니다.");
        isRunning.set(true);
        startUserMenu();
    }
}
