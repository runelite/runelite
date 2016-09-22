import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
public class class112 {
   @ObfuscatedName("u")
   public static boolean field1988;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1526569567"
   )
   public static int method2443() {
      return ++class143.mouseIdleTicks - 1;
   }

   static {
      new HashMap();
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static final void method2445() {
      XItemContainer.method177(false);
      Client.field289 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class28.field688.length; ++var1) {
         if(class47.field1067[var1] != -1 && null == class28.field688[var1]) {
            class28.field688[var1] = class1.field18.method3309(class47.field1067[var1], 0);
            if(null == class28.field688[var1]) {
               var0 = false;
               ++Client.field289;
            }
         }

         if(class48.field1089[var1] != -1 && null == SecondaryBufferProvider.field1446[var1]) {
            SecondaryBufferProvider.field1446[var1] = class1.field18.method3310(class48.field1089[var1], 0, Friend.xteaKeys[var1]);
            if(SecondaryBufferProvider.field1446[var1] == null) {
               var0 = false;
               ++Client.field289;
            }
         }
      }

      if(!var0) {
         Client.field340 = 1;
      } else {
         Client.field338 = 0;
         var0 = true;

         int var3;
         int var4;
         Buffer var8;
         int var9;
         int var10;
         int var11;
         int var13;
         int var14;
         int var15;
         int var16;
         int var17;
         int var18;
         for(var1 = 0; var1 < class28.field688.length; ++var1) {
            byte[] var2 = SecondaryBufferProvider.field1446[var1];
            if(var2 != null) {
               var3 = 64 * (class20.mapRegions[var1] >> 8) - class9.baseX;
               var4 = 64 * (class20.mapRegions[var1] & 255) - KitDefinition.baseY;
               if(Client.field342) {
                  var3 = 10;
                  var4 = 10;
               }

               boolean var7 = true;
               var8 = new Buffer(var2);
               var9 = -1;

               label1700:
               while(true) {
                  var10 = var8.method2710();
                  if(var10 == 0) {
                     var0 &= var7;
                     break;
                  }

                  var9 += var10;
                  var11 = 0;
                  boolean var12 = false;

                  while(true) {
                     while(!var12) {
                        var13 = var8.method2710();
                        if(var13 == 0) {
                           continue label1700;
                        }

                        var11 += var13 - 1;
                        var14 = var11 & 63;
                        var15 = var11 >> 6 & 63;
                        var16 = var8.method2528() >> 2;
                        var17 = var15 + var3;
                        var18 = var14 + var4;
                        if(var17 > 0 && var18 > 0 && var17 < 103 && var18 < 103) {
                           ObjectComposition var19 = class165.getObjectDefinition(var9);
                           if(var16 != 22 || !Client.field285 || var19.field967 != 0 || var19.field965 == 1 || var19.field986) {
                              if(!var19.method884()) {
                                 ++Client.field338;
                                 var7 = false;
                              }

                              var12 = true;
                           }
                        }
                     }

                     var13 = var8.method2710();
                     if(var13 == 0) {
                        break;
                     }

                     var8.method2528();
                  }
               }
            }
         }

         if(!var0) {
            Client.field340 = 2;
         } else {
            if(Client.field340 != 0) {
               class38.method779("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            WidgetNode.method41();
            class14.method171();
            WidgetNode.method41();
            class16.region.method2083();
            WidgetNode.method41();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].method2417();
            }

            int var48;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var48 = 0; var48 < 104; ++var48) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class5.tileSettings[var1][var48][var3] = 0;
                  }
               }
            }

            WidgetNode.method41();
            class138.method2913();
            var1 = class28.field688.length;

            for(class24 var64 = (class24)class24.field629.method3854(); null != var64; var64 = (class24)class24.field629.method3869()) {
               if(var64.field617 != null) {
                  GameObject.field1759.method1188(var64.field617);
                  var64.field617 = null;
               }

               if(null != var64.field619) {
                  GameObject.field1759.method1188(var64.field619);
                  var64.field619 = null;
               }
            }

            class24.field629.method3848();
            XItemContainer.method177(true);
            int var6;
            int var20;
            int var21;
            int var46;
            int var47;
            int var68;
            int var70;
            if(!Client.field342) {
               byte[] var5;
               for(var48 = 0; var48 < var1; ++var48) {
                  var3 = 64 * (class20.mapRegions[var48] >> 8) - class9.baseX;
                  var4 = (class20.mapRegions[var48] & 255) * 64 - KitDefinition.baseY;
                  var5 = class28.field688[var48];
                  if(null != var5) {
                     WidgetNode.method41();
                     var6 = class159.field2372 * 8 - 48;
                     var68 = WidgetNode.field66 * 8 - 48;
                     CollisionData[] var69 = Client.collisionMaps;

                     for(var9 = 0; var9 < 4; ++var9) {
                        for(var10 = 0; var10 < 64; ++var10) {
                           for(var11 = 0; var11 < 64; ++var11) {
                              if(var10 + var3 > 0 && var3 + var10 < 103 && var11 + var4 > 0 && var4 + var11 < 103) {
                                 var69[var9].flags[var10 + var3][var4 + var11] &= -16777217;
                              }
                           }
                        }
                     }

                     Buffer var61 = new Buffer(var5);

                     for(var10 = 0; var10 < 4; ++var10) {
                        for(var11 = 0; var11 < 64; ++var11) {
                           for(var70 = 0; var70 < 64; ++var70) {
                              KitDefinition.method978(var61, var10, var3 + var11, var70 + var4, var6, var68, 0);
                           }
                        }
                     }
                  }
               }

               for(var48 = 0; var48 < var1; ++var48) {
                  var3 = 64 * (class20.mapRegions[var48] >> 8) - class9.baseX;
                  var4 = 64 * (class20.mapRegions[var48] & 255) - KitDefinition.baseY;
                  var5 = class28.field688[var48];
                  if(null == var5 && WidgetNode.field66 < 800) {
                     WidgetNode.method41();
                     class0.method0(var3, var4, 64, 64);
                  }
               }

               XItemContainer.method177(true);

               for(var48 = 0; var48 < var1; ++var48) {
                  byte[] var51 = SecondaryBufferProvider.field1446[var48];
                  if(var51 != null) {
                     var4 = 64 * (class20.mapRegions[var48] >> 8) - class9.baseX;
                     var46 = 64 * (class20.mapRegions[var48] & 255) - KitDefinition.baseY;
                     WidgetNode.method41();
                     Region var52 = class16.region;
                     CollisionData[] var49 = Client.collisionMaps;
                     var8 = new Buffer(var51);
                     var9 = -1;

                     while(true) {
                        var10 = var8.method2710();
                        if(var10 == 0) {
                           break;
                        }

                        var9 += var10;
                        var11 = 0;

                        while(true) {
                           var70 = var8.method2710();
                           if(var70 == 0) {
                              break;
                           }

                           var11 += var70 - 1;
                           var13 = var11 & 63;
                           var14 = var11 >> 6 & 63;
                           var15 = var11 >> 12;
                           var16 = var8.method2528();
                           var17 = var16 >> 2;
                           var18 = var16 & 3;
                           var47 = var4 + var14;
                           var20 = var46 + var13;
                           if(var47 > 0 && var20 > 0 && var47 < 103 && var20 < 103) {
                              var21 = var15;
                              if((class5.tileSettings[1][var47][var20] & 2) == 2) {
                                 var21 = var15 - 1;
                              }

                              CollisionData var53 = null;
                              if(var21 >= 0) {
                                 var53 = var49[var21];
                              }

                              class14.method170(var15, var47, var20, var9, var18, var17, var52, var53);
                           }
                        }
                     }
                  }
               }
            }

            int var22;
            int var23;
            int var24;
            int var25;
            int var26;
            int var27;
            int var28;
            int var29;
            int var30;
            int var32;
            int var33;
            int var34;
            int var35;
            int var36;
            int var38;
            int var39;
            int var40;
            int var44;
            if(Client.field342) {
               CollisionData[] var54;
               Buffer var71;
               for(var48 = 0; var48 < 4; ++var48) {
                  WidgetNode.method41();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var77 = false;
                        var6 = Client.field475[var48][var3][var4];
                        if(var6 != -1) {
                           var68 = var6 >> 24 & 3;
                           var44 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = var10 / 8 + (var9 / 8 << 8);

                           for(var70 = 0; var70 < class20.mapRegions.length; ++var70) {
                              if(class20.mapRegions[var70] == var11 && null != class28.field688[var70]) {
                                 byte[] var55 = class28.field688[var70];
                                 var14 = 8 * var3;
                                 var15 = var4 * 8;
                                 var16 = (var9 & 7) * 8;
                                 var17 = 8 * (var10 & 7);
                                 var54 = Client.collisionMaps;

                                 for(var47 = 0; var47 < 8; ++var47) {
                                    for(var20 = 0; var20 < 8; ++var20) {
                                       if(var47 + var14 > 0 && var14 + var47 < 103 && var20 + var15 > 0 && var15 + var20 < 103) {
                                          var54[var48].flags[var14 + var47][var15 + var20] &= -16777217;
                                       }
                                    }
                                 }

                                 var71 = new Buffer(var55);

                                 for(var20 = 0; var20 < 4; ++var20) {
                                    for(var21 = 0; var21 < 64; ++var21) {
                                       for(var22 = 0; var22 < 64; ++var22) {
                                          if(var68 == var20 && var21 >= var16 && var21 < var16 + 8 && var22 >= var17 && var22 < var17 + 8) {
                                             var25 = var14 + SecondaryBufferProvider.method1681(var21 & 7, var22 & 7, var44);
                                             var28 = var21 & 7;
                                             var29 = var22 & 7;
                                             var30 = var44 & 3;
                                             if(var30 == 0) {
                                                var27 = var29;
                                             } else if(var30 == 1) {
                                                var27 = 7 - var28;
                                             } else if(var30 == 2) {
                                                var27 = 7 - var29;
                                             } else {
                                                var27 = var28;
                                             }

                                             KitDefinition.method978(var71, var48, var25, var27 + var15, 0, 0, var44);
                                          } else {
                                             KitDefinition.method978(var71, 0, -1, -1, 0, 0, 0);
                                          }
                                       }
                                    }
                                 }

                                 var77 = true;
                                 break;
                              }
                           }
                        }

                        if(!var77) {
                           WidgetNode.method42(var48, var3 * 8, 8 * var4);
                        }
                     }
                  }
               }

               for(var48 = 0; var48 < 13; ++var48) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.field475[0][var48][var3];
                     if(var4 == -1) {
                        class0.method0(var48 * 8, 8 * var3, 8, 8);
                     }
                  }
               }

               XItemContainer.method177(true);

               for(var48 = 0; var48 < 4; ++var48) {
                  WidgetNode.method41();

                  for(var3 = 0; var3 < 13; ++var3) {
                     label1486:
                     for(var4 = 0; var4 < 13; ++var4) {
                        var46 = Client.field475[var48][var3][var4];
                        if(var46 != -1) {
                           var6 = var46 >> 24 & 3;
                           var68 = var46 >> 1 & 3;
                           var44 = var46 >> 14 & 1023;
                           var9 = var46 >> 3 & 2047;
                           var10 = var9 / 8 + (var44 / 8 << 8);

                           for(var11 = 0; var11 < class20.mapRegions.length; ++var11) {
                              if(class20.mapRegions[var11] == var10 && null != SecondaryBufferProvider.field1446[var11]) {
                                 byte[] var59 = SecondaryBufferProvider.field1446[var11];
                                 var13 = var3 * 8;
                                 var14 = var4 * 8;
                                 var15 = 8 * (var44 & 7);
                                 var16 = 8 * (var9 & 7);
                                 Region var45 = class16.region;
                                 var54 = Client.collisionMaps;
                                 var71 = new Buffer(var59);
                                 var20 = -1;

                                 while(true) {
                                    var21 = var71.method2710();
                                    if(var21 == 0) {
                                       continue label1486;
                                    }

                                    var20 += var21;
                                    var22 = 0;

                                    while(true) {
                                       var23 = var71.method2710();
                                       if(var23 == 0) {
                                          break;
                                       }

                                       var22 += var23 - 1;
                                       var24 = var22 & 63;
                                       var25 = var22 >> 6 & 63;
                                       var26 = var22 >> 12;
                                       var27 = var71.method2528();
                                       var28 = var27 >> 2;
                                       var29 = var27 & 3;
                                       if(var6 == var26 && var25 >= var15 && var25 < 8 + var15 && var24 >= var16 && var24 < var16 + 8) {
                                          ObjectComposition var57 = class165.getObjectDefinition(var20);
                                          var33 = var25 & 7;
                                          var34 = var24 & 7;
                                          var36 = var57.field963;
                                          int var58 = var57.field964;
                                          if((var29 & 1) == 1) {
                                             var38 = var36;
                                             var36 = var58;
                                             var58 = var38;
                                          }

                                          var35 = var68 & 3;
                                          if(var35 == 0) {
                                             var32 = var33;
                                          } else if(var35 == 1) {
                                             var32 = var34;
                                          } else if(var35 == 2) {
                                             var32 = 7 - var33 - (var36 - 1);
                                          } else {
                                             var32 = 7 - var34 - (var58 - 1);
                                          }

                                          var38 = var13 + var32;
                                          var39 = var14 + class138.method2914(var25 & 7, var24 & 7, var68, var57.field963, var57.field964, var29);
                                          if(var38 > 0 && var39 > 0 && var38 < 103 && var39 < 103) {
                                             var40 = var48;
                                             if((class5.tileSettings[1][var38][var39] & 2) == 2) {
                                                var40 = var48 - 1;
                                             }

                                             CollisionData var60 = null;
                                             if(var40 >= 0) {
                                                var60 = var54[var40];
                                             }

                                             class14.method170(var48, var38, var39, var20, var68 + var29 & 3, var28, var45, var60);
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            XItemContainer.method177(true);
            class14.method171();
            WidgetNode.method41();
            Region var65 = class16.region;
            CollisionData[] var79 = Client.collisionMaps;

            for(var4 = 0; var4 < 4; ++var4) {
               for(var46 = 0; var46 < 104; ++var46) {
                  for(var6 = 0; var6 < 104; ++var6) {
                     if((class5.tileSettings[var4][var46][var6] & 1) == 1) {
                        var68 = var4;
                        if((class5.tileSettings[1][var46][var6] & 2) == 2) {
                           var68 = var4 - 1;
                        }

                        if(var68 >= 0) {
                           var79[var68].method2413(var46, var6);
                        }
                     }
                  }
               }
            }

            class5.field88 += (int)(Math.random() * 5.0D) - 2;
            if(class5.field88 < -8) {
               class5.field88 = -8;
            }

            if(class5.field88 > 8) {
               class5.field88 = 8;
            }

            class5.field90 += (int)(Math.random() * 5.0D) - 2;
            if(class5.field90 < -16) {
               class5.field90 = -16;
            }

            if(class5.field90 > 16) {
               class5.field90 = 16;
            }

            for(var4 = 0; var4 < 4; ++var4) {
               byte[][] var66 = class137.field2149[var4];
               var11 = (int)Math.sqrt(5100.0D);
               var70 = var11 * 768 >> 8;

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     var15 = class5.tileHeights[var4][1 + var14][var13] - class5.tileHeights[var4][var14 - 1][var13];
                     var16 = class5.tileHeights[var4][var14][1 + var13] - class5.tileHeights[var4][var14][var13 - 1];
                     var17 = (int)Math.sqrt((double)(65536 + var15 * var15 + var16 * var16));
                     var18 = (var15 << 8) / var17;
                     var47 = 65536 / var17;
                     var20 = (var16 << 8) / var17;
                     var21 = 96 + (var20 * -50 + var18 * -50 + var47 * -10) / var70;
                     var22 = (var66[var14 - 1][var13] >> 2) + (var66[1 + var14][var13] >> 3) + (var66[var14][var13 - 1] >> 2) + (var66[var14][1 + var13] >> 3) + (var66[var14][var13] >> 1);
                     class5.field81[var14][var13] = var21 - var22;
                  }
               }

               for(var13 = 0; var13 < 104; ++var13) {
                  class212.field3172[var13] = 0;
                  class4.field72[var13] = 0;
                  class212.field3176[var13] = 0;
                  RSCanvas.field2211[var13] = 0;
                  class224.field3228[var13] = 0;
               }

               for(var13 = -5; var13 < 109; ++var13) {
                  for(var14 = 0; var14 < 104; ++var14) {
                     var15 = var13 + 5;
                     if(var15 >= 0 && var15 < 104) {
                        var16 = class5.field79[var4][var15][var14] & 255;
                        if(var16 > 0) {
                           var18 = var16 - 1;
                           class43 var72 = (class43)class43.field999.get((long)var18);
                           class43 var76;
                           if(null != var72) {
                              var76 = var72;
                           } else {
                              byte[] var50 = class43.field1008.method3309(1, var18);
                              var72 = new class43();
                              if(var50 != null) {
                                 var72.method887(new Buffer(var50), var18);
                              }

                              var72.method886();
                              class43.field999.put(var72, (long)var18);
                              var76 = var72;
                           }

                           class212.field3172[var14] += var76.field998;
                           class4.field72[var14] += var76.field1002;
                           class212.field3176[var14] += var76.field1003;
                           RSCanvas.field2211[var14] += var76.field1004;
                           ++class224.field3228[var14];
                        }
                     }

                     var16 = var13 - 5;
                     if(var16 >= 0 && var16 < 104) {
                        var17 = class5.field79[var4][var16][var14] & 255;
                        if(var17 > 0) {
                           var47 = var17 - 1;
                           class43 var78 = (class43)class43.field999.get((long)var47);
                           class43 var80;
                           if(null != var78) {
                              var80 = var78;
                           } else {
                              byte[] var62 = class43.field1008.method3309(1, var47);
                              var78 = new class43();
                              if(null != var62) {
                                 var78.method887(new Buffer(var62), var47);
                              }

                              var78.method886();
                              class43.field999.put(var78, (long)var47);
                              var80 = var78;
                           }

                           class212.field3172[var14] -= var80.field998;
                           class4.field72[var14] -= var80.field1002;
                           class212.field3176[var14] -= var80.field1003;
                           RSCanvas.field2211[var14] -= var80.field1004;
                           --class224.field3228[var14];
                        }
                     }
                  }

                  if(var13 >= 1 && var13 < 103) {
                     var14 = 0;
                     var15 = 0;
                     var16 = 0;
                     var17 = 0;
                     var18 = 0;

                     for(var47 = -5; var47 < 109; ++var47) {
                        var20 = var47 + 5;
                        if(var20 >= 0 && var20 < 104) {
                           var14 += class212.field3172[var20];
                           var15 += class4.field72[var20];
                           var16 += class212.field3176[var20];
                           var17 += RSCanvas.field2211[var20];
                           var18 += class224.field3228[var20];
                        }

                        var21 = var47 - 5;
                        if(var21 >= 0 && var21 < 104) {
                           var14 -= class212.field3172[var21];
                           var15 -= class4.field72[var21];
                           var16 -= class212.field3176[var21];
                           var17 -= RSCanvas.field2211[var21];
                           var18 -= class224.field3228[var21];
                        }

                        if(var47 >= 1 && var47 < 103 && (!Client.field285 || (class5.tileSettings[0][var13][var47] & 2) != 0 || (class5.tileSettings[var4][var13][var47] & 16) == 0)) {
                           if(var4 < class5.field83) {
                              class5.field83 = var4;
                           }

                           var22 = class5.field79[var4][var13][var47] & 255;
                           var23 = class26.field653[var4][var13][var47] & 255;
                           if(var22 > 0 || var23 > 0) {
                              var24 = class5.tileHeights[var4][var13][var47];
                              var25 = class5.tileHeights[var4][1 + var13][var47];
                              var26 = class5.tileHeights[var4][var13 + 1][var47 + 1];
                              var27 = class5.tileHeights[var4][var13][1 + var47];
                              var28 = class5.field81[var13][var47];
                              var29 = class5.field81[var13 + 1][var47];
                              var30 = class5.field81[var13 + 1][var47 + 1];
                              int var31 = class5.field81[var13][1 + var47];
                              var32 = -1;
                              var33 = -1;
                              if(var22 > 0) {
                                 var34 = 256 * var14 / var17;
                                 var35 = var15 / var18;
                                 var36 = var16 / var18;
                                 var32 = class178.method3500(var34, var35, var36);
                                 var34 = var34 + class5.field88 & 255;
                                 var36 += class5.field90;
                                 if(var36 < 0) {
                                    var36 = 0;
                                 } else if(var36 > 255) {
                                    var36 = 255;
                                 }

                                 var33 = class178.method3500(var34, var35, var36);
                              }

                              if(var4 > 0) {
                                 boolean var74 = true;
                                 if(var22 == 0 && class93.field1649[var4][var13][var47] != 0) {
                                    var74 = false;
                                 }

                                 if(var23 > 0 && !class107.method2316(var23 - 1).field1076) {
                                    var74 = false;
                                 }

                                 if(var74 && var25 == var24 && var26 == var24 && var27 == var24) {
                                    class22.field590[var4][var13][var47] |= 2340;
                                 }
                              }

                              var34 = 0;
                              if(var33 != -1) {
                                 var34 = class94.colorPalette[class93.method2115(var33, 96)];
                              }

                              if(var23 == 0) {
                                 var65.method1953(var4, var13, var47, 0, 0, -1, var24, var25, var26, var27, class93.method2115(var32, var28), class93.method2115(var32, var29), class93.method2115(var32, var30), class93.method2115(var32, var31), 0, 0, 0, 0, var34, 0);
                              } else {
                                 var35 = 1 + class93.field1649[var4][var13][var47];
                                 byte var75 = class5.field80[var4][var13][var47];
                                 class48 var37 = class107.method2316(var23 - 1);
                                 var38 = var37.field1075;
                                 int var41;
                                 int var42;
                                 if(var38 >= 0) {
                                    var40 = class94.field1672.vmethod2203(var38);
                                    var39 = -1;
                                 } else if(var37.field1074 == 16711935) {
                                    var39 = -2;
                                    var38 = -1;
                                    var40 = -2;
                                 } else {
                                    var39 = class178.method3500(var37.field1086, var37.field1079, var37.field1080);
                                    var41 = class5.field88 + var37.field1086 & 255;
                                    var42 = class5.field90 + var37.field1080;
                                    if(var42 < 0) {
                                       var42 = 0;
                                    } else if(var42 > 255) {
                                       var42 = 255;
                                    }

                                    var40 = class178.method3500(var41, var37.field1079, var42);
                                 }

                                 var41 = 0;
                                 if(var40 != -2) {
                                    var41 = class94.colorPalette[class23.method584(var40, 96)];
                                 }

                                 if(var37.field1077 != -1) {
                                    var42 = class5.field88 + var37.field1081 & 255;
                                    int var43 = var37.field1087 + class5.field90;
                                    if(var43 < 0) {
                                       var43 = 0;
                                    } else if(var43 > 255) {
                                       var43 = 255;
                                    }

                                    var40 = class178.method3500(var42, var37.field1082, var43);
                                    var41 = class94.colorPalette[class23.method584(var40, 96)];
                                 }

                                 var65.method1953(var4, var13, var47, var35, var75, var38, var24, var25, var26, var27, class93.method2115(var32, var28), class93.method2115(var32, var29), class93.method2115(var32, var30), class93.method2115(var32, var31), class23.method584(var39, var28), class23.method584(var39, var29), class23.method584(var39, var30), class23.method584(var39, var31), var34, var41);
                              }
                           }
                        }
                     }
                  }
               }

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     if((class5.tileSettings[var4][var14][var13] & 8) != 0) {
                        var47 = 0;
                     } else if(var4 > 0 && (class5.tileSettings[1][var14][var13] & 2) != 0) {
                        var47 = var4 - 1;
                     } else {
                        var47 = var4;
                     }

                     var65.method1952(var4, var14, var13, var47);
                  }
               }

               class5.field79[var4] = null;
               class26.field653[var4] = null;
               class93.field1649[var4] = null;
               class5.field80[var4] = null;
               class137.field2149[var4] = null;
            }

            var65.method1979(-50, -10, -50);

            for(var4 = 0; var4 < 104; ++var4) {
               for(var46 = 0; var46 < 104; ++var46) {
                  if((class5.tileSettings[1][var4][var46] & 2) == 2) {
                     var65.method2012(var4, var46);
                  }
               }
            }

            var4 = 1;
            var46 = 2;
            var6 = 4;

            for(var68 = 0; var68 < 4; ++var68) {
               if(var68 > 0) {
                  var4 <<= 3;
                  var46 <<= 3;
                  var6 <<= 3;
               }

               for(var44 = 0; var44 <= var68; ++var44) {
                  for(var9 = 0; var9 <= 104; ++var9) {
                     for(var10 = 0; var10 <= 104; ++var10) {
                        short var73;
                        if((class22.field590[var44][var10][var9] & var4) != 0) {
                           var11 = var9;
                           var70 = var9;
                           var13 = var44;

                           for(var14 = var44; var11 > 0 && (class22.field590[var44][var10][var11 - 1] & var4) != 0; --var11) {
                              ;
                           }

                           while(var70 < 104 && (class22.field590[var44][var10][var70 + 1] & var4) != 0) {
                              ++var70;
                           }

                           label1214:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var70; ++var15) {
                                 if((class22.field590[var13 - 1][var10][var15] & var4) == 0) {
                                    break label1214;
                                 }
                              }

                              --var13;
                           }

                           label1203:
                           while(var14 < var68) {
                              for(var15 = var11; var15 <= var70; ++var15) {
                                 if((class22.field590[var14 + 1][var10][var15] & var4) == 0) {
                                    break label1203;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (1 + (var70 - var11)) * (1 + var14 - var13);
                           if(var15 >= 8) {
                              var73 = 240;
                              var17 = class5.tileHeights[var14][var10][var11] - var73;
                              var18 = class5.tileHeights[var13][var10][var11];
                              Region.method2065(var68, 1, 128 * var10, var10 * 128, 128 * var11, 128 + 128 * var70, var17, var18);

                              for(var47 = var13; var47 <= var14; ++var47) {
                                 for(var20 = var11; var20 <= var70; ++var20) {
                                    class22.field590[var47][var10][var20] &= ~var4;
                                 }
                              }
                           }
                        }

                        if((class22.field590[var44][var10][var9] & var46) != 0) {
                           var11 = var10;
                           var70 = var10;
                           var13 = var44;

                           for(var14 = var44; var11 > 0 && (class22.field590[var44][var11 - 1][var9] & var46) != 0; --var11) {
                              ;
                           }

                           while(var70 < 104 && (class22.field590[var44][1 + var70][var9] & var46) != 0) {
                              ++var70;
                           }

                           label1267:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var70; ++var15) {
                                 if((class22.field590[var13 - 1][var15][var9] & var46) == 0) {
                                    break label1267;
                                 }
                              }

                              --var13;
                           }

                           label1256:
                           while(var14 < var68) {
                              for(var15 = var11; var15 <= var70; ++var15) {
                                 if((class22.field590[1 + var14][var15][var9] & var46) == 0) {
                                    break label1256;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (var14 + 1 - var13) * (1 + (var70 - var11));
                           if(var15 >= 8) {
                              var73 = 240;
                              var17 = class5.tileHeights[var14][var11][var9] - var73;
                              var18 = class5.tileHeights[var13][var11][var9];
                              Region.method2065(var68, 2, 128 * var11, 128 + 128 * var70, var9 * 128, var9 * 128, var17, var18);

                              for(var47 = var13; var47 <= var14; ++var47) {
                                 for(var20 = var11; var20 <= var70; ++var20) {
                                    class22.field590[var47][var20][var9] &= ~var46;
                                 }
                              }
                           }
                        }

                        if((class22.field590[var44][var10][var9] & var6) != 0) {
                           var11 = var10;
                           var70 = var10;
                           var13 = var9;

                           for(var14 = var9; var13 > 0 && (class22.field590[var44][var10][var13 - 1] & var6) != 0; --var13) {
                              ;
                           }

                           while(var14 < 104 && (class22.field590[var44][var10][var14 + 1] & var6) != 0) {
                              ++var14;
                           }

                           label1320:
                           while(var11 > 0) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((class22.field590[var44][var11 - 1][var15] & var6) == 0) {
                                    break label1320;
                                 }
                              }

                              --var11;
                           }

                           label1309:
                           while(var70 < 104) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((class22.field590[var44][1 + var70][var15] & var6) == 0) {
                                    break label1309;
                                 }
                              }

                              ++var70;
                           }

                           if((var70 - var11 + 1) * (var14 - var13 + 1) >= 4) {
                              var15 = class5.tileHeights[var44][var11][var13];
                              Region.method2065(var68, 4, 128 * var11, 128 + var70 * 128, var13 * 128, 128 + 128 * var14, var15, var15);

                              for(var16 = var11; var16 <= var70; ++var16) {
                                 for(var17 = var13; var17 <= var14; ++var17) {
                                    class22.field590[var44][var16][var17] &= ~var6;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            XItemContainer.method177(true);
            var4 = class5.field83;
            if(var4 > Item.plane) {
               var4 = Item.plane;
            }

            if(var4 < Item.plane - 1) {
               var4 = Item.plane - 1;
            }

            if(Client.field285) {
               class16.region.method1949(class5.field83);
            } else {
               class16.region.method1949(0);
            }

            for(var46 = 0; var46 < 104; ++var46) {
               for(var6 = 0; var6 < 104; ++var6) {
                  class9.groundItemSpawned(var46, var6);
               }
            }

            WidgetNode.method41();

            for(class16 var67 = (class16)Client.field425.method3854(); var67 != null; var67 = (class16)Client.field425.method3869()) {
               if(var67.field224 == -1) {
                  var67.field227 = 0;
                  class5.method87(var67);
               } else {
                  var67.unlink();
               }
            }

            ObjectComposition.field980.reset();
            if(WallObject.field1621 != null) {
               Client.field323.method2801(135);
               Client.field323.method2600(1057001181);
            }

            if(!Client.field342) {
               var46 = (class159.field2372 - 6) / 8;
               var6 = (6 + class159.field2372) / 8;
               var68 = (WidgetNode.field66 - 6) / 8;
               var44 = (6 + WidgetNode.field66) / 8;

               for(var9 = var46 - 1; var9 <= var6 + 1; ++var9) {
                  for(var10 = var68 - 1; var10 <= 1 + var44; ++var10) {
                     if(var9 < var46 || var9 > var6 || var10 < var68 || var10 > var44) {
                        class1.field18.method3329("m" + var9 + "_" + var10);
                        class1.field18.method3329("l" + var9 + "_" + var10);
                     }
                  }
               }
            }

            XItemContainer.setGameState(30);
            WidgetNode.method41();
            class5.field79 = null;
            class26.field653 = null;
            class93.field1649 = null;
            class5.field80 = null;
            class22.field590 = null;
            class137.field2149 = null;
            class5.field81 = null;
            class212.field3172 = null;
            class4.field72 = null;
            class212.field3176 = null;
            RSCanvas.field2211 = null;
            class224.field3228 = null;
            Client.field323.method2801(132);
            DecorativeObject.field1699.vmethod3147();

            for(var46 = 0; var46 < 32; ++var46) {
               GameEngine.field2268[var46] = 0L;
            }

            for(var46 = 0; var46 < 32; ++var46) {
               GameEngine.field2269[var46] = 0L;
            }

            TextureProvider.field1702 = 0;
         }
      }
   }
}
