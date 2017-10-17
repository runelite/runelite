import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("ag")
public class class31 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 459901819
   )
   @Export("sampleRate")
   public static int sampleRate;
   @ObfuscatedName("lp")
   @ObfuscatedSignature(
      signature = "[Lhj;"
   )
   static Widget[] field457;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -756300447
   )
   static int field459;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = 759314825
   )
   static int field453;
   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   static IndexData field458;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1903816733
   )
   final int field455;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2145922275
   )
   final int field454;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 320533149
   )
   final int field461;

   class31(int var1, int var2, int var3) {
      this.field455 = var1;
      this.field454 = var2;
      this.field461 = var3;
   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2068882454"
   )
   static void method268() {
      Client.field1144 = -1L;
      Client.field934 = -1;
      class110.field1653.field861 = 0;
      class43.field595 = true;
      Client.field935 = true;
      Client.field1137 = -1L;
      FrameMap.method2754();
      Client.secretPacketBuffer1.offset = 0;
      Client.secretPacketBuffer2.offset = 0;
      Client.packetType = -1;
      Client.lastFrameId = -1;
      Client.secondLastFrameId = -1;
      Client.thridLastFrameId = -1;
      Client.field969 = 0;
      Client.field983 = 0;
      Client.field974 = 0;
      Client.field938 = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Varcs.method1894(0);
      class96.chatLineMap.clear();
      class96.field1508.clear();
      class96.field1509.method3773();
      class96.field1510 = 0;
      Client.itemSelectionState = 0;
      Client.spellSelected = false;
      Client.field1154 = 0;
      Client.mapAngle = 0;
      Client.field1183 = 0;
      Client.field1140 = -1;
      Client.destinationX = 0;
      Client.destinationY = 0;
      Client.field946 = class89.field1403;
      Client.field947 = class89.field1403;
      Client.npcIndexesCount = 0;
      class94.playerIndexesCount = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         class94.field1478[var0] = null;
         class94.field1477[var0] = 1;
      }

      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      for(var0 = 0; var0 < 32768; ++var0) {
         Client.cachedNPCs[var0] = null;
      }

      Client.field1061 = -1;
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
      Client.field1180 = 0;
      Client.friendCount = 0;
      Client.ignoreCount = 0;

      for(var0 = 0; var0 < class181.field2452; ++var0) {
         VarPlayerType var3 = Buffer.method3461(var0);
         if(var3 != null) {
            class211.settings[var0] = 0;
            class211.widgetSettings[var0] = 0;
         }
      }

      GZipDecompressor.chatMessages.reset();
      Client.field1081 = -1;
      if(Client.widgetRoot != -1) {
         class215.method4106(Client.widgetRoot);
      }

      for(WidgetNode var4 = (WidgetNode)Client.componentTable.method3646(); var4 != null; var4 = (WidgetNode)Client.componentTable.method3647()) {
         PendingSpawn.method1584(var4, true);
      }

      Client.widgetRoot = -1;
      Client.componentTable = new HashTable(8);
      Client.field1077 = null;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.field1179.method4096((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.playerOptions[var0] = null;
         Client.playerOptionsPriorities[var0] = false;
      }

      ItemContainer.itemContainers = new HashTable(32);
      Client.field1123 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field1118[var0] = true;
      }

      Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_RESIZE_CLIENT_FRAME);
      Client.secretPacketBuffer1.putByte(class19.method142());
      Client.secretPacketBuffer1.putShort(class60.canvasWidth);
      Client.secretPacketBuffer1.putShort(class48.canvasHeight);
      Client.clanChatOwner = null;
      class21.clanChatCount = 0;
      WorldMapType1.clanMembers = null;

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new GrandExchangeOffer();
      }

      class19.field330 = null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-41"
   )
   public static int method267() {
      return KeyFocusListener.keyboardIdleTicks;
   }
}
