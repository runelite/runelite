import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
@Implements("XClanMember")
public class class25 extends class211 {
   @ObfuscatedName("l")
   public static class170 field628;
   @ObfuscatedName("w")
   String field629;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1260920201
   )
   @Export("world")
   int field630;
   @ObfuscatedName("m")
   @Export("username")
   String field631;
   @ObfuscatedName("dk")
   static byte[][] field632;
   @ObfuscatedName("o")
   @Export("rank")
   byte field634;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1662970884"
   )
   public static void method594() {
      try {
         if(class186.field3004 == 1) {
            int var0 = class186.field3007.method3654();
            if(var0 > 0 && class186.field3007.method3660()) {
               var0 -= class186.field3010;
               if(var0 < 0) {
                  var0 = 0;
               }

               class186.field3007.method3653(var0);
               return;
            }

            class186.field3007.method3750();
            class186.field3007.method3769();
            if(null != class128.field2089) {
               class186.field3004 = 2;
            } else {
               class186.field3004 = 0;
            }

            class10.field152 = null;
            class138.field2137 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class186.field3007.method3750();
         class186.field3004 = 0;
         class10.field152 = null;
         class138.field2137 = null;
         class128.field2089 = null;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIILclass110;Lclass111;I)Z",
      garbageValue = "-661375071"
   )
   static final boolean method595(int var0, int var1, int var2, class110 var3, class111 var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class109.field1936[var7][var8] = 99;
      class109.field1930[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class109.field1933[var11] = var0;
      int var20 = var11 + 1;
      class109.field1927[var11] = var1;
      int[][] var13 = var4.field1954;

      while(true) {
         label349:
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
                     label326:
                     do {
                        if(var20 == var12) {
                           class109.field1934 = var5;
                           class109.field1932 = var6;
                           return false;
                        }

                        var5 = class109.field1933[var12];
                        var6 = class109.field1927[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.field1951;
                        var15 = var6 - var4.field1952;
                        if(var3.vmethod2446(var2, var5, var6, var4)) {
                           class109.field1934 = var5;
                           class109.field1932 = var6;
                           return true;
                        }

                        var16 = 1 + class109.field1930[var18][var19];
                        if(var18 > 0 && class109.field1936[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var2 + var15 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1933[var20] = var5 - 1;
                                 class109.field1927[var20] = var6;
                                 var20 = 1 + var20 & 4095;
                                 class109.field1936[var18 - 1][var19] = 2;
                                 class109.field1930[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var15 + var17] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class109.field1936[1 + var18][var19] == 0 && (var13[var2 + var14][var15] & 19136899) == 0 && (var13[var14 + var2][var2 + var15 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1933[var20] = var5 + 1;
                                 class109.field1927[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1936[1 + var18][var19] = 8;
                                 class109.field1930[var18 + 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class109.field1936[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1933[var20] = var5;
                                 class109.field1927[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1936[var18][var19 - 1] = 1;
                                 class109.field1930[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class109.field1936[var18][var19 + 1] == 0 && (var13[var14][var15 + var2] & 19136824) == 0 && (var13[var2 + var14 - 1][var15 + var2] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1933[var20] = var5;
                                 class109.field1927[var20] = 1 + var6;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1936[var18][var19 + 1] = 4;
                                 class109.field1930[var18][1 + var19] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var2 + var15] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class109.field1936[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class109.field1933[var20] = var5 - 1;
                                 class109.field1927[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class109.field1936[var18 - 1][var19 - 1] = 3;
                                 class109.field1930[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var15 - 1 + var17] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class109.field1936[1 + var18][var19 - 1] == 0 && (var13[var14 + var2][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class109.field1933[var20] = var5 + 1;
                                 class109.field1927[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1936[var18 + 1][var19 - 1] = 9;
                                 class109.field1930[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var17 + (var15 - 1)] & 19136995) != 0 || (var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class109.field1936[var18 - 1][var19 + 1] == 0 && (var13[var14 - 1][var2 + var15] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0 || (var13[var14 - 1 + var17][var2 + var15] & 19137016) != 0) {
                                 continue label326;
                              }
                           }

                           class109.field1933[var20] = var5 - 1;
                           class109.field1927[var20] = 1 + var6;
                           var20 = var20 + 1 & 4095;
                           class109.field1936[var18 - 1][1 + var19] = 6;
                           class109.field1930[var18 - 1][1 + var19] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class109.field1936[1 + var18][1 + var19] != 0);
            } while((var13[var2 + var14][var15 + var2] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var14 + var17][var2 + var15] & 19137016) != 0 || (var13[var2 + var14][var17 + var15] & 19136995) != 0) {
                  continue label349;
               }
            }

            class109.field1933[var20] = 1 + var5;
            class109.field1927[var20] = 1 + var6;
            var20 = 1 + var20 & 4095;
            class109.field1936[1 + var18][1 + var19] = 12;
            class109.field1930[var18 + 1][var19 + 1] = var16;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIIII[Lclass111;I)V",
      garbageValue = "2126990767"
   )
   static final void method596(byte[] var0, int var1, int var2, int var3, int var4, class111[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var1 + var7 > 0 && var1 + var7 < 103 && var2 + var8 > 0 && var2 + var8 < 103) {
                  var5[var6].field1954[var7 + var1][var2 + var8] &= -16777217;
               }
            }
         }
      }

      class122 var10 = new class122(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               class181.method3534(var10, var7, var1 + var8, var2 + var9, var3, var4, 0);
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "12"
   )
   public static boolean method597(int var0) {
      return (var0 >> 30 & 1) != 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass139;Ljava/awt/Component;IIB)Lclass59;",
      garbageValue = "2"
   )
   public static final class59 method598(class139 var0, Component var1, int var2, int var3) {
      if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class72 var4 = new class72();
            var4.field1251 = new int[(class59.field1247?2:1) * 256];
            var4.field1260 = var3;
            var4.vmethod1596(var1);
            var4.field1253 = 1024 + (var3 & -1024);
            if(var4.field1253 > 16384) {
               var4.field1253 = 16384;
            }

            var4.vmethod1601(var4.field1253);
            if(class59.field1262 > 0 && class59.field1249 == null) {
               class59.field1249 = new class75();
               class59.field1249.field1425 = var0;
               var0.method2937(class59.field1249, class59.field1262);
            }

            if(null != class59.field1249) {
               if(null != class59.field1249.field1422[var2]) {
                  throw new IllegalArgumentException();
               }

               class59.field1249.field1422[var2] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class59();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "19205"
   )
   public static int method599(int var0) {
      return var0 >> 11 & 63;
   }
}
