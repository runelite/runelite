import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 343619271
   )
   int field436;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1640170477
   )
   int field437;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1218065265
   )
   int field438;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -707282507
   )
   int field439;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1785239815
   )
   int field440;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 873133925
   )
   int field441;
   @ObfuscatedName("bp")
   static String field443;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1072148199
   )
   int field444;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2093568421
   )
   int field445;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -767594717
   )
   int field446;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -24723621
   )
   int field448;
   @ObfuscatedName("b")
   static class47 field449;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = 1631886669
   )
   @Export("menuWidth")
   static int menuWidth;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;I)V",
      garbageValue = "98017718"
   )
   public void vmethod753(WorldMapData var1) {
      if(var1.field467 > this.field441) {
         var1.field467 = this.field441;
      }

      if(var1.field468 < this.field445) {
         var1.field468 = this.field445;
      }

      if(var1.field472 > this.field436) {
         var1.field472 = this.field436;
      }

      if(var1.field466 < this.field444) {
         var1.field466 = this.field444;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "998947175"
   )
   public boolean vmethod728(int var1, int var2, int var3) {
      return var1 >= this.field448 && var1 < this.field438 + this.field448?var2 >> 6 >= this.field437 && var2 >> 6 <= this.field439 && var3 >> 6 >= this.field446 && var3 >> 6 <= this.field440:false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "202348652"
   )
   public boolean vmethod754(int var1, int var2) {
      return var1 >> 6 >= this.field441 && var1 >> 6 <= this.field445 && var2 >> 6 >= this.field436 && var2 >> 6 <= this.field444;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1509988890"
   )
   public int[] vmethod730(int var1, int var2, int var3) {
      if(!this.vmethod728(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field441 * 64 - this.field437 * 64 + var2, var3 + (this.field436 * 64 - this.field446 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)LCoordinates;",
      garbageValue = "-2079571098"
   )
   public Coordinates vmethod731(int var1, int var2) {
      if(!this.vmethod754(var1, var2)) {
         return null;
      } else {
         int var3 = this.field437 * 64 - this.field441 * 64 + var1;
         int var4 = this.field446 * 64 - this.field436 * 64 + var2;
         return new Coordinates(this.field448, var3, var4);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "618655756"
   )
   public void vmethod732(Buffer var1) {
      this.field448 = var1.readUnsignedByte();
      this.field438 = var1.readUnsignedByte();
      this.field437 = var1.readUnsignedShort();
      this.field446 = var1.readUnsignedShort();
      this.field439 = var1.readUnsignedShort();
      this.field440 = var1.readUnsignedShort();
      this.field441 = var1.readUnsignedShort();
      this.field436 = var1.readUnsignedShort();
      this.field445 = var1.readUnsignedShort();
      this.field444 = var1.readUnsignedShort();
      this.method243();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-15"
   )
   void method243() {
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIII)V",
      garbageValue = "1653104935"
   )
   static final void method262(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2734 || WorldMapType3.getWidgetConfig(var9) != 0 || var9 == Client.field1101 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !class39.method555(var9))) {
            int var10 = var9.relativeX + var6;
            int var11 = var9.relativeY + var7;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               int var19 = var10 + var9.width;
               var18 = var11 + var9.height;
               if(var19 < var10) {
                  var16 = var19;
                  var19 = var10;
               }

               if(var18 < var11) {
                  var17 = var18;
                  var18 = var11;
               }

               ++var19;
               ++var18;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var19 < var4?var19:var4;
               var15 = var18 < var5?var18:var5;
            } else {
               var16 = var10 + var9.width;
               var17 = var11 + var9.height;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == Client.field1100) {
               Client.field1176 = true;
               Client.field1109 = var10;
               Client.field960 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = MouseInput.field748;
               var17 = MouseInput.field749;
               if(MouseInput.field742 != 0) {
                  var16 = MouseInput.field747;
                  var17 = MouseInput.field756;
               }

               boolean var38 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               int var20;
               int var21;
               int var22;
               int var23;
               int var24;
               int var25;
               int var26;
               int var27;
               if(var9.contentType == 1337) {
                  if(!Client.field934 && !Client.isMenuOpen && var38) {
                     if(Client.itemSelectionState == 0 && !Client.spellSelected) {
                        class175.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var18 = -1;
                     var20 = -1;

                     for(var21 = 0; var21 < class134.field2010; ++var21) {
                        var22 = class134.field2011[var21];
                        var23 = var22 & 127;
                        var24 = var22 >> 7 & 127;
                        var25 = var22 >> 29 & 3;
                        var26 = var22 >> 14 & 32767;
                        if(var22 != var20) {
                           var20 = var22;
                           if(var25 == 2 && class2.region.method2696(WallObject.plane, var23, var24, var22) >= 0) {
                              ObjectComposition var42 = class251.getObjectDefinition(var26);
                              if(var42.impostorIds != null) {
                                 var42 = var42.getImpostor();
                              }

                              if(var42 == null) {
                                 continue;
                              }

                              if(Client.itemSelectionState == 1) {
                                 class175.addMenuEntry("Use", Client.selectedItemName + " -> " + class220.getColTags('\uffff') + var42.name, 1, var22, var23, var24);
                              } else if(Client.spellSelected) {
                                 if((WorldMapType3.spellTargetFlags & 4) == 4) {
                                    class175.addMenuEntry(Client.field1078, Client.field1159 + " -> " + class220.getColTags('\uffff') + var42.name, 2, var22, var23, var24);
                                 }
                              } else {
                                 String[] var47 = var42.actions;
                                 if(Client.field1199) {
                                    var47 = class251.method4456(var47);
                                 }

                                 if(var47 != null) {
                                    for(int var45 = 4; var45 >= 0; --var45) {
                                       if(var47[var45] != null) {
                                          short var54 = 0;
                                          if(var45 == 0) {
                                             var54 = 3;
                                          }

                                          if(var45 == 1) {
                                             var54 = 4;
                                          }

                                          if(var45 == 2) {
                                             var54 = 5;
                                          }

                                          if(var45 == 3) {
                                             var54 = 6;
                                          }

                                          if(var45 == 4) {
                                             var54 = 1001;
                                          }

                                          class175.addMenuEntry(var47[var45], class220.getColTags('\uffff') + var42.name, var54, var22, var23, var24);
                                       }
                                    }
                                 }

                                 class175.addMenuEntry("Examine", class220.getColTags('\uffff') + var42.name, 1002, var42.id << 14, var23, var24);
                              }
                           }

                           NPC var43;
                           int[] var48;
                           Player var52;
                           int var55;
                           if(var25 == 1) {
                              NPC var49 = Client.cachedNPCs[var26];
                              if(var49 == null) {
                                 continue;
                              }

                              if(var49.composition.field3561 == 1 && (var49.x & 127) == 64 && (var49.y & 127) == 64) {
                                 for(var27 = 0; var27 < Client.field937; ++var27) {
                                    var43 = Client.cachedNPCs[Client.npcIndices[var27]];
                                    if(var43 != null && var43 != var49 && var43.composition.field3561 == 1 && var43.x == var49.x && var43.y == var49.y) {
                                       class33.method349(var43.composition, Client.npcIndices[var27], var23, var24);
                                    }
                                 }

                                 var27 = class96.field1521;
                                 var48 = class96.field1531;

                                 for(var55 = 0; var55 < var27; ++var55) {
                                    var52 = Client.cachedPlayers[var48[var55]];
                                    if(var52 != null && var52.x == var49.x && var52.y == var49.y) {
                                       class181.method3429(var52, var48[var55], var23, var24);
                                    }
                                 }
                              }

                              class33.method349(var49.composition, var26, var23, var24);
                           }

                           if(var25 == 0) {
                              Player var50 = Client.cachedPlayers[var26];
                              if(var50 == null) {
                                 continue;
                              }

                              if((var50.x & 127) == 64 && (var50.y & 127) == 64) {
                                 for(var27 = 0; var27 < Client.field937; ++var27) {
                                    var43 = Client.cachedNPCs[Client.npcIndices[var27]];
                                    if(var43 != null && var43.composition.field3561 == 1 && var43.x == var50.x && var43.y == var50.y) {
                                       class33.method349(var43.composition, Client.npcIndices[var27], var23, var24);
                                    }
                                 }

                                 var27 = class96.field1521;
                                 var48 = class96.field1531;

                                 for(var55 = 0; var55 < var27; ++var55) {
                                    var52 = Client.cachedPlayers[var48[var55]];
                                    if(var52 != null && var50 != var52 && var52.x == var50.x && var52.y == var50.y) {
                                       class181.method3429(var52, var48[var55], var23, var24);
                                    }
                                 }
                              }

                              if(var26 != Client.field1056) {
                                 class181.method3429(var50, var26, var23, var24);
                              } else {
                                 var18 = var22;
                              }
                           }

                           if(var25 == 3) {
                              Deque var53 = Client.groundItemDeque[WallObject.plane][var23][var24];
                              if(var53 != null) {
                                 for(Item var51 = (Item)var53.getTail(); var51 != null; var51 = (Item)var53.getPrevious()) {
                                    ItemComposition var34 = AbstractByteBuffer.getItemDefinition(var51.id);
                                    if(Client.itemSelectionState == 1) {
                                       class175.addMenuEntry("Use", Client.selectedItemName + " -> " + class220.getColTags(16748608) + var34.name, 16, var51.id, var23, var24);
                                    } else if(Client.spellSelected) {
                                       if((WorldMapType3.spellTargetFlags & 1) == 1) {
                                          class175.addMenuEntry(Client.field1078, Client.field1159 + " -> " + class220.getColTags(16748608) + var34.name, 17, var51.id, var23, var24);
                                       }
                                    } else {
                                       String[] var35 = var34.groundActions;
                                       if(Client.field1199) {
                                          var35 = class251.method4456(var35);
                                       }

                                       for(int var36 = 4; var36 >= 0; --var36) {
                                          if(var35 != null && var35[var36] != null) {
                                             byte var37 = 0;
                                             if(var36 == 0) {
                                                var37 = 18;
                                             }

                                             if(var36 == 1) {
                                                var37 = 19;
                                             }

                                             if(var36 == 2) {
                                                var37 = 20;
                                             }

                                             if(var36 == 3) {
                                                var37 = 21;
                                             }

                                             if(var36 == 4) {
                                                var37 = 22;
                                             }

                                             class175.addMenuEntry(var35[var36], class220.getColTags(16748608) + var34.name, var37, var51.id, var23, var24);
                                          } else if(var36 == 2) {
                                             class175.addMenuEntry("Take", class220.getColTags(16748608) + var34.name, 20, var51.id, var23, var24);
                                          }
                                       }

                                       class175.addMenuEntry("Examine", class220.getColTags(16748608) + var34.name, 1004, var51.id, var23, var24);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var18 != -1) {
                        var21 = var18 & 127;
                        var22 = var18 >> 7 & 127;
                        Player var44 = Client.cachedPlayers[Client.field1056];
                        class181.method3429(var44, Client.field1056, var21, var22);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  if((Client.field1161 == 0 || Client.field1161 == 3) && (MouseInput.field742 == 1 || !class34.field499 && MouseInput.field742 == 4)) {
                     class210 var40 = var9.method3981(true);
                     if(var40 != null) {
                        var20 = MouseInput.field747 - var10;
                        var21 = MouseInput.field756 - var11;
                        if(var40.method3898(var20, var21)) {
                           var20 -= var40.field2607 / 2;
                           var21 -= var40.field2602 / 2;
                           var22 = Client.mapAngle + Client.mapScale & 2047;
                           var23 = Graphics3D.SINE[var22];
                           var24 = Graphics3D.COSINE[var22];
                           var23 = var23 * (256 + Client.mapScaleDelta) >> 8;
                           var24 = var24 * (256 + Client.mapScaleDelta) >> 8;
                           var25 = var24 * var20 + var23 * var21 >> 11;
                           var26 = var24 * var21 - var23 * var20 >> 11;
                           int var46 = var25 + XItemContainer.localPlayer.x >> 7;
                           var27 = XItemContainer.localPlayer.y - var26 >> 7;
                           Client.secretPacketBuffer1.putOpcode(115);
                           Client.secretPacketBuffer1.putByte(18);
                           Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field659[82]?(KeyFocusListener.field659[81]?2:1):0);
                           Client.secretPacketBuffer1.putShort(var27 + class266.baseY);
                           Client.secretPacketBuffer1.putShort(var46 + KeyFocusListener.baseX);
                           Client.secretPacketBuffer1.putByte(var20);
                           Client.secretPacketBuffer1.putByte(var21);
                           Client.secretPacketBuffer1.putShort(Client.mapAngle);
                           Client.secretPacketBuffer1.putByte(57);
                           Client.secretPacketBuffer1.putByte(Client.mapScale);
                           Client.secretPacketBuffer1.putByte(Client.mapScaleDelta);
                           Client.secretPacketBuffer1.putByte(89);
                           Client.secretPacketBuffer1.putShort(XItemContainer.localPlayer.x);
                           Client.secretPacketBuffer1.putShort(XItemContainer.localPlayer.y);
                           Client.secretPacketBuffer1.putByte(63);
                           Client.destinationX = var46;
                           Client.destinationY = var27;
                        }
                     }
                  }
               } else {
                  if(var9.contentType == 1400) {
                     class43.renderOverview.method5240(MouseInput.field748, MouseInput.field749, var38, var10, var11, var9.width, var9.height);
                  }

                  if(!Client.isMenuOpen && var38) {
                     if(var9.contentType == 1400) {
                        class43.renderOverview.method5228(var10, var11, var9.width, var9.height, var16, var17);
                     } else {
                        class24.method164(var9, var16 - var10, var17 - var11);
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && class39.method555(var9) && var9 != KitDefinition.field3371) {
                        continue;
                     }

                     method262(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method262(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var28 = (WidgetNode)Client.componentTable.get((long)var9.id);
                     if(var28 != null) {
                        if(var28.owner == 0 && MouseInput.field748 >= var12 && MouseInput.field749 >= var13 && MouseInput.field748 < var14 && MouseInput.field749 < var15 && !Client.isMenuOpen && !Client.field1097) {
                           for(ScriptEvent var29 = (ScriptEvent)Client.field1035.getFront(); var29 != null; var29 = (ScriptEvent)Client.field1035.getNext()) {
                              if(var29.field848) {
                                 var29.unlink();
                                 var29.widget.field2776 = false;
                              }
                           }

                           if(class220.field2809 == 0) {
                              Client.field1100 = null;
                              Client.field1101 = null;
                           }

                           if(!Client.isMenuOpen) {
                              class60.method1055();
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuOptionCount = 1;
                           }
                        }

                        var20 = var28.id;
                        if(class66.loadWidget(var20)) {
                           method262(class46.widgets[var20], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.hasScript) {
                     ScriptEvent var39;
                     if(!var9.field2685) {
                        if(var9.field2783 && MouseInput.field748 >= var12 && MouseInput.field749 >= var13 && MouseInput.field748 < var14 && MouseInput.field749 < var15) {
                           for(var39 = (ScriptEvent)Client.field1035.getFront(); var39 != null; var39 = (ScriptEvent)Client.field1035.getNext()) {
                              if(var39.field848 && var39.widget.scrollListener == var39.field857) {
                                 var39.unlink();
                              }
                           }
                        }
                     } else if(MouseInput.field748 >= var12 && MouseInput.field749 >= var13 && MouseInput.field748 < var14 && MouseInput.field749 < var15) {
                        for(var39 = (ScriptEvent)Client.field1035.getFront(); var39 != null; var39 = (ScriptEvent)Client.field1035.getNext()) {
                           if(var39.field848) {
                              var39.unlink();
                              var39.widget.field2776 = false;
                           }
                        }

                        if(class220.field2809 == 0) {
                           Client.field1100 = null;
                           Client.field1101 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.menuOptionCount = 1;
                        }
                     }

                     if(MouseInput.field748 >= var12 && MouseInput.field749 >= var13 && MouseInput.field748 < var14 && MouseInput.field749 < var15) {
                        var38 = true;
                     } else {
                        var38 = false;
                     }

                     boolean var41 = false;
                     if((MouseInput.field754 == 1 || !class34.field499 && MouseInput.field754 == 4) && var38) {
                        var41 = true;
                     }

                     boolean var30 = false;
                     if((MouseInput.field742 == 1 || !class34.field499 && MouseInput.field742 == 4) && MouseInput.field747 >= var12 && MouseInput.field756 >= var13 && MouseInput.field747 < var14 && MouseInput.field756 < var15) {
                        var30 = true;
                     }

                     if(var30) {
                        class140.method2856(var9, MouseInput.field747 - var10, MouseInput.field756 - var11);
                     }

                     if(var9.contentType == 1400) {
                        class43.renderOverview.method5182(MouseInput.field748, MouseInput.field749, var38 & var41);
                     }

                     if(Client.field1100 != null && var9 != Client.field1100 && var38 && FrameMap.method2664(WorldMapType3.getWidgetConfig(var9))) {
                        Client.field1105 = var9;
                     }

                     if(var9 == Client.field1101) {
                        Client.field1069 = true;
                        Client.field1175 = var10;
                        Client.field1107 = var11;
                     }

                     if(var9.field2734) {
                        ScriptEvent var31;
                        if(var38 && Client.field1125 != 0 && var9.scrollListener != null) {
                           var31 = new ScriptEvent();
                           var31.field848 = true;
                           var31.widget = var9;
                           var31.field853 = Client.field1125;
                           var31.field857 = var9.scrollListener;
                           Client.field1035.addFront(var31);
                        }

                        if(Client.field1100 != null || class95.field1513 != null || Client.isMenuOpen) {
                           var30 = false;
                           var41 = false;
                           var38 = false;
                        }

                        if(!var9.field2780 && var30) {
                           var9.field2780 = true;
                           if(var9.field2725 != null) {
                              var31 = new ScriptEvent();
                              var31.field848 = true;
                              var31.widget = var9;
                              var31.field850 = MouseInput.field747 - var10;
                              var31.field853 = MouseInput.field756 - var11;
                              var31.field857 = var9.field2725;
                              Client.field1035.addFront(var31);
                           }
                        }

                        if(var9.field2780 && var41 && var9.field2677 != null) {
                           var31 = new ScriptEvent();
                           var31.field848 = true;
                           var31.widget = var9;
                           var31.field850 = MouseInput.field748 - var10;
                           var31.field853 = MouseInput.field749 - var11;
                           var31.field857 = var9.field2677;
                           Client.field1035.addFront(var31);
                        }

                        if(var9.field2780 && !var41) {
                           var9.field2780 = false;
                           if(var9.field2738 != null) {
                              var31 = new ScriptEvent();
                              var31.field848 = true;
                              var31.widget = var9;
                              var31.field850 = MouseInput.field748 - var10;
                              var31.field853 = MouseInput.field749 - var11;
                              var31.field857 = var9.field2738;
                              Client.field1128.addFront(var31);
                           }
                        }

                        if(var41 && var9.field2722 != null) {
                           var31 = new ScriptEvent();
                           var31.field848 = true;
                           var31.widget = var9;
                           var31.field850 = MouseInput.field748 - var10;
                           var31.field853 = MouseInput.field749 - var11;
                           var31.field857 = var9.field2722;
                           Client.field1035.addFront(var31);
                        }

                        if(!var9.field2776 && var38) {
                           var9.field2776 = true;
                           if(var9.mouseEnterListener != null) {
                              var31 = new ScriptEvent();
                              var31.field848 = true;
                              var31.widget = var9;
                              var31.field850 = MouseInput.field748 - var10;
                              var31.field853 = MouseInput.field749 - var11;
                              var31.field857 = var9.mouseEnterListener;
                              Client.field1035.addFront(var31);
                           }
                        }

                        if(var9.field2776 && var38 && var9.mouseHoverListener != null) {
                           var31 = new ScriptEvent();
                           var31.field848 = true;
                           var31.widget = var9;
                           var31.field850 = MouseInput.field748 - var10;
                           var31.field853 = MouseInput.field749 - var11;
                           var31.field857 = var9.mouseHoverListener;
                           Client.field1035.addFront(var31);
                        }

                        if(var9.field2776 && !var38) {
                           var9.field2776 = false;
                           if(var9.mouseExitListener != null) {
                              var31 = new ScriptEvent();
                              var31.field848 = true;
                              var31.widget = var9;
                              var31.field850 = MouseInput.field748 - var10;
                              var31.field853 = MouseInput.field749 - var11;
                              var31.field857 = var9.mouseExitListener;
                              Client.field1128.addFront(var31);
                           }
                        }

                        if(var9.renderListener != null) {
                           var31 = new ScriptEvent();
                           var31.widget = var9;
                           var31.field857 = var9.renderListener;
                           Client.field1127.addFront(var31);
                        }

                        ScriptEvent var32;
                        if(var9.configListenerArgs != null && Client.field975 > var9.field2736) {
                           if(var9.configTriggers != null && Client.field975 - var9.field2736 <= 32) {
                              label777:
                              for(var21 = var9.field2736; var21 < Client.field975; ++var21) {
                                 var22 = Client.field1113[var21 & 31];

                                 for(var23 = 0; var23 < var9.configTriggers.length; ++var23) {
                                    if(var22 == var9.configTriggers[var23]) {
                                       var32 = new ScriptEvent();
                                       var32.widget = var9;
                                       var32.field857 = var9.configListenerArgs;
                                       Client.field1035.addFront(var32);
                                       break label777;
                                    }
                                 }
                              }
                           } else {
                              var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.field857 = var9.configListenerArgs;
                              Client.field1035.addFront(var31);
                           }

                           var9.field2736 = Client.field975;
                        }

                        if(var9.tableListenerArgs != null && Client.field1116 > var9.field2669) {
                           if(var9.tableModTriggers != null && Client.field1116 - var9.field2669 <= 32) {
                              label753:
                              for(var21 = var9.field2669; var21 < Client.field1116; ++var21) {
                                 var22 = Client.interfaceItemTriggers[var21 & 31];

                                 for(var23 = 0; var23 < var9.tableModTriggers.length; ++var23) {
                                    if(var22 == var9.tableModTriggers[var23]) {
                                       var32 = new ScriptEvent();
                                       var32.widget = var9;
                                       var32.field857 = var9.tableListenerArgs;
                                       Client.field1035.addFront(var32);
                                       break label753;
                                    }
                                 }
                              }
                           } else {
                              var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.field857 = var9.tableListenerArgs;
                              Client.field1035.addFront(var31);
                           }

                           var9.field2669 = Client.field1116;
                        }

                        if(var9.skillListenerArgs != null && Client.field1067 > var9.field2666) {
                           if(var9.skillTriggers != null && Client.field1067 - var9.field2666 <= 32) {
                              label729:
                              for(var21 = var9.field2666; var21 < Client.field1067; ++var21) {
                                 var22 = Client.field1117[var21 & 31];

                                 for(var23 = 0; var23 < var9.skillTriggers.length; ++var23) {
                                    if(var22 == var9.skillTriggers[var23]) {
                                       var32 = new ScriptEvent();
                                       var32.widget = var9;
                                       var32.field857 = var9.skillListenerArgs;
                                       Client.field1035.addFront(var32);
                                       break label729;
                                    }
                                 }
                              }
                           } else {
                              var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.field857 = var9.skillListenerArgs;
                              Client.field1035.addFront(var31);
                           }

                           var9.field2666 = Client.field1067;
                        }

                        if(Client.field1119 > var9.field2781 && var9.field2756 != null) {
                           var31 = new ScriptEvent();
                           var31.widget = var9;
                           var31.field857 = var9.field2756;
                           Client.field1035.addFront(var31);
                        }

                        if(Client.field1025 > var9.field2781 && var9.field2758 != null) {
                           var31 = new ScriptEvent();
                           var31.widget = var9;
                           var31.field857 = var9.field2758;
                           Client.field1035.addFront(var31);
                        }

                        if(Client.field1121 > var9.field2781 && var9.field2759 != null) {
                           var31 = new ScriptEvent();
                           var31.widget = var9;
                           var31.field857 = var9.field2759;
                           Client.field1035.addFront(var31);
                        }

                        if(Client.field1110 > var9.field2781 && var9.field2663 != null) {
                           var31 = new ScriptEvent();
                           var31.widget = var9;
                           var31.field857 = var9.field2663;
                           Client.field1035.addFront(var31);
                        }

                        if(Client.field1004 > var9.field2781 && var9.field2701 != null) {
                           var31 = new ScriptEvent();
                           var31.widget = var9;
                           var31.field857 = var9.field2701;
                           Client.field1035.addFront(var31);
                        }

                        if(Client.field1124 > var9.field2781 && var9.field2760 != null) {
                           var31 = new ScriptEvent();
                           var31.widget = var9;
                           var31.field857 = var9.field2760;
                           Client.field1035.addFront(var31);
                        }

                        var9.field2781 = Client.field1112;
                        if(var9.field2761 != null) {
                           for(var21 = 0; var21 < Client.field1037; ++var21) {
                              ScriptEvent var33 = new ScriptEvent();
                              var33.widget = var9;
                              var33.field854 = Client.field1150[var21];
                              var33.field855 = Client.field1149[var21];
                              var33.field857 = var9.field2761;
                              Client.field1035.addFront(var33);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.field1100 == null && class95.field1513 == null && !Client.isMenuOpen) {
                     if((var9.field2769 >= 0 || var9.field2681 != 0) && MouseInput.field748 >= var12 && MouseInput.field749 >= var13 && MouseInput.field748 < var14 && MouseInput.field749 < var15) {
                        if(var9.field2769 >= 0) {
                           KitDefinition.field3371 = var0[var9.field2769];
                        } else {
                           KitDefinition.field3371 = var9;
                        }
                     }

                     if(var9.type == 8 && MouseInput.field748 >= var12 && MouseInput.field749 >= var13 && MouseInput.field748 < var14 && MouseInput.field749 < var15) {
                        PendingSpawn.field1211 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        AbstractByteBuffer.method3364(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, MouseInput.field748, MouseInput.field749);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "-170105579"
   )
   static String method263(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.socketType == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.socketType == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.socketType == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.socketType == 5) {
         var0 = var0 + "-wti";
      } else if(Client.socketType == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(Client.sessionToken != null) {
         var3 = "/p=" + Client.sessionToken;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.languageId + "/a=" + class33.field480 + var3 + "/";
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-845090670"
   )
   public static int method264(int var0) {
      Varbit var1 = (Varbit)Varbit.varbits.get((long)var0);
      Varbit var2;
      if(var1 != null) {
         var2 = var1;
      } else {
         byte[] var3 = Varbit.varbit_ref.getConfigData(14, var0);
         var1 = new Varbit();
         if(var3 != null) {
            var1.decode(new Buffer(var3));
         }

         Varbit.varbits.put(var1, (long)var0);
         var2 = var1;
      }

      int var7 = var2.configId;
      int var4 = var2.leastSignificantBit;
      int var5 = var2.mostSignificantBit;
      int var6 = class211.field2613[var5 - var4];
      return class211.widgetSettings[var7] >> var4 & var6;
   }
}
