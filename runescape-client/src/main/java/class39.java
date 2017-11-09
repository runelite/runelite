import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class39 {
   @ObfuscatedName("ng")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   static SpritePixels field507;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -608153597
   )
   public final int field508;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   public final Coordinates field499;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   public final Coordinates field498;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 43631541
   )
   final int field500;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1469812355
   )
   final int field502;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lav;"
   )
   final class33 field503;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1661981201
   )
   int field504;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -961917725
   )
   int field505;

   @ObfuscatedSignature(
      signature = "(ILhq;Lhq;Lav;)V"
   )
   class39(int var1, Coordinates var2, Coordinates var3, class33 var4) {
      this.field508 = var1;
      this.field498 = var2;
      this.field499 = var3;
      this.field503 = var4;
      Area var5 = Area.field3358[this.field508];
      SpritePixels var6 = var5.method4485(false);
      if(var6 != null) {
         this.field500 = var6.width;
         this.field502 = var6.height;
      } else {
         this.field500 = 0;
         this.field502 = 0;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1597798621"
   )
   boolean method583(int var1, int var2) {
      return this.method592(var1, var2)?true:this.method585(var1, var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "2"
   )
   boolean method592(int var1, int var2) {
      Area var3 = Area.field3358[this.field508];
      switch(var3.field3348.field3598) {
      case 0:
         if(var1 > this.field504 - this.field500 && var1 <= this.field504) {
            break;
         }

         return false;
      case 1:
         if(var1 >= this.field504 && var1 < this.field504 + this.field500) {
            break;
         }

         return false;
      case 2:
         if(var1 < this.field504 - this.field500 / 2 || var1 > this.field500 / 2 + this.field504) {
            return false;
         }
      }

      switch(var3.field3349.field3338) {
      case 0:
         if(var2 > this.field505 - this.field502 && var2 <= this.field505) {
            break;
         }

         return false;
      case 1:
         if(var2 < this.field505 || var2 >= this.field505 + this.field502) {
            return false;
         }
         break;
      case 2:
         if(var2 < this.field505 - this.field502 / 2 || var2 > this.field502 / 2 + this.field505) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1374565747"
   )
   boolean method585(int var1, int var2) {
      return this.field503 == null?false:(var1 >= this.field504 - this.field503.field448 / 2 && var1 <= this.field503.field448 / 2 + this.field504?var2 >= this.field505 && var2 <= this.field503.field445 + this.field505:false);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "805954721"
   )
   @Export("ilog")
   public static int ilog(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BIILec;[Lfa;I)V",
      garbageValue = "-1468769940"
   )
   static final void method593(byte[] var0, int var1, int var2, Region var3, CollisionData[] var4) {
      Buffer var5 = new Buffer(var0);
      int var6 = -1;

      while(true) {
         int var7 = var5.getUSmart();
         if(var7 == 0) {
            return;
         }

         var6 += var7;
         int var8 = 0;

         while(true) {
            int var9 = var5.getUSmart();
            if(var9 == 0) {
               break;
            }

            var8 += var9 - 1;
            int var10 = var8 & 63;
            int var11 = var8 >> 6 & 63;
            int var12 = var8 >> 12;
            int var13 = var5.readUnsignedByte();
            int var14 = var13 >> 2;
            int var15 = var13 & 3;
            int var16 = var11 + var1;
            int var17 = var10 + var2;
            if(var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
               int var18 = var12;
               if((class61.tileSettings[1][var16][var17] & 2) == 2) {
                  var18 = var12 - 1;
               }

               CollisionData var19 = null;
               if(var18 >= 0) {
                  var19 = var4[var18];
               }

               class153.addObject(var12, var16, var17, var6, var15, var14, var3, var19);
            }
         }
      }
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-806629679"
   )
   static final void method586(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class56.region.method2814(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class56.region.method2912(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = field507.pixels;
         var11 = var1 * 4 + (103 - var2) * 2048 + 24624;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = class24.getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            IndexedSprite var14 = BuildType.mapscene[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var13.sizeY * 4 - var14.height) / 2;
               var14.method5246(var15 + var1 * 4 + 48, var16 + (104 - var2 - var13.sizeY) * 4 + 48);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class56.region.method2851(var0, var1, var2);
      if(var5 != 0) {
         var6 = class56.region.method2912(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = class24.getObjectDefinition(var9);
         int var18;
         if(var23.mapSceneId != -1) {
            IndexedSprite var17 = BuildType.mapscene[var23.mapSceneId];
            if(var17 != null) {
               var12 = (var23.sizeX * 4 - var17.originalWidth) / 2;
               var18 = (var23.sizeY * 4 - var17.height) / 2;
               var17.method5246(var12 + var1 * 4 + 48, (104 - var2 - var23.sizeY) * 4 + var18 + 48);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = field507.pixels;
            var18 = var1 * 4 + (103 - var2) * 2048 + 24624;
            if(var7 != 0 && var7 != 2) {
               var22[var18] = var11;
               var22[var18 + 1 + 512] = var11;
               var22[var18 + 1024 + 2] = var11;
               var22[var18 + 1536 + 3] = var11;
            } else {
               var22[var18 + 1536] = var11;
               var22[var18 + 1 + 1024] = var11;
               var22[var18 + 512 + 2] = var11;
               var22[var18 + 3] = var11;
            }
         }
      }

      var5 = class56.region.method2942(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var19 = class24.getObjectDefinition(var6);
         if(var19.mapSceneId != -1) {
            IndexedSprite var20 = BuildType.mapscene[var19.mapSceneId];
            if(var20 != null) {
               var9 = (var19.sizeX * 4 - var20.originalWidth) / 2;
               int var21 = (var19.sizeY * 4 - var20.height) / 2;
               var20.method5246(var1 * 4 + var9 + 48, (104 - var2 - var19.sizeY) * 4 + var21 + 48);
            }
         }
      }

   }
}
