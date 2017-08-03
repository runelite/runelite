import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
public final class class268 {
   @ObfuscatedName("d")
   public static final char[] field3656;
   @ObfuscatedName("j")
   static int[] field3657;

   static {
      field3656 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "906493247"
   )
   static void method4868() {
      Client.field1024 = -1L;
      Client.field905 = -1;
      class88.field1364.field837 = 0;
      class175.field2380 = true;
      Client.field916 = true;
      Client.field1108 = -1L;
      class280.field3735 = new CombatInfoList();
      Client.secretPacketBuffer1.offset = 0;
      Client.secretPacketBuffer2.offset = 0;
      Client.packetType = -1;
      Client.lastFrameId = -1;
      Client.secondLastFrameId = -1;
      Client.thridLastFrameId = -1;
      Client.field941 = 0;
      Client.field908 = 0;
      Client.field946 = 0;
      Client.field1115 = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      ScriptVarType.method18(0);
      class60.method1050();
      Client.itemSelectionState = 0;
      Client.spellSelected = false;
      Client.field1124 = 0;
      Client.mapAngle = 0;
      Client.field1118 = 0;
      Client.field1111 = -1;
      Client.destinationX = 0;
      Client.destinationY = 0;
      Client.field1117 = class91.field1393;
      Client.field918 = class91.field1393;
      Client.field932 = 0;
      class40.method554();

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      for(var0 = 0; var0 < '耀'; ++var0) {
         Client.cachedNPCs[var0] = null;
      }

      Client.field927 = -1;
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
      Client.field1144 = 0;
      Client.friendCount = 0;
      Client.ignoreCount = 0;

      for(var0 = 0; var0 < class3.field22; ++var0) {
         VarPlayerType var3 = WorldMapType3.method181(var0);
         if(var3 != null) {
            class211.settings[var0] = 0;
            class211.widgetSettings[var0] = 0;
         }
      }

      class51.chatMessages.reset();
      Client.field1051 = -1;
      if(Client.widgetRoot != -1) {
         CollisionData.method3079(Client.widgetRoot);
      }

      for(WidgetNode var4 = (WidgetNode)Client.componentTable.method3564(); var4 != null; var4 = (WidgetNode)Client.componentTable.method3565()) {
         class169.method3163(var4, true);
      }

      Client.widgetRoot = -1;
      Client.componentTable = new XHashTable(8);
      Client.field895 = null;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.field1155.method3957((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.playerOptions[var0] = null;
         Client.playerOptionsPriorities[var0] = false;
      }

      XItemContainer.itemContainers = new XHashTable(32);
      Client.field900 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field1088[var0] = true;
      }

      Client.secretPacketBuffer1.putOpcode(197);
      Client.secretPacketBuffer1.putByte(class10.method52());
      Client.secretPacketBuffer1.putShort(class31.canvasWidth);
      Client.secretPacketBuffer1.putShort(class67.canvasHeight);
      Client.clanChatOwner = null;
      class21.clanChatCount = 0;
      class37.clanMembers = null;

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
      }

      CombatInfo2.field3350 = null;
   }
}
