import java.util.Date;

public class TestResult {
    /*
    - Загальна кількість тестів
    - Кількість успішно пройдених тестів
    - Кількість провалених тестів
    - Фактичний час запуску тестів (можна використовувати тип даних Date)
     */
    int count;
    int countSuccess;
    int countFail;
    String date;

    public TestResult(int count, int countSuccess, int countFail, String date) {
        this.count = count;
        this.countSuccess = countSuccess;
        this.countFail = countFail;
        this.date = date;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "count=" + count +
                ", countSuccess=" + countSuccess +
                ", countFail=" + countFail +
                ", date=" + date +
                '}';
    }
}
