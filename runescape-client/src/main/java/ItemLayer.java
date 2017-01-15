import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1119464309
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 920756917
   )
   @Export("x")
   int x;
   @ObfuscatedName("a")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 620718117
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("c")
   @Export("top")
   Renderable top;
   @ObfuscatedName("f")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1338642657
   )
   @Export("height")
   int height;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = -200131883
   )
   protected static int field1211;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1926062925
   )
   @Export("y")
   int y;

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(LSequence;IIIB)V",
      garbageValue = "12"
   )
   static void method1411(Sequence var0, int var1, int var2, int var3) {
      if(Client.field516 < 50 && Client.field557 != 0 && var0.field3049 != null && var1 < var0.field3049.length) {
         int var4 = var0.field3049[var1];
         if(var4 != 0) {
            int var5 = var4 >> 8;
            int var6 = var4 >> 4 & 7;
            int var7 = var4 & 15;
            Client.field500[Client.field516] = var5;
            Client.field292[Client.field516] = var6;
            Client.field526[Client.field516] = 0;
            Client.field528[Client.field516] = null;
            int var8 = (var2 - 64) / 128;
            int var9 = (var3 - 64) / 128;
            Client.field527[Client.field516] = var7 + (var8 << 16) + (var9 << 8);
            ++Client.field516;
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1302502749"
   )
   static void method1412() {
      Client.field291 = -1L;
      Client.field294 = -1;
      class191.field2796.field214 = 0;
      class20.field219 = true;
      Client.field295 = true;
      Client.field506 = -1L;
      class227.field3228 = new CombatInfoList();
      Client.field326.offset = 0;
      Client.field409.offset = 0;
      Client.packetOpcode = -1;
      Client.field333 = 1;
      Client.field334 = -1;
      Client.field335 = -1;
      Client.field308 = 0;
      Client.field297 = 0;
      Client.field336 = 0;
      Client.field298 = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      class115.mouseIdleTicks = 0;
      class47.chatLineMap.clear();
      class47.field922.method2307();
      class47.field921.method2449();
      class47.field919 = 0;
      Client.field447 = 0;
      Client.field435 = false;
      Client.field516 = 0;
      Client.field347 = (int)(Math.random() * 100.0D) - 50;
      Client.field394 = (int)(Math.random() * 110.0D) - 55;
      Client.field351 = (int)(Math.random() * 80.0D) - 40;
      Client.mapScale = (int)(Math.random() * 120.0D) - 60;
      Client.mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
      Client.mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
      Client.field543 = 0;
      Client.field359 = -1;
      Client.flagX = 0;
      Client.flagY = 0;
      Client.field306 = class40.field798;
      Client.field307 = class40.field798;
      Client.field322 = 0;
      class190.method3457();

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      for(var0 = 0; var0 < '耀'; ++var0) {
         Client.cachedNPCs[var0] = null;
      }

      Client.field412 = -1;
      Client.projectiles.method2385();
      Client.field405.method2385();

      int var1;
      for(var0 = 0; var0 < 4; ++var0) {
         for(int var2 = 0; var2 < 104; ++var2) {
            for(var1 = 0; var1 < 104; ++var1) {
               Client.groundItemDeque[var0][var2][var1] = null;
            }
         }
      }

      Client.field545 = new Deque();
      Client.field465 = 0;
      Client.friendCount = 0;
      Client.ignoreCount = 0;

      for(var0 = 0; var0 < class187.field2750; ++var0) {
         class187 var3 = class30.method674(var0);
         if(var3 != null) {
            class165.settings[var0] = 0;
            class165.widgetSettings[var0] = 0;
         }
      }

      Renderable.chatMessages.method830();
      Client.field448 = -1;
      if(Client.widgetRoot != -1) {
         var0 = Client.widgetRoot;
         if(var0 != -1 && class6.validInterfaces[var0]) {
            Widget.field2245.method3274(var0);
            if(null != Widget.widgets[var0]) {
               boolean var4 = true;

               for(var1 = 0; var1 < Widget.widgets[var0].length; ++var1) {
                  if(null != Widget.widgets[var0][var1]) {
                     if(Widget.widgets[var0][var1].type != 2) {
                        Widget.widgets[var0][var1] = null;
                     } else {
                        var4 = false;
                     }
                  }
               }

               if(var4) {
                  Widget.widgets[var0] = null;
               }

               class6.validInterfaces[var0] = false;
            }
         }
      }

      for(WidgetNode var5 = (WidgetNode)Client.componentTable.method2344(); var5 != null; var5 = (WidgetNode)Client.componentTable.method2343()) {
         class3.method31(var5, true);
      }

      Client.widgetRoot = -1;
      Client.componentTable = new XHashTable(8);
      Client.field537 = null;
      Client.isMenuOpen = false;
      Client.menuOptionCount = 0;
      Client.field560.method3119((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.field466[var0] = null;
         Client.field410[var0] = false;
      }

      class156.method3005();
      Client.field301 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field485[var0] = true;
      }

      Client.field326.method3029(112);
      Client.field326.method2760(class182.method3335());
      Client.field326.method2918(class0.field1);
      Client.field326.method2918(class65.field1099);
      Client.field507 = null;
      class142.field1984 = 0;
      class30.clanMembers = null;

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
      }

      class11.field123 = null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "10"
   )
   static final int method1413(int var0, int var1) {
      int var2 = class2.method29(var0 - 1, var1 - 1) + class2.method29(var0 + 1, var1 - 1) + class2.method29(var0 - 1, 1 + var1) + class2.method29(var0 + 1, 1 + var1);
      int var3 = class2.method29(var0 - 1, var1) + class2.method29(var0 + 1, var1) + class2.method29(var0, var1 - 1) + class2.method29(var0, 1 + var1);
      int var4 = class2.method29(var0, var1);
      return var4 / 4 + var2 / 16 + var3 / 8;
   }
}
