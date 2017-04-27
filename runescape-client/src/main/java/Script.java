import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("c")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("n")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("q")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -789168359
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1993481445
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2099442795
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("l")
   class142[] field937;
   @ObfuscatedName("ea")
   static SpritePixels[] field938;
   @ObfuscatedName("bq")
   @Export("host")
   static String host;
   @ObfuscatedName("r")
   static Widget field942;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 564632501
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("d")
   static NodeCache field944 = new NodeCache(128);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)[Lclass142;",
      garbageValue = "109345847"
   )
   class142[] method905(int var1) {
      return new class142[var1];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass18;IB)V",
      garbageValue = "25"
   )
   static void method910(class18 var0, int var1) {
      Object[] var2 = var0.field196;
      int var3 = ((Integer)var2[0]).intValue();
      Script var4 = class49.method918(var3);
      if(var4 != null) {
         class32.field715 = 0;
         class32.scriptStringStackSize = 0;
         int var5 = -1;
         int[] var6 = var4.instructions;
         int[] var7 = var4.intOperands;
         byte var8 = -1;
         class32.scriptStackCount = 0;

         int var11;
         try {
            class32.field718 = new int[var4.localIntCount];
            int var9 = 0;
            class32.field717 = new String[var4.localStringCount];
            int var10 = 0;

            int var12;
            String var32;
            for(var11 = 1; var11 < var2.length; ++var11) {
               if(var2[var11] instanceof Integer) {
                  var12 = ((Integer)var2[var11]).intValue();
                  if(var12 == -2147483647) {
                     var12 = var0.field193;
                  }

                  if(var12 == -2147483646) {
                     var12 = var0.field187;
                  }

                  if(var12 == -2147483645) {
                     var12 = var0.field189 != null?var0.field189.id:-1;
                  }

                  if(var12 == -2147483644) {
                     var12 = var0.field192;
                  }

                  if(var12 == -2147483643) {
                     var12 = var0.field189 != null?var0.field189.index:-1;
                  }

                  if(var12 == -2147483642) {
                     var12 = var0.field195 != null?var0.field195.id:-1;
                  }

                  if(var12 == -2147483641) {
                     var12 = var0.field195 != null?var0.field195.index:-1;
                  }

                  if(var12 == -2147483640) {
                     var12 = var0.field191;
                  }

                  if(var12 == -2147483639) {
                     var12 = var0.field198;
                  }

                  class32.field718[var9++] = var12;
               } else if(var2[var11] instanceof String) {
                  var32 = (String)var2[var11];
                  if(var32.equals("event_opbase")) {
                     var32 = var0.field190;
                  }

                  class32.field717[var10++] = var32;
               }
            }

            var11 = 0;
            class32.field716 = var0.field197;

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
                                                                                       label1444:
                                                                                       while(true) {
                                                                                          ++var11;
                                                                                          if(var11 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var5;
                                                                                          int var54 = var6[var5];
                                                                                          int var15;
                                                                                          int var17;
                                                                                          int var18;
                                                                                          String var20;
                                                                                          int var33;
                                                                                          int var37;
                                                                                          String var58;
                                                                                          String var64;
                                                                                          int var84;
                                                                                          if(var54 < 100) {
                                                                                             if(var54 != 0) {
                                                                                                if(var54 != 1) {
                                                                                                   if(var54 != 2) {
                                                                                                      if(var54 != 3) {
                                                                                                         if(var54 != 6) {
                                                                                                            if(var54 != 7) {
                                                                                                               if(var54 != 8) {
                                                                                                                  if(var54 != 9) {
                                                                                                                     if(var54 != 10) {
                                                                                                                        if(var54 != 21) {
                                                                                                                           if(var54 != 25) {
                                                                                                                              if(var54 != 27) {
                                                                                                                                 if(var54 != 31) {
                                                                                                                                    if(var54 != 32) {
                                                                                                                                       if(var54 != 33) {
                                                                                                                                          if(var54 != 34) {
                                                                                                                                             if(var54 != 35) {
                                                                                                                                                if(var54 != 36) {
                                                                                                                                                   if(var54 != 37) {
                                                                                                                                                      if(var54 != 38) {
                                                                                                                                                         if(var54 != 39) {
                                                                                                                                                            if(var54 != 40) {
                                                                                                                                                               if(var54 != 42) {
                                                                                                                                                                  if(var54 != 43) {
                                                                                                                                                                     if(var54 == 44) {
                                                                                                                                                                        var12 = var7[var5] >> 16;
                                                                                                                                                                        var37 = var7[var5] & '\uffff';
                                                                                                                                                                        int var92 = class32.field720[--class32.field715];
                                                                                                                                                                        if(var92 >= 0 && var92 <= 5000) {
                                                                                                                                                                           class32.field719[var12] = var92;
                                                                                                                                                                           byte var77 = -1;
                                                                                                                                                                           if(var37 == 105) {
                                                                                                                                                                              var77 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var33 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var33 >= var92) {
                                                                                                                                                                                 continue label1444;
                                                                                                                                                                              }

                                                                                                                                                                              class32.field728[var12][var33] = var77;
                                                                                                                                                                              ++var33;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var54 == 45) {
                                                                                                                                                                        var12 = var7[var5];
                                                                                                                                                                        var37 = class32.field720[--class32.field715];
                                                                                                                                                                        if(var37 < 0 || var37 >= class32.field719[var12]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class32.field720[++class32.field715 - 1] = class32.field728[var12][var37];
                                                                                                                                                                     } else if(var54 == 46) {
                                                                                                                                                                        var12 = var7[var5];
                                                                                                                                                                        class32.field715 -= 2;
                                                                                                                                                                        var37 = class32.field720[class32.field715];
                                                                                                                                                                        if(var37 < 0 || var37 >= class32.field719[var12]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class32.field728[var12][var37] = class32.field720[class32.field715 + 1];
                                                                                                                                                                     } else if(var54 == 47) {
                                                                                                                                                                        var32 = XClanMember.chatMessages.method886(var7[var5]);
                                                                                                                                                                        if(var32 == null) {
                                                                                                                                                                           var32 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var32;
                                                                                                                                                                     } else if(var54 == 48) {
                                                                                                                                                                        XClanMember.chatMessages.method875(var7[var5], class32.scriptStringStack[--class32.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var54 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        class142 var78 = var4.field937[var7[var5]];
                                                                                                                                                                        class154 var57 = (class154)var78.method2728((long)class32.field720[--class32.field715]);
                                                                                                                                                                        if(var57 != null) {
                                                                                                                                                                           var5 += var57.field2046;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     XClanMember.chatMessages.method858(var7[var5], class32.field720[--class32.field715]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class32.field720[++class32.field715 - 1] = XClanMember.chatMessages.method859(var7[var5]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var12 = var7[var5];
                                                                                                                                                               Script var56 = class49.method918(var12);
                                                                                                                                                               int[] var55 = new int[var56.localIntCount];
                                                                                                                                                               String[] var91 = new String[var56.localStringCount];

                                                                                                                                                               for(var33 = 0; var33 < var56.intStackCount; ++var33) {
                                                                                                                                                                  var55[var33] = class32.field720[var33 + (class32.field715 - var56.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var33 = 0; var33 < var56.stringStackCount; ++var33) {
                                                                                                                                                                  var91[var33] = class32.scriptStringStack[var33 + (class32.scriptStringStackSize - var56.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class32.field715 -= var56.intStackCount;
                                                                                                                                                               class32.scriptStringStackSize -= var56.stringStackCount;
                                                                                                                                                               ScriptState var68 = new ScriptState();
                                                                                                                                                               var68.field113 = var4;
                                                                                                                                                               var68.field118 = var5;
                                                                                                                                                               var68.field114 = class32.field718;
                                                                                                                                                               var68.field115 = class32.field717;
                                                                                                                                                               class32.scriptStack[++class32.scriptStackCount - 1] = var68;
                                                                                                                                                               var4 = var56;
                                                                                                                                                               var6 = var56.instructions;
                                                                                                                                                               var7 = var56.intOperands;
                                                                                                                                                               var5 = -1;
                                                                                                                                                               class32.field718 = var55;
                                                                                                                                                               class32.field717 = var91;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --class32.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class32.field715;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var12 = var7[var5];
                                                                                                                                                      class32.scriptStringStackSize -= var12;
                                                                                                                                                      String[] var14 = class32.scriptStringStack;
                                                                                                                                                      var15 = class32.scriptStringStackSize;
                                                                                                                                                      String var13;
                                                                                                                                                      if(var12 == 0) {
                                                                                                                                                         var13 = "";
                                                                                                                                                      } else if(var12 == 1) {
                                                                                                                                                         var58 = var14[var15];
                                                                                                                                                         if(var58 == null) {
                                                                                                                                                            var13 = "null";
                                                                                                                                                         } else {
                                                                                                                                                            var13 = var58.toString();
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         var33 = var15 + var12;
                                                                                                                                                         var17 = 0;

                                                                                                                                                         for(var18 = var15; var18 < var33; ++var18) {
                                                                                                                                                            var64 = var14[var18];
                                                                                                                                                            if(var64 == null) {
                                                                                                                                                               var17 += 4;
                                                                                                                                                            } else {
                                                                                                                                                               var17 += var64.length();
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         StringBuilder var83 = new StringBuilder(var17);

                                                                                                                                                         for(var84 = var15; var84 < var33; ++var84) {
                                                                                                                                                            var20 = var14[var84];
                                                                                                                                                            if(var20 == null) {
                                                                                                                                                               var83.append("null");
                                                                                                                                                            } else {
                                                                                                                                                               var83.append(var20);
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         var13 = var83.toString();
                                                                                                                                                      }

                                                                                                                                                      class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var13;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class32.field717[var7[var5]] = class32.scriptStringStack[--class32.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class32.scriptStringStack[++class32.scriptStringStackSize - 1] = class32.field717[var7[var5]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class32.field718[var7[var5]] = class32.field720[--class32.field715];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class32.field720[++class32.field715 - 1] = class32.field718[var7[var5]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class32.field715 -= 2;
                                                                                                                                       if(class32.field720[class32.field715] >= class32.field720[class32.field715 + 1]) {
                                                                                                                                          var5 += var7[var5];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class32.field715 -= 2;
                                                                                                                                    if(class32.field720[class32.field715] <= class32.field720[class32.field715 + 1]) {
                                                                                                                                       var5 += var7[var5];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var12 = var7[var5];
                                                                                                                                 class88.method1894(var12, class32.field720[--class32.field715]);
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var12 = var7[var5];
                                                                                                                              class32.field720[++class32.field715 - 1] = class59.method1140(var12);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class32.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var76 = class32.scriptStack[--class32.scriptStackCount];
                                                                                                                           var4 = var76.field113;
                                                                                                                           var6 = var4.instructions;
                                                                                                                           var7 = var4.intOperands;
                                                                                                                           var5 = var76.field118;
                                                                                                                           class32.field718 = var76.field114;
                                                                                                                           class32.field717 = var76.field115;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class32.field715 -= 2;
                                                                                                                        if(class32.field720[class32.field715] > class32.field720[class32.field715 + 1]) {
                                                                                                                           var5 += var7[var5];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class32.field715 -= 2;
                                                                                                                     if(class32.field720[class32.field715] < class32.field720[class32.field715 + 1]) {
                                                                                                                        var5 += var7[var5];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class32.field715 -= 2;
                                                                                                                  if(class32.field720[class32.field715 + 1] == class32.field720[class32.field715]) {
                                                                                                                     var5 += var7[var5];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class32.field715 -= 2;
                                                                                                               if(class32.field720[class32.field715 + 1] != class32.field720[class32.field715]) {
                                                                                                                  var5 += var7[var5];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var5 += var7[var5];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var4.stringOperands[var5];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var12 = var7[var5];
                                                                                                      class167.widgetSettings[var12] = class32.field720[--class32.field715];
                                                                                                      class167.method3139(var12);
                                                                                                   }
                                                                                                } else {
                                                                                                   var12 = var7[var5];
                                                                                                   class32.field720[++class32.field715 - 1] = class167.widgetSettings[var12];
                                                                                                }
                                                                                             } else {
                                                                                                class32.field720[++class32.field715 - 1] = var7[var5];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var61;
                                                                                             if(var4.intOperands[var5] == 1) {
                                                                                                var61 = true;
                                                                                             } else {
                                                                                                var61 = false;
                                                                                             }

                                                                                             if(var54 < 1000) {
                                                                                                var37 = class179.method3274(var54, var4, var61);
                                                                                             } else if(var54 < 1100) {
                                                                                                var37 = class45.method850(var54, var4, var61);
                                                                                             } else if(var54 < 1200) {
                                                                                                var37 = class107.method2057(var54, var4, var61);
                                                                                             } else if(var54 < 1300) {
                                                                                                var37 = XClanMember.method255(var54, var4, var61);
                                                                                             } else if(var54 < 1400) {
                                                                                                var37 = class125.method2355(var54, var4, var61);
                                                                                             } else if(var54 < 1500) {
                                                                                                var37 = class57.method1082(var54, var4, var61);
                                                                                             } else if(var54 < 1600) {
                                                                                                var37 = class103.method1964(var54, var4, var61);
                                                                                             } else if(var54 < 1700) {
                                                                                                var37 = class44.method834(var54, var4, var61);
                                                                                             } else {
                                                                                                Widget var34;
                                                                                                byte var38;
                                                                                                if(var54 < 1800) {
                                                                                                   var34 = var61?class200.field2894:field942;
                                                                                                   if(var54 == 1700) {
                                                                                                      class32.field720[++class32.field715 - 1] = var34.item;
                                                                                                      var38 = 1;
                                                                                                   } else if(var54 == 1701) {
                                                                                                      if(var34.item != -1) {
                                                                                                         class32.field720[++class32.field715 - 1] = var34.stackSize;
                                                                                                      } else {
                                                                                                         class32.field720[++class32.field715 - 1] = 0;
                                                                                                      }

                                                                                                      var38 = 1;
                                                                                                   } else if(var54 == 1702) {
                                                                                                      class32.field720[++class32.field715 - 1] = var34.index;
                                                                                                      var38 = 1;
                                                                                                   } else {
                                                                                                      var38 = 2;
                                                                                                   }

                                                                                                   var37 = var38;
                                                                                                } else if(var54 < 1900) {
                                                                                                   var37 = class16.method191(var54, var4, var61);
                                                                                                } else if(var54 < 2000) {
                                                                                                   var37 = CombatInfo2.method3560(var54, var4, var61);
                                                                                                } else if(var54 < 2100) {
                                                                                                   var37 = class45.method850(var54, var4, var61);
                                                                                                } else if(var54 < 2200) {
                                                                                                   var37 = class107.method2057(var54, var4, var61);
                                                                                                } else if(var54 < 2300) {
                                                                                                   var37 = XClanMember.method255(var54, var4, var61);
                                                                                                } else if(var54 < 2400) {
                                                                                                   var37 = class125.method2355(var54, var4, var61);
                                                                                                } else if(var54 < 2500) {
                                                                                                   var37 = class57.method1082(var54, var4, var61);
                                                                                                } else if(var54 < 2600) {
                                                                                                   var37 = FrameMap.method1719(var54, var4, var61);
                                                                                                } else if(var54 < 2700) {
                                                                                                   var37 = Friend.method180(var54, var4, var61);
                                                                                                } else {
                                                                                                   Widget var36;
                                                                                                   if(var54 < 2800) {
                                                                                                      if(var54 == 2700) {
                                                                                                         var36 = class128.method2364(class32.field720[--class32.field715]);
                                                                                                         class32.field720[++class32.field715 - 1] = var36.item;
                                                                                                         var38 = 1;
                                                                                                      } else if(var54 == 2701) {
                                                                                                         var36 = class128.method2364(class32.field720[--class32.field715]);
                                                                                                         if(var36.item != -1) {
                                                                                                            class32.field720[++class32.field715 - 1] = var36.stackSize;
                                                                                                         } else {
                                                                                                            class32.field720[++class32.field715 - 1] = 0;
                                                                                                         }

                                                                                                         var38 = 1;
                                                                                                      } else if(var54 == 2702) {
                                                                                                         var15 = class32.field720[--class32.field715];
                                                                                                         WidgetNode var16 = (WidgetNode)Client.componentTable.method2773((long)var15);
                                                                                                         if(var16 != null) {
                                                                                                            class32.field720[++class32.field715 - 1] = 1;
                                                                                                         } else {
                                                                                                            class32.field720[++class32.field715 - 1] = 0;
                                                                                                         }

                                                                                                         var38 = 1;
                                                                                                      } else if(var54 == 2706) {
                                                                                                         class32.field720[++class32.field715 - 1] = Client.widgetRoot;
                                                                                                         var38 = 1;
                                                                                                      } else {
                                                                                                         var38 = 2;
                                                                                                      }

                                                                                                      var37 = var38;
                                                                                                   } else if(var54 < 2900) {
                                                                                                      var36 = class128.method2364(class32.field720[--class32.field715]);
                                                                                                      if(var54 == 2800) {
                                                                                                         class32.field720[++class32.field715 - 1] = CombatInfo2.method3540(class103.method1988(var36));
                                                                                                         var38 = 1;
                                                                                                      } else if(var54 != 2801) {
                                                                                                         if(var54 == 2802) {
                                                                                                            if(var36.name == null) {
                                                                                                               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                                                                                                            } else {
                                                                                                               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var36.name;
                                                                                                            }

                                                                                                            var38 = 1;
                                                                                                         } else {
                                                                                                            var38 = 2;
                                                                                                         }
                                                                                                      } else {
                                                                                                         var33 = class32.field720[--class32.field715];
                                                                                                         --var33;
                                                                                                         if(var36.actions != null && var33 < var36.actions.length && var36.actions[var33] != null) {
                                                                                                            class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var36.actions[var33];
                                                                                                         } else {
                                                                                                            class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                                                                                                         }

                                                                                                         var38 = 1;
                                                                                                      }

                                                                                                      var37 = var38;
                                                                                                   } else if(var54 < 3000) {
                                                                                                      var37 = CombatInfo2.method3560(var54, var4, var61);
                                                                                                   } else {
                                                                                                      int var39;
                                                                                                      boolean var80;
                                                                                                      String var86;
                                                                                                      if(var54 < 3200) {
                                                                                                         if(var54 == 3100) {
                                                                                                            var86 = class32.scriptStringStack[--class32.scriptStringStackSize];
                                                                                                            WidgetNode.sendGameMessage(0, "", var86);
                                                                                                            var38 = 1;
                                                                                                         } else if(var54 == 3101) {
                                                                                                            class32.field715 -= 2;
                                                                                                            Player.method250(class22.localPlayer, class32.field720[class32.field715], class32.field720[class32.field715 + 1]);
                                                                                                            var38 = 1;
                                                                                                         } else if(var54 == 3103) {
                                                                                                            Client.secretCipherBuffer1.putOpcode(197);
                                                                                                            WidgetNode var87 = (WidgetNode)Client.componentTable.method2776();

                                                                                                            while(true) {
                                                                                                               if(var87 == null) {
                                                                                                                  if(Client.field449 != null) {
                                                                                                                     class124.method2350(Client.field449);
                                                                                                                     Client.field449 = null;
                                                                                                                  }

                                                                                                                  var38 = 1;
                                                                                                                  break;
                                                                                                               }

                                                                                                               if(var87.field179 == 0 || var87.field179 == 3) {
                                                                                                                  FrameMap.method1718(var87, true);
                                                                                                               }

                                                                                                               var87 = (WidgetNode)Client.componentTable.method2777();
                                                                                                            }
                                                                                                         } else if(var54 == 3104) {
                                                                                                            var86 = class32.scriptStringStack[--class32.scriptStringStackSize];
                                                                                                            var33 = 0;
                                                                                                            if(class161.method3023(var86)) {
                                                                                                               var17 = Actor.method595(var86, 10, true);
                                                                                                               var33 = var17;
                                                                                                            }

                                                                                                            Client.secretCipherBuffer1.putOpcode(74);
                                                                                                            Client.secretCipherBuffer1.putInt(var33);
                                                                                                            var38 = 1;
                                                                                                         } else if(var54 == 3105) {
                                                                                                            var86 = class32.scriptStringStack[--class32.scriptStringStackSize];
                                                                                                            Client.secretCipherBuffer1.putOpcode(109);
                                                                                                            Client.secretCipherBuffer1.putByte(var86.length() + 1);
                                                                                                            Client.secretCipherBuffer1.method2504(var86);
                                                                                                            var38 = 1;
                                                                                                         } else if(var54 == 3106) {
                                                                                                            var86 = class32.scriptStringStack[--class32.scriptStringStackSize];
                                                                                                            Client.secretCipherBuffer1.putOpcode(162);
                                                                                                            Client.secretCipherBuffer1.putByte(var86.length() + 1);
                                                                                                            Client.secretCipherBuffer1.method2504(var86);
                                                                                                            var38 = 1;
                                                                                                         } else if(var54 != 3107) {
                                                                                                            if(var54 == 3108) {
                                                                                                               class32.field715 -= 3;
                                                                                                               var15 = class32.field720[class32.field715];
                                                                                                               var33 = class32.field720[class32.field715 + 1];
                                                                                                               var17 = class32.field720[class32.field715 + 2];
                                                                                                               var34 = class128.method2364(var17);
                                                                                                               class49.method919(var34, var15, var33);
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 3109) {
                                                                                                               class32.field715 -= 2;
                                                                                                               var15 = class32.field720[class32.field715];
                                                                                                               var33 = class32.field720[class32.field715 + 1];
                                                                                                               Widget var40 = var61?class200.field2894:field942;
                                                                                                               class49.method919(var40, var15, var33);
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 3110) {
                                                                                                               CombatInfo1.field662 = class32.field720[--class32.field715] == 1;
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 3111) {
                                                                                                               class32.field720[++class32.field715 - 1] = Actor.field656.field690?1:0;
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 3112) {
                                                                                                               Actor.field656.field690 = class32.field720[--class32.field715] == 1;
                                                                                                               Renderable.method1896();
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 3113) {
                                                                                                               var86 = class32.scriptStringStack[--class32.scriptStringStackSize];
                                                                                                               var80 = class32.field720[--class32.field715] == 1;
                                                                                                               class128.method2366(var86, var80, "openjs", false);
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 3115) {
                                                                                                               var15 = class32.field720[--class32.field715];
                                                                                                               Client.secretCipherBuffer1.putOpcode(50);
                                                                                                               Client.secretCipherBuffer1.putShort(var15);
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 3116) {
                                                                                                               var15 = class32.field720[--class32.field715];
                                                                                                               class32.scriptStringStackSize -= 2;
                                                                                                               var58 = class32.scriptStringStack[class32.scriptStringStackSize];
                                                                                                               String var88 = class32.scriptStringStack[class32.scriptStringStackSize + 1];
                                                                                                               if(var58.length() > 500) {
                                                                                                                  var38 = 1;
                                                                                                               } else if(var88.length() > 500) {
                                                                                                                  var38 = 1;
                                                                                                               } else {
                                                                                                                  Client.secretCipherBuffer1.putOpcode(173);
                                                                                                                  Client.secretCipherBuffer1.putShort(class36.method753(var58) + 1 + class36.method753(var88));
                                                                                                                  Client.secretCipherBuffer1.method2499(var15);
                                                                                                                  Client.secretCipherBuffer1.method2504(var58);
                                                                                                                  Client.secretCipherBuffer1.method2504(var88);
                                                                                                                  var38 = 1;
                                                                                                               }
                                                                                                            } else if(var54 == 3117) {
                                                                                                               Client.field432 = class32.field720[--class32.field715] == 1;
                                                                                                               var38 = 1;
                                                                                                            } else {
                                                                                                               var38 = 2;
                                                                                                            }
                                                                                                         } else {
                                                                                                            var15 = class32.field720[--class32.field715];
                                                                                                            var58 = class32.scriptStringStack[--class32.scriptStringStackSize];
                                                                                                            var17 = class45.field891;
                                                                                                            int[] var79 = class45.field894;
                                                                                                            boolean var35 = false;

                                                                                                            for(var39 = 0; var39 < var17; ++var39) {
                                                                                                               Player var21 = Client.cachedPlayers[var79[var39]];
                                                                                                               if(var21 != null && class22.localPlayer != var21 && var21.name != null && var21.name.equalsIgnoreCase(var58)) {
                                                                                                                  if(var15 == 1) {
                                                                                                                     Client.secretCipherBuffer1.putOpcode(164);
                                                                                                                     Client.secretCipherBuffer1.putShort(var79[var39]);
                                                                                                                     Client.secretCipherBuffer1.method2429(0);
                                                                                                                  } else if(var15 == 4) {
                                                                                                                     Client.secretCipherBuffer1.putOpcode(73);
                                                                                                                     Client.secretCipherBuffer1.method2526(var79[var39]);
                                                                                                                     Client.secretCipherBuffer1.putByte(0);
                                                                                                                  } else if(var15 == 6) {
                                                                                                                     Client.secretCipherBuffer1.putOpcode(32);
                                                                                                                     Client.secretCipherBuffer1.method2526(var79[var39]);
                                                                                                                     Client.secretCipherBuffer1.method2499(0);
                                                                                                                  } else if(var15 == 7) {
                                                                                                                     Client.secretCipherBuffer1.putOpcode(40);
                                                                                                                     Client.secretCipherBuffer1.method2499(0);
                                                                                                                     Client.secretCipherBuffer1.method2375(var79[var39]);
                                                                                                                  }

                                                                                                                  var35 = true;
                                                                                                                  break;
                                                                                                               }
                                                                                                            }

                                                                                                            if(!var35) {
                                                                                                               WidgetNode.sendGameMessage(4, "", "Unable to find " + var58);
                                                                                                            }

                                                                                                            var38 = 1;
                                                                                                         }

                                                                                                         var37 = var38;
                                                                                                      } else if(var54 < 3300) {
                                                                                                         if(var54 == 3200) {
                                                                                                            class32.field715 -= 3;
                                                                                                            var15 = class32.field720[class32.field715];
                                                                                                            var33 = class32.field720[class32.field715 + 1];
                                                                                                            var17 = class32.field720[class32.field715 + 2];
                                                                                                            if(Client.field551 != 0 && var33 != 0 && Client.field528 < 50) {
                                                                                                               Client.field529[Client.field528] = var15;
                                                                                                               Client.field530[Client.field528] = var33;
                                                                                                               Client.field442[Client.field528] = var17;
                                                                                                               Client.field504[Client.field528] = null;
                                                                                                               Client.field493[Client.field528] = 0;
                                                                                                               ++Client.field528;
                                                                                                            }

                                                                                                            var38 = 1;
                                                                                                         } else if(var54 != 3201) {
                                                                                                            if(var54 == 3202) {
                                                                                                               class32.field715 -= 2;
                                                                                                               class183.method3291(class32.field720[class32.field715], class32.field720[class32.field715 + 1]);
                                                                                                               var38 = 1;
                                                                                                            } else {
                                                                                                               var38 = 2;
                                                                                                            }
                                                                                                         } else {
                                                                                                            var15 = class32.field720[--class32.field715];
                                                                                                            if(var15 == -1 && !Client.field525) {
                                                                                                               MessageNode.method218();
                                                                                                            } else if(var15 != -1 && Client.field524 != var15 && Client.field501 != 0 && !Client.field525) {
                                                                                                               IndexData var59 = class18.indexTrack1;
                                                                                                               var17 = Client.field501;
                                                                                                               class159.field2063 = 1;
                                                                                                               class159.field2067 = var59;
                                                                                                               CipherBuffer.field1989 = var15;
                                                                                                               class190.field2791 = 0;
                                                                                                               class159.field2069 = var17;
                                                                                                               class15.field164 = false;
                                                                                                               WallObject.field1543 = 2;
                                                                                                            }

                                                                                                            Client.field524 = var15;
                                                                                                            var38 = 1;
                                                                                                         }

                                                                                                         var37 = var38;
                                                                                                      } else if(var54 < 3400) {
                                                                                                         var37 = XClanMember.method253(var54, var4, var61);
                                                                                                      } else if(var54 < 3500) {
                                                                                                         var37 = Preferences.method648(var54, var4, var61);
                                                                                                      } else if(var54 < 3700) {
                                                                                                         var37 = Friend.method182(var54, var4, var61);
                                                                                                      } else {
                                                                                                         long var41;
                                                                                                         int var43;
                                                                                                         if(var54 < 4000) {
                                                                                                            if(var54 == 3903) {
                                                                                                               var15 = class32.field720[--class32.field715];
                                                                                                               class32.field720[++class32.field715 - 1] = Client.grandExchangeOffers[var15].method42();
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 3904) {
                                                                                                               var15 = class32.field720[--class32.field715];
                                                                                                               class32.field720[++class32.field715 - 1] = Client.grandExchangeOffers[var15].itemId;
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 3905) {
                                                                                                               var15 = class32.field720[--class32.field715];
                                                                                                               class32.field720[++class32.field715 - 1] = Client.grandExchangeOffers[var15].price;
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 3906) {
                                                                                                               var15 = class32.field720[--class32.field715];
                                                                                                               class32.field720[++class32.field715 - 1] = Client.grandExchangeOffers[var15].totalQuantity;
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 3907) {
                                                                                                               var15 = class32.field720[--class32.field715];
                                                                                                               class32.field720[++class32.field715 - 1] = Client.grandExchangeOffers[var15].quantitySold;
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 3908) {
                                                                                                               var15 = class32.field720[--class32.field715];
                                                                                                               class32.field720[++class32.field715 - 1] = Client.grandExchangeOffers[var15].spent;
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 3910) {
                                                                                                               var15 = class32.field720[--class32.field715];
                                                                                                               var33 = Client.grandExchangeOffers[var15].method44();
                                                                                                               class32.field720[++class32.field715 - 1] = var33 == 0?1:0;
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 3911) {
                                                                                                               var15 = class32.field720[--class32.field715];
                                                                                                               var33 = Client.grandExchangeOffers[var15].method44();
                                                                                                               class32.field720[++class32.field715 - 1] = var33 == 2?1:0;
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 3912) {
                                                                                                               var15 = class32.field720[--class32.field715];
                                                                                                               var33 = Client.grandExchangeOffers[var15].method44();
                                                                                                               class32.field720[++class32.field715 - 1] = var33 == 5?1:0;
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 3913) {
                                                                                                               var15 = class32.field720[--class32.field715];
                                                                                                               var33 = Client.grandExchangeOffers[var15].method44();
                                                                                                               class32.field720[++class32.field715 - 1] = var33 == 1?1:0;
                                                                                                               var38 = 1;
                                                                                                            } else {
                                                                                                               boolean var67;
                                                                                                               if(var54 == 3914) {
                                                                                                                  var67 = class32.field720[--class32.field715] == 1;
                                                                                                                  if(IndexData.field2745 != null) {
                                                                                                                     IndexData.field2745.method16(class1.field13, var67);
                                                                                                                  }

                                                                                                                  var38 = 1;
                                                                                                               } else if(var54 == 3915) {
                                                                                                                  var67 = class32.field720[--class32.field715] == 1;
                                                                                                                  if(IndexData.field2745 != null) {
                                                                                                                     IndexData.field2745.method16(class1.field12, var67);
                                                                                                                  }

                                                                                                                  var38 = 1;
                                                                                                               } else if(var54 == 3916) {
                                                                                                                  class32.field715 -= 2;
                                                                                                                  var67 = class32.field720[class32.field715] == 1;
                                                                                                                  var80 = class32.field720[class32.field715 + 1] == 1;
                                                                                                                  if(IndexData.field2745 != null) {
                                                                                                                     IndexData.field2745.method16(new class44(var80), var67);
                                                                                                                  }

                                                                                                                  var38 = 1;
                                                                                                               } else if(var54 == 3917) {
                                                                                                                  var67 = class32.field720[--class32.field715] == 1;
                                                                                                                  if(IndexData.field2745 != null) {
                                                                                                                     IndexData.field2745.method16(class1.field11, var67);
                                                                                                                  }

                                                                                                                  var38 = 1;
                                                                                                               } else if(var54 == 3918) {
                                                                                                                  var67 = class32.field720[--class32.field715] == 1;
                                                                                                                  if(IndexData.field2745 != null) {
                                                                                                                     IndexData.field2745.method16(class1.field14, var67);
                                                                                                                  }

                                                                                                                  var38 = 1;
                                                                                                               } else if(var54 == 3919) {
                                                                                                                  class32.field720[++class32.field715 - 1] = IndexData.field2745 == null?0:IndexData.field2745.field15.size();
                                                                                                                  var38 = 1;
                                                                                                               } else {
                                                                                                                  class2 var60;
                                                                                                                  if(var54 == 3920) {
                                                                                                                     var15 = class32.field720[--class32.field715];
                                                                                                                     var60 = (class2)IndexData.field2745.field15.get(var15);
                                                                                                                     class32.field720[++class32.field715 - 1] = var60.field22;
                                                                                                                     var38 = 1;
                                                                                                                  } else if(var54 == 3921) {
                                                                                                                     var15 = class32.field720[--class32.field715];
                                                                                                                     var60 = (class2)IndexData.field2745.field15.get(var15);
                                                                                                                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var60.method25();
                                                                                                                     var38 = 1;
                                                                                                                  } else if(var54 == 3922) {
                                                                                                                     var15 = class32.field720[--class32.field715];
                                                                                                                     var60 = (class2)IndexData.field2745.field15.get(var15);
                                                                                                                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var60.method20();
                                                                                                                     var38 = 1;
                                                                                                                  } else if(var54 == 3923) {
                                                                                                                     var15 = class32.field720[--class32.field715];
                                                                                                                     var60 = (class2)IndexData.field2745.field15.get(var15);
                                                                                                                     var41 = class72.method1421() - Projectile.field872 - var60.field25;
                                                                                                                     var84 = (int)(var41 / 3600000L);
                                                                                                                     var39 = (int)((var41 - (long)(var84 * 3600000)) / 60000L);
                                                                                                                     var43 = (int)((var41 - (long)(var84 * 3600000) - (long)(var39 * '\uea60')) / 1000L);
                                                                                                                     String var22 = var84 + ":" + var39 / 10 + var39 % 10 + ":" + var43 / 10 + var43 % 10;
                                                                                                                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var22;
                                                                                                                     var38 = 1;
                                                                                                                  } else if(var54 == 3924) {
                                                                                                                     var15 = class32.field720[--class32.field715];
                                                                                                                     var60 = (class2)IndexData.field2745.field15.get(var15);
                                                                                                                     class32.field720[++class32.field715 - 1] = var60.field21.totalQuantity;
                                                                                                                     var38 = 1;
                                                                                                                  } else if(var54 == 3925) {
                                                                                                                     var15 = class32.field720[--class32.field715];
                                                                                                                     var60 = (class2)IndexData.field2745.field15.get(var15);
                                                                                                                     class32.field720[++class32.field715 - 1] = var60.field21.price;
                                                                                                                     var38 = 1;
                                                                                                                  } else if(var54 == 3926) {
                                                                                                                     var15 = class32.field720[--class32.field715];
                                                                                                                     var60 = (class2)IndexData.field2745.field15.get(var15);
                                                                                                                     class32.field720[++class32.field715 - 1] = var60.field21.itemId;
                                                                                                                     var38 = 1;
                                                                                                                  } else {
                                                                                                                     var38 = 2;
                                                                                                                  }
                                                                                                               }
                                                                                                            }

                                                                                                            var37 = var38;
                                                                                                         } else if(var54 < 4100) {
                                                                                                            if(var54 == 4000) {
                                                                                                               class32.field715 -= 2;
                                                                                                               var15 = class32.field720[class32.field715];
                                                                                                               var33 = class32.field720[class32.field715 + 1];
                                                                                                               class32.field720[++class32.field715 - 1] = var33 + var15;
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 4001) {
                                                                                                               class32.field715 -= 2;
                                                                                                               var15 = class32.field720[class32.field715];
                                                                                                               var33 = class32.field720[class32.field715 + 1];
                                                                                                               class32.field720[++class32.field715 - 1] = var15 - var33;
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 4002) {
                                                                                                               class32.field715 -= 2;
                                                                                                               var15 = class32.field720[class32.field715];
                                                                                                               var33 = class32.field720[class32.field715 + 1];
                                                                                                               class32.field720[++class32.field715 - 1] = var15 * var33;
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 4003) {
                                                                                                               class32.field715 -= 2;
                                                                                                               var15 = class32.field720[class32.field715];
                                                                                                               var33 = class32.field720[class32.field715 + 1];
                                                                                                               class32.field720[++class32.field715 - 1] = var15 / var33;
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 4004) {
                                                                                                               var15 = class32.field720[--class32.field715];
                                                                                                               class32.field720[++class32.field715 - 1] = (int)(Math.random() * (double)var15);
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 4005) {
                                                                                                               var15 = class32.field720[--class32.field715];
                                                                                                               class32.field720[++class32.field715 - 1] = (int)(Math.random() * (double)(var15 + 1));
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 4006) {
                                                                                                               class32.field715 -= 5;
                                                                                                               var15 = class32.field720[class32.field715];
                                                                                                               var33 = class32.field720[class32.field715 + 1];
                                                                                                               var17 = class32.field720[class32.field715 + 2];
                                                                                                               var18 = class32.field720[class32.field715 + 3];
                                                                                                               var84 = class32.field720[class32.field715 + 4];
                                                                                                               class32.field720[++class32.field715 - 1] = (var84 - var17) * (var33 - var15) / (var18 - var17) + var15;
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 4007) {
                                                                                                               class32.field715 -= 2;
                                                                                                               var15 = class32.field720[class32.field715];
                                                                                                               var33 = class32.field720[class32.field715 + 1];
                                                                                                               class32.field720[++class32.field715 - 1] = var33 * var15 / 100 + var15;
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 4008) {
                                                                                                               class32.field715 -= 2;
                                                                                                               var15 = class32.field720[class32.field715];
                                                                                                               var33 = class32.field720[class32.field715 + 1];
                                                                                                               class32.field720[++class32.field715 - 1] = var15 | 1 << var33;
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 4009) {
                                                                                                               class32.field715 -= 2;
                                                                                                               var15 = class32.field720[class32.field715];
                                                                                                               var33 = class32.field720[class32.field715 + 1];
                                                                                                               class32.field720[++class32.field715 - 1] = var15 & -1 - (1 << var33);
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 4010) {
                                                                                                               class32.field715 -= 2;
                                                                                                               var15 = class32.field720[class32.field715];
                                                                                                               var33 = class32.field720[class32.field715 + 1];
                                                                                                               class32.field720[++class32.field715 - 1] = (var15 & 1 << var33) != 0?1:0;
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 4011) {
                                                                                                               class32.field715 -= 2;
                                                                                                               var15 = class32.field720[class32.field715];
                                                                                                               var33 = class32.field720[class32.field715 + 1];
                                                                                                               class32.field720[++class32.field715 - 1] = var15 % var33;
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 4012) {
                                                                                                               class32.field715 -= 2;
                                                                                                               var15 = class32.field720[class32.field715];
                                                                                                               var33 = class32.field720[class32.field715 + 1];
                                                                                                               if(var15 == 0) {
                                                                                                                  class32.field720[++class32.field715 - 1] = 0;
                                                                                                               } else {
                                                                                                                  class32.field720[++class32.field715 - 1] = (int)Math.pow((double)var15, (double)var33);
                                                                                                               }

                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 4013) {
                                                                                                               class32.field715 -= 2;
                                                                                                               var15 = class32.field720[class32.field715];
                                                                                                               var33 = class32.field720[class32.field715 + 1];
                                                                                                               if(var15 == 0) {
                                                                                                                  class32.field720[++class32.field715 - 1] = 0;
                                                                                                               } else if(var33 == 0) {
                                                                                                                  class32.field720[++class32.field715 - 1] = Integer.MAX_VALUE;
                                                                                                               } else {
                                                                                                                  class32.field720[++class32.field715 - 1] = (int)Math.pow((double)var15, 1.0D / (double)var33);
                                                                                                               }

                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 4014) {
                                                                                                               class32.field715 -= 2;
                                                                                                               var15 = class32.field720[class32.field715];
                                                                                                               var33 = class32.field720[class32.field715 + 1];
                                                                                                               class32.field720[++class32.field715 - 1] = var15 & var33;
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 4015) {
                                                                                                               class32.field715 -= 2;
                                                                                                               var15 = class32.field720[class32.field715];
                                                                                                               var33 = class32.field720[class32.field715 + 1];
                                                                                                               class32.field720[++class32.field715 - 1] = var15 | var33;
                                                                                                               var38 = 1;
                                                                                                            } else if(var54 == 4018) {
                                                                                                               class32.field715 -= 3;
                                                                                                               long var44 = (long)class32.field720[class32.field715];
                                                                                                               var41 = (long)class32.field720[class32.field715 + 1];
                                                                                                               long var46 = (long)class32.field720[class32.field715 + 2];
                                                                                                               class32.field720[++class32.field715 - 1] = (int)(var46 * var44 / var41);
                                                                                                               var38 = 1;
                                                                                                            } else {
                                                                                                               var38 = 2;
                                                                                                            }

                                                                                                            var37 = var38;
                                                                                                         } else {
                                                                                                            int[] var90;
                                                                                                            if(var54 < 4200) {
                                                                                                               if(var54 == 4100) {
                                                                                                                  var86 = class32.scriptStringStack[--class32.scriptStringStackSize];
                                                                                                                  var33 = class32.field720[--class32.field715];
                                                                                                                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var86 + var33;
                                                                                                                  var38 = 1;
                                                                                                               } else if(var54 == 4101) {
                                                                                                                  class32.scriptStringStackSize -= 2;
                                                                                                                  var86 = class32.scriptStringStack[class32.scriptStringStackSize];
                                                                                                                  var58 = class32.scriptStringStack[class32.scriptStringStackSize + 1];
                                                                                                                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var86 + var58;
                                                                                                                  var38 = 1;
                                                                                                               } else if(var54 == 4102) {
                                                                                                                  var86 = class32.scriptStringStack[--class32.scriptStringStackSize];
                                                                                                                  var33 = class32.field720[--class32.field715];
                                                                                                                  String[] var89 = class32.scriptStringStack;
                                                                                                                  var18 = ++class32.scriptStringStackSize - 1;
                                                                                                                  if(var33 < 0) {
                                                                                                                     var20 = Integer.toString(var33);
                                                                                                                  } else {
                                                                                                                     var20 = ScriptState.method153(var33, 10, true);
                                                                                                                  }

                                                                                                                  var89[var18] = var86 + var20;
                                                                                                                  var38 = 1;
                                                                                                               } else if(var54 == 4103) {
                                                                                                                  var86 = class32.scriptStringStack[--class32.scriptStringStackSize];
                                                                                                                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var86.toLowerCase();
                                                                                                                  var38 = 1;
                                                                                                               } else if(var54 == 4104) {
                                                                                                                  var15 = class32.field720[--class32.field715];
                                                                                                                  long var48 = ((long)var15 + 11745L) * 86400000L;
                                                                                                                  class32.field726.setTime(new Date(var48));
                                                                                                                  var18 = class32.field726.get(5);
                                                                                                                  var84 = class32.field726.get(2);
                                                                                                                  var39 = class32.field726.get(1);
                                                                                                                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var18 + "-" + class32.field727[var84] + "-" + var39;
                                                                                                                  var38 = 1;
                                                                                                               } else if(var54 == 4105) {
                                                                                                                  class32.scriptStringStackSize -= 2;
                                                                                                                  var86 = class32.scriptStringStack[class32.scriptStringStackSize];
                                                                                                                  var58 = class32.scriptStringStack[class32.scriptStringStackSize + 1];
                                                                                                                  if(class22.localPlayer.composition != null && class22.localPlayer.composition.isFemale) {
                                                                                                                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var58;
                                                                                                                  } else {
                                                                                                                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var86;
                                                                                                                  }

                                                                                                                  var38 = 1;
                                                                                                               } else if(var54 == 4106) {
                                                                                                                  var15 = class32.field720[--class32.field715];
                                                                                                                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = Integer.toString(var15);
                                                                                                                  var38 = 1;
                                                                                                               } else if(var54 == 4107) {
                                                                                                                  class32.scriptStringStackSize -= 2;
                                                                                                                  var90 = class32.field720;
                                                                                                                  var33 = ++class32.field715 - 1;
                                                                                                                  String var82 = class32.scriptStringStack[class32.scriptStringStackSize];
                                                                                                                  var64 = class32.scriptStringStack[class32.scriptStringStackSize + 1];
                                                                                                                  var39 = Client.field286;
                                                                                                                  var43 = var82.length();
                                                                                                                  int var50 = var64.length();
                                                                                                                  int var23 = 0;
                                                                                                                  int var24 = 0;
                                                                                                                  byte var25 = 0;
                                                                                                                  byte var26 = 0;

                                                                                                                  label1294:
                                                                                                                  while(true) {
                                                                                                                     if(var23 - var25 >= var43 && var24 - var26 >= var50) {
                                                                                                                        int var71 = Math.min(var43, var50);

                                                                                                                        int var72;
                                                                                                                        char var75;
                                                                                                                        for(var72 = 0; var72 < var71; ++var72) {
                                                                                                                           char var73 = var82.charAt(var72);
                                                                                                                           var75 = var64.charAt(var72);
                                                                                                                           if(var75 != var73 && Character.toUpperCase(var73) != Character.toUpperCase(var75)) {
                                                                                                                              var73 = Character.toLowerCase(var73);
                                                                                                                              var75 = Character.toLowerCase(var75);
                                                                                                                              if(var75 != var73) {
                                                                                                                                 var17 = class38.method768(var73, var39) - class38.method768(var75, var39);
                                                                                                                                 break label1294;
                                                                                                                              }
                                                                                                                           }
                                                                                                                        }

                                                                                                                        var72 = var43 - var50;
                                                                                                                        if(var72 != 0) {
                                                                                                                           var17 = var72;
                                                                                                                        } else {
                                                                                                                           for(int var74 = 0; var74 < var71; ++var74) {
                                                                                                                              var75 = var82.charAt(var74);
                                                                                                                              char var31 = var64.charAt(var74);
                                                                                                                              if(var31 != var75) {
                                                                                                                                 var17 = class38.method768(var75, var39) - class38.method768(var31, var39);
                                                                                                                                 break label1294;
                                                                                                                              }
                                                                                                                           }

                                                                                                                           var17 = 0;
                                                                                                                        }
                                                                                                                        break;
                                                                                                                     }

                                                                                                                     if(var23 - var25 >= var43) {
                                                                                                                        var17 = -1;
                                                                                                                        break;
                                                                                                                     }

                                                                                                                     if(var24 - var26 >= var50) {
                                                                                                                        var17 = 1;
                                                                                                                        break;
                                                                                                                     }

                                                                                                                     char var27;
                                                                                                                     if(var25 != 0) {
                                                                                                                        var27 = (char)var25;
                                                                                                                        boolean var69 = false;
                                                                                                                     } else {
                                                                                                                        var27 = var82.charAt(var23++);
                                                                                                                     }

                                                                                                                     char var28;
                                                                                                                     if(var26 != 0) {
                                                                                                                        var28 = (char)var26;
                                                                                                                        boolean var70 = false;
                                                                                                                     } else {
                                                                                                                        var28 = var64.charAt(var24++);
                                                                                                                     }

                                                                                                                     byte var29;
                                                                                                                     if(var27 == 198) {
                                                                                                                        var29 = 69;
                                                                                                                     } else if(var27 == 230) {
                                                                                                                        var29 = 101;
                                                                                                                     } else if(var27 == 223) {
                                                                                                                        var29 = 115;
                                                                                                                     } else if(var27 == 338) {
                                                                                                                        var29 = 69;
                                                                                                                     } else if(var27 == 339) {
                                                                                                                        var29 = 101;
                                                                                                                     } else {
                                                                                                                        var29 = 0;
                                                                                                                     }

                                                                                                                     var25 = var29;
                                                                                                                     byte var30;
                                                                                                                     if(var28 == 198) {
                                                                                                                        var30 = 69;
                                                                                                                     } else if(var28 == 230) {
                                                                                                                        var30 = 101;
                                                                                                                     } else if(var28 == 223) {
                                                                                                                        var30 = 115;
                                                                                                                     } else if(var28 == 338) {
                                                                                                                        var30 = 69;
                                                                                                                     } else if(var28 == 339) {
                                                                                                                        var30 = 101;
                                                                                                                     } else {
                                                                                                                        var30 = 0;
                                                                                                                     }

                                                                                                                     var26 = var30;
                                                                                                                     var27 = class15.method187(var27, var39);
                                                                                                                     var28 = class15.method187(var28, var39);
                                                                                                                     if(var28 != var27 && Character.toUpperCase(var27) != Character.toUpperCase(var28)) {
                                                                                                                        var27 = Character.toLowerCase(var27);
                                                                                                                        var28 = Character.toLowerCase(var28);
                                                                                                                        if(var27 != var28) {
                                                                                                                           var17 = class38.method768(var27, var39) - class38.method768(var28, var39);
                                                                                                                           break;
                                                                                                                        }
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var90[var33] = class124.method2352(var17);
                                                                                                                  var38 = 1;
                                                                                                               } else {
                                                                                                                  Font var19;
                                                                                                                  byte[] var81;
                                                                                                                  if(var54 == 4108) {
                                                                                                                     var86 = class32.scriptStringStack[--class32.scriptStringStackSize];
                                                                                                                     class32.field715 -= 2;
                                                                                                                     var33 = class32.field720[class32.field715];
                                                                                                                     var17 = class32.field720[class32.field715 + 1];
                                                                                                                     var81 = DecorativeObject.field1584.getConfigData(var17, 0);
                                                                                                                     var19 = new Font(var81);
                                                                                                                     class32.field720[++class32.field715 - 1] = var19.method3912(var86, var33);
                                                                                                                     var38 = 1;
                                                                                                                  } else if(var54 == 4109) {
                                                                                                                     var86 = class32.scriptStringStack[--class32.scriptStringStackSize];
                                                                                                                     class32.field715 -= 2;
                                                                                                                     var33 = class32.field720[class32.field715];
                                                                                                                     var17 = class32.field720[class32.field715 + 1];
                                                                                                                     var81 = DecorativeObject.field1584.getConfigData(var17, 0);
                                                                                                                     var19 = new Font(var81);
                                                                                                                     class32.field720[++class32.field715 - 1] = var19.method3964(var86, var33);
                                                                                                                     var38 = 1;
                                                                                                                  } else if(var54 == 4110) {
                                                                                                                     class32.scriptStringStackSize -= 2;
                                                                                                                     var86 = class32.scriptStringStack[class32.scriptStringStackSize];
                                                                                                                     var58 = class32.scriptStringStack[class32.scriptStringStackSize + 1];
                                                                                                                     if(class32.field720[--class32.field715] == 1) {
                                                                                                                        class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var86;
                                                                                                                     } else {
                                                                                                                        class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var58;
                                                                                                                     }

                                                                                                                     var38 = 1;
                                                                                                                  } else if(var54 == 4111) {
                                                                                                                     var86 = class32.scriptStringStack[--class32.scriptStringStackSize];
                                                                                                                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = FontTypeFace.method3913(var86);
                                                                                                                     var38 = 1;
                                                                                                                  } else if(var54 == 4112) {
                                                                                                                     var86 = class32.scriptStringStack[--class32.scriptStringStackSize];
                                                                                                                     var33 = class32.field720[--class32.field715];
                                                                                                                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var86 + (char)var33;
                                                                                                                     var38 = 1;
                                                                                                                  } else {
                                                                                                                     boolean var62;
                                                                                                                     int[] var66;
                                                                                                                     char var85;
                                                                                                                     if(var54 == 4113) {
                                                                                                                        var15 = class32.field720[--class32.field715];
                                                                                                                        var66 = class32.field720;
                                                                                                                        var17 = ++class32.field715 - 1;
                                                                                                                        var85 = (char)var15;
                                                                                                                        if(var85 >= 32 && var85 <= 126) {
                                                                                                                           var62 = true;
                                                                                                                        } else if(var85 >= 160 && var85 <= 255) {
                                                                                                                           var62 = true;
                                                                                                                        } else if(var85 != 8364 && var85 != 338 && var85 != 8212 && var85 != 339 && var85 != 376) {
                                                                                                                           var62 = false;
                                                                                                                        } else {
                                                                                                                           var62 = true;
                                                                                                                        }

                                                                                                                        var66[var17] = var62?1:0;
                                                                                                                        var38 = 1;
                                                                                                                     } else if(var54 == 4114) {
                                                                                                                        var15 = class32.field720[--class32.field715];
                                                                                                                        class32.field720[++class32.field715 - 1] = class178.method3265((char)var15)?1:0;
                                                                                                                        var38 = 1;
                                                                                                                     } else if(var54 == 4115) {
                                                                                                                        var15 = class32.field720[--class32.field715];
                                                                                                                        var66 = class32.field720;
                                                                                                                        var17 = ++class32.field715 - 1;
                                                                                                                        var85 = (char)var15;
                                                                                                                        var62 = var85 >= 65 && var85 <= 90 || var85 >= 97 && var85 <= 122;
                                                                                                                        var66[var17] = var62?1:0;
                                                                                                                        var38 = 1;
                                                                                                                     } else if(var54 == 4116) {
                                                                                                                        var15 = class32.field720[--class32.field715];
                                                                                                                        class32.field720[++class32.field715 - 1] = class131.method2609((char)var15)?1:0;
                                                                                                                        var38 = 1;
                                                                                                                     } else if(var54 == 4117) {
                                                                                                                        var86 = class32.scriptStringStack[--class32.scriptStringStackSize];
                                                                                                                        if(var86 != null) {
                                                                                                                           class32.field720[++class32.field715 - 1] = var86.length();
                                                                                                                        } else {
                                                                                                                           class32.field720[++class32.field715 - 1] = 0;
                                                                                                                        }

                                                                                                                        var38 = 1;
                                                                                                                     } else if(var54 == 4118) {
                                                                                                                        var86 = class32.scriptStringStack[--class32.scriptStringStackSize];
                                                                                                                        class32.field715 -= 2;
                                                                                                                        var33 = class32.field720[class32.field715];
                                                                                                                        var17 = class32.field720[class32.field715 + 1];
                                                                                                                        class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var86.substring(var33, var17);
                                                                                                                        var38 = 1;
                                                                                                                     } else if(var54 != 4119) {
                                                                                                                        if(var54 == 4120) {
                                                                                                                           var86 = class32.scriptStringStack[--class32.scriptStringStackSize];
                                                                                                                           var33 = class32.field720[--class32.field715];
                                                                                                                           class32.field720[++class32.field715 - 1] = var86.indexOf(var33);
                                                                                                                           var38 = 1;
                                                                                                                        } else if(var54 == 4121) {
                                                                                                                           class32.scriptStringStackSize -= 2;
                                                                                                                           var86 = class32.scriptStringStack[class32.scriptStringStackSize];
                                                                                                                           var58 = class32.scriptStringStack[class32.scriptStringStackSize + 1];
                                                                                                                           var17 = class32.field720[--class32.field715];
                                                                                                                           class32.field720[++class32.field715 - 1] = var86.indexOf(var58, var17);
                                                                                                                           var38 = 1;
                                                                                                                        } else {
                                                                                                                           var38 = 2;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        var86 = class32.scriptStringStack[--class32.scriptStringStackSize];
                                                                                                                        StringBuilder var65 = new StringBuilder(var86.length());
                                                                                                                        boolean var63 = false;

                                                                                                                        for(var18 = 0; var18 < var86.length(); ++var18) {
                                                                                                                           var85 = var86.charAt(var18);
                                                                                                                           if(var85 == 60) {
                                                                                                                              var63 = true;
                                                                                                                           } else if(var85 == 62) {
                                                                                                                              var63 = false;
                                                                                                                           } else if(!var63) {
                                                                                                                              var65.append(var85);
                                                                                                                           }
                                                                                                                        }

                                                                                                                        class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var65.toString();
                                                                                                                        var38 = 1;
                                                                                                                     }
                                                                                                                  }
                                                                                                               }

                                                                                                               var37 = var38;
                                                                                                            } else if(var54 < 4300) {
                                                                                                               var37 = Tile.method1567(var54, var4, var61);
                                                                                                            } else if(var54 < 5100) {
                                                                                                               var37 = class57.method1118(var54, var4, var61);
                                                                                                            } else if(var54 < 5400) {
                                                                                                               if(var54 == 5306) {
                                                                                                                  var90 = class32.field720;
                                                                                                                  var33 = ++class32.field715 - 1;
                                                                                                                  var17 = Client.isResized?2:1;
                                                                                                                  var90[var33] = var17;
                                                                                                                  var38 = 1;
                                                                                                               } else if(var54 == 5307) {
                                                                                                                  var15 = class32.field720[--class32.field715];
                                                                                                                  if(var15 == 1 || var15 == 2) {
                                                                                                                     ItemComposition.method3798(var15);
                                                                                                                  }

                                                                                                                  var38 = 1;
                                                                                                               } else if(var54 == 5308) {
                                                                                                                  class32.field720[++class32.field715 - 1] = Actor.field656.field692;
                                                                                                                  var38 = 1;
                                                                                                               } else if(var54 != 5309) {
                                                                                                                  var38 = 2;
                                                                                                               } else {
                                                                                                                  var15 = class32.field720[--class32.field715];
                                                                                                                  if(var15 == 1 || var15 == 2) {
                                                                                                                     Actor.field656.field692 = var15;
                                                                                                                     Renderable.method1896();
                                                                                                                  }

                                                                                                                  var38 = 1;
                                                                                                               }

                                                                                                               var37 = var38;
                                                                                                            } else if(var54 < 5600) {
                                                                                                               var37 = class103.method1990(var54, var4, var61);
                                                                                                            } else if(var54 < 5700) {
                                                                                                               var37 = class36.method747(var54, var4, var61);
                                                                                                            } else if(var54 < 6300) {
                                                                                                               var37 = Renderable.method1903(var54, var4, var61);
                                                                                                            } else if(var54 < 6600) {
                                                                                                               var37 = class15.method185(var54, var4, var61);
                                                                                                            } else {
                                                                                                               var37 = 2;
                                                                                                            }
                                                                                                         }
                                                                                                      }
                                                                                                   }
                                                                                                }
                                                                                             }

                                                                                             switch(var37) {
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
         } catch (Exception var53) {
            StringBuilder var52 = new StringBuilder(30);
            var52.append("").append(var4.hash).append(" ");

            for(var11 = class32.scriptStackCount - 1; var11 >= 0; --var11) {
               var52.append("").append(class32.scriptStack[var11].field113.hash).append(" ");
            }

            var52.append("").append(var8);
            class173.method3259(var52.toString(), var53);
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;IIIZB)V",
      garbageValue = "109"
   )
   public static void method911(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class159.field2063 = 1;
      class159.field2067 = var0;
      CipherBuffer.field1989 = var1;
      class190.field2791 = var2;
      class159.field2069 = var3;
      class15.field164 = var4;
      WallObject.field1543 = 10000;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-358798132"
   )
   public static void method912() {
      try {
         class104.field1680.method1394();

         for(int var0 = 0; var0 < class104.field1677; ++var0) {
            class104.field1683[var0].method1394();
         }

         class104.field1681.method1394();
         class104.field1679.method1394();
      } catch (Exception var2) {
         ;
      }

   }
}
