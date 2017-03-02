import java.awt.Component;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
public abstract class class112 {
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = -1666824387
   )
   @Export("cameraZ")
   static int cameraZ;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "69"
   )
   public abstract int vmethod2147();

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass18;II)V",
      garbageValue = "937607130"
   )
   static void method2151(class18 var0, int var1) {
      Object[] var2 = var0.field197;
      int var3 = ((Integer)var2[0]).intValue();
      Script var4 = class13.method183(var3);
      if(var4 != null) {
         class101.field1648 = 0;
         World.scriptStringStackSize = 0;
         int var5 = -1;
         int[] var6 = var4.instructions;
         int[] var7 = var4.intOperands;
         byte var8 = -1;
         class32.scriptStackCount = 0;

         int var11;
         try {
            class32.field718 = new int[var4.localIntCount];
            int var9 = 0;
            class32.field734 = new String[var4.localStringCount];
            int var10 = 0;

            int var12;
            String var33;
            for(var11 = 1; var11 < var2.length; ++var11) {
               if(var2[var11] instanceof Integer) {
                  var12 = ((Integer)var2[var11]).intValue();
                  if(var12 == -2147483647) {
                     var12 = var0.field196;
                  }

                  if(var12 == -2147483646) {
                     var12 = var0.field189;
                  }

                  if(var12 == -2147483645) {
                     var12 = var0.field185 != null?var0.field185.id:-1;
                  }

                  if(var12 == -2147483644) {
                     var12 = var0.field190;
                  }

                  if(var12 == -2147483643) {
                     var12 = var0.field185 != null?var0.field185.index:-1;
                  }

                  if(var12 == -2147483642) {
                     var12 = var0.field188 != null?var0.field188.id:-1;
                  }

                  if(var12 == -2147483641) {
                     var12 = null != var0.field188?var0.field188.index:-1;
                  }

                  if(var12 == -2147483640) {
                     var12 = var0.field191;
                  }

                  if(var12 == -2147483639) {
                     var12 = var0.field195;
                  }

                  class32.field718[var9++] = var12;
               } else if(var2[var11] instanceof String) {
                  var33 = (String)var2[var11];
                  if(var33.equals("event_opbase")) {
                     var33 = var0.field194;
                  }

                  class32.field734[var10++] = var33;
               }
            }

            var11 = 0;
            class32.field717 = var0.field192;

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
                                                                                       label1668:
                                                                                       while(true) {
                                                                                          ++var11;
                                                                                          if(var11 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var5;
                                                                                          int var57 = var6[var5];
                                                                                          int var13;
                                                                                          int var17;
                                                                                          int var18;
                                                                                          int var19;
                                                                                          int var34;
                                                                                          int var35;
                                                                                          String var62;
                                                                                          String var75;
                                                                                          String var93;
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
                                                                                                                                                                        var12 = var7[var5] >> 16;
                                                                                                                                                                        var13 = var7[var5] & '\uffff';
                                                                                                                                                                        int var102 = class32.field729[--class101.field1648];
                                                                                                                                                                        if(var102 >= 0 && var102 <= 5000) {
                                                                                                                                                                           class32.field720[var12] = var102;
                                                                                                                                                                           byte var101 = -1;
                                                                                                                                                                           if(var13 == 105) {
                                                                                                                                                                              var101 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var34 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var34 >= var102) {
                                                                                                                                                                                 continue label1668;
                                                                                                                                                                              }

                                                                                                                                                                              class32.field721[var12][var34] = var101;
                                                                                                                                                                              ++var34;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var57 == 45) {
                                                                                                                                                                        var12 = var7[var5];
                                                                                                                                                                        var13 = class32.field729[--class101.field1648];
                                                                                                                                                                        if(var13 < 0 || var13 >= class32.field720[var12]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class32.field729[++class101.field1648 - 1] = class32.field721[var12][var13];
                                                                                                                                                                     } else if(var57 == 46) {
                                                                                                                                                                        var12 = var7[var5];
                                                                                                                                                                        class101.field1648 -= 2;
                                                                                                                                                                        var13 = class32.field729[class101.field1648];
                                                                                                                                                                        if(var13 < 0 || var13 >= class32.field720[var12]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class32.field721[var12][var13] = class32.field729[class101.field1648 + 1];
                                                                                                                                                                     } else if(var57 == 47) {
                                                                                                                                                                        var33 = class9.chatMessages.method903(var7[var5]);
                                                                                                                                                                        if(var33 == null) {
                                                                                                                                                                           var33 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class32.scriptStringStack[++World.scriptStringStackSize - 1] = var33;
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var57 != 48) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        class9.chatMessages.method929(var7[var5], class32.scriptStringStack[--World.scriptStringStackSize]);
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     class9.chatMessages.method904(var7[var5], class32.field729[--class101.field1648]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class32.field729[++class101.field1648 - 1] = class9.chatMessages.method905(var7[var5]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var12 = var7[var5];
                                                                                                                                                               Script var88 = class13.method183(var12);
                                                                                                                                                               int[] var59 = new int[var88.localIntCount];
                                                                                                                                                               String[] var78 = new String[var88.localStringCount];

                                                                                                                                                               for(var34 = 0; var34 < var88.intStackCount; ++var34) {
                                                                                                                                                                  var59[var34] = class32.field729[var34 + (class101.field1648 - var88.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var34 = 0; var34 < var88.stringStackCount; ++var34) {
                                                                                                                                                                  var78[var34] = class32.scriptStringStack[var34 + (World.scriptStringStackSize - var88.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class101.field1648 -= var88.intStackCount;
                                                                                                                                                               World.scriptStringStackSize -= var88.stringStackCount;
                                                                                                                                                               ScriptState var71 = new ScriptState();
                                                                                                                                                               var71.field118 = var4;
                                                                                                                                                               var71.field113 = var5;
                                                                                                                                                               var71.field112 = class32.field718;
                                                                                                                                                               var71.field110 = class32.field734;
                                                                                                                                                               class32.scriptStack[++class32.scriptStackCount - 1] = var71;
                                                                                                                                                               var4 = var88;
                                                                                                                                                               var6 = var88.instructions;
                                                                                                                                                               var7 = var88.intOperands;
                                                                                                                                                               var5 = -1;
                                                                                                                                                               class32.field718 = var59;
                                                                                                                                                               class32.field734 = var78;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --World.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class101.field1648;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var12 = var7[var5];
                                                                                                                                                      World.scriptStringStackSize -= var12;
                                                                                                                                                      String[] var58 = class32.scriptStringStack;
                                                                                                                                                      var35 = World.scriptStringStackSize;
                                                                                                                                                      String var36;
                                                                                                                                                      if(var12 == 0) {
                                                                                                                                                         var36 = "";
                                                                                                                                                      } else if(var12 == 1) {
                                                                                                                                                         var62 = var58[var35];
                                                                                                                                                         if(null == var62) {
                                                                                                                                                            var36 = "null";
                                                                                                                                                         } else {
                                                                                                                                                            var36 = var62.toString();
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         var34 = var12 + var35;
                                                                                                                                                         var17 = 0;

                                                                                                                                                         for(var18 = var35; var18 < var34; ++var18) {
                                                                                                                                                            var93 = var58[var18];
                                                                                                                                                            if(var93 == null) {
                                                                                                                                                               var17 += 4;
                                                                                                                                                            } else {
                                                                                                                                                               var17 += var93.length();
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         StringBuilder var96 = new StringBuilder(var17);

                                                                                                                                                         for(var19 = var35; var19 < var34; ++var19) {
                                                                                                                                                            var75 = var58[var19];
                                                                                                                                                            if(var75 == null) {
                                                                                                                                                               var96.append("null");
                                                                                                                                                            } else {
                                                                                                                                                               var96.append(var75);
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         var36 = var96.toString();
                                                                                                                                                      }

                                                                                                                                                      class32.scriptStringStack[++World.scriptStringStackSize - 1] = var36;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class32.field734[var7[var5]] = class32.scriptStringStack[--World.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class32.scriptStringStack[++World.scriptStringStackSize - 1] = class32.field734[var7[var5]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class32.field718[var7[var5]] = class32.field729[--class101.field1648];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class32.field729[++class101.field1648 - 1] = class32.field718[var7[var5]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class101.field1648 -= 2;
                                                                                                                                       if(class32.field729[class101.field1648] >= class32.field729[class101.field1648 + 1]) {
                                                                                                                                          var5 += var7[var5];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class101.field1648 -= 2;
                                                                                                                                    if(class32.field729[class101.field1648] <= class32.field729[class101.field1648 + 1]) {
                                                                                                                                       var5 += var7[var5];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var12 = var7[var5];
                                                                                                                                 var13 = class32.field729[--class101.field1648];
                                                                                                                                 Varbit var77 = (Varbit)Varbit.field2850.get((long)var12);
                                                                                                                                 Varbit var14;
                                                                                                                                 if(var77 != null) {
                                                                                                                                    var14 = var77;
                                                                                                                                 } else {
                                                                                                                                    byte[] var69 = Varbit.field2853.getConfigData(14, var12);
                                                                                                                                    var77 = new Varbit();
                                                                                                                                    if(null != var69) {
                                                                                                                                       var77.method3617(new Buffer(var69));
                                                                                                                                    }

                                                                                                                                    Varbit.field2850.put(var77, (long)var12);
                                                                                                                                    var14 = var77;
                                                                                                                                 }

                                                                                                                                 var34 = var14.leastSignificantBit;
                                                                                                                                 var17 = var14.configId;
                                                                                                                                 var18 = var14.mostSignificantBit;
                                                                                                                                 var19 = class165.field2153[var18 - var17];
                                                                                                                                 if(var13 < 0 || var13 > var19) {
                                                                                                                                    var13 = 0;
                                                                                                                                 }

                                                                                                                                 var19 <<= var17;
                                                                                                                                 class165.widgetSettings[var34] = class165.widgetSettings[var34] & ~var19 | var13 << var17 & var19;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var12 = var7[var5];
                                                                                                                              class32.field729[++class101.field1648 - 1] = class156.method3084(var12);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class32.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var86 = class32.scriptStack[--class32.scriptStackCount];
                                                                                                                           var4 = var86.field118;
                                                                                                                           var6 = var4.instructions;
                                                                                                                           var7 = var4.intOperands;
                                                                                                                           var5 = var86.field113;
                                                                                                                           class32.field718 = var86.field112;
                                                                                                                           class32.field734 = var86.field110;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class101.field1648 -= 2;
                                                                                                                        if(class32.field729[class101.field1648] > class32.field729[1 + class101.field1648]) {
                                                                                                                           var5 += var7[var5];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class101.field1648 -= 2;
                                                                                                                     if(class32.field729[class101.field1648] < class32.field729[class101.field1648 + 1]) {
                                                                                                                        var5 += var7[var5];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class101.field1648 -= 2;
                                                                                                                  if(class32.field729[class101.field1648] == class32.field729[1 + class101.field1648]) {
                                                                                                                     var5 += var7[var5];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class101.field1648 -= 2;
                                                                                                               if(class32.field729[class101.field1648] != class32.field729[class101.field1648 + 1]) {
                                                                                                                  var5 += var7[var5];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var5 += var7[var5];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class32.scriptStringStack[++World.scriptStringStackSize - 1] = var4.stringOperands[var5];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var12 = var7[var5];
                                                                                                      class165.widgetSettings[var12] = class32.field729[--class101.field1648];
                                                                                                      CombatInfoListHolder.method777(var12);
                                                                                                   }
                                                                                                } else {
                                                                                                   var12 = var7[var5];
                                                                                                   class32.field729[++class101.field1648 - 1] = class165.widgetSettings[var12];
                                                                                                }
                                                                                             } else {
                                                                                                class32.field729[++class101.field1648 - 1] = var7[var5];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var65;
                                                                                             if(var4.intOperands[var5] == 1) {
                                                                                                var65 = true;
                                                                                             } else {
                                                                                                var65 = false;
                                                                                             }

                                                                                             Widget var15;
                                                                                             Widget var38;
                                                                                             byte var39;
                                                                                             int var40;
                                                                                             if(var57 < 1000) {
                                                                                                if(var57 == 100) {
                                                                                                   class101.field1648 -= 3;
                                                                                                   var35 = class32.field729[class101.field1648];
                                                                                                   var34 = class32.field729[class101.field1648 + 1];
                                                                                                   var17 = class32.field729[class101.field1648 + 2];
                                                                                                   if(var34 == 0) {
                                                                                                      throw new RuntimeException();
                                                                                                   }

                                                                                                   var38 = class140.method2681(var35);
                                                                                                   if(null == var38.children) {
                                                                                                      var38.children = new Widget[1 + var17];
                                                                                                   }

                                                                                                   if(var38.children.length <= var17) {
                                                                                                      Widget[] var37 = new Widget[var17 + 1];

                                                                                                      for(var40 = 0; var40 < var38.children.length; ++var40) {
                                                                                                         var37[var40] = var38.children[var40];
                                                                                                      }

                                                                                                      var38.children = var37;
                                                                                                   }

                                                                                                   if(var17 > 0 && null == var38.children[var17 - 1]) {
                                                                                                      throw new RuntimeException("" + (var17 - 1));
                                                                                                   }

                                                                                                   Widget var87 = new Widget();
                                                                                                   var87.type = var34;
                                                                                                   var87.parentId = var87.id = var38.id;
                                                                                                   var87.index = var17;
                                                                                                   var87.hasScript = true;
                                                                                                   var38.children[var17] = var87;
                                                                                                   if(var65) {
                                                                                                      class32.field719 = var87;
                                                                                                   } else {
                                                                                                      class185.field2760 = var87;
                                                                                                   }

                                                                                                   Frames.method1960(var38);
                                                                                                   var39 = 1;
                                                                                                } else if(var57 == 101) {
                                                                                                   var15 = var65?class32.field719:class185.field2760;
                                                                                                   Widget var16 = class140.method2681(var15.id);
                                                                                                   var16.children[var15.index] = null;
                                                                                                   Frames.method1960(var16);
                                                                                                   var39 = 1;
                                                                                                } else if(var57 == 102) {
                                                                                                   var15 = class140.method2681(class32.field729[--class101.field1648]);
                                                                                                   var15.children = null;
                                                                                                   Frames.method1960(var15);
                                                                                                   var39 = 1;
                                                                                                } else if(var57 != 200) {
                                                                                                   if(var57 == 201) {
                                                                                                      var15 = class140.method2681(class32.field729[--class101.field1648]);
                                                                                                      if(null != var15) {
                                                                                                         class32.field729[++class101.field1648 - 1] = 1;
                                                                                                         if(var65) {
                                                                                                            class32.field719 = var15;
                                                                                                         } else {
                                                                                                            class185.field2760 = var15;
                                                                                                         }
                                                                                                      } else {
                                                                                                         class32.field729[++class101.field1648 - 1] = 0;
                                                                                                      }

                                                                                                      var39 = 1;
                                                                                                   } else {
                                                                                                      var39 = 2;
                                                                                                   }
                                                                                                } else {
                                                                                                   class101.field1648 -= 2;
                                                                                                   var35 = class32.field729[class101.field1648];
                                                                                                   var34 = class32.field729[1 + class101.field1648];
                                                                                                   Widget var41 = CollisionData.method2322(var35, var34);
                                                                                                   if(var41 != null && var34 != -1) {
                                                                                                      class32.field729[++class101.field1648 - 1] = 1;
                                                                                                      if(var65) {
                                                                                                         class32.field719 = var41;
                                                                                                      } else {
                                                                                                         class185.field2760 = var41;
                                                                                                      }
                                                                                                   } else {
                                                                                                      class32.field729[++class101.field1648 - 1] = 0;
                                                                                                   }

                                                                                                   var39 = 1;
                                                                                                }

                                                                                                var13 = var39;
                                                                                             } else if(var57 < 1100) {
                                                                                                var13 = Ignore.method208(var57, var4, var65);
                                                                                             } else if(var57 < 1200) {
                                                                                                var13 = class49.method964(var57, var4, var65);
                                                                                             } else if(var57 < 1300) {
                                                                                                var13 = class156.method3096(var57, var4, var65);
                                                                                             } else if(var57 < 1400) {
                                                                                                var13 = class15.method193(var57, var4, var65);
                                                                                             } else if(var57 < 1500) {
                                                                                                var13 = class176.method3329(var57, var4, var65);
                                                                                             } else if(var57 < 1600) {
                                                                                                var38 = var65?class32.field719:class185.field2760;
                                                                                                if(var57 == 1500) {
                                                                                                   class32.field729[++class101.field1648 - 1] = var38.relativeX;
                                                                                                   var39 = 1;
                                                                                                } else if(var57 == 1501) {
                                                                                                   class32.field729[++class101.field1648 - 1] = var38.relativeY;
                                                                                                   var39 = 1;
                                                                                                } else if(var57 == 1502) {
                                                                                                   class32.field729[++class101.field1648 - 1] = var38.width;
                                                                                                   var39 = 1;
                                                                                                } else if(var57 == 1503) {
                                                                                                   class32.field729[++class101.field1648 - 1] = var38.height;
                                                                                                   var39 = 1;
                                                                                                } else if(var57 == 1504) {
                                                                                                   class32.field729[++class101.field1648 - 1] = var38.isHidden?1:0;
                                                                                                   var39 = 1;
                                                                                                } else if(var57 == 1505) {
                                                                                                   class32.field729[++class101.field1648 - 1] = var38.parentId;
                                                                                                   var39 = 1;
                                                                                                } else {
                                                                                                   var39 = 2;
                                                                                                }

                                                                                                var13 = var39;
                                                                                             } else if(var57 < 1700) {
                                                                                                var13 = method2159(var57, var4, var65);
                                                                                             } else if(var57 < 1800) {
                                                                                                var13 = class184.method3465(var57, var4, var65);
                                                                                             } else if(var57 < 1900) {
                                                                                                var15 = var65?class32.field719:class185.field2760;
                                                                                                if(var57 == 1800) {
                                                                                                   class32.field729[++class101.field1648 - 1] = class0.method10(class8.method112(var15));
                                                                                                   var39 = 1;
                                                                                                } else if(var57 != 1801) {
                                                                                                   if(var57 == 1802) {
                                                                                                      if(var15.name == null) {
                                                                                                         class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                                                                                                      } else {
                                                                                                         class32.scriptStringStack[++World.scriptStringStackSize - 1] = var15.name;
                                                                                                      }

                                                                                                      var39 = 1;
                                                                                                   } else {
                                                                                                      var39 = 2;
                                                                                                   }
                                                                                                } else {
                                                                                                   var34 = class32.field729[--class101.field1648];
                                                                                                   --var34;
                                                                                                   if(var15.actions != null && var34 < var15.actions.length && var15.actions[var34] != null) {
                                                                                                      class32.scriptStringStack[++World.scriptStringStackSize - 1] = var15.actions[var34];
                                                                                                   } else {
                                                                                                      class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                                                                                                   }

                                                                                                   var39 = 1;
                                                                                                }

                                                                                                var13 = var39;
                                                                                             } else if(var57 < 2000) {
                                                                                                var13 = class204.method3911(var57, var4, var65);
                                                                                             } else if(var57 < 2100) {
                                                                                                var13 = Ignore.method208(var57, var4, var65);
                                                                                             } else if(var57 < 2200) {
                                                                                                var13 = class49.method964(var57, var4, var65);
                                                                                             } else if(var57 < 2300) {
                                                                                                var13 = class156.method3096(var57, var4, var65);
                                                                                             } else if(var57 < 2400) {
                                                                                                var13 = class15.method193(var57, var4, var65);
                                                                                             } else if(var57 < 2500) {
                                                                                                var13 = class176.method3329(var57, var4, var65);
                                                                                             } else if(var57 < 2600) {
                                                                                                var13 = World.method682(var57, var4, var65);
                                                                                             } else if(var57 < 2700) {
                                                                                                var15 = class140.method2681(class32.field729[--class101.field1648]);
                                                                                                if(var57 == 2600) {
                                                                                                   class32.field729[++class101.field1648 - 1] = var15.scrollX;
                                                                                                   var39 = 1;
                                                                                                } else if(var57 == 2601) {
                                                                                                   class32.field729[++class101.field1648 - 1] = var15.scrollY;
                                                                                                   var39 = 1;
                                                                                                } else if(var57 == 2602) {
                                                                                                   class32.scriptStringStack[++World.scriptStringStackSize - 1] = var15.text;
                                                                                                   var39 = 1;
                                                                                                } else if(var57 == 2603) {
                                                                                                   class32.field729[++class101.field1648 - 1] = var15.scrollWidth;
                                                                                                   var39 = 1;
                                                                                                } else if(var57 == 2604) {
                                                                                                   class32.field729[++class101.field1648 - 1] = var15.scrollHeight;
                                                                                                   var39 = 1;
                                                                                                } else if(var57 == 2605) {
                                                                                                   class32.field729[++class101.field1648 - 1] = var15.field2238;
                                                                                                   var39 = 1;
                                                                                                } else if(var57 == 2606) {
                                                                                                   class32.field729[++class101.field1648 - 1] = var15.rotationX;
                                                                                                   var39 = 1;
                                                                                                } else if(var57 == 2607) {
                                                                                                   class32.field729[++class101.field1648 - 1] = var15.rotationY;
                                                                                                   var39 = 1;
                                                                                                } else if(var57 == 2608) {
                                                                                                   class32.field729[++class101.field1648 - 1] = var15.rotationZ;
                                                                                                   var39 = 1;
                                                                                                } else if(var57 == 2609) {
                                                                                                   class32.field729[++class101.field1648 - 1] = var15.opacity;
                                                                                                   var39 = 1;
                                                                                                } else if(var57 == 2610) {
                                                                                                   class32.field729[++class101.field1648 - 1] = var15.field2228;
                                                                                                   var39 = 1;
                                                                                                } else if(var57 == 2611) {
                                                                                                   class32.field729[++class101.field1648 - 1] = var15.textColor;
                                                                                                   var39 = 1;
                                                                                                } else if(var57 == 2612) {
                                                                                                   class32.field729[++class101.field1648 - 1] = var15.field2222;
                                                                                                   var39 = 1;
                                                                                                } else if(var57 == 2613) {
                                                                                                   class32.field729[++class101.field1648 - 1] = var15.field2329.vmethod4183();
                                                                                                   var39 = 1;
                                                                                                } else {
                                                                                                   var39 = 2;
                                                                                                }

                                                                                                var13 = var39;
                                                                                             } else if(var57 < 2800) {
                                                                                                if(var57 == 2700) {
                                                                                                   var15 = class140.method2681(class32.field729[--class101.field1648]);
                                                                                                   class32.field729[++class101.field1648 - 1] = var15.item;
                                                                                                   var39 = 1;
                                                                                                } else if(var57 == 2701) {
                                                                                                   var15 = class140.method2681(class32.field729[--class101.field1648]);
                                                                                                   if(var15.item != -1) {
                                                                                                      class32.field729[++class101.field1648 - 1] = var15.stackSize;
                                                                                                   } else {
                                                                                                      class32.field729[++class101.field1648 - 1] = 0;
                                                                                                   }

                                                                                                   var39 = 1;
                                                                                                } else if(var57 == 2702) {
                                                                                                   var35 = class32.field729[--class101.field1648];
                                                                                                   WidgetNode var60 = (WidgetNode)Client.componentTable.method2428((long)var35);
                                                                                                   if(null != var60) {
                                                                                                      class32.field729[++class101.field1648 - 1] = 1;
                                                                                                   } else {
                                                                                                      class32.field729[++class101.field1648 - 1] = 0;
                                                                                                   }

                                                                                                   var39 = 1;
                                                                                                } else if(var57 == 2706) {
                                                                                                   class32.field729[++class101.field1648 - 1] = Client.widgetRoot;
                                                                                                   var39 = 1;
                                                                                                } else {
                                                                                                   var39 = 2;
                                                                                                }

                                                                                                var13 = var39;
                                                                                             } else if(var57 < 2900) {
                                                                                                var13 = Actor.method639(var57, var4, var65);
                                                                                             } else if(var57 < 3000) {
                                                                                                var13 = class204.method3911(var57, var4, var65);
                                                                                             } else if(var57 < 3200) {
                                                                                                var13 = RSCanvas.method2144(var57, var4, var65);
                                                                                             } else if(var57 < 3300) {
                                                                                                if(var57 == 3200) {
                                                                                                   class101.field1648 -= 3;
                                                                                                   var35 = class32.field729[class101.field1648];
                                                                                                   var34 = class32.field729[class101.field1648 + 1];
                                                                                                   var17 = class32.field729[class101.field1648 + 2];
                                                                                                   if(Client.field525 != 0 && var34 != 0 && Client.field527 < 50) {
                                                                                                      Client.field552[Client.field527] = var35;
                                                                                                      Client.field529[Client.field527] = var34;
                                                                                                      Client.field530[Client.field527] = var17;
                                                                                                      Client.field351[Client.field527] = null;
                                                                                                      Client.field531[Client.field527] = 0;
                                                                                                      ++Client.field527;
                                                                                                   }

                                                                                                   var39 = 1;
                                                                                                } else if(var57 != 3201) {
                                                                                                   if(var57 == 3202) {
                                                                                                      class101.field1648 -= 2;
                                                                                                      class31.method706(class32.field729[class101.field1648], class32.field729[class101.field1648 + 1]);
                                                                                                      var39 = 1;
                                                                                                   } else {
                                                                                                      var39 = 2;
                                                                                                   }
                                                                                                } else {
                                                                                                   var35 = class32.field729[--class101.field1648];
                                                                                                   if(var35 == -1 && !Client.field401) {
                                                                                                      World.method681();
                                                                                                   } else if(var35 != -1 && Client.field523 != var35 && Client.field522 != 0 && !Client.field401) {
                                                                                                      class25.method613(2, XItemContainer.field122, var35, 0, Client.field522, false);
                                                                                                   }

                                                                                                   Client.field523 = var35;
                                                                                                   var39 = 1;
                                                                                                }

                                                                                                var13 = var39;
                                                                                             } else if(var57 < 3400) {
                                                                                                var13 = class156.method3090(var57, var4, var65);
                                                                                             } else {
                                                                                                int var42;
                                                                                                if(var57 < 3500) {
                                                                                                   if(var57 == 3400) {
                                                                                                      class101.field1648 -= 2;
                                                                                                      var35 = class32.field729[class101.field1648];
                                                                                                      var34 = class32.field729[class101.field1648 + 1];
                                                                                                      class195 var90 = (class195)class195.field2861.get((long)var35);
                                                                                                      class195 var97;
                                                                                                      if(null != var90) {
                                                                                                         var97 = var90;
                                                                                                      } else {
                                                                                                         byte[] var91 = class195.field2870.getConfigData(8, var35);
                                                                                                         var90 = new class195();
                                                                                                         if(null != var91) {
                                                                                                            var90.method3630(new Buffer(var91));
                                                                                                         }

                                                                                                         class195.field2861.put(var90, (long)var35);
                                                                                                         var97 = var90;
                                                                                                      }

                                                                                                      var90 = var97;
                                                                                                      if(var97.field2863 != 115) {
                                                                                                         ;
                                                                                                      }

                                                                                                      for(var19 = 0; var19 < var90.field2866; ++var19) {
                                                                                                         if(var90.field2868[var19] == var34) {
                                                                                                            class32.scriptStringStack[++World.scriptStringStackSize - 1] = var90.field2869[var19];
                                                                                                            var90 = null;
                                                                                                            break;
                                                                                                         }
                                                                                                      }

                                                                                                      if(null != var90) {
                                                                                                         class32.scriptStringStack[++World.scriptStringStackSize - 1] = var90.field2864;
                                                                                                      }

                                                                                                      var39 = 1;
                                                                                                   } else if(var57 == 3408) {
                                                                                                      class101.field1648 -= 4;
                                                                                                      var35 = class32.field729[class101.field1648];
                                                                                                      var34 = class32.field729[class101.field1648 + 1];
                                                                                                      var17 = class32.field729[2 + class101.field1648];
                                                                                                      var18 = class32.field729[3 + class101.field1648];
                                                                                                      class195 var20 = (class195)class195.field2861.get((long)var17);
                                                                                                      class195 var89;
                                                                                                      if(null != var20) {
                                                                                                         var89 = var20;
                                                                                                      } else {
                                                                                                         byte[] var21 = class195.field2870.getConfigData(8, var17);
                                                                                                         var20 = new class195();
                                                                                                         if(null != var21) {
                                                                                                            var20.method3630(new Buffer(var21));
                                                                                                         }

                                                                                                         class195.field2861.put(var20, (long)var17);
                                                                                                         var89 = var20;
                                                                                                      }

                                                                                                      var20 = var89;
                                                                                                      if(var89.field2862 == var35 && var34 == var89.field2863) {
                                                                                                         for(var42 = 0; var42 < var20.field2866; ++var42) {
                                                                                                            if(var20.field2868[var42] == var18) {
                                                                                                               if(var34 == 115) {
                                                                                                                  class32.scriptStringStack[++World.scriptStringStackSize - 1] = var20.field2869[var42];
                                                                                                               } else {
                                                                                                                  class32.field729[++class101.field1648 - 1] = var20.field2867[var42];
                                                                                                               }

                                                                                                               var20 = null;
                                                                                                               break;
                                                                                                            }
                                                                                                         }

                                                                                                         if(null != var20) {
                                                                                                            if(var34 == 115) {
                                                                                                               class32.scriptStringStack[++World.scriptStringStackSize - 1] = var20.field2864;
                                                                                                            } else {
                                                                                                               class32.field729[++class101.field1648 - 1] = var20.field2865;
                                                                                                            }
                                                                                                         }

                                                                                                         var39 = 1;
                                                                                                      } else {
                                                                                                         if(var34 == 115) {
                                                                                                            class32.scriptStringStack[++World.scriptStringStackSize - 1] = "null";
                                                                                                         } else {
                                                                                                            class32.field729[++class101.field1648 - 1] = 0;
                                                                                                         }

                                                                                                         var39 = 1;
                                                                                                      }
                                                                                                   } else {
                                                                                                      var39 = 2;
                                                                                                   }

                                                                                                   var13 = var39;
                                                                                                } else if(var57 < 3700) {
                                                                                                   var13 = class25.method612(var57, var4, var65);
                                                                                                } else if(var57 < 4000) {
                                                                                                   var13 = class88.method1937(var57, var4, var65);
                                                                                                } else if(var57 < 4100) {
                                                                                                   if(var57 == 4000) {
                                                                                                      class101.field1648 -= 2;
                                                                                                      var35 = class32.field729[class101.field1648];
                                                                                                      var34 = class32.field729[1 + class101.field1648];
                                                                                                      class32.field729[++class101.field1648 - 1] = var35 + var34;
                                                                                                      var39 = 1;
                                                                                                   } else if(var57 == 4001) {
                                                                                                      class101.field1648 -= 2;
                                                                                                      var35 = class32.field729[class101.field1648];
                                                                                                      var34 = class32.field729[1 + class101.field1648];
                                                                                                      class32.field729[++class101.field1648 - 1] = var35 - var34;
                                                                                                      var39 = 1;
                                                                                                   } else if(var57 == 4002) {
                                                                                                      class101.field1648 -= 2;
                                                                                                      var35 = class32.field729[class101.field1648];
                                                                                                      var34 = class32.field729[class101.field1648 + 1];
                                                                                                      class32.field729[++class101.field1648 - 1] = var35 * var34;
                                                                                                      var39 = 1;
                                                                                                   } else if(var57 == 4003) {
                                                                                                      class101.field1648 -= 2;
                                                                                                      var35 = class32.field729[class101.field1648];
                                                                                                      var34 = class32.field729[class101.field1648 + 1];
                                                                                                      class32.field729[++class101.field1648 - 1] = var35 / var34;
                                                                                                      var39 = 1;
                                                                                                   } else if(var57 == 4004) {
                                                                                                      var35 = class32.field729[--class101.field1648];
                                                                                                      class32.field729[++class101.field1648 - 1] = (int)(Math.random() * (double)var35);
                                                                                                      var39 = 1;
                                                                                                   } else if(var57 == 4005) {
                                                                                                      var35 = class32.field729[--class101.field1648];
                                                                                                      class32.field729[++class101.field1648 - 1] = (int)(Math.random() * (double)(var35 + 1));
                                                                                                      var39 = 1;
                                                                                                   } else if(var57 == 4006) {
                                                                                                      class101.field1648 -= 5;
                                                                                                      var35 = class32.field729[class101.field1648];
                                                                                                      var34 = class32.field729[class101.field1648 + 1];
                                                                                                      var17 = class32.field729[2 + class101.field1648];
                                                                                                      var18 = class32.field729[class101.field1648 + 3];
                                                                                                      var19 = class32.field729[4 + class101.field1648];
                                                                                                      class32.field729[++class101.field1648 - 1] = (var34 - var35) * (var19 - var17) / (var18 - var17) + var35;
                                                                                                      var39 = 1;
                                                                                                   } else if(var57 == 4007) {
                                                                                                      class101.field1648 -= 2;
                                                                                                      var35 = class32.field729[class101.field1648];
                                                                                                      var34 = class32.field729[1 + class101.field1648];
                                                                                                      class32.field729[++class101.field1648 - 1] = var34 * var35 / 100 + var35;
                                                                                                      var39 = 1;
                                                                                                   } else if(var57 == 4008) {
                                                                                                      class101.field1648 -= 2;
                                                                                                      var35 = class32.field729[class101.field1648];
                                                                                                      var34 = class32.field729[class101.field1648 + 1];
                                                                                                      class32.field729[++class101.field1648 - 1] = var35 | 1 << var34;
                                                                                                      var39 = 1;
                                                                                                   } else if(var57 == 4009) {
                                                                                                      class101.field1648 -= 2;
                                                                                                      var35 = class32.field729[class101.field1648];
                                                                                                      var34 = class32.field729[1 + class101.field1648];
                                                                                                      class32.field729[++class101.field1648 - 1] = var35 & -1 - (1 << var34);
                                                                                                      var39 = 1;
                                                                                                   } else if(var57 == 4010) {
                                                                                                      class101.field1648 -= 2;
                                                                                                      var35 = class32.field729[class101.field1648];
                                                                                                      var34 = class32.field729[1 + class101.field1648];
                                                                                                      class32.field729[++class101.field1648 - 1] = (var35 & 1 << var34) != 0?1:0;
                                                                                                      var39 = 1;
                                                                                                   } else if(var57 == 4011) {
                                                                                                      class101.field1648 -= 2;
                                                                                                      var35 = class32.field729[class101.field1648];
                                                                                                      var34 = class32.field729[1 + class101.field1648];
                                                                                                      class32.field729[++class101.field1648 - 1] = var35 % var34;
                                                                                                      var39 = 1;
                                                                                                   } else if(var57 == 4012) {
                                                                                                      class101.field1648 -= 2;
                                                                                                      var35 = class32.field729[class101.field1648];
                                                                                                      var34 = class32.field729[1 + class101.field1648];
                                                                                                      if(var35 == 0) {
                                                                                                         class32.field729[++class101.field1648 - 1] = 0;
                                                                                                      } else {
                                                                                                         class32.field729[++class101.field1648 - 1] = (int)Math.pow((double)var35, (double)var34);
                                                                                                      }

                                                                                                      var39 = 1;
                                                                                                   } else if(var57 == 4013) {
                                                                                                      class101.field1648 -= 2;
                                                                                                      var35 = class32.field729[class101.field1648];
                                                                                                      var34 = class32.field729[1 + class101.field1648];
                                                                                                      if(var35 == 0) {
                                                                                                         class32.field729[++class101.field1648 - 1] = 0;
                                                                                                      } else if(var34 == 0) {
                                                                                                         class32.field729[++class101.field1648 - 1] = Integer.MAX_VALUE;
                                                                                                      } else {
                                                                                                         class32.field729[++class101.field1648 - 1] = (int)Math.pow((double)var35, 1.0D / (double)var34);
                                                                                                      }

                                                                                                      var39 = 1;
                                                                                                   } else if(var57 == 4014) {
                                                                                                      class101.field1648 -= 2;
                                                                                                      var35 = class32.field729[class101.field1648];
                                                                                                      var34 = class32.field729[1 + class101.field1648];
                                                                                                      class32.field729[++class101.field1648 - 1] = var35 & var34;
                                                                                                      var39 = 1;
                                                                                                   } else if(var57 == 4015) {
                                                                                                      class101.field1648 -= 2;
                                                                                                      var35 = class32.field729[class101.field1648];
                                                                                                      var34 = class32.field729[1 + class101.field1648];
                                                                                                      class32.field729[++class101.field1648 - 1] = var35 | var34;
                                                                                                      var39 = 1;
                                                                                                   } else if(var57 == 4018) {
                                                                                                      class101.field1648 -= 3;
                                                                                                      long var43 = (long)class32.field729[class101.field1648];
                                                                                                      long var45 = (long)class32.field729[class101.field1648 + 1];
                                                                                                      long var47 = (long)class32.field729[2 + class101.field1648];
                                                                                                      class32.field729[++class101.field1648 - 1] = (int)(var47 * var43 / var45);
                                                                                                      var39 = 1;
                                                                                                   } else {
                                                                                                      var39 = 2;
                                                                                                   }

                                                                                                   var13 = var39;
                                                                                                } else {
                                                                                                   int var22;
                                                                                                   int var24;
                                                                                                   String var64;
                                                                                                   boolean var68;
                                                                                                   if(var57 < 4200) {
                                                                                                      if(var57 == 4100) {
                                                                                                         var64 = class32.scriptStringStack[--World.scriptStringStackSize];
                                                                                                         var34 = class32.field729[--class101.field1648];
                                                                                                         class32.scriptStringStack[++World.scriptStringStackSize - 1] = var64 + var34;
                                                                                                         var39 = 1;
                                                                                                      } else if(var57 == 4101) {
                                                                                                         World.scriptStringStackSize -= 2;
                                                                                                         var64 = class32.scriptStringStack[World.scriptStringStackSize];
                                                                                                         var62 = class32.scriptStringStack[World.scriptStringStackSize + 1];
                                                                                                         class32.scriptStringStack[++World.scriptStringStackSize - 1] = var64 + var62;
                                                                                                         var39 = 1;
                                                                                                      } else {
                                                                                                         int var23;
                                                                                                         int var83;
                                                                                                         if(var57 == 4102) {
                                                                                                            var64 = class32.scriptStringStack[--World.scriptStringStackSize];
                                                                                                            var34 = class32.field729[--class101.field1648];
                                                                                                            String[] var98 = class32.scriptStringStack;
                                                                                                            var18 = ++World.scriptStringStackSize - 1;
                                                                                                            if(var34 < 0) {
                                                                                                               var75 = Integer.toString(var34);
                                                                                                            } else {
                                                                                                               var22 = var34;
                                                                                                               String var74;
                                                                                                               if(var34 < 0) {
                                                                                                                  var74 = Integer.toString(var34, 10);
                                                                                                               } else {
                                                                                                                  var23 = 2;

                                                                                                                  for(var24 = var34 / 10; var24 != 0; ++var23) {
                                                                                                                     var24 /= 10;
                                                                                                                  }

                                                                                                                  char[] var25 = new char[var23];
                                                                                                                  var25[0] = 43;

                                                                                                                  for(int var80 = var23 - 1; var80 > 0; --var80) {
                                                                                                                     int var82 = var22;
                                                                                                                     var22 /= 10;
                                                                                                                     var83 = var82 - var22 * 10;
                                                                                                                     if(var83 >= 10) {
                                                                                                                        var25[var80] = (char)(var83 + 87);
                                                                                                                     } else {
                                                                                                                        var25[var80] = (char)(48 + var83);
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var74 = new String(var25);
                                                                                                               }

                                                                                                               var75 = var74;
                                                                                                            }

                                                                                                            var98[var18] = var64 + var75;
                                                                                                            var39 = 1;
                                                                                                         } else if(var57 == 4103) {
                                                                                                            var64 = class32.scriptStringStack[--World.scriptStringStackSize];
                                                                                                            class32.scriptStringStack[++World.scriptStringStackSize - 1] = var64.toLowerCase();
                                                                                                            var39 = 1;
                                                                                                         } else if(var57 == 4104) {
                                                                                                            var35 = class32.field729[--class101.field1648];
                                                                                                            long var49 = (11745L + (long)var35) * 86400000L;
                                                                                                            class32.field722.setTime(new Date(var49));
                                                                                                            var18 = class32.field722.get(5);
                                                                                                            var19 = class32.field722.get(2);
                                                                                                            var40 = class32.field722.get(1);
                                                                                                            class32.scriptStringStack[++World.scriptStringStackSize - 1] = var18 + "-" + class32.field728[var19] + "-" + var40;
                                                                                                            var39 = 1;
                                                                                                         } else if(var57 == 4105) {
                                                                                                            World.scriptStringStackSize -= 2;
                                                                                                            var64 = class32.scriptStringStack[World.scriptStringStackSize];
                                                                                                            var62 = class32.scriptStringStack[World.scriptStringStackSize + 1];
                                                                                                            if(class9.localPlayer.composition != null && class9.localPlayer.composition.isFemale) {
                                                                                                               class32.scriptStringStack[++World.scriptStringStackSize - 1] = var62;
                                                                                                            } else {
                                                                                                               class32.scriptStringStack[++World.scriptStringStackSize - 1] = var64;
                                                                                                            }

                                                                                                            var39 = 1;
                                                                                                         } else if(var57 == 4106) {
                                                                                                            var35 = class32.field729[--class101.field1648];
                                                                                                            class32.scriptStringStack[++World.scriptStringStackSize - 1] = Integer.toString(var35);
                                                                                                            var39 = 1;
                                                                                                         } else if(var57 == 4107) {
                                                                                                            World.scriptStringStackSize -= 2;
                                                                                                            int[] var72 = class32.field729;
                                                                                                            var34 = ++class101.field1648 - 1;
                                                                                                            var93 = class32.scriptStringStack[World.scriptStringStackSize];
                                                                                                            var75 = class32.scriptStringStack[1 + World.scriptStringStackSize];
                                                                                                            var42 = Client.field289;
                                                                                                            var22 = var93.length();
                                                                                                            var23 = var75.length();
                                                                                                            var24 = 0;
                                                                                                            int var51 = 0;
                                                                                                            char var26 = 0;
                                                                                                            char var27 = 0;

                                                                                                            label1520:
                                                                                                            while(true) {
                                                                                                               if(var24 - var26 >= var22 && var51 - var27 >= var23) {
                                                                                                                  var83 = Math.min(var22, var23);

                                                                                                                  char var31;
                                                                                                                  int var84;
                                                                                                                  for(var84 = 0; var84 < var83; ++var84) {
                                                                                                                     char var30 = var93.charAt(var84);
                                                                                                                     var31 = var75.charAt(var84);
                                                                                                                     if(var30 != var31 && Character.toUpperCase(var30) != Character.toUpperCase(var31)) {
                                                                                                                        var30 = Character.toLowerCase(var30);
                                                                                                                        var31 = Character.toLowerCase(var31);
                                                                                                                        if(var31 != var30) {
                                                                                                                           var18 = class168.method3259(var30, var42) - class168.method3259(var31, var42);
                                                                                                                           break label1520;
                                                                                                                        }
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var84 = var22 - var23;
                                                                                                                  if(var84 != 0) {
                                                                                                                     var18 = var84;
                                                                                                                  } else {
                                                                                                                     for(int var85 = 0; var85 < var83; ++var85) {
                                                                                                                        var31 = var93.charAt(var85);
                                                                                                                        char var32 = var75.charAt(var85);
                                                                                                                        if(var31 != var32) {
                                                                                                                           var18 = class168.method3259(var31, var42) - class168.method3259(var32, var42);
                                                                                                                           break label1520;
                                                                                                                        }
                                                                                                                     }

                                                                                                                     var18 = 0;
                                                                                                                  }
                                                                                                                  break;
                                                                                                               }

                                                                                                               if(var24 - var26 >= var22) {
                                                                                                                  var18 = -1;
                                                                                                                  break;
                                                                                                               }

                                                                                                               if(var51 - var27 >= var23) {
                                                                                                                  var18 = 1;
                                                                                                                  break;
                                                                                                               }

                                                                                                               char var28;
                                                                                                               if(var26 != 0) {
                                                                                                                  var28 = var26;
                                                                                                                  boolean var79 = false;
                                                                                                               } else {
                                                                                                                  var28 = var93.charAt(var24++);
                                                                                                               }

                                                                                                               char var29;
                                                                                                               if(var27 != 0) {
                                                                                                                  var29 = var27;
                                                                                                                  boolean var81 = false;
                                                                                                               } else {
                                                                                                                  var29 = var75.charAt(var51++);
                                                                                                               }

                                                                                                               var26 = KitDefinition.method3570(var28);
                                                                                                               var27 = KitDefinition.method3570(var29);
                                                                                                               var28 = class99.method1997(var28, var42);
                                                                                                               var29 = class99.method1997(var29, var42);
                                                                                                               if(var28 != var29 && Character.toUpperCase(var28) != Character.toUpperCase(var29)) {
                                                                                                                  var28 = Character.toLowerCase(var28);
                                                                                                                  var29 = Character.toLowerCase(var29);
                                                                                                                  if(var29 != var28) {
                                                                                                                     var18 = class168.method3259(var28, var42) - class168.method3259(var29, var42);
                                                                                                                     break;
                                                                                                                  }
                                                                                                               }
                                                                                                            }

                                                                                                            byte var73;
                                                                                                            if(var18 > 0) {
                                                                                                               var73 = 1;
                                                                                                            } else if(var18 < 0) {
                                                                                                               var73 = -1;
                                                                                                            } else {
                                                                                                               var73 = 0;
                                                                                                            }

                                                                                                            var72[var34] = var73;
                                                                                                            var39 = 1;
                                                                                                         } else {
                                                                                                            Font var92;
                                                                                                            byte[] var95;
                                                                                                            if(var57 == 4108) {
                                                                                                               var64 = class32.scriptStringStack[--World.scriptStringStackSize];
                                                                                                               class101.field1648 -= 2;
                                                                                                               var34 = class32.field729[class101.field1648];
                                                                                                               var17 = class32.field729[class101.field1648 + 1];
                                                                                                               var95 = Client.field533.getConfigData(var17, 0);
                                                                                                               var92 = new Font(var95);
                                                                                                               class32.field729[++class101.field1648 - 1] = var92.method3982(var64, var34);
                                                                                                               var39 = 1;
                                                                                                            } else if(var57 == 4109) {
                                                                                                               var64 = class32.scriptStringStack[--World.scriptStringStackSize];
                                                                                                               class101.field1648 -= 2;
                                                                                                               var34 = class32.field729[class101.field1648];
                                                                                                               var17 = class32.field729[class101.field1648 + 1];
                                                                                                               var95 = Client.field533.getConfigData(var17, 0);
                                                                                                               var92 = new Font(var95);
                                                                                                               class32.field729[++class101.field1648 - 1] = var92.method3971(var64, var34);
                                                                                                               var39 = 1;
                                                                                                            } else if(var57 == 4110) {
                                                                                                               World.scriptStringStackSize -= 2;
                                                                                                               var64 = class32.scriptStringStack[World.scriptStringStackSize];
                                                                                                               var62 = class32.scriptStringStack[1 + World.scriptStringStackSize];
                                                                                                               if(class32.field729[--class101.field1648] == 1) {
                                                                                                                  class32.scriptStringStack[++World.scriptStringStackSize - 1] = var64;
                                                                                                               } else {
                                                                                                                  class32.scriptStringStack[++World.scriptStringStackSize - 1] = var62;
                                                                                                               }

                                                                                                               var39 = 1;
                                                                                                            } else if(var57 == 4111) {
                                                                                                               var64 = class32.scriptStringStack[--World.scriptStringStackSize];
                                                                                                               class32.scriptStringStack[++World.scriptStringStackSize - 1] = FontTypeFace.method3973(var64);
                                                                                                               var39 = 1;
                                                                                                            } else if(var57 == 4112) {
                                                                                                               var64 = class32.scriptStringStack[--World.scriptStringStackSize];
                                                                                                               var34 = class32.field729[--class101.field1648];
                                                                                                               class32.scriptStringStack[++World.scriptStringStackSize - 1] = var64 + (char)var34;
                                                                                                               var39 = 1;
                                                                                                            } else if(var57 == 4113) {
                                                                                                               var35 = class32.field729[--class101.field1648];
                                                                                                               class32.field729[++class101.field1648 - 1] = ChatLineBuffer.method982((char)var35)?1:0;
                                                                                                               var39 = 1;
                                                                                                            } else if(var57 == 4114) {
                                                                                                               var35 = class32.field729[--class101.field1648];
                                                                                                               class32.field729[++class101.field1648 - 1] = class41.method852((char)var35)?1:0;
                                                                                                               var39 = 1;
                                                                                                            } else {
                                                                                                               char var70;
                                                                                                               if(var57 == 4115) {
                                                                                                                  var35 = class32.field729[--class101.field1648];
                                                                                                                  int[] var63 = class32.field729;
                                                                                                                  var17 = ++class101.field1648 - 1;
                                                                                                                  var70 = (char)var35;
                                                                                                                  var68 = var70 >= 65 && var70 <= 90 || var70 >= 97 && var70 <= 122;
                                                                                                                  var63[var17] = var68?1:0;
                                                                                                                  var39 = 1;
                                                                                                               } else if(var57 == 4116) {
                                                                                                                  var35 = class32.field729[--class101.field1648];
                                                                                                                  class32.field729[++class101.field1648 - 1] = DecorativeObject.method1978((char)var35)?1:0;
                                                                                                                  var39 = 1;
                                                                                                               } else if(var57 == 4117) {
                                                                                                                  var64 = class32.scriptStringStack[--World.scriptStringStackSize];
                                                                                                                  if(var64 != null) {
                                                                                                                     class32.field729[++class101.field1648 - 1] = var64.length();
                                                                                                                  } else {
                                                                                                                     class32.field729[++class101.field1648 - 1] = 0;
                                                                                                                  }

                                                                                                                  var39 = 1;
                                                                                                               } else if(var57 == 4118) {
                                                                                                                  var64 = class32.scriptStringStack[--World.scriptStringStackSize];
                                                                                                                  class101.field1648 -= 2;
                                                                                                                  var34 = class32.field729[class101.field1648];
                                                                                                                  var17 = class32.field729[class101.field1648 + 1];
                                                                                                                  class32.scriptStringStack[++World.scriptStringStackSize - 1] = var64.substring(var34, var17);
                                                                                                                  var39 = 1;
                                                                                                               } else if(var57 != 4119) {
                                                                                                                  if(var57 == 4120) {
                                                                                                                     var64 = class32.scriptStringStack[--World.scriptStringStackSize];
                                                                                                                     var34 = class32.field729[--class101.field1648];
                                                                                                                     class32.field729[++class101.field1648 - 1] = var64.indexOf(var34);
                                                                                                                     var39 = 1;
                                                                                                                  } else if(var57 == 4121) {
                                                                                                                     World.scriptStringStackSize -= 2;
                                                                                                                     var64 = class32.scriptStringStack[World.scriptStringStackSize];
                                                                                                                     var62 = class32.scriptStringStack[1 + World.scriptStringStackSize];
                                                                                                                     var17 = class32.field729[--class101.field1648];
                                                                                                                     class32.field729[++class101.field1648 - 1] = var64.indexOf(var62, var17);
                                                                                                                     var39 = 1;
                                                                                                                  } else {
                                                                                                                     var39 = 2;
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  var64 = class32.scriptStringStack[--World.scriptStringStackSize];
                                                                                                                  StringBuilder var61 = new StringBuilder(var64.length());
                                                                                                                  boolean var66 = false;

                                                                                                                  for(var18 = 0; var18 < var64.length(); ++var18) {
                                                                                                                     var70 = var64.charAt(var18);
                                                                                                                     if(var70 == 60) {
                                                                                                                        var66 = true;
                                                                                                                     } else if(var70 == 62) {
                                                                                                                        var66 = false;
                                                                                                                     } else if(!var66) {
                                                                                                                        var61.append(var70);
                                                                                                                     }
                                                                                                                  }

                                                                                                                  class32.scriptStringStack[++World.scriptStringStackSize - 1] = var61.toString();
                                                                                                                  var39 = 1;
                                                                                                               }
                                                                                                            }
                                                                                                         }
                                                                                                      }

                                                                                                      var13 = var39;
                                                                                                   } else if(var57 < 4300) {
                                                                                                      if(var57 == 4200) {
                                                                                                         var35 = class32.field729[--class101.field1648];
                                                                                                         class32.scriptStringStack[++World.scriptStringStackSize - 1] = class168.getItemDefinition(var35).name;
                                                                                                         var39 = 1;
                                                                                                      } else {
                                                                                                         ItemComposition var100;
                                                                                                         if(var57 == 4201) {
                                                                                                            class101.field1648 -= 2;
                                                                                                            var35 = class32.field729[class101.field1648];
                                                                                                            var34 = class32.field729[1 + class101.field1648];
                                                                                                            var100 = class168.getItemDefinition(var35);
                                                                                                            if(var34 >= 1 && var34 <= 5 && null != var100.groundActions[var34 - 1]) {
                                                                                                               class32.scriptStringStack[++World.scriptStringStackSize - 1] = var100.groundActions[var34 - 1];
                                                                                                            } else {
                                                                                                               class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                                                                                                            }

                                                                                                            var39 = 1;
                                                                                                         } else if(var57 == 4202) {
                                                                                                            class101.field1648 -= 2;
                                                                                                            var35 = class32.field729[class101.field1648];
                                                                                                            var34 = class32.field729[class101.field1648 + 1];
                                                                                                            var100 = class168.getItemDefinition(var35);
                                                                                                            if(var34 >= 1 && var34 <= 5 && var100.inventoryActions[var34 - 1] != null) {
                                                                                                               class32.scriptStringStack[++World.scriptStringStackSize - 1] = var100.inventoryActions[var34 - 1];
                                                                                                            } else {
                                                                                                               class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                                                                                                            }

                                                                                                            var39 = 1;
                                                                                                         } else if(var57 == 4203) {
                                                                                                            var35 = class32.field729[--class101.field1648];
                                                                                                            class32.field729[++class101.field1648 - 1] = class168.getItemDefinition(var35).price;
                                                                                                            var39 = 1;
                                                                                                         } else if(var57 == 4204) {
                                                                                                            var35 = class32.field729[--class101.field1648];
                                                                                                            class32.field729[++class101.field1648 - 1] = class168.getItemDefinition(var35).isStackable == 1?1:0;
                                                                                                            var39 = 1;
                                                                                                         } else {
                                                                                                            ItemComposition var67;
                                                                                                            if(var57 == 4205) {
                                                                                                               var35 = class32.field729[--class101.field1648];
                                                                                                               var67 = class168.getItemDefinition(var35);
                                                                                                               if(var67.notedTemplate == -1 && var67.note >= 0) {
                                                                                                                  class32.field729[++class101.field1648 - 1] = var67.note;
                                                                                                               } else {
                                                                                                                  class32.field729[++class101.field1648 - 1] = var35;
                                                                                                               }

                                                                                                               var39 = 1;
                                                                                                            } else if(var57 == 4206) {
                                                                                                               var35 = class32.field729[--class101.field1648];
                                                                                                               var67 = class168.getItemDefinition(var35);
                                                                                                               if(var67.notedTemplate >= 0 && var67.note >= 0) {
                                                                                                                  class32.field729[++class101.field1648 - 1] = var67.note;
                                                                                                               } else {
                                                                                                                  class32.field729[++class101.field1648 - 1] = var35;
                                                                                                               }

                                                                                                               var39 = 1;
                                                                                                            } else if(var57 == 4207) {
                                                                                                               var35 = class32.field729[--class101.field1648];
                                                                                                               class32.field729[++class101.field1648 - 1] = class168.getItemDefinition(var35).isMembers?1:0;
                                                                                                               var39 = 1;
                                                                                                            } else if(var57 == 4208) {
                                                                                                               var35 = class32.field729[--class101.field1648];
                                                                                                               var67 = class168.getItemDefinition(var35);
                                                                                                               if(var67.field3000 == -1 && var67.field3003 >= 0) {
                                                                                                                  class32.field729[++class101.field1648 - 1] = var67.field3003;
                                                                                                               } else {
                                                                                                                  class32.field729[++class101.field1648 - 1] = var35;
                                                                                                               }

                                                                                                               var39 = 1;
                                                                                                            } else if(var57 == 4209) {
                                                                                                               var35 = class32.field729[--class101.field1648];
                                                                                                               var67 = class168.getItemDefinition(var35);
                                                                                                               if(var67.field3000 >= 0 && var67.field3003 >= 0) {
                                                                                                                  class32.field729[++class101.field1648 - 1] = var67.field3003;
                                                                                                               } else {
                                                                                                                  class32.field729[++class101.field1648 - 1] = var35;
                                                                                                               }

                                                                                                               var39 = 1;
                                                                                                            } else if(var57 == 4210) {
                                                                                                               var64 = class32.scriptStringStack[--World.scriptStringStackSize];
                                                                                                               var34 = class32.field729[--class101.field1648];
                                                                                                               var68 = var34 == 1;
                                                                                                               String var99 = var64.toLowerCase();
                                                                                                               short[] var94 = new short[16];
                                                                                                               var40 = 0;
                                                                                                               var42 = 0;

                                                                                                               while(true) {
                                                                                                                  if(var42 >= class174.field2637) {
                                                                                                                     class149.field2033 = var94;
                                                                                                                     Player.field265 = 0;
                                                                                                                     class119.field1852 = var40;
                                                                                                                     String[] var76 = new String[class119.field1852];

                                                                                                                     for(var22 = 0; var22 < class119.field1852; ++var22) {
                                                                                                                        var76[var22] = class168.getItemDefinition(var94[var22]).name;
                                                                                                                     }

                                                                                                                     Renderable.method1939(var76, class149.field2033);
                                                                                                                     break;
                                                                                                                  }

                                                                                                                  ItemComposition var52 = class168.getItemDefinition(var42);
                                                                                                                  if((!var68 || var52.field2950) && var52.notedTemplate == -1 && var52.name.toLowerCase().indexOf(var99) != -1) {
                                                                                                                     if(var40 >= 250) {
                                                                                                                        class119.field1852 = -1;
                                                                                                                        class149.field2033 = null;
                                                                                                                        break;
                                                                                                                     }

                                                                                                                     if(var40 >= var94.length) {
                                                                                                                        short[] var53 = new short[var94.length * 2];

                                                                                                                        for(var24 = 0; var24 < var40; ++var24) {
                                                                                                                           var53[var24] = var94[var24];
                                                                                                                        }

                                                                                                                        var94 = var53;
                                                                                                                     }

                                                                                                                     var94[var40++] = (short)var42;
                                                                                                                  }

                                                                                                                  ++var42;
                                                                                                               }

                                                                                                               class32.field729[++class101.field1648 - 1] = class119.field1852;
                                                                                                               var39 = 1;
                                                                                                            } else if(var57 != 4211) {
                                                                                                               if(var57 == 4212) {
                                                                                                                  Player.field265 = 0;
                                                                                                                  var39 = 1;
                                                                                                               } else {
                                                                                                                  var39 = 2;
                                                                                                               }
                                                                                                            } else {
                                                                                                               if(class149.field2033 != null && Player.field265 < class119.field1852) {
                                                                                                                  class32.field729[++class101.field1648 - 1] = class149.field2033[++Player.field265 - 1] & '\uffff';
                                                                                                               } else {
                                                                                                                  class32.field729[++class101.field1648 - 1] = -1;
                                                                                                               }

                                                                                                               var39 = 1;
                                                                                                            }
                                                                                                         }
                                                                                                      }

                                                                                                      var13 = var39;
                                                                                                   } else if(var57 < 5100) {
                                                                                                      var13 = class16.method195(var57, var4, var65);
                                                                                                   } else if(var57 < 5400) {
                                                                                                      if(var57 == 5306) {
                                                                                                         class32.field729[++class101.field1648 - 1] = Actor.method632();
                                                                                                         var39 = 1;
                                                                                                      } else if(var57 == 5307) {
                                                                                                         var35 = class32.field729[--class101.field1648];
                                                                                                         if(var35 == 1 || var35 == 2) {
                                                                                                            Client.field427 = 0L;
                                                                                                            if(var35 >= 2) {
                                                                                                               Client.isResized = true;
                                                                                                            } else {
                                                                                                               Client.isResized = false;
                                                                                                            }

                                                                                                            class88.method1938();
                                                                                                            if(Client.gameState >= 25) {
                                                                                                               Client.field327.method3124(166);
                                                                                                               Client.field327.method3010(Actor.method632());
                                                                                                               Client.field327.method2842(class2.field21);
                                                                                                               Client.field327.method2842(class20.field216);
                                                                                                            }

                                                                                                            GameEngine.field1773 = true;
                                                                                                         }

                                                                                                         var39 = 1;
                                                                                                      } else if(var57 == 5308) {
                                                                                                         class32.field729[++class101.field1648 - 1] = WallObject.field1551.field693;
                                                                                                         var39 = 1;
                                                                                                      } else if(var57 != 5309) {
                                                                                                         var39 = 2;
                                                                                                      } else {
                                                                                                         var35 = class32.field729[--class101.field1648];
                                                                                                         if(var35 == 1 || var35 == 2) {
                                                                                                            WallObject.field1551.field693 = var35;
                                                                                                            DecorativeObject.method1977();
                                                                                                         }

                                                                                                         var39 = 1;
                                                                                                      }

                                                                                                      var13 = var39;
                                                                                                   } else if(var57 < 5600) {
                                                                                                      if(var57 == 5504) {
                                                                                                         class101.field1648 -= 2;
                                                                                                         var18 = class32.field729[class101.field1648];
                                                                                                         var19 = class32.field729[class101.field1648 + 1];
                                                                                                         if(!Client.field332) {
                                                                                                            Client.field368 = var18;
                                                                                                            Client.mapAngle = var19;
                                                                                                         }

                                                                                                         var39 = 1;
                                                                                                      } else if(var57 == 5505) {
                                                                                                         class32.field729[++class101.field1648 - 1] = Client.field368;
                                                                                                         var39 = 1;
                                                                                                      } else if(var57 == 5506) {
                                                                                                         class32.field729[++class101.field1648 - 1] = Client.mapAngle;
                                                                                                         var39 = 1;
                                                                                                      } else if(var57 == 5530) {
                                                                                                         var18 = class32.field729[--class101.field1648];
                                                                                                         if(var18 < 0) {
                                                                                                            var18 = 0;
                                                                                                         }

                                                                                                         Client.field374 = var18;
                                                                                                         var39 = 1;
                                                                                                      } else if(var57 == 5531) {
                                                                                                         class32.field729[++class101.field1648 - 1] = Client.field374;
                                                                                                         var39 = 1;
                                                                                                      } else {
                                                                                                         var39 = 2;
                                                                                                      }

                                                                                                      var13 = var39;
                                                                                                   } else if(var57 < 5700) {
                                                                                                      var13 = class47.method947(var57, var4, var65);
                                                                                                   } else if(var57 < 6300) {
                                                                                                      if(var57 == 6200) {
                                                                                                         class101.field1648 -= 2;
                                                                                                         Client.field539 = (short)class32.field729[class101.field1648];
                                                                                                         if(Client.field539 <= 0) {
                                                                                                            Client.field539 = 256;
                                                                                                         }

                                                                                                         Client.field360 = (short)class32.field729[1 + class101.field1648];
                                                                                                         if(Client.field360 <= 0) {
                                                                                                            Client.field360 = 205;
                                                                                                         }

                                                                                                         var39 = 1;
                                                                                                      } else if(var57 == 6201) {
                                                                                                         class101.field1648 -= 2;
                                                                                                         Client.field541 = (short)class32.field729[class101.field1648];
                                                                                                         if(Client.field541 <= 0) {
                                                                                                            Client.field541 = 256;
                                                                                                         }

                                                                                                         Client.field542 = (short)class32.field729[1 + class101.field1648];
                                                                                                         if(Client.field542 <= 0) {
                                                                                                            Client.field542 = 320;
                                                                                                         }

                                                                                                         var39 = 1;
                                                                                                      } else if(var57 == 6202) {
                                                                                                         class101.field1648 -= 4;
                                                                                                         Client.field400 = (short)class32.field729[class101.field1648];
                                                                                                         if(Client.field400 <= 0) {
                                                                                                            Client.field400 = 1;
                                                                                                         }

                                                                                                         Client.field505 = (short)class32.field729[1 + class101.field1648];
                                                                                                         if(Client.field505 <= 0) {
                                                                                                            Client.field505 = 32767;
                                                                                                         } else if(Client.field505 < Client.field400) {
                                                                                                            Client.field505 = Client.field400;
                                                                                                         }

                                                                                                         Client.field555 = (short)class32.field729[2 + class101.field1648];
                                                                                                         if(Client.field555 <= 0) {
                                                                                                            Client.field555 = 1;
                                                                                                         }

                                                                                                         Client.field556 = (short)class32.field729[3 + class101.field1648];
                                                                                                         if(Client.field556 <= 0) {
                                                                                                            Client.field556 = 32767;
                                                                                                         } else if(Client.field556 < Client.field555) {
                                                                                                            Client.field556 = Client.field555;
                                                                                                         }

                                                                                                         var39 = 1;
                                                                                                      } else if(var57 == 6203) {
                                                                                                         if(Client.field457 != null) {
                                                                                                            class103.method2025(0, 0, Client.field457.width, Client.field457.height, false);
                                                                                                            class32.field729[++class101.field1648 - 1] = Client.camera2;
                                                                                                            class32.field729[++class101.field1648 - 1] = Client.camera3;
                                                                                                         } else {
                                                                                                            class32.field729[++class101.field1648 - 1] = -1;
                                                                                                            class32.field729[++class101.field1648 - 1] = -1;
                                                                                                         }

                                                                                                         var39 = 1;
                                                                                                      } else if(var57 == 6204) {
                                                                                                         class32.field729[++class101.field1648 - 1] = Client.field541;
                                                                                                         class32.field729[++class101.field1648 - 1] = Client.field542;
                                                                                                         var39 = 1;
                                                                                                      } else if(var57 == 6205) {
                                                                                                         class32.field729[++class101.field1648 - 1] = Client.field539;
                                                                                                         class32.field729[++class101.field1648 - 1] = Client.field360;
                                                                                                         var39 = 1;
                                                                                                      } else {
                                                                                                         var39 = 2;
                                                                                                      }

                                                                                                      var13 = var39;
                                                                                                   } else if(var57 < 6600) {
                                                                                                      var13 = class177.method3330(var57, var4, var65);
                                                                                                   } else {
                                                                                                      var13 = 2;
                                                                                                   }
                                                                                                }
                                                                                             }

                                                                                             switch(var13) {
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
         } catch (Exception var56) {
            StringBuilder var55 = new StringBuilder(30);
            var55.append("").append(var4.hash).append(" ");

            for(var11 = class32.scriptStackCount - 1; var11 >= 0; --var11) {
               var55.append("").append(class32.scriptStack[var11].field118.hash).append(" ");
            }

            var55.append("").append(var8);
            FaceNormal.method1950(var55.toString(), var56);
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;S)V",
      garbageValue = "236"
   )
   public abstract void vmethod2152(Component var1);

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1045567041"
   )
   static int method2159(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class32.field719:class185.field2760;
      if(var0 == 1600) {
         class32.field729[++class101.field1648 - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 1601) {
         class32.field729[++class101.field1648 - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 1602) {
         class32.scriptStringStack[++World.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 1603) {
         class32.field729[++class101.field1648 - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 1604) {
         class32.field729[++class101.field1648 - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 1605) {
         class32.field729[++class101.field1648 - 1] = var3.field2238;
         return 1;
      } else if(var0 == 1606) {
         class32.field729[++class101.field1648 - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 1607) {
         class32.field729[++class101.field1648 - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 1608) {
         class32.field729[++class101.field1648 - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 1609) {
         class32.field729[++class101.field1648 - 1] = var3.opacity;
         return 1;
      } else if(var0 == 1610) {
         class32.field729[++class101.field1648 - 1] = var3.field2228;
         return 1;
      } else if(var0 == 1611) {
         class32.field729[++class101.field1648 - 1] = var3.textColor;
         return 1;
      } else if(var0 == 1612) {
         class32.field729[++class101.field1648 - 1] = var3.field2222;
         return 1;
      } else if(var0 == 1613) {
         class32.field729[++class101.field1648 - 1] = var3.field2329.vmethod4183();
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;B)V",
      garbageValue = "97"
   )
   public static void method2160(class182 var0, class182 var1) {
      NPCComposition.field3037 = var0;
      NPCComposition.field3007 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIII)Z",
      garbageValue = "16777215"
   )
   static final boolean method2161(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label85:
      while(true) {
         int var6 = var4.method2991();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.method2991();
               if(var9 == 0) {
                  continue label85;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.readUnsignedByte() >> 2;
               int var13 = var11 + var1;
               int var14 = var10 + var2;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  ObjectComposition var15 = class196.getObjectDefinition(var5);
                  if(var12 != 22 || !Client.field404 || var15.field2922 != 0 || var15.field2914 == 1 || var15.field2935) {
                     if(!var15.method3684()) {
                        ++Client.field532;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.method2991();
            if(var9 == 0) {
               break;
            }

            var4.readUnsignedByte();
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1425006577"
   )
   public abstract void vmethod2162(Component var1);
}
