import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
public class class104 {
   @ObfuscatedName("l")
   public static class72 field1691 = null;
   @ObfuscatedName("t")
   public static String field1694;
   @ObfuscatedName("q")
   public static class72 field1695 = null;
   @ObfuscatedName("v")
   public static class72 field1696 = null;
   @ObfuscatedName("d")
   static File field1697;
   @ObfuscatedName("s")
   public static class72[] field1698;
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = 691090585
   )
   static int field1701;
   @ObfuscatedName("pf")
   static class1 field1702;

   class104() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2095347059"
   )
   static final void method2054() {
      if(Client.field327 > 1) {
         --Client.field327;
      }

      if(Client.field365 > 0) {
         --Client.field365;
      }

      if(Client.field587) {
         Client.field587 = false;
         class16.method203();
      } else {
         if(!Client.isMenuOpen) {
            Client.menuOptionCount = 0;
            Client.field391 = -1;
            Client.isMenuOpen = false;
            Client.menuOptions[0] = "Cancel";
            Client.menuTargets[0] = "";
            Client.menuTypes[0] = 1006;
            Client.menuOptionCount = 1;
         }

         int var0;
         for(var0 = 0; var0 < 100 && class142.method2717(); ++var0) {
            ;
         }

         if(Client.gameState == 30) {
            while(true) {
               ClassInfo var1 = (ClassInfo)class227.field3248.method2411();
               boolean var34;
               if(null == var1) {
                  var34 = false;
               } else {
                  var34 = true;
               }

               int var16;
               if(!var34) {
                  Object var17 = Client.field321.field253;
                  int var2;
                  int var3;
                  int var4;
                  int var5;
                  int var6;
                  int var7;
                  int var8;
                  synchronized(Client.field321.field253) {
                     if(!Client.field586) {
                        Client.field321.field254 = 0;
                     } else if(class115.field1813 != 0 || Client.field321.field254 >= 40) {
                        Client.field309.method3076(252);
                        Client.field309.method2843(0);
                        var16 = Client.field309.offset;
                        var2 = 0;

                        for(var3 = 0; var3 < Client.field321.field254 && Client.field309.offset - var16 < 240; ++var3) {
                           ++var2;
                           var4 = Client.field321.field250[var3];
                           if(var4 < 0) {
                              var4 = 0;
                           } else if(var4 > 502) {
                              var4 = 502;
                           }

                           var5 = Client.field321.field247[var3];
                           if(var5 < 0) {
                              var5 = 0;
                           } else if(var5 > 764) {
                              var5 = 764;
                           }

                           var6 = var5 + 765 * var4;
                           if(Client.field321.field250[var3] == -1 && Client.field321.field247[var3] == -1) {
                              var5 = -1;
                              var4 = -1;
                              var6 = 524287;
                           }

                           if(Client.field322 == var5 && var4 == Client.field323) {
                              if(Client.field314 < 2047) {
                                 ++Client.field314;
                              }
                           } else {
                              var7 = var5 - Client.field322;
                              Client.field322 = var5;
                              var8 = var4 - Client.field323;
                              Client.field323 = var4;
                              if(Client.field314 < 8 && var7 >= -32 && var7 <= 31 && var8 >= -32 && var8 <= 31) {
                                 var7 += 32;
                                 var8 += 32;
                                 Client.field309.method2817(var8 + (Client.field314 << 12) + (var7 << 6));
                                 Client.field314 = 0;
                              } else if(Client.field314 < 8) {
                                 Client.field309.method2818(8388608 + (Client.field314 << 19) + var6);
                                 Client.field314 = 0;
                              } else {
                                 Client.field309.method2819(-1073741824 + (Client.field314 << 19) + var6);
                                 Client.field314 = 0;
                              }
                           }
                        }

                        Client.field309.method2828(Client.field309.offset - var16);
                        if(var2 >= Client.field321.field254) {
                           Client.field321.field254 = 0;
                        } else {
                           Client.field321.field254 -= var2;

                           for(var3 = 0; var3 < Client.field321.field254; ++var3) {
                              Client.field321.field247[var3] = Client.field321.field247[var3 + var2];
                              Client.field321.field250[var3] = Client.field321.field250[var2 + var3];
                           }
                        }
                     }
                  }

                  if(class115.field1813 == 1 || !class202.field3076 && class115.field1813 == 4 || class115.field1813 == 2) {
                     long var18 = (class115.field1816 - Client.field320) / 50L;
                     if(var18 > 4095L) {
                        var18 = 4095L;
                     }

                     Client.field320 = class115.field1816;
                     var2 = class115.field1815;
                     if(var2 < 0) {
                        var2 = 0;
                     } else if(var2 > class145.field2018) {
                        var2 = class145.field2018;
                     }

                     var3 = class115.field1814;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > class108.field1748) {
                        var3 = class108.field1748;
                     }

                     var4 = (int)var18;
                     Client.field309.method3076(152);
                     Client.field309.method2817((class115.field1813 == 2?1:0) + (var4 << 1));
                     Client.field309.method2817(var3);
                     Client.field309.method2817(var2);
                  }

                  if(class105.field1716 > 0) {
                     Client.field309.method3076(217);
                     Client.field309.method2817(0);
                     var0 = Client.field309.offset;
                     long var20 = class99.method2005();

                     for(var3 = 0; var3 < class105.field1716; ++var3) {
                        long var22 = var20 - Client.field539;
                        if(var22 > 16777215L) {
                           var22 = 16777215L;
                        }

                        Client.field539 = var20;
                        Client.field309.method2871((int)var22);
                        Client.field309.method2843(class105.field1735[var3]);
                     }

                     Client.field309.method2945(Client.field309.offset - var0);
                  }

                  if(Client.field403 > 0) {
                     --Client.field403;
                  }

                  if(class105.field1725[96] || class105.field1725[97] || class105.field1725[98] || class105.field1725[99]) {
                     Client.field404 = true;
                  }

                  if(Client.field404 && Client.field403 <= 0) {
                     Client.field403 = 20;
                     Client.field404 = false;
                     Client.field309.method3076(213);
                     Client.field309.method2909(Client.field396);
                     Client.field309.method2909(Client.mapAngle);
                  }

                  if(class101.field1661 && !Client.field581) {
                     Client.field581 = true;
                     Client.field309.method3076(124);
                     Client.field309.method2843(1);
                  }

                  if(!class101.field1661 && Client.field581) {
                     Client.field581 = false;
                     Client.field309.method3076(124);
                     Client.field309.method2843(0);
                  }

                  int var10;
                  int var24;
                  if(class31.plane != Client.field543) {
                     Client.field543 = class31.plane;
                     var0 = class31.plane;
                     int[] var35 = Actor.field685.image;
                     var2 = var35.length;

                     for(var3 = 0; var3 < var2; ++var3) {
                        var35[var3] = 0;
                     }

                     for(var3 = 1; var3 < 103; ++var3) {
                        var4 = 24628 + 2048 * (103 - var3);

                        for(var5 = 1; var5 < 103; ++var5) {
                           if((class10.tileSettings[var0][var5][var3] & 24) == 0) {
                              Friend.region.method1869(var35, var4, 512, var0, var5, var3);
                           }

                           if(var0 < 3 && (class10.tileSettings[1 + var0][var5][var3] & 8) != 0) {
                              Friend.region.method1869(var35, var4, 512, var0 + 1, var5, var3);
                           }

                           var4 += 4;
                        }
                     }

                     var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
                     var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
                     Actor.field685.method4139();

                     for(var5 = 1; var5 < 103; ++var5) {
                        for(var6 = 1; var6 < 103; ++var6) {
                           if((class10.tileSettings[var0][var6][var5] & 24) == 0) {
                              class0.method12(var0, var6, var5, var3, var4);
                           }

                           if(var0 < 3 && (class10.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
                              class0.method12(var0 + 1, var6, var5, var3, var4);
                           }
                        }
                     }

                     Client.field585 = 0;

                     for(var5 = 0; var5 < 104; ++var5) {
                        for(var6 = 0; var6 < 104; ++var6) {
                           var7 = Friend.region.method1782(class31.plane, var5, var6);
                           if(var7 != 0) {
                              var7 = var7 >> 14 & 32767;
                              var8 = class195.getObjectDefinition(var7).mapIconId;
                              if(var8 >= 0) {
                                 var24 = var5;
                                 var10 = var6;
                                 if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                                    int[][] var13 = Client.collisionMaps[class31.plane].flags;

                                    for(int var14 = 0; var14 < 10; ++var14) {
                                       int var15 = (int)(Math.random() * 4.0D);
                                       if(var15 == 0 && var24 > 0 && var24 > var5 - 3 && (var13[var24 - 1][var10] & 19136776) == 0) {
                                          --var24;
                                       }

                                       if(var15 == 1 && var24 < 103 && var24 < var5 + 3 && (var13[var24 + 1][var10] & 19136896) == 0) {
                                          ++var24;
                                       }

                                       if(var15 == 2 && var10 > 0 && var10 > var6 - 3 && (var13[var24][var10 - 1] & 19136770) == 0) {
                                          --var10;
                                       }

                                       if(var15 == 3 && var10 < 103 && var10 < 3 + var6 && (var13[var24][var10 + 1] & 19136800) == 0) {
                                          ++var10;
                                       }
                                    }
                                 }

                                 Client.field546[Client.field585] = class172.field2335[var8];
                                 Client.field544[Client.field585] = var24;
                                 Client.field494[Client.field585] = var10;
                                 ++Client.field585;
                              }
                           }
                        }
                     }

                     Frames.bufferProvider.method4084();
                  }

                  if(Client.gameState != 30) {
                     return;
                  }

                  for(class25 var42 = (class25)Client.field444.method2448(); var42 != null; var42 = (class25)Client.field444.method2445()) {
                     if(var42.field596 > 0) {
                        --var42.field596;
                     }

                     if(var42.field596 == 0) {
                        if(var42.field604 < 0 || class10.method168(var42.field604, var42.field602)) {
                           XClanMember.method276(var42.field599, var42.field597, var42.field598, var42.field600, var42.field604, var42.field601, var42.field602);
                           var42.unlink();
                        }
                     } else {
                        if(var42.field606 > 0) {
                           --var42.field606;
                        }

                        if(var42.field606 == 0 && var42.field598 >= 1 && var42.field600 >= 1 && var42.field598 <= 102 && var42.field600 <= 102 && (var42.field612 < 0 || class10.method168(var42.field612, var42.field605))) {
                           XClanMember.method276(var42.field599, var42.field597, var42.field598, var42.field600, var42.field612, var42.field603, var42.field605);
                           var42.field606 = -1;
                           if(var42.field604 == var42.field612 && var42.field604 == -1) {
                              var42.unlink();
                           } else if(var42.field612 == var42.field604 && var42.field603 == var42.field601 && var42.field602 == var42.field605) {
                              var42.unlink();
                           }
                        }
                     }
                  }

                  class36.method804();
                  ++Client.field360;
                  if(Client.field360 > 750) {
                     class16.method203();
                     return;
                  }

                  class161.method3112();
                  class181.method3302();
                  class1.method20();
                  ++Client.field328;
                  if(Client.field423 != 0) {
                     Client.field548 += 20;
                     if(Client.field548 >= 400) {
                        Client.field423 = 0;
                     }
                  }

                  if(Tile.field1363 != null) {
                     ++Client.field425;
                     if(Client.field425 >= 15) {
                        class2.method36(Tile.field1363);
                        Tile.field1363 = null;
                     }
                  }

                  Widget var43 = class1.field16;
                  Widget var36 = FloorUnderlayDefinition.field2809;
                  class1.field16 = null;
                  FloorUnderlayDefinition.field2809 = null;
                  Client.field490 = null;
                  Client.field450 = false;
                  Client.field491 = false;
                  Client.field474 = 0;

                  while(GroundObject.method1593() && Client.field474 < 128) {
                     if(Client.field480 >= 2 && class105.field1725[82] && FileOnDisk.field1202 == 66) {
                        String var25 = "";

                        MessageNode var27;
                        for(Iterator var26 = class47.field951.iterator(); var26.hasNext(); var25 = var25 + var27.name + ':' + var27.value + '\n') {
                           var27 = (MessageNode)var26.next();
                        }

                        class25.field608.setContents(new StringSelection(var25), (ClipboardOwner)null);
                     } else {
                        Client.field538[Client.field474] = FileOnDisk.field1202;
                        Client.field537[Client.field474] = class157.field2108;
                        ++Client.field474;
                     }
                  }

                  if(Client.widgetRoot != -1) {
                     var2 = Client.widgetRoot;
                     var3 = class108.field1748;
                     var4 = class145.field2018;
                     if(class44.method892(var2)) {
                        class26.method604(Widget.widgets[var2], -1, 0, 0, var3, var4, 0, 0);
                     }
                  }

                  ++Client.field498;

                  while(true) {
                     class18 var28;
                     Widget var44;
                     Widget var45;
                     do {
                        var28 = (class18)Client.field513.method2446();
                        if(var28 == null) {
                           while(true) {
                              do {
                                 var28 = (class18)Client.field514.method2446();
                                 if(var28 == null) {
                                    while(true) {
                                       do {
                                          var28 = (class18)Client.field512.method2446();
                                          if(null == var28) {
                                             boolean var37 = false;

                                             while(!var37) {
                                                var37 = true;

                                                for(var3 = 0; var3 < Client.menuOptionCount - 1; ++var3) {
                                                   if(Client.menuTypes[var3] < 1000 && Client.menuTypes[1 + var3] > 1000) {
                                                      String var46 = Client.menuTargets[var3];
                                                      Client.menuTargets[var3] = Client.menuTargets[var3 + 1];
                                                      Client.menuTargets[var3 + 1] = var46;
                                                      String var47 = Client.menuOptions[var3];
                                                      Client.menuOptions[var3] = Client.menuOptions[1 + var3];
                                                      Client.menuOptions[1 + var3] = var47;
                                                      var6 = Client.menuTypes[var3];
                                                      Client.menuTypes[var3] = Client.menuTypes[1 + var3];
                                                      Client.menuTypes[var3 + 1] = var6;
                                                      var6 = Client.menuActionParams0[var3];
                                                      Client.menuActionParams0[var3] = Client.menuActionParams0[var3 + 1];
                                                      Client.menuActionParams0[1 + var3] = var6;
                                                      var6 = Client.menuActionParams1[var3];
                                                      Client.menuActionParams1[var3] = Client.menuActionParams1[var3 + 1];
                                                      Client.menuActionParams1[1 + var3] = var6;
                                                      var6 = Client.menuIdentifiers[var3];
                                                      Client.menuIdentifiers[var3] = Client.menuIdentifiers[1 + var3];
                                                      Client.menuIdentifiers[1 + var3] = var6;
                                                      if(Client.field391 != -1) {
                                                         if(Client.field391 == var3) {
                                                            Client.field391 = var3 + 1;
                                                         } else if(var3 + 1 == Client.field391) {
                                                            Client.field391 = var3;
                                                         }
                                                      }

                                                      var37 = false;
                                                   }
                                                }
                                             }

                                             int var11;
                                             if(null == CombatInfoListHolder.field784 && Client.field486 == null) {
                                                var2 = class115.field1813;
                                                if(Client.isMenuOpen) {
                                                   if(var2 != 1 && (class202.field3076 || var2 != 4)) {
                                                      var3 = class115.field1807;
                                                      var4 = class115.field1801;
                                                      if(var3 < class0.menuX - 10 || var3 > class0.menuX + class105.menuWidth + 10 || var4 < XItemContainer.menuY - 10 || var4 > 10 + NPCComposition.menuHeight + XItemContainer.menuY) {
                                                         Client.isMenuOpen = false;
                                                         WidgetNode.method208(class0.menuX, XItemContainer.menuY, class105.menuWidth, NPCComposition.menuHeight);
                                                      }
                                                   }

                                                   if(var2 == 1 || !class202.field3076 && var2 == 4) {
                                                      var3 = class0.menuX;
                                                      var4 = XItemContainer.menuY;
                                                      var5 = class105.menuWidth;
                                                      var6 = class115.field1814;
                                                      var7 = class115.field1815;
                                                      var8 = -1;

                                                      for(var24 = 0; var24 < Client.menuOptionCount; ++var24) {
                                                         var10 = 15 * (Client.menuOptionCount - 1 - var24) + var4 + 31;
                                                         if(var6 > var3 && var6 < var5 + var3 && var7 > var10 - 13 && var7 < 3 + var10) {
                                                            var8 = var24;
                                                         }
                                                      }

                                                      if(var8 != -1 && var8 >= 0) {
                                                         var24 = Client.menuActionParams0[var8];
                                                         var10 = Client.menuActionParams1[var8];
                                                         var11 = Client.menuTypes[var8];
                                                         int var12 = Client.menuIdentifiers[var8];
                                                         String var41 = Client.menuOptions[var8];
                                                         String var29 = Client.menuTargets[var8];
                                                         class65.menuAction(var24, var10, var11, var12, var41, var29, class115.field1814, class115.field1815);
                                                      }

                                                      Client.isMenuOpen = false;
                                                      WidgetNode.method208(class0.menuX, XItemContainer.menuY, class105.menuWidth, NPCComposition.menuHeight);
                                                   }
                                                } else {
                                                   label1545: {
                                                      var3 = class145.method2764();
                                                      if((var2 == 1 || !class202.field3076 && var2 == 4) && var3 >= 0) {
                                                         var4 = Client.menuTypes[var3];
                                                         if(var4 == 39 || var4 == 40 || var4 == 41 || var4 == 42 || var4 == 43 || var4 == 33 || var4 == 34 || var4 == 35 || var4 == 36 || var4 == 37 || var4 == 38 || var4 == 1005) {
                                                            var5 = Client.menuActionParams0[var3];
                                                            var6 = Client.menuActionParams1[var3];
                                                            Widget var30 = World.method670(var6);
                                                            if(class164.method3158(class174.method3271(var30)) || class119.method2332(class174.method3271(var30))) {
                                                               if(null != CombatInfoListHolder.field784 && !Client.field461) {
                                                                  var8 = class145.method2764();
                                                                  if(Client.field388 != 1 && !Player.method272(var8) && Client.menuOptionCount > 0) {
                                                                     Renderable.method1940(Client.field427, Client.field428);
                                                                  }
                                                               }

                                                               Client.field461 = false;
                                                               Client.field431 = 0;
                                                               if(CombatInfoListHolder.field784 != null) {
                                                                  class2.method36(CombatInfoListHolder.field784);
                                                               }

                                                               CombatInfoListHolder.field784 = World.method670(var6);
                                                               Client.field310 = var5;
                                                               Client.field427 = class115.field1814;
                                                               Client.field428 = class115.field1815;
                                                               if(var3 >= 0) {
                                                                  class65.field1115 = new class38();
                                                                  class65.field1115.field822 = Client.menuActionParams0[var3];
                                                                  class65.field1115.field831 = Client.menuActionParams1[var3];
                                                                  class65.field1115.field823 = Client.menuTypes[var3];
                                                                  class65.field1115.field830 = Client.menuIdentifiers[var3];
                                                                  class65.field1115.field825 = Client.menuOptions[var3];
                                                               }

                                                               class2.method36(CombatInfoListHolder.field784);
                                                               break label1545;
                                                            }
                                                         }
                                                      }

                                                      if(var2 == 1 || !class202.field3076 && var2 == 4) {
                                                         label1525: {
                                                            label1136: {
                                                               if(Client.field388 == 1 && Client.menuOptionCount > 2) {
                                                                  boolean var38;
                                                                  if(Client.menuOptionCount <= 0) {
                                                                     var38 = false;
                                                                  } else if(Client.field561 && class105.field1725[81] && Client.field391 != -1) {
                                                                     var38 = true;
                                                                  } else {
                                                                     var38 = false;
                                                                  }

                                                                  if(!var38) {
                                                                     break label1136;
                                                                  }
                                                               }

                                                               if(!Player.method272(var3)) {
                                                                  break label1525;
                                                               }
                                                            }

                                                            var2 = 2;
                                                         }
                                                      }

                                                      if((var2 == 1 || !class202.field3076 && var2 == 4) && Client.menuOptionCount > 0 && var3 >= 0) {
                                                         var4 = Client.menuActionParams0[var3];
                                                         var5 = Client.menuActionParams1[var3];
                                                         var6 = Client.menuTypes[var3];
                                                         var7 = Client.menuIdentifiers[var3];
                                                         String var31 = Client.menuOptions[var3];
                                                         String var9 = Client.menuTargets[var3];
                                                         class65.menuAction(var4, var5, var6, var7, var31, var9, class115.field1814, class115.field1815);
                                                      }

                                                      if(var2 == 2 && Client.menuOptionCount > 0) {
                                                         class30.method687(class115.field1814, class115.field1815);
                                                      }
                                                   }
                                                }
                                             }

                                             if(Client.field486 != null) {
                                                class47.method964();
                                             }

                                             if(CombatInfoListHolder.field784 != null) {
                                                class2.method36(CombatInfoListHolder.field784);
                                                ++Client.field431;
                                                if(class115.field1806 == 0) {
                                                   if(Client.field461) {
                                                      if(class3.field38 == CombatInfoListHolder.field784 && Client.field310 != Client.field408) {
                                                         Widget var49 = CombatInfoListHolder.field784;
                                                         byte var40 = 0;
                                                         if(Client.field476 == 1 && var49.contentType == 206) {
                                                            var40 = 1;
                                                         }

                                                         if(var49.itemIds[Client.field408] <= 0) {
                                                            var40 = 0;
                                                         }

                                                         if(class119.method2332(class174.method3271(var49))) {
                                                            var4 = Client.field310;
                                                            var5 = Client.field408;
                                                            var49.itemIds[var5] = var49.itemIds[var4];
                                                            var49.itemQuantities[var5] = var49.itemQuantities[var4];
                                                            var49.itemIds[var4] = -1;
                                                            var49.itemQuantities[var4] = 0;
                                                         } else if(var40 == 1) {
                                                            var4 = Client.field310;
                                                            var5 = Client.field408;

                                                            while(var4 != var5) {
                                                               if(var4 > var5) {
                                                                  var49.method3209(var4 - 1, var4);
                                                                  --var4;
                                                               } else if(var4 < var5) {
                                                                  var49.method3209(1 + var4, var4);
                                                                  ++var4;
                                                               }
                                                            }
                                                         } else {
                                                            var49.method3209(Client.field408, Client.field310);
                                                         }

                                                         Client.field309.method3076(151);
                                                         Client.field309.method2864(Client.field310);
                                                         Client.field309.method2817(Client.field408);
                                                         Client.field309.method2843(var40);
                                                         Client.field309.method2874(CombatInfoListHolder.field784.id);
                                                      }
                                                   } else {
                                                      label1491: {
                                                         label1509: {
                                                            var2 = class145.method2764();
                                                            if(Client.menuOptionCount > 2) {
                                                               if(Client.field388 == 1) {
                                                                  boolean var39;
                                                                  if(Client.menuOptionCount <= 0) {
                                                                     var39 = false;
                                                                  } else if(Client.field561 && class105.field1725[81] && Client.field391 != -1) {
                                                                     var39 = true;
                                                                  } else {
                                                                     var39 = false;
                                                                  }

                                                                  if(!var39) {
                                                                     break label1509;
                                                                  }
                                                               }

                                                               if(Player.method272(var2)) {
                                                                  break label1509;
                                                               }
                                                            }

                                                            if(Client.menuOptionCount > 0) {
                                                               Renderable.method1940(Client.field427, Client.field428);
                                                            }
                                                            break label1491;
                                                         }

                                                         class30.method687(Client.field427, Client.field428);
                                                      }
                                                   }

                                                   Client.field425 = 10;
                                                   class115.field1813 = 0;
                                                   CombatInfoListHolder.field784 = null;
                                                } else if(Client.field431 >= 5 && (class115.field1807 > Client.field427 + 5 || class115.field1807 < Client.field427 - 5 || class115.field1801 > 5 + Client.field428 || class115.field1801 < Client.field428 - 5)) {
                                                   Client.field461 = true;
                                                }
                                             }

                                             if(Region.method1933()) {
                                                var2 = Region.field1521;
                                                var3 = Region.field1522;
                                                Client.field309.method3076(147);
                                                Client.field309.method2843(5);
                                                Client.field309.method2855(class105.field1725[82]?(class105.field1725[81]?2:1):0);
                                                Client.field309.method2909(var3 + class3.baseY);
                                                Client.field309.method2909(var2 + CombatInfoListHolder.baseX);
                                                Region.method1793();
                                                Client.field422 = class115.field1814;
                                                Client.field421 = class115.field1815;
                                                Client.field423 = 1;
                                                Client.field548 = 0;
                                                Client.flagX = var2;
                                                Client.flagY = var3;
                                             }

                                             if(class1.field16 != var43) {
                                                if(null != var43) {
                                                   class2.method36(var43);
                                                }

                                                if(null != class1.field16) {
                                                   class2.method36(class1.field16);
                                                }
                                             }

                                             if(FloorUnderlayDefinition.field2809 != var36 && Client.field465 == Client.field348) {
                                                if(null != var36) {
                                                   class2.method36(var36);
                                                }

                                                if(FloorUnderlayDefinition.field2809 != null) {
                                                   class2.method36(FloorUnderlayDefinition.field2809);
                                                }
                                             }

                                             if(FloorUnderlayDefinition.field2809 != null) {
                                                if(Client.field348 < Client.field465) {
                                                   ++Client.field348;
                                                   if(Client.field348 == Client.field465) {
                                                      class2.method36(FloorUnderlayDefinition.field2809);
                                                   }
                                                }
                                             } else if(Client.field348 > 0) {
                                                --Client.field348;
                                             }

                                             var2 = Client.field376 + class22.localPlayer.x;
                                             var3 = class22.localPlayer.y + Client.field415;
                                             if(SecondaryBufferProvider.field3215 - var2 < -500 || SecondaryBufferProvider.field3215 - var2 > 500 || class40.field842 - var3 < -500 || class40.field842 - var3 > 500) {
                                                SecondaryBufferProvider.field3215 = var2;
                                                class40.field842 = var3;
                                             }

                                             if(var2 != SecondaryBufferProvider.field3215) {
                                                SecondaryBufferProvider.field3215 += (var2 - SecondaryBufferProvider.field3215) / 16;
                                             }

                                             if(class40.field842 != var3) {
                                                class40.field842 += (var3 - class40.field842) / 16;
                                             }

                                             if(class115.field1806 == 4 && class202.field3076) {
                                                var4 = class115.field1801 - Client.field401;
                                                Client.field399 = var4 * 2;
                                                Client.field401 = var4 != -1 && var4 != 1?(class115.field1801 + Client.field401) / 2:class115.field1801;
                                                var5 = Client.field400 - class115.field1807;
                                                Client.field447 = var5 * 2;
                                                Client.field400 = var5 != -1 && var5 != 1?(class115.field1807 + Client.field400) / 2:class115.field1807;
                                             } else {
                                                if(class105.field1725[96]) {
                                                   Client.field447 += (-24 - Client.field447) / 2;
                                                } else if(class105.field1725[97]) {
                                                   Client.field447 += (24 - Client.field447) / 2;
                                                } else {
                                                   Client.field447 /= 2;
                                                }

                                                if(class105.field1725[98]) {
                                                   Client.field399 += (12 - Client.field399) / 2;
                                                } else if(class105.field1725[99]) {
                                                   Client.field399 += (-12 - Client.field399) / 2;
                                                } else {
                                                   Client.field399 /= 2;
                                                }

                                                Client.field401 = class115.field1801;
                                                Client.field400 = class115.field1807;
                                             }

                                             Client.mapAngle = Client.mapAngle + Client.field447 / 2 & 2047;
                                             Client.field396 += Client.field399 / 2;
                                             if(Client.field396 < 128) {
                                                Client.field396 = 128;
                                             }

                                             if(Client.field396 > 383) {
                                                Client.field396 = 383;
                                             }

                                             var4 = SecondaryBufferProvider.field3215 >> 7;
                                             var5 = class40.field842 >> 7;
                                             var6 = class1.method21(SecondaryBufferProvider.field3215, class40.field842, class31.plane);
                                             var7 = 0;
                                             if(var4 > 3 && var5 > 3 && var4 < 100 && var5 < 100) {
                                                for(var8 = var4 - 4; var8 <= 4 + var4; ++var8) {
                                                   for(var24 = var5 - 4; var24 <= 4 + var5; ++var24) {
                                                      var10 = class31.plane;
                                                      if(var10 < 3 && (class10.tileSettings[1][var8][var24] & 2) == 2) {
                                                         ++var10;
                                                      }

                                                      var11 = var6 - class10.tileHeights[var10][var8][var24];
                                                      if(var11 > var7) {
                                                         var7 = var11;
                                                      }
                                                   }
                                                }
                                             }

                                             var8 = 192 * var7;
                                             if(var8 > 98048) {
                                                var8 = 98048;
                                             }

                                             if(var8 < '耀') {
                                                var8 = '耀';
                                             }

                                             if(var8 > Client.field503) {
                                                Client.field503 += (var8 - Client.field503) / 24;
                                             } else if(var8 < Client.field503) {
                                                Client.field503 += (var8 - Client.field503) / 80;
                                             }

                                             if(Client.field440) {
                                                class39.method820();
                                             }

                                             for(var2 = 0; var2 < 5; ++var2) {
                                                ++Client.field566[var2];
                                             }

                                             class7.chatMessages.method925();
                                             var2 = Buffer.method2844();
                                             var3 = GameObject.method1984();
                                             if(var2 > 15000 && var3 > 15000) {
                                                Client.field365 = 250;
                                                class115.mouseIdleTicks = 14500;
                                                Client.field309.method3076(255);
                                             }

                                             ++Client.field382;
                                             if(Client.field382 > 500) {
                                                Client.field382 = 0;
                                                var4 = (int)(Math.random() * 8.0D);
                                                if((var4 & 1) == 1) {
                                                   Client.field376 += Client.field377;
                                                }

                                                if((var4 & 2) == 2) {
                                                   Client.field415 += Client.field379;
                                                }

                                                if((var4 & 4) == 4) {
                                                   Client.field380 += Client.field442;
                                                }
                                             }

                                             if(Client.field376 < -50) {
                                                Client.field377 = 2;
                                             }

                                             if(Client.field376 > 50) {
                                                Client.field377 = -2;
                                             }

                                             if(Client.field415 < -55) {
                                                Client.field379 = 2;
                                             }

                                             if(Client.field415 > 55) {
                                                Client.field379 = -2;
                                             }

                                             if(Client.field380 < -40) {
                                                Client.field442 = 1;
                                             }

                                             if(Client.field380 > 40) {
                                                Client.field442 = -1;
                                             }

                                             ++Client.field387;
                                             if(Client.field387 > 500) {
                                                Client.field387 = 0;
                                                var4 = (int)(Math.random() * 8.0D);
                                                if((var4 & 1) == 1) {
                                                   Client.mapScale += Client.field384;
                                                }

                                                if((var4 & 2) == 2) {
                                                   Client.mapScaleDelta += Client.field386;
                                                }
                                             }

                                             if(Client.mapScale < -60) {
                                                Client.field384 = 2;
                                             }

                                             if(Client.mapScale > 60) {
                                                Client.field384 = -2;
                                             }

                                             if(Client.mapScaleDelta < -20) {
                                                Client.field386 = 1;
                                             }

                                             if(Client.mapScaleDelta > 10) {
                                                Client.field386 = -1;
                                             }

                                             for(class16 var48 = (class16)Client.field583.method2479(); null != var48; var48 = (class16)Client.field583.method2481()) {
                                                if((long)var48.field207 < class99.method2005() / 1000L - 5L) {
                                                   if(var48.field201 > 0) {
                                                      class30.sendGameMessage(5, "", var48.field202 + " has logged in.");
                                                   }

                                                   if(var48.field201 == 0) {
                                                      class30.sendGameMessage(5, "", var48.field202 + " has logged out.");
                                                   }

                                                   var48.method2491();
                                                }
                                             }

                                             ++Client.field497;
                                             if(Client.field497 > 50) {
                                                Client.field309.method3076(184);
                                             }

                                             try {
                                                if(null != class1.field15 && Client.field309.offset > 0) {
                                                   class1.field15.method2117(Client.field309.payload, 0, Client.field309.offset);
                                                   Client.field309.offset = 0;
                                                   Client.field497 = 0;
                                                }
                                             } catch (IOException var32) {
                                                class16.method203();
                                             }

                                             return;
                                          }

                                          var44 = var28.field223;
                                          if(var44.index < 0) {
                                             break;
                                          }

                                          var45 = World.method670(var44.parentId);
                                       } while(null == var45 || var45.children == null || var44.index >= var45.children.length || var44 != var45.children[var44.index]);

                                       Frames.method1963(var28);
                                    }
                                 }

                                 var44 = var28.field223;
                                 if(var44.index < 0) {
                                    break;
                                 }

                                 var45 = World.method670(var44.parentId);
                              } while(var45 == null || var45.children == null || var44.index >= var45.children.length || var44 != var45.children[var44.index]);

                              Frames.method1963(var28);
                           }
                        }

                        var44 = var28.field223;
                        if(var44.index < 0) {
                           break;
                        }

                        var45 = World.method670(var44.parentId);
                     } while(null == var45 || null == var45.children || var44.index >= var45.children.length || var45.children[var44.index] != var44);

                     Frames.method1963(var28);
                  }
               }

               Client.field309.method3076(52);
               Client.field309.method2843(0);
               var16 = Client.field309.offset;
               Script.method971(Client.field309);
               Client.field309.method2828(Client.field309.offset - var16);
            }
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "69974310"
   )
   static MessageNode method2055(int var0) {
      return (MessageNode)class47.field951.method2361((long)var0);
   }
}
