import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class35 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 928263917
   )
   final int field489;
   @ObfuscatedName("h")
   static final class35 field490;
   @ObfuscatedName("i")
   static final class35 field491;

   static {
      field491 = new class35(0);
      field490 = new class35(1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1280932994"
   )
   static int method494(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 6600) {
         var3 = Sequence.plane;
         int var9 = class166.baseX + (XGrandExchangeOffer.localPlayer.x >> 7);
         int var5 = class146.baseY + (XGrandExchangeOffer.localPlayer.y >> 7);
         MessageNode.method1130().method5262(var3, var9, var5, true);
         return 1;
      } else {
         class32 var11;
         if(var0 == 6601) {
            var3 = class83.intStack[--class83.intStackSize];
            String var16 = "";
            var11 = MessageNode.method1130().method5292(var3);
            if(var11 != null) {
               var16 = var11.method350();
            }

            class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var16;
            return 1;
         } else if(var0 == 6602) {
            var3 = class83.intStack[--class83.intStackSize];
            MessageNode.method1130().method5361(var3);
            return 1;
         } else if(var0 == 6603) {
            class83.intStack[++class83.intStackSize - 1] = MessageNode.method1130().method5376();
            return 1;
         } else if(var0 == 6604) {
            var3 = class83.intStack[--class83.intStackSize];
            MessageNode.method1130().method5271(var3);
            return 1;
         } else if(var0 == 6605) {
            class83.intStack[++class83.intStackSize - 1] = MessageNode.method1130().method5276()?1:0;
            return 1;
         } else {
            class212 var15;
            if(var0 == 6606) {
               var15 = new class212(class83.intStack[--class83.intStackSize]);
               MessageNode.method1130().method5278(var15.field2600, var15.field2601);
               return 1;
            } else if(var0 == 6607) {
               var15 = new class212(class83.intStack[--class83.intStackSize]);
               MessageNode.method1130().method5279(var15.field2600, var15.field2601);
               return 1;
            } else if(var0 == 6608) {
               var15 = new class212(class83.intStack[--class83.intStackSize]);
               MessageNode.method1130().method5280(var15.field2603, var15.field2600, var15.field2601);
               return 1;
            } else if(var0 == 6609) {
               var15 = new class212(class83.intStack[--class83.intStackSize]);
               MessageNode.method1130().method5281(var15.field2603, var15.field2600, var15.field2601);
               return 1;
            } else if(var0 == 6610) {
               class83.intStack[++class83.intStackSize - 1] = MessageNode.method1130().method5363();
               class83.intStack[++class83.intStackSize - 1] = MessageNode.method1130().method5254();
               return 1;
            } else {
               class32 var13;
               if(var0 == 6611) {
                  var3 = class83.intStack[--class83.intStackSize];
                  var13 = MessageNode.method1130().method5292(var3);
                  if(var13 == null) {
                     class83.intStack[++class83.intStackSize - 1] = 0;
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = var13.method291().method3991();
                  }

                  return 1;
               } else if(var0 == 6612) {
                  var3 = class83.intStack[--class83.intStackSize];
                  var13 = MessageNode.method1130().method5292(var3);
                  if(var13 == null) {
                     class83.intStack[++class83.intStackSize - 1] = 0;
                     class83.intStack[++class83.intStackSize - 1] = 0;
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = (var13.method285() - var13.method337() + 1) * 64;
                     class83.intStack[++class83.intStackSize - 1] = (var13.method287() - var13.method286() + 1) * 64;
                  }

                  return 1;
               } else if(var0 == 6613) {
                  var3 = class83.intStack[--class83.intStackSize];
                  var13 = MessageNode.method1130().method5292(var3);
                  if(var13 == null) {
                     class83.intStack[++class83.intStackSize - 1] = 0;
                     class83.intStack[++class83.intStackSize - 1] = 0;
                     class83.intStack[++class83.intStackSize - 1] = 0;
                     class83.intStack[++class83.intStackSize - 1] = 0;
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = var13.method337() * 64;
                     class83.intStack[++class83.intStackSize - 1] = var13.method286() * 64;
                     class83.intStack[++class83.intStackSize - 1] = var13.method285() * 64 + 64 - 1;
                     class83.intStack[++class83.intStackSize - 1] = var13.method287() * 64 + 64 - 1;
                  }

                  return 1;
               } else if(var0 == 6614) {
                  var3 = class83.intStack[--class83.intStackSize];
                  var13 = MessageNode.method1130().method5292(var3);
                  if(var13 == null) {
                     class83.intStack[++class83.intStackSize - 1] = -1;
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = var13.method283();
                  }

                  return 1;
               } else if(var0 == 6615) {
                  var15 = MessageNode.method1130().method5284();
                  if(var15 == null) {
                     class83.intStack[++class83.intStackSize - 1] = -1;
                     class83.intStack[++class83.intStackSize - 1] = -1;
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = var15.field2600;
                     class83.intStack[++class83.intStackSize - 1] = var15.field2601;
                  }

                  return 1;
               } else if(var0 == 6616) {
                  class83.intStack[++class83.intStackSize - 1] = MessageNode.method1130().method5427();
                  return 1;
               } else if(var0 == 6617) {
                  var15 = new class212(class83.intStack[--class83.intStackSize]);
                  var13 = MessageNode.method1130().method5265();
                  if(var13 == null) {
                     class83.intStack[++class83.intStackSize - 1] = -1;
                     class83.intStack[++class83.intStackSize - 1] = -1;
                     return 1;
                  } else {
                     int[] var14 = var13.method280(var15.field2603, var15.field2600, var15.field2601);
                     if(var14 == null) {
                        class83.intStack[++class83.intStackSize - 1] = -1;
                        class83.intStack[++class83.intStackSize - 1] = -1;
                     } else {
                        class83.intStack[++class83.intStackSize - 1] = var14[0];
                        class83.intStack[++class83.intStackSize - 1] = var14[1];
                     }

                     return 1;
                  }
               } else {
                  class212 var7;
                  if(var0 == 6618) {
                     var15 = new class212(class83.intStack[--class83.intStackSize]);
                     var13 = MessageNode.method1130().method5265();
                     if(var13 == null) {
                        class83.intStack[++class83.intStackSize - 1] = -1;
                        class83.intStack[++class83.intStackSize - 1] = -1;
                        return 1;
                     } else {
                        var7 = var13.method341(var15.field2600, var15.field2601);
                        if(var7 == null) {
                           class83.intStack[++class83.intStackSize - 1] = -1;
                        } else {
                           class83.intStack[++class83.intStackSize - 1] = var7.method3991();
                        }

                        return 1;
                     }
                  } else {
                     class212 var12;
                     if(var0 == 6619) {
                        class83.intStackSize -= 2;
                        var3 = class83.intStack[class83.intStackSize];
                        var12 = new class212(class83.intStack[class83.intStackSize + 1]);
                        class14.method81(var3, var12, false);
                        return 1;
                     } else if(var0 == 6620) {
                        class83.intStackSize -= 2;
                        var3 = class83.intStack[class83.intStackSize];
                        var12 = new class212(class83.intStack[class83.intStackSize + 1]);
                        class14.method81(var3, var12, true);
                        return 1;
                     } else if(var0 == 6621) {
                        class83.intStackSize -= 2;
                        var3 = class83.intStack[class83.intStackSize];
                        var12 = new class212(class83.intStack[class83.intStackSize + 1]);
                        var11 = MessageNode.method1130().method5292(var3);
                        if(var11 == null) {
                           class83.intStack[++class83.intStackSize - 1] = 0;
                           return 1;
                        } else {
                           class83.intStack[++class83.intStackSize - 1] = var11.method270(var12.field2603, var12.field2600, var12.field2601)?1:0;
                           return 1;
                        }
                     } else if(var0 == 6622) {
                        class83.intStack[++class83.intStackSize - 1] = MessageNode.method1130().method5285();
                        class83.intStack[++class83.intStackSize - 1] = MessageNode.method1130().method5286();
                        return 1;
                     } else if(var0 == 6623) {
                        var15 = new class212(class83.intStack[--class83.intStackSize]);
                        var13 = MessageNode.method1130().method5307(var15.field2603, var15.field2600, var15.field2601);
                        if(var13 == null) {
                           class83.intStack[++class83.intStackSize - 1] = -1;
                        } else {
                           class83.intStack[++class83.intStackSize - 1] = var13.method318();
                        }

                        return 1;
                     } else if(var0 == 6624) {
                        MessageNode.method1130().method5293(class83.intStack[--class83.intStackSize]);
                        return 1;
                     } else if(var0 == 6625) {
                        MessageNode.method1130().method5257();
                        return 1;
                     } else if(var0 == 6626) {
                        MessageNode.method1130().method5289(class83.intStack[--class83.intStackSize]);
                        return 1;
                     } else if(var0 == 6627) {
                        MessageNode.method1130().method5429();
                        return 1;
                     } else {
                        boolean var10;
                        if(var0 == 6628) {
                           var10 = class83.intStack[--class83.intStackSize] == 1;
                           MessageNode.method1130().method5291(var10);
                           return 1;
                        } else if(var0 == 6629) {
                           var3 = class83.intStack[--class83.intStackSize];
                           MessageNode.method1130().method5342(var3);
                           return 1;
                        } else if(var0 == 6630) {
                           var3 = class83.intStack[--class83.intStackSize];
                           MessageNode.method1130().method5282(var3);
                           return 1;
                        } else if(var0 == 6631) {
                           MessageNode.method1130().method5294();
                           return 1;
                        } else if(var0 == 6632) {
                           var10 = class83.intStack[--class83.intStackSize] == 1;
                           MessageNode.method1130().method5295(var10);
                           return 1;
                        } else {
                           boolean var4;
                           if(var0 == 6633) {
                              class83.intStackSize -= 2;
                              var3 = class83.intStack[class83.intStackSize];
                              var4 = class83.intStack[class83.intStackSize + 1] == 1;
                              MessageNode.method1130().method5296(var3, var4);
                              return 1;
                           } else if(var0 == 6634) {
                              class83.intStackSize -= 2;
                              var3 = class83.intStack[class83.intStackSize];
                              var4 = class83.intStack[class83.intStackSize + 1] == 1;
                              MessageNode.method1130().method5381(var3, var4);
                              return 1;
                           } else if(var0 == 6635) {
                              class83.intStack[++class83.intStackSize - 1] = MessageNode.method1130().method5298()?1:0;
                              return 1;
                           } else if(var0 == 6636) {
                              var3 = class83.intStack[--class83.intStackSize];
                              class83.intStack[++class83.intStackSize - 1] = MessageNode.method1130().method5299(var3)?1:0;
                              return 1;
                           } else if(var0 == 6637) {
                              var3 = class83.intStack[--class83.intStackSize];
                              class83.intStack[++class83.intStackSize - 1] = MessageNode.method1130().method5300(var3)?1:0;
                              return 1;
                           } else if(var0 == 6638) {
                              class83.intStackSize -= 2;
                              var3 = class83.intStack[class83.intStackSize];
                              var12 = new class212(class83.intStack[class83.intStackSize + 1]);
                              var7 = MessageNode.method1130().method5416(var3, var12);
                              if(var7 == null) {
                                 class83.intStack[++class83.intStackSize - 1] = -1;
                              } else {
                                 class83.intStack[++class83.intStackSize - 1] = var7.method3991();
                              }

                              return 1;
                           } else {
                              class39 var8;
                              if(var0 == 6639) {
                                 var8 = MessageNode.method1130().method5305();
                                 if(var8 == null) {
                                    class83.intStack[++class83.intStackSize - 1] = -1;
                                    class83.intStack[++class83.intStackSize - 1] = -1;
                                 } else {
                                    class83.intStack[++class83.intStackSize - 1] = var8.field526;
                                    class83.intStack[++class83.intStackSize - 1] = var8.field527.method3991();
                                 }

                                 return 1;
                              } else if(var0 == 6640) {
                                 var8 = MessageNode.method1130().method5306();
                                 if(var8 == null) {
                                    class83.intStack[++class83.intStackSize - 1] = -1;
                                    class83.intStack[++class83.intStackSize - 1] = -1;
                                 } else {
                                    class83.intStack[++class83.intStackSize - 1] = var8.field526;
                                    class83.intStack[++class83.intStackSize - 1] = var8.field527.method3991();
                                 }

                                 return 1;
                              } else {
                                 class242 var6;
                                 if(var0 == 6693) {
                                    var3 = class83.intStack[--class83.intStackSize];
                                    var6 = class242.field3276[var3];
                                    if(var6.field3282 == null) {
                                       class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                                    } else {
                                       class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var6.field3282;
                                    }

                                    return 1;
                                 } else if(var0 == 6694) {
                                    var3 = class83.intStack[--class83.intStackSize];
                                    var6 = class242.field3276[var3];
                                    class83.intStack[++class83.intStackSize - 1] = var6.field3284;
                                    return 1;
                                 } else if(var0 == 6695) {
                                    var3 = class83.intStack[--class83.intStackSize];
                                    var6 = class242.field3276[var3];
                                    if(var6 == null) {
                                       class83.intStack[++class83.intStackSize - 1] = -1;
                                    } else {
                                       class83.intStack[++class83.intStackSize - 1] = var6.field3296;
                                    }

                                    return 1;
                                 } else if(var0 == 6696) {
                                    var3 = class83.intStack[--class83.intStackSize];
                                    var6 = class242.field3276[var3];
                                    if(var6 == null) {
                                       class83.intStack[++class83.intStackSize - 1] = -1;
                                    } else {
                                       class83.intStack[++class83.intStackSize - 1] = var6.field3280;
                                    }

                                    return 1;
                                 } else if(var0 == 6697) {
                                    class83.intStack[++class83.intStackSize - 1] = Item.field1476.field598;
                                    return 1;
                                 } else if(var0 == 6698) {
                                    class83.intStack[++class83.intStackSize - 1] = Item.field1476.field597.method3991();
                                    return 1;
                                 } else if(var0 == 6699) {
                                    class83.intStack[++class83.intStackSize - 1] = Item.field1476.field596.method3991();
                                    return 1;
                                 } else {
                                    return 2;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class35(int var1) {
      this.field489 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1911450740"
   )
   static void method495(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(var0 != World.field1270[var5]) {
            var2[var4] = World.field1270[var5];
            var3[var4] = World.field1269[var5];
            ++var4;
         }
      }

      World.field1270 = var2;
      World.field1269 = var3;
      class238.method4327(World.worldList, 0, World.worldList.length - 1, World.field1270, World.field1269);
   }
}
