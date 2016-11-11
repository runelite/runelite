import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class50 extends CacheableNode {
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      intValue = -782116327
   )
   static int field1093;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1995807191
   )
   public int field1094;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 519814945
   )
   public int field1095;
   @ObfuscatedName("i")
   static class170 field1096;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1853149859
   )
   public int field1097;
   @ObfuscatedName("h")
   static NodeCache field1098 = new NodeCache(64);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass215;B)I",
      garbageValue = "88"
   )
   static final int method1021(class215 var0) {
      if(var0 == null) {
         return 12;
      } else {
         switch(var0.field3195) {
         case 6:
            return 20;
         default:
            return 12;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1956655237"
   )
   void method1022(Buffer var1) {
      while(true) {
         int var2 = var1.method2544();
         if(var2 == 0) {
            return;
         }

         this.method1023(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1855755051"
   )
   void method1023(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1095 = var1.method2546();
         this.field1094 = var1.method2544();
         this.field1097 = var1.method2544();
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(LActor;B)V",
      garbageValue = "55"
   )
   static final void method1032(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.field889 == 0) {
         var0.field893 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var1 = class192.getAnimation(var0.animation);
            if(var0.field894 > 0 && var1.precedenceAnimating == 0) {
               ++var0.field893;
               return;
            }

            if(var0.field894 <= 0 && var1.field1023 == 0) {
               ++var0.field893;
               return;
            }
         }

         int var10 = var0.x;
         int var2 = var0.y;
         int var3 = 128 * var0.pathX[var0.field889 - 1] + var0.field839 * 64;
         int var4 = 128 * var0.pathY[var0.field889 - 1] + var0.field839 * 64;
         if(var10 < var3) {
            if(var2 < var4) {
               var0.field886 = 1280;
            } else if(var2 > var4) {
               var0.field886 = 1792;
            } else {
               var0.field886 = 1536;
            }
         } else if(var10 > var3) {
            if(var2 < var4) {
               var0.field886 = 768;
            } else if(var2 > var4) {
               var0.field886 = 256;
            } else {
               var0.field886 = 512;
            }
         } else if(var2 < var4) {
            var0.field886 = 1024;
         } else if(var2 > var4) {
            var0.field886 = 0;
         }

         byte var5 = var0.field850[var0.field889 - 1];
         if(var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.field886 - var0.angle & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field844;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field859;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field846;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field845;
            }

            if(var7 == -1) {
               var7 = var0.field859;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.angle != var0.field886 && var0.interacting == -1 && var0.field888 != 0) {
                  var8 = 2;
               }

               if(var0.field889 > 2) {
                  var8 = 6;
               }

               if(var0.field889 > 3) {
                  var8 = 8;
               }

               if(var0.field893 > 0 && var0.field889 > 1) {
                  var8 = 8;
                  --var0.field893;
               }
            } else {
               if(var0.field889 > 1) {
                  var8 = 6;
               }

               if(var0.field889 > 2) {
                  var8 = 8;
               }

               if(var0.field893 > 0 && var0.field889 > 1) {
                  var8 = 8;
                  --var0.field893;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.field859 == var0.poseAnimation && var0.field843 != -1) {
               var0.poseAnimation = var0.field843;
            }

            if(var3 != var10 || var2 != var4) {
               if(var10 < var3) {
                  var0.x += var8;
                  if(var0.x > var3) {
                     var0.x = var3;
                  }
               } else if(var10 > var3) {
                  var0.x -= var8;
                  if(var0.x < var3) {
                     var0.x = var3;
                  }
               }

               if(var2 < var4) {
                  var0.y += var8;
                  if(var0.y > var4) {
                     var0.y = var4;
                  }
               } else if(var2 > var4) {
                  var0.y -= var8;
                  if(var0.y < var4) {
                     var0.y = var4;
                  }
               }
            }

            if(var3 == var0.x && var4 == var0.y) {
               --var0.field889;
               if(var0.field894 > 0) {
                  --var0.field894;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.field889;
            if(var0.field894 > 0) {
               --var0.field894;
            }

         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IILclass110;LCollisionData;B)Z",
      garbageValue = "0"
   )
   public static final boolean method1033(int var0, int var1, class110 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class109.field1930[var6][var7] = 99;
      class109.field1924[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class109.field1927[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class109.field1928[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var11 != var18) {
         var4 = class109.field1927[var11];
         var5 = class109.field1928[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod2413(1, var4, var5, var3)) {
            class109.field1921 = var4;
            class109.field1923 = var5;
            return true;
         }

         int var15 = class109.field1924[var16][var17] + 1;
         if(var16 > 0 && class109.field1930[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class109.field1927[var18] = var4 - 1;
            class109.field1928[var18] = var5;
            var18 = 1 + var18 & 4095;
            class109.field1930[var16 - 1][var17] = 2;
            class109.field1924[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class109.field1930[1 + var16][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
            class109.field1927[var18] = 1 + var4;
            class109.field1928[var18] = var5;
            var18 = var18 + 1 & 4095;
            class109.field1930[var16 + 1][var17] = 8;
            class109.field1924[1 + var16][var17] = var15;
         }

         if(var17 > 0 && class109.field1930[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class109.field1927[var18] = var4;
            class109.field1928[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class109.field1930[var16][var17 - 1] = 1;
            class109.field1924[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && class109.field1930[var16][var17 + 1] == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class109.field1927[var18] = var4;
            class109.field1928[var18] = 1 + var5;
            var18 = var18 + 1 & 4095;
            class109.field1930[var16][1 + var17] = 4;
            class109.field1924[var16][1 + var17] = var15;
         }

         if(var16 > 0 && var17 > 0 && class109.field1930[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class109.field1927[var18] = var4 - 1;
            class109.field1928[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class109.field1930[var16 - 1][var17 - 1] = 3;
            class109.field1924[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && class109.field1930[1 + var16][var17 - 1] == 0 && (var12[1 + var13][var14 - 1] & 19136899) == 0 && (var12[1 + var13][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class109.field1927[var18] = 1 + var4;
            class109.field1928[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class109.field1930[var16 + 1][var17 - 1] = 9;
            class109.field1924[1 + var16][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && class109.field1930[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][1 + var14] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][1 + var14] & 19136800) == 0) {
            class109.field1927[var18] = var4 - 1;
            class109.field1928[var18] = 1 + var5;
            var18 = var18 + 1 & 4095;
            class109.field1930[var16 - 1][var17 + 1] = 6;
            class109.field1924[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 127 && var17 < 127 && class109.field1930[var16 + 1][1 + var17] == 0 && (var12[1 + var13][var14 + 1] & 19136992) == 0 && (var12[1 + var13][var14] & 19136896) == 0 && (var12[var13][1 + var14] & 19136800) == 0) {
            class109.field1927[var18] = 1 + var4;
            class109.field1928[var18] = var5 + 1;
            var18 = 1 + var18 & 4095;
            class109.field1930[var16 + 1][var17 + 1] = 12;
            class109.field1924[var16 + 1][1 + var17] = var15;
         }
      }

      class109.field1921 = var4;
      class109.field1923 = var5;
      return false;
   }
}
