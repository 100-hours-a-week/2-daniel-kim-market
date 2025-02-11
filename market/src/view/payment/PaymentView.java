package view.payment;

import controller.payment.PaymentController;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class PaymentView {
    private final AtomicBoolean isRunning;
    private final Scanner scanner;
    private final PaymentController paymentController;

    public PaymentView() {
        this.isRunning = new AtomicBoolean(true);
        this.scanner = new Scanner(System.in);
        this.paymentController = new PaymentController();
    }

    public void PaymentMenu() {
        while (isRunning.get()) {
            System.out.println("\n=== 💵 결제 시스템 ===");
            System.out.println("[1] 현금 결제");
            System.out.println("[2] 카드 결제");
            System.out.println("[3] 결제 취소");
            System.out.print("👉 선택하세요: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거

            if (choice == 3) {
                System.out.println("🔚 결제를 취소합니다.");
                isRunning.set(false);
            } else {
                paymentController.processPayment(choice);
            }
        }
    }
}
