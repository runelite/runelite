import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1272934461
   )
   static int field1459;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1706735479
   )
   @Export("id")
   int id;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2056386017
   )
   @Export("type")
   int type;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1300672129
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1889733847
   )
   @Export("level")
   int level;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1793260165
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2113133667
   )
   @Export("sceneY")
   int sceneY;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   Sequence field1456;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 758956679
   )
   int field1457;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -947296379
   )
   int field1458;

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLes;)V"
   )
   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1456 = GrandExchangeEvents.getAnimation(var7);
         this.field1457 = 0;
         this.field1458 = Client.gameCycle - 1;
         if(this.field1456.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(this.field1456 == var10.field1456) {
               this.field1457 = var10.field1457;
               this.field1458 = var10.field1458;
               return;
            }
         }

         if(var8 && this.field1456.frameStep != -1) {
            this.field1457 = (int)(Math.random() * (double)this.field1456.frameIDs.length);
            this.field1458 -= (int)(Math.random() * (double)this.field1456.frameLenghts[this.field1457]);
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Leh;",
      garbageValue = "-473112722"
   )
   protected final Model getModel() {
      if(this.field1456 != null) {
         int var1 = Client.gameCycle - this.field1458;
         if(var1 > 100 && this.field1456.frameStep > 0) {
            var1 = 100;
         }

         label56: {
            do {
               do {
                  if(var1 <= this.field1456.frameLenghts[this.field1457]) {
                     break label56;
                  }

                  var1 -= this.field1456.frameLenghts[this.field1457];
                  ++this.field1457;
               } while(this.field1457 < this.field1456.frameIDs.length);

               this.field1457 -= this.field1456.frameStep;
            } while(this.field1457 >= 0 && this.field1457 < this.field1456.frameIDs.length);

            this.field1456 = null;
         }

         this.field1458 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = class3.getObjectDefinition(this.id);
      if(var12.impostorIds != null) {
         var12 = var12.getImpostor();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.orientation != 1 && this.orientation != 3) {
            var2 = var12.sizeX;
            var3 = var12.sizeY;
         } else {
            var2 = var12.sizeY;
            var3 = var12.sizeX;
         }

         int var4 = (var2 >> 1) + this.sceneX;
         int var5 = (var2 + 1 >> 1) + this.sceneX;
         int var6 = (var3 >> 1) + this.sceneY;
         int var7 = (var3 + 1 >> 1) + this.sceneY;
         int[][] var8 = class61.tileHeights[this.level];
         int var9 = var8[var5][var7] + var8[var4][var6] + var8[var5][var6] + var8[var4][var7] >> 2;
         int var10 = (this.sceneX << 7) + (var2 << 6);
         int var11 = (this.sceneY << 7) + (var3 << 6);
         return var12.method4746(this.type, this.orientation, var8, var10, var9, var11, this.field1456, this.field1457);
      }
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "([Lhx;IIIIIIII)V",
      garbageValue = "-854506870"
   )
   static final void method1910(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2770 || ClanMember.getWidgetConfig(var9) != 0 || var9 == Client.field1028 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !Buffer.method3509(var9))) {
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

            if(var9 == Client.field1027) {
               Client.field991 = true;
               Client.field1103 = var10;
               Client.field1037 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = MouseInput.field703;
               var17 = MouseInput.field715 * 10625923;
               if(MouseInput.mouseLastButton != 0) {
                  var16 = MouseInput.mouseLastPressedX;
                  var17 = MouseInput.mouseLastPressedY;
               }

               boolean var49 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               int var20;
               int var21;
               int var22;
               int var23;
               int var24;
               int var25;
               int var26;
               int var31;
               int var41;
               int var42;
               if(var9.contentType == 1337) {
                  if(!Client.field879 && !Client.isMenuOpen && var49) {
                     if(Client.itemSelectionState == 0 && !Client.spellSelected) {
                        RSCanvas.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var19 = -1;
                     var20 = -1;

                     for(var21 = 0; var21 < class133.Viewport_entityCountAtMouse; ++var21) {
                        var22 = class133.Viewport_entityIdsAtMouse[var21];
                        var23 = var22 & 127;
                        var24 = var22 >> 7 & 127;
                        var25 = var22 >> 29 & 3;
                        var26 = var22 >> 14 & 32767;
                        if(var22 != var20) {
                           var20 = var22;
                           if(var25 == 2 && GrandExchangeEvent.region.getObjectFlags(class233.plane, var23, var24, var22) >= 0) {
                              ObjectComposition var52 = class3.getObjectDefinition(var26);
                              if(var52.impostorIds != null) {
                                 var52 = var52.getImpostor();
                              }

                              if(var52 == null) {
                                 continue;
                              }

                              if(Client.itemSelectionState == 1) {
                                 RSCanvas.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + ISAACCipher.getColTags(65535) + var52.name, 1, var22, var23, var24);
                              } else if(Client.spellSelected) {
                                 if((class156.field2161 & 4) == 4) {
                                    RSCanvas.addMenuEntry(Client.lastSelectedSpellActionName, Client.lastSelectedSpellName + " " + "->" + " " + ISAACCipher.getColTags(65535) + var52.name, 2, var22, var23, var24);
                                 }
                              } else {
                                 String[] var28 = var52.actions;
                                 if(Client.numberMenuOptions) {
                                    var28 = GroundObject.prependIndices(var28);
                                 }

                                 if(var28 != null) {
                                    for(int var63 = 4; var63 >= 0; --var63) {
                                       if(var28[var63] != null) {
                                          short var64 = 0;
                                          if(var63 == 0) {
                                             var64 = 3;
                                          }

                                          if(var63 == 1) {
                                             var64 = 4;
                                          }

                                          if(var63 == 2) {
                                             var64 = 5;
                                          }

                                          if(var63 == 3) {
                                             var64 = 6;
                                          }

                                          if(var63 == 4) {
                                             var64 = 1001;
                                          }

                                          RSCanvas.addMenuEntry(var28[var63], ISAACCipher.getColTags(65535) + var52.name, var64, var22, var23, var24);
                                       }
                                    }
                                 }

                                 RSCanvas.addMenuEntry("Examine", ISAACCipher.getColTags(65535) + var52.name, 1002, var52.id << 14, var23, var24);
                              }
                           }

                           NPC var29;
                           Player var43;
                           int[] var54;
                           if(var25 == 1) {
                              NPC var55 = Client.cachedNPCs[var26];
                              if(var55 == null) {
                                 continue;
                              }

                              if(var55.composition.field3619 == 1 && (var55.x & 127) == 64 && (var55.y & 127) == 64) {
                                 for(var42 = 0; var42 < Client.npcIndexesCount; ++var42) {
                                    var29 = Client.cachedNPCs[Client.npcIndices[var42]];
                                    if(var29 != null && var55 != var29 && var29.composition.field3619 == 1 && var55.x == var29.x && var55.y == var29.y) {
                                       GrandExchangeOffer.method135(var29.composition, Client.npcIndices[var42], var23, var24);
                                    }
                                 }

                                 var42 = class94.playerIndexesCount;
                                 var54 = class94.playerIndices;

                                 for(var41 = 0; var41 < var42; ++var41) {
                                    var43 = Client.cachedPlayers[var54[var41]];
                                    if(var43 != null && var55.x == var43.x && var55.y == var43.y) {
                                       MessageNode.method1138(var43, var54[var41], var23, var24);
                                    }
                                 }
                              }

                              GrandExchangeOffer.method135(var55.composition, var26, var23, var24);
                           }

                           if(var25 == 0) {
                              Player var56 = Client.cachedPlayers[var26];
                              if(var56 == null) {
                                 continue;
                              }

                              if((var56.x & 127) == 64 && (var56.y & 127) == 64) {
                                 for(var42 = 0; var42 < Client.npcIndexesCount; ++var42) {
                                    var29 = Client.cachedNPCs[Client.npcIndices[var42]];
                                    if(var29 != null && var29.composition.field3619 == 1 && var29.x == var56.x && var29.y == var56.y) {
                                       GrandExchangeOffer.method135(var29.composition, Client.npcIndices[var42], var23, var24);
                                    }
                                 }

                                 var42 = class94.playerIndexesCount;
                                 var54 = class94.playerIndices;

                                 for(var41 = 0; var41 < var42; ++var41) {
                                    var43 = Client.cachedPlayers[var54[var41]];
                                    if(var43 != null && var56 != var43 && var43.x == var56.x && var56.y == var43.y) {
                                       MessageNode.method1138(var43, var54[var41], var23, var24);
                                    }
                                 }
                              }

                              if(var26 != Client.field1094) {
                                 MessageNode.method1138(var56, var26, var23, var24);
                              } else {
                                 var19 = var22;
                              }
                           }

                           if(var25 == 3) {
                              Deque var57 = Client.groundItemDeque[class233.plane][var23][var24];
                              if(var57 != null) {
                                 for(Item var53 = (Item)var57.getTail(); var53 != null; var53 = (Item)var57.getPrevious()) {
                                    ItemComposition var58 = WorldMapType2.getItemDefinition(var53.id);
                                    if(Client.itemSelectionState == 1) {
                                       RSCanvas.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + ISAACCipher.getColTags(16748608) + var58.name, 16, var53.id, var23, var24);
                                    } else if(Client.spellSelected) {
                                       if((class156.field2161 & 1) == 1) {
                                          RSCanvas.addMenuEntry(Client.lastSelectedSpellActionName, Client.lastSelectedSpellName + " " + "->" + " " + ISAACCipher.getColTags(16748608) + var58.name, 17, var53.id, var23, var24);
                                       }
                                    } else {
                                       String[] var30 = var58.groundActions;
                                       if(Client.numberMenuOptions) {
                                          var30 = GroundObject.prependIndices(var30);
                                       }

                                       for(var31 = 4; var31 >= 0; --var31) {
                                          if(var30 != null && var30[var31] != null) {
                                             byte var60 = 0;
                                             if(var31 == 0) {
                                                var60 = 18;
                                             }

                                             if(var31 == 1) {
                                                var60 = 19;
                                             }

                                             if(var31 == 2) {
                                                var60 = 20;
                                             }

                                             if(var31 == 3) {
                                                var60 = 21;
                                             }

                                             if(var31 == 4) {
                                                var60 = 22;
                                             }

                                             RSCanvas.addMenuEntry(var30[var31], ISAACCipher.getColTags(16748608) + var58.name, var60, var53.id, var23, var24);
                                          } else if(var31 == 2) {
                                             RSCanvas.addMenuEntry("Take", ISAACCipher.getColTags(16748608) + var58.name, 20, var53.id, var23, var24);
                                          }
                                       }

                                       RSCanvas.addMenuEntry("Examine", ISAACCipher.getColTags(16748608) + var58.name, 1004, var53.id, var23, var24);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var19 != -1) {
                        var21 = var19 & 127;
                        var22 = var19 >> 7 & 127;
                        Player var65 = Client.cachedPlayers[Client.field1094];
                        MessageNode.method1138(var65, Client.field1094, var21, var22);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  GrandExchangeOffer.method132(var9, var10, var11);
               } else {
                  if(var9.contentType == 1400) {
                     MouseInput.renderOverview.method5395(MouseInput.field703, MouseInput.field715 * 10625923, var49, var10, var11, var9.width, var9.height);
                  }

                  if(!Client.isMenuOpen && var49) {
                     if(var9.contentType == 1400) {
                        MouseInput.renderOverview.method5441(var10, var11, var9.width, var9.height, var16, var17);
                     } else {
                        var19 = var16 - var10;
                        var20 = var17 - var11;
                        if(var9.field2727 == 1) {
                           RSCanvas.addMenuEntry(var9.tooltip, "", 24, 0, 0, var9.id);
                        }

                        String var39;
                        if(var9.field2727 == 2 && !Client.spellSelected) {
                           var39 = DecorativeObject.method3017(var9);
                           if(var39 != null) {
                              RSCanvas.addMenuEntry(var39, ISAACCipher.getColTags(65280) + var9.spellName, 25, 0, -1, var9.id);
                           }
                        }

                        if(var9.field2727 == 3) {
                           RSCanvas.addMenuEntry("Close", "", 26, 0, 0, var9.id);
                        }

                        if(var9.field2727 == 4) {
                           RSCanvas.addMenuEntry(var9.tooltip, "", 28, 0, 0, var9.id);
                        }

                        if(var9.field2727 == 5) {
                           RSCanvas.addMenuEntry(var9.tooltip, "", 29, 0, 0, var9.id);
                        }

                        if(var9.field2727 == 6 && Client.field1018 == null) {
                           RSCanvas.addMenuEntry(var9.tooltip, "", 30, 0, -1, var9.id);
                        }

                        if(var9.type == 2) {
                           var21 = 0;

                           for(var22 = 0; var22 < var9.height; ++var22) {
                              for(var23 = 0; var23 < var9.width; ++var23) {
                                 var24 = var23 * (var9.paddingX + 32);
                                 var25 = var22 * (var9.paddingY + 32);
                                 if(var21 < 20) {
                                    var24 += var9.xSprites[var21];
                                    var25 += var9.field2838[var21];
                                 }

                                 if(var19 >= var24 && var20 >= var25 && var19 < var24 + 32 && var20 < var25 + 32) {
                                    Client.field1001 = var21;
                                    WorldMapType2.field497 = var9;
                                    if(var9.itemIds[var21] > 0) {
                                       label1750: {
                                          ItemComposition var46 = WorldMapType2.getItemDefinition(var9.itemIds[var21] - 1);
                                          boolean var47;
                                          if(Client.itemSelectionState == 1) {
                                             var42 = ClanMember.getWidgetConfig(var9);
                                             var47 = (var42 >> 30 & 1) != 0;
                                             if(var47) {
                                                if(var9.id != class214.field2675 || var21 != class34.selectedItemIndex) {
                                                   RSCanvas.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + ISAACCipher.getColTags(16748608) + var46.name, 31, var46.id, var21, var9.id);
                                                }
                                                break label1750;
                                             }
                                          }

                                          if(Client.spellSelected) {
                                             var42 = ClanMember.getWidgetConfig(var9);
                                             var47 = (var42 >> 30 & 1) != 0;
                                             if(var47) {
                                                if((class156.field2161 & 16) == 16) {
                                                   RSCanvas.addMenuEntry(Client.lastSelectedSpellActionName, Client.lastSelectedSpellName + " " + "->" + " " + ISAACCipher.getColTags(16748608) + var46.name, 32, var46.id, var21, var9.id);
                                                }
                                                break label1750;
                                             }
                                          }

                                          String[] var27 = var46.inventoryActions;
                                          if(Client.numberMenuOptions) {
                                             var27 = GroundObject.prependIndices(var27);
                                          }

                                          var42 = -1;
                                          if(Client.field1002 && KeyFocusListener.field606[81]) {
                                             var42 = var46.method4791();
                                          }

                                          var41 = ClanMember.getWidgetConfig(var9);
                                          boolean var40 = (var41 >> 30 & 1) != 0;
                                          if(var40) {
                                             for(var31 = 4; var31 >= 3; --var31) {
                                                if(var42 != var31) {
                                                   SoundTaskDataProvider.method780(var9, var46, var21, var31, false);
                                                }
                                             }
                                          }

                                          int var32 = ClanMember.getWidgetConfig(var9);
                                          boolean var59 = (var32 >> 31 & 1) != 0;
                                          if(var59) {
                                             RSCanvas.addMenuEntry("Use", ISAACCipher.getColTags(16748608) + var46.name, 38, var46.id, var21, var9.id);
                                          }

                                          int var34 = ClanMember.getWidgetConfig(var9);
                                          boolean var33 = (var34 >> 30 & 1) != 0;
                                          int var35;
                                          if(var33) {
                                             for(var35 = 2; var35 >= 0; --var35) {
                                                if(var42 != var35) {
                                                   SoundTaskDataProvider.method780(var9, var46, var21, var35, false);
                                                }
                                             }

                                             if(var42 >= 0) {
                                                SoundTaskDataProvider.method780(var9, var46, var21, var42, true);
                                             }
                                          }

                                          var27 = var9.configActions;
                                          if(Client.numberMenuOptions) {
                                             var27 = GroundObject.prependIndices(var27);
                                          }

                                          if(var27 != null) {
                                             for(var35 = 4; var35 >= 0; --var35) {
                                                if(var27[var35] != null) {
                                                   byte var36 = 0;
                                                   if(var35 == 0) {
                                                      var36 = 39;
                                                   }

                                                   if(var35 == 1) {
                                                      var36 = 40;
                                                   }

                                                   if(var35 == 2) {
                                                      var36 = 41;
                                                   }

                                                   if(var35 == 3) {
                                                      var36 = 42;
                                                   }

                                                   if(var35 == 4) {
                                                      var36 = 43;
                                                   }

                                                   RSCanvas.addMenuEntry(var27[var35], ISAACCipher.getColTags(16748608) + var46.name, var36, var46.id, var21, var9.id);
                                                }
                                             }
                                          }

                                          RSCanvas.addMenuEntry("Examine", ISAACCipher.getColTags(16748608) + var46.name, 1005, var46.id, var21, var9.id);
                                       }
                                    }
                                 }

                                 ++var21;
                              }
                           }
                        }

                        if(var9.hasScript) {
                           if(Client.spellSelected) {
                              if(class171.method3220(ClanMember.getWidgetConfig(var9)) && (class156.field2161 & 32) == 32) {
                                 RSCanvas.addMenuEntry(Client.lastSelectedSpellActionName, Client.lastSelectedSpellName + " " + "->" + " " + var9.name, 58, 0, var9.index, var9.id);
                              }
                           } else {
                              for(var21 = 9; var21 >= 5; --var21) {
                                 String var48 = BoundingBox2D.method44(var9, var21);
                                 if(var48 != null) {
                                    RSCanvas.addMenuEntry(var48, var9.name, 1007, var21 + 1, var9.index, var9.id);
                                 }
                              }

                              var39 = DecorativeObject.method3017(var9);
                              if(var39 != null) {
                                 RSCanvas.addMenuEntry(var39, var9.name, 25, 0, var9.index, var9.id);
                              }

                              for(var22 = 4; var22 >= 0; --var22) {
                                 String var44 = BoundingBox2D.method44(var9, var22);
                                 if(var44 != null) {
                                    RSCanvas.addMenuEntry(var44, var9.name, 57, var22 + 1, var9.index, var9.id);
                                 }
                              }

                              if(class21.method170(ClanMember.getWidgetConfig(var9))) {
                                 RSCanvas.addMenuEntry("Continue", "", 30, 0, var9.index, var9.id);
                              }
                           }
                        }
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && Buffer.method3509(var9) && var9 != FloorUnderlayDefinition.field3409) {
                        continue;
                     }

                     method1910(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method1910(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var37 = (WidgetNode)Client.componentTable.get((long)var9.id);
                     if(var37 != null) {
                        if(var37.owner == 0 && MouseInput.field703 >= var12 && MouseInput.field715 * 10625923 >= var13 && MouseInput.field703 < var14 && MouseInput.field715 * 10625923 < var15 && !Client.isMenuOpen && !Client.field967) {
                           for(ScriptEvent var38 = (ScriptEvent)Client.field1010.getFront(); var38 != null; var38 = (ScriptEvent)Client.field1010.getNext()) {
                              if(var38.boolean1) {
                                 var38.unlink();
                                 var38.widget.field2720 = false;
                              }
                           }

                           if(class37.field488 == 0) {
                              Client.field1027 = null;
                              Client.field1028 = null;
                           }

                           if(!Client.isMenuOpen) {
                              FileRequest.method4261();
                           }
                        }

                        var20 = var37.id;
                        if(ISAACCipher.loadWidget(var20)) {
                           method1910(class11.widgets[var20], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.hasScript) {
                     ScriptEvent var61;
                     if(!var9.noClickThrough) {
                        if(var9.field2826 && MouseInput.field703 >= var12 && MouseInput.field715 * 10625923 >= var13 && MouseInput.field703 < var14 && MouseInput.field715 * 10625923 < var15) {
                           for(var61 = (ScriptEvent)Client.field1010.getFront(); var61 != null; var61 = (ScriptEvent)Client.field1010.getNext()) {
                              if(var61.boolean1 && var61.widget.scrollListener == var61.objs) {
                                 var61.unlink();
                              }
                           }
                        }
                     } else if(MouseInput.field703 >= var12 && MouseInput.field715 * 10625923 >= var13 && MouseInput.field703 < var14 && MouseInput.field715 * 10625923 < var15) {
                        for(var61 = (ScriptEvent)Client.field1010.getFront(); var61 != null; var61 = (ScriptEvent)Client.field1010.getNext()) {
                           if(var61.boolean1) {
                              var61.unlink();
                              var61.widget.field2720 = false;
                           }
                        }

                        if(class37.field488 == 0) {
                           Client.field1027 = null;
                           Client.field1028 = null;
                        }

                        if(!Client.isMenuOpen) {
                           FileRequest.method4261();
                        }
                     }

                     if(MouseInput.field703 >= var12 && MouseInput.field715 * 10625923 >= var13 && MouseInput.field703 < var14 && MouseInput.field715 * 10625923 < var15) {
                        var49 = true;
                     } else {
                        var49 = false;
                     }

                     boolean var50 = false;
                     if((MouseInput.mouseCurrentButton == 1 || !Client.field956 && MouseInput.mouseCurrentButton == 4) && var49) {
                        var50 = true;
                     }

                     boolean var51 = false;
                     if((MouseInput.mouseLastButton == 1 || !Client.field956 && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= var12 && MouseInput.mouseLastPressedY >= var13 && MouseInput.mouseLastPressedX < var14 && MouseInput.mouseLastPressedY < var15) {
                        var51 = true;
                     }

                     if(var51) {
                        AttackOption.method1767(var9, MouseInput.mouseLastPressedX - var10, MouseInput.mouseLastPressedY - var11);
                     }

                     if(var9.contentType == 1400) {
                        MouseInput.renderOverview.method5497(MouseInput.field703, MouseInput.field715 * 10625923, var49 & var50, var49 & var51);
                     }

                     if(Client.field1027 != null && var9 != Client.field1027 && var49 && IndexStoreActionHandler.method4358(ClanMember.getWidgetConfig(var9))) {
                        Client.field890 = var9;
                     }

                     if(var9 == Client.field1028) {
                        Client.field1046 = true;
                        Client.field1033 = var10;
                        Client.field1034 = var11;
                     }

                     if(var9.field2770) {
                        ScriptEvent var62;
                        if(var49 && Client.mouseWheelRotation != 0 && var9.scrollListener != null) {
                           var62 = new ScriptEvent();
                           var62.boolean1 = true;
                           var62.widget = var9;
                           var62.field801 = Client.mouseWheelRotation;
                           var62.objs = var9.scrollListener;
                           Client.field1010.addFront(var62);
                        }

                        if(Client.field1027 != null || WorldMapType2.field492 != null || Client.isMenuOpen) {
                           var51 = false;
                           var50 = false;
                           var49 = false;
                        }

                        if(!var9.field2719 && var51) {
                           var9.field2719 = true;
                           if(var9.field2806 != null) {
                              var62 = new ScriptEvent();
                              var62.boolean1 = true;
                              var62.widget = var9;
                              var62.field800 = MouseInput.mouseLastPressedX - var10;
                              var62.field801 = MouseInput.mouseLastPressedY - var11;
                              var62.objs = var9.field2806;
                              Client.field1010.addFront(var62);
                           }
                        }

                        if(var9.field2719 && var50 && var9.field2805 != null) {
                           var62 = new ScriptEvent();
                           var62.boolean1 = true;
                           var62.widget = var9;
                           var62.field800 = MouseInput.field703 - var10;
                           var62.field801 = MouseInput.field715 * 10625923 - var11;
                           var62.objs = var9.field2805;
                           Client.field1010.addFront(var62);
                        }

                        if(var9.field2719 && !var50) {
                           var9.field2719 = false;
                           if(var9.field2852 != null) {
                              var62 = new ScriptEvent();
                              var62.boolean1 = true;
                              var62.widget = var9;
                              var62.field800 = MouseInput.field703 - var10;
                              var62.field801 = MouseInput.field715 * 10625923 - var11;
                              var62.objs = var9.field2852;
                              Client.field1105.addFront(var62);
                           }
                        }

                        if(var50 && var9.field2760 != null) {
                           var62 = new ScriptEvent();
                           var62.boolean1 = true;
                           var62.widget = var9;
                           var62.field800 = MouseInput.field703 - var10;
                           var62.field801 = MouseInput.field715 * 10625923 - var11;
                           var62.objs = var9.field2760;
                           Client.field1010.addFront(var62);
                        }

                        if(!var9.field2720 && var49) {
                           var9.field2720 = true;
                           if(var9.mouseEnterListener != null) {
                              var62 = new ScriptEvent();
                              var62.boolean1 = true;
                              var62.widget = var9;
                              var62.field800 = MouseInput.field703 - var10;
                              var62.field801 = MouseInput.field715 * 10625923 - var11;
                              var62.objs = var9.mouseEnterListener;
                              Client.field1010.addFront(var62);
                           }
                        }

                        if(var9.field2720 && var49 && var9.mouseHoverListener != null) {
                           var62 = new ScriptEvent();
                           var62.boolean1 = true;
                           var62.widget = var9;
                           var62.field800 = MouseInput.field703 - var10;
                           var62.field801 = MouseInput.field715 * 10625923 - var11;
                           var62.objs = var9.mouseHoverListener;
                           Client.field1010.addFront(var62);
                        }

                        if(var9.field2720 && !var49) {
                           var9.field2720 = false;
                           if(var9.mouseExitListener != null) {
                              var62 = new ScriptEvent();
                              var62.boolean1 = true;
                              var62.widget = var9;
                              var62.field800 = MouseInput.field703 - var10;
                              var62.field801 = MouseInput.field715 * 10625923 - var11;
                              var62.objs = var9.mouseExitListener;
                              Client.field1105.addFront(var62);
                           }
                        }

                        if(var9.renderListener != null) {
                           var62 = new ScriptEvent();
                           var62.widget = var9;
                           var62.objs = var9.renderListener;
                           Client.field1054.addFront(var62);
                        }

                        ScriptEvent var45;
                        if(var9.configListenerArgs != null && Client.field1041 > var9.field2832) {
                           if(var9.configTriggers != null && Client.field1041 - var9.field2832 <= 32) {
                              label1421:
                              for(var21 = var9.field2832; var21 < Client.field1041; ++var21) {
                                 var22 = Client.field1040[var21 & 31];

                                 for(var23 = 0; var23 < var9.configTriggers.length; ++var23) {
                                    if(var22 == var9.configTriggers[var23]) {
                                       var45 = new ScriptEvent();
                                       var45.widget = var9;
                                       var45.objs = var9.configListenerArgs;
                                       Client.field1010.addFront(var45);
                                       break label1421;
                                    }
                                 }
                              }
                           } else {
                              var62 = new ScriptEvent();
                              var62.widget = var9;
                              var62.objs = var9.configListenerArgs;
                              Client.field1010.addFront(var62);
                           }

                           var9.field2832 = Client.field1041;
                        }

                        if(var9.tableListenerArgs != null && Client.field961 > var9.field2853) {
                           if(var9.tableModTriggers != null && Client.field961 - var9.field2853 <= 32) {
                              label1397:
                              for(var21 = var9.field2853; var21 < Client.field961; ++var21) {
                                 var22 = Client.interfaceItemTriggers[var21 & 31];

                                 for(var23 = 0; var23 < var9.tableModTriggers.length; ++var23) {
                                    if(var22 == var9.tableModTriggers[var23]) {
                                       var45 = new ScriptEvent();
                                       var45.widget = var9;
                                       var45.objs = var9.tableListenerArgs;
                                       Client.field1010.addFront(var45);
                                       break label1397;
                                    }
                                 }
                              }
                           } else {
                              var62 = new ScriptEvent();
                              var62.widget = var9;
                              var62.objs = var9.tableListenerArgs;
                              Client.field1010.addFront(var62);
                           }

                           var9.field2853 = Client.field961;
                        }

                        if(var9.skillListenerArgs != null && Client.field894 > var9.field2854) {
                           if(var9.skillTriggers != null && Client.field894 - var9.field2854 <= 32) {
                              label1373:
                              for(var21 = var9.field2854; var21 < Client.field894; ++var21) {
                                 var22 = Client.field1092[var21 & 31];

                                 for(var23 = 0; var23 < var9.skillTriggers.length; ++var23) {
                                    if(var22 == var9.skillTriggers[var23]) {
                                       var45 = new ScriptEvent();
                                       var45.widget = var9;
                                       var45.objs = var9.skillListenerArgs;
                                       Client.field1010.addFront(var45);
                                       break label1373;
                                    }
                                 }
                              }
                           } else {
                              var62 = new ScriptEvent();
                              var62.widget = var9;
                              var62.objs = var9.skillListenerArgs;
                              Client.field1010.addFront(var62);
                           }

                           var9.field2854 = Client.field894;
                        }

                        if(Client.chatCycle > var9.field2851 && var9.field2849 != null) {
                           var62 = new ScriptEvent();
                           var62.widget = var9;
                           var62.objs = var9.field2849;
                           Client.field1010.addFront(var62);
                        }

                        if(Client.field977 > var9.field2851 && var9.field2828 != null) {
                           var62 = new ScriptEvent();
                           var62.widget = var9;
                           var62.objs = var9.field2828;
                           Client.field1010.addFront(var62);
                        }

                        if(Client.field1048 > var9.field2851 && var9.field2829 != null) {
                           var62 = new ScriptEvent();
                           var62.widget = var9;
                           var62.objs = var9.field2829;
                           Client.field1010.addFront(var62);
                        }

                        if(Client.field1049 > var9.field2851 && var9.field2834 != null) {
                           var62 = new ScriptEvent();
                           var62.widget = var9;
                           var62.objs = var9.field2834;
                           Client.field1010.addFront(var62);
                        }

                        if(Client.field1050 > var9.field2851 && var9.field2835 != null) {
                           var62 = new ScriptEvent();
                           var62.widget = var9;
                           var62.objs = var9.field2835;
                           Client.field1010.addFront(var62);
                        }

                        if(Client.field1051 > var9.field2851 && var9.field2830 != null) {
                           var62 = new ScriptEvent();
                           var62.widget = var9;
                           var62.objs = var9.field2830;
                           Client.field1010.addFront(var62);
                        }

                        var9.field2851 = Client.cycleCntr;
                        if(var9.field2827 != null) {
                           for(var21 = 0; var21 < Client.field1075; ++var21) {
                              ScriptEvent var66 = new ScriptEvent();
                              var66.widget = var9;
                              var66.field802 = Client.field1077[var21];
                              var66.field810 = Client.field1055[var21];
                              var66.objs = var9.field2827;
                              Client.field1010.addFront(var66);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.field1027 == null && WorldMapType2.field492 == null && !Client.isMenuOpen) {
                     if((var9.field2839 >= 0 || var9.field2751 != 0) && MouseInput.field703 >= var12 && MouseInput.field715 * 10625923 >= var13 && MouseInput.field703 < var14 && MouseInput.field715 * 10625923 < var15) {
                        if(var9.field2839 >= 0) {
                           FloorUnderlayDefinition.field3409 = var0[var9.field2839];
                        } else {
                           FloorUnderlayDefinition.field3409 = var9;
                        }
                     }

                     if(var9.type == 8 && MouseInput.field703 >= var12 && MouseInput.field715 * 10625923 >= var13 && MouseInput.field703 < var14 && MouseInput.field715 * 10625923 < var15) {
                        GrandExchangeEvent.field279 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        var19 = var10 + var9.width;
                        var20 = var9.height;
                        var21 = var9.scrollHeight;
                        var22 = MouseInput.field703;
                        var23 = MouseInput.field715 * 10625923;
                        if(Client.field973) {
                           Client.field936 = 32;
                        } else {
                           Client.field936 = 0;
                        }

                        Client.field973 = false;
                        if(MouseInput.mouseCurrentButton == 1 || !Client.field956 && MouseInput.mouseCurrentButton == 4) {
                           if(var22 >= var19 && var22 < var19 + 16 && var23 >= var11 && var23 < var11 + 16) {
                              var9.scrollY -= 4;
                              class40.method556(var9);
                           } else if(var22 >= var19 && var22 < var19 + 16 && var23 >= var11 + var20 - 16 && var23 < var11 + var20) {
                              var9.scrollY += 4;
                              class40.method556(var9);
                           } else if(var22 >= var19 - Client.field936 && var22 < var19 + Client.field936 + 16 && var23 >= var11 + 16 && var23 < var11 + var20 - 16) {
                              var24 = var20 * (var20 - 32) / var21;
                              if(var24 < 8) {
                                 var24 = 8;
                              }

                              var25 = var23 - var11 - 16 - var24 / 2;
                              var26 = var20 - 32 - var24;
                              var9.scrollY = var25 * (var21 - var20) / var26;
                              class40.method556(var9);
                              Client.field973 = true;
                           }
                        }

                        if(Client.mouseWheelRotation != 0) {
                           var24 = var9.width;
                           if(var22 >= var19 - var24 && var23 >= var11 && var22 < var19 + 16 && var23 <= var20 + var11) {
                              var9.scrollY += Client.mouseWheelRotation * 45;
                              class40.method556(var9);
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
