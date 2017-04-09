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
         Widget var4;
         if(var0 < 1600) {
            var4 = var2?class154.field2123:class32.field746;
            if(var0 == 1500) {
               class32.field743[++class30.field713 - 1] = var4.relativeX;
               var3 = 1;
            } else if(var0 == 1501) {
               class32.field743[++class30.field713 - 1] = var4.relativeY;
               var3 = 1;
            } else if(var0 == 1502) {
               class32.field743[++class30.field713 - 1] = var4.width;
               var3 = 1;
            } else if(var0 == 1503) {
               class32.field743[++class30.field713 - 1] = var4.height;
               var3 = 1;
            } else if(var0 == 1504) {
               class32.field743[++class30.field713 - 1] = var4.isHidden?1:0;
               var3 = 1;
            } else if(var0 == 1505) {
               class32.field743[++class30.field713 - 1] = var4.parentId;
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else {
            Widget var5;
            if(var0 < 1700) {
               var5 = var2?class154.field2123:class32.field746;
               if(var0 == 1600) {
                  class32.field743[++class30.field713 - 1] = var5.scrollX;
                  var3 = 1;
               } else if(var0 == 1601) {
                  class32.field743[++class30.field713 - 1] = var5.scrollY;
                  var3 = 1;
               } else if(var0 == 1602) {
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var5.text;
                  var3 = 1;
               } else if(var0 == 1603) {
                  class32.field743[++class30.field713 - 1] = var5.scrollWidth;
                  var3 = 1;
               } else if(var0 == 1604) {
                  class32.field743[++class30.field713 - 1] = var5.scrollHeight;
                  var3 = 1;
               } else if(var0 == 1605) {
                  class32.field743[++class30.field713 - 1] = var5.field2320;
                  var3 = 1;
               } else if(var0 == 1606) {
                  class32.field743[++class30.field713 - 1] = var5.rotationX;
                  var3 = 1;
               } else if(var0 == 1607) {
                  class32.field743[++class30.field713 - 1] = var5.rotationY;
                  var3 = 1;
               } else if(var0 == 1608) {
                  class32.field743[++class30.field713 - 1] = var5.rotationZ;
                  var3 = 1;
               } else if(var0 == 1609) {
                  class32.field743[++class30.field713 - 1] = var5.opacity;
                  var3 = 1;
               } else if(var0 == 1610) {
                  class32.field743[++class30.field713 - 1] = var5.field2251;
                  var3 = 1;
               } else if(var0 == 1611) {
                  class32.field743[++class30.field713 - 1] = var5.textColor;
                  var3 = 1;
               } else if(var0 == 1612) {
                  class32.field743[++class30.field713 - 1] = var5.field2245;
                  var3 = 1;
               } else if(var0 == 1613) {
                  class32.field743[++class30.field713 - 1] = var5.field2249.vmethod4085();
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 1800) {
               var4 = var2?class154.field2123:class32.field746;
               if(var0 == 1700) {
                  class32.field743[++class30.field713 - 1] = var4.item;
                  var3 = 1;
               } else if(var0 == 1701) {
                  if(var4.item != -1) {
                     class32.field743[++class30.field713 - 1] = var4.stackSize;
                  } else {
                     class32.field743[++class30.field713 - 1] = 0;
                  }

                  var3 = 1;
               } else if(var0 == 1702) {
                  class32.field743[++class30.field713 - 1] = var4.index;
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
               var5 = FaceNormal.method1932(class32.field743[--class30.field713]);
               if(var0 == 2600) {
                  class32.field743[++class30.field713 - 1] = var5.scrollX;
                  var3 = 1;
               } else if(var0 == 2601) {
                  class32.field743[++class30.field713 - 1] = var5.scrollY;
                  var3 = 1;
               } else if(var0 == 2602) {
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var5.text;
                  var3 = 1;
               } else if(var0 == 2603) {
                  class32.field743[++class30.field713 - 1] = var5.scrollWidth;
                  var3 = 1;
               } else if(var0 == 2604) {
                  class32.field743[++class30.field713 - 1] = var5.scrollHeight;
                  var3 = 1;
               } else if(var0 == 2605) {
                  class32.field743[++class30.field713 - 1] = var5.field2320;
                  var3 = 1;
               } else if(var0 == 2606) {
                  class32.field743[++class30.field713 - 1] = var5.rotationX;
                  var3 = 1;
               } else if(var0 == 2607) {
                  class32.field743[++class30.field713 - 1] = var5.rotationY;
                  var3 = 1;
               } else if(var0 == 2608) {
                  class32.field743[++class30.field713 - 1] = var5.rotationZ;
                  var3 = 1;
               } else if(var0 == 2609) {
                  class32.field743[++class30.field713 - 1] = var5.opacity;
                  var3 = 1;
               } else if(var0 == 2610) {
                  class32.field743[++class30.field713 - 1] = var5.field2251;
                  var3 = 1;
               } else if(var0 == 2611) {
                  class32.field743[++class30.field713 - 1] = var5.textColor;
                  var3 = 1;
               } else if(var0 == 2612) {
                  class32.field743[++class30.field713 - 1] = var5.field2245;
                  var3 = 1;
               } else if(var0 == 2613) {
                  class32.field743[++class30.field713 - 1] = var5.field2249.vmethod4085();
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else {
               int var6;
               if(var0 < 2800) {
                  if(var0 == 2700) {
                     var5 = FaceNormal.method1932(class32.field743[--class30.field713]);
                     class32.field743[++class30.field713 - 1] = var5.item;
                     var3 = 1;
                  } else if(var0 == 2701) {
                     var5 = FaceNormal.method1932(class32.field743[--class30.field713]);
                     if(var5.item != -1) {
                        class32.field743[++class30.field713 - 1] = var5.stackSize;
                     } else {
                        class32.field743[++class30.field713 - 1] = 0;
                     }

                     var3 = 1;
                  } else if(var0 == 2702) {
                     var6 = class32.field743[--class30.field713];
                     WidgetNode var33 = (WidgetNode)Client.componentTable.method2417((long)var6);
                     if(var33 != null) {
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
                  int var7;
                  int var8;
                  int var9;
                  int var10;
                  if(var0 < 2900) {
                     var5 = FaceNormal.method1932(class32.field743[--class30.field713]);
                     if(var0 == 2800) {
                        int[] var27 = class32.field743;
                        var8 = ++class30.field713 - 1;
                        var9 = FloorUnderlayDefinition.method3533(var5);
                        var10 = var9 >> 11 & 63;
                        var27[var8] = var10;
                        var3 = 1;
                     } else if(var0 == 2801) {
                        var7 = class32.field743[--class30.field713];
                        --var7;
                        if(var5.actions != null && var7 < var5.actions.length && var5.actions[var7] != null) {
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var5.actions[var7];
                        } else {
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                        }

                        var3 = 1;
                     } else if(var0 == 2802) {
                        if(var5.name == null) {
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                        } else {
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var5.name;
                        }

                        var3 = 1;
                     } else {
                        var3 = 2;
                     }

                     return var3;
                  } else if(var0 < 3000) {
                     return class202.method3824(var0, var1, var2);
                  } else if(var0 < 3200) {
                     return IndexFile.method2301(var0, var1, var2);
                  } else if(var0 < 3300) {
                     if(var0 == 3200) {
                        class30.field713 -= 3;
                        var6 = class32.field743[class30.field713];
                        var7 = class32.field743[class30.field713 + 1];
                        var8 = class32.field743[class30.field713 + 2];
                        if(Client.field543 != 0 && var7 != 0 && Client.field545 < 50) {
                           Client.field546[Client.field545] = var6;
                           Client.field547[Client.field545] = var7;
                           Client.field334[Client.field545] = var8;
                           Client.field550[Client.field545] = null;
                           Client.field464[Client.field545] = 0;
                           ++Client.field545;
                        }

                        var3 = 1;
                     } else if(var0 == 3201) {
                        var6 = class32.field743[--class30.field713];
                        if(var6 == -1 && !Client.field542) {
                           TextureProvider.method1486();
                        } else if(var6 != -1 && var6 != Client.field541 && Client.field540 != 0 && !Client.field542) {
                           IndexData var26 = Client.indexTrack1;
                           var8 = Client.field540;
                           class138.field1940 = 1;
                           class149.field2061 = var26;
                           class138.field1941 = var6;
                           RSCanvas.field1777 = 0;
                           NPC.field783 = var8;
                           class138.field1938 = false;
                           class138.field1937 = 2;
                        }

                        Client.field541 = var6;
                        var3 = 1;
                     } else if(var0 == 3202) {
                        class30.field713 -= 2;
                        var6 = class32.field743[class30.field713];
                        var7 = class32.field743[class30.field713 + 1];
                        if(Client.field540 != 0 && var6 != -1) {
                           TextureProvider.method1487(Friend.indexTrack2, var6, 0, Client.field540, false);
                           Client.field542 = true;
                        }

                        var3 = 1;
                     } else {
                        var3 = 2;
                     }

                     return var3;
                  } else {
                     int var11;
                     int var12;
                     if(var0 < 3400) {
                        if(var0 == 3300) {
                           class32.field743[++class30.field713 - 1] = Client.gameCycle;
                           var3 = 1;
                        } else if(var0 == 3301) {
                           class30.field713 -= 2;
                           var6 = class32.field743[class30.field713];
                           var7 = class32.field743[class30.field713 + 1];
                           class32.field743[++class30.field713 - 1] = class150.method2841(var6, var7);
                           var3 = 1;
                        } else {
                           int[] var28;
                           XItemContainer var30;
                           if(var0 == 3302) {
                              class30.field713 -= 2;
                              var6 = class32.field743[class30.field713];
                              var7 = class32.field743[class30.field713 + 1];
                              var28 = class32.field743;
                              var10 = ++class30.field713 - 1;
                              var30 = (XItemContainer)XItemContainer.itemContainers.method2417((long)var6);
                              if(var30 == null) {
                                 var9 = 0;
                              } else if(var7 >= 0 && var7 < var30.stackSizes.length) {
                                 var9 = var30.stackSizes[var7];
                              } else {
                                 var9 = 0;
                              }

                              var28[var10] = var9;
                              var3 = 1;
                           } else if(var0 == 3303) {
                              class30.field713 -= 2;
                              var6 = class32.field743[class30.field713];
                              var7 = class32.field743[class30.field713 + 1];
                              var28 = class32.field743;
                              var10 = ++class30.field713 - 1;
                              var30 = (XItemContainer)XItemContainer.itemContainers.method2417((long)var6);
                              if(var30 == null) {
                                 var9 = 0;
                              } else if(var7 == -1) {
                                 var9 = 0;
                              } else {
                                 var11 = 0;

                                 for(var12 = 0; var12 < var30.stackSizes.length; ++var12) {
                                    if(var7 == var30.itemIds[var12]) {
                                       var11 += var30.stackSizes[var12];
                                    }
                                 }

                                 var9 = var11;
                              }

                              var28[var10] = var9;
                              var3 = 1;
                           } else if(var0 == 3304) {
                              var6 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = class20.method181(var6).field2785;
                              var3 = 1;
                           } else if(var0 == 3305) {
                              var6 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = Client.boostedSkillLevels[var6];
                              var3 = 1;
                           } else if(var0 == 3306) {
                              var6 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = Client.realSkillLevels[var6];
                              var3 = 1;
                           } else if(var0 == 3307) {
                              var6 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = Client.skillExperiences[var6];
                              var3 = 1;
                           } else if(var0 == 3308) {
                              var6 = Sequence.plane;
                              var7 = class119.baseX + (Projectile.localPlayer.x >> 7);
                              var8 = class187.baseY + (Projectile.localPlayer.y >> 7);
                              class32.field743[++class30.field713 - 1] = var8 + (var6 << 28) + (var7 << 14);
                              var3 = 1;
                           } else if(var0 == 3309) {
                              var6 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = var6 >> 14 & 16383;
                              var3 = 1;
                           } else if(var0 == 3310) {
                              var6 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = var6 >> 28;
                              var3 = 1;
                           } else if(var0 == 3311) {
                              var6 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = var6 & 16383;
                              var3 = 1;
                           } else if(var0 == 3312) {
                              class32.field743[++class30.field713 - 1] = Client.isMembers?1:0;
                              var3 = 1;
                           } else if(var0 == 3313) {
                              class30.field713 -= 2;
                              var6 = class32.field743[class30.field713] + '耀';
                              var7 = class32.field743[class30.field713 + 1];
                              class32.field743[++class30.field713 - 1] = class150.method2841(var6, var7);
                              var3 = 1;
                           } else if(var0 == 3314) {
                              class30.field713 -= 2;
                              var6 = class32.field743[class30.field713] + '耀';
                              var7 = class32.field743[class30.field713 + 1];
                              var28 = class32.field743;
                              var10 = ++class30.field713 - 1;
                              var30 = (XItemContainer)XItemContainer.itemContainers.method2417((long)var6);
                              if(var30 == null) {
                                 var9 = 0;
                              } else if(var7 >= 0 && var7 < var30.stackSizes.length) {
                                 var9 = var30.stackSizes[var7];
                              } else {
                                 var9 = 0;
                              }

                              var28[var10] = var9;
                              var3 = 1;
                           } else if(var0 == 3315) {
                              class30.field713 -= 2;
                              var6 = class32.field743[class30.field713] + '耀';
                              var7 = class32.field743[class30.field713 + 1];
                              var28 = class32.field743;
                              var10 = ++class30.field713 - 1;
                              var30 = (XItemContainer)XItemContainer.itemContainers.method2417((long)var6);
                              if(var30 == null) {
                                 var9 = 0;
                              } else if(var7 == -1) {
                                 var9 = 0;
                              } else {
                                 var11 = 0;

                                 for(var12 = 0; var12 < var30.stackSizes.length; ++var12) {
                                    if(var30.itemIds[var12] == var7) {
                                       var11 += var30.stackSizes[var12];
                                    }
                                 }

                                 var9 = var11;
                              }

                              var28[var10] = var9;
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
                        class195 var14;
                        class195 var25;
                        byte[] var29;
                        if(var0 == 3400) {
                           class30.field713 -= 2;
                           var6 = class32.field743[class30.field713];
                           var7 = class32.field743[class30.field713 + 1];
                           var14 = (class195)class195.field2863.get((long)var6);
                           if(var14 != null) {
                              var25 = var14;
                           } else {
                              var29 = class195.field2867.getConfigData(8, var6);
                              var14 = new class195();
                              if(var29 != null) {
                                 var14.method3600(new Buffer(var29));
                              }

                              class195.field2863.put(var14, (long)var6);
                              var25 = var14;
                           }

                           var14 = var25;
                           if(var25.field2865 != 115) {
                              ;
                           }

                           for(var9 = 0; var9 < var14.field2868; ++var9) {
                              if(var14.field2862[var9] == var7) {
                                 class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var14.field2871[var9];
                                 var14 = null;
                                 break;
                              }
                           }

                           if(var14 != null) {
                              class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var14.field2866;
                           }

                           var3 = 1;
                        } else if(var0 == 3408) {
                           class30.field713 -= 4;
                           var6 = class32.field743[class30.field713];
                           var7 = class32.field743[class30.field713 + 1];
                           var8 = class32.field743[class30.field713 + 2];
                           var10 = class32.field743[class30.field713 + 3];
                           var14 = (class195)class195.field2863.get((long)var8);
                           if(var14 != null) {
                              var25 = var14;
                           } else {
                              var29 = class195.field2867.getConfigData(8, var8);
                              var14 = new class195();
                              if(var29 != null) {
                                 var14.method3600(new Buffer(var29));
                              }

                              class195.field2863.put(var14, (long)var8);
                              var25 = var14;
                           }

                           var14 = var25;
                           if(var6 == var25.field2864 && var7 == var25.field2865) {
                              for(var11 = 0; var11 < var14.field2868; ++var11) {
                                 if(var10 == var14.field2862[var11]) {
                                    if(var7 == 115) {
                                       class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var14.field2871[var11];
                                    } else {
                                       class32.field743[++class30.field713 - 1] = var14.field2872[var11];
                                    }

                                    var14 = null;
                                    break;
                                 }
                              }

                              if(var14 != null) {
                                 if(var7 == 115) {
                                    class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var14.field2866;
                                 } else {
                                    class32.field743[++class30.field713 - 1] = var14.field2869;
                                 }
                              }

                              var3 = 1;
                           } else {
                              if(var7 == 115) {
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
                        long var13;
                        int var15;
                        String var16;
                        if(var0 < 4000) {
                           if(var0 == 3903) {
                              var6 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = Client.grandExchangeOffers[var6].method45();
                              var3 = 1;
                           } else if(var0 == 3904) {
                              var6 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = Client.grandExchangeOffers[var6].itemId;
                              var3 = 1;
                           } else if(var0 == 3905) {
                              var6 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = Client.grandExchangeOffers[var6].price;
                              var3 = 1;
                           } else if(var0 == 3906) {
                              var6 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = Client.grandExchangeOffers[var6].totalQuantity;
                              var3 = 1;
                           } else if(var0 == 3907) {
                              var6 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = Client.grandExchangeOffers[var6].quantitySold;
                              var3 = 1;
                           } else if(var0 == 3908) {
                              var6 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = Client.grandExchangeOffers[var6].spent;
                              var3 = 1;
                           } else if(var0 == 3910) {
                              var6 = class32.field743[--class30.field713];
                              var7 = Client.grandExchangeOffers[var6].method31();
                              class32.field743[++class30.field713 - 1] = var7 == 0?1:0;
                              var3 = 1;
                           } else if(var0 == 3911) {
                              var6 = class32.field743[--class30.field713];
                              var7 = Client.grandExchangeOffers[var6].method31();
                              class32.field743[++class30.field713 - 1] = var7 == 2?1:0;
                              var3 = 1;
                           } else if(var0 == 3912) {
                              var6 = class32.field743[--class30.field713];
                              var7 = Client.grandExchangeOffers[var6].method31();
                              class32.field743[++class30.field713 - 1] = var7 == 5?1:0;
                              var3 = 1;
                           } else if(var0 == 3913) {
                              var6 = class32.field743[--class30.field713];
                              var7 = Client.grandExchangeOffers[var6].method31();
                              class32.field743[++class30.field713 - 1] = var7 == 1?1:0;
                              var3 = 1;
                           } else {
                              boolean var32;
                              if(var0 == 3914) {
                                 var32 = class32.field743[--class30.field713] == 1;
                                 if(field138 != null) {
                                    field138.method5(class1.field10, var32);
                                 }

                                 var3 = 1;
                              } else if(var0 == 3915) {
                                 var32 = class32.field743[--class30.field713] == 1;
                                 if(field138 != null) {
                                    field138.method5(class1.field16, var32);
                                 }

                                 var3 = 1;
                              } else if(var0 == 3916) {
                                 class30.field713 -= 2;
                                 var32 = class32.field743[class30.field713] == 1;
                                 boolean var34 = class32.field743[class30.field713 + 1] == 1;
                                 if(field138 != null) {
                                    field138.method5(new class44(var34), var32);
                                 }

                                 var3 = 1;
                              } else if(var0 == 3917) {
                                 var32 = class32.field743[--class30.field713] == 1;
                                 if(field138 != null) {
                                    field138.method5(class1.field8, var32);
                                 }

                                 var3 = 1;
                              } else if(var0 == 3918) {
                                 var32 = class32.field743[--class30.field713] == 1;
                                 if(field138 != null) {
                                    field138.method5(class1.field11, var32);
                                 }

                                 var3 = 1;
                              } else if(var0 == 3919) {
                                 class32.field743[++class30.field713 - 1] = field138 == null?0:field138.field13.size();
                                 var3 = 1;
                              } else {
                                 class2 var36;
                                 if(var0 == 3920) {
                                    var6 = class32.field743[--class30.field713];
                                    var36 = (class2)field138.field13.get(var6);
                                    class32.field743[++class30.field713 - 1] = var36.field22;
                                    var3 = 1;
                                 } else if(var0 == 3921) {
                                    var6 = class32.field743[--class30.field713];
                                    var36 = (class2)field138.field13.get(var6);
                                    class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var36.method10();
                                    var3 = 1;
                                 } else if(var0 == 3922) {
                                    var6 = class32.field743[--class30.field713];
                                    var36 = (class2)field138.field13.get(var6);
                                    class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var36.method15();
                                    var3 = 1;
                                 } else if(var0 == 3923) {
                                    var6 = class32.field743[--class30.field713];
                                    var36 = (class2)field138.field13.get(var6);
                                    var13 = class45.method867() - class103.field1698 - var36.field18;
                                    var9 = (int)(var13 / 3600000L);
                                    var15 = (int)((var13 - (long)(var9 * 3600000)) / 60000L);
                                    var11 = (int)((var13 - (long)(var9 * 3600000) - (long)(var15 * '\uea60')) / 1000L);
                                    var16 = var9 + ":" + var15 / 10 + var15 % 10 + ":" + var11 / 10 + var11 % 10;
                                    class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var16;
                                    var3 = 1;
                                 } else if(var0 == 3924) {
                                    var6 = class32.field743[--class30.field713];
                                    var36 = (class2)field138.field13.get(var6);
                                    class32.field743[++class30.field713 - 1] = var36.field19.totalQuantity;
                                    var3 = 1;
                                 } else if(var0 == 3925) {
                                    var6 = class32.field743[--class30.field713];
                                    var36 = (class2)field138.field13.get(var6);
                                    class32.field743[++class30.field713 - 1] = var36.field19.price;
                                    var3 = 1;
                                 } else if(var0 == 3926) {
                                    var6 = class32.field743[--class30.field713];
                                    var36 = (class2)field138.field13.get(var6);
                                    class32.field743[++class30.field713 - 1] = var36.field19.itemId;
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
                              var6 = class32.field743[class30.field713];
                              var7 = class32.field743[class30.field713 + 1];
                              class32.field743[++class30.field713 - 1] = var6 + var7;
                              var3 = 1;
                           } else if(var0 == 4001) {
                              class30.field713 -= 2;
                              var6 = class32.field743[class30.field713];
                              var7 = class32.field743[class30.field713 + 1];
                              class32.field743[++class30.field713 - 1] = var6 - var7;
                              var3 = 1;
                           } else if(var0 == 4002) {
                              class30.field713 -= 2;
                              var6 = class32.field743[class30.field713];
                              var7 = class32.field743[class30.field713 + 1];
                              class32.field743[++class30.field713 - 1] = var6 * var7;
                              var3 = 1;
                           } else if(var0 == 4003) {
                              class30.field713 -= 2;
                              var6 = class32.field743[class30.field713];
                              var7 = class32.field743[class30.field713 + 1];
                              class32.field743[++class30.field713 - 1] = var6 / var7;
                              var3 = 1;
                           } else if(var0 == 4004) {
                              var6 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = (int)(Math.random() * (double)var6);
                              var3 = 1;
                           } else if(var0 == 4005) {
                              var6 = class32.field743[--class30.field713];
                              class32.field743[++class30.field713 - 1] = (int)(Math.random() * (double)(var6 + 1));
                              var3 = 1;
                           } else if(var0 == 4006) {
                              class30.field713 -= 5;
                              var6 = class32.field743[class30.field713];
                              var7 = class32.field743[class30.field713 + 1];
                              var8 = class32.field743[class30.field713 + 2];
                              var10 = class32.field743[class30.field713 + 3];
                              var9 = class32.field743[class30.field713 + 4];
                              class32.field743[++class30.field713 - 1] = (var9 - var8) * (var7 - var6) / (var10 - var8) + var6;
                              var3 = 1;
                           } else if(var0 == 4007) {
                              class30.field713 -= 2;
                              var6 = class32.field743[class30.field713];
                              var7 = class32.field743[class30.field713 + 1];
                              class32.field743[++class30.field713 - 1] = var7 * var6 / 100 + var6;
                              var3 = 1;
                           } else if(var0 == 4008) {
                              class30.field713 -= 2;
                              var6 = class32.field743[class30.field713];
                              var7 = class32.field743[class30.field713 + 1];
                              class32.field743[++class30.field713 - 1] = var6 | 1 << var7;
                              var3 = 1;
                           } else if(var0 == 4009) {
                              class30.field713 -= 2;
                              var6 = class32.field743[class30.field713];
                              var7 = class32.field743[class30.field713 + 1];
                              class32.field743[++class30.field713 - 1] = var6 & -1 - (1 << var7);
                              var3 = 1;
                           } else if(var0 == 4010) {
                              class30.field713 -= 2;
                              var6 = class32.field743[class30.field713];
                              var7 = class32.field743[class30.field713 + 1];
                              class32.field743[++class30.field713 - 1] = (var6 & 1 << var7) != 0?1:0;
                              var3 = 1;
                           } else if(var0 == 4011) {
                              class30.field713 -= 2;
                              var6 = class32.field743[class30.field713];
                              var7 = class32.field743[class30.field713 + 1];
                              class32.field743[++class30.field713 - 1] = var6 % var7;
                              var3 = 1;
                           } else if(var0 == 4012) {
                              class30.field713 -= 2;
                              var6 = class32.field743[class30.field713];
                              var7 = class32.field743[class30.field713 + 1];
                              if(var6 == 0) {
                                 class32.field743[++class30.field713 - 1] = 0;
                              } else {
                                 class32.field743[++class30.field713 - 1] = (int)Math.pow((double)var6, (double)var7);
                              }

                              var3 = 1;
                           } else if(var0 == 4013) {
                              class30.field713 -= 2;
                              var6 = class32.field743[class30.field713];
                              var7 = class32.field743[class30.field713 + 1];
                              if(var6 == 0) {
                                 class32.field743[++class30.field713 - 1] = 0;
                              } else if(var7 == 0) {
                                 class32.field743[++class30.field713 - 1] = Integer.MAX_VALUE;
                              } else {
                                 class32.field743[++class30.field713 - 1] = (int)Math.pow((double)var6, 1.0D / (double)var7);
                              }

                              var3 = 1;
                           } else if(var0 == 4014) {
                              class30.field713 -= 2;
                              var6 = class32.field743[class30.field713];
                              var7 = class32.field743[class30.field713 + 1];
                              class32.field743[++class30.field713 - 1] = var6 & var7;
                              var3 = 1;
                           } else if(var0 == 4015) {
                              class30.field713 -= 2;
                              var6 = class32.field743[class30.field713];
                              var7 = class32.field743[class30.field713 + 1];
                              class32.field743[++class30.field713 - 1] = var6 | var7;
                              var3 = 1;
                           } else if(var0 == 4018) {
                              class30.field713 -= 3;
                              long var31 = (long)class32.field743[class30.field713];
                              var13 = (long)class32.field743[class30.field713 + 1];
                              long var35 = (long)class32.field743[class30.field713 + 2];
                              class32.field743[++class30.field713 - 1] = (int)(var35 * var31 / var13);
                              var3 = 1;
                           } else {
                              var3 = 2;
                           }

                           return var3;
                        } else if(var0 < 4200) {
                           return class152.method2850(var0, var1, var2);
                        } else if(var0 >= 4300) {
                           if(var0 < 5100) {
                              return IndexData.method3450(var0, var1, var2);
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

                                 Client.field558 = (short)class32.field743[class30.field713 + 1];
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

                                 Client.field560 = (short)class32.field743[class30.field713 + 1];
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

                                 Client.field564 = (short)class32.field743[class30.field713 + 3];
                                 if(Client.field564 <= 0) {
                                    Client.field564 = 32767;
                                 } else if(Client.field564 < Client.field563) {
                                    Client.field564 = Client.field563;
                                 }

                                 var3 = 1;
                              } else if(var0 == 6203) {
                                 if(Client.field475 != null) {
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
                              var6 = class32.field743[--class30.field713];
                              class32.scriptStringStack[++class32.scriptStringStackSize - 1] = class196.getItemDefinition(var6).name;
                              var3 = 1;
                           } else {
                              ItemComposition var17;
                              if(var0 == 4201) {
                                 class30.field713 -= 2;
                                 var6 = class32.field743[class30.field713];
                                 var7 = class32.field743[class30.field713 + 1];
                                 var17 = class196.getItemDefinition(var6);
                                 if(var7 >= 1 && var7 <= 5 && var17.groundActions[var7 - 1] != null) {
                                    class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var17.groundActions[var7 - 1];
                                 } else {
                                    class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                                 }

                                 var3 = 1;
                              } else if(var0 == 4202) {
                                 class30.field713 -= 2;
                                 var6 = class32.field743[class30.field713];
                                 var7 = class32.field743[class30.field713 + 1];
                                 var17 = class196.getItemDefinition(var6);
                                 if(var7 >= 1 && var7 <= 5 && var17.inventoryActions[var7 - 1] != null) {
                                    class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var17.inventoryActions[var7 - 1];
                                 } else {
                                    class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                                 }

                                 var3 = 1;
                              } else if(var0 == 4203) {
                                 var6 = class32.field743[--class30.field713];
                                 class32.field743[++class30.field713 - 1] = class196.getItemDefinition(var6).price;
                                 var3 = 1;
                              } else if(var0 == 4204) {
                                 var6 = class32.field743[--class30.field713];
                                 class32.field743[++class30.field713 - 1] = class196.getItemDefinition(var6).isStackable == 1?1:0;
                                 var3 = 1;
                              } else {
                                 ItemComposition var18;
                                 if(var0 == 4205) {
                                    var6 = class32.field743[--class30.field713];
                                    var18 = class196.getItemDefinition(var6);
                                    if(var18.notedTemplate == -1 && var18.note >= 0) {
                                       class32.field743[++class30.field713 - 1] = var18.note;
                                    } else {
                                       class32.field743[++class30.field713 - 1] = var6;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4206) {
                                    var6 = class32.field743[--class30.field713];
                                    var18 = class196.getItemDefinition(var6);
                                    if(var18.notedTemplate >= 0 && var18.note >= 0) {
                                       class32.field743[++class30.field713 - 1] = var18.note;
                                    } else {
                                       class32.field743[++class30.field713 - 1] = var6;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4207) {
                                    var6 = class32.field743[--class30.field713];
                                    class32.field743[++class30.field713 - 1] = class196.getItemDefinition(var6).isMembers?1:0;
                                    var3 = 1;
                                 } else if(var0 == 4208) {
                                    var6 = class32.field743[--class30.field713];
                                    var18 = class196.getItemDefinition(var6);
                                    if(var18.field3001 == -1 && var18.field2958 >= 0) {
                                       class32.field743[++class30.field713 - 1] = var18.field2958;
                                    } else {
                                       class32.field743[++class30.field713 - 1] = var6;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4209) {
                                    var6 = class32.field743[--class30.field713];
                                    var18 = class196.getItemDefinition(var6);
                                    if(var18.field3001 >= 0 && var18.field2958 >= 0) {
                                       class32.field743[++class30.field713 - 1] = var18.field2958;
                                    } else {
                                       class32.field743[++class30.field713 - 1] = var6;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4210) {
                                    var16 = class32.scriptStringStack[--class32.scriptStringStackSize];
                                    var7 = class32.field743[--class30.field713];
                                    boolean var19 = var7 == 1;
                                    String var20 = var16.toLowerCase();
                                    short[] var21 = new short[16];
                                    var15 = 0;
                                    var11 = 0;

                                    while(true) {
                                       if(var11 >= ItemComposition.field3000) {
                                          class36.field794 = var21;
                                          class9.field78 = 0;
                                          class60.field1104 = var15;
                                          String[] var37 = new String[class60.field1104];

                                          for(var12 = 0; var12 < class60.field1104; ++var12) {
                                             var37[var12] = class196.getItemDefinition(var21[var12]).name;
                                          }

                                          class148.method2832(var37, class36.field794);
                                          break;
                                       }

                                       ItemComposition var22 = class196.getItemDefinition(var11);
                                       if((!var19 || var22.field2997) && var22.notedTemplate == -1 && var22.name.toLowerCase().indexOf(var20) != -1) {
                                          if(var15 >= 250) {
                                             class60.field1104 = -1;
                                             class36.field794 = null;
                                             break;
                                          }

                                          if(var15 >= var21.length) {
                                             short[] var23 = new short[var21.length * 2];

                                             for(int var24 = 0; var24 < var15; ++var24) {
                                                var23[var24] = var21[var24];
                                             }

                                             var21 = var23;
                                          }

                                          var21[var15++] = (short)var11;
                                       }

                                       ++var11;
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
      Rasterizer2D.method4007(var0, var1 + 16, 16, var3 - 32, Client.field379);
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
      Rasterizer2D.method4017(var0 + 15, var1 + 16 + var6, var5, Client.field381);
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

         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         for(var2 = 0; var2 < var1; ++var2) {
            int var8 = Client.field342[var2];
            NPC var9 = Client.cachedNPCs[var8];
            var3 = Client.secretCipherBuffer2.method3111(1);
            if(var3 == 0) {
               Client.field342[++Client.field402 - 1] = var8;
               var9.field667 = Client.gameCycle;
            } else {
               var4 = Client.secretCipherBuffer2.method3111(2);
               if(var4 == 0) {
                  Client.field342[++Client.field402 - 1] = var8;
                  var9.field667 = Client.gameCycle;
                  Client.field485[++Client.field343 - 1] = var8;
               } else if(var4 == 1) {
                  Client.field342[++Client.field402 - 1] = var8;
                  var9.field667 = Client.gameCycle;
                  var5 = Client.secretCipherBuffer2.method3111(3);
                  var9.method735(var5, (byte)1);
                  var6 = Client.secretCipherBuffer2.method3111(1);
                  if(var6 == 1) {
                     Client.field485[++Client.field343 - 1] = var8;
                  }
               } else if(var4 == 2) {
                  Client.field342[++Client.field402 - 1] = var8;
                  var9.field667 = Client.gameCycle;
                  var5 = Client.secretCipherBuffer2.method3111(3);
                  var9.method735(var5, (byte)2);
                  var6 = Client.secretCipherBuffer2.method3111(3);
                  var9.method735(var6, (byte)2);
                  var7 = Client.secretCipherBuffer2.method3111(1);
                  if(var7 == 1) {
                     Client.field485[++Client.field343 - 1] = var8;
                  }
               } else if(var4 == 3) {
                  Client.field426[++Client.field310 - 1] = var8;
               }
            }
         }

         NPC var13;
         int var14;
         while(Client.secretCipherBuffer2.method3098(Client.field348) >= 27) {
            var1 = Client.secretCipherBuffer2.method3111(15);
            if(var1 == 32767) {
               break;
            }

            boolean var10 = false;
            if(Client.cachedNPCs[var1] == null) {
               Client.cachedNPCs[var1] = new NPC();
               var10 = true;
            }

            var13 = Client.cachedNPCs[var1];
            Client.field342[++Client.field402 - 1] = var1;
            var13.field667 = Client.gameCycle;
            var14 = Client.secretCipherBuffer2.method3111(1);
            var3 = Client.secretCipherBuffer2.method3111(1);
            if(var3 == 1) {
               Client.field485[++Client.field343 - 1] = var1;
            }

            var4 = Client.field430[Client.secretCipherBuffer2.method3111(3)];
            if(var10) {
               var13.field669 = var13.angle = var4;
            }

            var13.composition = class15.getNpcDefinition(Client.secretCipherBuffer2.method3111(14));
            if(var0) {
               var5 = Client.secretCipherBuffer2.method3111(8);
               if(var5 > 127) {
                  var5 -= 256;
               }
            } else {
               var5 = Client.secretCipherBuffer2.method3111(5);
               if(var5 > 15) {
                  var5 -= 32;
               }
            }

            if(var0) {
               var6 = Client.secretCipherBuffer2.method3111(8);
               if(var6 > 127) {
                  var6 -= 256;
               }
            } else {
               var6 = Client.secretCipherBuffer2.method3111(5);
               if(var6 > 15) {
                  var6 -= 32;
               }
            }

            var13.field622 = var13.composition.field3011;
            var13.field671 = var13.composition.field3034;
            if(var13.field671 == 0) {
               var13.angle = 0;
            }

            var13.field626 = var13.composition.field3017;
            var13.field627 = var13.composition.field3018;
            var13.field645 = var13.composition.field3019;
            var13.field629 = var13.composition.field3031;
            var13.idlePoseAnimation = var13.composition.field3014;
            var13.field633 = var13.composition.field3038;
            var13.field625 = var13.composition.field3016;
            var13.method736(var5 + Projectile.localPlayer.pathX[0], var6 + Projectile.localPlayer.pathY[0], var14 == 1);
         }

         Client.secretCipherBuffer2.method3103();

         for(var1 = 0; var1 < Client.field343; ++var1) {
            var2 = Client.field485[var1];
            var13 = Client.cachedNPCs[var2];
            var14 = Client.secretCipherBuffer2.readUnsignedByte();
            if((var14 & 8) != 0) {
               var13.composition = class15.getNpcDefinition(Client.secretCipherBuffer2.method2853());
               var13.field622 = var13.composition.field3011;
               var13.field671 = var13.composition.field3034;
               var13.field626 = var13.composition.field3017;
               var13.field627 = var13.composition.field3018;
               var13.field645 = var13.composition.field3019;
               var13.field629 = var13.composition.field3031;
               var13.idlePoseAnimation = var13.composition.field3014;
               var13.field633 = var13.composition.field3038;
               var13.field625 = var13.composition.field3016;
            }

            if((var14 & 32) != 0) {
               var13.overhead = Client.secretCipherBuffer2.readString();
               var13.field656 = 100;
            }

            if((var14 & 1) != 0) {
               var3 = Client.secretCipherBuffer2.method2904();
               var4 = Client.secretCipherBuffer2.method2853();
               var5 = var13.x - (var3 - class119.baseX - class119.baseX) * 64;
               var6 = var13.y - (var4 - class187.baseY - class187.baseY) * 64;
               if(var5 != 0 || var6 != 0) {
                  var13.field646 = (int)(Math.atan2((double)var5, (double)var6) * 325.949D) & 2047;
               }
            }

            if((var14 & 64) != 0) {
               var3 = Client.secretCipherBuffer2.method2903();
               if(var3 == '\uffff') {
                  var3 = -1;
               }

               var4 = Client.secretCipherBuffer2.method3015();
               if(var3 == var13.animation && var3 != -1) {
                  var5 = Friend.getAnimation(var3).replyMode;
                  if(var5 == 1) {
                     var13.actionFrame = 0;
                     var13.field652 = 0;
                     var13.actionAnimationDisable = var4;
                     var13.field637 = 0;
                  }

                  if(var5 == 2) {
                     var13.field637 = 0;
                  }
               } else if(var3 == -1 || var13.animation == -1 || Friend.getAnimation(var3).forcedPriority >= Friend.getAnimation(var13.animation).forcedPriority) {
                  var13.animation = var3;
                  var13.actionFrame = 0;
                  var13.field652 = 0;
                  var13.actionAnimationDisable = var4;
                  var13.field637 = 0;
                  var13.field655 = var13.field672;
               }
            }

            if((var14 & 2) != 0) {
               var3 = Client.secretCipherBuffer2.method3051();
               int var11;
               int var15;
               if(var3 > 0) {
                  for(var4 = 0; var4 < var3; ++var4) {
                     var6 = -1;
                     var7 = -1;
                     var11 = -1;
                     var5 = Client.secretCipherBuffer2.method2880();
                     if(var5 == 32767) {
                        var5 = Client.secretCipherBuffer2.method2880();
                        var7 = Client.secretCipherBuffer2.method2880();
                        var6 = Client.secretCipherBuffer2.method2880();
                        var11 = Client.secretCipherBuffer2.method2880();
                     } else if(var5 != 32766) {
                        var7 = Client.secretCipherBuffer2.method2880();
                     } else {
                        var5 = -1;
                     }

                     var15 = Client.secretCipherBuffer2.method2880();
                     var13.method585(var5, var7, var6, var11, Client.gameCycle, var15);
                  }
               }

               var4 = Client.secretCipherBuffer2.method3015();
               if(var4 > 0) {
                  for(var5 = 0; var5 < var4; ++var5) {
                     var6 = Client.secretCipherBuffer2.method2880();
                     var7 = Client.secretCipherBuffer2.method2880();
                     if(var7 != 32767) {
                        var11 = Client.secretCipherBuffer2.method2880();
                        var15 = Client.secretCipherBuffer2.readUnsignedByte();
                        int var12 = var7 > 0?Client.secretCipherBuffer2.readUnsignedByte():var15;
                        var13.method570(var6, Client.gameCycle, var7, var11, var15, var12);
                     } else {
                        var13.method569(var6);
                     }
                  }
               }
            }

            if((var14 & 4) != 0) {
               var13.interacting = Client.secretCipherBuffer2.method2904();
               if(var13.interacting == '\uffff') {
                  var13.interacting = -1;
               }
            }

            if((var14 & 16) != 0) {
               var13.graphic = Client.secretCipherBuffer2.method2853();
               var3 = Client.secretCipherBuffer2.method3006();
               var13.field659 = var3 >> 16;
               var13.field658 = (var3 & '\uffff') + Client.gameCycle;
               var13.field678 = 0;
               var13.field638 = 0;
               if(var13.field658 > Client.gameCycle) {
                  var13.field678 = -1;
               }

               if(var13.graphic == '\uffff') {
                  var13.graphic = -1;
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
