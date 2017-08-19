import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
@Implements("Occluder")
public final class Occluder {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -842314363
   )
   @Export("testDirection")
   int testDirection;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -125665285
   )
   @Export("minX")
   int minX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 686228313
   )
   @Export("type")
   int type;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -993971037
   )
   @Export("minNormalX")
   int minNormalX;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 749770721
   )
   @Export("minTileX")
   int minTileX;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1370713155
   )
   @Export("minZ")
   int minZ;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2124296853
   )
   @Export("minTileZ")
   int minTileZ;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1498515641
   )
   @Export("maxZ")
   int maxZ;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -499622845
   )
   @Export("maxNormalX")
   int maxNormalX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 808841341
   )
   int field2172;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1352008363
   )
   @Export("minY")
   int minY;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1830913551
   )
   @Export("minNormalY")
   int minNormalY;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1460546985
   )
   int field2166;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2012533703
   )
   @Export("maxX")
   int maxX;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1083284927
   )
   @Export("maxY")
   int maxY;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1241812421
   )
   @Export("maxNormalY")
   int maxNormalY;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1795630029
   )
   @Export("maxTileZ")
   int maxTileZ;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1048972355
   )
   @Export("maxTIleX")
   int maxTIleX;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)[Ljj;",
      garbageValue = "2017139024"
   )
   public static Parameters[] method2920() {
      return new Parameters[]{Parameters.field3714, Parameters.field3705, Parameters.field3703, Parameters.field3701, Parameters.field3708, Parameters.field3704, Parameters.field3707, Parameters.field3712, Parameters.field3706, Parameters.field3710, Parameters.field3715, Parameters.field3713, Parameters.field3709, Parameters.field3711, Parameters.field3700};
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "61"
   )
   public static String method2916(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-109"
   )
   public static int method2918(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "([Lhi;IIIIIIII)V",
      garbageValue = "2021221892"
   )
   static final void method2919(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2760 || class262.getWidgetConfig(var9) != 0 || var9 == Client.field1173 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !Renderable.method2896(var9))) {
            int var10 = var9.relativeX + var6;
            int var11 = var7 + var9.relativeY;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var19;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               int var18 = var10 + var9.width;
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
               var16 = var10 + var9.width;
               var17 = var11 + var9.height;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == Client.field1107) {
               Client.field1099 = true;
               Client.field948 = var10;
               Client.field1109 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = MouseInput.field734;
               var17 = MouseInput.field735;
               if(MouseInput.field740 != 0) {
                  var16 = MouseInput.field741;
                  var17 = MouseInput.field742;
               }

               boolean var44 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               int var20;
               int var21;
               int var22;
               int var23;
               int var24;
               int var25;
               int var26;
               int var28;
               int var29;
               if(var9.contentType == 1337) {
                  if(!Client.field942 && !Client.isMenuOpen && var44) {
                     if(Client.itemSelectionState == 0 && !Client.spellSelected) {
                        DynamicObject.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var19 = -1;
                     var20 = -1;

                     for(var21 = 0; var21 < class135.field1997; ++var21) {
                        var22 = class135.field2002[var21];
                        var23 = var22 & 127;
                        var24 = var22 >> 7 & 127;
                        var25 = var22 >> 29 & 3;
                        var26 = var22 >> 14 & 32767;
                        if(var20 != var22) {
                           var20 = var22;
                           if(var25 == 2 && class36.region.method2825(class35.plane, var23, var24, var22) >= 0) {
                              ObjectComposition var48 = class37.getObjectDefinition(var26);
                              if(var48.impostorIds != null) {
                                 var48 = var48.getImpostor();
                              }

                              if(var48 == null) {
                                 continue;
                              }

                              if(Client.itemSelectionState == 1) {
                                 DynamicObject.addMenuEntry("Use", Client.field1084 + " " + "->" + " " + Tile.getColTags('\uffff') + var48.name, 1, var22, var23, var24);
                              } else if(Client.spellSelected) {
                                 if((class51.field664 & 4) == 4) {
                                    DynamicObject.addMenuEntry(Client.field993, Client.field1085 + " " + "->" + " " + Tile.getColTags('\uffff') + var48.name, 2, var22, var23, var24);
                                 }
                              } else {
                                 String[] var41 = var48.actions;
                                 if(Client.field1027) {
                                    var41 = class158.method3000(var41);
                                 }

                                 if(var41 != null) {
                                    for(var29 = 4; var29 >= 0; --var29) {
                                       if(var41[var29] != null) {
                                          short var52 = 0;
                                          if(var29 == 0) {
                                             var52 = 3;
                                          }

                                          if(var29 == 1) {
                                             var52 = 4;
                                          }

                                          if(var29 == 2) {
                                             var52 = 5;
                                          }

                                          if(var29 == 3) {
                                             var52 = 6;
                                          }

                                          if(var29 == 4) {
                                             var52 = 1001;
                                          }

                                          DynamicObject.addMenuEntry(var41[var29], Tile.getColTags('\uffff') + var48.name, var52, var22, var23, var24);
                                       }
                                    }
                                 }

                                 DynamicObject.addMenuEntry("Examine", Tile.getColTags('\uffff') + var48.name, 1002, var48.id << 14, var23, var24);
                              }
                           }

                           Player var31;
                           NPC var38;
                           int var55;
                           int[] var57;
                           if(var25 == 1) {
                              NPC var49 = Client.cachedNPCs[var26];
                              if(var49 == null) {
                                 continue;
                              }

                              if(var49.composition.field3543 == 1 && (var49.x & 127) == 64 && (var49.y & 127) == 64) {
                                 for(var28 = 0; var28 < Client.field958; ++var28) {
                                    var38 = Client.cachedNPCs[Client.npcIndices[var28]];
                                    if(var38 != null && var49 != var38 && var38.composition.field3543 == 1 && var49.x == var38.x && var49.y == var38.y) {
                                       class43.method649(var38.composition, Client.npcIndices[var28], var23, var24);
                                    }
                                 }

                                 var28 = class97.field1510;
                                 var57 = class97.field1511;

                                 for(var55 = 0; var55 < var28; ++var55) {
                                    var31 = Client.cachedPlayers[var57[var55]];
                                    if(var31 != null && var31.x == var49.x && var31.y == var49.y) {
                                       class158.method2996(var31, var57[var55], var23, var24);
                                    }
                                 }
                              }

                              class43.method649(var49.composition, var26, var23, var24);
                           }

                           if(var25 == 0) {
                              Player var50 = Client.cachedPlayers[var26];
                              if(var50 == null) {
                                 continue;
                              }

                              if((var50.x & 127) == 64 && (var50.y & 127) == 64) {
                                 for(var28 = 0; var28 < Client.field958; ++var28) {
                                    var38 = Client.cachedNPCs[Client.npcIndices[var28]];
                                    if(var38 != null && var38.composition.field3543 == 1 && var50.x == var38.x && var38.y == var50.y) {
                                       class43.method649(var38.composition, Client.npcIndices[var28], var23, var24);
                                    }
                                 }

                                 var28 = class97.field1510;
                                 var57 = class97.field1511;

                                 for(var55 = 0; var55 < var28; ++var55) {
                                    var31 = Client.cachedPlayers[var57[var55]];
                                    if(var31 != null && var31 != var50 && var31.x == var50.x && var31.y == var50.y) {
                                       class158.method2996(var31, var57[var55], var23, var24);
                                    }
                                 }
                              }

                              if(var26 != Client.field1054) {
                                 class158.method2996(var50, var26, var23, var24);
                              } else {
                                 var19 = var22;
                              }
                           }

                           if(var25 == 3) {
                              Deque var51 = Client.groundItemDeque[class35.plane][var23][var24];
                              if(var51 != null) {
                                 for(Item var60 = (Item)var51.getTail(); var60 != null; var60 = (Item)var51.getPrevious()) {
                                    ItemComposition var58 = SoundTask.getItemDefinition(var60.id);
                                    if(Client.itemSelectionState == 1) {
                                       DynamicObject.addMenuEntry("Use", Client.field1084 + " " + "->" + " " + Tile.getColTags(16748608) + var58.name, 16, var60.id, var23, var24);
                                    } else if(Client.spellSelected) {
                                       if((class51.field664 & 1) == 1) {
                                          DynamicObject.addMenuEntry(Client.field993, Client.field1085 + " " + "->" + " " + Tile.getColTags(16748608) + var58.name, 17, var60.id, var23, var24);
                                       }
                                    } else {
                                       String[] var42 = var58.groundActions;
                                       if(Client.field1027) {
                                          var42 = class158.method3000(var42);
                                       }

                                       for(int var43 = 4; var43 >= 0; --var43) {
                                          if(var42 != null && var42[var43] != null) {
                                             byte var32 = 0;
                                             if(var43 == 0) {
                                                var32 = 18;
                                             }

                                             if(var43 == 1) {
                                                var32 = 19;
                                             }

                                             if(var43 == 2) {
                                                var32 = 20;
                                             }

                                             if(var43 == 3) {
                                                var32 = 21;
                                             }

                                             if(var43 == 4) {
                                                var32 = 22;
                                             }

                                             DynamicObject.addMenuEntry(var42[var43], Tile.getColTags(16748608) + var58.name, var32, var60.id, var23, var24);
                                          } else if(var43 == 2) {
                                             DynamicObject.addMenuEntry("Take", Tile.getColTags(16748608) + var58.name, 20, var60.id, var23, var24);
                                          }
                                       }

                                       DynamicObject.addMenuEntry("Examine", Tile.getColTags(16748608) + var58.name, 1004, var60.id, var23, var24);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var19 != -1) {
                        var21 = var19 & 127;
                        var22 = var19 >> 7 & 127;
                        Player var59 = Client.cachedPlayers[Client.field1054];
                        class158.method2996(var59, Client.field1054, var21, var22);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  class74.method1184(var9, var10, var11);
               } else {
                  if(var9.contentType == 1400) {
                     class46.renderOverview.method5285(MouseInput.field734, MouseInput.field735, var44, var10, var11, var9.width, var9.height);
                  }

                  if(!Client.isMenuOpen && var44) {
                     if(var9.contentType == 1400) {
                        class46.renderOverview.method5275(var10, var11, var9.width, var9.height, var16, var17);
                     } else {
                        var19 = var16 - var10;
                        var20 = var17 - var11;
                        if(var9.field2652 == 1) {
                           DynamicObject.addMenuEntry(var9.tooltip, "", 24, 0, 0, var9.id);
                        }

                        String var33;
                        if(var9.field2652 == 2 && !Client.spellSelected) {
                           var33 = Renderable.method2895(var9);
                           if(var33 != null) {
                              DynamicObject.addMenuEntry(var33, Tile.getColTags('\uff00') + var9.field2765, 25, 0, -1, var9.id);
                           }
                        }

                        if(var9.field2652 == 3) {
                           DynamicObject.addMenuEntry("Close", "", 26, 0, 0, var9.id);
                        }

                        if(var9.field2652 == 4) {
                           DynamicObject.addMenuEntry(var9.tooltip, "", 28, 0, 0, var9.id);
                        }

                        if(var9.field2652 == 5) {
                           DynamicObject.addMenuEntry(var9.tooltip, "", 29, 0, 0, var9.id);
                        }

                        if(var9.field2652 == 6 && Client.field1090 == null) {
                           DynamicObject.addMenuEntry(var9.tooltip, "", 30, 0, -1, var9.id);
                        }

                        if(var9.type == 2) {
                           var21 = 0;

                           for(var22 = 0; var22 < var9.height; ++var22) {
                              for(var23 = 0; var23 < var9.width; ++var23) {
                                 var24 = var23 * (var9.paddingX + 32);
                                 var25 = (var9.paddingY + 32) * var22;
                                 if(var21 < 20) {
                                    var24 += var9.xSprites[var21];
                                    var25 += var9.field2718[var21];
                                 }

                                 if(var19 >= var24 && var20 >= var25 && var19 < var24 + 32 && var20 < var25 + 32) {
                                    Client.field1146 = var21;
                                    class277.field3718 = var9;
                                    if(var9.itemIds[var21] > 0) {
                                       ItemComposition var37 = SoundTask.getItemDefinition(var9.itemIds[var21] - 1);
                                       if(Client.itemSelectionState == 1 && class35.method506(class262.getWidgetConfig(var9))) {
                                          if(var9.id != class34.field499 || var21 != MessageNode.selectedItemIndex) {
                                             DynamicObject.addMenuEntry("Use", Client.field1084 + " " + "->" + " " + Tile.getColTags(16748608) + var37.name, 31, var37.id, var21, var9.id);
                                          }
                                       } else if(Client.spellSelected && class35.method506(class262.getWidgetConfig(var9))) {
                                          if((class51.field664 & 16) == 16) {
                                             DynamicObject.addMenuEntry(Client.field993, Client.field1085 + " " + "->" + " " + Tile.getColTags(16748608) + var37.name, 32, var37.id, var21, var9.id);
                                          }
                                       } else {
                                          String[] var27 = var37.inventoryActions;
                                          if(Client.field1027) {
                                             var27 = class158.method3000(var27);
                                          }

                                          var28 = -1;
                                          if(Client.field1074 && KeyFocusListener.field642[81]) {
                                             var28 = var37.method4615();
                                          }

                                          if(class35.method506(class262.getWidgetConfig(var9))) {
                                             for(var29 = 4; var29 >= 3; --var29) {
                                                if(var29 != var28) {
                                                   class37.method515(var9, var37, var21, var29, false);
                                                }
                                             }
                                          }

                                          if(class221.method4073(class262.getWidgetConfig(var9))) {
                                             DynamicObject.addMenuEntry("Use", Tile.getColTags(16748608) + var37.name, 38, var37.id, var21, var9.id);
                                          }

                                          if(class35.method506(class262.getWidgetConfig(var9))) {
                                             for(var29 = 2; var29 >= 0; --var29) {
                                                if(var29 != var28) {
                                                   class37.method515(var9, var37, var21, var29, false);
                                                }
                                             }

                                             if(var28 >= 0) {
                                                class37.method515(var9, var37, var21, var28, true);
                                             }
                                          }

                                          var27 = var9.configActions;
                                          if(Client.field1027) {
                                             var27 = class158.method3000(var27);
                                          }

                                          if(var27 != null) {
                                             for(var29 = 4; var29 >= 0; --var29) {
                                                if(var27[var29] != null) {
                                                   byte var30 = 0;
                                                   if(var29 == 0) {
                                                      var30 = 39;
                                                   }

                                                   if(var29 == 1) {
                                                      var30 = 40;
                                                   }

                                                   if(var29 == 2) {
                                                      var30 = 41;
                                                   }

                                                   if(var29 == 3) {
                                                      var30 = 42;
                                                   }

                                                   if(var29 == 4) {
                                                      var30 = 43;
                                                   }

                                                   DynamicObject.addMenuEntry(var27[var29], Tile.getColTags(16748608) + var37.name, var30, var37.id, var21, var9.id);
                                                }
                                             }
                                          }

                                          DynamicObject.addMenuEntry("Examine", Tile.getColTags(16748608) + var37.name, 1005, var37.id, var21, var9.id);
                                       }
                                    }
                                 }

                                 ++var21;
                              }
                           }
                        }

                        if(var9.hasScript) {
                           if(Client.spellSelected) {
                              if(class19.method160(class262.getWidgetConfig(var9)) && (class51.field664 & 32) == 32) {
                                 DynamicObject.addMenuEntry(Client.field993, Client.field1085 + " " + "->" + " " + var9.name, 58, 0, var9.index, var9.id);
                              }
                           } else {
                              for(var21 = 9; var21 >= 5; --var21) {
                                 String var35 = class7.method31(var9, var21);
                                 if(var35 != null) {
                                    DynamicObject.addMenuEntry(var35, var9.name, 1007, var21 + 1, var9.index, var9.id);
                                 }
                              }

                              var33 = Renderable.method2895(var9);
                              if(var33 != null) {
                                 DynamicObject.addMenuEntry(var33, var9.name, 25, 0, var9.index, var9.id);
                              }

                              for(var22 = 4; var22 >= 0; --var22) {
                                 String var40 = class7.method31(var9, var22);
                                 if(var40 != null) {
                                    DynamicObject.addMenuEntry(var40, var9.name, 57, var22 + 1, var9.index, var9.id);
                                 }
                              }

                              if(class178.method3414(class262.getWidgetConfig(var9))) {
                                 DynamicObject.addMenuEntry("Continue", "", 30, 0, var9.index, var9.id);
                              }
                           }
                        }
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && Renderable.method2896(var9) && var9 != class2.field12) {
                        continue;
                     }

                     method2919(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method2919(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var34 = (WidgetNode)Client.componentTable.get((long)var9.id);
                     if(var34 != null) {
                        if(var34.owner == 0 && MouseInput.field734 >= var12 && MouseInput.field735 >= var13 && MouseInput.field734 < var14 && MouseInput.field735 < var15 && !Client.isMenuOpen && !Client.field1096) {
                           for(ScriptEvent var36 = (ScriptEvent)Client.field964.getFront(); var36 != null; var36 = (ScriptEvent)Client.field964.getNext()) {
                              if(var36.field865) {
                                 var36.unlink();
                                 var36.widget.field2774 = false;
                              }
                           }

                           if(class48.field621 == 0) {
                              Client.field1107 = null;
                              Client.field1173 = null;
                           }

                           if(!Client.isMenuOpen) {
                              class37.method519();
                           }
                        }

                        AbstractByteBuffer.method3407(var34.id, var12, var13, var14, var15, var10, var11);
                     }
                  }

                  if(var9.hasScript) {
                     ScriptEvent var54;
                     if(!var9.field2758) {
                        if(var9.field2732 && MouseInput.field734 >= var12 && MouseInput.field735 >= var13 && MouseInput.field734 < var14 && MouseInput.field735 < var15) {
                           for(var54 = (ScriptEvent)Client.field964.getFront(); var54 != null; var54 = (ScriptEvent)Client.field964.getNext()) {
                              if(var54.field865 && var54.widget.scrollListener == var54.field856) {
                                 var54.unlink();
                              }
                           }
                        }
                     } else if(MouseInput.field734 >= var12 && MouseInput.field735 >= var13 && MouseInput.field734 < var14 && MouseInput.field735 < var15) {
                        for(var54 = (ScriptEvent)Client.field964.getFront(); var54 != null; var54 = (ScriptEvent)Client.field964.getNext()) {
                           if(var54.field865) {
                              var54.unlink();
                              var54.widget.field2774 = false;
                           }
                        }

                        if(class48.field621 == 0) {
                           Client.field1107 = null;
                           Client.field1173 = null;
                        }

                        if(!Client.isMenuOpen) {
                           class37.method519();
                        }
                     }

                     if(MouseInput.field734 >= var12 && MouseInput.field735 >= var13 && MouseInput.field734 < var14 && MouseInput.field735 < var15) {
                        var44 = true;
                     } else {
                        var44 = false;
                     }

                     boolean var46 = false;
                     if((MouseInput.field733 == 1 || !GrandExchangeOffer.field302 && MouseInput.field733 == 4) && var44) {
                        var46 = true;
                     }

                     boolean var45 = false;
                     if((MouseInput.field740 == 1 || !GrandExchangeOffer.field302 && MouseInput.field740 == 4) && MouseInput.field741 >= var12 && MouseInput.field742 >= var13 && MouseInput.field741 < var14 && MouseInput.field742 < var15) {
                        var45 = true;
                     }

                     if(var45) {
                        class61.method1117(var9, MouseInput.field741 - var10, MouseInput.field742 - var11);
                     }

                     if(var9.contentType == 1400) {
                        class46.renderOverview.method5230(MouseInput.field734, MouseInput.field735, var44 & var46);
                     }

                     if(Client.field1107 != null && var9 != Client.field1107 && var44) {
                        var22 = class262.getWidgetConfig(var9);
                        boolean var47 = (var22 >> 20 & 1) != 0;
                        if(var47) {
                           Client.field1185 = var9;
                        }
                     }

                     if(var9 == Client.field1173) {
                        Client.field1104 = true;
                        Client.field1105 = var10;
                        Client.field1106 = var11;
                     }

                     if(var9.field2760) {
                        ScriptEvent var53;
                        if(var44 && Client.field1124 != 0 && var9.scrollListener != null) {
                           var53 = new ScriptEvent();
                           var53.field865 = true;
                           var53.widget = var9;
                           var53.field858 = Client.field1124;
                           var53.field856 = var9.scrollListener;
                           Client.field964.addFront(var53);
                        }

                        if(Client.field1107 != null || class25.field373 != null || Client.isMenuOpen) {
                           var45 = false;
                           var46 = false;
                           var44 = false;
                        }

                        if(!var9.field2650 && var45) {
                           var9.field2650 = true;
                           if(var9.field2740 != null) {
                              var53 = new ScriptEvent();
                              var53.field865 = true;
                              var53.widget = var9;
                              var53.field857 = MouseInput.field741 - var10;
                              var53.field858 = MouseInput.field742 - var11;
                              var53.field856 = var9.field2740;
                              Client.field964.addFront(var53);
                           }
                        }

                        if(var9.field2650 && var46 && var9.field2769 != null) {
                           var53 = new ScriptEvent();
                           var53.field865 = true;
                           var53.widget = var9;
                           var53.field857 = MouseInput.field734 - var10;
                           var53.field858 = MouseInput.field735 - var11;
                           var53.field856 = var9.field2769;
                           Client.field964.addFront(var53);
                        }

                        if(var9.field2650 && !var46) {
                           var9.field2650 = false;
                           if(var9.field2733 != null) {
                              var53 = new ScriptEvent();
                              var53.field865 = true;
                              var53.widget = var9;
                              var53.field857 = MouseInput.field734 - var10;
                              var53.field858 = MouseInput.field735 - var11;
                              var53.field856 = var9.field2733;
                              Client.field1127.addFront(var53);
                           }
                        }

                        if(var46 && var9.field2661 != null) {
                           var53 = new ScriptEvent();
                           var53.field865 = true;
                           var53.widget = var9;
                           var53.field857 = MouseInput.field734 - var10;
                           var53.field858 = MouseInput.field735 - var11;
                           var53.field856 = var9.field2661;
                           Client.field964.addFront(var53);
                        }

                        if(!var9.field2774 && var44) {
                           var9.field2774 = true;
                           if(var9.mouseEnterListener != null) {
                              var53 = new ScriptEvent();
                              var53.field865 = true;
                              var53.widget = var9;
                              var53.field857 = MouseInput.field734 - var10;
                              var53.field858 = MouseInput.field735 - var11;
                              var53.field856 = var9.mouseEnterListener;
                              Client.field964.addFront(var53);
                           }
                        }

                        if(var9.field2774 && var44 && var9.mouseHoverListener != null) {
                           var53 = new ScriptEvent();
                           var53.field865 = true;
                           var53.widget = var9;
                           var53.field857 = MouseInput.field734 - var10;
                           var53.field858 = MouseInput.field735 - var11;
                           var53.field856 = var9.mouseHoverListener;
                           Client.field964.addFront(var53);
                        }

                        if(var9.field2774 && !var44) {
                           var9.field2774 = false;
                           if(var9.mouseExitListener != null) {
                              var53 = new ScriptEvent();
                              var53.field865 = true;
                              var53.widget = var9;
                              var53.field857 = MouseInput.field734 - var10;
                              var53.field858 = MouseInput.field735 - var11;
                              var53.field856 = var9.mouseExitListener;
                              Client.field1127.addFront(var53);
                           }
                        }

                        if(var9.renderListener != null) {
                           var53 = new ScriptEvent();
                           var53.widget = var9;
                           var53.field856 = var9.renderListener;
                           Client.field1044.addFront(var53);
                        }

                        ScriptEvent var39;
                        if(var9.configListenerArgs != null && Client.field961 > var9.field2721) {
                           if(var9.configTriggers != null && Client.field961 - var9.field2721 <= 32) {
                              label1382:
                              for(var21 = var9.field2721; var21 < Client.field961; ++var21) {
                                 var22 = Client.field1078[var21 & 31];

                                 for(var23 = 0; var23 < var9.configTriggers.length; ++var23) {
                                    if(var22 == var9.configTriggers[var23]) {
                                       var39 = new ScriptEvent();
                                       var39.widget = var9;
                                       var39.field856 = var9.configListenerArgs;
                                       Client.field964.addFront(var39);
                                       break label1382;
                                    }
                                 }
                              }
                           } else {
                              var53 = new ScriptEvent();
                              var53.widget = var9;
                              var53.field856 = var9.configListenerArgs;
                              Client.field964.addFront(var53);
                           }

                           var9.field2721 = Client.field961;
                        }

                        if(var9.tableListenerArgs != null && Client.field1115 > var9.field2778) {
                           if(var9.tableModTriggers != null && Client.field1115 - var9.field2778 <= 32) {
                              label1358:
                              for(var21 = var9.field2778; var21 < Client.field1115; ++var21) {
                                 var22 = Client.interfaceItemTriggers[var21 & 31];

                                 for(var23 = 0; var23 < var9.tableModTriggers.length; ++var23) {
                                    if(var22 == var9.tableModTriggers[var23]) {
                                       var39 = new ScriptEvent();
                                       var39.widget = var9;
                                       var39.field856 = var9.tableListenerArgs;
                                       Client.field964.addFront(var39);
                                       break label1358;
                                    }
                                 }
                              }
                           } else {
                              var53 = new ScriptEvent();
                              var53.widget = var9;
                              var53.field856 = var9.tableListenerArgs;
                              Client.field964.addFront(var53);
                           }

                           var9.field2778 = Client.field1115;
                        }

                        if(var9.skillListenerArgs != null && Client.field1064 > var9.field2779) {
                           if(var9.skillTriggers != null && Client.field1064 - var9.field2779 <= 32) {
                              label1334:
                              for(var21 = var9.field2779; var21 < Client.field1064; ++var21) {
                                 var22 = Client.field1116[var21 & 31];

                                 for(var23 = 0; var23 < var9.skillTriggers.length; ++var23) {
                                    if(var22 == var9.skillTriggers[var23]) {
                                       var39 = new ScriptEvent();
                                       var39.widget = var9;
                                       var39.field856 = var9.skillListenerArgs;
                                       Client.field964.addFront(var39);
                                       break label1334;
                                    }
                                 }
                              }
                           } else {
                              var53 = new ScriptEvent();
                              var53.widget = var9;
                              var53.field856 = var9.skillListenerArgs;
                              Client.field964.addFront(var53);
                           }

                           var9.field2779 = Client.field1064;
                        }

                        if(Client.chatCycle > var9.field2776 && var9.field2751 != null) {
                           var53 = new ScriptEvent();
                           var53.widget = var9;
                           var53.field856 = var9.field2751;
                           Client.field964.addFront(var53);
                        }

                        if(Client.field1119 > var9.field2776 && var9.field2782 != null) {
                           var53 = new ScriptEvent();
                           var53.widget = var9;
                           var53.field856 = var9.field2782;
                           Client.field964.addFront(var53);
                        }

                        if(Client.field973 > var9.field2776 && var9.field2754 != null) {
                           var53 = new ScriptEvent();
                           var53.widget = var9;
                           var53.field856 = var9.field2754;
                           Client.field964.addFront(var53);
                        }

                        if(Client.field1121 > var9.field2776 && var9.field2655 != null) {
                           var53 = new ScriptEvent();
                           var53.widget = var9;
                           var53.field856 = var9.field2655;
                           Client.field964.addFront(var53);
                        }

                        if(Client.field949 > var9.field2776 && var9.field2759 != null) {
                           var53 = new ScriptEvent();
                           var53.widget = var9;
                           var53.field856 = var9.field2759;
                           Client.field964.addFront(var53);
                        }

                        if(Client.field1123 > var9.field2776 && var9.field2761 != null) {
                           var53 = new ScriptEvent();
                           var53.widget = var9;
                           var53.field856 = var9.field2761;
                           Client.field964.addFront(var53);
                        }

                        var9.field2776 = Client.cycleCntr;
                        if(var9.field2752 != null) {
                           for(var21 = 0; var21 < Client.field1147; ++var21) {
                              ScriptEvent var56 = new ScriptEvent();
                              var56.widget = var9;
                              var56.field861 = Client.field960[var21];
                              var56.field862 = Client.field1011[var21];
                              var56.field856 = var9.field2752;
                              Client.field964.addFront(var56);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.field1107 == null && class25.field373 == null && !Client.isMenuOpen) {
                     if((var9.field2764 >= 0 || var9.field2777 != 0) && MouseInput.field734 >= var12 && MouseInput.field735 >= var13 && MouseInput.field734 < var14 && MouseInput.field735 < var15) {
                        if(var9.field2764 >= 0) {
                           class2.field12 = var0[var9.field2764];
                        } else {
                           class2.field12 = var9;
                        }
                     }

                     if(var9.type == 8 && MouseInput.field734 >= var12 && MouseInput.field735 >= var13 && MouseInput.field734 < var14 && MouseInput.field735 < var15) {
                        class23.field359 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        var19 = var10 + var9.width;
                        var20 = var9.height;
                        var21 = var9.scrollHeight;
                        var22 = MouseInput.field734;
                        var23 = MouseInput.field735;
                        if(Client.field1065) {
                           Client.field1007 = 32;
                        } else {
                           Client.field1007 = 0;
                        }

                        Client.field1065 = false;
                        if(MouseInput.field733 == 1 || !GrandExchangeOffer.field302 && MouseInput.field733 == 4) {
                           if(var22 >= var19 && var22 < var19 + 16 && var23 >= var11 && var23 < var11 + 16) {
                              var9.scrollY -= 4;
                              class90.method1723(var9);
                           } else if(var22 >= var19 && var22 < var19 + 16 && var23 >= var20 + var11 - 16 && var23 < var20 + var11) {
                              var9.scrollY += 4;
                              class90.method1723(var9);
                           } else if(var22 >= var19 - Client.field1007 && var22 < var19 + Client.field1007 + 16 && var23 >= var11 + 16 && var23 < var20 + var11 - 16) {
                              var24 = var20 * (var20 - 32) / var21;
                              if(var24 < 8) {
                                 var24 = 8;
                              }

                              var25 = var23 - var11 - 16 - var24 / 2;
                              var26 = var20 - 32 - var24;
                              var9.scrollY = var25 * (var21 - var20) / var26;
                              class90.method1723(var9);
                              Client.field1065 = true;
                           }
                        }

                        if(Client.field1124 != 0) {
                           var24 = var9.width;
                           if(var22 >= var19 - var24 && var23 >= var11 && var22 < var19 + 16 && var23 <= var11 + var20) {
                              var9.scrollY += Client.field1124 * 45;
                              class90.method1723(var9);
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
