import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class38 {
   @ObfuscatedName("j")
   static class14[] field818 = new class14[50];
   @ObfuscatedName("e")
   static int[] field819;
   @ObfuscatedName("g")
   static String[] field820;
   @ObfuscatedName("n")
   static int[] field821 = new int[5];
   @ObfuscatedName("u")
   static int[][] field822 = new int[5][5000];
   @ObfuscatedName("l")
   @Export("chatboxSegments")
   static String[] chatboxSegments = new String[1000];
   @ObfuscatedName("v")
   static final String[] field825 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = 1167682739
   )
   static int field826;
   @ObfuscatedName("y")
   static Widget field827;
   @ObfuscatedName("p")
   static Calendar field828 = Calendar.getInstance();
   @ObfuscatedName("d")
   static int[] field829 = new int[1000];
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -391538763
   )
   static int field830 = 0;
   @ObfuscatedName("pn")
   @ObfuscatedGetter(
      longValue = -8200622243770225463L
   )
   static long field831;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1940982965
   )
   static int field832 = 0;
   @ObfuscatedName("rq")
   protected static boolean field833;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIILclass110;LCollisionData;B)Z",
      garbageValue = "2"
   )
   public static final boolean method772(int var0, int var1, int var2, class110 var3, CollisionData var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class109.field1930[var7][var8] = 99;
      class109.field1924[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class109.field1927[var11] = var0;
      int var20 = var11 + 1;
      class109.field1928[var11] = var1;
      int[][] var13 = var4.flags;

      while(true) {
         label345:
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
                     label322:
                     do {
                        if(var12 == var20) {
                           class109.field1921 = var5;
                           class109.field1923 = var6;
                           return false;
                        }

                        var5 = class109.field1927[var12];
                        var6 = class109.field1928[var12];
                        var12 = 1 + var12 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.x;
                        var15 = var6 - var4.y;
                        if(var3.vmethod2413(var2, var5, var6, var4)) {
                           class109.field1921 = var5;
                           class109.field1923 = var6;
                           return true;
                        }

                        var16 = class109.field1924[var18][var19] + 1;
                        if(var18 > 0 && class109.field1930[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1927[var20] = var5 - 1;
                                 class109.field1928[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1930[var18 - 1][var19] = 2;
                                 class109.field1924[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class109.field1930[1 + var18][var19] == 0 && (var13[var2 + var14][var15] & 19136899) == 0 && (var13[var14 + var2][var15 + var2 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1927[var20] = 1 + var5;
                                 class109.field1928[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1930[1 + var18][var19] = 8;
                                 class109.field1924[var18 + 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class109.field1930[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var2 + var14 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1927[var20] = var5;
                                 class109.field1928[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1930[var18][var19 - 1] = 1;
                                 class109.field1924[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class109.field1930[var18][1 + var19] == 0 && (var13[var14][var2 + var15] & 19136824) == 0 && (var13[var2 + var14 - 1][var2 + var15] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1927[var20] = var5;
                                 class109.field1928[var20] = 1 + var6;
                                 var20 = 1 + var20 & 4095;
                                 class109.field1930[var18][var19 + 1] = 4;
                                 class109.field1924[var18][var19 + 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 + var2] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class109.field1930[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class109.field1927[var20] = var5 - 1;
                                 class109.field1928[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class109.field1930[var18 - 1][var19 - 1] = 3;
                                 class109.field1924[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var15 - 1 + var17] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class109.field1930[var18 + 1][var19 - 1] == 0 && (var13[var2 + var14][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class109.field1927[var20] = var5 + 1;
                                 class109.field1928[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1930[var18 + 1][var19 - 1] = 9;
                                 class109.field1924[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var17 + (var15 - 1)] & 19136995) != 0 || (var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class109.field1930[var18 - 1][1 + var19] == 0 && (var13[var14 - 1][var15 + var2] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var15 + var17] & 19136830) != 0 || (var13[var14 - 1 + var17][var2 + var15] & 19137016) != 0) {
                                 continue label322;
                              }
                           }

                           class109.field1927[var20] = var5 - 1;
                           class109.field1928[var20] = 1 + var6;
                           var20 = 1 + var20 & 4095;
                           class109.field1930[var18 - 1][var19 + 1] = 6;
                           class109.field1924[var18 - 1][1 + var19] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class109.field1930[var18 + 1][1 + var19] != 0);
            } while((var13[var14 + var2][var15 + var2] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var17 + var14][var2 + var15] & 19137016) != 0 || (var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                  continue label345;
               }
            }

            class109.field1927[var20] = 1 + var5;
            class109.field1928[var20] = 1 + var6;
            var20 = 1 + var20 & 4095;
            class109.field1930[var18 + 1][var19 + 1] = 12;
            class109.field1924[var18 + 1][1 + var19] = var16;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "21"
   )
   public static int method779(int var0) {
      return var0 >> 17 & 7;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "86"
   )
   static final int method780(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
