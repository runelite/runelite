import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1687064927
   )
   @Export("length")
   int length;
   @ObfuscatedName("c")
   @Export("lines")
   MessageNode[] lines = new MessageNode[100];

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)LMessageNode;",
      garbageValue = "117"
   )
   MessageNode method923(int var1, String var2, String var3, String var4) {
      MessageNode var5 = this.lines[99];

      for(int var6 = this.length; var6 > 0; --var6) {
         if(var6 != 100) {
            this.lines[var6] = this.lines[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new MessageNode(var1, var2, var4, var3);
      } else {
         var5.unlink();
         var5.method2851();
         var5.method216(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "1750738907"
   )
   MessageNode method924(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-366964683"
   )
   public static final boolean method925() {
      class105 var0 = class105.keyboard;
      synchronized(class105.keyboard) {
         if(class105.field1694 == class105.field1703) {
            return false;
         } else {
            class177.field2652 = class105.field1702[class105.field1703];
            class25.field571 = class105.field1699[class105.field1703];
            class105.field1703 = class105.field1703 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "157863331"
   )
   int method930() {
      return this.length;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1416448424"
   )
   static final void method933() {
      class114.method2211(false);
      Client.field337 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class215.field3156.length; ++var1) {
         if(XClanMember.field272[var1] != -1 && class215.field3156[var1] == null) {
            class215.field3156[var1] = FileOnDisk.indexMaps.getConfigData(XClanMember.field272[var1], 0);
            if(class215.field3156[var1] == null) {
               var0 = false;
               ++Client.field337;
            }
         }

         if(Actor.field641[var1] != -1 && RSCanvas.field1759[var1] == null) {
            RSCanvas.field1759[var1] = FileOnDisk.indexMaps.getConfigData(Actor.field641[var1], 0, class118.xteaKeys[var1]);
            if(RSCanvas.field1759[var1] == null) {
               var0 = false;
               ++Client.field337;
            }
         }
      }

      if(!var0) {
         Client.field341 = 1;
      } else {
         Client.field369 = 0;
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
         for(var1 = 0; var1 < class215.field3156.length; ++var1) {
            byte[] var2 = RSCanvas.field1759[var1];
            if(var2 != null) {
               var3 = (class164.mapRegions[var1] >> 8) * 64 - class108.baseX;
               var4 = (class164.mapRegions[var1] & 255) * 64 - GameEngine.baseY;
               if(Client.isDynamicRegion) {
                  var3 = 10;
                  var4 = 10;
               }

               boolean var7 = true;
               var8 = new Buffer(var2);
               var9 = -1;

               label1485:
               while(true) {
                  var10 = var8.method2395();
                  if(var10 == 0) {
                     var0 &= var7;
                     break;
                  }

                  var9 += var10;
                  var11 = 0;
                  boolean var12 = false;

                  while(true) {
                     while(!var12) {
                        var13 = var8.method2395();
                        if(var13 == 0) {
                           continue label1485;
                        }

                        var11 += var13 - 1;
                        var14 = var11 & 63;
                        var15 = var11 >> 6 & 63;
                        var16 = var8.readUnsignedByte() >> 2;
                        var17 = var15 + var3;
                        var18 = var14 + var4;
                        if(var17 > 0 && var18 > 0 && var17 < 103 && var18 < 103) {
                           ObjectComposition var19 = class26.getObjectDefinition(var9);
                           if(var16 != 22 || !Client.field285 || var19.field2943 != 0 || var19.field2936 == 1 || var19.field2962) {
                              if(!var19.method3683()) {
                                 ++Client.field369;
                                 var7 = false;
                              }

                              var12 = true;
                           }
                        }
                     }

                     var13 = var8.method2395();
                     if(var13 == 0) {
                        break;
                     }

                     var8.readUnsignedByte();
                  }
               }
            }
         }

         if(!var0) {
            Client.field341 = 2;
         } else {
            if(Client.field341 != 0) {
               class38.method769("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            GameEngine.method2201();
            class101.method1962();
            GameEngine.method2201();
            class172.region.method1721();
            GameEngine.method2201();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].method2250();
            }

            int var46;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var46 = 0; var46 < 104; ++var46) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class10.tileSettings[var1][var46][var3] = 0;
                  }
               }
            }

            GameEngine.method2201();
            class10.field93 = 99;
            class173.underlayIds = new byte[4][104][104];
            class119.overlayIds = new byte[4][104][104];
            class10.overlayPaths = new byte[4][104][104];
            class124.overlayRotations = new byte[4][104][104];
            class164.field2160 = new int[4][105][105];
            class44.field882 = new byte[4][105][105];
            ItemLayer.field1199 = new int[105][105];
            FrameMap.field1459 = new int[104];
            class10.field98 = new int[104];
            class10.field96 = new int[104];
            class138.field2005 = new int[104];
            class10.field91 = new int[104];
            var1 = class215.field3156.length;

            for(class31 var65 = (class31)class31.field709.method2828(); var65 != null; var65 = (class31)class31.field709.method2830()) {
               if(var65.field705 != null) {
                  class114.field1791.method945(var65.field705);
                  var65.field705 = null;
               }

               if(var65.field710 != null) {
                  class114.field1791.method945(var65.field710);
                  var65.field710 = null;
               }
            }

            class31.field709.method2823();
            class114.method2211(true);
            int var5;
            int var21;
            int var49;
            int var50;
            int var69;
            if(!Client.isDynamicRegion) {
               byte[] var52;
               for(var46 = 0; var46 < var1; ++var46) {
                  var3 = (class164.mapRegions[var46] >> 8) * 64 - class108.baseX;
                  var4 = (class164.mapRegions[var46] & 255) * 64 - GameEngine.baseY;
                  var52 = class215.field3156[var46];
                  if(var52 != null) {
                     GameEngine.method2201();
                     Buffer.method2600(var52, var3, var4, Actor.field619 * 8 - 48, class180.field2680 * 8 - 48, Client.collisionMaps);
                  }
               }

               for(var46 = 0; var46 < var1; ++var46) {
                  var3 = (class164.mapRegions[var46] >> 8) * 64 - class108.baseX;
                  var4 = (class164.mapRegions[var46] & 255) * 64 - GameEngine.baseY;
                  var52 = class215.field3156[var46];
                  if(var52 == null && class180.field2680 < 800) {
                     GameEngine.method2201();
                     class103.method1993(var3, var4, 64, 64);
                  }
               }

               class114.method2211(true);

               for(var46 = 0; var46 < var1; ++var46) {
                  byte[] var53 = RSCanvas.field1759[var46];
                  if(var53 != null) {
                     var4 = (class164.mapRegions[var46] >> 8) * 64 - class108.baseX;
                     var5 = (class164.mapRegions[var46] & 255) * 64 - GameEngine.baseY;
                     GameEngine.method2201();
                     Region var54 = class172.region;
                     CollisionData[] var55 = Client.collisionMaps;
                     var8 = new Buffer(var53);
                     var9 = -1;

                     while(true) {
                        var10 = var8.method2395();
                        if(var10 == 0) {
                           break;
                        }

                        var9 += var10;
                        var11 = 0;

                        while(true) {
                           var69 = var8.method2395();
                           if(var69 == 0) {
                              break;
                           }

                           var11 += var69 - 1;
                           var13 = var11 & 63;
                           var14 = var11 >> 6 & 63;
                           var15 = var11 >> 12;
                           var16 = var8.readUnsignedByte();
                           var17 = var16 >> 2;
                           var18 = var16 & 3;
                           var49 = var4 + var14;
                           var50 = var5 + var13;
                           if(var49 > 0 && var50 > 0 && var49 < 103 && var50 < 103) {
                              var21 = var15;
                              if((class10.tileSettings[1][var49][var50] & 2) == 2) {
                                 var21 = var15 - 1;
                              }

                              CollisionData var57 = null;
                              if(var21 >= 0) {
                                 var57 = var55[var21];
                              }

                              class9.method107(var15, var49, var50, var9, var18, var17, var54, var57);
                           }
                        }
                     }
                  }
               }
            }

            int var6;
            int var22;
            int var23;
            int var24;
            int var25;
            int var26;
            int var27;
            int var28;
            int var29;
            int var31;
            int var32;
            int var33;
            int var48;
            int var68;
            if(Client.isDynamicRegion) {
               for(var46 = 0; var46 < 4; ++var46) {
                  GameEngine.method2201();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var67 = false;
                        var6 = Client.field344[var46][var3][var4];
                        if(var6 != -1) {
                           var68 = var6 >> 24 & 3;
                           var48 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = var10 / 8 + (var9 / 8 << 8);

                           for(var69 = 0; var69 < class164.mapRegions.length; ++var69) {
                              if(var11 == class164.mapRegions[var69] && class215.field3156[var69] != null) {
                                 class121.method2303(class215.field3156[var69], var46, var3 * 8, var4 * 8, var68, (var9 & 7) * 8, (var10 & 7) * 8, var48, Client.collisionMaps);
                                 var67 = true;
                                 break;
                              }
                           }
                        }

                        if(!var67) {
                           class33.method715(var46, var3 * 8, var4 * 8);
                        }
                     }
                  }
               }

               for(var46 = 0; var46 < 13; ++var46) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.field344[0][var46][var3];
                     if(var4 == -1) {
                        class103.method1993(var46 * 8, var3 * 8, 8, 8);
                     }
                  }
               }

               class114.method2211(true);

               for(var46 = 0; var46 < 4; ++var46) {
                  GameEngine.method2201();

                  for(var3 = 0; var3 < 13; ++var3) {
                     label1341:
                     for(var4 = 0; var4 < 13; ++var4) {
                        var5 = Client.field344[var46][var3][var4];
                        if(var5 != -1) {
                           var6 = var5 >> 24 & 3;
                           var68 = var5 >> 1 & 3;
                           var48 = var5 >> 14 & 1023;
                           var9 = var5 >> 3 & 2047;
                           var10 = (var48 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < class164.mapRegions.length; ++var11) {
                              if(var10 == class164.mapRegions[var11] && RSCanvas.field1759[var11] != null) {
                                 byte[] var58 = RSCanvas.field1759[var11];
                                 var13 = var3 * 8;
                                 var14 = var4 * 8;
                                 var15 = (var48 & 7) * 8;
                                 var16 = (var9 & 7) * 8;
                                 Region var60 = class172.region;
                                 CollisionData[] var51 = Client.collisionMaps;
                                 Buffer var70 = new Buffer(var58);
                                 var50 = -1;

                                 while(true) {
                                    var21 = var70.method2395();
                                    if(var21 == 0) {
                                       continue label1341;
                                    }

                                    var50 += var21;
                                    var22 = 0;

                                    while(true) {
                                       var23 = var70.method2395();
                                       if(var23 == 0) {
                                          break;
                                       }

                                       var22 += var23 - 1;
                                       var24 = var22 & 63;
                                       var25 = var22 >> 6 & 63;
                                       var26 = var22 >> 12;
                                       var27 = var70.readUnsignedByte();
                                       var28 = var27 >> 2;
                                       var29 = var27 & 3;
                                       if(var6 == var26 && var25 >= var15 && var25 < var15 + 8 && var24 >= var16 && var24 < var16 + 8) {
                                          ObjectComposition var59 = class26.getObjectDefinition(var50);
                                          var31 = var13 + XItemContainer.method171(var25 & 7, var24 & 7, var68, var59.sizeX, var59.sizeY, var29);
                                          var32 = var14 + WallObject.method1904(var25 & 7, var24 & 7, var68, var59.sizeX, var59.sizeY, var29);
                                          if(var31 > 0 && var32 > 0 && var31 < 103 && var32 < 103) {
                                             var33 = var46;
                                             if((class10.tileSettings[1][var31][var32] & 2) == 2) {
                                                var33 = var46 - 1;
                                             }

                                             CollisionData var34 = null;
                                             if(var33 >= 0) {
                                                var34 = var51[var33];
                                             }

                                             class9.method107(var46, var31, var32, var50, var29 + var68 & 3, var28, var60, var34);
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

            class114.method2211(true);
            class101.method1962();
            GameEngine.method2201();
            Region var66 = class172.region;
            CollisionData[] var77 = Client.collisionMaps;

            for(var4 = 0; var4 < 4; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  for(var6 = 0; var6 < 104; ++var6) {
                     if((class10.tileSettings[var4][var5][var6] & 1) == 1) {
                        var68 = var4;
                        if((class10.tileSettings[1][var5][var6] & 2) == 2) {
                           var68 = var4 - 1;
                        }

                        if(var68 >= 0) {
                           var77[var68].method2255(var5, var6);
                        }
                     }
                  }
               }
            }

            class10.field104 += (int)(Math.random() * 5.0D) - 2;
            if(class10.field104 < -8) {
               class10.field104 = -8;
            }

            if(class10.field104 > 8) {
               class10.field104 = 8;
            }

            class10.field105 += (int)(Math.random() * 5.0D) - 2;
            if(class10.field105 < -16) {
               class10.field105 = -16;
            }

            if(class10.field105 > 16) {
               class10.field105 = 16;
            }

            for(var4 = 0; var4 < 4; ++var4) {
               byte[][] var76 = class44.field882[var4];
               var11 = (int)Math.sqrt(5100.0D);
               var69 = var11 * 768 >> 8;

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     var15 = class10.tileHeights[var4][var14 + 1][var13] - class10.tileHeights[var4][var14 - 1][var13];
                     var16 = class10.tileHeights[var4][var14][var13 + 1] - class10.tileHeights[var4][var14][var13 - 1];
                     var17 = (int)Math.sqrt((double)(var15 * var15 + 65536 + var16 * var16));
                     var18 = (var15 << 8) / var17;
                     var49 = 65536 / var17;
                     var50 = (var16 << 8) / var17;
                     var21 = (var50 * -50 + var18 * -50 + var49 * -10) / var69 + 96;
                     var22 = (var76[var14][var13] >> 1) + (var76[var14 - 1][var13] >> 2) + (var76[var14 + 1][var13] >> 3) + (var76[var14][var13 - 1] >> 2) + (var76[var14][var13 + 1] >> 3);
                     ItemLayer.field1199[var14][var13] = var21 - var22;
                  }
               }

               for(var13 = 0; var13 < 104; ++var13) {
                  FrameMap.field1459[var13] = 0;
                  class10.field98[var13] = 0;
                  class10.field96[var13] = 0;
                  class138.field2005[var13] = 0;
                  class10.field91[var13] = 0;
               }

               for(var13 = -5; var13 < 109; ++var13) {
                  for(var14 = 0; var14 < 104; ++var14) {
                     var15 = var13 + 5;
                     if(var15 >= 0 && var15 < 104) {
                        var16 = class173.underlayIds[var4][var15][var14] & 255;
                        if(var16 > 0) {
                           var18 = var16 - 1;
                           FloorUnderlayDefinition var71 = (FloorUnderlayDefinition)FloorUnderlayDefinition.field2822.get((long)var18);
                           FloorUnderlayDefinition var78;
                           if(var71 != null) {
                              var78 = var71;
                           } else {
                              byte[] var20 = FloorUnderlayDefinition.field2820.getConfigData(1, var18);
                              var71 = new FloorUnderlayDefinition();
                              if(var20 != null) {
                                 var71.method3488(new Buffer(var20), var18);
                              }

                              var71.method3490();
                              FloorUnderlayDefinition.field2822.put(var71, (long)var18);
                              var78 = var71;
                           }

                           FrameMap.field1459[var14] += var78.field2825;
                           class10.field98[var14] += var78.field2823;
                           class10.field96[var14] += var78.field2819;
                           class138.field2005[var14] += var78.field2824;
                           ++class10.field91[var14];
                        }
                     }

                     var16 = var13 - 5;
                     if(var16 >= 0 && var16 < 104) {
                        var17 = class173.underlayIds[var4][var16][var14] & 255;
                        if(var17 > 0) {
                           var49 = var17 - 1;
                           FloorUnderlayDefinition var73 = (FloorUnderlayDefinition)FloorUnderlayDefinition.field2822.get((long)var49);
                           FloorUnderlayDefinition var75;
                           if(var73 != null) {
                              var75 = var73;
                           } else {
                              byte[] var61 = FloorUnderlayDefinition.field2820.getConfigData(1, var49);
                              var73 = new FloorUnderlayDefinition();
                              if(var61 != null) {
                                 var73.method3488(new Buffer(var61), var49);
                              }

                              var73.method3490();
                              FloorUnderlayDefinition.field2822.put(var73, (long)var49);
                              var75 = var73;
                           }

                           FrameMap.field1459[var14] -= var75.field2825;
                           class10.field98[var14] -= var75.field2823;
                           class10.field96[var14] -= var75.field2819;
                           class138.field2005[var14] -= var75.field2824;
                           --class10.field91[var14];
                        }
                     }
                  }

                  if(var13 >= 1 && var13 < 103) {
                     var14 = 0;
                     var15 = 0;
                     var16 = 0;
                     var17 = 0;
                     var18 = 0;

                     for(var49 = -5; var49 < 109; ++var49) {
                        var50 = var49 + 5;
                        if(var50 >= 0 && var50 < 104) {
                           var14 += FrameMap.field1459[var50];
                           var15 += class10.field98[var50];
                           var16 += class10.field96[var50];
                           var17 += class138.field2005[var50];
                           var18 += class10.field91[var50];
                        }

                        var21 = var49 - 5;
                        if(var21 >= 0 && var21 < 104) {
                           var14 -= FrameMap.field1459[var21];
                           var15 -= class10.field98[var21];
                           var16 -= class10.field96[var21];
                           var17 -= class138.field2005[var21];
                           var18 -= class10.field91[var21];
                        }

                        if(var49 >= 1 && var49 < 103 && (!Client.field285 || (class10.tileSettings[0][var13][var49] & 2) != 0 || (class10.tileSettings[var4][var13][var49] & 16) == 0)) {
                           if(var4 < class10.field93) {
                              class10.field93 = var4;
                           }

                           var22 = class173.underlayIds[var4][var13][var49] & 255;
                           var23 = class119.overlayIds[var4][var13][var49] & 255;
                           if(var22 > 0 || var23 > 0) {
                              var24 = class10.tileHeights[var4][var13][var49];
                              var25 = class10.tileHeights[var4][var13 + 1][var49];
                              var26 = class10.tileHeights[var4][var13 + 1][var49 + 1];
                              var27 = class10.tileHeights[var4][var13][var49 + 1];
                              var28 = ItemLayer.field1199[var13][var49];
                              var29 = ItemLayer.field1199[var13 + 1][var49];
                              int var30 = ItemLayer.field1199[var13 + 1][var49 + 1];
                              var31 = ItemLayer.field1199[var13][var49 + 1];
                              var32 = -1;
                              var33 = -1;
                              int var35;
                              int var36;
                              int var62;
                              if(var22 > 0) {
                                 var62 = var14 * 256 / var17;
                                 var35 = var15 / var18;
                                 var36 = var16 / var18;
                                 var32 = class39.method773(var62, var35, var36);
                                 var62 = class10.field104 + var62 & 255;
                                 var36 += class10.field105;
                                 if(var36 < 0) {
                                    var36 = 0;
                                 } else if(var36 > 255) {
                                    var36 = 255;
                                 }

                                 var33 = class39.method773(var62, var35, var36);
                              }

                              Overlay var37;
                              if(var4 > 0) {
                                 boolean var79 = true;
                                 if(var22 == 0 && class10.overlayPaths[var4][var13][var49] != 0) {
                                    var79 = false;
                                 }

                                 if(var23 > 0) {
                                    var36 = var23 - 1;
                                    var37 = (Overlay)Overlay.field3071.get((long)var36);
                                    Overlay var47;
                                    if(var37 != null) {
                                       var47 = var37;
                                    } else {
                                       byte[] var63 = Overlay.field3081.getConfigData(4, var36);
                                       var37 = new Overlay();
                                       if(var63 != null) {
                                          var37.method3839(new Buffer(var63), var36);
                                       }

                                       var37.method3837();
                                       Overlay.field3071.put(var37, (long)var36);
                                       var47 = var37;
                                    }

                                    if(!var47.isHidden) {
                                       var79 = false;
                                    }
                                 }

                                 if(var79 && var24 == var25 && var24 == var26 && var27 == var24) {
                                    class164.field2160[var4][var13][var49] |= 2340;
                                 }
                              }

                              var62 = 0;
                              if(var33 != -1) {
                                 var62 = class84.colorPalette[class65.method1194(var33, 96)];
                              }

                              if(var23 == 0) {
                                 var66.method1859(var4, var13, var49, 0, 0, -1, var24, var25, var26, var27, class65.method1194(var32, var28), class65.method1194(var32, var29), class65.method1194(var32, var30), class65.method1194(var32, var31), 0, 0, 0, 0, var62, 0);
                              } else {
                                 var35 = class10.overlayPaths[var4][var13][var49] + 1;
                                 byte var74 = class124.overlayRotations[var4][var13][var49];
                                 int var38 = var23 - 1;
                                 Overlay var39 = (Overlay)Overlay.field3071.get((long)var38);
                                 if(var39 != null) {
                                    var37 = var39;
                                 } else {
                                    byte[] var64 = Overlay.field3081.getConfigData(4, var38);
                                    var39 = new Overlay();
                                    if(var64 != null) {
                                       var39.method3839(new Buffer(var64), var38);
                                    }

                                    var39.method3837();
                                    Overlay.field3071.put(var39, (long)var38);
                                    var37 = var39;
                                 }

                                 int var40 = var37.texture;
                                 int var41;
                                 int var42;
                                 int var43;
                                 int var44;
                                 if(var40 >= 0) {
                                    var42 = class84.field1437.vmethod1913(var40);
                                    var41 = -1;
                                 } else if(var37.color == 16711935) {
                                    var41 = -2;
                                    var40 = -1;
                                    var42 = -2;
                                 } else {
                                    var41 = class39.method773(var37.hue, var37.saturation, var37.lightness);
                                    var43 = class10.field104 + var37.hue & 255;
                                    var44 = var37.lightness + class10.field105;
                                    if(var44 < 0) {
                                       var44 = 0;
                                    } else if(var44 > 255) {
                                       var44 = 255;
                                    }

                                    var42 = class39.method773(var43, var37.saturation, var44);
                                 }

                                 var43 = 0;
                                 if(var42 != -2) {
                                    var43 = class84.colorPalette[class15.method186(var42, 96)];
                                 }

                                 if(var37.field3079 != -1) {
                                    var44 = var37.field3072 + class10.field104 & 255;
                                    int var45 = var37.field3070 + class10.field105;
                                    if(var45 < 0) {
                                       var45 = 0;
                                    } else if(var45 > 255) {
                                       var45 = 255;
                                    }

                                    var42 = class39.method773(var44, var37.field3080, var45);
                                    var43 = class84.colorPalette[class15.method186(var42, 96)];
                                 }

                                 var66.method1859(var4, var13, var49, var35, var74, var40, var24, var25, var26, var27, class65.method1194(var32, var28), class65.method1194(var32, var29), class65.method1194(var32, var30), class65.method1194(var32, var31), class15.method186(var41, var28), class15.method186(var41, var29), class15.method186(var41, var30), class15.method186(var41, var31), var62, var43);
                              }
                           }
                        }
                     }
                  }
               }

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     if((class10.tileSettings[var4][var14][var13] & 8) != 0) {
                        var49 = 0;
                     } else if(var4 > 0 && (class10.tileSettings[1][var14][var13] & 2) != 0) {
                        var49 = var4 - 1;
                     } else {
                        var49 = var4;
                     }

                     var66.method1725(var4, var14, var13, var49);
                  }
               }

               class173.underlayIds[var4] = null;
               class119.overlayIds[var4] = null;
               class10.overlayPaths[var4] = null;
               class124.overlayRotations[var4] = null;
               class44.field882[var4] = null;
            }

            var66.method1839(-50, -10, -50);

            for(var4 = 0; var4 < 104; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  if((class10.tileSettings[1][var4][var5] & 2) == 2) {
                     var66.method1823(var4, var5);
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
                        short var72;
                        if((class164.field2160[var48][var10][var9] & var4) != 0) {
                           var11 = var9;
                           var69 = var9;
                           var13 = var48;

                           for(var14 = var48; var11 > 0 && (class164.field2160[var48][var10][var11 - 1] & var4) != 0; --var11) {
                              ;
                           }

                           while(var69 < 104 && (class164.field2160[var48][var10][var69 + 1] & var4) != 0) {
                              ++var69;
                           }

                           label1069:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var69; ++var15) {
                                 if((class164.field2160[var13 - 1][var10][var15] & var4) == 0) {
                                    break label1069;
                                 }
                              }

                              --var13;
                           }

                           label1058:
                           while(var14 < var68) {
                              for(var15 = var11; var15 <= var69; ++var15) {
                                 if((class164.field2160[var14 + 1][var10][var15] & var4) == 0) {
                                    break label1058;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (var69 - var11 + 1) * (var14 + 1 - var13);
                           if(var15 >= 8) {
                              var72 = 240;
                              var17 = class10.tileHeights[var14][var10][var11] - var72;
                              var18 = class10.tileHeights[var13][var10][var11];
                              Region.method1881(var68, 1, var10 * 128, var10 * 128, var11 * 128, var69 * 128 + 128, var17, var18);

                              for(var49 = var13; var49 <= var14; ++var49) {
                                 for(var50 = var11; var50 <= var69; ++var50) {
                                    class164.field2160[var49][var10][var50] &= ~var4;
                                 }
                              }
                           }
                        }

                        if((class164.field2160[var48][var10][var9] & var5) != 0) {
                           var11 = var10;
                           var69 = var10;
                           var13 = var48;

                           for(var14 = var48; var11 > 0 && (class164.field2160[var48][var11 - 1][var9] & var5) != 0; --var11) {
                              ;
                           }

                           while(var69 < 104 && (class164.field2160[var48][var69 + 1][var9] & var5) != 0) {
                              ++var69;
                           }

                           label1122:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var69; ++var15) {
                                 if((class164.field2160[var13 - 1][var15][var9] & var5) == 0) {
                                    break label1122;
                                 }
                              }

                              --var13;
                           }

                           label1111:
                           while(var14 < var68) {
                              for(var15 = var11; var15 <= var69; ++var15) {
                                 if((class164.field2160[var14 + 1][var15][var9] & var5) == 0) {
                                    break label1111;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (var69 - var11 + 1) * (var14 + 1 - var13);
                           if(var15 >= 8) {
                              var72 = 240;
                              var17 = class10.tileHeights[var14][var11][var9] - var72;
                              var18 = class10.tileHeights[var13][var11][var9];
                              Region.method1881(var68, 2, var11 * 128, var69 * 128 + 128, var9 * 128, var9 * 128, var17, var18);

                              for(var49 = var13; var49 <= var14; ++var49) {
                                 for(var50 = var11; var50 <= var69; ++var50) {
                                    class164.field2160[var49][var50][var9] &= ~var5;
                                 }
                              }
                           }
                        }

                        if((class164.field2160[var48][var10][var9] & var6) != 0) {
                           var11 = var10;
                           var69 = var10;
                           var13 = var9;

                           for(var14 = var9; var13 > 0 && (class164.field2160[var48][var10][var13 - 1] & var6) != 0; --var13) {
                              ;
                           }

                           while(var14 < 104 && (class164.field2160[var48][var10][var14 + 1] & var6) != 0) {
                              ++var14;
                           }

                           label1175:
                           while(var11 > 0) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((class164.field2160[var48][var11 - 1][var15] & var6) == 0) {
                                    break label1175;
                                 }
                              }

                              --var11;
                           }

                           label1164:
                           while(var69 < 104) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((class164.field2160[var48][var69 + 1][var15] & var6) == 0) {
                                    break label1164;
                                 }
                              }

                              ++var69;
                           }

                           if((var69 - var11 + 1) * (var14 - var13 + 1) >= 4) {
                              var15 = class10.tileHeights[var48][var11][var13];
                              Region.method1881(var68, 4, var11 * 128, var69 * 128 + 128, var13 * 128, var14 * 128 + 128, var15, var15);

                              for(var16 = var11; var16 <= var69; ++var16) {
                                 for(var17 = var13; var17 <= var14; ++var17) {
                                    class164.field2160[var48][var16][var17] &= ~var6;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            class114.method2211(true);
            var4 = class10.field93;
            if(var4 > Client.plane) {
               var4 = Client.plane;
            }

            if(var4 < Client.plane - 1) {
               var4 = Client.plane - 1;
            }

            if(Client.field285) {
               class172.region.method1722(class10.field93);
            } else {
               class172.region.method1722(0);
            }

            for(var5 = 0; var5 < 104; ++var5) {
               for(var6 = 0; var6 < 104; ++var6) {
                  class40.groundItemSpawned(var5, var6);
               }
            }

            GameEngine.method2201();
            class200.method3626();
            ObjectComposition.field2927.reset();
            if(class3.field26 != null) {
               Client.secretCipherBuffer1.putOpcode(60);
               Client.secretCipherBuffer1.putInt(1057001181);
            }

            if(!Client.isDynamicRegion) {
               var5 = (Actor.field619 - 6) / 8;
               var6 = (Actor.field619 + 6) / 8;
               var68 = (class180.field2680 - 6) / 8;
               var48 = (class180.field2680 + 6) / 8;

               for(var9 = var5 - 1; var9 <= var6 + 1; ++var9) {
                  for(var10 = var68 - 1; var10 <= var48 + 1; ++var10) {
                     if(var9 < var5 || var9 > var6 || var10 < var68 || var10 > var48) {
                        FileOnDisk.indexMaps.method3335("m" + var9 + "_" + var10);
                        FileOnDisk.indexMaps.method3335("l" + var9 + "_" + var10);
                     }
                  }
               }
            }

            class9.setGameState(30);
            GameEngine.method2201();
            class173.underlayIds = null;
            class119.overlayIds = null;
            class10.overlayPaths = null;
            class124.overlayRotations = null;
            class164.field2160 = null;
            class44.field882 = null;
            ItemLayer.field1199 = null;
            FrameMap.field1459 = null;
            class10.field98 = null;
            class10.field96 = null;
            class138.field2005 = null;
            class10.field91 = null;
            Client.secretCipherBuffer1.putOpcode(54);
            ChatMessages.field916.vmethod2062();

            for(var5 = 0; var5 < 32; ++var5) {
               GameEngine.field1773[var5] = 0L;
            }

            for(var5 = 0; var5 < 32; ++var5) {
               GameEngine.field1774[var5] = 0L;
            }

            XItemContainer.field130 = 0;
         }
      }
   }
}
