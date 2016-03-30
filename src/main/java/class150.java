import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ec")
public final class class150 {
   @ObfuscatedName("n")
   static class13 field2275;

   @ObfuscatedName("x")
   public static final boolean method3170(int var0, int var1, int var2, class107 var3, class108 var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class106.field1877[var7][var8] = 99;
      class106.field1878[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class106.field1881[var11] = var0;
      int var20 = var11 + 1;
      class106.field1879[var11] = var1;
      int[][] var13 = var4.field1894;

      while(true) {
         label353:
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
                     label330:
                     do {
                        if(var12 == var20) {
                           class106.field1876 = var5;
                           class131.field2071 = var6;
                           return false;
                        }

                        var5 = class106.field1881[var12];
                        var6 = class106.field1879[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.field1902;
                        var15 = var6 - var4.field1903;
                        if(var3.vmethod2389(var5, var6)) {
                           class106.field1876 = var5;
                           class131.field2071 = var6;
                           return true;
                        }

                        var16 = class106.field1878[var18][var19] + 1;
                        if(var18 > 0 && class106.field1877[var18 - 1][var19] == 0 && 0 == (var13[var14 - 1][var15] & 19136782) && (var13[var14 - 1][var2 + var15 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class106.field1881[var20] = var5 - 1;
                                 class106.field1879[var20] = var6;
                                 var20 = 1 + var20 & 4095;
                                 class106.field1877[var18 - 1][var19] = 2;
                                 class106.field1878[var18 - 1][var19] = var16;
                                 break;
                              }

                              if(0 != (var13[var14 - 1][var17 + var15] & 19136830)) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && 0 == class106.field1877[1 + var18][var19] && (var13[var2 + var14][var15] & 19136899) == 0 && 0 == (var13[var2 + var14][var2 + var15 - 1] & 19136992)) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class106.field1881[var20] = var5 + 1;
                                 class106.field1879[var20] = var6;
                                 var20 = 1 + var20 & 4095;
                                 class106.field1877[1 + var18][var19] = 8;
                                 class106.field1878[1 + var18][var19] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var17 + var15] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && 0 == class106.field1877[var18][var19 - 1] && 0 == (var13[var14][var15 - 1] & 19136782) && 0 == (var13[var2 + var14 - 1][var15 - 1] & 19136899)) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class106.field1881[var20] = var5;
                                 class106.field1879[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class106.field1877[var18][var19 - 1] = 1;
                                 class106.field1878[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class106.field1877[var18][var19 + 1] == 0 && 0 == (var13[var14][var15 + var2] & 19136824) && 0 == (var13[var2 + var14 - 1][var15 + var2] & 19136992)) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class106.field1881[var20] = var5;
                                 class106.field1879[var20] = var6 + 1;
                                 var20 = 1 + var20 & 4095;
                                 class106.field1877[var18][1 + var19] = 4;
                                 class106.field1878[var18][var19 + 1] = var16;
                                 break;
                              }

                              if(0 != (var13[var17 + var14][var15 + var2] & 19137016)) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class106.field1877[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class106.field1881[var20] = var5 - 1;
                                 class106.field1879[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class106.field1877[var18 - 1][var19 - 1] = 3;
                                 class106.field1878[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var15 - 1 + var17] & 19136830) != 0 || (var13[var14 - 1 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class106.field1877[1 + var18][var19 - 1] == 0 && 0 == (var13[var2 + var14][var15 - 1] & 19136899)) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class106.field1881[var20] = 1 + var5;
                                 class106.field1879[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class106.field1877[1 + var18][var19 - 1] = 9;
                                 class106.field1878[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var2 + var14][var17 + (var15 - 1)] & 19136995) != 0 || (var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && 0 == class106.field1877[var18 - 1][1 + var19] && 0 == (var13[var14 - 1][var2 + var15] & 19136824)) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if(0 != (var13[var14 - 1][var17 + var15] & 19136830) || (var13[var14 - 1 + var17][var15 + var2] & 19137016) != 0) {
                                 continue label330;
                              }
                           }

                           class106.field1881[var20] = var5 - 1;
                           class106.field1879[var20] = var6 + 1;
                           var20 = 1 + var20 & 4095;
                           class106.field1877[var18 - 1][1 + var19] = 6;
                           class106.field1878[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class106.field1877[1 + var18][var19 + 1] != 0);
            } while(0 != (var13[var14 + var2][var15 + var2] & 19136992));

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var17 + var14][var15 + var2] & 19137016) != 0 || (var13[var14 + var2][var17 + var15] & 19136995) != 0) {
                  continue label353;
               }
            }

            class106.field1881[var20] = 1 + var5;
            class106.field1879[var20] = var6 + 1;
            var20 = var20 + 1 & 4095;
            class106.field1877[var18 + 1][var19 + 1] = 12;
            class106.field1878[1 + var18][var19 + 1] = var16;
         }
      }
   }
}
