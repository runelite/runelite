import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
public class class195 extends CacheableNode {
   @ObfuscatedName("l")
   public static NodeCache field2861 = new NodeCache(64);
   @ObfuscatedName("i")
   public char field2862;
   @ObfuscatedName("t")
   public char field2863;
   @ObfuscatedName("k")
   public String field2864 = "null";
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1215395759
   )
   public int field2865;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -612621765
   )
   public int field2866 = 0;
   @ObfuscatedName("a")
   public int[] field2867;
   @ObfuscatedName("f")
   public int[] field2868;
   @ObfuscatedName("r")
   public String[] field2869;
   @ObfuscatedName("b")
   public static class182 field2870;
   @ObfuscatedName("bc")
   static class184 field2871;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "849562405"
   )
   public void method3630(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3632(var1, var2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;ZLFont;I)V",
      garbageValue = "1258996228"
   )
   public static void method3631(class182 var0, class182 var1, boolean var2, Font var3) {
      ItemComposition.field2954 = var0;
      class38.field796 = var1;
      ItemComposition.isMembersWorld = var2;
      class174.field2637 = ItemComposition.field2954.method3398(10);
      FrameMap.field1457 = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1288205310"
   )
   void method3632(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2862 = (char)var1.readUnsignedByte();
      } else if(var2 == 2) {
         this.field2863 = (char)var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2864 = var1.readString();
      } else if(var2 == 4) {
         this.field2865 = var1.readInt();
      } else {
         int var3;
         if(var2 == 5) {
            this.field2866 = var1.readUnsignedShort();
            this.field2868 = new int[this.field2866];
            this.field2869 = new String[this.field2866];

            for(var3 = 0; var3 < this.field2866; ++var3) {
               this.field2868[var3] = var1.readInt();
               this.field2869[var3] = var1.readString();
            }
         } else if(var2 == 6) {
            this.field2866 = var1.readUnsignedShort();
            this.field2868 = new int[this.field2866];
            this.field2867 = new int[this.field2866];

            for(var3 = 0; var3 < this.field2866; ++var3) {
               this.field2868[var3] = var1.readInt();
               this.field2867[var3] = var1.readInt();
            }
         }
      }

   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIII)V",
      garbageValue = "2083049849"
   )
   static final void method3638(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2276 || class8.method112(var9) != 0 || Client.field459 == var9 || var9.contentType == 1338) && var1 == var9.parentId && (!var9.hasScript || !Client.method611(var9))) {
            int var10 = var6 + var9.relativeX;
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
               var18 = var9.width + var10;
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
               var16 = var9.width + var10;
               var17 = var9.height + var11;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(Client.field458 == var9) {
               Client.field419 = true;
               Client.field424 = var10;
               Client.field468 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = class115.field1802;
               var17 = class115.field1801;
               if(class115.field1796 != 0) {
                  var16 = class115.field1808;
                  var17 = class115.field1798;
               }

               if(var9.contentType == 1337) {
                  if(!Client.field547 && !Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     class72.method1449(var16, var17, var12, var13);
                  }
               } else if(var9.contentType == 1338) {
                  class3.method32(var9, var10, var11);
               } else {
                  int var22;
                  int var23;
                  int var34;
                  if(!Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     var18 = var16 - var10;
                     var19 = var17 - var11;
                     if(var9.field2199 == 1) {
                        class164.addMenuEntry(var9.tooltip, "", 24, 0, 0, var9.id);
                     }

                     String var32;
                     if(var9.field2199 == 2 && !Client.field549) {
                        var32 = class37.method807(var9);
                        if(var32 != null) {
                           class164.addMenuEntry(var32, class187.method3515('\uff00') + var9.field2312, 25, 0, -1, var9.id);
                        }
                     }

                     if(var9.field2199 == 3) {
                        class164.addMenuEntry("Close", "", 26, 0, 0, var9.id);
                     }

                     if(var9.field2199 == 4) {
                        class164.addMenuEntry(var9.tooltip, "", 28, 0, 0, var9.id);
                     }

                     if(var9.field2199 == 5) {
                        class164.addMenuEntry(var9.tooltip, "", 29, 0, 0, var9.id);
                     }

                     if(var9.field2199 == 6 && Client.field546 == null) {
                        class164.addMenuEntry(var9.tooltip, "", 30, 0, -1, var9.id);
                     }

                     int var20;
                     if(var9.type == 2) {
                        var20 = 0;

                        for(var34 = 0; var34 < var9.height; ++var34) {
                           for(var22 = 0; var22 < var9.width; ++var22) {
                              var23 = (var9.field2259 + 32) * var22;
                              int var24 = var34 * (32 + var9.field2313);
                              if(var20 < 20) {
                                 var23 += var9.field2264[var20];
                                 var24 += var9.field2319[var20];
                              }

                              if(var18 >= var23 && var19 >= var24 && var18 < var23 + 32 && var19 < 32 + var24) {
                                 Client.field284 = var20;
                                 WallObject.field1534 = var9;
                                 if(var9.itemIds[var20] > 0) {
                                    ItemComposition var25 = class168.getItemDefinition(var9.itemIds[var20] - 1);
                                    if(Client.field438 == 1 && class45.method899(class8.method112(var9))) {
                                       if(var9.id != XGrandExchangeOffer.field42 || class109.field1732 != var20) {
                                          class164.addMenuEntry("Use", Client.field439 + " " + "->" + " " + class187.method3515(16748608) + var25.name, 31, var25.id, var20, var9.id);
                                       }
                                    } else if(Client.field549 && class45.method899(class8.method112(var9))) {
                                       if((class137.field1908 & 16) == 16) {
                                          class164.addMenuEntry(Client.field328, Client.field350 + " " + "->" + " " + class187.method3515(16748608) + var25.name, 32, var25.id, var20, var9.id);
                                       }
                                    } else {
                                       String[] var26 = var25.inventoryActions;
                                       if(Client.field456) {
                                          var26 = class155.method3078(var26);
                                       }

                                       int var27 = var25.method3737();
                                       int var28;
                                       boolean var29;
                                       byte var30;
                                       if(class45.method899(class8.method112(var9))) {
                                          for(var28 = 4; var28 >= 3; --var28) {
                                             var29 = var27 == var28;
                                             if(var26 != null && null != var26[var28]) {
                                                if(var28 == 3) {
                                                   var30 = 36;
                                                } else {
                                                   var30 = 37;
                                                }

                                                class47.method945(var26[var28], class187.method3515(16748608) + var25.name, var30, var25.id, var20, var9.id, var29);
                                             } else if(var28 == 4) {
                                                class47.method945("Drop", class187.method3515(16748608) + var25.name, 37, var25.id, var20, var9.id, var29);
                                             }
                                          }
                                       }

                                       if(class63.method1215(class8.method112(var9))) {
                                          class164.addMenuEntry("Use", class187.method3515(16748608) + var25.name, 38, var25.id, var20, var9.id);
                                       }

                                       if(class45.method899(class8.method112(var9)) && null != var26) {
                                          for(var28 = 2; var28 >= 0; --var28) {
                                             var29 = var28 == var27;
                                             if(null != var26[var28]) {
                                                var30 = 0;
                                                if(var28 == 0) {
                                                   var30 = 33;
                                                }

                                                if(var28 == 1) {
                                                   var30 = 34;
                                                }

                                                if(var28 == 2) {
                                                   var30 = 35;
                                                }

                                                class47.method945(var26[var28], class187.method3515(16748608) + var25.name, var30, var25.id, var20, var9.id, var29);
                                             }
                                          }
                                       }

                                       var26 = var9.field2187;
                                       if(Client.field456) {
                                          var26 = class155.method3078(var26);
                                       }

                                       if(var26 != null) {
                                          for(var28 = 4; var28 >= 0; --var28) {
                                             if(null != var26[var28]) {
                                                byte var42 = 0;
                                                if(var28 == 0) {
                                                   var42 = 39;
                                                }

                                                if(var28 == 1) {
                                                   var42 = 40;
                                                }

                                                if(var28 == 2) {
                                                   var42 = 41;
                                                }

                                                if(var28 == 3) {
                                                   var42 = 42;
                                                }

                                                if(var28 == 4) {
                                                   var42 = 43;
                                                }

                                                class164.addMenuEntry(var26[var28], class187.method3515(16748608) + var25.name, var42, var25.id, var20, var9.id);
                                             }
                                          }
                                       }

                                       class164.addMenuEntry("Examine", class187.method3515(16748608) + var25.name, 1005, var25.id, var20, var9.id);
                                    }
                                 }
                              }

                              ++var20;
                           }
                        }
                     }

                     if(var9.hasScript) {
                        if(Client.field549) {
                           if(class37.method806(class8.method112(var9)) && (class137.field1908 & 32) == 32) {
                              class164.addMenuEntry(Client.field328, Client.field350 + " " + "->" + " " + var9.name, 58, 0, var9.index, var9.id);
                           }
                        } else {
                           for(var20 = 9; var20 >= 5; --var20) {
                              String var21;
                              if(!class188.method3518(class8.method112(var9), var20) && null == var9.field2288) {
                                 var21 = null;
                              } else if(var9.actions != null && var9.actions.length > var20 && null != var9.actions[var20] && var9.actions[var20].trim().length() != 0) {
                                 var21 = var9.actions[var20];
                              } else {
                                 var21 = null;
                              }

                              if(null != var21) {
                                 class164.addMenuEntry(var21, var9.name, 1007, 1 + var20, var9.index, var9.id);
                              }
                           }

                           var32 = class37.method807(var9);
                           if(var32 != null) {
                              class164.addMenuEntry(var32, var9.name, 25, 0, var9.index, var9.id);
                           }

                           for(var34 = 4; var34 >= 0; --var34) {
                              String var35;
                              if(!class188.method3518(class8.method112(var9), var34) && null == var9.field2288) {
                                 var35 = null;
                              } else if(var9.actions != null && var9.actions.length > var34 && null != var9.actions[var34] && var9.actions[var34].trim().length() != 0) {
                                 var35 = var9.actions[var34];
                              } else {
                                 var35 = null;
                              }

                              if(var35 != null) {
                                 class164.addMenuEntry(var35, var9.name, 57, 1 + var34, var9.index, var9.id);
                              }
                           }

                           var22 = class8.method112(var9);
                           boolean var44 = (var22 & 1) != 0;
                           if(var44) {
                              class164.addMenuEntry("Continue", "", 30, 0, var9.index, var9.id);
                           }
                        }
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && Client.method611(var9) && class45.field896 != var9) {
                        continue;
                     }

                     method3638(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method3638(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var33 = (WidgetNode)Client.componentTable.method2428((long)var9.id);
                     if(null != var33) {
                        if(var33.field179 == 0 && class115.field1802 >= var12 && class115.field1801 >= var13 && class115.field1802 < var14 && class115.field1801 < var15 && !Client.isMenuOpen && !Client.field455) {
                           for(class18 var31 = (class18)Client.field484.method2472(); null != var31; var31 = (class18)Client.field484.method2479()) {
                              if(var31.field186) {
                                 var31.unlink();
                                 var31.field185.field2215 = false;
                              }
                           }

                           if(class138.field1919 == 0) {
                              Client.field458 = null;
                              Client.field459 = null;
                           }

                           if(!Client.isMenuOpen) {
                              FloorUnderlayDefinition.method3569();
                           }
                        }

                        class108.method2098(var33.id, var12, var13, var14, var15, var10, var11);
                     }
                  }

                  if(var9.hasScript) {
                     class18 var43;
                     if(!var9.field2280) {
                        if(var9.field2210 && class115.field1802 >= var12 && class115.field1801 >= var13 && class115.field1802 < var14 && class115.field1801 < var15) {
                           for(var43 = (class18)Client.field484.method2472(); var43 != null; var43 = (class18)Client.field484.method2479()) {
                              if(var43.field186 && var43.field197 == var43.field185.field2258) {
                                 var43.unlink();
                              }
                           }
                        }
                     } else if(class115.field1802 >= var12 && class115.field1801 >= var13 && class115.field1802 < var14 && class115.field1801 < var15) {
                        for(var43 = (class18)Client.field484.method2472(); var43 != null; var43 = (class18)Client.field484.method2479()) {
                           if(var43.field186) {
                              var43.unlink();
                              var43.field185.field2215 = false;
                           }
                        }

                        if(class138.field1919 == 0) {
                           Client.field458 = null;
                           Client.field459 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.menuOptionCount = 1;
                        }
                     }

                     boolean var38;
                     if(class115.field1802 >= var12 && class115.field1801 >= var13 && class115.field1802 < var14 && class115.field1801 < var15) {
                        var38 = true;
                     } else {
                        var38 = false;
                     }

                     boolean var39 = false;
                     if((class115.field1809 == 1 || !class36.field769 && class115.field1809 == 4) && var38) {
                        var39 = true;
                     }

                     boolean var40 = false;
                     if((class115.field1796 == 1 || !class36.field769 && class115.field1796 == 4) && class115.field1808 >= var12 && class115.field1798 >= var13 && class115.field1808 < var14 && class115.field1798 < var15) {
                        var40 = true;
                     }

                     if(var40) {
                        FileOnDisk.method1487(var9, class115.field1808 - var10, class115.field1798 - var11);
                     }

                     if(Client.field458 != null && Client.field458 != var9 && var38 && class49.method969(class8.method112(var9))) {
                        Client.field563 = var9;
                     }

                     if(var9 == Client.field459) {
                        Client.field463 = true;
                        Client.field506 = var10;
                        Client.field465 = var11;
                     }

                     if(var9.field2276) {
                        class18 var41;
                        if(var38 && Client.field483 != 0 && null != var9.field2258) {
                           var41 = new class18();
                           var41.field186 = true;
                           var41.field185 = var9;
                           var41.field189 = Client.field483;
                           var41.field197 = var9.field2258;
                           Client.field484.method2468(var41);
                        }

                        if(Client.field458 != null || null != class5.field50 || Client.isMenuOpen) {
                           var40 = false;
                           var39 = false;
                           var38 = false;
                        }

                        if(!var9.field2224 && var40) {
                           var9.field2224 = true;
                           if(null != var9.field2186) {
                              var41 = new class18();
                              var41.field186 = true;
                              var41.field185 = var9;
                              var41.field196 = class115.field1808 - var10;
                              var41.field189 = class115.field1798 - var11;
                              var41.field197 = var9.field2186;
                              Client.field484.method2468(var41);
                           }
                        }

                        if(var9.field2224 && var39 && null != var9.field2279) {
                           var41 = new class18();
                           var41.field186 = true;
                           var41.field185 = var9;
                           var41.field196 = class115.field1802 - var10;
                           var41.field189 = class115.field1801 - var11;
                           var41.field197 = var9.field2279;
                           Client.field484.method2468(var41);
                        }

                        if(var9.field2224 && !var39) {
                           var9.field2224 = false;
                           if(null != var9.field2327) {
                              var41 = new class18();
                              var41.field186 = true;
                              var41.field185 = var9;
                              var41.field196 = class115.field1802 - var10;
                              var41.field189 = class115.field1801 - var11;
                              var41.field197 = var9.field2327;
                              Client.field486.method2468(var41);
                           }
                        }

                        if(var39 && var9.field2330 != null) {
                           var41 = new class18();
                           var41.field186 = true;
                           var41.field185 = var9;
                           var41.field196 = class115.field1802 - var10;
                           var41.field189 = class115.field1801 - var11;
                           var41.field197 = var9.field2330;
                           Client.field484.method2468(var41);
                        }

                        if(!var9.field2215 && var38) {
                           var9.field2215 = true;
                           if(var9.field2282 != null) {
                              var41 = new class18();
                              var41.field186 = true;
                              var41.field185 = var9;
                              var41.field196 = class115.field1802 - var10;
                              var41.field189 = class115.field1801 - var11;
                              var41.field197 = var9.field2282;
                              Client.field484.method2468(var41);
                           }
                        }

                        if(var9.field2215 && var38 && var9.field2267 != null) {
                           var41 = new class18();
                           var41.field186 = true;
                           var41.field185 = var9;
                           var41.field196 = class115.field1802 - var10;
                           var41.field189 = class115.field1801 - var11;
                           var41.field197 = var9.field2267;
                           Client.field484.method2468(var41);
                        }

                        if(var9.field2215 && !var38) {
                           var9.field2215 = false;
                           if(var9.field2241 != null) {
                              var41 = new class18();
                              var41.field186 = true;
                              var41.field185 = var9;
                              var41.field196 = class115.field1802 - var10;
                              var41.field189 = class115.field1801 - var11;
                              var41.field197 = var9.field2241;
                              Client.field486.method2468(var41);
                           }
                        }

                        if(var9.field2295 != null) {
                           var41 = new class18();
                           var41.field185 = var9;
                           var41.field197 = var9.field2295;
                           Client.field485.method2468(var41);
                        }

                        class18 var37;
                        if(null != var9.field2289 && Client.field569 > var9.field2324) {
                           if(var9.field2290 != null && Client.field569 - var9.field2324 <= 32) {
                              label1000:
                              for(var34 = var9.field2324; var34 < Client.field569; ++var34) {
                                 var22 = Client.field471[var34 & 31];

                                 for(var23 = 0; var23 < var9.field2290.length; ++var23) {
                                    if(var9.field2290[var23] == var22) {
                                       var37 = new class18();
                                       var37.field185 = var9;
                                       var37.field197 = var9.field2289;
                                       Client.field484.method2468(var37);
                                       break label1000;
                                    }
                                 }
                              }
                           } else {
                              var41 = new class18();
                              var41.field185 = var9;
                              var41.field197 = var9.field2289;
                              Client.field484.method2468(var41);
                           }

                           var9.field2324 = Client.field569;
                        }

                        if(var9.field2291 != null && Client.field474 > var9.field2325) {
                           if(null != var9.field2292 && Client.field474 - var9.field2325 <= 32) {
                              label976:
                              for(var34 = var9.field2325; var34 < Client.field474; ++var34) {
                                 var22 = Client.interfaceItemTriggers[var34 & 31];

                                 for(var23 = 0; var23 < var9.field2292.length; ++var23) {
                                    if(var22 == var9.field2292[var23]) {
                                       var37 = new class18();
                                       var37.field185 = var9;
                                       var37.field197 = var9.field2291;
                                       Client.field484.method2468(var37);
                                       break label976;
                                    }
                                 }
                              }
                           } else {
                              var41 = new class18();
                              var41.field185 = var9;
                              var41.field197 = var9.field2291;
                              Client.field484.method2468(var41);
                           }

                           var9.field2325 = Client.field474;
                        }

                        if(null != var9.field2293 && Client.field476 > var9.field2326) {
                           if(null != var9.field2294 && Client.field476 - var9.field2326 <= 32) {
                              label952:
                              for(var34 = var9.field2326; var34 < Client.field476; ++var34) {
                                 var22 = Client.field475[var34 & 31];

                                 for(var23 = 0; var23 < var9.field2294.length; ++var23) {
                                    if(var22 == var9.field2294[var23]) {
                                       var37 = new class18();
                                       var37.field185 = var9;
                                       var37.field197 = var9.field2293;
                                       Client.field484.method2468(var37);
                                       break label952;
                                    }
                                 }
                              }
                           } else {
                              var41 = new class18();
                              var41.field185 = var9;
                              var41.field197 = var9.field2293;
                              Client.field484.method2468(var41);
                           }

                           var9.field2326 = Client.field476;
                        }

                        if(Client.field443 > var9.field2323 && null != var9.field2296) {
                           var41 = new class18();
                           var41.field185 = var9;
                           var41.field197 = var9.field2296;
                           Client.field484.method2468(var41);
                        }

                        if(Client.field285 > var9.field2323 && var9.field2265 != null) {
                           var41 = new class18();
                           var41.field185 = var9;
                           var41.field197 = var9.field2265;
                           Client.field484.method2468(var41);
                        }

                        if(Client.field513 > var9.field2323 && null != var9.field2301) {
                           var41 = new class18();
                           var41.field185 = var9;
                           var41.field197 = var9.field2301;
                           Client.field484.method2468(var41);
                        }

                        if(Client.field480 > var9.field2323 && null != var9.field2306) {
                           var41 = new class18();
                           var41.field185 = var9;
                           var41.field197 = var9.field2306;
                           Client.field484.method2468(var41);
                        }

                        if(Client.field481 > var9.field2323 && var9.field2307 != null) {
                           var41 = new class18();
                           var41.field185 = var9;
                           var41.field197 = var9.field2307;
                           Client.field484.method2468(var41);
                        }

                        if(Client.field482 > var9.field2323 && null != var9.field2302) {
                           var41 = new class18();
                           var41.field185 = var9;
                           var41.field197 = var9.field2302;
                           Client.field484.method2468(var41);
                        }

                        var9.field2323 = Client.field470;
                        if(var9.field2299 != null) {
                           for(var34 = 0; var34 < Client.field508; ++var34) {
                              class18 var45 = new class18();
                              var45.field185 = var9;
                              var45.field191 = Client.field510[var34];
                              var45.field195 = Client.field509[var34];
                              var45.field197 = var9.field2299;
                              Client.field484.method2468(var45);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && null == Client.field458 && null == class5.field50 && !Client.isMenuOpen) {
                     if((var9.field2317 >= 0 || var9.field2223 != 0) && class115.field1802 >= var12 && class115.field1801 >= var13 && class115.field1802 < var14 && class115.field1801 < var15) {
                        if(var9.field2317 >= 0) {
                           class45.field896 = var0[var9.field2317];
                        } else {
                           class45.field896 = var9;
                        }
                     }

                     if(var9.type == 8 && class115.field1802 >= var12 && class115.field1801 >= var13 && class115.field1802 < var14 && class115.field1801 < var15) {
                        Ignore.field201 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        class2.method23(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, class115.field1802, class115.field1801);
                     }
                  }
               }
            }
         }
      }

   }
}
