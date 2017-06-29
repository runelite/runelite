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
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2734 || WorldMapType3.method199(var9) != 0 || var9 == Client.field1101 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !class39.method555(var9))) {
            int var10 = var9.relativeX + var6;
            int var11 = var9.relativeY + var7;
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

            if(var9 == Client.field1100) {
               Client.field1176 = true;
               Client.field1109 = var10;
               Client.field960 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = class59.field748;
               var17 = class59.field749;
               if(class59.field742 != 0) {
                  var16 = class59.field747;
                  var17 = class59.field756;
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
               if(var9.contentType == 1337) {
                  if(!Client.field934 && !Client.isMenuOpen && var44) {
                     if(Client.itemSelectionState == 0 && !Client.field1082) {
                        class175.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var19 = -1;
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
                              ObjectComposition var35 = class251.getObjectDefinition(var26);
                              if(var35.impostorIds != null) {
                                 var35 = var35.getImpostor();
                              }

                              if(var35 == null) {
                                 continue;
                              }

                              if(Client.itemSelectionState == 1) {
                                 class175.addMenuEntry("Use", Client.selectedItemName + " " + "->" + " " + class220.method4055('\uffff') + var35.name, 1, var22, var23, var24);
                              } else if(Client.field1082) {
                                 if((WorldMapType3.spellTargetFlags & 4) == 4) {
                                    class175.addMenuEntry(Client.field1078, Client.field1159 + " " + "->" + " " + class220.method4055('\uffff') + var35.name, 2, var22, var23, var24);
                                 }
                              } else {
                                 String[] var40 = var35.actions;
                                 if(Client.field1199) {
                                    var40 = class251.method4456(var40);
                                 }

                                 if(var40 != null) {
                                    for(int var41 = 4; var41 >= 0; --var41) {
                                       if(var40[var41] != null) {
                                          short var30 = 0;
                                          if(var41 == 0) {
                                             var30 = 3;
                                          }

                                          if(var41 == 1) {
                                             var30 = 4;
                                          }

                                          if(var41 == 2) {
                                             var30 = 5;
                                          }

                                          if(var41 == 3) {
                                             var30 = 6;
                                          }

                                          if(var41 == 4) {
                                             var30 = 1001;
                                          }

                                          class175.addMenuEntry(var40[var41], class220.method4055('\uffff') + var35.name, var30, var22, var23, var24);
                                       }
                                    }
                                 }

                                 class175.addMenuEntry("Examine", class220.method4055('\uffff') + var35.name, 1002, var35.field3445 << 14, var23, var24);
                              }
                           }

                           NPC var29;
                           Player var31;
                           int[] var47;
                           int var49;
                           if(var25 == 1) {
                              NPC var52 = Client.cachedNPCs[var26];
                              if(var52 == null) {
                                 continue;
                              }

                              if(var52.composition.field3561 == 1 && (var52.x & 127) == 64 && (var52.y & 127) == 64) {
                                 for(var28 = 0; var28 < Client.field937; ++var28) {
                                    var29 = Client.cachedNPCs[Client.npcIndices[var28]];
                                    if(var29 != null && var29 != var52 && var29.composition.field3561 == 1 && var29.x == var52.x && var29.y == var52.y) {
                                       class33.method349(var29.composition, Client.npcIndices[var28], var23, var24);
                                    }
                                 }

                                 var28 = class96.field1521;
                                 var47 = class96.field1531;

                                 for(var49 = 0; var49 < var28; ++var49) {
                                    var31 = Client.cachedPlayers[var47[var49]];
                                    if(var31 != null && var31.x == var52.x && var31.y == var52.y) {
                                       class181.method3429(var31, var47[var49], var23, var24);
                                    }
                                 }
                              }

                              class33.method349(var52.composition, var26, var23, var24);
                           }

                           if(var25 == 0) {
                              Player var53 = Client.cachedPlayers[var26];
                              if(var53 == null) {
                                 continue;
                              }

                              if((var53.x & 127) == 64 && (var53.y & 127) == 64) {
                                 for(var28 = 0; var28 < Client.field937; ++var28) {
                                    var29 = Client.cachedNPCs[Client.npcIndices[var28]];
                                    if(var29 != null && var29.composition.field3561 == 1 && var29.x == var53.x && var29.y == var53.y) {
                                       class33.method349(var29.composition, Client.npcIndices[var28], var23, var24);
                                    }
                                 }

                                 var28 = class96.field1521;
                                 var47 = class96.field1531;

                                 for(var49 = 0; var49 < var28; ++var49) {
                                    var31 = Client.cachedPlayers[var47[var49]];
                                    if(var31 != null && var53 != var31 && var31.x == var53.x && var31.y == var53.y) {
                                       class181.method3429(var31, var47[var49], var23, var24);
                                    }
                                 }
                              }

                              if(var26 != Client.field1056) {
                                 class181.method3429(var53, var26, var23, var24);
                              } else {
                                 var19 = var22;
                              }
                           }

                           if(var25 == 3) {
                              Deque var54 = Client.groundItemDeque[WallObject.plane][var23][var24];
                              if(var54 != null) {
                                 for(Item var55 = (Item)var54.method3585(); var55 != null; var55 = (Item)var54.method3591()) {
                                    ItemComposition var48 = class176.getItemDefinition(var55.id);
                                    if(Client.itemSelectionState == 1) {
                                       class175.addMenuEntry("Use", Client.selectedItemName + " " + "->" + " " + class220.method4055(16748608) + var48.name, 16, var55.id, var23, var24);
                                    } else if(Client.field1082) {
                                       if((WorldMapType3.spellTargetFlags & 1) == 1) {
                                          class175.addMenuEntry(Client.field1078, Client.field1159 + " " + "->" + " " + class220.method4055(16748608) + var48.name, 17, var55.id, var23, var24);
                                       }
                                    } else {
                                       String[] var42 = var48.groundActions;
                                       if(Client.field1199) {
                                          var42 = class251.method4456(var42);
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

                                             class175.addMenuEntry(var42[var43], class220.method4055(16748608) + var48.name, var32, var55.id, var23, var24);
                                          } else if(var43 == 2) {
                                             class175.addMenuEntry("Take", class220.method4055(16748608) + var48.name, 20, var55.id, var23, var24);
                                          }
                                       }

                                       class175.addMenuEntry("Examine", class220.method4055(16748608) + var48.name, 1004, var55.id, var23, var24);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var19 != -1) {
                        var21 = var19 & 127;
                        var22 = var19 >> 7 & 127;
                        Player var33 = Client.cachedPlayers[Client.field1056];
                        class181.method3429(var33, Client.field1056, var21, var22);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  if((Client.field1161 == 0 || Client.field1161 == 3) && (class59.field742 == 1 || !class34.field499 && class59.field742 == 4)) {
                     class210 var51 = var9.method3981(true);
                     if(var51 != null) {
                        var20 = class59.field747 - var10;
                        var21 = class59.field756 - var11;
                        if(var51.method3898(var20, var21)) {
                           var20 -= var51.field2607 / 2;
                           var21 -= var51.field2602 / 2;
                           var22 = Client.mapAngle + Client.mapScale & 2047;
                           var23 = class136.SINE[var22];
                           var24 = class136.COSINE[var22];
                           var23 = var23 * (256 + Client.mapScaleDelta) >> 8;
                           var24 = var24 * (256 + Client.mapScaleDelta) >> 8;
                           var25 = var24 * var20 + var23 * var21 >> 11;
                           var26 = var24 * var21 - var23 * var20 >> 11;
                           int var27 = var25 + XItemContainer.localPlayer.x >> 7;
                           var28 = XItemContainer.localPlayer.y - var26 >> 7;
                           Client.secretPacketBuffer1.putOpcode(115);
                           Client.secretPacketBuffer1.putByte(18);
                           Client.secretPacketBuffer1.putShortLE(class50.field659[82]?(class50.field659[81]?2:1):0);
                           Client.secretPacketBuffer1.putShort(var28 + class266.baseY);
                           Client.secretPacketBuffer1.putShort(var27 + class50.baseX);
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
                           Client.destinationX = var27;
                           Client.destinationY = var28;
                        }
                     }
                  }
               } else {
                  if(var9.contentType == 1400) {
                     class43.renderOverview.method5240(class59.field748, class59.field749, var44, var10, var11, var9.width, var9.height);
                  }

                  if(!Client.isMenuOpen && var44) {
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

                     WidgetNode var34 = (WidgetNode)Client.componentTable.method3530((long)var9.id);
                     if(var34 != null) {
                        if(var34.field844 == 0 && class59.field748 >= var12 && class59.field749 >= var13 && class59.field748 < var14 && class59.field749 < var15 && !Client.isMenuOpen && !Client.field1097) {
                           for(class69 var39 = (class69)Client.field1035.method3584(); var39 != null; var39 = (class69)Client.field1035.method3578()) {
                              if(var39.field848) {
                                 var39.unlink();
                                 var39.field849.field2776 = false;
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

                        var20 = var34.id;
                        if(class66.method1121(var20)) {
                           method262(class46.widgets[var20], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.hasScript) {
                     class69 var50;
                     if(!var9.field2685) {
                        if(var9.field2783 && class59.field748 >= var12 && class59.field749 >= var13 && class59.field748 < var14 && class59.field749 < var15) {
                           for(var50 = (class69)Client.field1035.method3584(); var50 != null; var50 = (class69)Client.field1035.method3578()) {
                              if(var50.field848 && var50.field849.field2732 == var50.field857) {
                                 var50.unlink();
                              }
                           }
                        }
                     } else if(class59.field748 >= var12 && class59.field749 >= var13 && class59.field748 < var14 && class59.field749 < var15) {
                        for(var50 = (class69)Client.field1035.method3584(); var50 != null; var50 = (class69)Client.field1035.method3578()) {
                           if(var50.field848) {
                              var50.unlink();
                              var50.field849.field2776 = false;
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

                     if(class59.field748 >= var12 && class59.field749 >= var13 && class59.field748 < var14 && class59.field749 < var15) {
                        var44 = true;
                     } else {
                        var44 = false;
                     }

                     boolean var45 = false;
                     if((class59.field754 == 1 || !class34.field499 && class59.field754 == 4) && var44) {
                        var45 = true;
                     }

                     boolean var46 = false;
                     if((class59.field742 == 1 || !class34.field499 && class59.field742 == 4) && class59.field747 >= var12 && class59.field756 >= var13 && class59.field747 < var14 && class59.field756 < var15) {
                        var46 = true;
                     }

                     if(var46) {
                        class140.method2856(var9, class59.field747 - var10, class59.field756 - var11);
                     }

                     if(var9.contentType == 1400) {
                        class43.renderOverview.method5182(class59.field748, class59.field749, var44 & var45);
                     }

                     if(Client.field1100 != null && var9 != Client.field1100 && var44 && FrameMap.method2664(WorldMapType3.method199(var9))) {
                        Client.field1105 = var9;
                     }

                     if(var9 == Client.field1101) {
                        Client.field1069 = true;
                        Client.field1175 = var10;
                        Client.field1107 = var11;
                     }

                     if(var9.field2734) {
                        class69 var36;
                        if(var44 && Client.field1125 != 0 && var9.field2732 != null) {
                           var36 = new class69();
                           var36.field848 = true;
                           var36.field849 = var9;
                           var36.field853 = Client.field1125;
                           var36.field857 = var9.field2732;
                           Client.field1035.method3603(var36);
                        }

                        if(Client.field1100 != null || class95.field1513 != null || Client.isMenuOpen) {
                           var46 = false;
                           var45 = false;
                           var44 = false;
                        }

                        if(!var9.field2780 && var46) {
                           var9.field2780 = true;
                           if(var9.field2725 != null) {
                              var36 = new class69();
                              var36.field848 = true;
                              var36.field849 = var9;
                              var36.field850 = class59.field747 - var10;
                              var36.field853 = class59.field756 - var11;
                              var36.field857 = var9.field2725;
                              Client.field1035.method3603(var36);
                           }
                        }

                        if(var9.field2780 && var45 && var9.field2677 != null) {
                           var36 = new class69();
                           var36.field848 = true;
                           var36.field849 = var9;
                           var36.field850 = class59.field748 - var10;
                           var36.field853 = class59.field749 - var11;
                           var36.field857 = var9.field2677;
                           Client.field1035.method3603(var36);
                        }

                        if(var9.field2780 && !var45) {
                           var9.field2780 = false;
                           if(var9.field2738 != null) {
                              var36 = new class69();
                              var36.field848 = true;
                              var36.field849 = var9;
                              var36.field850 = class59.field748 - var10;
                              var36.field853 = class59.field749 - var11;
                              var36.field857 = var9.field2738;
                              Client.field1128.method3603(var36);
                           }
                        }

                        if(var45 && var9.field2722 != null) {
                           var36 = new class69();
                           var36.field848 = true;
                           var36.field849 = var9;
                           var36.field850 = class59.field748 - var10;
                           var36.field853 = class59.field749 - var11;
                           var36.field857 = var9.field2722;
                           Client.field1035.method3603(var36);
                        }

                        if(!var9.field2776 && var44) {
                           var9.field2776 = true;
                           if(var9.field2740 != null) {
                              var36 = new class69();
                              var36.field848 = true;
                              var36.field849 = var9;
                              var36.field850 = class59.field748 - var10;
                              var36.field853 = class59.field749 - var11;
                              var36.field857 = var9.field2740;
                              Client.field1035.method3603(var36);
                           }
                        }

                        if(var9.field2776 && var44 && var9.field2741 != null) {
                           var36 = new class69();
                           var36.field848 = true;
                           var36.field849 = var9;
                           var36.field850 = class59.field748 - var10;
                           var36.field853 = class59.field749 - var11;
                           var36.field857 = var9.field2741;
                           Client.field1035.method3603(var36);
                        }

                        if(var9.field2776 && !var44) {
                           var9.field2776 = false;
                           if(var9.field2742 != null) {
                              var36 = new class69();
                              var36.field848 = true;
                              var36.field849 = var9;
                              var36.field850 = class59.field748 - var10;
                              var36.field853 = class59.field749 - var11;
                              var36.field857 = var9.field2742;
                              Client.field1128.method3603(var36);
                           }
                        }

                        if(var9.field2753 != null) {
                           var36 = new class69();
                           var36.field849 = var9;
                           var36.field857 = var9.field2753;
                           Client.field1127.method3603(var36);
                        }

                        class69 var37;
                        if(var9.field2747 != null && Client.field975 > var9.field2736) {
                           if(var9.field2748 != null && Client.field975 - var9.field2736 <= 32) {
                              label1115:
                              for(var21 = var9.field2736; var21 < Client.field975; ++var21) {
                                 var22 = Client.field1113[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2748.length; ++var23) {
                                    if(var22 == var9.field2748[var23]) {
                                       var37 = new class69();
                                       var37.field849 = var9;
                                       var37.field857 = var9.field2747;
                                       Client.field1035.method3603(var37);
                                       break label1115;
                                    }
                                 }
                              }
                           } else {
                              var36 = new class69();
                              var36.field849 = var9;
                              var36.field857 = var9.field2747;
                              Client.field1035.method3603(var36);
                           }

                           var9.field2736 = Client.field975;
                        }

                        if(var9.field2718 != null && Client.field1116 > var9.field2669) {
                           if(var9.field2787 != null && Client.field1116 - var9.field2669 <= 32) {
                              label1091:
                              for(var21 = var9.field2669; var21 < Client.field1116; ++var21) {
                                 var22 = Client.interfaceItemTriggers[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2787.length; ++var23) {
                                    if(var22 == var9.field2787[var23]) {
                                       var37 = new class69();
                                       var37.field849 = var9;
                                       var37.field857 = var9.field2718;
                                       Client.field1035.method3603(var37);
                                       break label1091;
                                    }
                                 }
                              }
                           } else {
                              var36 = new class69();
                              var36.field849 = var9;
                              var36.field857 = var9.field2718;
                              Client.field1035.method3603(var36);
                           }

                           var9.field2669 = Client.field1116;
                        }

                        if(var9.field2751 != null && Client.field1067 > var9.field2666) {
                           if(var9.field2752 != null && Client.field1067 - var9.field2666 <= 32) {
                              label1067:
                              for(var21 = var9.field2666; var21 < Client.field1067; ++var21) {
                                 var22 = Client.field1117[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2752.length; ++var23) {
                                    if(var22 == var9.field2752[var23]) {
                                       var37 = new class69();
                                       var37.field849 = var9;
                                       var37.field857 = var9.field2751;
                                       Client.field1035.method3603(var37);
                                       break label1067;
                                    }
                                 }
                              }
                           } else {
                              var36 = new class69();
                              var36.field849 = var9;
                              var36.field857 = var9.field2751;
                              Client.field1035.method3603(var36);
                           }

                           var9.field2666 = Client.field1067;
                        }

                        if(Client.field1119 > var9.field2781 && var9.field2756 != null) {
                           var36 = new class69();
                           var36.field849 = var9;
                           var36.field857 = var9.field2756;
                           Client.field1035.method3603(var36);
                        }

                        if(Client.field1025 > var9.field2781 && var9.field2758 != null) {
                           var36 = new class69();
                           var36.field849 = var9;
                           var36.field857 = var9.field2758;
                           Client.field1035.method3603(var36);
                        }

                        if(Client.field1121 > var9.field2781 && var9.field2759 != null) {
                           var36 = new class69();
                           var36.field849 = var9;
                           var36.field857 = var9.field2759;
                           Client.field1035.method3603(var36);
                        }

                        if(Client.field1110 > var9.field2781 && var9.field2663 != null) {
                           var36 = new class69();
                           var36.field849 = var9;
                           var36.field857 = var9.field2663;
                           Client.field1035.method3603(var36);
                        }

                        if(Client.field1004 > var9.field2781 && var9.field2701 != null) {
                           var36 = new class69();
                           var36.field849 = var9;
                           var36.field857 = var9.field2701;
                           Client.field1035.method3603(var36);
                        }

                        if(Client.field1124 > var9.field2781 && var9.field2760 != null) {
                           var36 = new class69();
                           var36.field849 = var9;
                           var36.field857 = var9.field2760;
                           Client.field1035.method3603(var36);
                        }

                        var9.field2781 = Client.field1112;
                        if(var9.field2761 != null) {
                           for(var21 = 0; var21 < Client.field1037; ++var21) {
                              class69 var38 = new class69();
                              var38.field849 = var9;
                              var38.field854 = Client.field1150[var21];
                              var38.field855 = Client.field1149[var21];
                              var38.field857 = var9.field2761;
                              Client.field1035.method3603(var38);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.field1100 == null && class95.field1513 == null && !Client.isMenuOpen) {
                     if((var9.field2769 >= 0 || var9.field2681 != 0) && class59.field748 >= var12 && class59.field749 >= var13 && class59.field748 < var14 && class59.field749 < var15) {
                        if(var9.field2769 >= 0) {
                           KitDefinition.field3371 = var0[var9.field2769];
                        } else {
                           KitDefinition.field3371 = var9;
                        }
                     }

                     if(var9.type == 8 && class59.field748 >= var12 && class59.field749 >= var13 && class59.field748 < var14 && class59.field749 < var15) {
                        PendingSpawn.field1211 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        class176.method3364(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, class59.field748, class59.field749);
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
      if(Client.field1202 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field1202 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field1202 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field1202 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field1202 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(Client.field1062 != null) {
         var3 = "/p=" + Client.field1062;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field931 + "/a=" + class33.field480 + var3 + "/";
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-845090670"
   )
   public static int method264(int var0) {
      Varbit var2 = (Varbit)Varbit.field3390.get((long)var0);
      Varbit var1;
      if(var2 != null) {
         var1 = var2;
      } else {
         byte[] var7 = Varbit.field3391.getConfigData(14, var0);
         var2 = new Varbit();
         if(var7 != null) {
            var2.method4426(new Buffer(var7));
         }

         Varbit.field3390.put(var2, (long)var0);
         var1 = var2;
      }

      int var3 = var1.configId;
      int var4 = var1.leastSignificantBit;
      int var5 = var1.mostSignificantBit;
      int var6 = class211.field2613[var5 - var4];
      return class211.widgetSettings[var3] >> var4 & var6;
   }
}
