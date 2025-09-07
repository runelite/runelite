package net.runelite.client.plugins.rlbot.tasks;

import net.runelite.api.GameObject;

/**
 * Handles clicking on banks using the same simple approach as manual clicks (client thread + moveAndClickWithValidation).
 */
public class BankClicker {
    
    private static final String[] BANK_ACTIONS = {"Bank", "Use", "Open", "Deposit"};
    
    /**
     * Clicks a bank using the same simple approach as manual clicks (client thread + moveAndClickWithValidation).
     */
    public static boolean clickBank(TaskContext context, GameObject bank) {
        if (bank == null) {
            context.logger.info("[BankClicker] Bank is null, cannot click");
            return false;
        }
        
        context.logger.info("[BankClicker] Attempting to click bank at " + bank.getWorldLocation());
        
        try {
            // Get bank composition and find bank action
            net.runelite.api.ObjectComposition comp = context.client.getObjectDefinition(bank.getId());
            if (comp == null) {
                context.logger.warn("[BankClicker] No object composition for bank");
                return false;
            }
            
            String[] actions = comp.getActions();
            if (actions == null) {
                context.logger.warn("[BankClicker] Bank has no actions");
                return false;
            }
            
            int bankIdx = -1;
            String bankLabel = null;
            for (int i = 0; i < actions.length; i++) {
                String action = actions[i];
                if (action != null && (action.toLowerCase().contains("bank") || action.toLowerCase().contains("use") || action.toLowerCase().contains("open") || action.toLowerCase().contains("deposit"))) {
                    bankIdx = i;
                    bankLabel = action;
                    break;
                }
            }
            
            if (bankIdx < 0) {
                context.logger.warn("[BankClicker] No bank action found");
                return false;
            }
            
            context.logger.info("[BankClicker] Found bank action: " + bankLabel + " at index " + bankIdx);
            
            // Project to canvas point
            java.awt.Point projPoint = ObjectFinder.projectToClickablePoint(context, bank);
            if (projPoint == null || projPoint.x < 0 || projPoint.y < 0 || projPoint.x >= 765 || projPoint.y >= 503) {
                projPoint = ObjectFinder.projectToCanvas(context, bank);
            }
            
            if (projPoint == null) {
                context.logger.warn("[BankClicker] Cannot project bank to canvas");
                return false;
            }
            
            context.logger.info("[BankClicker] Clicking at (" + projPoint.x + "," + projPoint.y + ") with action: " + bankLabel);
            
            // Use the same client-thread approach as manual clicks
            final java.awt.Point finalClickPoint = projPoint;
            final String finalBankLabel = bankLabel;
            final java.util.concurrent.atomic.AtomicBoolean clickResult = new java.util.concurrent.atomic.AtomicBoolean(false);
            final java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(1);
            
            context.clientThread.invoke(() -> {
                try {
                    boolean ok = context.input.moveAndClickWithValidation(finalClickPoint, finalBankLabel);
                    clickResult.set(ok);
                } catch (Exception e) {
                    context.logger.warn("[BankClicker] moveAndClickWithValidation failed on client thread: " + e.getMessage());
                    clickResult.set(false);
                } finally {
                    latch.countDown();
                }
            });
            
            // Wait briefly for the click to execute
            try { 
                latch.await(600, java.util.concurrent.TimeUnit.MILLISECONDS); 
            } catch (InterruptedException ie) { 
                Thread.currentThread().interrupt(); 
            }
            
            if (clickResult.get()) {
                context.logger.info("[BankClicker] Successfully clicked bank");
                context.setBusyForMs(300);
                return true;
            } else {
                context.logger.warn("[BankClicker] Click validation failed");
                return false;
            }
            
        } catch (Exception e) {
            context.logger.warn("[BankClicker] Error during bank click: " + e.getMessage());
            return false;
        }
    }
}
