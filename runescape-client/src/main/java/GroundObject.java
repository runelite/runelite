import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -199807221
   )
   int field1294;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2050105713
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -42873871
   )
   @Export("y")
   int y;
   @ObfuscatedName("k")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1401934921
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 692717797
   )
   @Export("x")
   int x;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2095013191"
   )
   static void method1527() {
      Client.field563 = -1L;
      Client.field297 = -1;
      class26.field596.field210 = 0;
      class9.field83 = true;
      Client.field298 = true;
      Client.field512 = -1L;
      class48.method860();
      Client.field294.offset = 0;
      Client.field544.offset = 0;
      Client.packetOpcode = -1;
      Client.field319 = -1;
      Client.field466 = -1;
      Client.field336 = -1;
      Client.field332 = 0;
      Client.field300 = 0;
      Client.field453 = 0;
      Client.field489 = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      class115.mouseIdleTicks = 0;
      class171.method3176();
      Client.field526 = 0;
      Client.field523 = false;
      Client.field528 = 0;
      Client.field352 = (int)(Math.random() * 100.0D) - 50;
      Client.field354 = (int)(Math.random() * 110.0D) - 55;
      Client.field356 = (int)(Math.random() * 80.0D) - 40;
      Client.mapScale = (int)(Math.random() * 120.0D) - 60;
      Client.mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
      Client.mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
      Client.field522 = 0;
      Client.field515 = -1;
      Client.flagX = 0;
      Client.flagY = 0;
      Client.field309 = class40.field815;
      Client.field310 = class40.field815;
      Client.field322 = 0;
      class165.method3061();

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      for(var0 = 0; var0 < '耀'; ++var0) {
         Client.cachedNPCs[var0] = null;
      }

      Client.field418 = -1;
      Client.projectiles.method2353();
      Client.field422.method2353();

      for(var0 = 0; var0 < 4; ++var0) {
         for(int var4 = 0; var4 < 104; ++var4) {
            for(int var2 = 0; var2 < 104; ++var2) {
               Client.groundItemDeque[var0][var4][var2] = null;
            }
         }
      }

      Client.field370 = new Deque();
      Client.field554 = 0;
      Client.friendCount = 0;
      Client.ignoreCount = 0;

      for(var0 = 0; var0 < class187.field2779; ++var0) {
         class187 var1 = class41.method751(var0);
         if(null != var1) {
            class165.settings[var0] = 0;
            class165.widgetSettings[var0] = 0;
         }
      }

      Ignore.chatMessages.method822();
      Client.field454 = -1;
      if(Client.widgetRoot != -1) {
         Renderable.method1861(Client.widgetRoot);
      }

      for(WidgetNode var3 = (WidgetNode)Client.componentTable.method2313(); var3 != null; var3 = (WidgetNode)Client.componentTable.method2321()) {
         class26.method560(var3, true);
      }

      Client.widgetRoot = -1;
      Client.componentTable = new XHashTable(8);
      Client.field450 = null;
      Client.isMenuOpen = false;
      Client.menuOptionCount = 0;
      Client.field284.method3064((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.field415[var0] = null;
         Client.field416[var0] = false;
      }

      class11.method150();
      Client.field292 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field524[var0] = true;
      }

      FrameMap.method1689();
      Client.field513 = null;
      class13.field136 = 0;
      class8.clanMembers = null;

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
      }

      CombatInfoListHolder.field749 = null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Z",
      garbageValue = "-1755041539"
   )
   public static boolean method1528(String var0, int var1) {
      return NPC.method689(var0, var1, "openjs");
   }
}
