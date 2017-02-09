import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
public final class class85 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -520777083
   )
   int field1453;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 64590473
   )
   int field1454;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 855415361
   )
   int field1455;
   @ObfuscatedName("pb")
   static class30 field1456;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -422401403
   )
   int field1457;
   @ObfuscatedName("j")
   boolean field1458 = true;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1446772145
   )
   int field1459;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1051759079
   )
   int field1460;
   @ObfuscatedName("mg")
   @Export("clanMembers")
   static XClanMember[] clanMembers;

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class85(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1455 = var1;
      this.field1460 = var2;
      this.field1453 = var3;
      this.field1454 = var4;
      this.field1457 = var5;
      this.field1459 = var6;
      this.field1458 = var7;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1934794077"
   )
   static final void method1701() {
      class153.method2861(false);
      Client.field279 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class162.field2283.length; ++var1) {
         if(class9.field85[var1] != -1 && class162.field2283[var1] == null) {
            class162.field2283[var1] = class37.field786.getConfigData(class9.field85[var1], 0);
            if(class162.field2283[var1] == null) {
               var0 = false;
               ++Client.field279;
            }
         }

         if(VertexNormal.field1423[var1] != -1 && null == ItemLayer.field1220[var1]) {
            ItemLayer.field1220[var1] = class37.field786.getConfigData(VertexNormal.field1423[var1], 0, class88.xteaKeys[var1]);
            if(ItemLayer.field1220[var1] == null) {
               var0 = false;
               ++Client.field279;
            }
         }
      }

      if(!var0) {
         Client.field337 = 1;
      } else {
         Client.field335 = 0;
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
         Buffer var51;
         for(var1 = 0; var1 < class162.field2283.length; ++var1) {
            byte[] var50 = ItemLayer.field1220[var1];
            if(var50 != null) {
               var3 = (class20.mapRegions[var1] >> 8) * 64 - class114.baseX;
               var4 = 64 * (class20.mapRegions[var1] & 255) - CombatInfo1.baseY;
               if(Client.isDynamicRegion) {
                  var3 = 10;
                  var4 = 10;
               }

               boolean var7 = true;
               var51 = new Buffer(var50);
               var9 = -1;

               label929:
               while(true) {
                  var10 = var51.method2939();
                  if(var10 == 0) {
                     var0 &= var7;
                     break;
                  }

                  var9 += var10;
                  var11 = 0;
                  boolean var12 = false;

                  while(true) {
                     while(!var12) {
                        var13 = var51.method2939();
                        if(var13 == 0) {
                           continue label929;
                        }

                        var11 += var13 - 1;
                        var14 = var11 & 63;
                        var15 = var11 >> 6 & 63;
                        var16 = var51.readUnsignedByte() >> 2;
                        var17 = var3 + var15;
                        var18 = var14 + var4;
                        if(var17 > 0 && var18 > 0 && var17 < 103 && var18 < 103) {
                           ObjectComposition var49 = class156.getObjectDefinition(var9);
                           if(var16 != 22 || !Client.field278 || var49.field2910 != 0 || var49.field2901 == 1 || var49.field2912) {
                              if(!var49.method3602()) {
                                 ++Client.field335;
                                 var7 = false;
                              }

                              var12 = true;
                           }
                        }
                     }

                     var13 = var51.method2939();
                     if(var13 == 0) {
                        break;
                     }

                     var51.readUnsignedByte();
                  }
               }
            }
         }

         if(!var0) {
            Client.field337 = 2;
         } else {
            if(Client.field337 != 0) {
               class101.method1940("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class3.method33();
            class45.method827();
            class3.method33();
            class65.region.method1707();
            class3.method33();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].method2240();
            }

            int var2;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var2 = 0; var2 < 104; ++var2) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class11.tileSettings[var1][var2][var3] = 0;
                  }
               }
            }

            class3.method33();
            class11.field115 = 99;
            class11.underlayIds = new byte[4][104][104];
            class11.overlayIds = new byte[4][104][104];
            class189.overlayPaths = new byte[4][104][104];
            class11.overlayRotations = new byte[4][104][104];
            class7.field55 = new int[4][105][105];
            class39.field798 = new byte[4][105][105];
            class215.field3153 = new int[105][105];
            class48.field933 = new int[104];
            class11.field100 = new int[104];
            Ignore.field206 = new int[104];
            class7.field62 = new int[104];
            class47.field929 = new int[104];
            var1 = class162.field2283.length;

            for(class31 var66 = (class31)class31.field693.method2403(); null != var66; var66 = (class31)class31.field693.method2398()) {
               if(null != var66.field700) {
                  class164.field2290.method919(var66.field700);
                  var66.field700 = null;
               }

               if(var66.field705 != null) {
                  class164.field2290.method919(var66.field705);
                  var66.field705 = null;
               }
            }

            class31.field693.method2379();
            class153.method2861(true);
            int var5;
            int var6;
            int var19;
            int var20;
            int var21;
            int var63;
            int var64;
            if(!Client.isDynamicRegion) {
               byte[] var53;
               for(var2 = 0; var2 < var1; ++var2) {
                  var3 = 64 * (class20.mapRegions[var2] >> 8) - class114.baseX;
                  var4 = 64 * (class20.mapRegions[var2] & 255) - CombatInfo1.baseY;
                  var53 = class162.field2283[var2];
                  if(var53 != null) {
                     class3.method33();
                     var6 = Actor.field650 * 8 - 48;
                     var63 = class2.field25 * 8 - 48;
                     CollisionData[] var67 = Client.collisionMaps;

                     for(var9 = 0; var9 < 4; ++var9) {
                        for(var10 = 0; var10 < 64; ++var10) {
                           for(var11 = 0; var11 < 64; ++var11) {
                              if(var10 + var3 > 0 && var3 + var10 < 103 && var11 + var4 > 0 && var4 + var11 < 103) {
                                 var67[var9].flags[var10 + var3][var11 + var4] &= -16777217;
                              }
                           }
                        }
                     }

                     Buffer var57 = new Buffer(var53);

                     for(var10 = 0; var10 < 4; ++var10) {
                        for(var11 = 0; var11 < 64; ++var11) {
                           for(var64 = 0; var64 < 64; ++var64) {
                              class18.method202(var57, var10, var3 + var11, var4 + var64, var6, var63, 0);
                           }
                        }
                     }
                  }
               }

               for(var2 = 0; var2 < var1; ++var2) {
                  var3 = 64 * (class20.mapRegions[var2] >> 8) - class114.baseX;
                  var4 = 64 * (class20.mapRegions[var2] & 255) - CombatInfo1.baseY;
                  var53 = class162.field2283[var2];
                  if(var53 == null && class2.field25 < 800) {
                     class3.method33();
                     class166.method3171(var3, var4, 64, 64);
                  }
               }

               class153.method2861(true);

               for(var2 = 0; var2 < var1; ++var2) {
                  byte[] var58 = ItemLayer.field1220[var2];
                  if(null != var58) {
                     var4 = 64 * (class20.mapRegions[var2] >> 8) - class114.baseX;
                     var5 = (class20.mapRegions[var2] & 255) * 64 - CombatInfo1.baseY;
                     class3.method33();
                     Region var59 = class65.region;
                     CollisionData[] var54 = Client.collisionMaps;
                     var51 = new Buffer(var58);
                     var9 = -1;

                     while(true) {
                        var10 = var51.method2939();
                        if(var10 == 0) {
                           break;
                        }

                        var9 += var10;
                        var11 = 0;

                        while(true) {
                           var64 = var51.method2939();
                           if(var64 == 0) {
                              break;
                           }

                           var11 += var64 - 1;
                           var13 = var11 & 63;
                           var14 = var11 >> 6 & 63;
                           var15 = var11 >> 12;
                           var16 = var51.readUnsignedByte();
                           var17 = var16 >> 2;
                           var18 = var16 & 3;
                           var19 = var14 + var4;
                           var20 = var13 + var5;
                           if(var19 > 0 && var20 > 0 && var19 < 103 && var20 < 103) {
                              var21 = var15;
                              if((class11.tileSettings[1][var19][var20] & 2) == 2) {
                                 var21 = var15 - 1;
                              }

                              CollisionData var55 = null;
                              if(var21 >= 0) {
                                 var55 = var54[var21];
                              }

                              class166.method3172(var15, var19, var20, var9, var18, var17, var59, var55);
                           }
                        }
                     }
                  }
               }
            }

            int var8;
            if(Client.isDynamicRegion) {
               int var22;
               CollisionData[] var52;
               Buffer var65;
               for(var2 = 0; var2 < 4; ++var2) {
                  class3.method33();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var62 = false;
                        var6 = Client.field340[var2][var3][var4];
                        if(var6 != -1) {
                           var63 = var6 >> 24 & 3;
                           var8 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = var10 / 8 + (var9 / 8 << 8);

                           for(var64 = 0; var64 < class20.mapRegions.length; ++var64) {
                              if(class20.mapRegions[var64] == var11 && class162.field2283[var64] != null) {
                                 byte[] var56 = class162.field2283[var64];
                                 var14 = 8 * var3;
                                 var15 = 8 * var4;
                                 var16 = 8 * (var9 & 7);
                                 var17 = (var10 & 7) * 8;
                                 var52 = Client.collisionMaps;

                                 for(var19 = 0; var19 < 8; ++var19) {
                                    for(var20 = 0; var20 < 8; ++var20) {
                                       if(var19 + var14 > 0 && var14 + var19 < 103 && var15 + var20 > 0 && var20 + var15 < 103) {
                                          var52[var2].flags[var19 + var14][var20 + var15] &= -16777217;
                                       }
                                    }
                                 }

                                 var65 = new Buffer(var56);

                                 for(var20 = 0; var20 < 4; ++var20) {
                                    for(var21 = 0; var21 < 64; ++var21) {
                                       for(var22 = 0; var22 < 64; ++var22) {
                                          if(var63 == var20 && var21 >= var16 && var21 < var16 + 8 && var22 >= var17 && var22 < var17 + 8) {
                                             class18.method202(var65, var2, var14 + class94.method1901(var21 & 7, var22 & 7, var8), var15 + class139.method2608(var21 & 7, var22 & 7, var8), 0, 0, var8);
                                          } else {
                                             class18.method202(var65, 0, -1, -1, 0, 0, 0);
                                          }
                                       }
                                    }
                                 }

                                 var62 = true;
                                 break;
                              }
                           }
                        }

                        if(!var62) {
                           var63 = var2;
                           var8 = var3 * 8;
                           var9 = 8 * var4;

                           for(var10 = 0; var10 < 8; ++var10) {
                              for(var11 = 0; var11 < 8; ++var11) {
                                 class11.tileHeights[var63][var8 + var10][var11 + var9] = 0;
                              }
                           }

                           if(var8 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class11.tileHeights[var63][var8][var9 + var10] = class11.tileHeights[var63][var8 - 1][var9 + var10];
                              }
                           }

                           if(var9 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class11.tileHeights[var63][var10 + var8][var9] = class11.tileHeights[var63][var8 + var10][var9 - 1];
                              }
                           }

                           if(var8 > 0 && class11.tileHeights[var63][var8 - 1][var9] != 0) {
                              class11.tileHeights[var63][var8][var9] = class11.tileHeights[var63][var8 - 1][var9];
                           } else if(var9 > 0 && class11.tileHeights[var63][var8][var9 - 1] != 0) {
                              class11.tileHeights[var63][var8][var9] = class11.tileHeights[var63][var8][var9 - 1];
                           } else if(var8 > 0 && var9 > 0 && class11.tileHeights[var63][var8 - 1][var9 - 1] != 0) {
                              class11.tileHeights[var63][var8][var9] = class11.tileHeights[var63][var8 - 1][var9 - 1];
                           }
                        }
                     }
                  }
               }

               for(var2 = 0; var2 < 13; ++var2) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.field340[0][var2][var3];
                     if(var4 == -1) {
                        class166.method3171(8 * var2, 8 * var3, 8, 8);
                     }
                  }
               }

               class153.method2861(true);

               for(var2 = 0; var2 < 4; ++var2) {
                  class3.method33();

                  for(var3 = 0; var3 < 13; ++var3) {
                     label681:
                     for(var4 = 0; var4 < 13; ++var4) {
                        var5 = Client.field340[var2][var3][var4];
                        if(var5 != -1) {
                           var6 = var5 >> 24 & 3;
                           var63 = var5 >> 1 & 3;
                           var8 = var5 >> 14 & 1023;
                           var9 = var5 >> 3 & 2047;
                           var10 = var9 / 8 + (var8 / 8 << 8);

                           for(var11 = 0; var11 < class20.mapRegions.length; ++var11) {
                              if(var10 == class20.mapRegions[var11] && null != ItemLayer.field1220[var11]) {
                                 byte[] var61 = ItemLayer.field1220[var11];
                                 var13 = var3 * 8;
                                 var14 = 8 * var4;
                                 var15 = (var8 & 7) * 8;
                                 var16 = 8 * (var9 & 7);
                                 Region var60 = class65.region;
                                 var52 = Client.collisionMaps;
                                 var65 = new Buffer(var61);
                                 var20 = -1;

                                 while(true) {
                                    var21 = var65.method2939();
                                    if(var21 == 0) {
                                       continue label681;
                                    }

                                    var20 += var21;
                                    var22 = 0;

                                    while(true) {
                                       int var23 = var65.method2939();
                                       if(var23 == 0) {
                                          break;
                                       }

                                       var22 += var23 - 1;
                                       int var24 = var22 & 63;
                                       int var25 = var22 >> 6 & 63;
                                       int var26 = var22 >> 12;
                                       int var27 = var65.readUnsignedByte();
                                       int var28 = var27 >> 2;
                                       int var29 = var27 & 3;
                                       if(var6 == var26 && var25 >= var15 && var25 < var15 + 8 && var24 >= var16 && var24 < 8 + var16) {
                                          ObjectComposition var30 = class156.getObjectDefinition(var20);
                                          int var33 = var25 & 7;
                                          int var34 = var24 & 7;
                                          int var36 = var30.sizeX;
                                          int var37 = var30.sizeY;
                                          int var38;
                                          if((var29 & 1) == 1) {
                                             var38 = var36;
                                             var36 = var37;
                                             var37 = var38;
                                          }

                                          int var35 = var63 & 3;
                                          int var32;
                                          if(var35 == 0) {
                                             var32 = var33;
                                          } else if(var35 == 1) {
                                             var32 = var34;
                                          } else if(var35 == 2) {
                                             var32 = 7 - var33 - (var36 - 1);
                                          } else {
                                             var32 = 7 - var34 - (var37 - 1);
                                          }

                                          var38 = var13 + var32;
                                          int var41 = var25 & 7;
                                          int var42 = var24 & 7;
                                          int var44 = var30.sizeX;
                                          int var45 = var30.sizeY;
                                          int var46;
                                          if((var29 & 1) == 1) {
                                             var46 = var44;
                                             var44 = var45;
                                             var45 = var46;
                                          }

                                          int var43 = var63 & 3;
                                          int var40;
                                          if(var43 == 0) {
                                             var40 = var42;
                                          } else if(var43 == 1) {
                                             var40 = 7 - var41 - (var44 - 1);
                                          } else if(var43 == 2) {
                                             var40 = 7 - var42 - (var45 - 1);
                                          } else {
                                             var40 = var41;
                                          }

                                          var46 = var40 + var14;
                                          if(var38 > 0 && var46 > 0 && var38 < 103 && var46 < 103) {
                                             int var47 = var2;
                                             if((class11.tileSettings[1][var38][var46] & 2) == 2) {
                                                var47 = var2 - 1;
                                             }

                                             CollisionData var48 = null;
                                             if(var47 >= 0) {
                                                var48 = var52[var47];
                                             }

                                             class166.method3172(var2, var38, var46, var20, var63 + var29 & 3, var28, var60, var48);
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

            class153.method2861(true);
            class45.method827();
            class3.method33();
            class97.method1912(class65.region, Client.collisionMaps);
            class153.method2861(true);
            var2 = class11.field115;
            if(var2 > class48.plane) {
               var2 = class48.plane;
            }

            if(var2 < class48.plane - 1) {
               var2 = class48.plane - 1;
            }

            if(Client.field278) {
               class65.region.method1708(class11.field115);
            } else {
               class65.region.method1708(0);
            }

            for(var3 = 0; var3 < 104; ++var3) {
               for(var4 = 0; var4 < 104; ++var4) {
                  class11.groundItemSpawned(var3, var4);
               }
            }

            class3.method33();
            class25.method612();
            ObjectComposition.field2877.reset();
            if(null != Tile.field1351) {
               Client.field321.method3195(101);
               Client.field321.method3057(1057001181);
            }

            if(!Client.isDynamicRegion) {
               var3 = (Actor.field650 - 6) / 8;
               var4 = (6 + Actor.field650) / 8;
               var5 = (class2.field25 - 6) / 8;
               var6 = (class2.field25 + 6) / 8;

               for(var63 = var3 - 1; var63 <= 1 + var4; ++var63) {
                  for(var8 = var5 - 1; var8 <= var6 + 1; ++var8) {
                     if(var63 < var3 || var63 > var4 || var8 < var5 || var8 > var6) {
                        class37.field786.method3295("m" + var63 + "_" + var8);
                        class37.field786.method3295("l" + var63 + "_" + var8);
                     }
                  }
               }
            }

            class11.setGameState(30);
            class3.method33();
            class18.method201();
            Client.field321.method3195(74);
            Spotanim.method3457();
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1176456267"
   )
   public static void method1702() {
      class138.field1906.method2474();
      class138.field1910 = 1;
      class1.field10 = null;
   }
}
