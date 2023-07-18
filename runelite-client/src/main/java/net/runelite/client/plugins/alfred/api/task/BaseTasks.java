package net.runelite.client.plugins.alfred.api.task;

public class BaseTasks {

    private final BankTasks bankTasks;

    public BaseTasks() {
        bankTasks = new BankTasks();
    }

    public BankTasks banks() {
        return bankTasks;
    }
}
