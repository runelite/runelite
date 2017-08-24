import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class45 extends class28 {
   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("indexTrack1")
   static IndexData indexTrack1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1946780945
   )
   int field601;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -521235781
   )
   int field603;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -227921517
   )
   int field597;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 73750059
   )
   int field598;

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "30"
   )
   int method680() {
      return this.field597;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1830585690"
   )
   boolean method672(int var1, int var2) {
      return var1 < this.field597 * 8?false:(var2 < this.field598 * 8?false:(var1 >= this.field597 * 8 + 8?false:var2 < 8 + this.field598 * 8));
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1776733460"
   )
   int method677() {
      return this.field598;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfp;Lfp;B)V",
      garbageValue = "1"
   )
   void method671(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field514.field513) {
         throw new IllegalStateException("");
      } else {
         super.field422 = var2.readUnsignedByte();
         super.field419 = var2.readUnsignedByte();
         super.field415 = var2.readUnsignedShort();
         super.field416 = var2.readUnsignedShort();
         this.field603 = var2.readUnsignedByte();
         this.field601 = var2.readUnsignedByte();
         super.field414 = var2.readUnsignedShort();
         super.field417 = var2.readUnsignedShort();
         this.field597 = var2.readUnsignedByte();
         this.field598 = var2.readUnsignedByte();
         super.field419 = Math.min(super.field419, 4);
         super.field420 = new short[1][64][64];
         super.field418 = new short[super.field419][64][64];
         super.field421 = new byte[super.field419][64][64];
         super.field423 = new byte[super.field419][64][64];
         super.field424 = new class31[super.field419][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field506.field512) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field414 && var5 == super.field417 && var6 == this.field597 && var7 == this.field598) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method269(var8 + this.field597 * 8, var9 + this.field598 * 8, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1787473258"
   )
   int method674() {
      return this.field603;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-192231315"
   )
   int method686() {
      return this.field601;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class45)) {
         return false;
      } else {
         class45 var2 = (class45)var1;
         return var2.field414 == super.field414 && var2.field417 == super.field417?this.field597 == var2.field597 && this.field598 == var2.field598:false;
      }
   }

   public int hashCode() {
      return super.field414 | super.field417 << 8 | this.field597 << 16 | this.field598 << 24;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1927485164"
   )
   @Export("currentTimeMs")
   public static synchronized long currentTimeMs() {
      long var0 = System.currentTimeMillis();
      if(var0 < class176.field2412) {
         class176.field2410 += class176.field2412 - var0;
      }

      class176.field2412 = var0;
      return var0 + class176.field2410;
   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2005800270"
   )
   static final int method696() {
      if(Buffer.preferences.hideRoofs) {
         return class27.plane;
      } else {
         int var0 = 3;
         if(Friend.cameraPitch < 310) {
            int var1 = class82.cameraX >> 7;
            int var2 = class158.cameraY >> 7;
            int var3 = Player.localPlayer.x >> 7;
            int var4 = Player.localPlayer.y >> 7;
            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return class27.plane;
            }

            if((class61.tileSettings[class27.plane][var1][var2] & 4) != 0) {
               var0 = class27.plane;
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
               var8 = '耀';

               while(var1 != var3) {
                  if(var1 < var3) {
                     ++var1;
                  } else if(var1 > var3) {
                     --var1;
                  }

                  if((class61.tileSettings[class27.plane][var1][var2] & 4) != 0) {
                     var0 = class27.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var2 < var4) {
                        ++var2;
                     } else if(var2 > var4) {
                        --var2;
                     }

                     if((class61.tileSettings[class27.plane][var1][var2] & 4) != 0) {
                        var0 = class27.plane;
                     }
                  }
               }
            } else {
               var7 = var5 * 65536 / var6;
               var8 = '耀';

               while(var4 != var2) {
                  if(var2 < var4) {
                     ++var2;
                  } else if(var2 > var4) {
                     --var2;
                  }

                  if((class61.tileSettings[class27.plane][var1][var2] & 4) != 0) {
                     var0 = class27.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var1 < var3) {
                        ++var1;
                     } else if(var1 > var3) {
                        --var1;
                     }

                     if((class61.tileSettings[class27.plane][var1][var2] & 4) != 0) {
                        var0 = class27.plane;
                     }
                  }
               }
            }
         }

         if(Player.localPlayer.x >= 0 && Player.localPlayer.y >= 0 && Player.localPlayer.x < 13312 && Player.localPlayer.y < 13312) {
            if((class61.tileSettings[class27.plane][Player.localPlayer.x >> 7][Player.localPlayer.y >> 7] & 4) != 0) {
               var0 = class27.plane;
            }

            return var0;
         } else {
            return class27.plane;
         }
      }
   }
}
