import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
   @ObfuscatedName("d")
   @Export("progress")
   byte progress;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 77816035
   )
   @Export("price")
   public int price;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -113944759
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -627272043
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -764493253
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1143308177
   )
   @Export("spent")
   public int spent;

   public GrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(Lfg;Z)V",
      garbageValue = "0"
   )
   public GrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1471497444"
   )
   void method117(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1675959726"
   )
   void method103(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-663141281"
   )
   public int method101() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-317689150"
   )
   public int method99() {
      return this.progress & 7;
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "([Lhj;IIIIIIII)V",
      garbageValue = "-1422641377"
   )
   static final void method100(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2785 || class244.getWidgetConfig(var9) != 0 || var9 == Client.field1047 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !Script.method1926(var9))) {
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

            if(var9 == Client.field1052) {
               Client.field1094 = true;
               Client.field1095 = var10;
               Client.field1096 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = MouseInput.field745;
               var17 = MouseInput.field746;
               if(MouseInput.field741 != 0) {
                  var16 = MouseInput.field752;
                  var17 = MouseInput.field753;
               }

               boolean var43 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               int var20;
               int var22;
               int var23;
               int var46;
               if(var9.contentType == 1337) {
                  if(!Client.field1123 && !Client.isMenuOpen && var43) {
                     if(Client.itemSelectionState == 0 && !Client.spellSelected) {
                        class10.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var19 = -1;
                     var20 = -1;

                     for(var46 = 0; var46 < class132.field1989; ++var46) {
                        var22 = class132.field1990[var46];
                        var23 = var22 & 127;
                        int var24 = var22 >> 7 & 127;
                        int var25 = var22 >> 29 & 3;
                        int var26 = var22 >> 14 & 32767;
                        if(var22 != var20) {
                           var20 = var22;
                           if(var25 == 2 && class8.region.method2801(class5.plane, var23, var24, var22) >= 0) {
                              ObjectComposition var27 = Occluder.getObjectDefinition(var26);
                              if(var27.impostorIds != null) {
                                 var27 = var27.getImpostor();
                              }

                              if(var27 == null) {
                                 continue;
                              }

                              if(Client.itemSelectionState == 1) {
                                 class10.addMenuEntry("Use", Client.field1067 + " " + "->" + " " + class60.getColTags('\uffff') + var27.name, 1, var22, var23, var24);
                              } else if(Client.spellSelected) {
                                 if((WorldMapType1.field451 & 4) == 4) {
                                    class10.addMenuEntry(Client.field1071, Client.field948 + " " + "->" + " " + class60.getColTags('\uffff') + var27.name, 2, var22, var23, var24);
                                 }
                              } else {
                                 String[] var36 = var27.actions;
                                 if(Client.field978) {
                                    var36 = DecorativeObject.method2966(var36);
                                 }

                                 if(var36 != null) {
                                    for(int var37 = 4; var37 >= 0; --var37) {
                                       if(var36[var37] != null) {
                                          short var38 = 0;
                                          if(var37 == 0) {
                                             var38 = 3;
                                          }

                                          if(var37 == 1) {
                                             var38 = 4;
                                          }

                                          if(var37 == 2) {
                                             var38 = 5;
                                          }

                                          if(var37 == 3) {
                                             var38 = 6;
                                          }

                                          if(var37 == 4) {
                                             var38 = 1001;
                                          }

                                          class10.addMenuEntry(var36[var37], class60.getColTags('\uffff') + var27.name, var38, var22, var23, var24);
                                       }
                                    }
                                 }

                                 class10.addMenuEntry("Examine", class60.getColTags('\uffff') + var27.name, 1002, var27.id << 14, var23, var24);
                              }
                           }

                           int var28;
                           NPC var29;
                           Player var39;
                           int[] var50;
                           int var54;
                           if(var25 == 1) {
                              NPC var47 = Client.cachedNPCs[var26];
                              if(var47 == null) {
                                 continue;
                              }

                              if(var47.composition.field3559 == 1 && (var47.x & 127) == 64 && (var47.y & 127) == 64) {
                                 for(var28 = 0; var28 < Client.npcIndexesCount; ++var28) {
                                    var29 = Client.cachedNPCs[Client.npcIndices[var28]];
                                    if(var29 != null && var47 != var29 && var29.composition.field3559 == 1 && var47.x == var29.x && var29.y == var47.y) {
                                       SoundTask.method2153(var29.composition, Client.npcIndices[var28], var23, var24);
                                    }
                                 }

                                 var28 = class94.playerIndexesCount;
                                 var50 = class94.playerIndices;

                                 for(var54 = 0; var54 < var28; ++var54) {
                                    var39 = Client.cachedPlayers[var50[var54]];
                                    if(var39 != null && var39.x == var47.x && var47.y == var39.y) {
                                       ItemContainer.method1130(var39, var50[var54], var23, var24);
                                    }
                                 }
                              }

                              SoundTask.method2153(var47.composition, var26, var23, var24);
                           }

                           if(var25 == 0) {
                              Player var48 = Client.cachedPlayers[var26];
                              if(var48 == null) {
                                 continue;
                              }

                              if((var48.x & 127) == 64 && (var48.y & 127) == 64) {
                                 for(var28 = 0; var28 < Client.npcIndexesCount; ++var28) {
                                    var29 = Client.cachedNPCs[Client.npcIndices[var28]];
                                    if(var29 != null && var29.composition.field3559 == 1 && var48.x == var29.x && var29.y == var48.y) {
                                       SoundTask.method2153(var29.composition, Client.npcIndices[var28], var23, var24);
                                    }
                                 }

                                 var28 = class94.playerIndexesCount;
                                 var50 = class94.playerIndices;

                                 for(var54 = 0; var54 < var28; ++var54) {
                                    var39 = Client.cachedPlayers[var50[var54]];
                                    if(var39 != null && var48 != var39 && var48.x == var39.x && var48.y == var39.y) {
                                       ItemContainer.method1130(var39, var50[var54], var23, var24);
                                    }
                                 }
                              }

                              if(var26 != Client.field1061) {
                                 ItemContainer.method1130(var48, var26, var23, var24);
                              } else {
                                 var19 = var22;
                              }
                           }

                           if(var25 == 3) {
                              Deque var49 = Client.groundItemDeque[class5.plane][var23][var24];
                              if(var49 != null) {
                                 for(Item var53 = (Item)var49.getTail(); var53 != null; var53 = (Item)var49.getPrevious()) {
                                    ItemComposition var51 = class46.getItemDefinition(var53.id);
                                    if(Client.itemSelectionState == 1) {
                                       class10.addMenuEntry("Use", Client.field1067 + " " + "->" + " " + class60.getColTags(16748608) + var51.name, 16, var53.id, var23, var24);
                                    } else if(Client.spellSelected) {
                                       if((WorldMapType1.field451 & 1) == 1) {
                                          class10.addMenuEntry(Client.field1071, Client.field948 + " " + "->" + " " + class60.getColTags(16748608) + var51.name, 17, var53.id, var23, var24);
                                       }
                                    } else {
                                       String[] var30 = var51.groundActions;
                                       if(Client.field978) {
                                          var30 = DecorativeObject.method2966(var30);
                                       }

                                       for(int var31 = 4; var31 >= 0; --var31) {
                                          if(var30 != null && var30[var31] != null) {
                                             byte var32 = 0;
                                             if(var31 == 0) {
                                                var32 = 18;
                                             }

                                             if(var31 == 1) {
                                                var32 = 19;
                                             }

                                             if(var31 == 2) {
                                                var32 = 20;
                                             }

                                             if(var31 == 3) {
                                                var32 = 21;
                                             }

                                             if(var31 == 4) {
                                                var32 = 22;
                                             }

                                             class10.addMenuEntry(var30[var31], class60.getColTags(16748608) + var51.name, var32, var53.id, var23, var24);
                                          } else if(var31 == 2) {
                                             class10.addMenuEntry("Take", class60.getColTags(16748608) + var51.name, 20, var53.id, var23, var24);
                                          }
                                       }

                                       class10.addMenuEntry("Examine", class60.getColTags(16748608) + var51.name, 1004, var53.id, var23, var24);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var19 != -1) {
                        var46 = var19 & 127;
                        var22 = var19 >> 7 & 127;
                        Player var33 = Client.cachedPlayers[Client.field1061];
                        ItemContainer.method1130(var33, Client.field1061, var46, var22);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  class22.method161(var9, var10, var11);
               } else {
                  if(var9.contentType == 1400) {
                     GameObject.renderOverview.method5422(MouseInput.field745, MouseInput.field746, var43, var10, var11, var9.width, var9.height);
                  }

                  if(!Client.isMenuOpen && var43) {
                     if(var9.contentType == 1400) {
                        GameObject.renderOverview.method5366(var10, var11, var9.width, var9.height, var16, var17);
                     } else {
                        MessageNode.method1156(var9, var16 - var10, var17 - var11);
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && Script.method1926(var9) && var9 != class27.field403) {
                        continue;
                     }

                     method100(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method100(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var34 = (WidgetNode)Client.componentTable.get((long)var9.id);
                     if(var34 != null) {
                        if(var34.owner == 0 && MouseInput.field745 >= var12 && MouseInput.field746 >= var13 && MouseInput.field745 < var14 && MouseInput.field746 < var15 && !Client.isMenuOpen && !Client.field961) {
                           for(ScriptEvent var35 = (ScriptEvent)Client.field1112.getFront(); var35 != null; var35 = (ScriptEvent)Client.field1112.getNext()) {
                              if(var35.field845) {
                                 var35.unlink();
                                 var35.widget.field2695 = false;
                              }
                           }

                           if(Timer.field2268 == 0) {
                              Client.field1052 = null;
                              Client.field1047 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Client.menuOptionCount = 0;
                              Client.isMenuOpen = false;
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.field1021[0] = false;
                              Client.menuOptionCount = 1;
                           }
                        }

                        var20 = var34.id;
                        if(class93.loadWidget(var20)) {
                           method100(class177.widgets[var20], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.hasScript) {
                     ScriptEvent var52;
                     if(!var9.field2791) {
                        if(var9.field2792 && MouseInput.field745 >= var12 && MouseInput.field746 >= var13 && MouseInput.field745 < var14 && MouseInput.field746 < var15) {
                           for(var52 = (ScriptEvent)Client.field1112.getFront(); var52 != null; var52 = (ScriptEvent)Client.field1112.getNext()) {
                              if(var52.field845 && var52.widget.scrollListener == var52.field846) {
                                 var52.unlink();
                              }
                           }
                        }
                     } else if(MouseInput.field745 >= var12 && MouseInput.field746 >= var13 && MouseInput.field745 < var14 && MouseInput.field746 < var15) {
                        for(var52 = (ScriptEvent)Client.field1112.getFront(); var52 != null; var52 = (ScriptEvent)Client.field1112.getNext()) {
                           if(var52.field845) {
                              var52.unlink();
                              var52.widget.field2695 = false;
                           }
                        }

                        if(Timer.field2268 == 0) {
                           Client.field1052 = null;
                           Client.field1047 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Client.menuOptionCount = 0;
                           Client.isMenuOpen = false;
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.field1021[0] = false;
                           Client.menuOptionCount = 1;
                        }
                     }

                     if(MouseInput.field745 >= var12 && MouseInput.field746 >= var13 && MouseInput.field745 < var14 && MouseInput.field746 < var15) {
                        var43 = true;
                     } else {
                        var43 = false;
                     }

                     boolean var44 = false;
                     if((MouseInput.field738 == 1 || !class110.field1650 && MouseInput.field738 == 4) && var43) {
                        var44 = true;
                     }

                     boolean var45 = false;
                     if((MouseInput.field741 == 1 || !class110.field1650 && MouseInput.field741 == 4) && MouseInput.field752 >= var12 && MouseInput.field753 >= var13 && MouseInput.field752 < var14 && MouseInput.field753 < var15) {
                        var45 = true;
                     }

                     if(var45) {
                        class2.method4(var9, MouseInput.field752 - var10, MouseInput.field753 - var11);
                     }

                     if(var9.contentType == 1400) {
                        GameObject.renderOverview.method5369(MouseInput.field745, MouseInput.field746, var43 & var44, var43 & var45);
                     }

                     if(Client.field1052 != null && var9 != Client.field1052 && var43) {
                        var22 = class244.getWidgetConfig(var9);
                        boolean var21 = (var22 >> 20 & 1) != 0;
                        if(var21) {
                           Client.field952 = var9;
                        }
                     }

                     if(var9 == Client.field1047) {
                        Client.field1091 = true;
                        Client.field1092 = var10;
                        Client.field1093 = var11;
                     }

                     if(var9.field2785) {
                        ScriptEvent var40;
                        if(var43 && Client.field1111 != 0 && var9.scrollListener != null) {
                           var40 = new ScriptEvent();
                           var40.field845 = true;
                           var40.widget = var9;
                           var40.field848 = Client.field1111;
                           var40.field846 = var9.scrollListener;
                           Client.field1112.addFront(var40);
                        }

                        if(Client.field1052 != null || ClanMember.field915 != null || Client.isMenuOpen) {
                           var45 = false;
                           var44 = false;
                           var43 = false;
                        }

                        if(!var9.field2784 && var45) {
                           var9.field2784 = true;
                           if(var9.field2655 != null) {
                              var40 = new ScriptEvent();
                              var40.field845 = true;
                              var40.widget = var9;
                              var40.field847 = MouseInput.field752 - var10;
                              var40.field848 = MouseInput.field753 - var11;
                              var40.field846 = var9.field2655;
                              Client.field1112.addFront(var40);
                           }
                        }

                        if(var9.field2784 && var44 && var9.field2741 != null) {
                           var40 = new ScriptEvent();
                           var40.field845 = true;
                           var40.widget = var9;
                           var40.field847 = MouseInput.field745 - var10;
                           var40.field848 = MouseInput.field746 - var11;
                           var40.field846 = var9.field2741;
                           Client.field1112.addFront(var40);
                        }

                        if(var9.field2784 && !var44) {
                           var9.field2784 = false;
                           if(var9.field2742 != null) {
                              var40 = new ScriptEvent();
                              var40.field845 = true;
                              var40.widget = var9;
                              var40.field847 = MouseInput.field745 - var10;
                              var40.field848 = MouseInput.field746 - var11;
                              var40.field846 = var9.field2742;
                              Client.field1090.addFront(var40);
                           }
                        }

                        if(var44 && var9.field2783 != null) {
                           var40 = new ScriptEvent();
                           var40.field845 = true;
                           var40.widget = var9;
                           var40.field847 = MouseInput.field745 - var10;
                           var40.field848 = MouseInput.field746 - var11;
                           var40.field846 = var9.field2783;
                           Client.field1112.addFront(var40);
                        }

                        if(!var9.field2695 && var43) {
                           var9.field2695 = true;
                           if(var9.mouseEnterListener != null) {
                              var40 = new ScriptEvent();
                              var40.field845 = true;
                              var40.widget = var9;
                              var40.field847 = MouseInput.field745 - var10;
                              var40.field848 = MouseInput.field746 - var11;
                              var40.field846 = var9.mouseEnterListener;
                              Client.field1112.addFront(var40);
                           }
                        }

                        if(var9.field2695 && var43 && var9.mouseHoverListener != null) {
                           var40 = new ScriptEvent();
                           var40.field845 = true;
                           var40.widget = var9;
                           var40.field847 = MouseInput.field745 - var10;
                           var40.field848 = MouseInput.field746 - var11;
                           var40.field846 = var9.mouseHoverListener;
                           Client.field1112.addFront(var40);
                        }

                        if(var9.field2695 && !var43) {
                           var9.field2695 = false;
                           if(var9.mouseExitListener != null) {
                              var40 = new ScriptEvent();
                              var40.field845 = true;
                              var40.widget = var9;
                              var40.field847 = MouseInput.field745 - var10;
                              var40.field848 = MouseInput.field746 - var11;
                              var40.field846 = var9.mouseExitListener;
                              Client.field1090.addFront(var40);
                           }
                        }

                        if(var9.renderListener != null) {
                           var40 = new ScriptEvent();
                           var40.widget = var9;
                           var40.field846 = var9.renderListener;
                           Client.field1125.addFront(var40);
                        }

                        ScriptEvent var41;
                        if(var9.configListenerArgs != null && Client.field1100 > var9.field2762) {
                           if(var9.configTriggers != null && Client.field1100 - var9.field2762 <= 32) {
                              label1093:
                              for(var46 = var9.field2762; var46 < Client.field1100; ++var46) {
                                 var22 = Client.field1099[var46 & 31];

                                 for(var23 = 0; var23 < var9.configTriggers.length; ++var23) {
                                    if(var22 == var9.configTriggers[var23]) {
                                       var41 = new ScriptEvent();
                                       var41.widget = var9;
                                       var41.field846 = var9.configListenerArgs;
                                       Client.field1112.addFront(var41);
                                       break label1093;
                                    }
                                 }
                              }
                           } else {
                              var40 = new ScriptEvent();
                              var40.widget = var9;
                              var40.field846 = var9.configListenerArgs;
                              Client.field1112.addFront(var40);
                           }

                           var9.field2762 = Client.field1100;
                        }

                        if(var9.tableListenerArgs != null && Client.field1102 > var9.field2711) {
                           if(var9.tableModTriggers != null && Client.field1102 - var9.field2711 <= 32) {
                              label1069:
                              for(var46 = var9.field2711; var46 < Client.field1102; ++var46) {
                                 var22 = Client.interfaceItemTriggers[var46 & 31];

                                 for(var23 = 0; var23 < var9.tableModTriggers.length; ++var23) {
                                    if(var22 == var9.tableModTriggers[var23]) {
                                       var41 = new ScriptEvent();
                                       var41.widget = var9;
                                       var41.field846 = var9.tableListenerArgs;
                                       Client.field1112.addFront(var41);
                                       break label1069;
                                    }
                                 }
                              }
                           } else {
                              var40 = new ScriptEvent();
                              var40.widget = var9;
                              var40.field846 = var9.tableListenerArgs;
                              Client.field1112.addFront(var40);
                           }

                           var9.field2711 = Client.field1102;
                        }

                        if(var9.skillListenerArgs != null && Client.field1104 > var9.field2718) {
                           if(var9.skillTriggers != null && Client.field1104 - var9.field2718 <= 32) {
                              label1045:
                              for(var46 = var9.field2718; var46 < Client.field1104; ++var46) {
                                 var22 = Client.field1152[var46 & 31];

                                 for(var23 = 0; var23 < var9.skillTriggers.length; ++var23) {
                                    if(var22 == var9.skillTriggers[var23]) {
                                       var41 = new ScriptEvent();
                                       var41.widget = var9;
                                       var41.field846 = var9.skillListenerArgs;
                                       Client.field1112.addFront(var41);
                                       break label1045;
                                    }
                                 }
                              }
                           } else {
                              var40 = new ScriptEvent();
                              var40.widget = var9;
                              var40.field846 = var9.skillListenerArgs;
                              Client.field1112.addFront(var40);
                           }

                           var9.field2718 = Client.field1104;
                        }

                        if(Client.chatCycle > var9.field2698 && var9.field2760 != null) {
                           var40 = new ScriptEvent();
                           var40.widget = var9;
                           var40.field846 = var9.field2760;
                           Client.field1112.addFront(var40);
                        }

                        if(Client.field1106 > var9.field2698 && var9.field2653 != null) {
                           var40 = new ScriptEvent();
                           var40.widget = var9;
                           var40.field846 = var9.field2653;
                           Client.field1112.addFront(var40);
                        }

                        if(Client.field1107 > var9.field2698 && var9.field2691 != null) {
                           var40 = new ScriptEvent();
                           var40.widget = var9;
                           var40.field846 = var9.field2691;
                           Client.field1112.addFront(var40);
                        }

                        if(Client.field1108 > var9.field2698 && var9.field2768 != null) {
                           var40 = new ScriptEvent();
                           var40.widget = var9;
                           var40.field846 = var9.field2768;
                           Client.field1112.addFront(var40);
                        }

                        if(Client.field1109 > var9.field2698 && var9.field2769 != null) {
                           var40 = new ScriptEvent();
                           var40.widget = var9;
                           var40.field846 = var9.field2769;
                           Client.field1112.addFront(var40);
                        }

                        if(Client.field1110 > var9.field2698 && var9.field2775 != null) {
                           var40 = new ScriptEvent();
                           var40.widget = var9;
                           var40.field846 = var9.field2775;
                           Client.field1112.addFront(var40);
                        }

                        var9.field2698 = Client.cycleCntr;
                        if(var9.field2761 != null) {
                           for(var46 = 0; var46 < Client.field1134; ++var46) {
                              ScriptEvent var42 = new ScriptEvent();
                              var42.widget = var9;
                              var42.field851 = Client.field1136[var46];
                              var42.field844 = Client.field1185[var46];
                              var42.field846 = var9.field2761;
                              Client.field1112.addFront(var42);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.field1052 == null && ClanMember.field915 == null && !Client.isMenuOpen) {
                     if((var9.field2740 >= 0 || var9.field2685 != 0) && MouseInput.field745 >= var12 && MouseInput.field746 >= var13 && MouseInput.field745 < var14 && MouseInput.field746 < var15) {
                        if(var9.field2740 >= 0) {
                           class27.field403 = var0[var9.field2740];
                        } else {
                           class27.field403 = var9;
                        }
                     }

                     if(var9.type == 8 && MouseInput.field745 >= var12 && MouseInput.field746 >= var13 && MouseInput.field745 < var14 && MouseInput.field746 < var15) {
                        class48.field635 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        class22.method154(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, MouseInput.field745, MouseInput.field746);
                     }
                  }
               }
            }
         }
      }

   }
}
