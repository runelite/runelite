import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class40 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lac;"
   )
   public static final class40 field540;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lac;"
   )
   public static final class40 field541;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lac;"
   )
   public static final class40 field545;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lac;"
   )
   public static final class40 field542;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lac;"
   )
   public static final class40 field544;
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      intValue = 1562355429
   )
   static int field550;
   @ObfuscatedName("m")
   public final String field549;

   static {
      field540 = new class40("details");
      field541 = new class40("compositemap");
      field542 = new class40("compositetexture");
      field545 = new class40("area");
      field544 = new class40("labels");
   }

   class40(String var1) {
      this.field549 = var1;
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1229037345"
   )
   static final void method528() {
      class1.flush(false);
      Client.field970 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < SceneTilePaint.field2003.length; ++var1) {
         if(class66.field807[var1] != -1 && SceneTilePaint.field2003[var1] == null) {
            SceneTilePaint.field2003[var1] = ISAACCipher.indexMaps.getConfigData(class66.field807[var1], 0);
            if(SceneTilePaint.field2003[var1] == null) {
               var0 = false;
               ++Client.field970;
            }
         }

         if(class222.landRegionFielIds[var1] != -1 && Huffman.field2286[var1] == null) {
            Huffman.field2286[var1] = ISAACCipher.indexMaps.getConfigData(class222.landRegionFielIds[var1], 0, class39.xteaKeys[var1]);
            if(Huffman.field2286[var1] == null) {
               var0 = false;
               ++Client.field970;
            }
         }
      }

      if(!var0) {
         Client.field974 = 1;
      } else {
         Client.field972 = 0;
         var0 = true;

         int var3;
         int var4;
         int var9;
         int var10;
         int var11;
         int var13;
         int var14;
         int var15;
         int var16;
         int var17;
         int var18;
         for(var1 = 0; var1 < SceneTilePaint.field2003.length; ++var1) {
            byte[] var2 = Huffman.field2286[var1];
            if(var2 != null) {
               var3 = (WorldListFetcher.mapRegions[var1] >> 8) * 64 - class21.baseX;
               var4 = (WorldListFetcher.mapRegions[var1] & 255) * 64 - class164.baseY;
               if(Client.isDynamicRegion) {
                  var3 = 10;
                  var4 = 10;
               }

               boolean var7 = true;
               Buffer var8 = new Buffer(var2);
               var9 = -1;

               label1407:
               while(true) {
                  var10 = var8.getUSmart();
                  if(var10 == 0) {
                     var0 &= var7;
                     break;
                  }

                  var9 += var10;
                  var11 = 0;
                  boolean var12 = false;

                  while(true) {
                     while(!var12) {
                        var13 = var8.getUSmart();
                        if(var13 == 0) {
                           continue label1407;
                        }

                        var11 += var13 - 1;
                        var14 = var11 & 63;
                        var15 = var11 >> 6 & 63;
                        var16 = var8.readUnsignedByte() >> 2;
                        var17 = var3 + var15;
                        var18 = var14 + var4;
                        if(var17 > 0 && var18 > 0 && var17 < 103 && var18 < 103) {
                           ObjectComposition var19 = class169.getObjectDefinition(var9);
                           if(var16 != 22 || !Client.lowMemory || var19.field3429 != 0 || var19.interactType == 1 || var19.field3448) {
                              if(!var19.method4402()) {
                                 ++Client.field972;
                                 var7 = false;
                              }

                              var12 = true;
                           }
                        }
                     }

                     var13 = var8.getUSmart();
                     if(var13 == 0) {
                        break;
                     }

                     var8.readUnsignedByte();
                  }
               }
            }
         }

         if(!var0) {
            Client.field974 = 2;
         } else {
            if(Client.field974 != 0) {
               class163.drawStatusBox("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class140.method2791();
            class5.method17();
            class140.method2791();
            class19.region.reset();
            class140.method2791();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].reset();
            }

            int var49;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var49 = 0; var49 < 104; ++var49) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class61.tileSettings[var1][var49][var3] = 0;
                  }
               }
            }

            class140.method2791();
            class61.field754 = 99;
            class224.underlayIds = new byte[4][104][104];
            class5.overlayIds = new byte[4][104][104];
            class61.overlayPaths = new byte[4][104][104];
            class15.overlayRotations = new byte[4][104][104];
            class61.field755 = new int[4][105][105];
            class134.field1949 = new byte[4][105][105];
            class61.field756 = new int[105][105];
            class267.blendedHue = new int[104];
            class35.blendedSaturation = new int[104];
            class266.field3647 = new int[104];
            Timer.field2225 = new int[104];
            ISAACCipher.field2393 = new int[104];
            var1 = SceneTilePaint.field2003.length;

            for(class82 var61 = (class82)class82.field1311.getFront(); var61 != null; var61 = (class82)class82.field1311.getNext()) {
               if(var61.field1308 != null) {
                  class1.field4.method1809(var61.field1308);
                  var61.field1308 = null;
               }

               if(var61.field1316 != null) {
                  class1.field4.method1809(var61.field1316);
                  var61.field1316 = null;
               }
            }

            class82.field1311.clear();
            class1.flush(true);
            int var5;
            if(!Client.isDynamicRegion) {
               byte[] var50;
               for(var49 = 0; var49 < var1; ++var49) {
                  var3 = (WorldListFetcher.mapRegions[var49] >> 8) * 64 - class21.baseX;
                  var4 = (WorldListFetcher.mapRegions[var49] & 255) * 64 - class164.baseY;
                  var50 = SceneTilePaint.field2003[var49];
                  if(var50 != null) {
                     class140.method2791();
                     class31.method269(var50, var3, var4, class181.field2404 * 8 - 48, WallObject.field2088 * 8 - 48, Client.collisionMaps);
                  }
               }

               for(var49 = 0; var49 < var1; ++var49) {
                  var3 = (WorldListFetcher.mapRegions[var49] >> 8) * 64 - class21.baseX;
                  var4 = (WorldListFetcher.mapRegions[var49] & 255) * 64 - class164.baseY;
                  var50 = SceneTilePaint.field2003[var49];
                  if(var50 == null && WallObject.field2088 < 800) {
                     class140.method2791();
                     KeyFocusListener.method739(var3, var4, 64, 64);
                  }
               }

               class1.flush(true);

               for(var49 = 0; var49 < var1; ++var49) {
                  byte[] var55 = Huffman.field2286[var49];
                  if(var55 != null) {
                     var4 = (WorldListFetcher.mapRegions[var49] >> 8) * 64 - class21.baseX;
                     var5 = (WorldListFetcher.mapRegions[var49] & 255) * 64 - class164.baseY;
                     class140.method2791();
                     GameEngine.method935(var55, var4, var5, class19.region, Client.collisionMaps);
                  }
               }
            }

            int var6;
            int var20;
            int var21;
            int var22;
            int var23;
            int var24;
            int var25;
            int var26;
            int var27;
            int var28;
            int var29;
            int var32;
            int var33;
            int var34;
            int var35;
            int var36;
            int var38;
            int var40;
            int var41;
            int var42;
            int var43;
            int var51;
            int var54;
            int var64;
            int var65;
            if(Client.isDynamicRegion) {
               int var37;
               CollisionData[] var53;
               Buffer var66;
               for(var49 = 0; var49 < 4; ++var49) {
                  class140.method2791();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var63 = false;
                        var6 = Client.field1133[var49][var3][var4];
                        if(var6 != -1) {
                           var64 = var6 >> 24 & 3;
                           var51 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = (var9 / 8 << 8) + var10 / 8;

                           for(var65 = 0; var65 < WorldListFetcher.mapRegions.length; ++var65) {
                              if(WorldListFetcher.mapRegions[var65] == var11 && SceneTilePaint.field2003[var65] != null) {
                                 byte[] var52 = SceneTilePaint.field2003[var65];
                                 var14 = var3 * 8;
                                 var15 = var4 * 8;
                                 var16 = (var9 & 7) * 8;
                                 var17 = (var10 & 7) * 8;
                                 var53 = Client.collisionMaps;

                                 for(var54 = 0; var54 < 8; ++var54) {
                                    for(var20 = 0; var20 < 8; ++var20) {
                                       if(var14 + var54 > 0 && var14 + var54 < 103 && var20 + var15 > 0 && var15 + var20 < 103) {
                                          var53[var49].flags[var14 + var54][var20 + var15] &= -16777217;
                                       }
                                    }
                                 }

                                 var66 = new Buffer(var52);

                                 for(var20 = 0; var20 < 4; ++var20) {
                                    for(var21 = 0; var21 < 64; ++var21) {
                                       for(var22 = 0; var22 < 64; ++var22) {
                                          if(var64 == var20 && var21 >= var16 && var21 < var16 + 8 && var22 >= var17 && var22 < var17 + 8) {
                                             var27 = var21 & 7;
                                             var28 = var22 & 7;
                                             var29 = var51 & 3;
                                             if(var29 == 0) {
                                                var26 = var27;
                                             } else if(var29 == 1) {
                                                var26 = var28;
                                             } else if(var29 == 2) {
                                                var26 = 7 - var27;
                                             } else {
                                                var26 = 7 - var28;
                                             }

                                             var32 = var26 + var14;
                                             var35 = var21 & 7;
                                             var36 = var22 & 7;
                                             var37 = var51 & 3;
                                             if(var37 == 0) {
                                                var34 = var36;
                                             } else if(var37 == 1) {
                                                var34 = 7 - var35;
                                             } else if(var37 == 2) {
                                                var34 = 7 - var36;
                                             } else {
                                                var34 = var35;
                                             }

                                             loadTerrain(var66, var49, var32, var34 + var15, 0, 0, var51);
                                          } else {
                                             loadTerrain(var66, 0, -1, -1, 0, 0, 0);
                                          }
                                       }
                                    }
                                 }

                                 var63 = true;
                                 break;
                              }
                           }
                        }

                        if(!var63) {
                           ScriptState.method1024(var49, var3 * 8, var4 * 8);
                        }
                     }
                  }
               }

               for(var49 = 0; var49 < 13; ++var49) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.field1133[0][var49][var3];
                     if(var4 == -1) {
                        KeyFocusListener.method739(var49 * 8, var3 * 8, 8, 8);
                     }
                  }
               }

               class1.flush(true);

               for(var49 = 0; var49 < 4; ++var49) {
                  class140.method2791();

                  for(var3 = 0; var3 < 13; ++var3) {
                     label1242:
                     for(var4 = 0; var4 < 13; ++var4) {
                        var5 = Client.field1133[var49][var3][var4];
                        if(var5 != -1) {
                           var6 = var5 >> 24 & 3;
                           var64 = var5 >> 1 & 3;
                           var51 = var5 >> 14 & 1023;
                           var9 = var5 >> 3 & 2047;
                           var10 = (var51 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < WorldListFetcher.mapRegions.length; ++var11) {
                              if(WorldListFetcher.mapRegions[var11] == var10 && Huffman.field2286[var11] != null) {
                                 byte[] var56 = Huffman.field2286[var11];
                                 var13 = var3 * 8;
                                 var14 = var4 * 8;
                                 var15 = (var51 & 7) * 8;
                                 var16 = (var9 & 7) * 8;
                                 Region var57 = class19.region;
                                 var53 = Client.collisionMaps;
                                 var66 = new Buffer(var56);
                                 var20 = -1;

                                 while(true) {
                                    var21 = var66.getUSmart();
                                    if(var21 == 0) {
                                       continue label1242;
                                    }

                                    var20 += var21;
                                    var22 = 0;

                                    while(true) {
                                       var23 = var66.getUSmart();
                                       if(var23 == 0) {
                                          break;
                                       }

                                       var22 += var23 - 1;
                                       var24 = var22 & 63;
                                       var25 = var22 >> 6 & 63;
                                       var26 = var22 >> 12;
                                       var27 = var66.readUnsignedByte();
                                       var28 = var27 >> 2;
                                       var29 = var27 & 3;
                                       if(var26 == var6 && var25 >= var15 && var25 < var15 + 8 && var24 >= var16 && var24 < var16 + 8) {
                                          ObjectComposition var30 = class169.getObjectDefinition(var20);
                                          var33 = var25 & 7;
                                          var34 = var24 & 7;
                                          var36 = var30.sizeX;
                                          var37 = var30.sizeY;
                                          if((var29 & 1) == 1) {
                                             var38 = var36;
                                             var36 = var37;
                                             var37 = var38;
                                          }

                                          var35 = var64 & 3;
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
                                          var41 = var25 & 7;
                                          var42 = var24 & 7;
                                          int var44 = var30.sizeX;
                                          int var45 = var30.sizeY;
                                          int var46;
                                          if((var29 & 1) == 1) {
                                             var46 = var44;
                                             var44 = var45;
                                             var45 = var46;
                                          }

                                          var43 = var64 & 3;
                                          if(var43 == 0) {
                                             var40 = var42;
                                          } else if(var43 == 1) {
                                             var40 = 7 - var41 - (var44 - 1);
                                          } else if(var43 == 2) {
                                             var40 = 7 - var42 - (var45 - 1);
                                          } else {
                                             var40 = var41;
                                          }

                                          var46 = var14 + var40;
                                          if(var38 > 0 && var46 > 0 && var38 < 103 && var46 < 103) {
                                             int var47 = var49;
                                             if((class61.tileSettings[1][var38][var46] & 2) == 2) {
                                                var47 = var49 - 1;
                                             }

                                             CollisionData var48 = null;
                                             if(var47 >= 0) {
                                                var48 = var53[var47];
                                             }

                                             class24.addObject(var49, var38, var46, var20, var29 + var64 & 3, var28, var57, var48);
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

            class1.flush(true);
            class5.method17();
            class140.method2791();
            Region var62 = class19.region;
            CollisionData[] var72 = Client.collisionMaps;

            for(var4 = 0; var4 < 4; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  for(var6 = 0; var6 < 104; ++var6) {
                     if((class61.tileSettings[var4][var5][var6] & 1) == 1) {
                        var64 = var4;
                        if((class61.tileSettings[1][var5][var6] & 2) == 2) {
                           var64 = var4 - 1;
                        }

                        if(var64 >= 0) {
                           var72[var64].method2973(var5, var6);
                        }
                     }
                  }
               }
            }

            class61.field750 += (int)(Math.random() * 5.0D) - 2;
            if(class61.field750 < -8) {
               class61.field750 = -8;
            }

            if(class61.field750 > 8) {
               class61.field750 = 8;
            }

            class61.field753 += (int)(Math.random() * 5.0D) - 2;
            if(class61.field753 < -16) {
               class61.field753 = -16;
            }

            if(class61.field753 > 16) {
               class61.field753 = 16;
            }

            for(var4 = 0; var4 < 4; ++var4) {
               byte[][] var70 = class134.field1949[var4];
               var11 = (int)Math.sqrt(5100.0D);
               var65 = var11 * 768 >> 8;

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     var15 = class61.tileHeights[var4][var14 + 1][var13] - class61.tileHeights[var4][var14 - 1][var13];
                     var16 = class61.tileHeights[var4][var14][var13 + 1] - class61.tileHeights[var4][var14][var13 - 1];
                     var17 = (int)Math.sqrt((double)(var16 * var16 + 65536 + var15 * var15));
                     var18 = (var15 << 8) / var17;
                     var54 = 65536 / var17;
                     var20 = (var16 << 8) / var17;
                     var21 = (var54 * -10 + var18 * -50 + var20 * -50) / var65 + 96;
                     var22 = (var70[var14 + 1][var13] >> 3) + (var70[var14 - 1][var13] >> 2) + (var70[var14][var13 - 1] >> 2) + (var70[var14][var13 + 1] >> 3) + (var70[var14][var13] >> 1);
                     class61.field756[var14][var13] = var21 - var22;
                  }
               }

               for(var13 = 0; var13 < 104; ++var13) {
                  class267.blendedHue[var13] = 0;
                  class35.blendedSaturation[var13] = 0;
                  class266.field3647[var13] = 0;
                  Timer.field2225[var13] = 0;
                  ISAACCipher.field2393[var13] = 0;
               }

               for(var13 = -5; var13 < 109; ++var13) {
                  for(var14 = 0; var14 < 104; ++var14) {
                     var15 = var13 + 5;
                     if(var15 >= 0 && var15 < 104) {
                        var16 = class224.underlayIds[var4][var15][var14] & 255;
                        if(var16 > 0) {
                           FloorUnderlayDefinition var73 = class163.method3000(var16 - 1);
                           class267.blendedHue[var14] += var73.hue;
                           class35.blendedSaturation[var14] += var73.saturation;
                           class266.field3647[var14] += var73.lightness;
                           Timer.field2225[var14] += var73.hueMultiplier;
                           ++ISAACCipher.field2393[var14];
                        }
                     }

                     var16 = var13 - 5;
                     if(var16 >= 0 && var16 < 104) {
                        var17 = class224.underlayIds[var4][var16][var14] & 255;
                        if(var17 > 0) {
                           FloorUnderlayDefinition var71 = class163.method3000(var17 - 1);
                           class267.blendedHue[var14] -= var71.hue;
                           class35.blendedSaturation[var14] -= var71.saturation;
                           class266.field3647[var14] -= var71.lightness;
                           Timer.field2225[var14] -= var71.hueMultiplier;
                           --ISAACCipher.field2393[var14];
                        }
                     }
                  }

                  if(var13 >= 1 && var13 < 103) {
                     var14 = 0;
                     var15 = 0;
                     var16 = 0;
                     var17 = 0;
                     var18 = 0;

                     for(var54 = -5; var54 < 109; ++var54) {
                        var20 = var54 + 5;
                        if(var20 >= 0 && var20 < 104) {
                           var14 += class267.blendedHue[var20];
                           var15 += class35.blendedSaturation[var20];
                           var16 += class266.field3647[var20];
                           var17 += Timer.field2225[var20];
                           var18 += ISAACCipher.field2393[var20];
                        }

                        var21 = var54 - 5;
                        if(var21 >= 0 && var21 < 104) {
                           var14 -= class267.blendedHue[var21];
                           var15 -= class35.blendedSaturation[var21];
                           var16 -= class266.field3647[var21];
                           var17 -= Timer.field2225[var21];
                           var18 -= ISAACCipher.field2393[var21];
                        }

                        if(var54 >= 1 && var54 < 103 && (!Client.lowMemory || (class61.tileSettings[0][var13][var54] & 2) != 0 || (class61.tileSettings[var4][var13][var54] & 16) == 0)) {
                           if(var4 < class61.field754) {
                              class61.field754 = var4;
                           }

                           var22 = class224.underlayIds[var4][var13][var54] & 255;
                           var23 = class5.overlayIds[var4][var13][var54] & 255;
                           if(var22 > 0 || var23 > 0) {
                              var24 = class61.tileHeights[var4][var13][var54];
                              var25 = class61.tileHeights[var4][var13 + 1][var54];
                              var26 = class61.tileHeights[var4][var13 + 1][var54 + 1];
                              var27 = class61.tileHeights[var4][var13][var54 + 1];
                              var28 = class61.field756[var13][var54];
                              var29 = class61.field756[var13 + 1][var54];
                              int var59 = class61.field756[var13 + 1][var54 + 1];
                              int var31 = class61.field756[var13][var54 + 1];
                              var32 = -1;
                              var33 = -1;
                              if(var22 > 0) {
                                 var34 = var14 * 256 / var17;
                                 var35 = var15 / var18;
                                 var36 = var16 / var18;
                                 var32 = class267.method4745(var34, var35, var36);
                                 var34 = var34 + class61.field750 & 255;
                                 var36 += class61.field753;
                                 if(var36 < 0) {
                                    var36 = 0;
                                 } else if(var36 > 255) {
                                    var36 = 255;
                                 }

                                 var33 = class267.method4745(var34, var35, var36);
                              }

                              if(var4 > 0) {
                                 boolean var68 = true;
                                 if(var22 == 0 && class61.overlayPaths[var4][var13][var54] != 0) {
                                    var68 = false;
                                 }

                                 if(var23 > 0 && !class157.method2908(var23 - 1).isHidden) {
                                    var68 = false;
                                 }

                                 if(var68 && var25 == var24 && var26 == var24 && var24 == var27) {
                                    class61.field755[var4][var13][var54] |= 2340;
                                 }
                              }

                              var34 = 0;
                              if(var33 != -1) {
                                 var34 = Graphics3D.colorPalette[class44.method603(var33, 96)];
                              }

                              if(var23 == 0) {
                                 var62.addTile(var4, var13, var54, 0, 0, -1, var24, var25, var26, var27, class44.method603(var32, var28), class44.method603(var32, var29), class44.method603(var32, var59), class44.method603(var32, var31), 0, 0, 0, 0, var34, 0);
                              } else {
                                 var35 = class61.overlayPaths[var4][var13][var54] + 1;
                                 byte var69 = class15.overlayRotations[var4][var13][var54];
                                 Overlay var60 = class157.method2908(var23 - 1);
                                 var38 = var60.texture;
                                 int var39;
                                 if(var38 >= 0) {
                                    var40 = Graphics3D.textureLoader.getAverageTextureRGB(var38);
                                    var39 = -1;
                                 } else if(var60.color == 16711935) {
                                    var39 = -2;
                                    var38 = -1;
                                    var40 = -2;
                                 } else {
                                    var39 = class267.method4745(var60.hue, var60.saturation, var60.lightness);
                                    var41 = var60.hue + class61.field750 & 255;
                                    var42 = var60.lightness + class61.field753;
                                    if(var42 < 0) {
                                       var42 = 0;
                                    } else if(var42 > 255) {
                                       var42 = 255;
                                    }

                                    var40 = class267.method4745(var41, var60.saturation, var42);
                                 }

                                 var41 = 0;
                                 if(var40 != -2) {
                                    var41 = Graphics3D.colorPalette[class134.adjustHSLListness0(var40, 96)];
                                 }

                                 if(var60.otherRgbColor != -1) {
                                    var42 = var60.otherHue + class61.field750 & 255;
                                    var43 = var60.otherLightness + class61.field753;
                                    if(var43 < 0) {
                                       var43 = 0;
                                    } else if(var43 > 255) {
                                       var43 = 255;
                                    }

                                    var40 = class267.method4745(var42, var60.otherSaturation, var43);
                                    var41 = Graphics3D.colorPalette[class134.adjustHSLListness0(var40, 96)];
                                 }

                                 var62.addTile(var4, var13, var54, var35, var69, var38, var24, var25, var26, var27, class44.method603(var32, var28), class44.method603(var32, var29), class44.method603(var32, var59), class44.method603(var32, var31), class134.adjustHSLListness0(var39, var28), class134.adjustHSLListness0(var39, var29), class134.adjustHSLListness0(var39, var59), class134.adjustHSLListness0(var39, var31), var34, var41);
                              }
                           }
                        }
                     }
                  }
               }

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     var62.setPhysicalLevel(var4, var14, var13, WidgetNode.method1045(var4, var14, var13));
                  }
               }

               class224.underlayIds[var4] = null;
               class5.overlayIds[var4] = null;
               class61.overlayPaths[var4] = null;
               class15.overlayRotations[var4] = null;
               class134.field1949[var4] = null;
            }

            var62.applyLighting(-50, -10, -50);

            for(var4 = 0; var4 < 104; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  if((class61.tileSettings[1][var4][var5] & 2) == 2) {
                     var62.setBridge(var4, var5);
                  }
               }
            }

            var4 = 1;
            var5 = 2;
            var6 = 4;

            for(var64 = 0; var64 < 4; ++var64) {
               if(var64 > 0) {
                  var4 <<= 3;
                  var5 <<= 3;
                  var6 <<= 3;
               }

               for(var51 = 0; var51 <= var64; ++var51) {
                  for(var9 = 0; var9 <= 104; ++var9) {
                     for(var10 = 0; var10 <= 104; ++var10) {
                        short var67;
                        if((class61.field755[var51][var10][var9] & var4) != 0) {
                           var11 = var9;
                           var65 = var9;
                           var13 = var51;

                           for(var14 = var51; var11 > 0 && (class61.field755[var51][var10][var11 - 1] & var4) != 0; --var11) {
                              ;
                           }

                           while(var65 < 104 && (class61.field755[var51][var10][var65 + 1] & var4) != 0) {
                              ++var65;
                           }

                           label977:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var65; ++var15) {
                                 if((class61.field755[var13 - 1][var10][var15] & var4) == 0) {
                                    break label977;
                                 }
                              }

                              --var13;
                           }

                           label966:
                           while(var14 < var64) {
                              for(var15 = var11; var15 <= var65; ++var15) {
                                 if((class61.field755[var14 + 1][var10][var15] & var4) == 0) {
                                    break label966;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (var65 - var11 + 1) * (var14 + 1 - var13);
                           if(var15 >= 8) {
                              var67 = 240;
                              var17 = class61.tileHeights[var14][var10][var11] - var67;
                              var18 = class61.tileHeights[var13][var10][var11];
                              Region.addOcclude(var64, 1, var10 * 128, var10 * 128, var11 * 128, var65 * 128 + 128, var17, var18);

                              for(var54 = var13; var54 <= var14; ++var54) {
                                 for(var20 = var11; var20 <= var65; ++var20) {
                                    class61.field755[var54][var10][var20] &= ~var4;
                                 }
                              }
                           }
                        }

                        if((class61.field755[var51][var10][var9] & var5) != 0) {
                           var11 = var10;
                           var65 = var10;
                           var13 = var51;

                           for(var14 = var51; var11 > 0 && (class61.field755[var51][var11 - 1][var9] & var5) != 0; --var11) {
                              ;
                           }

                           while(var65 < 104 && (class61.field755[var51][var65 + 1][var9] & var5) != 0) {
                              ++var65;
                           }

                           label1030:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var65; ++var15) {
                                 if((class61.field755[var13 - 1][var15][var9] & var5) == 0) {
                                    break label1030;
                                 }
                              }

                              --var13;
                           }

                           label1019:
                           while(var14 < var64) {
                              for(var15 = var11; var15 <= var65; ++var15) {
                                 if((class61.field755[var14 + 1][var15][var9] & var5) == 0) {
                                    break label1019;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (var14 + 1 - var13) * (var65 - var11 + 1);
                           if(var15 >= 8) {
                              var67 = 240;
                              var17 = class61.tileHeights[var14][var11][var9] - var67;
                              var18 = class61.tileHeights[var13][var11][var9];
                              Region.addOcclude(var64, 2, var11 * 128, var65 * 128 + 128, var9 * 128, var9 * 128, var17, var18);

                              for(var54 = var13; var54 <= var14; ++var54) {
                                 for(var20 = var11; var20 <= var65; ++var20) {
                                    class61.field755[var54][var20][var9] &= ~var5;
                                 }
                              }
                           }
                        }

                        if((class61.field755[var51][var10][var9] & var6) != 0) {
                           var11 = var10;
                           var65 = var10;
                           var13 = var9;

                           for(var14 = var9; var13 > 0 && (class61.field755[var51][var10][var13 - 1] & var6) != 0; --var13) {
                              ;
                           }

                           while(var14 < 104 && (class61.field755[var51][var10][var14 + 1] & var6) != 0) {
                              ++var14;
                           }

                           label1083:
                           while(var11 > 0) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((class61.field755[var51][var11 - 1][var15] & var6) == 0) {
                                    break label1083;
                                 }
                              }

                              --var11;
                           }

                           label1072:
                           while(var65 < 104) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((class61.field755[var51][var65 + 1][var15] & var6) == 0) {
                                    break label1072;
                                 }
                              }

                              ++var65;
                           }

                           if((var65 - var11 + 1) * (var14 - var13 + 1) >= 4) {
                              var15 = class61.tileHeights[var51][var11][var13];
                              Region.addOcclude(var64, 4, var11 * 128, 128 + var65 * 128, var13 * 128, 128 + var14 * 128, var15, var15);

                              for(var16 = var11; var16 <= var65; ++var16) {
                                 for(var17 = var13; var17 <= var14; ++var17) {
                                    class61.field755[var51][var16][var17] &= ~var6;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            class1.flush(true);
            var4 = class61.field754;
            if(var4 > class10.plane) {
               var4 = class10.plane;
            }

            if(var4 < class10.plane - 1) {
               var4 = class10.plane - 1;
            }

            if(Client.lowMemory) {
               class19.region.setup(class61.field754);
            } else {
               class19.region.setup(0);
            }

            for(var5 = 0; var5 < 104; ++var5) {
               for(var6 = 0; var6 < 104; ++var6) {
                  ChatLineBuffer.groundItemSpawned(var5, var6);
               }
            }

            class140.method2791();
            class41.method530();
            ObjectComposition.field3443.reset();
            if(CombatInfoListHolder.clientInstance.method842()) {
               Client.secretPacketBuffer1.putOpcode(10);
               Client.secretPacketBuffer1.putInt(1057001181);
            }

            if(!Client.isDynamicRegion) {
               var5 = (class181.field2404 - 6) / 8;
               var6 = (class181.field2404 + 6) / 8;
               var64 = (WallObject.field2088 - 6) / 8;
               var51 = (WallObject.field2088 + 6) / 8;

               for(var9 = var5 - 1; var9 <= var6 + 1; ++var9) {
                  for(var10 = var64 - 1; var10 <= var51 + 1; ++var10) {
                     if(var9 < var5 || var9 > var6 || var10 < var64 || var10 > var51) {
                        ISAACCipher.indexMaps.method4030("m" + var9 + "_" + var10);
                        ISAACCipher.indexMaps.method4030("l" + var9 + "_" + var10);
                     }
                  }
               }
            }

            class152.setGameState(30);
            class140.method2791();
            class224.underlayIds = null;
            class5.overlayIds = null;
            class61.overlayPaths = null;
            class15.overlayRotations = null;
            class61.field755 = null;
            class134.field1949 = null;
            class61.field756 = null;
            class267.blendedHue = null;
            class35.blendedSaturation = null;
            class266.field3647 = null;
            Timer.field2225 = null;
            ISAACCipher.field2393 = null;
            Client.secretPacketBuffer1.putOpcode(70);
            ItemLayer.timer.vmethod2909();

            for(var5 = 0; var5 < 32; ++var5) {
               GameEngine.field696[var5] = 0L;
            }

            for(var5 = 0; var5 < 32; ++var5) {
               GameEngine.field686[var5] = 0L;
            }

            GameEngine.field692 = 0;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lfp;IIIIIII)V",
      garbageValue = "974640729"
   )
   @Export("loadTerrain")
   static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class61.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -class140.method2792(var2 + var4 + 932731, var3 + var5 + 556238) * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.readUnsignedByte();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -var8 * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class5.overlayIds[var1][var2][var3] = var0.readByte();
               class61.overlayPaths[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class15.overlayRotations[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class61.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class224.underlayIds[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }
}
