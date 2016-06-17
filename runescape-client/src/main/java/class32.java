import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class32 {
   @ObfuscatedName("l")
   static int[] field734 = new int[2048];
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1439415645
   )
   static int field735 = 0;
   @ObfuscatedName("d")
   static byte[] field736 = new byte[2048];
   @ObfuscatedName("x")
   static class119[] field737 = new class119[2048];
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 726683621
   )
   static int field738 = 0;
   @ObfuscatedName("r")
   static int[] field739 = new int[2048];
   @ObfuscatedName("k")
   static class119 field740 = new class119(new byte[5000]);
   @ObfuscatedName("u")
   static int[] field741 = new int[2048];
   @ObfuscatedName("p")
   static int[] field743 = new int[2048];
   @ObfuscatedName("n")
   static int[] field744 = new int[2048];
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1561423231
   )
   static int field745 = 0;
   @ObfuscatedName("z")
   static int[] field746 = new int[2048];
   @ObfuscatedName("j")
   static byte[] field748 = new byte[2048];

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)Lclass43;",
      garbageValue = "0"
   )
   public static class43 method708(int var0) {
      class43 var1 = (class43)class43.field984.method3764((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class43.field1001.method3266(13, var0);
         var1 = new class43();
         var1.field988 = var0;
         if(var2 != null) {
            var1.method911(new class119(var2));
         }

         class43.field984.method3759(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-50"
   )
   static void method711(int var0) {
      if(var0 != -1) {
         if(class84.method1909(var0)) {
            class173[] var1 = class173.field2750[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               class173 var3 = var1[var2];
               if(null != var3.field2829) {
                  class0 var4 = new class0();
                  var4.field10 = var3;
                  var4.field12 = var3.field2829;
                  class90.method2092(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIILclass107;Lclass108;I)Z",
      garbageValue = "396448047"
   )
   public static final boolean method718(int var0, int var1, int var2, class107 var3, class108 var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class106.field1853[var7][var8] = 99;
      class106.field1851[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class106.field1856[var11] = var0;
      int var20 = var11 + 1;
      class106.field1857[var11] = var1;
      int[][] var13 = var4.field1884;

      while(true) {
         label357:
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
                     label334:
                     do {
                        if(var20 == var12) {
                           class15.field219 = var5;
                           class45.field1023 = var6;
                           return false;
                        }

                        var5 = class106.field1856[var12];
                        var6 = class106.field1857[var12];
                        var12 = 1 + var12 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.field1880;
                        var15 = var6 - var4.field1873;
                        if(var3.vmethod2385(var2, var5, var6, var4)) {
                           class15.field219 = var5;
                           class45.field1023 = var6;
                           return true;
                        }

                        var16 = 1 + class106.field1851[var18][var19];
                        if(var18 > 0 && class106.field1853[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class106.field1856[var20] = var5 - 1;
                                 class106.field1857[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class106.field1853[var18 - 1][var19] = 2;
                                 class106.field1851[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var15 + var17] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class106.field1853[1 + var18][var19] == 0 && (var13[var14 + var2][var15] & 19136899) == 0 && (var13[var14 + var2][var2 + var15 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class106.field1856[var20] = var5 + 1;
                                 class106.field1857[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class106.field1853[1 + var18][var19] = 8;
                                 class106.field1851[1 + var18][var19] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var17 + var15] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class106.field1853[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var2 + var14 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class106.field1856[var20] = var5;
                                 class106.field1857[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class106.field1853[var18][var19 - 1] = 1;
                                 class106.field1851[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class106.field1853[var18][1 + var19] == 0 && (var13[var14][var15 + var2] & 19136824) == 0 && (var13[var14 + var2 - 1][var15 + var2] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class106.field1856[var20] = var5;
                                 class106.field1857[var20] = 1 + var6;
                                 var20 = 1 + var20 & 4095;
                                 class106.field1853[var18][1 + var19] = 4;
                                 class106.field1851[var18][var19 + 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 + var2] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class106.field1853[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class106.field1856[var20] = var5 - 1;
                                 class106.field1857[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class106.field1853[var18 - 1][var19 - 1] = 3;
                                 class106.field1851[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + (var15 - 1)] & 19136830) != 0 || (var13[var14 - 1 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class106.field1853[var18 + 1][var19 - 1] == 0 && (var13[var2 + var14][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class106.field1856[var20] = var5 + 1;
                                 class106.field1857[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class106.field1853[1 + var18][var19 - 1] = 9;
                                 class106.field1851[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var2 + var14][var15 - 1 + var17] & 19136995) != 0 || (var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class106.field1853[var18 - 1][var19 + 1] == 0 && (var13[var14 - 1][var2 + var15] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var2 + var15] & 19137016) != 0) {
                                 continue label334;
                              }
                           }

                           class106.field1856[var20] = var5 - 1;
                           class106.field1857[var20] = var6 + 1;
                           var20 = var20 + 1 & 4095;
                           class106.field1853[var18 - 1][1 + var19] = 6;
                           class106.field1851[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class106.field1853[1 + var18][1 + var19] != 0);
            } while((var13[var14 + var2][var2 + var15] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var14 + var17][var2 + var15] & 19137016) != 0 || (var13[var2 + var14][var17 + var15] & 19136995) != 0) {
                  continue label357;
               }
            }

            class106.field1856[var20] = var5 + 1;
            class106.field1857[var20] = 1 + var6;
            var20 = var20 + 1 & 4095;
            class106.field1853[var18 + 1][1 + var19] = 12;
            class106.field1851[var18 + 1][1 + var19] = var16;
         }
      }
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-16"
   )
   static final void method720(int var0, int var1) {
      if(class84.method1909(var0)) {
         class31.method705(class173.field2750[var0], var1);
      }
   }
}
