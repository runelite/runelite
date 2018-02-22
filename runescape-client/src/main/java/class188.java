import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
public class class188 {
   @ObfuscatedName("y")
   static byte[][][] field2488;
   @ObfuscatedName("j")
   @Export("osNameLC")
   public static String osNameLC;

   static {
      new HashMap();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "-16"
   )
   @Export("currentTimeMs")
   public static synchronized long currentTimeMs() {
      long var0 = System.currentTimeMillis();
      if(var0 < WorldComparator.currentTimeMsLast) {
         class195.currentTimeMsOffset += WorldComparator.currentTimeMsLast - var0;
      }

      WorldComparator.currentTimeMsLast = var0;
      return class195.currentTimeMsOffset + var0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "1325648126"
   )
   static void method3509(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(Spotanim.method4794(World.worldList[var9], var8, var2, var3, var4, var5) <= 0) {
               World var10 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var10;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method3509(var0, var7 - 1, var2, var3, var4, var5);
         method3509(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "([Lim;IIIIIIIS)V",
      garbageValue = "7261"
   )
   static final void method3507(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2857 || class230.getWidgetConfig(var9) != 0 || var9 == Client.field977 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !class197.method3823(var9))) {
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

            if(var9 == Client.field976) {
               Client.field984 = true;
               Client.field1014 = var10;
               Client.field986 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = MouseInput.mouseLastX;
               var17 = MouseInput.mouseLastY;
               if(MouseInput.mouseLastButton != 0) {
                  var16 = MouseInput.mouseLastPressedX;
                  var17 = MouseInput.mouseLastPressedY;
               }

               boolean var32 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               if(var9.contentType == 1337) {
                  if(!Client.field828 && !Client.isMenuOpen && var32) {
                     class31.method304(var16, var17, var12, var13);
                  }
               } else if(var9.contentType == 1338) {
                  World.method1678(var9, var10, var11);
               } else {
                  if(var9.contentType == 1400) {
                     BoundingBox3D.renderOverview.method5965(MouseInput.mouseLastX, MouseInput.mouseLastY, var32, var10, var11, var9.width, var9.height);
                  }

                  if(!Client.isMenuOpen && var32) {
                     if(var9.contentType == 1400) {
                        BoundingBox3D.renderOverview.method6013(var10, var11, var9.width, var9.height, var16, var17);
                     } else {
                        class63.method1105(var9, var16 - var10, var17 - var11);
                     }
                  }

                  int var20;
                  if(var9.type == 0) {
                     if(!var9.hasScript && class197.method3823(var9) && var9 != Varcs.field1389) {
                        continue;
                     }

                     method3507(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method3507(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var27 = (WidgetNode)Client.componentTable.get((long)var9.id);
                     if(var27 != null) {
                        if(var27.owner == 0 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15 && !Client.isMenuOpen && !Client.field1000) {
                           for(ScriptEvent var28 = (ScriptEvent)Client.field821.getFront(); var28 != null; var28 = (ScriptEvent)Client.field821.getNext()) {
                              if(var28.boolean1) {
                                 var28.unlink();
                                 var28.widget.field2902 = false;
                              }
                           }

                           if(Projectile.field1361 == 0) {
                              Client.field976 = null;
                              Client.field977 = null;
                           }

                           if(!Client.isMenuOpen) {
                              BoundingBox2D.method36();
                           }
                        }

                        var20 = var27.id;
                        if(class2.loadWidget(var20)) {
                           method3507(Widget.widgets[var20], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  int var22;
                  int var23;
                  int var29;
                  if(var9.hasScript) {
                     ScriptEvent var35;
                     if(!var9.noClickThrough) {
                        if(var9.field2911 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                           for(var35 = (ScriptEvent)Client.field821.getFront(); var35 != null; var35 = (ScriptEvent)Client.field821.getNext()) {
                              if(var35.boolean1 && var35.widget.scrollListener == var35.objs) {
                                 var35.unlink();
                              }
                           }
                        }
                     } else if(MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        for(var35 = (ScriptEvent)Client.field821.getFront(); var35 != null; var35 = (ScriptEvent)Client.field821.getNext()) {
                           if(var35.boolean1) {
                              var35.unlink();
                              var35.widget.field2902 = false;
                           }
                        }

                        if(Projectile.field1361 == 0) {
                           Client.field976 = null;
                           Client.field977 = null;
                        }

                        if(!Client.isMenuOpen) {
                           BoundingBox2D.method36();
                        }
                     }

                     if(MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        var32 = true;
                     } else {
                        var32 = false;
                     }

                     boolean var33 = false;
                     if((MouseInput.mouseCurrentButton == 1 || !Size.middleMouseMovesCamera && MouseInput.mouseCurrentButton == 4) && var32) {
                        var33 = true;
                     }

                     boolean var34 = false;
                     if((MouseInput.mouseLastButton == 1 || !Size.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= var12 && MouseInput.mouseLastPressedY >= var13 && MouseInput.mouseLastPressedX < var14 && MouseInput.mouseLastPressedY < var15) {
                        var34 = true;
                     }

                     if(var34) {
                        ScriptVarType.method26(var9, MouseInput.mouseLastPressedX - var10, MouseInput.mouseLastPressedY - var11);
                     }

                     if(var9.contentType == 1400) {
                        BoundingBox3D.renderOverview.method6141(MouseInput.mouseLastX, MouseInput.mouseLastY, var32 & var33, var32 & var34);
                     }

                     if(Client.field976 != null && var9 != Client.field976 && var32 && UnitPriceComparator.method134(class230.getWidgetConfig(var9))) {
                        Client.field980 = var9;
                     }

                     if(var9 == Client.field977) {
                        Client.field978 = true;
                        Client.field982 = var10;
                        Client.field1004 = var11;
                     }

                     if(var9.field2857) {
                        ScriptEvent var21;
                        if(var32 && Client.mouseWheelRotation != 0 && var9.scrollListener != null) {
                           var21 = new ScriptEvent();
                           var21.boolean1 = true;
                           var21.widget = var9;
                           var21.field745 = Client.mouseWheelRotation;
                           var21.objs = var9.scrollListener;
                           Client.field821.addFront(var21);
                        }

                        if(Client.field976 != null || class25.field348 != null || Client.isMenuOpen) {
                           var34 = false;
                           var33 = false;
                           var32 = false;
                        }

                        if(!var9.field2775 && var34) {
                           var9.field2775 = true;
                           if(var9.field2859 != null) {
                              var21 = new ScriptEvent();
                              var21.boolean1 = true;
                              var21.widget = var9;
                              var21.field744 = MouseInput.mouseLastPressedX - var10;
                              var21.field745 = MouseInput.mouseLastPressedY - var11;
                              var21.objs = var9.field2859;
                              Client.field821.addFront(var21);
                           }
                        }

                        if(var9.field2775 && var33 && var9.field2766 != null) {
                           var21 = new ScriptEvent();
                           var21.boolean1 = true;
                           var21.widget = var9;
                           var21.field744 = MouseInput.mouseLastX - var10;
                           var21.field745 = MouseInput.mouseLastY - var11;
                           var21.objs = var9.field2766;
                           Client.field821.addFront(var21);
                        }

                        if(var9.field2775 && !var33) {
                           var9.field2775 = false;
                           if(var9.field2861 != null) {
                              var21 = new ScriptEvent();
                              var21.boolean1 = true;
                              var21.widget = var9;
                              var21.field744 = MouseInput.mouseLastX - var10;
                              var21.field745 = MouseInput.mouseLastY - var11;
                              var21.objs = var9.field2861;
                              Client.field1049.addFront(var21);
                           }
                        }

                        if(var33 && var9.field2841 != null) {
                           var21 = new ScriptEvent();
                           var21.boolean1 = true;
                           var21.widget = var9;
                           var21.field744 = MouseInput.mouseLastX - var10;
                           var21.field745 = MouseInput.mouseLastY - var11;
                           var21.objs = var9.field2841;
                           Client.field821.addFront(var21);
                        }

                        if(!var9.field2902 && var32) {
                           var9.field2902 = true;
                           if(var9.mouseEnterListener != null) {
                              var21 = new ScriptEvent();
                              var21.boolean1 = true;
                              var21.widget = var9;
                              var21.field744 = MouseInput.mouseLastX - var10;
                              var21.field745 = MouseInput.mouseLastY - var11;
                              var21.objs = var9.mouseEnterListener;
                              Client.field821.addFront(var21);
                           }
                        }

                        if(var9.field2902 && var32 && var9.mouseHoverListener != null) {
                           var21 = new ScriptEvent();
                           var21.boolean1 = true;
                           var21.widget = var9;
                           var21.field744 = MouseInput.mouseLastX - var10;
                           var21.field745 = MouseInput.mouseLastY - var11;
                           var21.objs = var9.mouseHoverListener;
                           Client.field821.addFront(var21);
                        }

                        if(var9.field2902 && !var32) {
                           var9.field2902 = false;
                           if(var9.mouseExitListener != null) {
                              var21 = new ScriptEvent();
                              var21.boolean1 = true;
                              var21.widget = var9;
                              var21.field744 = MouseInput.mouseLastX - var10;
                              var21.field745 = MouseInput.mouseLastY - var11;
                              var21.objs = var9.mouseExitListener;
                              Client.field1049.addFront(var21);
                           }
                        }

                        if(var9.renderListener != null) {
                           var21 = new ScriptEvent();
                           var21.widget = var9;
                           var21.objs = var9.renderListener;
                           Client.field992.addFront(var21);
                        }

                        ScriptEvent var24;
                        if(var9.configListenerArgs != null && Client.field991 > var9.field2905) {
                           if(var9.configTriggers != null && Client.field991 - var9.field2905 <= 32) {
                              label847:
                              for(var29 = var9.field2905; var29 < Client.field991; ++var29) {
                                 var22 = Client.field990[var29 & 31];

                                 for(var23 = 0; var23 < var9.configTriggers.length; ++var23) {
                                    if(var22 == var9.configTriggers[var23]) {
                                       var24 = new ScriptEvent();
                                       var24.widget = var9;
                                       var24.objs = var9.configListenerArgs;
                                       Client.field821.addFront(var24);
                                       break label847;
                                    }
                                 }
                              }
                           } else {
                              var21 = new ScriptEvent();
                              var21.widget = var9;
                              var21.objs = var9.configListenerArgs;
                              Client.field821.addFront(var21);
                           }

                           var9.field2905 = Client.field991;
                        }

                        if(var9.tableListenerArgs != null && Client.field1016 > var9.field2780) {
                           if(var9.tableModTriggers != null && Client.field1016 - var9.field2780 <= 32) {
                              label823:
                              for(var29 = var9.field2780; var29 < Client.field1016; ++var29) {
                                 var22 = Client.interfaceItemTriggers[var29 & 31];

                                 for(var23 = 0; var23 < var9.tableModTriggers.length; ++var23) {
                                    if(var22 == var9.tableModTriggers[var23]) {
                                       var24 = new ScriptEvent();
                                       var24.widget = var9;
                                       var24.objs = var9.tableListenerArgs;
                                       Client.field821.addFront(var24);
                                       break label823;
                                    }
                                 }
                              }
                           } else {
                              var21 = new ScriptEvent();
                              var21.widget = var9;
                              var21.objs = var9.tableListenerArgs;
                              Client.field821.addFront(var21);
                           }

                           var9.field2780 = Client.field1016;
                        }

                        if(var9.skillListenerArgs != null && Client.field995 > var9.field2907) {
                           if(var9.skillTriggers != null && Client.field995 - var9.field2907 <= 32) {
                              label799:
                              for(var29 = var9.field2907; var29 < Client.field995; ++var29) {
                                 var22 = Client.field994[var29 & 31];

                                 for(var23 = 0; var23 < var9.skillTriggers.length; ++var23) {
                                    if(var22 == var9.skillTriggers[var23]) {
                                       var24 = new ScriptEvent();
                                       var24.widget = var9;
                                       var24.objs = var9.skillListenerArgs;
                                       Client.field821.addFront(var24);
                                       break label799;
                                    }
                                 }
                              }
                           } else {
                              var21 = new ScriptEvent();
                              var21.widget = var9;
                              var21.objs = var9.skillListenerArgs;
                              Client.field821.addFront(var21);
                           }

                           var9.field2907 = Client.field995;
                        }

                        if(Client.chatCycle > var9.field2904 && var9.field2879 != null) {
                           var21 = new ScriptEvent();
                           var21.widget = var9;
                           var21.objs = var9.field2879;
                           Client.field821.addFront(var21);
                        }

                        if(Client.field997 > var9.field2904 && var9.field2881 != null) {
                           var21 = new ScriptEvent();
                           var21.widget = var9;
                           var21.objs = var9.field2881;
                           Client.field821.addFront(var21);
                        }

                        if(Client.field998 > var9.field2904 && var9.field2882 != null) {
                           var21 = new ScriptEvent();
                           var21.widget = var9;
                           var21.objs = var9.field2882;
                           Client.field821.addFront(var21);
                        }

                        if(Client.field999 > var9.field2904 && var9.field2778 != null) {
                           var21 = new ScriptEvent();
                           var21.widget = var9;
                           var21.objs = var9.field2778;
                           Client.field821.addFront(var21);
                        }

                        if(Client.field884 > var9.field2904 && var9.field2796 != null) {
                           var21 = new ScriptEvent();
                           var21.widget = var9;
                           var21.objs = var9.field2796;
                           Client.field821.addFront(var21);
                        }

                        if(Client.field907 > var9.field2904 && var9.field2830 != null) {
                           var21 = new ScriptEvent();
                           var21.widget = var9;
                           var21.objs = var9.field2830;
                           Client.field821.addFront(var21);
                        }

                        var9.field2904 = Client.cycleCntr;
                        if(var9.field2880 != null) {
                           for(var29 = 0; var29 < Client.field1025; ++var29) {
                              ScriptEvent var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.field754 = Client.field956[var29];
                              var31.field749 = Client.field896[var29];
                              var31.objs = var9.field2880;
                              Client.field821.addFront(var31);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.field976 == null && class25.field348 == null && !Client.isMenuOpen) {
                     if((var9.field2885 >= 0 || var9.field2896 != 0) && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        if(var9.field2885 >= 0) {
                           Varcs.field1389 = var0[var9.field2885];
                        } else {
                           Varcs.field1389 = var9;
                        }
                     }

                     if(var9.type == 8 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        WorldComparator.field258 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        var19 = var10 + var9.width;
                        var20 = var9.height;
                        var29 = var9.scrollHeight;
                        var22 = MouseInput.mouseLastX;
                        var23 = MouseInput.mouseLastY;
                        if(Client.field883) {
                           Client.field855 = 32;
                        } else {
                           Client.field855 = 0;
                        }

                        Client.field883 = false;
                        int var30;
                        if(MouseInput.mouseCurrentButton == 1 || !Size.middleMouseMovesCamera && MouseInput.mouseCurrentButton == 4) {
                           if(var22 >= var19 && var22 < var19 + 16 && var23 >= var11 && var23 < var11 + 16) {
                              var9.scrollY -= 4;
                              ScriptEvent.method1132(var9);
                           } else if(var22 >= var19 && var22 < var19 + 16 && var23 >= var20 + var11 - 16 && var23 < var11 + var20) {
                              var9.scrollY += 4;
                              ScriptEvent.method1132(var9);
                           } else if(var22 >= var19 - Client.field855 && var22 < var19 + Client.field855 + 16 && var23 >= var11 + 16 && var23 < var11 + var20 - 16) {
                              var30 = var20 * (var20 - 32) / var29;
                              if(var30 < 8) {
                                 var30 = 8;
                              }

                              int var25 = var23 - var11 - 16 - var30 / 2;
                              int var26 = var20 - 32 - var30;
                              var9.scrollY = var25 * (var29 - var20) / var26;
                              ScriptEvent.method1132(var9);
                              Client.field883 = true;
                           }
                        }

                        if(Client.mouseWheelRotation != 0) {
                           var30 = var9.width;
                           if(var22 >= var19 - var30 && var23 >= var11 && var22 < var19 + 16 && var23 <= var11 + var20) {
                              var9.scrollY += Client.mouseWheelRotation * 45;
                              ScriptEvent.method1132(var9);
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
