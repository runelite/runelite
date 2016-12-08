import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class15 {
   @ObfuscatedName("q")
   static int[] field163;
   @ObfuscatedName("eo")
   static SpritePixels[] field164;
   @ObfuscatedName("b")
   static final class15 field165 = new class15();
   @ObfuscatedName("g")
   static final class15 field166 = new class15();
   @ObfuscatedName("m")
   static final class15 field167 = new class15();
   @ObfuscatedName("o")
   static final class15 field168 = new class15();

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "11697307"
   )
   static final void method175() {
      for(int var0 = 0; var0 < Client.field526; ++var0) {
         --Client.field529[var0];
         if(Client.field529[var0] >= -10) {
            class53 var9 = Client.field531[var0];
            if(null == var9) {
               Object var10000 = null;
               var9 = class53.method955(class103.field1665, Client.field527[var0], 0);
               if(var9 == null) {
                  continue;
               }

               Client.field529[var0] += var9.method954();
               Client.field531[var0] = var9;
            }

            if(Client.field529[var0] < 0) {
               int var2;
               if(Client.field349[var0] != 0) {
                  int var3 = (Client.field349[var0] & 255) * 128;
                  int var4 = Client.field349[var0] >> 16 & 255;
                  int var5 = var4 * 128 + 64 - class5.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.field349[var0] >> 8 & 255;
                  int var7 = 128 * var6 + 64 - class5.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var5 + var7 - 128;
                  if(var8 > var3) {
                     Client.field529[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = Client.field525 * (var3 - var8) / var3;
               } else {
                  var2 = Client.field524;
               }

               if(var2 > 0) {
                  class55 var10 = var9.method944().method990(class13.field141);
                  class66 var11 = class66.method1251(var10, 100, var2);
                  var11.method1268(Client.field351[var0] - 1);
                  FaceNormal.field1554.method898(var11);
               }

               Client.field529[var0] = -100;
            }
         } else {
            --Client.field526;

            for(int var1 = var0; var1 < Client.field526; ++var1) {
               Client.field527[var1] = Client.field527[1 + var1];
               Client.field531[var1] = Client.field531[var1 + 1];
               Client.field351[var1] = Client.field351[1 + var1];
               Client.field529[var1] = Client.field529[var1 + 1];
               Client.field349[var1] = Client.field349[1 + var1];
            }

            --var0;
         }
      }

      if(Client.field493 && !class31.method655()) {
         if(Client.field521 != 0 && Client.field522 != -1) {
            WallObject.method1843(class119.field1864, Client.field522, 0, Client.field521, false);
         }

         Client.field493 = false;
      }

   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2141467033"
   )
   static final void method176() {
      class65.method1161(false);
      Client.field516 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class63.field1089.length; ++var1) {
         if(Ignore.field206[var1] != -1 && class63.field1089[var1] == null) {
            class63.field1089[var1] = ChatLineBuffer.field970.method3203(Ignore.field206[var1], 0);
            if(class63.field1089[var1] == null) {
               var0 = false;
               ++Client.field516;
            }
         }

         if(class37.field797[var1] != -1 && World.field692[var1] == null) {
            World.field692[var1] = ChatLineBuffer.field970.method3279(class37.field797[var1], 0, class11.xteaKeys[var1]);
            if(World.field692[var1] == null) {
               var0 = false;
               ++Client.field516;
            }
         }
      }

      if(!var0) {
         Client.field346 = 1;
      } else {
         Client.field344 = 0;
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
         for(var1 = 0; var1 < class63.field1089.length; ++var1) {
            byte[] var2 = World.field692[var1];
            if(null != var2) {
               var3 = 64 * (class16.mapRegions[var1] >> 8) - class107.baseX;
               var4 = (class16.mapRegions[var1] & 255) * 64 - XClanMember.baseY;
               if(Client.field348) {
                  var3 = 10;
                  var4 = 10;
               }

               boolean var7 = true;
               Buffer var8 = new Buffer(var2);
               var9 = -1;

               label712:
               while(true) {
                  var10 = var8.method2842();
                  if(var10 == 0) {
                     var0 &= var7;
                     break;
                  }

                  var9 += var10;
                  var11 = 0;
                  boolean var12 = false;

                  while(true) {
                     while(!var12) {
                        var13 = var8.method2842();
                        if(var13 == 0) {
                           continue label712;
                        }

                        var11 += var13 - 1;
                        var14 = var11 & 63;
                        var15 = var11 >> 6 & 63;
                        var16 = var8.readUnsignedByte() >> 2;
                        int var17 = var3 + var15;
                        int var18 = var14 + var4;
                        if(var17 > 0 && var18 > 0 && var17 < 103 && var18 < 103) {
                           ObjectComposition var19 = class143.getObjectDefinition(var9);
                           if(var16 != 22 || !Client.field314 || var19.field2909 != 0 || var19.field2907 == 1 || var19.field2928) {
                              if(!var19.method3517()) {
                                 ++Client.field344;
                                 var7 = false;
                              }

                              var12 = true;
                           }
                        }
                     }

                     var13 = var8.method2842();
                     if(var13 == 0) {
                        break;
                     }

                     var8.readUnsignedByte();
                  }
               }
            }
         }

         if(!var0) {
            Client.field346 = 2;
         } else {
            if(Client.field346 != 0) {
               DecorativeObject.method1875("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class183.method3292();
            class3.method33();
            class183.method3292();
            class159.region.method1666();
            class183.method3292();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].method2199();
            }

            int var42;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var42 = 0; var42 < 104; ++var42) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class10.tileSettings[var1][var42][var3] = 0;
                  }
               }
            }

            class183.method3292();
            class10.field94 = 99;
            class10.field83 = new byte[4][104][104];
            class204.field3072 = new byte[4][104][104];
            class183.field2737 = new byte[4][104][104];
            class10.field82 = new byte[4][104][104];
            DecorativeObject.field1596 = new int[4][105][105];
            class10.field80 = new byte[4][105][105];
            class10.field86 = new int[105][105];
            class146.field2032 = new int[104];
            class10.field104 = new int[104];
            class10.field88 = new int[104];
            class10.field84 = new int[104];
            class10.field90 = new int[104];
            var1 = class63.field1089.length;

            for(class31 var49 = (class31)class31.field723.method2349(); null != var49; var49 = (class31)class31.field723.method2351()) {
               if(null != var49.field716) {
                  FaceNormal.field1554.method923(var49.field716);
                  var49.field716 = null;
               }

               if(var49.field714 != null) {
                  FaceNormal.field1554.method923(var49.field714);
                  var49.field714 = null;
               }
            }

            class31.field723.method2348();
            class65.method1161(true);
            int var5;
            if(!Client.field348) {
               byte[] var44;
               for(var42 = 0; var42 < var1; ++var42) {
                  var3 = 64 * (class16.mapRegions[var42] >> 8) - class107.baseX;
                  var4 = (class16.mapRegions[var42] & 255) * 64 - XClanMember.baseY;
                  var44 = class63.field1089[var42];
                  if(null != var44) {
                     class183.method3292();
                     WidgetNode.method184(var44, var3, var4, class7.field54 * 8 - 48, class36.field787 * 8 - 48, Client.collisionMaps);
                  }
               }

               for(var42 = 0; var42 < var1; ++var42) {
                  var3 = 64 * (class16.mapRegions[var42] >> 8) - class107.baseX;
                  var4 = 64 * (class16.mapRegions[var42] & 255) - XClanMember.baseY;
                  var44 = class63.field1089[var42];
                  if(null == var44 && class36.field787 < 800) {
                     class183.method3292();
                     class32.method668(var3, var4, 64, 64);
                  }
               }

               class65.method1161(true);

               for(var42 = 0; var42 < var1; ++var42) {
                  byte[] var45 = World.field692[var42];
                  if(null != var45) {
                     var4 = (class16.mapRegions[var42] >> 8) * 64 - class107.baseX;
                     var5 = 64 * (class16.mapRegions[var42] & 255) - XClanMember.baseY;
                     class183.method3292();
                     class13.method168(var45, var4, var5, class159.region, Client.collisionMaps);
                  }
               }
            }

            int var6;
            int var43;
            int var51;
            if(Client.field348) {
               for(var42 = 0; var42 < 4; ++var42) {
                  class183.method3292();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var50 = false;
                        var6 = Client.field447[var42][var3][var4];
                        if(var6 != -1) {
                           var51 = var6 >> 24 & 3;
                           var43 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = (var9 / 8 << 8) + var10 / 8;

                           for(int var52 = 0; var52 < class16.mapRegions.length; ++var52) {
                              if(var11 == class16.mapRegions[var52] && null != class63.field1089[var52]) {
                                 class88.method1828(class63.field1089[var52], var42, 8 * var3, 8 * var4, var51, 8 * (var9 & 7), (var10 & 7) * 8, var43, Client.collisionMaps);
                                 var50 = true;
                                 break;
                              }
                           }
                        }

                        if(!var50) {
                           var51 = var42;
                           var43 = 8 * var3;
                           var9 = 8 * var4;

                           for(var10 = 0; var10 < 8; ++var10) {
                              for(var11 = 0; var11 < 8; ++var11) {
                                 class10.tileHeights[var51][var43 + var10][var9 + var11] = 0;
                              }
                           }

                           if(var43 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class10.tileHeights[var51][var43][var9 + var10] = class10.tileHeights[var51][var43 - 1][var9 + var10];
                              }
                           }

                           if(var9 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class10.tileHeights[var51][var43 + var10][var9] = class10.tileHeights[var51][var43 + var10][var9 - 1];
                              }
                           }

                           if(var43 > 0 && class10.tileHeights[var51][var43 - 1][var9] != 0) {
                              class10.tileHeights[var51][var43][var9] = class10.tileHeights[var51][var43 - 1][var9];
                           } else if(var9 > 0 && class10.tileHeights[var51][var43][var9 - 1] != 0) {
                              class10.tileHeights[var51][var43][var9] = class10.tileHeights[var51][var43][var9 - 1];
                           } else if(var43 > 0 && var9 > 0 && class10.tileHeights[var51][var43 - 1][var9 - 1] != 0) {
                              class10.tileHeights[var51][var43][var9] = class10.tileHeights[var51][var43 - 1][var9 - 1];
                           }
                        }
                     }
                  }
               }

               for(var42 = 0; var42 < 13; ++var42) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.field447[0][var42][var3];
                     if(var4 == -1) {
                        class32.method668(var42 * 8, var3 * 8, 8, 8);
                     }
                  }
               }

               class65.method1161(true);

               for(var42 = 0; var42 < 4; ++var42) {
                  class183.method3292();

                  for(var3 = 0; var3 < 13; ++var3) {
                     label547:
                     for(var4 = 0; var4 < 13; ++var4) {
                        var5 = Client.field447[var42][var3][var4];
                        if(var5 != -1) {
                           var6 = var5 >> 24 & 3;
                           var51 = var5 >> 1 & 3;
                           var43 = var5 >> 14 & 1023;
                           var9 = var5 >> 3 & 2047;
                           var10 = (var43 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < class16.mapRegions.length; ++var11) {
                              if(class16.mapRegions[var11] == var10 && World.field692[var11] != null) {
                                 byte[] var47 = World.field692[var11];
                                 var13 = 8 * var3;
                                 var14 = 8 * var4;
                                 var15 = (var43 & 7) * 8;
                                 var16 = (var9 & 7) * 8;
                                 Region var46 = class159.region;
                                 CollisionData[] var48 = Client.collisionMaps;
                                 Buffer var53 = new Buffer(var47);
                                 int var20 = -1;

                                 while(true) {
                                    int var21 = var53.method2842();
                                    if(var21 == 0) {
                                       continue label547;
                                    }

                                    var20 += var21;
                                    int var22 = 0;

                                    while(true) {
                                       int var23 = var53.method2842();
                                       if(var23 == 0) {
                                          break;
                                       }

                                       var22 += var23 - 1;
                                       int var24 = var22 & 63;
                                       int var25 = var22 >> 6 & 63;
                                       int var26 = var22 >> 12;
                                       int var27 = var53.readUnsignedByte();
                                       int var28 = var27 >> 2;
                                       int var29 = var27 & 3;
                                       if(var26 == var6 && var25 >= var15 && var25 < var15 + 8 && var24 >= var16 && var24 < var16 + 8) {
                                          ObjectComposition var30 = class143.getObjectDefinition(var20);
                                          int var31 = var13 + class2.method27(var25 & 7, var24 & 7, var51, var30.field2905, var30.field2938, var29);
                                          int var34 = var25 & 7;
                                          int var35 = var24 & 7;
                                          int var37 = var30.field2905;
                                          int var38 = var30.field2938;
                                          int var39;
                                          if((var29 & 1) == 1) {
                                             var39 = var37;
                                             var37 = var38;
                                             var38 = var39;
                                          }

                                          int var36 = var51 & 3;
                                          int var33;
                                          if(var36 == 0) {
                                             var33 = var35;
                                          } else if(var36 == 1) {
                                             var33 = 7 - var34 - (var37 - 1);
                                          } else if(var36 == 2) {
                                             var33 = 7 - var35 - (var38 - 1);
                                          } else {
                                             var33 = var34;
                                          }

                                          var39 = var33 + var14;
                                          if(var31 > 0 && var39 > 0 && var31 < 103 && var39 < 103) {
                                             int var40 = var42;
                                             if((class10.tileSettings[1][var31][var39] & 2) == 2) {
                                                var40 = var42 - 1;
                                             }

                                             CollisionData var41 = null;
                                             if(var40 >= 0) {
                                                var41 = var48[var40];
                                             }

                                             class195.method3463(var42, var31, var39, var20, var29 + var51 & 3, var28, var46, var41);
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

            class65.method1161(true);
            class3.method33();
            class183.method3292();
            class45.method820(class159.region, Client.collisionMaps);
            class65.method1161(true);
            var42 = class10.field94;
            if(var42 > class63.plane) {
               var42 = class63.plane;
            }

            if(var42 < class63.plane - 1) {
               var42 = class63.plane - 1;
            }

            if(Client.field314) {
               class159.region.method1825(class10.field94);
            } else {
               class159.region.method1825(0);
            }

            for(var3 = 0; var3 < 104; ++var3) {
               for(var4 = 0; var4 < 104; ++var4) {
                  class161.groundItemSpawned(var3, var4);
               }
            }

            class183.method3292();
            class146.method2671();
            ObjectComposition.field2912.reset();
            if(class112.field1777 != null) {
               Client.field330.method2967(215);
               Client.field330.method2714(1057001181);
            }

            if(!Client.field348) {
               var3 = (class7.field54 - 6) / 8;
               var4 = (6 + class7.field54) / 8;
               var5 = (class36.field787 - 6) / 8;
               var6 = (6 + class36.field787) / 8;

               for(var51 = var3 - 1; var51 <= 1 + var4; ++var51) {
                  for(var43 = var5 - 1; var43 <= var6 + 1; ++var43) {
                     if(var51 < var3 || var51 > var4 || var43 < var5 || var43 > var6) {
                        ChatLineBuffer.field970.method3223("m" + var51 + "_" + var43);
                        ChatLineBuffer.field970.method3223("l" + var51 + "_" + var43);
                     }
                  }
               }
            }

            class20.setGameState(30);
            class183.method3292();
            class10.field83 = null;
            class204.field3072 = null;
            class183.field2737 = null;
            class10.field82 = null;
            DecorativeObject.field1596 = null;
            class10.field80 = null;
            class10.field86 = null;
            class146.field2032 = null;
            class10.field104 = null;
            class10.field88 = null;
            class10.field84 = null;
            class10.field90 = null;
            Client.field330.method2967(187);
            class9.field77.vmethod2001();

            for(var3 = 0; var3 < 32; ++var3) {
               GameEngine.field1791[var3] = 0L;
            }

            for(var3 = 0; var3 < 32; ++var3) {
               GameEngine.field1786[var3] = 0L;
            }

            WidgetNode.field184 = 0;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "251535225"
   )
   public static void method177(int var0) {
      class115.mouseIdleTicks = var0;
   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(LWidget;B)LWidget;",
      garbageValue = "6"
   )
   static Widget method178(Widget var0) {
      Widget var1 = class205.method3728(var0);
      if(null == var1) {
         var1 = var0.parent;
      }

      return var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-38"
   )
   public static boolean method179(char var0) {
      return var0 >= 48 && var0 <= 57;
   }
}
