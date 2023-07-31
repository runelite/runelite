package net.runelite.client.plugins.alfred.api.task;

public class BaseTasks {

    private final BankTasks bankTasks;
    private final NPCTasks npcTasks;
    private final ItemTasks itemTasks;
    private final ObjectTasks objectTasks;

    public BaseTasks() {
        bankTasks = new BankTasks();
        npcTasks = new NPCTasks();
        itemTasks = new ItemTasks();
        objectTasks = new ObjectTasks();
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

    public ObjectTasks objects() {
        return objectTasks;
    }
}
