import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
final class class2 implements class0 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -701975873
   )
   static int field12;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-648929694"
   )
   public static boolean method5(char var0) {
      return var0 >= 48 && var0 <= 57;
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "([Lho;IIIIIIII)V",
      garbageValue = "483529029"
   )
   static final void method7(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2697 || class60.getWidgetConfig(var9) != 0 || var9 == Client.field1147 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !class11.method55(var9))) {
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
               int var25 = var11 + var9.height;
               if(var18 < var10) {
                  var16 = var18;
                  var18 = var10;
               }

               if(var25 < var11) {
                  var17 = var25;
                  var25 = var11;
               }

               ++var18;
               ++var25;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var18 < var4?var18:var4;
               var15 = var25 < var5?var25:var5;
            } else {
               var16 = var10 + var9.width;
               var17 = var11 + var9.height;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == Client.field1077) {
               Client.field1085 = true;
               Client.field1086 = var10;
               Client.field931 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = MouseInput.field730;
               var17 = MouseInput.field731;
               if(MouseInput.field729 != 0) {
                  var16 = MouseInput.field737;
                  var17 = MouseInput.field723;
               }

               boolean var29 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               if(var9.contentType == 1337) {
                  if(!Client.field922 && !Client.isMenuOpen && var29) {
                     FaceNormal.method2809(var16, var17, var12, var13);
                  }
               } else if(var9.contentType == 1338) {
                  GameEngine.method934(var9, var10, var11);
               } else {
                  if(var9.contentType == 1400) {
                     Client.renderOverview.method5090(MouseInput.field730, MouseInput.field731, var29, var10, var11, var9.width, var9.height);
                  }

                  if(!Client.isMenuOpen && var29) {
                     if(var9.contentType == 1400) {
                        Client.renderOverview.method5137(var10, var11, var9.width, var9.height, var16, var17);
                     } else {
                        class73.method1069(var9, var16 - var10, var17 - var11);
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && class11.method55(var9) && var9 != class3.field14) {
                        continue;
                     }

                     method7(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method7(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var19 = (WidgetNode)Client.componentTable.get((long)var9.id);
                     if(var19 != null) {
                        if(var19.owner == 0 && MouseInput.field730 >= var12 && MouseInput.field731 >= var13 && MouseInput.field730 < var14 && MouseInput.field731 < var15 && !Client.isMenuOpen && !Client.field1074) {
                           for(ScriptEvent var26 = (ScriptEvent)Client.field1103.getFront(); var26 != null; var26 = (ScriptEvent)Client.field1103.getNext()) {
                              if(var26.field834) {
                                 var26.unlink();
                                 var26.widget.field2742 = false;
                              }
                           }

                           if(class261.field3610 == 0) {
                              Client.field1077 = null;
                              Client.field1147 = null;
                           }

                           if(!Client.isMenuOpen) {
                              class48.method698();
                           }
                        }

                        class29.method241(var19.id, var12, var13, var14, var15, var10, var11);
                     }
                  }

                  if(var9.hasScript) {
                     ScriptEvent var30;
                     if(!var9.field2750) {
                        if(var9.field2751 && MouseInput.field730 >= var12 && MouseInput.field731 >= var13 && MouseInput.field730 < var14 && MouseInput.field731 < var15) {
                           for(var30 = (ScriptEvent)Client.field1103.getFront(); var30 != null; var30 = (ScriptEvent)Client.field1103.getNext()) {
                              if(var30.field834 && var30.widget.scrollListener == var30.field831) {
                                 var30.unlink();
                              }
                           }
                        }
                     } else if(MouseInput.field730 >= var12 && MouseInput.field731 >= var13 && MouseInput.field730 < var14 && MouseInput.field731 < var15) {
                        for(var30 = (ScriptEvent)Client.field1103.getFront(); var30 != null; var30 = (ScriptEvent)Client.field1103.getNext()) {
                           if(var30.field834) {
                              var30.unlink();
                              var30.widget.field2742 = false;
                           }
                        }

                        if(class261.field3610 == 0) {
                           Client.field1077 = null;
                           Client.field1147 = null;
                        }

                        if(!Client.isMenuOpen) {
                           class48.method698();
                        }
                     }

                     if(MouseInput.field730 >= var12 && MouseInput.field731 >= var13 && MouseInput.field730 < var14 && MouseInput.field731 < var15) {
                        var29 = true;
                     } else {
                        var29 = false;
                     }

                     boolean var31 = false;
                     if((MouseInput.field733 == 1 || !GameEngine.field699 && MouseInput.field733 == 4) && var29) {
                        var31 = true;
                     }

                     boolean var20 = false;
                     if((MouseInput.field729 == 1 || !GameEngine.field699 && MouseInput.field729 == 4) && MouseInput.field737 >= var12 && MouseInput.field723 >= var13 && MouseInput.field737 < var14 && MouseInput.field723 < var15) {
                        var20 = true;
                     }

                     if(var20) {
                        class64.method1036(var9, MouseInput.field737 - var10, MouseInput.field723 - var11);
                     }

                     if(var9.contentType == 1400) {
                        Client.renderOverview.method5177(MouseInput.field730, MouseInput.field731, var29 & var31);
                     }

                     if(Client.field1077 != null && var9 != Client.field1077 && var29 && class164.method3009(class60.getWidgetConfig(var9))) {
                        Client.field923 = var9;
                     }

                     if(var9 == Client.field1147) {
                        Client.field1082 = true;
                        Client.field1083 = var10;
                        Client.field1084 = var11;
                     }

                     if(var9.field2697) {
                        ScriptEvent var21;
                        if(var29 && Client.field1102 != 0 && var9.scrollListener != null) {
                           var21 = new ScriptEvent();
                           var21.field834 = true;
                           var21.widget = var9;
                           var21.field833 = Client.field1102;
                           var21.field831 = var9.scrollListener;
                           Client.field1103.addFront(var21);
                        }

                        if(Client.field1077 != null || class14.field281 != null || Client.isMenuOpen) {
                           var20 = false;
                           var31 = false;
                           var29 = false;
                        }

                        if(!var9.field2743 && var20) {
                           var9.field2743 = true;
                           if(var9.field2699 != null) {
                              var21 = new ScriptEvent();
                              var21.field834 = true;
                              var21.widget = var9;
                              var21.field832 = MouseInput.field737 - var10;
                              var21.field833 = MouseInput.field723 - var11;
                              var21.field831 = var9.field2699;
                              Client.field1103.addFront(var21);
                           }
                        }

                        if(var9.field2743 && var31 && var9.field2700 != null) {
                           var21 = new ScriptEvent();
                           var21.field834 = true;
                           var21.widget = var9;
                           var21.field832 = MouseInput.field730 - var10;
                           var21.field833 = MouseInput.field731 - var11;
                           var21.field831 = var9.field2700;
                           Client.field1103.addFront(var21);
                        }

                        if(var9.field2743 && !var31) {
                           var9.field2743 = false;
                           if(var9.field2684 != null) {
                              var21 = new ScriptEvent();
                              var21.field834 = true;
                              var21.widget = var9;
                              var21.field832 = MouseInput.field730 - var10;
                              var21.field833 = MouseInput.field731 - var11;
                              var21.field831 = var9.field2684;
                              Client.field1105.addFront(var21);
                           }
                        }

                        if(var31 && var9.field2702 != null) {
                           var21 = new ScriptEvent();
                           var21.field834 = true;
                           var21.widget = var9;
                           var21.field832 = MouseInput.field730 - var10;
                           var21.field833 = MouseInput.field731 - var11;
                           var21.field831 = var9.field2702;
                           Client.field1103.addFront(var21);
                        }

                        if(!var9.field2742 && var29) {
                           var9.field2742 = true;
                           if(var9.mouseEnterListener != null) {
                              var21 = new ScriptEvent();
                              var21.field834 = true;
                              var21.widget = var9;
                              var21.field832 = MouseInput.field730 - var10;
                              var21.field833 = MouseInput.field731 - var11;
                              var21.field831 = var9.mouseEnterListener;
                              Client.field1103.addFront(var21);
                           }
                        }

                        if(var9.field2742 && var29 && var9.mouseHoverListener != null) {
                           var21 = new ScriptEvent();
                           var21.field834 = true;
                           var21.widget = var9;
                           var21.field832 = MouseInput.field730 - var10;
                           var21.field833 = MouseInput.field731 - var11;
                           var21.field831 = var9.mouseHoverListener;
                           Client.field1103.addFront(var21);
                        }

                        if(var9.field2742 && !var29) {
                           var9.field2742 = false;
                           if(var9.mouseExitListener != null) {
                              var21 = new ScriptEvent();
                              var21.field834 = true;
                              var21.widget = var9;
                              var21.field832 = MouseInput.field730 - var10;
                              var21.field833 = MouseInput.field731 - var11;
                              var21.field831 = var9.mouseExitListener;
                              Client.field1105.addFront(var21);
                           }
                        }

                        if(var9.renderListener != null) {
                           var21 = new ScriptEvent();
                           var21.widget = var9;
                           var21.field831 = var9.renderListener;
                           Client.field1104.addFront(var21);
                        }

                        int var22;
                        int var23;
                        ScriptEvent var24;
                        int var27;
                        if(var9.configListenerArgs != null && Client.field1091 > var9.field2745) {
                           if(var9.configTriggers != null && Client.field1091 - var9.field2745 <= 32) {
                              label692:
                              for(var27 = var9.field2745; var27 < Client.field1091; ++var27) {
                                 var22 = Client.field1090[var27 & 31];

                                 for(var23 = 0; var23 < var9.configTriggers.length; ++var23) {
                                    if(var22 == var9.configTriggers[var23]) {
                                       var24 = new ScriptEvent();
                                       var24.widget = var9;
                                       var24.field831 = var9.configListenerArgs;
                                       Client.field1103.addFront(var24);
                                       break label692;
                                    }
                                 }
                              }
                           } else {
                              var21 = new ScriptEvent();
                              var21.widget = var9;
                              var21.field831 = var9.configListenerArgs;
                              Client.field1103.addFront(var21);
                           }

                           var9.field2745 = Client.field1091;
                        }

                        if(var9.tableListenerArgs != null && Client.field1145 > var9.field2746) {
                           if(var9.tableModTriggers != null && Client.field1145 - var9.field2746 <= 32) {
                              label668:
                              for(var27 = var9.field2746; var27 < Client.field1145; ++var27) {
                                 var22 = Client.interfaceItemTriggers[var27 & 31];

                                 for(var23 = 0; var23 < var9.tableModTriggers.length; ++var23) {
                                    if(var22 == var9.tableModTriggers[var23]) {
                                       var24 = new ScriptEvent();
                                       var24.widget = var9;
                                       var24.field831 = var9.tableListenerArgs;
                                       Client.field1103.addFront(var24);
                                       break label668;
                                    }
                                 }
                              }
                           } else {
                              var21 = new ScriptEvent();
                              var21.widget = var9;
                              var21.field831 = var9.tableListenerArgs;
                              Client.field1103.addFront(var21);
                           }

                           var9.field2746 = Client.field1145;
                        }

                        if(var9.skillListenerArgs != null && Client.field943 > var9.field2642) {
                           if(var9.skillTriggers != null && Client.field943 - var9.field2642 <= 32) {
                              label644:
                              for(var27 = var9.field2642; var27 < Client.field943; ++var27) {
                                 var22 = Client.field1094[var27 & 31];

                                 for(var23 = 0; var23 < var9.skillTriggers.length; ++var23) {
                                    if(var22 == var9.skillTriggers[var23]) {
                                       var24 = new ScriptEvent();
                                       var24.widget = var9;
                                       var24.field831 = var9.skillListenerArgs;
                                       Client.field1103.addFront(var24);
                                       break label644;
                                    }
                                 }
                              }
                           } else {
                              var21 = new ScriptEvent();
                              var21.widget = var9;
                              var21.field831 = var9.skillListenerArgs;
                              Client.field1103.addFront(var21);
                           }

                           var9.field2642 = Client.field943;
                        }

                        if(Client.chatCycle > var9.field2708 && var9.field2719 != null) {
                           var21 = new ScriptEvent();
                           var21.widget = var9;
                           var21.field831 = var9.field2719;
                           Client.field1103.addFront(var21);
                        }

                        if(Client.field1142 > var9.field2708 && var9.field2721 != null) {
                           var21 = new ScriptEvent();
                           var21.widget = var9;
                           var21.field831 = var9.field2721;
                           Client.field1103.addFront(var21);
                        }

                        if(Client.field937 > var9.field2708 && var9.field2722 != null) {
                           var21 = new ScriptEvent();
                           var21.widget = var9;
                           var21.field831 = var9.field2722;
                           Client.field1103.addFront(var21);
                        }

                        if(Client.field1099 > var9.field2708 && var9.field2727 != null) {
                           var21 = new ScriptEvent();
                           var21.widget = var9;
                           var21.field831 = var9.field2727;
                           Client.field1103.addFront(var21);
                        }

                        if(Client.field1100 > var9.field2708 && var9.field2613 != null) {
                           var21 = new ScriptEvent();
                           var21.widget = var9;
                           var21.field831 = var9.field2613;
                           Client.field1103.addFront(var21);
                        }

                        if(Client.field1098 > var9.field2708 && var9.field2723 != null) {
                           var21 = new ScriptEvent();
                           var21.widget = var9;
                           var21.field831 = var9.field2723;
                           Client.field1103.addFront(var21);
                        }

                        var9.field2708 = Client.cycleCntr;
                        if(var9.field2639 != null) {
                           for(var27 = 0; var27 < Client.field1125; ++var27) {
                              ScriptEvent var28 = new ScriptEvent();
                              var28.widget = var9;
                              var28.field836 = Client.field1120[var27];
                              var28.field840 = Client.field1126[var27];
                              var28.field831 = var9.field2639;
                              Client.field1103.addFront(var28);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.field1077 == null && class14.field281 == null && !Client.isMenuOpen) {
                     if((var9.field2740 >= 0 || var9.field2632 != 0) && MouseInput.field730 >= var12 && MouseInput.field731 >= var13 && MouseInput.field730 < var14 && MouseInput.field731 < var15) {
                        if(var9.field2740 >= 0) {
                           class3.field14 = var0[var9.field2740];
                        } else {
                           class3.field14 = var9;
                        }
                     }

                     if(var9.type == 8 && MouseInput.field730 >= var12 && MouseInput.field731 >= var13 && MouseInput.field730 < var14 && MouseInput.field731 < var15) {
                        class48.field616 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        class27.method213(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, MouseInput.field730, MouseInput.field731);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "95111141"
   )
   static void method6() {
      if(Client.spellSelected) {
         Widget var0 = CollisionData.method2946(class60.field747, Client.field1055);
         if(var0 != null && var0.field2695 != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.field831 = var0.field2695;
            Ignore.method1054(var1);
         }

         Client.spellSelected = false;
         class21.method156(var0);
      }
   }
}
