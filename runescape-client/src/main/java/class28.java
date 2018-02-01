import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public abstract class class28 {
   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   @Export("indexScripts")
   static IndexData indexScripts;
   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   static class159 field387;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1950532741
   )
   int field384;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 317836375
   )
   int field376;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2103429009
   )
   int field377;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -620393045
   )
   int field378;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 528122949
   )
   int field379;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1785468815
   )
   int field381;
   @ObfuscatedName("t")
   short[][][] field380;
   @ObfuscatedName("r")
   short[][][] field382;
   @ObfuscatedName("m")
   byte[][][] field386;
   @ObfuscatedName("h")
   byte[][][] field383;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[[[[Lax;"
   )
   class31[][][][] field385;

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IILgj;I)V",
      garbageValue = "2091932326"
   )
   void method250(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method239(var1, var2, var3, var4);
         } else {
            this.method235(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IILgj;II)V",
      garbageValue = "1627874601"
   )
   void method239(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field382[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field380[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IILgj;IB)V",
      garbageValue = "16"
   )
   void method235(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field380[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = var3.readUnsignedByte();
            if(var10 != 0) {
               this.field382[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field386[var9][var1][var2] = (byte)(var11 >> 2);
               this.field383[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               class31[] var14 = this.field385[var8][var1][var2] = new class31[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3414();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new class31(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-361436416"
   )
   int method236(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field380[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-10"
   )
   int method237() {
      return this.field377;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-595018663"
   )
   int method233() {
      return this.field378;
   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "120"
   )
   static final int method256() {
      if(class221.preferences.hideRoofs) {
         return MessageNode.plane;
      } else {
         int var0 = 3;
         if(SceneTilePaint.cameraPitch < 310) {
            int var1 = Actor.cameraX >> 7;
            int var2 = GameCanvas.cameraY >> 7;
            int var3 = class36.localPlayer.x >> 7;
            int var4 = class36.localPlayer.y >> 7;
            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return MessageNode.plane;
            }

            if((class61.tileSettings[MessageNode.plane][var1][var2] & 4) != 0) {
               var0 = MessageNode.plane;
            }

            int var5;
            if(var3 > var1) {
               var5 = var3 - var1;
            } else {
               var5 = var1 - var3;
            }

            int var6;
            if(var4 > var2) {
               var6 = var4 - var2;
            } else {
               var6 = var2 - var4;
            }

            int var7;
            int var8;
            if(var5 > var6) {
               var7 = var6 * 65536 / var5;
               var8 = 32768;

               while(var1 != var3) {
                  if(var1 < var3) {
                     ++var1;
                  } else if(var1 > var3) {
                     --var1;
                  }

                  if((class61.tileSettings[MessageNode.plane][var1][var2] & 4) != 0) {
                     var0 = MessageNode.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var2 < var4) {
                        ++var2;
                     } else if(var2 > var4) {
                        --var2;
                     }

                     if((class61.tileSettings[MessageNode.plane][var1][var2] & 4) != 0) {
                        var0 = MessageNode.plane;
                     }
                  }
               }
            } else {
               var7 = var5 * 65536 / var6;
               var8 = 32768;

               while(var4 != var2) {
                  if(var2 < var4) {
                     ++var2;
                  } else if(var2 > var4) {
                     --var2;
                  }

                  if((class61.tileSettings[MessageNode.plane][var1][var2] & 4) != 0) {
                     var0 = MessageNode.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var1 < var3) {
                        ++var1;
                     } else if(var1 > var3) {
                        --var1;
                     }

                     if((class61.tileSettings[MessageNode.plane][var1][var2] & 4) != 0) {
                        var0 = MessageNode.plane;
                     }
                  }
               }
            }
         }

         if(class36.localPlayer.x >= 0 && class36.localPlayer.y >= 0 && class36.localPlayer.x < 13312 && class36.localPlayer.y < 13312) {
            if((class61.tileSettings[MessageNode.plane][class36.localPlayer.x >> 7][class36.localPlayer.y >> 7] & 4) != 0) {
               var0 = MessageNode.plane;
            }

            return var0;
         } else {
            return MessageNode.plane;
         }
      }
   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1252887892"
   )
   static final void method255(int var0) {
      if(class213.loadWidget(var0)) {
         Widget[] var1 = FileRequest.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2860 = 0;
               var3.field2871 = 0;
            }
         }

      }
   }
}
