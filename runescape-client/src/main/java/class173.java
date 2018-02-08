import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class class173 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   public static final class173 field2429;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   public static final class173 field2431;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   public static final class173 field2432;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   public static final class173 field2427;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   public static final class173 field2426;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   public static final class173 field2430;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   public static final class173 field2425;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   public static final class173 field2428;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   public static final class173 field2433;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   public static final class173 field2434;

   static {
      field2429 = new class173(5);
      field2431 = new class173(2);
      field2432 = new class173(3);
      field2427 = new class173(7);
      field2426 = new class173(4);
      field2430 = new class173(5);
      field2425 = new class173(15);
      field2428 = new class173(4);
      field2433 = new class173(6);
      field2434 = new class173(14);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5"
   )
   class173(int var1) {
   }

   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-945191630"
   )
   static void method3411() {
      Client.mouseLastLastPressedTimeMillis = 1L;
      Client.field853 = -1;
      class41.mouseRecorder.index = 0;
      class3.field14 = true;
      Client.field961 = true;
      Client.field1048 = -1L;
      class304.classInfos = new CombatInfoList();
      Client.field937.method2041();
      Client.field937.packetBuffer.offset = 0;
      Client.field937.serverPacket = null;
      Client.field937.field1455 = null;
      Client.field937.field1446 = null;
      Client.field937.field1457 = null;
      Client.field937.packetLength = 0;
      Client.field937.field1456 = 0;
      Client.field994 = 0;
      Client.field943 = 0;
      Client.hintArrowTargetType = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      class111.method2350(0);
      class84.method1866();
      Client.itemSelectionState = 0;
      Client.spellSelected = false;
      Client.queuedSoundEffectCount = 0;
      Client.mapAngle = 0;
      Client.field978 = 0;
      Client.field1049 = -1;
      Client.destinationX = 0;
      Client.destinationY = 0;
      Client.playerAttackOption = AttackOption.AttackOption_hidden;
      Client.npcAttackOption = AttackOption.AttackOption_hidden;
      Client.npcIndexesCount = 0;
      class92.playerIndexesCount = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         class92.field1398[var0] = null;
         class92.field1390[var0] = 1;
      }

      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      for(var0 = 0; var0 < 32768; ++var0) {
         Client.cachedNPCs[var0] = null;
      }

      Client.field953 = -1;
      Client.projectiles.clear();
      Client.graphicsObjectDeque.clear();

      int var2;
      for(var0 = 0; var0 < 4; ++var0) {
         for(int var1 = 0; var1 < 104; ++var1) {
            for(var2 = 0; var2 < 104; ++var2) {
               Client.groundItemDeque[var0][var1][var2] = null;
            }
         }
      }

      Client.pendingSpawns = new Deque();
      class35.friendManager.method1742();

      for(var0 = 0; var0 < VarPlayerType.field3373; ++var0) {
         VarPlayerType var3 = class160.method3258(var0);
         if(var3 != null) {
            class222.settings[var0] = 0;
            class222.widgetSettings[var0] = 0;
         }
      }

      class34.chatMessages.reset();
      Client.field992 = -1;
      if(Client.widgetRoot != -1) {
         var0 = Client.widgetRoot;
         if(var0 != -1 && GrandExchangeOffer.validInterfaces[var0]) {
            class60.widgetIndex.method4517(var0);
            if(ScriptState.widgets[var0] != null) {
               boolean var5 = true;

               for(var2 = 0; var2 < ScriptState.widgets[var0].length; ++var2) {
                  if(ScriptState.widgets[var0][var2] != null) {
                     if(ScriptState.widgets[var0][var2].type != 2) {
                        ScriptState.widgets[var0][var2] = null;
                     } else {
                        var5 = false;
                     }
                  }
               }

               if(var5) {
                  ScriptState.widgets[var0] = null;
               }

               GrandExchangeOffer.validInterfaces[var0] = false;
            }
         }
      }

      for(WidgetNode var4 = (WidgetNode)Client.componentTable.first(); var4 != null; var4 = (WidgetNode)Client.componentTable.next()) {
         class137.method3103(var4, true);
      }

      Client.widgetRoot = -1;
      Client.componentTable = new HashTable(8);
      Client.field885 = null;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.field1087.method4378((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.playerOptions[var0] = null;
         Client.playerOptionsPriorities[var0] = false;
      }

      FrameMap.method2902();
      Client.field848 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field1029[var0] = true;
      }

      ScriptState.method985();
      class22.clanMemberManager = null;

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new GrandExchangeOffer();
      }

      VertexNormal.grandExchangeEvents = null;
   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(Lbe;B)V",
      garbageValue = "-6"
   )
   static final void method3412(Actor var0) {
      int var1 = var0.field1160 - Client.gameCycle;
      int var2 = var0.field1162 * 128 + var0.field1127 * 64;
      int var3 = var0.field1158 * 128 + var0.field1127 * 64;
      var0.x += (var2 - var0.x) / var1;
      var0.y += (var3 - var0.y) / var1;
      var0.field1172 = 0;
      var0.orientation = var0.field1118;
   }
}
