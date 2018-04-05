import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ldm;"
   )
   @Export("task")
   static SoundTask task;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -2018748751
   )
   static int field795;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 327530869
   )
   static int field794;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -291936541
   )
   @Export("id")
   int id;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 840405479
   )
   @Export("owner")
   int owner;
   @ObfuscatedName("t")
   boolean field793;

   WidgetNode() {
      this.field793 = false;
   }

   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-14"
   )
   static void method1136() {
      Client.mouseLastLastPressedTimeMillis = 1L;
      Client.field885 = -1;
      WorldMapType2.mouseRecorder.index = 0;
      PlayerComposition.field2798 = true;
      Client.field886 = true;
      Client.field1091 = -1L;
      class150.method3111();
      Client.field957.method2038();
      Client.field957.packetBuffer.offset = 0;
      Client.field957.serverPacket = null;
      Client.field957.field1495 = null;
      Client.field957.field1492 = null;
      Client.field957.field1493 = null;
      Client.field957.packetLength = 0;
      Client.field957.field1480 = 0;
      Client.field888 = 0;
      Client.field915 = 0;
      Client.hintArrowTargetType = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      class25.method200(0);
      class95.chatLineMap.clear();
      class95.messages.clear();
      class95.field1453.clear();
      class95.field1452 = 0;
      Client.itemSelectionState = 0;
      Client.spellSelected = false;
      Client.queuedSoundEffectCount = 0;
      Client.mapAngle = 0;
      Client.field960 = 0;
      BaseVarType.field25 = null;
      Client.field1099 = 0;
      Client.field881 = -1;
      Client.destinationX = 0;
      Client.destinationY = 0;
      Client.playerAttackOption = AttackOption.AttackOption_hidden;
      Client.npcAttackOption = AttackOption.AttackOption_hidden;
      Client.npcIndexesCount = 0;
      class93.playerIndexesCount = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         class93.field1430[var0] = null;
         class93.field1429[var0] = 1;
      }

      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      for(var0 = 0; var0 < 32768; ++var0) {
         Client.cachedNPCs[var0] = null;
      }

      Client.field1112 = -1;
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
      WorldMapRectangle.friendManager.method1756();

      for(var0 = 0; var0 < class289.field3777; ++var0) {
         VarPlayerType var4 = (VarPlayerType)VarPlayerType.varplayers.get((long)var0);
         VarPlayerType var5;
         if(var4 != null) {
            var5 = var4;
         } else {
            byte[] var3 = VarPlayerType.varplayer_ref.getConfigData(16, var0);
            var4 = new VarPlayerType();
            if(var3 != null) {
               var4.decode(new Buffer(var3));
            }

            VarPlayerType.varplayers.put(var4, (long)var0);
            var5 = var4;
         }

         if(var5 != null) {
            class237.serverVarps[var0] = 0;
            class237.clientVarps[var0] = 0;
         }
      }

      SceneTilePaint.varcs.reset();
      Client.field1048 = -1;
      if(Client.widgetRoot != -1) {
         var0 = Client.widgetRoot;
         if(var0 != -1 && class154.validInterfaces[var0]) {
            UrlRequest.widgetIndex.method4543(var0);
            if(MouseRecorder.widgets[var0] != null) {
               boolean var7 = true;

               for(var2 = 0; var2 < MouseRecorder.widgets[var0].length; ++var2) {
                  if(MouseRecorder.widgets[var0][var2] != null) {
                     if(MouseRecorder.widgets[var0][var2].type != 2) {
                        MouseRecorder.widgets[var0][var2] = null;
                     } else {
                        var7 = false;
                     }
                  }
               }

               if(var7) {
                  MouseRecorder.widgets[var0] = null;
               }

               class154.validInterfaces[var0] = false;
            }
         }
      }

      for(WidgetNode var6 = (WidgetNode)Client.componentTable.first(); var6 != null; var6 = (WidgetNode)Client.componentTable.next()) {
         class57.closeWidget(var6, true);
      }

      Client.widgetRoot = -1;
      Client.componentTable = new HashTable(8);
      Client.field1033 = null;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.field1132.method4396((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.playerOptions[var0] = null;
         Client.playerOptionsPriorities[var0] = false;
      }

      class37.method544();
      Client.field880 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field1072[var0] = true;
      }

      class61.method1070();
      GameEngine.clanMemberManager = null;

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new GrandExchangeOffer();
      }

      class55.grandExchangeEvents = null;
   }

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-552539724"
   )
   static boolean method1134() {
      return (Client.playerNameMask & 4) != 0;
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1023679584"
   )
   static final void method1133() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < Client.menuOptionCount - 1; ++var1) {
            if(Client.menuTypes[var1] < 1000 && Client.menuTypes[var1 + 1] > 1000) {
               String var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
               Client.menuTargets[var1 + 1] = var2;
               String var3 = Client.menuOptions[var1];
               Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
               Client.menuOptions[var1 + 1] = var3;
               int var4 = Client.menuTypes[var1];
               Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
               Client.menuTypes[var1 + 1] = var4;
               var4 = Client.menuActionParams0[var1];
               Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
               Client.menuActionParams0[var1 + 1] = var4;
               var4 = Client.menuActionParams1[var1];
               Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               Client.menuActionParams1[var1 + 1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
               Client.menuIdentifiers[var1 + 1] = var4;
               boolean var5 = Client.menuBooleanArray[var1];
               Client.menuBooleanArray[var1] = Client.menuBooleanArray[var1 + 1];
               Client.menuBooleanArray[var1 + 1] = var5;
               var0 = false;
            }
         }
      }

   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lin;I)Ljava/lang/String;",
      garbageValue = "-1381280743"
   )
   static String method1135(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         for(int var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               String var4 = var0.substring(0, var3);
               int var6 = class308.method5486(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(var3 + 2);
            }
         }
      }

      return var0;
   }
}
