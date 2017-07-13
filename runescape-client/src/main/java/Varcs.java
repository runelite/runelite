import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("Varcs")
public class Varcs {
   @ObfuscatedName("bi")
   static class232 field1515;
   @ObfuscatedName("k")
   static int[] field1508;
   @ObfuscatedName("l")
   @Export("changed")
   boolean changed;
   @ObfuscatedName("e")
   @Export("varcstrings")
   String[] varcstrings;
   @ObfuscatedName("v")
   @Export("varcs")
   int[] varcs;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 4751790398243016377L
   )
   @Export("lastSerialize")
   long lastSerialize;
   @ObfuscatedName("n")
   @Export("varcSerials")
   boolean[] varcSerials;
   @ObfuscatedName("r")
   @Export("varcstringSerials")
   boolean[] varcstringSerials;

   Varcs() {
      this.changed = false;
      this.varcs = new int[Tile.configsIndex.fileCount(19)];
      this.varcstrings = new String[Tile.configsIndex.fileCount(15)];
      this.varcSerials = new boolean[this.varcs.length];

      int var1;
      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         class243 var3 = (class243)class243.field3311.get((long)var1);
         class243 var2;
         if(var3 != null) {
            var2 = var3;
         } else {
            byte[] var4 = class243.field3310.getConfigData(19, var1);
            var3 = new class243();
            if(var4 != null) {
               var3.method4263(new Buffer(var4));
            }

            class243.field3311.put(var3, (long)var1);
            var2 = var3;
         }

         this.varcSerials[var1] = var2.field3312;
      }

      this.varcstringSerials = new boolean[this.varcstrings.length];

      for(var1 = 0; var1 < this.varcstrings.length; ++var1) {
         class244 var5 = class177.getVarClientStringType(var1);
         this.varcstringSerials[var1] = var5.field3321;
      }

      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         this.varcs[var1] = -1;
      }

      this.deserialize();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ZI)LFileOnDisk;",
      garbageValue = "-1223007917"
   )
   @Export("getVarPrefs")
   FileOnDisk getVarPrefs(boolean var1) {
      return class152.getPreferencesFile("2", field1515.field3198, var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2143907124"
   )
   @Export("changed")
   boolean changed() {
      return this.changed;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1293109422"
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
               var2 += 2 + DecorativeObject.getLength(this.varcstrings[var5]);
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
      this.lastSerialize = class46.currentTimeMs();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1836002436"
   )
   @Export("deserialize")
   void deserialize() {
      FileOnDisk var1 = this.getVarPrefs(false);

      label200: {
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

            int var5 = var13.readUnsignedByte();
            if(var5 >= 0 && var5 <= 1) {
               int var6 = var13.readUnsignedShort();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var13.readUnsignedShort();
                  var9 = var13.readInt();
                  if(this.varcSerials[var8]) {
                     this.varcs[var8] = var9;
                  }
               }

               var7 = var13.readUnsignedShort();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label200;
                  }

                  var9 = var13.readUnsignedShort();
                  String var10 = var13.readString();
                  if(this.varcstringSerials[var9]) {
                     this.varcstrings[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label200;
         } finally {
            try {
               var1.close();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.changed = false;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "916322599"
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1028897416"
   )
   @Export("process")
   void process() {
      if(this.changed && this.lastSerialize < class46.currentTimeMs() - 60000L) {
         this.serialize();
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "2035976765"
   )
   @Export("getVarcString")
   String getVarcString(int var1) {
      return this.varcstrings[var1];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2131869908"
   )
   @Export("getVarc")
   int getVarc(int var1) {
      return this.varcs[var1];
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1789805765"
   )
   @Export("putVarc")
   void putVarc(int var1, int var2) {
      this.varcs[var1] = var2;
      if(this.varcSerials[var1]) {
         this.changed = true;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "475350821"
   )
   @Export("putVarcString")
   void putVarcString(int var1, String var2) {
      this.varcstrings[var1] = var2;
      if(this.varcstringSerials[var1]) {
         this.changed = true;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   public static void method1776() {
      Varbit.varbits.reset();
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "126"
   )
   static final void method1789(int var0, int var1, boolean var2) {
      if(!var2 || var0 != class37.field494 || class31.field435 != var1) {
         class37.field494 = var0;
         class31.field435 = var1;
         WorldMapType2.setGameState(25);
         class89.drawStatusBox("Loading - please wait.", true);
         int var3 = class163.baseX;
         int var4 = class10.baseY;
         class163.baseX = (var0 - 6) * 8;
         class10.baseY = (var1 - 6) * 8;
         int var5 = class163.baseX - var3;
         int var6 = class10.baseY - var4;
         var3 = class163.baseX;
         var4 = class10.baseY;

         int var7;
         int var9;
         for(var7 = 0; var7 < '耀'; ++var7) {
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
               int var15 = var13 + var5;
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

         Client.field1080 = 0;
         Client.field1152 = false;
         Client.field1133 = -1;
         Client.graphicsObjectDeque.clear();
         Client.projectiles.clear();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].reset();
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2114088606"
   )
   static final int method1804(int var0, int var1) {
      int var2 = var1 * 57 + var0;
      var2 ^= var2 << 13;
      int var3 = var2 * (var2 * var2 * 15731 + 789221) + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1741724367"
   )
   static int method1795(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class83.intStack[--WorldMapType2.intStackSize];
         var4 = class61.method1038(var3);
      } else {
         var4 = var2?class83.field1336:class1.field9;
      }

      if(var0 == 1000) {
         WorldMapType2.intStackSize -= 4;
         var4.originalX = class83.intStack[WorldMapType2.intStackSize];
         var4.originalY = class83.intStack[WorldMapType2.intStackSize + 1];
         var4.field2658 = class83.intStack[WorldMapType2.intStackSize + 2];
         var4.field2659 = class83.intStack[WorldMapType2.intStackSize + 3];
         class48.method749(var4);
         class28.clientInstance.method1346(var4);
         if(var3 != -1 && var4.type == 0) {
            class36.method487(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         WorldMapType2.intStackSize -= 4;
         var4.originalWidth = class83.intStack[WorldMapType2.intStackSize];
         var4.field2736 = class83.intStack[WorldMapType2.intStackSize + 1];
         var4.field2640 = class83.intStack[WorldMapType2.intStackSize + 2];
         var4.buttonType = class83.intStack[WorldMapType2.intStackSize + 3];
         class48.method749(var4);
         class28.clientInstance.method1346(var4);
         if(var3 != -1 && var4.type == 0) {
            class36.method487(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class83.intStack[--WorldMapType2.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            class48.method749(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.field2786 = class83.intStack[--WorldMapType2.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2787 = class83.intStack[--WorldMapType2.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }
}
