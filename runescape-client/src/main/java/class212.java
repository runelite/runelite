import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
public final class class212 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-180226967"
   )
   static void method4079() {
      Client.field296 = -1L;
      Client.field309 = -1;
      WidgetNode.field68.field204 = 0;
      class54.field1172 = true;
      Client.field310 = true;
      Client.field519 = -1L;
      class214.field3189 = new class205();
      Client.field337.offset = 0;
      Client.field339.offset = 0;
      Client.packetOpcode = -1;
      Client.field344 = 1;
      Client.field345 = -1;
      Client.field311 = -1;
      Client.field378 = 0;
      Client.field312 = 0;
      Client.field299 = 0;
      Client.field313 = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      class143.mouseIdleTicks = 0;
      class5.method89();
      Client.field439 = 0;
      Client.field448 = false;
      Client.field536 = 0;
      Client.field576 = (int)(Math.random() * 100.0D) - 50;
      Client.field360 = (int)(Math.random() * 110.0D) - 55;
      Client.field362 = (int)(Math.random() * 80.0D) - 40;
      Client.mapScale = (int)(Math.random() * 120.0D) - 60;
      Client.mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
      Client.mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
      Client.field530 = 0;
      Client.field523 = -1;
      Client.flagX = 0;
      Client.flagY = 0;
      Client.field292 = class21.field589;
      Client.field420 = class21.field589;
      Client.field486 = 0;
      Projectile.method97();

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      for(var0 = 0; var0 < '耀'; ++var0) {
         Client.cachedNPCs[var0] = null;
      }

      Client.field425 = -1;
      Client.projectiles.method3996();
      Client.field429.method3996();

      for(var0 = 0; var0 < 4; ++var0) {
         for(int var1 = 0; var1 < 104; ++var1) {
            for(int var2 = 0; var2 < 104; ++var2) {
               Client.groundItemDeque[var0][var1][var2] = null;
            }
         }
      }

      Client.field427 = new Deque();
      Client.field562 = 0;
      Client.friendCount = 0;
      Client.ignoreCount = 0;

      for(var0 = 0; var0 < class56.field1233; ++var0) {
         class56 var3 = GameEngine.method3242(var0);
         if(var3 != null) {
            class179.settings[var0] = 0;
            class179.widgetSettings[var0] = 0;
         }
      }

      Actor.chatMessages.method223();
      Client.field555 = -1;
      if(Client.widgetRoot != -1) {
         class163.method3329(Client.widgetRoot);
      }

      for(WidgetNode var4 = (WidgetNode)Client.componentTable.method3939(); null != var4; var4 = (WidgetNode)Client.componentTable.method3935()) {
         class145.method3130(var4, true);
      }

      Client.widgetRoot = -1;
      Client.componentTable = new XHashTable(8);
      Client.field376 = null;
      Client.isMenuOpen = false;
      Client.menuOptionCount = 0;
      Client.field567.method3634((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.field422[var0] = null;
         Client.field423[var0] = false;
      }

      class21.method581();
      Client.field304 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field498[var0] = true;
      }

      Projectile.method103();
      Client.field363 = null;
      Client.field522 = 0;
      class4.clanMembers = null;

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
      }

      class162.field2659 = null;
   }
}
