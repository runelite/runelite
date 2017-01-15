import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("o")
   static int[] field1557;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1198894355
   )
   static int field1561;
   @ObfuscatedName("u")
   Frame[] field1562;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "13"
   )
   public static boolean method1848(char var0) {
      return var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-79"
   )
   public boolean method1849(int var1) {
      return this.field1562[var1].field1319;
   }

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIB)V",
      garbageValue = "85"
   )
   static final void method1850(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.field2184 || var9.type == 0 || var9.field2307 || GameObject.method1872(var9) != 0 || Client.field454 == var9 || var9.contentType == 1338) && var1 == var9.parentId && (!var9.field2184 || !WallObject.method1846(var9))) {
            int var10 = var9.relativeX + var6;
            int var11 = var9.relativeY + var7;
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
               var16 = var9.width + var10;
               var17 = var11 + var9.height;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(Client.field453 == var9) {
               Client.field525 = true;
               Client.field509 = var10;
               Client.field463 = var11;
            }

            if(!var9.field2184 || var12 < var14 && var13 < var15) {
               var16 = class115.field1788;
               var17 = class115.field1789;
               if(class115.field1794 != 0) {
                  var16 = class115.field1791;
                  var17 = class115.field1796;
               }

               int var20;
               int var21;
               int var22;
               int var23;
               int var24;
               int var25;
               int var26;
               if(var9.contentType == 1337) {
                  if(!Client.field301 && !Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     if(Client.field447 == 0 && !Client.field435) {
                        GroundObject.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var18 = -1;
                     var19 = -1;

                     for(var25 = 0; var25 < Model.field1413; ++var25) {
                        var26 = Model.field1414[var25];
                        var20 = var26 & 127;
                        var21 = var26 >> 7 & 127;
                        var24 = var26 >> 29 & 3;
                        var22 = var26 >> 14 & 32767;
                        if(var26 != var19) {
                           var19 = var26;
                           int var43;
                           if(var24 == 2 && class6.region.method1714(class60.plane, var20, var21, var26) >= 0) {
                              ObjectComposition var40 = Tile.getObjectDefinition(var22);
                              if(var40.impostorIds != null) {
                                 var40 = var40.getImpostor();
                              }

                              if(var40 == null) {
                                 continue;
                              }

                              if(Client.field447 == 1) {
                                 GroundObject.addMenuEntry("Use", Client.field468 + " " + "->" + " " + class32.method691('\uffff') + var40.name, 1, var26, var20, var21);
                              } else if(Client.field435) {
                                 if((class214.field3158 & 4) == 4) {
                                    GroundObject.addMenuEntry(Client.field438, Client.field282 + " " + "->" + " " + class32.method691('\uffff') + var40.name, 2, var26, var20, var21);
                                 }
                              } else {
                                 String[] var47 = var40.actions;
                                 if(Client.field300) {
                                    var47 = class8.method112(var47);
                                 }

                                 if(var47 != null) {
                                    for(var43 = 4; var43 >= 0; --var43) {
                                       if(null != var47[var43]) {
                                          short var46 = 0;
                                          if(var43 == 0) {
                                             var46 = 3;
                                          }

                                          if(var43 == 1) {
                                             var46 = 4;
                                          }

                                          if(var43 == 2) {
                                             var46 = 5;
                                          }

                                          if(var43 == 3) {
                                             var46 = 6;
                                          }

                                          if(var43 == 4) {
                                             var46 = 1001;
                                          }

                                          GroundObject.addMenuEntry(var47[var43], class32.method691('\uffff') + var40.name, var46, var26, var20, var21);
                                       }
                                    }
                                 }

                                 GroundObject.addMenuEntry("Examine", class32.method691('\uffff') + var40.name, 1002, var40.field2887 << 14, var20, var21);
                              }
                           }

                           NPC var41;
                           Player var49;
                           int[] var51;
                           if(var24 == 1) {
                              NPC var52 = Client.cachedNPCs[var22];
                              if(null == var52) {
                                 continue;
                              }

                              if(var52.composition.field3007 == 1 && (var52.x & 127) == 64 && (var52.y & 127) == 64) {
                                 for(var23 = 0; var23 < Client.field322; ++var23) {
                                    var41 = Client.cachedNPCs[Client.field483[var23]];
                                    if(null != var41 && var52 != var41 && var41.composition.field3007 == 1 && var52.x == var41.x && var52.y == var41.y) {
                                       FileOnDisk.method1384(var41.composition, Client.field483[var23], var20, var21);
                                    }
                                 }

                                 var23 = class45.field888;
                                 var51 = class45.field892;

                                 for(var43 = 0; var43 < var23; ++var43) {
                                    var49 = Client.cachedPlayers[var51[var43]];
                                    if(null != var49 && var52.x == var49.x && var52.y == var49.y) {
                                       class11.method151(var49, var51[var43], var20, var21);
                                    }
                                 }
                              }

                              FileOnDisk.method1384(var52.composition, var22, var20, var21);
                           }

                           if(var24 == 0) {
                              Player var53 = Client.cachedPlayers[var22];
                              if(null == var53) {
                                 continue;
                              }

                              if((var53.x & 127) == 64 && (var53.y & 127) == 64) {
                                 for(var23 = 0; var23 < Client.field322; ++var23) {
                                    var41 = Client.cachedNPCs[Client.field483[var23]];
                                    if(var41 != null && var41.composition.field3007 == 1 && var53.x == var41.x && var41.y == var53.y) {
                                       FileOnDisk.method1384(var41.composition, Client.field483[var23], var20, var21);
                                    }
                                 }

                                 var23 = class45.field888;
                                 var51 = class45.field892;

                                 for(var43 = 0; var43 < var23; ++var43) {
                                    var49 = Client.cachedPlayers[var51[var43]];
                                    if(var49 != null && var49 != var53 && var49.x == var53.x && var53.y == var49.y) {
                                       class11.method151(var49, var51[var43], var20, var21);
                                    }
                                 }
                              }

                              if(Client.field412 != var22) {
                                 class11.method151(var53, var22, var20, var21);
                              } else {
                                 var18 = var26;
                              }
                           }

                           if(var24 == 3) {
                              Deque var54 = Client.groundItemDeque[class60.plane][var20][var21];
                              if(var54 != null) {
                                 for(Item var48 = (Item)var54.method2392(); null != var48; var48 = (Item)var54.method2390()) {
                                    ItemComposition var50 = class88.getItemDefinition(var48.id);
                                    if(Client.field447 == 1) {
                                       GroundObject.addMenuEntry("Use", Client.field468 + " " + "->" + " " + class32.method691(16748608) + var50.name, 16, var48.id, var20, var21);
                                    } else if(Client.field435) {
                                       if((class214.field3158 & 1) == 1) {
                                          GroundObject.addMenuEntry(Client.field438, Client.field282 + " " + "->" + " " + class32.method691(16748608) + var50.name, 17, var48.id, var20, var21);
                                       }
                                    } else {
                                       String[] var34 = var50.groundActions;
                                       if(Client.field300) {
                                          var34 = class8.method112(var34);
                                       }

                                       for(int var35 = 4; var35 >= 0; --var35) {
                                          if(var34 != null && var34[var35] != null) {
                                             byte var36 = 0;
                                             if(var35 == 0) {
                                                var36 = 18;
                                             }

                                             if(var35 == 1) {
                                                var36 = 19;
                                             }

                                             if(var35 == 2) {
                                                var36 = 20;
                                             }

                                             if(var35 == 3) {
                                                var36 = 21;
                                             }

                                             if(var35 == 4) {
                                                var36 = 22;
                                             }

                                             GroundObject.addMenuEntry(var34[var35], class32.method691(16748608) + var50.name, var36, var48.id, var20, var21);
                                          } else if(var35 == 2) {
                                             GroundObject.addMenuEntry("Take", class32.method691(16748608) + var50.name, 20, var48.id, var20, var21);
                                          }
                                       }

                                       GroundObject.addMenuEntry("Examine", class32.method691(16748608) + var50.name, 1004, var48.id, var20, var21);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var18 != -1) {
                        var25 = var18 & 127;
                        var26 = var18 >> 7 & 127;
                        Player var42 = Client.cachedPlayers[Client.field412];
                        class11.method151(var42, Client.field412, var25, var26);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  if((Client.field543 == 0 || Client.field543 == 3) && (class115.field1794 == 1 || !GroundObject.field1297 && class115.field1794 == 4)) {
                     class164 var38 = var9.method3173(true);
                     if(var38 != null) {
                        var19 = class115.field1791 - var10;
                        var25 = class115.field1796 - var11;
                        if(var38.method3114(var19, var25)) {
                           var19 -= var38.field2143 / 2;
                           var25 -= var38.field2139 / 2;
                           var26 = Client.mapAngle + Client.mapScale & 2047;
                           var20 = class84.field1438[var26];
                           var21 = class84.field1428[var26];
                           var20 = var20 * (256 + Client.mapScaleDelta) >> 8;
                           var21 = var21 * (256 + Client.mapScaleDelta) >> 8;
                           var24 = var21 * var19 + var25 * var20 >> 11;
                           var22 = var21 * var25 - var19 * var20 >> 11;
                           int var45 = var24 + class148.localPlayer.x >> 7;
                           var23 = class148.localPlayer.y - var22 >> 7;
                           Client.field326.method3029(93);
                           Client.field326.method2760(18);
                           Client.field326.method2800(class105.field1700[82]?(class105.field1700[81]?2:1):0);
                           Client.field326.method2942(FrameMap.baseX + var45);
                           Client.field326.method2809(var23 + XItemContainer.baseY);
                           Client.field326.method2760(var19);
                           Client.field326.method2760(var25);
                           Client.field326.method2918(Client.mapAngle);
                           Client.field326.method2760(57);
                           Client.field326.method2760(Client.mapScale);
                           Client.field326.method2760(Client.mapScaleDelta);
                           Client.field326.method2760(89);
                           Client.field326.method2918(class148.localPlayer.x);
                           Client.field326.method2918(class148.localPlayer.y);
                           Client.field326.method2760(63);
                           Client.flagX = var45;
                           Client.flagY = var23;
                        }
                     }
                  }
               } else {
                  if(!Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     class112.method2044(var9, var16 - var10, var17 - var11);
                  }

                  if(var9.type == 0) {
                     if(!var9.field2184 && WallObject.method1846(var9) && class188.field2758 != var9) {
                        continue;
                     }

                     method1850(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(null != var9.children) {
                        method1850(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var27 = (WidgetNode)Client.componentTable.method2339((long)var9.id);
                     if(var27 != null) {
                        if(var27.field182 == 0 && class115.field1788 >= var12 && class115.field1789 >= var13 && class115.field1788 < var14 && class115.field1789 < var15 && !Client.isMenuOpen && !Client.field414) {
                           for(class18 var28 = (class18)Client.field479.method2391(); null != var28; var28 = (class18)Client.field479.method2393()) {
                              if(var28.field189) {
                                 var28.unlink();
                                 var28.field195.field2198 = false;
                              }
                           }

                           if(class94.field1581 == 0) {
                              Client.field453 = null;
                              Client.field454 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuOptionCount = 1;
                           }
                        }

                        class183.method3352(var27.id, var12, var13, var14, var15, var10, var11);
                     }
                  }

                  if(var9.field2184) {
                     class18 var37;
                     if(!var9.field2204) {
                        if(var9.field2319 && class115.field1788 >= var12 && class115.field1789 >= var13 && class115.field1788 < var14 && class115.field1789 < var15) {
                           for(var37 = (class18)Client.field479.method2391(); null != var37; var37 = (class18)Client.field479.method2393()) {
                              if(var37.field189 && var37.field203 == var37.field195.field2286) {
                                 var37.unlink();
                              }
                           }
                        }
                     } else if(class115.field1788 >= var12 && class115.field1789 >= var13 && class115.field1788 < var14 && class115.field1789 < var15) {
                        for(var37 = (class18)Client.field479.method2391(); null != var37; var37 = (class18)Client.field479.method2393()) {
                           if(var37.field189) {
                              var37.unlink();
                              var37.field195.field2198 = false;
                           }
                        }

                        if(class94.field1581 == 0) {
                           Client.field453 = null;
                           Client.field454 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.menuOptionCount = 1;
                        }
                     }

                     boolean var39;
                     if(class115.field1788 >= var12 && class115.field1789 >= var13 && class115.field1788 < var14 && class115.field1789 < var15) {
                        var39 = true;
                     } else {
                        var39 = false;
                     }

                     boolean var29 = false;
                     if((class115.field1787 == 1 || !GroundObject.field1297 && class115.field1787 == 4) && var39) {
                        var29 = true;
                     }

                     boolean var30 = false;
                     if((class115.field1794 == 1 || !GroundObject.field1297 && class115.field1794 == 4) && class115.field1791 >= var12 && class115.field1796 >= var13 && class115.field1791 < var14 && class115.field1796 < var15) {
                        var30 = true;
                     }

                     if(var30) {
                        WallObject.method1845(var9, class115.field1791 - var10, class115.field1796 - var11);
                     }

                     if(null != Client.field453 && var9 != Client.field453 && var39) {
                        var20 = GameObject.method1872(var9);
                        boolean var31 = (var20 >> 20 & 1) != 0;
                        if(var31) {
                           Client.field457 = var9;
                        }
                     }

                     if(var9 == Client.field454) {
                        Client.field458 = true;
                        Client.field490 = var10;
                        Client.field284 = var11;
                     }

                     if(var9.field2307) {
                        class18 var44;
                        if(var39 && Client.field524 != 0 && null != var9.field2286) {
                           var44 = new class18();
                           var44.field189 = true;
                           var44.field195 = var9;
                           var44.field190 = Client.field524;
                           var44.field203 = var9.field2286;
                           Client.field479.method2394(var44);
                        }

                        if(Client.field453 != null || null != class31.field715 || Client.isMenuOpen) {
                           var30 = false;
                           var29 = false;
                           var39 = false;
                        }

                        if(!var9.field2311 && var30) {
                           var9.field2311 = true;
                           if(null != var9.field2267) {
                              var44 = new class18();
                              var44.field189 = true;
                              var44.field195 = var9;
                              var44.field191 = class115.field1791 - var10;
                              var44.field190 = class115.field1796 - var11;
                              var44.field203 = var9.field2267;
                              Client.field479.method2394(var44);
                           }
                        }

                        if(var9.field2311 && var29 && null != var9.field2268) {
                           var44 = new class18();
                           var44.field189 = true;
                           var44.field195 = var9;
                           var44.field191 = class115.field1788 - var10;
                           var44.field190 = class115.field1789 - var11;
                           var44.field203 = var9.field2268;
                           Client.field479.method2394(var44);
                        }

                        if(var9.field2311 && !var29) {
                           var9.field2311 = false;
                           if(null != var9.field2269) {
                              var44 = new class18();
                              var44.field189 = true;
                              var44.field195 = var9;
                              var44.field191 = class115.field1788 - var10;
                              var44.field190 = class115.field1789 - var11;
                              var44.field203 = var9.field2269;
                              Client.field325.method2394(var44);
                           }
                        }

                        if(var29 && var9.field2270 != null) {
                           var44 = new class18();
                           var44.field189 = true;
                           var44.field195 = var9;
                           var44.field191 = class115.field1788 - var10;
                           var44.field190 = class115.field1789 - var11;
                           var44.field203 = var9.field2270;
                           Client.field479.method2394(var44);
                        }

                        if(!var9.field2198 && var39) {
                           var9.field2198 = true;
                           if(null != var9.field2271) {
                              var44 = new class18();
                              var44.field189 = true;
                              var44.field195 = var9;
                              var44.field191 = class115.field1788 - var10;
                              var44.field190 = class115.field1789 - var11;
                              var44.field203 = var9.field2271;
                              Client.field479.method2394(var44);
                           }
                        }

                        if(var9.field2198 && var39 && null != var9.field2232) {
                           var44 = new class18();
                           var44.field189 = true;
                           var44.field195 = var9;
                           var44.field191 = class115.field1788 - var10;
                           var44.field190 = class115.field1789 - var11;
                           var44.field203 = var9.field2232;
                           Client.field479.method2394(var44);
                        }

                        if(var9.field2198 && !var39) {
                           var9.field2198 = false;
                           if(null != var9.field2273) {
                              var44 = new class18();
                              var44.field189 = true;
                              var44.field195 = var9;
                              var44.field191 = class115.field1788 - var10;
                              var44.field190 = class115.field1789 - var11;
                              var44.field203 = var9.field2273;
                              Client.field325.method2394(var44);
                           }
                        }

                        if(null != var9.field2272) {
                           var44 = new class18();
                           var44.field195 = var9;
                           var44.field203 = var9.field2272;
                           Client.field480.method2394(var44);
                        }

                        class18 var32;
                        if(var9.field2303 != null && Client.field467 > var9.field2313) {
                           if(null != var9.field2192 && Client.field467 - var9.field2313 <= 32) {
                              label783:
                              for(var26 = var9.field2313; var26 < Client.field467; ++var26) {
                                 var20 = Client.field287[var26 & 31];

                                 for(var21 = 0; var21 < var9.field2192.length; ++var21) {
                                    if(var9.field2192[var21] == var20) {
                                       var32 = new class18();
                                       var32.field195 = var9;
                                       var32.field203 = var9.field2303;
                                       Client.field479.method2394(var32);
                                       break label783;
                                    }
                                 }
                              }
                           } else {
                              var44 = new class18();
                              var44.field195 = var9;
                              var44.field203 = var9.field2303;
                              Client.field479.method2394(var44);
                           }

                           var9.field2313 = Client.field467;
                        }

                        if(null != var9.field2175 && Client.field469 > var9.field2314) {
                           if(var9.field2281 != null && Client.field469 - var9.field2314 <= 32) {
                              label759:
                              for(var26 = var9.field2314; var26 < Client.field469; ++var26) {
                                 var20 = Client.field471[var26 & 31];

                                 for(var21 = 0; var21 < var9.field2281.length; ++var21) {
                                    if(var9.field2281[var21] == var20) {
                                       var32 = new class18();
                                       var32.field195 = var9;
                                       var32.field203 = var9.field2175;
                                       Client.field479.method2394(var32);
                                       break label759;
                                    }
                                 }
                              }
                           } else {
                              var44 = new class18();
                              var44.field195 = var9;
                              var44.field203 = var9.field2175;
                              Client.field479.method2394(var44);
                           }

                           var9.field2314 = Client.field469;
                        }

                        if(null != var9.field2282 && Client.field344 > var9.field2315) {
                           if(var9.field2249 != null && Client.field344 - var9.field2315 <= 32) {
                              label735:
                              for(var26 = var9.field2315; var26 < Client.field344; ++var26) {
                                 var20 = Client.field470[var26 & 31];

                                 for(var21 = 0; var21 < var9.field2249.length; ++var21) {
                                    if(var20 == var9.field2249[var21]) {
                                       var32 = new class18();
                                       var32.field195 = var9;
                                       var32.field203 = var9.field2282;
                                       Client.field479.method2394(var32);
                                       break label735;
                                    }
                                 }
                              }
                           } else {
                              var44 = new class18();
                              var44.field195 = var9;
                              var44.field203 = var9.field2282;
                              Client.field479.method2394(var44);
                           }

                           var9.field2315 = Client.field344;
                        }

                        if(Client.field289 > var9.field2312 && var9.field2287 != null) {
                           var44 = new class18();
                           var44.field195 = var9;
                           var44.field203 = var9.field2287;
                           Client.field479.method2394(var44);
                        }

                        if(Client.field460 > var9.field2312 && var9.field2179 != null) {
                           var44 = new class18();
                           var44.field195 = var9;
                           var44.field203 = var9.field2179;
                           Client.field479.method2394(var44);
                        }

                        if(Client.field474 > var9.field2312 && null != var9.field2290) {
                           var44 = new class18();
                           var44.field195 = var9;
                           var44.field203 = var9.field2290;
                           Client.field479.method2394(var44);
                        }

                        if(Client.field549 > var9.field2312 && null != var9.field2295) {
                           var44 = new class18();
                           var44.field195 = var9;
                           var44.field203 = var9.field2295;
                           Client.field479.method2394(var44);
                        }

                        if(Client.field476 > var9.field2312 && var9.field2296 != null) {
                           var44 = new class18();
                           var44.field195 = var9;
                           var44.field203 = var9.field2296;
                           Client.field479.method2394(var44);
                        }

                        if(Client.field477 > var9.field2312 && null != var9.field2291) {
                           var44 = new class18();
                           var44.field195 = var9;
                           var44.field203 = var9.field2291;
                           Client.field479.method2394(var44);
                        }

                        var9.field2312 = Client.field446;
                        if(null != var9.field2288) {
                           for(var26 = 0; var26 < Client.field503; ++var26) {
                              class18 var33 = new class18();
                              var33.field195 = var9;
                              var33.field201 = Client.field505[var26];
                              var33.field193 = Client.field504[var26];
                              var33.field203 = var9.field2288;
                              Client.field479.method2394(var33);
                           }
                        }
                     }
                  }

                  if(!var9.field2184 && Client.field453 == null && class31.field715 == null && !Client.isMenuOpen) {
                     if((var9.field2300 >= 0 || var9.field2212 != 0) && class115.field1788 >= var12 && class115.field1789 >= var13 && class115.field1788 < var14 && class115.field1789 < var15) {
                        if(var9.field2300 >= 0) {
                           class188.field2758 = var0[var9.field2300];
                        } else {
                           class188.field2758 = var9;
                        }
                     }

                     if(var9.type == 8 && class115.field1788 >= var12 && class115.field1789 >= var13 && class115.field1788 < var14 && class115.field1789 < var15) {
                        Player.field241 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        class57.method1056(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, class115.field1788, class115.field1789);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "55"
   )
   static final void method1851() {
      if(Client.field336 > 0) {
         class11.method150();
      } else {
         Friend.setGameState(40);
         class101.field1643 = class37.field774;
         class37.field774 = null;
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IZ)V",
      garbageValue = "0"
   )
   public Frames(class182 var1, class182 var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method3323(var3);
      this.field1562 = new Frame[var6];
      int[] var7 = var1.method3314(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3272(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method2391(); null != var12; var12 = (FrameMap)var5.method2393()) {
            if(var11 == var12.field1463) {
               var10 = var12;
               break;
            }
         }

         if(null == var10) {
            byte[] var13 = var2.method3268(var11, 0);
            var10 = new FrameMap(var11, var13);
            var5.method2394(var10);
         }

         this.field1562[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-394090734"
   )
   public static boolean method1852(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
