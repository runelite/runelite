import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public abstract class class132 {
   @ObfuscatedName("v")
   @Export("worldServersDownload")
   static class26 worldServersDownload;
   @ObfuscatedName("cs")
   static RSSocket field1979;
   @ObfuscatedName("c")
   static boolean field1981 = false;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "0"
   )
   abstract byte[] vmethod2615();

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "339528659"
   )
   abstract void vmethod2616(byte[] var1);

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIII)V",
      garbageValue = "1167899144"
   )
   static final void method2624(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2285 || class103.method1988(var9) != 0 || var9 == Client.field496 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !ChatMessages.method857(var9))) {
            int var10 = var6 + var9.relativeX;
            int var11 = var9.relativeY + var7;
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
               int var18 = var9.width + var10;
               int var19 = var9.height + var11;
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
               var17 = var9.height + var11;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == Client.field458) {
               Client.field376 = true;
               Client.field467 = var10;
               Client.field397 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = class115.field1805;
               var17 = class115.field1806;
               if(class115.field1811 != 0) {
                  var16 = class115.field1802;
                  var17 = class115.field1813;
               }

               if(var9.contentType == 1337) {
                  if(!Client.field289 && !Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     class88.method1893(var16, var17, var12, var13);
                  }
               } else if(var9.contentType == 1338) {
                  GameEngine.method2191(var9, var10, var11);
               } else {
                  if(!Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     class128.method2365(var9, var16 - var10, var17 - var11);
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && ChatMessages.method857(var9) && ChatMessages.field920 != var9) {
                        continue;
                     }

                     method2624(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method2624(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var27 = (WidgetNode)Client.componentTable.method2773((long)var9.id);
                     if(var27 != null) {
                        if(var27.field179 == 0 && class115.field1805 >= var12 && class115.field1806 >= var13 && class115.field1805 < var14 && class115.field1806 < var15 && !Client.isMenuOpen && !Client.field455) {
                           for(class18 var28 = (class18)Client.field484.method2828(); var28 != null; var28 = (class18)Client.field484.method2830()) {
                              if(var28.field188) {
                                 var28.unlink();
                                 var28.field189.field2332 = false;
                              }
                           }

                           if(class99.field1638 == 0) {
                              Client.field458 = null;
                              Client.field496 = null;
                           }

                           if(!Client.isMenuOpen) {
                              class119.method2293();
                           }
                        }

                        class7.method101(var27.id, var12, var13, var14, var15, var10, var11);
                     }
                  }

                  if(var9.hasScript) {
                     class18 var31;
                     if(!var9.field2275) {
                        if(var9.field2203 && class115.field1805 >= var12 && class115.field1806 >= var13 && class115.field1805 < var14 && class115.field1806 < var15) {
                           for(var31 = (class18)Client.field484.method2828(); var31 != null; var31 = (class18)Client.field484.method2830()) {
                              if(var31.field188 && var31.field189.field2308 == var31.field196) {
                                 var31.unlink();
                              }
                           }
                        }
                     } else if(class115.field1805 >= var12 && class115.field1806 >= var13 && class115.field1805 < var14 && class115.field1806 < var15) {
                        for(var31 = (class18)Client.field484.method2828(); var31 != null; var31 = (class18)Client.field484.method2830()) {
                           if(var31.field188) {
                              var31.unlink();
                              var31.field189.field2332 = false;
                           }
                        }

                        if(class99.field1638 == 0) {
                           Client.field458 = null;
                           Client.field496 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.menuOptionCount = 1;
                        }
                     }

                     boolean var29;
                     if(class115.field1805 >= var12 && class115.field1806 >= var13 && class115.field1805 < var14 && class115.field1806 < var15) {
                        var29 = true;
                     } else {
                        var29 = false;
                     }

                     boolean var30 = false;
                     if((class115.field1799 == 1 || !CombatInfo1.field662 && class115.field1799 == 4) && var29) {
                        var30 = true;
                     }

                     boolean var20 = false;
                     if((class115.field1811 == 1 || !CombatInfo1.field662 && class115.field1811 == 4) && class115.field1802 >= var12 && class115.field1813 >= var13 && class115.field1802 < var14 && class115.field1813 < var15) {
                        var20 = true;
                     }

                     if(var20) {
                        class49.method919(var9, class115.field1802 - var10, class115.field1813 - var11);
                     }

                     if(Client.field458 != null && Client.field458 != var9 && var29 && Widget.method3242(class103.method1988(var9))) {
                        Client.field462 = var9;
                     }

                     if(Client.field496 == var9) {
                        Client.field463 = true;
                        Client.field380 = var10;
                        Client.field465 = var11;
                     }

                     if(var9.field2285) {
                        class18 var25;
                        if(var29 && Client.field483 != 0 && var9.field2308 != null) {
                           var25 = new class18();
                           var25.field188 = true;
                           var25.field189 = var9;
                           var25.field187 = Client.field483;
                           var25.field196 = var9.field2308;
                           Client.field484.method2824(var25);
                        }

                        if(Client.field458 != null || class97.field1627 != null || Client.isMenuOpen) {
                           var20 = false;
                           var30 = false;
                           var29 = false;
                        }

                        if(!var9.field2333 && var20) {
                           var9.field2333 = true;
                           if(var9.field2289 != null) {
                              var25 = new class18();
                              var25.field188 = true;
                              var25.field189 = var9;
                              var25.field193 = class115.field1802 - var10;
                              var25.field187 = class115.field1813 - var11;
                              var25.field196 = var9.field2289;
                              Client.field484.method2824(var25);
                           }
                        }

                        if(var9.field2333 && var30 && var9.field2209 != null) {
                           var25 = new class18();
                           var25.field188 = true;
                           var25.field189 = var9;
                           var25.field193 = class115.field1805 - var10;
                           var25.field187 = class115.field1806 - var11;
                           var25.field196 = var9.field2209;
                           Client.field484.method2824(var25);
                        }

                        if(var9.field2333 && !var30) {
                           var9.field2333 = false;
                           if(var9.field2302 != null) {
                              var25 = new class18();
                              var25.field188 = true;
                              var25.field189 = var9;
                              var25.field193 = class115.field1805 - var10;
                              var25.field187 = class115.field1806 - var11;
                              var25.field196 = var9.field2302;
                              Client.field486.method2824(var25);
                           }
                        }

                        if(var30 && var9.field2292 != null) {
                           var25 = new class18();
                           var25.field188 = true;
                           var25.field189 = var9;
                           var25.field193 = class115.field1805 - var10;
                           var25.field187 = class115.field1806 - var11;
                           var25.field196 = var9.field2292;
                           Client.field484.method2824(var25);
                        }

                        if(!var9.field2332 && var29) {
                           var9.field2332 = true;
                           if(var9.field2293 != null) {
                              var25 = new class18();
                              var25.field188 = true;
                              var25.field189 = var9;
                              var25.field193 = class115.field1805 - var10;
                              var25.field187 = class115.field1806 - var11;
                              var25.field196 = var9.field2293;
                              Client.field484.method2824(var25);
                           }
                        }

                        if(var9.field2332 && var29 && var9.field2294 != null) {
                           var25 = new class18();
                           var25.field188 = true;
                           var25.field189 = var9;
                           var25.field193 = class115.field1805 - var10;
                           var25.field187 = class115.field1806 - var11;
                           var25.field196 = var9.field2294;
                           Client.field484.method2824(var25);
                        }

                        if(var9.field2332 && !var29) {
                           var9.field2332 = false;
                           if(var9.field2295 != null) {
                              var25 = new class18();
                              var25.field188 = true;
                              var25.field189 = var9;
                              var25.field193 = class115.field1805 - var10;
                              var25.field187 = class115.field1806 - var11;
                              var25.field196 = var9.field2295;
                              Client.field486.method2824(var25);
                           }
                        }

                        if(var9.field2306 != null) {
                           var25 = new class18();
                           var25.field189 = var9;
                           var25.field196 = var9.field2306;
                           Client.field476.method2824(var25);
                        }

                        int var21;
                        int var22;
                        int var23;
                        class18 var24;
                        if(var9.field2300 != null && Client.field443 > var9.field2229) {
                           if(var9.field2301 != null && Client.field443 - var9.field2229 <= 32) {
                              label746:
                              for(var21 = var9.field2229; var21 < Client.field443; ++var21) {
                                 var22 = Client.field471[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2301.length; ++var23) {
                                    if(var22 == var9.field2301[var23]) {
                                       var24 = new class18();
                                       var24.field189 = var9;
                                       var24.field196 = var9.field2300;
                                       Client.field484.method2824(var24);
                                       break label746;
                                    }
                                 }
                              }
                           } else {
                              var25 = new class18();
                              var25.field189 = var9;
                              var25.field196 = var9.field2300;
                              Client.field484.method2824(var25);
                           }

                           var9.field2229 = Client.field443;
                        }

                        if(var9.field2269 != null && Client.field474 > var9.field2336) {
                           if(var9.field2264 != null && Client.field474 - var9.field2336 <= 32) {
                              label722:
                              for(var21 = var9.field2336; var21 < Client.field474; ++var21) {
                                 var22 = Client.interfaceItemTriggers[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2264.length; ++var23) {
                                    if(var22 == var9.field2264[var23]) {
                                       var24 = new class18();
                                       var24.field189 = var9;
                                       var24.field196 = var9.field2269;
                                       Client.field484.method2824(var24);
                                       break label722;
                                    }
                                 }
                              }
                           } else {
                              var25 = new class18();
                              var25.field189 = var9;
                              var25.field196 = var9.field2269;
                              Client.field484.method2824(var25);
                           }

                           var9.field2336 = Client.field474;
                        }

                        if(var9.field2304 != null && Client.field364 > var9.field2337) {
                           if(var9.field2305 != null && Client.field364 - var9.field2337 <= 32) {
                              label698:
                              for(var21 = var9.field2337; var21 < Client.field364; ++var21) {
                                 var22 = Client.field475[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2305.length; ++var23) {
                                    if(var22 == var9.field2305[var23]) {
                                       var24 = new class18();
                                       var24.field189 = var9;
                                       var24.field196 = var9.field2304;
                                       Client.field484.method2824(var24);
                                       break label698;
                                    }
                                 }
                              }
                           } else {
                              var25 = new class18();
                              var25.field189 = var9;
                              var25.field196 = var9.field2304;
                              Client.field484.method2824(var25);
                           }

                           var9.field2337 = Client.field364;
                        }

                        if(Client.field477 > var9.field2200 && var9.field2309 != null) {
                           var25 = new class18();
                           var25.field189 = var9;
                           var25.field196 = var9.field2309;
                           Client.field484.method2824(var25);
                        }

                        if(Client.field478 > var9.field2200 && var9.field2311 != null) {
                           var25 = new class18();
                           var25.field189 = var9;
                           var25.field196 = var9.field2311;
                           Client.field484.method2824(var25);
                        }

                        if(Client.field479 > var9.field2200 && var9.field2317 != null) {
                           var25 = new class18();
                           var25.field189 = var9;
                           var25.field196 = var9.field2317;
                           Client.field484.method2824(var25);
                        }

                        if(Client.field480 > var9.field2200 && var9.field2222 != null) {
                           var25 = new class18();
                           var25.field189 = var9;
                           var25.field196 = var9.field2222;
                           Client.field484.method2824(var25);
                        }

                        if(Client.field481 > var9.field2200 && var9.field2318 != null) {
                           var25 = new class18();
                           var25.field189 = var9;
                           var25.field196 = var9.field2318;
                           Client.field484.method2824(var25);
                        }

                        if(Client.field482 > var9.field2200 && var9.field2220 != null) {
                           var25 = new class18();
                           var25.field189 = var9;
                           var25.field196 = var9.field2220;
                           Client.field484.method2824(var25);
                        }

                        var9.field2200 = Client.field311;
                        if(var9.field2310 != null) {
                           for(var21 = 0; var21 < Client.field508; ++var21) {
                              class18 var26 = new class18();
                              var26.field189 = var9;
                              var26.field191 = Client.field510[var21];
                              var26.field198 = Client.field444[var21];
                              var26.field196 = var9.field2310;
                              Client.field484.method2824(var26);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.field458 == null && class97.field1627 == null && !Client.isMenuOpen) {
                     if((var9.field2322 >= 0 || var9.field2234 != 0) && class115.field1805 >= var12 && class115.field1806 >= var13 && class115.field1805 < var14 && class115.field1806 < var15) {
                        if(var9.field2322 >= 0) {
                           ChatMessages.field920 = var0[var9.field2322];
                        } else {
                           ChatMessages.field920 = var9;
                        }
                     }

                     if(var9.type == 8 && class115.field1805 >= var12 && class115.field1806 >= var13 && class115.field1805 < var14 && class115.field1806 < var15) {
                        class13.field142 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        class118.method2283(var9, var9.width + var10, var11, var9.height, var9.scrollHeight, class115.field1805, class115.field1806);
                     }
                  }
               }
            }
         }
      }

   }
}
