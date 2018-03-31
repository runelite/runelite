import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
public class class245 implements class244 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   public static final class245 field2950;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   public static final class245 field2951;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   public static final class245 field2959;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   public static final class245 field2949;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   public static final class245 field2953;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   public static final class245 field2952;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   public static final class245 field2955;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   public static final class245 field2956;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   static final class245 field2957;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   public static final class245 field2958;
   @ObfuscatedName("fo")
   static byte[][] field2960;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 832662083
   )
   public final int field2954;

   static {
      field2950 = new class245("", 10);
      field2951 = new class245("", 11);
      field2959 = new class245("", 12);
      field2949 = new class245("", 13);
      field2953 = new class245("", 14);
      field2952 = new class245("", 15, new ScriptVarType[]{ScriptVarType.field37, ScriptVarType.field37}, (ScriptVarType[])null);
      field2955 = new class245("", 16, new ScriptVarType[]{ScriptVarType.field37, ScriptVarType.field37}, (ScriptVarType[])null);
      field2956 = new class245("", 17, new ScriptVarType[]{ScriptVarType.field37, ScriptVarType.field37}, (ScriptVarType[])null);
      field2957 = new class245("", 73, true, true);
      field2958 = new class245("", 76, true, false);
   }

   class245(String var1, int var2) {
      this(var1, var2, false, (ScriptVarType[])null, false, (ScriptVarType[])null);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZ[Lz;Z[Lz;)V"
   )
   class245(String var1, int var2, boolean var3, ScriptVarType[] var4, boolean var5, ScriptVarType[] var6) {
      this.field2954 = var2;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I[Lz;[Lz;)V"
   )
   class245(String var1, int var2, ScriptVarType[] var3, ScriptVarType[] var4) {
      this(var1, var2, var3 != null, var3, null != var4, var4);
   }

   class245(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (ScriptVarType[])null, var4, (ScriptVarType[])null);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1780726447"
   )
   public int rsOrdinal() {
      return this.field2954;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lgp;Lhz;I)Lhz;",
      garbageValue = "1245672568"
   )
   @Export("readStringIntParameters")
   static final IterableHashTable readStringIntParameters(Buffer var0, IterableHashTable var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = WallObject.nextPowerOfTwo(var2);
         var1 = new IterableHashTable(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new ObjectNode(var0.readString());
         } else {
            var6 = new IntegerNode(var0.readInt());
         }

         var1.put((Node)var6, (long)var5);
      }

      return var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "585193291"
   )
   public static void method4508() {
      Spotanim.spotanims.reset();
      Spotanim.SpotAnimationDefinition_cachedModels.reset();
   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1985051902"
   )
   static void method4505() {
      Client.mouseLastLastPressedTimeMillis = -1L;
      Client.field870 = -1;
      class38.mouseRecorder.index = 0;
      MapIcon.field508 = true;
      Client.field1117 = true;
      Client.field1079 = -1L;
      class326.classInfos = new CombatInfoList();
      Client.field902.method2033();
      Client.field902.packetBuffer.offset = 0;
      Client.field902.serverPacket = null;
      Client.field902.field1485 = null;
      Client.field902.field1473 = null;
      Client.field902.field1471 = null;
      Client.field902.packetLength = 0;
      Client.field902.field1480 = 0;
      Client.field873 = 0;
      Client.field903 = 0;
      Client.hintArrowTargetType = 0;
      class45.method670();
      MouseInput.mouseIdleTicks = 0;
      class95.chatLineMap.clear();
      class95.messages.clear();
      class95.field1434.clear();
      class95.field1435 = 0;
      Client.itemSelectionState = 0;
      Client.spellSelected = false;
      Client.queuedSoundEffectCount = 0;
      Client.mapAngle = 0;
      Client.field930 = 0;
      Client.field1132 = null;
      Client.field1087 = 0;
      Client.field1100 = -1;
      Client.destinationX = 0;
      Client.destinationY = 0;
      Client.playerAttackOption = AttackOption.AttackOption_hidden;
      Client.npcAttackOption = AttackOption.AttackOption_hidden;
      Client.npcIndexesCount = 0;
      class3.method3();

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      for(var0 = 0; var0 < 32768; ++var0) {
         Client.cachedNPCs[var0] = null;
      }

      Client.field982 = -1;
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
      RunException.friendManager.method1661();

      for(var0 = 0; var0 < VarPlayerType.field3445; ++var0) {
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

      class158.varcs.reset();
      Client.field1055 = -1;
      if(Client.widgetRoot != -1) {
         var0 = Client.widgetRoot;
         if(var0 != -1 && class314.validInterfaces[var0]) {
            UnitPriceComparator.widgetIndex.method4566(var0);
            if(class189.widgets[var0] != null) {
               boolean var7 = true;

               for(var2 = 0; var2 < class189.widgets[var0].length; ++var2) {
                  if(class189.widgets[var0][var2] != null) {
                     if(class189.widgets[var0][var2].type != 2) {
                        class189.widgets[var0][var2] = null;
                     } else {
                        var7 = false;
                     }
                  }
               }

               if(var7) {
                  class189.widgets[var0] = null;
               }

               class314.validInterfaces[var0] = false;
            }
         }
      }

      for(WidgetNode var6 = (WidgetNode)Client.componentTable.first(); var6 != null; var6 = (WidgetNode)Client.componentTable.next()) {
         class44.closeWidget(var6, true);
      }

      Client.widgetRoot = -1;
      Client.componentTable = new HashTable(8);
      Client.field1102 = null;
      class45.method670();
      Client.field1118.method4408((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.playerOptions[var0] = null;
         Client.playerOptionsPriorities[var0] = false;
      }

      class229.method4142();
      Client.field865 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field1060[var0] = true;
      }

      Permission.method4535();
      class33.clanMemberManager = null;

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new GrandExchangeOffer();
      }

      Client.grandExchangeEvents = null;
   }
}
