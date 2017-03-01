import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("bv")
   static class184 field175;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1245497201
   )
   int field176;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1513389261
   )
   @Export("id")
   int id;
   @ObfuscatedName("g")
   boolean field179 = false;
   @ObfuscatedName("bz")
   static class184 field180;
   @ObfuscatedName("q")
   public static class72[] field182;
   @ObfuscatedName("hq")
   @Export("localPlayer")
   static Player localPlayer;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "82"
   )
   public static int method198(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class150.method2850(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "664340520"
   )
   static void method199() {
      Client.field296 = -1L;
      Client.field300 = -1;
      Client.field286.field221 = 0;
      class13.field133 = true;
      Client.field522 = true;
      Client.field515 = -1L;
      class227.field3246 = new CombatInfoList();
      Client.field332.offset = 0;
      Client.field334.offset = 0;
      Client.packetOpcode = -1;
      Client.field345 = 1;
      Client.field340 = -1;
      Client.field341 = -1;
      Client.field337 = 0;
      Client.field498 = 0;
      Client.field342 = 0;
      Client.field304 = 0;
      class108.method2131();
      class115.mouseIdleTicks = 0;
      class15.method193();
      Client.field416 = 0;
      Client.field444 = false;
      Client.field532 = 0;
      Client.field430 = (int)(Math.random() * 100.0D) - 50;
      Client.field398 = (int)(Math.random() * 110.0D) - 55;
      Client.field357 = (int)(Math.random() * 80.0D) - 40;
      Client.mapScale = (int)(Math.random() * 120.0D) - 60;
      Client.mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
      Client.mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
      Client.field526 = 0;
      Client.field519 = -1;
      Client.flagX = 0;
      Client.flagY = 0;
      Client.field313 = class40.field814;
      Client.field314 = class40.field814;
      Client.field328 = 0;
      Client.method610();

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      for(var0 = 0; var0 < '耀'; ++var0) {
         Client.cachedNPCs[var0] = null;
      }

      Client.field418 = -1;
      Client.projectiles.method2507();
      Client.field422.method2507();

      for(var0 = 0; var0 < 4; ++var0) {
         for(int var4 = 0; var4 < 104; ++var4) {
            for(int var2 = 0; var2 < 104; ++var2) {
               Client.groundItemDeque[var0][var4][var2] = null;
            }
         }
      }

      Client.field392 = new Deque();
      Client.field558 = 0;
      Client.friendCount = 0;
      Client.ignoreCount = 0;

      for(var0 = 0; var0 < class187.field2780; ++var0) {
         class187 var1 = class142.method2762(var0);
         if(null != var1) {
            class165.settings[var0] = 0;
            class165.widgetSettings[var0] = 0;
         }
      }

      class22.chatMessages.method930();
      Client.field457 = -1;
      if(Client.widgetRoot != -1) {
         class45.method914(Client.widgetRoot);
      }

      for(WidgetNode var3 = (WidgetNode)Client.componentTable.method2440(); var3 != null; var3 = (WidgetNode)Client.componentTable.method2441()) {
         class18.method203(var3, true);
      }

      Client.widgetRoot = -1;
      Client.componentTable = new XHashTable(8);
      Client.field543 = null;
      class108.method2131();
      Client.field412.method3270((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.playerOptions[var0] = null;
         Client.playerOptionsPriority[var0] = false;
      }

      XItemContainer.itemContainers = new XHashTable(32);
      Client.field294 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field494[var0] = true;
      }

      class140.method2705();
      Client.field516 = null;
      class119.clanChatCount = 0;
      Friend.clanMembers = null;

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
      }

      Renderable.field1549 = null;
   }
}
