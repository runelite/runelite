package net.runelite.client.plugins.rlbot.tasks;

import java.awt.event.KeyEvent;
import net.runelite.api.MenuAction;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.GameObject;
import net.runelite.api.ObjectComposition;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;

/**
 * Open nearest bank booth and deposit inventory via widget if bank is open.
 * Very naive: clicks a nearby object named Bank booth/Bank chest.
 */
public class BankDepositTask implements Task {
    @Override
    public boolean shouldRun(TaskContext context) {
        // If a bank/deposit UI is open, run if inventory is full OR if we need to close the bank
        if (isBankOpen(context) || isDepositBoxOpen(context)) {
            boolean inventoryFull = context.isInventoryFull();
            if (inventoryFull || context.getInventoryFreeSlots() == 28) {
                context.logger.info("[BankDeposit] Bank UI open, inventoryFull=" + inventoryFull + ", freeSlots=" + context.getInventoryFreeSlots());
            }
            return inventoryFull || context.getInventoryFreeSlots() == 28; // Close bank if empty
        }
        // Be more aggressive - run when inventory is full OR nearly full
        boolean inventoryFull = context.isInventoryFull();
        boolean inventoryNearFull = context.isInventoryNearFull();
        if (!inventoryFull && !inventoryNearFull) {
            if (context.getInventoryFreeSlots() <= 5) {
                context.logger.info("[BankDeposit] shouldRun() = false (inventory not near full, free slots: " + context.getInventoryFreeSlots() + ")");
            }
            return false;
        }
        // Actively discover banks like Chop task does for trees
        BankDiscovery.scanAndDiscoverBanks(context);
        // Visible bank by name + projection is sufficient to start this task
        boolean canSeeBank = false;
        boolean nearBank = false;
        try {
            // Require a valid bank interaction action to avoid clicking tables, stalls, etc.
            net.runelite.api.GameObject byName = ObjectFinder.findNearestByNames(
                context, new String[]{"bank booth", "bank chest", "bank", "bank counter", "banker"}, "Bank");
            if (byName != null) {
                java.awt.Point proj = ObjectFinder.projectToCanvas(context, byName);
                if (proj != null) {
                    net.runelite.api.coords.WorldPoint wp = byName.getWorldLocation();
                    boolean blacklisted = BankDiscovery.isBlacklisted(wp);
                    canSeeBank = !blacklisted && (inventoryFull || inventoryNearFull);
                    if (canSeeBank) {
                        context.logger.info("[BankDeposit] Visible bank on-screen; proceeding to interact (wp=" + wp + ")");
                    }
                }
                // If within a few tiles, prefer this task even if not visible
                net.runelite.api.Player me = context.client.getLocalPlayer();
                if (me != null) {
                    int dist = me.getWorldLocation().distanceTo(byName.getWorldLocation());
                    // Be more aggressive - consider "near" to be within 8 tiles instead of 6
                    nearBank = dist >= 0 && dist <= 8 && !BankDiscovery.isBlacklisted(byName.getWorldLocation());
                    if (nearBank) {
                        context.logger.info("[BankDeposit] Near bank at distance " + dist + "; proceeding to interact");
                    }
                }
            }
        } catch (Exception ignored) {}
        if (!canSeeBank && !nearBank) {
            // Do not run when no bank is visible or nearby; let navigation/exploration handle movement
            context.logger.info("[BankDeposit] shouldRun=false (no visible/nearby bank)");
            return false;
        }
        return true;
    }


