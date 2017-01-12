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

               int var22;
               int var23;
               int var25;
               int var27;
               int var36;
               int var44;
               int var52;
               if(var9.contentType == 1337) {
                  if(!Client.field301 && !Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     if(Client.field447 == 0 && !Client.field435) {
                        GroundObject.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var18 = -1;
                     var19 = -1;

                     for(var44 = 0; var44 < Model.field1413; ++var44) {
                        var52 = Model.field1414[var44];
                        var22 = var52 & 127;
                        var23 = var52 >> 7 & 127;
                        var36 = var52 >> 29 & 3;
                        var25 = var52 >> 14 & 32767;
                        if(var52 != var19) {
                           var19 = var52;
                           if(var36 == 2 && class6.region.method1714(class60.plane, var22, var23, var52) >= 0) {
                              ObjectComposition var26 = Tile.getObjectDefinition(var25);
                              if(var26.impostorIds != null) {
                                 var26 = var26.getImpostor();
                              }

                              if(var26 == null) {
                                 continue;
                              }

                              if(Client.field447 == 1) {
                                 GroundObject.addMenuEntry("Use", Client.field468 + " " + "->" + " " + class32.method691('\uffff') + var26.name, 1, var52, var22, var23);
                              } else if(Client.field435) {
                                 if((class214.field3158 & 4) == 4) {
                                    GroundObject.addMenuEntry(Client.field438, Client.field282 + " " + "->" + " " + class32.method691('\uffff') + var26.name, 2, var52, var22, var23);
                                 }
                              } else {
                                 String[] var34 = var26.actions;
                                 if(Client.field300) {
                                    var34 = class8.method112(var34);
                                 }

                                 if(var34 != null) {
                                    for(int var28 = 4; var28 >= 0; --var28) {
                                       if(null != var34[var28]) {
                                          short var29 = 0;
                                          if(var28 == 0) {
                                             var29 = 3;
                                          }

                                          if(var28 == 1) {
                                             var29 = 4;
                                          }

                                          if(var28 == 2) {
                                             var29 = 5;
                                          }

                                          if(var28 == 3) {
                                             var29 = 6;
                                          }

                                          if(var28 == 4) {
                                             var29 = 1001;
                                          }

                                          GroundObject.addMenuEntry(var34[var28], class32.method691('\uffff') + var26.name, var29, var52, var22, var23);
                                       }
                                    }
                                 }

                                 GroundObject.addMenuEntry("Examine", class32.method691('\uffff') + var26.name, 1002, var26.field2887 << 14, var22, var23);
                              }
                           }

                           NPC var37;
                           Player var38;
                           int var48;
                           int[] var53;
                           if(var36 == 1) {
                              NPC var45 = Client.cachedNPCs[var25];
                              if(null == var45) {
                                 continue;
                              }

                              if(var45.composition.field3007 == 1 && (var45.x & 127) == 64 && (var45.y & 127) == 64) {
                                 for(var27 = 0; var27 < Client.field322; ++var27) {
                                    var37 = Client.cachedNPCs[Client.field483[var27]];
                                    if(null != var37 && var45 != var37 && var37.composition.field3007 == 1 && var45.x == var37.x && var45.y == var37.y) {
                                       FileOnDisk.method1384(var37.composition, Client.field483[var27], var22, var23);
                                    }
                                 }

                                 var27 = class45.field888;
                                 var53 = class45.field892;

                                 for(var48 = 0; var48 < var27; ++var48) {
                                    var38 = Client.cachedPlayers[var53[var48]];
                                    if(null != var38 && var45.x == var38.x && var45.y == var38.y) {
                                       class11.method151(var38, var53[var48], var22, var23);
                                    }
                                 }
                              }

                              FileOnDisk.method1384(var45.composition, var25, var22, var23);
                           }

                           if(var36 == 0) {
                              Player var46 = Client.cachedPlayers[var25];
                              if(null == var46) {
                                 continue;
                              }

                              if((var46.x & 127) == 64 && (var46.y & 127) == 64) {
                                 for(var27 = 0; var27 < Client.field322; ++var27) {
                                    var37 = Client.cachedNPCs[Client.field483[var27]];
                                    if(var37 != null && var37.composition.field3007 == 1 && var46.x == var37.x && var37.y == var46.y) {
                                       FileOnDisk.method1384(var37.composition, Client.field483[var27], var22, var23);
                                    }
                                 }

                                 var27 = class45.field888;
                                 var53 = class45.field892;

                                 for(var48 = 0; var48 < var27; ++var48) {
                                    var38 = Client.cachedPlayers[var53[var48]];
                                    if(var38 != null && var38 != var46 && var38.x == var46.x && var46.y == var38.y) {
                                       class11.method151(var38, var53[var48], var22, var23);
                                    }
                                 }
                              }

                              if(Client.field412 != var25) {
                                 class11.method151(var46, var25, var22, var23);
                              } else {
                                 var18 = var52;
                              }
                           }

                           if(var36 == 3) {
                              Deque var47 = Client.groundItemDeque[class60.plane][var22][var23];
                              if(var47 != null) {
                                 for(Item var51 = (Item)var47.method2392(); null != var51; var51 = (Item)var47.method2390()) {
                                    ItemComposition var54 = class88.getItemDefinition(var51.id);
                                    if(Client.field447 == 1) {
                                       GroundObject.addMenuEntry("Use", Client.field468 + " " + "->" + " " + class32.method691(16748608) + var54.name, 16, var51.id, var22, var23);
                                    } else if(Client.field435) {
                                       if((class214.field3158 & 1) == 1) {
                                          GroundObject.addMenuEntry(Client.field438, Client.field282 + " " + "->" + " " + class32.method691(16748608) + var54.name, 17, var51.id, var22, var23);
                                       }
                                    } else {
                                       String[] var39 = var54.groundActions;
                                       if(Client.field300) {
                                          var39 = class8.method112(var39);
                                       }

                                       for(int var30 = 4; var30 >= 0; --var30) {
                                          if(var39 != null && var39[var30] != null) {
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

                                             GroundObject.addMenuEntry(var39[var30], class32.method691(16748608) + var54.name, var31, var51.id, var22, var23);
                                          } else if(var30 == 2) {
                                             GroundObject.addMenuEntry("Take", class32.method691(16748608) + var54.name, 20, var51.id, var22, var23);
                                          }
                                       }

                                       GroundObject.addMenuEntry("Examine", class32.method691(16748608) + var54.name, 1004, var51.id, var22, var23);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var18 != -1) {
                        var44 = var18 & 127;
                        var52 = var18 >> 7 & 127;
                        Player var55 = Client.cachedPlayers[Client.field412];
                        class11.method151(var55, Client.field412, var44, var52);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  if((Client.field543 == 0 || Client.field543 == 3) && (class115.field1794 == 1 || !GroundObject.field1297 && class115.field1794 == 4)) {
                     class164 var50 = var9.method3173(true);
                     if(var50 != null) {
                        var19 = class115.field1791 - var10;
                        var44 = class115.field1796 - var11;
                        if(var50.method3114(var19, var44)) {
                           var19 -= var50.field2143 / 2;
                           var44 -= var50.field2139 / 2;
                           var52 = Client.mapAngle + Client.mapScale & 2047;
                           var22 = class84.field1438[var52];
                           var23 = class84.field1428[var52];
                           var22 = var22 * (256 + Client.mapScaleDelta) >> 8;
                           var23 = var23 * (256 + Client.mapScaleDelta) >> 8;
                           var36 = var23 * var19 + var44 * var22 >> 11;
                           var25 = var23 * var44 - var19 * var22 >> 11;
                           int var41 = var36 + class148.localPlayer.x >> 7;
                           var27 = class148.localPlayer.y - var25 >> 7;
                           Client.field326.method3029(93);
                           Client.field326.method2760(18);
                           Client.field326.method2800(class105.field1700[82]?(class105.field1700[81]?2:1):0);
                           Client.field326.method2942(FrameMap.baseX + var41);
                           Client.field326.method2809(var27 + XItemContainer.baseY);
                           Client.field326.method2760(var19);
                           Client.field326.method2760(var44);
                           Client.field326.method2918(Client.mapAngle);
                           Client.field326.method2760(57);
                           Client.field326.method2760(Client.mapScale);
                           Client.field326.method2760(Client.mapScaleDelta);
                           Client.field326.method2760(89);
                           Client.field326.method2918(class148.localPlayer.x);
                           Client.field326.method2918(class148.localPlayer.y);
                           Client.field326.method2760(63);
                           Client.flagX = var41;
                           Client.flagY = var27;
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

                     WidgetNode var32 = (WidgetNode)Client.componentTable.method2339((long)var9.id);
                     if(var32 != null) {
                        if(var32.field182 == 0 && class115.field1788 >= var12 && class115.field1789 >= var13 && class115.field1788 < var14 && class115.field1789 < var15 && !Client.isMenuOpen && !Client.field414) {
                           for(class18 var33 = (class18)Client.field479.method2391(); null != var33; var33 = (class18)Client.field479.method2393()) {
                              if(var33.field189) {
                                 var33.unlink();
                                 var33.field195.field2198 = false;
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

                        class183.method3352(var32.id, var12, var13, var14, var15, var10, var11);
                     }
                  }

                  if(var9.field2184) {
                     class18 var49;
                     if(!var9.field2204) {
                        if(var9.field2319 && class115.field1788 >= var12 && class115.field1789 >= var13 && class115.field1788 < var14 && class115.field1789 < var15) {
                           for(var49 = (class18)Client.field479.method2391(); null != var49; var49 = (class18)Client.field479.method2393()) {
                              if(var49.field189 && var49.field203 == var49.field195.field2286) {
                                 var49.unlink();
                              }
                           }
                        }
                     } else if(class115.field1788 >= var12 && class115.field1789 >= var13 && class115.field1788 < var14 && class115.field1789 < var15) {
                        for(var49 = (class18)Client.field479.method2391(); null != var49; var49 = (class18)Client.field479.method2393()) {
                           if(var49.field189) {
                              var49.unlink();
                              var49.field195.field2198 = false;
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

                     boolean var42;
                     if(class115.field1788 >= var12 && class115.field1789 >= var13 && class115.field1788 < var14 && class115.field1789 < var15) {
                        var42 = true;
                     } else {
                        var42 = false;
                     }

                     boolean var43 = false;
                     if((class115.field1787 == 1 || !GroundObject.field1297 && class115.field1787 == 4) && var42) {
                        var43 = true;
                     }

                     boolean var20 = false;
                     if((class115.field1794 == 1 || !GroundObject.field1297 && class115.field1794 == 4) && class115.field1791 >= var12 && class115.field1796 >= var13 && class115.field1791 < var14 && class115.field1796 < var15) {
                        var20 = true;
                     }

                     if(var20) {
                        WallObject.method1845(var9, class115.field1791 - var10, class115.field1796 - var11);
                     }

                     if(null != Client.field453 && var9 != Client.field453 && var42) {
                        var22 = GameObject.method1872(var9);
                        boolean var35 = (var22 >> 20 & 1) != 0;
                        if(var35) {
                           Client.field457 = var9;
                        }
                     }

                     if(var9 == Client.field454) {
                        Client.field458 = true;
                        Client.field490 = var10;
                        Client.field284 = var11;
                     }

                     if(var9.field2307) {
                        class18 var21;
                        if(var42 && Client.field524 != 0 && null != var9.field2286) {
                           var21 = new class18();
                           var21.field189 = true;
                           var21.field195 = var9;
                           var21.field190 = Client.field524;
                           var21.field203 = var9.field2286;
                           Client.field479.method2394(var21);
                        }

                        if(Client.field453 != null || null != class31.field715 || Client.isMenuOpen) {
                           var20 = false;
                           var43 = false;
                           var42 = false;
                        }

                        if(!var9.field2311 && var20) {
                           var9.field2311 = true;
                           if(null != var9.field2267) {
                              var21 = new class18();
                              var21.field189 = true;
                              var21.field195 = var9;
                              var21.field191 = class115.field1791 - var10;
                              var21.field190 = class115.field1796 - var11;
                              var21.field203 = var9.field2267;
                              Client.field479.method2394(var21);
                           }
                        }

                        if(var9.field2311 && var43 && null != var9.field2268) {
                           var21 = new class18();
                           var21.field189 = true;
                           var21.field195 = var9;
                           var21.field191 = class115.field1788 - var10;
                           var21.field190 = class115.field1789 - var11;
                           var21.field203 = var9.field2268;
                           Client.field479.method2394(var21);
                        }

                        if(var9.field2311 && !var43) {
                           var9.field2311 = false;
                           if(null != var9.field2269) {
                              var21 = new class18();
                              var21.field189 = true;
                              var21.field195 = var9;
                              var21.field191 = class115.field1788 - var10;
                              var21.field190 = class115.field1789 - var11;
                              var21.field203 = var9.field2269;
                              Client.field325.method2394(var21);
                           }
                        }

                        if(var43 && var9.field2270 != null) {
                           var21 = new class18();
                           var21.field189 = true;
                           var21.field195 = var9;
                           var21.field191 = class115.field1788 - var10;
                           var21.field190 = class115.field1789 - var11;
                           var21.field203 = var9.field2270;
                           Client.field479.method2394(var21);
                        }

                        if(!var9.field2198 && var42) {
                           var9.field2198 = true;
                           if(null != var9.field2271) {
                              var21 = new class18();
                              var21.field189 = true;
                              var21.field195 = var9;
                              var21.field191 = class115.field1788 - var10;
                              var21.field190 = class115.field1789 - var11;
                              var21.field203 = var9.field2271;
                              Client.field479.method2394(var21);
                           }
                        }

                        if(var9.field2198 && var42 && null != var9.field2232) {
                           var21 = new class18();
                           var21.field189 = true;
                           var21.field195 = var9;
                           var21.field191 = class115.field1788 - var10;
                           var21.field190 = class115.field1789 - var11;
                           var21.field203 = var9.field2232;
                           Client.field479.method2394(var21);
                        }

                        if(var9.field2198 && !var42) {
                           var9.field2198 = false;
                           if(null != var9.field2273) {
                              var21 = new class18();
                              var21.field189 = true;
                              var21.field195 = var9;
                              var21.field191 = class115.field1788 - var10;
                              var21.field190 = class115.field1789 - var11;
                              var21.field203 = var9.field2273;
                              Client.field325.method2394(var21);
                           }
                        }

                        if(null != var9.field2272) {
                           var21 = new class18();
                           var21.field195 = var9;
                           var21.field203 = var9.field2272;
                           Client.field480.method2394(var21);
                        }

                        class18 var24;
                        if(var9.field2303 != null && Client.field467 > var9.field2313) {
                           if(null != var9.field2192 && Client.field467 - var9.field2313 <= 32) {
                              label1167:
                              for(var52 = var9.field2313; var52 < Client.field467; ++var52) {
                                 var22 = Client.field287[var52 & 31];

                                 for(var23 = 0; var23 < var9.field2192.length; ++var23) {
                                    if(var9.field2192[var23] == var22) {
                                       var24 = new class18();
                                       var24.field195 = var9;
                                       var24.field203 = var9.field2303;
                                       Client.field479.method2394(var24);
                                       break label1167;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class18();
                              var21.field195 = var9;
                              var21.field203 = var9.field2303;
                              Client.field479.method2394(var21);
                           }

                           var9.field2313 = Client.field467;
                        }

                        if(null != var9.field2175 && Client.field469 > var9.field2314) {
                           if(var9.field2281 != null && Client.field469 - var9.field2314 <= 32) {
                              label1143:
                              for(var52 = var9.field2314; var52 < Client.field469; ++var52) {
                                 var22 = Client.field471[var52 & 31];

                                 for(var23 = 0; var23 < var9.field2281.length; ++var23) {
                                    if(var9.field2281[var23] == var22) {
                                       var24 = new class18();
                                       var24.field195 = var9;
                                       var24.field203 = var9.field2175;
                                       Client.field479.method2394(var24);
                                       break label1143;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class18();
                              var21.field195 = var9;
                              var21.field203 = var9.field2175;
                              Client.field479.method2394(var21);
                           }

                           var9.field2314 = Client.field469;
                        }

                        if(null != var9.field2282 && Client.field344 > var9.field2315) {
                           if(var9.field2249 != null && Client.field344 - var9.field2315 <= 32) {
                              label1119:
                              for(var52 = var9.field2315; var52 < Client.field344; ++var52) {
                                 var22 = Client.field470[var52 & 31];

                                 for(var23 = 0; var23 < var9.field2249.length; ++var23) {
                                    if(var22 == var9.field2249[var23]) {
                                       var24 = new class18();
                                       var24.field195 = var9;
                                       var24.field203 = var9.field2282;
                                       Client.field479.method2394(var24);
                                       break label1119;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class18();
                              var21.field195 = var9;
                              var21.field203 = var9.field2282;
                              Client.field479.method2394(var21);
                           }

                           var9.field2315 = Client.field344;
                        }

                        if(Client.field289 > var9.field2312 && var9.field2287 != null) {
                           var21 = new class18();
                           var21.field195 = var9;
                           var21.field203 = var9.field2287;
                           Client.field479.method2394(var21);
                        }

                        if(Client.field460 > var9.field2312 && var9.field2179 != null) {
                           var21 = new class18();
                           var21.field195 = var9;
                           var21.field203 = var9.field2179;
                           Client.field479.method2394(var21);
                        }

                        if(Client.field474 > var9.field2312 && null != var9.field2290) {
                           var21 = new class18();
                           var21.field195 = var9;
                           var21.field203 = var9.field2290;
                           Client.field479.method2394(var21);
                        }

                        if(Client.field549 > var9.field2312 && null != var9.field2295) {
                           var21 = new class18();
                           var21.field195 = var9;
                           var21.field203 = var9.field2295;
                           Client.field479.method2394(var21);
                        }

                        if(Client.field476 > var9.field2312 && var9.field2296 != null) {
                           var21 = new class18();
                           var21.field195 = var9;
                           var21.field203 = var9.field2296;
                           Client.field479.method2394(var21);
                        }

                        if(Client.field477 > var9.field2312 && null != var9.field2291) {
                           var21 = new class18();
                           var21.field195 = var9;
                           var21.field203 = var9.field2291;
                           Client.field479.method2394(var21);
                        }

                        var9.field2312 = Client.field446;
                        if(null != var9.field2288) {
                           for(var52 = 0; var52 < Client.field503; ++var52) {
                              class18 var40 = new class18();
                              var40.field195 = var9;
                              var40.field201 = Client.field505[var52];
                              var40.field193 = Client.field504[var52];
                              var40.field203 = var9.field2288;
                              Client.field479.method2394(var40);
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
