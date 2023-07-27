package net.runelite.client.plugins.alfred.api.task;

public class BaseTasks {

    private final BankTasks bankTasks;
    private final NPCTasks npcTasks;
    private final ItemTasks itemTasks;

    public BaseTasks() {
        bankTasks = new BankTasks();
        npcTasks = new NPCTasks();
        itemTasks = new ItemTasks();
    }

    public BankTasks banks() {
        return bankTasks;
    }

    public NPCTasks npcs() {
        return npcTasks;
    }

    public ItemTasks items() {
        return itemTasks;
    }
}
