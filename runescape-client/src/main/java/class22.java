import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class22 extends class28 {
   @ObfuscatedName("cc")
   public static char field351;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgy;Lgy;I)V",
      garbageValue = "1294321850"
   )
   void method164(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class37.field509.field507) {
         throw new IllegalStateException("");
      } else {
         super.field414 = var2.readUnsignedByte();
         super.field410 = var2.readUnsignedByte();
         super.field411 = var2.readUnsignedShort();
         super.field420 = var2.readUnsignedShort();
         super.field422 = var2.readUnsignedShort();
         super.field413 = var2.readUnsignedShort();
         super.field410 = Math.min(super.field410, 4);
         super.field423 = new short[1][64][64];
         super.field416 = new short[super.field410][64][64];
         super.field418 = new byte[super.field410][64][64];
         super.field419 = new byte[super.field410][64][64];
         super.field417 = new class31[super.field410][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class36.field499.field501) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field422 && var5 == super.field413) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method225(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public int hashCode() {
      return super.field422 | super.field413 << 8;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class22)) {
         return false;
      } else {
         class22 var2 = (class22)var1;
         return super.field422 == var2.field422 && super.field413 == var2.field413;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1185923333"
   )
   public static boolean method161(int var0) {
      return var0 == class247.field2990.field3005;
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1838238113"
   )
   static String method170(int var0) {
      return var0 < 0?"":(Client.menuTargets[var0].length() > 0?Client.menuOptions[var0] + " " + Client.menuTargets[var0]:Client.menuOptions[var0]);
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(Lbd;IIII)V",
      garbageValue = "1003969179"
   )
   static final void method173(Player var0, int var1, int var2, int var3) {
      if(TotalQuantityComparator.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.totalLevel == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + class45.method634(var0.combatLevel, TotalQuantityComparator.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.actions[2];
            }

            int var5;
            if(Client.itemSelectionState == 1) {
               TextureProvider.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + IndexFile.getColTags(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.spellSelected) {
               if((class243.field2960 & 8) == 8) {
                  TextureProvider.addMenuEntry(Client.field1097, Client.field941 + " " + "->" + " " + IndexFile.getColTags(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(Client.playerOptions[var5] != null) {
                     short var6 = 0;
                     if(Client.playerOptions[var5].equalsIgnoreCase("Attack")) {
                        if(AttackOption.AttackOption_hidden == Client.playerAttackOption) {
                           continue;
                        }

                        if(Client.playerAttackOption == AttackOption.AttackOption_alwaysRightClick || AttackOption.AttackOption_dependsOnCombatLevels == Client.playerAttackOption && var0.combatLevel > TotalQuantityComparator.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(TotalQuantityComparator.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == TotalQuantityComparator.localPlayer.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriorities[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = Client.playerMenuTypes[var5] + var6;
                     TextureProvider.addMenuEntry(Client.playerOptions[var5], IndexFile.getColTags(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = IndexFile.getColTags(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "([Liw;IIIIIIIB)V",
      garbageValue = "-14"
   )
   static final void method171(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2905 || class85.getWidgetConfig(var9) != 0 || var9 == Client.field1022 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !class236.method4476(var9))) {
            int var10 = var9.relativeX + var6;
            int var11 = var7 + var9.relativeY;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               int var18 = var10 + var9.width;
               int var19 = var11 + var9.height;
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

            if(var9 == Client.field1021) {
               Client.field1029 = true;
               Client.field945 = var10;
               Client.field1031 = var11;
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
                  if(!Client.field1068 && !Client.isMenuOpen && var35) {
                     FloorUnderlayDefinition.method4966(var16, var17, var12, var13);
                  }
               } else {
                  int var21;
                  int var22;
                  int var23;
                  if(var9.contentType == 1338) {
                     if((Client.field1080 == 0 || Client.field1080 == 3) && (MouseInput.mouseLastButton == 1 || !Enum.middleMouseMovesCamera && MouseInput.mouseLastButton == 4)) {
                        class236 var39 = var9.method4563(true);
                        if(var39 != null) {
                           int var37 = MouseInput.mouseLastPressedX - var10;
                           var21 = MouseInput.mouseLastPressedY - var11;
                           if(var39.method4474(var37, var21)) {
                              var37 -= var39.field2777 / 2;
                              var21 -= var39.field2775 / 2;
                              var22 = Client.mapAngle & 2047;
                              var23 = Graphics3D.SINE[var22];
                              int var24 = Graphics3D.COSINE[var22];
                              int var25 = var37 * var24 + var23 * var21 >> 11;
                              int var26 = var21 * var24 - var37 * var23 >> 11;
                              int var27 = var25 + TotalQuantityComparator.localPlayer.x >> 7;
                              int var28 = TotalQuantityComparator.localPlayer.y - var26 >> 7;
                              PacketNode var29 = class31.method285(ClientPacket.field2418, Client.field899.field1470);
                              var29.packetBuffer.putByte(18);
                              var29.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?(KeyFocusListener.keyPressed[81]?2:1):0);
                              var29.packetBuffer.method3616(var28 + Enum.baseY);
                              var29.packetBuffer.putShort(var27 + WorldMapType1.baseX);
                              var29.packetBuffer.putByte(var37);
                              var29.packetBuffer.putByte(var21);
                              var29.packetBuffer.putShort(Client.mapAngle);
                              var29.packetBuffer.putByte(57);
                              var29.packetBuffer.putByte(0);
                              var29.packetBuffer.putByte(0);
                              var29.packetBuffer.putByte(89);
                              var29.packetBuffer.putShort(TotalQuantityComparator.localPlayer.x);
                              var29.packetBuffer.putShort(TotalQuantityComparator.localPlayer.y);
                              var29.packetBuffer.putByte(63);
                              Client.field899.method2082(var29);
                              Client.destinationX = var27;
                              Client.destinationY = var28;
                           }
                        }
                     }
                  } else {
                     if(var9.contentType == 1400) {
                        class248.renderOverview.method6093(MouseInput.mouseLastX, MouseInput.mouseLastY, var35, var10, var11, var9.width, var9.height);
                     }

                     if(!Client.isMenuOpen && var35) {
                        if(var9.contentType == 1400) {
                           class248.renderOverview.method6120(var10, var11, var9.width, var9.height, var16, var17);
                        } else {
                           GrandExchangeEvent.method89(var9, var16 - var10, var17 - var11);
                        }
                     }

                     if(var9.type == 0) {
                        if(!var9.hasScript && class236.method4476(var9) && var9 != class45.field579) {
                           continue;
                        }

                        method171(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                        if(var9.children != null) {
                           method171(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                        }

                        WidgetNode var30 = (WidgetNode)Client.componentTable.get((long)var9.id);
                        if(var30 != null) {
                           if(var30.owner == 0 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15 && !Client.isMenuOpen) {
                              for(ScriptEvent var31 = (ScriptEvent)Client.field1047.getFront(); var31 != null; var31 = (ScriptEvent)Client.field1047.getNext()) {
                                 if(var31.boolean1) {
                                    var31.unlink();
                                    var31.widget.field2950 = false;
                                 }
                              }

                              if(class31.field449 == 0) {
                                 Client.field1021 = null;
                                 Client.field1022 = null;
                              }

                              if(!Client.isMenuOpen) {
                                 class38.method508();
                                 Client.menuOptions[0] = "Cancel";
                                 Client.menuTargets[0] = "";
                                 Client.menuTypes[0] = 1006;
                                 Client.menuBooleanArray[0] = false;
                                 Client.menuOptionCount = 1;
                              }
                           }

                           UnitPriceComparator.method126(var30.id, var12, var13, var14, var15, var10, var11);
                        }
                     }

                     if(var9.hasScript) {
                        ScriptEvent var38;
                        if(!var9.noClickThrough) {
                           if(var9.field2959 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                              for(var38 = (ScriptEvent)Client.field1047.getFront(); var38 != null; var38 = (ScriptEvent)Client.field1047.getNext()) {
                                 if(var38.boolean1 && var38.widget.scrollListener == var38.objs) {
                                    var38.unlink();
                                 }
                              }
                           }
                        } else if(MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                           for(var38 = (ScriptEvent)Client.field1047.getFront(); var38 != null; var38 = (ScriptEvent)Client.field1047.getNext()) {
                              if(var38.boolean1) {
                                 var38.unlink();
                                 var38.widget.field2950 = false;
                              }
                           }

                           if(class31.field449 == 0) {
                              Client.field1021 = null;
                              Client.field1022 = null;
                           }

                           if(!Client.isMenuOpen) {
                              class38.method508();
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
                        if((MouseInput.mouseCurrentButton == 1 || !Enum.middleMouseMovesCamera && MouseInput.mouseCurrentButton == 4) && var35) {
                           var36 = true;
                        }

                        boolean var20 = false;
                        if((MouseInput.mouseLastButton == 1 || !Enum.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= var12 && MouseInput.mouseLastPressedY >= var13 && MouseInput.mouseLastPressedX < var14 && MouseInput.mouseLastPressedY < var15) {
                           var20 = true;
                        }

                        if(var20) {
                           class5.method20(var9, MouseInput.mouseLastPressedX - var10, MouseInput.mouseLastPressedY - var11);
                        }

                        if(var9.contentType == 1400) {
                           class248.renderOverview.method6108(var16, var17, var35 & var36, var35 & var20);
                        }

                        if(Client.field1021 != null && var9 != Client.field1021 && var35 && class191.method3549(class85.getWidgetConfig(var9))) {
                           Client.field1025 = var9;
                        }

                        if(var9 == Client.field1022) {
                           Client.field1026 = true;
                           Client.field1027 = var10;
                           Client.field1028 = var11;
                        }

                        if(var9.field2905) {
                           ScriptEvent var32;
                           if(var35 && Client.mouseWheelRotation != 0 && var9.scrollListener != null) {
                              var32 = new ScriptEvent();
                              var32.boolean1 = true;
                              var32.widget = var9;
                              var32.field790 = Client.mouseWheelRotation;
                              var32.objs = var9.scrollListener;
                              Client.field1047.addFront(var32);
                           }

                           if(Client.field1021 != null || class160.field2147 != null || Client.isMenuOpen) {
                              var20 = false;
                              var36 = false;
                              var35 = false;
                           }

                           if(!var9.field2951 && var20) {
                              var9.field2951 = true;
                              if(var9.field2907 != null) {
                                 var32 = new ScriptEvent();
                                 var32.boolean1 = true;
                                 var32.widget = var9;
                                 var32.field791 = MouseInput.mouseLastPressedX - var10;
                                 var32.field790 = MouseInput.mouseLastPressedY - var11;
                                 var32.objs = var9.field2907;
                                 Client.field1047.addFront(var32);
                              }
                           }

                           if(var9.field2951 && var36 && var9.field2908 != null) {
                              var32 = new ScriptEvent();
                              var32.boolean1 = true;
                              var32.widget = var9;
                              var32.field791 = MouseInput.mouseLastX - var10;
                              var32.field790 = MouseInput.mouseLastY - var11;
                              var32.objs = var9.field2908;
                              Client.field1047.addFront(var32);
                           }

                           if(var9.field2951 && !var36) {
                              var9.field2951 = false;
                              if(var9.field2858 != null) {
                                 var32 = new ScriptEvent();
                                 var32.boolean1 = true;
                                 var32.widget = var9;
                                 var32.field791 = MouseInput.mouseLastX - var10;
                                 var32.field790 = MouseInput.mouseLastY - var11;
                                 var32.objs = var9.field2858;
                                 Client.field977.addFront(var32);
                              }
                           }

                           if(var36 && var9.field2910 != null) {
                              var32 = new ScriptEvent();
                              var32.boolean1 = true;
                              var32.widget = var9;
                              var32.field791 = MouseInput.mouseLastX - var10;
                              var32.field790 = MouseInput.mouseLastY - var11;
                              var32.objs = var9.field2910;
                              Client.field1047.addFront(var32);
                           }

                           if(!var9.field2950 && var35) {
                              var9.field2950 = true;
                              if(var9.mouseEnterListener != null) {
                                 var32 = new ScriptEvent();
                                 var32.boolean1 = true;
                                 var32.widget = var9;
                                 var32.field791 = MouseInput.mouseLastX - var10;
                                 var32.field790 = MouseInput.mouseLastY - var11;
                                 var32.objs = var9.mouseEnterListener;
                                 Client.field1047.addFront(var32);
                              }
                           }

                           if(var9.field2950 && var35 && var9.mouseHoverListener != null) {
                              var32 = new ScriptEvent();
                              var32.boolean1 = true;
                              var32.widget = var9;
                              var32.field791 = MouseInput.mouseLastX - var10;
                              var32.field790 = MouseInput.mouseLastY - var11;
                              var32.objs = var9.mouseHoverListener;
                              Client.field1047.addFront(var32);
                           }

                           if(var9.field2950 && !var35) {
                              var9.field2950 = false;
                              if(var9.mouseExitListener != null) {
                                 var32 = new ScriptEvent();
                                 var32.boolean1 = true;
                                 var32.widget = var9;
                                 var32.field791 = MouseInput.mouseLastX - var10;
                                 var32.field790 = MouseInput.mouseLastY - var11;
                                 var32.objs = var9.mouseExitListener;
                                 Client.field977.addFront(var32);
                              }
                           }

                           if(var9.renderListener != null) {
                              var32 = new ScriptEvent();
                              var32.widget = var9;
                              var32.objs = var9.renderListener;
                              Client.field1018.addFront(var32);
                           }

                           ScriptEvent var34;
                           if(var9.configListenerArgs != null && Client.field1112 > var9.field2835) {
                              if(var9.configTriggers != null && Client.field1112 - var9.field2835 <= 32) {
                                 label741:
                                 for(var21 = var9.field2835; var21 < Client.field1112; ++var21) {
                                    var22 = Client.field1054[var21 & 31];

                                    for(var23 = 0; var23 < var9.configTriggers.length; ++var23) {
                                       if(var22 == var9.configTriggers[var23]) {
                                          var34 = new ScriptEvent();
                                          var34.widget = var9;
                                          var34.objs = var9.configListenerArgs;
                                          Client.field1047.addFront(var34);
                                          break label741;
                                       }
                                    }
                                 }
                              } else {
                                 var32 = new ScriptEvent();
                                 var32.widget = var9;
                                 var32.objs = var9.configListenerArgs;
                                 Client.field1047.addFront(var32);
                              }

                              var9.field2835 = Client.field1112;
                           }

                           if(var9.tableListenerArgs != null && Client.field1037 > var9.field2954) {
                              if(var9.tableModTriggers != null && Client.field1037 - var9.field2954 <= 32) {
                                 label717:
                                 for(var21 = var9.field2954; var21 < Client.field1037; ++var21) {
                                    var22 = Client.interfaceItemTriggers[var21 & 31];

                                    for(var23 = 0; var23 < var9.tableModTriggers.length; ++var23) {
                                       if(var22 == var9.tableModTriggers[var23]) {
                                          var34 = new ScriptEvent();
                                          var34.widget = var9;
                                          var34.objs = var9.tableListenerArgs;
                                          Client.field1047.addFront(var34);
                                          break label717;
                                       }
                                    }
                                 }
                              } else {
                                 var32 = new ScriptEvent();
                                 var32.widget = var9;
                                 var32.objs = var9.tableListenerArgs;
                                 Client.field1047.addFront(var32);
                              }

                              var9.field2954 = Client.field1037;
                           }

                           if(var9.skillListenerArgs != null && Client.field1039 > var9.field2955) {
                              if(var9.skillTriggers != null && Client.field1039 - var9.field2955 <= 32) {
                                 label693:
                                 for(var21 = var9.field2955; var21 < Client.field1039; ++var21) {
                                    var22 = Client.field1038[var21 & 31];

                                    for(var23 = 0; var23 < var9.skillTriggers.length; ++var23) {
                                       if(var22 == var9.skillTriggers[var23]) {
                                          var34 = new ScriptEvent();
                                          var34.widget = var9;
                                          var34.objs = var9.skillListenerArgs;
                                          Client.field1047.addFront(var34);
                                          break label693;
                                       }
                                    }
                                 }
                              } else {
                                 var32 = new ScriptEvent();
                                 var32.widget = var9;
                                 var32.objs = var9.skillListenerArgs;
                                 Client.field1047.addFront(var32);
                              }

                              var9.field2955 = Client.field1039;
                           }

                           if(Client.chatCycle > var9.field2952 && var9.field2828 != null) {
                              var32 = new ScriptEvent();
                              var32.widget = var9;
                              var32.objs = var9.field2828;
                              Client.field1047.addFront(var32);
                           }

                           if(Client.field1041 > var9.field2952 && var9.field2929 != null) {
                              var32 = new ScriptEvent();
                              var32.widget = var9;
                              var32.objs = var9.field2929;
                              Client.field1047.addFront(var32);
                           }

                           if(Client.field1035 > var9.field2952 && var9.field2930 != null) {
                              var32 = new ScriptEvent();
                              var32.widget = var9;
                              var32.objs = var9.field2930;
                              Client.field1047.addFront(var32);
                           }

                           if(Client.field944 > var9.field2952 && var9.field2935 != null) {
                              var32 = new ScriptEvent();
                              var32.widget = var9;
                              var32.objs = var9.field2935;
                              Client.field1047.addFront(var32);
                           }

                           if(Client.field1044 > var9.field2952 && var9.field2936 != null) {
                              var32 = new ScriptEvent();
                              var32.widget = var9;
                              var32.objs = var9.field2936;
                              Client.field1047.addFront(var32);
                           }

                           if(Client.field1045 > var9.field2952 && var9.field2931 != null) {
                              var32 = new ScriptEvent();
                              var32.widget = var9;
                              var32.objs = var9.field2931;
                              Client.field1047.addFront(var32);
                           }

                           var9.field2952 = Client.cycleCntr;
                           if(var9.field2906 != null) {
                              for(var21 = 0; var21 < Client.field980; ++var21) {
                                 ScriptEvent var33 = new ScriptEvent();
                                 var33.widget = var9;
                                 var33.field794 = Client.field1071[var21];
                                 var33.field795 = Client.field1070[var21];
                                 var33.objs = var9.field2906;
                                 Client.field1047.addFront(var33);
                              }
                           }
                        }
                     }

                     if(!var9.hasScript && Client.field1021 == null && class160.field2147 == null && !Client.isMenuOpen) {
                        if((var9.field2940 >= 0 || var9.field2852 != 0) && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                           if(var9.field2940 >= 0) {
                              class45.field579 = var0[var9.field2940];
                           } else {
                              class45.field579 = var9;
                           }
                        }

                        if(var9.type == 8 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                           class35.field497 = var9;
                        }

                        if(var9.scrollHeight > var9.height) {
                           GrandExchangeEvents.method81(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, MouseInput.mouseLastX, MouseInput.mouseLastY);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   static void method174(int var0) {
      for(IntegerNode var1 = (IntegerNode)Client.widgetFlags.first(); var1 != null; var1 = (IntegerNode)Client.widgetFlags.next()) {
         if((var1.hash >> 48 & 65535L) == (long)var0) {
            var1.unlink();
         }
      }

   }
}
