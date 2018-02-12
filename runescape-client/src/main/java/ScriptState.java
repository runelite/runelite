import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("of")
   @ObfuscatedGetter(
      intValue = -1286479009
   )
   static int field715;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[[Lhs;"
   )
   @Export("widgets")
   public static Widget[][] widgets;
   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "[Lki;"
   )
   @Export("mapMarkers")
   static SpritePixels[] mapMarkers;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2128444143
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lcf;"
   )
   @Export("invokedFromScript")
   Script invokedFromScript;
   @ObfuscatedName("m")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("h")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;

   ScriptState() {
      this.invokedFromPc = -1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lbc;II)V",
      garbageValue = "1690409976"
   )
   @Export("runScript")
   static void runScript(ScriptEvent var0, int var1) {
      Object[] var2 = var0.objs;
      Script var3;
      Script var5;
      int var7;
      int var8;
      int var9;
      int var11;
      int var31;
      if(class161.method3286(var0.field782)) {
         class19.field316 = (class47)var2[0];
         Area var4 = Area.mapAreaType[class19.field316.field572];
         class230 var6 = var0.field782;
         var7 = var4.field3379;
         var8 = var4.field3396;
         var9 = IndexFile.method3329(var7, var6);
         Script var10 = class36.getScriptByFile(var9, var6);
         if(var10 != null) {
            var5 = var10;
         } else {
            var11 = (var8 + 40000 << 8) + var6.field2899;
            var10 = class36.getScriptByFile(var11, var6);
            if(var10 != null) {
               var5 = var10;
            } else {
               var5 = null;
            }
         }

         var3 = var5;
      } else {
         var31 = ((Integer)var2[0]).intValue();
         Script var56 = (Script)Script.field1424.get((long)var31);
         if(var56 != null) {
            var5 = var56;
         } else {
            byte[] var32 = class22.indexScripts.getConfigData(var31, 0);
            if(var32 == null) {
               var5 = null;
            } else {
               var56 = CombatInfoListHolder.newScript(var32);
               Script.field1424.put(var56, (long)var31);
               var5 = var56;
            }
         }

         var3 = var5;
      }

      if(var3 != null) {
         class80.intStackSize = 0;
         class294.scriptStringStackSize = 0;
         var31 = -1;
         int[] var59 = var3.instructions;
         int[] var57 = var3.intOperands;
         byte var58 = -1;
         class80.scriptStackCount = 0;

         int var33;
         try {
            class80.scriptLocalInts = new int[var3.localIntCount];
            var8 = 0;
            class80.scriptLocalStrings = new String[var3.localStringCount];
            var9 = 0;

            String var34;
            for(var33 = 1; var33 < var2.length; ++var33) {
               if(var2[var33] instanceof Integer) {
                  var11 = ((Integer)var2[var33]).intValue();
                  if(var11 == -2147483647) {
                     var11 = var0.field774;
                  }

                  if(var11 == -2147483646) {
                     var11 = var0.field775;
                  }

                  if(var11 == -2147483645) {
                     var11 = var0.widget != null?var0.widget.id:-1;
                  }

                  if(var11 == -2147483644) {
                     var11 = var0.field781;
                  }

                  if(var11 == -2147483643) {
                     var11 = var0.widget != null?var0.widget.index:-1;
                  }

                  if(var11 == -2147483642) {
                     var11 = var0.field777 != null?var0.field777.id:-1;
                  }

                  if(var11 == -2147483641) {
                     var11 = var0.field777 != null?var0.field777.index:-1;
                  }

                  if(var11 == -2147483640) {
                     var11 = var0.field784;
                  }

                  if(var11 == -2147483639) {
                     var11 = var0.field779;
                  }

                  class80.scriptLocalInts[var8++] = var11;
               } else if(var2[var33] instanceof String) {
                  var34 = (String)var2[var33];
                  if(var34.equals("event_opbase")) {
                     var34 = var0.string;
                  }

                  class80.scriptLocalStrings[var9++] = var34;
               }
            }

            var33 = 0;
            class80.field1250 = var0.field771;

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
                                                                                       label1885:
                                                                                       while(true) {
                                                                                          ++var33;
                                                                                          if(var33 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var31;
                                                                                          var7 = var59[var31];
                                                                                          int var16;
                                                                                          int var36;
                                                                                          int var39;
                                                                                          int[] var83;
                                                                                          if(var7 < 100) {
                                                                                             if(var7 != 0) {
                                                                                                if(var7 != 1) {
                                                                                                   if(var7 != 2) {
                                                                                                      if(var7 != 3) {
                                                                                                         if(var7 != 6) {
                                                                                                            if(var7 != 7) {
                                                                                                               if(var7 != 8) {
                                                                                                                  if(var7 != 9) {
                                                                                                                     if(var7 != 10) {
                                                                                                                        if(var7 != 21) {
                                                                                                                           if(var7 != 25) {
                                                                                                                              if(var7 != 27) {
                                                                                                                                 if(var7 != 31) {
                                                                                                                                    if(var7 != 32) {
                                                                                                                                       if(var7 != 33) {
                                                                                                                                          if(var7 != 34) {
                                                                                                                                             if(var7 != 35) {
                                                                                                                                                if(var7 != 36) {
                                                                                                                                                   if(var7 != 37) {
                                                                                                                                                      if(var7 != 38) {
                                                                                                                                                         if(var7 != 39) {
                                                                                                                                                            if(var7 != 40) {
                                                                                                                                                               if(var7 != 42) {
                                                                                                                                                                  if(var7 != 43) {
                                                                                                                                                                     if(var7 == 44) {
                                                                                                                                                                        var11 = var57[var31] >> 16;
                                                                                                                                                                        var36 = var57[var31] & 65535;
                                                                                                                                                                        int var114 = class80.intStack[--class80.intStackSize];
                                                                                                                                                                        if(var114 >= 0 && var114 <= 5000) {
                                                                                                                                                                           class80.field1241[var11] = var114;
                                                                                                                                                                           byte var113 = -1;
                                                                                                                                                                           if(var36 == 105) {
                                                                                                                                                                              var113 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var39 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var39 >= var114) {
                                                                                                                                                                                 continue label1885;
                                                                                                                                                                              }

                                                                                                                                                                              class80.SHAPE_VERTICES[var11][var39] = var113;
                                                                                                                                                                              ++var39;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var7 == 45) {
                                                                                                                                                                        var11 = var57[var31];
                                                                                                                                                                        var36 = class80.intStack[--class80.intStackSize];
                                                                                                                                                                        if(var36 < 0 || var36 >= class80.field1241[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class80.intStack[++class80.intStackSize - 1] = class80.SHAPE_VERTICES[var11][var36];
                                                                                                                                                                     } else if(var7 == 46) {
                                                                                                                                                                        var11 = var57[var31];
                                                                                                                                                                        class80.intStackSize -= 2;
                                                                                                                                                                        var36 = class80.intStack[class80.intStackSize];
                                                                                                                                                                        if(var36 < 0 || var36 >= class80.field1241[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class80.SHAPE_VERTICES[var11][var36] = class80.intStack[class80.intStackSize + 1];
                                                                                                                                                                     } else if(var7 == 47) {
                                                                                                                                                                        var34 = class34.chatMessages.getVarcString(var57[var31]);
                                                                                                                                                                        if(var34 == null) {
                                                                                                                                                                           var34 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var34;
                                                                                                                                                                     } else if(var7 == 48) {
                                                                                                                                                                        class34.chatMessages.putVarcString(var57[var31], class80.scriptStringStack[--class294.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var7 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        IterableHashTable var102 = var3.switches[var57[var31]];
                                                                                                                                                                        IntegerNode var61 = (IntegerNode)var102.get((long)class80.intStack[--class80.intStackSize]);
                                                                                                                                                                        if(var61 != null) {
                                                                                                                                                                           var31 += var61.value;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     class34.chatMessages.putVarc(var57[var31], class80.intStack[--class80.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class80.intStack[++class80.intStackSize - 1] = class34.chatMessages.getVarc(var57[var31]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var11 = var57[var31];
                                                                                                                                                               Script var13 = (Script)Script.field1424.get((long)var11);
                                                                                                                                                               Script var60;
                                                                                                                                                               if(var13 != null) {
                                                                                                                                                                  var60 = var13;
                                                                                                                                                               } else {
                                                                                                                                                                  byte[] var94 = class22.indexScripts.getConfigData(var11, 0);
                                                                                                                                                                  if(var94 == null) {
                                                                                                                                                                     var60 = null;
                                                                                                                                                                  } else {
                                                                                                                                                                     var13 = CombatInfoListHolder.newScript(var94);
                                                                                                                                                                     Script.field1424.put(var13, (long)var11);
                                                                                                                                                                     var60 = var13;
                                                                                                                                                                  }
                                                                                                                                                               }

                                                                                                                                                               var13 = var60;
                                                                                                                                                               var83 = new int[var60.localIntCount];
                                                                                                                                                               String[] var96 = new String[var60.localStringCount];

                                                                                                                                                               for(var16 = 0; var16 < var13.intStackCount; ++var16) {
                                                                                                                                                                  var83[var16] = class80.intStack[var16 + (class80.intStackSize - var13.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var16 = 0; var16 < var13.stringStackCount; ++var16) {
                                                                                                                                                                  var96[var16] = class80.scriptStringStack[var16 + (class294.scriptStringStackSize - var13.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class80.intStackSize -= var13.intStackCount;
                                                                                                                                                               class294.scriptStringStackSize -= var13.stringStackCount;
                                                                                                                                                               ScriptState var106 = new ScriptState();
                                                                                                                                                               var106.invokedFromScript = var3;
                                                                                                                                                               var106.invokedFromPc = var31;
                                                                                                                                                               var106.savedLocalInts = class80.scriptLocalInts;
                                                                                                                                                               var106.savedLocalStrings = class80.scriptLocalStrings;
                                                                                                                                                               class80.scriptStack[++class80.scriptStackCount - 1] = var106;
                                                                                                                                                               var3 = var13;
                                                                                                                                                               var59 = var13.instructions;
                                                                                                                                                               var57 = var13.intOperands;
                                                                                                                                                               var31 = -1;
                                                                                                                                                               class80.scriptLocalInts = var83;
                                                                                                                                                               class80.scriptLocalStrings = var96;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --class294.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class80.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var11 = var57[var31];
                                                                                                                                                      class294.scriptStringStackSize -= var11;
                                                                                                                                                      String var12 = class221.method4350(class80.scriptStringStack, class294.scriptStringStackSize, var11);
                                                                                                                                                      class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var12;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class80.scriptLocalStrings[var57[var31]] = class80.scriptStringStack[--class294.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class80.scriptStringStack[++class294.scriptStringStackSize - 1] = class80.scriptLocalStrings[var57[var31]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class80.scriptLocalInts[var57[var31]] = class80.intStack[--class80.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class80.intStack[++class80.intStackSize - 1] = class80.scriptLocalInts[var57[var31]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class80.intStackSize -= 2;
                                                                                                                                       if(class80.intStack[class80.intStackSize] >= class80.intStack[class80.intStackSize + 1]) {
                                                                                                                                          var31 += var57[var31];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class80.intStackSize -= 2;
                                                                                                                                    if(class80.intStack[class80.intStackSize] <= class80.intStack[class80.intStackSize + 1]) {
                                                                                                                                       var31 += var57[var31];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var11 = var57[var31];
                                                                                                                                 Renderable.method3110(var11, class80.intStack[--class80.intStackSize]);
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var11 = var57[var31];
                                                                                                                              class80.intStack[++class80.intStackSize - 1] = BoundingBox3DDrawMode.getVarbit(var11);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class80.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var99 = class80.scriptStack[--class80.scriptStackCount];
                                                                                                                           var3 = var99.invokedFromScript;
                                                                                                                           var59 = var3.instructions;
                                                                                                                           var57 = var3.intOperands;
                                                                                                                           var31 = var99.invokedFromPc;
                                                                                                                           class80.scriptLocalInts = var99.savedLocalInts;
                                                                                                                           class80.scriptLocalStrings = var99.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class80.intStackSize -= 2;
                                                                                                                        if(class80.intStack[class80.intStackSize] > class80.intStack[class80.intStackSize + 1]) {
                                                                                                                           var31 += var57[var31];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class80.intStackSize -= 2;
                                                                                                                     if(class80.intStack[class80.intStackSize] < class80.intStack[class80.intStackSize + 1]) {
                                                                                                                        var31 += var57[var31];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class80.intStackSize -= 2;
                                                                                                                  if(class80.intStack[class80.intStackSize] == class80.intStack[class80.intStackSize + 1]) {
                                                                                                                     var31 += var57[var31];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class80.intStackSize -= 2;
                                                                                                               if(class80.intStack[class80.intStackSize] != class80.intStack[class80.intStackSize + 1]) {
                                                                                                                  var31 += var57[var31];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var31 += var57[var31];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var3.stringOperands[var31];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var11 = var57[var31];
                                                                                                      class222.widgetSettings[var11] = class80.intStack[--class80.intStackSize];
                                                                                                      class1.method1(var11);
                                                                                                   }
                                                                                                } else {
                                                                                                   var11 = var57[var31];
                                                                                                   class80.intStack[++class80.intStackSize - 1] = class222.widgetSettings[var11];
                                                                                                }
                                                                                             } else {
                                                                                                class80.intStack[++class80.intStackSize - 1] = var57[var31];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var68;
                                                                                             if(var3.intOperands[var31] == 1) {
                                                                                                var68 = true;
                                                                                             } else {
                                                                                                var68 = false;
                                                                                             }

                                                                                             Widget var14;
                                                                                             Widget var17;
                                                                                             int var19;
                                                                                             Widget var35;
                                                                                             byte var37;
                                                                                             int var38;
                                                                                             if(var7 < 1000) {
                                                                                                if(var7 == 100) {
                                                                                                   class80.intStackSize -= 3;
                                                                                                   var38 = class80.intStack[class80.intStackSize];
                                                                                                   var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                   var16 = class80.intStack[class80.intStackSize + 2];
                                                                                                   if(var39 == 0) {
                                                                                                      throw new RuntimeException();
                                                                                                   }

                                                                                                   var17 = class216.getWidget(var38);
                                                                                                   if(var17.children == null) {
                                                                                                      var17.children = new Widget[var16 + 1];
                                                                                                   }

                                                                                                   if(var17.children.length <= var16) {
                                                                                                      Widget[] var18 = new Widget[var16 + 1];

                                                                                                      for(var19 = 0; var19 < var17.children.length; ++var19) {
                                                                                                         var18[var19] = var17.children[var19];
                                                                                                      }

                                                                                                      var17.children = var18;
                                                                                                   }

                                                                                                   if(var16 > 0 && var17.children[var16 - 1] == null) {
                                                                                                      throw new RuntimeException("" + (var16 - 1));
                                                                                                   }

                                                                                                   Widget var71 = new Widget();
                                                                                                   var71.type = var39;
                                                                                                   var71.parentId = var71.id = var17.id;
                                                                                                   var71.index = var16;
                                                                                                   var71.hasScript = true;
                                                                                                   var17.children[var16] = var71;
                                                                                                   if(var68) {
                                                                                                      class94.field1418 = var71;
                                                                                                   } else {
                                                                                                      ItemLayer.field1668 = var71;
                                                                                                   }

                                                                                                   class33.method341(var17);
                                                                                                   var37 = 1;
                                                                                                } else if(var7 == 101) {
                                                                                                   var14 = var68?class94.field1418:ItemLayer.field1668;
                                                                                                   Widget var15 = class216.getWidget(var14.id);
                                                                                                   var15.children[var14.index] = null;
                                                                                                   class33.method341(var15);
                                                                                                   var37 = 1;
                                                                                                } else if(var7 == 102) {
                                                                                                   var14 = class216.getWidget(class80.intStack[--class80.intStackSize]);
                                                                                                   var14.children = null;
                                                                                                   class33.method341(var14);
                                                                                                   var37 = 1;
                                                                                                } else if(var7 != 200) {
                                                                                                   if(var7 == 201) {
                                                                                                      var14 = class216.getWidget(class80.intStack[--class80.intStackSize]);
                                                                                                      if(var14 != null) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = 1;
                                                                                                         if(var68) {
                                                                                                            class94.field1418 = var14;
                                                                                                         } else {
                                                                                                            ItemLayer.field1668 = var14;
                                                                                                         }
                                                                                                      } else {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                      }

                                                                                                      var37 = 1;
                                                                                                   } else {
                                                                                                      var37 = 2;
                                                                                                   }
                                                                                                } else {
                                                                                                   class80.intStackSize -= 2;
                                                                                                   var38 = class80.intStack[class80.intStackSize];
                                                                                                   var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                   var35 = class44.getWidgetChild(var38, var39);
                                                                                                   if(var35 != null && var39 != -1) {
                                                                                                      class80.intStack[++class80.intStackSize - 1] = 1;
                                                                                                      if(var68) {
                                                                                                         class94.field1418 = var35;
                                                                                                      } else {
                                                                                                         ItemLayer.field1668 = var35;
                                                                                                      }
                                                                                                   } else {
                                                                                                      class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                   }

                                                                                                   var37 = 1;
                                                                                                }

                                                                                                var36 = var37;
                                                                                             } else if(var7 < 1100) {
                                                                                                var36 = Actor.method1612(var7, var3, var68);
                                                                                             } else if(var7 < 1200) {
                                                                                                var36 = ContextMenuRow.method1874(var7, var3, var68);
                                                                                             } else if(var7 < 1300) {
                                                                                                var36 = CombatInfo1.method1619(var7, var3, var68);
                                                                                             } else if(var7 < 1400) {
                                                                                                var36 = class260.method4817(var7, var3, var68);
                                                                                             } else if(var7 < 1500) {
                                                                                                var36 = AttackOption.method1887(var7, var3, var68);
                                                                                             } else if(var7 < 1600) {
                                                                                                var36 = class219.method4333(var7, var3, var68);
                                                                                             } else if(var7 < 1700) {
                                                                                                var36 = WorldMapData.method339(var7, var3, var68);
                                                                                             } else if(var7 < 1800) {
                                                                                                var36 = class20.method159(var7, var3, var68);
                                                                                             } else if(var7 < 1900) {
                                                                                                var36 = Varcs.method1997(var7, var3, var68);
                                                                                             } else if(var7 < 2000) {
                                                                                                var36 = ScriptEvent.method1073(var7, var3, var68);
                                                                                             } else if(var7 < 2100) {
                                                                                                var36 = Actor.method1612(var7, var3, var68);
                                                                                             } else if(var7 < 2200) {
                                                                                                var36 = ContextMenuRow.method1874(var7, var3, var68);
                                                                                             } else if(var7 < 2300) {
                                                                                                var36 = CombatInfo1.method1619(var7, var3, var68);
                                                                                             } else if(var7 < 2400) {
                                                                                                var36 = class260.method4817(var7, var3, var68);
                                                                                             } else if(var7 < 2500) {
                                                                                                var36 = AttackOption.method1887(var7, var3, var68);
                                                                                             } else if(var7 < 2600) {
                                                                                                var36 = class263.method4861(var7, var3, var68);
                                                                                             } else if(var7 < 2700) {
                                                                                                var14 = class216.getWidget(class80.intStack[--class80.intStackSize]);
                                                                                                if(var7 == 2600) {
                                                                                                   class80.intStack[++class80.intStackSize - 1] = var14.scrollX;
                                                                                                   var37 = 1;
                                                                                                } else if(var7 == 2601) {
                                                                                                   class80.intStack[++class80.intStackSize - 1] = var14.scrollY;
                                                                                                   var37 = 1;
                                                                                                } else if(var7 == 2602) {
                                                                                                   class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var14.text;
                                                                                                   var37 = 1;
                                                                                                } else if(var7 == 2603) {
                                                                                                   class80.intStack[++class80.intStackSize - 1] = var14.scrollWidth;
                                                                                                   var37 = 1;
                                                                                                } else if(var7 == 2604) {
                                                                                                   class80.intStack[++class80.intStackSize - 1] = var14.scrollHeight;
                                                                                                   var37 = 1;
                                                                                                } else if(var7 == 2605) {
                                                                                                   class80.intStack[++class80.intStackSize - 1] = var14.modelZoom;
                                                                                                   var37 = 1;
                                                                                                } else if(var7 == 2606) {
                                                                                                   class80.intStack[++class80.intStackSize - 1] = var14.rotationX;
                                                                                                   var37 = 1;
                                                                                                } else if(var7 == 2607) {
                                                                                                   class80.intStack[++class80.intStackSize - 1] = var14.rotationY;
                                                                                                   var37 = 1;
                                                                                                } else if(var7 == 2608) {
                                                                                                   class80.intStack[++class80.intStackSize - 1] = var14.rotationZ;
                                                                                                   var37 = 1;
                                                                                                } else if(var7 == 2609) {
                                                                                                   class80.intStack[++class80.intStackSize - 1] = var14.opacity;
                                                                                                   var37 = 1;
                                                                                                } else if(var7 == 2610) {
                                                                                                   class80.intStack[++class80.intStackSize - 1] = var14.field2786;
                                                                                                   var37 = 1;
                                                                                                } else if(var7 == 2611) {
                                                                                                   class80.intStack[++class80.intStackSize - 1] = var14.textColor;
                                                                                                   var37 = 1;
                                                                                                } else if(var7 == 2612) {
                                                                                                   class80.intStack[++class80.intStackSize - 1] = var14.field2780;
                                                                                                   var37 = 1;
                                                                                                } else if(var7 == 2613) {
                                                                                                   class80.intStack[++class80.intStackSize - 1] = var14.field2832.rsOrdinal();
                                                                                                   var37 = 1;
                                                                                                } else {
                                                                                                   var37 = 2;
                                                                                                }

                                                                                                var36 = var37;
                                                                                             } else {
                                                                                                WidgetNode var62;
                                                                                                if(var7 < 2800) {
                                                                                                   if(var7 == 2700) {
                                                                                                      var14 = class216.getWidget(class80.intStack[--class80.intStackSize]);
                                                                                                      class80.intStack[++class80.intStackSize - 1] = var14.itemId;
                                                                                                      var37 = 1;
                                                                                                   } else if(var7 == 2701) {
                                                                                                      var14 = class216.getWidget(class80.intStack[--class80.intStackSize]);
                                                                                                      if(var14.itemId != -1) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = var14.itemQuantity;
                                                                                                      } else {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                      }

                                                                                                      var37 = 1;
                                                                                                   } else if(var7 == 2702) {
                                                                                                      var38 = class80.intStack[--class80.intStackSize];
                                                                                                      var62 = (WidgetNode)Client.componentTable.get((long)var38);
                                                                                                      if(var62 != null) {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = 1;
                                                                                                      } else {
                                                                                                         class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                      }

                                                                                                      var37 = 1;
                                                                                                   } else if(var7 == 2706) {
                                                                                                      class80.intStack[++class80.intStackSize - 1] = Client.widgetRoot;
                                                                                                      var37 = 1;
                                                                                                   } else {
                                                                                                      var37 = 2;
                                                                                                   }

                                                                                                   var36 = var37;
                                                                                                } else if(var7 < 2900) {
                                                                                                   var36 = Item.method1959(var7, var3, var68);
                                                                                                } else if(var7 < 3000) {
                                                                                                   var36 = ScriptEvent.method1073(var7, var3, var68);
                                                                                                } else {
                                                                                                   int var20;
                                                                                                   int var21;
                                                                                                   int var22;
                                                                                                   boolean var41;
                                                                                                   String var64;
                                                                                                   String var65;
                                                                                                   int var85;
                                                                                                   boolean var109;
                                                                                                   int var111;
                                                                                                   if(var7 < 3200) {
                                                                                                      if(var7 == 3100) {
                                                                                                         var64 = class80.scriptStringStack[--class294.scriptStringStackSize];
                                                                                                         SoundTaskDataProvider.sendGameMessage(0, "", var64);
                                                                                                         var37 = 1;
                                                                                                      } else if(var7 == 3101) {
                                                                                                         class80.intStackSize -= 2;
                                                                                                         JagexGame.method4497(GroundObject.localPlayer, class80.intStack[class80.intStackSize], class80.intStack[class80.intStackSize + 1]);
                                                                                                         var37 = 1;
                                                                                                      } else if(var7 == 3103) {
                                                                                                         PacketNode var66 = Script.method2025(ClientPacket.field2411, Client.field937.field1454);
                                                                                                         Client.field937.method2044(var66);
                                                                                                         var62 = (WidgetNode)Client.componentTable.first();

                                                                                                         while(true) {
                                                                                                            if(var62 == null) {
                                                                                                               if(Client.field885 != null) {
                                                                                                                  class33.method341(Client.field885);
                                                                                                                  Client.field885 = null;
                                                                                                               }

                                                                                                               var37 = 1;
                                                                                                               break;
                                                                                                            }

                                                                                                            if(var62.owner == 0 || var62.owner == 3) {
                                                                                                               class137.method3103(var62, true);
                                                                                                            }

                                                                                                            var62 = (WidgetNode)Client.componentTable.next();
                                                                                                         }
                                                                                                      } else {
                                                                                                         PacketNode var67;
                                                                                                         if(var7 != 3104) {
                                                                                                            PacketNode var63;
                                                                                                            if(var7 == 3105) {
                                                                                                               var64 = class80.scriptStringStack[--class294.scriptStringStackSize];
                                                                                                               var63 = Script.method2025(ClientPacket.field2388, Client.field937.field1454);
                                                                                                               var63.packetBuffer.putByte(var64.length() + 1);
                                                                                                               var63.packetBuffer.putString(var64);
                                                                                                               Client.field937.method2044(var63);
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 3106) {
                                                                                                               var64 = class80.scriptStringStack[--class294.scriptStringStackSize];
                                                                                                               var63 = Script.method2025(ClientPacket.field2396, Client.field937.field1454);
                                                                                                               var63.packetBuffer.putByte(var64.length() + 1);
                                                                                                               var63.packetBuffer.putString(var64);
                                                                                                               Client.field937.method2044(var63);
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 3107) {
                                                                                                               var38 = class80.intStack[--class80.intStackSize];
                                                                                                               var65 = class80.scriptStringStack[--class294.scriptStringStackSize];
                                                                                                               ScriptVarType.method22(var38, var65);
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 3108) {
                                                                                                               class80.intStackSize -= 3;
                                                                                                               var38 = class80.intStack[class80.intStackSize];
                                                                                                               var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                               var16 = class80.intStack[class80.intStackSize + 2];
                                                                                                               var17 = class216.getWidget(var16);
                                                                                                               MilliTimer.method3180(var17, var38, var39);
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 3109) {
                                                                                                               class80.intStackSize -= 2;
                                                                                                               var38 = class80.intStack[class80.intStackSize];
                                                                                                               var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                               var35 = var68?class94.field1418:ItemLayer.field1668;
                                                                                                               MilliTimer.method3180(var35, var38, var39);
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 3110) {
                                                                                                               class29.middleMouseMovesCamera = class80.intStack[--class80.intStackSize] == 1;
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 3111) {
                                                                                                               class80.intStack[++class80.intStackSize - 1] = WorldComparator.preferences.hideRoofs?1:0;
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 3112) {
                                                                                                               WorldComparator.preferences.hideRoofs = class80.intStack[--class80.intStackSize] == 1;
                                                                                                               CombatInfo1.method1618();
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 3113) {
                                                                                                               var64 = class80.scriptStringStack[--class294.scriptStringStackSize];
                                                                                                               var109 = class80.intStack[--class80.intStackSize] == 1;
                                                                                                               class233.method4474(var64, var109, false);
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 3115) {
                                                                                                               var38 = class80.intStack[--class80.intStackSize];
                                                                                                               var63 = Script.method2025(ClientPacket.field2356, Client.field937.field1454);
                                                                                                               var63.packetBuffer.putShort(var38);
                                                                                                               Client.field937.method2044(var63);
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 3116) {
                                                                                                               var38 = class80.intStack[--class80.intStackSize];
                                                                                                               class294.scriptStringStackSize -= 2;
                                                                                                               var65 = class80.scriptStringStack[class294.scriptStringStackSize];
                                                                                                               String var100 = class80.scriptStringStack[class294.scriptStringStackSize + 1];
                                                                                                               if(var65.length() > 500) {
                                                                                                                  var37 = 1;
                                                                                                               } else if(var100.length() > 500) {
                                                                                                                  var37 = 1;
                                                                                                               } else {
                                                                                                                  var67 = Script.method2025(ClientPacket.field2390, Client.field937.field1454);
                                                                                                                  var67.packetBuffer.putShort(1 + FrameMap.getLength(var65) + FrameMap.getLength(var100));
                                                                                                                  var67.packetBuffer.putByte(var38);
                                                                                                                  var67.packetBuffer.putString(var100);
                                                                                                                  var67.packetBuffer.putString(var65);
                                                                                                                  Client.field937.method2044(var67);
                                                                                                                  var37 = 1;
                                                                                                               }
                                                                                                            } else if(var7 == 3117) {
                                                                                                               Client.field972 = class80.intStack[--class80.intStackSize] == 1;
                                                                                                               var37 = 1;
                                                                                                            } else {
                                                                                                               var37 = 2;
                                                                                                            }
                                                                                                         } else {
                                                                                                            var64 = class80.scriptStringStack[--class294.scriptStringStackSize];
                                                                                                            var39 = 0;
                                                                                                            boolean var40 = false;
                                                                                                            boolean var77 = false;
                                                                                                            var20 = 0;
                                                                                                            var21 = var64.length();
                                                                                                            var22 = 0;

                                                                                                            while(true) {
                                                                                                               if(var22 >= var21) {
                                                                                                                  var41 = var77;
                                                                                                                  break;
                                                                                                               }

                                                                                                               label2221: {
                                                                                                                  char var23 = var64.charAt(var22);
                                                                                                                  if(var22 == 0) {
                                                                                                                     if(var23 == '-') {
                                                                                                                        var40 = true;
                                                                                                                        break label2221;
                                                                                                                     }

                                                                                                                     if(var23 == '+') {
                                                                                                                        break label2221;
                                                                                                                     }
                                                                                                                  }

                                                                                                                  if(var23 >= '0' && var23 <= '9') {
                                                                                                                     var85 = var23 - '0';
                                                                                                                  } else if(var23 >= 'A' && var23 <= 'Z') {
                                                                                                                     var85 = var23 - '7';
                                                                                                                  } else {
                                                                                                                     if(var23 < 'a' || var23 > 'z') {
                                                                                                                        var41 = false;
                                                                                                                        break;
                                                                                                                     }

                                                                                                                     var85 = var23 - 'W';
                                                                                                                  }

                                                                                                                  if(var85 >= 10) {
                                                                                                                     var41 = false;
                                                                                                                     break;
                                                                                                                  }

                                                                                                                  if(var40) {
                                                                                                                     var85 = -var85;
                                                                                                                  }

                                                                                                                  int var24 = var20 * 10 + var85;
                                                                                                                  if(var20 != var24 / 10) {
                                                                                                                     var41 = false;
                                                                                                                     break;
                                                                                                                  }

                                                                                                                  var20 = var24;
                                                                                                                  var77 = true;
                                                                                                               }

                                                                                                               ++var22;
                                                                                                            }

                                                                                                            if(var41) {
                                                                                                               var111 = Projectile.parseInt(var64, 10, true);
                                                                                                               var39 = var111;
                                                                                                            }

                                                                                                            var67 = Script.method2025(ClientPacket.field2342, Client.field937.field1454);
                                                                                                            var67.packetBuffer.putInt(var39);
                                                                                                            Client.field937.method2044(var67);
                                                                                                            var37 = 1;
                                                                                                         }
                                                                                                      }

                                                                                                      var36 = var37;
                                                                                                   } else if(var7 < 3300) {
                                                                                                      var36 = Spotanim.method4746(var7, var3, var68);
                                                                                                   } else {
                                                                                                      int[] var69;
                                                                                                      if(var7 < 3400) {
                                                                                                         if(var7 == 3300) {
                                                                                                            class80.intStack[++class80.intStackSize - 1] = Client.gameCycle;
                                                                                                            var37 = 1;
                                                                                                         } else if(var7 == 3301) {
                                                                                                            class80.intStackSize -= 2;
                                                                                                            var38 = class80.intStack[class80.intStackSize];
                                                                                                            var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                            class80.intStack[++class80.intStackSize - 1] = PlayerComposition.method4407(var38, var39);
                                                                                                            var37 = 1;
                                                                                                         } else if(var7 == 3302) {
                                                                                                            class80.intStackSize -= 2;
                                                                                                            var38 = class80.intStack[class80.intStackSize];
                                                                                                            var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                            class80.intStack[++class80.intStackSize - 1] = class2.method4(var38, var39);
                                                                                                            var37 = 1;
                                                                                                         } else if(var7 == 3303) {
                                                                                                            class80.intStackSize -= 2;
                                                                                                            var38 = class80.intStack[class80.intStackSize];
                                                                                                            var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                            class80.intStack[++class80.intStackSize - 1] = class56.method784(var38, var39);
                                                                                                            var37 = 1;
                                                                                                         } else if(var7 == 3304) {
                                                                                                            var38 = class80.intStack[--class80.intStackSize];
                                                                                                            var69 = class80.intStack;
                                                                                                            var16 = ++class80.intStackSize - 1;
                                                                                                            InvType var74 = (InvType)InvType.inventoryCache.get((long)var38);
                                                                                                            InvType var72;
                                                                                                            if(var74 != null) {
                                                                                                               var72 = var74;
                                                                                                            } else {
                                                                                                               byte[] var42 = InvType.field3366.getConfigData(5, var38);
                                                                                                               var74 = new InvType();
                                                                                                               if(var42 != null) {
                                                                                                                  var74.decode(new Buffer(var42));
                                                                                                               }

                                                                                                               InvType.inventoryCache.put(var74, (long)var38);
                                                                                                               var72 = var74;
                                                                                                            }

                                                                                                            var69[var16] = var72.size;
                                                                                                            var37 = 1;
                                                                                                         } else if(var7 == 3305) {
                                                                                                            var38 = class80.intStack[--class80.intStackSize];
                                                                                                            class80.intStack[++class80.intStackSize - 1] = Client.boostedSkillLevels[var38];
                                                                                                            var37 = 1;
                                                                                                         } else if(var7 == 3306) {
                                                                                                            var38 = class80.intStack[--class80.intStackSize];
                                                                                                            class80.intStack[++class80.intStackSize - 1] = Client.realSkillLevels[var38];
                                                                                                            var37 = 1;
                                                                                                         } else if(var7 == 3307) {
                                                                                                            var38 = class80.intStack[--class80.intStackSize];
                                                                                                            class80.intStack[++class80.intStackSize - 1] = Client.skillExperiences[var38];
                                                                                                            var37 = 1;
                                                                                                         } else if(var7 == 3308) {
                                                                                                            var38 = class60.plane;
                                                                                                            var39 = (GroundObject.localPlayer.x >> 7) + ClanMemberManager.baseX;
                                                                                                            var16 = (GroundObject.localPlayer.y >> 7) + WorldMapData.baseY;
                                                                                                            class80.intStack[++class80.intStackSize - 1] = (var39 << 14) + var16 + (var38 << 28);
                                                                                                            var37 = 1;
                                                                                                         } else if(var7 == 3309) {
                                                                                                            var38 = class80.intStack[--class80.intStackSize];
                                                                                                            class80.intStack[++class80.intStackSize - 1] = var38 >> 14 & 16383;
                                                                                                            var37 = 1;
                                                                                                         } else if(var7 == 3310) {
                                                                                                            var38 = class80.intStack[--class80.intStackSize];
                                                                                                            class80.intStack[++class80.intStackSize - 1] = var38 >> 28;
                                                                                                            var37 = 1;
                                                                                                         } else if(var7 == 3311) {
                                                                                                            var38 = class80.intStack[--class80.intStackSize];
                                                                                                            class80.intStack[++class80.intStackSize - 1] = var38 & 16383;
                                                                                                            var37 = 1;
                                                                                                         } else if(var7 == 3312) {
                                                                                                            class80.intStack[++class80.intStackSize - 1] = Client.isMembers?1:0;
                                                                                                            var37 = 1;
                                                                                                         } else if(var7 == 3313) {
                                                                                                            class80.intStackSize -= 2;
                                                                                                            var38 = class80.intStack[class80.intStackSize] + 32768;
                                                                                                            var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                            class80.intStack[++class80.intStackSize - 1] = PlayerComposition.method4407(var38, var39);
                                                                                                            var37 = 1;
                                                                                                         } else if(var7 == 3314) {
                                                                                                            class80.intStackSize -= 2;
                                                                                                            var38 = class80.intStack[class80.intStackSize] + 32768;
                                                                                                            var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                            class80.intStack[++class80.intStackSize - 1] = class2.method4(var38, var39);
                                                                                                            var37 = 1;
                                                                                                         } else if(var7 == 3315) {
                                                                                                            class80.intStackSize -= 2;
                                                                                                            var38 = class80.intStack[class80.intStackSize] + 32768;
                                                                                                            var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                            class80.intStack[++class80.intStackSize - 1] = class56.method784(var38, var39);
                                                                                                            var37 = 1;
                                                                                                         } else if(var7 == 3316) {
                                                                                                            if(Client.rights >= 2) {
                                                                                                               class80.intStack[++class80.intStackSize - 1] = Client.rights;
                                                                                                            } else {
                                                                                                               class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                            }

                                                                                                            var37 = 1;
                                                                                                         } else if(var7 == 3317) {
                                                                                                            class80.intStack[++class80.intStackSize - 1] = Client.field994;
                                                                                                            var37 = 1;
                                                                                                         } else if(var7 == 3318) {
                                                                                                            class80.intStack[++class80.intStackSize - 1] = Client.world;
                                                                                                            var37 = 1;
                                                                                                         } else if(var7 == 3321) {
                                                                                                            class80.intStack[++class80.intStackSize - 1] = Client.energy;
                                                                                                            var37 = 1;
                                                                                                         } else if(var7 == 3322) {
                                                                                                            class80.intStack[++class80.intStackSize - 1] = Client.weight;
                                                                                                            var37 = 1;
                                                                                                         } else if(var7 == 3323) {
                                                                                                            if(Client.field857) {
                                                                                                               class80.intStack[++class80.intStackSize - 1] = 1;
                                                                                                            } else {
                                                                                                               class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                            }

                                                                                                            var37 = 1;
                                                                                                         } else if(var7 == 3324) {
                                                                                                            class80.intStack[++class80.intStackSize - 1] = Client.flags;
                                                                                                            var37 = 1;
                                                                                                         } else if(var7 == 3325) {
                                                                                                            class80.intStackSize -= 4;
                                                                                                            var38 = class80.intStack[class80.intStackSize];
                                                                                                            var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                            var16 = class80.intStack[class80.intStackSize + 2];
                                                                                                            var111 = class80.intStack[class80.intStackSize + 3];
                                                                                                            var38 += var39 << 14;
                                                                                                            var38 += var16 << 28;
                                                                                                            var38 += var111;
                                                                                                            class80.intStack[++class80.intStackSize - 1] = var38;
                                                                                                            var37 = 1;
                                                                                                         } else {
                                                                                                            var37 = 2;
                                                                                                         }

                                                                                                         var36 = var37;
                                                                                                      } else if(var7 < 3500) {
                                                                                                         var36 = Timer.method3294(var7, var3, var68);
                                                                                                      } else if(var7 < 3700) {
                                                                                                         var36 = class79.method1759(var7, var3, var68);
                                                                                                      } else if(var7 < 4000) {
                                                                                                         var36 = class34.method482(var7, var3, var68);
                                                                                                      } else {
                                                                                                         int var107;
                                                                                                         if(var7 < 4100) {
                                                                                                            if(var7 == 4000) {
                                                                                                               class80.intStackSize -= 2;
                                                                                                               var38 = class80.intStack[class80.intStackSize];
                                                                                                               var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var38 + var39;
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 4001) {
                                                                                                               class80.intStackSize -= 2;
                                                                                                               var38 = class80.intStack[class80.intStackSize];
                                                                                                               var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var38 - var39;
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 4002) {
                                                                                                               class80.intStackSize -= 2;
                                                                                                               var38 = class80.intStack[class80.intStackSize];
                                                                                                               var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var39 * var38;
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 4003) {
                                                                                                               class80.intStackSize -= 2;
                                                                                                               var38 = class80.intStack[class80.intStackSize];
                                                                                                               var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var38 / var39;
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 4004) {
                                                                                                               var38 = class80.intStack[--class80.intStackSize];
                                                                                                               class80.intStack[++class80.intStackSize - 1] = (int)(Math.random() * (double)var38);
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 4005) {
                                                                                                               var38 = class80.intStack[--class80.intStackSize];
                                                                                                               class80.intStack[++class80.intStackSize - 1] = (int)(Math.random() * (double)(var38 + 1));
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 4006) {
                                                                                                               class80.intStackSize -= 5;
                                                                                                               var38 = class80.intStack[class80.intStackSize];
                                                                                                               var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                               var16 = class80.intStack[class80.intStackSize + 2];
                                                                                                               var111 = class80.intStack[class80.intStackSize + 3];
                                                                                                               var107 = class80.intStack[class80.intStackSize + 4];
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var38 + (var39 - var38) * (var107 - var16) / (var111 - var16);
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 4007) {
                                                                                                               class80.intStackSize -= 2;
                                                                                                               var38 = class80.intStack[class80.intStackSize];
                                                                                                               var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var38 + var38 * var39 / 100;
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 4008) {
                                                                                                               class80.intStackSize -= 2;
                                                                                                               var38 = class80.intStack[class80.intStackSize];
                                                                                                               var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var38 | 1 << var39;
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 4009) {
                                                                                                               class80.intStackSize -= 2;
                                                                                                               var38 = class80.intStack[class80.intStackSize];
                                                                                                               var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var38 & -1 - (1 << var39);
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 4010) {
                                                                                                               class80.intStackSize -= 2;
                                                                                                               var38 = class80.intStack[class80.intStackSize];
                                                                                                               var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                               class80.intStack[++class80.intStackSize - 1] = (var38 & 1 << var39) != 0?1:0;
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 4011) {
                                                                                                               class80.intStackSize -= 2;
                                                                                                               var38 = class80.intStack[class80.intStackSize];
                                                                                                               var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var38 % var39;
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 4012) {
                                                                                                               class80.intStackSize -= 2;
                                                                                                               var38 = class80.intStack[class80.intStackSize];
                                                                                                               var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                               if(var38 == 0) {
                                                                                                                  class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                               } else {
                                                                                                                  class80.intStack[++class80.intStackSize - 1] = (int)Math.pow((double)var38, (double)var39);
                                                                                                               }

                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 4013) {
                                                                                                               class80.intStackSize -= 2;
                                                                                                               var38 = class80.intStack[class80.intStackSize];
                                                                                                               var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                               if(var38 == 0) {
                                                                                                                  class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                  var37 = 1;
                                                                                                               } else {
                                                                                                                  switch(var39) {
                                                                                                                  case 0:
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = Integer.MAX_VALUE;
                                                                                                                     break;
                                                                                                                  case 1:
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = var38;
                                                                                                                     break;
                                                                                                                  case 2:
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = (int)Math.sqrt((double)var38);
                                                                                                                     break;
                                                                                                                  case 3:
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = (int)Math.cbrt((double)var38);
                                                                                                                     break;
                                                                                                                  case 4:
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var38));
                                                                                                                     break;
                                                                                                                  default:
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = (int)Math.pow((double)var38, 1.0D / (double)var39);
                                                                                                                  }

                                                                                                                  var37 = 1;
                                                                                                               }
                                                                                                            } else if(var7 == 4014) {
                                                                                                               class80.intStackSize -= 2;
                                                                                                               var38 = class80.intStack[class80.intStackSize];
                                                                                                               var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var38 & var39;
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 4015) {
                                                                                                               class80.intStackSize -= 2;
                                                                                                               var38 = class80.intStack[class80.intStackSize];
                                                                                                               var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                               class80.intStack[++class80.intStackSize - 1] = var38 | var39;
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 4018) {
                                                                                                               class80.intStackSize -= 3;
                                                                                                               long var43 = (long)class80.intStack[class80.intStackSize];
                                                                                                               long var45 = (long)class80.intStack[class80.intStackSize + 1];
                                                                                                               long var47 = (long)class80.intStack[class80.intStackSize + 2];
                                                                                                               class80.intStack[++class80.intStackSize - 1] = (int)(var47 * var43 / var45);
                                                                                                               var37 = 1;
                                                                                                            } else {
                                                                                                               var37 = 2;
                                                                                                            }

                                                                                                            var36 = var37;
                                                                                                         } else if(var7 < 4200) {
                                                                                                            if(var7 == 4100) {
                                                                                                               var64 = class80.scriptStringStack[--class294.scriptStringStackSize];
                                                                                                               var39 = class80.intStack[--class80.intStackSize];
                                                                                                               class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var64 + var39;
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 4101) {
                                                                                                               class294.scriptStringStackSize -= 2;
                                                                                                               var64 = class80.scriptStringStack[class294.scriptStringStackSize];
                                                                                                               var65 = class80.scriptStringStack[class294.scriptStringStackSize + 1];
                                                                                                               class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var64 + var65;
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 4102) {
                                                                                                               var64 = class80.scriptStringStack[--class294.scriptStringStackSize];
                                                                                                               var39 = class80.intStack[--class80.intStackSize];
                                                                                                               class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var64 + VertexNormal.method2814(var39, true);
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 4103) {
                                                                                                               var64 = class80.scriptStringStack[--class294.scriptStringStackSize];
                                                                                                               class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var64.toLowerCase();
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 4104) {
                                                                                                               var38 = class80.intStack[--class80.intStackSize];
                                                                                                               long var49 = 86400000L * (11745L + (long)var38);
                                                                                                               class80.field1248.setTime(new Date(var49));
                                                                                                               var111 = class80.field1248.get(5);
                                                                                                               var107 = class80.field1248.get(2);
                                                                                                               var19 = class80.field1248.get(1);
                                                                                                               class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var111 + "-" + class80.field1238[var107] + "-" + var19;
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 4105) {
                                                                                                               class294.scriptStringStackSize -= 2;
                                                                                                               var64 = class80.scriptStringStack[class294.scriptStringStackSize];
                                                                                                               var65 = class80.scriptStringStack[class294.scriptStringStackSize + 1];
                                                                                                               if(GroundObject.localPlayer.composition != null && GroundObject.localPlayer.composition.isFemale) {
                                                                                                                  class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var65;
                                                                                                               } else {
                                                                                                                  class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var64;
                                                                                                               }

                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 4106) {
                                                                                                               var38 = class80.intStack[--class80.intStackSize];
                                                                                                               class80.scriptStringStack[++class294.scriptStringStackSize - 1] = Integer.toString(var38);
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 4107) {
                                                                                                               class294.scriptStringStackSize -= 2;
                                                                                                               var83 = class80.intStack;
                                                                                                               var39 = ++class80.intStackSize - 1;
                                                                                                               String var78 = class80.scriptStringStack[class294.scriptStringStackSize];
                                                                                                               String var79 = class80.scriptStringStack[class294.scriptStringStackSize + 1];
                                                                                                               var19 = Client.languageId;
                                                                                                               var20 = var78.length();
                                                                                                               var21 = var79.length();
                                                                                                               var22 = 0;
                                                                                                               var85 = 0;
                                                                                                               char var88 = 0;
                                                                                                               char var25 = 0;

                                                                                                               label1725:
                                                                                                               while(true) {
                                                                                                                  if(var22 - var88 >= var20 && var85 - var25 >= var21) {
                                                                                                                     int var95 = Math.min(var20, var21);

                                                                                                                     char var29;
                                                                                                                     int var97;
                                                                                                                     for(var97 = 0; var97 < var95; ++var97) {
                                                                                                                        char var28 = var78.charAt(var97);
                                                                                                                        var29 = var79.charAt(var97);
                                                                                                                        if(var28 != var29 && Character.toUpperCase(var28) != Character.toUpperCase(var29)) {
                                                                                                                           var28 = Character.toLowerCase(var28);
                                                                                                                           var29 = Character.toLowerCase(var29);
                                                                                                                           if(var28 != var29) {
                                                                                                                              var16 = class28.method241(var28, var19) - class28.method241(var29, var19);
                                                                                                                              break label1725;
                                                                                                                           }
                                                                                                                        }
                                                                                                                     }

                                                                                                                     var97 = var20 - var21;
                                                                                                                     if(var97 != 0) {
                                                                                                                        var16 = var97;
                                                                                                                     } else {
                                                                                                                        for(int var98 = 0; var98 < var95; ++var98) {
                                                                                                                           var29 = var78.charAt(var98);
                                                                                                                           char var30 = var79.charAt(var98);
                                                                                                                           if(var30 != var29) {
                                                                                                                              var16 = class28.method241(var29, var19) - class28.method241(var30, var19);
                                                                                                                              break label1725;
                                                                                                                           }
                                                                                                                        }

                                                                                                                        var16 = 0;
                                                                                                                     }
                                                                                                                     break;
                                                                                                                  }

                                                                                                                  if(var22 - var88 >= var20) {
                                                                                                                     var16 = -1;
                                                                                                                     break;
                                                                                                                  }

                                                                                                                  if(var85 - var25 >= var21) {
                                                                                                                     var16 = 1;
                                                                                                                     break;
                                                                                                                  }

                                                                                                                  char var26;
                                                                                                                  if(var88 != 0) {
                                                                                                                     var26 = var88;
                                                                                                                     boolean var89 = false;
                                                                                                                  } else {
                                                                                                                     var26 = var78.charAt(var22++);
                                                                                                                  }

                                                                                                                  char var27;
                                                                                                                  if(var25 != 0) {
                                                                                                                     var27 = var25;
                                                                                                                     boolean var91 = false;
                                                                                                                  } else {
                                                                                                                     var27 = var79.charAt(var85++);
                                                                                                                  }

                                                                                                                  var88 = DecorativeObject.method3143(var26);
                                                                                                                  var25 = DecorativeObject.method3143(var27);
                                                                                                                  var26 = SoundTask.method2329(var26, var19);
                                                                                                                  var27 = SoundTask.method2329(var27, var19);
                                                                                                                  if(var27 != var26 && Character.toUpperCase(var26) != Character.toUpperCase(var27)) {
                                                                                                                     var26 = Character.toLowerCase(var26);
                                                                                                                     var27 = Character.toLowerCase(var27);
                                                                                                                     if(var26 != var27) {
                                                                                                                        var16 = class28.method241(var26, var19) - class28.method241(var27, var19);
                                                                                                                        break;
                                                                                                                     }
                                                                                                                  }
                                                                                                               }

                                                                                                               var83[var39] = Occluder.method3141(var16);
                                                                                                               var37 = 1;
                                                                                                            } else {
                                                                                                               byte[] var75;
                                                                                                               Font var76;
                                                                                                               if(var7 == 4108) {
                                                                                                                  var64 = class80.scriptStringStack[--class294.scriptStringStackSize];
                                                                                                                  class80.intStackSize -= 2;
                                                                                                                  var39 = class80.intStack[class80.intStackSize];
                                                                                                                  var16 = class80.intStack[class80.intStackSize + 1];
                                                                                                                  var75 = class27.indexCache13.getConfigData(var16, 0);
                                                                                                                  var76 = new Font(var75);
                                                                                                                  class80.intStack[++class80.intStackSize - 1] = var76.method5370(var64, var39);
                                                                                                                  var37 = 1;
                                                                                                               } else if(var7 == 4109) {
                                                                                                                  var64 = class80.scriptStringStack[--class294.scriptStringStackSize];
                                                                                                                  class80.intStackSize -= 2;
                                                                                                                  var39 = class80.intStack[class80.intStackSize];
                                                                                                                  var16 = class80.intStack[class80.intStackSize + 1];
                                                                                                                  var75 = class27.indexCache13.getConfigData(var16, 0);
                                                                                                                  var76 = new Font(var75);
                                                                                                                  class80.intStack[++class80.intStackSize - 1] = var76.method5447(var64, var39);
                                                                                                                  var37 = 1;
                                                                                                               } else if(var7 == 4110) {
                                                                                                                  class294.scriptStringStackSize -= 2;
                                                                                                                  var64 = class80.scriptStringStack[class294.scriptStringStackSize];
                                                                                                                  var65 = class80.scriptStringStack[class294.scriptStringStackSize + 1];
                                                                                                                  if(class80.intStack[--class80.intStackSize] == 1) {
                                                                                                                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var64;
                                                                                                                  } else {
                                                                                                                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var65;
                                                                                                                  }

                                                                                                                  var37 = 1;
                                                                                                               } else if(var7 == 4111) {
                                                                                                                  var64 = class80.scriptStringStack[--class294.scriptStringStackSize];
                                                                                                                  class80.scriptStringStack[++class294.scriptStringStackSize - 1] = FontTypeFace.appendTags(var64);
                                                                                                                  var37 = 1;
                                                                                                               } else if(var7 == 4112) {
                                                                                                                  var64 = class80.scriptStringStack[--class294.scriptStringStackSize];
                                                                                                                  var39 = class80.intStack[--class80.intStackSize];
                                                                                                                  class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var64 + (char)var39;
                                                                                                                  var37 = 1;
                                                                                                               } else if(var7 == 4113) {
                                                                                                                  var38 = class80.intStack[--class80.intStackSize];
                                                                                                                  class80.intStack[++class80.intStackSize - 1] = AttackOption.method1885((char)var38)?1:0;
                                                                                                                  var37 = 1;
                                                                                                               } else if(var7 == 4114) {
                                                                                                                  var38 = class80.intStack[--class80.intStackSize];
                                                                                                                  class80.intStack[++class80.intStackSize - 1] = class167.method3382((char)var38)?1:0;
                                                                                                                  var37 = 1;
                                                                                                               } else {
                                                                                                                  char var108;
                                                                                                                  if(var7 == 4115) {
                                                                                                                     var38 = class80.intStack[--class80.intStackSize];
                                                                                                                     var69 = class80.intStack;
                                                                                                                     var16 = ++class80.intStackSize - 1;
                                                                                                                     var108 = (char)var38;
                                                                                                                     var41 = var108 >= 'A' && var108 <= 'Z' || var108 >= 'a' && var108 <= 'z';
                                                                                                                     var69[var16] = var41?1:0;
                                                                                                                     var37 = 1;
                                                                                                                  } else if(var7 == 4116) {
                                                                                                                     var38 = class80.intStack[--class80.intStackSize];
                                                                                                                     var69 = class80.intStack;
                                                                                                                     var16 = ++class80.intStackSize - 1;
                                                                                                                     var108 = (char)var38;
                                                                                                                     var41 = var108 >= '0' && var108 <= '9';
                                                                                                                     var69[var16] = var41?1:0;
                                                                                                                     var37 = 1;
                                                                                                                  } else if(var7 == 4117) {
                                                                                                                     var64 = class80.scriptStringStack[--class294.scriptStringStackSize];
                                                                                                                     if(var64 != null) {
                                                                                                                        class80.intStack[++class80.intStackSize - 1] = var64.length();
                                                                                                                     } else {
                                                                                                                        class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                     }

                                                                                                                     var37 = 1;
                                                                                                                  } else if(var7 == 4118) {
                                                                                                                     var64 = class80.scriptStringStack[--class294.scriptStringStackSize];
                                                                                                                     class80.intStackSize -= 2;
                                                                                                                     var39 = class80.intStack[class80.intStackSize];
                                                                                                                     var16 = class80.intStack[class80.intStackSize + 1];
                                                                                                                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var64.substring(var39, var16);
                                                                                                                     var37 = 1;
                                                                                                                  } else if(var7 != 4119) {
                                                                                                                     if(var7 == 4120) {
                                                                                                                        var64 = class80.scriptStringStack[--class294.scriptStringStackSize];
                                                                                                                        var39 = class80.intStack[--class80.intStackSize];
                                                                                                                        class80.intStack[++class80.intStackSize - 1] = var64.indexOf(var39);
                                                                                                                        var37 = 1;
                                                                                                                     } else if(var7 == 4121) {
                                                                                                                        class294.scriptStringStackSize -= 2;
                                                                                                                        var64 = class80.scriptStringStack[class294.scriptStringStackSize];
                                                                                                                        var65 = class80.scriptStringStack[class294.scriptStringStackSize + 1];
                                                                                                                        var16 = class80.intStack[--class80.intStackSize];
                                                                                                                        class80.intStack[++class80.intStackSize - 1] = var64.indexOf(var65, var16);
                                                                                                                        var37 = 1;
                                                                                                                     } else {
                                                                                                                        var37 = 2;
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     var64 = class80.scriptStringStack[--class294.scriptStringStackSize];
                                                                                                                     StringBuilder var73 = new StringBuilder(var64.length());
                                                                                                                     boolean var70 = false;

                                                                                                                     for(var111 = 0; var111 < var64.length(); ++var111) {
                                                                                                                        var108 = var64.charAt(var111);
                                                                                                                        if(var108 == '<') {
                                                                                                                           var70 = true;
                                                                                                                        } else if(var108 == '>') {
                                                                                                                           var70 = false;
                                                                                                                        } else if(!var70) {
                                                                                                                           var73.append(var108);
                                                                                                                        }
                                                                                                                     }

                                                                                                                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var73.toString();
                                                                                                                     var37 = 1;
                                                                                                                  }
                                                                                                               }
                                                                                                            }

                                                                                                            var36 = var37;
                                                                                                         } else if(var7 < 4300) {
                                                                                                            var36 = Friend.method5348(var7, var3, var68);
                                                                                                         } else if(var7 < 5100) {
                                                                                                            var36 = MessageNode.method1112(var7, var3, var68);
                                                                                                         } else if(var7 < 5400) {
                                                                                                            if(var7 == 5306) {
                                                                                                               class80.intStack[++class80.intStackSize - 1] = BoundingBox.method40();
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 5307) {
                                                                                                               var38 = class80.intStack[--class80.intStackSize];
                                                                                                               if(var38 == 1 || var38 == 2) {
                                                                                                                  class283.method5349(var38);
                                                                                                               }

                                                                                                               var37 = 1;
                                                                                                            } else if(var7 == 5308) {
                                                                                                               class80.intStack[++class80.intStackSize - 1] = WorldComparator.preferences.screenType;
                                                                                                               var37 = 1;
                                                                                                            } else if(var7 != 5309) {
                                                                                                               var37 = 2;
                                                                                                            } else {
                                                                                                               var38 = class80.intStack[--class80.intStackSize];
                                                                                                               if(var38 == 1 || var38 == 2) {
                                                                                                                  WorldComparator.preferences.screenType = var38;
                                                                                                                  CombatInfo1.method1618();
                                                                                                               }

                                                                                                               var37 = 1;
                                                                                                            }

                                                                                                            var36 = var37;
                                                                                                         } else if(var7 < 5600) {
                                                                                                            var36 = Frames.method3124(var7, var3, var68);
                                                                                                         } else if(var7 < 5700) {
                                                                                                            var36 = class22.method172(var7, var3, var68);
                                                                                                         } else if(var7 < 6300) {
                                                                                                            var36 = UrlRequest.method3155(var7, var3, var68);
                                                                                                         } else if(var7 < 6600) {
                                                                                                            if(var7 == 6500) {
                                                                                                               class80.intStack[++class80.intStackSize - 1] = SoundTaskDataProvider.loadWorlds()?1:0;
                                                                                                               var37 = 1;
                                                                                                            } else {
                                                                                                               World var86;
                                                                                                               if(var7 == 6501) {
                                                                                                                  var86 = GrandExchangeEvents.method76();
                                                                                                                  if(var86 != null) {
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = var86.id;
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = var86.mask;
                                                                                                                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var86.activity;
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = var86.location;
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = var86.playerCount;
                                                                                                                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var86.address;
                                                                                                                  } else {
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var37 = 1;
                                                                                                               } else if(var7 == 6502) {
                                                                                                                  var86 = FileRequest.method4498();
                                                                                                                  if(var86 != null) {
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = var86.id;
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = var86.mask;
                                                                                                                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var86.activity;
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = var86.location;
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = var86.playerCount;
                                                                                                                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var86.address;
                                                                                                                  } else {
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var37 = 1;
                                                                                                               } else {
                                                                                                                  World var81;
                                                                                                                  if(var7 == 6506) {
                                                                                                                     var38 = class80.intStack[--class80.intStackSize];
                                                                                                                     var81 = null;

                                                                                                                     for(var16 = 0; var16 < World.worldCount; ++var16) {
                                                                                                                        if(var38 == class31.worldList[var16].id) {
                                                                                                                           var81 = class31.worldList[var16];
                                                                                                                           break;
                                                                                                                        }
                                                                                                                     }

                                                                                                                     if(var81 != null) {
                                                                                                                        class80.intStack[++class80.intStackSize - 1] = var81.id;
                                                                                                                        class80.intStack[++class80.intStackSize - 1] = var81.mask;
                                                                                                                        class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var81.activity;
                                                                                                                        class80.intStack[++class80.intStackSize - 1] = var81.location;
                                                                                                                        class80.intStack[++class80.intStackSize - 1] = var81.playerCount;
                                                                                                                        class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var81.address;
                                                                                                                     } else {
                                                                                                                        class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                                        class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                        class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
                                                                                                                        class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                        class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                        class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var37 = 1;
                                                                                                                  } else if(var7 == 6507) {
                                                                                                                     class80.intStackSize -= 4;
                                                                                                                     var38 = class80.intStack[class80.intStackSize];
                                                                                                                     var109 = class80.intStack[class80.intStackSize + 1] == 1;
                                                                                                                     var16 = class80.intStack[class80.intStackSize + 2];
                                                                                                                     var41 = class80.intStack[class80.intStackSize + 3] == 1;
                                                                                                                     if(class31.worldList != null) {
                                                                                                                        class186.method3764(0, class31.worldList.length - 1, var38, var109, var16, var41);
                                                                                                                     }

                                                                                                                     var37 = 1;
                                                                                                                  } else if(var7 != 6511) {
                                                                                                                     if(var7 == 6512) {
                                                                                                                        Client.field1013 = class80.intStack[--class80.intStackSize] == 1;
                                                                                                                        var37 = 1;
                                                                                                                     } else {
                                                                                                                        class262 var101;
                                                                                                                        if(var7 == 6513) {
                                                                                                                           class80.intStackSize -= 2;
                                                                                                                           var38 = class80.intStack[class80.intStackSize];
                                                                                                                           var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                                           var101 = class185.method3760(var39);
                                                                                                                           if(var101.method4833()) {
                                                                                                                              class80.scriptStringStack[++class294.scriptStringStackSize - 1] = Spotanim.getNpcDefinition(var38).method5028(var39, var101.field3469);
                                                                                                                           } else {
                                                                                                                              class80.intStack[++class80.intStackSize - 1] = Spotanim.getNpcDefinition(var38).method5037(var39, var101.field3465);
                                                                                                                           }

                                                                                                                           var37 = 1;
                                                                                                                        } else if(var7 == 6514) {
                                                                                                                           class80.intStackSize -= 2;
                                                                                                                           var38 = class80.intStack[class80.intStackSize];
                                                                                                                           var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                                           var101 = class185.method3760(var39);
                                                                                                                           if(var101.method4833()) {
                                                                                                                              class80.scriptStringStack[++class294.scriptStringStackSize - 1] = class219.getObjectDefinition(var38).method4927(var39, var101.field3469);
                                                                                                                           } else {
                                                                                                                              class80.intStack[++class80.intStackSize - 1] = class219.getObjectDefinition(var38).method4926(var39, var101.field3465);
                                                                                                                           }

                                                                                                                           var37 = 1;
                                                                                                                        } else if(var7 == 6515) {
                                                                                                                           class80.intStackSize -= 2;
                                                                                                                           var38 = class80.intStack[class80.intStackSize];
                                                                                                                           var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                                           var101 = class185.method3760(var39);
                                                                                                                           if(var101.method4833()) {
                                                                                                                              class80.scriptStringStack[++class294.scriptStringStackSize - 1] = ItemContainer.getItemDefinition(var38).method4980(var39, var101.field3469);
                                                                                                                           } else {
                                                                                                                              class80.intStack[++class80.intStackSize - 1] = ItemContainer.getItemDefinition(var38).method4979(var39, var101.field3465);
                                                                                                                           }

                                                                                                                           var37 = 1;
                                                                                                                        } else if(var7 == 6516) {
                                                                                                                           class80.intStackSize -= 2;
                                                                                                                           var38 = class80.intStack[class80.intStackSize];
                                                                                                                           var39 = class80.intStack[class80.intStackSize + 1];
                                                                                                                           var101 = class185.method3760(var39);
                                                                                                                           class263 var51;
                                                                                                                           byte[] var52;
                                                                                                                           class263 var110;
                                                                                                                           if(var101.method4833()) {
                                                                                                                              String[] var80 = class80.scriptStringStack;
                                                                                                                              var107 = ++class294.scriptStringStackSize - 1;
                                                                                                                              var51 = (class263)class263.field3473.get((long)var38);
                                                                                                                              if(var51 != null) {
                                                                                                                                 var110 = var51;
                                                                                                                              } else {
                                                                                                                                 var52 = class263.field3475.getConfigData(34, var38);
                                                                                                                                 var51 = new class263();
                                                                                                                                 if(var52 != null) {
                                                                                                                                    var51.method4863(new Buffer(var52));
                                                                                                                                 }

                                                                                                                                 var51.method4846();
                                                                                                                                 class263.field3473.put(var51, (long)var38);
                                                                                                                                 var110 = var51;
                                                                                                                              }

                                                                                                                              var80[var107] = var110.method4850(var39, var101.field3469);
                                                                                                                           } else {
                                                                                                                              int[] var82 = class80.intStack;
                                                                                                                              var107 = ++class80.intStackSize - 1;
                                                                                                                              var51 = (class263)class263.field3473.get((long)var38);
                                                                                                                              if(var51 != null) {
                                                                                                                                 var110 = var51;
                                                                                                                              } else {
                                                                                                                                 var52 = class263.field3475.getConfigData(34, var38);
                                                                                                                                 var51 = new class263();
                                                                                                                                 if(var52 != null) {
                                                                                                                                    var51.method4863(new Buffer(var52));
                                                                                                                                 }

                                                                                                                                 var51.method4846();
                                                                                                                                 class263.field3473.put(var51, (long)var38);
                                                                                                                                 var110 = var51;
                                                                                                                              }

                                                                                                                              var82[var107] = var110.method4849(var39, var101.field3465);
                                                                                                                           }

                                                                                                                           var37 = 1;
                                                                                                                        } else if(var7 == 6518) {
                                                                                                                           class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                           var37 = 1;
                                                                                                                        } else if(var7 == 6520) {
                                                                                                                           var37 = 1;
                                                                                                                        } else if(var7 == 6521) {
                                                                                                                           var37 = 1;
                                                                                                                        } else {
                                                                                                                           var37 = 2;
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     var38 = class80.intStack[--class80.intStackSize];
                                                                                                                     if(var38 >= 0 && var38 < World.worldCount) {
                                                                                                                        var81 = class31.worldList[var38];
                                                                                                                        class80.intStack[++class80.intStackSize - 1] = var81.id;
                                                                                                                        class80.intStack[++class80.intStackSize - 1] = var81.mask;
                                                                                                                        class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var81.activity;
                                                                                                                        class80.intStack[++class80.intStackSize - 1] = var81.location;
                                                                                                                        class80.intStack[++class80.intStackSize - 1] = var81.playerCount;
                                                                                                                        class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var81.address;
                                                                                                                     } else {
                                                                                                                        class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                                        class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                        class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
                                                                                                                        class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                        class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                        class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var37 = 1;
                                                                                                                  }
                                                                                                               }
                                                                                                            }

                                                                                                            var36 = var37;
                                                                                                         } else if(var7 < 6700) {
                                                                                                            if(var7 == 6600) {
                                                                                                               var38 = class60.plane;
                                                                                                               var39 = (GroundObject.localPlayer.x >> 7) + ClanMemberManager.baseX;
                                                                                                               var16 = (GroundObject.localPlayer.y >> 7) + WorldMapData.baseY;
                                                                                                               class33.method340().method5817(var38, var39, var16, true);
                                                                                                               var37 = 1;
                                                                                                            } else {
                                                                                                               WorldMapData var103;
                                                                                                               if(var7 == 6601) {
                                                                                                                  var38 = class80.intStack[--class80.intStackSize];
                                                                                                                  var65 = "";
                                                                                                                  var103 = class33.method340().method5835(var38);
                                                                                                                  if(var103 != null) {
                                                                                                                     var65 = var103.method281();
                                                                                                                  }

                                                                                                                  class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var65;
                                                                                                                  var37 = 1;
                                                                                                               } else if(var7 == 6602) {
                                                                                                                  var38 = class80.intStack[--class80.intStackSize];
                                                                                                                  class33.method340().method5847(var38);
                                                                                                                  var37 = 1;
                                                                                                               } else if(var7 == 6603) {
                                                                                                                  class80.intStack[++class80.intStackSize - 1] = class33.method340().method5832();
                                                                                                                  var37 = 1;
                                                                                                               } else if(var7 == 6604) {
                                                                                                                  var38 = class80.intStack[--class80.intStackSize];
                                                                                                                  class33.method340().method5829(var38);
                                                                                                                  var37 = 1;
                                                                                                               } else if(var7 == 6605) {
                                                                                                                  class80.intStack[++class80.intStackSize - 1] = class33.method340().method5834()?1:0;
                                                                                                                  var37 = 1;
                                                                                                               } else {
                                                                                                                  Coordinates var87;
                                                                                                                  if(var7 == 6606) {
                                                                                                                     var87 = new Coordinates(class80.intStack[--class80.intStackSize]);
                                                                                                                     class33.method340().method5930(var87.worldX, var87.worldY);
                                                                                                                     var37 = 1;
                                                                                                                  } else if(var7 == 6607) {
                                                                                                                     var87 = new Coordinates(class80.intStack[--class80.intStackSize]);
                                                                                                                     class33.method340().method5887(var87.worldX, var87.worldY);
                                                                                                                     var37 = 1;
                                                                                                                  } else if(var7 == 6608) {
                                                                                                                     var87 = new Coordinates(class80.intStack[--class80.intStackSize]);
                                                                                                                     class33.method340().method5838(var87.plane, var87.worldX, var87.worldY);
                                                                                                                     var37 = 1;
                                                                                                                  } else if(var7 == 6609) {
                                                                                                                     var87 = new Coordinates(class80.intStack[--class80.intStackSize]);
                                                                                                                     class33.method340().method5839(var87.plane, var87.worldX, var87.worldY);
                                                                                                                     var37 = 1;
                                                                                                                  } else if(var7 == 6610) {
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = class33.method340().method5840();
                                                                                                                     class80.intStack[++class80.intStackSize - 1] = class33.method340().method5870();
                                                                                                                     var37 = 1;
                                                                                                                  } else {
                                                                                                                     WorldMapData var84;
                                                                                                                     if(var7 == 6611) {
                                                                                                                        var38 = class80.intStack[--class80.intStackSize];
                                                                                                                        var84 = class33.method340().method5835(var38);
                                                                                                                        if(var84 == null) {
                                                                                                                           class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                        } else {
                                                                                                                           class80.intStack[++class80.intStackSize - 1] = var84.method291().method4357();
                                                                                                                        }

                                                                                                                        var37 = 1;
                                                                                                                     } else if(var7 == 6612) {
                                                                                                                        var38 = class80.intStack[--class80.intStackSize];
                                                                                                                        var84 = class33.method340().method5835(var38);
                                                                                                                        if(var84 == null) {
                                                                                                                           class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                           class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                        } else {
                                                                                                                           class80.intStack[++class80.intStackSize - 1] = (var84.method320() - var84.method284() + 1) * 64;
                                                                                                                           class80.intStack[++class80.intStackSize - 1] = (var84.method287() - var84.method305() + 1) * 64;
                                                                                                                        }

                                                                                                                        var37 = 1;
                                                                                                                     } else if(var7 == 6613) {
                                                                                                                        var38 = class80.intStack[--class80.intStackSize];
                                                                                                                        var84 = class33.method340().method5835(var38);
                                                                                                                        if(var84 == null) {
                                                                                                                           class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                           class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                           class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                           class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                        } else {
                                                                                                                           class80.intStack[++class80.intStackSize - 1] = var84.method284() * 64;
                                                                                                                           class80.intStack[++class80.intStackSize - 1] = var84.method305() * 64;
                                                                                                                           class80.intStack[++class80.intStackSize - 1] = var84.method320() * 64 + 64 - 1;
                                                                                                                           class80.intStack[++class80.intStackSize - 1] = var84.method287() * 64 + 64 - 1;
                                                                                                                        }

                                                                                                                        var37 = 1;
                                                                                                                     } else if(var7 == 6614) {
                                                                                                                        var38 = class80.intStack[--class80.intStackSize];
                                                                                                                        var84 = class33.method340().method5835(var38);
                                                                                                                        if(var84 == null) {
                                                                                                                           class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                                        } else {
                                                                                                                           class80.intStack[++class80.intStackSize - 1] = var84.method311();
                                                                                                                        }

                                                                                                                        var37 = 1;
                                                                                                                     } else if(var7 == 6615) {
                                                                                                                        var87 = class33.method340().method5813();
                                                                                                                        if(var87 == null) {
                                                                                                                           class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                                           class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                                        } else {
                                                                                                                           class80.intStack[++class80.intStackSize - 1] = var87.worldX;
                                                                                                                           class80.intStack[++class80.intStackSize - 1] = var87.worldY;
                                                                                                                        }

                                                                                                                        var37 = 1;
                                                                                                                     } else if(var7 == 6616) {
                                                                                                                        class80.intStack[++class80.intStackSize - 1] = class33.method340().method5821();
                                                                                                                        var37 = 1;
                                                                                                                     } else if(var7 == 6617) {
                                                                                                                        var87 = new Coordinates(class80.intStack[--class80.intStackSize]);
                                                                                                                        var84 = class33.method340().method5822();
                                                                                                                        if(var84 == null) {
                                                                                                                           class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                                           class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                                           var37 = 1;
                                                                                                                        } else {
                                                                                                                           int[] var104 = var84.method331(var87.plane, var87.worldX, var87.worldY);
                                                                                                                           if(var104 == null) {
                                                                                                                              class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                                              class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                                           } else {
                                                                                                                              class80.intStack[++class80.intStackSize - 1] = var104[0];
                                                                                                                              class80.intStack[++class80.intStackSize - 1] = var104[1];
                                                                                                                           }

                                                                                                                           var37 = 1;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        Coordinates var105;
                                                                                                                        if(var7 == 6618) {
                                                                                                                           var87 = new Coordinates(class80.intStack[--class80.intStackSize]);
                                                                                                                           var84 = class33.method340().method5822();
                                                                                                                           if(var84 == null) {
                                                                                                                              class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                                              class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                                              var37 = 1;
                                                                                                                           } else {
                                                                                                                              var105 = var84.method286(var87.worldX, var87.worldY);
                                                                                                                              if(var105 == null) {
                                                                                                                                 class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                                              } else {
                                                                                                                                 class80.intStack[++class80.intStackSize - 1] = var105.method4357();
                                                                                                                              }

                                                                                                                              var37 = 1;
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           Coordinates var90;
                                                                                                                           if(var7 == 6619) {
                                                                                                                              class80.intStackSize -= 2;
                                                                                                                              var38 = class80.intStack[class80.intStackSize];
                                                                                                                              var90 = new Coordinates(class80.intStack[class80.intStackSize + 1]);
                                                                                                                              class87.method1878(var38, var90, false);
                                                                                                                              var37 = 1;
                                                                                                                           } else if(var7 == 6620) {
                                                                                                                              class80.intStackSize -= 2;
                                                                                                                              var38 = class80.intStack[class80.intStackSize];
                                                                                                                              var90 = new Coordinates(class80.intStack[class80.intStackSize + 1]);
                                                                                                                              class87.method1878(var38, var90, true);
                                                                                                                              var37 = 1;
                                                                                                                           } else if(var7 == 6621) {
                                                                                                                              class80.intStackSize -= 2;
                                                                                                                              var38 = class80.intStack[class80.intStackSize];
                                                                                                                              var90 = new Coordinates(class80.intStack[class80.intStackSize + 1]);
                                                                                                                              var103 = class33.method340().method5835(var38);
                                                                                                                              if(var103 == null) {
                                                                                                                                 class80.intStack[++class80.intStackSize - 1] = 0;
                                                                                                                                 var37 = 1;
                                                                                                                              } else {
                                                                                                                                 class80.intStack[++class80.intStackSize - 1] = var103.method334(var90.plane, var90.worldX, var90.worldY)?1:0;
                                                                                                                                 var37 = 1;
                                                                                                                              }
                                                                                                                           } else if(var7 == 6622) {
                                                                                                                              class80.intStack[++class80.intStackSize - 1] = class33.method340().method5843();
                                                                                                                              class80.intStack[++class80.intStackSize - 1] = class33.method340().method5933();
                                                                                                                              var37 = 1;
                                                                                                                           } else if(var7 == 6623) {
                                                                                                                              var87 = new Coordinates(class80.intStack[--class80.intStackSize]);
                                                                                                                              var84 = class33.method340().method5819(var87.plane, var87.worldX, var87.worldY);
                                                                                                                              if(var84 == null) {
                                                                                                                                 class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                                              } else {
                                                                                                                                 class80.intStack[++class80.intStackSize - 1] = var84.method279();
                                                                                                                              }

                                                                                                                              var37 = 1;
                                                                                                                           } else if(var7 == 6624) {
                                                                                                                              class33.method340().method5845(class80.intStack[--class80.intStackSize]);
                                                                                                                              var37 = 1;
                                                                                                                           } else if(var7 == 6625) {
                                                                                                                              class33.method340().method5846();
                                                                                                                              var37 = 1;
                                                                                                                           } else if(var7 == 6626) {
                                                                                                                              class33.method340().method5875(class80.intStack[--class80.intStackSize]);
                                                                                                                              var37 = 1;
                                                                                                                           } else if(var7 == 6627) {
                                                                                                                              class33.method340().method5848();
                                                                                                                              var37 = 1;
                                                                                                                           } else {
                                                                                                                              boolean var112;
                                                                                                                              if(var7 == 6628) {
                                                                                                                                 var112 = class80.intStack[--class80.intStackSize] == 1;
                                                                                                                                 class33.method340().method5849(var112);
                                                                                                                                 var37 = 1;
                                                                                                                              } else if(var7 == 6629) {
                                                                                                                                 var38 = class80.intStack[--class80.intStackSize];
                                                                                                                                 class33.method340().method5850(var38);
                                                                                                                                 var37 = 1;
                                                                                                                              } else if(var7 == 6630) {
                                                                                                                                 var38 = class80.intStack[--class80.intStackSize];
                                                                                                                                 class33.method340().method5962(var38);
                                                                                                                                 var37 = 1;
                                                                                                                              } else if(var7 == 6631) {
                                                                                                                                 class33.method340().method5852();
                                                                                                                                 var37 = 1;
                                                                                                                              } else if(var7 == 6632) {
                                                                                                                                 var112 = class80.intStack[--class80.intStackSize] == 1;
                                                                                                                                 class33.method340().method5865(var112);
                                                                                                                                 var37 = 1;
                                                                                                                              } else if(var7 == 6633) {
                                                                                                                                 class80.intStackSize -= 2;
                                                                                                                                 var38 = class80.intStack[class80.intStackSize];
                                                                                                                                 var109 = class80.intStack[class80.intStackSize + 1] == 1;
                                                                                                                                 class33.method340().method5854(var38, var109);
                                                                                                                                 var37 = 1;
                                                                                                                              } else if(var7 == 6634) {
                                                                                                                                 class80.intStackSize -= 2;
                                                                                                                                 var38 = class80.intStack[class80.intStackSize];
                                                                                                                                 var109 = class80.intStack[class80.intStackSize + 1] == 1;
                                                                                                                                 class33.method340().method5948(var38, var109);
                                                                                                                                 var37 = 1;
                                                                                                                              } else if(var7 == 6635) {
                                                                                                                                 class80.intStack[++class80.intStackSize - 1] = class33.method340().method5856()?1:0;
                                                                                                                                 var37 = 1;
                                                                                                                              } else if(var7 == 6636) {
                                                                                                                                 var38 = class80.intStack[--class80.intStackSize];
                                                                                                                                 class80.intStack[++class80.intStackSize - 1] = class33.method340().method5907(var38)?1:0;
                                                                                                                                 var37 = 1;
                                                                                                                              } else if(var7 == 6637) {
                                                                                                                                 var38 = class80.intStack[--class80.intStackSize];
                                                                                                                                 class80.intStack[++class80.intStackSize - 1] = class33.method340().method5858(var38)?1:0;
                                                                                                                                 var37 = 1;
                                                                                                                              } else if(var7 == 6638) {
                                                                                                                                 class80.intStackSize -= 2;
                                                                                                                                 var38 = class80.intStack[class80.intStackSize];
                                                                                                                                 var90 = new Coordinates(class80.intStack[class80.intStackSize + 1]);
                                                                                                                                 var105 = class33.method340().method5861(var38, var90);
                                                                                                                                 if(var105 == null) {
                                                                                                                                    class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                                                 } else {
                                                                                                                                    class80.intStack[++class80.intStackSize - 1] = var105.method4357();
                                                                                                                                 }

                                                                                                                                 var37 = 1;
                                                                                                                              } else {
                                                                                                                                 class39 var92;
                                                                                                                                 if(var7 == 6639) {
                                                                                                                                    var92 = class33.method340().method5953();
                                                                                                                                    if(var92 == null) {
                                                                                                                                       class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                                                       class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                                                    } else {
                                                                                                                                       class80.intStack[++class80.intStackSize - 1] = var92.field514;
                                                                                                                                       class80.intStack[++class80.intStackSize - 1] = var92.field509.method4357();
                                                                                                                                    }

                                                                                                                                    var37 = 1;
                                                                                                                                 } else if(var7 == 6640) {
                                                                                                                                    var92 = class33.method340().method5929();
                                                                                                                                    if(var92 == null) {
                                                                                                                                       class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                                                       class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                                                    } else {
                                                                                                                                       class80.intStack[++class80.intStackSize - 1] = var92.field514;
                                                                                                                                       class80.intStack[++class80.intStackSize - 1] = var92.field509.method4357();
                                                                                                                                    }

                                                                                                                                    var37 = 1;
                                                                                                                                 } else {
                                                                                                                                    Area var93;
                                                                                                                                    if(var7 == 6693) {
                                                                                                                                       var38 = class80.intStack[--class80.intStackSize];
                                                                                                                                       var93 = Area.mapAreaType[var38];
                                                                                                                                       if(var93.name == null) {
                                                                                                                                          class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
                                                                                                                                       } else {
                                                                                                                                          class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var93.name;
                                                                                                                                       }

                                                                                                                                       var37 = 1;
                                                                                                                                    } else if(var7 == 6694) {
                                                                                                                                       var38 = class80.intStack[--class80.intStackSize];
                                                                                                                                       var93 = Area.mapAreaType[var38];
                                                                                                                                       class80.intStack[++class80.intStackSize - 1] = var93.field3378;
                                                                                                                                       var37 = 1;
                                                                                                                                    } else if(var7 == 6695) {
                                                                                                                                       var38 = class80.intStack[--class80.intStackSize];
                                                                                                                                       var93 = Area.mapAreaType[var38];
                                                                                                                                       if(var93 == null) {
                                                                                                                                          class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                                                       } else {
                                                                                                                                          class80.intStack[++class80.intStackSize - 1] = var93.field3396;
                                                                                                                                       }

                                                                                                                                       var37 = 1;
                                                                                                                                    } else if(var7 == 6696) {
                                                                                                                                       var38 = class80.intStack[--class80.intStackSize];
                                                                                                                                       var93 = Area.mapAreaType[var38];
                                                                                                                                       if(var93 == null) {
                                                                                                                                          class80.intStack[++class80.intStackSize - 1] = -1;
                                                                                                                                       } else {
                                                                                                                                          class80.intStack[++class80.intStackSize - 1] = var93.spriteId;
                                                                                                                                       }

                                                                                                                                       var37 = 1;
                                                                                                                                    } else if(var7 == 6697) {
                                                                                                                                       class80.intStack[++class80.intStackSize - 1] = class19.field316.field572;
                                                                                                                                       var37 = 1;
                                                                                                                                    } else if(var7 == 6698) {
                                                                                                                                       class80.intStack[++class80.intStackSize - 1] = class19.field316.field575.method4357();
                                                                                                                                       var37 = 1;
                                                                                                                                    } else if(var7 == 6699) {
                                                                                                                                       class80.intStack[++class80.intStackSize - 1] = class19.field316.field574.method4357();
                                                                                                                                       var37 = 1;
                                                                                                                                    } else {
                                                                                                                                       var37 = 2;
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              }
                                                                                                                           }
                                                                                                                        }
                                                                                                                     }
                                                                                                                  }
                                                                                                               }
                                                                                                            }

                                                                                                            var36 = var37;
                                                                                                         } else {
                                                                                                            var36 = 2;
                                                                                                         }
                                                                                                      }
                                                                                                   }
                                                                                                }
                                                                                             }

                                                                                             switch(var36) {
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
         } catch (Exception var55) {
            StringBuilder var54 = new StringBuilder(30);
            var54.append("").append(var3.hash).append(" ");

            for(var33 = class80.scriptStackCount - 1; var33 >= 0; --var33) {
               var54.append("").append(class80.scriptStack[var33].invokedFromScript.hash).append(" ");
            }

            var54.append("").append(var58);
            GrandExchangeEvent.method78(var54.toString(), var55);
         }
      }
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-105"
   )
   static void method985() {
      PacketNode var0 = Script.method2025(ClientPacket.field2370, Client.field937.field1454);
      var0.packetBuffer.putByte(BoundingBox.method40());
      var0.packetBuffer.putShort(GameEngine.canvasWidth);
      var0.packetBuffer.putShort(IndexFile.canvasHeight);
      Client.field937.method2044(var0);
   }
}
