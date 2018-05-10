import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
public class class126 {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILcs;ZI)I",
      garbageValue = "2146503778"
   )
   static int method3072(int var0, Script var1, boolean var2) {
      byte var3;
      int var4;
      int var6;
      int var9;
      int var24;
      Widget var67;
      Widget var68;
      if(var0 < 1000) {
         if(var0 == 100) {
            class45.intStackSize -= 3;
            var4 = class69.intStack[class45.intStackSize];
            var24 = class69.intStack[class45.intStackSize + 1];
            var6 = class69.intStack[class45.intStackSize + 2];
            if(var24 == 0) {
               throw new RuntimeException();
            }

            Widget var30 = OwnWorldComparator.getWidget(var4);
            if(var30.children == null) {
               var30.children = new Widget[var6 + 1];
            }

            if(var30.children.length <= var6) {
               Widget[] var32 = new Widget[var6 + 1];

               for(var9 = 0; var9 < var30.children.length; ++var9) {
                  var32[var9] = var30.children[var9];
               }

               var30.children = var32;
            }

            if(var6 > 0 && var30.children[var6 - 1] == null) {
               throw new RuntimeException("" + (var6 - 1));
            }

            Widget var33 = new Widget();
            var33.type = var24;
            var33.parentId = var33.id = var30.id;
            var33.index = var6;
            var33.hasScript = true;
            var30.children[var6] = var33;
            if(var2) {
               class184.field2379 = var33;
            } else {
               FriendManager.field996 = var33;
            }

            DState.method3548(var30);
            var3 = 1;
         } else if(var0 == 101) {
            var68 = var2?class184.field2379:FriendManager.field996;
            var67 = OwnWorldComparator.getWidget(var68.id);
            var67.children[var68.index] = null;
            DState.method3548(var67);
            var3 = 1;
         } else if(var0 == 102) {
            var68 = OwnWorldComparator.getWidget(class69.intStack[--class45.intStackSize]);
            var68.children = null;
            DState.method3548(var68);
            var3 = 1;
         } else if(var0 == 200) {
            class45.intStackSize -= 2;
            var4 = class69.intStack[class45.intStackSize];
            var24 = class69.intStack[class45.intStackSize + 1];
            Widget var63 = class21.getWidgetChild(var4, var24);
            if(var63 != null && var24 != -1) {
               class69.intStack[++class45.intStackSize - 1] = 1;
               if(var2) {
                  class184.field2379 = var63;
               } else {
                  FriendManager.field996 = var63;
               }
            } else {
               class69.intStack[++class45.intStackSize - 1] = 0;
            }

            var3 = 1;
         } else if(var0 == 201) {
            var68 = OwnWorldComparator.getWidget(class69.intStack[--class45.intStackSize]);
            if(var68 != null) {
               class69.intStack[++class45.intStackSize - 1] = 1;
               if(var2) {
                  class184.field2379 = var68;
               } else {
                  FriendManager.field996 = var68;
               }
            } else {
               class69.intStack[++class45.intStackSize - 1] = 0;
            }

            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 1100) {
         return NetWriter.method2047(var0, var1, var2);
      } else if(var0 < 1200) {
         return UrlRequest.method3138(var0, var1, var2);
      } else if(var0 < 1300) {
         return ScriptState.method1062(var0, var1, var2);
      } else if(var0 < 1400) {
         return NPC.method1831(var0, var1, var2);
      } else if(var0 < 1500) {
         return MouseRecorder.method1090(var0, var1, var2);
      } else if(var0 < 1600) {
         return Varcs.method1943(var0, var1, var2);
      } else if(var0 < 1700) {
         return class52.method1066(var0, var1, var2);
      } else if(var0 < 1800) {
         return class25.method464(var0, var1, var2);
      } else {
         int var17;
         int var46;
         int[] var65;
         if(var0 < 1900) {
            var68 = var2?class184.field2379:FriendManager.field996;
            if(var0 == 1800) {
               var65 = class69.intStack;
               var6 = ++class45.intStackSize - 1;
               var17 = AbstractSoundSystem.getWidgetClickMask(var68);
               var46 = var17 >> 11 & 63;
               var65[var6] = var46;
               var3 = 1;
            } else if(var0 == 1801) {
               var24 = class69.intStack[--class45.intStackSize];
               --var24;
               if(var68.actions != null && var24 < var68.actions.length && var68.actions[var24] != null) {
                  class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var68.actions[var24];
               } else {
                  class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
               }

               var3 = 1;
            } else if(var0 == 1802) {
               if(var68.opBase == null) {
                  class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
               } else {
                  class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var68.opBase;
               }

               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 2000) {
            var4 = var0;
            if(var0 >= 2000) {
               var4 = var0 - 1000;
               var67 = OwnWorldComparator.getWidget(class69.intStack[--class45.intStackSize]);
            } else {
               var67 = var2?class184.field2379:FriendManager.field996;
            }

            if(var4 == 1927) {
               if(class69.field1025 >= 10) {
                  throw new RuntimeException();
               }

               if(var67.onResizeListener == null) {
                  var3 = 0;
               } else {
                  ScriptEvent var62 = new ScriptEvent();
                  var62.source = var67;
                  var62.params = var67.onResizeListener;
                  var62.field519 = class69.field1025 + 1;
                  Client.field755.addFront(var62);
                  var3 = 1;
               }
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 2100) {
            return NetWriter.method2047(var0, var1, var2);
         } else if(var0 < 2200) {
            return UrlRequest.method3138(var0, var1, var2);
         } else if(var0 < 2300) {
            return ScriptState.method1062(var0, var1, var2);
         } else if(var0 < 2400) {
            return NPC.method1831(var0, var1, var2);
         } else if(var0 < 2500) {
            return MouseRecorder.method1090(var0, var1, var2);
         } else if(var0 < 2600) {
            var68 = OwnWorldComparator.getWidget(class69.intStack[--class45.intStackSize]);
            if(var0 == 2500) {
               class69.intStack[++class45.intStackSize - 1] = var68.relativeX;
               var3 = 1;
            } else if(var0 == 2501) {
               class69.intStack[++class45.intStackSize - 1] = var68.relativeY;
               var3 = 1;
            } else if(var0 == 2502) {
               class69.intStack[++class45.intStackSize - 1] = var68.width;
               var3 = 1;
            } else if(var0 == 2503) {
               class69.intStack[++class45.intStackSize - 1] = var68.height;
               var3 = 1;
            } else if(var0 == 2504) {
               class69.intStack[++class45.intStackSize - 1] = var68.isHidden?1:0;
               var3 = 1;
            } else if(var0 == 2505) {
               class69.intStack[++class45.intStackSize - 1] = var68.parentId;
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 2700) {
            return class32.method600(var0, var1, var2);
         } else if(var0 < 2800) {
            if(var0 == 2700) {
               var68 = OwnWorldComparator.getWidget(class69.intStack[--class45.intStackSize]);
               class69.intStack[++class45.intStackSize - 1] = var68.itemId;
               var3 = 1;
            } else if(var0 == 2701) {
               var68 = OwnWorldComparator.getWidget(class69.intStack[--class45.intStackSize]);
               if(var68.itemId != -1) {
                  class69.intStack[++class45.intStackSize - 1] = var68.itemQuantity;
               } else {
                  class69.intStack[++class45.intStackSize - 1] = 0;
               }

               var3 = 1;
            } else if(var0 == 2702) {
               var4 = class69.intStack[--class45.intStackSize];
               WidgetNode var66 = (WidgetNode)Client.componentTable.get((long)var4);
               if(var66 != null) {
                  class69.intStack[++class45.intStackSize - 1] = 1;
               } else {
                  class69.intStack[++class45.intStackSize - 1] = 0;
               }

               var3 = 1;
            } else if(var0 == 2706) {
               class69.intStack[++class45.intStackSize - 1] = Client.widgetRoot;
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 2900) {
            var68 = OwnWorldComparator.getWidget(class69.intStack[--class45.intStackSize]);
            if(var0 == 2800) {
               var65 = class69.intStack;
               var6 = ++class45.intStackSize - 1;
               var17 = AbstractSoundSystem.getWidgetClickMask(var68);
               var46 = var17 >> 11 & 63;
               var65[var6] = var46;
               var3 = 1;
            } else if(var0 == 2801) {
               var24 = class69.intStack[--class45.intStackSize];
               --var24;
               if(var68.actions != null && var24 < var68.actions.length && var68.actions[var24] != null) {
                  class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var68.actions[var24];
               } else {
                  class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
               }

               var3 = 1;
            } else if(var0 == 2802) {
               if(var68.opBase == null) {
                  class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
               } else {
                  class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var68.opBase;
               }

               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 3000) {
            return class98.method2285(var0, var1, var2);
         } else if(var0 < 3200) {
            return WorldMapManager.method528(var0, var1, var2);
         } else if(var0 < 3300) {
            return MessageNode.method1118(var0, var1, var2);
         } else {
            int var20;
            int[] var43;
            if(var0 < 3400) {
               if(var0 == 3300) {
                  class69.intStack[++class45.intStackSize - 1] = Client.gameCycle;
                  var3 = 1;
               } else {
                  ItemContainer var58;
                  if(var0 == 3301) {
                     class45.intStackSize -= 2;
                     var4 = class69.intStack[class45.intStackSize];
                     var24 = class69.intStack[class45.intStackSize + 1];
                     var43 = class69.intStack;
                     var46 = ++class45.intStackSize - 1;
                     var58 = (ItemContainer)ItemContainer.itemContainers.get((long)var4);
                     if(var58 == null) {
                        var17 = -1;
                     } else if(var24 >= 0 && var24 < var58.itemIds.length) {
                        var17 = var58.itemIds[var24];
                     } else {
                        var17 = -1;
                     }

                     var43[var46] = var17;
                     var3 = 1;
                  } else if(var0 == 3302) {
                     class45.intStackSize -= 2;
                     var4 = class69.intStack[class45.intStackSize];
                     var24 = class69.intStack[class45.intStackSize + 1];
                     var43 = class69.intStack;
                     var46 = ++class45.intStackSize - 1;
                     var58 = (ItemContainer)ItemContainer.itemContainers.get((long)var4);
                     if(var58 == null) {
                        var17 = 0;
                     } else if(var24 >= 0 && var24 < var58.stackSizes.length) {
                        var17 = var58.stackSizes[var24];
                     } else {
                        var17 = 0;
                     }

                     var43[var46] = var17;
                     var3 = 1;
                  } else {
                     int var21;
                     if(var0 == 3303) {
                        class45.intStackSize -= 2;
                        var4 = class69.intStack[class45.intStackSize];
                        var24 = class69.intStack[class45.intStackSize + 1];
                        var43 = class69.intStack;
                        var46 = ++class45.intStackSize - 1;
                        var58 = (ItemContainer)ItemContainer.itemContainers.get((long)var4);
                        if(var58 == null) {
                           var17 = 0;
                        } else if(var24 == -1) {
                           var17 = 0;
                        } else {
                           var20 = 0;

                           for(var21 = 0; var21 < var58.stackSizes.length; ++var21) {
                              if(var24 == var58.itemIds[var21]) {
                                 var20 += var58.stackSizes[var21];
                              }
                           }

                           var17 = var20;
                        }

                        var43[var46] = var17;
                        var3 = 1;
                     } else if(var0 == 3304) {
                        var4 = class69.intStack[--class45.intStackSize];
                        class69.intStack[++class45.intStackSize - 1] = FileRequest.method4622(var4).size;
                        var3 = 1;
                     } else if(var0 == 3305) {
                        var4 = class69.intStack[--class45.intStackSize];
                        class69.intStack[++class45.intStackSize - 1] = Client.boostedSkillLevels[var4];
                        var3 = 1;
                     } else if(var0 == 3306) {
                        var4 = class69.intStack[--class45.intStackSize];
                        class69.intStack[++class45.intStackSize - 1] = Client.realSkillLevels[var4];
                        var3 = 1;
                     } else if(var0 == 3307) {
                        var4 = class69.intStack[--class45.intStackSize];
                        class69.intStack[++class45.intStackSize - 1] = Client.skillExperiences[var4];
                        var3 = 1;
                     } else if(var0 == 3308) {
                        var4 = class192.plane;
                        var24 = (MilliTimer.localPlayer.x >> 7) + class178.baseX;
                        var6 = (MilliTimer.localPlayer.y >> 7) + CombatInfoListHolder.baseY;
                        class69.intStack[++class45.intStackSize - 1] = (var24 << 14) + var6 + (var4 << 28);
                        var3 = 1;
                     } else if(var0 == 3309) {
                        var4 = class69.intStack[--class45.intStackSize];
                        class69.intStack[++class45.intStackSize - 1] = var4 >> 14 & 16383;
                        var3 = 1;
                     } else if(var0 == 3310) {
                        var4 = class69.intStack[--class45.intStackSize];
                        class69.intStack[++class45.intStackSize - 1] = var4 >> 28;
                        var3 = 1;
                     } else if(var0 == 3311) {
                        var4 = class69.intStack[--class45.intStackSize];
                        class69.intStack[++class45.intStackSize - 1] = var4 & 16383;
                        var3 = 1;
                     } else if(var0 == 3312) {
                        class69.intStack[++class45.intStackSize - 1] = Client.isMembers?1:0;
                        var3 = 1;
                     } else if(var0 == 3313) {
                        class45.intStackSize -= 2;
                        var4 = class69.intStack[class45.intStackSize] + 32768;
                        var24 = class69.intStack[class45.intStackSize + 1];
                        var43 = class69.intStack;
                        var46 = ++class45.intStackSize - 1;
                        var58 = (ItemContainer)ItemContainer.itemContainers.get((long)var4);
                        if(var58 == null) {
                           var17 = -1;
                        } else if(var24 >= 0 && var24 < var58.itemIds.length) {
                           var17 = var58.itemIds[var24];
                        } else {
                           var17 = -1;
                        }

                        var43[var46] = var17;
                        var3 = 1;
                     } else if(var0 == 3314) {
                        class45.intStackSize -= 2;
                        var4 = class69.intStack[class45.intStackSize] + 32768;
                        var24 = class69.intStack[class45.intStackSize + 1];
                        var43 = class69.intStack;
                        var46 = ++class45.intStackSize - 1;
                        var58 = (ItemContainer)ItemContainer.itemContainers.get((long)var4);
                        if(var58 == null) {
                           var17 = 0;
                        } else if(var24 >= 0 && var24 < var58.stackSizes.length) {
                           var17 = var58.stackSizes[var24];
                        } else {
                           var17 = 0;
                        }

                        var43[var46] = var17;
                        var3 = 1;
                     } else if(var0 == 3315) {
                        class45.intStackSize -= 2;
                        var4 = class69.intStack[class45.intStackSize] + 32768;
                        var24 = class69.intStack[class45.intStackSize + 1];
                        var43 = class69.intStack;
                        var46 = ++class45.intStackSize - 1;
                        var58 = (ItemContainer)ItemContainer.itemContainers.get((long)var4);
                        if(var58 == null) {
                           var17 = 0;
                        } else if(var24 == -1) {
                           var17 = 0;
                        } else {
                           var20 = 0;

                           for(var21 = 0; var21 < var58.stackSizes.length; ++var21) {
                              if(var24 == var58.itemIds[var21]) {
                                 var20 += var58.stackSizes[var21];
                              }
                           }

                           var17 = var20;
                        }

                        var43[var46] = var17;
                        var3 = 1;
                     } else if(var0 == 3316) {
                        if(Client.rights >= 2) {
                           class69.intStack[++class45.intStackSize - 1] = Client.rights;
                        } else {
                           class69.intStack[++class45.intStackSize - 1] = 0;
                        }

                        var3 = 1;
                     } else if(var0 == 3317) {
                        class69.intStack[++class45.intStackSize - 1] = Client.field643;
                        var3 = 1;
                     } else if(var0 == 3318) {
                        class69.intStack[++class45.intStackSize - 1] = Client.world;
                        var3 = 1;
                     } else if(var0 == 3321) {
                        class69.intStack[++class45.intStackSize - 1] = Client.energy;
                        var3 = 1;
                     } else if(var0 == 3322) {
                        class69.intStack[++class45.intStackSize - 1] = Client.weight;
                        var3 = 1;
                     } else if(var0 == 3323) {
                        if(Client.field761) {
                           class69.intStack[++class45.intStackSize - 1] = 1;
                        } else {
                           class69.intStack[++class45.intStackSize - 1] = 0;
                        }

                        var3 = 1;
                     } else if(var0 == 3324) {
                        class69.intStack[++class45.intStackSize - 1] = Client.flags;
                        var3 = 1;
                     } else if(var0 == 3325) {
                        class45.intStackSize -= 4;
                        var4 = class69.intStack[class45.intStackSize];
                        var24 = class69.intStack[class45.intStackSize + 1];
                        var6 = class69.intStack[class45.intStackSize + 2];
                        var46 = class69.intStack[class45.intStackSize + 3];
                        var4 += var24 << 14;
                        var4 += var6 << 28;
                        var4 += var46;
                        class69.intStack[++class45.intStackSize - 1] = var4;
                        var3 = 1;
                     } else {
                        var3 = 2;
                     }
                  }
               }

               return var3;
            } else if(var0 < 3500) {
               if(var0 == 3400) {
                  class45.intStackSize -= 2;
                  var4 = class69.intStack[class45.intStackSize];
                  var24 = class69.intStack[class45.intStackSize + 1];
                  Enum var59 = ScriptState.method1063(var4);
                  if(var59.valType != 's') {
                     ;
                  }

                  for(var46 = 0; var46 < var59.size; ++var46) {
                     if(var24 == var59.keys[var46]) {
                        class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var59.stringVals[var46];
                        var59 = null;
                        break;
                     }
                  }

                  if(var59 != null) {
                     class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var59.defaultString;
                  }

                  var3 = 1;
               } else if(var0 == 3408) {
                  class45.intStackSize -= 4;
                  var4 = class69.intStack[class45.intStackSize];
                  var24 = class69.intStack[class45.intStackSize + 1];
                  var6 = class69.intStack[class45.intStackSize + 2];
                  var46 = class69.intStack[class45.intStackSize + 3];
                  Enum var31 = ScriptState.method1063(var6);
                  if(var4 == var31.keyType && var24 == var31.valType) {
                     for(var9 = 0; var9 < var31.size; ++var9) {
                        if(var46 == var31.keys[var9]) {
                           if(var24 == 115) {
                              class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var31.stringVals[var9];
                           } else {
                              class69.intStack[++class45.intStackSize - 1] = var31.intVals[var9];
                           }

                           var31 = null;
                           break;
                        }
                     }

                     if(var31 != null) {
                        if(var24 == 115) {
                           class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var31.defaultString;
                        } else {
                           class69.intStack[++class45.intStackSize - 1] = var31.defaultInt;
                        }
                     }

                     var3 = 1;
                  } else {
                     if(var24 == 115) {
                        class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "null";
                     } else {
                        class69.intStack[++class45.intStackSize - 1] = 0;
                     }

                     var3 = 1;
                  }
               } else if(var0 == 3411) {
                  var4 = class69.intStack[--class45.intStackSize];
                  Enum var64 = ScriptState.method1063(var4);
                  class69.intStack[++class45.intStackSize - 1] = var64.method4998();
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 3700) {
               return LoginPacket.method3465(var0, var1, var2);
            } else {
               boolean var5;
               boolean var34;
               if(var0 < 4000) {
                  if(var0 == 3903) {
                     var4 = class69.intStack[--class45.intStackSize];
                     class69.intStack[++class45.intStackSize - 1] = Client.grandExchangeOffers[var4].type();
                     var3 = 1;
                  } else if(var0 == 3904) {
                     var4 = class69.intStack[--class45.intStackSize];
                     class69.intStack[++class45.intStackSize - 1] = Client.grandExchangeOffers[var4].itemId;
                     var3 = 1;
                  } else if(var0 == 3905) {
                     var4 = class69.intStack[--class45.intStackSize];
                     class69.intStack[++class45.intStackSize - 1] = Client.grandExchangeOffers[var4].price;
                     var3 = 1;
                  } else if(var0 == 3906) {
                     var4 = class69.intStack[--class45.intStackSize];
                     class69.intStack[++class45.intStackSize - 1] = Client.grandExchangeOffers[var4].totalQuantity;
                     var3 = 1;
                  } else if(var0 == 3907) {
                     var4 = class69.intStack[--class45.intStackSize];
                     class69.intStack[++class45.intStackSize - 1] = Client.grandExchangeOffers[var4].quantitySold;
                     var3 = 1;
                  } else if(var0 == 3908) {
                     var4 = class69.intStack[--class45.intStackSize];
                     class69.intStack[++class45.intStackSize - 1] = Client.grandExchangeOffers[var4].spent;
                     var3 = 1;
                  } else if(var0 == 3910) {
                     var4 = class69.intStack[--class45.intStackSize];
                     var24 = Client.grandExchangeOffers[var4].status();
                     class69.intStack[++class45.intStackSize - 1] = var24 == 0?1:0;
                     var3 = 1;
                  } else if(var0 == 3911) {
                     var4 = class69.intStack[--class45.intStackSize];
                     var24 = Client.grandExchangeOffers[var4].status();
                     class69.intStack[++class45.intStackSize - 1] = var24 == 2?1:0;
                     var3 = 1;
                  } else if(var0 == 3912) {
                     var4 = class69.intStack[--class45.intStackSize];
                     var24 = Client.grandExchangeOffers[var4].status();
                     class69.intStack[++class45.intStackSize - 1] = var24 == 5?1:0;
                     var3 = 1;
                  } else if(var0 == 3913) {
                     var4 = class69.intStack[--class45.intStackSize];
                     var24 = Client.grandExchangeOffers[var4].status();
                     class69.intStack[++class45.intStackSize - 1] = var24 == 1?1:0;
                     var3 = 1;
                  } else if(var0 == 3914) {
                     var34 = class69.intStack[--class45.intStackSize] == 1;
                     if(class173.grandExchangeEvents != null) {
                        class173.grandExchangeEvents.sort(GrandExchangeEvents.field8, var34);
                     }

                     var3 = 1;
                  } else if(var0 == 3915) {
                     var34 = class69.intStack[--class45.intStackSize] == 1;
                     if(class173.grandExchangeEvents != null) {
                        class173.grandExchangeEvents.sort(GrandExchangeEvents.field7, var34);
                     }

                     var3 = 1;
                  } else if(var0 == 3916) {
                     class45.intStackSize -= 2;
                     var34 = class69.intStack[class45.intStackSize] == 1;
                     var5 = class69.intStack[class45.intStackSize + 1] == 1;
                     if(class173.grandExchangeEvents != null) {
                        Client.field738.field591 = var5;
                        class173.grandExchangeEvents.sort(Client.field738, var34);
                     }

                     var3 = 1;
                  } else if(var0 == 3917) {
                     var34 = class69.intStack[--class45.intStackSize] == 1;
                     if(class173.grandExchangeEvents != null) {
                        class173.grandExchangeEvents.sort(GrandExchangeEvents.field5, var34);
                     }

                     var3 = 1;
                  } else if(var0 == 3918) {
                     var34 = class69.intStack[--class45.intStackSize] == 1;
                     if(class173.grandExchangeEvents != null) {
                        class173.grandExchangeEvents.sort(GrandExchangeEvents.field9, var34);
                     }

                     var3 = 1;
                  } else if(var0 == 3919) {
                     class69.intStack[++class45.intStackSize - 1] = class173.grandExchangeEvents == null?0:class173.grandExchangeEvents.events.size();
                     var3 = 1;
                  } else {
                     GrandExchangeEvent var61;
                     if(var0 == 3920) {
                        var4 = class69.intStack[--class45.intStackSize];
                        var61 = (GrandExchangeEvent)class173.grandExchangeEvents.events.get(var4);
                        class69.intStack[++class45.intStackSize - 1] = var61.world;
                        var3 = 1;
                     } else if(var0 == 3921) {
                        var4 = class69.intStack[--class45.intStackSize];
                        var61 = (GrandExchangeEvent)class173.grandExchangeEvents.events.get(var4);
                        class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var61.method16();
                        var3 = 1;
                     } else if(var0 == 3922) {
                        var4 = class69.intStack[--class45.intStackSize];
                        var61 = (GrandExchangeEvent)class173.grandExchangeEvents.events.get(var4);
                        class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var61.method17();
                        var3 = 1;
                     } else if(var0 == 3923) {
                        var4 = class69.intStack[--class45.intStackSize];
                        var61 = (GrandExchangeEvent)class173.grandExchangeEvents.events.get(var4);
                        long var22 = class166.method3456() - Client.field629 - var61.field10;
                        var17 = (int)(var22 / 3600000L);
                        var9 = (int)((var22 - (long)(var17 * 3600000)) / 60000L);
                        var20 = (int)((var22 - (long)(var17 * 3600000) - (long)(var9 * 60000)) / 1000L);
                        String var37 = var17 + ":" + var9 / 10 + var9 % 10 + ":" + var20 / 10 + var20 % 10;
                        class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var37;
                        var3 = 1;
                     } else if(var0 == 3924) {
                        var4 = class69.intStack[--class45.intStackSize];
                        var61 = (GrandExchangeEvent)class173.grandExchangeEvents.events.get(var4);
                        class69.intStack[++class45.intStackSize - 1] = var61.grandExchangeOffer.totalQuantity;
                        var3 = 1;
                     } else if(var0 == 3925) {
                        var4 = class69.intStack[--class45.intStackSize];
                        var61 = (GrandExchangeEvent)class173.grandExchangeEvents.events.get(var4);
                        class69.intStack[++class45.intStackSize - 1] = var61.grandExchangeOffer.price;
                        var3 = 1;
                     } else if(var0 == 3926) {
                        var4 = class69.intStack[--class45.intStackSize];
                        var61 = (GrandExchangeEvent)class173.grandExchangeEvents.events.get(var4);
                        class69.intStack[++class45.intStackSize - 1] = var61.grandExchangeOffer.itemId;
                        var3 = 1;
                     } else {
                        var3 = 2;
                     }
                  }

                  return var3;
               } else if(var0 < 4100) {
                  return WallObject.method3081(var0, var1, var2);
               } else if(var0 < 4200) {
                  return ItemLayer.method2617(var0, var1, var2);
               } else if(var0 < 4300) {
                  return Preferences.method1661(var0, var1, var2);
               } else {
                  String var39;
                  PacketNode var49;
                  if(var0 < 5100) {
                     if(var0 == 5000) {
                        class69.intStack[++class45.intStackSize - 1] = Client.publicChatMode;
                        var3 = 1;
                     } else if(var0 == 5001) {
                        class45.intStackSize -= 3;
                        Client.publicChatMode = class69.intStack[class45.intStackSize];
                        var24 = class69.intStack[class45.intStackSize + 1];
                        class307[] var50 = class151.method3235();
                        var46 = 0;

                        class307 var47;
                        while(true) {
                           if(var46 >= var50.length) {
                              var47 = null;
                              break;
                           }

                           class307 var8 = var50[var46];
                           if(var24 == var8.field3741) {
                              var47 = var8;
                              break;
                           }

                           ++var46;
                        }

                        WorldMapData.field170 = var47;
                        if(WorldMapData.field170 == null) {
                           WorldMapData.field170 = class307.field3740;
                        }

                        Client.field694 = class69.intStack[class45.intStackSize + 2];
                        var49 = DecorativeObject.method3115(ClientPacket.field2219, Client.field739.field1250);
                        var49.packetBuffer.putByte(Client.publicChatMode);
                        var49.packetBuffer.putByte(WorldMapData.field170.field3741);
                        var49.packetBuffer.putByte(Client.field694);
                        Client.field739.method2019(var49);
                        var3 = 1;
                     } else {
                        String var51;
                        if(var0 == 5002) {
                           var51 = class69.scriptStringStack[--class83.scriptStringStackSize];
                           class45.intStackSize -= 2;
                           var24 = class69.intStack[class45.intStackSize];
                           var6 = class69.intStack[class45.intStackSize + 1];
                           PacketNode var27 = DecorativeObject.method3115(ClientPacket.field2248, Client.field739.field1250);
                           var27.packetBuffer.putByte(Size.getLength(var51) + 2);
                           var27.packetBuffer.putString(var51);
                           var27.packetBuffer.putByte(var24 - 1);
                           var27.packetBuffer.putByte(var6);
                           Client.field739.method2019(var27);
                           var3 = 1;
                        } else if(var0 == 5003) {
                           class45.intStackSize -= 2;
                           var4 = class69.intStack[class45.intStackSize];
                           var24 = class69.intStack[class45.intStackSize + 1];
                           ChatLineBuffer var28 = (ChatLineBuffer)class83.chatLineMap.get(Integer.valueOf(var4));
                           MessageNode var53 = var28.getMessage(var24);
                           if(var53 != null) {
                              class69.intStack[++class45.intStackSize - 1] = var53.id;
                              class69.intStack[++class45.intStackSize - 1] = var53.tick;
                              class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var53.name != null?var53.name:"";
                              class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var53.sender != null?var53.sender:"";
                              class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var53.value != null?var53.value:"";
                              class69.intStack[++class45.intStackSize - 1] = var53.method1096()?1:(var53.method1099()?2:0);
                           } else {
                              class69.intStack[++class45.intStackSize - 1] = -1;
                              class69.intStack[++class45.intStackSize - 1] = 0;
                              class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                              class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                              class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                              class69.intStack[++class45.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        } else if(var0 == 5004) {
                           var4 = class69.intStack[--class45.intStackSize];
                           MessageNode var60 = (MessageNode)class83.messages.get((long)var4);
                           if(var60 != null) {
                              class69.intStack[++class45.intStackSize - 1] = var60.type;
                              class69.intStack[++class45.intStackSize - 1] = var60.tick;
                              class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var60.name != null?var60.name:"";
                              class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var60.sender != null?var60.sender:"";
                              class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var60.value != null?var60.value:"";
                              class69.intStack[++class45.intStackSize - 1] = var60.method1096()?1:(var60.method1099()?2:0);
                           } else {
                              class69.intStack[++class45.intStackSize - 1] = -1;
                              class69.intStack[++class45.intStackSize - 1] = 0;
                              class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                              class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                              class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                              class69.intStack[++class45.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        } else if(var0 == 5005) {
                           if(WorldMapData.field170 == null) {
                              class69.intStack[++class45.intStackSize - 1] = -1;
                           } else {
                              class69.intStack[++class45.intStackSize - 1] = WorldMapData.field170.field3741;
                           }

                           var3 = 1;
                        } else if(var0 == 5008) {
                           var51 = class69.scriptStringStack[--class83.scriptStringStackSize];
                           var24 = class69.intStack[--class45.intStackSize];
                           String var54 = var51.toLowerCase();
                           byte var55 = 0;
                           if(var54.startsWith("yellow:")) {
                              var55 = 0;
                              var51 = var51.substring("yellow:".length());
                           } else if(var54.startsWith("red:")) {
                              var55 = 1;
                              var51 = var51.substring("red:".length());
                           } else if(var54.startsWith("green:")) {
                              var55 = 2;
                              var51 = var51.substring("green:".length());
                           } else if(var54.startsWith("cyan:")) {
                              var55 = 3;
                              var51 = var51.substring("cyan:".length());
                           } else if(var54.startsWith("purple:")) {
                              var55 = 4;
                              var51 = var51.substring("purple:".length());
                           } else if(var54.startsWith("white:")) {
                              var55 = 5;
                              var51 = var51.substring("white:".length());
                           } else if(var54.startsWith("flash1:")) {
                              var55 = 6;
                              var51 = var51.substring("flash1:".length());
                           } else if(var54.startsWith("flash2:")) {
                              var55 = 7;
                              var51 = var51.substring("flash2:".length());
                           } else if(var54.startsWith("flash3:")) {
                              var55 = 8;
                              var51 = var51.substring("flash3:".length());
                           } else if(var54.startsWith("glow1:")) {
                              var55 = 9;
                              var51 = var51.substring("glow1:".length());
                           } else if(var54.startsWith("glow2:")) {
                              var55 = 10;
                              var51 = var51.substring("glow2:".length());
                           } else if(var54.startsWith("glow3:")) {
                              var55 = 11;
                              var51 = var51.substring("glow3:".length());
                           } else if(Client.languageId != 0) {
                              if(var54.startsWith("yellow:")) {
                                 var55 = 0;
                                 var51 = var51.substring("yellow:".length());
                              } else if(var54.startsWith("red:")) {
                                 var55 = 1;
                                 var51 = var51.substring("red:".length());
                              } else if(var54.startsWith("green:")) {
                                 var55 = 2;
                                 var51 = var51.substring("green:".length());
                              } else if(var54.startsWith("cyan:")) {
                                 var55 = 3;
                                 var51 = var51.substring("cyan:".length());
                              } else if(var54.startsWith("purple:")) {
                                 var55 = 4;
                                 var51 = var51.substring("purple:".length());
                              } else if(var54.startsWith("white:")) {
                                 var55 = 5;
                                 var51 = var51.substring("white:".length());
                              } else if(var54.startsWith("flash1:")) {
                                 var55 = 6;
                                 var51 = var51.substring("flash1:".length());
                              } else if(var54.startsWith("flash2:")) {
                                 var55 = 7;
                                 var51 = var51.substring("flash2:".length());
                              } else if(var54.startsWith("flash3:")) {
                                 var55 = 8;
                                 var51 = var51.substring("flash3:".length());
                              } else if(var54.startsWith("glow1:")) {
                                 var55 = 9;
                                 var51 = var51.substring("glow1:".length());
                              } else if(var54.startsWith("glow2:")) {
                                 var55 = 10;
                                 var51 = var51.substring("glow2:".length());
                              } else if(var54.startsWith("glow3:")) {
                                 var55 = 11;
                                 var51 = var51.substring("glow3:".length());
                              }
                           }

                           var54 = var51.toLowerCase();
                           byte var48 = 0;
                           if(var54.startsWith("wave:")) {
                              var48 = 1;
                              var51 = var51.substring("wave:".length());
                           } else if(var54.startsWith("wave2:")) {
                              var48 = 2;
                              var51 = var51.substring("wave2:".length());
                           } else if(var54.startsWith("shake:")) {
                              var48 = 3;
                              var51 = var51.substring("shake:".length());
                           } else if(var54.startsWith("scroll:")) {
                              var48 = 4;
                              var51 = var51.substring("scroll:".length());
                           } else if(var54.startsWith("slide:")) {
                              var48 = 5;
                              var51 = var51.substring("slide:".length());
                           } else if(Client.languageId != 0) {
                              if(var54.startsWith("wave:")) {
                                 var48 = 1;
                                 var51 = var51.substring("wave:".length());
                              } else if(var54.startsWith("wave2:")) {
                                 var48 = 2;
                                 var51 = var51.substring("wave2:".length());
                              } else if(var54.startsWith("shake:")) {
                                 var48 = 3;
                                 var51 = var51.substring("shake:".length());
                              } else if(var54.startsWith("scroll:")) {
                                 var48 = 4;
                                 var51 = var51.substring("scroll:".length());
                              } else if(var54.startsWith("slide:")) {
                                 var48 = 5;
                                 var51 = var51.substring("slide:".length());
                              }
                           }

                           PacketNode var56 = DecorativeObject.method3115(ClientPacket.field2253, Client.field739.field1250);
                           var56.packetBuffer.putByte(0);
                           var20 = var56.packetBuffer.offset;
                           var56.packetBuffer.putByte(var24);
                           var56.packetBuffer.putByte(var55);
                           var56.packetBuffer.putByte(var48);
                           PacketBuffer var36 = var56.packetBuffer;
                           int var12 = var36.offset;
                           byte[] var13 = class148.method3203(var51);
                           var36.putShortSmart(var13.length);
                           var36.offset += class300.huffman.compress(var13, 0, var13.length, var36.payload, var36.offset);
                           var56.packetBuffer.method3565(var56.packetBuffer.offset - var20);
                           Client.field739.method2019(var56);
                           var3 = 1;
                        } else if(var0 == 5009) {
                           class83.scriptStringStackSize -= 2;
                           var51 = class69.scriptStringStack[class83.scriptStringStackSize];
                           var39 = class69.scriptStringStack[class83.scriptStringStackSize + 1];
                           var49 = DecorativeObject.method3115(ClientPacket.field2197, Client.field739.field1250);
                           var49.packetBuffer.putShort(0);
                           var46 = var49.packetBuffer.offset;
                           var49.packetBuffer.putString(var51);
                           PacketBuffer var29 = var49.packetBuffer;
                           var9 = var29.offset;
                           byte[] var35 = class148.method3203(var39);
                           var29.putShortSmart(var35.length);
                           var29.offset += class300.huffman.compress(var35, 0, var35.length, var29.payload, var29.offset);
                           var49.packetBuffer.method3734(var49.packetBuffer.offset - var46);
                           Client.field739.method2019(var49);
                           var3 = 1;
                        } else if(var0 == 5015) {
                           if(MilliTimer.localPlayer != null && MilliTimer.localPlayer.name != null) {
                              var51 = MilliTimer.localPlayer.name.getName();
                           } else {
                              var51 = "";
                           }

                           class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var51;
                           var3 = 1;
                        } else if(var0 == 5016) {
                           class69.intStack[++class45.intStackSize - 1] = Client.field694;
                           var3 = 1;
                        } else if(var0 == 5017) {
                           var4 = class69.intStack[--class45.intStackSize];
                           class69.intStack[++class45.intStackSize - 1] = SceneTilePaint.method2895(var4);
                           var3 = 1;
                        } else if(var0 == 5018) {
                           var4 = class69.intStack[--class45.intStackSize];
                           class69.intStack[++class45.intStackSize - 1] = class15.method157(var4);
                           var3 = 1;
                        } else if(var0 == 5019) {
                           var4 = class69.intStack[--class45.intStackSize];
                           class69.intStack[++class45.intStackSize - 1] = Projectile.method1900(var4);
                           var3 = 1;
                        } else if(var0 == 5020) {
                           var51 = class69.scriptStringStack[--class83.scriptStringStackSize];
                           class151.method3234(var51);
                           var3 = 1;
                        } else if(var0 == 5021) {
                           Client.field808 = class69.scriptStringStack[--class83.scriptStringStackSize].toLowerCase().trim();
                           var3 = 1;
                        } else if(var0 == 5022) {
                           class69.scriptStringStack[++class83.scriptStringStackSize - 1] = Client.field808;
                           var3 = 1;
                        } else {
                           var3 = 2;
                        }
                     }

                     return var3;
                  } else if(var0 < 5400) {
                     if(var0 == 5306) {
                        int[] var44 = class69.intStack;
                        var24 = ++class45.intStackSize - 1;
                        var6 = Client.isResized?2:1;
                        var44[var24] = var6;
                        var3 = 1;
                     } else if(var0 == 5307) {
                        var4 = class69.intStack[--class45.intStackSize];
                        if(var4 == 1 || var4 == 2) {
                           Client.field803 = 0L;
                           if(var4 >= 2) {
                              Client.isResized = true;
                           } else {
                              Client.isResized = false;
                           }

                           var24 = Client.isResized?2:1;
                           if(var24 == 1) {
                              class37.clientInstance.method896(765, 503);
                           } else {
                              class37.clientInstance.method896(7680, 2160);
                           }

                           if(Client.gameState >= 25) {
                              var49 = DecorativeObject.method3115(ClientPacket.field2206, Client.field739.field1250);
                              PacketBuffer var26 = var49.packetBuffer;
                              var17 = Client.isResized?2:1;
                              var26.putByte(var17);
                              var49.packetBuffer.putShort(class9.canvasWidth);
                              var49.packetBuffer.putShort(class37.canvasHeight);
                              Client.field739.method2019(var49);
                           }
                        }

                        var3 = 1;
                     } else if(var0 == 5308) {
                        class69.intStack[++class45.intStackSize - 1] = ScriptState.preferences.screenType;
                        var3 = 1;
                     } else if(var0 == 5309) {
                        var4 = class69.intStack[--class45.intStackSize];
                        if(var4 == 1 || var4 == 2) {
                           ScriptState.preferences.screenType = var4;
                           Enum.method5008();
                        }

                        var3 = 1;
                     } else {
                        var3 = 2;
                     }

                     return var3;
                  } else if(var0 < 5600) {
                     if(var0 == 5504) {
                        class45.intStackSize -= 2;
                        var46 = class69.intStack[class45.intStackSize];
                        var17 = class69.intStack[class45.intStackSize + 1];
                        if(!Client.field746) {
                           Client.cameraPitchTarget = var46;
                           Client.mapAngle = var17;
                        }

                        var3 = 1;
                     } else if(var0 == 5505) {
                        class69.intStack[++class45.intStackSize - 1] = Client.cameraPitchTarget;
                        var3 = 1;
                     } else if(var0 == 5506) {
                        class69.intStack[++class45.intStackSize - 1] = Client.mapAngle;
                        var3 = 1;
                     } else if(var0 == 5530) {
                        var46 = class69.intStack[--class45.intStackSize];
                        if(var46 < 0) {
                           var46 = 0;
                        }

                        Client.field668 = var46;
                        var3 = 1;
                     } else if(var0 == 5531) {
                        class69.intStack[++class45.intStackSize - 1] = Client.field668;
                        var3 = 1;
                     } else {
                        var3 = 2;
                     }

                     return var3;
                  } else if(var0 < 5700) {
                     if(var0 == 5630) {
                        Client.field688 = 250;
                        var3 = 1;
                     } else {
                        var3 = 2;
                     }

                     return var3;
                  } else if(var0 < 6300) {
                     if(var0 == 6200) {
                        class45.intStackSize -= 2;
                        Client.field745 = (short)class69.intStack[class45.intStackSize];
                        if(Client.field745 <= 0) {
                           Client.field745 = 256;
                        }

                        Client.field841 = (short)class69.intStack[class45.intStackSize + 1];
                        if(Client.field841 <= 0) {
                           Client.field841 = 205;
                        }

                        var3 = 1;
                     } else if(var0 == 6201) {
                        class45.intStackSize -= 2;
                        Client.field842 = (short)class69.intStack[class45.intStackSize];
                        if(Client.field842 <= 0) {
                           Client.field842 = 256;
                        }

                        Client.field615 = (short)class69.intStack[class45.intStackSize + 1];
                        if(Client.field615 <= 0) {
                           Client.field615 = 320;
                        }

                        var3 = 1;
                     } else if(var0 == 6202) {
                        class45.intStackSize -= 4;
                        Client.field844 = (short)class69.intStack[class45.intStackSize];
                        if(Client.field844 <= 0) {
                           Client.field844 = 1;
                        }

                        Client.field863 = (short)class69.intStack[class45.intStackSize + 1];
                        if(Client.field863 <= 0) {
                           Client.field863 = 32767;
                        } else if(Client.field863 < Client.field844) {
                           Client.field863 = Client.field844;
                        }

                        Client.field707 = (short)class69.intStack[class45.intStackSize + 2];
                        if(Client.field707 <= 0) {
                           Client.field707 = 1;
                        }

                        Client.field847 = (short)class69.intStack[class45.intStackSize + 3];
                        if(Client.field847 <= 0) {
                           Client.field847 = 32767;
                        } else if(Client.field847 < Client.field707) {
                           Client.field847 = Client.field707;
                        }

                        var3 = 1;
                     } else if(var0 == 6203) {
                        if(Client.field776 != null) {
                           Occluder.method3113(0, 0, Client.field776.width, Client.field776.height, false);
                           class69.intStack[++class45.intStackSize - 1] = Client.viewportWidth;
                           class69.intStack[++class45.intStackSize - 1] = Client.viewportHeight;
                        } else {
                           class69.intStack[++class45.intStackSize - 1] = -1;
                           class69.intStack[++class45.intStackSize - 1] = -1;
                        }

                        var3 = 1;
                     } else if(var0 == 6204) {
                        class69.intStack[++class45.intStackSize - 1] = Client.field842;
                        class69.intStack[++class45.intStackSize - 1] = Client.field615;
                        var3 = 1;
                     } else if(var0 == 6205) {
                        class69.intStack[++class45.intStackSize - 1] = Client.field745;
                        class69.intStack[++class45.intStackSize - 1] = Client.field841;
                        var3 = 1;
                     } else {
                        var3 = 2;
                     }

                     return var3;
                  } else if(var0 >= 6600) {
                     if(var0 < 6700) {
                        if(var0 == 6600) {
                           var4 = class192.plane;
                           var24 = (MilliTimer.localPlayer.x >> 7) + class178.baseX;
                           var6 = (MilliTimer.localPlayer.y >> 7) + CombatInfoListHolder.baseY;
                           CombatInfoListHolder.method1821().method6222(var4, var24, var6, true);
                           var3 = 1;
                        } else {
                           WorldMapData var40;
                           if(var0 == 6601) {
                              var4 = class69.intStack[--class45.intStackSize];
                              var39 = "";
                              var40 = CombatInfoListHolder.method1821().getWorldMapDataByFileId(var4);
                              if(var40 != null) {
                                 var39 = var40.getName();
                              }

                              class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var39;
                              var3 = 1;
                           } else if(var0 == 6602) {
                              var4 = class69.intStack[--class45.intStackSize];
                              CombatInfoListHolder.method1821().method6244(var4);
                              var3 = 1;
                           } else if(var0 == 6603) {
                              class69.intStack[++class45.intStackSize - 1] = CombatInfoListHolder.method1821().method6073();
                              var3 = 1;
                           } else if(var0 == 6604) {
                              var4 = class69.intStack[--class45.intStackSize];
                              CombatInfoListHolder.method1821().method6191(var4);
                              var3 = 1;
                           } else if(var0 == 6605) {
                              class69.intStack[++class45.intStackSize - 1] = CombatInfoListHolder.method1821().method6075()?1:0;
                              var3 = 1;
                           } else {
                              Coordinates var38;
                              if(var0 == 6606) {
                                 var38 = new Coordinates(class69.intStack[--class45.intStackSize]);
                                 CombatInfoListHolder.method1821().setWorldMapPositionTarget(var38.worldX, var38.worldY);
                                 var3 = 1;
                              } else if(var0 == 6607) {
                                 var38 = new Coordinates(class69.intStack[--class45.intStackSize]);
                                 CombatInfoListHolder.method1821().method6070(var38.worldX, var38.worldY);
                                 var3 = 1;
                              } else if(var0 == 6608) {
                                 var38 = new Coordinates(class69.intStack[--class45.intStackSize]);
                                 CombatInfoListHolder.method1821().method6224(var38.plane, var38.worldX, var38.worldY);
                                 var3 = 1;
                              } else if(var0 == 6609) {
                                 var38 = new Coordinates(class69.intStack[--class45.intStackSize]);
                                 CombatInfoListHolder.method1821().method6080(var38.plane, var38.worldX, var38.worldY);
                                 var3 = 1;
                              } else if(var0 == 6610) {
                                 class69.intStack[++class45.intStackSize - 1] = CombatInfoListHolder.method1821().method6081();
                                 class69.intStack[++class45.intStackSize - 1] = CombatInfoListHolder.method1821().method6218();
                                 var3 = 1;
                              } else {
                                 WorldMapData var41;
                                 if(var0 == 6611) {
                                    var4 = class69.intStack[--class45.intStackSize];
                                    var41 = CombatInfoListHolder.method1821().getWorldMapDataByFileId(var4);
                                    if(var41 == null) {
                                       class69.intStack[++class45.intStackSize - 1] = 0;
                                    } else {
                                       class69.intStack[++class45.intStackSize - 1] = var41.method244().bitpack();
                                    }

                                    var3 = 1;
                                 } else if(var0 == 6612) {
                                    var4 = class69.intStack[--class45.intStackSize];
                                    var41 = CombatInfoListHolder.method1821().getWorldMapDataByFileId(var4);
                                    if(var41 == null) {
                                       class69.intStack[++class45.intStackSize - 1] = 0;
                                       class69.intStack[++class45.intStackSize - 1] = 0;
                                    } else {
                                       class69.intStack[++class45.intStackSize - 1] = (var41.method238() - var41.getMinX() + 1) * 64;
                                       class69.intStack[++class45.intStackSize - 1] = (var41.method270() - var41.getMinY() + 1) * 64;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 6613) {
                                    var4 = class69.intStack[--class45.intStackSize];
                                    var41 = CombatInfoListHolder.method1821().getWorldMapDataByFileId(var4);
                                    if(var41 == null) {
                                       class69.intStack[++class45.intStackSize - 1] = 0;
                                       class69.intStack[++class45.intStackSize - 1] = 0;
                                       class69.intStack[++class45.intStackSize - 1] = 0;
                                       class69.intStack[++class45.intStackSize - 1] = 0;
                                    } else {
                                       class69.intStack[++class45.intStackSize - 1] = var41.getMinX() * 64;
                                       class69.intStack[++class45.intStackSize - 1] = var41.getMinY() * 64;
                                       class69.intStack[++class45.intStackSize - 1] = var41.method238() * 64 + 64 - 1;
                                       class69.intStack[++class45.intStackSize - 1] = var41.method270() * 64 + 64 - 1;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 6614) {
                                    var4 = class69.intStack[--class45.intStackSize];
                                    var41 = CombatInfoListHolder.method1821().getWorldMapDataByFileId(var4);
                                    if(var41 == null) {
                                       class69.intStack[++class45.intStackSize - 1] = -1;
                                    } else {
                                       class69.intStack[++class45.intStackSize - 1] = var41.getInitialMapSurfaceZoom();
                                    }

                                    var3 = 1;
                                 } else if(var0 == 6615) {
                                    var38 = CombatInfoListHolder.method1821().method6083();
                                    if(var38 == null) {
                                       class69.intStack[++class45.intStackSize - 1] = -1;
                                       class69.intStack[++class45.intStackSize - 1] = -1;
                                    } else {
                                       class69.intStack[++class45.intStackSize - 1] = var38.worldX;
                                       class69.intStack[++class45.intStackSize - 1] = var38.worldY;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 6616) {
                                    class69.intStack[++class45.intStackSize - 1] = CombatInfoListHolder.method1821().method6060();
                                    var3 = 1;
                                 } else if(var0 == 6617) {
                                    var38 = new Coordinates(class69.intStack[--class45.intStackSize]);
                                    var41 = CombatInfoListHolder.method1821().method6061();
                                    if(var41 == null) {
                                       class69.intStack[++class45.intStackSize - 1] = -1;
                                       class69.intStack[++class45.intStackSize - 1] = -1;
                                       var3 = 1;
                                    } else {
                                       var43 = var41.method281(var38.plane, var38.worldX, var38.worldY);
                                       if(var43 == null) {
                                          class69.intStack[++class45.intStackSize - 1] = -1;
                                          class69.intStack[++class45.intStackSize - 1] = -1;
                                       } else {
                                          class69.intStack[++class45.intStackSize - 1] = var43[0];
                                          class69.intStack[++class45.intStackSize - 1] = var43[1];
                                       }

                                       var3 = 1;
                                    }
                                 } else {
                                    Coordinates var45;
                                    if(var0 == 6618) {
                                       var38 = new Coordinates(class69.intStack[--class45.intStackSize]);
                                       var41 = CombatInfoListHolder.method1821().method6061();
                                       if(var41 == null) {
                                          class69.intStack[++class45.intStackSize - 1] = -1;
                                          class69.intStack[++class45.intStackSize - 1] = -1;
                                          var3 = 1;
                                       } else {
                                          var45 = var41.method229(var38.worldX, var38.worldY);
                                          if(var45 == null) {
                                             class69.intStack[++class45.intStackSize - 1] = -1;
                                          } else {
                                             class69.intStack[++class45.intStackSize - 1] = var45.bitpack();
                                          }

                                          var3 = 1;
                                       }
                                    } else {
                                       Coordinates var52;
                                       if(var0 == 6619) {
                                          class45.intStackSize -= 2;
                                          var4 = class69.intStack[class45.intStackSize];
                                          var52 = new Coordinates(class69.intStack[class45.intStackSize + 1]);
                                          class32.method601(var4, var52, false);
                                          var3 = 1;
                                       } else if(var0 == 6620) {
                                          class45.intStackSize -= 2;
                                          var4 = class69.intStack[class45.intStackSize];
                                          var52 = new Coordinates(class69.intStack[class45.intStackSize + 1]);
                                          class32.method601(var4, var52, true);
                                          var3 = 1;
                                       } else if(var0 == 6621) {
                                          class45.intStackSize -= 2;
                                          var4 = class69.intStack[class45.intStackSize];
                                          var52 = new Coordinates(class69.intStack[class45.intStackSize + 1]);
                                          var40 = CombatInfoListHolder.method1821().getWorldMapDataByFileId(var4);
                                          if(var40 == null) {
                                             class69.intStack[++class45.intStackSize - 1] = 0;
                                             var3 = 1;
                                          } else {
                                             class69.intStack[++class45.intStackSize - 1] = var40.containsCoord(var52.plane, var52.worldX, var52.worldY)?1:0;
                                             var3 = 1;
                                          }
                                       } else if(var0 == 6622) {
                                          class69.intStack[++class45.intStackSize - 1] = CombatInfoListHolder.method1821().method6084();
                                          class69.intStack[++class45.intStackSize - 1] = CombatInfoListHolder.method1821().method6085();
                                          var3 = 1;
                                       } else if(var0 == 6623) {
                                          var38 = new Coordinates(class69.intStack[--class45.intStackSize]);
                                          var41 = CombatInfoListHolder.method1821().getWorldMapDataContainingCoord(var38.plane, var38.worldX, var38.worldY);
                                          if(var41 == null) {
                                             class69.intStack[++class45.intStackSize - 1] = -1;
                                          } else {
                                             class69.intStack[++class45.intStackSize - 1] = var41.getFileId();
                                          }

                                          var3 = 1;
                                       } else if(var0 == 6624) {
                                          CombatInfoListHolder.method1821().method6086(class69.intStack[--class45.intStackSize]);
                                          var3 = 1;
                                       } else if(var0 == 6625) {
                                          CombatInfoListHolder.method1821().method6087();
                                          var3 = 1;
                                       } else if(var0 == 6626) {
                                          CombatInfoListHolder.method1821().method6088(class69.intStack[--class45.intStackSize]);
                                          var3 = 1;
                                       } else if(var0 == 6627) {
                                          CombatInfoListHolder.method1821().method6203();
                                          var3 = 1;
                                       } else if(var0 == 6628) {
                                          var34 = class69.intStack[--class45.intStackSize] == 1;
                                          CombatInfoListHolder.method1821().method6058(var34);
                                          var3 = 1;
                                       } else if(var0 == 6629) {
                                          var4 = class69.intStack[--class45.intStackSize];
                                          CombatInfoListHolder.method1821().method6091(var4);
                                          var3 = 1;
                                       } else if(var0 == 6630) {
                                          var4 = class69.intStack[--class45.intStackSize];
                                          CombatInfoListHolder.method1821().method6090(var4);
                                          var3 = 1;
                                       } else if(var0 == 6631) {
                                          CombatInfoListHolder.method1821().method6093();
                                          var3 = 1;
                                       } else if(var0 == 6632) {
                                          var34 = class69.intStack[--class45.intStackSize] == 1;
                                          CombatInfoListHolder.method1821().method6094(var34);
                                          var3 = 1;
                                       } else if(var0 == 6633) {
                                          class45.intStackSize -= 2;
                                          var4 = class69.intStack[class45.intStackSize];
                                          var5 = class69.intStack[class45.intStackSize + 1] == 1;
                                          CombatInfoListHolder.method1821().method6095(var4, var5);
                                          var3 = 1;
                                       } else if(var0 == 6634) {
                                          class45.intStackSize -= 2;
                                          var4 = class69.intStack[class45.intStackSize];
                                          var5 = class69.intStack[class45.intStackSize + 1] == 1;
                                          CombatInfoListHolder.method1821().method6082(var4, var5);
                                          var3 = 1;
                                       } else if(var0 == 6635) {
                                          class69.intStack[++class45.intStackSize - 1] = CombatInfoListHolder.method1821().method6097()?1:0;
                                          var3 = 1;
                                       } else if(var0 == 6636) {
                                          var4 = class69.intStack[--class45.intStackSize];
                                          class69.intStack[++class45.intStackSize - 1] = CombatInfoListHolder.method1821().method6098(var4)?1:0;
                                          var3 = 1;
                                       } else if(var0 == 6637) {
                                          var4 = class69.intStack[--class45.intStackSize];
                                          class69.intStack[++class45.intStackSize - 1] = CombatInfoListHolder.method1821().method6059(var4)?1:0;
                                          var3 = 1;
                                       } else if(var0 == 6638) {
                                          class45.intStackSize -= 2;
                                          var4 = class69.intStack[class45.intStackSize];
                                          var52 = new Coordinates(class69.intStack[class45.intStackSize + 1]);
                                          var45 = CombatInfoListHolder.method1821().method6105(var4, var52);
                                          if(var45 == null) {
                                             class69.intStack[++class45.intStackSize - 1] = -1;
                                          } else {
                                             class69.intStack[++class45.intStackSize - 1] = var45.bitpack();
                                          }

                                          var3 = 1;
                                       } else {
                                          MapIcon var42;
                                          if(var0 == 6639) {
                                             var42 = CombatInfoListHolder.method1821().method6067();
                                             if(var42 == null) {
                                                class69.intStack[++class45.intStackSize - 1] = -1;
                                                class69.intStack[++class45.intStackSize - 1] = -1;
                                             } else {
                                                class69.intStack[++class45.intStackSize - 1] = var42.areaId;
                                                class69.intStack[++class45.intStackSize - 1] = var42.field247.bitpack();
                                             }

                                             var3 = 1;
                                          } else if(var0 == 6640) {
                                             var42 = CombatInfoListHolder.method1821().method6245();
                                             if(var42 == null) {
                                                class69.intStack[++class45.intStackSize - 1] = -1;
                                                class69.intStack[++class45.intStackSize - 1] = -1;
                                             } else {
                                                class69.intStack[++class45.intStackSize - 1] = var42.areaId;
                                                class69.intStack[++class45.intStackSize - 1] = var42.field247.bitpack();
                                             }

                                             var3 = 1;
                                          } else {
                                             Area var57;
                                             if(var0 == 6693) {
                                                var4 = class69.intStack[--class45.intStackSize];
                                                var57 = Area.mapAreaType[var4];
                                                if(var57.name == null) {
                                                   class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                                                } else {
                                                   class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var57.name;
                                                }

                                                var3 = 1;
                                             } else if(var0 == 6694) {
                                                var4 = class69.intStack[--class45.intStackSize];
                                                var57 = Area.mapAreaType[var4];
                                                class69.intStack[++class45.intStackSize - 1] = var57.field3276;
                                                var3 = 1;
                                             } else if(var0 == 6695) {
                                                var4 = class69.intStack[--class45.intStackSize];
                                                var57 = Area.mapAreaType[var4];
                                                if(var57 == null) {
                                                   class69.intStack[++class45.intStackSize - 1] = -1;
                                                } else {
                                                   class69.intStack[++class45.intStackSize - 1] = var57.field3277;
                                                }

                                                var3 = 1;
                                             } else if(var0 == 6696) {
                                                var4 = class69.intStack[--class45.intStackSize];
                                                var57 = Area.mapAreaType[var4];
                                                if(var57 == null) {
                                                   class69.intStack[++class45.intStackSize - 1] = -1;
                                                } else {
                                                   class69.intStack[++class45.intStackSize - 1] = var57.spriteId;
                                                }

                                                var3 = 1;
                                             } else if(var0 == 6697) {
                                                class69.intStack[++class45.intStackSize - 1] = class173.scriptMapIconReference.areaId;
                                                var3 = 1;
                                             } else if(var0 == 6698) {
                                                class69.intStack[++class45.intStackSize - 1] = class173.scriptMapIconReference.field308.bitpack();
                                                var3 = 1;
                                             } else if(var0 == 6699) {
                                                class69.intStack[++class45.intStackSize - 1] = class173.scriptMapIconReference.field309.bitpack();
                                                var3 = 1;
                                             } else {
                                                var3 = 2;
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }

                        return var3;
                     } else {
                        return 2;
                     }
                  } else {
                     if(var0 == 6500) {
                        class69.intStack[++class45.intStackSize - 1] = IndexStoreActionHandler.loadWorlds()?1:0;
                        var3 = 1;
                     } else {
                        World var14;
                        if(var0 == 6501) {
                           var14 = class294.method5520();
                           if(var14 != null) {
                              class69.intStack[++class45.intStackSize - 1] = var14.id;
                              class69.intStack[++class45.intStackSize - 1] = var14.mask;
                              class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var14.activity;
                              class69.intStack[++class45.intStackSize - 1] = var14.location;
                              class69.intStack[++class45.intStackSize - 1] = var14.playerCount;
                              class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var14.address;
                           } else {
                              class69.intStack[++class45.intStackSize - 1] = -1;
                              class69.intStack[++class45.intStackSize - 1] = 0;
                              class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                              class69.intStack[++class45.intStackSize - 1] = 0;
                              class69.intStack[++class45.intStackSize - 1] = 0;
                              class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                           }

                           var3 = 1;
                        } else if(var0 == 6502) {
                           var14 = GroundObject.method2704();
                           if(var14 != null) {
                              class69.intStack[++class45.intStackSize - 1] = var14.id;
                              class69.intStack[++class45.intStackSize - 1] = var14.mask;
                              class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var14.activity;
                              class69.intStack[++class45.intStackSize - 1] = var14.location;
                              class69.intStack[++class45.intStackSize - 1] = var14.playerCount;
                              class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var14.address;
                           } else {
                              class69.intStack[++class45.intStackSize - 1] = -1;
                              class69.intStack[++class45.intStackSize - 1] = 0;
                              class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                              class69.intStack[++class45.intStackSize - 1] = 0;
                              class69.intStack[++class45.intStackSize - 1] = 0;
                              class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                           }

                           var3 = 1;
                        } else {
                           World var15;
                           if(var0 == 6506) {
                              var4 = class69.intStack[--class45.intStackSize];
                              var15 = null;

                              for(var6 = 0; var6 < World.worldCount; ++var6) {
                                 if(var4 == class143.worldList[var6].id) {
                                    var15 = class143.worldList[var6];
                                    break;
                                 }
                              }

                              if(var15 != null) {
                                 class69.intStack[++class45.intStackSize - 1] = var15.id;
                                 class69.intStack[++class45.intStackSize - 1] = var15.mask;
                                 class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var15.activity;
                                 class69.intStack[++class45.intStackSize - 1] = var15.location;
                                 class69.intStack[++class45.intStackSize - 1] = var15.playerCount;
                                 class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var15.address;
                              } else {
                                 class69.intStack[++class45.intStackSize - 1] = -1;
                                 class69.intStack[++class45.intStackSize - 1] = 0;
                                 class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                                 class69.intStack[++class45.intStackSize - 1] = 0;
                                 class69.intStack[++class45.intStackSize - 1] = 0;
                                 class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 6507) {
                              class45.intStackSize -= 4;
                              var4 = class69.intStack[class45.intStackSize];
                              var5 = class69.intStack[class45.intStackSize + 1] == 1;
                              var6 = class69.intStack[class45.intStackSize + 2];
                              boolean var18 = class69.intStack[class45.intStackSize + 3] == 1;
                              class138.method3160(var4, var5, var6, var18);
                              var3 = 1;
                           } else if(var0 == 6511) {
                              var4 = class69.intStack[--class45.intStackSize];
                              if(var4 >= 0 && var4 < World.worldCount) {
                                 var15 = class143.worldList[var4];
                                 class69.intStack[++class45.intStackSize - 1] = var15.id;
                                 class69.intStack[++class45.intStackSize - 1] = var15.mask;
                                 class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var15.activity;
                                 class69.intStack[++class45.intStackSize - 1] = var15.location;
                                 class69.intStack[++class45.intStackSize - 1] = var15.playerCount;
                                 class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var15.address;
                              } else {
                                 class69.intStack[++class45.intStackSize - 1] = -1;
                                 class69.intStack[++class45.intStackSize - 1] = 0;
                                 class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                                 class69.intStack[++class45.intStackSize - 1] = 0;
                                 class69.intStack[++class45.intStackSize - 1] = 0;
                                 class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 6512) {
                              Client.field753 = class69.intStack[--class45.intStackSize] == 1;
                              var3 = 1;
                           } else {
                              class264 var16;
                              if(var0 == 6513) {
                                 class45.intStackSize -= 2;
                                 var4 = class69.intStack[class45.intStackSize];
                                 var24 = class69.intStack[class45.intStackSize + 1];
                                 var16 = Buffer.method3811(var24);
                                 if(var16.method4956()) {
                                    class69.scriptStringStack[++class83.scriptStringStackSize - 1] = class59.getNpcDefinition(var4).method5175(var24, var16.field3347);
                                 } else {
                                    class69.intStack[++class45.intStackSize - 1] = class59.getNpcDefinition(var4).method5196(var24, var16.field3348);
                                 }

                                 var3 = 1;
                              } else if(var0 == 6514) {
                                 class45.intStackSize -= 2;
                                 var4 = class69.intStack[class45.intStackSize];
                                 var24 = class69.intStack[class45.intStackSize + 1];
                                 var16 = Buffer.method3811(var24);
                                 if(var16.method4956()) {
                                    class69.scriptStringStack[++class83.scriptStringStackSize - 1] = SoundTaskDataProvider.getObjectDefinition(var4).method5057(var24, var16.field3347);
                                 } else {
                                    class69.intStack[++class45.intStackSize - 1] = SoundTaskDataProvider.getObjectDefinition(var4).method5078(var24, var16.field3348);
                                 }

                                 var3 = 1;
                              } else if(var0 == 6515) {
                                 class45.intStackSize -= 2;
                                 var4 = class69.intStack[class45.intStackSize];
                                 var24 = class69.intStack[class45.intStackSize + 1];
                                 var16 = Buffer.method3811(var24);
                                 if(var16.method4956()) {
                                    class69.scriptStringStack[++class83.scriptStringStackSize - 1] = class120.getItemDefinition(var4).method5111(var24, var16.field3347);
                                 } else {
                                    class69.intStack[++class45.intStackSize - 1] = class120.getItemDefinition(var4).method5103(var24, var16.field3348);
                                 }

                                 var3 = 1;
                              } else if(var0 == 6516) {
                                 class45.intStackSize -= 2;
                                 var4 = class69.intStack[class45.intStackSize];
                                 var24 = class69.intStack[class45.intStackSize + 1];
                                 var16 = Buffer.method3811(var24);
                                 class265 var10;
                                 byte[] var11;
                                 class265 var19;
                                 if(var16.method4956()) {
                                    String[] var7 = class69.scriptStringStack;
                                    var17 = ++class83.scriptStringStackSize - 1;
                                    var10 = (class265)class265.field3352.get((long)var4);
                                    if(var10 != null) {
                                       var19 = var10;
                                    } else {
                                       var11 = class265.field3351.getConfigData(34, var4);
                                       var10 = new class265();
                                       if(var11 != null) {
                                          var10.method4990(new Buffer(var11));
                                       }

                                       var10.method4976();
                                       class265.field3352.put(var10, (long)var4);
                                       var19 = var10;
                                    }

                                    var7[var17] = var19.method4980(var24, var16.field3347);
                                 } else {
                                    int[] var25 = class69.intStack;
                                    var17 = ++class45.intStackSize - 1;
                                    var10 = (class265)class265.field3352.get((long)var4);
                                    if(var10 != null) {
                                       var19 = var10;
                                    } else {
                                       var11 = class265.field3351.getConfigData(34, var4);
                                       var10 = new class265();
                                       if(var11 != null) {
                                          var10.method4990(new Buffer(var11));
                                       }

                                       var10.method4976();
                                       class265.field3352.put(var10, (long)var4);
                                       var19 = var10;
                                    }

                                    var25[var17] = var19.method4982(var24, var16.field3348);
                                 }

                                 var3 = 1;
                              } else if(var0 == 6518) {
                                 class69.intStack[++class45.intStackSize - 1] = Client.field601?1:0;
                                 var3 = 1;
                              } else if(var0 == 6520) {
                                 var3 = 1;
                              } else if(var0 == 6521) {
                                 var3 = 1;
                              } else if(var0 == 6522) {
                                 --class83.scriptStringStackSize;
                                 --class45.intStackSize;
                                 var3 = 1;
                              } else if(var0 == 6523) {
                                 --class83.scriptStringStackSize;
                                 --class45.intStackSize;
                                 var3 = 1;
                              } else {
                                 var3 = 2;
                              }
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
