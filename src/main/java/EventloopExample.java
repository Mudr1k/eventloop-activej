import io.activej.eventloop.Eventloop;

import static java.lang.System.currentTimeMillis;

public class EventloopExample {

    public static void main(String[] args) {
        Eventloop eventloop = Eventloop.create().withCurrentThread();
        long startTime = currentTimeMillis();

        eventloop.delay(3000L, () -> task1(startTime));
        eventloop.delay(1000L, () -> task2(startTime));
        eventloop.delay(100L, () -> task3(startTime));

        System.out.println("Before running eventloop, time: " + (currentTimeMillis() - startTime));

        eventloop.run();

    }

    private static void task1(long startTime) {
        System.out.println("Eventloop.delay(3000) is finished, time: " +
                (currentTimeMillis() - startTime));
    }

    private static void task2(long startTime) {
        System.out.println("Eventloop.delay(1000) is finished, time: " +
                (currentTimeMillis() - startTime));
    }

    private static void task3(long startTime) {
        System.out.println("Eventloop.delay(100) is finished, time: " +
                (currentTimeMillis() - startTime));
    }
}
