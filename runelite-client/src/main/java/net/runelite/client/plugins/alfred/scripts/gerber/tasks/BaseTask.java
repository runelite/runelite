package net.runelite.client.plugins.alfred.scripts.gerber.tasks;

public abstract class BaseTask {
//    abstract WorldPoint getBankLocation();
//    abstract List<Integer> getRecommendedItems();
//    private RSInventoryItem retrieveRecommendedItem() {
//        RSPlayer player = Alfred.api.players().getLocalPlayer();
//
//        // if we are too far away from the bank we don't have it open
//        if (player.getWorldLocation().distanceTo(getBankLocation()) > 5) {
//            Alfred.api.walk().walkTo(getBankLocation());
//        }
//
//        // if the bank is not open then open it
//        if (!Alfred.api.banks().isOpen()) {
//            RSBank bank = Alfred.api.banks().getNearestBanks().stream().findFirst().orElse(null);
//            bank.open();
//        }
//
//        for (Integer itemId : getRecommendedItems()) {
//            if (Alfred.api.banks().hasItem(itemId)) {
//                Alfred.api.banks().withdrawItem(itemId);
//            }
//        }
//    }
}
