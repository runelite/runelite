import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public class class165 {
   @ObfuscatedName("d")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("h")
   @Export("widgetSettings")
   public static int[] widgetSettings;
   @ObfuscatedName("m")
   public static boolean field2163;
   @ObfuscatedName("q")
   static int[] field2165 = new int[32];
   @ObfuscatedName("bd")
   static class184 field2167;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;B)V",
      garbageValue = "11"
   )
   public static void method3160(class182 var0, class182 var1, class182 var2) {
      class196.field2890 = var0;
      class196.field2868 = var1;
      class196.field2869 = var2;
   }

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2165[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "86"
   )
   static final void method3161() {
      Actor.method632(false);
      Client.field360 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class40.field828.length; ++var1) {
         if(class40.field835[var1] != -1 && null == class40.field828[var1]) {
            class40.field828[var1] = Client.field337.getConfigData(class40.field835[var1], 0);
            if(class40.field828[var1] == null) {
               var0 = false;
               ++Client.field360;
            }
         }

         if(class185.field2755[var1] != -1 && class31.field738[var1] == null) {
            class31.field738[var1] = Client.field337.getConfigData(class185.field2755[var1], 0, class104.xteaKeys[var1]);
            if(null == class31.field738[var1]) {
               var0 = false;
               ++Client.field360;
            }
         }
      }

      if(!var0) {
         Client.field364 = 1;
      } else {
         Client.field362 = 0;
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
         int var46;
         for(var1 = 0; var1 < class40.field828.length; ++var1) {
            byte[] var2 = class31.field738[var1];
            if(var2 != null) {
               var3 = (class119.mapRegions[var1] >> 8) * 64 - class5.baseX;
               var4 = 64 * (class119.mapRegions[var1] & 255) - XClanMember.baseY;
               if(Client.isDynamicRegion) {
                  var3 = 10;
                  var4 = 10;
               }

               boolean var7 = true;
               var8 = new Buffer(var2);
               var9 = -1;

               label1583:
               while(true) {
                  var10 = var8.method2846();
                  if(var10 == 0) {
                     var0 &= var7;
                     break;
                  }

                  var9 += var10;
                  var11 = 0;
                  boolean var12 = false;

                  while(true) {
                     while(!var12) {
                        var13 = var8.method2846();
                        if(var13 == 0) {
                           continue label1583;
                        }

                        var11 += var13 - 1;
                        var14 = var11 & 63;
                        var15 = var11 >> 6 & 63;
                        var16 = var8.readUnsignedByte() >> 2;
                        var17 = var15 + var3;
                        var46 = var14 + var4;
                        if(var17 > 0 && var46 > 0 && var17 < 103 && var46 < 103) {
                           ObjectComposition var19 = class187.getObjectDefinition(var9);
                           if(var16 != 22 || !Client.field308 || var19.field2912 != 0 || var19.field2943 == 1 || var19.field2940) {
                              if(!var19.method3621()) {
                                 ++Client.field362;
                                 var7 = false;
                              }

                              var12 = true;
                           }
                        }
                     }

                     var13 = var8.method2846();
                     if(var13 == 0) {
                        break;
                     }

                     var8.readUnsignedByte();
                  }
               }
            }
         }

         if(!var0) {
            Client.field364 = 2;
         } else {
            if(Client.field364 != 0) {
               Ignore.method203("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class7.method91();
            class182.method3325();
            class7.method91();
            Script.region.method1748();
            class7.method91();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].method2306();
            }

            int var49;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var49 = 0; var49 < 104; ++var49) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class10.tileSettings[var1][var49][var3] = 0;
                  }
               }
            }

            class7.method91();
            class10.field95 = 99;
            class10.underlayIds = new byte[4][104][104];
            class10.overlayIds = new byte[4][104][104];
            class3.overlayPaths = new byte[4][104][104];
            class10.overlayRotations = new byte[4][104][104];
            class49.field984 = new int[4][105][105];
            class10.field118 = new byte[4][105][105];
            class10.field99 = new int[105][105];
            class2.field24 = new int[104];
            XClanMember.field291 = new int[104];
            class10.field98 = new int[104];
            class154.field2108 = new int[104];
            class10.field102 = new int[104];
            var1 = class40.field828.length;
            class114.method2262();
            Actor.method632(true);
            int var5;
            int var21;
            int var47;
            int var55;
            int var69;
            if(!Client.isDynamicRegion) {
               byte[] var51;
               for(var49 = 0; var49 < var1; ++var49) {
                  var3 = (class119.mapRegions[var49] >> 8) * 64 - class5.baseX;
                  var4 = 64 * (class119.mapRegions[var49] & 255) - XClanMember.baseY;
                  var51 = class40.field828[var49];
                  if(null != var51) {
                     class7.method91();
                     class13.method170(var51, var3, var4, class149.field2035 * 8 - 48, MessageNode.field239 * 8 - 48, Client.collisionMaps);
                  }
               }

               for(var49 = 0; var49 < var1; ++var49) {
                  var3 = 64 * (class119.mapRegions[var49] >> 8) - class5.baseX;
                  var4 = 64 * (class119.mapRegions[var49] & 255) - XClanMember.baseY;
                  var51 = class40.field828[var49];
                  if(var51 == null && MessageNode.field239 < 800) {
                     class7.method91();
                     class103.method2033(var3, var4, 64, 64);
                  }
               }

               Actor.method632(true);

               for(var49 = 0; var49 < var1; ++var49) {
                  byte[] var52 = class31.field738[var49];
                  if(null != var52) {
                     var4 = (class119.mapRegions[var49] >> 8) * 64 - class5.baseX;
                     var5 = 64 * (class119.mapRegions[var49] & 255) - XClanMember.baseY;
                     class7.method91();
                     Region var53 = Script.region;
                     CollisionData[] var58 = Client.collisionMaps;
                     var8 = new Buffer(var52);
                     var9 = -1;

                     while(true) {
                        var10 = var8.method2846();
                        if(var10 == 0) {
                           break;
                        }

                        var9 += var10;
                        var11 = 0;

                        while(true) {
                           var69 = var8.method2846();
                           if(var69 == 0) {
                              break;
                           }

                           var11 += var69 - 1;
                           var13 = var11 & 63;
                           var14 = var11 >> 6 & 63;
                           var15 = var11 >> 12;
                           var16 = var8.readUnsignedByte();
                           var17 = var16 >> 2;
                           var46 = var16 & 3;
                           var55 = var4 + var14;
                           var47 = var5 + var13;
                           if(var55 > 0 && var47 > 0 && var55 < 103 && var47 < 103) {
                              var21 = var15;
                              if((class10.tileSettings[1][var55][var47] & 2) == 2) {
                                 var21 = var15 - 1;
                              }

                              CollisionData var22 = null;
                              if(var21 >= 0) {
                                 var22 = var58[var21];
                              }

                              class10.method114(var15, var55, var47, var9, var46, var17, var53, var22);
                           }
                        }
                     }
                  }
               }
            }

            int var6;
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
            int var40;
            int var48;
            int var54;
            int var68;
            if(Client.isDynamicRegion) {
               CollisionData[] var18;
               Buffer var71;
               for(var49 = 0; var49 < 4; ++var49) {
                  class7.method91();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var67 = false;
                        var6 = Client.field367[var49][var3][var4];
                        if(var6 != -1) {
                           var68 = var6 >> 24 & 3;
                           var48 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = (var9 / 8 << 8) + var10 / 8;

                           for(var69 = 0; var69 < class119.mapRegions.length; ++var69) {
                              if(var11 == class119.mapRegions[var69] && class40.field828[var69] != null) {
                                 byte[] var56 = class40.field828[var69];
                                 var14 = 8 * var3;
                                 var15 = 8 * var4;
                                 var16 = (var9 & 7) * 8;
                                 var17 = (var10 & 7) * 8;
                                 var18 = Client.collisionMaps;

                                 for(var55 = 0; var55 < 8; ++var55) {
                                    for(var47 = 0; var47 < 8; ++var47) {
                                       if(var55 + var14 > 0 && var14 + var55 < 103 && var47 + var15 > 0 && var15 + var47 < 103) {
                                          var18[var49].flags[var14 + var55][var15 + var47] &= -16777217;
                                       }
                                    }
                                 }

                                 var71 = new Buffer(var56);

                                 for(var47 = 0; var47 < 4; ++var47) {
                                    for(var21 = 0; var21 < 64; ++var21) {
                                       for(var54 = 0; var54 < 64; ++var54) {
                                          if(var68 == var47 && var21 >= var16 && var21 < 8 + var16 && var54 >= var17 && var54 < 8 + var17) {
                                             var25 = var14 + class47.method967(var21 & 7, var54 & 7, var48);
                                             var28 = var21 & 7;
                                             var29 = var54 & 7;
                                             var30 = var48 & 3;
                                             if(var30 == 0) {
                                                var27 = var29;
                                             } else if(var30 == 1) {
                                                var27 = 7 - var28;
                                             } else if(var30 == 2) {
                                                var27 = 7 - var29;
                                             } else {
                                                var27 = var28;
                                             }

                                             XClanMember.method251(var71, var49, var25, var27 + var15, 0, 0, var48);
                                          } else {
                                             XClanMember.method251(var71, 0, -1, -1, 0, 0, 0);
                                          }
                                       }
                                    }
                                 }

                                 var67 = true;
                                 break;
                              }
                           }
                        }

                        if(!var67) {
                           class15.method181(var49, var3 * 8, 8 * var4);
                        }
                     }
                  }
               }

               for(var49 = 0; var49 < 13; ++var49) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.field367[0][var49][var3];
                     if(var4 == -1) {
                        class103.method2033(8 * var49, var3 * 8, 8, 8);
                     }
                  }
               }

               Actor.method632(true);

               for(var49 = 0; var49 < 4; ++var49) {
                  class7.method91();

                  for(var3 = 0; var3 < 13; ++var3) {
                     label1411:
                     for(var4 = 0; var4 < 13; ++var4) {
                        var5 = Client.field367[var49][var3][var4];
                        if(var5 != -1) {
                           var6 = var5 >> 24 & 3;
                           var68 = var5 >> 1 & 3;
                           var48 = var5 >> 14 & 1023;
                           var9 = var5 >> 3 & 2047;
                           var10 = (var48 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < class119.mapRegions.length; ++var11) {
                              if(var10 == class119.mapRegions[var11] && class31.field738[var11] != null) {
                                 byte[] var59 = class31.field738[var11];
                                 var13 = var3 * 8;
                                 var14 = 8 * var4;
                                 var15 = (var48 & 7) * 8;
                                 var16 = 8 * (var9 & 7);
                                 Region var50 = Script.region;
                                 var18 = Client.collisionMaps;
                                 var71 = new Buffer(var59);
                                 var47 = -1;

                                 while(true) {
                                    var21 = var71.method2846();
                                    if(var21 == 0) {
                                       continue label1411;
                                    }

                                    var47 += var21;
                                    var54 = 0;

                                    while(true) {
                                       var23 = var71.method2846();
                                       if(var23 == 0) {
                                          break;
                                       }

                                       var54 += var23 - 1;
                                       var24 = var54 & 63;
                                       var25 = var54 >> 6 & 63;
                                       var26 = var54 >> 12;
                                       var27 = var71.readUnsignedByte();
                                       var28 = var27 >> 2;
                                       var29 = var27 & 3;
                                       if(var6 == var26 && var25 >= var15 && var25 < 8 + var15 && var24 >= var16 && var24 < var16 + 8) {
                                          ObjectComposition var60 = class187.getObjectDefinition(var47);
                                          var33 = var25 & 7;
                                          var34 = var24 & 7;
                                          var36 = var60.sizeX;
                                          int var37 = var60.sizeY;
                                          if((var29 & 1) == 1) {
                                             var38 = var36;
                                             var36 = var37;
                                             var37 = var38;
                                          }

                                          var35 = var68 & 3;
                                          if(var35 == 0) {
                                             var32 = var33;
                                          } else if(var35 == 1) {
                                             var32 = var34;
                                          } else if(var35 == 2) {
                                             var32 = 7 - var33 - (var36 - 1);
                                          } else {
                                             var32 = 7 - var34 - (var37 - 1);
                                          }

                                          var38 = var32 + var13;
                                          int var61 = var14 + class85.method1745(var25 & 7, var24 & 7, var68, var60.sizeX, var60.sizeY, var29);
                                          if(var38 > 0 && var61 > 0 && var38 < 103 && var61 < 103) {
                                             var40 = var49;
                                             if((class10.tileSettings[1][var38][var61] & 2) == 2) {
                                                var40 = var49 - 1;
                                             }

                                             CollisionData var62 = null;
                                             if(var40 >= 0) {
                                                var62 = var18[var40];
                                             }

                                             class10.method114(var49, var38, var61, var47, var68 + var29 & 3, var28, var50, var62);
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

            Actor.method632(true);
            class182.method3325();
            class7.method91();
            Region var66 = Script.region;
            CollisionData[] var80 = Client.collisionMaps;

            for(var4 = 0; var4 < 4; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  for(var6 = 0; var6 < 104; ++var6) {
                     if((class10.tileSettings[var4][var5][var6] & 1) == 1) {
                        var68 = var4;
                        if((class10.tileSettings[1][var5][var6] & 2) == 2) {
                           var68 = var4 - 1;
                        }

                        if(var68 >= 0) {
                           var80[var68].method2309(var5, var6);
                        }
                     }
                  }
               }
            }

            class10.field100 += (int)(Math.random() * 5.0D) - 2;
            if(class10.field100 < -8) {
               class10.field100 = -8;
            }

            if(class10.field100 > 8) {
               class10.field100 = 8;
            }

            class10.field112 += (int)(Math.random() * 5.0D) - 2;
            if(class10.field112 < -16) {
               class10.field112 = -16;
            }

            if(class10.field112 > 16) {
               class10.field112 = 16;
            }

            for(var4 = 0; var4 < 4; ++var4) {
               byte[][] var78 = class10.field118[var4];
               var11 = (int)Math.sqrt(5100.0D);
               var69 = 768 * var11 >> 8;

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     var15 = class10.tileHeights[var4][var14 + 1][var13] - class10.tileHeights[var4][var14 - 1][var13];
                     var16 = class10.tileHeights[var4][var14][var13 + 1] - class10.tileHeights[var4][var14][var13 - 1];
                     var17 = (int)Math.sqrt((double)(var16 * var16 + var15 * var15 + 65536));
                     var46 = (var15 << 8) / var17;
                     var55 = 65536 / var17;
                     var47 = (var16 << 8) / var17;
                     var21 = 96 + (var47 * -50 + -10 * var55 + var46 * -50) / var69;
                     var54 = (var78[var14][var13] >> 1) + (var78[var14][var13 + 1] >> 3) + (var78[var14][var13 - 1] >> 2) + (var78[var14 - 1][var13] >> 2) + (var78[1 + var14][var13] >> 3);
                     class10.field99[var14][var13] = var21 - var54;
                  }
               }

               for(var13 = 0; var13 < 104; ++var13) {
                  class2.field24[var13] = 0;
                  XClanMember.field291[var13] = 0;
                  class10.field98[var13] = 0;
                  class154.field2108[var13] = 0;
                  class10.field102[var13] = 0;
               }

               for(var13 = -5; var13 < 109; ++var13) {
                  for(var14 = 0; var14 < 104; ++var14) {
                     var15 = 5 + var13;
                     if(var15 >= 0 && var15 < 104) {
                        var16 = class10.underlayIds[var4][var15][var14] & 255;
                        if(var16 > 0) {
                           var46 = var16 - 1;
                           FloorUnderlayDefinition var72 = (FloorUnderlayDefinition)FloorUnderlayDefinition.field2817.get((long)var46);
                           FloorUnderlayDefinition var77;
                           if(null != var72) {
                              var77 = var72;
                           } else {
                              byte[] var20 = class150.field2041.getConfigData(1, var46);
                              var72 = new FloorUnderlayDefinition();
                              if(null != var20) {
                                 var72.method3485(new Buffer(var20), var46);
                              }

                              var72.method3484();
                              FloorUnderlayDefinition.field2817.put(var72, (long)var46);
                              var77 = var72;
                           }

                           class2.field24[var14] += var77.field2814;
                           XClanMember.field291[var14] += var77.field2812;
                           class10.field98[var14] += var77.field2816;
                           class154.field2108[var14] += var77.field2815;
                           ++class10.field102[var14];
                        }
                     }

                     var16 = var13 - 5;
                     if(var16 >= 0 && var16 < 104) {
                        var17 = class10.underlayIds[var4][var16][var14] & 255;
                        if(var17 > 0) {
                           var55 = var17 - 1;
                           FloorUnderlayDefinition var74 = (FloorUnderlayDefinition)FloorUnderlayDefinition.field2817.get((long)var55);
                           FloorUnderlayDefinition var70;
                           if(var74 != null) {
                              var70 = var74;
                           } else {
                              byte[] var63 = class150.field2041.getConfigData(1, var55);
                              var74 = new FloorUnderlayDefinition();
                              if(null != var63) {
                                 var74.method3485(new Buffer(var63), var55);
                              }

                              var74.method3484();
                              FloorUnderlayDefinition.field2817.put(var74, (long)var55);
                              var70 = var74;
                           }

                           class2.field24[var14] -= var70.field2814;
                           XClanMember.field291[var14] -= var70.field2812;
                           class10.field98[var14] -= var70.field2816;
                           class154.field2108[var14] -= var70.field2815;
                           --class10.field102[var14];
                        }
                     }
                  }

                  if(var13 >= 1 && var13 < 103) {
                     var14 = 0;
                     var15 = 0;
                     var16 = 0;
                     var17 = 0;
                     var46 = 0;

                     for(var55 = -5; var55 < 109; ++var55) {
                        var47 = 5 + var55;
                        if(var47 >= 0 && var47 < 104) {
                           var14 += class2.field24[var47];
                           var15 += XClanMember.field291[var47];
                           var16 += class10.field98[var47];
                           var17 += class154.field2108[var47];
                           var46 += class10.field102[var47];
                        }

                        var21 = var55 - 5;
                        if(var21 >= 0 && var21 < 104) {
                           var14 -= class2.field24[var21];
                           var15 -= XClanMember.field291[var21];
                           var16 -= class10.field98[var21];
                           var17 -= class154.field2108[var21];
                           var46 -= class10.field102[var21];
                        }

                        if(var55 >= 1 && var55 < 103 && (!Client.field308 || (class10.tileSettings[0][var13][var55] & 2) != 0 || (class10.tileSettings[var4][var13][var55] & 16) == 0)) {
                           if(var4 < class10.field95) {
                              class10.field95 = var4;
                           }

                           var54 = class10.underlayIds[var4][var13][var55] & 255;
                           var23 = class10.overlayIds[var4][var13][var55] & 255;
                           if(var54 > 0 || var23 > 0) {
                              var24 = class10.tileHeights[var4][var13][var55];
                              var25 = class10.tileHeights[var4][var13 + 1][var55];
                              var26 = class10.tileHeights[var4][var13 + 1][1 + var55];
                              var27 = class10.tileHeights[var4][var13][var55 + 1];
                              var28 = class10.field99[var13][var55];
                              var29 = class10.field99[var13 + 1][var55];
                              var30 = class10.field99[1 + var13][1 + var55];
                              int var31 = class10.field99[var13][var55 + 1];
                              var32 = -1;
                              var33 = -1;
                              if(var54 > 0) {
                                 var34 = var14 * 256 / var17;
                                 var35 = var15 / var46;
                                 var36 = var16 / var46;
                                 var32 = World.method674(var34, var35, var36);
                                 var34 = var34 + class10.field100 & 255;
                                 var36 += class10.field112;
                                 if(var36 < 0) {
                                    var36 = 0;
                                 } else if(var36 > 255) {
                                    var36 = 255;
                                 }

                                 var33 = World.method674(var34, var35, var36);
                              }

                              if(var4 > 0) {
                                 boolean var75 = true;
                                 if(var54 == 0 && class3.overlayPaths[var4][var13][var55] != 0) {
                                    var75 = false;
                                 }

                                 if(var23 > 0 && !NPCComposition.method3733(var23 - 1).isHidden) {
                                    var75 = false;
                                 }

                                 if(var75 && var24 == var25 && var24 == var26 && var24 == var27) {
                                    class49.field984[var4][var13][var55] |= 2340;
                                 }
                              }

                              var34 = 0;
                              if(var33 != -1) {
                                 var34 = class84.colorPalette[class114.method2256(var33, 96)];
                              }

                              if(var23 == 0) {
                                 var66.method1752(var4, var13, var55, 0, 0, -1, var24, var25, var26, var27, class114.method2256(var32, var28), class114.method2256(var32, var29), class114.method2256(var32, var30), class114.method2256(var32, var31), 0, 0, 0, 0, var34, 0);
                              } else {
                                 var35 = 1 + class3.overlayPaths[var4][var13][var55];
                                 byte var76 = class10.overlayRotations[var4][var13][var55];
                                 var38 = var23 - 1;
                                 Overlay var39 = (Overlay)Overlay.field3041.get((long)var38);
                                 Overlay var64;
                                 if(null != var39) {
                                    var64 = var39;
                                 } else {
                                    byte[] var65 = Overlay.field3038.getConfigData(4, var38);
                                    var39 = new Overlay();
                                    if(null != var65) {
                                       var39.method3754(new Buffer(var65), var38);
                                    }

                                    var39.method3753();
                                    Overlay.field3041.put(var39, (long)var38);
                                    var64 = var39;
                                 }

                                 var40 = var64.texture;
                                 int var41;
                                 int var42;
                                 int var43;
                                 int var44;
                                 if(var40 >= 0) {
                                    var42 = class84.field1465.vmethod1964(var40);
                                    var41 = -1;
                                 } else if(var64.color == 16711935) {
                                    var41 = -2;
                                    var40 = -1;
                                    var42 = -2;
                                 } else {
                                    var41 = World.method674(var64.hue, var64.saturation, var64.lightness);
                                    var43 = var64.hue + class10.field100 & 255;
                                    var44 = var64.lightness + class10.field112;
                                    if(var44 < 0) {
                                       var44 = 0;
                                    } else if(var44 > 255) {
                                       var44 = 255;
                                    }

                                    var42 = World.method674(var43, var64.saturation, var44);
                                 }

                                 var43 = 0;
                                 if(var42 != -2) {
                                    var43 = class84.colorPalette[class11.method152(var42, 96)];
                                 }

                                 if(var64.field3043 != -1) {
                                    var44 = var64.field3047 + class10.field100 & 255;
                                    int var45 = var64.field3049 + class10.field112;
                                    if(var45 < 0) {
                                       var45 = 0;
                                    } else if(var45 > 255) {
                                       var45 = 255;
                                    }

                                    var42 = World.method674(var44, var64.field3048, var45);
                                    var43 = class84.colorPalette[class11.method152(var42, 96)];
                                 }

                                 var66.method1752(var4, var13, var55, var35, var76, var40, var24, var25, var26, var27, class114.method2256(var32, var28), class114.method2256(var32, var29), class114.method2256(var32, var30), class114.method2256(var32, var31), class11.method152(var41, var28), class11.method152(var41, var29), class11.method152(var41, var30), class11.method152(var41, var31), var34, var43);
                              }
                           }
                        }
                     }
                  }
               }

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     var66.method1751(var4, var14, var13, class65.method1222(var4, var14, var13));
                  }
               }

               class10.underlayIds[var4] = null;
               class10.overlayIds[var4] = null;
               class3.overlayPaths[var4] = null;
               class10.overlayRotations[var4] = null;
               class10.field118[var4] = null;
            }

            var66.method1778(-50, -10, -50);

            for(var4 = 0; var4 < 104; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  if((class10.tileSettings[1][var4][var5] & 2) == 2) {
                     var66.method1766(var4, var5);
                  }
               }
            }

            var4 = 1;
            var5 = 2;
            var6 = 4;

            for(var68 = 0; var68 < 4; ++var68) {
               if(var68 > 0) {
                  var4 <<= 3;
                  var5 <<= 3;
                  var6 <<= 3;
               }

               for(var48 = 0; var48 <= var68; ++var48) {
                  for(var9 = 0; var9 <= 104; ++var9) {
                     for(var10 = 0; var10 <= 104; ++var10) {
                        short var73;
                        if((class49.field984[var48][var10][var9] & var4) != 0) {
                           var11 = var9;
                           var69 = var9;
                           var13 = var48;

                           for(var14 = var48; var11 > 0 && (class49.field984[var48][var10][var11 - 1] & var4) != 0; --var11) {
                              ;
                           }

                           while(var69 < 104 && (class49.field984[var48][var10][1 + var69] & var4) != 0) {
                              ++var69;
                           }

                           label1146:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var69; ++var15) {
                                 if((class49.field984[var13 - 1][var10][var15] & var4) == 0) {
                                    break label1146;
                                 }
                              }

                              --var13;
                           }

                           label1135:
                           while(var14 < var68) {
                              for(var15 = var11; var15 <= var69; ++var15) {
                                 if((class49.field984[var14 + 1][var10][var15] & var4) == 0) {
                                    break label1135;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (1 + (var69 - var11)) * (1 + var14 - var13);
                           if(var15 >= 8) {
                              var73 = 240;
                              var17 = class10.tileHeights[var14][var10][var11] - var73;
                              var46 = class10.tileHeights[var13][var10][var11];
                              Region.method1750(var68, 1, 128 * var10, var10 * 128, var11 * 128, var69 * 128 + 128, var17, var46);

                              for(var55 = var13; var55 <= var14; ++var55) {
                                 for(var47 = var11; var47 <= var69; ++var47) {
                                    class49.field984[var55][var10][var47] &= ~var4;
                                 }
                              }
                           }
                        }

                        if((class49.field984[var48][var10][var9] & var5) != 0) {
                           var11 = var10;
                           var69 = var10;
                           var13 = var48;

                           for(var14 = var48; var11 > 0 && (class49.field984[var48][var11 - 1][var9] & var5) != 0; --var11) {
                              ;
                           }

                           while(var69 < 104 && (class49.field984[var48][1 + var69][var9] & var5) != 0) {
                              ++var69;
                           }

                           label1199:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var69; ++var15) {
                                 if((class49.field984[var13 - 1][var15][var9] & var5) == 0) {
                                    break label1199;
                                 }
                              }

                              --var13;
                           }

                           label1188:
                           while(var14 < var68) {
                              for(var15 = var11; var15 <= var69; ++var15) {
                                 if((class49.field984[1 + var14][var15][var9] & var5) == 0) {
                                    break label1188;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (1 + var14 - var13) * (var69 - var11 + 1);
                           if(var15 >= 8) {
                              var73 = 240;
                              var17 = class10.tileHeights[var14][var11][var9] - var73;
                              var46 = class10.tileHeights[var13][var11][var9];
                              Region.method1750(var68, 2, var11 * 128, var69 * 128 + 128, var9 * 128, var9 * 128, var17, var46);

                              for(var55 = var13; var55 <= var14; ++var55) {
                                 for(var47 = var11; var47 <= var69; ++var47) {
                                    class49.field984[var55][var47][var9] &= ~var5;
                                 }
                              }
                           }
                        }

                        if((class49.field984[var48][var10][var9] & var6) != 0) {
                           var11 = var10;
                           var69 = var10;
                           var13 = var9;

                           for(var14 = var9; var13 > 0 && (class49.field984[var48][var10][var13 - 1] & var6) != 0; --var13) {
                              ;
                           }

                           while(var14 < 104 && (class49.field984[var48][var10][1 + var14] & var6) != 0) {
                              ++var14;
                           }

                           label1252:
                           while(var11 > 0) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((class49.field984[var48][var11 - 1][var15] & var6) == 0) {
                                    break label1252;
                                 }
                              }

                              --var11;
                           }

                           label1241:
                           while(var69 < 104) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((class49.field984[var48][var69 + 1][var15] & var6) == 0) {
                                    break label1241;
                                 }
                              }

                              ++var69;
                           }

                           if((1 + (var14 - var13)) * (1 + (var69 - var11)) >= 4) {
                              var15 = class10.tileHeights[var48][var11][var13];
                              Region.method1750(var68, 4, 128 * var11, 128 + 128 * var69, var13 * 128, 128 + 128 * var14, var15, var15);

                              for(var16 = var11; var16 <= var69; ++var16) {
                                 for(var17 = var13; var17 <= var14; ++var17) {
                                    class49.field984[var48][var16][var17] &= ~var6;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            Actor.method632(true);
            var4 = class10.field95;
            if(var4 > WallObject.plane) {
               var4 = WallObject.plane;
            }

            if(var4 < WallObject.plane - 1) {
               var4 = WallObject.plane - 1;
            }

            if(Client.field308) {
               Script.region.method1749(class10.field95);
            } else {
               Script.region.method1749(0);
            }

            for(var5 = 0; var5 < 104; ++var5) {
               for(var6 = 0; var6 < 104; ++var6) {
                  class88.groundItemSpawned(var5, var6);
               }
            }

            class7.method91();

            for(class25 var79 = (class25)Client.field436.method2458(); null != var79; var79 = (class25)Client.field436.method2472()) {
               if(var79.field603 == -1) {
                  var79.field602 = 0;
                  class105.method2057(var79);
               } else {
                  var79.unlink();
               }
            }

            ObjectComposition.field2896.reset();
            if(null != class3.field39) {
               Client.field348.method3073(59);
               Client.field348.method2821(1057001181);
            }

            if(!Client.isDynamicRegion) {
               var5 = (class149.field2035 - 6) / 8;
               var6 = (class149.field2035 + 6) / 8;
               var68 = (MessageNode.field239 - 6) / 8;
               var48 = (MessageNode.field239 + 6) / 8;

               for(var9 = var5 - 1; var9 <= var6 + 1; ++var9) {
                  for(var10 = var68 - 1; var10 <= 1 + var48; ++var10) {
                     if(var9 < var5 || var9 > var6 || var10 < var68 || var10 > var48) {
                        Client.field337.method3323("m" + var9 + "_" + var10);
                        Client.field337.method3323("l" + var9 + "_" + var10);
                     }
                  }
               }
            }

            class8.setGameState(30);
            class7.method91();
            class10.underlayIds = null;
            class10.overlayIds = null;
            class3.overlayPaths = null;
            class10.overlayRotations = null;
            class49.field984 = null;
            class10.field118 = null;
            class10.field99 = null;
            class2.field24 = null;
            XClanMember.field291 = null;
            class10.field98 = null;
            class154.field2108 = null;
            class10.field102 = null;
            Client.field348.method3073(5);
            class159.field2135.vmethod2107();

            for(var5 = 0; var5 < 32; ++var5) {
               GameEngine.field1776[var5] = 0L;
            }

            for(var5 = 0; var5 < 32; ++var5) {
               GameEngine.field1771[var5] = 0L;
            }

            ChatMessages.field944 = 0;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2083999288"
   )
   public static boolean method3164() {
      long var0 = class0.method11();
      int var2 = (int)(var0 - class185.field2757);
      class185.field2757 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class185.field2747 += var2;
      if(class185.field2750 == 0 && class185.field2752 == 0 && class185.field2751 == 0 && class185.field2763 == 0) {
         return true;
      } else if(null == class185.field2759) {
         return false;
      } else {
         try {
            if(class185.field2747 > 30000) {
               throw new IOException();
            } else {
               class181 var3;
               Buffer var4;
               while(class185.field2752 < 20 && class185.field2763 > 0) {
                  var3 = (class181)class185.field2749.method2403();
                  var4 = new Buffer(4);
                  var4.method2918(1);
                  var4.method2961((int)var3.hash);
                  class185.field2759.method2114(var4.payload, 0, 4);
                  class185.field2756.method2400(var3, var3.hash);
                  --class185.field2763;
                  ++class185.field2752;
               }

               while(class185.field2750 < 20 && class185.field2751 > 0) {
                  var3 = (class181)class185.field2753.method2348();
                  var4 = new Buffer(4);
                  var4.method2918(0);
                  var4.method2961((int)var3.hash);
                  class185.field2759.method2114(var4.payload, 0, 4);
                  var3.method2484();
                  class185.field2767.method2400(var3, var3.hash);
                  --class185.field2751;
                  ++class185.field2750;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class185.field2759.method2128();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class185.field2747 = 0;
                  byte var5 = 0;
                  if(null == class181.field2706) {
                     var5 = 8;
                  } else if(class185.field2748 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class185.field2758.offset;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class185.field2759.method2117(class185.field2758.payload, class185.field2758.offset, var6);
                     if(class185.field2762 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class185.field2758.payload[class185.field2758.offset + var7] ^= class185.field2762;
                        }
                     }

                     class185.field2758.offset += var6;
                     if(class185.field2758.offset < var5) {
                        break;
                     }

                     if(null == class181.field2706) {
                        class185.field2758.offset = 0;
                        var7 = class185.field2758.readUnsignedByte();
                        var8 = class185.field2758.readUnsignedShort();
                        int var9 = class185.field2758.readUnsignedByte();
                        var10 = class185.field2758.readInt();
                        long var11 = (long)(var8 + (var7 << 16));
                        class181 var13 = (class181)class185.field2756.method2399(var11);
                        class85.field1475 = true;
                        if(var13 == null) {
                           var13 = (class181)class185.field2767.method2399(var11);
                           class85.field1475 = false;
                        }

                        if(null == var13) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        class181.field2706 = var13;
                        class142.field2001 = new Buffer(class181.field2706.field2702 + var10 + var14);
                        class142.field2001.method2918(var9);
                        class142.field2001.method2821(var10);
                        class185.field2748 = 8;
                        class185.field2758.offset = 0;
                     } else if(class185.field2748 == 0) {
                        if(class185.field2758.payload[0] == -1) {
                           class185.field2748 = 1;
                           class185.field2758.offset = 0;
                        } else {
                           class181.field2706 = null;
                        }
                     }
                  } else {
                     var6 = class142.field2001.payload.length - class181.field2706.field2702;
                     var7 = 512 - class185.field2748;
                     if(var7 > var6 - class142.field2001.offset) {
                        var7 = var6 - class142.field2001.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class185.field2759.method2117(class142.field2001.payload, class142.field2001.offset, var7);
                     if(class185.field2762 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           class142.field2001.payload[class142.field2001.offset + var8] ^= class185.field2762;
                        }
                     }

                     class142.field2001.offset += var7;
                     class185.field2748 += var7;
                     if(class142.field2001.offset == var6) {
                        if(16711935L == class181.field2706.hash) {
                           class185.field2761 = class142.field2001;

                           for(var8 = 0; var8 < 256; ++var8) {
                              class184 var17 = class185.field2746[var8];
                              if(var17 != null) {
                                 class185.field2761.offset = 5 + 8 * var8;
                                 var10 = class185.field2761.readInt();
                                 int var18 = class185.field2761.readInt();
                                 var17.method3395(var10, var18);
                              }
                           }
                        } else {
                           class185.field2760.reset();
                           class185.field2760.update(class142.field2001.payload, 0, var6);
                           var8 = (int)class185.field2760.getValue();
                           if(class181.field2706.field2703 != var8) {
                              try {
                                 class185.field2759.method2118();
                              } catch (Exception var20) {
                                 ;
                              }

                              ++class185.field2764;
                              class185.field2759 = null;
                              class185.field2762 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class185.field2764 = 0;
                           class185.field2765 = 0;
                           class181.field2706.field2707.method3398((int)(class181.field2706.hash & 65535L), class142.field2001.payload, 16711680L == (class181.field2706.hash & 16711680L), class85.field1475);
                        }

                        class181.field2706.unlink();
                        if(class85.field1475) {
                           --class185.field2752;
                        } else {
                           --class185.field2750;
                        }

                        class185.field2748 = 0;
                        class181.field2706 = null;
                        class142.field2001 = null;
                     } else {
                        if(class185.field2748 != 512) {
                           break;
                        }

                        class185.field2748 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var21) {
            try {
               class185.field2759.method2118();
            } catch (Exception var19) {
               ;
            }

            ++class185.field2765;
            class185.field2759 = null;
            return false;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1493407385"
   )
   public static void method3165() {
      KitDefinition.field2819.reset();
   }

   class165() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILclass48;ZI)I",
      garbageValue = "894990248"
   )
   static int method3167(int var0, Script var1, boolean var2) {
      Widget var3 = class179.method3296(class32.field747[--class103.field1686]);
      if(var0 == 2600) {
         class32.field747[++class103.field1686 - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 2601) {
         class32.field747[++class103.field1686 - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 2602) {
         class32.chatboxSegments[++class32.field749 - 1] = var3.text;
         return 1;
      } else if(var0 == 2603) {
         class32.field747[++class103.field1686 - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 2604) {
         class32.field747[++class103.field1686 - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 2605) {
         class32.field747[++class103.field1686 - 1] = var3.field2259;
         return 1;
      } else if(var0 == 2606) {
         class32.field747[++class103.field1686 - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 2607) {
         class32.field747[++class103.field1686 - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 2608) {
         class32.field747[++class103.field1686 - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 2609) {
         class32.field747[++class103.field1686 - 1] = var3.opacity;
         return 1;
      } else if(var0 == 2610) {
         class32.field747[++class103.field1686 - 1] = var3.field2237;
         return 1;
      } else if(var0 == 2611) {
         class32.field747[++class103.field1686 - 1] = var3.textColor;
         return 1;
      } else if(var0 == 2612) {
         class32.field747[++class103.field1686 - 1] = var3.field2313;
         return 1;
      } else if(var0 == 2613) {
         class32.field747[++class103.field1686 - 1] = var3.field2235.vmethod4101();
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)LModIcon;",
      garbageValue = "1275645984"
   )
   static ModIcon method3168() {
      ModIcon var0 = new ModIcon();
      var0.width = class202.field3074;
      var0.originalHeight = class225.field3231;
      var0.offsetX = Ignore.field223[0];
      var0.offsetY = class225.field3233[0];
      var0.originalWidth = class225.field3234[0];
      var0.height = class41.field862[0];
      var0.palette = class160.field2146;
      var0.pixels = class11.field129[0];
      Actor.method636();
      return var0;
   }
}
