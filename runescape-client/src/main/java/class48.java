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

         int var2;
         Buffer var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         int var13;
         for(var1 = 0; var1 < class104.field1680.length; ++var1) {
            byte[] var14 = class7.field59[var1];
            if(var14 != null) {
               var13 = (class183.mapRegions[var1] >> 8) * 64 - FrameMap.baseX;
               var2 = (class183.mapRegions[var1] & 255) * 64 - XItemContainer.baseY;
               if(Client.field434) {
                  var13 = 10;
                  var2 = 10;
               }

               boolean var15 = true;
               var3 = new Buffer(var14);
               var4 = -1;

               label1140:
               while(true) {
                  var5 = var3.method2963();
                  if(var5 == 0) {
                     var0 &= var15;
                     break;
                  }

                  var4 += var5;
                  var6 = 0;
                  boolean var16 = false;

                  while(true) {
                     ObjectComposition var17;
                     do {
                        do {
                           do {
                              do {
                                 do {
                                    while(var16) {
                                       var7 = var3.method2963();
                                       if(var7 == 0) {
                                          continue label1140;
                                       }

                                       var3.readUnsignedByte();
                                    }

                                    var7 = var3.method2963();
                                    if(var7 == 0) {
                                       continue label1140;
                                    }

                                    var6 += var7 - 1;
                                    var8 = var6 & 63;
                                    var9 = var6 >> 6 & 63;
                                    var10 = var3.readUnsignedByte() >> 2;
                                    var11 = var13 + var9;
                                    var12 = var8 + var2;
                                 } while(var11 <= 0);
                              } while(var12 <= 0);
                           } while(var11 >= 103);
                        } while(var12 >= 103);

                        var17 = Tile.getObjectDefinition(var4);
                     } while(var10 == 22 && Client.field286 && var17.field2899 == 0 && var17.field2923 != 1 && !var17.field2918);

                     if(!var17.method3597()) {
                        ++Client.field340;
                        var15 = false;
                     }

                     var16 = true;
                  }
               }
            }
         }

         if(!var0) {
            Client.field342 = 2;
         } else {
            if(Client.field342 != 0) {
               VertexNormal.method1599("Loading - please wait.<br> (100%)", true);
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

            int var48;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var48 = 0; var48 < 104; ++var48) {
                  for(var13 = 0; var13 < 104; ++var13) {
                     class10.tileSettings[var1][var48][var13] = 0;
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
            int var18;
            int var19;
            int var20;
            int var21;
            int var49;
            int var50;
            int var51;
            if(!Client.field434) {
               var48 = 0;

               label1064:
               while(true) {
                  byte[] var22;
                  if(var48 >= var1) {
                     for(var48 = 0; var48 < var1; ++var48) {
                        var13 = (class183.mapRegions[var48] >> 8) * 64 - FrameMap.baseX;
                        var2 = (class183.mapRegions[var48] & 255) * 64 - XItemContainer.baseY;
                        var22 = class104.field1680[var48];
                        if(var22 == null && XGrandExchangeOffer.field31 < 800) {
                           class40.method741();
                           class179.method3257(var13, var2, 64, 64);
                        }
                     }

                     MessageNode.method199(true);
                     var48 = 0;

                     while(true) {
                        if(var48 >= var1) {
                           break label1064;
                        }

                        byte[] var53 = class7.field59[var48];
                        if(var53 != null) {
                           var2 = 64 * (class183.mapRegions[var48] >> 8) - FrameMap.baseX;
                           var49 = (class183.mapRegions[var48] & 255) * 64 - XItemContainer.baseY;
                           class40.method741();
                           Region var55 = class6.region;
                           CollisionData[] var25 = Client.collisionMaps;
                           var3 = new Buffer(var53);
                           var4 = -1;

                           while(true) {
                              var5 = var3.method2963();
                              if(var5 == 0) {
                                 break;
                              }

                              var4 += var5;
                              var6 = 0;

                              while(true) {
                                 var21 = var3.method2963();
                                 if(var21 == 0) {
                                    break;
                                 }

                                 var6 += var21 - 1;
                                 var7 = var6 & 63;
                                 var8 = var6 >> 6 & 63;
                                 var9 = var6 >> 12;
                                 var10 = var3.readUnsignedByte();
                                 var11 = var10 >> 2;
                                 var12 = var10 & 3;
                                 var51 = var2 + var8;
                                 var18 = var49 + var7;
                                 if(var51 > 0 && var18 > 0 && var51 < 103 && var18 < 103) {
                                    var19 = var9;
                                    if((class10.tileSettings[1][var51][var18] & 2) == 2) {
                                       var19 = var9 - 1;
                                    }

                                    CollisionData var26 = null;
                                    if(var19 >= 0) {
                                       var26 = var25[var19];
                                    }

                                    class13.method172(var9, var51, var18, var4, var12, var11, var55, var26);
                                 }
                              }
                           }
                        }

                        ++var48;
                     }
                  }

                  var13 = 64 * (class183.mapRegions[var48] >> 8) - FrameMap.baseX;
                  var2 = 64 * (class183.mapRegions[var48] & 255) - XItemContainer.baseY;
                  var22 = class104.field1680[var48];
                  if(var22 != null) {
                     class40.method741();
                     var50 = MessageNode.field231 * 8 - 48;
                     var20 = XGrandExchangeOffer.field31 * 8 - 48;
                     CollisionData[] var23 = Client.collisionMaps;
                     var4 = 0;

                     label1061:
                     while(true) {
                        if(var4 >= 4) {
                           Buffer var24 = new Buffer(var22);
                           var5 = 0;

                           while(true) {
                              if(var5 >= 4) {
                                 break label1061;
                              }

                              for(var6 = 0; var6 < 64; ++var6) {
                                 for(var21 = 0; var21 < 64; ++var21) {
                                    FrameMap.method1665(var24, var5, var13 + var6, var2 + var21, var50, var20, 0);
                                 }
                              }

                              ++var5;
                           }
                        }

                        for(var5 = 0; var5 < 64; ++var5) {
                           for(var6 = 0; var6 < 64; ++var6) {
                              if(var5 + var13 > 0 && var5 + var13 < 103 && var6 + var2 > 0 && var2 + var6 < 103) {
                                 var23[var4].flags[var13 + var5][var2 + var6] &= -16777217;
                              }
                           }
                        }

                        ++var4;
                     }
                  }

                  ++var48;
               }
            }

            int var52;
            if(Client.field434) {
               var48 = 0;

               label997:
               while(true) {
                  if(var48 >= 4) {
                     for(var48 = 0; var48 < 13; ++var48) {
                        for(var13 = 0; var13 < 13; ++var13) {
                           var2 = Client.field345[0][var48][var13];
                           if(var2 == -1) {
                              class179.method3257(8 * var48, 8 * var13, 8, 8);
                           }
                        }
                     }

                     MessageNode.method199(true);
                     var48 = 0;

                     while(true) {
                        if(var48 >= 4) {
                           break label997;
                        }

                        class40.method741();

                        for(var13 = 0; var13 < 13; ++var13) {
                           for(var2 = 0; var2 < 13; ++var2) {
                              var49 = Client.field345[var48][var13][var2];
                              if(var49 != -1) {
                                 var50 = var49 >> 24 & 3;
                                 var20 = var49 >> 1 & 3;
                                 var52 = var49 >> 14 & 1023;
                                 var4 = var49 >> 3 & 2047;
                                 var5 = var4 / 8 + (var52 / 8 << 8);

                                 for(var6 = 0; var6 < class183.mapRegions.length; ++var6) {
                                    if(var5 == class183.mapRegions[var6] && null != class7.field59[var6]) {
                                       class116.method2226(class7.field59[var6], var48, var13 * 8, 8 * var2, var50, (var52 & 7) * 8, 8 * (var4 & 7), var20, class6.region, Client.collisionMaps);
                                       break;
                                    }
                                 }
                              }
                           }
                        }

                        ++var48;
                     }
                  }

                  class40.method741();

                  for(var13 = 0; var13 < 13; ++var13) {
                     for(var2 = 0; var2 < 13; ++var2) {
                        boolean var54 = false;
                        var50 = Client.field345[var48][var13][var2];
                        if(var50 != -1) {
                           var20 = var50 >> 24 & 3;
                           var52 = var50 >> 1 & 3;
                           var4 = var50 >> 14 & 1023;
                           var5 = var50 >> 3 & 2047;
                           var6 = var5 / 8 + (var4 / 8 << 8);

                           for(var21 = 0; var21 < class183.mapRegions.length; ++var21) {
                              if(var6 == class183.mapRegions[var21] && null != class104.field1680[var21]) {
                                 class204.method3813(class104.field1680[var21], var48, 8 * var13, 8 * var2, var20, (var4 & 7) * 8, 8 * (var5 & 7), var52, Client.collisionMaps);
                                 var54 = true;
                                 break;
                              }
                           }
                        }

                        if(!var54) {
                           var20 = var48;
                           var52 = 8 * var13;
                           var4 = 8 * var2;

                           for(var5 = 0; var5 < 8; ++var5) {
                              for(var6 = 0; var6 < 8; ++var6) {
                                 class10.tileHeights[var20][var52 + var5][var6 + var4] = 0;
                              }
                           }

                           if(var52 > 0) {
                              for(var5 = 1; var5 < 8; ++var5) {
                                 class10.tileHeights[var20][var52][var5 + var4] = class10.tileHeights[var20][var52 - 1][var5 + var4];
                              }
                           }

                           if(var4 > 0) {
                              for(var5 = 1; var5 < 8; ++var5) {
                                 class10.tileHeights[var20][var5 + var52][var4] = class10.tileHeights[var20][var52 + var5][var4 - 1];
                              }
                           }

                           if(var52 > 0 && class10.tileHeights[var20][var52 - 1][var4] != 0) {
                              class10.tileHeights[var20][var52][var4] = class10.tileHeights[var20][var52 - 1][var4];
                           } else if(var4 > 0 && class10.tileHeights[var20][var52][var4 - 1] != 0) {
                              class10.tileHeights[var20][var52][var4] = class10.tileHeights[var20][var52][var4 - 1];
                           } else if(var52 > 0 && var4 > 0 && class10.tileHeights[var20][var52 - 1][var4 - 1] != 0) {
                              class10.tileHeights[var20][var52][var4] = class10.tileHeights[var20][var52 - 1][var4 - 1];
                           }
                        }
                     }
                  }

                  ++var48;
               }
            }

            MessageNode.method199(true);
            Tile.method1512();
            class40.method741();
            Region var56 = class6.region;
            CollisionData[] var57 = Client.collisionMaps;

            for(var2 = 0; var2 < 4; ++var2) {
               for(var49 = 0; var49 < 104; ++var49) {
                  for(var50 = 0; var50 < 104; ++var50) {
                     if((class10.tileSettings[var2][var49][var50] & 1) == 1) {
                        var20 = var2;
                        if((class10.tileSettings[1][var49][var50] & 2) == 2) {
                           var20 = var2 - 1;
                        }

                        if(var20 >= 0) {
                           var57[var20].method2232(var49, var50);
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

            for(var2 = 0; var2 < 4; ++var2) {
               byte[][] var58 = class174.field2619[var2];
               var6 = (int)Math.sqrt(5100.0D);
               var21 = 768 * var6 >> 8;

               int var60;
               for(var7 = 1; var7 < 103; ++var7) {
                  for(var8 = 1; var8 < 103; ++var8) {
                     var9 = class10.tileHeights[var2][var8 + 1][var7] - class10.tileHeights[var2][var8 - 1][var7];
                     var10 = class10.tileHeights[var2][var8][var7 + 1] - class10.tileHeights[var2][var8][var7 - 1];
                     var11 = (int)Math.sqrt((double)(var10 * var10 + var9 * var9 + 65536));
                     var12 = (var9 << 8) / var11;
                     var51 = 65536 / var11;
                     var18 = (var10 << 8) / var11;
                     var19 = (var18 * -50 + -50 * var12 + -10 * var51) / var21 + 96;
                     var60 = (var58[var8][var7 + 1] >> 3) + (var58[1 + var8][var7] >> 3) + (var58[var8 - 1][var7] >> 2) + (var58[var8][var7 - 1] >> 2) + (var58[var8][var7] >> 1);
                     class191.field2785[var8][var7] = var19 - var60;
                  }
               }

               for(var7 = 0; var7 < 104; ++var7) {
                  class20.field221[var7] = 0;
                  class10.field99[var7] = 0;
                  class191.field2791[var7] = 0;
                  class39.field796[var7] = 0;
                  DecorativeObject.field1587[var7] = 0;
               }

               for(var7 = -5; var7 < 109; ++var7) {
                  for(var8 = 0; var8 < 104; ++var8) {
                     var9 = 5 + var7;
                     class191 var27;
                     class191 var28;
                     byte[] var29;
                     if(var9 >= 0 && var9 < 104) {
                        var10 = class10.underlayIds[var2][var9][var8] & 255;
                        if(var10 > 0) {
                           var12 = var10 - 1;
                           var27 = (class191)class191.field2789.get((long)var12);
                           if(var27 != null) {
                              var28 = var27;
                           } else {
                              var29 = class191.field2795.method3272(1, var12);
                              var27 = new class191();
                              if(null != var29) {
                                 var27.method3476(new Buffer(var29), var12);
                              }

                              var27.method3462();
                              class191.field2789.put(var27, (long)var12);
                              var28 = var27;
                           }

                           class20.field221[var8] += var28.field2787;
                           class10.field99[var8] += var28.field2788;
                           class191.field2791[var8] += var28.field2784;
                           class39.field796[var8] += var28.field2790;
                           ++DecorativeObject.field1587[var8];
                        }
                     }

                     var10 = var7 - 5;
                     if(var10 >= 0 && var10 < 104) {
                        var11 = class10.underlayIds[var2][var10][var8] & 255;
                        if(var11 > 0) {
                           var51 = var11 - 1;
                           var27 = (class191)class191.field2789.get((long)var51);
                           if(var27 != null) {
                              var28 = var27;
                           } else {
                              var29 = class191.field2795.method3272(1, var51);
                              var27 = new class191();
                              if(var29 != null) {
                                 var27.method3476(new Buffer(var29), var51);
                              }

                              var27.method3462();
                              class191.field2789.put(var27, (long)var51);
                              var28 = var27;
                           }

                           class20.field221[var8] -= var28.field2787;
                           class10.field99[var8] -= var28.field2788;
                           class191.field2791[var8] -= var28.field2784;
                           class39.field796[var8] -= var28.field2790;
                           --DecorativeObject.field1587[var8];
                        }
                     }
                  }

                  if(var7 >= 1 && var7 < 103) {
                     var8 = 0;
                     var9 = 0;
                     var10 = 0;
                     var11 = 0;
                     var12 = 0;

                     for(var51 = -5; var51 < 109; ++var51) {
                        var18 = 5 + var51;
                        if(var18 >= 0 && var18 < 104) {
                           var8 += class20.field221[var18];
                           var9 += class10.field99[var18];
                           var10 += class191.field2791[var18];
                           var11 += class39.field796[var18];
                           var12 += DecorativeObject.field1587[var18];
                        }

                        var19 = var51 - 5;
                        if(var19 >= 0 && var19 < 104) {
                           var8 -= class20.field221[var19];
                           var9 -= class10.field99[var19];
                           var10 -= class191.field2791[var19];
                           var11 -= class39.field796[var19];
                           var12 -= DecorativeObject.field1587[var19];
                        }

                        if(var51 >= 1 && var51 < 103 && (!Client.field286 || (class10.tileSettings[0][var7][var51] & 2) != 0 || (class10.tileSettings[var2][var7][var51] & 16) == 0)) {
                           if(var2 < class10.field95) {
                              class10.field95 = var2;
                           }

                           var60 = class10.underlayIds[var2][var7][var51] & 255;
                           int var61 = class10.overlayIds[var2][var7][var51] & 255;
                           if(var60 > 0 || var61 > 0) {
                              int var63 = class10.tileHeights[var2][var7][var51];
                              int var62 = class10.tileHeights[var2][var7 + 1][var51];
                              int var30 = class10.tileHeights[var2][var7 + 1][var51 + 1];
                              int var31 = class10.tileHeights[var2][var7][var51 + 1];
                              int var32 = class191.field2785[var7][var51];
                              int var33 = class191.field2785[var7 + 1][var51];
                              int var34 = class191.field2785[1 + var7][var51 + 1];
                              int var35 = class191.field2785[var7][1 + var51];
                              int var36 = -1;
                              int var37 = -1;
                              int var38;
                              int var39;
                              if(var60 > 0) {
                                 var38 = 256 * var8 / var11;
                                 var39 = var9 / var12;
                                 int var40 = var10 / var12;
                                 var36 = CombatInfo2.method3533(var38, var39, var40);
                                 var38 = class10.field93 + var38 & 255;
                                 var40 += class10.field97;
                                 if(var40 < 0) {
                                    var40 = 0;
                                 } else if(var40 > 255) {
                                    var40 = 255;
                                 }

                                 var37 = CombatInfo2.method3533(var38, var39, var40);
                              }

                              if(var2 > 0) {
                                 boolean var64 = true;
                                 if(var60 == 0 && class10.overlayPaths[var2][var7][var51] != 0) {
                                    var64 = false;
                                 }

                                 if(var61 > 0 && !class112.method2054(var61 - 1).field3025) {
                                    var64 = false;
                                 }

                                 if(var64 && var62 == var63 && var30 == var63 && var63 == var31) {
                                    class221.field3189[var2][var7][var51] |= 2340;
                                 }
                              }

                              var38 = 0;
                              if(var37 != -1) {
                                 var38 = class84.colorPalette[class184.method3384(var37, 96)];
                              }

                              if(var61 == 0) {
                                 var56.method1675(var2, var7, var51, 0, 0, -1, var63, var62, var30, var31, class184.method3384(var36, var32), class184.method3384(var36, var33), class184.method3384(var36, var34), class184.method3384(var36, var35), 0, 0, 0, 0, var38, 0);
                              } else {
                                 var39 = 1 + class10.overlayPaths[var2][var7][var51];
                                 byte var65 = class174.overlayRotations[var2][var7][var51];
                                 Overlay var41 = class112.method2054(var61 - 1);
                                 int var42 = var41.texture;
                                 int var43;
                                 int var44;
                                 int var45;
                                 int var46;
                                 if(var42 >= 0) {
                                    var44 = class84.field1434.vmethod1854(var42);
                                    var43 = -1;
                                 } else if(var41.color == 16711935) {
                                    var43 = -2;
                                    var42 = -1;
                                    var44 = -2;
                                 } else {
                                    var43 = CombatInfo2.method3533(var41.hue, var41.saturation, var41.lightness);
                                    var45 = var41.hue + class10.field93 & 255;
                                    var46 = var41.lightness + class10.field97;
                                    if(var46 < 0) {
                                       var46 = 0;
                                    } else if(var46 > 255) {
                                       var46 = 255;
                                    }

                                    var44 = CombatInfo2.method3533(var45, var41.saturation, var46);
                                 }

                                 var45 = 0;
                                 if(var44 != -2) {
                                    var45 = class84.colorPalette[class112.method2052(var44, 96)];
                                 }

                                 if(var41.field3027 != -1) {
                                    var46 = class10.field93 + var41.field3031 & 255;
                                    int var47 = var41.field3033 + class10.field97;
                                    if(var47 < 0) {
                                       var47 = 0;
                                    } else if(var47 > 255) {
                                       var47 = 255;
                                    }

                                    var44 = CombatInfo2.method3533(var46, var41.field3032, var47);
                                    var45 = class84.colorPalette[class112.method2052(var44, 96)];
                                 }

                                 var56.method1675(var2, var7, var51, var39, var65, var42, var63, var62, var30, var31, class184.method3384(var36, var32), class184.method3384(var36, var33), class184.method3384(var36, var34), class184.method3384(var36, var35), class112.method2052(var43, var32), class112.method2052(var43, var33), class112.method2052(var43, var34), class112.method2052(var43, var35), var38, var45);
                              }
                           }
                        }
                     }
                  }
               }

               for(var7 = 1; var7 < 103; ++var7) {
                  for(var8 = 1; var8 < 103; ++var8) {
                     var56.method1726(var2, var8, var7, class22.method203(var2, var8, var7));
                  }
               }

               class10.underlayIds[var2] = (byte[][])null;
               class10.overlayIds[var2] = (byte[][])null;
               class10.overlayPaths[var2] = (byte[][])null;
               class174.overlayRotations[var2] = (byte[][])null;
               class174.field2619[var2] = (byte[][])null;
            }

            var56.method1701(-50, -10, -50);

            for(var2 = 0; var2 < 104; ++var2) {
               for(var49 = 0; var49 < 104; ++var49) {
                  if((class10.tileSettings[1][var2][var49] & 2) == 2) {
                     var56.method1747(var2, var49);
                  }
               }
            }

            var2 = 1;
            var49 = 2;
            var50 = 4;

            for(var20 = 0; var20 < 4; ++var20) {
               if(var20 > 0) {
                  var2 <<= 3;
                  var49 <<= 3;
                  var50 <<= 3;
               }

               for(var52 = 0; var52 <= var20; ++var52) {
                  for(var4 = 0; var4 <= 104; ++var4) {
                     for(var5 = 0; var5 <= 104; ++var5) {
                        short var59;
                        if((class221.field3189[var52][var5][var4] & var2) != 0) {
                           var6 = var4;
                           var21 = var4;
                           var7 = var52;

                           for(var8 = var52; var6 > 0 && (class221.field3189[var52][var5][var6 - 1] & var2) != 0; --var6) {
                              ;
                           }

                           while(var21 < 104 && (class221.field3189[var52][var5][var21 + 1] & var2) != 0) {
                              ++var21;
                           }

                           label655:
                           while(var7 > 0) {
                              for(var9 = var6; var9 <= var21; ++var9) {
                                 if((class221.field3189[var7 - 1][var5][var9] & var2) == 0) {
                                    break label655;
                                 }
                              }

                              --var7;
                           }

                           label644:
                           while(var8 < var20) {
                              for(var9 = var6; var9 <= var21; ++var9) {
                                 if((class221.field3189[var8 + 1][var5][var9] & var2) == 0) {
                                    break label644;
                                 }
                              }

                              ++var8;
                           }

                           var9 = (1 + var8 - var7) * (1 + (var21 - var6));
                           if(var9 >= 8) {
                              var59 = 240;
                              var11 = class10.tileHeights[var8][var5][var6] - var59;
                              var12 = class10.tileHeights[var7][var5][var6];
                              Region.method1673(var20, 1, var5 * 128, 128 * var5, var6 * 128, var21 * 128 + 128, var11, var12);

                              for(var51 = var7; var51 <= var8; ++var51) {
                                 for(var18 = var6; var18 <= var21; ++var18) {
                                    class221.field3189[var51][var5][var18] &= ~var2;
                                 }
                              }
                           }
                        }

                        if((class221.field3189[var52][var5][var4] & var49) != 0) {
                           var6 = var5;
                           var21 = var5;
                           var7 = var52;

                           for(var8 = var52; var6 > 0 && (class221.field3189[var52][var6 - 1][var4] & var49) != 0; --var6) {
                              ;
                           }

                           while(var21 < 104 && (class221.field3189[var52][1 + var21][var4] & var49) != 0) {
                              ++var21;
                           }

                           label708:
                           while(var7 > 0) {
                              for(var9 = var6; var9 <= var21; ++var9) {
                                 if((class221.field3189[var7 - 1][var9][var4] & var49) == 0) {
                                    break label708;
                                 }
                              }

                              --var7;
                           }

                           label697:
                           while(var8 < var20) {
                              for(var9 = var6; var9 <= var21; ++var9) {
                                 if((class221.field3189[var8 + 1][var9][var4] & var49) == 0) {
                                    break label697;
                                 }
                              }

                              ++var8;
                           }

                           var9 = (1 + var8 - var7) * (1 + (var21 - var6));
                           if(var9 >= 8) {
                              var59 = 240;
                              var11 = class10.tileHeights[var8][var6][var4] - var59;
                              var12 = class10.tileHeights[var7][var6][var4];
                              Region.method1673(var20, 2, var6 * 128, var21 * 128 + 128, 128 * var4, 128 * var4, var11, var12);

                              for(var51 = var7; var51 <= var8; ++var51) {
                                 for(var18 = var6; var18 <= var21; ++var18) {
                                    class221.field3189[var51][var18][var4] &= ~var49;
                                 }
                              }
                           }
                        }

                        if((class221.field3189[var52][var5][var4] & var50) != 0) {
                           var6 = var5;
                           var21 = var5;
                           var7 = var4;

                           for(var8 = var4; var7 > 0 && (class221.field3189[var52][var5][var7 - 1] & var50) != 0; --var7) {
                              ;
                           }

                           while(var8 < 104 && (class221.field3189[var52][var5][1 + var8] & var50) != 0) {
                              ++var8;
                           }

                           label761:
                           while(var6 > 0) {
                              for(var9 = var7; var9 <= var8; ++var9) {
                                 if((class221.field3189[var52][var6 - 1][var9] & var50) == 0) {
                                    break label761;
                                 }
                              }

                              --var6;
                           }

                           label750:
                           while(var21 < 104) {
                              for(var9 = var7; var9 <= var8; ++var9) {
                                 if((class221.field3189[var52][var21 + 1][var9] & var50) == 0) {
                                    break label750;
                                 }
                              }

                              ++var21;
                           }

                           if((var21 - var6 + 1) * (1 + (var8 - var7)) >= 4) {
                              var9 = class10.tileHeights[var52][var6][var7];
                              Region.method1673(var20, 4, 128 * var6, 128 + 128 * var21, 128 * var7, 128 * var8 + 128, var9, var9);

                              for(var10 = var6; var10 <= var21; ++var10) {
                                 for(var11 = var7; var11 <= var8; ++var11) {
                                    class221.field3189[var52][var10][var11] &= ~var50;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            MessageNode.method199(true);
            var2 = class10.field95;
            if(var2 > class60.plane) {
               var2 = class60.plane;
            }

            if(var2 < class60.plane - 1) {
               var2 = class60.plane - 1;
            }

            if(Client.field286) {
               class6.region.method1813(class10.field95);
            } else {
               class6.region.method1813(0);
            }

            for(var49 = 0; var49 < 104; ++var49) {
               for(var50 = 0; var50 < 104; ++var50) {
                  class44.groundItemSpawned(var49, var50);
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
               var49 = (MessageNode.field231 - 6) / 8;
               var50 = (MessageNode.field231 + 6) / 8;
               var20 = (XGrandExchangeOffer.field31 - 6) / 8;
               var52 = (6 + XGrandExchangeOffer.field31) / 8;

               for(var4 = var49 - 1; var4 <= var50 + 1; ++var4) {
                  for(var5 = var20 - 1; var5 <= 1 + var52; ++var5) {
                     if(var4 < var49 || var4 > var50 || var5 < var20 || var5 > var52) {
                        Client.field563.method3281("m" + var4 + "_" + var5);
                        Client.field563.method3281("l" + var4 + "_" + var5);
                     }
                  }
               }
            }

            Friend.setGameState(30);
            class40.method741();
            class10.underlayIds = (byte[][][])null;
            class10.overlayIds = (byte[][][])null;
            class10.overlayPaths = (byte[][][])null;
            class174.overlayRotations = (byte[][][])null;
            class221.field3189 = (int[][][])null;
            class174.field2619 = (byte[][][])null;
            class191.field2785 = (int[][])null;
            class20.field221 = null;
            class10.field99 = null;
            class191.field2791 = null;
            class39.field796 = null;
            DecorativeObject.field1587 = null;
            Client.field326.method3029(49);
            class8.field79.vmethod2003();

            for(var49 = 0; var49 < 32; ++var49) {
               GameEngine.field1772[var49] = 0L;
            }

            for(var49 = 0; var49 < 32; ++var49) {
               GameEngine.field1755[var49] = 0L;
            }

            CombatInfoListHolder.field753 = 0;
         }
      }

   }
}
