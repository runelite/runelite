import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("d")
   static class182 field785;
   @ObfuscatedName("ce")
   static Font field786;
   @ObfuscatedName("q")
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIZS)V",
      garbageValue = "30034"
   )
   final void method801(int var1, int var2, boolean var3) {
      if(super.animation != -1 && class195.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field673 < 9) {
               ++super.field673;
            }

            for(int var6 = super.field673; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.field680[var6] = super.field680[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field680[0] = 1;
            return;
         }
      }

      super.field673 = 0;
      super.field682 = 0;
      super.field681 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.pathX[0] * 128 + super.field657 * 64;
      super.y = super.field657 * 64 + 128 * super.pathY[0];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BIB)I",
      garbageValue = "-37"
   )
   public static int method802(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var1 + var6);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var4 + var6] = (byte)var7;
         } else if(var7 == 8364) {
            var3[var6 + var4] = -128;
         } else if(var7 == 8218) {
            var3[var6 + var4] = -126;
         } else if(var7 == 402) {
            var3[var6 + var4] = -125;
         } else if(var7 == 8222) {
            var3[var4 + var6] = -124;
         } else if(var7 == 8230) {
            var3[var4 + var6] = -123;
         } else if(var7 == 8224) {
            var3[var4 + var6] = -122;
         } else if(var7 == 8225) {
            var3[var4 + var6] = -121;
         } else if(var7 == 710) {
            var3[var4 + var6] = -120;
         } else if(var7 == 8240) {
            var3[var4 + var6] = -119;
         } else if(var7 == 352) {
            var3[var4 + var6] = -118;
         } else if(var7 == 8249) {
            var3[var4 + var6] = -117;
         } else if(var7 == 338) {
            var3[var4 + var6] = -116;
         } else if(var7 == 381) {
            var3[var4 + var6] = -114;
         } else if(var7 == 8216) {
            var3[var4 + var6] = -111;
         } else if(var7 == 8217) {
            var3[var4 + var6] = -110;
         } else if(var7 == 8220) {
            var3[var4 + var6] = -109;
         } else if(var7 == 8221) {
            var3[var4 + var6] = -108;
         } else if(var7 == 8226) {
            var3[var6 + var4] = -107;
         } else if(var7 == 8211) {
            var3[var4 + var6] = -106;
         } else if(var7 == 8212) {
            var3[var6 + var4] = -105;
         } else if(var7 == 732) {
            var3[var6 + var4] = -104;
         } else if(var7 == 8482) {
            var3[var6 + var4] = -103;
         } else if(var7 == 353) {
            var3[var6 + var4] = -102;
         } else if(var7 == 8250) {
            var3[var4 + var6] = -101;
         } else if(var7 == 339) {
            var3[var6 + var4] = -100;
         } else if(var7 == 382) {
            var3[var4 + var6] = -98;
         } else if(var7 == 376) {
            var3[var6 + var4] = -97;
         } else {
            var3[var4 + var6] = 63;
         }
      }

      return var5;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-848141872"
   )
   final boolean vmethod803() {
      return null != this.composition;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "-1954276870"
   )
   final void method805(int var1, byte var2) {
      int var3 = super.pathX[0];
      int var4 = super.pathY[0];
      if(var1 == 0) {
         --var3;
         ++var4;
      }

      if(var1 == 1) {
         ++var4;
      }

      if(var1 == 2) {
         ++var3;
         ++var4;
      }

      if(var1 == 3) {
         --var3;
      }

      if(var1 == 4) {
         ++var3;
      }

      if(var1 == 5) {
         --var3;
         --var4;
      }

      if(var1 == 6) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(super.animation != -1 && class195.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(super.field673 < 9) {
         ++super.field673;
      }

      for(int var5 = super.field673; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field680[var5] = super.field680[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field680[0] = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "286397846"
   )
   protected final Model getModel() {
      if(null == this.composition) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class195.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && (super.poseAnimation != super.idlePoseAnimation || var1 == null)?class195.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method3741(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method1647();
            super.field629 = var3.modelHeight;
            if(super.graphic != -1 && super.field661 != -1) {
               Model var4 = Renderable.method1953(super.graphic).method3472(super.field661);
               if(var4 != null) {
                  var4.method1627(0, -super.field664, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3010 == 1) {
               var3.field1402 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "426990435"
   )
   static final void method814() {
      if(Client.field322 > 1) {
         --Client.field322;
      }

      if(Client.field358 > 0) {
         --Client.field358;
      }

      if(Client.field387) {
         Client.field387 = false;
         if(Client.field358 > 0) {
            class6.method73();
         } else {
            class8.setGameState(40);
            class159.field2130 = class149.field2036;
            class149.field2036 = null;
         }

      } else {
         if(!Client.isMenuOpen) {
            class152.method2814();
            Client.menuOptions[0] = "Cancel";
            Client.menuTargets[0] = "";
            Client.menuTypes[0] = 1006;
            Client.menuOptionCount = 1;
         }

         int var0;
         for(var0 = 0; var0 < 100 && Renderable.method1952(); ++var0) {
            ;
         }

         if(Client.gameState == 30) {
            while(true) {
               ClassInfo var1 = (ClassInfo)class227.field3245.method2420();
               boolean var28;
               if(var1 == null) {
                  var28 = false;
               } else {
                  var28 = true;
               }

               int var13;
               if(!var28) {
                  Object var14 = Client.field316.field225;
                  int var2;
                  int var3;
                  int var4;
                  int var5;
                  int var6;
                  int var7;
                  int var8;
                  synchronized(Client.field316.field225) {
                     if(!Client.field301) {
                        Client.field316.field226 = 0;
                     } else if(class115.field1804 != 0 || Client.field316.field226 >= 40) {
                        Client.field348.method3073(98);
                        Client.field348.method2918(0);
                        var13 = Client.field348.offset;
                        var2 = 0;

                        for(var3 = 0; var3 < Client.field316.field226 && Client.field348.offset - var13 < 240; ++var3) {
                           ++var2;
                           var4 = Client.field316.field224[var3];
                           if(var4 < 0) {
                              var4 = 0;
                           } else if(var4 > 502) {
                              var4 = 502;
                           }

                           var5 = Client.field316.field234[var3];
                           if(var5 < 0) {
                              var5 = 0;
                           } else if(var5 > 764) {
                              var5 = 764;
                           }

                           var6 = var5 + var4 * 765;
                           if(Client.field316.field224[var3] == -1 && Client.field316.field234[var3] == -1) {
                              var5 = -1;
                              var4 = -1;
                              var6 = 524287;
                           }

                           if(Client.field475 == var5 && var4 == Client.field318) {
                              if(Client.field464 < 2047) {
                                 ++Client.field464;
                              }
                           } else {
                              var7 = var5 - Client.field475;
                              Client.field475 = var5;
                              var8 = var4 - Client.field318;
                              Client.field318 = var4;
                              if(Client.field464 < 8 && var7 >= -32 && var7 <= 31 && var8 >= -32 && var8 <= 31) {
                                 var7 += 32;
                                 var8 += 32;
                                 Client.field348.method2831(var8 + (var7 << 6) + (Client.field464 << 12));
                                 Client.field464 = 0;
                              } else if(Client.field464 < 8) {
                                 Client.field348.method2961(var6 + 8388608 + (Client.field464 << 19));
                                 Client.field464 = 0;
                              } else {
                                 Client.field348.method2821(var6 + (Client.field464 << 19) + -1073741824);
                                 Client.field464 = 0;
                              }
                           }
                        }

                        Client.field348.method2830(Client.field348.offset - var13);
                        if(var2 >= Client.field316.field226) {
                           Client.field316.field226 = 0;
                        } else {
                           Client.field316.field226 -= var2;

                           for(var3 = 0; var3 < Client.field316.field226; ++var3) {
                              Client.field316.field234[var3] = Client.field316.field234[var3 + var2];
                              Client.field316.field224[var3] = Client.field316.field224[var2 + var3];
                           }
                        }
                     }
                  }

                  if(class115.field1804 == 1 || !class15.field173 && class115.field1804 == 4 || class115.field1804 == 2) {
                     long var15 = (class115.field1807 - Client.field315 * -1L) / 50L;
                     if(var15 > 4095L) {
                        var15 = 4095L;
                     }

                     Client.field315 = class115.field1807 * -1L;
                     var2 = class115.field1806;
                     if(var2 < 0) {
                        var2 = 0;
                     } else if(var2 > class47.field950) {
                        var2 = class47.field950;
                     }

                     var3 = class115.field1796;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > class32.field758) {
                        var3 = class32.field758;
                     }

                     var4 = (int)var15;
                     Client.field348.method3073(187);
                     Client.field348.method2831((class115.field1804 == 2?1:0) + (var4 << 1));
                     Client.field348.method2831(var3);
                     Client.field348.method2831(var2);
                  }

                  if(class105.field1720 > 0) {
                     Client.field348.method3073(116);
                     Client.field348.method2831(0);
                     var0 = Client.field348.offset;
                     long var17 = class0.method11();

                     for(var3 = 0; var3 < class105.field1720; ++var3) {
                        long var19 = var17 - Client.field419;
                        if(var19 > 16777215L) {
                           var19 = 16777215L;
                        }

                        Client.field419 = var17;
                        Client.field348.method2857(class105.field1719[var3]);
                        Client.field348.method2872((int)var19);
                     }

                     Client.field348.method2829(Client.field348.offset - var0);
                  }

                  if(Client.field395 > 0) {
                     --Client.field395;
                  }

                  if(class105.field1713[96] || class105.field1713[97] || class105.field1713[98] || class105.field1713[99]) {
                     Client.field396 = true;
                  }

                  if(Client.field396 && Client.field395 <= 0) {
                     Client.field395 = 20;
                     Client.field396 = false;
                     Client.field348.method3073(216);
                     Client.field348.method2831(Client.mapAngle);
                     Client.field348.method2862(Client.field541);
                  }

                  if(class63.field1108 && !Client.field320) {
                     Client.field320 = true;
                     Client.field348.method3073(174);
                     Client.field348.method2918(1);
                  }

                  if(!class63.field1108 && Client.field320) {
                     Client.field320 = false;
                     Client.field348.method3073(174);
                     Client.field348.method2918(0);
                  }

                  if(WallObject.plane != Client.field534) {
                     Client.field534 = WallObject.plane;
                     class39.method824(WallObject.plane);
                  }

                  if(Client.gameState != 30) {
                     return;
                  }

                  for(class25 var33 = (class25)Client.field436.method2458(); null != var33; var33 = (class25)Client.field436.method2472()) {
                     if(var33.field603 > 0) {
                        --var33.field603;
                     }

                     if(var33.field603 == 0) {
                        if(var33.field596 < 0 || class139.method2660(var33.field596, var33.field601)) {
                           class16.method187(var33.field594, var33.field593, var33.field598, var33.field595, var33.field596, var33.field597, var33.field601);
                           var33.unlink();
                        }
                     } else {
                        if(var33.field602 > 0) {
                           --var33.field602;
                        }

                        if(var33.field602 == 0 && var33.field598 >= 1 && var33.field595 >= 1 && var33.field598 <= 102 && var33.field595 <= 102 && (var33.field599 < 0 || class139.method2660(var33.field599, var33.field608))) {
                           class16.method187(var33.field594, var33.field593, var33.field598, var33.field595, var33.field599, var33.field600, var33.field608);
                           var33.field602 = -1;
                           if(var33.field599 == var33.field596 && var33.field596 == -1) {
                              var33.unlink();
                           } else if(var33.field599 == var33.field596 && var33.field597 == var33.field600 && var33.field608 == var33.field601) {
                              var33.unlink();
                           }
                        }
                     }
                  }

                  for(var0 = 0; var0 < Client.field547; ++var0) {
                     --Client.field550[var0];
                     if(Client.field550[var0] >= -10) {
                        class53 var29 = Client.field349[var0];
                        if(null == var29) {
                           Object var10000 = null;
                           var29 = class53.method1039(Client.field336, Client.field548[var0], 0);
                           if(null == var29) {
                              continue;
                           }

                           Client.field550[var0] += var29.method1042();
                           Client.field349[var0] = var29;
                        }

                        if(Client.field550[var0] < 0) {
                           if(Client.field555[var0] != 0) {
                              var3 = (Client.field555[var0] & 255) * 128;
                              var4 = Client.field555[var0] >> 16 & 255;
                              var5 = var4 * 128 + 64 - class36.localPlayer.x;
                              if(var5 < 0) {
                                 var5 = -var5;
                              }

                              var6 = Client.field555[var0] >> 8 & 255;
                              var7 = 64 + 128 * var6 - class36.localPlayer.y;
                              if(var7 < 0) {
                                 var7 = -var7;
                              }

                              var8 = var5 + var7 - 128;
                              if(var8 > var3) {
                                 Client.field550[var0] = -100;
                                 continue;
                              }

                              if(var8 < 0) {
                                 var8 = 0;
                              }

                              var2 = Client.field546 * (var3 - var8) / var3;
                           } else {
                              var2 = Client.field479;
                           }

                           if(var2 > 0) {
                              class55 var21 = var29.method1040().method1084(World.field706);
                              class66 var22 = class66.method1235(var21, 100, var2);
                              var22.method1243(Client.field549[var0] - 1);
                              class16.field184.method985(var22);
                           }

                           Client.field550[var0] = -100;
                        }
                     } else {
                        --Client.field547;

                        for(var13 = var0; var13 < Client.field547; ++var13) {
                           Client.field548[var13] = Client.field548[var13 + 1];
                           Client.field349[var13] = Client.field349[var13 + 1];
                           Client.field549[var13] = Client.field549[var13 + 1];
                           Client.field550[var13] = Client.field550[var13 + 1];
                           Client.field555[var13] = Client.field555[1 + var13];
                        }

                        --var0;
                     }
                  }

                  if(Client.field545) {
                     if(class138.field1919 != 0) {
                        var28 = true;
                     } else {
                        var28 = class138.field1916.method2607();
                     }

                     if(!var28) {
                        if(Client.field542 != 0 && Client.field421 != -1) {
                           class72.method1464(ScriptState.field127, Client.field421, 0, Client.field542, false);
                        }

                        Client.field545 = false;
                     }
                  }

                  ++Client.field559;
                  if(Client.field559 > 750) {
                     if(Client.field358 > 0) {
                        class6.method73();
                     } else {
                        class8.setGameState(40);
                        class159.field2130 = class149.field2036;
                        class149.field2036 = null;
                     }

                     return;
                  }

                  class212.method3985();

                  for(var0 = 0; var0 < Client.field340; ++var0) {
                     var13 = Client.field345[var0];
                     NPC var23 = Client.cachedNPCs[var13];
                     if(null != var23) {
                        class140.method2666(var23, var23.composition.field3010);
                     }
                  }

                  class33.method785();
                  ++Client.field498;
                  if(Client.field415 != 0) {
                     Client.field414 += 20;
                     if(Client.field414 >= 400) {
                        Client.field415 = 0;
                     }
                  }

                  if(class41.field843 != null) {
                     ++Client.field452;
                     if(Client.field452 >= 15) {
                        class174.method3276(class41.field843);
                        class41.field843 = null;
                     }
                  }

                  Widget var34 = class114.field1787;
                  Widget var30 = class171.field2344;
                  class114.field1787 = null;
                  class171.field2344 = null;
                  Client.field343 = null;
                  Client.field455 = false;
                  Client.field516 = false;
                  Client.field528 = 0;

                  while(class162.method3118() && Client.field528 < 128) {
                     if(Client.field472 >= 2 && class105.field1713[82] && class7.field72 == 66) {
                        String var35 = "";

                        MessageNode var24;
                        for(Iterator var37 = class47.field951.iterator(); var37.hasNext(); var35 = var35 + var24.name + ':' + var24.value + '\n') {
                           var24 = (MessageNode)var37.next();
                        }

                        class115.field1810.setContents(new StringSelection(var35), (ClipboardOwner)null);
                     } else {
                        Client.field323[Client.field528] = class7.field72;
                        Client.field529[Client.field528] = class33.field772;
                        ++Client.field528;
                     }
                  }

                  if(Client.widgetRoot != -1) {
                     var2 = Client.widgetRoot;
                     var3 = class32.field758;
                     var4 = class47.field950;
                     if(class30.method696(var2)) {
                        class8.method98(Widget.widgets[var2], -1, 0, 0, var3, var4, 0, 0);
                     }
                  }

                  ++Client.field490;

                  while(true) {
                     Widget var36;
                     Widget var38;
                     class18 var39;
                     do {
                        var39 = (class18)Client.field543.method2459();
                        if(null == var39) {
                           while(true) {
                              do {
                                 var39 = (class18)Client.field506.method2459();
                                 if(var39 == null) {
                                    while(true) {
                                       do {
                                          var39 = (class18)Client.field435.method2459();
                                          if(null == var39) {
                                             class6.method80();
                                             if(Client.field523 != null) {
                                                class170.method3267();
                                             }

                                             if(class0.field7 != null) {
                                                class174.method3276(class0.field7);
                                                ++Client.field423;
                                                if(class115.field1794 == 0) {
                                                   if(Client.field467) {
                                                      if(class110.field1758 == class0.field7 && Client.field501 != Client.field402) {
                                                         Widget var41 = class0.field7;
                                                         byte var31 = 0;
                                                         if(Client.field468 == 1 && var41.contentType == 206) {
                                                            var31 = 1;
                                                         }

                                                         if(var41.itemIds[Client.field501] <= 0) {
                                                            var31 = 0;
                                                         }

                                                         var5 = class196.method3614(var41);
                                                         boolean var32 = (var5 >> 29 & 1) != 0;
                                                         if(var32) {
                                                            var6 = Client.field402;
                                                            var7 = Client.field501;
                                                            var41.itemIds[var7] = var41.itemIds[var6];
                                                            var41.itemQuantities[var7] = var41.itemQuantities[var6];
                                                            var41.itemIds[var6] = -1;
                                                            var41.itemQuantities[var6] = 0;
                                                         } else if(var31 == 1) {
                                                            var6 = Client.field402;
                                                            var7 = Client.field501;

                                                            while(var7 != var6) {
                                                               if(var6 > var7) {
                                                                  var41.method3214(var6 - 1, var6);
                                                                  --var6;
                                                               } else if(var6 < var7) {
                                                                  var41.method3214(1 + var6, var6);
                                                                  ++var6;
                                                               }
                                                            }
                                                         } else {
                                                            var41.method3214(Client.field501, Client.field402);
                                                         }

                                                         Client.field348.method3073(132);
                                                         Client.field348.method2857(var31);
                                                         Client.field348.method2864(Client.field501);
                                                         Client.field348.method2865(Client.field402);
                                                         Client.field348.method3019(class0.field7.id);
                                                      }
                                                   } else {
                                                      var2 = Buffer.method2893();
                                                      if(Client.menuOptionCount <= 2 || (Client.field442 != 1 || WidgetNode.method192()) && !class149.method2801(var2)) {
                                                         if(Client.menuOptionCount > 0) {
                                                            var3 = Client.field359;
                                                            var4 = Client.field399;
                                                            ObjectComposition.method3659(class9.field90, var3, var4);
                                                            class9.field90 = null;
                                                         }
                                                      } else {
                                                         WidgetNode.method190(Client.field359, Client.field399);
                                                      }
                                                   }

                                                   Client.field452 = 10;
                                                   class115.field1804 = 0;
                                                   class0.field7 = null;
                                                } else if(Client.field423 >= 5 && (class115.field1792 > Client.field359 + 5 || class115.field1792 < Client.field359 - 5 || class115.field1799 > 5 + Client.field399 || class115.field1799 < Client.field399 - 5)) {
                                                   Client.field467 = true;
                                                }
                                             }

                                             if(Region.method1930()) {
                                                var2 = Region.field1522;
                                                var3 = Region.field1523;
                                                Client.field348.method3073(25);
                                                Client.field348.method2918(5);
                                                Client.field348.method2865(var2 + class5.baseX);
                                                Client.field348.method2918(class105.field1713[82]?(class105.field1713[81]?2:1):0);
                                                Client.field348.method2864(var3 + XClanMember.baseY);
                                                Region.method1787();
                                                Client.field412 = class115.field1796;
                                                Client.field413 = class115.field1806;
                                                Client.field415 = 1;
                                                Client.field414 = 0;
                                                Client.flagX = var2;
                                                Client.flagY = var3;
                                             }

                                             if(class114.field1787 != var34) {
                                                if(null != var34) {
                                                   class174.method3276(var34);
                                                }

                                                if(null != class114.field1787) {
                                                   class174.method3276(class114.field1787);
                                                }
                                             }

                                             if(var30 != class171.field2344 && Client.field584 == Client.field299) {
                                                if(var30 != null) {
                                                   class174.method3276(var30);
                                                }

                                                if(class171.field2344 != null) {
                                                   class174.method3276(class171.field2344);
                                                }
                                             }

                                             if(class171.field2344 != null) {
                                                if(Client.field299 < Client.field584) {
                                                   ++Client.field299;
                                                   if(Client.field584 == Client.field299) {
                                                      class174.method3276(class171.field2344);
                                                   }
                                                }
                                             } else if(Client.field299 > 0) {
                                                --Client.field299;
                                             }

                                             class107.method2099();
                                             if(Client.field553) {
                                                var2 = 64 + class155.field2116 * 128;
                                                var3 = 64 + class152.field2086 * 128;
                                                var4 = class2.method19(var2, var3, WallObject.plane) - Frames.field1580;
                                                if(VertexNormal.cameraX < var2) {
                                                   VertexNormal.cameraX += XGrandExchangeOffer.field45 + (var2 - VertexNormal.cameraX) * class41.field873 / 1000;
                                                   if(VertexNormal.cameraX > var2) {
                                                      VertexNormal.cameraX = var2;
                                                   }
                                                }

                                                if(VertexNormal.cameraX > var2) {
                                                   VertexNormal.cameraX -= XGrandExchangeOffer.field45 + class41.field873 * (VertexNormal.cameraX - var2) / 1000;
                                                   if(VertexNormal.cameraX < var2) {
                                                      VertexNormal.cameraX = var2;
                                                   }
                                                }

                                                if(class36.cameraZ < var4) {
                                                   class36.cameraZ += (var4 - class36.cameraZ) * class41.field873 / 1000 + XGrandExchangeOffer.field45;
                                                   if(class36.cameraZ > var4) {
                                                      class36.cameraZ = var4;
                                                   }
                                                }

                                                if(class36.cameraZ > var4) {
                                                   class36.cameraZ -= (class36.cameraZ - var4) * class41.field873 / 1000 + XGrandExchangeOffer.field45;
                                                   if(class36.cameraZ < var4) {
                                                      class36.cameraZ = var4;
                                                   }
                                                }

                                                if(class37.cameraY < var3) {
                                                   class37.cameraY += XGrandExchangeOffer.field45 + (var3 - class37.cameraY) * class41.field873 / 1000;
                                                   if(class37.cameraY > var3) {
                                                      class37.cameraY = var3;
                                                   }
                                                }

                                                if(class37.cameraY > var3) {
                                                   class37.cameraY -= XGrandExchangeOffer.field45 + class41.field873 * (class37.cameraY - var3) / 1000;
                                                   if(class37.cameraY < var3) {
                                                      class37.cameraY = var3;
                                                   }
                                                }

                                                var2 = 64 + class31.field740 * 128;
                                                var3 = 64 + class161.field2149 * 128;
                                                var4 = class2.method19(var2, var3, WallObject.plane) - class138.field1920;
                                                var5 = var2 - VertexNormal.cameraX;
                                                var6 = var4 - class36.cameraZ;
                                                var7 = var3 - class37.cameraY;
                                                var8 = (int)Math.sqrt((double)(var7 * var7 + var5 * var5));
                                                int var25 = (int)(Math.atan2((double)var6, (double)var8) * 325.949D) & 2047;
                                                int var10 = (int)(Math.atan2((double)var5, (double)var7) * -325.949D) & 2047;
                                                if(var25 < 128) {
                                                   var25 = 128;
                                                }

                                                if(var25 > 383) {
                                                   var25 = 383;
                                                }

                                                if(Actor.cameraPitch < var25) {
                                                   Actor.cameraPitch += class183.field2727 + (var25 - Actor.cameraPitch) * class63.field1105 / 1000;
                                                   if(Actor.cameraPitch > var25) {
                                                      Actor.cameraPitch = var25;
                                                   }
                                                }

                                                if(Actor.cameraPitch > var25) {
                                                   Actor.cameraPitch -= (Actor.cameraPitch - var25) * class63.field1105 / 1000 + class183.field2727;
                                                   if(Actor.cameraPitch < var25) {
                                                      Actor.cameraPitch = var25;
                                                   }
                                                }

                                                int var11 = var10 - class26.cameraYaw;
                                                if(var11 > 1024) {
                                                   var11 -= 2048;
                                                }

                                                if(var11 < -1024) {
                                                   var11 += 2048;
                                                }

                                                if(var11 > 0) {
                                                   class26.cameraYaw += var11 * class63.field1105 / 1000 + class183.field2727;
                                                   class26.cameraYaw &= 2047;
                                                }

                                                if(var11 < 0) {
                                                   class26.cameraYaw -= class183.field2727 + -var11 * class63.field1105 / 1000;
                                                   class26.cameraYaw &= 2047;
                                                }

                                                int var12 = var10 - class26.cameraYaw;
                                                if(var12 > 1024) {
                                                   var12 -= 2048;
                                                }

                                                if(var12 < -1024) {
                                                   var12 += 2048;
                                                }

                                                if(var12 < 0 && var11 > 0 || var12 > 0 && var11 < 0) {
                                                   class26.cameraYaw = var10;
                                                }
                                             }

                                             for(var2 = 0; var2 < 5; ++var2) {
                                                ++Client.field558[var2];
                                             }

                                             class20.chatMessages.method915();
                                             var2 = WidgetNode.method195();
                                             var3 = class30.method694();
                                             if(var2 > 15000 && var3 > 15000) {
                                                Client.field358 = 250;
                                                class115.mouseIdleTicks = 14500;
                                                Client.field348.method3073(47);
                                             }

                                             ++Client.field357;
                                             if(Client.field357 > 500) {
                                                Client.field357 = 0;
                                                var4 = (int)(Math.random() * 8.0D);
                                                if((var4 & 1) == 1) {
                                                   Client.field481 += Client.field370;
                                                }

                                                if((var4 & 2) == 2) {
                                                   Client.field371 += Client.field372;
                                                }

                                                if((var4 & 4) == 4) {
                                                   Client.field339 += Client.field439;
                                                }
                                             }

                                             if(Client.field481 < -50) {
                                                Client.field370 = 2;
                                             }

                                             if(Client.field481 > 50) {
                                                Client.field370 = -2;
                                             }

                                             if(Client.field371 < -55) {
                                                Client.field372 = 2;
                                             }

                                             if(Client.field371 > 55) {
                                                Client.field372 = -2;
                                             }

                                             if(Client.field339 < -40) {
                                                Client.field439 = 1;
                                             }

                                             if(Client.field339 > 40) {
                                                Client.field439 = -1;
                                             }

                                             ++Client.field578;
                                             if(Client.field578 > 500) {
                                                Client.field578 = 0;
                                                var4 = (int)(Math.random() * 8.0D);
                                                if((var4 & 1) == 1) {
                                                   Client.mapScale += Client.field377;
                                                }

                                                if((var4 & 2) == 2) {
                                                   Client.mapScaleDelta += Client.field379;
                                                }
                                             }

                                             if(Client.mapScale < -60) {
                                                Client.field377 = 2;
                                             }

                                             if(Client.mapScale > 60) {
                                                Client.field377 = -2;
                                             }

                                             if(Client.mapScaleDelta < -20) {
                                                Client.field379 = 1;
                                             }

                                             if(Client.mapScaleDelta > 10) {
                                                Client.field379 = -1;
                                             }

                                             for(class16 var40 = (class16)Client.field575.method2488(); var40 != null; var40 = (class16)Client.field575.method2489()) {
                                                if((long)var40.field181 < class0.method11() / 1000L - 5L) {
                                                   if(var40.field182 > 0) {
                                                      class16.sendGameMessage(5, "", var40.field180 + " has logged in.");
                                                   }

                                                   if(var40.field182 == 0) {
                                                      class16.sendGameMessage(5, "", var40.field180 + " has logged out.");
                                                   }

                                                   var40.method2496();
                                                }
                                             }

                                             ++Client.field354;
                                             if(Client.field354 > 50) {
                                                Client.field348.method3073(8);
                                             }

                                             try {
                                                if(class149.field2036 != null && Client.field348.offset > 0) {
                                                   class149.field2036.method2114(Client.field348.payload, 0, Client.field348.offset);
                                                   Client.field348.offset = 0;
                                                   Client.field354 = 0;
                                                }
                                             } catch (IOException var26) {
                                                if(Client.field358 > 0) {
                                                   class6.method73();
                                                } else {
                                                   class8.setGameState(40);
                                                   class159.field2130 = class149.field2036;
                                                   class149.field2036 = null;
                                                }
                                             }

                                             return;
                                          }

                                          var36 = var39.field198;
                                          if(var36.index < 0) {
                                             break;
                                          }

                                          var38 = class179.method3296(var36.parentId);
                                       } while(null == var38 || var38.children == null || var36.index >= var38.children.length || var36 != var38.children[var36.index]);

                                       class174.method3275(var39, 200000);
                                    }
                                 }

                                 var36 = var39.field198;
                                 if(var36.index < 0) {
                                    break;
                                 }

                                 var38 = class179.method3296(var36.parentId);
                              } while(null == var38 || var38.children == null || var36.index >= var38.children.length || var36 != var38.children[var36.index]);

                              FloorUnderlayDefinition.method3491(var39);
                           }
                        }

                        var36 = var39.field198;
                        if(var36.index < 0) {
                           break;
                        }

                        var38 = class179.method3296(var36.parentId);
                     } while(var38 == null || var38.children == null || var36.index >= var38.children.length || var38.children[var36.index] != var36);

                     FloorUnderlayDefinition.method3491(var39);
                  }
               }

               Client.field348.method3073(173);
               Client.field348.method2918(0);
               var13 = Client.field348.offset;
               Overlay.method3774(Client.field348);
               Client.field348.method2830(Client.field348.offset - var13);
            }
         }
      }
   }
}
