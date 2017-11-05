import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("hf")
public class class217 {
   @ObfuscatedName("o")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "([Lhj;IIIIIIII)V",
      garbageValue = "-2072787167"
   )
   static final void method4128(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2722 || class25.getWidgetConfig(var9) != 0 || var9 == Client.field960 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !ScriptEvent.method1097(var9))) {
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

            if(var9 == Client.field1158) {
               Client.field1153 = true;
               Client.field1096 = var10;
               Client.field1097 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = MouseInput.field756;
               var17 = MouseInput.field741;
               if(MouseInput.field743 != 0) {
                  var16 = MouseInput.field757;
                  var17 = MouseInput.field758;
               }

               boolean var34 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               if(var9.contentType == 1337) {
                  if(!Client.field931 && !Client.isMenuOpen && var34) {
                     class88.method1724(var16, var17, var12, var13);
                  }
               } else {
                  int var22;
                  int var23;
                  int var24;
                  int var25;
                  int var26;
                  int var36;
                  int var37;
                  if(var9.contentType == 1338) {
                     if((Client.field1148 == 0 || Client.field1148 == 3) && (MouseInput.field743 == 1 || !class7.field244 && MouseInput.field743 == 4)) {
                        class210 var39 = var9.method4076(true);
                        if(var39 != null) {
                           var37 = MouseInput.field757 - var10;
                           var36 = MouseInput.field758 - var11;
                           if(var39.method4001(var37, var36)) {
                              var37 -= var39.field2589 / 2;
                              var36 -= var39.field2592 / 2;
                              var22 = Client.mapAngle & 2047;
                              var23 = Graphics3D.SINE[var22];
                              var24 = Graphics3D.COSINE[var22];
                              var25 = var24 * var37 + var23 * var36 >> 11;
                              var26 = var24 * var36 - var23 * var37 >> 11;
                              int var27 = var25 + class66.localPlayer.x >> 7;
                              int var28 = class66.localPlayer.y - var26 >> 7;
                              Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_MINIMAP_WALK);
                              if(Client.RUNELITE_PACKET) {
                                 Client.secretPacketBuffer1.runeliteWriteInt(18);
                              } else {
                                 Client.secretPacketBuffer1.putByte(18);
                              }

                              Client.secretPacketBuffer1.putByte(KeyFocusListener.field659[82]?(KeyFocusListener.field659[81]?2:1):0);
                              Client.secretPacketBuffer1.putShortLE(var28 + class273.baseY);
                              Client.secretPacketBuffer1.method3342(var27 + class22.baseX);
                              Client.secretPacketBuffer1.putByte(var37);
                              Client.secretPacketBuffer1.putByte(var36);
                              Client.secretPacketBuffer1.putShort(Client.mapAngle);
                              Client.secretPacketBuffer1.putByte(57);
                              Client.secretPacketBuffer1.putByte(0);
                              Client.secretPacketBuffer1.putByte(0);
                              Client.secretPacketBuffer1.putByte(89);
                              Client.secretPacketBuffer1.putShort(class66.localPlayer.x);
                              Client.secretPacketBuffer1.putShort(class66.localPlayer.y);
                              Client.secretPacketBuffer1.putByte(63);
                              Client.destinationX = var27;
                              Client.destinationY = var28;
                           }
                        }
                     }
                  } else {
                     if(var9.contentType == 1400) {
                        Client.renderOverview.method5483(MouseInput.field756, MouseInput.field741, var34, var10, var11, var9.width, var9.height);
                     }

                     if(!Client.isMenuOpen && var34) {
                        if(var9.contentType == 1400) {
                           Client.renderOverview.method5442(var10, var11, var9.width, var9.height, var16, var17);
                        } else {
                           class56.method813(var9, var16 - var10, var17 - var11);
                        }
                     }

                     if(var9.type == 0) {
                        if(!var9.hasScript && ScriptEvent.method1097(var9) && var9 != Sequence.field3621) {
                           continue;
                        }

                        method4128(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                        if(var9.children != null) {
                           method4128(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                        }

                        WidgetNode var29 = (WidgetNode)Client.componentTable.get((long)var9.id);
                        if(var29 != null) {
                           if(var29.owner == 0 && MouseInput.field756 >= var12 && MouseInput.field741 >= var13 && MouseInput.field756 < var14 && MouseInput.field741 < var15 && !Client.isMenuOpen && !Client.field1084) {
                              for(ScriptEvent var30 = (ScriptEvent)Client.field1113.getFront(); var30 != null; var30 = (ScriptEvent)Client.field1113.getNext()) {
                                 if(var30.field846) {
                                    var30.unlink();
                                    var30.widget.field2767 = false;
                                 }
                              }

                              if(class39.field554 == 0) {
                                 Client.field1158 = null;
                                 Client.field960 = null;
                              }

                              if(!Client.isMenuOpen) {
                                 class44.method615();
                              }
                           }

                           DynamicObject.method1904(var29.id, var12, var13, var14, var15, var10, var11);
                        }
                     }

                     if(var9.hasScript) {
                        ScriptEvent var38;
                        if(!var9.field2659) {
                           if(var9.field2698 && MouseInput.field756 >= var12 && MouseInput.field741 >= var13 && MouseInput.field756 < var14 && MouseInput.field741 < var15) {
                              for(var38 = (ScriptEvent)Client.field1113.getFront(); var38 != null; var38 = (ScriptEvent)Client.field1113.getNext()) {
                                 if(var38.field846 && var38.widget.scrollListener == var38.field849) {
                                    var38.unlink();
                                 }
                              }
                           }
                        } else if(MouseInput.field756 >= var12 && MouseInput.field741 >= var13 && MouseInput.field756 < var14 && MouseInput.field741 < var15) {
                           for(var38 = (ScriptEvent)Client.field1113.getFront(); var38 != null; var38 = (ScriptEvent)Client.field1113.getNext()) {
                              if(var38.field846) {
                                 var38.unlink();
                                 var38.widget.field2767 = false;
                              }
                           }

                           if(class39.field554 == 0) {
                              Client.field1158 = null;
                              Client.field960 = null;
                           }

                           if(!Client.isMenuOpen) {
                              class44.method615();
                           }
                        }

                        if(MouseInput.field756 >= var12 && MouseInput.field741 >= var13 && MouseInput.field756 < var14 && MouseInput.field741 < var15) {
                           var34 = true;
                        } else {
                           var34 = false;
                        }

                        boolean var35 = false;
                        if((MouseInput.field750 == 1 || !class7.field244 && MouseInput.field750 == 4) && var34) {
                           var35 = true;
                        }

                        boolean var20 = false;
                        if((MouseInput.field743 == 1 || !class7.field244 && MouseInput.field743 == 4) && MouseInput.field757 >= var12 && MouseInput.field758 >= var13 && MouseInput.field757 < var14 && MouseInput.field758 < var15) {
                           var20 = true;
                        }

                        if(var20) {
                           class85.method1713(var9, MouseInput.field757 - var10, MouseInput.field758 - var11);
                        }

                        if(var9.contentType == 1400) {
                           Client.renderOverview.method5297(MouseInput.field756, MouseInput.field741, var34 & var35, var34 & var20);
                        }

                        if(Client.field1158 != null && var9 != Client.field1158 && var34) {
                           var22 = class25.getWidgetConfig(var9);
                           boolean var21 = (var22 >> 20 & 1) != 0;
                           if(var21) {
                              Client.field1091 = var9;
                           }
                        }

                        if(var9 == Client.field960) {
                           Client.field1183 = true;
                           Client.field1093 = var10;
                           Client.field1094 = var11;
                        }

                        if(var9.field2722) {
                           ScriptEvent var31;
                           if(var34 && Client.field1112 != 0 && var9.scrollListener != null) {
                              var31 = new ScriptEvent();
                              var31.field846 = true;
                              var31.widget = var9;
                              var31.field848 = Client.field1112;
                              var31.field849 = var9.scrollListener;
                              Client.field1113.addFront(var31);
                           }

                           if(Client.field1158 != null || ScriptState.field787 != null || Client.isMenuOpen) {
                              var20 = false;
                              var35 = false;
                              var34 = false;
                           }

                           if(!var9.field2709 && var20) {
                              var9.field2709 = true;
                              if(var9.field2724 != null) {
                                 var31 = new ScriptEvent();
                                 var31.field846 = true;
                                 var31.widget = var9;
                                 var31.field847 = MouseInput.field757 - var10;
                                 var31.field848 = MouseInput.field758 - var11;
                                 var31.field849 = var9.field2724;
                                 Client.field1113.addFront(var31);
                              }
                           }

                           if(var9.field2709 && var35 && var9.field2635 != null) {
                              var31 = new ScriptEvent();
                              var31.field846 = true;
                              var31.widget = var9;
                              var31.field847 = MouseInput.field756 - var10;
                              var31.field848 = MouseInput.field741 - var11;
                              var31.field849 = var9.field2635;
                              Client.field1113.addFront(var31);
                           }

                           if(var9.field2709 && !var35) {
                              var9.field2709 = false;
                              if(var9.field2721 != null) {
                                 var31 = new ScriptEvent();
                                 var31.field846 = true;
                                 var31.widget = var9;
                                 var31.field847 = MouseInput.field756 - var10;
                                 var31.field848 = MouseInput.field741 - var11;
                                 var31.field849 = var9.field2721;
                                 Client.field1115.addFront(var31);
                              }
                           }

                           if(var35 && var9.field2645 != null) {
                              var31 = new ScriptEvent();
                              var31.field846 = true;
                              var31.widget = var9;
                              var31.field847 = MouseInput.field756 - var10;
                              var31.field848 = MouseInput.field741 - var11;
                              var31.field849 = var9.field2645;
                              Client.field1113.addFront(var31);
                           }

                           if(!var9.field2767 && var34) {
                              var9.field2767 = true;
                              if(var9.mouseEnterListener != null) {
                                 var31 = new ScriptEvent();
                                 var31.field846 = true;
                                 var31.widget = var9;
                                 var31.field847 = MouseInput.field756 - var10;
                                 var31.field848 = MouseInput.field741 - var11;
                                 var31.field849 = var9.mouseEnterListener;
                                 Client.field1113.addFront(var31);
                              }
                           }

                           if(var9.field2767 && var34 && var9.mouseHoverListener != null) {
                              var31 = new ScriptEvent();
                              var31.field846 = true;
                              var31.widget = var9;
                              var31.field847 = MouseInput.field756 - var10;
                              var31.field848 = MouseInput.field741 - var11;
                              var31.field849 = var9.mouseHoverListener;
                              Client.field1113.addFront(var31);
                           }

                           if(var9.field2767 && !var34) {
                              var9.field2767 = false;
                              if(var9.mouseExitListener != null) {
                                 var31 = new ScriptEvent();
                                 var31.field846 = true;
                                 var31.widget = var9;
                                 var31.field847 = MouseInput.field756 - var10;
                                 var31.field848 = MouseInput.field741 - var11;
                                 var31.field849 = var9.mouseExitListener;
                                 Client.field1115.addFront(var31);
                              }
                           }

                           if(var9.renderListener != null) {
                              var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.field849 = var9.renderListener;
                              Client.field1171.addFront(var31);
                           }

                           ScriptEvent var32;
                           if(var9.configListenerArgs != null && Client.field999 > var9.field2770) {
                              if(var9.configTriggers != null && Client.field999 - var9.field2770 <= 32) {
                                 label845:
                                 for(var36 = var9.field2770; var36 < Client.field999; ++var36) {
                                    var22 = Client.field1100[var36 & 31];

                                    for(var23 = 0; var23 < var9.configTriggers.length; ++var23) {
                                       if(var22 == var9.configTriggers[var23]) {
                                          var32 = new ScriptEvent();
                                          var32.widget = var9;
                                          var32.field849 = var9.configListenerArgs;
                                          Client.field1113.addFront(var32);
                                          break label845;
                                       }
                                    }
                                 }
                              } else {
                                 var31 = new ScriptEvent();
                                 var31.widget = var9;
                                 var31.field849 = var9.configListenerArgs;
                                 Client.field1113.addFront(var31);
                              }

                              var9.field2770 = Client.field999;
                           }

                           if(var9.tableListenerArgs != null && Client.field1103 > var9.field2648) {
                              if(var9.tableModTriggers != null && Client.field1103 - var9.field2648 <= 32) {
                                 label821:
                                 for(var36 = var9.field2648; var36 < Client.field1103; ++var36) {
                                    var22 = Client.interfaceItemTriggers[var36 & 31];

                                    for(var23 = 0; var23 < var9.tableModTriggers.length; ++var23) {
                                       if(var22 == var9.tableModTriggers[var23]) {
                                          var32 = new ScriptEvent();
                                          var32.widget = var9;
                                          var32.field849 = var9.tableListenerArgs;
                                          Client.field1113.addFront(var32);
                                          break label821;
                                       }
                                    }
                                 }
                              } else {
                                 var31 = new ScriptEvent();
                                 var31.widget = var9;
                                 var31.field849 = var9.tableListenerArgs;
                                 Client.field1113.addFront(var31);
                              }

                              var9.field2648 = Client.field1103;
                           }

                           if(var9.skillListenerArgs != null && Client.field1105 > var9.field2772) {
                              if(var9.skillTriggers != null && Client.field1105 - var9.field2772 <= 32) {
                                 label797:
                                 for(var36 = var9.field2772; var36 < Client.field1105; ++var36) {
                                    var22 = Client.field936[var36 & 31];

                                    for(var23 = 0; var23 < var9.skillTriggers.length; ++var23) {
                                       if(var22 == var9.skillTriggers[var23]) {
                                          var32 = new ScriptEvent();
                                          var32.widget = var9;
                                          var32.field849 = var9.skillListenerArgs;
                                          Client.field1113.addFront(var32);
                                          break label797;
                                       }
                                    }
                                 }
                              } else {
                                 var31 = new ScriptEvent();
                                 var31.widget = var9;
                                 var31.field849 = var9.skillListenerArgs;
                                 Client.field1113.addFront(var31);
                              }

                              var9.field2772 = Client.field1105;
                           }

                           if(Client.chatCycle > var9.field2769 && var9.field2744 != null) {
                              var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.field849 = var9.field2744;
                              Client.field1113.addFront(var31);
                           }

                           if(Client.field1191 > var9.field2769 && var9.field2703 != null) {
                              var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.field849 = var9.field2703;
                              Client.field1113.addFront(var31);
                           }

                           if(Client.field1108 > var9.field2769 && var9.field2747 != null) {
                              var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.field849 = var9.field2747;
                              Client.field1113.addFront(var31);
                           }

                           if(Client.field1109 > var9.field2769 && var9.field2637 != null) {
                              var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.field849 = var9.field2637;
                              Client.field1113.addFront(var31);
                           }

                           if(Client.field1092 > var9.field2769 && var9.field2753 != null) {
                              var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.field849 = var9.field2753;
                              Client.field1113.addFront(var31);
                           }

                           if(Client.field1111 > var9.field2769 && var9.field2748 != null) {
                              var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.field849 = var9.field2748;
                              Client.field1113.addFront(var31);
                           }

                           var9.field2769 = Client.cycleCntr;
                           if(var9.field2771 != null) {
                              for(var36 = 0; var36 < Client.field1135; ++var36) {
                                 ScriptEvent var33 = new ScriptEvent();
                                 var33.widget = var9;
                                 var33.field845 = Client.field1015[var36];
                                 var33.field852 = Client.field1095[var36];
                                 var33.field849 = var9.field2771;
                                 Client.field1113.addFront(var33);
                              }
                           }
                        }
                     }

                     if(!var9.hasScript && Client.field1158 == null && ScriptState.field787 == null && !Client.isMenuOpen) {
                        if((var9.field2733 >= 0 || var9.field2669 != 0) && MouseInput.field756 >= var12 && MouseInput.field741 >= var13 && MouseInput.field756 < var14 && MouseInput.field741 < var15) {
                           if(var9.field2733 >= 0) {
                              Sequence.field3621 = var0[var9.field2733];
                           } else {
                              Sequence.field3621 = var9;
                           }
                        }

                        if(var9.type == 8 && MouseInput.field756 >= var12 && MouseInput.field741 >= var13 && MouseInput.field756 < var14 && MouseInput.field741 < var15) {
                           class162.field2303 = var9;
                        }

                        if(var9.scrollHeight > var9.height) {
                           var19 = var10 + var9.width;
                           var37 = var9.height;
                           var36 = var9.scrollHeight;
                           var22 = MouseInput.field756;
                           var23 = MouseInput.field741;
                           if(Client.field1132) {
                              Client.field996 = 32;
                           } else {
                              Client.field996 = 0;
                           }

                           Client.field1132 = false;
                           if(MouseInput.field750 == 1 || !class7.field244 && MouseInput.field750 == 4) {
                              if(var22 >= var19 && var22 < var19 + 16 && var23 >= var11 && var23 < var11 + 16) {
                                 var9.scrollY -= 4;
                                 class45.method647(var9);
                              } else if(var22 >= var19 && var22 < var19 + 16 && var23 >= var37 + var11 - 16 && var23 < var11 + var37) {
                                 var9.scrollY += 4;
                                 class45.method647(var9);
                              } else if(var22 >= var19 - Client.field996 && var22 < var19 + Client.field996 + 16 && var23 >= var11 + 16 && var23 < var37 + var11 - 16) {
                                 var24 = var37 * (var37 - 32) / var36;
                                 if(var24 < 8) {
                                    var24 = 8;
                                 }

                                 var25 = var23 - var11 - 16 - var24 / 2;
                                 var26 = var37 - 32 - var24;
                                 var9.scrollY = var25 * (var36 - var37) / var26;
                                 class45.method647(var9);
                                 Client.field1132 = true;
                              }
                           }

                           if(Client.field1112 != 0) {
                              var24 = var9.width;
                              if(var22 >= var19 - var24 && var23 >= var11 && var22 < var19 + 16 && var23 <= var11 + var37) {
                                 var9.scrollY += Client.field1112 * 45;
                                 class45.method647(var9);
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
