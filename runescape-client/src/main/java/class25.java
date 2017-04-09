import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public final class class25 extends Node {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -243793197
   )
   int field587;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1792080171
   )
   int field588;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -966493297
   )
   int field589 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 97350549
   )
   int field591;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1188820349
   )
   int field592;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 462907571
   )
   int field593;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 600507223
   )
   int field594;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 647198071
   )
   int field596;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1141738291
   )
   int field597;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2001121109
   )
   int field598 = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1249647151
   )
   int field599;
   @ObfuscatedName("dc")
   @Export("mapRegions")
   static int[] mapRegions;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -867631951
   )
   int field601;
   @ObfuscatedName("am")
   static int[] field603;

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIII)V",
      garbageValue = "894939346"
   )
   static final void method558(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2299 || FloorUnderlayDefinition.method3533(var9) != 0 || var9 == Client.field477 || var9.contentType == 1338) && var1 == var9.parentId && (!var9.hasScript || !ISAACCipher.method3124(var9))) {
            int var10 = var9.relativeX + var6;
            int var11 = var7 + var9.relativeY;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               var18 = var10 + var9.width;
               var19 = var9.height + var11;
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

            if(Client.field476 == var9) {
               Client.field484 = true;
               Client.field454 = var10;
               Client.field491 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = class115.field1817;
               var17 = class115.field1818;
               if(class115.field1823 != 0) {
                  var16 = class115.field1825;
                  var17 = class115.field1813;
               }

               if(var9.contentType == 1337) {
                  if(!Client.field578 && !Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     class142.method2751(var16, var17, var12, var13);
                  }
               } else if(var9.contentType == 1338) {
                  class2.method9(var9, var10, var11);
               } else {
                  int var20;
                  int var21;
                  int var22;
                  int var23;
                  int var24;
                  boolean var25;
                  boolean var26;
                  if(!Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     var18 = var16 - var10;
                     var19 = var17 - var11;
                     if(var9.field2222 == 1) {
                        class119.addMenuEntry(var9.tooltip, "", 24, 0, 0, var9.id);
                     }

                     String var27;
                     if(var9.field2222 == 2 && !Client.field458) {
                        var21 = FloorUnderlayDefinition.method3533(var9);
                        var23 = var21 >> 11 & 63;
                        if(var23 == 0) {
                           var27 = null;
                        } else if(var9.field2328 != null && var9.field2328.trim().length() != 0) {
                           var27 = var9.field2328;
                        } else {
                           var27 = null;
                        }

                        if(var27 != null) {
                           class119.addMenuEntry(var27, XItemContainer.method153('\uff00') + var9.field2335, 25, 0, -1, var9.id);
                        }
                     }

                     if(var9.field2222 == 3) {
                        class119.addMenuEntry("Close", "", 26, 0, 0, var9.id);
                     }

                     if(var9.field2222 == 4) {
                        class119.addMenuEntry(var9.tooltip, "", 28, 0, 0, var9.id);
                     }

                     if(var9.field2222 == 5) {
                        class119.addMenuEntry(var9.tooltip, "", 29, 0, 0, var9.id);
                     }

                     if(var9.field2222 == 6 && Client.field467 == null) {
                        class119.addMenuEntry(var9.tooltip, "", 30, 0, -1, var9.id);
                     }

                     if(var9.type == 2) {
                        var20 = 0;

                        for(var23 = 0; var23 < var9.height; ++var23) {
                           for(var21 = 0; var21 < var9.width; ++var21) {
                              var22 = (var9.field2285 + 32) * var21;
                              var24 = (var9.field2286 + 32) * var23;
                              if(var20 < 20) {
                                 var22 += var9.field2340[var20];
                                 var24 += var9.field2288[var20];
                              }

                              if(var18 >= var22 && var19 >= var24 && var18 < var22 + 32 && var19 < var24 + 32) {
                                 Client.field418 = var20;
                                 class161.field2160 = var9;
                                 if(var9.itemIds[var20] > 0) {
                                    label1093: {
                                       ItemComposition var28 = class196.getItemDefinition(var9.itemIds[var20] - 1);
                                       int var29;
                                       boolean var30;
                                       if(Client.field455 == 1) {
                                          var29 = FloorUnderlayDefinition.method3533(var9);
                                          var30 = (var29 >> 30 & 1) != 0;
                                          if(var30) {
                                             if(var9.id != class177.field2689 || var20 != class47.field957) {
                                                class119.addMenuEntry("Use", Client.field457 + " -> " + XItemContainer.method153(16748608) + var28.name, 31, var28.id, var20, var9.id);
                                             }
                                             break label1093;
                                          }
                                       }

                                       if(Client.field458) {
                                          var29 = FloorUnderlayDefinition.method3533(var9);
                                          var30 = (var29 >> 30 & 1) != 0;
                                          if(var30) {
                                             if((ItemComposition.field3004 & 16) == 16) {
                                                class119.addMenuEntry(Client.field326, Client.field527 + " -> " + XItemContainer.method153(16748608) + var28.name, 32, var28.id, var20, var9.id);
                                             }
                                             break label1093;
                                          }
                                       }

                                       String[] var31 = var28.inventoryActions;
                                       if(Client.field474) {
                                          var31 = class31.method659(var31);
                                       }

                                       var29 = var28.method3687();
                                       int var32 = FloorUnderlayDefinition.method3533(var9);
                                       boolean var33 = (var32 >> 30 & 1) != 0;
                                       int var34;
                                       boolean var35;
                                       if(var33) {
                                          for(var34 = 4; var34 >= 3; --var34) {
                                             var35 = var29 == var34;
                                             if(var31 != null && var31[var34] != null) {
                                                byte var36;
                                                if(var34 == 3) {
                                                   var36 = 36;
                                                } else {
                                                   var36 = 37;
                                                }

                                                class168.method3249(var31[var34], XItemContainer.method153(16748608) + var28.name, var36, var28.id, var20, var9.id, var35);
                                             } else if(var34 == 4) {
                                                class168.method3249("Drop", XItemContainer.method153(16748608) + var28.name, 37, var28.id, var20, var9.id, var35);
                                             }
                                          }
                                       }

                                       var34 = FloorUnderlayDefinition.method3533(var9);
                                       var35 = (var34 >> 31 & 1) != 0;
                                       if(var35) {
                                          class119.addMenuEntry("Use", XItemContainer.method153(16748608) + var28.name, 38, var28.id, var20, var9.id);
                                       }

                                       int var50 = FloorUnderlayDefinition.method3533(var9);
                                       boolean var37 = (var50 >> 30 & 1) != 0;
                                       int var38;
                                       if(var37 && var31 != null) {
                                          for(var38 = 2; var38 >= 0; --var38) {
                                             boolean var39 = var29 == var38;
                                             if(var31[var38] != null) {
                                                byte var40 = 0;
                                                if(var38 == 0) {
                                                   var40 = 33;
                                                }

                                                if(var38 == 1) {
                                                   var40 = 34;
                                                }

                                                if(var38 == 2) {
                                                   var40 = 35;
                                                }

                                                class168.method3249(var31[var38], XItemContainer.method153(16748608) + var28.name, var40, var28.id, var20, var9.id, var39);
                                             }
                                          }
                                       }

                                       var31 = var9.field2336;
                                       if(Client.field474) {
                                          var31 = class31.method659(var31);
                                       }

                                       if(var31 != null) {
                                          for(var38 = 4; var38 >= 0; --var38) {
                                             if(var31[var38] != null) {
                                                byte var51 = 0;
                                                if(var38 == 0) {
                                                   var51 = 39;
                                                }

                                                if(var38 == 1) {
                                                   var51 = 40;
                                                }

                                                if(var38 == 2) {
                                                   var51 = 41;
                                                }

                                                if(var38 == 3) {
                                                   var51 = 42;
                                                }

                                                if(var38 == 4) {
                                                   var51 = 43;
                                                }

                                                class119.addMenuEntry(var31[var38], XItemContainer.method153(16748608) + var28.name, var51, var28.id, var20, var9.id);
                                             }
                                          }
                                       }

                                       class119.addMenuEntry("Examine", XItemContainer.method153(16748608) + var28.name, 1005, var28.id, var20, var9.id);
                                    }
                                 }
                              }

                              ++var20;
                           }
                        }
                     }

                     if(var9.hasScript) {
                        if(Client.field458) {
                           var23 = FloorUnderlayDefinition.method3533(var9);
                           var25 = (var23 >> 21 & 1) != 0;
                           if(var25 && (ItemComposition.field3004 & 32) == 32) {
                              class119.addMenuEntry(Client.field326, Client.field527 + " -> " + var9.name, 58, 0, var9.index, var9.id);
                           }
                        } else {
                           String var41;
                           for(var20 = 9; var20 >= 5; --var20) {
                              if(!class152.method2849(FloorUnderlayDefinition.method3533(var9), var20) && var9.field2319 == null) {
                                 var41 = null;
                              } else if(var9.actions != null && var9.actions.length > var20 && var9.actions[var20] != null && var9.actions[var20].trim().length() != 0) {
                                 var41 = var9.actions[var20];
                              } else {
                                 var41 = null;
                              }

                              if(var41 != null) {
                                 class119.addMenuEntry(var41, var9.name, 1007, var20 + 1, var9.index, var9.id);
                              }
                           }

                           var21 = FloorUnderlayDefinition.method3533(var9);
                           var23 = var21 >> 11 & 63;
                           if(var23 == 0) {
                              var27 = null;
                           } else if(var9.field2328 != null && var9.field2328.trim().length() != 0) {
                              var27 = var9.field2328;
                           } else {
                              var27 = null;
                           }

                           if(var27 != null) {
                              class119.addMenuEntry(var27, var9.name, 25, 0, var9.index, var9.id);
                           }

                           for(var21 = 4; var21 >= 0; --var21) {
                              if(!class152.method2849(FloorUnderlayDefinition.method3533(var9), var21) && var9.field2319 == null) {
                                 var41 = null;
                              } else if(var9.actions != null && var9.actions.length > var21 && var9.actions[var21] != null && var9.actions[var21].trim().length() != 0) {
                                 var41 = var9.actions[var21];
                              } else {
                                 var41 = null;
                              }

                              if(var41 != null) {
                                 class119.addMenuEntry(var41, var9.name, 57, var21 + 1, var9.index, var9.id);
                              }
                           }

                           var22 = FloorUnderlayDefinition.method3533(var9);
                           var26 = (var22 & 1) != 0;
                           if(var26) {
                              class119.addMenuEntry("Continue", "", 30, 0, var9.index, var9.id);
                           }
                        }
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && ISAACCipher.method3124(var9) && class152.field2085 != var9) {
                        continue;
                     }

                     method558(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method558(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var42 = (WidgetNode)Client.componentTable.method2417((long)var9.id);
                     if(var42 != null) {
                        if(var42.field187 == 0 && class115.field1817 >= var12 && class115.field1818 >= var13 && class115.field1817 < var14 && class115.field1818 < var15 && !Client.isMenuOpen && !Client.field473) {
                           for(class18 var46 = (class18)Client.field502.method2464(); var46 != null; var46 = (class18)Client.field502.method2472()) {
                              if(var46.field197) {
                                 var46.unlink();
                                 var46.field207.field2252 = false;
                              }
                           }

                           if(class44.field912 == 0) {
                              Client.field476 = null;
                              Client.field477 = null;
                           }

                           if(!Client.isMenuOpen) {
                              class37.method762();
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuOptionCount = 1;
                           }
                        }

                        var19 = var42.id;
                        if(Ignore.method178(var19)) {
                           method558(Widget.widgets[var19], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.hasScript) {
                     class18 var43;
                     if(!var9.field2210) {
                        if(var9.field2353 && class115.field1817 >= var12 && class115.field1818 >= var13 && class115.field1817 < var14 && class115.field1818 < var15) {
                           for(var43 = (class18)Client.field502.method2464(); var43 != null; var43 = (class18)Client.field502.method2472()) {
                              if(var43.field197 && var43.field207.field2262 == var43.field199) {
                                 var43.unlink();
                              }
                           }
                        }
                     } else if(class115.field1817 >= var12 && class115.field1818 >= var13 && class115.field1817 < var14 && class115.field1818 < var15) {
                        for(var43 = (class18)Client.field502.method2464(); var43 != null; var43 = (class18)Client.field502.method2472()) {
                           if(var43.field197) {
                              var43.unlink();
                              var43.field207.field2252 = false;
                           }
                        }

                        if(class44.field912 == 0) {
                           Client.field476 = null;
                           Client.field477 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.menuOptionCount = 1;
                        }
                     }

                     if(class115.field1817 >= var12 && class115.field1818 >= var13 && class115.field1817 < var14 && class115.field1818 < var15) {
                        var26 = true;
                     } else {
                        var26 = false;
                     }

                     boolean var48 = false;
                     if((class115.field1811 == 1 || !class177.field2687 && class115.field1811 == 4) && var26) {
                        var48 = true;
                     }

                     var25 = false;
                     if((class115.field1823 == 1 || !class177.field2687 && class115.field1823 == 4) && class115.field1825 >= var12 && class115.field1813 >= var13 && class115.field1825 < var14 && class115.field1813 < var15) {
                        var25 = true;
                     }

                     if(var25) {
                        class20.method187(var9, class115.field1825 - var10, class115.field1813 - var11);
                     }

                     if(Client.field476 != null && var9 != Client.field476 && var26 && class168.method3247(FloorUnderlayDefinition.method3533(var9))) {
                        Client.field480 = var9;
                     }

                     if(var9 == Client.field477) {
                        Client.field481 = true;
                        Client.field324 = var10;
                        Client.field483 = var11;
                     }

                     if(var9.field2299) {
                        class18 var44;
                        if(var26 && Client.field538 != 0 && var9.field2262 != null) {
                           var44 = new class18();
                           var44.field197 = true;
                           var44.field207 = var9;
                           var44.field201 = Client.field538;
                           var44.field199 = var9.field2262;
                           Client.field502.method2459(var44);
                        }

                        if(Client.field476 != null || class164.field2177 != null || Client.isMenuOpen) {
                           var25 = false;
                           var48 = false;
                           var26 = false;
                        }

                        if(!var9.field2345 && var25) {
                           var9.field2345 = true;
                           if(var9.field2337 != null) {
                              var44 = new class18();
                              var44.field197 = true;
                              var44.field207 = var9;
                              var44.field198 = class115.field1825 - var10;
                              var44.field201 = class115.field1813 - var11;
                              var44.field199 = var9.field2337;
                              Client.field502.method2459(var44);
                           }
                        }

                        if(var9.field2345 && var48 && var9.field2287 != null) {
                           var44 = new class18();
                           var44.field197 = true;
                           var44.field207 = var9;
                           var44.field198 = class115.field1817 - var10;
                           var44.field201 = class115.field1818 - var11;
                           var44.field199 = var9.field2287;
                           Client.field502.method2459(var44);
                        }

                        if(var9.field2345 && !var48) {
                           var9.field2345 = false;
                           if(var9.field2303 != null) {
                              var44 = new class18();
                              var44.field197 = true;
                              var44.field207 = var9;
                              var44.field198 = class115.field1817 - var10;
                              var44.field201 = class115.field1818 - var11;
                              var44.field199 = var9.field2303;
                              Client.field504.method2459(var44);
                           }
                        }

                        if(var48 && var9.field2304 != null) {
                           var44 = new class18();
                           var44.field197 = true;
                           var44.field207 = var9;
                           var44.field198 = class115.field1817 - var10;
                           var44.field201 = class115.field1818 - var11;
                           var44.field199 = var9.field2304;
                           Client.field502.method2459(var44);
                        }

                        if(!var9.field2252 && var26) {
                           var9.field2252 = true;
                           if(var9.field2300 != null) {
                              var44 = new class18();
                              var44.field197 = true;
                              var44.field207 = var9;
                              var44.field198 = class115.field1817 - var10;
                              var44.field201 = class115.field1818 - var11;
                              var44.field199 = var9.field2300;
                              Client.field502.method2459(var44);
                           }
                        }

                        if(var9.field2252 && var26 && var9.field2306 != null) {
                           var44 = new class18();
                           var44.field197 = true;
                           var44.field207 = var9;
                           var44.field198 = class115.field1817 - var10;
                           var44.field201 = class115.field1818 - var11;
                           var44.field199 = var9.field2306;
                           Client.field502.method2459(var44);
                        }

                        if(var9.field2252 && !var26) {
                           var9.field2252 = false;
                           if(var9.field2248 != null) {
                              var44 = new class18();
                              var44.field197 = true;
                              var44.field207 = var9;
                              var44.field198 = class115.field1817 - var10;
                              var44.field201 = class115.field1818 - var11;
                              var44.field199 = var9.field2248;
                              Client.field504.method2459(var44);
                           }
                        }

                        if(var9.field2318 != null) {
                           var44 = new class18();
                           var44.field207 = var9;
                           var44.field199 = var9.field2318;
                           Client.field307.method2459(var44);
                        }

                        class18 var45;
                        if(var9.field2312 != null && Client.field490 > var9.field2347) {
                           if(var9.field2313 != null && Client.field490 - var9.field2347 <= 32) {
                              label756:
                              for(var23 = var9.field2347; var23 < Client.field490; ++var23) {
                                 var21 = Client.field489[var23 & 31];

                                 for(var22 = 0; var22 < var9.field2313.length; ++var22) {
                                    if(var21 == var9.field2313[var22]) {
                                       var45 = new class18();
                                       var45.field207 = var9;
                                       var45.field199 = var9.field2312;
                                       Client.field502.method2459(var45);
                                       break label756;
                                    }
                                 }
                              }
                           } else {
                              var44 = new class18();
                              var44.field207 = var9;
                              var44.field199 = var9.field2312;
                              Client.field502.method2459(var44);
                           }

                           var9.field2347 = Client.field490;
                        }

                        if(var9.field2314 != null && Client.field492 > var9.field2348) {
                           if(var9.field2315 != null && Client.field492 - var9.field2348 <= 32) {
                              label732:
                              for(var23 = var9.field2348; var23 < Client.field492; ++var23) {
                                 var21 = Client.interfaceItemTriggers[var23 & 31];

                                 for(var22 = 0; var22 < var9.field2315.length; ++var22) {
                                    if(var21 == var9.field2315[var22]) {
                                       var45 = new class18();
                                       var45.field207 = var9;
                                       var45.field199 = var9.field2314;
                                       Client.field502.method2459(var45);
                                       break label732;
                                    }
                                 }
                              }
                           } else {
                              var44 = new class18();
                              var44.field207 = var9;
                              var44.field199 = var9.field2314;
                              Client.field502.method2459(var44);
                           }

                           var9.field2348 = Client.field492;
                        }

                        if(var9.field2316 != null && Client.field503 > var9.field2349) {
                           if(var9.field2282 != null && Client.field503 - var9.field2349 <= 32) {
                              label708:
                              for(var23 = var9.field2349; var23 < Client.field503; ++var23) {
                                 var21 = Client.field493[var23 & 31];

                                 for(var22 = 0; var22 < var9.field2282.length; ++var22) {
                                    if(var21 == var9.field2282[var22]) {
                                       var45 = new class18();
                                       var45.field207 = var9;
                                       var45.field199 = var9.field2316;
                                       Client.field502.method2459(var45);
                                       break label708;
                                    }
                                 }
                              }
                           } else {
                              var44 = new class18();
                              var44.field207 = var9;
                              var44.field199 = var9.field2316;
                              Client.field502.method2459(var44);
                           }

                           var9.field2349 = Client.field503;
                        }

                        if(Client.field495 > var9.field2346 && var9.field2321 != null) {
                           var44 = new class18();
                           var44.field207 = var9;
                           var44.field199 = var9.field2321;
                           Client.field502.method2459(var44);
                        }

                        if(Client.field496 > var9.field2346 && var9.field2290 != null) {
                           var44 = new class18();
                           var44.field207 = var9;
                           var44.field199 = var9.field2290;
                           Client.field502.method2459(var44);
                        }

                        if(Client.field497 > var9.field2346 && var9.field2324 != null) {
                           var44 = new class18();
                           var44.field207 = var9;
                           var44.field199 = var9.field2324;
                           Client.field502.method2459(var44);
                        }

                        if(Client.field498 > var9.field2346 && var9.field2329 != null) {
                           var44 = new class18();
                           var44.field207 = var9;
                           var44.field199 = var9.field2329;
                           Client.field502.method2459(var44);
                        }

                        if(Client.field499 > var9.field2346 && var9.field2330 != null) {
                           var44 = new class18();
                           var44.field207 = var9;
                           var44.field199 = var9.field2330;
                           Client.field502.method2459(var44);
                        }

                        if(Client.field500 > var9.field2346 && var9.field2284 != null) {
                           var44 = new class18();
                           var44.field207 = var9;
                           var44.field199 = var9.field2284;
                           Client.field502.method2459(var44);
                        }

                        var9.field2346 = Client.field561;
                        if(var9.field2322 != null) {
                           for(var23 = 0; var23 < Client.field345; ++var23) {
                              class18 var49 = new class18();
                              var49.field207 = var9;
                              var49.field204 = Client.field528[var23];
                              var49.field205 = Client.field419[var23];
                              var49.field199 = var9.field2322;
                              Client.field502.method2459(var49);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.field476 == null && class164.field2177 == null && !Client.isMenuOpen) {
                     if((var9.field2334 >= 0 || var9.field2280 != 0) && class115.field1817 >= var12 && class115.field1818 >= var13 && class115.field1817 < var14 && class115.field1818 < var15) {
                        if(var9.field2334 >= 0) {
                           class152.field2085 = var0[var9.field2334];
                        } else {
                           class152.field2085 = var9;
                        }
                     }

                     if(var9.type == 8 && class115.field1817 >= var12 && class115.field1818 >= var13 && class115.field1817 < var14 && class115.field1818 < var15) {
                        WidgetNode.field190 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        var18 = var10 + var9.width;
                        var19 = var9.height;
                        var20 = var9.scrollHeight;
                        var23 = class115.field1817;
                        var21 = class115.field1818;
                        if(Client.field321) {
                           Client.field365 = 32;
                        } else {
                           Client.field365 = 0;
                        }

                        Client.field321 = false;
                        if(class115.field1811 == 1 || !class177.field2687 && class115.field1811 == 4) {
                           if(var23 >= var18 && var23 < var18 + 16 && var21 >= var11 && var21 < var11 + 16) {
                              var9.scrollY -= 4;
                              class22.method197(var9);
                           } else if(var23 >= var18 && var23 < var18 + 16 && var21 >= var11 + var19 - 16 && var21 < var11 + var19) {
                              var9.scrollY += 4;
                              class22.method197(var9);
                           } else if(var23 >= var18 - Client.field365 && var23 < Client.field365 + var18 + 16 && var21 >= var11 + 16 && var21 < var19 + var11 - 16) {
                              var22 = (var19 - 32) * var19 / var20;
                              if(var22 < 8) {
                                 var22 = 8;
                              }

                              var24 = var21 - var11 - 16 - var22 / 2;
                              int var47 = var19 - 32 - var22;
                              var9.scrollY = (var20 - var19) * var24 / var47;
                              class22.method197(var9);
                              Client.field321 = true;
                           }
                        }

                        if(Client.field538 != 0) {
                           var22 = var9.width;
                           if(var23 >= var18 - var22 && var21 >= var11 && var23 < var18 + 16 && var21 <= var11 + var19) {
                              var9.scrollY += Client.field538 * 45;
                              class22.method197(var9);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IILclass119;LCollisionData;S)Z",
      garbageValue = "-20204"
   )
   static final boolean method559(int var0, int var1, class119 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class118.field1865[var6][var7] = 99;
      class118.field1870[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class118.field1869[var10] = var0;
      int var12 = var10 + 1;
      class118.field1867[var10] = var1;
      int[][] var13 = var3.flags;

      while(var12 != var11) {
         var4 = class118.field1869[var11];
         var5 = class118.field1867[var11];
         var11 = var11 + 1 & 4095;
         int var14 = var4 - var8;
         int var15 = var5 - var9;
         int var16 = var4 - var3.x;
         int var17 = var5 - var3.y;
         if(var2.vmethod2355(1, var4, var5, var3)) {
            class118.field1866 = var4;
            class118.field1863 = var5;
            return true;
         }

         int var18 = class118.field1870[var14][var15] + 1;
         if(var14 > 0 && class118.field1865[var14 - 1][var15] == 0 && (var13[var16 - 1][var17] & 19136776) == 0) {
            class118.field1869[var12] = var4 - 1;
            class118.field1867[var12] = var5;
            var12 = var12 + 1 & 4095;
            class118.field1865[var14 - 1][var15] = 2;
            class118.field1870[var14 - 1][var15] = var18;
         }

         if(var14 < 127 && class118.field1865[var14 + 1][var15] == 0 && (var13[var16 + 1][var17] & 19136896) == 0) {
            class118.field1869[var12] = var4 + 1;
            class118.field1867[var12] = var5;
            var12 = var12 + 1 & 4095;
            class118.field1865[var14 + 1][var15] = 8;
            class118.field1870[var14 + 1][var15] = var18;
         }

         if(var15 > 0 && class118.field1865[var14][var15 - 1] == 0 && (var13[var16][var17 - 1] & 19136770) == 0) {
            class118.field1869[var12] = var4;
            class118.field1867[var12] = var5 - 1;
            var12 = var12 + 1 & 4095;
            class118.field1865[var14][var15 - 1] = 1;
            class118.field1870[var14][var15 - 1] = var18;
         }

         if(var15 < 127 && class118.field1865[var14][var15 + 1] == 0 && (var13[var16][var17 + 1] & 19136800) == 0) {
            class118.field1869[var12] = var4;
            class118.field1867[var12] = var5 + 1;
            var12 = var12 + 1 & 4095;
            class118.field1865[var14][var15 + 1] = 4;
            class118.field1870[var14][var15 + 1] = var18;
         }

         if(var14 > 0 && var15 > 0 && class118.field1865[var14 - 1][var15 - 1] == 0 && (var13[var16 - 1][var17 - 1] & 19136782) == 0 && (var13[var16 - 1][var17] & 19136776) == 0 && (var13[var16][var17 - 1] & 19136770) == 0) {
            class118.field1869[var12] = var4 - 1;
            class118.field1867[var12] = var5 - 1;
            var12 = var12 + 1 & 4095;
            class118.field1865[var14 - 1][var15 - 1] = 3;
            class118.field1870[var14 - 1][var15 - 1] = var18;
         }

         if(var14 < 127 && var15 > 0 && class118.field1865[var14 + 1][var15 - 1] == 0 && (var13[var16 + 1][var17 - 1] & 19136899) == 0 && (var13[var16 + 1][var17] & 19136896) == 0 && (var13[var16][var17 - 1] & 19136770) == 0) {
            class118.field1869[var12] = var4 + 1;
            class118.field1867[var12] = var5 - 1;
            var12 = var12 + 1 & 4095;
            class118.field1865[var14 + 1][var15 - 1] = 9;
            class118.field1870[var14 + 1][var15 - 1] = var18;
         }

         if(var14 > 0 && var15 < 127 && class118.field1865[var14 - 1][var15 + 1] == 0 && (var13[var16 - 1][var17 + 1] & 19136824) == 0 && (var13[var16 - 1][var17] & 19136776) == 0 && (var13[var16][var17 + 1] & 19136800) == 0) {
            class118.field1869[var12] = var4 - 1;
            class118.field1867[var12] = var5 + 1;
            var12 = var12 + 1 & 4095;
            class118.field1865[var14 - 1][var15 + 1] = 6;
            class118.field1870[var14 - 1][var15 + 1] = var18;
         }

         if(var14 < 127 && var15 < 127 && class118.field1865[var14 + 1][var15 + 1] == 0 && (var13[var16 + 1][var17 + 1] & 19136992) == 0 && (var13[var16 + 1][var17] & 19136896) == 0 && (var13[var16][var17 + 1] & 19136800) == 0) {
            class118.field1869[var12] = var4 + 1;
            class118.field1867[var12] = var5 + 1;
            var12 = var12 + 1 & 4095;
            class118.field1865[var14 + 1][var15 + 1] = 12;
            class118.field1870[var14 + 1][var15 + 1] = var18;
         }
      }

      class118.field1866 = var4;
      class118.field1863 = var5;
      return false;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1729144844"
   )
   public static int method560(int var0) {
      Varbit var1 = class22.method201(var0);
      int var2 = var1.leastSignificantBit;
      int var3 = var1.configId;
      int var4 = var1.mostSignificantBit;
      int var5 = class165.field2182[var4 - var3];
      return class165.widgetSettings[var2] >> var3 & var5;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-570795447"
   )
   static boolean method561(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }
}