    @Override
    public void run(TaskContext context) {
        UiHelper.closeObstructions(context);
        if (context.isBusy() && !context.timedOutSince(4000)) {
            context.logger.info("[BankDeposit] Context is busy, skipping this tick");
            return;
        }
        Client client = context.client;
        
        // Check if bank is open
        boolean bankOpen = isBankOpen(context);
        
        if (bankOpen) {
            context.logger.info("[BankDeposit] Bank is open, inventory free slots: " + context.getInventoryFreeSlots());
            
            // If inventory is empty, close the bank
            if (context.getInventoryFreeSlots() == 28) {
                context.logger.info("[BankDeposit] Inventory is empty, closing bank");
                // Prefer explicit bank main close by widget id then generic
                if (!UiHelper.closeBankMainById(context, 786434) && !UiHelper.clickCloseIfVisible(context)) {
                    context.input.pressKey(KeyEvent.VK_ESCAPE);
                    context.setBusyForMs(200);
                }
                return;
            }
            
            // Check for deposit inventory widget first
            Widget depositInv = client.getWidget(WidgetInfo.BANK_DEPOSIT_INVENTORY);
            context.logger.info("[BankDeposit] Checking deposit inventory widget: " + (depositInv != null ? "found" : "null") + 
                              (depositInv != null ? (depositInv.isHidden() ? " (hidden)" : " (visible)") : ""));
            
            if (depositInv != null && !depositInv.isHidden()) {
                context.logger.info("[BankDeposit] Found deposit inventory widget, clicking it");
                int widgetId = depositInv.getId();
                context.logger.info("[BankDeposit] Widget ID: " + widgetId + ", about to invoke menuAction");
                context.clientThread.invoke(() -> {
                    try {
                        context.logger.info("[BankDeposit] Executing menuAction with widgetId=" + widgetId);
                        client.menuAction(-1, widgetId, MenuAction.CC_OP, 1, -1, "Deposit inventory", "");
                        context.logger.info("[BankDeposit] menuAction completed successfully");
                    } catch (Exception e) {
                        context.logger.error("[BankDeposit] menuAction failed: " + e.getMessage());
                    }
                });
                context.logger.info("[BankDeposit] Set busy for 200ms after widget click");
                context.setBusyForMs(200);
                if (context.telemetry != null) context.telemetry.addReward(10);
                // Fallback: also perform a direct click on the widget bounds to ensure activation
                try {
                    java.awt.Rectangle b = depositInv.getBounds();
                    if (b != null && b.width > 0 && b.height > 0) {
                        java.awt.Point p = new java.awt.Point(b.x + b.width / 2, b.y + b.height / 2);
                        context.logger.info("[BankDeposit] Fallback-clicking Deposit inventory at " + p);
                        context.input.smoothMouseMove(p);
                        context.input.clickAt(p);
                        context.setBusyForMs(250);
                    }
                } catch (Exception ignored) {}
                context.logger.info("[BankDeposit] Returning after deposit inventory widget click");
                return;
            }
            
            Widget depositButton = findDepositButton(context);
            context.logger.info("[BankDeposit] Scanning for deposit button: " + (depositButton != null ? "found" : "not found"));
            
            if (depositButton != null) {
                context.logger.info("[BankDeposit] Found deposit button via scanning, clicking it");
                int widgetId = depositButton.getId();
                context.logger.info("[BankDeposit] Deposit button widget ID: " + widgetId + ", about to invoke menuAction");
                context.clientThread.invoke(() -> {
                    try {
                        context.logger.info("[BankDeposit] Executing menuAction for deposit button with widgetId=" + widgetId);
                        client.menuAction(-1, widgetId, MenuAction.CC_OP, 1, -1, "Deposit inventory", "");
                        context.logger.info("[BankDeposit] Deposit button menuAction completed successfully");
                    } catch (Exception e) {
                        context.logger.error("[BankDeposit] Deposit button menuAction failed: " + e.getMessage());
                    }
                });
                context.logger.info("[BankDeposit] Set busy for 200ms after deposit button click");
                context.setBusyForMs(200);
                if (context.telemetry != null) context.telemetry.addReward(10);
                // Fallback: direct click the located button's bounds
                try {
                    java.awt.Rectangle b = depositButton.getBounds();
                    if (b != null && b.width > 0 && b.height > 0) {
                        java.awt.Point p = new java.awt.Point(b.x + b.width / 2, b.y + b.height / 2);
                        context.logger.info("[BankDeposit] Fallback-clicking deposit button at " + p);
                        context.input.smoothMouseMove(p);
                        context.input.clickAt(p);
                        context.setBusyForMs(250);
                    }
                } catch (Exception ignored) {}
                context.logger.info("[BankDeposit] Returning after deposit button click");
                return;
            }
            
            // Fallback: try clicking deposit area
            context.logger.info("[BankDeposit] No deposit button found, trying to click deposit area");
            java.awt.Point depositArea = new java.awt.Point(400, 300); // Approximate location
            context.input.smoothMouseMove(depositArea);
            context.setBusyForMs(200);
            context.input.clickAt(depositArea);
            context.setBusyForMs(500);
            if (context.telemetry != null) context.telemetry.addReward(5);
            return;
        }
        
        // Deposit box handling (unchanged)
        if (isDepositBoxOpen(context) && !context.isInventoryFull()) {
            if (!UiHelper.clickCloseIfVisible(context)) {
                context.input.pressKey(KeyEvent.VK_ESCAPE);
                context.setBusyForMs(200);
            }
            return;
        }
        Widget depositBoxButton = client.getWidget(192, 29);
        context.logger.info("[BankDeposit] Checking deposit box widget (192,29): " + (depositBoxButton != null ? "found" : "null") + 
                          (depositBoxButton != null ? (depositBoxButton.isHidden() ? " (hidden)" : " (visible)") : ""));
        if (depositBoxButton != null && !depositBoxButton.isHidden() && depositBoxButton.getBounds() != null && depositBoxButton.getBounds().width > 0) {
            context.logger.info("[BankDeposit] Found deposit box, clicking Deposit inventory");
            int widgetId = depositBoxButton.getId();
            context.logger.info("[BankDeposit] Deposit box widget ID: " + widgetId + ", about to invoke menuAction");
            context.clientThread.invoke(() -> {
                try {
                    context.logger.info("[BankDeposit] Executing menuAction for deposit box with widgetId=" + widgetId);
                    client.menuAction(-1, widgetId, MenuAction.CC_OP, 1, -1, "Deposit inventory", "");
                    context.logger.info("[BankDeposit] Deposit box menuAction completed successfully");
                } catch (Exception e) {
                    context.logger.error("[BankDeposit] Deposit box menuAction failed: " + e.getMessage());
                }
            });
            context.logger.info("[BankDeposit] Set busy for 500ms after deposit box click");
            context.setBusyForMs(500);
            if (context.telemetry != null) context.telemetry.addReward(10);
            context.logger.info("[BankDeposit] Attempting to close deposit box UI");
            if (!UiHelper.clickCloseIfVisible(context)) {
                context.logger.info("[BankDeposit] Close button not found, pressing ESC");
                context.input.pressKey(KeyEvent.VK_ESCAPE);
                context.setBusyForMs(250);
            }
            context.logger.info("[BankDeposit] Returning after deposit box handling");
            return;
        }

        // Use simplified BankClicker for consistent bank clicking behavior (same as TreeClicker)
        Player me = context.client.getLocalPlayer();
        if (me == null) return;
        
        // Log what bank objects are available for debugging
        context.logger.info("[BankDeposit] Scanning for bank objects with actions...");
        
        // First, let's see what ObjectFinder.findNearestBankInteractable finds
        GameObject bankInteractable = ObjectFinder.findNearestBankInteractable(context);
        if (bankInteractable != null) {
            ObjectComposition comp = context.client.getObjectDefinition(bankInteractable.getId());
            String[] actions = comp.getActions();
            context.logger.info("[BankDeposit] findNearestBankInteractable found: " + comp.getName() + 
                              " (ID: " + bankInteractable.getId() + ") at " + bankInteractable.getWorldLocation() + 
                              " Actions: " + java.util.Arrays.toString(actions));
        } else {
            context.logger.warn("[BankDeposit] findNearestBankInteractable returned null - no interactable banks found");
        }
        
        // Try using simplified BankClicker first - same approach as TreeClicker
        context.logger.info("[BankDeposit] Attempting to click bank using BankClicker");
        if (BankClicker.clickBank(context, bankInteractable)) {
            context.logger.info("[BankDeposit] Successfully clicked bank using BankClicker");
            
            // Check if bank opened after a short delay
            context.setBusyForMs(500);
            boolean bankOpenAfterClick = isBankOpen(context);
            context.logger.info("[BankDeposit] After BankClicker click, isBankOpen() = " + bankOpenAfterClick);
            if (bankOpenAfterClick) {
                context.logger.info("[BankDeposit] Bank opened successfully!");
                if (context.telemetry != null) context.telemetry.addReward(15);
            } else {
                context.logger.warn("[BankDeposit] Bank click validated but UI not open - applying camera nudge and retry");
                // Nudge camera and retry once at a higher click point to avoid occluders
                CameraHelper.sweepYawSmall(context, 6);
                context.input.tiltCameraUpSmall();
                context.setBusyForMs(200);
                // Retry using BankClicker again
                if (BankClicker.clickBank(context, bankInteractable)) {
                    context.setBusyForMs(200);
                    if (isBankOpen(context)) {
                        context.logger.info("[BankDeposit] Bank opened on retry");
                        if (context.telemetry != null) context.telemetry.addReward(10);
                    } else {
                        context.logger.warn("[BankDeposit] Retry validated click but UI still not open");
                    }
                }
            }
            return;
        } else {
            context.logger.warn("[BankDeposit] BankClicker.clickBank failed - no bank objects found or click failed");
        }
        
        // Fallback: try to find a specific bank object and use BankClicker on it
        net.runelite.api.GameObject best = ObjectFinder.findNearestBankInteractable(context);
        if (best != null) {
            context.logger.info("[BankDeposit] Found bank object: " + best.getId() + " at " + best.getWorldLocation());
            
            if (BankDiscovery.isBlacklisted(best.getWorldLocation())) {
                context.logger.warn("[BankDeposit] Skipping blacklisted bank at " + best.getWorldLocation());
                return;
            }
            
            // Mark as last targeted so chat-based blacklist can apply if unreachable
            BankDiscovery.setLastTargetedBank(best.getWorldLocation());
            
            // Try using BankClicker with the specific object
            context.logger.info("[BankDeposit] Attempting to click specific bank object using BankClicker");
            if (BankClicker.clickBank(context, best)) {
                context.logger.info("[BankDeposit] Successfully clicked specific bank using BankClicker");
                
                // Check if bank opened after a short delay
                context.setBusyForMs(200);
                if (isBankOpen(context)) {
                    context.logger.info("[BankDeposit] Bank opened successfully!");
                    if (context.telemetry != null) context.telemetry.addReward(15);
                } else {
                    context.logger.warn("[BankDeposit] Specific bank click succeeded but bank did not open");
                }
                return;
            }
            
            // If BankClicker fails, fall back to navigation or camera adjustment
            context.logger.warn("[BankDeposit] BankClicker.clickBank failed for specific bank - trying camera adjustment or navigation");
            
            // Project bank to canvas 
            java.awt.Point proj = ObjectFinder.projectToClickablePoint(context, best);
            if (proj == null) {
                final net.runelite.api.GameObject bestFinal = best;
                // If we're already within 6 tiles, do not navigate; only try to reveal via camera
                int distTiles = -1;
                try {
                    net.runelite.api.Player meP = context.client.getLocalPlayer();
                    if (meP != null) distTiles = meP.getWorldLocation().distanceTo(bestFinal.getWorldLocation());
                } catch (Exception ignored) {}
                boolean visible = CameraHelper.sweepUntilVisible(context, () -> ObjectFinder.projectToCanvas(context, bestFinal) != null, 6);
                if (!visible && (distTiles < 0 || distTiles > 6)) {
                    context.logger.info("[BankDeposit] Bank not visible, navigating closer");
                    WorldPathing.clickStepToward(context, best.getWorldLocation(), 6);
                    context.setBusyForMs(300);
                }
                return;
            } else {
                context.logger.warn("[BankDeposit] Bank is visible but ObjectClicker failed - may be action mismatch or occlusion");
                context.setBusyForMs(300);
            }
            return;
        }
        
        // No bank in scene: navigate toward nearest discovered bank or explore
        java.util.List<net.runelite.api.coords.WorldPoint> discovered = BankDiscovery.getDiscoveredBanks();
        if (!discovered.isEmpty()) {
            net.runelite.api.coords.WorldPoint meWp = me.getWorldLocation();
            net.runelite.api.coords.WorldPoint nearest = null;
            int bestDist = Integer.MAX_VALUE;
            for (net.runelite.api.coords.WorldPoint wp : discovered) {
                if (BankDiscovery.isBlacklisted(wp)) continue;
                int d = meWp.distanceTo(wp);
                if (d >= 0 && d < bestDist) { bestDist = d; nearest = wp; }
            }
            if (nearest != null) {
                context.logger.info("[BankDeposit] Navigating toward nearest discovered bank at " + nearest);
                boolean worldClicked = WorldPathing.clickStepToward(context, nearest, 6);
                if (!worldClicked) {
                    boolean visible = WorldPathing.clickStepToward(context, nearest, 0);
                    if (!visible) {
                        MinimapPathing.stepTowards(context, nearest, 0.0);
                    }
                }
                context.setBusyForMs(300);
                return;
            }
        }
        // If nothing discovered, trigger bank discovery exploration via NavigateToBankHotspotTask hotspots logic
        context.logger.info("[BankDeposit] No discovered banks to navigate to; exploring to find bank");
        NavigateToBankHotspotTask nav = new NavigateToBankHotspotTask();
        java.util.List<net.runelite.api.coords.WorldPoint> hs = nav.hotspots(context);
        if (!hs.isEmpty()) {
            net.runelite.api.coords.WorldPoint target = hs.get(0);
            boolean worldClicked = WorldPathing.clickStepToward(context, target, 6);
            if (!worldClicked) {
                MinimapPathing.stepTowards(context, target, 0.0);
            }
            context.setBusyForMs(300);
        }
    }

