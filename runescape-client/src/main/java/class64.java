import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public class class64 {
   @ObfuscatedName("lt")
   @ObfuscatedGetter(
      intValue = -1822330787
   )
   static int field799;
   @ObfuscatedName("bb")
   static class71 field807;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = 927526927
   )
   static int field808;
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      intValue = -1327015711
   )
   static int field810;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "0"
   )
   public static int method1069(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1315166860"
   )
   static final void method1070() {
      class12.method62(false);
      Client.field1026 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < XClanMember.field923.length; ++var1) {
         if(XItemContainer.field794[var1] != -1 && XClanMember.field923[var1] == null) {
            XClanMember.field923[var1] = XClanMember.indexMaps.getConfigData(XItemContainer.field794[var1], 0);
            if(XClanMember.field923[var1] == null) {
               var0 = false;
               ++Client.field1026;
            }
         }

         if(class28.field420[var1] != -1 && Frames.field2158[var1] == null) {
            Frames.field2158[var1] = XClanMember.indexMaps.getConfigData(class28.field420[var1], 0, ChatLineBuffer.xteaKeys[var1]);
            if(Frames.field2158[var1] == null) {
               var0 = false;
               ++Client.field1026;
            }
         }
      }

      if(!var0) {
         Client.field1142 = 1;
      } else {
         Client.field987 = 0;
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
         for(var1 = 0; var1 < XClanMember.field923.length; ++var1) {
            byte[] var2 = Frames.field2158[var1];
            if(var2 != null) {
               var3 = (class100.mapRegions[var1] >> 8) * 64 - class41.baseX;
               var4 = (class100.mapRegions[var1] & 255) * 64 - WorldMapType3.baseY;
               if(Client.isDynamicRegion) {
                  var3 = 10;
                  var4 = 10;
               }

               boolean var7 = true;
               Buffer var8 = new Buffer(var2);
               var9 = -1;

               label761:
               while(true) {
                  var10 = var8.method3154();
                  if(var10 == 0) {
                     var0 &= var7;
                     break;
                  }

                  var9 += var10;
                  var11 = 0;
                  boolean var12 = false;

                  while(true) {
                     while(!var12) {
                        var13 = var8.method3154();
                        if(var13 == 0) {
                           continue label761;
                        }

                        var11 += var13 - 1;
                        var14 = var11 & 63;
                        var15 = var11 >> 6 & 63;
                        var16 = var8.readUnsignedByte() >> 2;
                        int var17 = var3 + var15;
                        int var18 = var14 + var4;
                        if(var17 > 0 && var18 > 0 && var17 < 103 && var18 < 103) {
                           ObjectComposition var19 = class226.getObjectDefinition(var9);
                           if(var16 != 22 || !Client.field1046 || var19.field3451 != 0 || var19.field3471 == 1 || var19.field3470) {
                              if(!var19.method4529()) {
                                 ++Client.field987;
                                 var7 = false;
                              }

                              var12 = true;
                           }
                        }
                     }

                     var13 = var8.method3154();
                     if(var13 == 0) {
                        break;
                     }

                     var8.readUnsignedByte();
                  }
               }
            }
         }

         if(!var0) {
            Client.field1142 = 2;
         } else {
            if(Client.field1142 != 0) {
               KitDefinition.method4378("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            WidgetNode.method1084();
            class10.method48();
            WidgetNode.method1084();
            class1.region.method2674();
            WidgetNode.method1084();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].method3022();
            }

            int var42;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var42 = 0; var42 < 104; ++var42) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class61.tileSettings[var1][var42][var3] = 0;
                  }
               }
            }

            WidgetNode.method1084();
            class224.method4069();
            var1 = XClanMember.field923.length;

            for(class82 var50 = (class82)class82.field1348.method3576(); var50 != null; var50 = (class82)class82.field1348.method3578()) {
               if(var50.field1341 != null) {
                  class158.field2288.method1871(var50.field1341);
                  var50.field1341 = null;
               }

               if(var50.field1353 != null) {
                  class158.field2288.method1871(var50.field1353);
                  var50.field1353 = null;
               }
            }

            class82.field1348.method3569();
            class12.method62(true);
            int var5;
            int var6;
            int var52;
            int var54;
            if(!Client.isDynamicRegion) {
               byte[] var44;
               for(var42 = 0; var42 < var1; ++var42) {
                  var3 = (class100.mapRegions[var42] >> 8) * 64 - class41.baseX;
                  var4 = (class100.mapRegions[var42] & 255) * 64 - WorldMapType3.baseY;
                  var44 = XClanMember.field923[var42];
                  if(var44 != null) {
                     WidgetNode.method1084();
                     var6 = class59.field748 * 8 - 48;
                     var52 = class59.field747 * 8 - 48;
                     CollisionData[] var53 = Client.collisionMaps;

                     for(var9 = 0; var9 < 4; ++var9) {
                        for(var10 = 0; var10 < 64; ++var10) {
                           for(var11 = 0; var11 < 64; ++var11) {
                              if(var10 + var3 > 0 && var3 + var10 < 103 && var4 + var11 > 0 && var4 + var11 < 103) {
                                 var53[var9].flags[var3 + var10][var4 + var11] &= -16777217;
                              }
                           }
                        }
                     }

                     Buffer var45 = new Buffer(var44);

                     for(var10 = 0; var10 < 4; ++var10) {
                        for(var11 = 0; var11 < 64; ++var11) {
                           for(var54 = 0; var54 < 64; ++var54) {
                              class90.method1706(var45, var10, var3 + var11, var54 + var4, var6, var52, 0);
                           }
                        }
                     }
                  }
               }

               for(var42 = 0; var42 < var1; ++var42) {
                  var3 = (class100.mapRegions[var42] >> 8) * 64 - class41.baseX;
                  var4 = (class100.mapRegions[var42] & 255) * 64 - WorldMapType3.baseY;
                  var44 = XClanMember.field923[var42];
                  if(var44 == null && class59.field747 < 800) {
                     WidgetNode.method1084();
                     class2.method1(var3, var4, 64, 64);
                  }
               }

               class12.method62(true);

               for(var42 = 0; var42 < var1; ++var42) {
                  byte[] var46 = Frames.field2158[var42];
                  if(var46 != null) {
                     var4 = (class100.mapRegions[var42] >> 8) * 64 - class41.baseX;
                     var5 = (class100.mapRegions[var42] & 255) * 64 - WorldMapType3.baseY;
                     WidgetNode.method1084();
                     class234.method4104(var46, var4, var5, class1.region, Client.collisionMaps);
                  }
               }
            }

            int var43;
            if(Client.isDynamicRegion) {
               for(var42 = 0; var42 < 4; ++var42) {
                  WidgetNode.method1084();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var51 = false;
                        var6 = Client.field992[var42][var3][var4];
                        if(var6 != -1) {
                           var52 = var6 >> 24 & 3;
                           var43 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = (var9 / 8 << 8) + var10 / 8;

                           for(var54 = 0; var54 < class100.mapRegions.length; ++var54) {
                              if(var11 == class100.mapRegions[var54] && XClanMember.field923[var54] != null) {
                                 class61.method1042(XClanMember.field923[var54], var42, var3 * 8, var4 * 8, var52, (var9 & 7) * 8, (var10 & 7) * 8, var43, Client.collisionMaps);
                                 var51 = true;
                                 break;
                              }
                           }
                        }

                        if(!var51) {
                           var52 = var42;
                           var43 = var3 * 8;
                           var9 = var4 * 8;

                           for(var10 = 0; var10 < 8; ++var10) {
                              for(var11 = 0; var11 < 8; ++var11) {
                                 class61.tileHeights[var52][var43 + var10][var9 + var11] = 0;
                              }
                           }

                           if(var43 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class61.tileHeights[var52][var43][var9 + var10] = class61.tileHeights[var52][var43 - 1][var9 + var10];
                              }
                           }

                           if(var9 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class61.tileHeights[var52][var10 + var43][var9] = class61.tileHeights[var52][var10 + var43][var9 - 1];
                              }
                           }

                           if(var43 > 0 && class61.tileHeights[var52][var43 - 1][var9] != 0) {
                              class61.tileHeights[var52][var43][var9] = class61.tileHeights[var52][var43 - 1][var9];
                           } else if(var9 > 0 && class61.tileHeights[var52][var43][var9 - 1] != 0) {
                              class61.tileHeights[var52][var43][var9] = class61.tileHeights[var52][var43][var9 - 1];
                           } else if(var43 > 0 && var9 > 0 && class61.tileHeights[var52][var43 - 1][var9 - 1] != 0) {
                              class61.tileHeights[var52][var43][var9] = class61.tileHeights[var52][var43 - 1][var9 - 1];
                           }
                        }
                     }
                  }
               }

               for(var42 = 0; var42 < 13; ++var42) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.field992[0][var42][var3];
                     if(var4 == -1) {
                        class2.method1(var42 * 8, var3 * 8, 8, 8);
                     }
                  }
               }

               class12.method62(true);

               for(var42 = 0; var42 < 4; ++var42) {
                  WidgetNode.method1084();

                  for(var3 = 0; var3 < 13; ++var3) {
                     label560:
                     for(var4 = 0; var4 < 13; ++var4) {
                        var5 = Client.field992[var42][var3][var4];
                        if(var5 != -1) {
                           var6 = var5 >> 24 & 3;
                           var52 = var5 >> 1 & 3;
                           var43 = var5 >> 14 & 1023;
                           var9 = var5 >> 3 & 2047;
                           var10 = (var43 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < class100.mapRegions.length; ++var11) {
                              if(var10 == class100.mapRegions[var11] && Frames.field2158[var11] != null) {
                                 byte[] var47 = Frames.field2158[var11];
                                 var13 = var3 * 8;
                                 var14 = var4 * 8;
                                 var15 = (var43 & 7) * 8;
                                 var16 = (var9 & 7) * 8;
                                 Region var48 = class1.region;
                                 CollisionData[] var49 = Client.collisionMaps;
                                 Buffer var55 = new Buffer(var47);
                                 int var20 = -1;

                                 while(true) {
                                    int var21 = var55.method3154();
                                    if(var21 == 0) {
                                       continue label560;
                                    }

                                    var20 += var21;
                                    int var22 = 0;

                                    while(true) {
                                       int var23 = var55.method3154();
                                       if(var23 == 0) {
                                          break;
                                       }

                                       var22 += var23 - 1;
                                       int var24 = var22 & 63;
                                       int var25 = var22 >> 6 & 63;
                                       int var26 = var22 >> 12;
                                       int var27 = var55.readUnsignedByte();
                                       int var28 = var27 >> 2;
                                       int var29 = var27 & 3;
                                       if(var26 == var6 && var25 >= var15 && var25 < var15 + 8 && var24 >= var16 && var24 < var16 + 8) {
                                          ObjectComposition var30 = class226.getObjectDefinition(var20);
                                          int var31 = var13 + class69.method1086(var25 & 7, var24 & 7, var52, var30.sizeX, var30.sizeY, var29);
                                          int var34 = var25 & 7;
                                          int var35 = var24 & 7;
                                          int var37 = var30.sizeX;
                                          int var38 = var30.sizeY;
                                          int var39;
                                          if((var29 & 1) == 1) {
                                             var39 = var37;
                                             var37 = var38;
                                             var38 = var39;
                                          }

                                          int var36 = var52 & 3;
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
                                             if((class61.tileSettings[1][var31][var39] & 2) == 2) {
                                                var40 = var42 - 1;
                                             }

                                             CollisionData var41 = null;
                                             if(var40 >= 0) {
                                                var41 = var49[var40];
                                             }

                                             class84.method1667(var42, var31, var39, var20, var29 + var52 & 3, var28, var48, var41);
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

            class12.method62(true);
            class10.method48();
            WidgetNode.method1084();
            Player.method1122(class1.region, Client.collisionMaps);
            class12.method62(true);
            var42 = class61.field757;
            if(var42 > FaceNormal.plane) {
               var42 = FaceNormal.plane;
            }

            if(var42 < FaceNormal.plane - 1) {
               var42 = FaceNormal.plane - 1;
            }

            if(Client.field1046) {
               class1.region.method2713(class61.field757);
            } else {
               class1.region.method2713(0);
            }

            for(var3 = 0; var3 < 104; ++var3) {
               for(var4 = 0; var4 < 104; ++var4) {
                  World.groundItemSpawned(var3, var4);
               }
            }

            WidgetNode.method1084();
            class47.method692();
            ObjectComposition.field3455.reset();
            if(Client.field1214.method890()) {
               Client.secretPacketBuffer1.putOpcode(234);
               Client.secretPacketBuffer1.putInt(1057001181);
            }

            if(!Client.isDynamicRegion) {
               var3 = (class59.field748 - 6) / 8;
               var4 = (class59.field748 + 6) / 8;
               var5 = (class59.field747 - 6) / 8;
               var6 = (class59.field747 + 6) / 8;

               for(var52 = var3 - 1; var52 <= var4 + 1; ++var52) {
                  for(var43 = var5 - 1; var43 <= var6 + 1; ++var43) {
                     if(var52 < var3 || var52 > var4 || var43 < var5 || var43 > var6) {
                        XClanMember.indexMaps.method4130("m" + var52 + "_" + var43);
                        XClanMember.indexMaps.method4130("l" + var52 + "_" + var43);
                     }
                  }
               }
            }

            class249.setGameState(30);
            WidgetNode.method1084();
            class61.underlayIds = null;
            class61.overlayIds = null;
            class61.overlayPaths = null;
            class13.overlayRotations = null;
            class47.field607 = null;
            class47.field605 = null;
            Friend.field819 = null;
            class61.field762 = null;
            class61.field763 = null;
            class215.field2637 = null;
            class61.field764 = null;
            class61.field756 = null;
            Client.secretPacketBuffer1.putOpcode(3);
            method1071();
         }
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1068611784"
   )
   protected static final void method1071() {
      GameEngine.field708.vmethod2971();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field719[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field714[var0] = 0L;
      }

      GameEngine.field704 = 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IB)I",
      garbageValue = "6"
   )
   public static int method1072(CharSequence var0, int var1) {
      return class211.method3909(var0, var1, true);
   }
}
