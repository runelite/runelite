import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("c")
   String field284;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 464077509
   )
   @Export("world")
   int world;
   @ObfuscatedName("h")
   @Export("rank")
   byte rank;
   @ObfuscatedName("bt")
   static class184 field288;
   @ObfuscatedName("s")
   @Export("username")
   String username;
   @ObfuscatedName("ek")
   static ModIcon[] field291;

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "824691924"
   )
   static final int method223(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class10.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = var6 * class10.tileHeights[var5][1 + var3][var4] + class10.tileHeights[var5][var3][var4] * (128 - var6) >> 7;
         int var9 = class10.tileHeights[var5][var3][1 + var4] * (128 - var6) + var6 * class10.tileHeights[var5][var3 + 1][1 + var4] >> 7;
         return (128 - var7) * var8 + var9 * var7 >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "56"
   )
   static final boolean method224(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field346 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field470.method3041(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field470.method3042(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field470.method3043(false);
         }

         if(var1 == 325) {
            Client.field470.method3043(true);
         }

         if(var1 == 326) {
            Client.field336.method2963(103);
            Client.field470.method3044(Client.field336);
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1967657058"
   )
   static final void method225() {
      if(Client.field534 > 1) {
         --Client.field534;
      }

      if(Client.field346 > 0) {
         --Client.field346;
      }

      if(Client.field473) {
         Client.field473 = false;
         class105.method1961();
      } else {
         if(!Client.isMenuOpen) {
            Client.menuOptions[0] = "Cancel";
            Client.menuTargets[0] = "";
            Client.menuTypes[0] = 1006;
            Client.menuOptionCount = 1;
         }

         int var0;
         for(var0 = 0; var0 < 100 && class160.method2995(); ++var0) {
            ;
         }

         if(Client.gameState == 30) {
            while(class11.method134()) {
               Client.field336.method2963(54);
               Client.field336.method2708(0);
               var0 = Client.field336.offset;
               class202.method3649(Client.field336);
               Client.field336.method2768(Client.field336.offset - var0);
            }

            Object var15 = class39.field802.field235;
            int var1;
            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            synchronized(class39.field802.field235) {
               if(!Client.field293) {
                  class39.field802.field230 = 0;
               } else if(class115.field1807 != 0 || class39.field802.field230 >= 40) {
                  Client.field336.method2963(121);
                  Client.field336.method2708(0);
                  var1 = Client.field336.offset;
                  var2 = 0;

                  for(var3 = 0; var3 < class39.field802.field230 && Client.field336.offset - var1 < 240; ++var3) {
                     ++var2;
                     var4 = class39.field802.field232[var3];
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > 502) {
                        var4 = 502;
                     }

                     var5 = class39.field802.field233[var3];
                     if(var5 < 0) {
                        var5 = 0;
                     } else if(var5 > 764) {
                        var5 = 764;
                     }

                     var6 = 765 * var4 + var5;
                     if(class39.field802.field232[var3] == -1 && class39.field802.field233[var3] == -1) {
                        var5 = -1;
                        var4 = -1;
                        var6 = 524287;
                     }

                     if(var5 == Client.field445 && Client.field306 == var4) {
                        if(Client.field307 < 2047) {
                           ++Client.field307;
                        }
                     } else {
                        var7 = var5 - Client.field445;
                        Client.field445 = var5;
                        var8 = var4 - Client.field306;
                        Client.field306 = var4;
                        if(Client.field307 < 8 && var7 >= -32 && var7 <= 31 && var8 >= -32 && var8 <= 31) {
                           var7 += 32;
                           var8 += 32;
                           Client.field336.method2709((var7 << 6) + (Client.field307 << 12) + var8);
                           Client.field307 = 0;
                        } else if(Client.field307 < 8) {
                           Client.field336.method2710(var6 + 8388608 + (Client.field307 << 19));
                           Client.field307 = 0;
                        } else {
                           Client.field336.method2711((Client.field307 << 19) + -1073741824 + var6);
                           Client.field307 = 0;
                        }
                     }
                  }

                  Client.field336.method2768(Client.field336.offset - var1);
                  if(var2 >= class39.field802.field230) {
                     class39.field802.field230 = 0;
                  } else {
                     class39.field802.field230 -= var2;

                     for(var3 = 0; var3 < class39.field802.field230; ++var3) {
                        class39.field802.field233[var3] = class39.field802.field233[var3 + var2];
                        class39.field802.field232[var3] = class39.field802.field232[var3 + var2];
                     }
                  }
               }
            }

            if(class115.field1807 == 1 || !class10.field110 && class115.field1807 == 4 || class115.field1807 == 2) {
               long var26 = (class115.field1811 - Client.field304) / 50L;
               if(var26 > 4095L) {
                  var26 = 4095L;
               }

               Client.field304 = class115.field1811;
               var2 = class115.field1796;
               if(var2 < 0) {
                  var2 = 0;
               } else if(var2 > ChatMessages.field907) {
                  var2 = ChatMessages.field907;
               }

               var3 = class115.field1809;
               if(var3 < 0) {
                  var3 = 0;
               } else if(var3 > class16.field186) {
                  var3 = class16.field186;
               }

               var4 = (int)var26;
               Client.field336.method2963(162);
               Client.field336.method2709((var4 << 1) + (class115.field1807 == 2?1:0));
               Client.field336.method2709(var3);
               Client.field336.method2709(var2);
            }

            if(class105.field1722 > 0) {
               Client.field336.method2963(95);
               Client.field336.method2709(0);
               var0 = Client.field336.offset;
               long var27 = class2.method27();

               for(var3 = 0; var3 < class105.field1722; ++var3) {
                  long var29 = var27 - Client.field396;
                  if(var29 > 16777215L) {
                     var29 = 16777215L;
                  }

                  Client.field396 = var27;
                  Client.field336.method2833(class105.field1715[var3]);
                  Client.field336.method2762((int)var29);
               }

               Client.field336.method2885(Client.field336.offset - var0);
            }

            if(Client.field571 > 0) {
               --Client.field571;
            }

            if(class105.field1709[96] || class105.field1709[97] || class105.field1709[98] || class105.field1709[99]) {
               Client.field385 = true;
            }

            if(Client.field385 && Client.field571 <= 0) {
               Client.field571 = 20;
               Client.field385 = false;
               Client.field336.method2963(45);
               Client.field336.method2755(Client.field419);
               Client.field336.method2755(Client.mapAngle);
            }

            if(class49.field956 && !Client.field308) {
               Client.field308 = true;
               Client.field336.method2963(62);
               Client.field336.method2708(1);
            }

            if(!class49.field956 && Client.field308) {
               Client.field308 = false;
               Client.field336.method2963(62);
               Client.field336.method2708(0);
            }

            if(Client.field369 != class118.plane) {
               Client.field369 = class118.plane;
               class65.method1121(class118.plane);
            }

            if(Client.gameState == 30) {
               Ignore.method167();

               for(var0 = 0; var0 < Client.field505; ++var0) {
                  --Client.field537[var0];
                  if(Client.field537[var0] >= -10) {
                     class53 var16 = Client.field420[var0];
                     if(null == var16) {
                        Object var10000 = null;
                        var16 = class53.method921(class5.field60, Client.field565[var0], 0);
                        if(var16 == null) {
                           continue;
                        }

                        Client.field537[var0] += var16.method919();
                        Client.field420[var0] = var16;
                     }

                     if(Client.field537[var0] < 0) {
                        if(Client.field538[var0] != 0) {
                           var3 = 128 * (Client.field538[var0] & 255);
                           var4 = Client.field538[var0] >> 16 & 255;
                           var5 = 64 + var4 * 128 - XItemContainer.localPlayer.x;
                           if(var5 < 0) {
                              var5 = -var5;
                           }

                           var6 = Client.field538[var0] >> 8 & 255;
                           var7 = 128 * var6 + 64 - XItemContainer.localPlayer.y;
                           if(var7 < 0) {
                              var7 = -var7;
                           }

                           var8 = var5 + var7 - 128;
                           if(var8 > var3) {
                              Client.field537[var0] = -100;
                              continue;
                           }

                           if(var8 < 0) {
                              var8 = 0;
                           }

                           var2 = Client.field551 * (var3 - var8) / var3;
                        } else {
                           var2 = Client.field532;
                        }

                        if(var2 > 0) {
                           class55 var17 = var16.method918().method963(Player.field267);
                           class66 var18 = class66.method1126(var17, 100, var2);
                           var18.method1165(Client.field502[var0] - 1);
                           CombatInfoListHolder.field758.method868(var18);
                        }

                        Client.field537[var0] = -100;
                     }
                  } else {
                     --Client.field505;

                     for(var1 = var0; var1 < Client.field505; ++var1) {
                        Client.field565[var1] = Client.field565[var1 + 1];
                        Client.field420[var1] = Client.field420[1 + var1];
                        Client.field502[var1] = Client.field502[1 + var1];
                        Client.field537[var1] = Client.field537[var1 + 1];
                        Client.field538[var1] = Client.field538[var1 + 1];
                     }

                     --var0;
                  }
               }

               if(Client.field531) {
                  boolean var28;
                  if(class138.field1933 != 0) {
                     var28 = true;
                  } else {
                     var28 = class138.field1923.method2421();
                  }

                  if(!var28) {
                     if(Client.field529 != 0 && Client.field530 != -1) {
                        WallObject.method1833(class164.field2170, Client.field530, 0, Client.field529, false);
                     }

                     Client.field531 = false;
                  }
               }

               ++Client.field517;
               if(Client.field517 > 750) {
                  class105.method1961();
               } else {
                  Frames.method1841();

                  for(var0 = 0; var0 < Client.field332; ++var0) {
                     var1 = Client.field333[var0];
                     NPC var19 = Client.cachedNPCs[var1];
                     if(var19 != null) {
                        class7.method87(var19, var19.composition.field3010);
                     }
                  }

                  Ignore.method166();
                  ++Client.field533;
                  if(Client.field390 != 0) {
                     Client.field401 += 20;
                     if(Client.field401 >= 400) {
                        Client.field390 = 0;
                     }
                  }

                  if(null != class170.field2345) {
                     ++Client.field444;
                     if(Client.field444 >= 15) {
                        class204.method3671(class170.field2345);
                        class170.field2345 = null;
                     }
                  }

                  Widget var36 = class215.field3163;
                  Widget var37 = XItemContainer.field130;
                  class215.field3163 = null;
                  XItemContainer.field130 = null;
                  Client.field468 = null;
                  Client.field472 = false;
                  Client.field429 = false;
                  Client.field515 = 0;

                  while(GameObject.method1863() && Client.field515 < 128) {
                     if(Client.field458 >= 2 && class105.field1709[82] && class15.field175 == 66) {
                        String var38 = "";

                        MessageNode var20;
                        for(Iterator var40 = class47.field927.iterator(); var40.hasNext(); var38 = var38 + var20.name + ':' + var20.value + '\n') {
                           var20 = (MessageNode)var40.next();
                        }

                        class88.field1541.setContents(new StringSelection(var38), (ClipboardOwner)null);
                     } else {
                        Client.field494[Client.field515] = class15.field175;
                        Client.field516[Client.field515] = Item.field880;
                        ++Client.field515;
                     }
                  }

                  if(Client.widgetRoot != -1) {
                     Item.method774(Client.widgetRoot, 0, 0, class16.field186, ChatMessages.field907, 0, 0);
                  }

                  ++Client.field358;

                  while(true) {
                     Widget var39;
                     Widget var41;
                     class18 var42;
                     do {
                        var42 = (class18)Client.field492.method2332();
                        if(var42 == null) {
                           while(true) {
                              do {
                                 var42 = (class18)Client.field388.method2332();
                                 if(null == var42) {
                                    while(true) {
                                       do {
                                          var42 = (class18)Client.field417.method2332();
                                          if(var42 == null) {
                                             class160.method2994();
                                             int var10;
                                             int var11;
                                             int var21;
                                             boolean var45;
                                             if(null == class38.field786 && null == Client.field464) {
                                                var2 = class115.field1807;
                                                if(Client.isMenuOpen) {
                                                   if(var2 != 1 && (class10.field110 || var2 != 4)) {
                                                      var3 = class115.field1810;
                                                      var4 = class115.field1803;
                                                      if(var3 < Client.menuX - 10 || var3 > 10 + Client.menuX + class5.menuWidth || var4 < class6.menuY - 10 || var4 > 10 + ChatMessages.menuHeight + class6.menuY) {
                                                         Client.isMenuOpen = false;
                                                         class31.method659(Client.menuX, class6.menuY, class5.menuWidth, ChatMessages.menuHeight);
                                                      }
                                                   }

                                                   if(var2 == 1 || !class10.field110 && var2 == 4) {
                                                      var3 = Client.menuX;
                                                      var4 = class6.menuY;
                                                      var5 = class5.menuWidth;
                                                      var6 = class115.field1809;
                                                      var7 = class115.field1796;
                                                      var8 = -1;

                                                      for(var21 = 0; var21 < Client.menuOptionCount; ++var21) {
                                                         var10 = 15 * (Client.menuOptionCount - 1 - var21) + 31 + var4;
                                                         if(var6 > var3 && var6 < var5 + var3 && var7 > var10 - 13 && var7 < 3 + var10) {
                                                            var8 = var21;
                                                         }
                                                      }

                                                      if(var8 != -1 && var8 >= 0) {
                                                         var21 = Client.menuActionParams0[var8];
                                                         var10 = Client.menuActionParams1[var8];
                                                         var11 = Client.menuTypes[var8];
                                                         int var12 = Client.menuIdentifiers[var8];
                                                         String var13 = Client.menuOptions[var8];
                                                         String var14 = Client.menuTargets[var8];
                                                         Player.menuAction(var21, var10, var11, var12, var13, var14, class115.field1809, class115.field1796);
                                                      }

                                                      Client.isMenuOpen = false;
                                                      class31.method659(Client.menuX, class6.menuY, class5.menuWidth, ChatMessages.menuHeight);
                                                   }
                                                } else {
                                                   label1450: {
                                                      if((var2 == 1 || !class10.field110 && var2 == 4) && Client.menuOptionCount > 0) {
                                                         var3 = Client.menuTypes[Client.menuOptionCount - 1];
                                                         if(var3 == 39 || var3 == 40 || var3 == 41 || var3 == 42 || var3 == 43 || var3 == 33 || var3 == 34 || var3 == 35 || var3 == 36 || var3 == 37 || var3 == 38 || var3 == 1005) {
                                                            label1431: {
                                                               var4 = Client.menuActionParams0[Client.menuOptionCount - 1];
                                                               var5 = Client.menuActionParams1[Client.menuOptionCount - 1];
                                                               Widget var22 = class108.method1988(var5);
                                                               var8 = class170.method3147(var22);
                                                               boolean var32 = (var8 >> 28 & 1) != 0;
                                                               if(!var32) {
                                                                  var10 = class170.method3147(var22);
                                                                  var45 = (var10 >> 29 & 1) != 0;
                                                                  if(!var45) {
                                                                     break label1431;
                                                                  }
                                                               }

                                                               if(class38.field786 != null && !Client.field410 && Client.field430 != 1) {
                                                                  var10 = Client.menuOptionCount - 1;
                                                                  if(var10 < 0) {
                                                                     var45 = false;
                                                                  } else {
                                                                     var11 = Client.menuTypes[var10];
                                                                     if(var11 >= 2000) {
                                                                        var11 -= 2000;
                                                                     }

                                                                     if(var11 == 1007) {
                                                                        var45 = true;
                                                                     } else {
                                                                        var45 = false;
                                                                     }
                                                                  }

                                                                  if(!var45 && Client.menuOptionCount > 0) {
                                                                     Buffer.method2921(Client.field407, Client.field344);
                                                                  }
                                                               }

                                                               Client.field410 = false;
                                                               Client.field422 = 0;
                                                               if(null != class38.field786) {
                                                                  class204.method3671(class38.field786);
                                                               }

                                                               class38.field786 = class108.method1988(var5);
                                                               Client.field406 = var4;
                                                               Client.field407 = class115.field1809;
                                                               Client.field344 = class115.field1796;
                                                               if(Client.menuOptionCount > 0) {
                                                                  class47.method841(Client.menuOptionCount - 1);
                                                               }

                                                               class204.method3671(class38.field786);
                                                               break label1450;
                                                            }
                                                         }
                                                      }

                                                      if(var2 == 1 || !class10.field110 && var2 == 4) {
                                                         label1443: {
                                                            if(Client.field430 != 1 || Client.menuOptionCount <= 2) {
                                                               var4 = Client.menuOptionCount - 1;
                                                               boolean var30;
                                                               if(var4 < 0) {
                                                                  var30 = false;
                                                               } else {
                                                                  var5 = Client.menuTypes[var4];
                                                                  if(var5 >= 2000) {
                                                                     var5 -= 2000;
                                                                  }

                                                                  if(var5 == 1007) {
                                                                     var30 = true;
                                                                  } else {
                                                                     var30 = false;
                                                                  }
                                                               }

                                                               if(!var30) {
                                                                  break label1443;
                                                               }
                                                            }

                                                            var2 = 2;
                                                         }
                                                      }

                                                      if((var2 == 1 || !class10.field110 && var2 == 4) && Client.menuOptionCount > 0) {
                                                         var3 = Client.menuOptionCount - 1;
                                                         if(var3 >= 0) {
                                                            var4 = Client.menuActionParams0[var3];
                                                            var5 = Client.menuActionParams1[var3];
                                                            var6 = Client.menuTypes[var3];
                                                            var7 = Client.menuIdentifiers[var3];
                                                            String var23 = Client.menuOptions[var3];
                                                            String var9 = Client.menuTargets[var3];
                                                            Player.menuAction(var4, var5, var6, var7, var23, var9, class115.field1809, class115.field1796);
                                                         }
                                                      }

                                                      if(var2 == 2 && Client.menuOptionCount > 0) {
                                                         class171.method3148(class115.field1809, class115.field1796);
                                                      }
                                                   }
                                                }
                                             }

                                             if(null != Client.field464) {
                                                class204.method3671(Client.field464);
                                                ++class6.field72;
                                                if(Client.field472 && Client.field429) {
                                                   var2 = class115.field1810;
                                                   var3 = class115.field1803;
                                                   var2 -= Client.field466;
                                                   var3 -= Client.field467;
                                                   if(var2 < Client.field408) {
                                                      var2 = Client.field408;
                                                   }

                                                   if(Client.field464.width + var2 > Client.field465.width + Client.field408) {
                                                      var2 = Client.field465.width + Client.field408 - Client.field464.width;
                                                   }

                                                   if(var3 < Client.field310) {
                                                      var3 = Client.field310;
                                                   }

                                                   if(Client.field464.height + var3 > Client.field465.height + Client.field310) {
                                                      var3 = Client.field465.height + Client.field310 - Client.field464.height;
                                                   }

                                                   var4 = var2 - Client.field576;
                                                   var5 = var3 - Client.field474;
                                                   var6 = Client.field464.field2285;
                                                   if(class6.field72 > Client.field464.field2231 && (var4 > var6 || var4 < -var6 || var5 > var6 || var5 < -var6)) {
                                                      Client.field475 = true;
                                                   }

                                                   var7 = var2 - Client.field408 + Client.field465.scrollX;
                                                   var8 = Client.field465.scrollY + (var3 - Client.field310);
                                                   class18 var33;
                                                   if(Client.field464.field2233 != null && Client.field475) {
                                                      var33 = new class18();
                                                      var33.field204 = Client.field464;
                                                      var33.field209 = var7;
                                                      var33.field206 = var8;
                                                      var33.field205 = Client.field464.field2233;
                                                      CombatInfo1.method594(var33);
                                                   }

                                                   if(class115.field1801 == 0) {
                                                      if(Client.field475) {
                                                         if(null != Client.field464.field2254) {
                                                            var33 = new class18();
                                                            var33.field204 = Client.field464;
                                                            var33.field209 = var7;
                                                            var33.field206 = var8;
                                                            var33.field216 = Client.field468;
                                                            var33.field205 = Client.field464.field2254;
                                                            CombatInfo1.method594(var33);
                                                         }

                                                         if(null != Client.field468 && class9.method97(Client.field464) != null) {
                                                            Client.field336.method2963(34);
                                                            Client.field336.method2772(Client.field464.id);
                                                            Client.field336.method2709(Client.field464.index);
                                                            Client.field336.method2709(Client.field468.item);
                                                            Client.field336.method2711(Client.field468.id);
                                                            Client.field336.method2754(Client.field464.item);
                                                            Client.field336.method2755(Client.field468.index);
                                                         }
                                                      } else {
                                                         label1406: {
                                                            label1075: {
                                                               if(Client.field430 != 1) {
                                                                  var10 = Client.menuOptionCount - 1;
                                                                  if(var10 < 0) {
                                                                     var45 = false;
                                                                  } else {
                                                                     var11 = Client.menuTypes[var10];
                                                                     if(var11 >= 2000) {
                                                                        var11 -= 2000;
                                                                     }

                                                                     if(var11 == 1007) {
                                                                        var45 = true;
                                                                     } else {
                                                                        var45 = false;
                                                                     }
                                                                  }

                                                                  if(!var45) {
                                                                     break label1075;
                                                                  }
                                                               }

                                                               if(Client.menuOptionCount > 2) {
                                                                  class171.method3148(Client.field576 + Client.field466, Client.field467 + Client.field474);
                                                                  break label1406;
                                                               }
                                                            }

                                                            if(Client.menuOptionCount > 0) {
                                                               Buffer.method2921(Client.field576 + Client.field466, Client.field467 + Client.field474);
                                                            }
                                                         }
                                                      }

                                                      Client.field464 = null;
                                                   }
                                                } else if(class6.field72 > 1) {
                                                   Client.field464 = null;
                                                }
                                             }

                                             if(null != class38.field786) {
                                                class204.method3671(class38.field786);
                                                ++Client.field422;
                                                if(class115.field1801 == 0) {
                                                   if(Client.field410) {
                                                      if(class38.field786 == class179.field2694 && Client.field409 != Client.field406) {
                                                         Widget var44 = class38.field786;
                                                         byte var35 = 0;
                                                         if(Client.field454 == 1 && var44.contentType == 206) {
                                                            var35 = 1;
                                                         }

                                                         if(var44.itemIds[Client.field409] <= 0) {
                                                            var35 = 0;
                                                         }

                                                         var5 = class170.method3147(var44);
                                                         boolean var34 = (var5 >> 29 & 1) != 0;
                                                         if(var34) {
                                                            var6 = Client.field406;
                                                            var7 = Client.field409;
                                                            var44.itemIds[var7] = var44.itemIds[var6];
                                                            var44.itemQuantities[var7] = var44.itemQuantities[var6];
                                                            var44.itemIds[var6] = -1;
                                                            var44.itemQuantities[var6] = 0;
                                                         } else if(var35 == 1) {
                                                            var6 = Client.field406;
                                                            var7 = Client.field409;

                                                            while(var7 != var6) {
                                                               if(var6 > var7) {
                                                                  var44.method3132(var6 - 1, var6);
                                                                  --var6;
                                                               } else if(var6 < var7) {
                                                                  var44.method3132(var6 + 1, var6);
                                                                  ++var6;
                                                               }
                                                            }
                                                         } else {
                                                            var44.method3132(Client.field409, Client.field406);
                                                         }

                                                         Client.field336.method2963(117);
                                                         Client.field336.method2708(var35);
                                                         Client.field336.method2756(Client.field409);
                                                         Client.field336.method2756(Client.field406);
                                                         Client.field336.method2711(class38.field786.id);
                                                      }
                                                   } else {
                                                      label1409: {
                                                         label1061: {
                                                            if(Client.field430 != 1) {
                                                               var3 = Client.menuOptionCount - 1;
                                                               boolean var31;
                                                               if(var3 < 0) {
                                                                  var31 = false;
                                                               } else {
                                                                  var4 = Client.menuTypes[var3];
                                                                  if(var4 >= 2000) {
                                                                     var4 -= 2000;
                                                                  }

                                                                  if(var4 == 1007) {
                                                                     var31 = true;
                                                                  } else {
                                                                     var31 = false;
                                                                  }
                                                               }

                                                               if(!var31) {
                                                                  break label1061;
                                                               }
                                                            }

                                                            if(Client.menuOptionCount > 2) {
                                                               class171.method3148(Client.field407, Client.field344);
                                                               break label1409;
                                                            }
                                                         }

                                                         if(Client.menuOptionCount > 0) {
                                                            Buffer.method2921(Client.field407, Client.field344);
                                                         }
                                                      }
                                                   }

                                                   Client.field444 = 10;
                                                   class115.field1807 = 0;
                                                   class38.field786 = null;
                                                } else if(Client.field422 >= 5 && (class115.field1810 > Client.field407 + 5 || class115.field1810 < Client.field407 - 5 || class115.field1803 > 5 + Client.field344 || class115.field1803 < Client.field344 - 5)) {
                                                   Client.field410 = true;
                                                }
                                             }

                                             if(Region.field1510 != -1) {
                                                var2 = Region.field1510;
                                                var3 = Region.field1513;
                                                Client.field336.method2963(148);
                                                Client.field336.method2708(5);
                                                Client.field336.method2756(var3 + class103.baseY);
                                                Client.field336.method2733(class105.field1709[82]?(class105.field1709[81]?2:1):0);
                                                Client.field336.method2756(var2 + class22.baseX);
                                                Region.field1510 = -1;
                                                Client.field540 = class115.field1809;
                                                Client.field486 = class115.field1796;
                                                Client.field390 = 1;
                                                Client.field401 = 0;
                                                Client.flagX = var2;
                                                Client.flagY = var3;
                                             }

                                             if(class215.field3163 != var36) {
                                                if(var36 != null) {
                                                   class204.method3671(var36);
                                                }

                                                if(class215.field3163 != null) {
                                                   class204.method3671(class215.field3163);
                                                }
                                             }

                                             if(var37 != XItemContainer.field130 && Client.field443 == Client.field442) {
                                                if(var37 != null) {
                                                   class204.method3671(var37);
                                                }

                                                if(XItemContainer.field130 != null) {
                                                   class204.method3671(XItemContainer.field130);
                                                }
                                             }

                                             if(XItemContainer.field130 != null) {
                                                if(Client.field442 < Client.field443) {
                                                   ++Client.field442;
                                                   if(Client.field442 == Client.field443) {
                                                      class204.method3671(XItemContainer.field130);
                                                   }
                                                }
                                             } else if(Client.field442 > 0) {
                                                --Client.field442;
                                             }

                                             var2 = XItemContainer.localPlayer.x + Client.field560;
                                             var3 = Client.field536 + XItemContainer.localPlayer.y;
                                             if(class0.field7 - var2 < -500 || class0.field7 - var2 > 500 || class1.field11 - var3 < -500 || class1.field11 - var3 > 500) {
                                                class0.field7 = var2;
                                                class1.field11 = var3;
                                             }

                                             if(class0.field7 != var2) {
                                                class0.field7 += (var2 - class0.field7) / 16;
                                             }

                                             if(var3 != class1.field11) {
                                                class1.field11 += (var3 - class1.field11) / 16;
                                             }

                                             if(class115.field1801 == 4 && class10.field110) {
                                                var4 = class115.field1803 - Client.field381;
                                                Client.field379 = var4 * 2;
                                                Client.field381 = var4 != -1 && var4 != 1?(Client.field381 + class115.field1803) / 2:class115.field1803;
                                                var5 = Client.field539 - class115.field1810;
                                                Client.field295 = var5 * 2;
                                                Client.field539 = var5 != -1 && var5 != 1?(class115.field1810 + Client.field539) / 2:class115.field1810;
                                             } else {
                                                if(class105.field1709[96]) {
                                                   Client.field295 += (-24 - Client.field295) / 2;
                                                } else if(class105.field1709[97]) {
                                                   Client.field295 += (24 - Client.field295) / 2;
                                                } else {
                                                   Client.field295 /= 2;
                                                }

                                                if(class105.field1709[98]) {
                                                   Client.field379 += (12 - Client.field379) / 2;
                                                } else if(class105.field1709[99]) {
                                                   Client.field379 += (-12 - Client.field379) / 2;
                                                } else {
                                                   Client.field379 /= 2;
                                                }

                                                Client.field381 = class115.field1803;
                                                Client.field539 = class115.field1810;
                                             }

                                             Client.mapAngle = Client.field295 / 2 + Client.mapAngle & 2047;
                                             Client.field419 += Client.field379 / 2;
                                             if(Client.field419 < 128) {
                                                Client.field419 = 128;
                                             }

                                             if(Client.field419 > 383) {
                                                Client.field419 = 383;
                                             }

                                             var4 = class0.field7 >> 7;
                                             var5 = class1.field11 >> 7;
                                             var6 = method223(class0.field7, class1.field11, class118.plane);
                                             var7 = 0;
                                             if(var4 > 3 && var5 > 3 && var4 < 100 && var5 < 100) {
                                                for(var8 = var4 - 4; var8 <= 4 + var4; ++var8) {
                                                   for(var21 = var5 - 4; var21 <= var5 + 4; ++var21) {
                                                      var10 = class118.plane;
                                                      if(var10 < 3 && (class10.tileSettings[1][var8][var21] & 2) == 2) {
                                                         ++var10;
                                                      }

                                                      var11 = var6 - class10.tileHeights[var10][var8][var21];
                                                      if(var11 > var7) {
                                                         var7 = var11;
                                                      }
                                                   }
                                                }
                                             }

                                             var8 = var7 * 192;
                                             if(var8 > 98048) {
                                                var8 = 98048;
                                             }

                                             if(var8 < '耀') {
                                                var8 = '耀';
                                             }

                                             if(var8 > Client.field376) {
                                                Client.field376 += (var8 - Client.field376) / 24;
                                             } else if(var8 < Client.field376) {
                                                Client.field376 += (var8 - Client.field376) / 80;
                                             }

                                             if(Client.field499) {
                                                Friend.method154();
                                             }

                                             for(var2 = 0; var2 < 5; ++var2) {
                                                ++Client.field545[var2];
                                             }

                                             Client.chatMessages.method808();
                                             var2 = class57.method995();
                                             var3 = ChatMessages.method829();
                                             if(var2 > 15000 && var3 > 15000) {
                                                Client.field346 = 250;
                                                class115.mouseIdleTicks = 14500;
                                                Client.field336.method2963(60);
                                             }

                                             ++Client.field363;
                                             if(Client.field363 > 500) {
                                                Client.field363 = 0;
                                                var4 = (int)(Math.random() * 8.0D);
                                                if((var4 & 1) == 1) {
                                                   Client.field560 += Client.field522;
                                                }

                                                if((var4 & 2) == 2) {
                                                   Client.field536 += Client.field360;
                                                }

                                                if((var4 & 4) == 4) {
                                                   Client.field382 += Client.field362;
                                                }
                                             }

                                             if(Client.field560 < -50) {
                                                Client.field522 = 2;
                                             }

                                             if(Client.field560 > 50) {
                                                Client.field522 = -2;
                                             }

                                             if(Client.field536 < -55) {
                                                Client.field360 = 2;
                                             }

                                             if(Client.field536 > 55) {
                                                Client.field360 = -2;
                                             }

                                             if(Client.field382 < -40) {
                                                Client.field362 = 1;
                                             }

                                             if(Client.field382 > 40) {
                                                Client.field362 = -1;
                                             }

                                             ++Client.field368;
                                             if(Client.field368 > 500) {
                                                Client.field368 = 0;
                                                var4 = (int)(Math.random() * 8.0D);
                                                if((var4 & 1) == 1) {
                                                   Client.mapScale += Client.field365;
                                                }

                                                if((var4 & 2) == 2) {
                                                   Client.mapScaleDelta += Client.field367;
                                                }
                                             }

                                             if(Client.mapScale < -60) {
                                                Client.field365 = 2;
                                             }

                                             if(Client.mapScale > 60) {
                                                Client.field365 = -2;
                                             }

                                             if(Client.mapScaleDelta < -20) {
                                                Client.field367 = 1;
                                             }

                                             if(Client.mapScaleDelta > 10) {
                                                Client.field367 = -1;
                                             }

                                             for(class16 var43 = (class16)Client.field562.method2367(); var43 != null; var43 = (class16)Client.field562.method2368()) {
                                                if((long)var43.field191 < class2.method27() / 1000L - 5L) {
                                                   if(var43.field183 > 0) {
                                                      Player.sendGameMessage(5, "", var43.field182 + " has logged in.");
                                                   }

                                                   if(var43.field183 == 0) {
                                                      Player.sendGameMessage(5, "", var43.field182 + " has logged out.");
                                                   }

                                                   var43.method2373();
                                                }
                                             }

                                             ++Client.field342;
                                             if(Client.field342 > 50) {
                                                Client.field336.method2963(71);
                                             }

                                             try {
                                                if(class30.field698 != null && Client.field336.offset > 0) {
                                                   class30.field698.method2015(Client.field336.payload, 0, Client.field336.offset);
                                                   Client.field336.offset = 0;
                                                   Client.field342 = 0;
                                                }
                                             } catch (IOException var24) {
                                                class105.method1961();
                                             }

                                             return;
                                          }

                                          var39 = var42.field204;
                                          if(var39.index < 0) {
                                             break;
                                          }

                                          var41 = class108.method1988(var39.parentId);
                                       } while(var41 == null || var41.children == null || var39.index >= var41.children.length || var41.children[var39.index] != var39);

                                       CombatInfo1.method594(var42);
                                    }
                                 }

                                 var39 = var42.field204;
                                 if(var39.index < 0) {
                                    break;
                                 }

                                 var41 = class108.method1988(var39.parentId);
                              } while(null == var41 || var41.children == null || var39.index >= var41.children.length || var41.children[var39.index] != var39);

                              CombatInfo1.method594(var42);
                           }
                        }

                        var39 = var42.field204;
                        if(var39.index < 0) {
                           break;
                        }

                        var41 = class108.method1988(var39.parentId);
                     } while(null == var41 || var41.children == null || var39.index >= var41.children.length || var39 != var41.children[var39.index]);

                     CombatInfo1.method594(var42);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "35814140"
   )
   static void method226() {
      int var0;
      if(Client.field321 == 0) {
         class0.region = new Region(4, 104, 104, class10.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         class63.field1094 = new SpritePixels(512, 512);
         class41.field822 = "Starting game engine...";
         class41.field828 = 5;
         Client.field321 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.field321 == 20) {
            int[] var25 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 128 + 15;
               var3 = 3 * var2 + 600;
               var4 = class84.field1444[var2];
               var25[var1] = var3 * var4 >> 16;
            }

            Region.method1723(var25, 500, 800, 512, 334);
            class41.field822 = "Prepared visibility map";
            class41.field828 = 10;
            Client.field321 = 30;
         } else if(Client.field321 == 30) {
            class8.field86 = class2.method25(0, false, true, true);
            class37.field780 = class2.method25(1, false, true, true);
            ChatMessages.field919 = class2.method25(2, true, false, true);
            field288 = class2.method25(3, false, true, true);
            class5.field60 = class2.method25(4, false, true, true);
            class1.field16 = class2.method25(5, true, true, true);
            class164.field2170 = class2.method25(6, true, true, false);
            class97.field1639 = class2.method25(7, false, true, true);
            class40.field807 = class2.method25(8, false, true, true);
            Client.field324 = class2.method25(9, false, true, true);
            class108.field1736 = class2.method25(10, false, true, true);
            Client.field325 = class2.method25(11, false, true, true);
            WidgetNode.field201 = class2.method25(12, false, true, true);
            class6.field68 = class2.method25(13, true, false, true);
            class94.field1593 = class2.method25(14, false, true, false);
            class47.field924 = class2.method25(15, false, true, true);
            class41.field822 = "Connecting to update server";
            class41.field828 = 20;
            Client.field321 = 40;
         } else if(Client.field321 == 40) {
            byte var21 = 0;
            var0 = var21 + class8.field86.method3291() * 4 / 100;
            var0 += class37.field780.method3291() * 4 / 100;
            var0 += ChatMessages.field919.method3291() * 2 / 100;
            var0 += field288.method3291() * 2 / 100;
            var0 += class5.field60.method3291() * 6 / 100;
            var0 += class1.field16.method3291() * 4 / 100;
            var0 += class164.field2170.method3291() * 2 / 100;
            var0 += class97.field1639.method3291() * 60 / 100;
            var0 += class40.field807.method3291() * 2 / 100;
            var0 += Client.field324.method3291() * 2 / 100;
            var0 += class108.field1736.method3291() * 2 / 100;
            var0 += Client.field325.method3291() * 2 / 100;
            var0 += WidgetNode.field201.method3291() * 2 / 100;
            var0 += class6.field68.method3291() * 2 / 100;
            var0 += class94.field1593.method3291() * 2 / 100;
            var0 += class47.field924.method3291() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class41.field822 = "Checking for updates - " + var0 + "%";
               }

               class41.field828 = 30;
            } else {
               class41.field822 = "Loaded update list";
               class41.field828 = 30;
               Client.field321 = 45;
            }
         } else if(Client.field321 == 45) {
            class149.method2693(22050, !Client.field299, 2);
            class139 var24 = new class139();
            var24.method2507(9, 128);
            GameObject.field1626 = class39.method722(class22.field252, class25.canvas, 0, 22050);
            GameObject.field1626.method994(var24);
            VertexNormal.method1591(class47.field924, class94.field1593, class5.field60, var24);
            class47.field929 = class39.method722(class22.field252, class25.canvas, 1, 2048);
            CombatInfoListHolder.field758 = new class51();
            class47.field929.method994(CombatInfoListHolder.field758);
            Player.field267 = new class65(22050, class57.field1057);
            class41.field822 = "Prepared sound engine";
            class41.field828 = 35;
            Client.field321 = 50;
         } else if(Client.field321 == 50) {
            var0 = 0;
            if(null == class137.field1909) {
               class137.field1909 = class1.method7(class40.field807, class6.field68, "p11_full", "");
            } else {
               ++var0;
            }

            if(class20.field234 == null) {
               class20.field234 = class1.method7(class40.field807, class6.field68, "p12_full", "");
            } else {
               ++var0;
            }

            if(class16.field187 == null) {
               class16.field187 = class1.method7(class40.field807, class6.field68, "b12_full", "");
            } else {
               ++var0;
            }

            if(var0 < 3) {
               class41.field822 = "Loading fonts - " + var0 * 100 / 3 + "%";
               class41.field828 = 40;
            } else {
               DecorativeObject.field1604 = new class230(true);
               class41.field822 = "Loaded fonts";
               class41.field828 = 40;
               Client.field321 = 60;
            }
         } else if(Client.field321 == 60) {
            var0 = class97.method1869(class108.field1736, class40.field807);
            byte var19 = 9;
            if(var0 < var19) {
               class41.field822 = "Loading title screen - " + 100 * var0 / var19 + "%";
               class41.field828 = 50;
            } else {
               class41.field822 = "Loaded title screen";
               class41.field828 = 50;
               class103.setGameState(5);
               Client.field321 = 70;
            }
         } else if(Client.field321 == 70) {
            if(!ChatMessages.field919.method3186()) {
               class41.field822 = "Loading config - " + ChatMessages.field919.method3277() + "%";
               class41.field828 = 60;
            } else {
               class184 var23 = ChatMessages.field919;
               class32.field737 = var23;
               class184 var15 = ChatMessages.field919;
               FloorUnderlayDefinition.field2814 = var15;
               class152.method2705(ChatMessages.field919, class97.field1639);
               class184 var17 = ChatMessages.field919;
               class184 var16 = class97.field1639;
               boolean var20 = Client.field299;
               ObjectComposition.field2918 = var17;
               class205.field3087 = var16;
               ObjectComposition.field2934 = var20;
               FrameMap.method1656(ChatMessages.field919, class97.field1639);
               class108.method1989(ChatMessages.field919, class97.field1639, Client.isMembers, class137.field1909);
               class33.method677(ChatMessages.field919, class8.field86, class37.field780);
               class184 var5 = ChatMessages.field919;
               class184 var6 = class97.field1639;
               class190.field2804 = var5;
               class190.field2805 = var6;
               class2.method23(ChatMessages.field919);
               class184 var7 = ChatMessages.field919;
               class187.field2777 = var7;
               class170.field2346 = class187.field2777.method3192(16);
               class94.method1858(field288, class97.field1639, class40.field807, class6.field68);
               class184 var8 = ChatMessages.field919;
               class186.field2774 = var8;
               class184 var9 = ChatMessages.field919;
               class195.field2863 = var9;
               class184 var10 = ChatMessages.field919;
               class188.field2786 = var10;
               class184 var11 = ChatMessages.field919;
               class157.field2130 = var11;
               Client.chatMessages = new ChatMessages();
               class180.method3177(ChatMessages.field919, class40.field807, class6.field68);
               class184 var12 = ChatMessages.field919;
               class184 var13 = class40.field807;
               class6.field73 = var12;
               class118.field1848 = var13;
               class41.field822 = "Loaded config";
               class41.field828 = 60;
               Client.field321 = 80;
            }
         } else if(Client.field321 != 80) {
            if(Client.field321 == 90) {
               if(!Client.field324.method3186()) {
                  class41.field822 = "Loading textures - " + Client.field324.method3277() + "%";
                  class41.field828 = 90;
               } else {
                  TextureProvider var22 = new TextureProvider(Client.field324, class40.field807, 20, 0.8D, Client.field299?64:128);
                  class84.method1597(var22);
                  class84.method1603(0.8D);
                  class41.field822 = "Loaded textures";
                  class41.field828 = 90;
                  Client.field321 = 110;
               }
            } else if(Client.field321 == 110) {
               class39.field802 = new class20();
               class22.field252.method1912(class39.field802, 10);
               class41.field822 = "Loaded input handler";
               class41.field828 = 94;
               Client.field321 = 120;
            } else if(Client.field321 == 120) {
               if(!class108.field1736.method3238("huffman", "")) {
                  class41.field822 = "Loading wordpack - " + 0 + "%";
                  class41.field828 = 96;
               } else {
                  class145 var14 = new class145(class108.field1736.method3199("huffman", ""));
                  class138.method2405(var14);
                  class41.field822 = "Loaded wordpack";
                  class41.field828 = 96;
                  Client.field321 = 130;
               }
            } else if(Client.field321 == 130) {
               if(!field288.method3186()) {
                  class41.field822 = "Loading interfaces - " + field288.method3277() * 4 / 5 + "%";
                  class41.field828 = 100;
               } else if(!WidgetNode.field201.method3186()) {
                  class41.field822 = "Loading interfaces - " + (80 + WidgetNode.field201.method3277() / 6) + "%";
                  class41.field828 = 100;
               } else if(!class6.field68.method3186()) {
                  class41.field822 = "Loading interfaces - " + (96 + class6.field68.method3277() / 20) + "%";
                  class41.field828 = 100;
               } else {
                  class41.field822 = "Loaded interfaces";
                  class41.field828 = 100;
                  Client.field321 = 140;
               }
            } else if(Client.field321 == 140) {
               class103.setGameState(10);
            }
         } else {
            var0 = 0;
            if(class72.field1180 == null) {
               class72.field1180 = class211.method3824(class40.field807, "compass", "");
            } else {
               ++var0;
            }

            if(class104.field1694 == null) {
               class104.field1694 = class211.method3824(class40.field807, "mapedge", "");
            } else {
               ++var0;
            }

            if(null == class152.field2080) {
               class152.field2080 = Renderable.method1831(class40.field807, "mapscene", "");
            } else {
               ++var0;
            }

            if(null == class157.field2131) {
               class157.field2131 = class215.method3829(class40.field807, "mapfunction", "");
            } else {
               ++var0;
            }

            if(class41.field848 == null) {
               class41.field848 = class215.method3829(class40.field807, "headicons_pk", "");
            } else {
               ++var0;
            }

            if(null == class150.field2053) {
               class150.field2053 = class215.method3829(class40.field807, "headicons_prayer", "");
            } else {
               ++var0;
            }

            if(class101.field1658 == null) {
               class101.field1658 = class215.method3829(class40.field807, "headicons_hint", "");
            } else {
               ++var0;
            }

            if(class26.field593 == null) {
               class26.field593 = class215.method3829(class40.field807, "mapmarker", "");
            } else {
               ++var0;
            }

            if(null == class22.field250) {
               class22.field250 = class215.method3829(class40.field807, "cross", "");
            } else {
               ++var0;
            }

            if(class116.field1821 == null) {
               class116.field1821 = class215.method3829(class40.field807, "mapdots", "");
            } else {
               ++var0;
            }

            if(null == field291) {
               field291 = Renderable.method1831(class40.field807, "scrollbar", "");
            } else {
               ++var0;
            }

            if(class137.field1920 == null) {
               class137.field1920 = Renderable.method1831(class40.field807, "mod_icons", "");
            } else {
               ++var0;
            }

            if(var0 < 12) {
               class41.field822 = "Loading sprites - " + var0 * 100 / 12 + "%";
               class41.field828 = 70;
            } else {
               FontTypeFace.modIcons = class137.field1920;
               class104.field1694.method4048();
               var1 = (int)(Math.random() * 21.0D) - 10;
               var2 = (int)(Math.random() * 21.0D) - 10;
               var3 = (int)(Math.random() * 21.0D) - 10;
               var4 = (int)(Math.random() * 41.0D) - 20;

               for(int var18 = 0; var18 < class157.field2131.length; ++var18) {
                  class157.field2131[var18].method3962(var4 + var1, var4 + var2, var4 + var3);
               }

               class152.field2080[0].method3921(var4 + var1, var4 + var2, var3 + var4);
               class41.field822 = "Loaded sprites";
               class41.field828 = 70;
               Client.field321 = 90;
            }
         }
      }
   }
}
