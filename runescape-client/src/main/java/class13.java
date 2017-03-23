import java.awt.Desktop;
import java.awt.Image;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public class class13 {
   @ObfuscatedName("po")
   static class1 field138;
   @ObfuscatedName("re")
   protected static Image field143;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "238960799"
   )
   static int method158(int var0, Script var1, boolean var2) {
      if(var0 < 1000) {
         return CipherBuffer.method3104(var0, var1, var2);
      } else if(var0 < 1100) {
         return class97.method1961(var0, var1, var2);
      } else if(var0 < 1200) {
         return Actor.method573(var0, var1, var2);
      } else if(var0 < 1300) {
         return class15.method169(var0, var1, var2);
      } else if(var0 < 1400) {
         return class49.method929(var0, var1, var2);
      } else if(var0 < 1500) {
         return Player.method235(var0, var1, var2);
      } else {
         byte var3;
         Widget var28;
         if(var0 < 1600) {
            var28 = var2?class154.field2123:class32.field746;
            if(var0 == 1500) {
               class32.field743[++class30.field713 - 1] = var28.relativeX;
               var3 = 1;
            } else if(var0 == 1501) {
               class32.field743[++class30.field713 - 1] = var28.relativeY;
               var3 = 1;
            } else if(var0 == 1502) {
               class32.field743[++class30.field713 - 1] = var28.width;
               var3 = 1;
            } else if(var0 == 1503) {
               class32.field743[++class30.field713 - 1] = var28.height;
               var3 = 1;
            } else if(var0 == 1504) {
               class32.field743[++class30.field713 - 1] = var28.isHidden?1:0;
               var3 = 1;
            } else if(var0 == 1505) {
               class32.field743[++class30.field713 - 1] = var28.parentId;
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else {
            Widget var32;
            if(var0 < 1700) {
               var32 = var2?class154.field2123:class32.field746;
               if(var0 == 1600) {
                  class32.field743[++class30.field713 - 1] = var32.scrollX;
                  var3 = 1;
               } else if(var0 == 1601) {
                  class32.field743[++class30.field713 - 1] = var32.scrollY;
                  var3 = 1;
               } else if(var0 == 1602) {
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var32.text;
                  var3 = 1;
               } else if(var0 == 1603) {
                  class32.field743[++class30.field713 - 1] = var32.scrollWidth;
                  var3 = 1;
               } else if(var0 == 1604) {
                  class32.field743[++class30.field713 - 1] = var32.scrollHeight;
                  var3 = 1;
               } else if(var0 == 1605) {
                  class32.field743[++class30.field713 - 1] = var32.field2320;
                  var3 = 1;
               } else if(var0 == 1606) {
                  class32.field743[++class30.field713 - 1] = var32.rotationX;
                  var3 = 1;
               } else if(var0 == 1607) {
                  class32.field743[++class30.field713 - 1] = var32.rotationY;
                  var3 = 1;
               } else if(var0 == 1608) {
                  class32.field743[++class30.field713 - 1] = var32.rotationZ;
                  var3 = 1;
               } else if(var0 == 1609) {
                  class32.field743[++class30.field713 - 1] = var32.opacity;
                  var3 = 1;
               } else if(var0 == 1610) {
                  class32.field743[++class30.field713 - 1] = var32.field2251;
                  var3 = 1;
               } else if(var0 == 1611) {
                  class32.field743[++class30.field713 - 1] = var32.textColor;
                  var3 = 1;
               } else if(var0 == 1612) {
                  class32.field743[++class30.field713 - 1] = var32.field2245;
                  var3 = 1;
               } else if(var0 == 1613) {
                  class32.field743[++class30.field713 - 1] = var32.field2249.vmethod4085();
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 1800) {
               var28 = var2?class154.field2123:class32.field746;
               if(var0 == 1700) {
                  class32.field743[++class30.field713 - 1] = var28.item;
                  var3 = 1;
               } else if(var0 == 1701) {
                  if(var28.item != -1) {
                     class32.field743[++class30.field713 - 1] = var28.stackSize;
                  } else {
                     class32.field743[++class30.field713 - 1] = 0;
                  }

                  var3 = 1;
               } else if(var0 == 1702) {
                  class32.field743[++class30.field713 - 1] = var28.index;
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 1900) {
               return class1.method4(var0, var1, var2);
            } else if(var0 < 2000) {
               return class202.method3824(var0, var1, var2);
            } else if(var0 < 2100) {
               return class97.method1961(var0, var1, var2);
            } else if(var0 < 2200) {
               return Actor.method573(var0, var1, var2);
            } else if(var0 < 2300) {
               return class15.method169(var0, var1, var2);
            } else if(var0 < 2400) {
               return class49.method929(var0, var1, var2);
            } else if(var0 < 2500) {
               return Player.method235(var0, var1, var2);
            } else if(var0 < 2600) {
               return Ignore.method180(var0, var1, var2);
            } else if(var0 < 2700) {
               var32 = FaceNormal.method1932(class32.field743[--class30.field713]);
               if(var0 == 2600) {
                  class32.field743[++class30.field713 - 1] = var32.scrollX;
                  var3 = 1;
               } else if(var0 == 2601) {
                  class32.field743[++class30.field713 - 1] = var32.scrollY;
                  var3 = 1;
               } else if(var0 == 2602) {
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var32.text;
                  var3 = 1;
               } else if(var0 == 2603) {
                  class32.field743[++class30.field713 - 1] = var32.scrollWidth;
                  var3 = 1;
               } else if(var0 == 2604) {
                  class32.field743[++class30.field713 - 1] = var32.scrollHeight;
                  var3 = 1;
               } else if(var0 == 2605) {
                  class32.field743[++class30.field713 - 1] = var32.field2320;
                  var3 = 1;
               } else if(var0 == 2606) {
                  class32.field743[++class30.field713 - 1] = var32.rotationX;
                  var3 = 1;
               } else if(var0 == 2607) {
                  class32.field743[++class30.field713 - 1] = var32.rotationY;
                  var3 = 1;
               } else if(var0 == 2608) {
                  class32.field743[++class30.field713 - 1] = var32.rotationZ;
                  var3 = 1;
               } else if(var0 == 2609) {
                  class32.field743[++class30.field713 - 1] = var32.opacity;
                  var3 = 1;
               } else if(var0 == 2610) {
                  class32.field743[++class30.field713 - 1] = var32.field2251;
                  var3 = 1;
               } else if(var0 == 2611) {
                  class32.field743[++class30.field713 - 1] = var32.textColor;
                  var3 = 1;
               } else if(var0 == 2612) {
                  class32.field743[++class30.field713 - 1] = var32.field2245;
                  var3 = 1;
               } else if(var0 == 2613) {
                  class32.field743[++class30.field713 - 1] = var32.field2249.vmethod4085();
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else {
               int var4;
               if(var0 < 2800) {
                  if(var0 == 2700) {
                     var32 = FaceNormal.method1932(class32.field743[--class30.field713]);
                     class32.field743[++class30.field713 - 1] = var32.item;
                     var3 = 1;
                  } else if(var0 == 2701) {
                     var32 = FaceNormal.method1932(class32.field743[--class30.field713]);
                     if(var32.item != -1) {
                        class32.field743[++class30.field713 - 1] = var32.stackSize;
                     } else {
                        class32.field743[++class30.field713 - 1] = 0;
                     }

                     var3 = 1;
                  } else if(var0 == 2702) {
                     var4 = class32.field743[--class30.field713];
                     WidgetNode var39 = (WidgetNode)Client.componentTable.method2417((long)var4);
                     if(null != var39) {
                        class32.field743[++class30.field713 - 1] = 1;
                     } else {
                        class32.field743[++class30.field713 - 1] = 0;
                     }

                     var3 = 1;
                  } else if(var0 == 2706) {
                     class32.field743[++class30.field713 - 1] = Client.widgetRoot;
                     var3 = 1;
                  } else {
                     var3 = 2;
                  }

                  return var3;
               } else {
                  int var5;
                  int var6;
                  int var8;
                  int var40;
                  if(var0 < 2900) {
                     var32 = FaceNormal.method1932(class32.field743[--class30.field713]);
                     if(var0 == 2800) {
                        int[] var38 = class32.field743;
                        var6 = ++class30.field713 - 1;
                        var8 = FloorUnderlayDefinition.method3533(var32);
                        var40 = var8 >> 11 & 63;
                        var38[var6] = var40;
                        var3 = 1;
                     } else if(var0 == 2801) {
                        var5 = class32.field743[--class30.field713];
                        --var5;
                        if(null != var32.actions && var5 < var32.actions.length && var32.actions[var5] != null) {
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var32.actions[var5];
                        } else {
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                        }

                        var3 = 1;
                     } else if(var0 == 2802) {
                        if(null == var32.name) {
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                        } else {
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var32.name;
                        }

                        var3 = 1;
                     } else {
                        var3 = 2;
                     }

                     return var3;
                  } else if(var0 < 3000) {
                     return class202.method3824(var0, var1, var2);
                  } else if(var0 < 3200) {
                     return class116.method2301(var0, var1, var2);
                  } else if(var0 < 3300) {
                     if(var0 == 3200) {
                        class30.field713 -= 3;
                        var4 = class32.field743[class30.field713];
                        var5 = class32.field743[class30.field713 + 1];
                        var6 = class32.field743[2 + class30.field713];
                        if(Client.field543 != 0 && var5 != 0 && Client.field545 < 50) {
                           Client.field546[Client.field545] = var4;
                           Client.field547[Client.field545] = var5;
                           Client.field334[Client.field545] = var6;
                           Client.field550[Client.field545] = null;
                           Client.field464[Client.field545] = 0;
                           ++Client.field545;
                        }

                        var3 = 1;
                     } else if(var0 == 3201) {
                        var4 = class32.field743[--class30.field713];
                        if(var4 == -1 && !Client.field542) {
                           TextureProvider.method1486();
                        } else if(var4 != -1 && var4 != Client.field541 && Client.field540 != 0 && !Client.field542) {
                           class184 var37 = Client.field586;
                           var6 = Client.field540;
                           class138.field1940 = 1;
                           class149.field2061 = var37;
                           class138.field1941 = var4;
                           RSCanvas.field1777 = 0;
                           NPC.field783 = var6;
                           class138.field1938 = false;
                           class138.field1937 = 2;
                        }

                        Client.field541 = var4;
                        var3 = 1;
                     } else if(var0 == 3202) {
                        class30.field713 -= 2;
                        var4 = class32.field743[class30.field713];
                        var5 = class32.field743[1 + class30.field713];
                        if(Client.field540 != 0 && var4 != -1) {
                           TextureProvider.method1487(Friend.field162, var4, 0, Client.field540, false);
                           Client.field542 = true;
                        }

                        var3 = 1;
                     } else {
                        var3 = 2;
                     }

                     return var3;
                  } else {
                     int var10;
                     int var17;
                     if(var0 < 3400) {
                        if(var0 == 3300) {
                           class32.field743[++class30.field713 - 1] = Client.gameCycle;
                           var3 = 1;
                        } else if(var0 == 3301) {
                           class30.field713 -= 2;
                           var4 = class32.field743[class30.field713];
                           var5 = class32.field743[class30.field713 + 1];
                           class32.field743[++class30.field713 - 1] = class150.method2841(var4, var5);
                           var3 = 1;
                        } else {
                           XItemContainer var29;
                           int[] var44;
                           if(var0 == 3302) {
                              class30.field713 -= 2;
                              var4 = class32.field743[class30.field713];
                              var5 = class32.field743[class30.field713 + 1];
                              var44 = class32.field743;
                              var40 = ++class30.field713 - 1;
                              var29 = (XItemContainer)XItemContainer.itemContainers.method2417((long)var4);
                              if(var29 == null) {
                                 var8 = 0;
                              } else if(var5 >= 0 && var5 < var29.stackSizes.length) {
                                 var8 = var29.stackSizes[var5];
                              } else {
                                 var8 = 0;
                              }

                              var44[var40] = var8;
                              var3 = 1;
                           } else if(var0 == 3303) {
                              class30.field713 -= 2;
                              var4 = class32.field743[class30.field713];
                              var5 = class32.field743[class30.field713 + 1];
                              var44 = class32.field743;
                              var40 = ++class30.field713 - 1;
                              var29 = (XItemContainer)XItemContainer.itemContainers.method2417((long)var4);
                              if(var29 == null) {
                                 var8 = 0;
                              } else if(var5 == -1) {
                                 var8 = 0;
                              } else {
                                 var10 = 0;

                                 for(var17 = 0; var17 < var29.stackSizes.length; ++var17) {
                                    if(var5 == var29.itemIds[var17]) {
                                       var10 += var29.stackSizes[var17];
                                    }
                                 }

                                 var8 = var10;
                              }

                              var44[var40] = var8;
                              var3 = 1;
                           } else if(var0 == 3304) {
                              var4 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = class20.method181(var4).field2785;
                              var3 = 1;
                           } else if(var0 == 3305) {
                              var4 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = Client.boostedSkillLevels[var4];
                              var3 = 1;
                           } else if(var0 == 3306) {
                              var4 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = Client.realSkillLevels[var4];
                              var3 = 1;
                           } else if(var0 == 3307) {
                              var4 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = Client.skillExperiences[var4];
                              var3 = 1;
                           } else if(var0 == 3308) {
                              var4 = Sequence.plane;
                              var5 = class119.baseX + (Projectile.localPlayer.x >> 7);
                              var6 = class187.baseY + (Projectile.localPlayer.y >> 7);
                              class32.field743[++class30.field713 - 1] = var6 + (var4 << 28) + (var5 << 14);
                              var3 = 1;
                           } else if(var0 == 3309) {
                              var4 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = var4 >> 14 & 16383;
                              var3 = 1;
                           } else if(var0 == 3310) {
                              var4 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = var4 >> 28;
                              var3 = 1;
                           } else if(var0 == 3311) {
                              var4 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = var4 & 16383;
                              var3 = 1;
                           } else if(var0 == 3312) {
                              class32.field743[++class30.field713 - 1] = Client.isMembers?1:0;
                              var3 = 1;
                           } else if(var0 == 3313) {
                              class30.field713 -= 2;
                              var4 = '耀' + class32.field743[class30.field713];
                              var5 = class32.field743[class30.field713 + 1];
                              class32.field743[++class30.field713 - 1] = class150.method2841(var4, var5);
                              var3 = 1;
                           } else if(var0 == 3314) {
                              class30.field713 -= 2;
                              var4 = '耀' + class32.field743[class30.field713];
                              var5 = class32.field743[1 + class30.field713];
                              var44 = class32.field743;
                              var40 = ++class30.field713 - 1;
                              var29 = (XItemContainer)XItemContainer.itemContainers.method2417((long)var4);
                              if(null == var29) {
                                 var8 = 0;
                              } else if(var5 >= 0 && var5 < var29.stackSizes.length) {
                                 var8 = var29.stackSizes[var5];
                              } else {
                                 var8 = 0;
                              }

                              var44[var40] = var8;
                              var3 = 1;
                           } else if(var0 == 3315) {
                              class30.field713 -= 2;
                              var4 = class32.field743[class30.field713] + '耀';
                              var5 = class32.field743[1 + class30.field713];
                              var44 = class32.field743;
                              var40 = ++class30.field713 - 1;
                              var29 = (XItemContainer)XItemContainer.itemContainers.method2417((long)var4);
                              if(var29 == null) {
                                 var8 = 0;
                              } else if(var5 == -1) {
                                 var8 = 0;
                              } else {
                                 var10 = 0;

                                 for(var17 = 0; var17 < var29.stackSizes.length; ++var17) {
                                    if(var29.itemIds[var17] == var5) {
                                       var10 += var29.stackSizes[var17];
                                    }
                                 }

                                 var8 = var10;
                              }

                              var44[var40] = var8;
                              var3 = 1;
                           } else if(var0 == 3316) {
                              if(Client.field470 >= 2) {
                                 class32.field743[++class30.field713 - 1] = Client.field470;
                              } else {
                                 class32.field743[++class30.field713 - 1] = 0;
                              }

                              var3 = 1;
                           } else if(var0 == 3317) {
                              class32.field743[++class30.field713 - 1] = Client.field319;
                              var3 = 1;
                           } else if(var0 == 3318) {
                              class32.field743[++class30.field713 - 1] = Client.world;
                              var3 = 1;
                           } else if(var0 == 3321) {
                              class32.field743[++class30.field713 - 1] = Client.energy;
                              var3 = 1;
                           } else if(var0 == 3322) {
                              class32.field743[++class30.field713 - 1] = Client.weight;
                              var3 = 1;
                           } else if(var0 == 3323) {
                              if(Client.field368) {
                                 class32.field743[++class30.field713 - 1] = 1;
                              } else {
                                 class32.field743[++class30.field713 - 1] = 0;
                              }

                              var3 = 1;
                           } else if(var0 == 3324) {
                              class32.field743[++class30.field713 - 1] = Client.flags;
                              var3 = 1;
                           } else {
                              var3 = 2;
                           }
                        }

                        return var3;
                     } else if(var0 < 3500) {
                        if(var0 == 3400) {
                           class30.field713 -= 2;
                           var4 = class32.field743[class30.field713];
                           var5 = class32.field743[class30.field713 + 1];
                           class195 var7 = (class195)class195.field2863.get((long)var4);
                           class195 var42;
                           if(var7 != null) {
                              var42 = var7;
                           } else {
                              byte[] var35 = class195.field2867.getConfigData(8, var4);
                              var7 = new class195();
                              if(var35 != null) {
                                 var7.method3600(new Buffer(var35));
                              }

                              class195.field2863.put(var7, (long)var4);
                              var42 = var7;
                           }

                           var7 = var42;
                           if(var42.field2865 != 115) {
                              ;
                           }

                           for(var8 = 0; var8 < var7.field2868; ++var8) {
                              if(var7.field2862[var8] == var5) {
                                 class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var7.field2871[var8];
                                 var7 = null;
                                 break;
                              }
                           }

                           if(var7 != null) {
                              class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var7.field2866;
                           }

                           var3 = 1;
                        } else if(var0 == 3408) {
                           class30.field713 -= 4;
                           var4 = class32.field743[class30.field713];
                           var5 = class32.field743[class30.field713 + 1];
                           var6 = class32.field743[2 + class30.field713];
                           var40 = class32.field743[class30.field713 + 3];
                           class195 var9 = (class195)class195.field2863.get((long)var6);
                           class195 var36;
                           if(var9 != null) {
                              var36 = var9;
                           } else {
                              byte[] var43 = class195.field2867.getConfigData(8, var6);
                              var9 = new class195();
                              if(var43 != null) {
                                 var9.method3600(new Buffer(var43));
                              }

                              class195.field2863.put(var9, (long)var6);
                              var36 = var9;
                           }

                           var9 = var36;
                           if(var4 == var36.field2864 && var5 == var36.field2865) {
                              for(var10 = 0; var10 < var9.field2868; ++var10) {
                                 if(var40 == var9.field2862[var10]) {
                                    if(var5 == 115) {
                                       class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var9.field2871[var10];
                                    } else {
                                       class32.field743[++class30.field713 - 1] = var9.field2872[var10];
                                    }

                                    var9 = null;
                                    break;
                                 }
                              }

                              if(null != var9) {
                                 if(var5 == 115) {
                                    class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var9.field2866;
                                 } else {
                                    class32.field743[++class30.field713 - 1] = var9.field2869;
                                 }
                              }

                              var3 = 1;
                           } else {
                              if(var5 == 115) {
                                 class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "null";
                              } else {
                                 class32.field743[++class30.field713 - 1] = 0;
                              }

                              var3 = 1;
                           }
                        } else {
                           var3 = 2;
                        }

                        return var3;
                     } else if(var0 < 3700) {
                        return class101.method1998(var0, var1, var2);
                     } else {
                        long var22;
                        int var27;
                        if(var0 < 4000) {
                           if(var0 == 3903) {
                              var4 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = Client.grandExchangeOffers[var4].method45();
                              var3 = 1;
                           } else if(var0 == 3904) {
                              var4 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = Client.grandExchangeOffers[var4].itemId;
                              var3 = 1;
                           } else if(var0 == 3905) {
                              var4 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = Client.grandExchangeOffers[var4].price;
                              var3 = 1;
                           } else if(var0 == 3906) {
                              var4 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = Client.grandExchangeOffers[var4].totalQuantity;
                              var3 = 1;
                           } else if(var0 == 3907) {
                              var4 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = Client.grandExchangeOffers[var4].quantitySold;
                              var3 = 1;
                           } else if(var0 == 3908) {
                              var4 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = Client.grandExchangeOffers[var4].spent;
                              var3 = 1;
                           } else if(var0 == 3910) {
                              var4 = class32.field743[--class30.field713];
                              var5 = Client.grandExchangeOffers[var4].method31();
                              class32.field743[++class30.field713 - 1] = var5 == 0?1:0;
                              var3 = 1;
                           } else if(var0 == 3911) {
                              var4 = class32.field743[--class30.field713];
                              var5 = Client.grandExchangeOffers[var4].method31();
                              class32.field743[++class30.field713 - 1] = var5 == 2?1:0;
                              var3 = 1;
                           } else if(var0 == 3912) {
                              var4 = class32.field743[--class30.field713];
                              var5 = Client.grandExchangeOffers[var4].method31();
                              class32.field743[++class30.field713 - 1] = var5 == 5?1:0;
                              var3 = 1;
                           } else if(var0 == 3913) {
                              var4 = class32.field743[--class30.field713];
                              var5 = Client.grandExchangeOffers[var4].method31();
                              class32.field743[++class30.field713 - 1] = var5 == 1?1:0;
                              var3 = 1;
                           } else {
                              boolean var34;
                              if(var0 == 3914) {
                                 var34 = class32.field743[--class30.field713] == 1;
                                 if(field138 != null) {
                                    field138.method5(class1.field10, var34);
                                 }

                                 var3 = 1;
                              } else if(var0 == 3915) {
                                 var34 = class32.field743[--class30.field713] == 1;
                                 if(null != field138) {
                                    field138.method5(class1.field16, var34);
                                 }

                                 var3 = 1;
                              } else if(var0 == 3916) {
                                 class30.field713 -= 2;
                                 var34 = class32.field743[class30.field713] == 1;
                                 boolean var31 = class32.field743[1 + class30.field713] == 1;
                                 if(field138 != null) {
                                    field138.method5(new class44(var31), var34);
                                 }

                                 var3 = 1;
                              } else if(var0 == 3917) {
                                 var34 = class32.field743[--class30.field713] == 1;
                                 if(null != field138) {
                                    field138.method5(class1.field8, var34);
                                 }

                                 var3 = 1;
                              } else if(var0 == 3918) {
                                 var34 = class32.field743[--class30.field713] == 1;
                                 if(null != field138) {
                                    field138.method5(class1.field11, var34);
                                 }

                                 var3 = 1;
                              } else if(var0 == 3919) {
                                 class32.field743[++class30.field713 - 1] = null == field138?0:field138.field13.size();
                                 var3 = 1;
                              } else {
                                 class2 var33;
                                 if(var0 == 3920) {
                                    var4 = class32.field743[--class30.field713];
                                    var33 = (class2)field138.field13.get(var4);
                                    class32.field743[++class30.field713 - 1] = var33.field22;
                                    var3 = 1;
                                 } else if(var0 == 3921) {
                                    var4 = class32.field743[--class30.field713];
                                    var33 = (class2)field138.field13.get(var4);
                                    class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var33.method10();
                                    var3 = 1;
                                 } else if(var0 == 3922) {
                                    var4 = class32.field743[--class30.field713];
                                    var33 = (class2)field138.field13.get(var4);
                                    class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var33.method15();
                                    var3 = 1;
                                 } else if(var0 == 3923) {
                                    var4 = class32.field743[--class30.field713];
                                    var33 = (class2)field138.field13.get(var4);
                                    var22 = class45.method867() - class103.field1698 - var33.field18;
                                    var8 = (int)(var22 / 3600000L);
                                    var27 = (int)((var22 - (long)(var8 * 3600000)) / 60000L);
                                    var10 = (int)((var22 - (long)(var8 * 3600000) - (long)(var27 * '\uea60')) / 1000L);
                                    String var30 = var8 + ":" + var27 / 10 + var27 % 10 + ":" + var10 / 10 + var10 % 10;
                                    class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var30;
                                    var3 = 1;
                                 } else if(var0 == 3924) {
                                    var4 = class32.field743[--class30.field713];
                                    var33 = (class2)field138.field13.get(var4);
                                    class32.field743[++class30.field713 - 1] = var33.field19.totalQuantity;
                                    var3 = 1;
                                 } else if(var0 == 3925) {
                                    var4 = class32.field743[--class30.field713];
                                    var33 = (class2)field138.field13.get(var4);
                                    class32.field743[++class30.field713 - 1] = var33.field19.price;
                                    var3 = 1;
                                 } else if(var0 == 3926) {
                                    var4 = class32.field743[--class30.field713];
                                    var33 = (class2)field138.field13.get(var4);
                                    class32.field743[++class30.field713 - 1] = var33.field19.itemId;
                                    var3 = 1;
                                 } else {
                                    var3 = 2;
                                 }
                              }
                           }

                           return var3;
                        } else if(var0 < 4100) {
                           if(var0 == 4000) {
                              class30.field713 -= 2;
                              var4 = class32.field743[class30.field713];
                              var5 = class32.field743[class30.field713 + 1];
                              class32.field743[++class30.field713 - 1] = var4 + var5;
                              var3 = 1;
                           } else if(var0 == 4001) {
                              class30.field713 -= 2;
                              var4 = class32.field743[class30.field713];
                              var5 = class32.field743[1 + class30.field713];
                              class32.field743[++class30.field713 - 1] = var4 - var5;
                              var3 = 1;
                           } else if(var0 == 4002) {
                              class30.field713 -= 2;
                              var4 = class32.field743[class30.field713];
                              var5 = class32.field743[class30.field713 + 1];
                              class32.field743[++class30.field713 - 1] = var4 * var5;
                              var3 = 1;
                           } else if(var0 == 4003) {
                              class30.field713 -= 2;
                              var4 = class32.field743[class30.field713];
                              var5 = class32.field743[1 + class30.field713];
                              class32.field743[++class30.field713 - 1] = var4 / var5;
                              var3 = 1;
                           } else if(var0 == 4004) {
                              var4 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = (int)(Math.random() * (double)var4);
                              var3 = 1;
                           } else if(var0 == 4005) {
                              var4 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = (int)(Math.random() * (double)(var4 + 1));
                              var3 = 1;
                           } else if(var0 == 4006) {
                              class30.field713 -= 5;
                              var4 = class32.field743[class30.field713];
                              var5 = class32.field743[class30.field713 + 1];
                              var6 = class32.field743[class30.field713 + 2];
                              var40 = class32.field743[class30.field713 + 3];
                              var8 = class32.field743[4 + class30.field713];
                              class32.field743[++class30.field713 - 1] = (var8 - var6) * (var5 - var4) / (var40 - var6) + var4;
                              var3 = 1;
                           } else if(var0 == 4007) {
                              class30.field713 -= 2;
                              var4 = class32.field743[class30.field713];
                              var5 = class32.field743[1 + class30.field713];
                              class32.field743[++class30.field713 - 1] = var5 * var4 / 100 + var4;
                              var3 = 1;
                           } else if(var0 == 4008) {
                              class30.field713 -= 2;
                              var4 = class32.field743[class30.field713];
                              var5 = class32.field743[class30.field713 + 1];
                              class32.field743[++class30.field713 - 1] = var4 | 1 << var5;
                              var3 = 1;
                           } else if(var0 == 4009) {
                              class30.field713 -= 2;
                              var4 = class32.field743[class30.field713];
                              var5 = class32.field743[1 + class30.field713];
                              class32.field743[++class30.field713 - 1] = var4 & -1 - (1 << var5);
                              var3 = 1;
                           } else if(var0 == 4010) {
                              class30.field713 -= 2;
                              var4 = class32.field743[class30.field713];
                              var5 = class32.field743[class30.field713 + 1];
                              class32.field743[++class30.field713 - 1] = (var4 & 1 << var5) != 0?1:0;
                              var3 = 1;
                           } else if(var0 == 4011) {
                              class30.field713 -= 2;
                              var4 = class32.field743[class30.field713];
                              var5 = class32.field743[class30.field713 + 1];
                              class32.field743[++class30.field713 - 1] = var4 % var5;
                              var3 = 1;
                           } else if(var0 == 4012) {
                              class30.field713 -= 2;
                              var4 = class32.field743[class30.field713];
                              var5 = class32.field743[class30.field713 + 1];
                              if(var4 == 0) {
                                 class32.field743[++class30.field713 - 1] = 0;
                              } else {
                                 class32.field743[++class30.field713 - 1] = (int)Math.pow((double)var4, (double)var5);
                              }

                              var3 = 1;
                           } else if(var0 == 4013) {
                              class30.field713 -= 2;
                              var4 = class32.field743[class30.field713];
                              var5 = class32.field743[1 + class30.field713];
                              if(var4 == 0) {
                                 class32.field743[++class30.field713 - 1] = 0;
                              } else if(var5 == 0) {
                                 class32.field743[++class30.field713 - 1] = Integer.MAX_VALUE;
                              } else {
                                 class32.field743[++class30.field713 - 1] = (int)Math.pow((double)var4, 1.0D / (double)var5);
                              }

                              var3 = 1;
                           } else if(var0 == 4014) {
                              class30.field713 -= 2;
                              var4 = class32.field743[class30.field713];
                              var5 = class32.field743[class30.field713 + 1];
                              class32.field743[++class30.field713 - 1] = var4 & var5;
                              var3 = 1;
                           } else if(var0 == 4015) {
                              class30.field713 -= 2;
                              var4 = class32.field743[class30.field713];
                              var5 = class32.field743[1 + class30.field713];
                              class32.field743[++class30.field713 - 1] = var4 | var5;
                              var3 = 1;
                           } else if(var0 == 4018) {
                              class30.field713 -= 3;
                              long var20 = (long)class32.field743[class30.field713];
                              var22 = (long)class32.field743[1 + class30.field713];
                              long var18 = (long)class32.field743[2 + class30.field713];
                              class32.field743[++class30.field713 - 1] = (int)(var18 * var20 / var22);
                              var3 = 1;
                           } else {
                              var3 = 2;
                           }

                           return var3;
                        } else if(var0 < 4200) {
                           return class152.method2850(var0, var1, var2);
                        } else if(var0 >= 4300) {
                           if(var0 < 5100) {
                              return class184.method3450(var0, var1, var2);
                           } else if(var0 < 5400) {
                              return class10.method140(var0, var1, var2);
                           } else if(var0 < 5600) {
                              return class18.method173(var0, var1, var2);
                           } else if(var0 < 5700) {
                              return XItemContainer.method152(var0, var1, var2);
                           } else if(var0 < 6300) {
                              if(var0 == 6200) {
                                 class30.field713 -= 2;
                                 Client.field325 = (short)class32.field743[class30.field713];
                                 if(Client.field325 <= 0) {
                                    Client.field325 = 256;
                                 }

                                 Client.field558 = (short)class32.field743[1 + class30.field713];
                                 if(Client.field558 <= 0) {
                                    Client.field558 = 205;
                                 }

                                 var3 = 1;
                              } else if(var0 == 6201) {
                                 class30.field713 -= 2;
                                 Client.field559 = (short)class32.field743[class30.field713];
                                 if(Client.field559 <= 0) {
                                    Client.field559 = 256;
                                 }

                                 Client.field560 = (short)class32.field743[1 + class30.field713];
                                 if(Client.field560 <= 0) {
                                    Client.field560 = 320;
                                 }

                                 var3 = 1;
                              } else if(var0 == 6202) {
                                 class30.field713 -= 4;
                                 Client.field505 = (short)class32.field743[class30.field713];
                                 if(Client.field505 <= 0) {
                                    Client.field505 = 1;
                                 }

                                 Client.field562 = (short)class32.field743[class30.field713 + 1];
                                 if(Client.field562 <= 0) {
                                    Client.field562 = 32767;
                                 } else if(Client.field562 < Client.field505) {
                                    Client.field562 = Client.field505;
                                 }

                                 Client.field563 = (short)class32.field743[class30.field713 + 2];
                                 if(Client.field563 <= 0) {
                                    Client.field563 = 1;
                                 }

                                 Client.field564 = (short)class32.field743[3 + class30.field713];
                                 if(Client.field564 <= 0) {
                                    Client.field564 = 32767;
                                 } else if(Client.field564 < Client.field563) {
                                    Client.field564 = Client.field563;
                                 }

                                 var3 = 1;
                              } else if(var0 == 6203) {
                                 if(null != Client.field475) {
                                    XItemContainer.method154(0, 0, Client.field475.width, Client.field475.height, false);
                                    class32.field743[++class30.field713 - 1] = Client.camera2;
                                    class32.field743[++class30.field713 - 1] = Client.camera3;
                                 } else {
                                    class32.field743[++class30.field713 - 1] = -1;
                                    class32.field743[++class30.field713 - 1] = -1;
                                 }

                                 var3 = 1;
                              } else if(var0 == 6204) {
                                 class32.field743[++class30.field713 - 1] = Client.field559;
                                 class32.field743[++class30.field713 - 1] = Client.field560;
                                 var3 = 1;
                              } else if(var0 == 6205) {
                                 class32.field743[++class30.field713 - 1] = Client.field325;
                                 class32.field743[++class30.field713 - 1] = Client.field558;
                                 var3 = 1;
                              } else {
                                 var3 = 2;
                              }

                              return var3;
                           } else {
                              return var0 < 6600?class57.method1118(var0, var1, var2):2;
                           }
                        } else {
                           if(var0 == 4200) {
                              var4 = class32.field743[--class30.field713];
                              class32.scriptStringStack[++class32.scriptStringStackSize - 1] = class196.getItemDefinition(var4).name;
                              var3 = 1;
                           } else {
                              ItemComposition var25;
                              if(var0 == 4201) {
                                 class30.field713 -= 2;
                                 var4 = class32.field743[class30.field713];
                                 var5 = class32.field743[1 + class30.field713];
                                 var25 = class196.getItemDefinition(var4);
                                 if(var5 >= 1 && var5 <= 5 && var25.groundActions[var5 - 1] != null) {
                                    class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var25.groundActions[var5 - 1];
                                 } else {
                                    class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                                 }

                                 var3 = 1;
                              } else if(var0 == 4202) {
                                 class30.field713 -= 2;
                                 var4 = class32.field743[class30.field713];
                                 var5 = class32.field743[1 + class30.field713];
                                 var25 = class196.getItemDefinition(var4);
                                 if(var5 >= 1 && var5 <= 5 && var25.inventoryActions[var5 - 1] != null) {
                                    class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var25.inventoryActions[var5 - 1];
                                 } else {
                                    class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                                 }

                                 var3 = 1;
                              } else if(var0 == 4203) {
                                 var4 = class32.field743[--class30.field713];
                                 class32.field743[++class30.field713 - 1] = class196.getItemDefinition(var4).price;
                                 var3 = 1;
                              } else if(var0 == 4204) {
                                 var4 = class32.field743[--class30.field713];
                                 class32.field743[++class30.field713 - 1] = class196.getItemDefinition(var4).isStackable == 1?1:0;
                                 var3 = 1;
                              } else {
                                 ItemComposition var14;
                                 if(var0 == 4205) {
                                    var4 = class32.field743[--class30.field713];
                                    var14 = class196.getItemDefinition(var4);
                                    if(var14.notedTemplate == -1 && var14.note >= 0) {
                                       class32.field743[++class30.field713 - 1] = var14.note;
                                    } else {
                                       class32.field743[++class30.field713 - 1] = var4;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4206) {
                                    var4 = class32.field743[--class30.field713];
                                    var14 = class196.getItemDefinition(var4);
                                    if(var14.notedTemplate >= 0 && var14.note >= 0) {
                                       class32.field743[++class30.field713 - 1] = var14.note;
                                    } else {
                                       class32.field743[++class30.field713 - 1] = var4;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4207) {
                                    var4 = class32.field743[--class30.field713];
                                    class32.field743[++class30.field713 - 1] = class196.getItemDefinition(var4).isMembers?1:0;
                                    var3 = 1;
                                 } else if(var0 == 4208) {
                                    var4 = class32.field743[--class30.field713];
                                    var14 = class196.getItemDefinition(var4);
                                    if(var14.field3001 == -1 && var14.field2958 >= 0) {
                                       class32.field743[++class30.field713 - 1] = var14.field2958;
                                    } else {
                                       class32.field743[++class30.field713 - 1] = var4;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4209) {
                                    var4 = class32.field743[--class30.field713];
                                    var14 = class196.getItemDefinition(var4);
                                    if(var14.field3001 >= 0 && var14.field2958 >= 0) {
                                       class32.field743[++class30.field713 - 1] = var14.field2958;
                                    } else {
                                       class32.field743[++class30.field713 - 1] = var4;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4210) {
                                    String var15 = class32.scriptStringStack[--class32.scriptStringStackSize];
                                    var5 = class32.field743[--class30.field713];
                                    boolean var24 = var5 == 1;
                                    String var41 = var15.toLowerCase();
                                    short[] var16 = new short[16];
                                    var27 = 0;
                                    var10 = 0;

                                    while(true) {
                                       if(var10 >= ItemComposition.field3000) {
                                          class36.field794 = var16;
                                          class9.field78 = 0;
                                          class60.field1104 = var27;
                                          String[] var26 = new String[class60.field1104];

                                          for(var17 = 0; var17 < class60.field1104; ++var17) {
                                             var26[var17] = class196.getItemDefinition(var16[var17]).name;
                                          }

                                          class148.method2832(var26, class36.field794);
                                          break;
                                       }

                                       ItemComposition var11 = class196.getItemDefinition(var10);
                                       if((!var24 || var11.field2997) && var11.notedTemplate == -1 && var11.name.toLowerCase().indexOf(var41) != -1) {
                                          if(var27 >= 250) {
                                             class60.field1104 = -1;
                                             class36.field794 = null;
                                             break;
                                          }

                                          if(var27 >= var16.length) {
                                             short[] var12 = new short[var16.length * 2];

                                             for(int var13 = 0; var13 < var27; ++var13) {
                                                var12[var13] = var16[var13];
                                             }

                                             var16 = var12;
                                          }

                                          var16[var27++] = (short)var10;
                                       }

                                       ++var10;
                                    }

                                    class32.field743[++class30.field713 - 1] = class60.field1104;
                                    var3 = 1;
                                 } else if(var0 == 4211) {
                                    if(class36.field794 != null && class9.field78 < class60.field1104) {
                                       class32.field743[++class30.field713 - 1] = class36.field794[++class9.field78 - 1] & '\uffff';
                                    } else {
                                       class32.field743[++class30.field713 - 1] = -1;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4212) {
                                    class9.field78 = 0;
                                    var3 = 1;
                                 } else {
                                    var3 = 2;
                                 }
                              }
                           }

                           return var3;
                        }
                     }
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1902646861"
   )
   static final void method159(int var0, int var1, int var2, int var3, int var4) {
      Tile.field1372[0].method4088(var0, var1);
      Tile.field1372[1].method4088(var0, var3 + var1 - 16);
      Rasterizer2D.method4007(var0, 16 + var1, 16, var3 - 32, Client.field379);
      int var5 = var3 * (var3 - 32) / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = var2 * (var3 - 32 - var5) / (var4 - var3);
      Rasterizer2D.method4007(var0, var6 + var1 + 16, 16, var5, Client.field329);
      Rasterizer2D.method4017(var0, var6 + var1 + 16, var5, Client.field382);
      Rasterizer2D.method4017(var0 + 1, var6 + var1 + 16, var5, Client.field382);
      Rasterizer2D.method4027(var0, var6 + 16 + var1, 16, Client.field382);
      Rasterizer2D.method4027(var0, var6 + 17 + var1, 16, Client.field382);
      Rasterizer2D.method4017(15 + var0, 16 + var1 + var6, var5, Client.field381);
      Rasterizer2D.method4017(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field381);
      Rasterizer2D.method4027(var0, var1 + 15 + var6 + var5, 16, Client.field381);
      Rasterizer2D.method4027(var0 + 1, var5 + var6 + var1 + 14, 15, Client.field381);
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1743014193"
   )
   static final void method160(boolean var0) {
      Client.field310 = 0;
      Client.field343 = 0;
      Client.secretCipherBuffer2.method3102();
      int var1 = Client.secretCipherBuffer2.method3111(8);
      int var2;
      if(var1 < Client.field402) {
         for(var2 = var1; var2 < Client.field402; ++var2) {
            Client.field426[++Client.field310 - 1] = Client.field342[var2];
         }
      }

      if(var1 > Client.field402) {
         throw new RuntimeException("");
      } else {
         Client.field402 = 0;

         int var5;
         int var6;
         int var7;
         int var8;
         int var9;
         for(var2 = 0; var2 < var1; ++var2) {
            int var13 = Client.field342[var2];
            NPC var4 = Client.cachedNPCs[var13];
            var5 = Client.secretCipherBuffer2.method3111(1);
            if(var5 == 0) {
               Client.field342[++Client.field402 - 1] = var13;
               var4.field667 = Client.gameCycle;
            } else {
               var6 = Client.secretCipherBuffer2.method3111(2);
               if(var6 == 0) {
                  Client.field342[++Client.field402 - 1] = var13;
                  var4.field667 = Client.gameCycle;
                  Client.field485[++Client.field343 - 1] = var13;
               } else if(var6 == 1) {
                  Client.field342[++Client.field402 - 1] = var13;
                  var4.field667 = Client.gameCycle;
                  var7 = Client.secretCipherBuffer2.method3111(3);
                  var4.method735(var7, (byte)1);
                  var8 = Client.secretCipherBuffer2.method3111(1);
                  if(var8 == 1) {
                     Client.field485[++Client.field343 - 1] = var13;
                  }
               } else if(var6 == 2) {
                  Client.field342[++Client.field402 - 1] = var13;
                  var4.field667 = Client.gameCycle;
                  var7 = Client.secretCipherBuffer2.method3111(3);
                  var4.method735(var7, (byte)2);
                  var8 = Client.secretCipherBuffer2.method3111(3);
                  var4.method735(var8, (byte)2);
                  var9 = Client.secretCipherBuffer2.method3111(1);
                  if(var9 == 1) {
                     Client.field485[++Client.field343 - 1] = var13;
                  }
               } else if(var6 == 3) {
                  Client.field426[++Client.field310 - 1] = var13;
               }
            }
         }

         NPC var3;
         int var14;
         while(Client.secretCipherBuffer2.method3098(Client.field348) >= 27) {
            var1 = Client.secretCipherBuffer2.method3111(15);
            if(var1 == 32767) {
               break;
            }

            boolean var15 = false;
            if(null == Client.cachedNPCs[var1]) {
               Client.cachedNPCs[var1] = new NPC();
               var15 = true;
            }

            var3 = Client.cachedNPCs[var1];
            Client.field342[++Client.field402 - 1] = var1;
            var3.field667 = Client.gameCycle;
            var14 = Client.secretCipherBuffer2.method3111(1);
            var5 = Client.secretCipherBuffer2.method3111(1);
            if(var5 == 1) {
               Client.field485[++Client.field343 - 1] = var1;
            }

            var6 = Client.field430[Client.secretCipherBuffer2.method3111(3)];
            if(var15) {
               var3.field669 = var3.angle = var6;
            }

            var3.composition = class15.getNpcDefinition(Client.secretCipherBuffer2.method3111(14));
            if(var0) {
               var7 = Client.secretCipherBuffer2.method3111(8);
               if(var7 > 127) {
                  var7 -= 256;
               }
            } else {
               var7 = Client.secretCipherBuffer2.method3111(5);
               if(var7 > 15) {
                  var7 -= 32;
               }
            }

            if(var0) {
               var8 = Client.secretCipherBuffer2.method3111(8);
               if(var8 > 127) {
                  var8 -= 256;
               }
            } else {
               var8 = Client.secretCipherBuffer2.method3111(5);
               if(var8 > 15) {
                  var8 -= 32;
               }
            }

            var3.field622 = var3.composition.field3011;
            var3.field671 = var3.composition.field3034;
            if(var3.field671 == 0) {
               var3.angle = 0;
            }

            var3.field626 = var3.composition.field3017;
            var3.field627 = var3.composition.field3018;
            var3.field645 = var3.composition.field3019;
            var3.field629 = var3.composition.field3031;
            var3.idlePoseAnimation = var3.composition.field3014;
            var3.field633 = var3.composition.field3038;
            var3.field625 = var3.composition.field3016;
            var3.method736(var7 + Projectile.localPlayer.pathX[0], var8 + Projectile.localPlayer.pathY[0], var14 == 1);
         }

         Client.secretCipherBuffer2.method3103();

         for(var1 = 0; var1 < Client.field343; ++var1) {
            var2 = Client.field485[var1];
            var3 = Client.cachedNPCs[var2];
            var14 = Client.secretCipherBuffer2.readUnsignedByte();
            if((var14 & 8) != 0) {
               var3.composition = class15.getNpcDefinition(Client.secretCipherBuffer2.method2853());
               var3.field622 = var3.composition.field3011;
               var3.field671 = var3.composition.field3034;
               var3.field626 = var3.composition.field3017;
               var3.field627 = var3.composition.field3018;
               var3.field645 = var3.composition.field3019;
               var3.field629 = var3.composition.field3031;
               var3.idlePoseAnimation = var3.composition.field3014;
               var3.field633 = var3.composition.field3038;
               var3.field625 = var3.composition.field3016;
            }

            if((var14 & 32) != 0) {
               var3.overhead = Client.secretCipherBuffer2.readString();
               var3.field656 = 100;
            }

            if((var14 & 1) != 0) {
               var5 = Client.secretCipherBuffer2.method2904();
               var6 = Client.secretCipherBuffer2.method2853();
               var7 = var3.x - (var5 - class119.baseX - class119.baseX) * 64;
               var8 = var3.y - (var6 - class187.baseY - class187.baseY) * 64;
               if(var7 != 0 || var8 != 0) {
                  var3.field646 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
               }
            }

            if((var14 & 64) != 0) {
               var5 = Client.secretCipherBuffer2.method2903();
               if(var5 == '\uffff') {
                  var5 = -1;
               }

               var6 = Client.secretCipherBuffer2.method3015();
               if(var5 == var3.animation && var5 != -1) {
                  var7 = Friend.getAnimation(var5).replyMode;
                  if(var7 == 1) {
                     var3.actionFrame = 0;
                     var3.field652 = 0;
                     var3.actionAnimationDisable = var6;
                     var3.field637 = 0;
                  }

                  if(var7 == 2) {
                     var3.field637 = 0;
                  }
               } else if(var5 == -1 || var3.animation == -1 || Friend.getAnimation(var5).forcedPriority >= Friend.getAnimation(var3.animation).forcedPriority) {
                  var3.animation = var5;
                  var3.actionFrame = 0;
                  var3.field652 = 0;
                  var3.actionAnimationDisable = var6;
                  var3.field637 = 0;
                  var3.field655 = var3.field672;
               }
            }

            if((var14 & 2) != 0) {
               var5 = Client.secretCipherBuffer2.method3051();
               int var10;
               int var11;
               if(var5 > 0) {
                  for(var6 = 0; var6 < var5; ++var6) {
                     var8 = -1;
                     var9 = -1;
                     var10 = -1;
                     var7 = Client.secretCipherBuffer2.method2880();
                     if(var7 == 32767) {
                        var7 = Client.secretCipherBuffer2.method2880();
                        var9 = Client.secretCipherBuffer2.method2880();
                        var8 = Client.secretCipherBuffer2.method2880();
                        var10 = Client.secretCipherBuffer2.method2880();
                     } else if(var7 != 32766) {
                        var9 = Client.secretCipherBuffer2.method2880();
                     } else {
                        var7 = -1;
                     }

                     var11 = Client.secretCipherBuffer2.method2880();
                     var3.method585(var7, var9, var8, var10, Client.gameCycle, var11);
                  }
               }

               var6 = Client.secretCipherBuffer2.method3015();
               if(var6 > 0) {
                  for(var7 = 0; var7 < var6; ++var7) {
                     var8 = Client.secretCipherBuffer2.method2880();
                     var9 = Client.secretCipherBuffer2.method2880();
                     if(var9 != 32767) {
                        var10 = Client.secretCipherBuffer2.method2880();
                        var11 = Client.secretCipherBuffer2.readUnsignedByte();
                        int var12 = var9 > 0?Client.secretCipherBuffer2.readUnsignedByte():var11;
                        var3.method570(var8, Client.gameCycle, var9, var10, var11, var12);
                     } else {
                        var3.method569(var8);
                     }
                  }
               }
            }

            if((var14 & 4) != 0) {
               var3.interacting = Client.secretCipherBuffer2.method2904();
               if(var3.interacting == '\uffff') {
                  var3.interacting = -1;
               }
            }

            if((var14 & 16) != 0) {
               var3.graphic = Client.secretCipherBuffer2.method2853();
               var5 = Client.secretCipherBuffer2.method3006();
               var3.field659 = var5 >> 16;
               var3.field658 = (var5 & '\uffff') + Client.gameCycle;
               var3.field678 = 0;
               var3.field638 = 0;
               if(var3.field658 > Client.gameCycle) {
                  var3.field678 = -1;
               }

               if(var3.graphic == '\uffff') {
                  var3.graphic = -1;
               }
            }
         }

         for(var1 = 0; var1 < Client.field310; ++var1) {
            var2 = Client.field426[var1];
            if(Client.gameCycle != Client.cachedNPCs[var2].field667) {
               Client.cachedNPCs[var2].composition = null;
               Client.cachedNPCs[var2] = null;
            }
         }

         if(Client.secretCipherBuffer2.offset != Client.field348) {
            throw new RuntimeException(Client.secretCipherBuffer2.offset + "," + Client.field348);
         } else {
            for(var1 = 0; var1 < Client.field402; ++var1) {
               if(Client.cachedNPCs[Client.field342[var1]] == null) {
                  throw new RuntimeException(var1 + "," + Client.field402);
               }
            }

         }
      }
   }

   class13() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZB)V",
      garbageValue = "-63"
   )
   static void method161(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class114.field1810.startsWith("win") && !var3) {
            class41.method813(var0, 0);
            return;
         }

         if(class114.field1810.startsWith("mac")) {
            class112.method2141(var0, 1, var2);
            return;
         }

         class41.method813(var0, 2);
      } else {
         class41.method813(var0, 3);
      }

   }
}
