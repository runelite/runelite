import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("u")
   static int[] field1282;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 764867537
   )
   int field1283;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -536095991
   )
   @Export("y")
   int y;
   @ObfuscatedName("w")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1207523761
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1081841661
   )
   @Export("x")
   int x;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = -1421184225
   )
   static int field1289;
   @ObfuscatedName("t")
   static int[] field1290;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1045544863
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("ct")
   static class208 field1293;

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIII)V",
      garbageValue = "2119438093"
   )
   static final void method1570(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(null != var9 && (!var9.field2068 || var9.type == 0 || var9.field2149 || class185.method3463(var9) != 0 || var9 == Client.field340 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.field2068 || !class33.method715(var9))) {
            int var10 = var6 + var9.relativeX;
            int var11 = var7 + var9.relativeY;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var19;
            int var33;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               var33 = var10 + var9.width;
               var19 = var9.height + var11;
               if(var33 < var10) {
                  var16 = var33;
                  var33 = var10;
               }

               if(var19 < var11) {
                  var17 = var19;
                  var19 = var11;
               }

               ++var33;
               ++var19;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var33 < var4?var33:var4;
               var15 = var19 < var5?var19:var5;
            } else {
               var16 = var9.width + var10;
               var17 = var9.height + var11;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(Client.field383 == var9) {
               Client.field466 = true;
               Client.field467 = var10;
               Client.field417 = var11;
            }

            if(!var9.field2068 || var12 < var14 && var13 < var15) {
               var16 = class115.field1811;
               var17 = class115.field1810;
               if(class115.field1808 != 0) {
                  var16 = class115.field1809;
                  var17 = class115.field1806;
               }

               int var22;
               int var23;
               int var25;
               int var37;
               int var43;
               int var49;
               if(var9.contentType == 1337) {
                  if(!Client.field280 && !Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     if(Client.field438 == 0 && !Client.field440) {
                        class166.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var33 = -1;
                     var19 = -1;

                     for(var43 = 0; var43 < Model.field1407; ++var43) {
                        var49 = Model.field1382[var43];
                        var22 = var49 & 127;
                        var23 = var49 >> 7 & 127;
                        var37 = var49 >> 29 & 3;
                        var25 = var49 >> 14 & 32767;
                        if(var19 != var49) {
                           var19 = var49;
                           if(var37 == 2 && class157.region.method1881(class166.plane, var22, var23, var49) >= 0) {
                              ObjectComposition var26 = class15.getObjectDefinition(var25);
                              if(var26.impostorIds != null) {
                                 var26 = var26.getImpostor();
                              }

                              if(var26 == null) {
                                 continue;
                              }

                              if(Client.field438 == 1) {
                                 class166.addMenuEntry("Use", Client.field371 + " " + "->" + " " + class13.method182('\uffff') + var26.name, 1, var49, var22, var23);
                              } else if(Client.field440) {
                                 if((class138.field1920 & 4) == 4) {
                                    class166.addMenuEntry(Client.field297, Client.field444 + " " + "->" + " " + class13.method182('\uffff') + var26.name, 2, var49, var22, var23);
                                 }
                              } else {
                                 String[] var38 = var26.actions;
                                 if(Client.field346) {
                                    var38 = class204.method3858(var38);
                                 }

                                 if(null != var38) {
                                    for(int var39 = 4; var39 >= 0; --var39) {
                                       if(null != var38[var39]) {
                                          short var35 = 0;
                                          if(var39 == 0) {
                                             var35 = 3;
                                          }

                                          if(var39 == 1) {
                                             var35 = 4;
                                          }

                                          if(var39 == 2) {
                                             var35 = 5;
                                          }

                                          if(var39 == 3) {
                                             var35 = 6;
                                          }

                                          if(var39 == 4) {
                                             var35 = 1001;
                                          }

                                          class166.addMenuEntry(var38[var39], class13.method182('\uffff') + var26.name, var35, var49, var22, var23);
                                       }
                                    }
                                 }

                                 class166.addMenuEntry("Examine", class13.method182('\uffff') + var26.name, 1002, var26.field2918 << 14, var22, var23);
                              }
                           }

                           int var27;
                           NPC var28;
                           Player var36;
                           int[] var47;
                           int var51;
                           if(var37 == 1) {
                              NPC var44 = Client.cachedNPCs[var25];
                              if(null == var44) {
                                 continue;
                              }

                              if(var44.composition.field3009 == 1 && (var44.x & 127) == 64 && (var44.y & 127) == 64) {
                                 for(var27 = 0; var27 < Client.field326; ++var27) {
                                    var28 = Client.cachedNPCs[Client.field559[var27]];
                                    if(null != var28 && var44 != var28 && var28.composition.field3009 == 1 && var28.x == var44.x && var28.y == var44.y) {
                                       class30.method683(var28.composition, Client.field559[var27], var22, var23);
                                    }
                                 }

                                 var27 = class45.field897;
                                 var47 = class45.field902;

                                 for(var51 = 0; var51 < var27; ++var51) {
                                    var36 = Client.cachedPlayers[var47[var51]];
                                    if(null != var36 && var44.x == var36.x && var44.y == var36.y) {
                                       class49.method899(var36, var47[var51], var22, var23);
                                    }
                                 }
                              }

                              class30.method683(var44.composition, var25, var22, var23);
                           }

                           if(var37 == 0) {
                              Player var45 = Client.cachedPlayers[var25];
                              if(null == var45) {
                                 continue;
                              }

                              if((var45.x & 127) == 64 && (var45.y & 127) == 64) {
                                 for(var27 = 0; var27 < Client.field326; ++var27) {
                                    var28 = Client.cachedNPCs[Client.field559[var27]];
                                    if(null != var28 && var28.composition.field3009 == 1 && var45.x == var28.x && var45.y == var28.y) {
                                       class30.method683(var28.composition, Client.field559[var27], var22, var23);
                                    }
                                 }

                                 var27 = class45.field897;
                                 var47 = class45.field902;

                                 for(var51 = 0; var51 < var27; ++var51) {
                                    var36 = Client.cachedPlayers[var47[var51]];
                                    if(null != var36 && var36 != var45 && var36.x == var45.x && var45.y == var36.y) {
                                       class49.method899(var36, var47[var51], var22, var23);
                                    }
                                 }
                              }

                              if(Client.field525 != var25) {
                                 class49.method899(var45, var25, var22, var23);
                              } else {
                                 var33 = var49;
                              }
                           }

                           if(var37 == 3) {
                              Deque var46 = Client.groundItemDeque[class166.plane][var22][var23];
                              if(var46 != null) {
                                 for(Item var52 = (Item)var46.method2460(); null != var52; var52 = (Item)var46.method2462()) {
                                    ItemComposition var48 = class18.getItemDefinition(var52.id);
                                    if(Client.field438 == 1) {
                                       class166.addMenuEntry("Use", Client.field371 + " " + "->" + " " + class13.method182(16748608) + var48.name, 16, var52.id, var22, var23);
                                    } else if(Client.field440) {
                                       if((class138.field1920 & 1) == 1) {
                                          class166.addMenuEntry(Client.field297, Client.field444 + " " + "->" + " " + class13.method182(16748608) + var48.name, 17, var52.id, var22, var23);
                                       }
                                    } else {
                                       String[] var29 = var48.groundActions;
                                       if(Client.field346) {
                                          var29 = class204.method3858(var29);
                                       }

                                       for(int var30 = 4; var30 >= 0; --var30) {
                                          if(var29 != null && var29[var30] != null) {
                                             byte var31 = 0;
                                             if(var30 == 0) {
                                                var31 = 18;
                                             }

                                             if(var30 == 1) {
                                                var31 = 19;
                                             }

                                             if(var30 == 2) {
                                                var31 = 20;
                                             }

                                             if(var30 == 3) {
                                                var31 = 21;
                                             }

                                             if(var30 == 4) {
                                                var31 = 22;
                                             }

                                             class166.addMenuEntry(var29[var30], class13.method182(16748608) + var48.name, var31, var52.id, var22, var23);
                                          } else if(var30 == 2) {
                                             class166.addMenuEntry("Take", class13.method182(16748608) + var48.name, 20, var52.id, var22, var23);
                                          }
                                       }

                                       class166.addMenuEntry("Examine", class13.method182(16748608) + var48.name, 1004, var52.id, var22, var23);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var33 != -1) {
                        var43 = var33 & 127;
                        var49 = var33 >> 7 & 127;
                        Player var53 = Client.cachedPlayers[Client.field525];
                        class49.method899(var53, Client.field525, var43, var49);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  class157.method2957(var9, var10, var11);
               } else {
                  if(!Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     DecorativeObject.method1950(var9, var16 - var10, var17 - var11);
                  }

                  if(var9.type == 0) {
                     if(!var9.field2068 && class33.method715(var9) && var9 != class39.field802) {
                        continue;
                     }

                     method1570(var0, var9.id, var12, var13, var14, var15, var10 - var9.itemId, var11 - var9.scrollY);
                     if(null != var9.children) {
                        method1570(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.itemId, var11 - var9.scrollY);
                     }

                     WidgetNode var18 = (WidgetNode)Client.componentTable.method2405((long)var9.id);
                     if(null != var18) {
                        if(var18.field174 == 0 && class115.field1811 >= var12 && class115.field1810 >= var13 && class115.field1811 < var14 && class115.field1810 < var15 && !Client.isMenuOpen && !Client.field455) {
                           for(class18 var34 = (class18)Client.field484.method2466(); var34 != null; var34 = (class18)Client.field484.method2461()) {
                              if(var34.field182) {
                                 var34.unlink();
                                 var34.field192.field2194 = false;
                              }
                           }

                           if(field1289 == 0) {
                              Client.field383 = null;
                              Client.field340 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuOptionCount = 1;
                           }
                        }

                        var19 = var18.id;
                        if(class60.method1127(var19)) {
                           method1570(Widget.widgets[var19], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.field2068) {
                     class18 var41;
                     if(!var9.field2202) {
                        if(var9.field2203 && class115.field1811 >= var12 && class115.field1810 >= var13 && class115.field1811 < var14 && class115.field1810 < var15) {
                           for(var41 = (class18)Client.field484.method2466(); null != var41; var41 = (class18)Client.field484.method2461()) {
                              if(var41.field182 && var41.field192.field2170 == var41.field196) {
                                 var41.unlink();
                              }
                           }
                        }
                     } else if(class115.field1811 >= var12 && class115.field1810 >= var13 && class115.field1811 < var14 && class115.field1810 < var15) {
                        for(var41 = (class18)Client.field484.method2466(); null != var41; var41 = (class18)Client.field484.method2461()) {
                           if(var41.field182) {
                              var41.unlink();
                              var41.field192.field2194 = false;
                           }
                        }

                        if(field1289 == 0) {
                           Client.field383 = null;
                           Client.field340 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.menuOptionCount = 1;
                        }
                     }

                     boolean var50;
                     if(class115.field1811 >= var12 && class115.field1810 >= var13 && class115.field1811 < var14 && class115.field1810 < var15) {
                        var50 = true;
                     } else {
                        var50 = false;
                     }

                     boolean var42 = false;
                     if((class115.field1801 == 1 || !MessageNode.field229 && class115.field1801 == 4) && var50) {
                        var42 = true;
                     }

                     boolean var20 = false;
                     if((class115.field1808 == 1 || !MessageNode.field229 && class115.field1808 == 4) && class115.field1809 >= var12 && class115.field1806 >= var13 && class115.field1809 < var14 && class115.field1806 < var15) {
                        var20 = true;
                     }

                     if(var20) {
                        class108.method2088(var9, class115.field1809 - var10, class115.field1806 - var11);
                     }

                     if(Client.field383 != null && Client.field383 != var9 && var50) {
                        var22 = class185.method3463(var9);
                        boolean var32 = (var22 >> 20 & 1) != 0;
                        if(var32) {
                           Client.field363 = var9;
                        }
                     }

                     if(Client.field340 == var9) {
                        Client.field462 = true;
                        Client.field464 = var10;
                        Client.field465 = var11;
                     }

                     if(var9.field2149) {
                        class18 var21;
                        if(var50 && Client.field483 != 0 && null != var9.field2170) {
                           var21 = new class18();
                           var21.field182 = true;
                           var21.field192 = var9;
                           var21.field185 = Client.field483;
                           var21.field196 = var9.field2170;
                           Client.field484.method2454(var21);
                        }

                        if(Client.field383 != null || null != class163.field2313 || Client.isMenuOpen) {
                           var20 = false;
                           var42 = false;
                           var50 = false;
                        }

                        if(!var9.field2128 && var20) {
                           var9.field2128 = true;
                           if(null != var9.field2151) {
                              var21 = new class18();
                              var21.field182 = true;
                              var21.field192 = var9;
                              var21.field184 = class115.field1809 - var10;
                              var21.field185 = class115.field1806 - var11;
                              var21.field196 = var9.field2151;
                              Client.field484.method2454(var21);
                           }
                        }

                        if(var9.field2128 && var42 && var9.field2152 != null) {
                           var21 = new class18();
                           var21.field182 = true;
                           var21.field192 = var9;
                           var21.field184 = class115.field1811 - var10;
                           var21.field185 = class115.field1810 - var11;
                           var21.field196 = var9.field2152;
                           Client.field484.method2454(var21);
                        }

                        if(var9.field2128 && !var42) {
                           var9.field2128 = false;
                           if(null != var9.field2153) {
                              var21 = new class18();
                              var21.field182 = true;
                              var21.field192 = var9;
                              var21.field184 = class115.field1811 - var10;
                              var21.field185 = class115.field1810 - var11;
                              var21.field196 = var9.field2153;
                              Client.field569.method2454(var21);
                           }
                        }

                        if(var42 && var9.field2154 != null) {
                           var21 = new class18();
                           var21.field182 = true;
                           var21.field192 = var9;
                           var21.field184 = class115.field1811 - var10;
                           var21.field185 = class115.field1810 - var11;
                           var21.field196 = var9.field2154;
                           Client.field484.method2454(var21);
                        }

                        if(!var9.field2194 && var50) {
                           var9.field2194 = true;
                           if(var9.field2155 != null) {
                              var21 = new class18();
                              var21.field182 = true;
                              var21.field192 = var9;
                              var21.field184 = class115.field1811 - var10;
                              var21.field185 = class115.field1810 - var11;
                              var21.field196 = var9.field2155;
                              Client.field484.method2454(var21);
                           }
                        }

                        if(var9.field2194 && var50 && var9.field2156 != null) {
                           var21 = new class18();
                           var21.field182 = true;
                           var21.field192 = var9;
                           var21.field184 = class115.field1811 - var10;
                           var21.field185 = class115.field1810 - var11;
                           var21.field196 = var9.field2156;
                           Client.field484.method2454(var21);
                        }

                        if(var9.field2194 && !var50) {
                           var9.field2194 = false;
                           if(var9.field2157 != null) {
                              var21 = new class18();
                              var21.field182 = true;
                              var21.field192 = var9;
                              var21.field184 = class115.field1811 - var10;
                              var21.field185 = class115.field1810 - var11;
                              var21.field196 = var9.field2157;
                              Client.field569.method2454(var21);
                           }
                        }

                        if(null != var9.field2168) {
                           var21 = new class18();
                           var21.field192 = var9;
                           var21.field196 = var9.field2168;
                           Client.field485.method2454(var21);
                        }

                        class18 var24;
                        if(var9.field2189 != null && Client.field472 > var9.field2197) {
                           if(var9.field2079 != null && Client.field472 - var9.field2197 <= 32) {
                              label1207:
                              for(var49 = var9.field2197; var49 < Client.field472; ++var49) {
                                 var22 = Client.field400[var49 & 31];

                                 for(var23 = 0; var23 < var9.field2079.length; ++var23) {
                                    if(var22 == var9.field2079[var23]) {
                                       var24 = new class18();
                                       var24.field192 = var9;
                                       var24.field196 = var9.field2189;
                                       Client.field484.method2454(var24);
                                       break label1207;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class18();
                              var21.field192 = var9;
                              var21.field196 = var9.field2189;
                              Client.field484.method2454(var21);
                           }

                           var9.field2197 = Client.field472;
                        }

                        if(null != var9.field2164 && Client.field468 > var9.field2198) {
                           if(null != var9.field2143 && Client.field468 - var9.field2198 <= 32) {
                              label1183:
                              for(var49 = var9.field2198; var49 < Client.field468; ++var49) {
                                 var22 = Client.field473[var49 & 31];

                                 for(var23 = 0; var23 < var9.field2143.length; ++var23) {
                                    if(var9.field2143[var23] == var22) {
                                       var24 = new class18();
                                       var24.field192 = var9;
                                       var24.field196 = var9.field2164;
                                       Client.field484.method2454(var24);
                                       break label1183;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class18();
                              var21.field192 = var9;
                              var21.field196 = var9.field2164;
                              Client.field484.method2454(var21);
                           }

                           var9.field2198 = Client.field468;
                        }

                        if(var9.field2166 != null && Client.field476 > var9.field2199) {
                           if(var9.field2089 != null && Client.field476 - var9.field2199 <= 32) {
                              label1159:
                              for(var49 = var9.field2199; var49 < Client.field476; ++var49) {
                                 var22 = Client.field475[var49 & 31];

                                 for(var23 = 0; var23 < var9.field2089.length; ++var23) {
                                    if(var9.field2089[var23] == var22) {
                                       var24 = new class18();
                                       var24.field192 = var9;
                                       var24.field196 = var9.field2166;
                                       Client.field484.method2454(var24);
                                       break label1159;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class18();
                              var21.field192 = var9;
                              var21.field196 = var9.field2166;
                              Client.field484.method2454(var21);
                           }

                           var9.field2199 = Client.field476;
                        }

                        if(Client.field477 > var9.field2196 && null != var9.field2171) {
                           var21 = new class18();
                           var21.field192 = var9;
                           var21.field196 = var9.field2171;
                           Client.field484.method2454(var21);
                        }

                        if(Client.field388 > var9.field2196 && null != var9.field2167) {
                           var21 = new class18();
                           var21.field192 = var9;
                           var21.field196 = var9.field2167;
                           Client.field484.method2454(var21);
                        }

                        if(Client.field479 > var9.field2196 && null != var9.field2174) {
                           var21 = new class18();
                           var21.field192 = var9;
                           var21.field196 = var9.field2174;
                           Client.field484.method2454(var21);
                        }

                        if(Client.field480 > var9.field2196 && var9.field2105 != null) {
                           var21 = new class18();
                           var21.field192 = var9;
                           var21.field196 = var9.field2105;
                           Client.field484.method2454(var21);
                        }

                        if(Client.field481 > var9.field2196 && var9.field2180 != null) {
                           var21 = new class18();
                           var21.field192 = var9;
                           var21.field196 = var9.field2180;
                           Client.field484.method2454(var21);
                        }

                        if(Client.field379 > var9.field2196 && null != var9.field2175) {
                           var21 = new class18();
                           var21.field192 = var9;
                           var21.field196 = var9.field2175;
                           Client.field484.method2454(var21);
                        }

                        var9.field2196 = Client.field470;
                        if(null != var9.field2182) {
                           for(var49 = 0; var49 < Client.field508; ++var49) {
                              class18 var40 = new class18();
                              var40.field192 = var9;
                              var40.field188 = Client.field352[var49];
                              var40.field189 = Client.field474[var49];
                              var40.field196 = var9.field2182;
                              Client.field484.method2454(var40);
                           }
                        }
                     }
                  }

                  if(!var9.field2068 && Client.field383 == null && class163.field2313 == null && !Client.isMenuOpen) {
                     if((var9.field2120 >= 0 || var9.field2096 != 0) && class115.field1811 >= var12 && class115.field1810 >= var13 && class115.field1811 < var14 && class115.field1810 < var15) {
                        if(var9.field2120 >= 0) {
                           class39.field802 = var0[var9.field2120];
                        } else {
                           class39.field802 = var9;
                        }
                     }

                     if(var9.type == 8 && class115.field1811 >= var12 && class115.field1810 >= var13 && class115.field1811 < var14 && class115.field1810 < var15) {
                        class105.field1723 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        var33 = var9.width + var10;
                        var19 = var9.height;
                        var43 = var9.scrollHeight;
                        var49 = class115.field1811;
                        var22 = class115.field1810;
                        if(Client.field325) {
                           Client.field369 = 32;
                        } else {
                           Client.field369 = 0;
                        }

                        Client.field325 = false;
                        if(class115.field1801 == 1 || !MessageNode.field229 && class115.field1801 == 4) {
                           if(var49 >= var33 && var49 < var33 + 16 && var22 >= var11 && var22 < 16 + var11) {
                              var9.scrollY -= 4;
                              Tile.method1577(var9);
                           } else if(var49 >= var33 && var49 < 16 + var33 && var22 >= var19 + var11 - 16 && var22 < var11 + var19) {
                              var9.scrollY += 4;
                              Tile.method1577(var9);
                           } else if(var49 >= var33 - Client.field369 && var49 < 16 + var33 + Client.field369 && var22 >= var11 + 16 && var22 < var11 + var19 - 16) {
                              var23 = (var19 - 32) * var19 / var43;
                              if(var23 < 8) {
                                 var23 = 8;
                              }

                              var37 = var22 - var11 - 16 - var23 / 2;
                              var25 = var19 - 32 - var23;
                              var9.scrollY = var37 * (var43 - var19) / var25;
                              Tile.method1577(var9);
                              Client.field325 = true;
                           }
                        }

                        if(Client.field483 != 0) {
                           var23 = var9.width;
                           if(var49 >= var33 - var23 && var22 >= var11 && var49 < 16 + var33 && var22 <= var19 + var11) {
                              var9.scrollY += Client.field483 * 45;
                              Tile.method1577(var9);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "92"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(null == class206.worldServersDownload) {
            class206.worldServersDownload = new class26(class15.field159, new URL(class97.field1629));
         } else {
            byte[] var0 = class206.worldServersDownload.method608();
            if(null != var0) {
               Buffer var1 = new Buffer(var0);
               World.field672 = var1.readUnsignedShort();
               World.worldList = new World[World.field672];

               World var3;
               for(int var2 = 0; var2 < World.field672; var3.index = var2++) {
                  var3 = World.worldList[var2] = new World();
                  var3.id = var1.readUnsignedShort();
                  var3.mask = var1.method2995();
                  var3.address = var1.method3057();
                  var3.activity = var1.method3057();
                  var3.location = var1.readUnsignedByte();
                  var3.playerCount = var1.method2993();
               }

               FaceNormal.method1924(World.worldList, 0, World.worldList.length - 1, World.field686, World.field674);
               class206.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class206.worldServersDownload = null;
      }

      return false;
   }
}
