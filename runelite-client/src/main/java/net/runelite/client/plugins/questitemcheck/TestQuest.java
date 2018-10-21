package net.runelite.client.plugins.questitemcheck;

public class TestQuest {
    private String itemList;

    TestQuest(){
        setItemList(itemList);
    }

    public void setItemList(String itemList) {
        this.itemList = itemList;
        itemList = "A,B,C";
    }

    public String getItemList() {
        return itemList;
    }
}
