import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class4 {
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = 1010602197
   )
   @Export("baseX")
   static int field62;
   @ObfuscatedName("g")
   static final BigInteger field63 = new BigInteger("cc3f611f9220a3943b434a6f0366cad7c6d9fecfe38a0a936b5c9348d4239499f0bf0b644fb6085c3dc58899cf7024ac3780181e4365de5f53909ccd7a1622e285544423cc692e26e1975b391dd50dd8cba7977664b5cdb06577ff3c6e61c0f72a57bf2ffc24d6d5f6b9dfdfe9d98bd49444d4e47bcb87e81d925080ab11b3e3", 16);
   @ObfuscatedName("b")
   static final BigInteger field67 = new BigInteger("10001", 16);

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)V",
      garbageValue = "-1776941067"
   )
   static void method37(class173 var0) {
      if(var0.field2880 == client.field491) {
         client.field507[var0.field2879] = true;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass86;[Lclass108;I)V",
      garbageValue = "911901635"
   )
   static final void method38(class86 var0, class108[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if((class5.field69[var2][var3][var4] & 1) == 1) {
                  var5 = var2;
                  if((class5.field69[1][var3][var4] & 2) == 2) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method2394(var3, var4);
                  }
               }
            }
         }
      }

      class5.field78 += (int)(Math.random() * 5.0D) - 2;
      if(class5.field78 < -8) {
         class5.field78 = -8;
      }

      if(class5.field78 > 8) {
         class5.field78 = 8;
      }

      class5.field81 += (int)(Math.random() * 5.0D) - 2;
      if(class5.field81 < -16) {
         class5.field81 = -16;
      }

      if(class5.field81 > 16) {
         class5.field81 = 16;
      }

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      int var18;
      for(var2 = 0; var2 < 4; ++var2) {
         byte[][] var42 = class5.field91[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = 768 * var9 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class5.field83[var2][var12 + 1][var11] - class5.field83[var2][var12 - 1][var11];
               var14 = class5.field83[var2][var12][var11 + 1] - class5.field83[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(65536 + var13 * var13 + var14 * var14));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (var18 * -50 + var16 * -50 + -10 * var17) / var10 + 96;
               var20 = (var42[var12][var11] >> 1) + (var42[var12][1 + var11] >> 3) + (var42[var12][var11 - 1] >> 2) + (var42[var12 - 1][var11] >> 2) + (var42[1 + var12][var11] >> 3);
               class41.field957[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class9.field144[var11] = 0;
            class14.field212[var11] = 0;
            class41.field954[var11] = 0;
            class76.field1356[var11] = 0;
            class10.field161[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = 5 + var11;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class5.field71[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     var16 = var14 - 1;
                     class41 var43 = (class41)class41.field955.method3764((long)var16);
                     class41 var45;
                     if(var43 != null) {
                        var45 = var43;
                     } else {
                        byte[] var44 = class124.field2022.method3266(1, var16);
                        var43 = new class41();
                        if(null != var44) {
                           var43.method847(new class119(var44), var16);
                        }

                        var43.method855();
                        class41.field955.method3759(var43, (long)var16);
                        var45 = var43;
                     }

                     class9.field144[var12] += var45.field953;
                     class14.field212[var12] += var45.field958;
                     class41.field954[var12] += var45.field960;
                     class76.field1356[var12] += var45.field956;
                     ++class10.field161[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class5.field71[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     var17 = var15 - 1;
                     class41 var51 = (class41)class41.field955.method3764((long)var17);
                     class41 var46;
                     if(null != var51) {
                        var46 = var51;
                     } else {
                        byte[] var47 = class124.field2022.method3266(1, var17);
                        var51 = new class41();
                        if(null != var47) {
                           var51.method847(new class119(var47), var17);
                        }

                        var51.method855();
                        class41.field955.method3759(var51, (long)var17);
                        var46 = var51;
                     }

                     class9.field144[var12] -= var46.field953;
                     class14.field212[var12] -= var46.field958;
                     class41.field954[var12] -= var46.field960;
                     class76.field1356[var12] -= var46.field956;
                     --class10.field161[var12];
                  }
               }
            }

            if(var11 >= 1 && var11 < 103) {
               var12 = 0;
               var13 = 0;
               var14 = 0;
               var15 = 0;
               var16 = 0;

               for(var17 = -5; var17 < 109; ++var17) {
                  var18 = var17 + 5;
                  if(var18 >= 0 && var18 < 104) {
                     var12 += class9.field144[var18];
                     var13 += class14.field212[var18];
                     var14 += class41.field954[var18];
                     var15 += class76.field1356[var18];
                     var16 += class10.field161[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class9.field144[var19];
                     var13 -= class14.field212[var19];
                     var14 -= class41.field954[var19];
                     var15 -= class76.field1356[var19];
                     var16 -= class10.field161[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!client.field383 || (class5.field69[0][var11][var17] & 2) != 0 || (class5.field69[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class5.field70) {
                        class5.field70 = var2;
                     }

                     var20 = class5.field71[var2][var11][var17] & 255;
                     int var21 = class5.field72[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class5.field83[var2][var11][var17];
                        int var23 = class5.field83[var2][var11 + 1][var17];
                        int var24 = class5.field83[var2][var11 + 1][1 + var17];
                        int var25 = class5.field83[var2][var11][1 + var17];
                        int var26 = class41.field957[var11][var17];
                        int var27 = class41.field957[var11 + 1][var17];
                        int var28 = class41.field957[var11 + 1][1 + var17];
                        int var29 = class41.field957[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = class59.method1271(var32, var33, var34);
                           var32 = var32 + class5.field78 & 255;
                           var34 += class5.field81;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class59.method1271(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var49 = true;
                           if(var20 == 0 && class5.field73[var2][var11][var17] != 0) {
                              var49 = false;
                           }

                           if(var21 > 0 && !class56.method1230(var21 - 1).field1031) {
                              var49 = false;
                           }

                           if(var49 && var23 == var22 && var24 == var22 && var25 == var22) {
                              class149.field2225[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = class91.field1549[class15.method174(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.method1930(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class15.method174(var30, var26), class15.method174(var30, var27), class15.method174(var30, var28), class15.method174(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = class5.field73[var2][var11][var17] + 1;
                           byte var50 = class49.field1067[var2][var11][var17];
                           class46 var35 = class56.method1230(var21 - 1);
                           int var36 = var35.field1030;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if(var36 >= 0) {
                              var38 = class91.field1560.vmethod2176(var36);
                              var37 = -1;
                           } else if(var35.field1027 == 16711935) {
                              var37 = -2;
                              var36 = -1;
                              var38 = -2;
                           } else {
                              var37 = class59.method1271(var35.field1037, var35.field1034, var35.field1035);
                              var39 = var35.field1037 + class5.field78 & 255;
                              var40 = var35.field1035 + class5.field81;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = class59.method1271(var39, var35.field1034, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = class91.field1549[class13.method160(var38, 96)];
                           }

                           if(var35.field1038 != -1) {
                              var40 = var35.field1036 + class5.field78 & 255;
                              int var41 = class5.field81 + var35.field1032;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = class59.method1271(var40, var35.field1029, var41);
                              var39 = class91.field1549[class13.method160(var38, 96)];
                           }

                           var0.method1930(var2, var11, var17, var33, var50, var36, var22, var23, var24, var25, class15.method174(var30, var26), class15.method174(var30, var27), class15.method174(var30, var28), class15.method174(var30, var29), class13.method160(var37, var26), class13.method160(var37, var27), class13.method160(var37, var28), class13.method160(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var0.method1929(var2, var12, var11, class122.method2809(var2, var12, var11));
            }
         }

         class5.field71[var2] = (byte[][])null;
         class5.field72[var2] = (byte[][])null;
         class5.field73[var2] = (byte[][])null;
         class49.field1067[var2] = (byte[][])null;
         class5.field91[var2] = (byte[][])null;
      }

      var0.method1956(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class5.field69[1][var2][var3] & 2) == 2) {
               var0.method2055(var2, var3);
            }
         }
      }

      var2 = 1;
      var3 = 2;
      var4 = 4;

      for(var5 = 0; var5 < 4; ++var5) {
         if(var5 > 0) {
            var2 <<= 3;
            var3 <<= 3;
            var4 <<= 3;
         }

         for(int var6 = 0; var6 <= var5; ++var6) {
            for(int var7 = 0; var7 <= 104; ++var7) {
               for(int var8 = 0; var8 <= 104; ++var8) {
                  short var48;
                  if((class149.field2225[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class149.field2225[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class149.field2225[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label538:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class149.field2225[var11 - 1][var8][var13] & var2) == 0) {
                              break label538;
                           }
                        }

                        --var11;
                     }

                     label527:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class149.field2225[1 + var12][var8][var13] & var2) == 0) {
                              break label527;
                           }
                        }

                        ++var12;
                     }

                     var13 = (1 + (var10 - var9)) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var48 = 240;
                        var15 = class5.field83[var12][var8][var9] - var48;
                        var16 = class5.field83[var11][var8][var9];
                        class86.method1928(var5, 1, var8 * 128, var8 * 128, 128 * var9, 128 + var10 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class149.field2225[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class149.field2225[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class149.field2225[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class149.field2225[var6][1 + var10][var7] & var3) != 0) {
                        ++var10;
                     }

                     label591:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class149.field2225[var11 - 1][var13][var7] & var3) == 0) {
                              break label591;
                           }
                        }

                        --var11;
                     }

                     label580:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class149.field2225[1 + var12][var13][var7] & var3) == 0) {
                              break label580;
                           }
                        }

                        ++var12;
                     }

                     var13 = (1 + (var10 - var9)) * (1 + var12 - var11);
                     if(var13 >= 8) {
                        var48 = 240;
                        var15 = class5.field83[var12][var9][var7] - var48;
                        var16 = class5.field83[var11][var9][var7];
                        class86.method1928(var5, 2, var9 * 128, var10 * 128 + 128, var7 * 128, 128 * var7, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class149.field2225[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class149.field2225[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class149.field2225[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class149.field2225[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label644:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class149.field2225[var6][var9 - 1][var13] & var4) == 0) {
                              break label644;
                           }
                        }

                        --var9;
                     }

                     label633:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class149.field2225[var6][1 + var10][var13] & var4) == 0) {
                              break label633;
                           }
                        }

                        ++var10;
                     }

                     if((1 + (var12 - var11)) * (1 + (var10 - var9)) >= 4) {
                        var13 = class5.field83[var6][var9][var11];
                        class86.method1928(var5, 4, 128 * var9, 128 + var10 * 128, 128 * var11, 128 + 128 * var12, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class149.field2225[var6][var14][var15] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)[Lclass152;",
      garbageValue = "1851100860"
   )
   public static class152[] method39() {
      return new class152[]{class152.field2243, class152.field2244, class152.field2246, class152.field2251, class152.field2247};
   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "53"
   )
   static final void method40(int var0) {
      class52.method1069();
      client.method546();
      int var1 = class20.method553(var0).field1132;
      if(var1 != 0) {
         int var2 = class176.field2896[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               class91.method2093(0.9D);
               ((class95)class91.field1560).method2175(0.9D);
            }

            if(var2 == 2) {
               class91.method2093(0.8D);
               ((class95)class91.field1560).method2175(0.8D);
            }

            if(var2 == 3) {
               class91.method2093(0.7D);
               ((class95)class91.field1560).method2175(0.7D);
            }

            if(var2 == 4) {
               class91.method2093(0.6D);
               ((class95)class91.field1560).method2175(0.6D);
            }

            class51.field1081.method3755();
         }

         if(var1 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(var3 != client.field524) {
               if(client.field524 == 0 && client.field525 != -1) {
                  class85.method1922(client.field358, client.field525, 0, var3, false);
                  client.field526 = false;
               } else if(var3 == 0) {
                  class183.field2952.method3614();
                  class183.field2953 = 1;
                  class50.field1075 = null;
                  client.field526 = false;
               } else {
                  class138.method2967(var3);
               }

               client.field524 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               client.field527 = 127;
            }

            if(var2 == 1) {
               client.field527 = 96;
            }

            if(var2 == 2) {
               client.field527 = 64;
            }

            if(var2 == 3) {
               client.field527 = 32;
            }

            if(var2 == 4) {
               client.field527 = 0;
            }
         }

         if(var1 == 5) {
            client.field427 = var2;
         }

         if(var1 == 6) {
            client.field377 = var2;
         }

         if(var1 == 9) {
            client.field362 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               client.field365 = 127;
            }

            if(var2 == 1) {
               client.field365 = 96;
            }

            if(var2 == 2) {
               client.field365 = 64;
            }

            if(var2 == 3) {
               client.field365 = 32;
            }

            if(var2 == 4) {
               client.field365 = 0;
            }
         }

         if(var1 == 17) {
            client.field374 = var2 & '\uffff';
         }

         class20[] var4;
         if(var1 == 18) {
            var4 = new class20[]{class20.field575, class20.field571, class20.field574, class20.field576};
            client.field312 = (class20)class157.method3181(var4, var2);
            if(client.field312 == null) {
               client.field312 = class20.field575;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               client.field329 = -1;
            } else {
               client.field329 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            var4 = new class20[]{class20.field575, class20.field571, class20.field574, class20.field576};
            client.field313 = (class20)class157.method3181(var4, var2);
            if(null == client.field313) {
               client.field313 = class20.field575;
            }
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "133939366"
   )
   public static int method41(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(Lclass173;II)I",
      garbageValue = "-400559220"
   )
   static final int method42(class173 var0, int var1) {
      if(null != var0.field2860 && var1 < var0.field2860.length) {
         try {
            int[] var2 = var0.field2860[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = client.field356[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = client.field425[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = client.field426[var2[var4++]];
               }

               int var9;
               class173 var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class161.method3205(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class35.method741(var11).field1098 || client.field290)) {
                     for(var12 = 0; var12 < var10.field2866.length; ++var12) {
                        if(var10.field2866[var12] == var11 + 1) {
                           var7 += var10.field2745[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class176.field2896[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class155.field2282[client.field425[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class176.field2896[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class153.field2262.field31;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class155.field2280[var9]) {
                        var7 += client.field425[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class161.method3205(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class35.method741(var11).field1098 || client.field290)) {
                     for(var12 = 0; var12 < var10.field2866.length; ++var12) {
                        if(var11 + 1 == var10.field2866[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = client.field452;
               }

               if(var6 == 12) {
                  var7 = client.field453;
               }

               if(var6 == 13) {
                  var9 = class176.field2896[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class7.method90(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (class153.field2262.field813 >> 7) + field62;
               }

               if(var6 == 19) {
                  var7 = (class153.field2262.field791 >> 7) + class85.field1434;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }
}
