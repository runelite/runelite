import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jp")
public class class261 {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   public static final class261 field3602;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   public static final class261 field3608;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   public static final class261 field3603;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = 513311007
   )
   static int field3610;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   public static final class261 field3604;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   public static final class261 field3600;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   public static final class261 field3601;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -222679291
   )
   @Export("priority")
   public static int priority;
   @ObfuscatedName("s")
   final String field3605;
   @ObfuscatedName("x")
   String field3606;

   static {
      field3608 = new class261("PLAIN11", "p11_full");
      field3600 = new class261("PLAIN12", "p12_full");
      field3601 = new class261("BOLD12", "b12_full");
      field3602 = new class261("VERDANA11", "verdana_11pt_regular");
      field3603 = new class261("VERDANA13", "verdana_13pt_regular");
      field3604 = new class261("VERDANA15", "verdana_15pt_regular");
   }

   class261(String var1, String var2) {
      this.field3605 = var1;
      this.field3606 = var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "63329007"
   )
   static final boolean method4610() {
      return class134.field1957;
   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIB)V",
      garbageValue = "2"
   )
   @Export("addMenuEntry")
   public static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      boolean var12 = false;
      if(!Client.isMenuOpen && Client.menuOptionCount < 500) {
         Client.menuOptions[Client.menuOptionCount] = var0;
         Client.menuTargets[Client.menuOptionCount] = var1;
         Client.menuTypes[Client.menuOptionCount] = var2;
         Client.menuIdentifiers[Client.menuOptionCount] = var3;
         Client.menuActionParams0[Client.menuOptionCount] = var4;
         Client.menuActionParams1[Client.menuOptionCount] = var5;
         Client.field984[Client.menuOptionCount] = var12;
         ++Client.menuOptionCount;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)[Ljp;",
      garbageValue = "1"
   )
   public static class261[] method4616() {
      return new class261[]{field3608, field3601, field3603, field3602, field3600, field3604};
   }

   @ObfuscatedName("ea")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-247304808"
   )
   static void method4617() {
      Client.field924 = -1L;
      Client.field969 = -1;
      Client.field1038.field850 = 0;
      class31.field425 = true;
      Client.field929 = true;
      Client.field1128 = -1L;
      class229.method3989();
      Client.secretPacketBuffer1.offset = 0;
      Client.secretPacketBuffer2.offset = 0;
      Client.packetType = -1;
      Client.lastFrameId = -1;
      Client.secondLastFrameId = -1;
      Client.thridLastFrameId = -1;
      Client.field962 = 0;
      Client.field1070 = 0;
      Client.field967 = 0;
      Client.field992 = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      class82.method1564(0);
      class98.chatLineMap.clear();
      class98.field1495.clear();
      class98.field1493.method3613();
      class98.field1496 = 0;
      Client.itemSelectionState = 0;
      Client.spellSelected = false;
      Client.field935 = 0;
      Client.mapAngle = 0;
      Client.field1138 = 0;
      Client.field1131 = -1;
      Client.destinationX = 0;
      Client.destinationY = 0;
      Client.field940 = class91.field1393;
      Client.field1161 = class91.field1393;
      Client.field953 = 0;
      class44.method604();

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      for(var0 = 0; var0 < '耀'; ++var0) {
         Client.cachedNPCs[var0] = null;
      }

      Client.field1033 = -1;
      Client.projectiles.clear();
      Client.graphicsObjectDeque.clear();

      for(var0 = 0; var0 < 4; ++var0) {
         for(int var1 = 0; var1 < 104; ++var1) {
            for(int var2 = 0; var2 < 104; ++var2) {
               Client.groundItemDeque[var0][var1][var2] = null;
            }
         }
      }

      Client.pendingSpawns = new Deque();
      Client.field1170 = 0;
      Client.friendCount = 0;
      Client.ignoreCount = 0;

      for(var0 = 0; var0 < class215.field2605; ++var0) {
         VarPlayerType var3 = class92.method1695(var0);
         if(var3 != null) {
            class211.settings[var0] = 0;
            class211.widgetSettings[var0] = 0;
         }
      }

      Varcs.chatMessages.reset();
      Client.field1072 = -1;
      if(Client.widgetRoot != -1) {
         class98.method1769(Client.widgetRoot);
      }

      for(WidgetNode var4 = (WidgetNode)Client.componentTable.method3492(); var4 != null; var4 = (WidgetNode)Client.componentTable.method3493()) {
         ScriptState.method1021(var4, true);
      }

      Client.widgetRoot = -1;
      Client.componentTable = new XHashTable(8);
      Client.field1068 = null;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.field1080.method3876((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.playerOptions[var0] = null;
         Client.playerOptionsPriorities[var0] = false;
      }

      XItemContainer.itemContainers = new XHashTable(32);
      Client.field922 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field1109[var0] = true;
      }

      XItemContainer.method1031();
      Client.clanChatOwner = null;
      VarPlayerType.clanChatCount = 0;
      KeyFocusListener.clanMembers = null;

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
      }

      InvType.field3251 = null;
   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(Lcm;I)V",
      garbageValue = "-1597253054"
   )
   static final void method4618(Actor var0) {
      if(var0.field1268 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field1243 + 1 > class31.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
         int var1 = var0.field1268 - var0.field1255;
         int var2 = Client.gameCycle - var0.field1255;
         int var3 = var0.field1236 * 128 + var0.field1213 * 64;
         int var4 = var0.field1253 * 128 + var0.field1213 * 64;
         int var5 = var0.field1265 * 128 + var0.field1213 * 64;
         int var6 = var0.field1254 * 128 + var0.field1213 * 64;
         var0.x = (var5 * var2 + var3 * (var1 - var2)) / var1;
         var0.y = (var2 * var6 + var4 * (var1 - var2)) / var1;
      }

      var0.field1267 = 0;
      var0.orientation = var0.field1257;
      var0.angle = var0.orientation;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "797340072"
   )
   static int method4613(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.get((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "(Lcm;I)V",
      garbageValue = "78916711"
   )
   static final void method4619(Actor var0) {
      var0.field1233 = false;
      Sequence var1;
      if(var0.poseAnimation != -1) {
         var1 = class31.getAnimation(var0.poseAnimation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.field1240;
            if(var0.poseFrame < var1.frameIDs.length && var0.field1240 > var1.frameLenghts[var0.poseFrame]) {
               var0.field1240 = 1;
               ++var0.poseFrame;
               class37.method491(var1, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var1.frameIDs.length) {
               var0.field1240 = 0;
               var0.poseFrame = 0;
               class37.method491(var1, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.graphicsDelay) {
         if(var0.field1247 < 0) {
            var0.field1247 = 0;
         }

         int var3 = class205.getSpotAnimType(var0.graphic).field3299;
         if(var3 != -1) {
            Sequence var2 = class31.getAnimation(var3);
            if(var2 != null && var2.frameIDs != null) {
               ++var0.field1248;
               if(var0.field1247 < var2.frameIDs.length && var0.field1248 > var2.frameLenghts[var0.field1247]) {
                  var0.field1248 = 1;
                  ++var0.field1247;
                  class37.method491(var2, var0.field1247, var0.x, var0.y);
               }

               if(var0.field1247 >= var2.frameIDs.length && (var0.field1247 < 0 || var0.field1247 >= var2.frameIDs.length)) {
                  var0.graphic = -1;
               }
            } else {
               var0.graphic = -1;
            }
         } else {
            var0.graphic = -1;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable <= 1) {
         var1 = class31.getAnimation(var0.animation);
         if(var1.precedenceAnimating == 1 && var0.field1219 > 0 && var0.field1255 <= Client.gameCycle && var0.field1268 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var1 = class31.getAnimation(var0.animation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.field1243;
            if(var0.actionFrame < var1.frameIDs.length && var0.field1243 > var1.frameLenghts[var0.actionFrame]) {
               var0.field1243 = 1;
               ++var0.actionFrame;
               class37.method491(var1, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var1.frameIDs.length) {
               var0.actionFrame -= var1.frameStep;
               ++var0.field1245;
               if(var0.field1245 >= var1.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var1.frameIDs.length) {
                  class37.method491(var1, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field1233 = var1.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-611846647"
   )
   public static final void method4615() {
      class134.field1957 = false;
      class134.field1954 = 0;
   }
}
