import java.util.Comparator;
import java.util.Date;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
final class class17 implements Comparator {
   @ObfuscatedName("ag")
   static java.awt.Font field308;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = -1082691711
   )
   static int field305;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lt;Lt;B)I",
      garbageValue = "66"
   )
   int method126(class14 var1, class14 var2) {
      return var1.field276.price < var2.field276.price?-1:(var2.field276.price == var1.field276.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method126((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "53922600"
   )
   public static int method125(int var0) {
      Varbit var1 = class155.method2895(var0);
      int var2 = var1.configId;
      int var3 = var1.leastSignificantBit;
      int var4 = var1.mostSignificantBit;
      int var5 = class211.field2576[var4 - var3];
      return class211.widgetSettings[var2] >> var3 & var5;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lby;II)V",
      garbageValue = "2139181328"
   )
   static void method123(ScriptEvent var0, int var1) {
      Object[] var2 = var0.field831;
      class219 var5 = var0.field830;
      boolean var4 = var5 == class219.field2762 || var5 == class219.field2760 || var5 == class219.field2761 || var5 == class219.field2766 || var5 == class219.field2763 || var5 == class219.field2770 || var5 == class219.field2765 || var5 == class219.field2773;
      Script var3;
      int var30;
      if(var4) {
         class47.field598 = (class47)var2[0];
         Area var6 = Area.field3265[class47.field598.field606];
         var3 = class82.method1562(var0.field830, var6.field3275, var6.field3281);
      } else {
         var30 = ((Integer)var2[0]).intValue();
         Script var8 = (Script)Script.field1506.get((long)var30);
         Script var7;
         if(var8 != null) {
            var7 = var8;
         } else {
            byte[] var51 = class13.indexScripts.getConfigData(var30, 0);
            if(var51 == null) {
               var7 = null;
            } else {
               var8 = Friend.method1037(var51);
               Script.field1506.put(var8, (long)var30);
               var7 = var8;
            }
         }

         var3 = var7;
      }

      if(var3 != null) {
         BufferProvider.intStackSize = 0;
         class83.scriptStringStackSize = 0;
         var30 = -1;
         int[] var55 = var3.instructions;
         int[] var56 = var3.intOperands;
         byte var9 = -1;
         class83.scriptStackCount = 0;

         int var12;
         try {
            class83.scriptLocalInts = new int[var3.localIntCount];
            int var10 = 0;
            class83.scriptLocalStrings = new String[var3.localStringCount];
            int var11 = 0;

            int var13;
            String var31;
            for(var12 = 1; var12 < var2.length; ++var12) {
               if(var2[var12] instanceof Integer) {
                  var13 = ((Integer)var2[var12]).intValue();
                  if(var13 == -2147483647) {
                     var13 = var0.field832;
                  }

                  if(var13 == -2147483646) {
                     var13 = var0.field833;
                  }

                  if(var13 == -2147483645) {
                     var13 = var0.widget != null?var0.widget.id:-1;
                  }

                  if(var13 == -2147483644) {
                     var13 = var0.field837;
                  }

                  if(var13 == -2147483643) {
                     var13 = var0.widget != null?var0.widget.index:-1;
                  }

                  if(var13 == -2147483642) {
                     var13 = var0.field835 != null?var0.field835.id:-1;
                  }

                  if(var13 == -2147483641) {
                     var13 = var0.field835 != null?var0.field835.index:-1;
                  }

                  if(var13 == -2147483640) {
                     var13 = var0.field836;
                  }

                  if(var13 == -2147483639) {
                     var13 = var0.field840;
                  }

                  class83.scriptLocalInts[var10++] = var13;
               } else if(var2[var12] instanceof String) {
                  var31 = (String)var2[var12];
                  if(var31.equals("event_opbase")) {
                     var31 = var0.field838;
                  }

                  class83.scriptLocalStrings[var11++] = var31;
               }
            }

            var12 = 0;
            class83.field1333 = var0.field839;

            while(true) {
               while(true) {
                  while(true) {
                     while(true) {
                        while(true) {
                           while(true) {
                              while(true) {
                                 while(true) {
                                    while(true) {
                                       while(true) {
                                          while(true) {
                                             while(true) {
                                                while(true) {
                                                   while(true) {
                                                      while(true) {
                                                         while(true) {
                                                            while(true) {
                                                               while(true) {
                                                                  while(true) {
                                                                     while(true) {
                                                                        while(true) {
                                                                           while(true) {
                                                                              while(true) {
                                                                                 while(true) {
                                                                                    while(true) {
                                                                                       label2325:
                                                                                       while(true) {
                                                                                          ++var12;
                                                                                          if(var12 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var30;
                                                                                          int var57 = var55[var30];
                                                                                          int var14;
                                                                                          int var18;
                                                                                          int var20;
                                                                                          int var34;
                                                                                          int var35;
                                                                                          int[] var86;
                                                                                          if(var57 < 100) {
                                                                                             if(var57 != 0) {
                                                                                                if(var57 != 1) {
                                                                                                   if(var57 != 2) {
                                                                                                      if(var57 != 3) {
                                                                                                         if(var57 != 6) {
                                                                                                            if(var57 != 7) {
                                                                                                               if(var57 != 8) {
                                                                                                                  if(var57 != 9) {
                                                                                                                     if(var57 != 10) {
                                                                                                                        if(var57 != 21) {
                                                                                                                           if(var57 != 25) {
                                                                                                                              if(var57 != 27) {
                                                                                                                                 if(var57 != 31) {
                                                                                                                                    if(var57 != 32) {
                                                                                                                                       if(var57 != 33) {
                                                                                                                                          if(var57 != 34) {
                                                                                                                                             if(var57 != 35) {
                                                                                                                                                if(var57 != 36) {
                                                                                                                                                   if(var57 != 37) {
                                                                                                                                                      if(var57 != 38) {
                                                                                                                                                         if(var57 != 39) {
                                                                                                                                                            if(var57 != 40) {
                                                                                                                                                               if(var57 != 42) {
                                                                                                                                                                  if(var57 != 43) {
                                                                                                                                                                     if(var57 == 44) {
                                                                                                                                                                        var13 = var56[var30] >> 16;
                                                                                                                                                                        var14 = var56[var30] & '\uffff';
                                                                                                                                                                        int var109 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                                                                        if(var109 >= 0 && var109 <= 5000) {
                                                                                                                                                                           class83.field1320[var13] = var109;
                                                                                                                                                                           byte var88 = -1;
                                                                                                                                                                           if(var14 == 105) {
                                                                                                                                                                              var88 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var34 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var34 >= var109) {
                                                                                                                                                                                 continue label2325;
                                                                                                                                                                              }

                                                                                                                                                                              class83.SHAPE_VERTICIES[var13][var34] = var88;
                                                                                                                                                                              ++var34;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var57 == 45) {
                                                                                                                                                                        var13 = var56[var30];
                                                                                                                                                                        var14 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                                                                        if(var14 < 0 || var14 >= class83.field1320[var13]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = class83.SHAPE_VERTICIES[var13][var14];
                                                                                                                                                                     } else if(var57 == 46) {
                                                                                                                                                                        var13 = var56[var30];
                                                                                                                                                                        BufferProvider.intStackSize -= 2;
                                                                                                                                                                        var14 = class83.intStack[BufferProvider.intStackSize];
                                                                                                                                                                        if(var14 < 0 || var14 >= class83.field1320[var13]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class83.SHAPE_VERTICIES[var13][var14] = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                                                                                     } else if(var57 == 47) {
                                                                                                                                                                        var31 = Varcs.chatMessages.getVarcString(var56[var30]);
                                                                                                                                                                        if(var31 == null) {
                                                                                                                                                                           var31 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var31;
                                                                                                                                                                     } else if(var57 == 48) {
                                                                                                                                                                        Varcs.chatMessages.putVarcString(var56[var30], class83.scriptStringStack[--class83.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var57 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        IterableHashTable var83 = var3.switches[var56[var30]];
                                                                                                                                                                        IntegerNode var87 = (IntegerNode)var83.get((long)class83.intStack[--BufferProvider.intStackSize]);
                                                                                                                                                                        if(var87 != null) {
                                                                                                                                                                           var30 += var87.value;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     Varcs.chatMessages.putVarc(var56[var30], class83.intStack[--BufferProvider.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = Varcs.chatMessages.getVarc(var56[var30]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var13 = var56[var30];
                                                                                                                                                               Script var84 = (Script)Script.field1506.get((long)var13);
                                                                                                                                                               Script var85;
                                                                                                                                                               if(var84 != null) {
                                                                                                                                                                  var85 = var84;
                                                                                                                                                               } else {
                                                                                                                                                                  byte[] var108 = class13.indexScripts.getConfigData(var13, 0);
                                                                                                                                                                  if(var108 == null) {
                                                                                                                                                                     var85 = null;
                                                                                                                                                                  } else {
                                                                                                                                                                     var84 = Friend.method1037(var108);
                                                                                                                                                                     Script.field1506.put(var84, (long)var13);
                                                                                                                                                                     var85 = var84;
                                                                                                                                                                  }
                                                                                                                                                               }

                                                                                                                                                               var84 = var85;
                                                                                                                                                               var86 = new int[var85.localIntCount];
                                                                                                                                                               String[] var76 = new String[var85.localStringCount];

                                                                                                                                                               for(var18 = 0; var18 < var84.intStackCount; ++var18) {
                                                                                                                                                                  var86[var18] = class83.intStack[var18 + (BufferProvider.intStackSize - var84.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var18 = 0; var18 < var84.stringStackCount; ++var18) {
                                                                                                                                                                  var76[var18] = class83.scriptStringStack[var18 + (class83.scriptStringStackSize - var84.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               BufferProvider.intStackSize -= var84.intStackCount;
                                                                                                                                                               class83.scriptStringStackSize -= var84.stringStackCount;
                                                                                                                                                               ScriptState var103 = new ScriptState();
                                                                                                                                                               var103.invokedFromScript = var3;
                                                                                                                                                               var103.invokedFromPc = var30;
                                                                                                                                                               var103.savedLocalInts = class83.scriptLocalInts;
                                                                                                                                                               var103.savedLocalStrings = class83.scriptLocalStrings;
                                                                                                                                                               class83.scriptStack[++class83.scriptStackCount - 1] = var103;
                                                                                                                                                               var3 = var84;
                                                                                                                                                               var55 = var84.instructions;
                                                                                                                                                               var56 = var84.intOperands;
                                                                                                                                                               var30 = -1;
                                                                                                                                                               class83.scriptLocalInts = var86;
                                                                                                                                                               class83.scriptLocalStrings = var76;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --class83.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --BufferProvider.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var13 = var56[var30];
                                                                                                                                                      class83.scriptStringStackSize -= var13;
                                                                                                                                                      String var36 = class249.method4299(class83.scriptStringStack, class83.scriptStringStackSize, var13);
                                                                                                                                                      class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var36;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class83.scriptLocalStrings[var56[var30]] = class83.scriptStringStack[--class83.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class83.scriptStringStack[++class83.scriptStringStackSize - 1] = class83.scriptLocalStrings[var56[var30]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class83.scriptLocalInts[var56[var30]] = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class83.intStack[++BufferProvider.intStackSize - 1] = class83.scriptLocalInts[var56[var30]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       BufferProvider.intStackSize -= 2;
                                                                                                                                       if(class83.intStack[BufferProvider.intStackSize] >= class83.intStack[BufferProvider.intStackSize + 1]) {
                                                                                                                                          var30 += var56[var30];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    BufferProvider.intStackSize -= 2;
                                                                                                                                    if(class83.intStack[BufferProvider.intStackSize] <= class83.intStack[BufferProvider.intStackSize + 1]) {
                                                                                                                                       var30 += var56[var30];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var13 = var56[var30];
                                                                                                                                 var14 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                                 Varbit var107 = (Varbit)Varbit.varbits.get((long)var13);
                                                                                                                                 Varbit var33;
                                                                                                                                 if(var107 != null) {
                                                                                                                                    var33 = var107;
                                                                                                                                 } else {
                                                                                                                                    byte[] var74 = Varbit.varbit_ref.getConfigData(14, var13);
                                                                                                                                    var107 = new Varbit();
                                                                                                                                    if(var74 != null) {
                                                                                                                                       var107.decode(new Buffer(var74));
                                                                                                                                    }

                                                                                                                                    Varbit.varbits.put(var107, (long)var13);
                                                                                                                                    var33 = var107;
                                                                                                                                 }

                                                                                                                                 var34 = var33.configId;
                                                                                                                                 var18 = var33.leastSignificantBit;
                                                                                                                                 var35 = var33.mostSignificantBit;
                                                                                                                                 var20 = class211.field2576[var35 - var18];
                                                                                                                                 if(var14 < 0 || var14 > var20) {
                                                                                                                                    var14 = 0;
                                                                                                                                 }

                                                                                                                                 var20 <<= var18;
                                                                                                                                 class211.widgetSettings[var34] = class211.widgetSettings[var34] & ~var20 | var14 << var18 & var20;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var13 = var56[var30];
                                                                                                                              class83.intStack[++BufferProvider.intStackSize - 1] = method125(var13);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class83.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var81 = class83.scriptStack[--class83.scriptStackCount];
                                                                                                                           var3 = var81.invokedFromScript;
                                                                                                                           var55 = var3.instructions;
                                                                                                                           var56 = var3.intOperands;
                                                                                                                           var30 = var81.invokedFromPc;
                                                                                                                           class83.scriptLocalInts = var81.savedLocalInts;
                                                                                                                           class83.scriptLocalStrings = var81.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        BufferProvider.intStackSize -= 2;
                                                                                                                        if(class83.intStack[BufferProvider.intStackSize] > class83.intStack[BufferProvider.intStackSize + 1]) {
                                                                                                                           var30 += var56[var30];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     BufferProvider.intStackSize -= 2;
                                                                                                                     if(class83.intStack[BufferProvider.intStackSize] < class83.intStack[BufferProvider.intStackSize + 1]) {
                                                                                                                        var30 += var56[var30];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  BufferProvider.intStackSize -= 2;
                                                                                                                  if(class83.intStack[BufferProvider.intStackSize] == class83.intStack[BufferProvider.intStackSize + 1]) {
                                                                                                                     var30 += var56[var30];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               BufferProvider.intStackSize -= 2;
                                                                                                               if(class83.intStack[BufferProvider.intStackSize] != class83.intStack[BufferProvider.intStackSize + 1]) {
                                                                                                                  var30 += var56[var30];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var30 += var56[var30];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var3.stringOperands[var30];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var13 = var56[var30];
                                                                                                      class211.widgetSettings[var13] = class83.intStack[--BufferProvider.intStackSize];
                                                                                                      class164.method3010(var13);
                                                                                                   }
                                                                                                } else {
                                                                                                   var13 = var56[var30];
                                                                                                   class83.intStack[++BufferProvider.intStackSize - 1] = class211.widgetSettings[var13];
                                                                                                }
                                                                                             } else {
                                                                                                class83.intStack[++BufferProvider.intStackSize - 1] = var56[var30];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var60;
                                                                                             if(var3.intOperands[var30] == 1) {
                                                                                                var60 = true;
                                                                                             } else {
                                                                                                var60 = false;
                                                                                             }

                                                                                             if(var57 < 1000) {
                                                                                                var14 = ISAACCipher.method3379(var57, var3, var60);
                                                                                             } else if(var57 < 1100) {
                                                                                                var14 = CombatInfo1.method1504(var57, var3, var60);
                                                                                             } else if(var57 < 1200) {
                                                                                                var14 = World.method1537(var57, var3, var60);
                                                                                             } else if(var57 < 1300) {
                                                                                                var14 = class215.method3909(var57, var3, var60);
                                                                                             } else if(var57 < 1400) {
                                                                                                var14 = class64.method1035(var57, var3, var60);
                                                                                             } else if(var57 < 1500) {
                                                                                                var14 = WorldMapType3.method209(var57, var3, var60);
                                                                                             } else {
                                                                                                byte var15;
                                                                                                if(var57 < 1600) {
                                                                                                   Widget var19 = var60?class48.field614:FaceNormal.field2099;
                                                                                                   if(var57 == 1500) {
                                                                                                      class83.intStack[++BufferProvider.intStackSize - 1] = var19.relativeX;
                                                                                                      var15 = 1;
                                                                                                   } else if(var57 == 1501) {
                                                                                                      class83.intStack[++BufferProvider.intStackSize - 1] = var19.relativeY;
                                                                                                      var15 = 1;
                                                                                                   } else if(var57 == 1502) {
                                                                                                      class83.intStack[++BufferProvider.intStackSize - 1] = var19.width;
                                                                                                      var15 = 1;
                                                                                                   } else if(var57 == 1503) {
                                                                                                      class83.intStack[++BufferProvider.intStackSize - 1] = var19.height;
                                                                                                      var15 = 1;
                                                                                                   } else if(var57 == 1504) {
                                                                                                      class83.intStack[++BufferProvider.intStackSize - 1] = var19.isHidden?1:0;
                                                                                                      var15 = 1;
                                                                                                   } else if(var57 == 1505) {
                                                                                                      class83.intStack[++BufferProvider.intStackSize - 1] = var19.parentId;
                                                                                                      var15 = 1;
                                                                                                   } else {
                                                                                                      var15 = 2;
                                                                                                   }

                                                                                                   var14 = var15;
                                                                                                } else if(var57 < 1700) {
                                                                                                   var14 = ScriptState.method1023(var57, var3, var60);
                                                                                                } else if(var57 < 1800) {
                                                                                                   var14 = class88.method1656(var57, var3, var60);
                                                                                                } else {
                                                                                                   int[] var17;
                                                                                                   Widget var32;
                                                                                                   if(var57 < 1900) {
                                                                                                      var32 = var60?class48.field614:FaceNormal.field2099;
                                                                                                      if(var57 == 1800) {
                                                                                                         var17 = class83.intStack;
                                                                                                         var18 = ++BufferProvider.intStackSize - 1;
                                                                                                         var20 = class60.getWidgetConfig(var32);
                                                                                                         var35 = var20 >> 11 & 63;
                                                                                                         var17[var18] = var35;
                                                                                                         var15 = 1;
                                                                                                      } else if(var57 != 1801) {
                                                                                                         if(var57 == 1802) {
                                                                                                            if(var32.name == null) {
                                                                                                               class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                                                                                                            } else {
                                                                                                               class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var32.name;
                                                                                                            }

                                                                                                            var15 = 1;
                                                                                                         } else {
                                                                                                            var15 = 2;
                                                                                                         }
                                                                                                      } else {
                                                                                                         var34 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                         --var34;
                                                                                                         if(var32.actions != null && var34 < var32.actions.length && var32.actions[var34] != null) {
                                                                                                            class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var32.actions[var34];
                                                                                                         } else {
                                                                                                            class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                                                                                                         }

                                                                                                         var15 = 1;
                                                                                                      }

                                                                                                      var14 = var15;
                                                                                                   } else if(var57 < 2000) {
                                                                                                      var14 = DecorativeObject.method2834(var57, var3, var60);
                                                                                                   } else if(var57 < 2100) {
                                                                                                      var14 = CombatInfo1.method1504(var57, var3, var60);
                                                                                                   } else if(var57 < 2200) {
                                                                                                      var14 = World.method1537(var57, var3, var60);
                                                                                                   } else if(var57 < 2300) {
                                                                                                      var14 = class215.method3909(var57, var3, var60);
                                                                                                   } else if(var57 < 2400) {
                                                                                                      var14 = class64.method1035(var57, var3, var60);
                                                                                                   } else if(var57 < 2500) {
                                                                                                      var14 = WorldMapType3.method209(var57, var3, var60);
                                                                                                   } else if(var57 < 2600) {
                                                                                                      var32 = class239.method4167(class83.intStack[--BufferProvider.intStackSize]);
                                                                                                      if(var57 == 2500) {
                                                                                                         class83.intStack[++BufferProvider.intStackSize - 1] = var32.relativeX;
                                                                                                         var15 = 1;
                                                                                                      } else if(var57 == 2501) {
                                                                                                         class83.intStack[++BufferProvider.intStackSize - 1] = var32.relativeY;
                                                                                                         var15 = 1;
                                                                                                      } else if(var57 == 2502) {
                                                                                                         class83.intStack[++BufferProvider.intStackSize - 1] = var32.width;
                                                                                                         var15 = 1;
                                                                                                      } else if(var57 == 2503) {
                                                                                                         class83.intStack[++BufferProvider.intStackSize - 1] = var32.height;
                                                                                                         var15 = 1;
                                                                                                      } else if(var57 == 2504) {
                                                                                                         class83.intStack[++BufferProvider.intStackSize - 1] = var32.isHidden?1:0;
                                                                                                         var15 = 1;
                                                                                                      } else if(var57 == 2505) {
                                                                                                         class83.intStack[++BufferProvider.intStackSize - 1] = var32.parentId;
                                                                                                         var15 = 1;
                                                                                                      } else {
                                                                                                         var15 = 2;
                                                                                                      }

                                                                                                      var14 = var15;
                                                                                                   } else if(var57 < 2700) {
                                                                                                      var32 = class239.method4167(class83.intStack[--BufferProvider.intStackSize]);
                                                                                                      if(var57 == 2600) {
                                                                                                         class83.intStack[++BufferProvider.intStackSize - 1] = var32.scrollX;
                                                                                                         var15 = 1;
                                                                                                      } else if(var57 == 2601) {
                                                                                                         class83.intStack[++BufferProvider.intStackSize - 1] = var32.scrollY;
                                                                                                         var15 = 1;
                                                                                                      } else if(var57 == 2602) {
                                                                                                         class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var32.text;
                                                                                                         var15 = 1;
                                                                                                      } else if(var57 == 2603) {
                                                                                                         class83.intStack[++BufferProvider.intStackSize - 1] = var32.scrollWidth;
                                                                                                         var15 = 1;
                                                                                                      } else if(var57 == 2604) {
                                                                                                         class83.intStack[++BufferProvider.intStackSize - 1] = var32.scrollHeight;
                                                                                                         var15 = 1;
                                                                                                      } else if(var57 == 2605) {
                                                                                                         class83.intStack[++BufferProvider.intStackSize - 1] = var32.modelZoom;
                                                                                                         var15 = 1;
                                                                                                      } else if(var57 == 2606) {
                                                                                                         class83.intStack[++BufferProvider.intStackSize - 1] = var32.rotationX;
                                                                                                         var15 = 1;
                                                                                                      } else if(var57 == 2607) {
                                                                                                         class83.intStack[++BufferProvider.intStackSize - 1] = var32.rotationY;
                                                                                                         var15 = 1;
                                                                                                      } else if(var57 == 2608) {
                                                                                                         class83.intStack[++BufferProvider.intStackSize - 1] = var32.rotationZ;
                                                                                                         var15 = 1;
                                                                                                      } else if(var57 == 2609) {
                                                                                                         class83.intStack[++BufferProvider.intStackSize - 1] = var32.opacity;
                                                                                                         var15 = 1;
                                                                                                      } else if(var57 == 2610) {
                                                                                                         class83.intStack[++BufferProvider.intStackSize - 1] = var32.field2649;
                                                                                                         var15 = 1;
                                                                                                      } else if(var57 == 2611) {
                                                                                                         class83.intStack[++BufferProvider.intStackSize - 1] = var32.textColor;
                                                                                                         var15 = 1;
                                                                                                      } else if(var57 == 2612) {
                                                                                                         class83.intStack[++BufferProvider.intStackSize - 1] = var32.field2643;
                                                                                                         var15 = 1;
                                                                                                      } else if(var57 == 2613) {
                                                                                                         class83.intStack[++BufferProvider.intStackSize - 1] = var32.field2647.rsOrdinal();
                                                                                                         var15 = 1;
                                                                                                      } else {
                                                                                                         var15 = 2;
                                                                                                      }

                                                                                                      var14 = var15;
                                                                                                   } else if(var57 < 2800) {
                                                                                                      var14 = class51.method746(var57, var3, var60);
                                                                                                   } else if(var57 < 2900) {
                                                                                                      var14 = FileSystem.method4003(var57, var3, var60);
                                                                                                   } else if(var57 < 3000) {
                                                                                                      var14 = DecorativeObject.method2834(var57, var3, var60);
                                                                                                   } else if(var57 < 3200) {
                                                                                                      var14 = class205.method3761(var57, var3, var60);
                                                                                                   } else if(var57 < 3300) {
                                                                                                      if(var57 == 3200) {
                                                                                                         BufferProvider.intStackSize -= 3;
                                                                                                         WallObject.method2805(class83.intStack[BufferProvider.intStackSize], class83.intStack[BufferProvider.intStackSize + 1], class83.intStack[BufferProvider.intStackSize + 2]);
                                                                                                         var15 = 1;
                                                                                                      } else if(var57 == 3201) {
                                                                                                         WorldMapType3.method207(class83.intStack[--BufferProvider.intStackSize]);
                                                                                                         var15 = 1;
                                                                                                      } else if(var57 == 3202) {
                                                                                                         BufferProvider.intStackSize -= 2;
                                                                                                         class1.method3(class83.intStack[BufferProvider.intStackSize], class83.intStack[BufferProvider.intStackSize + 1]);
                                                                                                         var15 = 1;
                                                                                                      } else {
                                                                                                         var15 = 2;
                                                                                                      }

                                                                                                      var14 = var15;
                                                                                                   } else {
                                                                                                      int var16;
                                                                                                      int var22;
                                                                                                      int var23;
                                                                                                      byte[] var65;
                                                                                                      if(var57 < 3400) {
                                                                                                         if(var57 == 3300) {
                                                                                                            class83.intStack[++BufferProvider.intStackSize - 1] = Client.gameCycle;
                                                                                                            var15 = 1;
                                                                                                         } else if(var57 == 3301) {
                                                                                                            BufferProvider.intStackSize -= 2;
                                                                                                            var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                            var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                            class83.intStack[++BufferProvider.intStackSize - 1] = class261.method4613(var16, var34);
                                                                                                            var15 = 1;
                                                                                                         } else {
                                                                                                            XItemContainer var21;
                                                                                                            int[] var37;
                                                                                                            if(var57 == 3302) {
                                                                                                               BufferProvider.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                               var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                               var37 = class83.intStack;
                                                                                                               var35 = ++BufferProvider.intStackSize - 1;
                                                                                                               var21 = (XItemContainer)XItemContainer.itemContainers.get((long)var16);
                                                                                                               if(var21 == null) {
                                                                                                                  var20 = 0;
                                                                                                               } else if(var34 >= 0 && var34 < var21.stackSizes.length) {
                                                                                                                  var20 = var21.stackSizes[var34];
                                                                                                               } else {
                                                                                                                  var20 = 0;
                                                                                                               }

                                                                                                               var37[var35] = var20;
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 3303) {
                                                                                                               BufferProvider.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                               var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                               var37 = class83.intStack;
                                                                                                               var35 = ++BufferProvider.intStackSize - 1;
                                                                                                               var21 = (XItemContainer)XItemContainer.itemContainers.get((long)var16);
                                                                                                               if(var21 == null) {
                                                                                                                  var20 = 0;
                                                                                                               } else if(var34 == -1) {
                                                                                                                  var20 = 0;
                                                                                                               } else {
                                                                                                                  var22 = 0;

                                                                                                                  for(var23 = 0; var23 < var21.stackSizes.length; ++var23) {
                                                                                                                     if(var34 == var21.itemIds[var23]) {
                                                                                                                        var22 += var21.stackSizes[var23];
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var20 = var22;
                                                                                                               }

                                                                                                               var37[var35] = var20;
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 3304) {
                                                                                                               var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                               var17 = class83.intStack;
                                                                                                               var18 = ++BufferProvider.intStackSize - 1;
                                                                                                               InvType var38 = (InvType)InvType.field3249.get((long)var16);
                                                                                                               InvType var61;
                                                                                                               if(var38 != null) {
                                                                                                                  var61 = var38;
                                                                                                               } else {
                                                                                                                  var65 = class5.field30.getConfigData(5, var16);
                                                                                                                  var38 = new InvType();
                                                                                                                  if(var65 != null) {
                                                                                                                     var38.decode(new Buffer(var65));
                                                                                                                  }

                                                                                                                  InvType.field3249.put(var38, (long)var16);
                                                                                                                  var61 = var38;
                                                                                                               }

                                                                                                               var17[var18] = var61.field3248;
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 3305) {
                                                                                                               var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = Client.boostedSkillLevels[var16];
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 3306) {
                                                                                                               var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = Client.realSkillLevels[var16];
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 3307) {
                                                                                                               var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = Client.skillExperiences[var16];
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 3308) {
                                                                                                               var16 = class10.plane;
                                                                                                               var34 = (class226.localPlayer.x >> 7) + class21.baseX;
                                                                                                               var18 = (class226.localPlayer.y >> 7) + class164.baseY;
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = var18 + (var34 << 14) + (var16 << 28);
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 3309) {
                                                                                                               var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = var16 >> 14 & 16383;
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 3310) {
                                                                                                               var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = var16 >> 28;
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 3311) {
                                                                                                               var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = var16 & 16383;
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 3312) {
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = Client.isMembers?1:0;
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 3313) {
                                                                                                               BufferProvider.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[BufferProvider.intStackSize] + '耀';
                                                                                                               var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = class261.method4613(var16, var34);
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 3314) {
                                                                                                               BufferProvider.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[BufferProvider.intStackSize] + '耀';
                                                                                                               var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                               var37 = class83.intStack;
                                                                                                               var35 = ++BufferProvider.intStackSize - 1;
                                                                                                               var21 = (XItemContainer)XItemContainer.itemContainers.get((long)var16);
                                                                                                               if(var21 == null) {
                                                                                                                  var20 = 0;
                                                                                                               } else if(var34 >= 0 && var34 < var21.stackSizes.length) {
                                                                                                                  var20 = var21.stackSizes[var34];
                                                                                                               } else {
                                                                                                                  var20 = 0;
                                                                                                               }

                                                                                                               var37[var35] = var20;
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 != 3315) {
                                                                                                               if(var57 == 3316) {
                                                                                                                  if(Client.rights >= 2) {
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = Client.rights;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var57 == 3317) {
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = Client.field1070;
                                                                                                                  var15 = 1;
                                                                                                               } else if(var57 == 3318) {
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = Client.world;
                                                                                                                  var15 = 1;
                                                                                                               } else if(var57 == 3321) {
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = Client.energy;
                                                                                                                  var15 = 1;
                                                                                                               } else if(var57 == 3322) {
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = Client.weight;
                                                                                                                  var15 = 1;
                                                                                                               } else if(var57 == 3323) {
                                                                                                                  if(Client.field1073) {
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = 1;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var57 == 3324) {
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = Client.flags;
                                                                                                                  var15 = 1;
                                                                                                               } else if(var57 == 3325) {
                                                                                                                  BufferProvider.intStackSize -= 4;
                                                                                                                  var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                                  var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                                  var18 = class83.intStack[BufferProvider.intStackSize + 2];
                                                                                                                  var35 = class83.intStack[BufferProvider.intStackSize + 3];
                                                                                                                  var16 += var34 << 14;
                                                                                                                  var16 += var18 << 28;
                                                                                                                  var16 += var35;
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = var16;
                                                                                                                  var15 = 1;
                                                                                                               } else {
                                                                                                                  var15 = 2;
                                                                                                               }
                                                                                                            } else {
                                                                                                               BufferProvider.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[BufferProvider.intStackSize] + '耀';
                                                                                                               var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                               var37 = class83.intStack;
                                                                                                               var35 = ++BufferProvider.intStackSize - 1;
                                                                                                               var21 = (XItemContainer)XItemContainer.itemContainers.get((long)var16);
                                                                                                               if(var21 == null) {
                                                                                                                  var20 = 0;
                                                                                                               } else if(var34 == -1) {
                                                                                                                  var20 = 0;
                                                                                                               } else {
                                                                                                                  var22 = 0;

                                                                                                                  for(var23 = 0; var23 < var21.stackSizes.length; ++var23) {
                                                                                                                     if(var34 == var21.itemIds[var23]) {
                                                                                                                        var22 += var21.stackSizes[var23];
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var20 = var22;
                                                                                                               }

                                                                                                               var37[var35] = var20;
                                                                                                               var15 = 1;
                                                                                                            }
                                                                                                         }

                                                                                                         var14 = var15;
                                                                                                      } else if(var57 < 3500) {
                                                                                                         if(var57 == 3400) {
                                                                                                            BufferProvider.intStackSize -= 2;
                                                                                                            var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                            var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                            Enum var64 = (Enum)Enum.field3381.get((long)var16);
                                                                                                            Enum var89;
                                                                                                            if(var64 != null) {
                                                                                                               var89 = var64;
                                                                                                            } else {
                                                                                                               byte[] var94 = Enum.field3374.getConfigData(8, var16);
                                                                                                               var64 = new Enum();
                                                                                                               if(var94 != null) {
                                                                                                                  var64.decode(new Buffer(var94));
                                                                                                               }

                                                                                                               Enum.field3381.put(var64, (long)var16);
                                                                                                               var89 = var64;
                                                                                                            }

                                                                                                            var64 = var89;
                                                                                                            if(var89.valType != 115) {
                                                                                                               ;
                                                                                                            }

                                                                                                            for(var20 = 0; var20 < var64.size; ++var20) {
                                                                                                               if(var34 == var64.keys[var20]) {
                                                                                                                  class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var64.stringVals[var20];
                                                                                                                  var64 = null;
                                                                                                                  break;
                                                                                                               }
                                                                                                            }

                                                                                                            if(var64 != null) {
                                                                                                               class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var64.defaultString;
                                                                                                            }

                                                                                                            var15 = 1;
                                                                                                         } else if(var57 == 3408) {
                                                                                                            BufferProvider.intStackSize -= 4;
                                                                                                            var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                            var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                            var18 = class83.intStack[BufferProvider.intStackSize + 2];
                                                                                                            var35 = class83.intStack[BufferProvider.intStackSize + 3];
                                                                                                            Enum var69 = (Enum)Enum.field3381.get((long)var18);
                                                                                                            Enum var91;
                                                                                                            if(var69 != null) {
                                                                                                               var91 = var69;
                                                                                                            } else {
                                                                                                               byte[] var39 = Enum.field3374.getConfigData(8, var18);
                                                                                                               var69 = new Enum();
                                                                                                               if(var39 != null) {
                                                                                                                  var69.decode(new Buffer(var39));
                                                                                                               }

                                                                                                               Enum.field3381.put(var69, (long)var18);
                                                                                                               var91 = var69;
                                                                                                            }

                                                                                                            var69 = var91;
                                                                                                            if(var16 == var91.keyType && var34 == var91.valType) {
                                                                                                               for(var22 = 0; var22 < var69.size; ++var22) {
                                                                                                                  if(var35 == var69.keys[var22]) {
                                                                                                                     if(var34 == 115) {
                                                                                                                        class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var69.stringVals[var22];
                                                                                                                     } else {
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = var69.intVals[var22];
                                                                                                                     }

                                                                                                                     var69 = null;
                                                                                                                     break;
                                                                                                                  }
                                                                                                               }

                                                                                                               if(var69 != null) {
                                                                                                                  if(var34 == 115) {
                                                                                                                     class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var69.defaultString;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = var69.defaultInt;
                                                                                                                  }
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else {
                                                                                                               if(var34 == 115) {
                                                                                                                  class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "null";
                                                                                                               } else {
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            }
                                                                                                         } else {
                                                                                                            var15 = 2;
                                                                                                         }

                                                                                                         var14 = var15;
                                                                                                      } else if(var57 < 3700) {
                                                                                                         var14 = GraphicsObject.method1616(var57, var3, var60);
                                                                                                      } else if(var57 < 4000) {
                                                                                                         var14 = class51.method745(var57, var3, var60);
                                                                                                      } else if(var57 < 4100) {
                                                                                                         if(var57 == 4000) {
                                                                                                            BufferProvider.intStackSize -= 2;
                                                                                                            var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                            var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                            class83.intStack[++BufferProvider.intStackSize - 1] = var16 + var34;
                                                                                                            var15 = 1;
                                                                                                         } else if(var57 == 4001) {
                                                                                                            BufferProvider.intStackSize -= 2;
                                                                                                            var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                            var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                            class83.intStack[++BufferProvider.intStackSize - 1] = var16 - var34;
                                                                                                            var15 = 1;
                                                                                                         } else if(var57 == 4002) {
                                                                                                            BufferProvider.intStackSize -= 2;
                                                                                                            var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                            var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                            class83.intStack[++BufferProvider.intStackSize - 1] = var16 * var34;
                                                                                                            var15 = 1;
                                                                                                         } else if(var57 == 4003) {
                                                                                                            BufferProvider.intStackSize -= 2;
                                                                                                            var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                            var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                            class83.intStack[++BufferProvider.intStackSize - 1] = var16 / var34;
                                                                                                            var15 = 1;
                                                                                                         } else if(var57 == 4004) {
                                                                                                            var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                            class83.intStack[++BufferProvider.intStackSize - 1] = (int)(Math.random() * (double)var16);
                                                                                                            var15 = 1;
                                                                                                         } else if(var57 == 4005) {
                                                                                                            var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                            class83.intStack[++BufferProvider.intStackSize - 1] = (int)(Math.random() * (double)(var16 + 1));
                                                                                                            var15 = 1;
                                                                                                         } else if(var57 == 4006) {
                                                                                                            BufferProvider.intStackSize -= 5;
                                                                                                            var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                            var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                            var18 = class83.intStack[BufferProvider.intStackSize + 2];
                                                                                                            var35 = class83.intStack[BufferProvider.intStackSize + 3];
                                                                                                            var20 = class83.intStack[BufferProvider.intStackSize + 4];
                                                                                                            class83.intStack[++BufferProvider.intStackSize - 1] = var16 + (var20 - var18) * (var34 - var16) / (var35 - var18);
                                                                                                            var15 = 1;
                                                                                                         } else if(var57 == 4007) {
                                                                                                            BufferProvider.intStackSize -= 2;
                                                                                                            var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                            var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                            class83.intStack[++BufferProvider.intStackSize - 1] = var16 + var16 * var34 / 100;
                                                                                                            var15 = 1;
                                                                                                         } else if(var57 == 4008) {
                                                                                                            BufferProvider.intStackSize -= 2;
                                                                                                            var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                            var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                            class83.intStack[++BufferProvider.intStackSize - 1] = var16 | 1 << var34;
                                                                                                            var15 = 1;
                                                                                                         } else if(var57 == 4009) {
                                                                                                            BufferProvider.intStackSize -= 2;
                                                                                                            var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                            var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                            class83.intStack[++BufferProvider.intStackSize - 1] = var16 & -1 - (1 << var34);
                                                                                                            var15 = 1;
                                                                                                         } else if(var57 == 4010) {
                                                                                                            BufferProvider.intStackSize -= 2;
                                                                                                            var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                            var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                            class83.intStack[++BufferProvider.intStackSize - 1] = (var16 & 1 << var34) != 0?1:0;
                                                                                                            var15 = 1;
                                                                                                         } else if(var57 == 4011) {
                                                                                                            BufferProvider.intStackSize -= 2;
                                                                                                            var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                            var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                            class83.intStack[++BufferProvider.intStackSize - 1] = var16 % var34;
                                                                                                            var15 = 1;
                                                                                                         } else if(var57 == 4012) {
                                                                                                            BufferProvider.intStackSize -= 2;
                                                                                                            var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                            var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                            if(var16 == 0) {
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                                                                                                            } else {
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = (int)Math.pow((double)var16, (double)var34);
                                                                                                            }

                                                                                                            var15 = 1;
                                                                                                         } else if(var57 == 4013) {
                                                                                                            BufferProvider.intStackSize -= 2;
                                                                                                            var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                            var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                            if(var16 == 0) {
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                                                                                                            } else if(var34 == 0) {
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = Integer.MAX_VALUE;
                                                                                                            } else {
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = (int)Math.pow((double)var16, 1.0D / (double)var34);
                                                                                                            }

                                                                                                            var15 = 1;
                                                                                                         } else if(var57 == 4014) {
                                                                                                            BufferProvider.intStackSize -= 2;
                                                                                                            var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                            var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                            class83.intStack[++BufferProvider.intStackSize - 1] = var16 & var34;
                                                                                                            var15 = 1;
                                                                                                         } else if(var57 == 4015) {
                                                                                                            BufferProvider.intStackSize -= 2;
                                                                                                            var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                            var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                            class83.intStack[++BufferProvider.intStackSize - 1] = var16 | var34;
                                                                                                            var15 = 1;
                                                                                                         } else if(var57 == 4018) {
                                                                                                            BufferProvider.intStackSize -= 3;
                                                                                                            long var40 = (long)class83.intStack[BufferProvider.intStackSize];
                                                                                                            long var42 = (long)class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                            long var44 = (long)class83.intStack[BufferProvider.intStackSize + 2];
                                                                                                            class83.intStack[++BufferProvider.intStackSize - 1] = (int)(var44 * var40 / var42);
                                                                                                            var15 = 1;
                                                                                                         } else {
                                                                                                            var15 = 2;
                                                                                                         }

                                                                                                         var14 = var15;
                                                                                                      } else {
                                                                                                         int var48;
                                                                                                         String var59;
                                                                                                         String var82;
                                                                                                         boolean var90;
                                                                                                         if(var57 < 4200) {
                                                                                                            if(var57 == 4100) {
                                                                                                               var82 = class83.scriptStringStack[--class83.scriptStringStackSize];
                                                                                                               var34 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                               class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var82 + var34;
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 4101) {
                                                                                                               class83.scriptStringStackSize -= 2;
                                                                                                               var82 = class83.scriptStringStack[class83.scriptStringStackSize];
                                                                                                               var59 = class83.scriptStringStack[class83.scriptStringStackSize + 1];
                                                                                                               class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var82 + var59;
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 4102) {
                                                                                                               var82 = class83.scriptStringStack[--class83.scriptStringStackSize];
                                                                                                               var34 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                               String[] var92 = class83.scriptStringStack;
                                                                                                               var35 = ++class83.scriptStringStackSize - 1;
                                                                                                               String var77;
                                                                                                               if(var34 < 0) {
                                                                                                                  var77 = Integer.toString(var34);
                                                                                                               } else {
                                                                                                                  var23 = var34;
                                                                                                                  String var93;
                                                                                                                  if(var34 < 0) {
                                                                                                                     var93 = Integer.toString(var34, 10);
                                                                                                                  } else {
                                                                                                                     int var24 = 2;

                                                                                                                     for(int var25 = var34 / 10; var25 != 0; ++var24) {
                                                                                                                        var25 /= 10;
                                                                                                                     }

                                                                                                                     char[] var26 = new char[var24];
                                                                                                                     var26[0] = 43;

                                                                                                                     for(int var27 = var24 - 1; var27 > 0; --var27) {
                                                                                                                        int var28 = var23;
                                                                                                                        var23 /= 10;
                                                                                                                        int var29 = var28 - var23 * 10;
                                                                                                                        if(var29 >= 10) {
                                                                                                                           var26[var27] = (char)(var29 + 87);
                                                                                                                        } else {
                                                                                                                           var26[var27] = (char)(var29 + 48);
                                                                                                                        }
                                                                                                                     }

                                                                                                                     var93 = new String(var26);
                                                                                                                  }

                                                                                                                  var77 = var93;
                                                                                                               }

                                                                                                               var92[var35] = var82 + var77;
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 4103) {
                                                                                                               var82 = class83.scriptStringStack[--class83.scriptStringStackSize];
                                                                                                               class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var82.toLowerCase();
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 4104) {
                                                                                                               var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                               long var46 = 86400000L * ((long)var16 + 11745L);
                                                                                                               class83.field1335.setTime(new Date(var46));
                                                                                                               var35 = class83.field1335.get(5);
                                                                                                               var20 = class83.field1335.get(2);
                                                                                                               var48 = class83.field1335.get(1);
                                                                                                               class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var35 + "-" + class83.field1332[var20] + "-" + var48;
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 4105) {
                                                                                                               class83.scriptStringStackSize -= 2;
                                                                                                               var82 = class83.scriptStringStack[class83.scriptStringStackSize];
                                                                                                               var59 = class83.scriptStringStack[class83.scriptStringStackSize + 1];
                                                                                                               if(class226.localPlayer.composition != null && class226.localPlayer.composition.isFemale) {
                                                                                                                  class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var59;
                                                                                                               } else {
                                                                                                                  class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var82;
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 4106) {
                                                                                                               var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                               class83.scriptStringStack[++class83.scriptStringStackSize - 1] = Integer.toString(var16);
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 4107) {
                                                                                                               class83.scriptStringStackSize -= 2;
                                                                                                               var86 = class83.intStack;
                                                                                                               var34 = ++BufferProvider.intStackSize - 1;
                                                                                                               var35 = PendingSpawn.method1461(class83.scriptStringStack[class83.scriptStringStackSize], class83.scriptStringStack[class83.scriptStringStackSize + 1], Client.languageId);
                                                                                                               byte var72;
                                                                                                               if(var35 > 0) {
                                                                                                                  var72 = 1;
                                                                                                               } else if(var35 < 0) {
                                                                                                                  var72 = -1;
                                                                                                               } else {
                                                                                                                  var72 = 0;
                                                                                                               }

                                                                                                               var86[var34] = var72;
                                                                                                               var15 = 1;
                                                                                                            } else {
                                                                                                               byte[] var67;
                                                                                                               Font var96;
                                                                                                               if(var57 == 4108) {
                                                                                                                  var82 = class83.scriptStringStack[--class83.scriptStringStackSize];
                                                                                                                  BufferProvider.intStackSize -= 2;
                                                                                                                  var34 = class83.intStack[BufferProvider.intStackSize];
                                                                                                                  var18 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                                  var67 = class60.field744.getConfigData(var18, 0);
                                                                                                                  var96 = new Font(var67);
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = var96.method4638(var82, var34);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var57 == 4109) {
                                                                                                                  var82 = class83.scriptStringStack[--class83.scriptStringStackSize];
                                                                                                                  BufferProvider.intStackSize -= 2;
                                                                                                                  var34 = class83.intStack[BufferProvider.intStackSize];
                                                                                                                  var18 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                                  var67 = class60.field744.getConfigData(var18, 0);
                                                                                                                  var96 = new Font(var67);
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = var96.method4637(var82, var34);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var57 == 4110) {
                                                                                                                  class83.scriptStringStackSize -= 2;
                                                                                                                  var82 = class83.scriptStringStack[class83.scriptStringStackSize];
                                                                                                                  var59 = class83.scriptStringStack[class83.scriptStringStackSize + 1];
                                                                                                                  if(class83.intStack[--BufferProvider.intStackSize] == 1) {
                                                                                                                     class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var82;
                                                                                                                  } else {
                                                                                                                     class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var59;
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var57 == 4111) {
                                                                                                                  var82 = class83.scriptStringStack[--class83.scriptStringStackSize];
                                                                                                                  class83.scriptStringStack[++class83.scriptStringStackSize - 1] = FontTypeFace.appendTags(var82);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var57 == 4112) {
                                                                                                                  var82 = class83.scriptStringStack[--class83.scriptStringStackSize];
                                                                                                                  var34 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                  class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var82 + (char)var34;
                                                                                                                  var15 = 1;
                                                                                                               } else {
                                                                                                                  char var79;
                                                                                                                  if(var57 == 4113) {
                                                                                                                     var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                     var17 = class83.intStack;
                                                                                                                     var18 = ++BufferProvider.intStackSize - 1;
                                                                                                                     var79 = (char)var16;
                                                                                                                     if(var79 >= 32 && var79 <= 126) {
                                                                                                                        var90 = true;
                                                                                                                     } else if(var79 >= 160 && var79 <= 255) {
                                                                                                                        var90 = true;
                                                                                                                     } else if(var79 != 8364 && var79 != 338 && var79 != 8212 && var79 != 339 && var79 != 376) {
                                                                                                                        var90 = false;
                                                                                                                     } else {
                                                                                                                        var90 = true;
                                                                                                                     }

                                                                                                                     var17[var18] = var90?1:0;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var57 == 4114) {
                                                                                                                     var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = CombatInfoListHolder.method1630((char)var16)?1:0;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var57 == 4115) {
                                                                                                                     var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                     var17 = class83.intStack;
                                                                                                                     var18 = ++BufferProvider.intStackSize - 1;
                                                                                                                     var79 = (char)var16;
                                                                                                                     var90 = var79 >= 65 && var79 <= 90 || var79 >= 97 && var79 <= 122;
                                                                                                                     var17[var18] = var90?1:0;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var57 == 4116) {
                                                                                                                     var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = class2.method5((char)var16)?1:0;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var57 == 4117) {
                                                                                                                     var82 = class83.scriptStringStack[--class83.scriptStringStackSize];
                                                                                                                     if(var82 != null) {
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = var82.length();
                                                                                                                     } else {
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                                                                                                                     }

                                                                                                                     var15 = 1;
                                                                                                                  } else if(var57 == 4118) {
                                                                                                                     var82 = class83.scriptStringStack[--class83.scriptStringStackSize];
                                                                                                                     BufferProvider.intStackSize -= 2;
                                                                                                                     var34 = class83.intStack[BufferProvider.intStackSize];
                                                                                                                     var18 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                                     class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var82.substring(var34, var18);
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var57 != 4119) {
                                                                                                                     if(var57 == 4120) {
                                                                                                                        var82 = class83.scriptStringStack[--class83.scriptStringStackSize];
                                                                                                                        var34 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = var82.indexOf(var34);
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var57 == 4121) {
                                                                                                                        class83.scriptStringStackSize -= 2;
                                                                                                                        var82 = class83.scriptStringStack[class83.scriptStringStackSize];
                                                                                                                        var59 = class83.scriptStringStack[class83.scriptStringStackSize + 1];
                                                                                                                        var18 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = var82.indexOf(var59, var18);
                                                                                                                        var15 = 1;
                                                                                                                     } else {
                                                                                                                        var15 = 2;
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     var82 = class83.scriptStringStack[--class83.scriptStringStackSize];
                                                                                                                     StringBuilder var58 = new StringBuilder(var82.length());
                                                                                                                     boolean var63 = false;

                                                                                                                     for(var35 = 0; var35 < var82.length(); ++var35) {
                                                                                                                        var79 = var82.charAt(var35);
                                                                                                                        if(var79 == 60) {
                                                                                                                           var63 = true;
                                                                                                                        } else if(var79 == 62) {
                                                                                                                           var63 = false;
                                                                                                                        } else if(!var63) {
                                                                                                                           var58.append(var79);
                                                                                                                        }
                                                                                                                     }

                                                                                                                     class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var58.toString();
                                                                                                                     var15 = 1;
                                                                                                                  }
                                                                                                               }
                                                                                                            }

                                                                                                            var14 = var15;
                                                                                                         } else if(var57 < 4300) {
                                                                                                            if(var57 == 4200) {
                                                                                                               var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                               class83.scriptStringStack[++class83.scriptStringStackSize - 1] = class10.getItemDefinition(var16).name;
                                                                                                               var15 = 1;
                                                                                                            } else {
                                                                                                               ItemComposition var95;
                                                                                                               if(var57 == 4201) {
                                                                                                                  BufferProvider.intStackSize -= 2;
                                                                                                                  var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                                  var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                                  var95 = class10.getItemDefinition(var16);
                                                                                                                  if(var34 >= 1 && var34 <= 5 && var95.groundActions[var34 - 1] != null) {
                                                                                                                     class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var95.groundActions[var34 - 1];
                                                                                                                  } else {
                                                                                                                     class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var57 == 4202) {
                                                                                                                  BufferProvider.intStackSize -= 2;
                                                                                                                  var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                                  var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                                  var95 = class10.getItemDefinition(var16);
                                                                                                                  if(var34 >= 1 && var34 <= 5 && var95.inventoryActions[var34 - 1] != null) {
                                                                                                                     class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var95.inventoryActions[var34 - 1];
                                                                                                                  } else {
                                                                                                                     class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var57 == 4203) {
                                                                                                                  var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = class10.getItemDefinition(var16).price;
                                                                                                                  var15 = 1;
                                                                                                               } else if(var57 == 4204) {
                                                                                                                  var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = class10.getItemDefinition(var16).isStackable == 1?1:0;
                                                                                                                  var15 = 1;
                                                                                                               } else {
                                                                                                                  ItemComposition var62;
                                                                                                                  if(var57 == 4205) {
                                                                                                                     var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                     var62 = class10.getItemDefinition(var16);
                                                                                                                     if(var62.notedTemplate == -1 && var62.note >= 0) {
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = var62.note;
                                                                                                                     } else {
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = var16;
                                                                                                                     }

                                                                                                                     var15 = 1;
                                                                                                                  } else if(var57 == 4206) {
                                                                                                                     var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                     var62 = class10.getItemDefinition(var16);
                                                                                                                     if(var62.notedTemplate >= 0 && var62.note >= 0) {
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = var62.note;
                                                                                                                     } else {
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = var16;
                                                                                                                     }

                                                                                                                     var15 = 1;
                                                                                                                  } else if(var57 == 4207) {
                                                                                                                     var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = class10.getItemDefinition(var16).isMembers?1:0;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var57 == 4208) {
                                                                                                                     var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                     var62 = class10.getItemDefinition(var16);
                                                                                                                     if(var62.field3492 == -1 && var62.field3516 >= 0) {
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = var62.field3516;
                                                                                                                     } else {
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = var16;
                                                                                                                     }

                                                                                                                     var15 = 1;
                                                                                                                  } else if(var57 == 4209) {
                                                                                                                     var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                     var62 = class10.getItemDefinition(var16);
                                                                                                                     if(var62.field3492 >= 0 && var62.field3516 >= 0) {
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = var62.field3516;
                                                                                                                     } else {
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = var16;
                                                                                                                     }

                                                                                                                     var15 = 1;
                                                                                                                  } else if(var57 == 4210) {
                                                                                                                     var82 = class83.scriptStringStack[--class83.scriptStringStackSize];
                                                                                                                     var34 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                     MilliTimer.method2851(var82, var34 == 1);
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = WorldMapType3.field380;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var57 != 4211) {
                                                                                                                     if(var57 == 4212) {
                                                                                                                        class83.field1334 = 0;
                                                                                                                        var15 = 1;
                                                                                                                     } else {
                                                                                                                        var15 = 2;
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     if(WorldMapType3.field361 != null && class83.field1334 < WorldMapType3.field380) {
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = WorldMapType3.field361[++class83.field1334 - 1] & '\uffff';
                                                                                                                     } else {
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                                                                                                                     }

                                                                                                                     var15 = 1;
                                                                                                                  }
                                                                                                               }
                                                                                                            }

                                                                                                            var14 = var15;
                                                                                                         } else if(var57 < 5100) {
                                                                                                            if(var57 == 5000) {
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = Client.field1017;
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 5001) {
                                                                                                               BufferProvider.intStackSize -= 3;
                                                                                                               Client.field1017 = class83.intStack[BufferProvider.intStackSize];
                                                                                                               class51.field654 = CombatInfo1.method1505(class83.intStack[BufferProvider.intStackSize + 1]);
                                                                                                               if(class51.field654 == null) {
                                                                                                                  class51.field654 = class276.field3718;
                                                                                                               }

                                                                                                               Client.field1003 = class83.intStack[BufferProvider.intStackSize + 2];
                                                                                                               Client.secretPacketBuffer1.putOpcode(5);
                                                                                                               Client.secretPacketBuffer1.putByte(Client.field1017);
                                                                                                               Client.secretPacketBuffer1.putByte(class51.field654.field3721);
                                                                                                               Client.secretPacketBuffer1.putByte(Client.field1003);
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 5002) {
                                                                                                               var82 = class83.scriptStringStack[--class83.scriptStringStackSize];
                                                                                                               BufferProvider.intStackSize -= 2;
                                                                                                               var34 = class83.intStack[BufferProvider.intStackSize];
                                                                                                               var18 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                               Client.secretPacketBuffer1.putOpcode(247);
                                                                                                               Client.secretPacketBuffer1.putByte(class15.getLength(var82) + 2);
                                                                                                               Client.secretPacketBuffer1.putString(var82);
                                                                                                               Client.secretPacketBuffer1.putByte(var34 - 1);
                                                                                                               Client.secretPacketBuffer1.putByte(var18);
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 5003) {
                                                                                                               BufferProvider.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                               var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                               ChatLineBuffer var71 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var16));
                                                                                                               MessageNode var101 = var71.method1803(var34);
                                                                                                               if(var101 != null) {
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = var101.id;
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = var101.tick;
                                                                                                                  class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var101.name != null?var101.name:"";
                                                                                                                  class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var101.sender != null?var101.sender:"";
                                                                                                                  class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var101.value != null?var101.value:"";
                                                                                                               } else {
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                                                                                                                  class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                                                                                                                  class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                                                                                                                  class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 5004) {
                                                                                                               var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                               MessageNode var66 = class35.method483(var16);
                                                                                                               if(var66 != null) {
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = var66.type;
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = var66.tick;
                                                                                                                  class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var66.name != null?var66.name:"";
                                                                                                                  class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var66.sender != null?var66.sender:"";
                                                                                                                  class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var66.value != null?var66.value:"";
                                                                                                               } else {
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                                                                                                                  class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                                                                                                                  class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                                                                                                                  class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 5005) {
                                                                                                               if(class51.field654 == null) {
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                                                                                                               } else {
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = class51.field654.field3721;
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 5008) {
                                                                                                               var82 = class83.scriptStringStack[--class83.scriptStringStackSize];
                                                                                                               var34 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                               String var97 = var82.toLowerCase();
                                                                                                               byte var104 = 0;
                                                                                                               if(var97.startsWith("yellow:")) {
                                                                                                                  var104 = 0;
                                                                                                                  var82 = var82.substring("yellow:".length());
                                                                                                               } else if(var97.startsWith("red:")) {
                                                                                                                  var104 = 1;
                                                                                                                  var82 = var82.substring("red:".length());
                                                                                                               } else if(var97.startsWith("green:")) {
                                                                                                                  var104 = 2;
                                                                                                                  var82 = var82.substring("green:".length());
                                                                                                               } else if(var97.startsWith("cyan:")) {
                                                                                                                  var104 = 3;
                                                                                                                  var82 = var82.substring("cyan:".length());
                                                                                                               } else if(var97.startsWith("purple:")) {
                                                                                                                  var104 = 4;
                                                                                                                  var82 = var82.substring("purple:".length());
                                                                                                               } else if(var97.startsWith("white:")) {
                                                                                                                  var104 = 5;
                                                                                                                  var82 = var82.substring("white:".length());
                                                                                                               } else if(var97.startsWith("flash1:")) {
                                                                                                                  var104 = 6;
                                                                                                                  var82 = var82.substring("flash1:".length());
                                                                                                               } else if(var97.startsWith("flash2:")) {
                                                                                                                  var104 = 7;
                                                                                                                  var82 = var82.substring("flash2:".length());
                                                                                                               } else if(var97.startsWith("flash3:")) {
                                                                                                                  var104 = 8;
                                                                                                                  var82 = var82.substring("flash3:".length());
                                                                                                               } else if(var97.startsWith("glow1:")) {
                                                                                                                  var104 = 9;
                                                                                                                  var82 = var82.substring("glow1:".length());
                                                                                                               } else if(var97.startsWith("glow2:")) {
                                                                                                                  var104 = 10;
                                                                                                                  var82 = var82.substring("glow2:".length());
                                                                                                               } else if(var97.startsWith("glow3:")) {
                                                                                                                  var104 = 11;
                                                                                                                  var82 = var82.substring("glow3:".length());
                                                                                                               } else if(Client.languageId != 0) {
                                                                                                                  if(var97.startsWith("yellow:")) {
                                                                                                                     var104 = 0;
                                                                                                                     var82 = var82.substring("yellow:".length());
                                                                                                                  } else if(var97.startsWith("red:")) {
                                                                                                                     var104 = 1;
                                                                                                                     var82 = var82.substring("red:".length());
                                                                                                                  } else if(var97.startsWith("green:")) {
                                                                                                                     var104 = 2;
                                                                                                                     var82 = var82.substring("green:".length());
                                                                                                                  } else if(var97.startsWith("cyan:")) {
                                                                                                                     var104 = 3;
                                                                                                                     var82 = var82.substring("cyan:".length());
                                                                                                                  } else if(var97.startsWith("purple:")) {
                                                                                                                     var104 = 4;
                                                                                                                     var82 = var82.substring("purple:".length());
                                                                                                                  } else if(var97.startsWith("white:")) {
                                                                                                                     var104 = 5;
                                                                                                                     var82 = var82.substring("white:".length());
                                                                                                                  } else if(var97.startsWith("flash1:")) {
                                                                                                                     var104 = 6;
                                                                                                                     var82 = var82.substring("flash1:".length());
                                                                                                                  } else if(var97.startsWith("flash2:")) {
                                                                                                                     var104 = 7;
                                                                                                                     var82 = var82.substring("flash2:".length());
                                                                                                                  } else if(var97.startsWith("flash3:")) {
                                                                                                                     var104 = 8;
                                                                                                                     var82 = var82.substring("flash3:".length());
                                                                                                                  } else if(var97.startsWith("glow1:")) {
                                                                                                                     var104 = 9;
                                                                                                                     var82 = var82.substring("glow1:".length());
                                                                                                                  } else if(var97.startsWith("glow2:")) {
                                                                                                                     var104 = 10;
                                                                                                                     var82 = var82.substring("glow2:".length());
                                                                                                                  } else if(var97.startsWith("glow3:")) {
                                                                                                                     var104 = 11;
                                                                                                                     var82 = var82.substring("glow3:".length());
                                                                                                                  }
                                                                                                               }

                                                                                                               var97 = var82.toLowerCase();
                                                                                                               byte var80 = 0;
                                                                                                               if(var97.startsWith("wave:")) {
                                                                                                                  var80 = 1;
                                                                                                                  var82 = var82.substring("wave:".length());
                                                                                                               } else if(var97.startsWith("wave2:")) {
                                                                                                                  var80 = 2;
                                                                                                                  var82 = var82.substring("wave2:".length());
                                                                                                               } else if(var97.startsWith("shake:")) {
                                                                                                                  var80 = 3;
                                                                                                                  var82 = var82.substring("shake:".length());
                                                                                                               } else if(var97.startsWith("scroll:")) {
                                                                                                                  var80 = 4;
                                                                                                                  var82 = var82.substring("scroll:".length());
                                                                                                               } else if(var97.startsWith("slide:")) {
                                                                                                                  var80 = 5;
                                                                                                                  var82 = var82.substring("slide:".length());
                                                                                                               } else if(Client.languageId != 0) {
                                                                                                                  if(var97.startsWith("wave:")) {
                                                                                                                     var80 = 1;
                                                                                                                     var82 = var82.substring("wave:".length());
                                                                                                                  } else if(var97.startsWith("wave2:")) {
                                                                                                                     var80 = 2;
                                                                                                                     var82 = var82.substring("wave2:".length());
                                                                                                                  } else if(var97.startsWith("shake:")) {
                                                                                                                     var80 = 3;
                                                                                                                     var82 = var82.substring("shake:".length());
                                                                                                                  } else if(var97.startsWith("scroll:")) {
                                                                                                                     var80 = 4;
                                                                                                                     var82 = var82.substring("scroll:".length());
                                                                                                                  } else if(var97.startsWith("slide:")) {
                                                                                                                     var80 = 5;
                                                                                                                     var82 = var82.substring("slide:".length());
                                                                                                                  }
                                                                                                               }

                                                                                                               Client.secretPacketBuffer1.putOpcode(77);
                                                                                                               Client.secretPacketBuffer1.putByte(0);
                                                                                                               var48 = Client.secretPacketBuffer1.offset;
                                                                                                               Client.secretPacketBuffer1.putByte(var34);
                                                                                                               Client.secretPacketBuffer1.putByte(var104);
                                                                                                               Client.secretPacketBuffer1.putByte(var80);
                                                                                                               PacketBuffer var98 = Client.secretPacketBuffer1;
                                                                                                               var23 = var98.offset;
                                                                                                               byte[] var50 = class272.method4794(var82);
                                                                                                               var98.putShortSmart(var50.length);
                                                                                                               var98.offset += class265.field3642.compress(var50, 0, var50.length, var98.payload, var98.offset);
                                                                                                               Client.secretPacketBuffer1.putLength(Client.secretPacketBuffer1.offset - var48);
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 5009) {
                                                                                                               class83.scriptStringStackSize -= 2;
                                                                                                               var82 = class83.scriptStringStack[class83.scriptStringStackSize];
                                                                                                               var59 = class83.scriptStringStack[class83.scriptStringStackSize + 1];
                                                                                                               Client.secretPacketBuffer1.putOpcode(142);
                                                                                                               Client.secretPacketBuffer1.putShort(0);
                                                                                                               var18 = Client.secretPacketBuffer1.offset;
                                                                                                               Client.secretPacketBuffer1.putString(var82);
                                                                                                               PacketBuffer var70 = Client.secretPacketBuffer1;
                                                                                                               var20 = var70.offset;
                                                                                                               var65 = class272.method4794(var59);
                                                                                                               var70.putShortSmart(var65.length);
                                                                                                               var70.offset += class265.field3642.compress(var65, 0, var65.length, var70.payload, var70.offset);
                                                                                                               Client.secretPacketBuffer1.putShortLength(Client.secretPacketBuffer1.offset - var18);
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 != 5015) {
                                                                                                               if(var57 == 5016) {
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = Client.field1003;
                                                                                                                  var15 = 1;
                                                                                                               } else if(var57 == 5017) {
                                                                                                                  var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = MouseInput.method949(var16);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var57 == 5018) {
                                                                                                                  var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = DecorativeObject.method2831(var16);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var57 == 5019) {
                                                                                                                  var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                  var17 = class83.intStack;
                                                                                                                  var18 = ++BufferProvider.intStackSize - 1;
                                                                                                                  MessageNode var99 = (MessageNode)class98.field1495.get((long)var16);
                                                                                                                  if(var99 == null) {
                                                                                                                     var35 = -1;
                                                                                                                  } else if(var99.next == class98.field1493.field2456) {
                                                                                                                     var35 = -1;
                                                                                                                  } else {
                                                                                                                     var35 = ((MessageNode)var99.next).id;
                                                                                                                  }

                                                                                                                  var17[var18] = var35;
                                                                                                                  var15 = 1;
                                                                                                               } else if(var57 == 5020) {
                                                                                                                  var82 = class83.scriptStringStack[--class83.scriptStringStackSize];
                                                                                                                  if(var82.equalsIgnoreCase("toggleroof")) {
                                                                                                                     class34.preferences.hideRoofs = !class34.preferences.hideRoofs;
                                                                                                                     class10.method51();
                                                                                                                     if(class34.preferences.hideRoofs) {
                                                                                                                        Item.sendGameMessage(99, "", "Roofs are now all hidden");
                                                                                                                     } else {
                                                                                                                        Item.sendGameMessage(99, "", "Roofs will only be removed selectively");
                                                                                                                     }
                                                                                                                  }

                                                                                                                  if(var82.equalsIgnoreCase("displayfps")) {
                                                                                                                     Client.displayFps = !Client.displayFps;
                                                                                                                  }

                                                                                                                  if(var82.equalsIgnoreCase("clickbox")) {
                                                                                                                     Model.field1939 = !Model.field1939;
                                                                                                                     Item.sendGameMessage(99, "", "Clickbox Mode: " + (Model.field1939?"AABB":"Legacy"));
                                                                                                                  }

                                                                                                                  if(Client.rights >= 2) {
                                                                                                                     if(var82.equalsIgnoreCase("aabb")) {
                                                                                                                        if(!class7.field225) {
                                                                                                                           class7.field225 = true;
                                                                                                                           class7.field224 = class11.field253;
                                                                                                                           Item.sendGameMessage(99, "", "AABB boxes: All");
                                                                                                                        } else if(class7.field224 == class11.field253) {
                                                                                                                           class7.field225 = true;
                                                                                                                           class7.field224 = class11.field255;
                                                                                                                           Item.sendGameMessage(99, "", "AABB boxes: Mouse Over");
                                                                                                                        } else {
                                                                                                                           class7.field225 = false;
                                                                                                                           Item.sendGameMessage(99, "", "AABB boxes: Off");
                                                                                                                        }
                                                                                                                     }

                                                                                                                     if(var82.equalsIgnoreCase("legacyboxes")) {
                                                                                                                        class7.field220 = !class7.field220;
                                                                                                                        Item.sendGameMessage(99, "", "Show legacy boxes: " + class7.field220);
                                                                                                                     }

                                                                                                                     if(var82.equalsIgnoreCase("geotests")) {
                                                                                                                        class7.field221 = !class7.field221;
                                                                                                                        Item.sendGameMessage(99, "", "Show geometry tests: " + class7.field221);
                                                                                                                     }

                                                                                                                     if(var82.equalsIgnoreCase("fpson")) {
                                                                                                                        Client.displayFps = true;
                                                                                                                     }

                                                                                                                     if(var82.equalsIgnoreCase("fpsoff")) {
                                                                                                                        Client.displayFps = false;
                                                                                                                     }

                                                                                                                     if(var82.equalsIgnoreCase("gc")) {
                                                                                                                        System.gc();
                                                                                                                     }

                                                                                                                     if(var82.equalsIgnoreCase("clientdrop")) {
                                                                                                                        if(Client.field967 > 0) {
                                                                                                                           class48.method674();
                                                                                                                        } else {
                                                                                                                           class152.setGameState(40);
                                                                                                                           class56.field680 = class13.rssocket;
                                                                                                                           class13.rssocket = null;
                                                                                                                        }
                                                                                                                     }

                                                                                                                     if(var82.equalsIgnoreCase("errortest") && Client.socketType == 2) {
                                                                                                                        throw new RuntimeException();
                                                                                                                     }
                                                                                                                  }

                                                                                                                  Client.secretPacketBuffer1.putOpcode(60);
                                                                                                                  Client.secretPacketBuffer1.putByte(var82.length() + 1);
                                                                                                                  Client.secretPacketBuffer1.putString(var82);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var57 == 5021) {
                                                                                                                  Client.field1122 = class83.scriptStringStack[--class83.scriptStringStackSize].toLowerCase().trim();
                                                                                                                  var15 = 1;
                                                                                                               } else if(var57 == 5022) {
                                                                                                                  class83.scriptStringStack[++class83.scriptStringStackSize - 1] = Client.field1122;
                                                                                                                  var15 = 1;
                                                                                                               } else {
                                                                                                                  var15 = 2;
                                                                                                               }
                                                                                                            } else {
                                                                                                               if(class226.localPlayer != null && class226.localPlayer.name != null) {
                                                                                                                  var82 = class226.localPlayer.name;
                                                                                                               } else {
                                                                                                                  var82 = "";
                                                                                                               }

                                                                                                               class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var82;
                                                                                                               var15 = 1;
                                                                                                            }

                                                                                                            var14 = var15;
                                                                                                         } else if(var57 < 5400) {
                                                                                                            if(var57 == 5306) {
                                                                                                               var86 = class83.intStack;
                                                                                                               var34 = ++BufferProvider.intStackSize - 1;
                                                                                                               var18 = Client.isResized?2:1;
                                                                                                               var86[var34] = var18;
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 5307) {
                                                                                                               var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                               if(var16 == 1 || var16 == 2) {
                                                                                                                  Client.field1050 = 0L;
                                                                                                                  if(var16 >= 2) {
                                                                                                                     Client.isResized = true;
                                                                                                                  } else {
                                                                                                                     Client.isResized = false;
                                                                                                                  }

                                                                                                                  var34 = Client.isResized?2:1;
                                                                                                                  if(var34 == 1) {
                                                                                                                     CombatInfoListHolder.clientInstance.method916(765, 503);
                                                                                                                  } else {
                                                                                                                     CombatInfoListHolder.clientInstance.method916(7680, 2160);
                                                                                                                  }

                                                                                                                  if(Client.gameState >= 25) {
                                                                                                                     XItemContainer.method1031();
                                                                                                                  }
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 5308) {
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = class34.preferences.screenType;
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 != 5309) {
                                                                                                               var15 = 2;
                                                                                                            } else {
                                                                                                               var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                               if(var16 == 1 || var16 == 2) {
                                                                                                                  class34.preferences.screenType = var16;
                                                                                                                  class10.method51();
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            }

                                                                                                            var14 = var15;
                                                                                                         } else if(var57 < 5600) {
                                                                                                            if(var57 == 5504) {
                                                                                                               BufferProvider.intStackSize -= 2;
                                                                                                               var35 = class83.intStack[BufferProvider.intStackSize];
                                                                                                               var20 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                               if(!Client.field1008) {
                                                                                                                  Client.field987 = var35;
                                                                                                                  Client.mapAngle = var20;
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 5505) {
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = Client.field987;
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 5506) {
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = Client.mapAngle;
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 5530) {
                                                                                                               var35 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                               if(var35 < 0) {
                                                                                                                  var35 = 0;
                                                                                                               }

                                                                                                               Client.field993 = var35;
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 5531) {
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = Client.field993;
                                                                                                               var15 = 1;
                                                                                                            } else {
                                                                                                               var15 = 2;
                                                                                                            }

                                                                                                            var14 = var15;
                                                                                                         } else if(var57 < 5700) {
                                                                                                            var14 = class168.method3058(var57, var3, var60);
                                                                                                         } else if(var57 < 6300) {
                                                                                                            if(var57 == 6200) {
                                                                                                               BufferProvider.intStackSize -= 2;
                                                                                                               Client.field1163 = (short)class83.intStack[BufferProvider.intStackSize];
                                                                                                               if(Client.field1163 <= 0) {
                                                                                                                  Client.field1163 = 256;
                                                                                                               }

                                                                                                               Client.field1157 = (short)class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                               if(Client.field1157 <= 0) {
                                                                                                                  Client.field1157 = 205;
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 6201) {
                                                                                                               BufferProvider.intStackSize -= 2;
                                                                                                               Client.field1158 = (short)class83.intStack[BufferProvider.intStackSize];
                                                                                                               if(Client.field1158 <= 0) {
                                                                                                                  Client.field1158 = 256;
                                                                                                               }

                                                                                                               Client.field1159 = (short)class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                               if(Client.field1159 <= 0) {
                                                                                                                  Client.field1159 = 320;
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 6202) {
                                                                                                               BufferProvider.intStackSize -= 4;
                                                                                                               Client.field913 = (short)class83.intStack[BufferProvider.intStackSize];
                                                                                                               if(Client.field913 <= 0) {
                                                                                                                  Client.field913 = 1;
                                                                                                               }

                                                                                                               Client.field979 = (short)class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                               if(Client.field979 <= 0) {
                                                                                                                  Client.field979 = 32767;
                                                                                                               } else if(Client.field979 < Client.field913) {
                                                                                                                  Client.field979 = Client.field913;
                                                                                                               }

                                                                                                               Client.field1162 = (short)class83.intStack[BufferProvider.intStackSize + 2];
                                                                                                               if(Client.field1162 <= 0) {
                                                                                                                  Client.field1162 = 1;
                                                                                                               }

                                                                                                               Client.field965 = (short)class83.intStack[BufferProvider.intStackSize + 3];
                                                                                                               if(Client.field965 <= 0) {
                                                                                                                  Client.field965 = 32767;
                                                                                                               } else if(Client.field965 < Client.field1162) {
                                                                                                                  Client.field965 = Client.field1162;
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 6203) {
                                                                                                               if(Client.field977 != null) {
                                                                                                                  class20.method150(0, 0, Client.field977.width, Client.field977.height, false);
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = Client.viewportHeight;
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = Client.viewportWidth;
                                                                                                               } else {
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                                                                                                                  class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 6204) {
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = Client.field1158;
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = Client.field1159;
                                                                                                               var15 = 1;
                                                                                                            } else if(var57 == 6205) {
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = Client.field1163;
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = Client.field1157;
                                                                                                               var15 = 1;
                                                                                                            } else {
                                                                                                               var15 = 2;
                                                                                                            }

                                                                                                            var14 = var15;
                                                                                                         } else if(var57 < 6600) {
                                                                                                            if(var57 == 6500) {
                                                                                                               class83.intStack[++BufferProvider.intStackSize - 1] = class67.loadWorlds()?1:0;
                                                                                                               var15 = 1;
                                                                                                            } else {
                                                                                                               World var106;
                                                                                                               if(var57 == 6501) {
                                                                                                                  World.field1283 = 0;
                                                                                                                  var106 = class90.method1658();
                                                                                                                  if(var106 != null) {
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = var106.id;
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = var106.mask;
                                                                                                                     class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var106.activity;
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = var106.location;
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = var106.playerCount;
                                                                                                                     class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var106.address;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                                                                                                                     class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                                                                                                                     class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var57 == 6502) {
                                                                                                                  var106 = class90.method1658();
                                                                                                                  if(var106 != null) {
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = var106.id;
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = var106.mask;
                                                                                                                     class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var106.activity;
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = var106.location;
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = var106.playerCount;
                                                                                                                     class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var106.address;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                                                                                                                     class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                                                                                                                     class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                                                                                                                     class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else {
                                                                                                                  World var68;
                                                                                                                  if(var57 == 6506) {
                                                                                                                     var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                     var68 = null;

                                                                                                                     for(var18 = 0; var18 < World.worldCount; ++var18) {
                                                                                                                        if(var16 == class64.worldList[var18].id) {
                                                                                                                           var68 = class64.worldList[var18];
                                                                                                                           break;
                                                                                                                        }
                                                                                                                     }

                                                                                                                     if(var68 != null) {
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = var68.id;
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = var68.mask;
                                                                                                                        class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var68.activity;
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = var68.location;
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = var68.playerCount;
                                                                                                                        class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var68.address;
                                                                                                                     } else {
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                                                                                                                        class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                                                                                                                        class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var15 = 1;
                                                                                                                  } else if(var57 == 6507) {
                                                                                                                     BufferProvider.intStackSize -= 4;
                                                                                                                     var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                                     boolean var105 = class83.intStack[1 + BufferProvider.intStackSize] == 1;
                                                                                                                     var18 = class83.intStack[BufferProvider.intStackSize + 2];
                                                                                                                     var90 = class83.intStack[BufferProvider.intStackSize + 3] == 1;
                                                                                                                     Preferences.method1551(var16, var105, var18, var90);
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var57 != 6511) {
                                                                                                                     if(var57 == 6512) {
                                                                                                                        Client.field1097 = class83.intStack[--BufferProvider.intStackSize] == 1;
                                                                                                                        var15 = 1;
                                                                                                                     } else {
                                                                                                                        class251 var102;
                                                                                                                        if(var57 == 6513) {
                                                                                                                           BufferProvider.intStackSize -= 2;
                                                                                                                           var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                                           var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                                           var102 = Varbit.method4309(var34);
                                                                                                                           if(var102.method4325()) {
                                                                                                                              class83.scriptStringStack[++class83.scriptStringStackSize - 1] = WorldMapType3.getNpcDefinition(var16).method4519(var34, var102.field3363);
                                                                                                                           } else {
                                                                                                                              class83.intStack[++BufferProvider.intStackSize - 1] = WorldMapType3.getNpcDefinition(var16).method4524(var34, var102.field3360);
                                                                                                                           }

                                                                                                                           var15 = 1;
                                                                                                                        } else if(var57 == 6514) {
                                                                                                                           BufferProvider.intStackSize -= 2;
                                                                                                                           var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                                           var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                                           var102 = Varbit.method4309(var34);
                                                                                                                           if(var102.method4325()) {
                                                                                                                              class83.scriptStringStack[++class83.scriptStringStackSize - 1] = class169.getObjectDefinition(var16).method4441(var34, var102.field3363);
                                                                                                                           } else {
                                                                                                                              class83.intStack[++BufferProvider.intStackSize - 1] = class169.getObjectDefinition(var16).method4432(var34, var102.field3360);
                                                                                                                           }

                                                                                                                           var15 = 1;
                                                                                                                        } else if(var57 == 6515) {
                                                                                                                           BufferProvider.intStackSize -= 2;
                                                                                                                           var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                                           var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                                           var102 = Varbit.method4309(var34);
                                                                                                                           if(var102.method4325()) {
                                                                                                                              class83.scriptStringStack[++class83.scriptStringStackSize - 1] = class10.getItemDefinition(var16).method4478(var34, var102.field3363);
                                                                                                                           } else {
                                                                                                                              class83.intStack[++BufferProvider.intStackSize - 1] = class10.getItemDefinition(var16).method4455(var34, var102.field3360);
                                                                                                                           }

                                                                                                                           var15 = 1;
                                                                                                                        } else if(var57 == 6516) {
                                                                                                                           BufferProvider.intStackSize -= 2;
                                                                                                                           var16 = class83.intStack[BufferProvider.intStackSize];
                                                                                                                           var34 = class83.intStack[BufferProvider.intStackSize + 1];
                                                                                                                           var102 = Varbit.method4309(var34);
                                                                                                                           byte[] var49;
                                                                                                                           class252 var78;
                                                                                                                           class252 var100;
                                                                                                                           if(var102.method4325()) {
                                                                                                                              String[] var73 = class83.scriptStringStack;
                                                                                                                              var20 = ++class83.scriptStringStackSize - 1;
                                                                                                                              var100 = (class252)class252.field3368.get((long)var16);
                                                                                                                              if(var100 != null) {
                                                                                                                                 var78 = var100;
                                                                                                                              } else {
                                                                                                                                 var49 = class252.field3370.getConfigData(34, var16);
                                                                                                                                 var100 = new class252();
                                                                                                                                 if(var49 != null) {
                                                                                                                                    var100.method4337(new Buffer(var49));
                                                                                                                                 }

                                                                                                                                 var100.method4333();
                                                                                                                                 class252.field3368.put(var100, (long)var16);
                                                                                                                                 var78 = var100;
                                                                                                                              }

                                                                                                                              var73[var20] = var78.method4347(var34, var102.field3363);
                                                                                                                           } else {
                                                                                                                              int[] var75 = class83.intStack;
                                                                                                                              var20 = ++BufferProvider.intStackSize - 1;
                                                                                                                              var100 = (class252)class252.field3368.get((long)var16);
                                                                                                                              if(var100 != null) {
                                                                                                                                 var78 = var100;
                                                                                                                              } else {
                                                                                                                                 var49 = class252.field3370.getConfigData(34, var16);
                                                                                                                                 var100 = new class252();
                                                                                                                                 if(var49 != null) {
                                                                                                                                    var100.method4337(new Buffer(var49));
                                                                                                                                 }

                                                                                                                                 var100.method4333();
                                                                                                                                 class252.field3368.put(var100, (long)var16);
                                                                                                                                 var78 = var100;
                                                                                                                              }

                                                                                                                              var75[var20] = var78.method4336(var34, var102.field3360);
                                                                                                                           }

                                                                                                                           var15 = 1;
                                                                                                                        } else {
                                                                                                                           var15 = 2;
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     var16 = class83.intStack[--BufferProvider.intStackSize];
                                                                                                                     if(var16 >= 0 && var16 < World.worldCount) {
                                                                                                                        var68 = class64.worldList[var16];
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = var68.id;
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = var68.mask;
                                                                                                                        class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var68.activity;
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = var68.location;
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = var68.playerCount;
                                                                                                                        class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var68.address;
                                                                                                                     } else {
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                                                                                                                        class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                                                                                                                        class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                                                                                                                        class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var15 = 1;
                                                                                                                  }
                                                                                                               }
                                                                                                            }

                                                                                                            var14 = var15;
                                                                                                         } else if(var57 < 6700) {
                                                                                                            var14 = class41.method565(var57, var3, var60);
                                                                                                         } else {
                                                                                                            var14 = 2;
                                                                                                         }
                                                                                                      }
                                                                                                   }
                                                                                                }
                                                                                             }

                                                                                             switch(var14) {
                                                                                             case 0:
                                                                                                return;
                                                                                             case 1:
                                                                                             default:
                                                                                                break;
                                                                                             case 2:
                                                                                                throw new IllegalStateException();
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
                           }
                        }
                     }
                  }
               }
            }
         } catch (Exception var54) {
            StringBuilder var53 = new StringBuilder(30);
            var53.append("").append(var3.hash).append(" ");

            for(var12 = class83.scriptStackCount - 1; var12 >= 0; --var12) {
               var53.append("").append(class83.scriptStack[var12].invokedFromScript.hash).append(" ");
            }

            var53.append("").append(var9);
            WorldMapType2.method495(var53.toString(), var54);
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "-87"
   )
   public static final void method115(int var0, int var1, int var2, int var3, int var4) {
      class7.field219.method3509(new class8(var0, var1, var2, var3, var4));
   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-507520037"
   )
   static final void method124(int var0, int var1, int var2, int var3) {
      ++Client.field1021;
      class24.method170(class66.field810);
      boolean var4 = false;
      int var5;
      int var7;
      if(Client.field1033 >= 0) {
         var5 = class96.field1469;
         int[] var6 = class96.field1470;

         for(var7 = 0; var7 < var5; ++var7) {
            if(var6[var7] == Client.field1033) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         class24.method170(class66.field808);
      }

      GraphicsObject.method1620(true);
      class24.method170(var4?class66.field809:class66.field811);
      GraphicsObject.method1620(false);

      for(Projectile var28 = (Projectile)Client.projectiles.getFront(); var28 != null; var28 = (Projectile)Client.projectiles.getNext()) {
         if(var28.floor == class10.plane && Client.gameCycle <= var28.cycle) {
            if(Client.gameCycle >= var28.startTime) {
               if(var28.interacting > 0) {
                  NPC var34 = Client.cachedNPCs[var28.interacting - 1];
                  if(var34 != null && var34.x >= 0 && var34.x < 13312 && var34.y >= 0 && var34.y < 13312) {
                     var28.method1696(var34.x, var34.y, class23.getTileHeight(var34.x, var34.y, var28.floor) - var28.endHeight, Client.gameCycle);
                  }
               }

               if(var28.interacting < 0) {
                  var7 = -var28.interacting - 1;
                  Player var35;
                  if(var7 == Client.localInteractingIndex) {
                     var35 = class226.localPlayer;
                  } else {
                     var35 = Client.cachedPlayers[var7];
                  }

                  if(var35 != null && var35.x >= 0 && var35.x < 13312 && var35.y >= 0 && var35.y < 13312) {
                     var28.method1696(var35.x, var35.y, class23.getTileHeight(var35.x, var35.y, var28.floor) - var28.endHeight, Client.gameCycle);
                  }
               }

               var28.method1701(Client.field1066);
               class19.region.method2671(class10.plane, (int)var28.x, (int)var28.velocityZ, (int)var28.z, 60, var28, var28.rotationX, -1, false);
            }
         } else {
            var28.unlink();
         }
      }

      for(GraphicsObject var37 = (GraphicsObject)Client.graphicsObjectDeque.getFront(); var37 != null; var37 = (GraphicsObject)Client.graphicsObjectDeque.getNext()) {
         if(var37.level == class10.plane && !var37.finished) {
            if(Client.gameCycle >= var37.startCycle) {
               var37.method1612(Client.field1066);
               if(var37.finished) {
                  var37.unlink();
               } else {
                  class19.region.method2671(var37.level, var37.x, var37.y, var37.height, 60, var37, 0, -1, false);
               }
            }
         } else {
            var37.unlink();
         }
      }

      class20.method150(var0, var1, var2, var3, true);
      var0 = Client.field1164;
      var1 = Client.field1165;
      var2 = Client.viewportHeight;
      var3 = Client.viewportWidth;
      Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
      Graphics3D.method2524();
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var18;
      int var29;
      if(!Client.field1008) {
         var5 = Client.field987;
         if(Client.field996 / 256 > var5) {
            var5 = Client.field996 / 256;
         }

         if(Client.field959[4] && Client.field1153[4] + 128 > var5) {
            var5 = Client.field1153[4] + 128;
         }

         var29 = Client.mapAngle & 2047;
         var7 = class232.field3168;
         var8 = class23.getTileHeight(class226.localPlayer.x, class226.localPlayer.y, class10.plane) - Client.field993;
         var9 = class155.field2213;
         var10 = var5 * 3 + 600;
         var11 = 2048 - var5 & 2047;
         var12 = 2048 - var29 & 2047;
         var13 = 0;
         var14 = 0;
         var15 = var10;
         int var17;
         if(var11 != 0) {
            var16 = Graphics3D.SINE[var11];
            var17 = Graphics3D.COSINE[var11];
            var18 = var14 * var17 - var10 * var16 >> 16;
            var15 = var17 * var10 + var16 * var14 >> 16;
            var14 = var18;
         }

         if(var12 != 0) {
            var16 = Graphics3D.SINE[var12];
            var17 = Graphics3D.COSINE[var12];
            var18 = var15 * var16 + var17 * var13 >> 16;
            var15 = var15 * var17 - var16 * var13 >> 16;
            var13 = var18;
         }

         class73.cameraX = var7 - var13;
         WidgetNode.cameraZ = var8 - var14;
         Client.cameraY = var9 - var15;
         class10.cameraPitch = var5;
         class236.cameraYaw = var29;
      }

      if(!Client.field1008) {
         if(class34.preferences.hideRoofs) {
            var29 = class10.plane;
         } else {
            label700: {
               var7 = 3;
               if(class10.cameraPitch < 310) {
                  var8 = class73.cameraX >> 7;
                  var9 = Client.cameraY >> 7;
                  var10 = class226.localPlayer.x >> 7;
                  var11 = class226.localPlayer.y >> 7;
                  if(var8 < 0 || var9 < 0 || var8 >= 104 || var9 >= 104) {
                     var29 = class10.plane;
                     break label700;
                  }

                  if((class61.tileSettings[class10.plane][var8][var9] & 4) != 0) {
                     var7 = class10.plane;
                  }

                  if(var10 > var8) {
                     var12 = var10 - var8;
                  } else {
                     var12 = var8 - var10;
                  }

                  if(var11 > var9) {
                     var13 = var11 - var9;
                  } else {
                     var13 = var9 - var11;
                  }

                  if(var12 > var13) {
                     var14 = var13 * 65536 / var12;
                     var15 = '耀';

                     while(var8 != var10) {
                        if(var8 < var10) {
                           ++var8;
                        } else if(var8 > var10) {
                           --var8;
                        }

                        if((class61.tileSettings[class10.plane][var8][var9] & 4) != 0) {
                           var7 = class10.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var9 < var11) {
                              ++var9;
                           } else if(var9 > var11) {
                              --var9;
                           }

                           if((class61.tileSettings[class10.plane][var8][var9] & 4) != 0) {
                              var7 = class10.plane;
                           }
                        }
                     }
                  } else {
                     var14 = var12 * 65536 / var13;
                     var15 = '耀';

                     while(var9 != var11) {
                        if(var9 < var11) {
                           ++var9;
                        } else if(var9 > var11) {
                           --var9;
                        }

                        if((class61.tileSettings[class10.plane][var8][var9] & 4) != 0) {
                           var7 = class10.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var8 < var10) {
                              ++var8;
                           } else if(var8 > var10) {
                              --var8;
                           }

                           if((class61.tileSettings[class10.plane][var8][var9] & 4) != 0) {
                              var7 = class10.plane;
                           }
                        }
                     }
                  }
               }

               if(class226.localPlayer.x >= 0 && class226.localPlayer.y >= 0 && class226.localPlayer.x < 13312 && class226.localPlayer.y < 13312) {
                  if((class61.tileSettings[class10.plane][class226.localPlayer.x >> 7][class226.localPlayer.y >> 7] & 4) != 0) {
                     var7 = class10.plane;
                  }

                  var29 = var7;
               } else {
                  var29 = class10.plane;
               }
            }
         }

         var5 = var29;
      } else {
         var5 = class163.method2994();
      }

      var29 = class73.cameraX;
      var7 = WidgetNode.cameraZ;
      var8 = Client.cameraY;
      var9 = class10.cameraPitch;
      var10 = class236.cameraYaw;

      for(var11 = 0; var11 < 5; ++var11) {
         if(Client.field959[var11]) {
            var12 = (int)(Math.random() * (double)(Client.field1152[var11] * 2 + 1) - (double)Client.field1152[var11] + Math.sin((double)Client.field1093[var11] / 100.0D * (double)Client.field1155[var11]) * (double)Client.field1153[var11]);
            if(var11 == 0) {
               class73.cameraX += var12;
            }

            if(var11 == 1) {
               WidgetNode.cameraZ += var12;
            }

            if(var11 == 2) {
               Client.cameraY += var12;
            }

            if(var11 == 3) {
               class236.cameraYaw = var12 + class236.cameraYaw & 2047;
            }

            if(var11 == 4) {
               class10.cameraPitch += var12;
               if(class10.cameraPitch < 128) {
                  class10.cameraPitch = 128;
               }

               if(class10.cameraPitch > 383) {
                  class10.cameraPitch = 383;
               }
            }
         }
      }

      var11 = MouseInput.field730;
      var12 = MouseInput.field731;
      if(MouseInput.field729 != 0) {
         var11 = MouseInput.field737;
         var12 = MouseInput.field723;
      }

      if(var11 >= var0 && var11 < var0 + var2 && var12 >= var1 && var12 < var3 + var1) {
         var13 = var11 - var0;
         var14 = var12 - var1;
         class134.field1953 = var13;
         class134.field1948 = var14;
         class134.field1957 = true;
         class134.field1954 = 0;
         class134.field1951 = false;
      } else {
         class261.method4615();
      }

      class140.method2791();
      Rasterizer2D.method4828(var0, var1, var2, var3, 0);
      class140.method2791();
      var13 = Graphics3D.field1983;
      Graphics3D.field1983 = Client.scale;
      class19.region.draw(class73.cameraX, WidgetNode.cameraZ, Client.cameraY, class10.cameraPitch, class236.cameraYaw, var5);

      while(true) {
         class9 var30 = (class9)class7.field219.method3512();
         if(var30 == null) {
            Graphics3D.field1983 = var13;
            class140.method2791();
            class19.region.clearEntities();
            Client.field961 = 0;
            boolean var36 = false;
            var15 = -1;
            var16 = class96.field1469;
            int[] var31 = class96.field1470;

            for(var18 = 0; var18 < var16 + Client.field953; ++var18) {
               Object var19;
               if(var18 < var16) {
                  var19 = Client.cachedPlayers[var31[var18]];
                  if(var31[var18] == Client.field1033) {
                     var36 = true;
                     var15 = var18;
                     continue;
                  }
               } else {
                  var19 = Client.cachedNPCs[Client.npcIndices[var18 - var16]];
               }

               BuildType.method3997((Actor)var19, var18, var0, var1, var2, var3);
            }

            if(var36) {
               BuildType.method3997(Client.cachedPlayers[Client.field1033], var15, var0, var1, var2, var3);
            }

            for(var18 = 0; var18 < Client.field961; ++var18) {
               int var32 = Client.field999[var18];
               int var20 = Client.field1000[var18];
               int var21 = Client.field1051[var18];
               int var22 = Client.field981[var18];
               boolean var23 = true;

               while(var23) {
                  var23 = false;

                  for(int var24 = 0; var24 < var18; ++var24) {
                     if(var20 + 2 > Client.field1000[var24] - Client.field981[var24] && var20 - var22 < Client.field1000[var24] + 2 && var32 - var21 < Client.field1051[var24] + Client.field999[var24] && var21 + var32 > Client.field999[var24] - Client.field1051[var24] && Client.field1000[var24] - Client.field981[var24] < var20) {
                        var20 = Client.field1000[var24] - Client.field981[var24];
                        var23 = true;
                     }
                  }
               }

               Client.screenY = Client.field999[var18];
               Client.screenX = Client.field1000[var18] = var20;
               String var33 = Client.field1006[var18];
               if(Client.field916 == 0) {
                  int var25 = 16776960;
                  if(Client.field1087[var18] < 6) {
                     var25 = Client.field942[Client.field1087[var18]];
                  }

                  if(Client.field1087[var18] == 6) {
                     var25 = Client.field1021 % 20 < 10?16711680:16776960;
                  }

                  if(Client.field1087[var18] == 7) {
                     var25 = Client.field1021 % 20 < 10?255:'\uffff';
                  }

                  if(Client.field1087[var18] == 8) {
                     var25 = Client.field1021 % 20 < 10?'뀀':8454016;
                  }

                  int var26;
                  if(Client.field1087[var18] == 9) {
                     var26 = 150 - Client.field1005[var18];
                     if(var26 < 50) {
                        var25 = var26 * 1280 + 16711680;
                     } else if(var26 < 100) {
                        var25 = 16776960 - (var26 - 50) * 327680;
                     } else if(var26 < 150) {
                        var25 = (var26 - 100) * 5 + '\uff00';
                     }
                  }

                  if(Client.field1087[var18] == 10) {
                     var26 = 150 - Client.field1005[var18];
                     if(var26 < 50) {
                        var25 = var26 * 5 + 16711680;
                     } else if(var26 < 100) {
                        var25 = 16711935 - (var26 - 50) * 327680;
                     } else if(var26 < 150) {
                        var25 = (var26 - 100) * 327680 + 255 - (var26 - 100) * 5;
                     }
                  }

                  if(Client.field1087[var18] == 11) {
                     var26 = 150 - Client.field1005[var18];
                     if(var26 < 50) {
                        var25 = 16777215 - var26 * 327685;
                     } else if(var26 < 100) {
                        var25 = (var26 - 50) * 327685 + '\uff00';
                     } else if(var26 < 150) {
                        var25 = 16777215 - (var26 - 100) * 327680;
                     }
                  }

                  if(Client.field1004[var18] == 0) {
                     Area.field3285.method4643(var33, var0 + Client.screenY, Client.screenX + var1, var25, 0);
                  }

                  if(Client.field1004[var18] == 1) {
                     Area.field3285.method4645(var33, var0 + Client.screenY, Client.screenX + var1, var25, 0, Client.field1021);
                  }

                  if(Client.field1004[var18] == 2) {
                     Area.field3285.method4646(var33, var0 + Client.screenY, Client.screenX + var1, var25, 0, Client.field1021);
                  }

                  if(Client.field1004[var18] == 3) {
                     Area.field3285.method4724(var33, var0 + Client.screenY, Client.screenX + var1, var25, 0, Client.field1021, 150 - Client.field1005[var18]);
                  }

                  if(Client.field1004[var18] == 4) {
                     var26 = (150 - Client.field1005[var18]) * (Area.field3285.method4635(var33) + 100) / 150;
                     Rasterizer2D.setInnerDrawRegion(var0 + Client.screenY - 50, var1, Client.screenY + var0 + 50, var3 + var1);
                     Area.field3285.method4640(var33, Client.screenY + var0 + 50 - var26, Client.screenX + var1, var25, 0);
                     Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
                  }

                  if(Client.field1004[var18] == 5) {
                     var26 = 150 - Client.field1005[var18];
                     int var27 = 0;
                     if(var26 < 25) {
                        var27 = var26 - 25;
                     } else if(var26 > 125) {
                        var27 = var26 - 125;
                     }

                     Rasterizer2D.setInnerDrawRegion(var0, Client.screenX + var1 - Area.field3285.verticalSpace - 1, var0 + var2, Client.screenX + var1 + 5);
                     Area.field3285.method4643(var33, var0 + Client.screenY, var27 + Client.screenX + var1, var25, 0);
                     Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
                  }
               } else {
                  Area.field3285.method4643(var33, var0 + Client.screenY, Client.screenX + var1, 16776960, 0);
               }
            }

            FaceNormal.method2808(var0, var1);
            ((TextureProvider)Graphics3D.textureLoader).method2312(Client.field1066);
            if(Client.cursorState == 1) {
               class82.field1319[Client.field1013 / 100].method4958(Client.field1011 - 8, Client.field1012 - 8);
            }

            if(Client.cursorState == 2) {
               class82.field1319[Client.field1013 / 100 + 4].method4958(Client.field1011 - 8, Client.field1012 - 8);
            }

            Client.field1023 = 0;
            var14 = (class226.localPlayer.x >> 7) + class21.baseX;
            var15 = (class226.localPlayer.y >> 7) + class164.baseY;
            if(var14 >= 3053 && var14 <= 3156 && var15 >= 3056 && var15 <= 3136) {
               Client.field1023 = 1;
            }

            if(var14 >= 3072 && var14 <= 3118 && var15 >= 9492 && var15 <= 9535) {
               Client.field1023 = 1;
            }

            if(Client.field1023 == 1 && var14 >= 3139 && var14 <= 3199 && var15 >= 3008 && var15 <= 3062) {
               Client.field1023 = 0;
            }

            class73.cameraX = var29;
            WidgetNode.cameraZ = var7;
            Client.cameraY = var8;
            class10.cameraPitch = var9;
            class236.cameraYaw = var10;
            if(Client.field922 && class54.method753(true, false) == 0) {
               Client.field922 = false;
            }

            if(Client.field922) {
               Rasterizer2D.method4828(var0, var1, var2, var3, 0);
               class163.drawStatusBox("Loading - please wait.", false);
            }

            return;
         }

         var30.vmethod49();
      }
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(Lbt;IIII)V",
      garbageValue = "-2051297916"
   )
   static final void method127(Player var0, int var1, int var2, int var3) {
      if(class226.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            int var7;
            if(var0.totalLevel == 0) {
               String var5 = var0.actions[0] + var0.name + var0.actions[1];
               var7 = var0.combatLevel;
               int var8 = class226.localPlayer.combatLevel;
               int var9 = var8 - var7;
               String var6;
               if(var9 < -9) {
                  var6 = class8.getColTags(16711680);
               } else if(var9 < -6) {
                  var6 = class8.getColTags(16723968);
               } else if(var9 < -3) {
                  var6 = class8.getColTags(16740352);
               } else if(var9 < 0) {
                  var6 = class8.getColTags(16756736);
               } else if(var9 > 9) {
                  var6 = class8.getColTags('\uff00');
               } else if(var9 > 6) {
                  var6 = class8.getColTags(4259584);
               } else if(var9 > 3) {
                  var6 = class8.getColTags(8453888);
               } else if(var9 > 0) {
                  var6 = class8.getColTags(12648192);
               } else {
                  var6 = class8.getColTags(16776960);
               }

               var4 = var5 + var6 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.actions[2];
            }

            int var10;
            if(Client.itemSelectionState == 1) {
               class261.addMenuEntry("Use", Client.field1058 + " " + "->" + " " + class8.getColTags(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.spellSelected) {
               if((class39.field534 & 8) == 8) {
                  class261.addMenuEntry(Client.field1062, Client.field1063 + " " + "->" + " " + class8.getColTags(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var10 = 7; var10 >= 0; --var10) {
                  if(Client.playerOptions[var10] != null) {
                     short var11 = 0;
                     if(Client.playerOptions[var10].equalsIgnoreCase("Attack")) {
                        if(class91.field1393 == Client.field940) {
                           continue;
                        }

                        if(class91.field1387 == Client.field940 || class91.field1386 == Client.field940 && var0.combatLevel > class226.localPlayer.combatLevel) {
                           var11 = 2000;
                        }

                        if(class226.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == class226.localPlayer.team) {
                              var11 = 2000;
                           } else {
                              var11 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriorities[var10]) {
                        var11 = 2000;
                     }

                     boolean var12 = false;
                     var7 = Client.playerMenuTypes[var10] + var11;
                     class261.addMenuEntry(Client.playerOptions[var10], class8.getColTags(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var10 = 0; var10 < Client.menuOptionCount; ++var10) {
               if(Client.menuTypes[var10] == 23) {
                  Client.menuTargets[var10] = class8.getColTags(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
