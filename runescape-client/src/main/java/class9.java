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
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3939(); null != var0; var0 = (WidgetNode)Client.componentTable.method3935()) {
         int var1 = var0.id;
         if(class14.method179(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(null != var3[var4]) {
                  var2 = var3[var4].field2855;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class134.method2983(var4);
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
      Client.field342 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class127.field2086.length; ++var1) {
         if(class119.field2037[var1] != -1 && class127.field2086[var1] == null) {
            class127.field2086[var1] = BufferProvider.field1476.method3411(class119.field2037[var1], 0);
            if(class127.field2086[var1] == null) {
               var0 = false;
               ++Client.field342;
            }
         }

         if(WidgetNode.field66[var1] != -1 && null == class109.field1944[var1]) {
            class109.field1944[var1] = BufferProvider.field1476.method3396(WidgetNode.field66[var1], 0, GameObject.xteaKeys[var1]);
            if(class109.field1944[var1] == null) {
               var0 = false;
               ++Client.field342;
            }
         }
      }

      if(!var0) {
         Client.field527 = 1;
      } else {
         Client.field493 = 0;
         var0 = true;

         int var2;
         int var3;
         for(var1 = 0; var1 < class127.field2086.length; ++var1) {
            byte[] var4 = class109.field1944[var1];
            if(var4 != null) {
               var2 = 64 * (Ignore.mapRegions[var1] >> 8) - class0.baseX;
               var3 = (Ignore.mapRegions[var1] & 255) * 64 - class21.baseY;
               if(Client.field355) {
                  var2 = 10;
                  var3 = 10;
               }

               var0 &= class143.method3111(var4, var2, var3);
            }
         }

         if(!var0) {
            Client.field527 = 2;
         } else {
            if(Client.field527 != 0) {
               method131("Loading - please wait.<br> (100%)", true);
            }

            class47.method1009();
            class31.method693();
            class47.method1009();
            class136.region.method1992();
            class47.method1009();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].method2493();
            }

            int var47;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var47 = 0; var47 < 104; ++var47) {
                  for(var2 = 0; var2 < 104; ++var2) {
                     class5.tileSettings[var1][var47][var2] = 0;
                  }
               }
            }

            class47.method1009();
            NPC.method762();
            var1 = class127.field2086.length;
            RSCanvas.method3089();
            class160.method3313(true);
            int var5;
            int var6;
            int var7;
            int var8;
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
            if(!Client.field355) {
               var47 = 0;

               label992:
               while(true) {
                  byte[] var21;
                  if(var47 >= var1) {
                     for(var47 = 0; var47 < var1; ++var47) {
                        var2 = (Ignore.mapRegions[var47] >> 8) * 64 - class0.baseX;
                        var3 = 64 * (Ignore.mapRegions[var47] & 255) - class21.baseY;
                        var21 = class127.field2086[var47];
                        if(null == var21 && class16.field242 < 800) {
                           class47.method1009();
                           class114.method2545(var2, var3, 64, 64);
                        }
                     }

                     class160.method3313(true);
                     var47 = 0;

                     while(true) {
                        if(var47 >= var1) {
                           break label992;
                        }

                        byte[] var49 = class109.field1944[var47];
                        if(null != var49) {
                           var3 = (Ignore.mapRegions[var47] >> 8) * 64 - class0.baseX;
                           var5 = 64 * (Ignore.mapRegions[var47] & 255) - class21.baseY;
                           class47.method1009();
                           Region var51 = class136.region;
                           CollisionData[] var24 = Client.collisionMaps;
                           Buffer var25 = new Buffer(var49);
                           var8 = -1;

                           while(true) {
                              var9 = var25.method2646();
                              if(var9 == 0) {
                                 break;
                              }

                              var8 += var9;
                              var10 = 0;

                              while(true) {
                                 var11 = var25.method2646();
                                 if(var11 == 0) {
                                    break;
                                 }

                                 var10 += var11 - 1;
                                 var12 = var10 & 63;
                                 var13 = var10 >> 6 & 63;
                                 var14 = var10 >> 12;
                                 var15 = var25.method2633();
                                 var16 = var15 >> 2;
                                 var17 = var15 & 3;
                                 var18 = var13 + var3;
                                 var19 = var5 + var12;
                                 if(var18 > 0 && var19 > 0 && var18 < 103 && var19 < 103) {
                                    var20 = var14;
                                    if((class5.tileSettings[1][var18][var19] & 2) == 2) {
                                       var20 = var14 - 1;
                                    }

                                    CollisionData var26 = null;
                                    if(var20 >= 0) {
                                       var26 = var24[var20];
                                    }

                                    class177.method3597(var14, var18, var19, var8, var17, var16, var51, var26);
                                 }
                              }
                           }
                        }

                        ++var47;
                     }
                  }

                  var2 = (Ignore.mapRegions[var47] >> 8) * 64 - class0.baseX;
                  var3 = (Ignore.mapRegions[var47] & 255) * 64 - class21.baseY;
                  var21 = class127.field2086[var47];
                  if(var21 != null) {
                     class47.method1009();
                     var6 = class48.field1092 * 8 - 48;
                     var7 = class16.field242 * 8 - 48;
                     CollisionData[] var22 = Client.collisionMaps;
                     var8 = 0;

                     label989:
                     while(true) {
                        if(var8 >= 4) {
                           Buffer var23 = new Buffer(var21);
                           var9 = 0;

                           while(true) {
                              if(var9 >= 4) {
                                 break label989;
                              }

                              for(var10 = 0; var10 < 64; ++var10) {
                                 for(var11 = 0; var11 < 64; ++var11) {
                                    GroundObject.method2252(var23, var9, var10 + var2, var11 + var3, var6, var7, 0);
                                 }
                              }

                              ++var9;
                           }
                        }

                        for(var9 = 0; var9 < 64; ++var9) {
                           for(var10 = 0; var10 < 64; ++var10) {
                              if(var9 + var2 > 0 && var2 + var9 < 103 && var3 + var10 > 0 && var3 + var10 < 103) {
                                 var22[var8].flags[var9 + var2][var10 + var3] &= -16777217;
                              }
                           }
                        }

                        ++var8;
                     }
                  }

                  ++var47;
               }
            }

            int var48;
            if(Client.field355) {
               var47 = 0;

               label925:
               while(true) {
                  if(var47 >= 4) {
                     for(var47 = 0; var47 < 13; ++var47) {
                        for(var2 = 0; var2 < 13; ++var2) {
                           var3 = Client.field356[0][var47][var2];
                           if(var3 == -1) {
                              class114.method2545(8 * var47, 8 * var2, 8, 8);
                           }
                        }
                     }

                     class160.method3313(true);
                     var47 = 0;

                     while(true) {
                        if(var47 >= 4) {
                           break label925;
                        }

                        class47.method1009();

                        for(var2 = 0; var2 < 13; ++var2) {
                           for(var3 = 0; var3 < 13; ++var3) {
                              var5 = Client.field356[var47][var2][var3];
                              if(var5 != -1) {
                                 var6 = var5 >> 24 & 3;
                                 var7 = var5 >> 1 & 3;
                                 var48 = var5 >> 14 & 1023;
                                 var8 = var5 >> 3 & 2047;
                                 var9 = var8 / 8 + (var48 / 8 << 8);

                                 for(var10 = 0; var10 < Ignore.mapRegions.length; ++var10) {
                                    if(var9 == Ignore.mapRegions[var10] && null != class109.field1944[var10]) {
                                       class107.method2396(class109.field1944[var10], var47, 8 * var2, var3 * 8, var6, 8 * (var48 & 7), 8 * (var8 & 7), var7, class136.region, Client.collisionMaps);
                                       break;
                                    }
                                 }
                              }
                           }
                        }

                        ++var47;
                     }
                  }

                  class47.method1009();

                  for(var2 = 0; var2 < 13; ++var2) {
                     for(var3 = 0; var3 < 13; ++var3) {
                        boolean var50 = false;
                        var6 = Client.field356[var47][var2][var3];
                        if(var6 != -1) {
                           var7 = var6 >> 24 & 3;
                           var48 = var6 >> 1 & 3;
                           var8 = var6 >> 14 & 1023;
                           var9 = var6 >> 3 & 2047;
                           var10 = var9 / 8 + (var8 / 8 << 8);

                           for(var11 = 0; var11 < Ignore.mapRegions.length; ++var11) {
                              if(Ignore.mapRegions[var11] == var10 && class127.field2086[var11] != null) {
                                 class1.method5(class127.field2086[var11], var47, 8 * var2, var3 * 8, var7, 8 * (var8 & 7), 8 * (var9 & 7), var48, Client.collisionMaps);
                                 var50 = true;
                                 break;
                              }
                           }
                        }

                        if(!var50) {
                           DecorativeObject.method2256(var47, var2 * 8, var3 * 8);
                        }
                     }
                  }

                  ++var47;
               }
            }

            class160.method3313(true);
            class31.method693();
            class47.method1009();
            Region var52 = class136.region;
            CollisionData[] var53 = Client.collisionMaps;

            for(var3 = 0; var3 < 4; ++var3) {
               for(var5 = 0; var5 < 104; ++var5) {
                  for(var6 = 0; var6 < 104; ++var6) {
                     if((class5.tileSettings[var3][var5][var6] & 1) == 1) {
                        var7 = var3;
                        if((class5.tileSettings[1][var5][var6] & 2) == 2) {
                           var7 = var3 - 1;
                        }

                        if(var7 >= 0) {
                           var53[var7].method2497(var5, var6);
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

            for(var3 = 0; var3 < 4; ++var3) {
               byte[][] var54 = class232.field3275[var3];
               var10 = (int)Math.sqrt(5100.0D);
               var11 = var10 * 768 >> 8;

               int var56;
               for(var12 = 1; var12 < 103; ++var12) {
                  for(var13 = 1; var13 < 103; ++var13) {
                     var14 = class5.tileHeights[var3][var13 + 1][var12] - class5.tileHeights[var3][var13 - 1][var12];
                     var15 = class5.tileHeights[var3][var13][1 + var12] - class5.tileHeights[var3][var13][var12 - 1];
                     var16 = (int)Math.sqrt((double)(65536 + var14 * var14 + var15 * var15));
                     var17 = (var14 << 8) / var16;
                     var18 = 65536 / var16;
                     var19 = (var15 << 8) / var16;
                     var20 = (var17 * -50 + -10 * var18 + var19 * -50) / var11 + 96;
                     var56 = (var54[var13][var12] >> 1) + (var54[var13 + 1][var12] >> 3) + (var54[var13 - 1][var12] >> 2) + (var54[var13][var12 - 1] >> 2) + (var54[var13][var12 + 1] >> 3);
                     class13.field207[var13][var12] = var20 - var56;
                  }
               }

               for(var12 = 0; var12 < 104; ++var12) {
                  class5.field83[var12] = 0;
                  class5.field87[var12] = 0;
                  class5.field96[var12] = 0;
                  MessageNode.field809[var12] = 0;
                  class224.field3225[var12] = 0;
               }

               for(var12 = -5; var12 < 109; ++var12) {
                  for(var13 = 0; var13 < 104; ++var13) {
                     var14 = var12 + 5;
                     class43 var58;
                     if(var14 >= 0 && var14 < 104) {
                        var15 = class5.field82[var3][var14][var13] & 255;
                        if(var15 > 0) {
                           var58 = class23.method601(var15 - 1);
                           class5.field83[var13] += var58.field999;
                           class5.field87[var13] += var58.field1003;
                           class5.field96[var13] += var58.field1004;
                           MessageNode.field809[var13] += var58.field1005;
                           ++class224.field3225[var13];
                        }
                     }

                     var15 = var12 - 5;
                     if(var15 >= 0 && var15 < 104) {
                        var16 = class5.field82[var3][var15][var13] & 255;
                        if(var16 > 0) {
                           var58 = class23.method601(var16 - 1);
                           class5.field83[var13] -= var58.field999;
                           class5.field87[var13] -= var58.field1003;
                           class5.field96[var13] -= var58.field1004;
                           MessageNode.field809[var13] -= var58.field1005;
                           --class224.field3225[var13];
                        }
                     }
                  }

                  if(var12 >= 1 && var12 < 103) {
                     var13 = 0;
                     var14 = 0;
                     var15 = 0;
                     var16 = 0;
                     var17 = 0;

                     for(var18 = -5; var18 < 109; ++var18) {
                        var19 = 5 + var18;
                        if(var19 >= 0 && var19 < 104) {
                           var13 += class5.field83[var19];
                           var14 += class5.field87[var19];
                           var15 += class5.field96[var19];
                           var16 += MessageNode.field809[var19];
                           var17 += class224.field3225[var19];
                        }

                        var20 = var18 - 5;
                        if(var20 >= 0 && var20 < 104) {
                           var13 -= class5.field83[var20];
                           var14 -= class5.field87[var20];
                           var15 -= class5.field96[var20];
                           var16 -= MessageNode.field809[var20];
                           var17 -= class224.field3225[var20];
                        }

                        if(var18 >= 1 && var18 < 103 && (!Client.field301 || (class5.tileSettings[0][var12][var18] & 2) != 0 || (class5.tileSettings[var3][var12][var18] & 16) == 0)) {
                           if(var3 < class5.field81) {
                              class5.field81 = var3;
                           }

                           var56 = class5.field82[var3][var12][var18] & 255;
                           int var59 = class75.field1422[var3][var12][var18] & 255;
                           if(var56 > 0 || var59 > 0) {
                              int var27 = class5.tileHeights[var3][var12][var18];
                              int var28 = class5.tileHeights[var3][var12 + 1][var18];
                              int var29 = class5.tileHeights[var3][var12 + 1][1 + var18];
                              int var30 = class5.tileHeights[var3][var12][var18 + 1];
                              int var31 = class13.field207[var12][var18];
                              int var32 = class13.field207[var12 + 1][var18];
                              int var33 = class13.field207[var12 + 1][var18 + 1];
                              int var34 = class13.field207[var12][1 + var18];
                              int var35 = -1;
                              int var36 = -1;
                              int var37;
                              int var38;
                              if(var56 > 0) {
                                 var37 = 256 * var13 / var16;
                                 var38 = var14 / var17;
                                 int var39 = var15 / var17;
                                 var35 = class151.method3274(var37, var38, var39);
                                 var37 = var37 + class5.field84 & 255;
                                 var39 += class5.field97;
                                 if(var39 < 0) {
                                    var39 = 0;
                                 } else if(var39 > 255) {
                                    var39 = 255;
                                 }

                                 var36 = class151.method3274(var37, var38, var39);
                              }

                              if(var3 > 0) {
                                 boolean var60 = true;
                                 if(var56 == 0 && class5.field88[var3][var12][var18] != 0) {
                                    var60 = false;
                                 }

                                 if(var59 > 0 && !class16.method204(var59 - 1).field1077) {
                                    var60 = false;
                                 }

                                 if(var60 && var28 == var27 && var27 == var29 && var27 == var30) {
                                    VertexNormal.field1704[var3][var12][var18] |= 2340;
                                 }
                              }

                              var37 = 0;
                              if(var36 != -1) {
                                 var37 = class94.colorPalette[class113.method2538(var36, 96)];
                              }

                              if(var59 == 0) {
                                 var52.method1997(var3, var12, var18, 0, 0, -1, var27, var28, var29, var30, class113.method2538(var35, var31), class113.method2538(var35, var32), class113.method2538(var35, var33), class113.method2538(var35, var34), 0, 0, 0, 0, var37, 0);
                              } else {
                                 var38 = class5.field88[var3][var12][var18] + 1;
                                 byte var61 = class5.field86[var3][var12][var18];
                                 class48 var40 = class16.method204(var59 - 1);
                                 int var41 = var40.field1087;
                                 int var42;
                                 int var43;
                                 int var44;
                                 int var45;
                                 if(var41 >= 0) {
                                    var43 = class94.field1658.vmethod2260(var41);
                                    var42 = -1;
                                 } else if(var40.field1079 == 16711935) {
                                    var42 = -2;
                                    var41 = -1;
                                    var43 = -2;
                                 } else {
                                    var42 = class151.method3274(var40.field1083, var40.field1084, var40.field1085);
                                    var44 = class5.field84 + var40.field1083 & 255;
                                    var45 = var40.field1085 + class5.field97;
                                    if(var45 < 0) {
                                       var45 = 0;
                                    } else if(var45 > 255) {
                                       var45 = 255;
                                    }

                                    var43 = class151.method3274(var44, var40.field1084, var45);
                                 }

                                 var44 = 0;
                                 if(var43 != -2) {
                                    var44 = class94.colorPalette[class40.method813(var43, 96)];
                                 }

                                 if(var40.field1082 != -1) {
                                    var45 = class5.field84 + var40.field1090 & 255;
                                    int var46 = class5.field97 + var40.field1088;
                                    if(var46 < 0) {
                                       var46 = 0;
                                    } else if(var46 > 255) {
                                       var46 = 255;
                                    }

                                    var43 = class151.method3274(var45, var40.field1080, var46);
                                    var44 = class94.colorPalette[class40.method813(var43, 96)];
                                 }

                                 var52.method1997(var3, var12, var18, var38, var61, var41, var27, var28, var29, var30, class113.method2538(var35, var31), class113.method2538(var35, var32), class113.method2538(var35, var33), class113.method2538(var35, var34), class40.method813(var42, var31), class40.method813(var42, var32), class40.method813(var42, var33), class40.method813(var42, var34), var37, var44);
                              }
                           }
                        }
                     }
                  }
               }

               for(var12 = 1; var12 < 103; ++var12) {
                  for(var13 = 1; var13 < 103; ++var13) {
                     if((class5.tileSettings[var3][var13][var12] & 8) != 0) {
                        var18 = 0;
                     } else if(var3 > 0 && (class5.tileSettings[1][var13][var12] & 2) != 0) {
                        var18 = var3 - 1;
                     } else {
                        var18 = var3;
                     }

                     var52.method2073(var3, var13, var12, var18);
                  }
               }

               class5.field82[var3] = (byte[][])null;
               class75.field1422[var3] = (byte[][])null;
               class5.field88[var3] = (byte[][])null;
               class5.field86[var3] = (byte[][])null;
               class232.field3275[var3] = (byte[][])null;
            }

            var52.method2022(-50, -10, -50);

            for(var3 = 0; var3 < 104; ++var3) {
               for(var5 = 0; var5 < 104; ++var5) {
                  if((class5.tileSettings[1][var3][var5] & 2) == 2) {
                     var52.method2061(var3, var5);
                  }
               }
            }

            var3 = 1;
            var5 = 2;
            var6 = 4;

            for(var7 = 0; var7 < 4; ++var7) {
               if(var7 > 0) {
                  var3 <<= 3;
                  var5 <<= 3;
                  var6 <<= 3;
               }

               for(var48 = 0; var48 <= var7; ++var48) {
                  for(var8 = 0; var8 <= 104; ++var8) {
                     for(var9 = 0; var9 <= 104; ++var9) {
                        short var55;
                        if((VertexNormal.field1704[var48][var9][var8] & var3) != 0) {
                           var10 = var8;
                           var11 = var8;
                           var12 = var48;

                           for(var13 = var48; var10 > 0 && (VertexNormal.field1704[var48][var9][var10 - 1] & var3) != 0; --var10) {
                              ;
                           }

                           while(var11 < 104 && (VertexNormal.field1704[var48][var9][var11 + 1] & var3) != 0) {
                              ++var11;
                           }

                           label610:
                           while(var12 > 0) {
                              for(var14 = var10; var14 <= var11; ++var14) {
                                 if((VertexNormal.field1704[var12 - 1][var9][var14] & var3) == 0) {
                                    break label610;
                                 }
                              }

                              --var12;
                           }

                           label599:
                           while(var13 < var7) {
                              for(var14 = var10; var14 <= var11; ++var14) {
                                 if((VertexNormal.field1704[1 + var13][var9][var14] & var3) == 0) {
                                    break label599;
                                 }
                              }

                              ++var13;
                           }

                           var14 = (1 + (var11 - var10)) * (var13 + 1 - var12);
                           if(var14 >= 8) {
                              var55 = 240;
                              var16 = class5.tileHeights[var13][var9][var10] - var55;
                              var17 = class5.tileHeights[var12][var9][var10];
                              Region.method1995(var7, 1, var9 * 128, 128 * var9, 128 * var10, 128 * var11 + 128, var16, var17);

                              for(var18 = var12; var18 <= var13; ++var18) {
                                 for(var19 = var10; var19 <= var11; ++var19) {
                                    VertexNormal.field1704[var18][var9][var19] &= ~var3;
                                 }
                              }
                           }
                        }

                        if((VertexNormal.field1704[var48][var9][var8] & var5) != 0) {
                           var10 = var9;
                           var11 = var9;
                           var12 = var48;

                           for(var13 = var48; var10 > 0 && (VertexNormal.field1704[var48][var10 - 1][var8] & var5) != 0; --var10) {
                              ;
                           }

                           while(var11 < 104 && (VertexNormal.field1704[var48][1 + var11][var8] & var5) != 0) {
                              ++var11;
                           }

                           label663:
                           while(var12 > 0) {
                              for(var14 = var10; var14 <= var11; ++var14) {
                                 if((VertexNormal.field1704[var12 - 1][var14][var8] & var5) == 0) {
                                    break label663;
                                 }
                              }

                              --var12;
                           }

                           label652:
                           while(var13 < var7) {
                              for(var14 = var10; var14 <= var11; ++var14) {
                                 if((VertexNormal.field1704[1 + var13][var14][var8] & var5) == 0) {
                                    break label652;
                                 }
                              }

                              ++var13;
                           }

                           var14 = (1 + (var11 - var10)) * (var13 + 1 - var12);
                           if(var14 >= 8) {
                              var55 = 240;
                              var16 = class5.tileHeights[var13][var10][var8] - var55;
                              var17 = class5.tileHeights[var12][var10][var8];
                              Region.method1995(var7, 2, var10 * 128, var11 * 128 + 128, var8 * 128, var8 * 128, var16, var17);

                              for(var18 = var12; var18 <= var13; ++var18) {
                                 for(var19 = var10; var19 <= var11; ++var19) {
                                    VertexNormal.field1704[var18][var19][var8] &= ~var5;
                                 }
                              }
                           }
                        }

                        if((VertexNormal.field1704[var48][var9][var8] & var6) != 0) {
                           var10 = var9;
                           var11 = var9;
                           var12 = var8;

                           for(var13 = var8; var12 > 0 && (VertexNormal.field1704[var48][var9][var12 - 1] & var6) != 0; --var12) {
                              ;
                           }

                           while(var13 < 104 && (VertexNormal.field1704[var48][var9][var13 + 1] & var6) != 0) {
                              ++var13;
                           }

                           label716:
                           while(var10 > 0) {
                              for(var14 = var12; var14 <= var13; ++var14) {
                                 if((VertexNormal.field1704[var48][var10 - 1][var14] & var6) == 0) {
                                    break label716;
                                 }
                              }

                              --var10;
                           }

                           label705:
                           while(var11 < 104) {
                              for(var14 = var12; var14 <= var13; ++var14) {
                                 if((VertexNormal.field1704[var48][var11 + 1][var14] & var6) == 0) {
                                    break label705;
                                 }
                              }

                              ++var11;
                           }

                           if((var13 - var12 + 1) * (1 + (var11 - var10)) >= 4) {
                              var14 = class5.tileHeights[var48][var10][var12];
                              Region.method1995(var7, 4, 128 * var10, 128 + 128 * var11, var12 * 128, 128 * var13 + 128, var14, var14);

                              for(var15 = var10; var15 <= var11; ++var15) {
                                 for(var16 = var12; var16 <= var13; ++var16) {
                                    VertexNormal.field1704[var48][var15][var16] &= ~var6;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            class160.method3313(true);
            var3 = class5.field81;
            if(var3 > VertexNormal.plane) {
               var3 = VertexNormal.plane;
            }

            if(var3 < VertexNormal.plane - 1) {
               var3 = VertexNormal.plane - 1;
            }

            if(Client.field301) {
               class136.region.method1993(class5.field81);
            } else {
               class136.region.method1993(0);
            }

            for(var5 = 0; var5 < 104; ++var5) {
               for(var6 = 0; var6 < 104; ++var6) {
                  class144.groundItemSpawned(var5, var6);
               }
            }

            class47.method1009();

            for(class16 var57 = (class16)Client.field427.method3980(); null != var57; var57 = (class16)Client.field427.method3970()) {
               if(var57.field237 == -1) {
                  var57.field241 = 0;
                  ChatMessages.method253(var57);
               } else {
                  var57.unlink();
               }
            }

            ObjectComposition.field948.reset();
            if(class114.field2013 != null) {
               Client.field337.method2903(251);
               Client.field337.method2728(1057001181);
            }

            if(!Client.field355) {
               var5 = (class48.field1092 - 6) / 8;
               var6 = (class48.field1092 + 6) / 8;
               var7 = (class16.field242 - 6) / 8;
               var48 = (class16.field242 + 6) / 8;

               for(var8 = var5 - 1; var8 <= var6 + 1; ++var8) {
                  for(var9 = var7 - 1; var9 <= var48 + 1; ++var9) {
                     if(var8 < var5 || var8 > var6 || var9 < var7 || var9 > var48) {
                        BufferProvider.field1476.method3446("m" + var8 + "_" + var9);
                        BufferProvider.field1476.method3446("l" + var8 + "_" + var9);
                     }
                  }
               }
            }

            class138.setGameState(30);
            class47.method1009();
            class151.method3269();
            Client.field337.method2903(94);
            GroundObject.field1669.vmethod3260();

            for(var5 = 0; var5 < 32; ++var5) {
               GameEngine.field2259[var5] = 0L;
            }

            for(var5 = 0; var5 < 32; ++var5) {
               GameEngine.field2260[var5] = 0L;
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
            Graphics var7 = class107.canvas.getGraphics();
            class54.bufferProvider.draw(var7, 0, 0);
         } catch (Exception var8) {
            class107.canvas.repaint();
         }
      } else {
         XItemContainer.method187(var3, var4, var5, var6);
      }

   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "42"
   )
   static boolean method132(Widget var0) {
      if(Client.field471) {
         if(Player.method39(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([LWorld;II[I[IS)V",
      garbageValue = "11702"
   )
   static void method133(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = 1 + var2;
         int var7 = (var1 + var2) / 2;
         World var8 = var0[var7];
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
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
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
                     var11 = var0[var6].id;
                     var12 = var8.id;
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
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
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
                     var11 = var0[var5].id;
                     var12 = var8.id;
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
               World var13 = var0[var5];
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
      signature = "([LWidget;II)V",
      garbageValue = "1712478199"
   )
   static final void method134(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(null != var3) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method134(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method3936((long)var3.id);
               if(var4 != null) {
                  int var5 = var4.id;
                  if(class14.method179(var5)) {
                     method134(Widget.widgets[var5], var1);
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
               if(var3.index >= 0) {
                  Widget var7 = class134.method2983(var3.id);
                  if(null == var7 || null == var7.children || var3.index >= var7.children.length || var3 != var7.children[var3.index]) {
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
      signature = "(Ljava/lang/String;LWidget;I)Ljava/lang/String;",
      garbageValue = "1693276158"
   )
   static String method136(String var0, Widget var1) {
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
            if(null != FrameMap.field1834) {
               int var4 = FrameMap.field1834.field2278;
               String var5 = (var4 >> 24 & 255) + "." + (var4 >> 16 & 255) + "." + (var4 >> 8 & 255) + "." + (var4 & 255);
               var6 = var5;
               if(null != FrameMap.field1834.field2272) {
                  var6 = (String)FrameMap.field1834.field2272;
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
