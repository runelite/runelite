import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public class class23 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1069822511
   )
   public static int field342;

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(ZLgt;I)V",
      garbageValue = "2136895178"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0, PacketBuffer var1) {
      Client.isDynamicRegion = var0;
      int var2;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      if(!Client.isDynamicRegion) {
         var2 = var1.readUnsignedShort();
         int var3 = var1.readUnsignedShort();
         var4 = var1.readUnsignedShort();
         Client.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               Client.xteaKeys[var5][var6] = var1.readInt();
            }
         }

         Item.mapRegions = new int[var4];
         class47.landMapFileIds = new int[var4];
         class84.landRegionFileIds = new int[var4];
         class2.field13 = new byte[var4][];
         class46.field571 = new byte[var4][];
         boolean var16 = false;
         if((var2 / 8 == 48 || var2 / 8 == 49) && var3 / 8 == 48) {
            var16 = true;
         }

         if(var2 / 8 == 48 && var3 / 8 == 148) {
            var16 = true;
         }

         var4 = 0;

         for(var6 = (var2 - 6) / 8; var6 <= (var2 + 6) / 8; ++var6) {
            for(var7 = (var3 - 6) / 8; var7 <= (var3 + 6) / 8; ++var7) {
               var8 = var7 + (var6 << 8);
               if(!var16 || var7 != 49 && var7 != 149 && var7 != 147 && var6 != 50 && (var6 != 49 || var7 != 47)) {
                  Item.mapRegions[var4] = var8;
                  class47.landMapFileIds[var4] = Client.indexMaps.getFile("m" + var6 + "_" + var7);
                  class84.landRegionFileIds[var4] = Client.indexMaps.getFile("l" + var6 + "_" + var7);
                  ++var4;
               }
            }
         }

         class43.method599(var2, var3, true);
      } else {
         var2 = var1.readUnsignedShortOb1();
         boolean var15 = var1.readUnsignedByte() == 1;
         var4 = var1.readUnsignedShort();
         var5 = var1.readUnsignedShort();
         var1.bitAccess();

         int var9;
         for(var6 = 0; var6 < 4; ++var6) {
            for(var7 = 0; var7 < 13; ++var7) {
               for(var8 = 0; var8 < 13; ++var8) {
                  var9 = var1.getBits(1);
                  if(var9 == 1) {
                     Client.field897[var6][var7][var8] = var1.getBits(26);
                  } else {
                     Client.field897[var6][var7][var8] = -1;
                  }
               }
            }
         }

         var1.byteAccess();
         Client.xteaKeys = new int[var5][4];

         for(var6 = 0; var6 < var5; ++var6) {
            for(var7 = 0; var7 < 4; ++var7) {
               Client.xteaKeys[var6][var7] = var1.readInt();
            }
         }

         Item.mapRegions = new int[var5];
         class47.landMapFileIds = new int[var5];
         class84.landRegionFileIds = new int[var5];
         class2.field13 = new byte[var5][];
         class46.field571 = new byte[var5][];
         var5 = 0;

         for(var6 = 0; var6 < 4; ++var6) {
            for(var7 = 0; var7 < 13; ++var7) {
               for(var8 = 0; var8 < 13; ++var8) {
                  var9 = Client.field897[var6][var7][var8];
                  if(var9 != -1) {
                     int var10 = var9 >> 14 & 1023;
                     int var11 = var9 >> 3 & 2047;
                     int var12 = (var10 / 8 << 8) + var11 / 8;

                     int var13;
                     for(var13 = 0; var13 < var5; ++var13) {
                        if(Item.mapRegions[var13] == var12) {
                           var12 = -1;
                           break;
                        }
                     }

                     if(var12 != -1) {
                        Item.mapRegions[var5] = var12;
                        var13 = var12 >> 8 & 255;
                        int var14 = var12 & 255;
                        class47.landMapFileIds[var5] = Client.indexMaps.getFile("m" + var13 + "_" + var14);
                        class84.landRegionFileIds[var5] = Client.indexMaps.getFile("l" + var13 + "_" + var14);
                        ++var5;
                     }
                  }
               }
            }
         }

         class43.method599(var2, var4, !var15);
      }

   }

   @ObfuscatedName("jl")
   @ObfuscatedSignature(
      signature = "([Lhs;IIIIIIII)V",
      garbageValue = "-1919257398"
   )
   static final void method174(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2834 || WorldComparator.getWidgetConfig(var9) != 0 || var9 == Client.field930 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !ContextMenuRow.method1877(var9))) {
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

            if(var9 == Client.field940) {
               Client.field980 = true;
               Client.field919 = var10;
               Client.field1007 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = MouseInput.mouseLastX;
               var17 = MouseInput.mouseLastY;
               if(MouseInput.mouseLastButton != 0) {
                  var16 = MouseInput.mouseLastPressedX;
                  var17 = MouseInput.mouseLastPressedY;
               }

               boolean var35 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               if(var9.contentType == 1337) {
                  if(!Client.field848 && !Client.isMenuOpen && var35) {
                     class47.method677(var16, var17, var12, var13);
                  }
               } else {
                  int var20;
                  int var22;
                  int var23;
                  int var24;
                  int var25;
                  int var26;
                  int var38;
                  if(var9.contentType == 1338) {
                     if((Client.field978 == 0 || Client.field978 == 3) && (MouseInput.mouseLastButton == 1 || !class29.middleMouseMovesCamera && MouseInput.mouseLastButton == 4)) {
                        class221 var40 = var9.method4421(true);
                        if(var40 != null) {
                           var20 = MouseInput.mouseLastPressedX - var10;
                           var38 = MouseInput.mouseLastPressedY - var11;
                           if(var40.method4347(var20, var38)) {
                              var20 -= var40.field2708 / 2;
                              var38 -= var40.field2703 / 2;
                              var22 = Client.mapAngle & 2047;
                              var23 = Graphics3D.SINE[var22];
                              var24 = Graphics3D.COSINE[var22];
                              var25 = var24 * var20 + var38 * var23 >> 11;
                              var26 = var38 * var24 - var20 * var23 >> 11;
                              int var27 = var25 + GroundObject.localPlayer.x >> 7;
                              int var28 = GroundObject.localPlayer.y - var26 >> 7;
                              PacketNode var29 = Script.method2025(ClientPacket.field2323, Client.field937.field1454);
                              var29.packetBuffer.putByte(18);
                              var29.packetBuffer.writeIntLE16(var28 + WorldMapData.baseY);
                              var29.packetBuffer.putShort(var27 + ClanMemberManager.baseX);
                              var29.packetBuffer.method3535(KeyFocusListener.keyPressed[82]?(KeyFocusListener.keyPressed[81]?2:1):0);
                              var29.packetBuffer.putByte(var20);
                              var29.packetBuffer.putByte(var38);
                              var29.packetBuffer.putShort(Client.mapAngle);
                              var29.packetBuffer.putByte(57);
                              var29.packetBuffer.putByte(0);
                              var29.packetBuffer.putByte(0);
                              var29.packetBuffer.putByte(89);
                              var29.packetBuffer.putShort(GroundObject.localPlayer.x);
                              var29.packetBuffer.putShort(GroundObject.localPlayer.y);
                              var29.packetBuffer.putByte(63);
                              Client.field937.method2044(var29);
                              Client.destinationX = var27;
                              Client.destinationY = var28;
                           }
                        }
                     }
                  } else {
                     if(var9.contentType == 1400) {
                        class175.renderOverview.method5922(MouseInput.mouseLastX, MouseInput.mouseLastY, var35, var10, var11, var9.width, var9.height);
                     }

                     if(!Client.isMenuOpen && var35) {
                        if(var9.contentType == 1400) {
                           class175.renderOverview.method5860(var10, var11, var9.width, var9.height, var16, var17);
                        } else {
                           SoundTaskDataProvider.method743(var9, var16 - var10, var17 - var11);
                        }
                     }

                     if(var9.type == 0) {
                        if(!var9.hasScript && ContextMenuRow.method1877(var9) && var9 != KeyFocusListener.field624) {
                           continue;
                        }

                        method174(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                        if(var9.children != null) {
                           method174(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                        }

                        WidgetNode var30 = (WidgetNode)Client.componentTable.get((long)var9.id);
                        if(var30 != null) {
                           if(var30.owner == 0 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15 && !Client.isMenuOpen && !Client.field1098) {
                              for(ScriptEvent var34 = (ScriptEvent)Client.field1023.getFront(); var34 != null; var34 = (ScriptEvent)Client.field1023.getNext()) {
                                 if(var34.boolean1) {
                                    var34.unlink();
                                    var34.widget.field2854 = false;
                                 }
                              }

                              if(UnitPriceComparator.field308 == 0) {
                                 Client.field940 = null;
                                 Client.field930 = null;
                              }

                              if(!Client.isMenuOpen) {
                                 Client.menuOptionCount = 0;
                                 Client.isMenuOpen = false;
                                 Client.menuOptions[0] = "Cancel";
                                 Client.menuTargets[0] = "";
                                 Client.menuTypes[0] = 1006;
                                 Client.menuBooleanArray[0] = false;
                                 Client.menuOptionCount = 1;
                              }
                           }

                           var20 = var30.id;
                           if(ServerPacket.loadWidget(var20)) {
                              method174(ScriptState.widgets[var20], -1, var12, var13, var14, var15, var10, var11);
                           }
                        }
                     }

                     if(var9.hasScript) {
                        ScriptEvent var39;
                        if(!var9.noClickThrough) {
                           if(var9.field2888 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                              for(var39 = (ScriptEvent)Client.field1023.getFront(); var39 != null; var39 = (ScriptEvent)Client.field1023.getNext()) {
                                 if(var39.boolean1 && var39.widget.scrollListener == var39.objs) {
                                    var39.unlink();
                                 }
                              }
                           }
                        } else if(MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                           for(var39 = (ScriptEvent)Client.field1023.getFront(); var39 != null; var39 = (ScriptEvent)Client.field1023.getNext()) {
                              if(var39.boolean1) {
                                 var39.unlink();
                                 var39.widget.field2854 = false;
                              }
                           }

                           if(UnitPriceComparator.field308 == 0) {
                              Client.field940 = null;
                              Client.field930 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Client.menuOptionCount = 0;
                              Client.isMenuOpen = false;
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuBooleanArray[0] = false;
                              Client.menuOptionCount = 1;
                           }
                        }

                        if(MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                           var35 = true;
                        } else {
                           var35 = false;
                        }

                        boolean var36 = false;
                        if((MouseInput.mouseCurrentButton == 1 || !class29.middleMouseMovesCamera && MouseInput.mouseCurrentButton == 4) && var35) {
                           var36 = true;
                        }

                        boolean var37 = false;
                        if((MouseInput.mouseLastButton == 1 || !class29.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= var12 && MouseInput.mouseLastPressedY >= var13 && MouseInput.mouseLastPressedX < var14 && MouseInput.mouseLastPressedY < var15) {
                           var37 = true;
                        }

                        if(var37) {
                           MilliTimer.method3180(var9, MouseInput.mouseLastPressedX - var10, MouseInput.mouseLastPressedY - var11);
                        }

                        if(var9.contentType == 1400) {
                           class175.renderOverview.method5814(MouseInput.mouseLastX, MouseInput.mouseLastY, var35 & var36, var35 & var37);
                        }

                        if(Client.field940 != null && var9 != Client.field940 && var35) {
                           var22 = WorldComparator.getWidgetConfig(var9);
                           boolean var21 = (var22 >> 20 & 1) != 0;
                           if(var21) {
                              Client.field1001 = var9;
                           }
                        }

                        if(var9 == Client.field930) {
                           Client.field1002 = true;
                           Client.field856 = var10;
                           Client.field1070 = var11;
                        }

                        if(var9.field2834) {
                           ScriptEvent var31;
                           if(var35 && Client.mouseWheelRotation != 0 && var9.scrollListener != null) {
                              var31 = new ScriptEvent();
                              var31.boolean1 = true;
                              var31.widget = var9;
                              var31.field775 = Client.mouseWheelRotation;
                              var31.objs = var9.scrollListener;
                              Client.field1023.addFront(var31);
                           }

                           if(Client.field940 != null || class265.field3515 != null || Client.isMenuOpen) {
                              var37 = false;
                              var36 = false;
                              var35 = false;
                           }

                           if(!var9.field2880 && var37) {
                              var9.field2880 = true;
                              if(var9.field2836 != null) {
                                 var31 = new ScriptEvent();
                                 var31.boolean1 = true;
                                 var31.widget = var9;
                                 var31.field774 = MouseInput.mouseLastPressedX - var10;
                                 var31.field775 = MouseInput.mouseLastPressedY - var11;
                                 var31.objs = var9.field2836;
                                 Client.field1023.addFront(var31);
                              }
                           }

                           if(var9.field2880 && var36 && var9.field2837 != null) {
                              var31 = new ScriptEvent();
                              var31.boolean1 = true;
                              var31.widget = var9;
                              var31.field774 = MouseInput.mouseLastX - var10;
                              var31.field775 = MouseInput.mouseLastY - var11;
                              var31.objs = var9.field2837;
                              Client.field1023.addFront(var31);
                           }

                           if(var9.field2880 && !var36) {
                              var9.field2880 = false;
                              if(var9.field2825 != null) {
                                 var31 = new ScriptEvent();
                                 var31.boolean1 = true;
                                 var31.widget = var9;
                                 var31.field774 = MouseInput.mouseLastX - var10;
                                 var31.field775 = MouseInput.mouseLastY - var11;
                                 var31.objs = var9.field2825;
                                 Client.field1025.addFront(var31);
                              }
                           }

                           if(var36 && var9.field2839 != null) {
                              var31 = new ScriptEvent();
                              var31.boolean1 = true;
                              var31.widget = var9;
                              var31.field774 = MouseInput.mouseLastX - var10;
                              var31.field775 = MouseInput.mouseLastY - var11;
                              var31.objs = var9.field2839;
                              Client.field1023.addFront(var31);
                           }

                           if(!var9.field2854 && var35) {
                              var9.field2854 = true;
                              if(var9.mouseEnterListener != null) {
                                 var31 = new ScriptEvent();
                                 var31.boolean1 = true;
                                 var31.widget = var9;
                                 var31.field774 = MouseInput.mouseLastX - var10;
                                 var31.field775 = MouseInput.mouseLastY - var11;
                                 var31.objs = var9.mouseEnterListener;
                                 Client.field1023.addFront(var31);
                              }
                           }

                           if(var9.field2854 && var35 && var9.mouseHoverListener != null) {
                              var31 = new ScriptEvent();
                              var31.boolean1 = true;
                              var31.widget = var9;
                              var31.field774 = MouseInput.mouseLastX - var10;
                              var31.field775 = MouseInput.mouseLastY - var11;
                              var31.objs = var9.mouseHoverListener;
                              Client.field1023.addFront(var31);
                           }

                           if(var9.field2854 && !var35) {
                              var9.field2854 = false;
                              if(var9.mouseExitListener != null) {
                                 var31 = new ScriptEvent();
                                 var31.boolean1 = true;
                                 var31.widget = var9;
                                 var31.field774 = MouseInput.mouseLastX - var10;
                                 var31.field775 = MouseInput.mouseLastY - var11;
                                 var31.objs = var9.mouseExitListener;
                                 Client.field1025.addFront(var31);
                              }
                           }

                           if(var9.renderListener != null) {
                              var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.objs = var9.renderListener;
                              Client.field1024.addFront(var31);
                           }

                           ScriptEvent var32;
                           if(var9.configListenerArgs != null && Client.field1011 > var9.field2882) {
                              if(var9.configTriggers != null && Client.field1011 - var9.field2882 <= 32) {
                                 label882:
                                 for(var38 = var9.field2882; var38 < Client.field1011; ++var38) {
                                    var22 = Client.field1010[var38 & 31];

                                    for(var23 = 0; var23 < var9.configTriggers.length; ++var23) {
                                       if(var22 == var9.configTriggers[var23]) {
                                          var32 = new ScriptEvent();
                                          var32.widget = var9;
                                          var32.objs = var9.configListenerArgs;
                                          Client.field1023.addFront(var32);
                                          break label882;
                                       }
                                    }
                                 }
                              } else {
                                 var31 = new ScriptEvent();
                                 var31.widget = var9;
                                 var31.objs = var9.configListenerArgs;
                                 Client.field1023.addFront(var31);
                              }

                              var9.field2882 = Client.field1011;
                           }

                           if(var9.tableListenerArgs != null && Client.field1090 > var9.field2821) {
                              if(var9.tableModTriggers != null && Client.field1090 - var9.field2821 <= 32) {
                                 label858:
                                 for(var38 = var9.field2821; var38 < Client.field1090; ++var38) {
                                    var22 = Client.interfaceItemTriggers[var38 & 31];

                                    for(var23 = 0; var23 < var9.tableModTriggers.length; ++var23) {
                                       if(var22 == var9.tableModTriggers[var23]) {
                                          var32 = new ScriptEvent();
                                          var32.widget = var9;
                                          var32.objs = var9.tableListenerArgs;
                                          Client.field1023.addFront(var32);
                                          break label858;
                                       }
                                    }
                                 }
                              } else {
                                 var31 = new ScriptEvent();
                                 var31.widget = var9;
                                 var31.objs = var9.tableListenerArgs;
                                 Client.field1023.addFront(var31);
                              }

                              var9.field2821 = Client.field1090;
                           }

                           if(var9.skillListenerArgs != null && Client.field996 > var9.field2884) {
                              if(var9.skillTriggers != null && Client.field996 - var9.field2884 <= 32) {
                                 label834:
                                 for(var38 = var9.field2884; var38 < Client.field996; ++var38) {
                                    var22 = Client.field1014[var38 & 31];

                                    for(var23 = 0; var23 < var9.skillTriggers.length; ++var23) {
                                       if(var22 == var9.skillTriggers[var23]) {
                                          var32 = new ScriptEvent();
                                          var32.widget = var9;
                                          var32.objs = var9.skillListenerArgs;
                                          Client.field1023.addFront(var32);
                                          break label834;
                                       }
                                    }
                                 }
                              } else {
                                 var31 = new ScriptEvent();
                                 var31.widget = var9;
                                 var31.objs = var9.skillListenerArgs;
                                 Client.field1023.addFront(var31);
                              }

                              var9.field2884 = Client.field996;
                           }

                           if(Client.chatCycle > var9.field2881 && var9.field2856 != null) {
                              var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.objs = var9.field2856;
                              Client.field1023.addFront(var31);
                           }

                           if(Client.field1017 > var9.field2881 && var9.field2858 != null) {
                              var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.objs = var9.field2858;
                              Client.field1023.addFront(var31);
                           }

                           if(Client.field1030 > var9.field2881 && var9.field2859 != null) {
                              var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.objs = var9.field2859;
                              Client.field1023.addFront(var31);
                           }

                           if(Client.field1019 > var9.field2881 && var9.field2759 != null) {
                              var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.objs = var9.field2759;
                              Client.field1023.addFront(var31);
                           }

                           if(Client.field1020 > var9.field2881 && var9.field2833 != null) {
                              var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.objs = var9.field2833;
                              Client.field1023.addFront(var31);
                           }

                           if(Client.field1021 > var9.field2881 && var9.field2883 != null) {
                              var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.objs = var9.field2883;
                              Client.field1023.addFront(var31);
                           }

                           var9.field2881 = Client.cycleCntr;
                           if(var9.field2857 != null) {
                              for(var38 = 0; var38 < Client.field1045; ++var38) {
                                 ScriptEvent var33 = new ScriptEvent();
                                 var33.widget = var9;
                                 var33.field784 = Client.field966[var38];
                                 var33.field779 = Client.field1046[var38];
                                 var33.objs = var9.field2857;
                                 Client.field1023.addFront(var33);
                              }
                           }
                        }
                     }

                     if(!var9.hasScript && Client.field940 == null && class265.field3515 == null && !Client.isMenuOpen) {
                        if((var9.field2869 >= 0 || var9.field2867 != 0) && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                           if(var9.field2869 >= 0) {
                              KeyFocusListener.field624 = var0[var9.field2869];
                           } else {
                              KeyFocusListener.field624 = var9;
                           }
                        }

                        if(var9.type == 8 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                           FriendManager.field1216 = var9;
                        }

                        if(var9.scrollHeight > var9.height) {
                           var19 = var10 + var9.width;
                           var20 = var9.height;
                           var38 = var9.scrollHeight;
                           var22 = MouseInput.mouseLastX;
                           var23 = MouseInput.mouseLastY;
                           if(Client.field927) {
                              Client.field1093 = 32;
                           } else {
                              Client.field1093 = 0;
                           }

                           Client.field927 = false;
                           if(MouseInput.mouseCurrentButton == 1 || !class29.middleMouseMovesCamera && MouseInput.mouseCurrentButton == 4) {
                              if(var22 >= var19 && var22 < var19 + 16 && var23 >= var11 && var23 < var11 + 16) {
                                 var9.scrollY -= 4;
                                 class33.method341(var9);
                              } else if(var22 >= var19 && var22 < var19 + 16 && var23 >= var11 + var20 - 16 && var23 < var20 + var11) {
                                 var9.scrollY += 4;
                                 class33.method341(var9);
                              } else if(var22 >= var19 - Client.field1093 && var22 < var19 + Client.field1093 + 16 && var23 >= var11 + 16 && var23 < var11 + var20 - 16) {
                                 var24 = var20 * (var20 - 32) / var38;
                                 if(var24 < 8) {
                                    var24 = 8;
                                 }

                                 var25 = var23 - var11 - 16 - var24 / 2;
                                 var26 = var20 - 32 - var24;
                                 var9.scrollY = var25 * (var38 - var20) / var26;
                                 class33.method341(var9);
                                 Client.field927 = true;
                              }
                           }

                           if(Client.mouseWheelRotation != 0) {
                              var24 = var9.width;
                              if(var22 >= var19 - var24 && var23 >= var11 && var22 < var19 + 16 && var23 <= var20 + var11) {
                                 var9.scrollY += Client.mouseWheelRotation * 45;
                                 class33.method341(var9);
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
