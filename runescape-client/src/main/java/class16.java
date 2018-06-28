import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public abstract class class16 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -394254045
   )
   int field131;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 113242555
   )
   int field135;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -115293407
   )
   int field141;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -542251137
   )
   int field132;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1746992555
   )
   int field133;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1123040571
   )
   int field134;
   @ObfuscatedName("h")
   short[][][] field129;
   @ObfuscatedName("x")
   short[][][] field130;
   @ObfuscatedName("j")
   byte[][][] field137;
   @ObfuscatedName("a")
   byte[][][] field138;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[[[[Lu;"
   )
   @Export("decorations")
   WorldMapDecoration[][][][] decorations;

   class16() {
      new LinkedList();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IILgy;I)V",
      garbageValue = "-654618120"
   )
   void method165(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method167(var1, var2, var3, var4);
         } else {
            this.method175(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IILgy;II)V",
      garbageValue = "-1325628856"
   )
   void method167(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field130[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field129[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IILgy;II)V",
      garbageValue = "-1146297648"
   )
   void method175(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field129[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = var3.readUnsignedByte();
            if(var10 != 0) {
               this.field130[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field137[var9][var1][var2] = (byte)(var11 >> 2);
               this.field138[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               WorldMapDecoration[] var14 = this.decorations[var8][var1][var2] = new WorldMapDecoration[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3585();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new WorldMapDecoration(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-359965470"
   )
   int method168(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field129[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1875239894"
   )
   int method182() {
      return this.field141;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1199787934"
   )
   int method170() {
      return this.field132;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "825820954"
   )
   static final int method185(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "713832417"
   )
   static void method186() {
      Client.mouseLastLastPressedTimeMillis = 1L;
      Client.field608 = -1;
      VarCString.mouseRecorder.index = 0;
      Preferences.field978 = true;
      Client.field609 = true;
      Client.field782 = -1L;
      class313.classInfos = new CombatInfoList();
      Client.field739.method2020();
      Client.field739.packetBuffer.offset = 0;
      Client.field739.serverPacket = null;
      Client.field739.field1251 = null;
      Client.field739.field1245 = null;
      Client.field739.field1253 = null;
      Client.field739.packetLength = 0;
      Client.field739.field1249 = 0;
      Client.field643 = 0;
      Client.field688 = 0;
      Client.hintArrowTargetType = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      class59.method1120(0);
      AttackOption.method1855();
      Client.itemSelectionState = 0;
      Client.spellSelected = false;
      Client.queuedSoundEffectCount = 0;
      Client.mapAngle = 0;
      Client.field678 = 0;
      class8.field53 = null;
      Client.field822 = 0;
      Client.field815 = -1;
      Client.destinationX = 0;
      Client.destinationY = 0;
      Client.playerAttackOption = AttackOption.AttackOption_hidden;
      Client.npcAttackOption = AttackOption.AttackOption_hidden;
      Client.npcIndexesCount = 0;
      Client.method1525();

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      for(var0 = 0; var0 < 32768; ++var0) {
         Client.cachedNPCs[var0] = null;
      }

      Client.field719 = -1;
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
      CacheFile.friendManager.method1667();

      for(var0 = 0; var0 < VarPlayerType.field3251; ++var0) {
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
            class225.serverVarps[var0] = 0;
            class225.clientVarps[var0] = 0;
         }
      }

      Permission.varcs.reset();
      Client.field760 = -1;
      if(Client.widgetRoot != -1) {
         WorldMapRectangle.method190(Client.widgetRoot);
      }

      for(WidgetNode var6 = (WidgetNode)Client.componentTable.first(); var6 != null; var6 = (WidgetNode)Client.componentTable.next()) {
         class21.closeWidget(var6, true);
      }

      Client.widgetRoot = -1;
      Client.componentTable = new HashTable(8);
      Client.field756 = null;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.field853.method4485((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.playerOptions[var0] = null;
         Client.playerOptionsPriorities[var0] = false;
      }

      ItemContainer.itemContainers = new HashTable(32);
      Client.field603 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field795[var0] = true;
      }

      PacketNode var8 = DecorativeObject.method3115(ClientPacket.field2206, Client.field739.field1250);
      PacketBuffer var7 = var8.packetBuffer;
      var2 = Client.isResized?2:1;
      var7.putByte(var2);
      var8.packetBuffer.putShort(class9.canvasWidth);
      var8.packetBuffer.putShort(class37.canvasHeight);
      Client.field739.method2019(var8);
      WorldComparator.clanMemberManager = null;

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new GrandExchangeOffer();
      }

      class173.grandExchangeEvents = null;
   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZS)V",
      garbageValue = "-7094"
   )
   static final void method187(String var0, boolean var1) {
      if(Client.field715) {
         byte var2 = 4;
         int var3 = var2 + 6;
         int var4 = var2 + 6;
         int var5 = ScriptEvent.font_p12full.method5538(var0, 250);
         int var6 = ScriptEvent.font_p12full.method5539(var0, 250) * 13;
         Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2, 0);
         Rasterizer2D.drawRectangle(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2, 16777215);
         ScriptEvent.font_p12full.method5595(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
         class34.method626(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2);
         if(var1) {
            class50.rasterProvider.drawFull(0, 0);
         } else {
            BuildType.method4608(var3, var4, var5, var6);
         }

      }
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-99"
   )
   static boolean method188() {
      return (Client.playerNameMask & 4) != 0;
   }

   @ObfuscatedName("ki")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "121"
   )
   static void method189(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < class49.field443; ++var4) {
         ItemComposition var5 = class120.getItemDefinition(var4);
         if((!var1 || var5.isTradable) && var5.notedTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               MapIcon.field256 = -1;
               class137.field1889 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class137.field1889 = var2;
      ScriptEvent.field522 = 0;
      MapIcon.field256 = var3;
      String[] var8 = new String[MapIcon.field256];

      for(int var9 = 0; var9 < MapIcon.field256; ++var9) {
         var8[var9] = class120.getItemDefinition(var2[var9]).name;
      }

      class140.method3173(var8, class137.field1889);
   }
}
