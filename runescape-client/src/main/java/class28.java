import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class28 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1250293227
   )
   public static int field666;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 862215419
   )
   public static int field670;
   @ObfuscatedName("ci")
   static class146 field671;
   @ObfuscatedName("au")
   static class146 field675;
   @ObfuscatedName("eh")
   static SpritePixels field678;

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIB)V",
      garbageValue = "-4"
   )
   static final void method659(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(null != var9 && (!var9.field2815 || var9.type == 0 || var9.field2918 || FrameMap.method2356(var9) != 0 || Client.field388 == var9 || var9.contentType == 1338) && var1 == var9.parentId && (!var9.field2815 || !class5.method56(var9))) {
            int var10 = var9.relativeX + var6;
            int var11 = var9.relativeY + var7;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               var18 = var9.width + var10;
               var19 = var11 + var9.height;
               if(var18 < var10) {
                  var16 = var18;
                  var18 = var10;
               }

               if(var19 < var11) {
                  var17 = var19;
                  var19 = var11;
               }

               ++var18;
               ++var19;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var18 < var4?var18:var4;
               var15 = var19 < var5?var19:var5;
            } else {
               var16 = var9.width + var10;
               var17 = var9.height + var11;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == Client.field453) {
               Client.field461 = true;
               Client.field462 = var10;
               Client.field445 = var11;
            }

            if(!var9.field2815 || var12 < var14 && var13 < var15) {
               var16 = class143.field2200;
               var17 = class143.field2204;
               if(class143.field2206 != 0) {
                  var16 = class143.field2207;
                  var17 = class143.field2196;
               }

               int var20;
               int var21;
               int var22;
               int var23;
               int var24;
               int var27;
               int var29;
               int var35;
               int var61;
               if(var9.contentType == 1337) {
                  if(!Client.field287 && !Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     if(Client.field497 == 0 && !Client.field435) {
                        class5.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var18 = -1;
                     var19 = -1;

                     for(var20 = 0; var20 < Model.field1915; ++var20) {
                        var21 = Model.field1916[var20];
                        var22 = var21 & 127;
                        var23 = var21 >> 7 & 127;
                        var24 = var21 >> 29 & 3;
                        var35 = var21 >> 14 & 32767;
                        if(var21 != var19) {
                           var19 = var21;
                           if(var24 == 2 && Frames.region.method1990(class145.plane, var22, var23, var21) >= 0) {
                              ObjectComposition var50 = Projectile.getObjectDefinition(var35);
                              if(var50.impostorIds != null) {
                                 var50 = var50.getImpostor();
                              }

                              if(var50 == null) {
                                 continue;
                              }

                              if(Client.field497 == 1) {
                                 class5.addMenuEntry("Use", Client.field434 + " " + "->" + " " + class144.method3013('\uffff') + var50.name, 1, var21, var22, var23);
                              } else if(Client.field435) {
                                 if((class145.field2220 & 4) == 4) {
                                    class5.addMenuEntry(Client.field328, Client.field439 + " " + "->" + " " + class144.method3013('\uffff') + var50.name, 2, var21, var22, var23);
                                 }
                              } else {
                                 String[] var36 = var50.actions;
                                 if(Client.field451) {
                                    var36 = class56.method1174(var36);
                                 }

                                 if(var36 != null) {
                                    for(var61 = 4; var61 >= 0; --var61) {
                                       if(var36[var61] != null) {
                                          short var56 = 0;
                                          if(var61 == 0) {
                                             var56 = 3;
                                          }

                                          if(var61 == 1) {
                                             var56 = 4;
                                          }

                                          if(var61 == 2) {
                                             var56 = 5;
                                          }

                                          if(var61 == 3) {
                                             var56 = 6;
                                          }

                                          if(var61 == 4) {
                                             var56 = 1001;
                                          }

                                          class5.addMenuEntry(var36[var61], class144.method3013('\uffff') + var50.name, var56, var21, var22, var23);
                                       }
                                    }
                                 }

                                 class5.addMenuEntry("Examine", class144.method3013('\uffff') + var50.name, 1002, var50.field975 << 14, var22, var23);
                              }
                           }

                           NPC var28;
                           Player var30;
                           int[] var51;
                           if(var24 == 1) {
                              NPC var52 = Client.cachedNPCs[var35];
                              if(null == var52) {
                                 continue;
                              }

                              if(var52.composition.field899 == 1 && (var52.x & 127) == 64 && (var52.y & 127) == 64) {
                                 for(var27 = 0; var27 < Client.field319; ++var27) {
                                    var28 = Client.cachedNPCs[Client.field501[var27]];
                                    if(var28 != null && var28 != var52 && var28.composition.field899 == 1 && var52.x == var28.x && var28.y == var52.y) {
                                       class161.method3193(var28.composition, Client.field501[var27], var22, var23);
                                    }
                                 }

                                 var27 = class34.field777;
                                 var51 = class34.field773;

                                 for(var29 = 0; var29 < var27; ++var29) {
                                    var30 = Client.cachedPlayers[var51[var29]];
                                    if(var30 != null && var52.x == var30.x && var52.y == var30.y) {
                                       class43.method890(var30, var51[var29], var22, var23);
                                    }
                                 }
                              }

                              class161.method3193(var52.composition, var35, var22, var23);
                           }

                           if(var24 == 0) {
                              Player var54 = Client.cachedPlayers[var35];
                              if(var54 == null) {
                                 continue;
                              }

                              if((var54.x & 127) == 64 && (var54.y & 127) == 64) {
                                 for(var27 = 0; var27 < Client.field319; ++var27) {
                                    var28 = Client.cachedNPCs[Client.field501[var27]];
                                    if(null != var28 && var28.composition.field899 == 1 && var54.x == var28.x && var28.y == var54.y) {
                                       class161.method3193(var28.composition, Client.field501[var27], var22, var23);
                                    }
                                 }

                                 var27 = class34.field777;
                                 var51 = class34.field773;

                                 for(var29 = 0; var29 < var27; ++var29) {
                                    var30 = Client.cachedPlayers[var51[var29]];
                                    if(null != var30 && var54 != var30 && var54.x == var30.x && var54.y == var30.y) {
                                       class43.method890(var30, var51[var29], var22, var23);
                                    }
                                 }
                              }

                              if(Client.field411 != var35) {
                                 class43.method890(var54, var35, var22, var23);
                              } else {
                                 var18 = var21;
                              }
                           }

                           if(var24 == 3) {
                              Deque var55 = Client.groundItemDeque[class145.plane][var22][var23];
                              if(null != var55) {
                                 for(Item var60 = (Item)var55.method3852(); var60 != null; var60 = (Item)var55.method3856()) {
                                    ItemComposition var53 = class22.getItemDefinition(var60.id);
                                    if(Client.field497 == 1) {
                                       class5.addMenuEntry("Use", Client.field434 + " " + "->" + " " + class144.method3013(16748608) + var53.name, 16, var60.id, var22, var23);
                                    } else if(Client.field435) {
                                       if((class145.field2220 & 1) == 1) {
                                          class5.addMenuEntry(Client.field328, Client.field439 + " " + "->" + " " + class144.method3013(16748608) + var53.name, 17, var60.id, var22, var23);
                                       }
                                    } else {
                                       String[] var40 = var53.groundActions;
                                       if(Client.field451) {
                                          var40 = class56.method1174(var40);
                                       }

                                       for(int var64 = 4; var64 >= 0; --var64) {
                                          if(var40 != null && var40[var64] != null) {
                                             byte var31 = 0;
                                             if(var64 == 0) {
                                                var31 = 18;
                                             }

                                             if(var64 == 1) {
                                                var31 = 19;
                                             }

                                             if(var64 == 2) {
                                                var31 = 20;
                                             }

                                             if(var64 == 3) {
                                                var31 = 21;
                                             }

                                             if(var64 == 4) {
                                                var31 = 22;
                                             }

                                             class5.addMenuEntry(var40[var64], class144.method3013(16748608) + var53.name, var31, var60.id, var22, var23);
                                          } else if(var64 == 2) {
                                             class5.addMenuEntry("Take", class144.method3013(16748608) + var53.name, 20, var60.id, var22, var23);
                                          }
                                       }

                                       class5.addMenuEntry("Examine", class144.method3013(16748608) + var53.name, 1004, var60.id, var22, var23);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var18 != -1) {
                        var20 = var18 & 127;
                        var21 = var18 >> 7 & 127;
                        Player var63 = Client.cachedPlayers[Client.field411];
                        class43.method890(var63, Client.field411, var20, var21);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  if((Client.field516 == 0 || Client.field516 == 3) && (class143.field2206 == 1 || !class124.field2066 && class143.field2206 == 4)) {
                     class178 var59 = var9.method3425(true);
                     if(null != var59) {
                        var19 = class143.field2207 - var10;
                        var20 = class143.field2196 - var11;
                        if(var59.method3472(var19, var20)) {
                           var19 -= var59.field2947 / 2;
                           var20 -= var59.field2942 / 2;
                           var21 = Client.mapAngle + Client.mapScale & 2047;
                           var22 = class94.field1650[var21];
                           var23 = class94.field1651[var21];
                           var22 = var22 * (Client.mapScaleDelta + 256) >> 8;
                           var23 = (256 + Client.mapScaleDelta) * var23 >> 8;
                           var24 = var23 * var19 + var20 * var22 >> 11;
                           var35 = var23 * var20 - var19 * var22 >> 11;
                           int var42 = class165.localPlayer.x + var24 >> 7;
                           var27 = class165.localPlayer.y - var35 >> 7;
                           Client.field324.method2828(203);
                           Client.field324.method2556(18);
                           Client.field324.method2603(class47.baseX + var42);
                           Client.field324.method2756(var27 + class21.baseY);
                           Client.field324.method2700(class140.field2163[82]?(class140.field2163[81]?2:1):0);
                           Client.field324.method2556(var19);
                           Client.field324.method2556(var20);
                           Client.field324.method2638(Client.mapAngle);
                           Client.field324.method2556(57);
                           Client.field324.method2556(Client.mapScale);
                           Client.field324.method2556(Client.mapScaleDelta);
                           Client.field324.method2556(89);
                           Client.field324.method2638(class165.localPlayer.x);
                           Client.field324.method2638(class165.localPlayer.y);
                           Client.field324.method2556(63);
                           Client.flagX = var42;
                           Client.flagY = var27;
                        }
                     }
                  }
               } else {
                  boolean var48;
                  if(!Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     var18 = var16 - var10;
                     var19 = var17 - var11;
                     if(var9.field2801 == 1) {
                        class5.addMenuEntry(var9.tooltip, "", 24, 0, 0, var9.id);
                     }

                     String var33;
                     if(var9.field2801 == 2 && !Client.field435) {
                        var33 = class18.method186(var9);
                        if(var33 != null) {
                           class5.addMenuEntry(var33, class144.method3013('\uff00') + var9.field2868, 25, 0, -1, var9.id);
                        }
                     }

                     if(var9.field2801 == 3) {
                        class5.addMenuEntry("Close", "", 26, 0, 0, var9.id);
                     }

                     if(var9.field2801 == 4) {
                        class5.addMenuEntry(var9.tooltip, "", 28, 0, 0, var9.id);
                     }

                     if(var9.field2801 == 5) {
                        class5.addMenuEntry(var9.tooltip, "", 29, 0, 0, var9.id);
                     }

                     if(var9.field2801 == 6 && Client.field361 == null) {
                        class5.addMenuEntry(var9.tooltip, "", 30, 0, -1, var9.id);
                     }

                     if(var9.type == 2) {
                        var20 = 0;

                        for(var21 = 0; var21 < var9.height; ++var21) {
                           for(var22 = 0; var22 < var9.width; ++var22) {
                              var23 = var22 * (var9.field2864 + 32);
                              var24 = var21 * (32 + var9.field2841);
                              if(var20 < 20) {
                                 var23 += var9.field2866[var20];
                                 var24 += var9.field2867[var20];
                              }

                              if(var18 >= var23 && var19 >= var24 && var18 < var23 + 32 && var19 < 32 + var24) {
                                 Client.field398 = var20;
                                 class117.field2030 = var9;
                                 if(var9.itemIds[var20] > 0) {
                                    ItemComposition var25 = class22.getItemDefinition(var9.itemIds[var20] - 1);
                                    if(Client.field497 == 1 && class33.method692(FrameMap.method2356(var9))) {
                                       if(class20.field569 != var9.id || class12.field184 != var20) {
                                          class5.addMenuEntry("Use", Client.field434 + " " + "->" + " " + class144.method3013(16748608) + var25.name, 31, var25.id, var20, var9.id);
                                       }
                                    } else if(Client.field435 && class33.method692(FrameMap.method2356(var9))) {
                                       if((class145.field2220 & 16) == 16) {
                                          class5.addMenuEntry(Client.field328, Client.field439 + " " + "->" + " " + class144.method3013(16748608) + var25.name, 32, var25.id, var20, var9.id);
                                       }
                                    } else {
                                       String[] var26 = var25.inventoryActions;
                                       if(Client.field451) {
                                          var26 = class56.method1174(var26);
                                       }

                                       if(class33.method692(FrameMap.method2356(var9))) {
                                          for(var27 = 4; var27 >= 3; --var27) {
                                             if(var26 != null && null != var26[var27]) {
                                                byte var37;
                                                if(var27 == 3) {
                                                   var37 = 36;
                                                } else {
                                                   var37 = 37;
                                                }

                                                class5.addMenuEntry(var26[var27], class144.method3013(16748608) + var25.name, var37, var25.id, var20, var9.id);
                                             } else if(var27 == 4) {
                                                class5.addMenuEntry("Drop", class144.method3013(16748608) + var25.name, 37, var25.id, var20, var9.id);
                                             }
                                          }
                                       }

                                       var61 = FrameMap.method2356(var9);
                                       boolean var49 = (var61 >> 31 & 1) != 0;
                                       if(var49) {
                                          class5.addMenuEntry("Use", class144.method3013(16748608) + var25.name, 38, var25.id, var20, var9.id);
                                       }

                                       Object var10000 = null;
                                       byte var41;
                                       if(class33.method692(FrameMap.method2356(var9)) && var26 != null) {
                                          for(var29 = 2; var29 >= 0; --var29) {
                                             if(null != var26[var29]) {
                                                var41 = 0;
                                                if(var29 == 0) {
                                                   var41 = 33;
                                                }

                                                if(var29 == 1) {
                                                   var41 = 34;
                                                }

                                                if(var29 == 2) {
                                                   var41 = 35;
                                                }

                                                class5.addMenuEntry(var26[var29], class144.method3013(16748608) + var25.name, var41, var25.id, var20, var9.id);
                                             }
                                          }
                                       }

                                       var26 = var9.field2809;
                                       if(Client.field451) {
                                          var26 = class56.method1174(var26);
                                       }

                                       if(var26 != null) {
                                          for(var29 = 4; var29 >= 0; --var29) {
                                             if(var26[var29] != null) {
                                                var41 = 0;
                                                if(var29 == 0) {
                                                   var41 = 39;
                                                }

                                                if(var29 == 1) {
                                                   var41 = 40;
                                                }

                                                if(var29 == 2) {
                                                   var41 = 41;
                                                }

                                                if(var29 == 3) {
                                                   var41 = 42;
                                                }

                                                if(var29 == 4) {
                                                   var41 = 43;
                                                }

                                                class5.addMenuEntry(var26[var29], class144.method3013(16748608) + var25.name, var41, var25.id, var20, var9.id);
                                             }
                                          }
                                       }

                                       class5.addMenuEntry("Examine", class144.method3013(16748608) + var25.name, 1005, var25.id, var20, var9.id);
                                    }
                                 }
                              }

                              ++var20;
                           }
                        }
                     }

                     if(var9.field2815) {
                        if(Client.field435) {
                           if(DecorativeObject.method2237(FrameMap.method2356(var9)) && (class145.field2220 & 32) == 32) {
                              class5.addMenuEntry(Client.field328, Client.field439 + " " + "->" + " " + var9.name, 58, 0, var9.index, var9.id);
                           }
                        } else {
                           for(var20 = 9; var20 >= 5; --var20) {
                              String var32;
                              if(!VertexNormal.method2268(FrameMap.method2356(var9), var20) && var9.field2898 == null) {
                                 var32 = null;
                              } else if(var9.actions != null && var9.actions.length > var20 && var9.actions[var20] != null && var9.actions[var20].trim().length() != 0) {
                                 var32 = var9.actions[var20];
                              } else {
                                 var32 = null;
                              }

                              if(null != var32) {
                                 class5.addMenuEntry(var32, var9.name, 1007, 1 + var20, var9.index, var9.id);
                              }
                           }

                           var33 = class18.method186(var9);
                           if(null != var33) {
                              class5.addMenuEntry(var33, var9.name, 25, 0, var9.index, var9.id);
                           }

                           for(var21 = 4; var21 >= 0; --var21) {
                              String var38;
                              if(!VertexNormal.method2268(FrameMap.method2356(var9), var21) && var9.field2898 == null) {
                                 var38 = null;
                              } else if(null != var9.actions && var9.actions.length > var21 && var9.actions[var21] != null && var9.actions[var21].trim().length() != 0) {
                                 var38 = var9.actions[var21];
                              } else {
                                 var38 = null;
                              }

                              if(var38 != null) {
                                 class5.addMenuEntry(var38, var9.name, 57, 1 + var21, var9.index, var9.id);
                              }
                           }

                           var22 = FrameMap.method2356(var9);
                           var48 = (var22 & 1) != 0;
                           if(var48) {
                              class5.addMenuEntry("Continue", "", 30, 0, var9.index, var9.id);
                           }
                        }
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.field2815 && class5.method56(var9) && var9 != Player.field31) {
                        continue;
                     }

                     method659(var0, var9.id, var12, var13, var14, var15, var10 - var9.itemId, var11 - var9.scrollY);
                     if(null != var9.children) {
                        method659(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.itemId, var11 - var9.scrollY);
                     }

                     WidgetNode var34 = (WidgetNode)Client.componentTable.method3828((long)var9.id);
                     if(null != var34) {
                        if(var34.field57 == 0 && class143.field2200 >= var12 && class143.field2204 >= var13 && class143.field2200 < var14 && class143.field2204 < var15 && !Client.isMenuOpen && !Client.field316) {
                           for(class0 var44 = (class0)Client.field532.method3864(); null != var44; var44 = (class0)Client.field532.method3851()) {
                              if(var44.field1) {
                                 var44.unlink();
                                 var44.field11.field2923 = false;
                              }
                           }

                           if(Friend.field248 == 0) {
                              Client.field453 = null;
                              Client.field388 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuOptionCount = 1;
                           }
                        }

                        var19 = var34.id;
                        if(class85.method1938(var19)) {
                           method659(Widget.widgets[var19], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.field2815) {
                     class0 var58;
                     if(!var9.field2931) {
                        if(var9.field2932 && class143.field2200 >= var12 && class143.field2204 >= var13 && class143.field2200 < var14 && class143.field2204 < var15) {
                           for(var58 = (class0)Client.field532.method3864(); var58 != null; var58 = (class0)Client.field532.method3851()) {
                              if(var58.field1 && var58.field11.field2899 == var58.field0) {
                                 var58.unlink();
                              }
                           }
                        }
                     } else if(class143.field2200 >= var12 && class143.field2204 >= var13 && class143.field2200 < var14 && class143.field2204 < var15) {
                        for(var58 = (class0)Client.field532.method3864(); null != var58; var58 = (class0)Client.field532.method3851()) {
                           if(var58.field1) {
                              var58.unlink();
                              var58.field11.field2923 = false;
                           }
                        }

                        if(Friend.field248 == 0) {
                           Client.field453 = null;
                           Client.field388 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.menuOptionCount = 1;
                        }
                     }

                     boolean var45;
                     if(class143.field2200 >= var12 && class143.field2204 >= var13 && class143.field2200 < var14 && class143.field2204 < var15) {
                        var45 = true;
                     } else {
                        var45 = false;
                     }

                     boolean var46 = false;
                     if((class143.field2199 == 1 || !class124.field2066 && class143.field2199 == 4) && var45) {
                        var46 = true;
                     }

                     boolean var47 = false;
                     if((class143.field2206 == 1 || !class124.field2066 && class143.field2206 == 4) && class143.field2207 >= var12 && class143.field2196 >= var13 && class143.field2207 < var14 && class143.field2196 < var15) {
                        var47 = true;
                     }

                     if(var47) {
                        NPC.method756(var9, class143.field2207 - var10, class143.field2196 - var11);
                     }

                     if(Client.field453 != null && var9 != Client.field453 && var45) {
                        var22 = FrameMap.method2356(var9);
                        var48 = (var22 >> 20 & 1) != 0;
                        if(var48) {
                           Client.field343 = var9;
                        }
                     }

                     if(Client.field388 == var9) {
                        Client.field458 = true;
                        Client.field545 = var10;
                        Client.field526 = var11;
                     }

                     if(var9.field2918) {
                        class0 var57;
                        if(var45 && Client.field539 != 0 && null != var9.field2899) {
                           var57 = new class0();
                           var57.field1 = true;
                           var57.field11 = var9;
                           var57.field3 = Client.field539;
                           var57.field0 = var9.field2899;
                           Client.field532.method3844(var57);
                        }

                        if(null != Client.field453 || null != class12.field182 || Client.isMenuOpen) {
                           var47 = false;
                           var46 = false;
                           var45 = false;
                        }

                        if(!var9.field2924 && var47) {
                           var9.field2924 = true;
                           if(null != var9.field2880) {
                              var57 = new class0();
                              var57.field1 = true;
                              var57.field11 = var9;
                              var57.field10 = class143.field2207 - var10;
                              var57.field3 = class143.field2196 - var11;
                              var57.field0 = var9.field2880;
                              Client.field532.method3844(var57);
                           }
                        }

                        if(var9.field2924 && var46 && null != var9.field2881) {
                           var57 = new class0();
                           var57.field1 = true;
                           var57.field11 = var9;
                           var57.field10 = class143.field2200 - var10;
                           var57.field3 = class143.field2204 - var11;
                           var57.field0 = var9.field2881;
                           Client.field532.method3844(var57);
                        }

                        if(var9.field2924 && !var46) {
                           var9.field2924 = false;
                           if(var9.field2797 != null) {
                              var57 = new class0();
                              var57.field1 = true;
                              var57.field11 = var9;
                              var57.field10 = class143.field2200 - var10;
                              var57.field3 = class143.field2204 - var11;
                              var57.field0 = var9.field2797;
                              Client.field481.method3844(var57);
                           }
                        }

                        if(var46 && var9.field2883 != null) {
                           var57 = new class0();
                           var57.field1 = true;
                           var57.field11 = var9;
                           var57.field10 = class143.field2200 - var10;
                           var57.field3 = class143.field2204 - var11;
                           var57.field0 = var9.field2883;
                           Client.field532.method3844(var57);
                        }

                        if(!var9.field2923 && var45) {
                           var9.field2923 = true;
                           if(var9.field2884 != null) {
                              var57 = new class0();
                              var57.field1 = true;
                              var57.field11 = var9;
                              var57.field10 = class143.field2200 - var10;
                              var57.field3 = class143.field2204 - var11;
                              var57.field0 = var9.field2884;
                              Client.field532.method3844(var57);
                           }
                        }

                        if(var9.field2923 && var45 && null != var9.field2885) {
                           var57 = new class0();
                           var57.field1 = true;
                           var57.field11 = var9;
                           var57.field10 = class143.field2200 - var10;
                           var57.field3 = class143.field2204 - var11;
                           var57.field0 = var9.field2885;
                           Client.field532.method3844(var57);
                        }

                        if(var9.field2923 && !var45) {
                           var9.field2923 = false;
                           if(var9.field2886 != null) {
                              var57 = new class0();
                              var57.field1 = true;
                              var57.field11 = var9;
                              var57.field10 = class143.field2200 - var10;
                              var57.field3 = class143.field2204 - var11;
                              var57.field0 = var9.field2886;
                              Client.field481.method3844(var57);
                           }
                        }

                        if(null != var9.field2926) {
                           var57 = new class0();
                           var57.field11 = var9;
                           var57.field0 = var9.field2926;
                           Client.field290.method3844(var57);
                        }

                        class0 var43;
                        if(null != var9.field2891 && Client.field464 > var9.field2865) {
                           if(null != var9.field2892 && Client.field464 - var9.field2865 <= 32) {
                              label1405:
                              for(var21 = var9.field2865; var21 < Client.field464; ++var21) {
                                 var22 = Client.field466[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2892.length; ++var23) {
                                    if(var9.field2892[var23] == var22) {
                                       var43 = new class0();
                                       var43.field11 = var9;
                                       var43.field0 = var9.field2891;
                                       Client.field532.method3844(var43);
                                       break label1405;
                                    }
                                 }
                              }
                           } else {
                              var57 = new class0();
                              var57.field11 = var9;
                              var57.field0 = var9.field2891;
                              Client.field532.method3844(var57);
                           }

                           var9.field2865 = Client.field464;
                        }

                        if(null != var9.field2900 && Client.field496 > var9.field2927) {
                           if(null != var9.field2894 && Client.field496 - var9.field2927 <= 32) {
                              label1381:
                              for(var21 = var9.field2927; var21 < Client.field496; ++var21) {
                                 var22 = Client.field468[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2894.length; ++var23) {
                                    if(var9.field2894[var23] == var22) {
                                       var43 = new class0();
                                       var43.field11 = var9;
                                       var43.field0 = var9.field2900;
                                       Client.field532.method3844(var43);
                                       break label1381;
                                    }
                                 }
                              }
                           } else {
                              var57 = new class0();
                              var57.field11 = var9;
                              var57.field0 = var9.field2900;
                              Client.field532.method3844(var57);
                           }

                           var9.field2927 = Client.field496;
                        }

                        if(null != var9.field2819 && Client.field323 > var9.field2928) {
                           if(null != var9.field2896 && Client.field323 - var9.field2928 <= 32) {
                              label1357:
                              for(var21 = var9.field2928; var21 < Client.field323; ++var21) {
                                 var22 = Client.field470[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2896.length; ++var23) {
                                    if(var22 == var9.field2896[var23]) {
                                       var43 = new class0();
                                       var43.field11 = var9;
                                       var43.field0 = var9.field2819;
                                       Client.field532.method3844(var43);
                                       break label1357;
                                    }
                                 }
                              }
                           } else {
                              var57 = new class0();
                              var57.field11 = var9;
                              var57.field0 = var9.field2819;
                              Client.field532.method3844(var57);
                           }

                           var9.field2928 = Client.field323;
                        }

                        if(Client.field472 > var9.field2925 && null != var9.field2890) {
                           var57 = new class0();
                           var57.field11 = var9;
                           var57.field0 = var9.field2890;
                           Client.field532.method3844(var57);
                        }

                        if(Client.field359 > var9.field2925 && null != var9.field2888) {
                           var57 = new class0();
                           var57.field11 = var9;
                           var57.field0 = var9.field2888;
                           Client.field532.method3844(var57);
                        }

                        if(Client.field555 > var9.field2925 && var9.field2806 != null) {
                           var57 = new class0();
                           var57.field11 = var9;
                           var57.field0 = var9.field2806;
                           Client.field532.method3844(var57);
                        }

                        if(Client.field475 > var9.field2925 && var9.field2908 != null) {
                           var57 = new class0();
                           var57.field11 = var9;
                           var57.field0 = var9.field2908;
                           Client.field532.method3844(var57);
                        }

                        if(Client.field476 > var9.field2925 && var9.field2909 != null) {
                           var57 = new class0();
                           var57.field11 = var9;
                           var57.field0 = var9.field2909;
                           Client.field532.method3844(var57);
                        }

                        if(Client.field477 > var9.field2925 && null != var9.field2913) {
                           var57 = new class0();
                           var57.field11 = var9;
                           var57.field0 = var9.field2913;
                           Client.field532.method3844(var57);
                        }

                        var9.field2925 = Client.field465;
                        if(null != var9.field2901) {
                           for(var21 = 0; var21 < Client.field391; ++var21) {
                              class0 var62 = new class0();
                              var62.field11 = var9;
                              var62.field7 = Client.field505[var21];
                              var62.field8 = Client.field478[var21];
                              var62.field0 = var9.field2901;
                              Client.field532.method3844(var62);
                           }
                        }
                     }
                  }

                  if(!var9.field2815 && null == Client.field453 && class12.field182 == null && !Client.isMenuOpen) {
                     if((var9.field2904 >= 0 || var9.field2825 != 0) && class143.field2200 >= var12 && class143.field2204 >= var13 && class143.field2200 < var14 && class143.field2204 < var15) {
                        if(var9.field2904 >= 0) {
                           Player.field31 = var0[var9.field2904];
                        } else {
                           Player.field31 = var9;
                        }
                     }

                     if(var9.type == 8 && class143.field2200 >= var12 && class143.field2204 >= var13 && class143.field2200 < var14 && class143.field2204 < var15) {
                        Actor.field885 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        BufferProvider.method1735(var9, var9.width + var10, var11, var9.height, var9.scrollHeight, class143.field2200, class143.field2204);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass125;IS)V",
      garbageValue = "-26834"
   )
   static final void method660(class125 var0, int var1) {
      int var2 = var0.offset;
      class34.field779 = 0;
      Actor.method780(var0);
      class14.method150(var0);
      if(var1 != var0.offset - var2) {
         throw new RuntimeException(var0.offset - var2 + " " + var1);
      }
   }
}
