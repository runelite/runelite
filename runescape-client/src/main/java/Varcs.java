import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("Varcs")
public class Varcs {
   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   static Widget field1389;
   @ObfuscatedName("o")
   @Export("varcSerials")
   boolean[] varcSerials;
   @ObfuscatedName("p")
   @Export("varcstringSerials")
   boolean[] varcstringSerials;
   @ObfuscatedName("a")
   @Export("varcs")
   int[] varcs;
   @ObfuscatedName("h")
   @Export("varcstrings")
   String[] varcstrings;
   @ObfuscatedName("l")
   @Export("changed")
   boolean changed;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = -978780189123539923L
   )
   long field1393;

   Varcs() {
      this.changed = false;
      this.varcs = new int[class109.configsIndex.fileCount(19)];
      this.varcstrings = new String[class109.configsIndex.fileCount(15)];
      this.varcSerials = new boolean[this.varcs.length];

      int var1;
      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         class263 var2 = class230.method4363(var1);
         this.varcSerials[var1] = var2.field3413;
      }

      this.varcstringSerials = new boolean[this.varcstrings.length];

      for(var1 = 0; var1 < this.varcstrings.length; ++var1) {
         class264 var3 = (class264)class264.field3417.get((long)var1);
         class264 var5;
         if(var3 != null) {
            var5 = var3;
         } else {
            byte[] var4 = class264.field3415.getConfigData(15, var1);
            var3 = new class264();
            if(var4 != null) {
               var3.method4776(new Buffer(var4));
            }

            class264.field3417.put(var3, (long)var1);
            var5 = var3;
         }

         this.varcstringSerials[var1] = var5.field3416;
      }

      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         this.varcs[var1] = -1;
      }

      this.deserialize();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-389083651"
   )
   @Export("putVarc")
   void putVarc(int var1, int var2) {
      this.varcs[var1] = var2;
      if(this.varcSerials[var1]) {
         this.changed = true;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1138959472"
   )
   @Export("getVarc")
   int getVarc(int var1) {
      return this.varcs[var1];
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "448726047"
   )
   @Export("putVarcString")
   void putVarcString(int var1, String var2) {
      this.varcstrings[var1] = var2;
      if(this.varcstringSerials[var1]) {
         this.changed = true;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "4"
   )
   @Export("getVarcString")
   String getVarcString(int var1) {
      return this.varcstrings[var1];
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "838041647"
   )
   @Export("reset")
   void reset() {
      int var1;
      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         if(!this.varcSerials[var1]) {
            this.varcs[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.varcstrings.length; ++var1) {
         if(!this.varcstringSerials[var1]) {
            this.varcstrings[var1] = null;
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ZI)Ldx;",
      garbageValue = "-855409483"
   )
   @Export("getVarPrefs")
   FileOnDisk getVarPrefs(boolean var1) {
      return WorldComparator.getPreferencesFile("2", class35.field456.name, var1);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-907962476"
   )
   @Export("serialize")
   void serialize() {
      FileOnDisk var1 = this.getVarPrefs(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.varcs.length; ++var4) {
            if(this.varcSerials[var4] && this.varcs[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.varcstrings.length; ++var5) {
            if(this.varcstringSerials[var5] && this.varcstrings[var5] != null) {
               var2 += 2 + class43.getLength(this.varcstrings[var5]);
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.putByte(1);
         var9.putShort(var3);

         int var6;
         for(var6 = 0; var6 < this.varcs.length; ++var6) {
            if(this.varcSerials[var6] && this.varcs[var6] != -1) {
               var9.putShort(var6);
               var9.putInt(this.varcs[var6]);
            }
         }

         var9.putShort(var4);

         for(var6 = 0; var6 < this.varcstrings.length; ++var6) {
            if(this.varcstringSerials[var6] && this.varcstrings[var6] != null) {
               var9.putShort(var6);
               var9.putString(this.varcstrings[var6]);
            }
         }

         var1.write(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.close();
         } catch (Exception var16) {
            ;
         }

      }

      this.changed = false;
      this.field1393 = class188.currentTimeMs();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2032953048"
   )
   @Export("deserialize")
   void deserialize() {
      FileOnDisk var1 = this.getVarPrefs(false);

      try {
         byte[] var2 = new byte[(int)var1.length()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var1.read(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new EOFException();
            }
         }

         Buffer var13 = new Buffer(var2);
         if(var13.payload.length - var13.offset < 1) {
            return;
         }

         int var14 = var13.readUnsignedByte();
         if(var14 < 0 || var14 > 1) {
            return;
         }

         int var15 = var13.readUnsignedShort();

         int var7;
         int var8;
         int var9;
         for(var7 = 0; var7 < var15; ++var7) {
            var8 = var13.readUnsignedShort();
            var9 = var13.readInt();
            if(this.varcSerials[var8]) {
               this.varcs[var8] = var9;
            }
         }

         var7 = var13.readUnsignedShort();

         for(var8 = 0; var8 < var7; ++var8) {
            var9 = var13.readUnsignedShort();
            String var10 = var13.readString();
            if(this.varcstringSerials[var9]) {
               this.varcstrings[var9] = var10;
            }
         }
      } catch (Exception var24) {
         ;
      } finally {
         try {
            var1.close();
         } catch (Exception var23) {
            ;
         }

      }

      this.changed = false;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "488450473"
   )
   @Export("process")
   void process() {
      if(this.changed && this.field1393 < class188.currentTimeMs() - 60000L) {
         this.serialize();
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "34"
   )
   @Export("changed")
   boolean changed() {
      return this.changed;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "1280142012"
   )
   public static int method1956(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & '?');
         } else {
            var0[var4++] = (byte)(224 | var6 >> '\f');
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & '?');
         }
      }

      return var4 - var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BIIII[Lfq;B)V",
      garbageValue = "-43"
   )
   static final void method1983(byte[] var0, int var1, int var2, int var3, int var4, CollisionData[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var7 + var1 > 0 && var7 + var1 < 103 && var8 + var2 > 0 && var8 + var2 < 103) {
                  var5[var6].flags[var7 + var1][var2 + var8] &= -16777217;
               }
            }
         }
      }

      Buffer var10 = new Buffer(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               Resampler.loadTerrain(var10, var7, var8 + var1, var9 + var2, var3, var4, 0);
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lgu;ILbl;II)V",
      garbageValue = "1217448319"
   )
   static final void method1981(PacketBuffer var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 4) != 0) {
         var5 = var0.readUnsignedByteNegate();
         byte[] var6 = new byte[var5];
         Buffer var7 = new Buffer(var6);
         var0.method3597(var6, 0, var5);
         class92.field1374[var1] = var7;
         var2.decodeApperance(var7);
      }

      int var8;
      int var9;
      int var12;
      int var16;
      if((var3 & 2) != 0) {
         var5 = var0.readUnsignedByteNegate();
         int var10;
         int var11;
         int var17;
         if(var5 > 0) {
            for(var16 = 0; var16 < var5; ++var16) {
               var8 = -1;
               var9 = -1;
               var10 = -1;
               var17 = var0.getUSmart();
               if(var17 == 32767) {
                  var17 = var0.getUSmart();
                  var9 = var0.getUSmart();
                  var8 = var0.getUSmart();
                  var10 = var0.getUSmart();
               } else if(var17 != 32766) {
                  var9 = var0.getUSmart();
               } else {
                  var17 = -1;
               }

               var11 = var0.getUSmart();
               var2.method1621(var17, var9, var8, var10, Client.gameCycle, var11);
            }
         }

         var16 = var0.method3577();
         if(var16 > 0) {
            for(var17 = 0; var17 < var16; ++var17) {
               var8 = var0.getUSmart();
               var9 = var0.getUSmart();
               if(var9 != 32767) {
                  var10 = var0.getUSmart();
                  var11 = var0.method3577();
                  var12 = var9 > 0?var0.readUnsignedByteNegate():var11;
                  var2.method1623(var8, Client.gameCycle, var9, var10, var11, var12);
               } else {
                  var2.method1622(var8);
               }
            }
         }
      }

      if((var3 & 64) != 0) {
         var2.field1122 = var0.method3666();
         if(var2.queueSize == 0) {
            var2.orientation = var2.field1122;
            var2.field1122 = -1;
         }
      }

      if((var3 & 1024) != 0) {
         var2.graphic = var0.method3666();
         var5 = var0.method3595();
         var2.field1135 = var5 >> 16;
         var2.graphicsDelay = (var5 & 65535) + Client.gameCycle;
         var2.field1104 = 0;
         var2.field1144 = 0;
         if(var2.graphicsDelay > Client.gameCycle) {
            var2.field1104 = -1;
         }

         if(var2.graphic == 65535) {
            var2.graphic = -1;
         }
      }

      if((var3 & 16) != 0) {
         var2.overhead = var0.readString();
         if(var2.overhead.charAt(0) == '~') {
            var2.overhead = var2.overhead.substring(1);
            class149.sendGameMessage(2, var2.name.getName(), var2.overhead);
         } else if(var2 == OwnWorldComparator.localPlayer) {
            class149.sendGameMessage(2, var2.name.getName(), var2.overhead);
         }

         var2.field1103 = false;
         var2.field1111 = 0;
         var2.field1112 = 0;
         var2.overheadTextCyclesRemaining = 150;
      }

      if((var3 & 8) != 0) {
         var5 = var0.readUnsignedShortOb1();
         if(var5 == 65535) {
            var5 = -1;
         }

         var16 = var0.readUnsignedByteNegate();
         PacketNode.method3441(var2, var5, var16);
      }

      if((var3 & 2048) != 0) {
         var4 = var0.method3580();
      }

      if((var3 & 4096) != 0) {
         var2.field1136 = var0.method3580();
         var2.field1108 = var0.method3580();
         var2.field1137 = var0.readByte();
         var2.field1119 = var0.readByte();
         var2.field1140 = var0.method3699() + Client.gameCycle;
         var2.field1141 = var0.method3699() + Client.gameCycle;
         var2.field1142 = var0.method3666();
         if(var2.field806) {
            var2.field1136 += var2.field807;
            var2.field1108 += var2.field791;
            var2.field1137 += var2.field807;
            var2.field1119 += var2.field791;
            var2.queueSize = 0;
         } else {
            var2.field1136 += var2.pathX[0];
            var2.field1108 += var2.pathY[0];
            var2.field1137 += var2.pathX[0];
            var2.field1119 += var2.pathY[0];
            var2.queueSize = 1;
         }

         var2.field1153 = 0;
      }

      if((var3 & 512) != 0) {
         class92.field1378[var1] = var0.method3579();
      }

      if((var3 & 128) != 0) {
         var2.interacting = var0.readUnsignedShortOb1();
         if(var2.interacting == 65535) {
            var2.interacting = -1;
         }
      }

      if((var3 & 256) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.readString();
         }
      }

      if((var3 & 32) != 0) {
         var5 = var0.method3699();
         Permission var19 = (Permission)Tile.forOrdinal(class34.method395(), var0.method3575());
         boolean var22 = var0.method3575() == 1;
         var8 = var0.method3575();
         var9 = var0.offset;
         if(var2.name != null && var2.composition != null) {
            boolean var21 = false;
            if(var19.field3295 && ContextMenuRow.friendManager.method1701(var2.name)) {
               var21 = true;
            }

            if(!var21 && Client.myPlayerIndex == 0 && !var2.hidden) {
               class92.field1384.offset = 0;
               var0.method3596(class92.field1384.payload, 0, var8);
               class92.field1384.offset = 0;
               String var18 = FontTypeFace.appendTags(class61.method1062(ISAACCipher.method3887(class92.field1384)));
               var2.overhead = var18.trim();
               var2.field1111 = var5 >> 8;
               var2.field1112 = var5 & 255;
               var2.overheadTextCyclesRemaining = 150;
               var2.field1103 = var22;
               var2.inSequence = var2 != OwnWorldComparator.localPlayer && var19.field3295 && "" != Client.field1022 && var18.toLowerCase().indexOf(Client.field1022) == -1;
               if(var19.field3294) {
                  var12 = var22?91:1;
               } else {
                  var12 = var22?90:2;
               }

               if(var19.field3293 != -1) {
                  int var15 = var19.field3293;
                  String var14 = "<img=" + var15 + ">";
                  class149.sendGameMessage(var12, var14 + var2.name.getName(), var18);
               } else {
                  class149.sendGameMessage(var12, var2.name.getName(), var18);
               }
            }
         }

         var0.offset = var9 + var8;
      }

      if(var2.field806) {
         if(var4 == 127) {
            var2.method1191(var2.field807, var2.field791);
         } else {
            byte var20;
            if(var4 != -1) {
               var20 = var4;
            } else {
               var20 = class92.field1378[var1];
            }

            var2.method1190(var2.field807, var2.field791, var20);
         }
      }

   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-2100477261"
   )
   static final void method1967(int var0, int var1, boolean var2) {
      if(!var2 || var0 != class152.field2090 || class151.field2086 != var1) {
         class152.field2090 = var0;
         class151.field2086 = var1;
         WorldMapType1.setGameState(25);
         class235.drawStatusBox("Loading - please wait.", true);
         int var3 = ScriptState.baseX;
         int var4 = WorldMapType1.baseY;
         ScriptState.baseX = (var0 - 6) * 8;
         WorldMapType1.baseY = (var1 - 6) * 8;
         int var5 = ScriptState.baseX - var3;
         int var6 = WorldMapType1.baseY - var4;
         var3 = ScriptState.baseX;
         var4 = WorldMapType1.baseY;

         int var7;
         int var9;
         for(var7 = 0; var7 < 32768; ++var7) {
            NPC var8 = Client.cachedNPCs[var7];
            if(var8 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var8.pathX[var9] -= var5;
                  var8.pathY[var9] -= var6;
               }

               var8.x -= var5 * 128;
               var8.y -= var6 * 128;
            }
         }

         for(var7 = 0; var7 < 2048; ++var7) {
            Player var21 = Client.cachedPlayers[var7];
            if(var21 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var21.pathX[var9] -= var5;
                  var21.pathY[var9] -= var6;
               }

               var21.x -= var5 * 128;
               var21.y -= var6 * 128;
            }
         }

         byte var20 = 0;
         byte var18 = 104;
         byte var22 = 1;
         if(var5 < 0) {
            var20 = 103;
            var18 = -1;
            var22 = -1;
         }

         byte var10 = 0;
         byte var11 = 104;
         byte var12 = 1;
         if(var6 < 0) {
            var10 = 103;
            var11 = -1;
            var12 = -1;
         }

         int var14;
         for(int var13 = var20; var13 != var18; var13 += var22) {
            for(var14 = var10; var14 != var11; var14 += var12) {
               int var15 = var5 + var13;
               int var16 = var6 + var14;

               for(int var17 = 0; var17 < 4; ++var17) {
                  if(var15 >= 0 && var16 >= 0 && var15 < 104 && var16 < 104) {
                     Client.groundItemDeque[var17][var13][var14] = Client.groundItemDeque[var17][var15][var16];
                  } else {
                     Client.groundItemDeque[var17][var13][var14] = null;
                  }
               }
            }
         }

         for(PendingSpawn var19 = (PendingSpawn)Client.pendingSpawns.getFront(); var19 != null; var19 = (PendingSpawn)Client.pendingSpawns.getNext()) {
            var19.x -= var5;
            var19.y -= var6;
            if(var19.x < 0 || var19.y < 0 || var19.x >= 104 || var19.y >= 104) {
               var19.unlink();
            }
         }

         if(Client.destinationX != 0) {
            Client.destinationX -= var5;
            Client.destinationY -= var6;
         }

         Client.queuedSoundEffectCount = 0;
         Client.field983 = false;
         Client.field1077 = -1;
         Client.graphicsObjectDeque.clear();
         Client.projectiles.clear();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].reset();
         }

      }
   }
}
