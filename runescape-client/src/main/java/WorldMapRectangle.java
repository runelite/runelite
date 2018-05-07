import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
@Implements("WorldMapRectangle")
public final class WorldMapRectangle {
   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("indexTextures")
   static IndexData indexTextures;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 72260519
   )
   @Export("worldMapRegionWidth")
   int worldMapRegionWidth;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1563132525
   )
   @Export("worldMapRegionHeight")
   int worldMapRegionHeight;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1314346791
   )
   @Export("worldMapRegionX")
   int worldMapRegionX;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 870537715
   )
   @Export("worldMapRegionY")
   int worldMapRegionY;
   // $FF: synthetic field
   @ObfuscatedSignature(
      signature = "Lah;"
   )
   final WorldMapManager this$0;

   @ObfuscatedSignature(
      signature = "(Lah;)V"
   )
   WorldMapRectangle(WorldMapManager var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-995938018"
   )
   static boolean method247() {
      return (Client.playerNameMask & 8) != 0;
   }

   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "([Liz;IIIIIIIB)V",
      garbageValue = "36"
   )
   static final void method248(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.hasListener || class1.getWidgetClickMask(var9) != 0 || var9 == Client.field1024 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !MapIconReference.method762(var9))) {
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

            if(var9 == Client.draggedWidget) {
               Client.field1031 = true;
               Client.field901 = var10;
               Client.field1098 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = MouseInput.mouseLastX;
               var17 = MouseInput.mouseLastY;
               if(MouseInput.mouseLastButton != 0) {
                  var16 = MouseInput.mouseLastPressedX;
                  var17 = MouseInput.mouseLastPressedY;
               }

               boolean var43 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               int var20;
               int var22;
               int var23;
               int var24;
               int var25;
               int var26;
               int var46;
               if(var9.contentType == 1337) {
                  if(!Client.field995 && !Client.isMenuOpen && var43) {
                     if(Client.itemSelectionState == 0 && !Client.spellSelected) {
                        class150.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var19 = -1;
                     var20 = -1;

                     for(var46 = 0; var46 < class132.Viewport_entityCountAtMouse; ++var46) {
                        var22 = class132.Viewport_entityIdsAtMouse[var46];
                        var23 = var22 & 127;
                        var24 = var22 >> 7 & 127;
                        var25 = var22 >> 29 & 3;
                        var26 = var22 >> 14 & 32767;
                        if(var22 != var20) {
                           var20 = var22;
                           if(var25 == 2 && GameSocket.region.getObjectFlags(ScriptVarType.plane, var23, var24, var22) >= 0) {
                              ObjectComposition var27 = class80.getObjectDefinition(var26);
                              if(var27.impostorIds != null) {
                                 var27 = var27.getImpostor();
                              }

                              if(var27 == null) {
                                 continue;
                              }

                              if(Client.itemSelectionState == 1) {
                                 class150.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + DynamicObject.getColTags(65535) + var27.name, 1, var22, var23, var24);
                              } else if(Client.spellSelected) {
                                 if((class49.field605 & 4) == 4) {
                                    class150.addMenuEntry(Client.field1010, Client.field1063 + " " + "->" + " " + DynamicObject.getColTags(65535) + var27.name, 2, var22, var23, var24);
                                 }
                              } else {
                                 String[] var28 = var27.actions;
                                 if(var28 != null) {
                                    for(int var36 = 4; var36 >= 0; --var36) {
                                       if(var28[var36] != null) {
                                          short var30 = 0;
                                          if(var36 == 0) {
                                             var30 = 3;
                                          }

                                          if(var36 == 1) {
                                             var30 = 4;
                                          }

                                          if(var36 == 2) {
                                             var30 = 5;
                                          }

                                          if(var36 == 3) {
                                             var30 = 6;
                                          }

                                          if(var36 == 4) {
                                             var30 = 1001;
                                          }

                                          class150.addMenuEntry(var28[var36], DynamicObject.getColTags(65535) + var27.name, var30, var22, var23, var24);
                                       }
                                    }
                                 }

                                 class150.addMenuEntry("Examine", DynamicObject.getColTags(65535) + var27.name, 1002, var27.id << 14, var23, var24);
                              }
                           }

                           NPC var29;
                           Player var31;
                           int var35;
                           int[] var51;
                           int var53;
                           if(var25 == 1) {
                              NPC var47 = Client.cachedNPCs[var26];
                              if(var47 == null) {
                                 continue;
                              }

                              if(var47.composition.size == 1 && (var47.x & 127) == 64 && (var47.y & 127) == 64) {
                                 for(var35 = 0; var35 < Client.npcIndexesCount; ++var35) {
                                    var29 = Client.cachedNPCs[Client.npcIndices[var35]];
                                    if(var29 != null && var29 != var47 && var29.composition.size == 1 && var29.x == var47.x && var47.y == var29.y) {
                                       TotalQuantityComparator.method101(var29.composition, Client.npcIndices[var35], var23, var24);
                                    }
                                 }

                                 var35 = class93.playerIndexesCount;
                                 var51 = class93.playerIndices;

                                 for(var53 = 0; var53 < var35; ++var53) {
                                    var31 = Client.cachedPlayers[var51[var53]];
                                    if(var31 != null && var47.x == var31.x && var47.y == var31.y) {
                                       class243.method4597(var31, var51[var53], var23, var24);
                                    }
                                 }
                              }

                              TotalQuantityComparator.method101(var47.composition, var26, var23, var24);
                           }

                           if(var25 == 0) {
                              Player var48 = Client.cachedPlayers[var26];
                              if(var48 == null) {
                                 continue;
                              }

                              if((var48.x & 127) == 64 && (var48.y & 127) == 64) {
                                 for(var35 = 0; var35 < Client.npcIndexesCount; ++var35) {
                                    var29 = Client.cachedNPCs[Client.npcIndices[var35]];
                                    if(var29 != null && var29.composition.size == 1 && var29.x == var48.x && var48.y == var29.y) {
                                       TotalQuantityComparator.method101(var29.composition, Client.npcIndices[var35], var23, var24);
                                    }
                                 }

                                 var35 = class93.playerIndexesCount;
                                 var51 = class93.playerIndices;

                                 for(var53 = 0; var53 < var35; ++var53) {
                                    var31 = Client.cachedPlayers[var51[var53]];
                                    if(var31 != null && var31 != var48 && var31.x == var48.x && var31.y == var48.y) {
                                       class243.method4597(var31, var51[var53], var23, var24);
                                    }
                                 }
                              }

                              if(var26 != Client.field978) {
                                 class243.method4597(var48, var26, var23, var24);
                              } else {
                                 var19 = var22;
                              }
                           }

                           if(var25 == 3) {
                              Deque var50 = Client.groundItemDeque[ScriptVarType.plane][var23][var24];
                              if(var50 != null) {
                                 for(Item var49 = (Item)var50.getTail(); var49 != null; var49 = (Item)var50.getPrevious()) {
                                    ItemComposition var52 = NetWriter.getItemDefinition(var49.id);
                                    if(Client.itemSelectionState == 1) {
                                       class150.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + DynamicObject.getColTags(16748608) + var52.name, 16, var49.id, var23, var24);
                                    } else if(Client.spellSelected) {
                                       if((class49.field605 & 1) == 1) {
                                          class150.addMenuEntry(Client.field1010, Client.field1063 + " " + "->" + " " + DynamicObject.getColTags(16748608) + var52.name, 17, var49.id, var23, var24);
                                       }
                                    } else {
                                       String[] var37 = var52.groundActions;

                                       for(int var38 = 4; var38 >= 0; --var38) {
                                          if(var37 != null && var37[var38] != null) {
                                             byte var32 = 0;
                                             if(var38 == 0) {
                                                var32 = 18;
                                             }

                                             if(var38 == 1) {
                                                var32 = 19;
                                             }

                                             if(var38 == 2) {
                                                var32 = 20;
                                             }

                                             if(var38 == 3) {
                                                var32 = 21;
                                             }

                                             if(var38 == 4) {
                                                var32 = 22;
                                             }

                                             class150.addMenuEntry(var37[var38], DynamicObject.getColTags(16748608) + var52.name, var32, var49.id, var23, var24);
                                          } else if(var38 == 2) {
                                             class150.addMenuEntry("Take", DynamicObject.getColTags(16748608) + var52.name, 20, var49.id, var23, var24);
                                          }
                                       }

                                       class150.addMenuEntry("Examine", DynamicObject.getColTags(16748608) + var52.name, 1004, var49.id, var23, var24);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var19 != -1) {
                        var46 = var19 & 127;
                        var22 = var19 >> 7 & 127;
                        Player var39 = Client.cachedPlayers[Client.field978];
                        class243.method4597(var39, Client.field978, var46, var22);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  SoundTaskDataProvider.method828(var9, var10, var11);
               } else {
                  if(var9.contentType == 1400) {
                     class196.renderOverview.method6068(MouseInput.mouseLastX, MouseInput.mouseLastY, var43, var10, var11, var9.width, var9.height);
                  }

                  if(!Client.isMenuOpen && var43) {
                     if(var9.contentType == 1400) {
                        class196.renderOverview.method6119(var10, var11, var9.width, var9.height, var16, var17);
                     } else {
                        GameCanvas.method842(var9, var16 - var10, var17 - var11);
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && MapIconReference.method762(var9) && var9 != GameCanvas.field642) {
                        continue;
                     }

                     method248(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method248(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var33 = (WidgetNode)Client.componentTable.get((long)var9.id);
                     if(var33 != null) {
                        if(var33.owner == 0 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15 && !Client.isMenuOpen) {
                           for(ScriptEvent var34 = (ScriptEvent)Client.field1049.getFront(); var34 != null; var34 = (ScriptEvent)Client.field1049.getNext()) {
                              if(var34.boolean1) {
                                 var34.unlink();
                                 var34.source.field2946 = false;
                              }
                           }

                           if(class23.field352 == 0) {
                              Client.draggedWidget = null;
                              Client.field1024 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Signlink.method3322();
                           }
                        }

                        var20 = var33.id;
                        if(class85.loadWidget(var20)) {
                           method248(GZipDecompressor.widgets[var20], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.hasScript) {
                     ScriptEvent var54;
                     if(!var9.noClickThrough) {
                        if(var9.noScrollThrough && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                           for(var54 = (ScriptEvent)Client.field1049.getFront(); var54 != null; var54 = (ScriptEvent)Client.field1049.getNext()) {
                              if(var54.boolean1 && var54.source.onScrollWheelListener == var54.objs) {
                                 var54.unlink();
                              }
                           }
                        }
                     } else if(MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        for(var54 = (ScriptEvent)Client.field1049.getFront(); var54 != null; var54 = (ScriptEvent)Client.field1049.getNext()) {
                           if(var54.boolean1) {
                              var54.unlink();
                              var54.source.field2946 = false;
                           }
                        }

                        if(class23.field352 == 0) {
                           Client.draggedWidget = null;
                           Client.field1024 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Signlink.method3322();
                        }
                     }

                     if(MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        var43 = true;
                     } else {
                        var43 = false;
                     }

                     boolean var44 = false;
                     if((MouseInput.mouseCurrentButton == 1 || !Occluder.middleMouseMovesCamera && MouseInput.mouseCurrentButton == 4) && var43) {
                        var44 = true;
                     }

                     boolean var45 = false;
                     if((MouseInput.mouseLastButton == 1 || !Occluder.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= var12 && MouseInput.mouseLastPressedY >= var13 && MouseInput.mouseLastPressedX < var14 && MouseInput.mouseLastPressedY < var15) {
                        var45 = true;
                     }

                     if(var45) {
                        PacketBuffer.method3863(var9, MouseInput.mouseLastPressedX - var10, MouseInput.mouseLastPressedY - var11);
                     }

                     if(var9.contentType == 1400) {
                        class196.renderOverview.method6200(var16, var17, var43 & var44, var43 & var45);
                     }

                     if(Client.draggedWidget != null && var9 != Client.draggedWidget && var43) {
                        var22 = class1.getWidgetClickMask(var9);
                        boolean var21 = (var22 >> 20 & 1) != 0;
                        if(var21) {
                           Client.draggedOnWidget = var9;
                        }
                     }

                     if(var9 == Client.field1024) {
                        Client.field1028 = true;
                        Client.field1029 = var10;
                        Client.field954 = var11;
                     }

                     if(var9.hasListener) {
                        ScriptEvent var40;
                        if(var43 && Client.mouseWheelRotation != 0 && var9.onScrollWheelListener != null) {
                           var40 = new ScriptEvent();
                           var40.boolean1 = true;
                           var40.source = var9;
                           var40.mouseY = Client.mouseWheelRotation;
                           var40.objs = var9.onScrollWheelListener;
                           Client.field1049.addFront(var40);
                        }

                        if(Client.draggedWidget != null || KeyFocusListener.field635 != null || Client.isMenuOpen) {
                           var45 = false;
                           var44 = false;
                           var43 = false;
                        }

                        if(!var9.field2906 && var45) {
                           var9.field2906 = true;
                           if(var9.onClickListener != null) {
                              var40 = new ScriptEvent();
                              var40.boolean1 = true;
                              var40.source = var9;
                              var40.mouseX = MouseInput.mouseLastPressedX - var10;
                              var40.mouseY = MouseInput.mouseLastPressedY - var11;
                              var40.objs = var9.onClickListener;
                              Client.field1049.addFront(var40);
                           }
                        }

                        if(var9.field2906 && var44 && var9.onClickRepeatListener != null) {
                           var40 = new ScriptEvent();
                           var40.boolean1 = true;
                           var40.source = var9;
                           var40.mouseX = MouseInput.mouseLastX - var10;
                           var40.mouseY = MouseInput.mouseLastY - var11;
                           var40.objs = var9.onClickRepeatListener;
                           Client.field1049.addFront(var40);
                        }

                        if(var9.field2906 && !var44) {
                           var9.field2906 = false;
                           if(var9.onReleaseListener != null) {
                              var40 = new ScriptEvent();
                              var40.boolean1 = true;
                              var40.source = var9;
                              var40.mouseX = MouseInput.mouseLastX - var10;
                              var40.mouseY = MouseInput.mouseLastY - var11;
                              var40.objs = var9.onReleaseListener;
                              Client.field1051.addFront(var40);
                           }
                        }

                        if(var44 && var9.onHoldListener != null) {
                           var40 = new ScriptEvent();
                           var40.boolean1 = true;
                           var40.source = var9;
                           var40.mouseX = MouseInput.mouseLastX - var10;
                           var40.mouseY = MouseInput.mouseLastY - var11;
                           var40.objs = var9.onHoldListener;
                           Client.field1049.addFront(var40);
                        }

                        if(!var9.field2946 && var43) {
                           var9.field2946 = true;
                           if(var9.onMouseOverListener != null) {
                              var40 = new ScriptEvent();
                              var40.boolean1 = true;
                              var40.source = var9;
                              var40.mouseX = MouseInput.mouseLastX - var10;
                              var40.mouseY = MouseInput.mouseLastY - var11;
                              var40.objs = var9.onMouseOverListener;
                              Client.field1049.addFront(var40);
                           }
                        }

                        if(var9.field2946 && var43 && var9.onMouseRepeatListener != null) {
                           var40 = new ScriptEvent();
                           var40.boolean1 = true;
                           var40.source = var9;
                           var40.mouseX = MouseInput.mouseLastX - var10;
                           var40.mouseY = MouseInput.mouseLastY - var11;
                           var40.objs = var9.onMouseRepeatListener;
                           Client.field1049.addFront(var40);
                        }

                        if(var9.field2946 && !var43) {
                           var9.field2946 = false;
                           if(var9.onMouseLeaveListener != null) {
                              var40 = new ScriptEvent();
                              var40.boolean1 = true;
                              var40.source = var9;
                              var40.mouseX = MouseInput.mouseLastX - var10;
                              var40.mouseY = MouseInput.mouseLastY - var11;
                              var40.objs = var9.onMouseLeaveListener;
                              Client.field1051.addFront(var40);
                           }
                        }

                        if(var9.onTimerListener != null) {
                           var40 = new ScriptEvent();
                           var40.source = var9;
                           var40.objs = var9.onTimerListener;
                           Client.field976.addFront(var40);
                        }

                        ScriptEvent var41;
                        if(var9.onVarTransmitListener != null && Client.pendingVarbitCount > var9.field2949) {
                           if(var9.varTransmitTriggers != null && Client.pendingVarbitCount - var9.field2949 <= 32) {
                              label1184:
                              for(var46 = var9.field2949; var46 < Client.pendingVarbitCount; ++var46) {
                                 var22 = Client.pendingVarbitChanges[var46 & 31];

                                 for(var23 = 0; var23 < var9.varTransmitTriggers.length; ++var23) {
                                    if(var22 == var9.varTransmitTriggers[var23]) {
                                       var41 = new ScriptEvent();
                                       var41.source = var9;
                                       var41.objs = var9.onVarTransmitListener;
                                       Client.field1049.addFront(var41);
                                       break label1184;
                                    }
                                 }
                              }
                           } else {
                              var40 = new ScriptEvent();
                              var40.source = var9;
                              var40.objs = var9.onVarTransmitListener;
                              Client.field1049.addFront(var40);
                           }

                           var9.field2949 = Client.pendingVarbitCount;
                        }

                        if(var9.onInvTransmitListener != null && Client.field1032 > var9.field2835) {
                           if(var9.invTransmitTriggers != null && Client.field1032 - var9.field2835 <= 32) {
                              label1160:
                              for(var46 = var9.field2835; var46 < Client.field1032; ++var46) {
                                 var22 = Client.interfaceItemTriggers[var46 & 31];

                                 for(var23 = 0; var23 < var9.invTransmitTriggers.length; ++var23) {
                                    if(var22 == var9.invTransmitTriggers[var23]) {
                                       var41 = new ScriptEvent();
                                       var41.source = var9;
                                       var41.objs = var9.onInvTransmitListener;
                                       Client.field1049.addFront(var41);
                                       break label1160;
                                    }
                                 }
                              }
                           } else {
                              var40 = new ScriptEvent();
                              var40.source = var9;
                              var40.objs = var9.onInvTransmitListener;
                              Client.field1049.addFront(var40);
                           }

                           var9.field2835 = Client.field1032;
                        }

                        if(var9.onStatTransmitListener != null && Client.changedSkillsCount > var9.field2951) {
                           if(var9.statTransmitTriggers != null && Client.changedSkillsCount - var9.field2951 <= 32) {
                              label1136:
                              for(var46 = var9.field2951; var46 < Client.changedSkillsCount; ++var46) {
                                 var22 = Client.changedSkills[var46 & 31];

                                 for(var23 = 0; var23 < var9.statTransmitTriggers.length; ++var23) {
                                    if(var22 == var9.statTransmitTriggers[var23]) {
                                       var41 = new ScriptEvent();
                                       var41.source = var9;
                                       var41.objs = var9.onStatTransmitListener;
                                       Client.field1049.addFront(var41);
                                       break label1136;
                                    }
                                 }
                              }
                           } else {
                              var40 = new ScriptEvent();
                              var40.source = var9;
                              var40.objs = var9.onStatTransmitListener;
                              Client.field1049.addFront(var40);
                           }

                           var9.field2951 = Client.changedSkillsCount;
                        }

                        if(Client.chatCycle > var9.field2948 && var9.onChatTransmitListener != null) {
                           var40 = new ScriptEvent();
                           var40.source = var9;
                           var40.objs = var9.onChatTransmitListener;
                           Client.field1049.addFront(var40);
                        }

                        if(Client.field1045 > var9.field2948 && var9.onFriendTransmitListener != null) {
                           var40 = new ScriptEvent();
                           var40.source = var9;
                           var40.objs = var9.onFriendTransmitListener;
                           Client.field1049.addFront(var40);
                        }

                        if(Client.field891 > var9.field2948 && var9.onClanTransmitListener != null) {
                           var40 = new ScriptEvent();
                           var40.source = var9;
                           var40.objs = var9.onClanTransmitListener;
                           Client.field1049.addFront(var40);
                        }

                        if(Client.field881 > var9.field2948 && var9.onStockTransmitListener != null) {
                           var40 = new ScriptEvent();
                           var40.source = var9;
                           var40.objs = var9.onStockTransmitListener;
                           Client.field1049.addFront(var40);
                        }

                        if(Client.field1046 > var9.field2948 && var9.onCamFinishedListener != null) {
                           var40 = new ScriptEvent();
                           var40.source = var9;
                           var40.objs = var9.onCamFinishedListener;
                           Client.field1049.addFront(var40);
                        }

                        if(Client.field987 > var9.field2948 && var9.onMiscTransmitListener != null) {
                           var40 = new ScriptEvent();
                           var40.source = var9;
                           var40.objs = var9.onMiscTransmitListener;
                           Client.field1049.addFront(var40);
                        }

                        var9.field2948 = Client.cycleCntr;
                        if(var9.onKeyListener != null) {
                           for(var46 = 0; var46 < Client.field1089; ++var46) {
                              ScriptEvent var42 = new ScriptEvent();
                              var42.source = var9;
                              var42.typedKeyCode = Client.field1039[var46];
                              var42.typedKey = Client.field957[var46];
                              var42.objs = var9.onKeyListener;
                              Client.field1049.addFront(var42);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.draggedWidget == null && KeyFocusListener.field635 == null && !Client.isMenuOpen) {
                     if((var9.field2862 >= 0 || var9.field2841 != 0) && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        if(var9.field2862 >= 0) {
                           GameCanvas.field642 = var0[var9.field2862];
                        } else {
                           GameCanvas.field642 = var9;
                        }
                     }

                     if(var9.type == 8 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        FrameMap.field1950 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        var19 = var10 + var9.width;
                        var20 = var9.height;
                        var46 = var9.scrollHeight;
                        var22 = MouseInput.mouseLastX;
                        var23 = MouseInput.mouseLastY;
                        if(Client.field918) {
                           Client.field919 = 32;
                        } else {
                           Client.field919 = 0;
                        }

                        Client.field918 = false;
                        if(MouseInput.mouseCurrentButton == 1 || !Occluder.middleMouseMovesCamera && MouseInput.mouseCurrentButton == 4) {
                           if(var22 >= var19 && var22 < var19 + 16 && var23 >= var11 && var23 < var11 + 16) {
                              var9.scrollY -= 4;
                              TotalQuantityComparator.method100(var9);
                           } else if(var22 >= var19 && var22 < var19 + 16 && var23 >= var20 + var11 - 16 && var23 < var11 + var20) {
                              var9.scrollY += 4;
                              TotalQuantityComparator.method100(var9);
                           } else if(var22 >= var19 - Client.field919 && var22 < var19 + Client.field919 + 16 && var23 >= var11 + 16 && var23 < var20 + var11 - 16) {
                              var24 = var20 * (var20 - 32) / var46;
                              if(var24 < 8) {
                                 var24 = 8;
                              }

                              var25 = var23 - var11 - 16 - var24 / 2;
                              var26 = var20 - 32 - var24;
                              var9.scrollY = var25 * (var46 - var20) / var26;
                              TotalQuantityComparator.method100(var9);
                              Client.field918 = true;
                           }
                        }

                        if(Client.mouseWheelRotation != 0) {
                           var24 = var9.width;
                           if(var22 >= var19 - var24 && var23 >= var11 && var22 < var19 + 16 && var23 <= var20 + var11) {
                              var9.scrollY += Client.mouseWheelRotation * 45;
                              TotalQuantityComparator.method100(var9);
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
