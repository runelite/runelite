import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class33 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1779796427
   )
   int field464;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -275068309
   )
   int field465;
   @ObfuscatedName("cq")
   @Export("indexTrack2")
   static IndexData indexTrack2;
   @ObfuscatedName("q")
   class24 field467;
   @ObfuscatedName("i")
   String field468;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 414407823
   )
   static int field470;

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIIB)V",
      garbageValue = "-56"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.method4998(var2, var3, var4, var5);
      class136.method2651();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var1 == var10.parentId || var1 == -1412584499 && Client.field961 == var10)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field1093] = var10.relativeX + var6;
               Client.widgetPositionY[Client.field1093] = var10.relativeY + var7;
               Client.widgetBoundsWidth[Client.field1093] = var10.width;
               Client.widgetBoundsHeight[Client.field1093] = var10.height;
               var11 = ++Client.field1093 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2774 = Client.gameCycle;
            if(!var10.hasScript || !class149.method2945(var10)) {
               if(var10.contentType > 0) {
                  class56.method817(var10);
               }

               int var12 = var10.relativeX + var6;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(Client.field961 == var10) {
                  if(var1 != -1412584499 && !var10.field2720) {
                     class29.field416 = var0;
                     XClanMember.field886 = var6;
                     class51.field648 = var7;
                     continue;
                  }

                  if(Client.field1008 && Client.field1068) {
                     var15 = class59.field721;
                     var16 = class59.field722;
                     var15 -= Client.field1065;
                     var16 -= Client.field1039;
                     if(var15 < Client.field1034) {
                        var15 = Client.field1034;
                     }

                     if(var10.width + var15 > Client.field1084.width + Client.field1034) {
                        var15 = Client.field1034 + Client.field1084.width - var10.width;
                     }

                     if(var16 < Client.field989) {
                        var16 = Client.field989;
                     }

                     if(var16 + var10.height > Client.field989 + Client.field1084.height) {
                        var16 = Client.field1084.height + Client.field989 - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2720) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var21;
               int var22;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var19 = var12;
                  var20 = var13;
                  var21 = var10.width + var12;
                  var22 = var13 + var10.height;
                  if(var21 < var12) {
                     var19 = var21;
                     var21 = var12;
                  }

                  if(var22 < var13) {
                     var20 = var22;
                     var22 = var13;
                  }

                  ++var21;
                  ++var22;
                  var15 = var19 > var2?var19:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var21 < var4?var21:var4;
                  var18 = var22 < var5?var22:var5;
               } else {
                  var19 = var10.width + var12;
                  var20 = var13 + var10.height;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.hasScript || var15 < var17 && var16 < var18) {
                  int var24;
                  int var27;
                  int var29;
                  int var49;
                  int var51;
                  int var53;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.field905) {
                           var13 += 15;
                           MessageNode.field845.method4816("Fps:" + GameEngine.FPS, var10.width + var12, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var75 = Runtime.getRuntime();
                           var20 = (int)((var75.totalMemory() - var75.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && Client.field895) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.field895) {
                              var21 = 16711680;
                           }

                           MessageNode.field845.method4816("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     int var28;
                     int var31;
                     NPC var63;
                     Player var64;
                     if(var10.contentType == 1337) {
                        Client.field1143 = var12;
                        Client.field1040 = var13;
                        var21 = var10.width;
                        var22 = var10.height;
                        ++Client.field1152;
                        class15.method86(class66.field802);
                        boolean var84 = false;
                        if(Client.field1106 >= 0) {
                           var24 = class96.field1489;
                           int[] var65 = class96.field1496;

                           for(var53 = 0; var53 < var24; ++var53) {
                              if(var65[var53] == Client.field1106) {
                                 var84 = true;
                                 break;
                              }
                           }
                        }

                        if(var84) {
                           class15.method86(class66.field799);
                        }

                        class6.method10(true);
                        class15.method86(var84?class66.field801:class66.field803);
                        class6.method10(false);

                        for(Projectile var81 = (Projectile)Client.projectiles.method3660(); var81 != null; var81 = (Projectile)Client.projectiles.method3661()) {
                           if(var81.floor == Sequence.plane && Client.gameCycle <= var81.field1454) {
                              if(Client.gameCycle >= var81.startTime) {
                                 if(var81.interacting > 0) {
                                    var63 = Client.cachedNPCs[var81.interacting - 1];
                                    if(var63 != null && var63.x >= 0 && var63.x < 13312 && var63.y >= 0 && var63.y < 13312) {
                                       var81.method1782(var63.x, var63.y, Ignore.method1119(var63.x, var63.y, var81.floor) - var81.field1452, Client.gameCycle);
                                    }
                                 }

                                 if(var81.interacting < 0) {
                                    var53 = -var81.interacting - 1;
                                    if(Client.localInteractingIndex == var53) {
                                       var64 = XGrandExchangeOffer.localPlayer;
                                    } else {
                                       var64 = Client.cachedPlayers[var53];
                                    }

                                    if(var64 != null && var64.x >= 0 && var64.x < 13312 && var64.y >= 0 && var64.y < 13312) {
                                       var81.method1782(var64.x, var64.y, Ignore.method1119(var64.x, var64.y, var81.floor) - var81.field1452, Client.gameCycle);
                                    }
                                 }

                                 var81.method1791(Client.field966);
                                 class46.region.method2771(Sequence.plane, (int)var81.x, (int)var81.velocityZ, (int)var81.z, 60, var81, var81.field1470, -1, false);
                              }
                           } else {
                              var81.unlink();
                           }
                        }

                        for(class84 var82 = (class84)Client.field1023.method3660(); var82 != null; var82 = (class84)Client.field1023.method3661()) {
                           if(Sequence.plane == var82.field1330 && !var82.field1337) {
                              if(Client.gameCycle >= var82.field1328) {
                                 var82.method1688(Client.field966);
                                 if(var82.field1337) {
                                    var82.unlink();
                                 } else {
                                    class46.region.method2771(var82.field1330, var82.field1331, var82.field1329, var82.field1333, 60, var82, 0, -1, false);
                                 }
                              }
                           } else {
                              var82.unlink();
                           }
                        }

                        Client.method1512(var12, var13, var21, var22, true);
                        var19 = Client.field1151;
                        var20 = Client.field1091;
                        var21 = Client.camera2;
                        var22 = Client.camera3;
                        Rasterizer2D.method4998(var19, var20, var19 + var21, var22 + var20);
                        class136.method2651();
                        int var32;
                        int var33;
                        int var34;
                        int var35;
                        int var37;
                        int var67;
                        if(!Client.field929) {
                           var24 = Client.field973;
                           if(Client.field982 / 256 > var24) {
                              var24 = Client.field982 / 256;
                           }

                           if(Client.field1138[4] && Client.field1140[4] + 128 > var24) {
                              var24 = Client.field1140[4] + 128;
                           }

                           var51 = Client.mapAngle + Client.field958 & 2047;
                           var53 = class34.field487;
                           var27 = Ignore.method1119(XGrandExchangeOffer.localPlayer.x, XGrandExchangeOffer.localPlayer.y, Sequence.plane) - Client.field979;
                           var28 = class31.field439;
                           var29 = var24 * 3 + 600;
                           var67 = 2048 - var24 & 2047;
                           var31 = 2048 - var51 & 2047;
                           var32 = 0;
                           var33 = 0;
                           var34 = var29;
                           int var36;
                           if(var67 != 0) {
                              var35 = class136.SINE[var67];
                              var36 = class136.COSINE[var67];
                              var37 = var36 * var33 - var35 * var29 >> 16;
                              var34 = var35 * var33 + var36 * var29 >> 16;
                              var33 = var37;
                           }

                           if(var31 != 0) {
                              var35 = class136.SINE[var31];
                              var36 = class136.COSINE[var31];
                              var37 = var34 * var35 + var32 * var36 >> 16;
                              var34 = var34 * var36 - var32 * var35 >> 16;
                              var32 = var37;
                           }

                           class12.cameraX = var53 - var32;
                           class40.cameraZ = var27 - var33;
                           class12.cameraY = var28 - var34;
                           class36.cameraPitch = var24;
                           class244.cameraYaw = var51;
                        }

                        if(!Client.field929) {
                           if(class134.field1989.field1284) {
                              var51 = Sequence.plane;
                           } else {
                              label2041: {
                                 var53 = 3;
                                 if(class36.cameraPitch < 310) {
                                    var27 = class12.cameraX >> 7;
                                    var28 = class12.cameraY >> 7;
                                    var29 = XGrandExchangeOffer.localPlayer.x >> 7;
                                    var67 = XGrandExchangeOffer.localPlayer.y >> 7;
                                    if(var27 < 0 || var28 < 0 || var27 >= 104 || var28 >= 104) {
                                       var51 = Sequence.plane;
                                       break label2041;
                                    }

                                    if((class61.tileSettings[Sequence.plane][var27][var28] & 4) != 0) {
                                       var53 = Sequence.plane;
                                    }

                                    if(var29 > var27) {
                                       var31 = var29 - var27;
                                    } else {
                                       var31 = var27 - var29;
                                    }

                                    if(var67 > var28) {
                                       var32 = var67 - var28;
                                    } else {
                                       var32 = var28 - var67;
                                    }

                                    if(var31 > var32) {
                                       var33 = var32 * 65536 / var31;
                                       var34 = '耀';

                                       while(var27 != var29) {
                                          if(var27 < var29) {
                                             ++var27;
                                          } else if(var27 > var29) {
                                             --var27;
                                          }

                                          if((class61.tileSettings[Sequence.plane][var27][var28] & 4) != 0) {
                                             var53 = Sequence.plane;
                                          }

                                          var34 += var33;
                                          if(var34 >= 65536) {
                                             var34 -= 65536;
                                             if(var28 < var67) {
                                                ++var28;
                                             } else if(var28 > var67) {
                                                --var28;
                                             }

                                             if((class61.tileSettings[Sequence.plane][var27][var28] & 4) != 0) {
                                                var53 = Sequence.plane;
                                             }
                                          }
                                       }
                                    } else {
                                       var33 = var31 * 65536 / var32;
                                       var34 = '耀';

                                       while(var28 != var67) {
                                          if(var28 < var67) {
                                             ++var28;
                                          } else if(var28 > var67) {
                                             --var28;
                                          }

                                          if((class61.tileSettings[Sequence.plane][var27][var28] & 4) != 0) {
                                             var53 = Sequence.plane;
                                          }

                                          var34 += var33;
                                          if(var34 >= 65536) {
                                             var34 -= 65536;
                                             if(var27 < var29) {
                                                ++var27;
                                             } else if(var27 > var29) {
                                                --var27;
                                             }

                                             if((class61.tileSettings[Sequence.plane][var27][var28] & 4) != 0) {
                                                var53 = Sequence.plane;
                                             }
                                          }
                                       }
                                    }
                                 }

                                 if(XGrandExchangeOffer.localPlayer.x >= 0 && XGrandExchangeOffer.localPlayer.y >= 0 && XGrandExchangeOffer.localPlayer.x < 13312 && XGrandExchangeOffer.localPlayer.y < 13312) {
                                    if((class61.tileSettings[Sequence.plane][XGrandExchangeOffer.localPlayer.x >> 7][XGrandExchangeOffer.localPlayer.y >> 7] & 4) != 0) {
                                       var53 = Sequence.plane;
                                    }

                                    var51 = var53;
                                 } else {
                                    var51 = Sequence.plane;
                                 }
                              }
                           }

                           var24 = var51;
                        } else {
                           if(class134.field1989.field1284) {
                              var51 = Sequence.plane;
                           } else {
                              var53 = Ignore.method1119(class12.cameraX, class12.cameraY, Sequence.plane);
                              if(var53 - class40.cameraZ < 800 && (class61.tileSettings[Sequence.plane][class12.cameraX >> 7][class12.cameraY >> 7] & 4) != 0) {
                                 var51 = Sequence.plane;
                              } else {
                                 var51 = 3;
                              }
                           }

                           var24 = var51;
                        }

                        var51 = class12.cameraX;
                        var53 = class40.cameraZ;
                        var27 = class12.cameraY;
                        var28 = class36.cameraPitch;
                        var29 = class244.cameraYaw;

                        for(var67 = 0; var67 < 5; ++var67) {
                           if(Client.field1138[var67]) {
                              var31 = (int)(Math.random() * (double)(Client.field1139[var67] * 2 + 1) - (double)Client.field1139[var67] + Math.sin((double)Client.field1141[var67] / 100.0D * (double)Client.field1166[var67]) * (double)Client.field1140[var67]);
                              if(var67 == 0) {
                                 class12.cameraX += var31;
                              }

                              if(var67 == 1) {
                                 class40.cameraZ += var31;
                              }

                              if(var67 == 2) {
                                 class12.cameraY += var31;
                              }

                              if(var67 == 3) {
                                 class244.cameraYaw = class244.cameraYaw + var31 & 2047;
                              }

                              if(var67 == 4) {
                                 class36.cameraPitch += var31;
                                 if(class36.cameraPitch < 128) {
                                    class36.cameraPitch = 128;
                                 }

                                 if(class36.cameraPitch > 383) {
                                    class36.cameraPitch = 383;
                                 }
                              }
                           }
                        }

                        var67 = class59.field721;
                        var31 = class59.field722;
                        if(class59.field727 != 0) {
                           var67 = class59.field717;
                           var31 = class59.field729;
                        }

                        if(var67 >= var19 && var67 < var19 + var21 && var31 >= var20 && var31 < var22 + var20) {
                           XClanMember.method1167(var67 - var19, var31 - var20);
                        } else {
                           class36.method502();
                        }

                        Ignore.method1118();
                        Rasterizer2D.method5042(var19, var20, var21, var22, 0);
                        Ignore.method1118();
                        var32 = class136.field1998;
                        class136.field1998 = Client.scale;
                        class46.region.method2748(class12.cameraX, class40.cameraZ, class12.cameraY, class36.cameraPitch, class244.cameraYaw, var24);
                        Client.method1275();
                        class136.field1998 = var32;
                        Ignore.method1118();
                        class46.region.method2779();
                        Client.field983 = 0;
                        boolean var70 = false;
                        var34 = -1;
                        var35 = class96.field1489;
                        int[] var54 = class96.field1496;

                        for(var37 = 0; var37 < var35 + Client.field928; ++var37) {
                           Object var38;
                           if(var37 < var35) {
                              var38 = Client.cachedPlayers[var54[var37]];
                              if(var54[var37] == Client.field1106) {
                                 var70 = true;
                                 var34 = var37;
                                 continue;
                              }
                           } else {
                              var38 = Client.cachedNPCs[Client.field1013[var37 - var35]];
                           }

                           class208.method3968((Actor)var38, var37, var19, var20, var21, var22);
                        }

                        if(var70) {
                           class208.method3968(Client.cachedPlayers[Client.field1106], var34, var19, var20, var21, var22);
                        }

                        for(var37 = 0; var37 < Client.field983; ++var37) {
                           int var57 = Client.field985[var37];
                           int var39 = Client.field910[var37];
                           int var40 = Client.field988[var37];
                           int var41 = Client.field987[var37];
                           boolean var42 = true;

                           while(var42) {
                              var42 = false;

                              for(int var56 = 0; var56 < var37; ++var56) {
                                 if(var39 + 2 > Client.field910[var56] - Client.field987[var56] && var39 - var41 < Client.field910[var56] + 2 && var57 - var40 < Client.field988[var56] + Client.field985[var56] && var57 + var40 > Client.field985[var56] - Client.field988[var56] && Client.field910[var56] - Client.field987[var56] < var39) {
                                    var39 = Client.field910[var56] - Client.field987[var56];
                                    var42 = true;
                                 }
                              }
                           }

                           Client.field995 = Client.field985[var37];
                           Client.field996 = Client.field910[var37] = var39;
                           String var43 = Client.field992[var37];
                           if(Client.field1052 == 0) {
                              int var44 = 16776960;
                              if(Client.field1056[var37] < 6) {
                                 var44 = Client.field1066[Client.field1056[var37]];
                              }

                              if(Client.field1056[var37] == 6) {
                                 var44 = Client.field1152 % 20 < 10?16711680:16776960;
                              }

                              if(Client.field1056[var37] == 7) {
                                 var44 = Client.field1152 % 20 < 10?255:'\uffff';
                              }

                              if(Client.field1056[var37] == 8) {
                                 var44 = Client.field1152 % 20 < 10?'뀀':8454016;
                              }

                              int var45;
                              if(Client.field1056[var37] == 9) {
                                 var45 = 150 - Client.field952[var37];
                                 if(var45 < 50) {
                                    var44 = var45 * 1280 + 16711680;
                                 } else if(var45 < 100) {
                                    var44 = 16776960 - (var45 - 50) * 327680;
                                 } else if(var45 < 150) {
                                    var44 = (var45 - 100) * 5 + '\uff00';
                                 }
                              }

                              if(Client.field1056[var37] == 10) {
                                 var45 = 150 - Client.field952[var37];
                                 if(var45 < 50) {
                                    var44 = var45 * 5 + 16711680;
                                 } else if(var45 < 100) {
                                    var44 = 16711935 - (var45 - 50) * 327680;
                                 } else if(var45 < 150) {
                                    var44 = (var45 - 100) * 327680 + 255 - (var45 - 100) * 5;
                                 }
                              }

                              if(Client.field1056[var37] == 11) {
                                 var45 = 150 - Client.field952[var37];
                                 if(var45 < 50) {
                                    var44 = 16777215 - var45 * 327685;
                                 } else if(var45 < 100) {
                                    var44 = (var45 - 50) * 327685 + '\uff00';
                                 } else if(var45 < 150) {
                                    var44 = 16777215 - (var45 - 100) * 327680;
                                 }
                              }

                              if(Client.field925[var37] == 0) {
                                 class40.field531.method4817(var43, var19 + Client.field995, var20 + Client.field996, var44, 0);
                              }

                              if(Client.field925[var37] == 1) {
                                 class40.field531.method4819(var43, var19 + Client.field995, Client.field996 + var20, var44, 0, Client.field1152);
                              }

                              if(Client.field925[var37] == 2) {
                                 class40.field531.method4820(var43, Client.field995 + var19, var20 + Client.field996, var44, 0, Client.field1152);
                              }

                              if(Client.field925[var37] == 3) {
                                 class40.field531.method4821(var43, var19 + Client.field995, var20 + Client.field996, var44, 0, Client.field1152, 150 - Client.field952[var37]);
                              }

                              if(Client.field925[var37] == 4) {
                                 var45 = (150 - Client.field952[var37]) * (class40.field531.method4809(var43) + 100) / 150;
                                 Rasterizer2D.method4999(var19 + Client.field995 - 50, var20, Client.field995 + var19 + 50, var22 + var20);
                                 class40.field531.method4889(var43, var19 + Client.field995 + 50 - var45, var20 + Client.field996, var44, 0);
                                 Rasterizer2D.method4998(var19, var20, var19 + var21, var20 + var22);
                              }

                              if(Client.field925[var37] == 5) {
                                 var45 = 150 - Client.field952[var37];
                                 int var46 = 0;
                                 if(var45 < 25) {
                                    var46 = var45 - 25;
                                 } else if(var45 > 125) {
                                    var46 = var45 - 125;
                                 }

                                 Rasterizer2D.method4999(var19, Client.field996 + var20 - class40.field531.field3638 - 1, var21 + var19, Client.field996 + var20 + 5);
                                 class40.field531.method4817(var43, Client.field995 + var19, var46 + Client.field996 + var20, var44, 0);
                                 Rasterizer2D.method4998(var19, var20, var19 + var21, var22 + var20);
                              }
                           } else {
                              class40.field531.method4817(var43, var19 + Client.field995, Client.field996 + var20, 16776960, 0);
                           }
                        }

                        if(Client.field907 == 2) {
                           IndexDataBase.method4269(Client.field913 + (Client.field924 - class166.baseX << 7), Client.field1026 + (Client.field911 - class146.baseY << 7), Client.field1133 * 2);
                           if(Client.field995 > -1 && Client.gameCycle % 20 < 10) {
                              class10.field261[0].method5207(var19 + Client.field995 - 12, Client.field996 + var20 - 28);
                           }
                        }

                        ((TextureProvider)class136.field2017).method2416(Client.field966);
                        class40.method555(var19, var20, var21, var22);
                        class12.cameraX = var51;
                        class40.cameraZ = var53;
                        class12.cameraY = var27;
                        class36.cameraPitch = var28;
                        class244.cameraYaw = var29;
                        if(Client.field898) {
                           byte var71 = 0;
                           var34 = var71 + class238.field3244 + class238.field3246;
                           if(var34 == 0) {
                              Client.field898 = false;
                           }
                        }

                        if(Client.field898) {
                           Rasterizer2D.method5042(var19, var20, var21, var22, 0);
                           WorldMapData.method349("Loading - please wait.", false);
                        }

                        Client.field1095[var10.boundsIndex] = true;
                        Rasterizer2D.method4998(var2, var3, var4, var5);
                        continue;
                     }

                     class210 var74;
                     if(var10.contentType == 1338) {
                        Ignore.method1118();
                        var74 = var10.method4067(false);
                        if(var74 != null) {
                           Rasterizer2D.method4998(var12, var13, var74.field2591 + var12, var74.field2590 + var13);
                           if(Client.field1017 != 2 && Client.field1017 != 5) {
                              var20 = Client.mapScale + Client.mapAngle & 2047;
                              var21 = XGrandExchangeOffer.localPlayer.x / 32 + 48;
                              var22 = 464 - XGrandExchangeOffer.localPlayer.y / 32;
                              class172.field2368.method5143(var12, var13, var74.field2591, var74.field2590, var21, var22, var20, Client.mapScaleDelta + 256, var74.field2587, var74.field2589);

                              for(var49 = 0; var49 < Client.field1118; ++var49) {
                                 var24 = Client.field918[var49] * 4 + 2 - XGrandExchangeOffer.localPlayer.x / 32;
                                 var51 = Client.field1064[var49] * 4 + 2 - XGrandExchangeOffer.localPlayer.y / 32;
                                 class54.method787(var12, var13, var24, var51, Client.field1124[var49], var74);
                              }

                              var49 = 0;

                              while(true) {
                                 if(var49 >= 104) {
                                    for(var49 = 0; var49 < Client.field928; ++var49) {
                                       NPC var78 = Client.cachedNPCs[Client.field1013[var49]];
                                       if(var78 != null && var78.vmethod1721()) {
                                          NPCComposition var61 = var78.composition;
                                          if(var61 != null && var61.configs != null) {
                                             var61 = var61.method4705();
                                          }

                                          if(var61 != null && var61.isMinimapVisible && var61.field3575) {
                                             var53 = var78.x / 32 - XGrandExchangeOffer.localPlayer.x / 32;
                                             var27 = var78.y / 32 - XGrandExchangeOffer.localPlayer.y / 32;
                                             class54.method787(var12, var13, var53, var27, Preferences.field1282[1], var74);
                                          }
                                       }
                                    }

                                    var49 = class96.field1489;
                                    int[] var79 = class96.field1496;

                                    for(var51 = 0; var51 < var49; ++var51) {
                                       Player var26 = Client.cachedPlayers[var79[var51]];
                                       if(var26 != null && var26.vmethod1721() && !var26.field867 && XGrandExchangeOffer.localPlayer != var26) {
                                          var27 = var26.x / 32 - XGrandExchangeOffer.localPlayer.x / 32;
                                          var28 = var26.y / 32 - XGrandExchangeOffer.localPlayer.y / 32;
                                          boolean var69 = false;
                                          if(class158.method3025(var26.name, true)) {
                                             var69 = true;
                                          }

                                          boolean var30 = false;

                                          for(var31 = 0; var31 < WorldMapType0.clanChatCount; ++var31) {
                                             if(var26.name.equals(ClassInfo.clanMembers[var31].username)) {
                                                var30 = true;
                                                break;
                                             }
                                          }

                                          boolean var68 = false;
                                          if(XGrandExchangeOffer.localPlayer.team != 0 && var26.team != 0 && var26.team == XGrandExchangeOffer.localPlayer.team) {
                                             var68 = true;
                                          }

                                          if(var69) {
                                             class54.method787(var12, var13, var27, var28, Preferences.field1282[3], var74);
                                          } else if(var68) {
                                             class54.method787(var12, var13, var27, var28, Preferences.field1282[4], var74);
                                          } else if(var30) {
                                             class54.method787(var12, var13, var27, var28, Preferences.field1282[5], var74);
                                          } else {
                                             class54.method787(var12, var13, var27, var28, Preferences.field1282[2], var74);
                                          }
                                       }
                                    }

                                    if(Client.field907 != 0 && Client.gameCycle % 20 < 10) {
                                       if(Client.field907 == 1 && Client.field908 >= 0 && Client.field908 < Client.cachedNPCs.length) {
                                          var63 = Client.cachedNPCs[Client.field908];
                                          if(var63 != null) {
                                             var53 = var63.x / 32 - XGrandExchangeOffer.localPlayer.x / 32;
                                             var27 = var63.y / 32 - XGrandExchangeOffer.localPlayer.y / 32;
                                             class45.method675(var12, var13, var53, var27, CombatInfoListHolder.field1347[1], var74);
                                          }
                                       }

                                       if(Client.field907 == 2) {
                                          var51 = Client.field924 * 4 - class166.baseX * 4 + 2 - XGrandExchangeOffer.localPlayer.x / 32;
                                          var53 = Client.field911 * 4 - class146.baseY * 4 + 2 - XGrandExchangeOffer.localPlayer.y / 32;
                                          class45.method675(var12, var13, var51, var53, CombatInfoListHolder.field1347[1], var74);
                                       }

                                       if(Client.field907 == 10 && Client.field909 >= 0 && Client.field909 < Client.cachedPlayers.length) {
                                          var64 = Client.cachedPlayers[Client.field909];
                                          if(var64 != null) {
                                             var53 = var64.x / 32 - XGrandExchangeOffer.localPlayer.x / 32;
                                             var27 = var64.y / 32 - XGrandExchangeOffer.localPlayer.y / 32;
                                             class45.method675(var12, var13, var53, var27, CombatInfoListHolder.field1347[1], var74);
                                          }
                                       }
                                    }

                                    if(Client.flagX != 0) {
                                       var51 = Client.flagX * 4 + 2 - XGrandExchangeOffer.localPlayer.x / 32;
                                       var53 = Client.flagY * 4 + 2 - XGrandExchangeOffer.localPlayer.y / 32;
                                       class54.method787(var12, var13, var51, var53, CombatInfoListHolder.field1347[0], var74);
                                    }

                                    if(!XGrandExchangeOffer.localPlayer.field867) {
                                       Rasterizer2D.method5042(var74.field2591 / 2 + var12 - 1, var13 + var74.field2590 / 2 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var24 = 0; var24 < 104; ++var24) {
                                    Deque var25 = Client.groundItemDeque[Sequence.plane][var49][var24];
                                    if(var25 != null) {
                                       var53 = var49 * 4 + 2 - XGrandExchangeOffer.localPlayer.x / 32;
                                       var27 = var24 * 4 + 2 - XGrandExchangeOffer.localPlayer.y / 32;
                                       class54.method787(var12, var13, var53, var27, Preferences.field1282[0], var74);
                                    }
                                 }

                                 ++var49;
                              }
                           } else {
                              Rasterizer2D.method5020(var12, var13, 0, var74.field2587, var74.field2589);
                           }

                           Client.field1096[var11] = true;
                        }

                        Rasterizer2D.method4998(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        var74 = var10.method4067(false);
                        if(var74 != null) {
                           if(Client.field1017 < 3) {
                              class166.field2304.method5143(var12, var13, var74.field2591, var74.field2590, 25, 25, Client.mapAngle, 256, var74.field2587, var74.field2589);
                           } else {
                              Rasterizer2D.method5020(var12, var13, 0, var74.field2587, var74.field2589);
                           }
                        }

                        Rasterizer2D.method4998(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1400) {
                        class83.field1325.extractWorldmap(var12, var13, var10.width, var10.height, Client.gameCycle);
                     }

                     if(var10.contentType == 1401) {
                        class83.field1325.extractData(var12, var13, var10.width, var10.height);
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && class149.method2945(var10) && Player.field868 != var10) {
                        continue;
                     }

                     if(!var10.hasScript) {
                        if(var10.scrollY > var10.scrollHeight - var10.height) {
                           var10.scrollY = var10.scrollHeight - var10.height;
                        }

                        if(var10.scrollY < 0) {
                           var10.scrollY = 0;
                        }
                     }

                     gameDraw(var0, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     if(var10.children != null) {
                        gameDraw(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     }

                     WidgetNode var47 = (WidgetNode)Client.componentTable.method3615((long)var10.id);
                     if(var47 != null) {
                        class13.method66(var47.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.method4998(var2, var3, var4, var5);
                     class136.method2651();
                  }

                  if(Client.isResized || Client.field1097[var11] || Client.field1102 > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        var19 = var10.width + var12;
                        var20 = var10.scrollY;
                        var21 = var10.height;
                        var22 = var10.scrollHeight;
                        class50.field642[0].method5101(var19, var13);
                        class50.field642[1].method5101(var19, var13 + var21 - 16);
                        Rasterizer2D.method5042(var19, var13 + 16, 16, var21 - 32, Client.field940);
                        var49 = (var21 - 32) * var21 / var22;
                        if(var49 < 8) {
                           var49 = 8;
                        }

                        var24 = var20 * (var21 - 32 - var49) / (var22 - var21);
                        Rasterizer2D.method5042(var19, var24 + var13 + 16, 16, var49, Client.field1015);
                        Rasterizer2D.method5076(var19, var24 + var13 + 16, var49, Client.field969);
                        Rasterizer2D.method5076(var19 + 1, var13 + 16 + var24, var49, Client.field969);
                        Rasterizer2D.method5014(var19, var13 + 16 + var24, 16, Client.field969);
                        Rasterizer2D.method5014(var19, var13 + 17 + var24, 16, Client.field969);
                        Rasterizer2D.method5076(var19 + 15, var13 + 16 + var24, var49, Client.field946);
                        Rasterizer2D.method5076(var19 + 14, var24 + var13 + 17, var49 - 1, Client.field946);
                        Rasterizer2D.method5014(var19, var24 + var13 + 15 + var49, 16, Client.field946);
                        Rasterizer2D.method5014(var19 + 1, var24 + var13 + 14 + var49, 15, Client.field946);
                     }

                     if(var10.type != 1) {
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2638; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = var12 + var21 * (var10.paddingX + 32);
                                 var49 = var13 + (var10.paddingY + 32) * var20;
                                 if(var19 < 20) {
                                    var22 += var10.field2710[var19];
                                    var49 += var10.field2711[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(var10.field2712 != null && var19 < 20) {
                                       SpritePixels var77 = var10.method4087(var19);
                                       if(var77 != null) {
                                          var77.method5207(var22, var49);
                                       } else if(Widget.field2664) {
                                          class219.method4130(var10);
                                       }
                                    }
                                 } else {
                                    boolean var66 = false;
                                    boolean var83 = false;
                                    var53 = var10.itemIds[var19] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var49 + 32 > var3 && var49 < var5 || class20.field323 == var10 && var19 == Client.field1105) {
                                       SpritePixels var58;
                                       if(Client.field1043 == 1 && WorldMapType0.field612 == var19 && var10.id == class214.field2622) {
                                          var58 = class28.createSprite(var53, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var58 = class28.createSprite(var53, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(var58 != null) {
                                          if(class20.field323 == var10 && Client.field1105 == var19) {
                                             var24 = class59.field721 - Client.field993;
                                             var51 = class59.field722 - Client.field970;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var51 < 5 && var51 > -5) {
                                                var51 = 0;
                                             }

                                             if(Client.field1090 < 5) {
                                                var24 = 0;
                                                var51 = 0;
                                             }

                                             var58.method5138(var24 + var22, var49 + var51, 128);
                                             if(var1 != -1) {
                                                Widget var55 = var0[var1 & '\uffff'];
                                                if(var49 + var51 < Rasterizer2D.field3746 && var55.scrollY > 0) {
                                                   var29 = Client.field966 * (Rasterizer2D.field3746 - var49 - var51) / 3;
                                                   if(var29 > Client.field966 * 10) {
                                                      var29 = Client.field966 * 10;
                                                   }

                                                   if(var29 > var55.scrollY) {
                                                      var29 = var55.scrollY;
                                                   }

                                                   var55.scrollY -= var29;
                                                   Client.field970 += var29;
                                                   class219.method4130(var55);
                                                }

                                                if(var49 + var51 + 32 > Rasterizer2D.field3750 && var55.scrollY < var55.scrollHeight - var55.height) {
                                                   var29 = Client.field966 * (var49 + var51 + 32 - Rasterizer2D.field3750) / 3;
                                                   if(var29 > Client.field966 * 10) {
                                                      var29 = Client.field966 * 10;
                                                   }

                                                   if(var29 > var55.scrollHeight - var55.height - var55.scrollY) {
                                                      var29 = var55.scrollHeight - var55.height - var55.scrollY;
                                                   }

                                                   var55.scrollY += var29;
                                                   Client.field970 -= var29;
                                                   class219.method4130(var55);
                                                }
                                             }
                                          } else if(var10 == class37.field507 && var19 == Client.field1002) {
                                             var58.method5138(var22, var49, 128);
                                          } else {
                                             var58.method5207(var22, var49);
                                          }
                                       } else {
                                          class219.method4130(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class46.method710(var10)) {
                              var19 = var10.field2668;
                              if(Player.field868 == var10 && var10.field2670 != 0) {
                                 var19 = var10.field2670;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(var10 == Player.field868 && var10.field2706 != 0) {
                                 var19 = var10.field2706;
                              }
                           }

                           if(var10.field2671) {
                              switch(var10.field2672.field3761) {
                              case 1:
                                 Rasterizer2D.method5007(var12, var13, var10.width, var10.height, var10.textColor, var10.field2668, 256 - (var10.opacity & 255), 256 - (var10.field2734 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method5073(var12, var13, var10.width, var10.height, var10.textColor, var10.field2668, 256 - (var10.opacity & 255), 256 - (var10.field2734 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method5063(var12, var13, var10.width, var10.height, var10.textColor, var10.field2668, 256 - (var10.opacity & 255), 256 - (var10.field2734 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method5011(var12, var13, var10.width, var10.height, var10.textColor, var10.field2668, 256 - (var10.opacity & 255), 256 - (var10.field2734 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method5042(var12, var13, var10.width, var10.height, var19);
                                 } else {
                                    Rasterizer2D.method5048(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.method5012(var12, var13, var10.width, var10.height, var19);
                           } else {
                              Rasterizer2D.method5013(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                           }
                        } else {
                           Font var72;
                           if(var10.type == 4) {
                              var72 = var10.method4053();
                              if(var72 == null) {
                                 if(Widget.field2664) {
                                    class219.method4130(var10);
                                 }
                              } else {
                                 String var85 = var10.text;
                                 if(class46.method710(var10)) {
                                    var20 = var10.field2668;
                                    if(Player.field868 == var10 && var10.field2670 != 0) {
                                       var20 = var10.field2670;
                                    }

                                    if(var10.field2703.length() > 0) {
                                       var85 = var10.field2703;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == Player.field868 && var10.field2706 != 0) {
                                       var20 = var10.field2706;
                                    }
                                 }

                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var76 = class51.getItemDefinition(var10.itemId);
                                    var85 = var76.name;
                                    if(var85 == null) {
                                       var85 = "null";
                                    }

                                    if((var76.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var85 = class82.method1610(16748608) + var85 + "</col>" + " " + 'x' + class7.method30(var10.itemQuantity);
                                    }
                                 }

                                 if(var10 == Client.field1054) {
                                    Object var10000 = null;
                                    var85 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var85 = class8.method33(var85, var10);
                                 }

                                 var72.method4818(var85, var12, var13, var10.width, var10.height, var20, var10.field2707?0:-1, var10.field2705, var10.field2772, var10.field2704);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var73;
                              if(!var10.hasScript) {
                                 var73 = var10.method4052(class46.method710(var10));
                                 if(var73 != null) {
                                    var73.method5207(var12, var13);
                                 } else if(Widget.field2664) {
                                    class219.method4130(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var73 = class28.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2770, false);
                                 } else {
                                    var73 = var10.method4052(false);
                                 }

                                 if(var73 == null) {
                                    if(Widget.field2664) {
                                       class219.method4130(var10);
                                    }
                                 } else {
                                    var20 = var73.maxWidth;
                                    var21 = var73.maxHeight;
                                    if(!var10.field2723) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.field2679 != 0) {
                                          var73.method5121(var12 + var10.width / 2, var10.height / 2 + var13, var10.field2679, var22);
                                       } else if(var14 != 0) {
                                          var73.method5140(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var10.width == var20 && var21 == var10.height) {
                                          var73.method5207(var12, var13);
                                       } else {
                                          var73.method5134(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.method4999(var12, var13, var12 + var10.width, var10.height + var13);
                                       var22 = (var10.width + (var20 - 1)) / var20;
                                       var49 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var51 = 0; var51 < var49; ++var51) {
                                             if(var10.field2679 != 0) {
                                                var73.method5121(var24 * var20 + var12 + var20 / 2, var21 / 2 + var13 + var21 * var51, var10.field2679, 4096);
                                             } else if(var14 != 0) {
                                                var73.method5138(var20 * var24 + var12, var21 * var51 + var13, 256 - (var14 & 255));
                                             } else {
                                                var73.method5207(var24 * var20 + var12, var51 * var21 + var13);
                                             }
                                          }
                                       }

                                       Rasterizer2D.method4998(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var23;
                              if(var10.type == 6) {
                                 boolean var59 = class46.method710(var10);
                                 if(var59) {
                                    var20 = var10.field2675;
                                 } else {
                                    var20 = var10.field2689;
                                 }

                                 Model var80 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var23 = class51.getItemDefinition(var10.itemId);
                                    if(var23 != null) {
                                       var23 = var23.method4637(var10.itemQuantity);
                                       var80 = var23.getModel(1);
                                       if(var80 != null) {
                                          var80.method2575();
                                          var22 = var80.modelHeight / 2;
                                       } else {
                                          class219.method4130(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var80 = Client.field1162.method4012((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var80 = XGrandExchangeOffer.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var80 = var10.method4055((Sequence)null, -1, var59, XGrandExchangeOffer.localPlayer.composition);
                                    if(var80 == null && Widget.field2664) {
                                       class219.method4130(var10);
                                    }
                                 } else {
                                    Sequence var62 = class165.getAnimation(var20);
                                    var80 = var10.method4055(var62, var10.field2773, var59, XGrandExchangeOffer.localPlayer.composition);
                                    if(var80 == null && Widget.field2664) {
                                       class219.method4130(var10);
                                    }
                                 }

                                 class136.method2625(var12 + var10.width / 2, var13 + var10.height / 2);
                                 var49 = var10.field2696 * class136.SINE[var10.rotationX] >> 16;
                                 var24 = var10.field2696 * class136.COSINE[var10.rotationX] >> 16;
                                 if(var80 != null) {
                                    if(!var10.hasScript) {
                                       var80.method2552(0, var10.rotationZ, 0, var10.rotationX, 0, var49, var24);
                                    } else {
                                       var80.method2575();
                                       if(var10.field2699) {
                                          var80.method2553(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2752, var49 + var22 + var10.field2692, var24 + var10.field2692, var10.field2696);
                                       } else {
                                          var80.method2552(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2752, var22 + var49 + var10.field2692, var10.field2692 + var24);
                                       }
                                    }
                                 }

                                 class136.method2624();
                              } else {
                                 if(var10.type == 7) {
                                    var72 = var10.method4053();
                                    if(var72 == null) {
                                       if(Widget.field2664) {
                                          class219.method4130(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2638; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var23 = class51.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var50;
                                             if(var23.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var50 = class82.method1610(16748608) + var23.name + "</col>";
                                             } else {
                                                var50 = class82.method1610(16748608) + var23.name + "</col>" + " " + 'x' + class7.method30(var10.itemQuantities[var20]);
                                             }

                                             var51 = var22 * (var10.paddingX + 115) + var12;
                                             var53 = var13 + (var10.paddingY + 12) * var21;
                                             if(var10.field2705 == 0) {
                                                var72.method4889(var50, var51, var53, var10.textColor, var10.field2707?0:-1);
                                             } else if(var10.field2705 == 1) {
                                                var72.method4817(var50, var10.width / 2 + var51, var53, var10.textColor, var10.field2707?0:-1);
                                             } else {
                                                var72.method4816(var50, var51 + var10.width - 1, var53, var10.textColor, var10.field2707?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == NPCComposition.field3579 && Client.field1042 == Client.field1120) {
                                    var19 = 0;
                                    var20 = 0;
                                    Font var52 = MessageNode.field845;
                                    String var48 = var10.text;

                                    String var60;
                                    for(var48 = class8.method33(var48, var10); var48.length() > 0; var20 += var52.field3638 + 1) {
                                       var24 = var48.indexOf("<br>");
                                       if(var24 != -1) {
                                          var60 = var48.substring(0, var24);
                                          var48 = var48.substring(var24 + 4);
                                       } else {
                                          var60 = var48;
                                          var48 = "";
                                       }

                                       var51 = var52.method4809(var60);
                                       if(var51 > var19) {
                                          var19 = var51;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var24 = var10.width + var12 - 5 - var19;
                                    var51 = var10.height + var13 + 5;
                                    if(var24 < var12 + 5) {
                                       var24 = var12 + 5;
                                    }

                                    if(var24 + var19 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if(var51 + var20 > var5) {
                                       var51 = var5 - var20;
                                    }

                                    Rasterizer2D.method5042(var24, var51, var19, var20, 16777120);
                                    Rasterizer2D.method5012(var24, var51, var19, var20, 0);
                                    var48 = var10.text;
                                    var53 = var51 + var52.field3638 + 2;

                                    for(var48 = class8.method33(var48, var10); var48.length() > 0; var53 += var52.field3638 + 1) {
                                       var27 = var48.indexOf("<br>");
                                       if(var27 != -1) {
                                          var60 = var48.substring(0, var27);
                                          var48 = var48.substring(var27 + 4);
                                       } else {
                                          var60 = var48;
                                          var48 = "";
                                       }

                                       var52.method4889(var60, var24 + 3, var53, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2676) {
                                       var19 = var12;
                                       var20 = var10.height + var13;
                                       var21 = var10.width + var12;
                                       var22 = var13;
                                    } else {
                                       var19 = var12;
                                       var20 = var13;
                                       var21 = var10.width + var12;
                                       var22 = var10.height + var13;
                                    }

                                    if(var10.field2669 == 1) {
                                       Rasterizer2D.method5055(var19, var20, var21, var22, var10.textColor);
                                    } else {
                                       class59.method998(var19, var20, var21, var22, var10.textColor, var10.field2669);
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

   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1264206646"
   )
   static final void method352() {
      class112.method2130(false);
      Client.field1044 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < WorldMapData.field461.length; ++var1) {
         if(class168.field2317[var1] != -1 && WorldMapData.field461[var1] == null) {
            WorldMapData.field461[var1] = class34.indexMaps.getConfigData(class168.field2317[var1], 0);
            if(WorldMapData.field461[var1] == null) {
               var0 = false;
               ++Client.field1044;
            }
         }

         if(class100.field1545[var1] != -1 && class50.field619[var1] == null) {
            class50.field619[var1] = class34.indexMaps.getConfigData(class100.field1545[var1], 0, class22.xteaKeys[var1]);
            if(class50.field619[var1] == null) {
               var0 = false;
               ++Client.field1044;
            }
         }
      }

      if(!var0) {
         Client.field949 = 1;
      } else {
         Client.field947 = 0;
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
         for(var1 = 0; var1 < WorldMapData.field461.length; ++var1) {
            byte[] var2 = class50.field619[var1];
            if(var2 != null) {
               var3 = (RSCanvas.mapRegions[var1] >> 8) * 64 - class166.baseX;
               var4 = (RSCanvas.mapRegions[var1] & 255) * 64 - class146.baseY;
               if(Client.isDynamicRegion) {
                  var3 = 10;
                  var4 = 10;
               }

               boolean var7 = true;
               var8 = new Buffer(var2);
               var9 = -1;

               label588:
               while(true) {
                  var10 = var8.method3212();
                  if(var10 == 0) {
                     var0 &= var7;
                     break;
                  }

                  var9 += var10;
                  var11 = 0;
                  boolean var12 = false;

                  while(true) {
                     while(!var12) {
                        var13 = var8.method3212();
                        if(var13 == 0) {
                           continue label588;
                        }

                        var11 += var13 - 1;
                        var14 = var11 & 63;
                        var15 = var11 >> 6 & 63;
                        var16 = var8.readUnsignedByte() >> 2;
                        var17 = var3 + var15;
                        var18 = var4 + var14;
                        if(var17 > 0 && var18 > 0 && var17 < 103 && var18 < 103) {
                           ObjectComposition var19 = class43.getObjectDefinition(var9);
                           if(var16 != 22 || !Client.field895 || var19.field3456 != 0 || var19.field3446 == 1 || var19.field3461) {
                              if(!var19.method4583()) {
                                 ++Client.field947;
                                 var7 = false;
                              }

                              var12 = true;
                           }
                        }
                     }

                     var13 = var8.method3212();
                     if(var13 == 0) {
                        break;
                     }

                     var8.readUnsignedByte();
                  }
               }
            }
         }

         if(!var0) {
            Client.field949 = 2;
         } else {
            if(Client.field949 != 0) {
               WorldMapData.method349("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            Ignore.method1118();
            class170.method3171();
            Ignore.method1118();
            class46.region.method2709();
            Ignore.method1118();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].method3073();
            }

            int var23;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var23 = 0; var23 < 104; ++var23) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class61.tileSettings[var1][var23][var3] = 0;
                  }
               }
            }

            Ignore.method1118();
            class61.field752 = 99;
            class90.underlayIds = new byte[4][104][104];
            class61.overlayIds = new byte[4][104][104];
            class61.overlayPaths = new byte[4][104][104];
            class61.overlayRotations = new byte[4][104][104];
            class61.field754 = new int[4][105][105];
            class18.field315 = new byte[4][105][105];
            class61.field746 = new int[105][105];
            class89.field1387 = new int[104];
            class51.field650 = new int[104];
            class249.field3371 = new int[104];
            class11.field264 = new int[104];
            class61.field745 = new int[104];
            var1 = WorldMapData.field461.length;

            for(class82 var30 = (class82)class82.field1299.method3660(); var30 != null; var30 = (class82)class82.field1299.method3661()) {
               if(var30.field1298 != null) {
                  class164.field2291.method1910(var30.field1298);
                  var30.field1298 = null;
               }

               if(var30.field1303 != null) {
                  class164.field2291.method1910(var30.field1303);
                  var30.field1303 = null;
               }
            }

            class82.field1299.method3656();
            class112.method2130(true);
            int var5;
            int var33;
            if(!Client.isDynamicRegion) {
               byte[] var25;
               for(var23 = 0; var23 < var1; ++var23) {
                  var3 = (RSCanvas.mapRegions[var23] >> 8) * 64 - class166.baseX;
                  var4 = (RSCanvas.mapRegions[var23] & 255) * 64 - class146.baseY;
                  var25 = WorldMapData.field461[var23];
                  if(var25 != null) {
                     Ignore.method1118();
                     ChatMessages.method1855(var25, var3, var4, class51.field646 * 8 - 48, DecorativeObject.field2158 * 8 - 48, Client.collisionMaps);
                  }
               }

               for(var23 = 0; var23 < var1; ++var23) {
                  var3 = (RSCanvas.mapRegions[var23] >> 8) * 64 - class166.baseX;
                  var4 = (RSCanvas.mapRegions[var23] & 255) * 64 - class146.baseY;
                  var25 = WorldMapData.field461[var23];
                  if(var25 == null && DecorativeObject.field2158 < 800) {
                     Ignore.method1118();
                     Item.method1796(var3, var4, 64, 64);
                  }
               }

               class112.method2130(true);

               for(var23 = 0; var23 < var1; ++var23) {
                  byte[] var26 = class50.field619[var23];
                  if(var26 != null) {
                     var4 = (RSCanvas.mapRegions[var23] >> 8) * 64 - class166.baseX;
                     var5 = (RSCanvas.mapRegions[var23] & 255) * 64 - class146.baseY;
                     Ignore.method1118();
                     Region var27 = class46.region;
                     CollisionData[] var28 = Client.collisionMaps;
                     var8 = new Buffer(var26);
                     var9 = -1;

                     while(true) {
                        var10 = var8.method3212();
                        if(var10 == 0) {
                           break;
                        }

                        var9 += var10;
                        var11 = 0;

                        while(true) {
                           var33 = var8.method3212();
                           if(var33 == 0) {
                              break;
                           }

                           var11 += var33 - 1;
                           var13 = var11 & 63;
                           var14 = var11 >> 6 & 63;
                           var15 = var11 >> 12;
                           var16 = var8.readUnsignedByte();
                           var17 = var16 >> 2;
                           var18 = var16 & 3;
                           int var24 = var4 + var14;
                           int var20 = var13 + var5;
                           if(var24 > 0 && var20 > 0 && var24 < 103 && var20 < 103) {
                              int var21 = var15;
                              if((class61.tileSettings[1][var24][var20] & 2) == 2) {
                                 var21 = var15 - 1;
                              }

                              CollisionData var22 = null;
                              if(var21 >= 0) {
                                 var22 = var28[var21];
                              }

                              class36.method500(var15, var24, var20, var9, var18, var17, var27, var22);
                           }
                        }
                     }
                  }
               }
            }

            int var6;
            int var29;
            int var32;
            if(Client.isDynamicRegion) {
               for(var23 = 0; var23 < 4; ++var23) {
                  Ignore.method1118();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var31 = false;
                        var6 = Client.field1076[var23][var3][var4];
                        if(var6 != -1) {
                           var32 = var6 >> 24 & 3;
                           var29 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = var10 / 8 + (var9 / 8 << 8);

                           for(var33 = 0; var33 < RSCanvas.mapRegions.length; ++var33) {
                              if(RSCanvas.mapRegions[var33] == var11 && WorldMapData.field461[var33] != null) {
                                 class11.method46(WorldMapData.field461[var33], var23, var3 * 8, var4 * 8, var32, (var9 & 7) * 8, (var10 & 7) * 8, var29, Client.collisionMaps);
                                 var31 = true;
                                 break;
                              }
                           }
                        }

                        if(!var31) {
                           class23.method162(var23, var3 * 8, var4 * 8);
                        }
                     }
                  }
               }

               for(var23 = 0; var23 < 13; ++var23) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.field1076[0][var23][var3];
                     if(var4 == -1) {
                        Item.method1796(var23 * 8, var3 * 8, 8, 8);
                     }
                  }
               }

               class112.method2130(true);

               for(var23 = 0; var23 < 4; ++var23) {
                  Ignore.method1118();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        var5 = Client.field1076[var23][var3][var4];
                        if(var5 != -1) {
                           var6 = var5 >> 24 & 3;
                           var32 = var5 >> 1 & 3;
                           var29 = var5 >> 14 & 1023;
                           var9 = var5 >> 3 & 2047;
                           var10 = var9 / 8 + (var29 / 8 << 8);

                           for(var11 = 0; var11 < RSCanvas.mapRegions.length; ++var11) {
                              if(var10 == RSCanvas.mapRegions[var11] && class50.field619[var11] != null) {
                                 class44.method647(class50.field619[var11], var23, var3 * 8, var4 * 8, var6, (var29 & 7) * 8, (var9 & 7) * 8, var32, class46.region, Client.collisionMaps);
                                 break;
                              }
                           }
                        }
                     }
                  }
               }
            }

            class112.method2130(true);
            class170.method3171();
            Ignore.method1118();
            class87.method1739(class46.region, Client.collisionMaps);
            class112.method2130(true);
            var23 = class61.field752;
            if(var23 > Sequence.plane) {
               var23 = Sequence.plane;
            }

            if(var23 < Sequence.plane - 1) {
               var23 = Sequence.plane - 1;
            }

            if(Client.field895) {
               class46.region.method2710(class61.field752);
            } else {
               class46.region.method2710(0);
            }

            for(var3 = 0; var3 < 104; ++var3) {
               for(var4 = 0; var4 < 104; ++var4) {
                  class37.groundItemSpawned(var3, var4);
               }
            }

            Ignore.method1118();
            WorldMapType2.method512();
            ObjectComposition.field3478.reset();
            if(class24.field356.method873()) {
               Client.secretPacketBuffer1.putOpcode(169);
               Client.secretPacketBuffer1.putInt(1057001181);
            }

            if(!Client.isDynamicRegion) {
               var3 = (class51.field646 - 6) / 8;
               var4 = (class51.field646 + 6) / 8;
               var5 = (DecorativeObject.field2158 - 6) / 8;
               var6 = (DecorativeObject.field2158 + 6) / 8;

               for(var32 = var3 - 1; var32 <= var4 + 1; ++var32) {
                  for(var29 = var5 - 1; var29 <= var6 + 1; ++var29) {
                     if(var32 < var3 || var32 > var4 || var29 < var5 || var29 > var6) {
                        class34.indexMaps.method4235("m" + var32 + "_" + var29);
                        class34.indexMaps.method4235("l" + var32 + "_" + var29);
                     }
                  }
               }
            }

            class12.setGameState(30);
            Ignore.method1118();
            RSCanvas.method779();
            Client.secretPacketBuffer1.putOpcode(49);
            class234.field3197.vmethod3024();

            for(var3 = 0; var3 < 32; ++var3) {
               GameEngine.field690[var3] = 0L;
            }

            for(var3 = 0; var3 < 32; ++var3) {
               GameEngine.field691[var3] = 0L;
            }

            class64.field786 = 0;
         }
      }
   }

   class33(String var1, int var2, int var3, class24 var4) {
      this.field468 = var1;
      this.field465 = var2;
      this.field464 = var3;
      this.field467 = var4;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "-669695729"
   )
   static void method353(int var0, boolean var1, int var2, boolean var3) {
      if(World.worldList != null) {
         class208.method3966(0, World.worldList.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "1"
   )
   static final int method354(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var0 & 16711935) * var3 + (var1 & 16711935) * var2 & -16711936) + (var2 * (var1 & '\uff00') + (var0 & '\uff00') * var3 & 16711680) >> 8;
   }
}
