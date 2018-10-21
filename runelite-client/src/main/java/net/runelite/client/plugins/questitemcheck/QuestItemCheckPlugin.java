package net.runelite.client.plugins.questitemcheck;

import javax.inject.Inject;

import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.bankvalue.BankValueConfig;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.util.QueryRunner;

@PluginDescriptor(
        name = "Quest Item Check",
        description = "Helps quickly identify if you have a item needed for a quest either within your bank or inventory",
        tags = {"external", "integration", "notifications", "quest", "items"}
)

class QuestItemCheckPlugin{
    @Inject
    private ClientToolbar clientToolbar;

    @Inject
    private QuestItemCheckConfig config;

    private final QueryRunner queryRunner;
    private final ItemManager itemManager;
    private TestQuest testQuest = new TestQuest();


    //pass in quest object with all items needed, run bank and inventory queries checking over each item needed from the quest

    //class constructor
    @Inject
    QuestItemCheckPlugin(QueryRunner queryRunner, ItemManager itemManager, TestQuest testQuest)
    {
        this.queryRunner = queryRunner;
        this.itemManager = itemManager;
        this.testQuest = testQuest;

        doQuestCheck(testQuest.getItemList(), "A");
    }

    //pass in selected quest to check for items (maybe store those in a JSON format?)
    //Go over list of items needed and check if each is contained within Bank or Inventory
    //Will a query have to be run for each item? And have a true or false returned?
    //Or can a single query be run and items cached somewhere so then we just need to perform a single query
    @Inject
    boolean doQuestCheck(String questItems, String item)
    {
        if (questItems.contains(item)) {
            return true;
        }
        return false;
    }



}
