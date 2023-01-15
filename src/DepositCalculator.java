import java.util.Scanner;

public class DepositCalculator {
    double complexPercent(double a, double y, int d) {
        double payment = a * Math.pow((1 + y / 12), 12 * d);
        return depositAmount(payment, 2);
    }

    double simplePercent(double amount, double yearRate, int depositPeriod) {
        return depositAmount(amount + amount * yearRate * depositPeriod, 2);
    }

    double depositAmount(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void getResultOfDeposit() {
        int period;
        int command;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int firstDepositAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        command = scanner.nextInt();
        double finalDepositAmount = 0; /*вот если честно, то я не знаю точно, как лучше сделать, но как по мне, лучше
        перенести объявление переменной в начало метода и отделить их пустой строкой от отдельного кода, либо вынести за
        предел метода, вместе с остальными переменными. Хотя, может твой вариант более правильный.
        Мда, так себе я ревьюер :(*/
        if (command == 1) {
            finalDepositAmount = simplePercent(firstDepositAmount, 0.06, period);
        } else if (command == 2) {
            finalDepositAmount = complexPercent(firstDepositAmount, 0.06, period);
        }
        System.out.println("Результат вклада: " + firstDepositAmount + " за " + period + " лет превратятся в " + finalDepositAmount); //эта строка > 120 символов))
    }

    public static void main(String[] args) {
//зачем тут эта пустая строка?
        new DepositCalculator().getResultOfDeposit();
    }

}
