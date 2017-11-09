import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
@Implements("ItemContainer")
public class ItemContainer extends Node {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("itemContainers")
   static HashTable itemContainers;
   @ObfuscatedName("x")
   static int[] field745;
   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   static IndexedSprite field750;
   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   static Widget field751;
   @ObfuscatedName("p")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("i")
   @Export("stackSizes")
   int[] stackSizes;

   static {
      itemContainers = new HashTable(32);
   }

   ItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "([Lhk;IIIIIIII)V",
      garbageValue = "-785770715"
   )
   static final void method1145(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2749 || Preferences.getWidgetConfig(var9) != 0 || var9 == Client.field1023 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !class258.method4629(var9))) {
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

            if(var9 == Client.field1022) {
               Client.field1068 = true;
               Client.field1031 = var10;
               Client.field1032 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = MouseInput.field704;
               var17 = MouseInput.field708;
               if(MouseInput.field713 != 0) {
                  var16 = MouseInput.field714;
                  var17 = MouseInput.field715;
               }

               boolean var47 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               int var20;
               int var21;
               int var22;
               int var23;
               int var24;
               int var25;
               int var26;
               int var28;
               int var30;
               int var31;
               if(var9.contentType == 1337) {
                  if(!Client.field877 && !Client.isMenuOpen && var47) {
                     if(Client.itemSelectionState == 0 && !Client.spellSelected) {
                        class60.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var19 = -1;
                     var20 = -1;

                     for(var21 = 0; var21 < class133.field1921; ++var21) {
                        var22 = class133.field1922[var21];
                        var23 = var22 & 127;
                        var24 = var22 >> 7 & 127;
                        var25 = var22 >> 29 & 3;
                        var26 = var22 >> 14 & 32767;
                        if(var20 != var22) {
                           var20 = var22;
                           if(var25 == 2 && class56.region.method2912(Ignore.plane, var23, var24, var22) >= 0) {
                              ObjectComposition var64 = class24.getObjectDefinition(var26);
                              if(var64.impostorIds != null) {
                                 var64 = var64.getImpostor();
                              }

                              if(var64 == null) {
                                 continue;
                              }

                              if(Client.itemSelectionState == 1) {
                                 class60.addMenuEntry("Use", Client.field1118 + " " + "->" + " " + WallObject.getColTags(65535) + var64.name, 1, var22, var23, var24);
                              } else if(Client.spellSelected) {
                                 if((class228.field2902 & 4) == 4) {
                                    class60.addMenuEntry(Client.field1007, Client.field1008 + " " + "->" + " " + WallObject.getColTags(65535) + var64.name, 2, var22, var23, var24);
                                 }
                              } else {
                                 String[] var44 = var64.actions;
                                 if(Client.field869) {
                                    var44 = Friend.method1149(var44);
                                 }

                                 if(var44 != null) {
                                    for(int var63 = 4; var63 >= 0; --var63) {
                                       if(var44[var63] != null) {
                                          short var54 = 0;
                                          if(var63 == 0) {
                                             var54 = 3;
                                          }

                                          if(var63 == 1) {
                                             var54 = 4;
                                          }

                                          if(var63 == 2) {
                                             var54 = 5;
                                          }

                                          if(var63 == 3) {
                                             var54 = 6;
                                          }

                                          if(var63 == 4) {
                                             var54 = 1001;
                                          }

                                          class60.addMenuEntry(var44[var63], WallObject.getColTags(65535) + var64.name, var54, var22, var23, var24);
                                       }
                                    }
                                 }

                                 class60.addMenuEntry("Examine", WallObject.getColTags(65535) + var64.name, 1002, var64.id << 14, var23, var24);
                              }
                           }

                           Player var45;
                           NPC var52;
                           int[] var53;
                           if(var25 == 1) {
                              NPC var65 = Client.cachedNPCs[var26];
                              if(var65 == null) {
                                 continue;
                              }

                              if(var65.composition.field3625 == 1 && (var65.x & 127) == 64 && (var65.y & 127) == 64) {
                                 for(var28 = 0; var28 < Client.npcIndexesCount; ++var28) {
                                    var52 = Client.cachedNPCs[Client.npcIndices[var28]];
                                    if(var52 != null && var65 != var52 && var52.composition.field3625 == 1 && var52.x == var65.x && var65.y == var52.y) {
                                       class41.method641(var52.composition, Client.npcIndices[var28], var23, var24);
                                    }
                                 }

                                 var28 = class94.playerIndexesCount;
                                 var53 = class94.playerIndices;

                                 for(var30 = 0; var30 < var28; ++var30) {
                                    var45 = Client.cachedPlayers[var53[var30]];
                                    if(var45 != null && var45.x == var65.x && var65.y == var45.y) {
                                       class89.method1796(var45, var53[var30], var23, var24);
                                    }
                                 }
                              }

                              class41.method641(var65.composition, var26, var23, var24);
                           }

                           if(var25 == 0) {
                              Player var66 = Client.cachedPlayers[var26];
                              if(var66 == null) {
                                 continue;
                              }

                              if((var66.x & 127) == 64 && (var66.y & 127) == 64) {
                                 for(var28 = 0; var28 < Client.npcIndexesCount; ++var28) {
                                    var52 = Client.cachedNPCs[Client.npcIndices[var28]];
                                    if(var52 != null && var52.composition.field3625 == 1 && var66.x == var52.x && var52.y == var66.y) {
                                       class41.method641(var52.composition, Client.npcIndices[var28], var23, var24);
                                    }
                                 }

                                 var28 = class94.playerIndexesCount;
                                 var53 = class94.playerIndices;

                                 for(var30 = 0; var30 < var28; ++var30) {
                                    var45 = Client.cachedPlayers[var53[var30]];
                                    if(var45 != null && var66 != var45 && var45.x == var66.x && var45.y == var66.y) {
                                       class89.method1796(var45, var53[var30], var23, var24);
                                    }
                                 }
                              }

                              if(var26 != Client.field978) {
                                 class89.method1796(var66, var26, var23, var24);
                              } else {
                                 var19 = var22;
                              }
                           }

                           if(var25 == 3) {
                              Deque var68 = Client.groundItemDeque[Ignore.plane][var23][var24];
                              if(var68 != null) {
                                 for(Item var67 = (Item)var68.getTail(); var67 != null; var67 = (Item)var68.getPrevious()) {
                                    ItemComposition var55 = class250.getItemDefinition(var67.id);
                                    if(Client.itemSelectionState == 1) {
                                       class60.addMenuEntry("Use", Client.field1118 + " " + "->" + " " + WallObject.getColTags(16748608) + var55.name, 16, var67.id, var23, var24);
                                    } else if(Client.spellSelected) {
                                       if((class228.field2902 & 1) == 1) {
                                          class60.addMenuEntry(Client.field1007, Client.field1008 + " " + "->" + " " + WallObject.getColTags(16748608) + var55.name, 17, var67.id, var23, var24);
                                       }
                                    } else {
                                       String[] var46 = var55.groundActions;
                                       if(Client.field869) {
                                          var46 = Friend.method1149(var46);
                                       }

                                       for(var31 = 4; var31 >= 0; --var31) {
                                          if(var46 != null && var46[var31] != null) {
                                             byte var57 = 0;
                                             if(var31 == 0) {
                                                var57 = 18;
                                             }

                                             if(var31 == 1) {
                                                var57 = 19;
                                             }

                                             if(var31 == 2) {
                                                var57 = 20;
                                             }

                                             if(var31 == 3) {
                                                var57 = 21;
                                             }

                                             if(var31 == 4) {
                                                var57 = 22;
                                             }

                                             class60.addMenuEntry(var46[var31], WallObject.getColTags(16748608) + var55.name, var57, var67.id, var23, var24);
                                          } else if(var31 == 2) {
                                             class60.addMenuEntry("Take", WallObject.getColTags(16748608) + var55.name, 20, var67.id, var23, var24);
                                          }
                                       }

                                       class60.addMenuEntry("Examine", WallObject.getColTags(16748608) + var55.name, 1004, var67.id, var23, var24);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var19 != -1) {
                        var21 = var19 & 127;
                        var22 = var19 >> 7 & 127;
                        Player var62 = Client.cachedPlayers[Client.field978];
                        class89.method1796(var62, Client.field978, var21, var22);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  if((Client.field1085 == 0 || Client.field1085 == 3) && (MouseInput.field713 == 1 || !Item.field1399 && MouseInput.field713 == 4)) {
                     class217 var59 = var9.method4183(true);
                     if(var59 != null) {
                        var20 = MouseInput.field714 - var10;
                        var21 = MouseInput.field715 - var11;
                        if(var59.method4081(var20, var21)) {
                           var20 -= var59.field2683 / 2;
                           var21 -= var59.field2680 / 2;
                           var22 = Client.mapAngle & 2047;
                           var23 = Graphics3D.SINE[var22];
                           var24 = Graphics3D.COSINE[var22];
                           var25 = var24 * var20 + var21 * var23 >> 11;
                           var26 = var21 * var24 - var20 * var23 >> 11;
                           int var51 = var25 + class48.localPlayer.x >> 7;
                           var28 = class48.localPlayer.y - var26 >> 7;
                           PacketNode var29 = Actor.method1628(ClientPacket.field2354, Client.field952.field1478);
                           var29.packetBuffer.putByte(18);
                           var29.packetBuffer.method3340(var28 + ItemLayer.baseY);
                           var29.packetBuffer.method3340(var51 + ItemLayer.baseX);
                           var29.packetBuffer.method3374(KeyFocusListener.field618[82]?(KeyFocusListener.field618[81]?2:1):0);
                           var29.packetBuffer.putByte(var20);
                           var29.packetBuffer.putByte(var21);
                           var29.packetBuffer.putShort(Client.mapAngle);
                           var29.packetBuffer.putByte(57);
                           var29.packetBuffer.putByte(0);
                           var29.packetBuffer.putByte(0);
                           var29.packetBuffer.putByte(89);
                           var29.packetBuffer.putShort(class48.localPlayer.x);
                           var29.packetBuffer.putShort(class48.localPlayer.y);
                           var29.packetBuffer.putByte(63);
                           Client.field952.method1951(var29);
                           Client.destinationX = var51;
                           Client.destinationY = var28;
                        }
                     }
                  }
               } else {
                  if(var9.contentType == 1400) {
                     Client.renderOverview.method5415(MouseInput.field704, MouseInput.field708, var47, var10, var11, var9.width, var9.height);
                  }

                  if(!Client.isMenuOpen && var47) {
                     if(var9.contentType == 1400) {
                        Client.renderOverview.method5414(var10, var11, var9.width, var9.height, var16, var17);
                     } else {
                        var19 = var16 - var10;
                        var20 = var17 - var11;
                        if(var9.field2729 == 1) {
                           class60.addMenuEntry(var9.tooltip, "", 24, 0, 0, var9.id);
                        }

                        String var37;
                        if(var9.field2729 == 2 && !Client.spellSelected) {
                           if(GraphicsObject.method1747(Preferences.getWidgetConfig(var9)) == 0) {
                              var37 = null;
                           } else if(var9.selectedAction != null && var9.selectedAction.trim().length() != 0) {
                              var37 = var9.selectedAction;
                           } else {
                              var37 = null;
                           }

                           if(var37 != null) {
                              class60.addMenuEntry(var37, WallObject.getColTags(65280) + var9.field2842, 25, 0, -1, var9.id);
                           }
                        }

                        if(var9.field2729 == 3) {
                           class60.addMenuEntry("Close", "", 26, 0, 0, var9.id);
                        }

                        if(var9.field2729 == 4) {
                           class60.addMenuEntry(var9.tooltip, "", 28, 0, 0, var9.id);
                        }

                        if(var9.field2729 == 5) {
                           class60.addMenuEntry(var9.tooltip, "", 29, 0, 0, var9.id);
                        }

                        if(var9.field2729 == 6 && Client.field1013 == null) {
                           class60.addMenuEntry(var9.tooltip, "", 30, 0, -1, var9.id);
                        }

                        if(var9.type == 2) {
                           var21 = 0;

                           for(var22 = 0; var22 < var9.height; ++var22) {
                              for(var23 = 0; var23 < var9.width; ++var23) {
                                 var24 = var23 * (var9.paddingX + 32);
                                 var25 = var22 * (var9.paddingY + 32);
                                 if(var21 < 20) {
                                    var24 += var9.xSprites[var21];
                                    var25 += var9.field2795[var21];
                                 }

                                 if(var19 >= var24 && var20 >= var25 && var19 < var24 + 32 && var20 < var25 + 32) {
                                    Client.field965 = var21;
                                    class111.field1586 = var9;
                                    if(var9.itemIds[var21] > 0) {
                                       label1900: {
                                          ItemComposition var41 = class250.getItemDefinition(var9.itemIds[var21] - 1);
                                          boolean var27;
                                          if(Client.itemSelectionState == 1) {
                                             var28 = Preferences.getWidgetConfig(var9);
                                             var27 = (var28 >> 30 & 1) != 0;
                                             if(var27) {
                                                if(var9.id != class5.field33 || var21 != GameEngine.selectedItemIndex) {
                                                   class60.addMenuEntry("Use", Client.field1118 + " " + "->" + " " + WallObject.getColTags(16748608) + var41.name, 31, var41.id, var21, var9.id);
                                                }
                                                break label1900;
                                             }
                                          }

                                          if(Client.spellSelected) {
                                             var28 = Preferences.getWidgetConfig(var9);
                                             var27 = (var28 >> 30 & 1) != 0;
                                             if(var27) {
                                                if((class228.field2902 & 16) == 16) {
                                                   class60.addMenuEntry(Client.field1007, Client.field1008 + " " + "->" + " " + WallObject.getColTags(16748608) + var41.name, 32, var41.id, var21, var9.id);
                                                }
                                                break label1900;
                                             }
                                          }

                                          String[] var42 = var41.inventoryActions;
                                          if(Client.field869) {
                                             var42 = Friend.method1149(var42);
                                          }

                                          var28 = -1;
                                          if(Client.field997 && KeyFocusListener.field618[81]) {
                                             var28 = var41.method4762();
                                          }

                                          var30 = Preferences.getWidgetConfig(var9);
                                          boolean var43 = (var30 >> 30 & 1) != 0;
                                          if(var43) {
                                             for(var31 = 4; var31 >= 3; --var31) {
                                                if(var31 != var28) {
                                                   class36.method546(var9, var41, var21, var31, false);
                                                }
                                             }
                                          }

                                          Object var10000 = null;
                                          if(Timer.method3089(Preferences.getWidgetConfig(var9))) {
                                             class60.addMenuEntry("Use", WallObject.getColTags(16748608) + var41.name, 38, var41.id, var21, var9.id);
                                          }

                                          int var32 = Preferences.getWidgetConfig(var9);
                                          boolean var56 = (var32 >> 30 & 1) != 0;
                                          int var33;
                                          if(var56) {
                                             for(var33 = 2; var33 >= 0; --var33) {
                                                if(var33 != var28) {
                                                   class36.method546(var9, var41, var21, var33, false);
                                                }
                                             }

                                             if(var28 >= 0) {
                                                class36.method546(var9, var41, var21, var28, true);
                                             }
                                          }

                                          var42 = var9.configActions;
                                          if(Client.field869) {
                                             var42 = Friend.method1149(var42);
                                          }

                                          if(var42 != null) {
                                             for(var33 = 4; var33 >= 0; --var33) {
                                                if(var42[var33] != null) {
                                                   byte var34 = 0;
                                                   if(var33 == 0) {
                                                      var34 = 39;
                                                   }

                                                   if(var33 == 1) {
                                                      var34 = 40;
                                                   }

                                                   if(var33 == 2) {
                                                      var34 = 41;
                                                   }

                                                   if(var33 == 3) {
                                                      var34 = 42;
                                                   }

                                                   if(var33 == 4) {
                                                      var34 = 43;
                                                   }

                                                   class60.addMenuEntry(var42[var33], WallObject.getColTags(16748608) + var41.name, var34, var41.id, var21, var9.id);
                                                }
                                             }
                                          }

                                          class60.addMenuEntry("Examine", WallObject.getColTags(16748608) + var41.name, 1005, var41.id, var21, var9.id);
                                       }
                                    }
                                 }

                                 ++var21;
                              }
                           }
                        }

                        if(var9.hasScript) {
                           if(Client.spellSelected) {
                              var22 = Preferences.getWidgetConfig(var9);
                              boolean var50 = (var22 >> 21 & 1) != 0;
                              if(var50 && (class228.field2902 & 32) == 32) {
                                 class60.addMenuEntry(Client.field1007, Client.field1008 + " " + "->" + " " + var9.name, 58, 0, var9.index, var9.id);
                              }
                           } else {
                              for(var21 = 9; var21 >= 5; --var21) {
                                 String var38;
                                 if(!class115.method2210(Preferences.getWidgetConfig(var9), var21) && var9.field2826 == null) {
                                    var38 = null;
                                 } else if(var9.actions != null && var9.actions.length > var21 && var9.actions[var21] != null && var9.actions[var21].trim().length() != 0) {
                                    var38 = var9.actions[var21];
                                 } else {
                                    var38 = null;
                                 }

                                 if(var38 != null) {
                                    class60.addMenuEntry(var38, var9.name, 1007, var21 + 1, var9.index, var9.id);
                                 }
                              }

                              var37 = Timer.method3094(var9);
                              if(var37 != null) {
                                 class60.addMenuEntry(var37, var9.name, 25, 0, var9.index, var9.id);
                              }

                              for(var22 = 4; var22 >= 0; --var22) {
                                 String var39;
                                 if(!class115.method2210(Preferences.getWidgetConfig(var9), var22) && var9.field2826 == null) {
                                    var39 = null;
                                 } else if(var9.actions != null && var9.actions.length > var22 && var9.actions[var22] != null && var9.actions[var22].trim().length() != 0) {
                                    var39 = var9.actions[var22];
                                 } else {
                                    var39 = null;
                                 }

                                 if(var39 != null) {
                                    class60.addMenuEntry(var39, var9.name, 57, var22 + 1, var9.index, var9.id);
                                 }
                              }

                              if(ChatLineBuffer.method1947(Preferences.getWidgetConfig(var9))) {
                                 class60.addMenuEntry("Continue", "", 30, 0, var9.index, var9.id);
                              }
                           }
                        }
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && class258.method4629(var9) && var9 != field751) {
                        continue;
                     }

                     method1145(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method1145(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var35 = (WidgetNode)Client.componentTable.get((long)var9.id);
                     if(var35 != null) {
                        if(var35.owner == 0 && MouseInput.field704 >= var12 && MouseInput.field708 >= var13 && MouseInput.field704 < var14 && MouseInput.field708 < var15 && !Client.isMenuOpen && !Client.field1081) {
                           for(ScriptEvent var36 = (ScriptEvent)Client.field1048.getFront(); var36 != null; var36 = (ScriptEvent)Client.field1048.getNext()) {
                              if(var36.field786) {
                                 var36.unlink();
                                 var36.widget.field2851 = false;
                              }
                           }

                           if(ScriptVarType.field225 == 0) {
                              Client.field1022 = null;
                              Client.field1023 = null;
                           }

                           if(!Client.isMenuOpen) {
                              class34.method495();
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.field995[0] = false;
                              Client.menuOptionCount = 1;
                           }
                        }

                        GameEngine.method1053(var35.id, var12, var13, var14, var15, var10, var11);
                     }
                  }

                  if(var9.hasScript) {
                     ScriptEvent var58;
                     if(!var9.field2859) {
                        if(var9.field2733 && MouseInput.field704 >= var12 && MouseInput.field708 >= var13 && MouseInput.field704 < var14 && MouseInput.field708 < var15) {
                           for(var58 = (ScriptEvent)Client.field1048.getFront(); var58 != null; var58 = (ScriptEvent)Client.field1048.getNext()) {
                              if(var58.field786 && var58.widget.scrollListener == var58.field791) {
                                 var58.unlink();
                              }
                           }
                        }
                     } else if(MouseInput.field704 >= var12 && MouseInput.field708 >= var13 && MouseInput.field704 < var14 && MouseInput.field708 < var15) {
                        for(var58 = (ScriptEvent)Client.field1048.getFront(); var58 != null; var58 = (ScriptEvent)Client.field1048.getNext()) {
                           if(var58.field786) {
                              var58.unlink();
                              var58.widget.field2851 = false;
                           }
                        }

                        if(ScriptVarType.field225 == 0) {
                           Client.field1022 = null;
                           Client.field1023 = null;
                        }

                        if(!Client.isMenuOpen) {
                           class34.method495();
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.field995[0] = false;
                           Client.menuOptionCount = 1;
                        }
                     }

                     if(MouseInput.field704 >= var12 && MouseInput.field708 >= var13 && MouseInput.field704 < var14 && MouseInput.field708 < var15) {
                        var47 = true;
                     } else {
                        var47 = false;
                     }

                     boolean var49 = false;
                     if((MouseInput.field706 == 1 || !Item.field1399 && MouseInput.field706 == 4) && var47) {
                        var49 = true;
                     }

                     boolean var48 = false;
                     if((MouseInput.field713 == 1 || !Item.field1399 && MouseInput.field713 == 4) && MouseInput.field714 >= var12 && MouseInput.field715 >= var13 && MouseInput.field714 < var14 && MouseInput.field715 < var15) {
                        var48 = true;
                     }

                     if(var48) {
                        Tile.method2608(var9, MouseInput.field714 - var10, MouseInput.field715 - var11);
                     }

                     if(var9.contentType == 1400) {
                        Client.renderOverview.method5554(MouseInput.field704, MouseInput.field708, var47 & var49, var47 & var48);
                     }

                     if(Client.field1022 != null && var9 != Client.field1022 && var47 && FrameMap.method2777(Preferences.getWidgetConfig(var9))) {
                        Client.field1041 = var9;
                     }

                     if(var9 == Client.field1023) {
                        Client.field1027 = true;
                        Client.field1028 = var10;
                        Client.field880 = var11;
                     }

                     if(var9.field2749) {
                        ScriptEvent var60;
                        if(var47 && Client.field1047 != 0 && var9.scrollListener != null) {
                           var60 = new ScriptEvent();
                           var60.field786 = true;
                           var60.widget = var9;
                           var60.field788 = Client.field1047;
                           var60.field791 = var9.scrollListener;
                           Client.field1048.addFront(var60);
                        }

                        if(Client.field1022 != null || ClanMember.field864 != null || Client.isMenuOpen) {
                           var48 = false;
                           var49 = false;
                           var47 = false;
                        }

                        if(!var9.field2852 && var48) {
                           var9.field2852 = true;
                           if(var9.field2846 != null) {
                              var60 = new ScriptEvent();
                              var60.field786 = true;
                              var60.widget = var9;
                              var60.field787 = MouseInput.field714 - var10;
                              var60.field788 = MouseInput.field715 - var11;
                              var60.field791 = var9.field2846;
                              Client.field1048.addFront(var60);
                           }
                        }

                        if(var9.field2852 && var49 && var9.field2755 != null) {
                           var60 = new ScriptEvent();
                           var60.field786 = true;
                           var60.widget = var9;
                           var60.field787 = MouseInput.field704 - var10;
                           var60.field788 = MouseInput.field708 - var11;
                           var60.field791 = var9.field2755;
                           Client.field1048.addFront(var60);
                        }

                        if(var9.field2852 && !var49) {
                           var9.field2852 = false;
                           if(var9.field2810 != null) {
                              var60 = new ScriptEvent();
                              var60.field786 = true;
                              var60.widget = var9;
                              var60.field787 = MouseInput.field704 - var10;
                              var60.field788 = MouseInput.field708 - var11;
                              var60.field791 = var9.field2810;
                              Client.field959.addFront(var60);
                           }
                        }

                        if(var49 && var9.field2811 != null) {
                           var60 = new ScriptEvent();
                           var60.field786 = true;
                           var60.widget = var9;
                           var60.field787 = MouseInput.field704 - var10;
                           var60.field788 = MouseInput.field708 - var11;
                           var60.field791 = var9.field2811;
                           Client.field1048.addFront(var60);
                        }

                        if(!var9.field2851 && var47) {
                           var9.field2851 = true;
                           if(var9.mouseEnterListener != null) {
                              var60 = new ScriptEvent();
                              var60.field786 = true;
                              var60.widget = var9;
                              var60.field787 = MouseInput.field704 - var10;
                              var60.field788 = MouseInput.field708 - var11;
                              var60.field791 = var9.mouseEnterListener;
                              Client.field1048.addFront(var60);
                           }
                        }

                        if(var9.field2851 && var47 && var9.mouseHoverListener != null) {
                           var60 = new ScriptEvent();
                           var60.field786 = true;
                           var60.widget = var9;
                           var60.field787 = MouseInput.field704 - var10;
                           var60.field788 = MouseInput.field708 - var11;
                           var60.field791 = var9.mouseHoverListener;
                           Client.field1048.addFront(var60);
                        }

                        if(var9.field2851 && !var47) {
                           var9.field2851 = false;
                           if(var9.mouseExitListener != null) {
                              var60 = new ScriptEvent();
                              var60.field786 = true;
                              var60.widget = var9;
                              var60.field787 = MouseInput.field704 - var10;
                              var60.field788 = MouseInput.field708 - var11;
                              var60.field791 = var9.mouseExitListener;
                              Client.field959.addFront(var60);
                           }
                        }

                        if(var9.renderListener != null) {
                           var60 = new ScriptEvent();
                           var60.widget = var9;
                           var60.field791 = var9.renderListener;
                           Client.field1061.addFront(var60);
                        }

                        ScriptEvent var40;
                        if(var9.configListenerArgs != null && Client.field1128 > var9.field2730) {
                           if(var9.configTriggers != null && Client.field1128 - var9.field2730 <= 32) {
                              label1534:
                              for(var21 = var9.field2730; var21 < Client.field1128; ++var21) {
                                 var22 = Client.field1035[var21 & 31];

                                 for(var23 = 0; var23 < var9.configTriggers.length; ++var23) {
                                    if(var22 == var9.configTriggers[var23]) {
                                       var40 = new ScriptEvent();
                                       var40.widget = var9;
                                       var40.field791 = var9.configListenerArgs;
                                       Client.field1048.addFront(var40);
                                       break label1534;
                                    }
                                 }
                              }
                           } else {
                              var60 = new ScriptEvent();
                              var60.widget = var9;
                              var60.field791 = var9.configListenerArgs;
                              Client.field1048.addFront(var60);
                           }

                           var9.field2730 = Client.field1128;
                        }

                        if(var9.tableListenerArgs != null && Client.field991 > var9.field2790) {
                           if(var9.tableModTriggers != null && Client.field991 - var9.field2790 <= 32) {
                              label1510:
                              for(var21 = var9.field2790; var21 < Client.field991; ++var21) {
                                 var22 = Client.interfaceItemTriggers[var21 & 31];

                                 for(var23 = 0; var23 < var9.tableModTriggers.length; ++var23) {
                                    if(var22 == var9.tableModTriggers[var23]) {
                                       var40 = new ScriptEvent();
                                       var40.widget = var9;
                                       var40.field791 = var9.tableListenerArgs;
                                       Client.field1048.addFront(var40);
                                       break label1510;
                                    }
                                 }
                              }
                           } else {
                              var60 = new ScriptEvent();
                              var60.widget = var9;
                              var60.field791 = var9.tableListenerArgs;
                              Client.field1048.addFront(var60);
                           }

                           var9.field2790 = Client.field991;
                        }

                        if(var9.skillListenerArgs != null && Client.field1034 > var9.field2772) {
                           if(var9.skillTriggers != null && Client.field1034 - var9.field2772 <= 32) {
                              label1486:
                              for(var21 = var9.field2772; var21 < Client.field1034; ++var21) {
                                 var22 = Client.field1039[var21 & 31];

                                 for(var23 = 0; var23 < var9.skillTriggers.length; ++var23) {
                                    if(var22 == var9.skillTriggers[var23]) {
                                       var40 = new ScriptEvent();
                                       var40.widget = var9;
                                       var40.field791 = var9.skillListenerArgs;
                                       Client.field1048.addFront(var40);
                                       break label1486;
                                    }
                                 }
                              }
                           } else {
                              var60 = new ScriptEvent();
                              var60.widget = var9;
                              var60.field791 = var9.skillListenerArgs;
                              Client.field1048.addFront(var60);
                           }

                           var9.field2772 = Client.field1034;
                        }

                        if(Client.chatCycle > var9.field2714 && var9.field2742 != null) {
                           var60 = new ScriptEvent();
                           var60.widget = var9;
                           var60.field791 = var9.field2742;
                           Client.field1048.addFront(var60);
                        }

                        if(Client.field1042 > var9.field2714 && var9.field2830 != null) {
                           var60 = new ScriptEvent();
                           var60.widget = var9;
                           var60.field791 = var9.field2830;
                           Client.field1048.addFront(var60);
                        }

                        if(Client.field1043 > var9.field2714 && var9.field2798 != null) {
                           var60 = new ScriptEvent();
                           var60.widget = var9;
                           var60.field791 = var9.field2798;
                           Client.field1048.addFront(var60);
                        }

                        if(Client.field1044 > var9.field2714 && var9.field2850 != null) {
                           var60 = new ScriptEvent();
                           var60.widget = var9;
                           var60.field791 = var9.field2850;
                           Client.field1048.addFront(var60);
                        }

                        if(Client.field1045 > var9.field2714 && var9.field2837 != null) {
                           var60 = new ScriptEvent();
                           var60.widget = var9;
                           var60.field791 = var9.field2837;
                           Client.field1048.addFront(var60);
                        }

                        if(Client.field1046 > var9.field2714 && var9.field2832 != null) {
                           var60 = new ScriptEvent();
                           var60.widget = var9;
                           var60.field791 = var9.field2832;
                           Client.field1048.addFront(var60);
                        }

                        var9.field2714 = Client.cycleCntr;
                        if(var9.field2829 != null) {
                           for(var21 = 0; var21 < Client.field885; ++var21) {
                              ScriptEvent var61 = new ScriptEvent();
                              var61.widget = var9;
                              var61.field795 = Client.field1073[var21];
                              var61.field792 = Client.field1072[var21];
                              var61.field791 = var9.field2829;
                              Client.field1048.addFront(var61);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.field1022 == null && ClanMember.field864 == null && !Client.isMenuOpen) {
                     if((var9.field2841 >= 0 || var9.field2809 != 0) && MouseInput.field704 >= var12 && MouseInput.field708 >= var13 && MouseInput.field704 < var14 && MouseInput.field708 < var15) {
                        if(var9.field2841 >= 0) {
                           field751 = var0[var9.field2841];
                        } else {
                           field751 = var9;
                        }
                     }

                     if(var9.type == 8 && MouseInput.field704 >= var12 && MouseInput.field708 >= var13 && MouseInput.field704 < var14 && MouseInput.field708 < var15) {
                        class13.field280 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        var19 = var10 + var9.width;
                        var20 = var9.height;
                        var21 = var9.scrollHeight;
                        var22 = MouseInput.field704;
                        var23 = MouseInput.field708;
                        if(Client.field1092) {
                           Client.field931 = 32;
                        } else {
                           Client.field931 = 0;
                        }

                        Client.field1092 = false;
                        if(MouseInput.field706 == 1 || !Item.field1399 && MouseInput.field706 == 4) {
                           if(var22 >= var19 && var22 < var19 + 16 && var23 >= var11 && var23 < var11 + 16) {
                              var9.scrollY -= 4;
                              WorldMapData.method394(var9);
                           } else if(var22 >= var19 && var22 < var19 + 16 && var23 >= var11 + var20 - 16 && var23 < var11 + var20) {
                              var9.scrollY += 4;
                              WorldMapData.method394(var9);
                           } else if(var22 >= var19 - Client.field931 && var22 < var19 + Client.field931 + 16 && var23 >= var11 + 16 && var23 < var20 + var11 - 16) {
                              var24 = var20 * (var20 - 32) / var21;
                              if(var24 < 8) {
                                 var24 = 8;
                              }

                              var25 = var23 - var11 - 16 - var24 / 2;
                              var26 = var20 - 32 - var24;
                              var9.scrollY = var25 * (var21 - var20) / var26;
                              WorldMapData.method394(var9);
                              Client.field1092 = true;
                           }
                        }

                        if(Client.field1047 != 0) {
                           var24 = var9.width;
                           if(var22 >= var19 - var24 && var23 >= var11 && var22 < var19 + 16 && var23 <= var11 + var20) {
                              var9.scrollY += Client.field1047 * 45;
                              WorldMapData.method394(var9);
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
