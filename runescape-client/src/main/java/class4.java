import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public class class4 {
   @ObfuscatedName("bl")
   static class171 field68;
   @ObfuscatedName("e")
   static final BigInteger field69 = new BigInteger("10001", 16);
   @ObfuscatedName("h")
   static String[] field72;
   @ObfuscatedName("l")
   static final BigInteger field75 = new BigInteger("ae0beace687ed780dc147cb2fbbbaed13bb2fd8fc07402742dd975f6880ea97eee7bfe87f405f21a922ddef374aba8fbd9ae7e75ee597c7fbee5d2d8ec62c4b8ca25b748b5626a05e31233897cc0eb466115225f65b4238c7680cf7b25ec858db8a94296da73f8464d7ef2fb132b77c898e663f8540d888fe4ea779b80e8a735", 16);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Lclass81;",
      garbageValue = "16711935"
   )
   static class81 method41() {
      class81 var0 = new class81();
      var0.field1471 = class79.field1458;
      var0.field1469 = class79.field1452;
      var0.field1468 = class79.field1449[0];
      var0.field1475 = class11.field192[0];
      var0.field1466 = class138.field2134[0];
      var0.field1467 = class169.field2703[0];
      int var1 = var0.field1467 * var0.field1466;
      byte[] var2 = class93.field1626[0];
      var0.field1476 = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.field1476[var3] = class178.field2941[var2[var3] & 255];
      }

      class52.method1134();
      return var0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass125;II)V",
      garbageValue = "-1513427620"
   )
   static void method42(class125 var0, int var1) {
      boolean var2 = var0.method2859(1) == 1;
      if(var2) {
         class34.field796[++class34.field806 - 1] = var1;
      }

      int var3 = var0.method2859(2);
      class2 var4 = client.field467[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field37 = false;
         } else if(client.field417 == var1) {
            throw new RuntimeException();
         } else {
            class34.field803[var1] = (class6.field128 + var4.field906[0] >> 6) + (var4.field57 << 28) + (class19.field286 + var4.field885[0] >> 6 << 14);
            if(var4.field878 != -1) {
               class34.field800[var1] = var4.field878;
            } else {
               class34.field800[var1] = var4.field889;
            }

            class34.field805[var1] = var4.field876;
            client.field467[var1] = null;
            if(var0.method2859(1) != 0) {
               class21.method546(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method2859(3);
            var6 = var4.field885[0];
            var7 = var4.field906[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(var1 == client.field417 && (var4.field896 < 1536 || var4.field879 < 1536 || var4.field896 >= 11776 || var4.field879 >= 11776)) {
               var4.method23(var6, var7);
               var4.field37 = false;
            } else if(var2) {
               var4.field37 = true;
               var4.field54 = var6;
               var4.field55 = var7;
            } else {
               var4.field37 = false;
               var4.method9(var6, var7, class34.field799[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.method2859(4);
            var6 = var4.field885[0];
            var7 = var4.field906[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(var1 != client.field417 || var4.field896 >= 1536 && var4.field879 >= 1536 && var4.field896 < 11776 && var4.field879 < 11776) {
               if(var2) {
                  var4.field37 = true;
                  var4.field54 = var6;
                  var4.field55 = var7;
               } else {
                  var4.field37 = false;
                  var4.method9(var6, var7, class34.field799[var1]);
               }
            } else {
               var4.method23(var6, var7);
               var4.field37 = false;
            }

         } else {
            var5 = var0.method2859(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method2859(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.field885[0];
               var11 = var9 + var4.field906[0];
               if(client.field417 != var1 || var4.field896 >= 1536 && var4.field879 >= 1536 && var4.field896 < 11776 && var4.field879 < 11776) {
                  if(var2) {
                     var4.field37 = true;
                     var4.field54 = var10;
                     var4.field55 = var11;
                  } else {
                     var4.field37 = false;
                     var4.method9(var10, var11, class34.field799[var1]);
                  }
               } else {
                  var4.method23(var10, var11);
                  var4.field37 = false;
               }

               var4.field57 = (byte)(var4.field57 + var7 & 3);
               if(client.field417 == var1) {
                  class50.field1119 = var4.field57;
               }

            } else {
               var6 = var0.method2859(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (class19.field286 + var4.field885[0] + var8 & 16383) - class19.field286;
               var11 = (var9 + class6.field128 + var4.field906[0] & 16383) - class6.field128;
               if(client.field417 != var1 || var4.field896 >= 1536 && var4.field879 >= 1536 && var4.field896 < 11776 && var4.field879 < 11776) {
                  if(var2) {
                     var4.field37 = true;
                     var4.field54 = var10;
                     var4.field55 = var11;
                  } else {
                     var4.field37 = false;
                     var4.method9(var10, var11, class34.field799[var1]);
                  }
               } else {
                  var4.method23(var10, var11);
                  var4.field37 = false;
               }

               var4.field57 = (byte)(var7 + var4.field57 & 3);
               if(var1 == client.field417) {
                  class50.field1119 = var4.field57;
               }

            }
         }
      }
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(Lclass41;IIIB)V",
      garbageValue = "37"
   )
   static final void method43(class41 var0, int var1, int var2, int var3) {
      if(client.field435 < 400) {
         if(var0.field948 != null) {
            var0 = var0.method824();
         }

         if(var0 != null) {
            if(var0.field947) {
               if(!var0.field935 || client.field462 == var1) {
                  String var4 = var0.field942;
                  int var8;
                  if(var0.field940 != 0) {
                     int var7 = var0.field940;
                     var8 = class118.field2035.field35;
                     int var9 = var8 - var7;
                     String var6;
                     if(var9 < -9) {
                        var6 = class117.method2530(16711680);
                     } else if(var9 < -6) {
                        var6 = class117.method2530(16723968);
                     } else if(var9 < -3) {
                        var6 = class117.method2530(16740352);
                     } else if(var9 < 0) {
                        var6 = class117.method2530(16756736);
                     } else if(var9 > 9) {
                        var6 = class117.method2530('\uff00');
                     } else if(var9 > 6) {
                        var6 = class117.method2530(4259584);
                     } else if(var9 > 3) {
                        var6 = class117.method2530(8453888);
                     } else if(var9 > 0) {
                        var6 = class117.method2530(12648192);
                     } else {
                        var6 = class117.method2530(16776960);
                     }

                     var4 = var4 + var6 + " " + " (" + "level-" + var0.field940 + ")";
                  }

                  if(client.field459 == 1) {
                     class118.method2543("Use", client.field447 + " " + "->" + " " + class117.method2530(16776960) + var4, 7, var1, var2, var3);
                  } else if(client.field448) {
                     if((class19.field278 & 2) == 2) {
                        class118.method2543(client.field452, client.field369 + " " + "->" + " " + class117.method2530(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.field938;
                     if(client.field524) {
                        var5 = class20.method542(var5);
                     }

                     int var10;
                     if(var5 != null) {
                        for(var10 = 4; var10 >= 0; --var10) {
                           if(var5[var10] != null && !var5[var10].equalsIgnoreCase("Attack")) {
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

                              class118.method2543(var5[var10], class117.method2530(16776960) + var4, var11, var1, var2, var3);
                           }
                        }
                     }

                     if(var5 != null) {
                        for(var10 = 4; var10 >= 0; --var10) {
                           if(var5[var10] != null && var5[var10].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(client.field321 != class21.field594) {
                                 if(class21.field598 == client.field321 || class21.field597 == client.field321 && var0.field940 > class118.field2035.field35) {
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
                                    var8 = 11 + var12;
                                 }

                                 if(var10 == 3) {
                                    var8 = 12 + var12;
                                 }

                                 if(var10 == 4) {
                                    var8 = var12 + 13;
                                 }

                                 class118.method2543(var5[var10], class117.method2530(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     class118.method2543("Examine", class117.method2530(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I[BLclass137;I)V",
      garbageValue = "-1781815950"
   )
   static void method44(int var0, byte[] var1, class137 var2) {
      class172 var3 = new class172();
      var3.field2745 = 0;
      var3.field3161 = (long)var0;
      var3.field2747 = var1;
      var3.field2742 = var2;
      class202 var4 = class173.field2750;
      synchronized(class173.field2750) {
         class173.field2750.method3895(var3);
      }

      class125.method2862();
   }
}
