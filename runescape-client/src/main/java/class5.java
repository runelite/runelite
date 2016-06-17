import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public final class class5 {
   @ObfuscatedName("a")
   static final int[] field68 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("g")
   @Export("tileSettings")
   static byte[][][] field69 = new byte[4][104][104];
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1375195125
   )
   static int field70 = 99;
   @ObfuscatedName("d")
   static byte[][][] field71;
   @ObfuscatedName("x")
   static byte[][][] field72;
   @ObfuscatedName("y")
   static byte[][][] field73;
   @ObfuscatedName("v")
   static final int[] field75 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("m")
   static final int[] field76 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("q")
   static final int[] field77 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -974659145
   )
   static int field78 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("s")
   static final int[] field80 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1815050909
   )
   static int field81 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("b")
   @Export("tileHeights")
   static int[][][] field83 = new int[4][105][105];
   @ObfuscatedName("ew")
   static class80[] field84;
   @ObfuscatedName("f")
   static final int[] field88 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("c")
   static byte[][][] field91;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "123"
   )
   static final void method45(int var0) {
      short var1 = 256;
      class31.field694 += 128 * var0;
      int var2;
      if(class31.field694 > class28.field673.length) {
         class31.field694 -= class28.field673.length;
         var2 = (int)(Math.random() * 12.0D);
         class150.method3153(class31.field720[var2]);
      }

      var2 = 0;
      int var3 = 128 * var0;
      int var4 = 128 * (var1 - var0);

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = class36.field788[var2 + var3] - class28.field673[class31.field694 + var2 & class28.field673.length - 1] * var0 / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         class36.field788[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = 128 * var5;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               class36.field788[var6 + var7] = 255;
            } else {
               class36.field788[var7 + var6] = 0;
            }
         }
      }

      if(class31.field725 > 0) {
         class31.field725 -= 4 * var0;
      }

      if(class31.field707 > 0) {
         class31.field707 -= 4 * var0;
      }

      if(class31.field725 == 0 && class31.field707 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class31.field725 = 1024;
         }

         if(var5 == 1) {
            class31.field707 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class31.field721[var5] = class31.field721[var0 + var5];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class31.field721[var5] = (int)(Math.sin((double)class31.field712 / 14.0D) * 16.0D + Math.sin((double)class31.field712 / 15.0D) * 14.0D + Math.sin((double)class31.field712 / 16.0D) * 12.0D);
         ++class31.field712;
      }

      class31.field710 += var0;
      var5 = ((client.field296 & 1) + var0) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class31.field710 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            class36.field788[(var8 << 7) + var7] = 192;
         }

         class31.field710 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = 128 * var6;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var5 + var9 < 128) {
                  var7 += class36.field788[var5 + var8 + var9];
               }

               if(var9 - (var5 + 1) >= 0) {
                  var7 -= class36.field788[var8 + var9 - (var5 + 1)];
               }

               if(var9 >= 0) {
                  class98.field1633[var8 + var9] = var7 / (1 + var5 * 2);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = 128 * var8;
               if(var8 + var5 < var1) {
                  var7 += class98.field1633[128 * var5 + var6 + var9];
               }

               if(var8 - (var5 + 1) >= 0) {
                  var7 -= class98.field1633[var9 + var6 - 128 * (var5 + 1)];
               }

               if(var8 >= 0) {
                  class36.field788[var9 + var6] = var7 / (var5 * 2 + 1);
               }
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass25;Lclass25;IZIZB)I",
      garbageValue = "-79"
   )
   static int method53(class25 var0, class25 var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = class35.method742(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = class35.method742(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(Lclass39;IIII)V",
      garbageValue = "1804253727"
   )
   static final void method78(class39 var0, int var1, int var2, int var3) {
      if(client.field429 < 400) {
         if(null != var0.field889) {
            var0 = var0.method773();
         }

         if(null != var0) {
            if(var0.field892) {
               if(!var0.field893 || client.field374 == var1) {
                  String var4 = var0.field864;
                  int var8;
                  if(var0.field881 != 0) {
                     int var7 = var0.field881;
                     var8 = class153.field2262.field31;
                     int var9 = var8 - var7;
                     String var6;
                     if(var9 < -9) {
                        var6 = class158.method3184(16711680);
                     } else if(var9 < -6) {
                        var6 = class158.method3184(16723968);
                     } else if(var9 < -3) {
                        var6 = class158.method3184(16740352);
                     } else if(var9 < 0) {
                        var6 = class158.method3184(16756736);
                     } else if(var9 > 9) {
                        var6 = class158.method3184('\uff00');
                     } else if(var9 > 6) {
                        var6 = class158.method3184(4259584);
                     } else if(var9 > 3) {
                        var6 = class158.method3184(8453888);
                     } else if(var9 > 0) {
                        var6 = class158.method3184(12648192);
                     } else {
                        var6 = class158.method3184(16776960);
                     }

                     var4 = var4 + var6 + " " + " (" + "level-" + var0.field881 + ")";
                  }

                  if(client.field352 == 1) {
                     class217.method3974("Use", client.field349 + " " + "->" + " " + class158.method3184(16776960) + var4, 7, var1, var2, var3);
                  } else if(client.field442) {
                     if((class138.field2115 & 2) == 2) {
                        class217.method3974(client.field445, client.field446 + " " + "->" + " " + class158.method3184(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.field879;
                     if(client.field439) {
                        var5 = class0.method1(var5);
                     }

                     int var10;
                     if(var5 != null) {
                        for(var10 = 4; var10 >= 0; --var10) {
                           if(null != var5[var10] && !var5[var10].equalsIgnoreCase("Attack")) {
                              byte var11 = 0;
                              if(var10 == 0) {
                                 var11 = 9;
                              }

                              if(var10 == 1) {
                                 var11 = 10;
                              }

                              if(var10 == 2) {
                                 var11 = 11;
                              }

                              if(var10 == 3) {
                                 var11 = 12;
                              }

                              if(var10 == 4) {
                                 var11 = 13;
                              }

                              class217.method3974(var5[var10], class158.method3184(16776960) + var4, var11, var1, var2, var3);
                           }
                        }
                     }

                     if(null != var5) {
                        for(var10 = 4; var10 >= 0; --var10) {
                           if(var5[var10] != null && var5[var10].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(client.field313 != class20.field574) {
                                 if(client.field313 == class20.field576 || class20.field575 == client.field313 && var0.field881 > class153.field2262.field31) {
                                    var12 = 2000;
                                 }

                                 var8 = 0;
                                 if(var10 == 0) {
                                    var8 = var12 + 9;
                                 }

                                 if(var10 == 1) {
                                    var8 = 10 + var12;
                                 }

                                 if(var10 == 2) {
                                    var8 = var12 + 11;
                                 }

                                 if(var10 == 3) {
                                    var8 = 12 + var12;
                                 }

                                 if(var10 == 4) {
                                    var8 = 13 + var12;
                                 }

                                 class217.method3974(var5[var10], class158.method3184(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     class217.method3974("Examine", class158.method3184(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }
}
