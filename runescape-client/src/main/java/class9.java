import java.awt.Graphics;
import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public class class9 {
   @ObfuscatedName("h")
   static final BigInteger field157 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = -303328519
   )
   static int field160;
   @ObfuscatedName("s")
   static final BigInteger field163 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "362586367"
   )
   static void method125() {
      for(class3 var0 = (class3)client.field475.method3939(); null != var0; var0 = (class3)client.field475.method3935()) {
         int var1 = var0.field70;
         if(class14.method179(var1)) {
            boolean var2 = true;
            class176[] var3 = class176.field2836[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(null != var3[var4]) {
                  var2 = var3[var4].field2855;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.field3175;
               class176 var5 = class134.method2983(var4);
               if(null != var5) {
                  class79.method1777(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-197097329"
   )
   static final void method126() {
      class160.method3313(false);
      client.field342 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class127.field2086.length; ++var1) {
         if(class119.field2037[var1] != -1 && class127.field2086[var1] == null) {
            class127.field2086[var1] = class80.field1476.method3411(class119.field2037[var1], 0);
            if(class127.field2086[var1] == null) {
               var0 = false;
               ++client.field342;
            }
         }

         if(class3.field66[var1] != -1 && null == class109.field1944[var1]) {
            class109.field1944[var1] = class80.field1476.method3396(class3.field66[var1], 0, class101.field1747[var1]);
            if(class109.field1944[var1] == null) {
               var0 = false;
               ++client.field342;
            }
         }
      }

      if(!var0) {
         client.field527 = 1;
      } else {
         client.field493 = 0;
         var0 = true;

         int var3;
         int var4;
         for(var1 = 0; var1 < class127.field2086.length; ++var1) {
            byte[] var44 = class109.field1944[var1];
            if(var44 != null) {
               var3 = 64 * (class7.field135[var1] >> 8) - class0.field11;
               var4 = (class7.field135[var1] & 255) * 64 - class21.field592;
               if(client.field355) {
                  var3 = 10;
                  var4 = 10;
               }

               var0 &= class143.method3111(var44, var3, var4);
            }
         }

         if(!var0) {
            client.field527 = 2;
         } else {
            if(client.field527 != 0) {
               method131("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class47.method1009();
            class31.method693();
            class47.method1009();
            class136.field2126.method1992();
            class47.method1009();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               client.field354[var1].method2493();
            }

            int var2;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var2 = 0; var2 < 104; ++var2) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class5.field80[var1][var2][var3] = 0;
                  }
               }
            }

            class47.method1009();
            class36.method762();
            var1 = class127.field2086.length;
            class142.method3089();
            class160.method3313(true);
            int var5;
            int var6;
            int var7;
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
            int var19;
            int var20;
            int var21;
            if(!client.field355) {
               byte[] var45;
               for(var2 = 0; var2 < var1; ++var2) {
                  var3 = (class7.field135[var2] >> 8) * 64 - class0.field11;
                  var4 = (class7.field135[var2] & 255) * 64 - class21.field592;
                  var45 = class127.field2086[var2];
                  if(var45 != null) {
                     class47.method1009();
                     var6 = class48.field1092 * 8 - 48;
                     var7 = class16.field242 * 8 - 48;
                     class111[] var48 = client.field354;

                     for(var9 = 0; var9 < 4; ++var9) {
                        for(var10 = 0; var10 < 64; ++var10) {
                           for(var11 = 0; var11 < 64; ++var11) {
                              if(var10 + var3 > 0 && var3 + var10 < 103 && var4 + var11 > 0 && var4 + var11 < 103) {
                                 var48[var9].field1969[var10 + var3][var11 + var4] &= -16777217;
                              }
                           }
                        }
                     }

                     class122 var46 = new class122(var45);

                     for(var10 = 0; var10 < 4; ++var10) {
                        for(var11 = 0; var11 < 64; ++var11) {
                           for(var12 = 0; var12 < 64; ++var12) {
                              class96.method2252(var46, var10, var11 + var3, var12 + var4, var6, var7, 0);
                           }
                        }
                     }
                  }
               }

               for(var2 = 0; var2 < var1; ++var2) {
                  var3 = (class7.field135[var2] >> 8) * 64 - class0.field11;
                  var4 = 64 * (class7.field135[var2] & 255) - class21.field592;
                  var45 = class127.field2086[var2];
                  if(null == var45 && class16.field242 < 800) {
                     class47.method1009();
                     class114.method2545(var3, var4, 64, 64);
                  }
               }

               class160.method3313(true);

               for(var2 = 0; var2 < var1; ++var2) {
                  byte[] var50 = class109.field1944[var2];
                  if(null != var50) {
                     var4 = (class7.field135[var2] >> 8) * 64 - class0.field11;
                     var5 = 64 * (class7.field135[var2] & 255) - class21.field592;
                     class47.method1009();
                     class89 var47 = class136.field2126;
                     class111[] var49 = client.field354;
                     class122 var62 = new class122(var50);
                     var9 = -1;

                     while(true) {
                        var10 = var62.method2646();
                        if(var10 == 0) {
                           break;
                        }

                        var9 += var10;
                        var11 = 0;

                        while(true) {
                           var12 = var62.method2646();
                           if(var12 == 0) {
                              break;
                           }

                           var11 += var12 - 1;
                           var13 = var11 & 63;
                           var14 = var11 >> 6 & 63;
                           var15 = var11 >> 12;
                           var16 = var62.method2633();
                           var17 = var16 >> 2;
                           var18 = var16 & 3;
                           var19 = var14 + var4;
                           var20 = var5 + var13;
                           if(var19 > 0 && var20 > 0 && var19 < 103 && var20 < 103) {
                              var21 = var15;
                              if((class5.field80[1][var19][var20] & 2) == 2) {
                                 var21 = var15 - 1;
                              }

                              class111 var22 = null;
                              if(var21 >= 0) {
                                 var22 = var49[var21];
                              }

                              class177.method3597(var15, var19, var20, var9, var18, var17, var47, var22);
                           }
                        }
                     }
                  }
               }
            }

            int var8;
            if(client.field355) {
               for(var2 = 0; var2 < 4; ++var2) {
                  class47.method1009();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var55 = false;
                        var6 = client.field356[var2][var3][var4];
                        if(var6 != -1) {
                           var7 = var6 >> 24 & 3;
                           var8 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = var10 / 8 + (var9 / 8 << 8);

                           for(var12 = 0; var12 < class7.field135.length; ++var12) {
                              if(class7.field135[var12] == var11 && class127.field2086[var12] != null) {
                                 class1.method5(class127.field2086[var12], var2, 8 * var3, var4 * 8, var7, 8 * (var9 & 7), 8 * (var10 & 7), var8, client.field354);
                                 var55 = true;
                                 break;
                              }
                           }
                        }

                        if(!var55) {
                           class97.method2256(var2, var3 * 8, var4 * 8);
                        }
                     }
                  }
               }

               for(var2 = 0; var2 < 13; ++var2) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = client.field356[0][var2][var3];
                     if(var4 == -1) {
                        class114.method2545(8 * var2, 8 * var3, 8, 8);
                     }
                  }
               }

               class160.method3313(true);

               for(var2 = 0; var2 < 4; ++var2) {
                  class47.method1009();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        var5 = client.field356[var2][var3][var4];
                        if(var5 != -1) {
                           var6 = var5 >> 24 & 3;
                           var7 = var5 >> 1 & 3;
                           var8 = var5 >> 14 & 1023;
                           var9 = var5 >> 3 & 2047;
                           var10 = var9 / 8 + (var8 / 8 << 8);

                           for(var11 = 0; var11 < class7.field135.length; ++var11) {
                              if(var10 == class7.field135[var11] && null != class109.field1944[var11]) {
                                 class107.method2396(class109.field1944[var11], var2, 8 * var3, var4 * 8, var6, 8 * (var8 & 7), 8 * (var9 & 7), var7, class136.field2126, client.field354);
                                 break;
                              }
                           }
                        }
                     }
                  }
               }
            }

            class160.method3313(true);
            class31.method693();
            class47.method1009();
            class89 var59 = class136.field2126;
            class111[] var63 = client.field354;

            for(var4 = 0; var4 < 4; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  for(var6 = 0; var6 < 104; ++var6) {
                     if((class5.field80[var4][var5][var6] & 1) == 1) {
                        var7 = var4;
                        if((class5.field80[1][var5][var6] & 2) == 2) {
                           var7 = var4 - 1;
                        }

                        if(var7 >= 0) {
                           var63[var7].method2497(var5, var6);
                        }
                     }
                  }
               }
            }

            class5.field84 += (int)(Math.random() * 5.0D) - 2;
            if(class5.field84 < -8) {
               class5.field84 = -8;
            }

            if(class5.field84 > 8) {
               class5.field84 = 8;
            }

            class5.field97 += (int)(Math.random() * 5.0D) - 2;
            if(class5.field97 < -16) {
               class5.field97 = -16;
            }

            if(class5.field97 > 16) {
               class5.field97 = 16;
            }

            for(var4 = 0; var4 < 4; ++var4) {
               byte[][] var60 = class232.field3275[var4];
               var11 = (int)Math.sqrt(5100.0D);
               var12 = var11 * 768 >> 8;

               int var51;
               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     var15 = class5.field85[var4][var14 + 1][var13] - class5.field85[var4][var14 - 1][var13];
                     var16 = class5.field85[var4][var14][1 + var13] - class5.field85[var4][var14][var13 - 1];
                     var17 = (int)Math.sqrt((double)(65536 + var15 * var15 + var16 * var16));
                     var18 = (var15 << 8) / var17;
                     var19 = 65536 / var17;
                     var20 = (var16 << 8) / var17;
                     var21 = (var18 * -50 + -10 * var19 + var20 * -50) / var12 + 96;
                     var51 = (var60[var14][var13] >> 1) + (var60[var14 + 1][var13] >> 3) + (var60[var14 - 1][var13] >> 2) + (var60[var14][var13 - 1] >> 2) + (var60[var14][var13 + 1] >> 3);
                     class13.field207[var14][var13] = var21 - var51;
                  }
               }

               for(var13 = 0; var13 < 104; ++var13) {
                  class5.field83[var13] = 0;
                  class5.field87[var13] = 0;
                  class5.field96[var13] = 0;
                  class37.field809[var13] = 0;
                  class224.field3225[var13] = 0;
               }

               for(var13 = -5; var13 < 109; ++var13) {
                  for(var14 = 0; var14 < 104; ++var14) {
                     var15 = var13 + 5;
                     if(var15 >= 0 && var15 < 104) {
                        var16 = class5.field82[var4][var15][var14] & 255;
                        if(var16 > 0) {
                           class43 var52 = class23.method601(var16 - 1);
                           class5.field83[var14] += var52.field999;
                           class5.field87[var14] += var52.field1003;
                           class5.field96[var14] += var52.field1004;
                           class37.field809[var14] += var52.field1005;
                           ++class224.field3225[var14];
                        }
                     }

                     var16 = var13 - 5;
                     if(var16 >= 0 && var16 < 104) {
                        var17 = class5.field82[var4][var16][var14] & 255;
                        if(var17 > 0) {
                           class43 var53 = class23.method601(var17 - 1);
                           class5.field83[var14] -= var53.field999;
                           class5.field87[var14] -= var53.field1003;
                           class5.field96[var14] -= var53.field1004;
                           class37.field809[var14] -= var53.field1005;
                           --class224.field3225[var14];
                        }
                     }
                  }

                  if(var13 >= 1 && var13 < 103) {
                     var14 = 0;
                     var15 = 0;
                     var16 = 0;
                     var17 = 0;
                     var18 = 0;

                     for(var19 = -5; var19 < 109; ++var19) {
                        var20 = 5 + var19;
                        if(var20 >= 0 && var20 < 104) {
                           var14 += class5.field83[var20];
                           var15 += class5.field87[var20];
                           var16 += class5.field96[var20];
                           var17 += class37.field809[var20];
                           var18 += class224.field3225[var20];
                        }

                        var21 = var19 - 5;
                        if(var21 >= 0 && var21 < 104) {
                           var14 -= class5.field83[var21];
                           var15 -= class5.field87[var21];
                           var16 -= class5.field96[var21];
                           var17 -= class37.field809[var21];
                           var18 -= class224.field3225[var21];
                        }

                        if(var19 >= 1 && var19 < 103 && (!client.field301 || (class5.field80[0][var13][var19] & 2) != 0 || (class5.field80[var4][var13][var19] & 16) == 0)) {
                           if(var4 < class5.field81) {
                              class5.field81 = var4;
                           }

                           var51 = class5.field82[var4][var13][var19] & 255;
                           int var23 = class75.field1422[var4][var13][var19] & 255;
                           if(var51 > 0 || var23 > 0) {
                              int var24 = class5.field85[var4][var13][var19];
                              int var25 = class5.field85[var4][var13 + 1][var19];
                              int var26 = class5.field85[var4][var13 + 1][1 + var19];
                              int var27 = class5.field85[var4][var13][var19 + 1];
                              int var28 = class13.field207[var13][var19];
                              int var29 = class13.field207[var13 + 1][var19];
                              int var30 = class13.field207[var13 + 1][var19 + 1];
                              int var31 = class13.field207[var13][1 + var19];
                              int var32 = -1;
                              int var33 = -1;
                              int var34;
                              int var35;
                              if(var51 > 0) {
                                 var34 = 256 * var14 / var17;
                                 var35 = var15 / var18;
                                 int var36 = var16 / var18;
                                 var32 = class151.method3274(var34, var35, var36);
                                 var34 = var34 + class5.field84 & 255;
                                 var36 += class5.field97;
                                 if(var36 < 0) {
                                    var36 = 0;
                                 } else if(var36 > 255) {
                                    var36 = 255;
                                 }

                                 var33 = class151.method3274(var34, var35, var36);
                              }

                              if(var4 > 0) {
                                 boolean var57 = true;
                                 if(var51 == 0 && class5.field88[var4][var13][var19] != 0) {
                                    var57 = false;
                                 }

                                 if(var23 > 0 && !class16.method204(var23 - 1).field1077) {
                                    var57 = false;
                                 }

                                 if(var57 && var25 == var24 && var24 == var26 && var24 == var27) {
                                    class99.field1704[var4][var13][var19] |= 2340;
                                 }
                              }

                              var34 = 0;
                              if(var33 != -1) {
                                 var34 = class94.field1659[class113.method2538(var33, 96)];
                              }

                              if(var23 == 0) {
                                 var59.method1997(var4, var13, var19, 0, 0, -1, var24, var25, var26, var27, class113.method2538(var32, var28), class113.method2538(var32, var29), class113.method2538(var32, var30), class113.method2538(var32, var31), 0, 0, 0, 0, var34, 0);
                              } else {
                                 var35 = class5.field88[var4][var13][var19] + 1;
                                 byte var58 = class5.field86[var4][var13][var19];
                                 class48 var37 = class16.method204(var23 - 1);
                                 int var38 = var37.field1087;
                                 int var39;
                                 int var40;
                                 int var41;
                                 int var42;
                                 if(var38 >= 0) {
                                    var40 = class94.field1658.vmethod2260(var38);
                                    var39 = -1;
                                 } else if(var37.field1079 == 16711935) {
                                    var39 = -2;
                                    var38 = -1;
                                    var40 = -2;
                                 } else {
                                    var39 = class151.method3274(var37.field1083, var37.field1084, var37.field1085);
                                    var41 = class5.field84 + var37.field1083 & 255;
                                    var42 = var37.field1085 + class5.field97;
                                    if(var42 < 0) {
                                       var42 = 0;
                                    } else if(var42 > 255) {
                                       var42 = 255;
                                    }

                                    var40 = class151.method3274(var41, var37.field1084, var42);
                                 }

                                 var41 = 0;
                                 if(var40 != -2) {
                                    var41 = class94.field1659[class40.method813(var40, 96)];
                                 }

                                 if(var37.field1082 != -1) {
                                    var42 = class5.field84 + var37.field1090 & 255;
                                    int var43 = class5.field97 + var37.field1088;
                                    if(var43 < 0) {
                                       var43 = 0;
                                    } else if(var43 > 255) {
                                       var43 = 255;
                                    }

                                    var40 = class151.method3274(var42, var37.field1080, var43);
                                    var41 = class94.field1659[class40.method813(var40, 96)];
                                 }

                                 var59.method1997(var4, var13, var19, var35, var58, var38, var24, var25, var26, var27, class113.method2538(var32, var28), class113.method2538(var32, var29), class113.method2538(var32, var30), class113.method2538(var32, var31), class40.method813(var39, var28), class40.method813(var39, var29), class40.method813(var39, var30), class40.method813(var39, var31), var34, var41);
                              }
                           }
                        }
                     }
                  }
               }

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     if((class5.field80[var4][var14][var13] & 8) != 0) {
                        var19 = 0;
                     } else if(var4 > 0 && (class5.field80[1][var14][var13] & 2) != 0) {
                        var19 = var4 - 1;
                     } else {
                        var19 = var4;
                     }

                     var59.method2073(var4, var14, var13, var19);
                  }
               }

               class5.field82[var4] = null;
               class75.field1422[var4] = null;
               class5.field88[var4] = null;
               class5.field86[var4] = null;
               class232.field3275[var4] = null;
            }

            var59.method2022(-50, -10, -50);

            for(var4 = 0; var4 < 104; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  if((class5.field80[1][var4][var5] & 2) == 2) {
                     var59.method2061(var4, var5);
                  }
               }
            }

            var4 = 1;
            var5 = 2;
            var6 = 4;

            for(var7 = 0; var7 < 4; ++var7) {
               if(var7 > 0) {
                  var4 <<= 3;
                  var5 <<= 3;
                  var6 <<= 3;
               }

               for(var8 = 0; var8 <= var7; ++var8) {
                  for(var9 = 0; var9 <= 104; ++var9) {
                     for(var10 = 0; var10 <= 104; ++var10) {
                        short var56;
                        if((class99.field1704[var8][var10][var9] & var4) != 0) {
                           var11 = var9;
                           var12 = var9;
                           var13 = var8;

                           for(var14 = var8; var11 > 0 && (class99.field1704[var8][var10][var11 - 1] & var4) != 0; --var11) {
                              ;
                           }

                           while(var12 < 104 && (class99.field1704[var8][var10][var12 + 1] & var4) != 0) {
                              ++var12;
                           }

                           label930:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var12; ++var15) {
                                 if((class99.field1704[var13 - 1][var10][var15] & var4) == 0) {
                                    break label930;
                                 }
                              }

                              --var13;
                           }

                           label919:
                           while(var14 < var7) {
                              for(var15 = var11; var15 <= var12; ++var15) {
                                 if((class99.field1704[1 + var14][var10][var15] & var4) == 0) {
                                    break label919;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (1 + (var12 - var11)) * (var14 + 1 - var13);
                           if(var15 >= 8) {
                              var56 = 240;
                              var17 = class5.field85[var14][var10][var11] - var56;
                              var18 = class5.field85[var13][var10][var11];
                              class89.method1995(var7, 1, var10 * 128, 128 * var10, 128 * var11, 128 * var12 + 128, var17, var18);

                              for(var19 = var13; var19 <= var14; ++var19) {
                                 for(var20 = var11; var20 <= var12; ++var20) {
                                    class99.field1704[var19][var10][var20] &= ~var4;
                                 }
                              }
                           }
                        }

                        if((class99.field1704[var8][var10][var9] & var5) != 0) {
                           var11 = var10;
                           var12 = var10;
                           var13 = var8;

                           for(var14 = var8; var11 > 0 && (class99.field1704[var8][var11 - 1][var9] & var5) != 0; --var11) {
                              ;
                           }

                           while(var12 < 104 && (class99.field1704[var8][1 + var12][var9] & var5) != 0) {
                              ++var12;
                           }

                           label983:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var12; ++var15) {
                                 if((class99.field1704[var13 - 1][var15][var9] & var5) == 0) {
                                    break label983;
                                 }
                              }

                              --var13;
                           }

                           label972:
                           while(var14 < var7) {
                              for(var15 = var11; var15 <= var12; ++var15) {
                                 if((class99.field1704[1 + var14][var15][var9] & var5) == 0) {
                                    break label972;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (1 + (var12 - var11)) * (var14 + 1 - var13);
                           if(var15 >= 8) {
                              var56 = 240;
                              var17 = class5.field85[var14][var11][var9] - var56;
                              var18 = class5.field85[var13][var11][var9];
                              class89.method1995(var7, 2, var11 * 128, var12 * 128 + 128, var9 * 128, var9 * 128, var17, var18);

                              for(var19 = var13; var19 <= var14; ++var19) {
                                 for(var20 = var11; var20 <= var12; ++var20) {
                                    class99.field1704[var19][var20][var9] &= ~var5;
                                 }
                              }
                           }
                        }

                        if((class99.field1704[var8][var10][var9] & var6) != 0) {
                           var11 = var10;
                           var12 = var10;
                           var13 = var9;

                           for(var14 = var9; var13 > 0 && (class99.field1704[var8][var10][var13 - 1] & var6) != 0; --var13) {
                              ;
                           }

                           while(var14 < 104 && (class99.field1704[var8][var10][var14 + 1] & var6) != 0) {
                              ++var14;
                           }

                           label1036:
                           while(var11 > 0) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((class99.field1704[var8][var11 - 1][var15] & var6) == 0) {
                                    break label1036;
                                 }
                              }

                              --var11;
                           }

                           label1025:
                           while(var12 < 104) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((class99.field1704[var8][var12 + 1][var15] & var6) == 0) {
                                    break label1025;
                                 }
                              }

                              ++var12;
                           }

                           if((var14 - var13 + 1) * (1 + (var12 - var11)) >= 4) {
                              var15 = class5.field85[var8][var11][var13];
                              class89.method1995(var7, 4, 128 * var11, 128 + 128 * var12, var13 * 128, 128 * var14 + 128, var15, var15);

                              for(var16 = var11; var16 <= var12; ++var16) {
                                 for(var17 = var13; var17 <= var14; ++var17) {
                                    class99.field1704[var8][var16][var17] &= ~var6;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            class160.method3313(true);
            var4 = class5.field81;
            if(var4 > class99.field1701) {
               var4 = class99.field1701;
            }

            if(var4 < class99.field1701 - 1) {
               var4 = class99.field1701 - 1;
            }

            if(client.field301) {
               class136.field2126.method1993(class5.field81);
            } else {
               class136.field2126.method1993(0);
            }

            for(var5 = 0; var5 < 104; ++var5) {
               for(var6 = 0; var6 < 104; ++var6) {
                  class144.method3120(var5, var6);
               }
            }

            class47.method1009();

            for(class16 var61 = (class16)client.field427.method3980(); null != var61; var61 = (class16)client.field427.method3970()) {
               if(var61.field237 == -1) {
                  var61.field241 = 0;
                  class19.method253(var61);
               } else {
                  var61.method4067();
               }
            }

            class42.field948.method3910();
            if(class114.field2013 != null) {
               client.field337.method2903(251);
               client.field337.method2728(1057001181);
            }

            if(!client.field355) {
               var5 = (class48.field1092 - 6) / 8;
               var6 = (class48.field1092 + 6) / 8;
               var7 = (class16.field242 - 6) / 8;
               var8 = (class16.field242 + 6) / 8;

               for(var9 = var5 - 1; var9 <= var6 + 1; ++var9) {
                  for(var10 = var7 - 1; var10 <= var8 + 1; ++var10) {
                     if(var9 < var5 || var9 > var6 || var10 < var7 || var10 > var8) {
                        class80.field1476.method3446("m" + var9 + "_" + var10);
                        class80.field1476.method3446("l" + var9 + "_" + var10);
                     }
                  }
               }
            }

            class138.method3024(30);
            class47.method1009();
            class151.method3269();
            client.field337.method2903(94);
            class96.field1669.vmethod3260();

            for(var5 = 0; var5 < 32; ++var5) {
               class147.field2259[var5] = 0L;
            }

            for(var5 = 0; var5 < 32; ++var5) {
               class147.field2260[var5] = 0L;
            }

            class45.field1050 = 0;
         }
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "217217031"
   )
   static final void method131(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = class8.field144.method4167(var0, 250);
      int var6 = class8.field144.method4168(var0, 250) * 13;
      class82.method1907(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2, 0);
      class82.method1893(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2, 16777215);
      class8.field144.method4174(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class51.method1082(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2);
      if(var1) {
         try {
            Graphics var7 = class107.field1867.getGraphics();
            class54.field1173.vmethod1965(var7, 0, 0);
         } catch (Exception var8) {
            class107.field1867.repaint();
         }
      } else {
         class15.method187(var3, var4, var5, var6);
      }

   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(Lclass176;B)Z",
      garbageValue = "42"
   )
   static boolean method132(class176 var0) {
      if(client.field471) {
         if(class2.method39(var0) != 0) {
            return false;
         }

         if(var0.field2910 == 0) {
            return false;
         }
      }

      return var0.field2804;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([Lclass27;II[I[IS)V",
      garbageValue = "11702"
   )
   static void method133(class27[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = 1 + var2;
         int var7 = (var1 + var2) / 2;
         class27 var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].field673;
                     var12 = var8.field673;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].field669;
                     var12 = var8.field669;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method632()?1:0;
                     var12 = var8.method632()?1:0;
                  } else {
                     var11 = var0[var6].field667;
                     var12 = var8.field667;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].field673;
                     var12 = var8.field673;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].field669;
                     var12 = var8.field669;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method632()?1:0;
                     var12 = var8.method632()?1:0;
                  } else {
                     var11 = var0[var5].field667;
                     var12 = var8.field667;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               class27 var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method133(var0, var1, var6, var3, var4);
         method133(var0, 1 + var6, var2, var3, var4);
      }

   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "([Lclass176;II)V",
      garbageValue = "1712478199"
   )
   static final void method134(class176[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class176 var3 = var0[var2];
         if(null != var3) {
            if(var3.field2910 == 0) {
               if(var3.field2931 != null) {
                  method134(var3.field2931, var1);
               }

               class3 var4 = (class3)client.field475.method3936((long)var3.field2807);
               if(var4 != null) {
                  int var5 = var4.field70;
                  if(class14.method179(var5)) {
                     method134(class176.field2836[var5], var1);
                  }
               }
            }

            class0 var6;
            if(var1 == 0 && var3.field2914 != null) {
               var6 = new class0();
               var6.field2 = var3;
               var6.field8 = var3.field2914;
               class16.method203(var6);
            }

            if(var1 == 1 && var3.field2824 != null) {
               if(var3.field2813 >= 0) {
                  class176 var7 = class134.method2983(var3.field2807);
                  if(null == var7 || null == var7.field2931 || var3.field2813 >= var7.field2931.length || var3 != var7.field2931[var3.field2813]) {
                     continue;
                  }
               }

               var6 = new class0();
               var6.field2 = var3;
               var6.field8 = var3.field2824;
               class16.method203(var6);
            }
         }
      }

   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lclass176;I)Ljava/lang/String;",
      garbageValue = "1693276158"
   )
   static String method136(String var0, class176 var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var0 = var0.substring(0, var3) + class171.method3511(class31.method689(var1, var2 - 1)) + var0.substring(var3 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var6 = "";
            if(null != class105.field1834) {
               int var5 = class105.field1834.field2278;
               String var4 = (var5 >> 24 & 255) + "." + (var5 >> 16 & 255) + "." + (var5 >> 8 & 255) + "." + (var5 & 255);
               var6 = var4;
               if(null != class105.field1834.field2272) {
                  var6 = (String)class105.field1834.field2272;
               }
            }

            var0 = var0.substring(0, var2) + var6 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "1770626936"
   )
   public static int method137(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & 63);
         } else {
            var0[var4++] = (byte)(224 | var6 >> 12);
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & 63);
         }
      }

      return var4 - var1;
   }
}
