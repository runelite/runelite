import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class48 extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2061477207
   )
   int field927;
   @ObfuscatedName("x")
   int[] field928;
   @ObfuscatedName("u")
   static NodeCache field929 = new NodeCache(128);
   @ObfuscatedName("a")
   String[] field930;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1000663143
   )
   int field931;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1899496679
   )
   int field932;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1252351411
   )
   int field934;
   @ObfuscatedName("i")
   int[] field935;
   @ObfuscatedName("au")
   static class184 field936;

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-116855260"
   )
   static final void method869() {
      MessageNode.method199(false);
      Client.field338 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class104.field1680.length; ++var1) {
         if(Actor.field659[var1] != -1 && class104.field1680[var1] == null) {
            class104.field1680[var1] = Client.field563.method3272(Actor.field659[var1], 0);
            if(class104.field1680[var1] == null) {
               var0 = false;
               ++Client.field338;
            }
         }

         if(class25.field582[var1] != -1 && class7.field59[var1] == null) {
            class7.field59[var1] = Client.field563.method3332(class25.field582[var1], 0, Tile.xteaKeys[var1]);
            if(class7.field59[var1] == null) {
               var0 = false;
               ++Client.field338;
            }
         }
      }

      if(!var0) {
         Client.field342 = 1;
      } else {
         Client.field340 = 0;
         var0 = true;

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
         int var44;
         for(var1 = 0; var1 < class104.field1680.length; ++var1) {
            byte[] var2 = class7.field59[var1];
            if(var2 != null) {
               var44 = (class183.mapRegions[var1] >> 8) * 64 - FrameMap.baseX;
               var4 = (class183.mapRegions[var1] & 255) * 64 - XItemContainer.baseY;
               if(Client.field434) {
                  var44 = 10;
                  var4 = 10;
               }

               boolean var7 = true;
               var8 = new Buffer(var2);
               var9 = -1;

               label1499:
               while(true) {
                  var10 = var8.method2963();
                  if(var10 == 0) {
                     var0 &= var7;
                     break;
                  }

                  var9 += var10;
                  var11 = 0;
                  boolean var12 = false;

                  while(true) {
                     while(!var12) {
                        var13 = var8.method2963();
                        if(var13 == 0) {
                           continue label1499;
                        }

                        var11 += var13 - 1;
                        var14 = var11 & 63;
                        var15 = var11 >> 6 & 63;
                        var16 = var8.readUnsignedByte() >> 2;
                        var17 = var44 + var15;
                        var18 = var14 + var4;
                        if(var17 > 0 && var18 > 0 && var17 < 103 && var18 < 103) {
                           ObjectComposition var46 = Tile.getObjectDefinition(var9);
                           if(var16 != 22 || !Client.field286 || var46.field2899 != 0 || var46.field2923 == 1 || var46.field2918) {
                              if(!var46.method3597()) {
                                 ++Client.field340;
                                 var7 = false;
                              }

                              var12 = true;
                           }
                        }
                     }

                     var13 = var8.method2963();
                     if(var13 == 0) {
                        break;
                     }

                     var8.readUnsignedByte();
                  }
               }
            }
         }

         if(!var0) {
            Client.field342 = 2;
         } else {
            if(Client.field342 != 0) {
               VertexNormal.method1599("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class40.method741();
            Tile.method1512();
            class40.method741();
            class6.region.method1775();
            class40.method741();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].method2229();
            }

            int var47;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var47 = 0; var47 < 104; ++var47) {
                  for(var44 = 0; var44 < 104; ++var44) {
                     class10.tileSettings[var1][var47][var44] = 0;
                  }
               }
            }

            class40.method741();
            class10.field95 = 99;
            class10.underlayIds = new byte[4][104][104];
            class10.overlayIds = new byte[4][104][104];
            class10.overlayPaths = new byte[4][104][104];
            class174.overlayRotations = new byte[4][104][104];
            class221.field3189 = new int[4][105][105];
            class174.field2619 = new byte[4][105][105];
            class191.field2785 = new int[105][105];
            class20.field221 = new int[104];
            class10.field99 = new int[104];
            class191.field2791 = new int[104];
            class39.field796 = new int[104];
            DecorativeObject.field1587 = new int[104];
            var1 = class104.field1680.length;
            class173.method3237();
            MessageNode.method199(true);
            int var5;
            int var6;
            int var19;
            int var20;
            int var21;
            int var60;
            int var62;
            if(!Client.field434) {
               byte[] var49;
               for(var47 = 0; var47 < var1; ++var47) {
                  var44 = 64 * (class183.mapRegions[var47] >> 8) - FrameMap.baseX;
                  var4 = 64 * (class183.mapRegions[var47] & 255) - XItemContainer.baseY;
                  var49 = class104.field1680[var47];
                  if(var49 != null) {
                     class40.method741();
                     var6 = MessageNode.field231 * 8 - 48;
                     var60 = XGrandExchangeOffer.field31 * 8 - 48;
                     CollisionData[] var61 = Client.collisionMaps;

                     for(var9 = 0; var9 < 4; ++var9) {
                        for(var10 = 0; var10 < 64; ++var10) {
                           for(var11 = 0; var11 < 64; ++var11) {
                              if(var10 + var44 > 0 && var10 + var44 < 103 && var11 + var4 > 0 && var4 + var11 < 103) {
                                 var61[var9].flags[var44 + var10][var4 + var11] &= -16777217;
                              }
                           }
                        }
                     }

                     Buffer var50 = new Buffer(var49);

                     for(var10 = 0; var10 < 4; ++var10) {
                        for(var11 = 0; var11 < 64; ++var11) {
                           for(var62 = 0; var62 < 64; ++var62) {
                              FrameMap.method1665(var50, var10, var44 + var11, var4 + var62, var6, var60, 0);
                           }
                        }
                     }
                  }
               }

               for(var47 = 0; var47 < var1; ++var47) {
                  var44 = (class183.mapRegions[var47] >> 8) * 64 - FrameMap.baseX;
                  var4 = (class183.mapRegions[var47] & 255) * 64 - XItemContainer.baseY;
                  var49 = class104.field1680[var47];
                  if(var49 == null && XGrandExchangeOffer.field31 < 800) {
                     class40.method741();
                     class179.method3257(var44, var4, 64, 64);
                  }
               }

               MessageNode.method199(true);

               for(var47 = 0; var47 < var1; ++var47) {
                  byte[] var3 = class7.field59[var47];
                  if(var3 != null) {
                     var4 = 64 * (class183.mapRegions[var47] >> 8) - FrameMap.baseX;
                     var5 = (class183.mapRegions[var47] & 255) * 64 - XItemContainer.baseY;
                     class40.method741();
                     Region var51 = class6.region;
                     CollisionData[] var48 = Client.collisionMaps;
                     var8 = new Buffer(var3);
                     var9 = -1;

                     while(true) {
                        var10 = var8.method2963();
                        if(var10 == 0) {
                           break;
                        }

                        var9 += var10;
                        var11 = 0;

                        while(true) {
                           var62 = var8.method2963();
                           if(var62 == 0) {
                              break;
                           }

                           var11 += var62 - 1;
                           var13 = var11 & 63;
                           var14 = var11 >> 6 & 63;
                           var15 = var11 >> 12;
                           var16 = var8.readUnsignedByte();
                           var17 = var16 >> 2;
                           var18 = var16 & 3;
                           var19 = var4 + var14;
                           var20 = var5 + var13;
                           if(var19 > 0 && var20 > 0 && var19 < 103 && var20 < 103) {
                              var21 = var15;
                              if((class10.tileSettings[1][var19][var20] & 2) == 2) {
                                 var21 = var15 - 1;
                              }

                              CollisionData var22 = null;
                              if(var21 >= 0) {
                                 var22 = var48[var21];
                              }

                              class13.method172(var15, var19, var20, var9, var18, var17, var51, var22);
                           }
                        }
                     }
                  }
               }
            }

            int var45;
            if(Client.field434) {
               for(var47 = 0; var47 < 4; ++var47) {
                  class40.method741();

                  for(var44 = 0; var44 < 13; ++var44) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var59 = false;
                        var6 = Client.field345[var47][var44][var4];
                        if(var6 != -1) {
                           var60 = var6 >> 24 & 3;
                           var45 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = var10 / 8 + (var9 / 8 << 8);

                           for(var62 = 0; var62 < class183.mapRegions.length; ++var62) {
                              if(var11 == class183.mapRegions[var62] && null != class104.field1680[var62]) {
                                 class204.method3813(class104.field1680[var62], var47, 8 * var44, 8 * var4, var60, (var9 & 7) * 8, 8 * (var10 & 7), var45, Client.collisionMaps);
                                 var59 = true;
                                 break;
                              }
                           }
                        }

                        if(!var59) {
                           var60 = var47;
                           var45 = 8 * var44;
                           var9 = 8 * var4;

                           for(var10 = 0; var10 < 8; ++var10) {
                              for(var11 = 0; var11 < 8; ++var11) {
                                 class10.tileHeights[var60][var45 + var10][var11 + var9] = 0;
                              }
                           }

                           if(var45 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class10.tileHeights[var60][var45][var10 + var9] = class10.tileHeights[var60][var45 - 1][var10 + var9];
                              }
                           }

                           if(var9 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class10.tileHeights[var60][var10 + var45][var9] = class10.tileHeights[var60][var45 + var10][var9 - 1];
                              }
                           }

                           if(var45 > 0 && class10.tileHeights[var60][var45 - 1][var9] != 0) {
                              class10.tileHeights[var60][var45][var9] = class10.tileHeights[var60][var45 - 1][var9];
                           } else if(var9 > 0 && class10.tileHeights[var60][var45][var9 - 1] != 0) {
                              class10.tileHeights[var60][var45][var9] = class10.tileHeights[var60][var45][var9 - 1];
                           } else if(var45 > 0 && var9 > 0 && class10.tileHeights[var60][var45 - 1][var9 - 1] != 0) {
                              class10.tileHeights[var60][var45][var9] = class10.tileHeights[var60][var45 - 1][var9 - 1];
                           }
                        }
                     }
                  }
               }

               for(var47 = 0; var47 < 13; ++var47) {
                  for(var44 = 0; var44 < 13; ++var44) {
                     var4 = Client.field345[0][var47][var44];
                     if(var4 == -1) {
                        class179.method3257(8 * var47, 8 * var44, 8, 8);
                     }
                  }
               }

               MessageNode.method199(true);

               for(var47 = 0; var47 < 4; ++var47) {
                  class40.method741();

                  for(var44 = 0; var44 < 13; ++var44) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        var5 = Client.field345[var47][var44][var4];
                        if(var5 != -1) {
                           var6 = var5 >> 24 & 3;
                           var60 = var5 >> 1 & 3;
                           var45 = var5 >> 14 & 1023;
                           var9 = var5 >> 3 & 2047;
                           var10 = var9 / 8 + (var45 / 8 << 8);

                           for(var11 = 0; var11 < class183.mapRegions.length; ++var11) {
                              if(var10 == class183.mapRegions[var11] && null != class7.field59[var11]) {
                                 class116.method2226(class7.field59[var11], var47, var44 * 8, 8 * var4, var6, (var45 & 7) * 8, 8 * (var9 & 7), var60, class6.region, Client.collisionMaps);
                                 break;
                              }
                           }
                        }
                     }
                  }
               }
            }

            MessageNode.method199(true);
            Tile.method1512();
            class40.method741();
            Region var57 = class6.region;
            CollisionData[] var58 = Client.collisionMaps;

            for(var4 = 0; var4 < 4; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  for(var6 = 0; var6 < 104; ++var6) {
                     if((class10.tileSettings[var4][var5][var6] & 1) == 1) {
                        var60 = var4;
                        if((class10.tileSettings[1][var5][var6] & 2) == 2) {
                           var60 = var4 - 1;
                        }

                        if(var60 >= 0) {
                           var58[var60].method2232(var5, var6);
                        }
                     }
                  }
               }
            }

            class10.field93 += (int)(Math.random() * 5.0D) - 2;
            if(class10.field93 < -8) {
               class10.field93 = -8;
            }

            if(class10.field93 > 8) {
               class10.field93 = 8;
            }

            class10.field97 += (int)(Math.random() * 5.0D) - 2;
            if(class10.field97 < -16) {
               class10.field97 = -16;
            }

            if(class10.field97 > 16) {
               class10.field97 = 16;
            }

            for(var4 = 0; var4 < 4; ++var4) {
               byte[][] var67 = class174.field2619[var4];
               var11 = (int)Math.sqrt(5100.0D);
               var62 = 768 * var11 >> 8;

               int var54;
               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     var15 = class10.tileHeights[var4][var14 + 1][var13] - class10.tileHeights[var4][var14 - 1][var13];
                     var16 = class10.tileHeights[var4][var14][var13 + 1] - class10.tileHeights[var4][var14][var13 - 1];
                     var17 = (int)Math.sqrt((double)(var16 * var16 + var15 * var15 + 65536));
                     var18 = (var15 << 8) / var17;
                     var19 = 65536 / var17;
                     var20 = (var16 << 8) / var17;
                     var21 = (var20 * -50 + -50 * var18 + -10 * var19) / var62 + 96;
                     var54 = (var67[var14][var13 + 1] >> 3) + (var67[1 + var14][var13] >> 3) + (var67[var14 - 1][var13] >> 2) + (var67[var14][var13 - 1] >> 2) + (var67[var14][var13] >> 1);
                     class191.field2785[var14][var13] = var21 - var54;
                  }
               }

               for(var13 = 0; var13 < 104; ++var13) {
                  class20.field221[var13] = 0;
                  class10.field99[var13] = 0;
                  class191.field2791[var13] = 0;
                  class39.field796[var13] = 0;
                  DecorativeObject.field1587[var13] = 0;
               }

               for(var13 = -5; var13 < 109; ++var13) {
                  for(var14 = 0; var14 < 104; ++var14) {
                     var15 = 5 + var13;
                     if(var15 >= 0 && var15 < 104) {
                        var16 = class10.underlayIds[var4][var15][var14] & 255;
                        if(var16 > 0) {
                           var18 = var16 - 1;
                           class191 var66 = (class191)class191.field2789.get((long)var18);
                           class191 var53;
                           if(var66 != null) {
                              var53 = var66;
                           } else {
                              byte[] var52 = class191.field2795.method3272(1, var18);
                              var66 = new class191();
                              if(null != var52) {
                                 var66.method3476(new Buffer(var52), var18);
                              }

                              var66.method3462();
                              class191.field2789.put(var66, (long)var18);
                              var53 = var66;
                           }

                           class20.field221[var14] += var53.field2787;
                           class10.field99[var14] += var53.field2788;
                           class191.field2791[var14] += var53.field2784;
                           class39.field796[var14] += var53.field2790;
                           ++DecorativeObject.field1587[var14];
                        }
                     }

                     var16 = var13 - 5;
                     if(var16 >= 0 && var16 < 104) {
                        var17 = class10.underlayIds[var4][var16][var14] & 255;
                        if(var17 > 0) {
                           var19 = var17 - 1;
                           class191 var68 = (class191)class191.field2789.get((long)var19);
                           class191 var55;
                           if(var68 != null) {
                              var55 = var68;
                           } else {
                              byte[] var56 = class191.field2795.method3272(1, var19);
                              var68 = new class191();
                              if(var56 != null) {
                                 var68.method3476(new Buffer(var56), var19);
                              }

                              var68.method3462();
                              class191.field2789.put(var68, (long)var19);
                              var55 = var68;
                           }

                           class20.field221[var14] -= var55.field2787;
                           class10.field99[var14] -= var55.field2788;
                           class191.field2791[var14] -= var55.field2784;
                           class39.field796[var14] -= var55.field2790;
                           --DecorativeObject.field1587[var14];
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
                           var14 += class20.field221[var20];
                           var15 += class10.field99[var20];
                           var16 += class191.field2791[var20];
                           var17 += class39.field796[var20];
                           var18 += DecorativeObject.field1587[var20];
                        }

                        var21 = var19 - 5;
                        if(var21 >= 0 && var21 < 104) {
                           var14 -= class20.field221[var21];
                           var15 -= class10.field99[var21];
                           var16 -= class191.field2791[var21];
                           var17 -= class39.field796[var21];
                           var18 -= DecorativeObject.field1587[var21];
                        }

                        if(var19 >= 1 && var19 < 103 && (!Client.field286 || (class10.tileSettings[0][var13][var19] & 2) != 0 || (class10.tileSettings[var4][var13][var19] & 16) == 0)) {
                           if(var4 < class10.field95) {
                              class10.field95 = var4;
                           }

                           var54 = class10.underlayIds[var4][var13][var19] & 255;
                           int var23 = class10.overlayIds[var4][var13][var19] & 255;
                           if(var54 > 0 || var23 > 0) {
                              int var24 = class10.tileHeights[var4][var13][var19];
                              int var25 = class10.tileHeights[var4][var13 + 1][var19];
                              int var26 = class10.tileHeights[var4][var13 + 1][var19 + 1];
                              int var27 = class10.tileHeights[var4][var13][var19 + 1];
                              int var28 = class191.field2785[var13][var19];
                              int var29 = class191.field2785[var13 + 1][var19];
                              int var30 = class191.field2785[1 + var13][var19 + 1];
                              int var31 = class191.field2785[var13][1 + var19];
                              int var32 = -1;
                              int var33 = -1;
                              int var34;
                              int var35;
                              if(var54 > 0) {
                                 var34 = 256 * var14 / var17;
                                 var35 = var15 / var18;
                                 int var36 = var16 / var18;
                                 var32 = CombatInfo2.method3533(var34, var35, var36);
                                 var34 = class10.field93 + var34 & 255;
                                 var36 += class10.field97;
                                 if(var36 < 0) {
                                    var36 = 0;
                                 } else if(var36 > 255) {
                                    var36 = 255;
                                 }

                                 var33 = CombatInfo2.method3533(var34, var35, var36);
                              }

                              if(var4 > 0) {
                                 boolean var64 = true;
                                 if(var54 == 0 && class10.overlayPaths[var4][var13][var19] != 0) {
                                    var64 = false;
                                 }

                                 if(var23 > 0 && !class112.method2054(var23 - 1).field3025) {
                                    var64 = false;
                                 }

                                 if(var64 && var25 == var24 && var26 == var24 && var24 == var27) {
                                    class221.field3189[var4][var13][var19] |= 2340;
                                 }
                              }

                              var34 = 0;
                              if(var33 != -1) {
                                 var34 = class84.colorPalette[class184.method3384(var33, 96)];
                              }

                              if(var23 == 0) {
                                 var57.method1675(var4, var13, var19, 0, 0, -1, var24, var25, var26, var27, class184.method3384(var32, var28), class184.method3384(var32, var29), class184.method3384(var32, var30), class184.method3384(var32, var31), 0, 0, 0, 0, var34, 0);
                              } else {
                                 var35 = 1 + class10.overlayPaths[var4][var13][var19];
                                 byte var65 = class174.overlayRotations[var4][var13][var19];
                                 Overlay var37 = class112.method2054(var23 - 1);
                                 int var38 = var37.texture;
                                 int var39;
                                 int var40;
                                 int var41;
                                 int var42;
                                 if(var38 >= 0) {
                                    var40 = class84.field1434.vmethod1854(var38);
                                    var39 = -1;
                                 } else if(var37.color == 16711935) {
                                    var39 = -2;
                                    var38 = -1;
                                    var40 = -2;
                                 } else {
                                    var39 = CombatInfo2.method3533(var37.hue, var37.saturation, var37.lightness);
                                    var41 = var37.hue + class10.field93 & 255;
                                    var42 = var37.lightness + class10.field97;
                                    if(var42 < 0) {
                                       var42 = 0;
                                    } else if(var42 > 255) {
                                       var42 = 255;
                                    }

                                    var40 = CombatInfo2.method3533(var41, var37.saturation, var42);
                                 }

                                 var41 = 0;
                                 if(var40 != -2) {
                                    var41 = class84.colorPalette[class112.method2052(var40, 96)];
                                 }

                                 if(var37.field3027 != -1) {
                                    var42 = class10.field93 + var37.field3031 & 255;
                                    int var43 = var37.field3033 + class10.field97;
                                    if(var43 < 0) {
                                       var43 = 0;
                                    } else if(var43 > 255) {
                                       var43 = 255;
                                    }

                                    var40 = CombatInfo2.method3533(var42, var37.field3032, var43);
                                    var41 = class84.colorPalette[class112.method2052(var40, 96)];
                                 }

                                 var57.method1675(var4, var13, var19, var35, var65, var38, var24, var25, var26, var27, class184.method3384(var32, var28), class184.method3384(var32, var29), class184.method3384(var32, var30), class184.method3384(var32, var31), class112.method2052(var39, var28), class112.method2052(var39, var29), class112.method2052(var39, var30), class112.method2052(var39, var31), var34, var41);
                              }
                           }
                        }
                     }
                  }
               }

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     var57.method1726(var4, var14, var13, class22.method203(var4, var14, var13));
                  }
               }

               class10.underlayIds[var4] = null;
               class10.overlayIds[var4] = null;
               class10.overlayPaths[var4] = null;
               class174.overlayRotations[var4] = null;
               class174.field2619[var4] = null;
            }

            var57.method1701(-50, -10, -50);

            for(var4 = 0; var4 < 104; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  if((class10.tileSettings[1][var4][var5] & 2) == 2) {
                     var57.method1747(var4, var5);
                  }
               }
            }

            var4 = 1;
            var5 = 2;
            var6 = 4;

            for(var60 = 0; var60 < 4; ++var60) {
               if(var60 > 0) {
                  var4 <<= 3;
                  var5 <<= 3;
                  var6 <<= 3;
               }

               for(var45 = 0; var45 <= var60; ++var45) {
                  for(var9 = 0; var9 <= 104; ++var9) {
                     for(var10 = 0; var10 <= 104; ++var10) {
                        short var63;
                        if((class221.field3189[var45][var10][var9] & var4) != 0) {
                           var11 = var9;
                           var62 = var9;
                           var13 = var45;

                           for(var14 = var45; var11 > 0 && (class221.field3189[var45][var10][var11 - 1] & var4) != 0; --var11) {
                              ;
                           }

                           while(var62 < 104 && (class221.field3189[var45][var10][var62 + 1] & var4) != 0) {
                              ++var62;
                           }

                           label1035:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var62; ++var15) {
                                 if((class221.field3189[var13 - 1][var10][var15] & var4) == 0) {
                                    break label1035;
                                 }
                              }

                              --var13;
                           }

                           label1024:
                           while(var14 < var60) {
                              for(var15 = var11; var15 <= var62; ++var15) {
                                 if((class221.field3189[var14 + 1][var10][var15] & var4) == 0) {
                                    break label1024;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (1 + var14 - var13) * (1 + (var62 - var11));
                           if(var15 >= 8) {
                              var63 = 240;
                              var17 = class10.tileHeights[var14][var10][var11] - var63;
                              var18 = class10.tileHeights[var13][var10][var11];
                              Region.method1673(var60, 1, var10 * 128, 128 * var10, var11 * 128, var62 * 128 + 128, var17, var18);

                              for(var19 = var13; var19 <= var14; ++var19) {
                                 for(var20 = var11; var20 <= var62; ++var20) {
                                    class221.field3189[var19][var10][var20] &= ~var4;
                                 }
                              }
                           }
                        }

                        if((class221.field3189[var45][var10][var9] & var5) != 0) {
                           var11 = var10;
                           var62 = var10;
                           var13 = var45;

                           for(var14 = var45; var11 > 0 && (class221.field3189[var45][var11 - 1][var9] & var5) != 0; --var11) {
                              ;
                           }

                           while(var62 < 104 && (class221.field3189[var45][1 + var62][var9] & var5) != 0) {
                              ++var62;
                           }

                           label1088:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var62; ++var15) {
                                 if((class221.field3189[var13 - 1][var15][var9] & var5) == 0) {
                                    break label1088;
                                 }
                              }

                              --var13;
                           }

                           label1077:
                           while(var14 < var60) {
                              for(var15 = var11; var15 <= var62; ++var15) {
                                 if((class221.field3189[var14 + 1][var15][var9] & var5) == 0) {
                                    break label1077;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (1 + var14 - var13) * (1 + (var62 - var11));
                           if(var15 >= 8) {
                              var63 = 240;
                              var17 = class10.tileHeights[var14][var11][var9] - var63;
                              var18 = class10.tileHeights[var13][var11][var9];
                              Region.method1673(var60, 2, var11 * 128, var62 * 128 + 128, 128 * var9, 128 * var9, var17, var18);

                              for(var19 = var13; var19 <= var14; ++var19) {
                                 for(var20 = var11; var20 <= var62; ++var20) {
                                    class221.field3189[var19][var20][var9] &= ~var5;
                                 }
                              }
                           }
                        }

                        if((class221.field3189[var45][var10][var9] & var6) != 0) {
                           var11 = var10;
                           var62 = var10;
                           var13 = var9;

                           for(var14 = var9; var13 > 0 && (class221.field3189[var45][var10][var13 - 1] & var6) != 0; --var13) {
                              ;
                           }

                           while(var14 < 104 && (class221.field3189[var45][var10][1 + var14] & var6) != 0) {
                              ++var14;
                           }

                           label1141:
                           while(var11 > 0) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((class221.field3189[var45][var11 - 1][var15] & var6) == 0) {
                                    break label1141;
                                 }
                              }

                              --var11;
                           }

                           label1130:
                           while(var62 < 104) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((class221.field3189[var45][var62 + 1][var15] & var6) == 0) {
                                    break label1130;
                                 }
                              }

                              ++var62;
                           }

                           if((var62 - var11 + 1) * (1 + (var14 - var13)) >= 4) {
                              var15 = class10.tileHeights[var45][var11][var13];
                              Region.method1673(var60, 4, 128 * var11, 128 + 128 * var62, 128 * var13, 128 * var14 + 128, var15, var15);

                              for(var16 = var11; var16 <= var62; ++var16) {
                                 for(var17 = var13; var17 <= var14; ++var17) {
                                    class221.field3189[var45][var16][var17] &= ~var6;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            MessageNode.method199(true);
            var4 = class10.field95;
            if(var4 > class60.plane) {
               var4 = class60.plane;
            }

            if(var4 < class60.plane - 1) {
               var4 = class60.plane - 1;
            }

            if(Client.field286) {
               class6.region.method1813(class10.field95);
            } else {
               class6.region.method1813(0);
            }

            for(var5 = 0; var5 < 104; ++var5) {
               for(var6 = 0; var6 < 104; ++var6) {
                  class44.groundItemSpawned(var5, var6);
               }
            }

            class40.method741();
            class15.method178();
            ObjectComposition.field2929.reset();
            if(null != GameObject.field1615) {
               Client.field326.method3029(116);
               Client.field326.method2763(1057001181);
            }

            if(!Client.field434) {
               var5 = (MessageNode.field231 - 6) / 8;
               var6 = (MessageNode.field231 + 6) / 8;
               var60 = (XGrandExchangeOffer.field31 - 6) / 8;
               var45 = (6 + XGrandExchangeOffer.field31) / 8;

               for(var9 = var5 - 1; var9 <= var6 + 1; ++var9) {
                  for(var10 = var60 - 1; var10 <= 1 + var45; ++var10) {
                     if(var9 < var5 || var9 > var6 || var10 < var60 || var10 > var45) {
                        Client.field563.method3281("m" + var9 + "_" + var10);
                        Client.field563.method3281("l" + var9 + "_" + var10);
                     }
                  }
               }
            }

            Friend.setGameState(30);
            class40.method741();
            class10.underlayIds = null;
            class10.overlayIds = null;
            class10.overlayPaths = null;
            class174.overlayRotations = null;
            class221.field3189 = null;
            class174.field2619 = null;
            class191.field2785 = null;
            class20.field221 = null;
            class10.field99 = null;
            class191.field2791 = null;
            class39.field796 = null;
            DecorativeObject.field1587 = null;
            Client.field326.method3029(49);
            class8.field79.vmethod2003();

            for(var5 = 0; var5 < 32; ++var5) {
               GameEngine.field1772[var5] = 0L;
            }

            for(var5 = 0; var5 < 32; ++var5) {
               GameEngine.field1755[var5] = 0L;
            }

            CombatInfoListHolder.field753 = 0;
         }
      }
   }
}
