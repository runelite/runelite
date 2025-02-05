//package net.runelite.client.plugins.toolbox.core;
//
//import lombok.SneakyThrows;
//import net.runelite.client.plugins.toolbox.ToolBoxPlugin;
//import java.util.concurrent.*;
//import java.util.function.BooleanSupplier;
//
//public class Global {
//    static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
//    static ScheduledFuture<?> scheduledFuture;
//
//    public static ScheduledFuture<?> awaitExecutionUntil(Runnable callback, BooleanSupplier awaitedCondition, int time) {
//        scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(() -> {
//            if (awaitedCondition.getAsBoolean()) {
//                scheduledFuture.cancel(true);
//                scheduledFuture = null;
//                callback.run();
//            }
//        }, 0, time, TimeUnit.MILLISECONDS);
//        return scheduledFuture;
//    }
//
//    public static void sleep(int start) {
//        if (ToolBoxPlugin.getClient().isClientThread()) return;
//        try {
//            Thread.sleep(start);
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public static void sleep(int start, int end) {
//        int randomSleep = Randomization.between(start, end);
//        try {
//            Thread.sleep(randomSleep);
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public static void sleepGaussian(int mean, int stddev) {
//        int randomSleep = Randomization.randomGaussian(mean, stddev);
//        try {
//            Thread.sleep(randomSleep);
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public static void sleepUntil(BooleanSupplier awaitedCondition) {
//        sleepUntil(awaitedCondition, 5000);
//    }
//
//    @SneakyThrows
//    public static <T> T sleepUntilNotNull(Callable<T> method, int time) {
//        if (ToolBoxPlugin.getClient().isClientThread()) return null;
//        boolean done;
//        T methodResponse;
//        long startTime = System.currentTimeMillis();
//        do {
//            methodResponse = method.call();
//            done = methodResponse != null;
//            sleep(100);
//        } while (!done && System.currentTimeMillis() - startTime < time);
//        return methodResponse;
//    }
//
//
//    public static boolean sleepUntil(BooleanSupplier awaitedCondition, int time) {
//        if (ToolBoxPlugin.getClient().isClientThread()) return false;
//        boolean done;
//        long startTime = System.currentTimeMillis();
//        do {
//            done = awaitedCondition.getAsBoolean();
//            sleep(100);
//        } while (!done && System.currentTimeMillis() - startTime < time);
//
//        return done;
//    }
//
//    /**
//     * Sleeps until a specified condition is met, running an action periodically, or until a timeout is reached.
//     *
//     * @param awaitedCondition The condition to wait for.
//     * @param action           The action to run periodically while waiting.
//     * @param timeoutMillis    The maximum time to wait in milliseconds.
//     * @param sleepMillis      The time to sleep between action executions in milliseconds.
//     * @return true if the condition was met within the timeout, false otherwise.
//     */
//    public static boolean sleepUntil(BooleanSupplier awaitedCondition, Runnable action, long timeoutMillis, int sleepMillis) {
//        long startTime = System.nanoTime();
//        long timeoutNanos = TimeUnit.MILLISECONDS.toNanos(timeoutMillis);
//        try {
//            while (System.nanoTime() - startTime < timeoutNanos) {
//                action.run();
//                if (awaitedCondition.getAsBoolean()) {
//                    return true;
//                }
//                sleep(sleepMillis);
//            }
//        } catch (Exception e) {
//            Thread.currentThread().interrupt(); // Restore the interrupt status
//        }
//        return false; // Timeout reached without satisfying the condition
//    }
//
//    /**
//     * Sleeps until the given condition is true or a default timeout of 5 seconds is reached.
//     *
//     * @param awaitedCondition the condition to wait for, represented as a {@link BooleanSupplier}.
//     * @return {@code true} if the condition became true within the timeout, {@code false} otherwise.
//     * Returns {@code false} immediately if called on the client thread.
//     */
//    public static boolean sleepUntilTrue(BooleanSupplier awaitedCondition) {
//        if (ToolBoxPlugin.getClient().isClientThread()) return false;
//        long startTime = System.currentTimeMillis();
//        do {
//            if (awaitedCondition.getAsBoolean()) {
//                return true;
//            }
//            sleep(100);
//        } while (System.currentTimeMillis() - startTime < 5000);
//        return false;
//    }
//
//    /**
//     * Sleeps until the given condition is true or a specified timeout is reached.
//     *
//     * @param awaitedCondition the condition to wait for, represented as a {@link BooleanSupplier}.
//     * @param time             the interval in milliseconds to sleep between condition checks.
//     * @param timeout          the maximum time in milliseconds to wait for the condition to become true.
//     * @return {@code true} if the condition became true within the timeout, {@code false} otherwise.
//     * Returns {@code false} immediately if called on the client thread.
//     */
//    public static boolean sleepUntilTrue(BooleanSupplier awaitedCondition, int time, int timeout) {
//        if (ToolBoxPlugin.getClient().isClientThread()) return false;
//        long startTime = System.currentTimeMillis();
//        do {
//            if (awaitedCondition.getAsBoolean()) {
//                return true;
//            }
//            sleep(time);
//        } while (System.currentTimeMillis() - startTime < timeout);
//        return false;
//    }
//
//    /**
//     * Sleeps until the given condition is true or a specified timeout is reached,
//     * while allowing a reset condition to restart the timeout.
//     *
//     * @param awaitedCondition the condition to wait for, represented as a {@link BooleanSupplier}.
//     * @param resetCondition   a condition that, when true, resets the timeout timer.
//     * @param time             the interval in milliseconds to sleep between condition checks.
//     * @param timeout          the maximum time in milliseconds to wait for the {@code awaitedCondition} to become true.
//     * @return {@code true} if the {@code awaitedCondition} became true within the timeout, {@code false} otherwise.
//     * Returns {@code false} immediately if called on the client thread.
//     */
//    public static boolean sleepUntilTrue(BooleanSupplier awaitedCondition, BooleanSupplier resetCondition, int time, int timeout) {
//        if (ToolBoxPlugin.getClient().isClientThread()) return false;
//        long startTime = System.currentTimeMillis();
//        do {
//            if (resetCondition.getAsBoolean()) {
//                startTime = System.currentTimeMillis();
//            }
//
//            if (awaitedCondition.getAsBoolean()) {
//                return true;
//            }
//            sleep(time);
//        } while (System.currentTimeMillis() - startTime < timeout);
//        return false;
//    }
//
//    public static void sleepUntilOnClientThread(BooleanSupplier awaitedCondition) {
//        sleepUntilOnClientThread(awaitedCondition, Randomization.between(2500, 5000));
//    }
//
//    public static void sleepUntilOnClientThread(BooleanSupplier awaitedCondition, int time) {
//        if (ToolBoxPlugin.getClient().isClientThread()) return;
//        boolean done;
//        long startTime = System.currentTimeMillis();
//        do {
//            done = ToolBoxPlugin.getClientThread().runOnClientThread(() -> awaitedCondition.getAsBoolean());
//        } while (!done && System.currentTimeMillis() - startTime < time);
//    }
//}