    private static boolean isBankOpen(TaskContext context) {
        Widget bank = context.client.getWidget(WidgetInfo.BANK_CONTAINER);
        boolean isOpen = bank != null && !bank.isHidden();
        context.logger.info("[BankDeposit] isBankOpen check: widget=" + (bank != null ? "found" : "null") + 
                          (bank != null ? (bank.isHidden() ? " (hidden)" : " (visible)") : "") + 
                          " -> result=" + isOpen);
        return isOpen;
    }

    private static boolean isDepositBoxOpen(TaskContext context) {
        try {
            // Deposit box group is 192; child 29 is the Deposit inventory button
            Widget w = context.client.getWidget(192, 29);
            if (w != null && !w.isHidden()) {
                java.awt.Rectangle b = w.getBounds();
                return b != null && b.width > 0 && b.height > 0;
            }
        } catch (Exception ignored) {}
        return false;
    }

    /**
     * Scan all visible widgets recursively using DFS to find deposit-related buttons.
     * This is much more comprehensive than checking specific widget IDs.
     */
    private static Widget findDepositButton(TaskContext context) {
        try {
            // DFS through all widget groups (0-1000+ to be thorough)
            for (int groupId = 0; groupId < 2000; groupId++) {
                Widget group = context.client.getWidget(groupId, 0);
                if (group == null || group.isHidden()) continue;
                
                // DFS through this group's children recursively
                Widget found = dfsFindDepositButton(context, group, 0);
                if (found != null) {
                    return found;
                }
            }
        } catch (Exception e) {
            context.logger.warn("[BankDeposit] Error scanning for deposit button: " + e.getMessage());
        }
        return null;
    }
    
