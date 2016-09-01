import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public final class class5 {
   @ObfuscatedName("r")
   @Export("tileSettings")
   static byte[][][] tileSettings = new byte[4][104][104];
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1657428305
   )
   static int field73 = 99;
   @ObfuscatedName("p")
   static int[][] field74;
   @ObfuscatedName("b")
   static byte[][][] field75;
   @ObfuscatedName("l")
   static byte[][][] field76;
   @ObfuscatedName("n")
   static final int[] field77 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("d")
   static int[] field78;
   @ObfuscatedName("v")
   static int[] field79;
   @ObfuscatedName("a")
   static final int[] field82 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("e")
   static final int[] field83 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("c")
   static final int[] field84 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("z")
   static byte[][][] field85;
   @ObfuscatedName("nl")
   @ObfuscatedGetter(
      intValue = 218925299
   )
   static int field86;
   @ObfuscatedName("k")
   static final int[] field87 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -596899693
   )
   static int field88 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 824829095
   )
   static int field89 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("y")
   static final int[] field90 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("ke")
   static class134 field91;
   @ObfuscatedName("bf")
   static ModIcon[] field92;
   @ObfuscatedName("x")
   @Export("tileHeights")
   static int[][][] tileHeights = new int[4][105][105];

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass178;I)V",
      garbageValue = "1257348434"
   )
   static final void method63(int var0, int var1, int var2, int var3, SpritePixels var4, class178 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle + Client.mapScale & 2047;
         int var8 = class94.field1639[var7];
         int var9 = class94.field1640[var7];
         var8 = var8 * 256 / (Client.mapScaleDelta + 256);
         var9 = var9 * 256 / (256 + Client.mapScaleDelta);
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var9 * var3 - var2 * var8 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class77.field1412.method1752(4 + var14 + 94 + var0 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         Sequence.method883(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1313516320"
   )
   static void method80() {
      FileOnDisk var0 = null;

      try {
         var0 = DecorativeObject.method2222("", class35.field775.field2339, true);
         Buffer var1 = class161.field2659.method114();
         var0.method4135(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method4136();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([Lclass115;II)Lclass115;",
      garbageValue = "-12788372"
   )
   public static class115 method98(class115[] var0, int var1) {
      class115[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class115 var4 = var2[var3];
         if(var1 == var4.vmethod3206()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIILclass110;LCollisionData;B)Z",
      garbageValue = "63"
   )
   static final boolean method99(int var0, int var1, int var2, class110 var3, CollisionData var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class109.field1923[var7][var8] = 99;
      class109.field1924[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class109.field1925[var11] = var0;
      int var20 = var11 + 1;
      class109.field1926[var11] = var1;
      int[][] var13 = var4.flags;

      while(true) {
         label351:
         while(true) {
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            do {
               do {
                  do {
                     label328:
                     do {
                        if(var20 == var12) {
                           FileOnDisk.field3259 = var5;
                           class167.field2722 = var6;
                           return false;
                        }

                        var5 = class109.field1925[var12];
                        var6 = class109.field1926[var12];
                        var12 = 1 + var12 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.x;
                        var15 = var6 - var4.y;
                        if(var3.vmethod2439(var2, var5, var6, var4)) {
                           FileOnDisk.field3259 = var5;
                           class167.field2722 = var6;
                           return true;
                        }

                        var16 = class109.field1924[var18][var19] + 1;
                        if(var18 > 0 && class109.field1923[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var2 + var15 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1925[var20] = var5 - 1;
                                 class109.field1926[var20] = var6;
                                 var20 = 1 + var20 & 4095;
                                 class109.field1923[var18 - 1][var19] = 2;
                                 class109.field1924[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class109.field1923[var18 + 1][var19] == 0 && (var13[var14 + var2][var15] & 19136899) == 0 && (var13[var14 + var2][var2 + var15 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1925[var20] = 1 + var5;
                                 class109.field1926[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1923[var18 + 1][var19] = 8;
                                 class109.field1924[var18 + 1][var19] = var16;
                                 break;
                              }

                              if((var13[var2 + var14][var15 + var17] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class109.field1923[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1925[var20] = var5;
                                 class109.field1926[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1923[var18][var19 - 1] = 1;
                                 class109.field1924[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class109.field1923[var18][1 + var19] == 0 && (var13[var14][var15 + var2] & 19136824) == 0 && (var13[var14 + var2 - 1][var2 + var15] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1925[var20] = var5;
                                 class109.field1926[var20] = 1 + var6;
                                 var20 = 1 + var20 & 4095;
                                 class109.field1923[var18][1 + var19] = 4;
                                 class109.field1924[var18][var19 + 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var2 + var15] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class109.field1923[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class109.field1925[var20] = var5 - 1;
                                 class109.field1926[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1923[var18 - 1][var19 - 1] = 3;
                                 class109.field1924[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var15 - 1 + var17] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class109.field1923[1 + var18][var19 - 1] == 0 && (var13[var2 + var14][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class109.field1925[var20] = var5 + 1;
                                 class109.field1926[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class109.field1923[1 + var18][var19 - 1] = 9;
                                 class109.field1924[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var15 - 1 + var17] & 19136995) != 0 || (var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class109.field1923[var18 - 1][var19 + 1] == 0 && (var13[var14 - 1][var15 + var2] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var15 + var17] & 19136830) != 0 || (var13[var14 - 1 + var17][var15 + var2] & 19137016) != 0) {
                                 continue label328;
                              }
                           }

                           class109.field1925[var20] = var5 - 1;
                           class109.field1926[var20] = 1 + var6;
                           var20 = var20 + 1 & 4095;
                           class109.field1923[var18 - 1][var19 + 1] = 6;
                           class109.field1924[var18 - 1][1 + var19] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class109.field1923[1 + var18][var19 + 1] != 0);
            } while((var13[var14 + var2][var2 + var15] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var14 + var17][var2 + var15] & 19137016) != 0 || (var13[var14 + var2][var17 + var15] & 19136995) != 0) {
                  continue label351;
               }
            }

            class109.field1925[var20] = 1 + var5;
            class109.field1926[var20] = 1 + var6;
            var20 = 1 + var20 & 4095;
            class109.field1923[var18 + 1][var19 + 1] = 12;
            class109.field1924[var18 + 1][var19 + 1] = var16;
         }
      }
   }
}