    /**
     * Recursive DFS to find deposit button in widget tree.
     */
    private static Widget dfsFindDepositButton(TaskContext context, Widget widget, int depth) {
        if (widget == null || widget.isHidden() || depth > 10) return null; // Prevent infinite recursion
        
        try {
            // Check this widget's text first
            String text = widget.getText();
            if (text != null && !text.isEmpty()) {
                String lowerText = text.toLowerCase();
                if (lowerText.contains("deposit") || lowerText.contains("deposit inventory")) {
                    context.logger.info("[BankDeposit] Found deposit button via DFS (text): group=" + widget.getParentId() + 
                                     ", child=" + widget.getId() + ", text='" + text + "', depth=" + depth);
                    return widget;
                }
            }
            
            // Check for clickable widgets with sprites (buttons without text)
            if (widget.hasListener() && widget.getSpriteId() > 0) {
                // Log potential button candidates for debugging
                if (depth <= 3) { // Only log top-level candidates to avoid spam
                    context.logger.info("[BankDeposit] Found clickable widget: id=" + widget.getId() + 
                                     ", parent=" + widget.getParentId() + ", sprite=" + widget.getSpriteId() + 
                                     ", bounds=" + widget.getBounds() + ", depth=" + depth);
                }
                
                // Check if this looks like a deposit button based on sprite ID or position
                // Common deposit button sprites or positions
                if (widget.getSpriteId() == 170 || // From your screenshot
                    (widget.getBounds() != null && widget.getBounds().width > 50 && widget.getBounds().height > 20)) {
                    context.logger.info("[BankDeposit] Found potential deposit button (sprite): id=" + widget.getId() + 
                                     ", sprite=" + widget.getSpriteId() + ", bounds=" + widget.getBounds());
                    return widget;
                }
            }
            
            // DFS through children
            Widget[] children = widget.getChildren();
            if (children != null) {
                for (Widget child : children) {
                    Widget found = dfsFindDepositButton(context, child, depth + 1);
                    if (found != null) {
                        return found;
                    }
                }
            }
            
            // DFS through dynamic children if different from regular children
            Widget[] dynamicChildren = widget.getDynamicChildren();
            if (dynamicChildren != null) {
                for (Widget child : dynamicChildren) {
                    Widget found = dfsFindDepositButton(context, child, depth + 1);
                    if (found != null) {
                        return found;
                    }
                }
            }
            
        } catch (Exception e) {
            context.logger.warn("[BankDeposit] Error in DFS at depth " + depth + ": " + e.getMessage());
        }
        
        return null;
    }
    /**
     * Dump all visible widgets for debugging purposes.
     */
    private static void dumpAllVisibleWidgets(TaskContext context) {
        try {
            context.logger.info("[BankDeposit] === WIDGET DUMP START ===");
            
            // Scan through widget groups and dump visible ones
            for (int groupId = 0; groupId < 100; groupId++) { // Limit to first 100 groups to avoid spam
                Widget group = context.client.getWidget(groupId, 0);
                if (group == null || group.isHidden()) continue;
                
                context.logger.info("[BankDeposit] Group " + groupId + ": " + 
                                 "id=" + group.getId() + 
                                 ", text='" + group.getText() + "'" +
                                 ", sprite=" + group.getSpriteId() +
                                 ", hasListener=" + group.hasListener() +
                                 ", bounds=" + group.getBounds());
                
                // Dump children too
                Widget[] children = group.getChildren();
                if (children != null) {
                    for (Widget child : children) {
                        if (child == null || child.isHidden()) continue;
                        context.logger.info("[BankDeposit]   Child: id=" + child.getId() + 
                                         ", text='" + child.getText() + "'" +
                                         ", sprite=" + child.getSpriteId() +
                                         ", hasListener=" + child.hasListener() +
                                         ", bounds=" + child.getBounds());
                    }
                }
            }
            
            context.logger.info("[BankDeposit] === WIDGET DUMP END ===");
        } catch (Exception e) {
            context.logger.warn("[BankDeposit] Error dumping widgets: " + e.getMessage());
        }
    }
}


