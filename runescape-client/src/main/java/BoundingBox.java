import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
@Implements("BoundingBox")
public abstract class BoundingBox extends Node {
   @ObfuscatedName("nu")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   static class320 field250;
   @ObfuscatedName("dt")
   @Export("host")
   static String host;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public abstract void vmethod59();

   @ObfuscatedName("d")
   static double method53(double var0) {
      return Math.exp(-var0 * var0 / 2.0D) / Math.sqrt(6.283185307179586D);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lbi;II)V",
      garbageValue = "203062345"
   )
   @Export("runScript")
   static void runScript(ScriptEvent var0, int var1) {
      Object[] var2 = var0.objs;
      Script var3;
      int var7;
      int var8;
      int var9;
      int var11;
      int var28;
      if(OwnWorldComparator.method1193(var0.field793)) {
         SoundTaskDataProvider.scriptMapIconReference = (MapIconReference)var2[0];
         Area var4 = Area.mapAreaType[SoundTaskDataProvider.scriptMapIconReference.areaId];
         class245 var6 = var0.field793;
         var7 = var4.id;
         var8 = var4.field3451;
         var9 = WallObject.method3130(var7, var6);
         Script var10 = class95.getScriptByFile(var9, var6);
         Script var5;
         if(var10 != null) {
            var5 = var10;
         } else {
            var11 = (var8 + 40000 << 8) + var6.field2966;
            var10 = class95.getScriptByFile(var11, var6);
            if(var10 != null) {
               var5 = var10;
            } else {
               var5 = null;
            }
         }

         var3 = var5;
      } else {
         var28 = ((Integer)var2[0]).intValue();
         var3 = class86.method1892(var28);
      }

      if(var3 != null) {
         class81.intStackSize = 0;
         UrlRequester.scriptStringStackSize = 0;
         var28 = -1;
         int[] var50 = var3.instructions;
         int[] var51 = var3.intOperands;
         byte var52 = -1;
         class81.scriptStackCount = 0;

         int var29;
         try {
            class81.scriptLocalInts = new int[var3.localIntCount];
            var8 = 0;
            class81.scriptLocalStrings = new String[var3.localStringCount];
            var9 = 0;

            String var30;
            for(var29 = 1; var29 < var2.length; ++var29) {
               if(var2[var29] instanceof Integer) {
                  var11 = ((Integer)var2[var29]).intValue();
                  if(var11 == -2147483647) {
                     var11 = var0.field791;
                  }

                  if(var11 == -2147483646) {
                     var11 = var0.field790;
                  }

                  if(var11 == -2147483645) {
                     var11 = var0.widget != null?var0.widget.id:-1;
                  }

                  if(var11 == -2147483644) {
                     var11 = var0.field798;
                  }

                  if(var11 == -2147483643) {
                     var11 = var0.widget != null?var0.widget.index:-1;
                  }

                  if(var11 == -2147483642) {
                     var11 = var0.field792 != null?var0.field792.id:-1;
                  }

                  if(var11 == -2147483641) {
                     var11 = var0.field792 != null?var0.field792.index:-1;
                  }

                  if(var11 == -2147483640) {
                     var11 = var0.field794;
                  }

                  if(var11 == -2147483639) {
                     var11 = var0.field795;
                  }

                  class81.scriptLocalInts[var8++] = var11;
               } else if(var2[var29] instanceof String) {
                  var30 = (String)var2[var29];
                  if(var30.equals("event_opbase")) {
                     var30 = var0.string;
                  }

                  class81.scriptLocalStrings[var9++] = var30;
               }
            }

            var29 = 0;
            class81.field1270 = var0.field797;

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
                                                                                       label2754:
                                                                                       while(true) {
                                                                                          ++var29;
                                                                                          if(var29 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var28;
                                                                                          var7 = var50[var28];
                                                                                          int var15;
                                                                                          int var32;
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
                                                                                                                                                                        var11 = var51[var28] >> 16;
                                                                                                                                                                        var32 = var51[var28] & 65535;
                                                                                                                                                                        int var104 = class81.intStack[--class81.intStackSize];
                                                                                                                                                                        if(var104 >= 0 && var104 <= 5000) {
                                                                                                                                                                           class81.field1264[var11] = var104;
                                                                                                                                                                           byte var103 = -1;
                                                                                                                                                                           if(var32 == 105) {
                                                                                                                                                                              var103 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var15 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var15 >= var104) {
                                                                                                                                                                                 continue label2754;
                                                                                                                                                                              }

                                                                                                                                                                              class81.SHAPE_VERTICES[var11][var15] = var103;
                                                                                                                                                                              ++var15;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var7 == 45) {
                                                                                                                                                                        var11 = var51[var28];
                                                                                                                                                                        var32 = class81.intStack[--class81.intStackSize];
                                                                                                                                                                        if(var32 < 0 || var32 >= class81.field1264[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class81.intStack[++class81.intStackSize - 1] = class81.SHAPE_VERTICES[var11][var32];
                                                                                                                                                                     } else if(var7 == 46) {
                                                                                                                                                                        var11 = var51[var28];
                                                                                                                                                                        class81.intStackSize -= 2;
                                                                                                                                                                        var32 = class81.intStack[class81.intStackSize];
                                                                                                                                                                        if(var32 < 0 || var32 >= class81.field1264[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class81.SHAPE_VERTICES[var11][var32] = class81.intStack[class81.intStackSize + 1];
                                                                                                                                                                     } else if(var7 == 47) {
                                                                                                                                                                        var30 = Script.chatMessages.getVarcString(var51[var28]);
                                                                                                                                                                        if(var30 == null) {
                                                                                                                                                                           var30 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var30;
                                                                                                                                                                     } else if(var7 == 48) {
                                                                                                                                                                        Script.chatMessages.putVarcString(var51[var28], class81.scriptStringStack[--UrlRequester.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var7 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        IterableHashTable var77 = var3.switches[var51[var28]];
                                                                                                                                                                        IntegerNode var54 = (IntegerNode)var77.get((long)class81.intStack[--class81.intStackSize]);
                                                                                                                                                                        if(var54 != null) {
                                                                                                                                                                           var28 += var54.value;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     Script.chatMessages.putVarc(var51[var28], class81.intStack[--class81.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class81.intStack[++class81.intStackSize - 1] = Script.chatMessages.getVarc(var51[var28]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var11 = var51[var28];
                                                                                                                                                               Script var53 = class86.method1892(var11);
                                                                                                                                                               int[] var13 = new int[var53.localIntCount];
                                                                                                                                                               String[] var72 = new String[var53.localStringCount];

                                                                                                                                                               for(var15 = 0; var15 < var53.intStackCount; ++var15) {
                                                                                                                                                                  var13[var15] = class81.intStack[var15 + (class81.intStackSize - var53.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var15 = 0; var15 < var53.stringStackCount; ++var15) {
                                                                                                                                                                  var72[var15] = class81.scriptStringStack[var15 + (UrlRequester.scriptStringStackSize - var53.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class81.intStackSize -= var53.intStackCount;
                                                                                                                                                               UrlRequester.scriptStringStackSize -= var53.stringStackCount;
                                                                                                                                                               ScriptState var102 = new ScriptState();
                                                                                                                                                               var102.invokedFromScript = var3;
                                                                                                                                                               var102.invokedFromPc = var28;
                                                                                                                                                               var102.savedLocalInts = class81.scriptLocalInts;
                                                                                                                                                               var102.savedLocalStrings = class81.scriptLocalStrings;
                                                                                                                                                               class81.scriptStack[++class81.scriptStackCount - 1] = var102;
                                                                                                                                                               var3 = var53;
                                                                                                                                                               var50 = var53.instructions;
                                                                                                                                                               var51 = var53.intOperands;
                                                                                                                                                               var28 = -1;
                                                                                                                                                               class81.scriptLocalInts = var13;
                                                                                                                                                               class81.scriptLocalStrings = var72;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --UrlRequester.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class81.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var11 = var51[var28];
                                                                                                                                                      UrlRequester.scriptStringStackSize -= var11;
                                                                                                                                                      String var12 = class203.method3927(class81.scriptStringStack, UrlRequester.scriptStringStackSize, var11);
                                                                                                                                                      class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var12;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class81.scriptLocalStrings[var51[var28]] = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = class81.scriptLocalStrings[var51[var28]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class81.scriptLocalInts[var51[var28]] = class81.intStack[--class81.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class81.intStack[++class81.intStackSize - 1] = class81.scriptLocalInts[var51[var28]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class81.intStackSize -= 2;
                                                                                                                                       if(class81.intStack[class81.intStackSize] >= class81.intStack[class81.intStackSize + 1]) {
                                                                                                                                          var28 += var51[var28];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class81.intStackSize -= 2;
                                                                                                                                    if(class81.intStack[class81.intStackSize] <= class81.intStack[class81.intStackSize + 1]) {
                                                                                                                                       var28 += var51[var28];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var11 = var51[var28];
                                                                                                                                 class64.method1062(var11, class81.intStack[--class81.intStackSize]);
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var11 = var51[var28];
                                                                                                                              class81.intStack[++class81.intStackSize - 1] = class57.getVarbit(var11);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class81.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var73 = class81.scriptStack[--class81.scriptStackCount];
                                                                                                                           var3 = var73.invokedFromScript;
                                                                                                                           var50 = var3.instructions;
                                                                                                                           var51 = var3.intOperands;
                                                                                                                           var28 = var73.invokedFromPc;
                                                                                                                           class81.scriptLocalInts = var73.savedLocalInts;
                                                                                                                           class81.scriptLocalStrings = var73.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class81.intStackSize -= 2;
                                                                                                                        if(class81.intStack[class81.intStackSize] > class81.intStack[class81.intStackSize + 1]) {
                                                                                                                           var28 += var51[var28];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class81.intStackSize -= 2;
                                                                                                                     if(class81.intStack[class81.intStackSize] < class81.intStack[class81.intStackSize + 1]) {
                                                                                                                        var28 += var51[var28];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class81.intStackSize -= 2;
                                                                                                                  if(class81.intStack[class81.intStackSize] == class81.intStack[class81.intStackSize + 1]) {
                                                                                                                     var28 += var51[var28];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class81.intStackSize -= 2;
                                                                                                               if(class81.intStack[class81.intStackSize] != class81.intStack[class81.intStackSize + 1]) {
                                                                                                                  var28 += var51[var28];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var28 += var51[var28];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var3.stringOperands[var28];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var11 = var51[var28];
                                                                                                      class237.widgetSettings[var11] = class81.intStack[--class81.intStackSize];
                                                                                                      class149.method3193(var11);
                                                                                                   }
                                                                                                } else {
                                                                                                   var11 = var51[var28];
                                                                                                   class81.intStack[++class81.intStackSize - 1] = class237.widgetSettings[var11];
                                                                                                }
                                                                                             } else {
                                                                                                class81.intStack[++class81.intStackSize - 1] = var51[var28];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var60;
                                                                                             if(var3.intOperands[var28] == 1) {
                                                                                                var60 = true;
                                                                                             } else {
                                                                                                var60 = false;
                                                                                             }

                                                                                             if(var7 < 1000) {
                                                                                                var32 = UrlRequest.method3184(var7, var3, var60);
                                                                                             } else if(var7 < 1100) {
                                                                                                var32 = class21.method157(var7, var3, var60);
                                                                                             } else if(var7 < 1200) {
                                                                                                var32 = ItemContainer.method1079(var7, var3, var60);
                                                                                             } else if(var7 < 1300) {
                                                                                                var32 = class298.method5395(var7, var3, var60);
                                                                                             } else if(var7 < 1400) {
                                                                                                var32 = WallObject.method3135(var7, var3, var60);
                                                                                             } else if(var7 < 1500) {
                                                                                                var32 = ContextMenuRow.method1893(var7, var3, var60);
                                                                                             } else if(var7 < 1600) {
                                                                                                var32 = GameCanvas.method797(var7, var3, var60);
                                                                                             } else {
                                                                                                Widget var14;
                                                                                                byte var33;
                                                                                                if(var7 < 1700) {
                                                                                                   var14 = var60?class20.field338:class81.field1267;
                                                                                                   if(var7 == 1600) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var14.scrollX;
                                                                                                      var33 = 1;
                                                                                                   } else if(var7 == 1601) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var14.scrollY;
                                                                                                      var33 = 1;
                                                                                                   } else if(var7 == 1602) {
                                                                                                      class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var14.text;
                                                                                                      var33 = 1;
                                                                                                   } else if(var7 == 1603) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var14.scrollWidth;
                                                                                                      var33 = 1;
                                                                                                   } else if(var7 == 1604) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var14.scrollHeight;
                                                                                                      var33 = 1;
                                                                                                   } else if(var7 == 1605) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var14.modelZoom;
                                                                                                      var33 = 1;
                                                                                                   } else if(var7 == 1606) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var14.rotationX;
                                                                                                      var33 = 1;
                                                                                                   } else if(var7 == 1607) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var14.rotationY;
                                                                                                      var33 = 1;
                                                                                                   } else if(var7 == 1608) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var14.rotationZ;
                                                                                                      var33 = 1;
                                                                                                   } else if(var7 == 1609) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var14.opacity;
                                                                                                      var33 = 1;
                                                                                                   } else if(var7 == 1610) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var14.field2857;
                                                                                                      var33 = 1;
                                                                                                   } else if(var7 == 1611) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var14.textColor;
                                                                                                      var33 = 1;
                                                                                                   } else if(var7 == 1612) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var14.field2851;
                                                                                                      var33 = 1;
                                                                                                   } else if(var7 == 1613) {
                                                                                                      class81.intStack[++class81.intStackSize - 1] = var14.field2868.rsOrdinal();
                                                                                                      var33 = 1;
                                                                                                   } else {
                                                                                                      var33 = 2;
                                                                                                   }

                                                                                                   var32 = var33;
                                                                                                } else {
                                                                                                   Widget var17;
                                                                                                   if(var7 < 1800) {
                                                                                                      var17 = var60?class20.field338:class81.field1267;
                                                                                                      if(var7 == 1700) {
                                                                                                         class81.intStack[++class81.intStackSize - 1] = var17.itemId;
                                                                                                         var33 = 1;
                                                                                                      } else if(var7 == 1701) {
                                                                                                         if(var17.itemId != -1) {
                                                                                                            class81.intStack[++class81.intStackSize - 1] = var17.itemQuantity;
                                                                                                         } else {
                                                                                                            class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                         }

                                                                                                         var33 = 1;
                                                                                                      } else if(var7 == 1702) {
                                                                                                         class81.intStack[++class81.intStackSize - 1] = var17.index;
                                                                                                         var33 = 1;
                                                                                                      } else {
                                                                                                         var33 = 2;
                                                                                                      }

                                                                                                      var32 = var33;
                                                                                                   } else if(var7 < 1900) {
                                                                                                      var32 = Frames.method3142(var7, var3, var60);
                                                                                                   } else if(var7 < 2000) {
                                                                                                      var32 = GroundObject.method2737(var7, var3, var60);
                                                                                                   } else if(var7 < 2100) {
                                                                                                      var32 = class21.method157(var7, var3, var60);
                                                                                                   } else if(var7 < 2200) {
                                                                                                      var32 = ItemContainer.method1079(var7, var3, var60);
                                                                                                   } else if(var7 < 2300) {
                                                                                                      var32 = class298.method5395(var7, var3, var60);
                                                                                                   } else if(var7 < 2400) {
                                                                                                      var32 = WallObject.method3135(var7, var3, var60);
                                                                                                   } else if(var7 < 2500) {
                                                                                                      var32 = ContextMenuRow.method1893(var7, var3, var60);
                                                                                                   } else if(var7 < 2600) {
                                                                                                      var14 = class5.getWidget(class81.intStack[--class81.intStackSize]);
                                                                                                      if(var7 == 2500) {
                                                                                                         class81.intStack[++class81.intStackSize - 1] = var14.relativeX;
                                                                                                         var33 = 1;
                                                                                                      } else if(var7 == 2501) {
                                                                                                         class81.intStack[++class81.intStackSize - 1] = var14.relativeY;
                                                                                                         var33 = 1;
                                                                                                      } else if(var7 == 2502) {
                                                                                                         class81.intStack[++class81.intStackSize - 1] = var14.width;
                                                                                                         var33 = 1;
                                                                                                      } else if(var7 == 2503) {
                                                                                                         class81.intStack[++class81.intStackSize - 1] = var14.height;
                                                                                                         var33 = 1;
                                                                                                      } else if(var7 == 2504) {
                                                                                                         class81.intStack[++class81.intStackSize - 1] = var14.isHidden?1:0;
                                                                                                         var33 = 1;
                                                                                                      } else if(var7 == 2505) {
                                                                                                         class81.intStack[++class81.intStackSize - 1] = var14.parentId;
                                                                                                         var33 = 1;
                                                                                                      } else {
                                                                                                         var33 = 2;
                                                                                                      }

                                                                                                      var32 = var33;
                                                                                                   } else if(var7 < 2700) {
                                                                                                      var14 = class5.getWidget(class81.intStack[--class81.intStackSize]);
                                                                                                      if(var7 == 2600) {
                                                                                                         class81.intStack[++class81.intStackSize - 1] = var14.scrollX;
                                                                                                         var33 = 1;
                                                                                                      } else if(var7 == 2601) {
                                                                                                         class81.intStack[++class81.intStackSize - 1] = var14.scrollY;
                                                                                                         var33 = 1;
                                                                                                      } else if(var7 == 2602) {
                                                                                                         class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var14.text;
                                                                                                         var33 = 1;
                                                                                                      } else if(var7 == 2603) {
                                                                                                         class81.intStack[++class81.intStackSize - 1] = var14.scrollWidth;
                                                                                                         var33 = 1;
                                                                                                      } else if(var7 == 2604) {
                                                                                                         class81.intStack[++class81.intStackSize - 1] = var14.scrollHeight;
                                                                                                         var33 = 1;
                                                                                                      } else if(var7 == 2605) {
                                                                                                         class81.intStack[++class81.intStackSize - 1] = var14.modelZoom;
                                                                                                         var33 = 1;
                                                                                                      } else if(var7 == 2606) {
                                                                                                         class81.intStack[++class81.intStackSize - 1] = var14.rotationX;
                                                                                                         var33 = 1;
                                                                                                      } else if(var7 == 2607) {
                                                                                                         class81.intStack[++class81.intStackSize - 1] = var14.rotationY;
                                                                                                         var33 = 1;
                                                                                                      } else if(var7 == 2608) {
                                                                                                         class81.intStack[++class81.intStackSize - 1] = var14.rotationZ;
                                                                                                         var33 = 1;
                                                                                                      } else if(var7 == 2609) {
                                                                                                         class81.intStack[++class81.intStackSize - 1] = var14.opacity;
                                                                                                         var33 = 1;
                                                                                                      } else if(var7 == 2610) {
                                                                                                         class81.intStack[++class81.intStackSize - 1] = var14.field2857;
                                                                                                         var33 = 1;
                                                                                                      } else if(var7 == 2611) {
                                                                                                         class81.intStack[++class81.intStackSize - 1] = var14.textColor;
                                                                                                         var33 = 1;
                                                                                                      } else if(var7 == 2612) {
                                                                                                         class81.intStack[++class81.intStackSize - 1] = var14.field2851;
                                                                                                         var33 = 1;
                                                                                                      } else if(var7 == 2613) {
                                                                                                         class81.intStack[++class81.intStackSize - 1] = var14.field2868.rsOrdinal();
                                                                                                         var33 = 1;
                                                                                                      } else {
                                                                                                         var33 = 2;
                                                                                                      }

                                                                                                      var32 = var33;
                                                                                                   } else {
                                                                                                      int var34;
                                                                                                      if(var7 < 2800) {
                                                                                                         if(var7 == 2700) {
                                                                                                            var14 = class5.getWidget(class81.intStack[--class81.intStackSize]);
                                                                                                            class81.intStack[++class81.intStackSize - 1] = var14.itemId;
                                                                                                            var33 = 1;
                                                                                                         } else if(var7 == 2701) {
                                                                                                            var14 = class5.getWidget(class81.intStack[--class81.intStackSize]);
                                                                                                            if(var14.itemId != -1) {
                                                                                                               class81.intStack[++class81.intStackSize - 1] = var14.itemQuantity;
                                                                                                            } else {
                                                                                                               class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                            }

                                                                                                            var33 = 1;
                                                                                                         } else if(var7 == 2702) {
                                                                                                            var34 = class81.intStack[--class81.intStackSize];
                                                                                                            WidgetNode var31 = (WidgetNode)Client.componentTable.get((long)var34);
                                                                                                            if(var31 != null) {
                                                                                                               class81.intStack[++class81.intStackSize - 1] = 1;
                                                                                                            } else {
                                                                                                               class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                            }

                                                                                                            var33 = 1;
                                                                                                         } else if(var7 == 2706) {
                                                                                                            class81.intStack[++class81.intStackSize - 1] = Client.widgetRoot;
                                                                                                            var33 = 1;
                                                                                                         } else {
                                                                                                            var33 = 2;
                                                                                                         }

                                                                                                         var32 = var33;
                                                                                                      } else {
                                                                                                         int var16;
                                                                                                         int var18;
                                                                                                         int var35;
                                                                                                         int[] var74;
                                                                                                         if(var7 < 2900) {
                                                                                                            var14 = class5.getWidget(class81.intStack[--class81.intStackSize]);
                                                                                                            if(var7 == 2800) {
                                                                                                               var74 = class81.intStack;
                                                                                                               var16 = ++class81.intStackSize - 1;
                                                                                                               var18 = class85.getWidgetConfig(var14);
                                                                                                               var35 = var18 >> 11 & 63;
                                                                                                               var74[var16] = var35;
                                                                                                               var33 = 1;
                                                                                                            } else if(var7 != 2801) {
                                                                                                               if(var7 == 2802) {
                                                                                                                  if(var14.name == null) {
                                                                                                                     class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = "";
                                                                                                                  } else {
                                                                                                                     class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var14.name;
                                                                                                                  }

                                                                                                                  var33 = 1;
                                                                                                               } else {
                                                                                                                  var33 = 2;
                                                                                                               }
                                                                                                            } else {
                                                                                                               var15 = class81.intStack[--class81.intStackSize];
                                                                                                               --var15;
                                                                                                               if(var14.actions != null && var15 < var14.actions.length && var14.actions[var15] != null) {
                                                                                                                  class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var14.actions[var15];
                                                                                                               } else {
                                                                                                                  class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = "";
                                                                                                               }

                                                                                                               var33 = 1;
                                                                                                            }

                                                                                                            var32 = var33;
                                                                                                         } else if(var7 < 3000) {
                                                                                                            var32 = GroundObject.method2737(var7, var3, var60);
                                                                                                         } else {
                                                                                                            int var20;
                                                                                                            int var21;
                                                                                                            int var22;
                                                                                                            String var55;
                                                                                                            boolean var56;
                                                                                                            int[] var57;
                                                                                                            boolean var58;
                                                                                                            int var68;
                                                                                                            String var75;
                                                                                                            PacketNode var76;
                                                                                                            boolean var83;
                                                                                                            boolean var84;
                                                                                                            if(var7 < 3200) {
                                                                                                               if(var7 == 3100) {
                                                                                                                  var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                  class19.sendGameMessage(0, "", var55);
                                                                                                                  var33 = 1;
                                                                                                               } else if(var7 == 3101) {
                                                                                                                  class81.intStackSize -= 2;
                                                                                                                  class317.method5715(TotalQuantityComparator.localPlayer, class81.intStack[class81.intStackSize], class81.intStack[class81.intStackSize + 1]);
                                                                                                                  var33 = 1;
                                                                                                               } else if(var7 == 3103) {
                                                                                                                  class29.method250();
                                                                                                                  var33 = 1;
                                                                                                               } else {
                                                                                                                  PacketNode var61;
                                                                                                                  boolean var62;
                                                                                                                  if(var7 == 3104) {
                                                                                                                     var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                     var15 = 0;
                                                                                                                     var62 = false;
                                                                                                                     boolean var19 = false;
                                                                                                                     var20 = 0;
                                                                                                                     var21 = var55.length();
                                                                                                                     var22 = 0;

                                                                                                                     while(true) {
                                                                                                                        if(var22 >= var21) {
                                                                                                                           var83 = var19;
                                                                                                                           break;
                                                                                                                        }

                                                                                                                        label3235: {
                                                                                                                           char var23 = var55.charAt(var22);
                                                                                                                           if(var22 == 0) {
                                                                                                                              if(var23 == '-') {
                                                                                                                                 var62 = true;
                                                                                                                                 break label3235;
                                                                                                                              }

                                                                                                                              if(var23 == '+') {
                                                                                                                                 break label3235;
                                                                                                                              }
                                                                                                                           }

                                                                                                                           if(var23 >= '0' && var23 <= '9') {
                                                                                                                              var68 = var23 - '0';
                                                                                                                           } else if(var23 >= 'A' && var23 <= 'Z') {
                                                                                                                              var68 = var23 - '7';
                                                                                                                           } else {
                                                                                                                              if(var23 < 'a' || var23 > 'z') {
                                                                                                                                 var83 = false;
                                                                                                                                 break;
                                                                                                                              }

                                                                                                                              var68 = var23 - 'W';
                                                                                                                           }

                                                                                                                           if(var68 >= 10) {
                                                                                                                              var83 = false;
                                                                                                                              break;
                                                                                                                           }

                                                                                                                           if(var62) {
                                                                                                                              var68 = -var68;
                                                                                                                           }

                                                                                                                           int var24 = var68 + var20 * 10;
                                                                                                                           if(var20 != var24 / 10) {
                                                                                                                              var83 = false;
                                                                                                                              break;
                                                                                                                           }

                                                                                                                           var20 = var24;
                                                                                                                           var19 = true;
                                                                                                                        }

                                                                                                                        ++var22;
                                                                                                                     }

                                                                                                                     if(var83) {
                                                                                                                        var15 = Client.method1623(var55);
                                                                                                                     }

                                                                                                                     var61 = class31.method285(ClientPacket.field2393, Client.field899.field1470);
                                                                                                                     var61.packetBuffer.putInt(var15);
                                                                                                                     Client.field899.method2082(var61);
                                                                                                                     var33 = 1;
                                                                                                                  } else if(var7 == 3105) {
                                                                                                                     var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                     var76 = class31.method285(ClientPacket.field2399, Client.field899.field1470);
                                                                                                                     var76.packetBuffer.putByte(var55.length() + 1);
                                                                                                                     var76.packetBuffer.putString(var55);
                                                                                                                     Client.field899.method2082(var76);
                                                                                                                     var33 = 1;
                                                                                                                  } else if(var7 == 3106) {
                                                                                                                     var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                     var76 = class31.method285(ClientPacket.field2414, Client.field899.field1470);
                                                                                                                     var76.packetBuffer.putByte(var55.length() + 1);
                                                                                                                     var76.packetBuffer.putString(var55);
                                                                                                                     Client.field899.method2082(var76);
                                                                                                                     var33 = 1;
                                                                                                                  } else if(var7 != 3107) {
                                                                                                                     if(var7 == 3108) {
                                                                                                                        class81.intStackSize -= 3;
                                                                                                                        var34 = class81.intStack[class81.intStackSize];
                                                                                                                        var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                                        var16 = class81.intStack[class81.intStackSize + 2];
                                                                                                                        var17 = class5.getWidget(var16);
                                                                                                                        class5.method20(var17, var34, var15);
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3109) {
                                                                                                                        class81.intStackSize -= 2;
                                                                                                                        var34 = class81.intStack[class81.intStackSize];
                                                                                                                        var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                                        Widget var39 = var60?class20.field338:class81.field1267;
                                                                                                                        class5.method20(var39, var34, var15);
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3110) {
                                                                                                                        Enum.middleMouseMovesCamera = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3111) {
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = class55.preferences.hideRoofs?1:0;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3112) {
                                                                                                                        class55.preferences.hideRoofs = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                        MessageNode.method1130();
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3113) {
                                                                                                                        var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                        var56 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                        TotalQuantityComparator.method98(var55, var56, false);
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3115) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        var76 = class31.method285(ClientPacket.field2434, Client.field899.field1470);
                                                                                                                        var76.packetBuffer.putShort(var34);
                                                                                                                        Client.field899.method2082(var76);
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3116) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        UrlRequester.scriptStringStackSize -= 2;
                                                                                                                        var75 = class81.scriptStringStack[UrlRequester.scriptStringStackSize];
                                                                                                                        String var90 = class81.scriptStringStack[UrlRequester.scriptStringStackSize + 1];
                                                                                                                        if(var75.length() > 500) {
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var90.length() > 500) {
                                                                                                                           var33 = 1;
                                                                                                                        } else {
                                                                                                                           var61 = class31.method285(ClientPacket.field2423, Client.field899.field1470);
                                                                                                                           var61.packetBuffer.putShort(1 + class29.getLength(var75) + class29.getLength(var90));
                                                                                                                           var61.packetBuffer.putString(var90);
                                                                                                                           var61.packetBuffer.putByte(var34);
                                                                                                                           var61.packetBuffer.putString(var75);
                                                                                                                           Client.field899.method2082(var61);
                                                                                                                           var33 = 1;
                                                                                                                        }
                                                                                                                     } else if(var7 == 3117) {
                                                                                                                        Client.field996 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3118) {
                                                                                                                        Client.field1049 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3119) {
                                                                                                                        Client.field969 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3120) {
                                                                                                                        if(class81.intStack[--class81.intStackSize] == 1) {
                                                                                                                           Client.field988 |= 1;
                                                                                                                        } else {
                                                                                                                           Client.field988 &= -2;
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3121) {
                                                                                                                        if(class81.intStack[--class81.intStackSize] == 1) {
                                                                                                                           Client.field988 |= 2;
                                                                                                                        } else {
                                                                                                                           Client.field988 &= -3;
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3122) {
                                                                                                                        if(class81.intStack[--class81.intStackSize] == 1) {
                                                                                                                           Client.field988 |= 4;
                                                                                                                        } else {
                                                                                                                           Client.field988 &= -5;
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3123) {
                                                                                                                        if(class81.intStack[--class81.intStackSize] == 1) {
                                                                                                                           Client.field988 |= 8;
                                                                                                                        } else {
                                                                                                                           Client.field988 &= -9;
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3124) {
                                                                                                                        Client.field988 = 0;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3125) {
                                                                                                                        Client.field978 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3126) {
                                                                                                                        Client.field965 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3127) {
                                                                                                                        var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                        Client.field997 = var84;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3128) {
                                                                                                                        var57 = class81.intStack;
                                                                                                                        var15 = ++class81.intStackSize - 1;
                                                                                                                        var58 = Client.field997;
                                                                                                                        var57[var15] = var58?1:0;
                                                                                                                        var33 = 1;
                                                                                                                     } else {
                                                                                                                        var33 = 2;
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     var34 = class81.intStack[--class81.intStackSize];
                                                                                                                     var75 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                     var16 = class93.playerIndexesCount;
                                                                                                                     int[] var59 = class93.playerIndices;
                                                                                                                     var62 = false;
                                                                                                                     Name var36 = new Name(var75, class21.loginType);

                                                                                                                     for(var20 = 0; var20 < var16; ++var20) {
                                                                                                                        Player var37 = Client.cachedPlayers[var59[var20]];
                                                                                                                        if(var37 != null && var37 != TotalQuantityComparator.localPlayer && var37.name != null && var37.name.equals(var36)) {
                                                                                                                           PacketNode var38;
                                                                                                                           if(var34 == 1) {
                                                                                                                              var38 = class31.method285(ClientPacket.field2450, Client.field899.field1470);
                                                                                                                              var38.packetBuffer.method3607(0);
                                                                                                                              var38.packetBuffer.method3754(var59[var20]);
                                                                                                                              Client.field899.method2082(var38);
                                                                                                                           } else if(var34 == 4) {
                                                                                                                              var38 = class31.method285(ClientPacket.field2441, Client.field899.field1470);
                                                                                                                              var38.packetBuffer.putShort(var59[var20]);
                                                                                                                              var38.packetBuffer.putByte(0);
                                                                                                                              Client.field899.method2082(var38);
                                                                                                                           } else if(var34 == 6) {
                                                                                                                              var38 = class31.method285(ClientPacket.field2413, Client.field899.field1470);
                                                                                                                              var38.packetBuffer.putShort(var59[var20]);
                                                                                                                              var38.packetBuffer.method3596(0);
                                                                                                                              Client.field899.method2082(var38);
                                                                                                                           } else if(var34 == 7) {
                                                                                                                              var38 = class31.method285(ClientPacket.field2456, Client.field899.field1470);
                                                                                                                              var38.packetBuffer.method3607(0);
                                                                                                                              var38.packetBuffer.method3754(var59[var20]);
                                                                                                                              Client.field899.method2082(var38);
                                                                                                                           }

                                                                                                                           var62 = true;
                                                                                                                           break;
                                                                                                                        }
                                                                                                                     }

                                                                                                                     if(!var62) {
                                                                                                                        class19.sendGameMessage(4, "", "Unable to find " + var75);
                                                                                                                     }

                                                                                                                     var33 = 1;
                                                                                                                  }
                                                                                                               }

                                                                                                               var32 = var33;
                                                                                                            } else if(var7 < 3300) {
                                                                                                               if(var7 == 3200) {
                                                                                                                  class81.intStackSize -= 3;
                                                                                                                  class64.method1067(class81.intStack[class81.intStackSize], class81.intStack[class81.intStackSize + 1], class81.intStack[class81.intStackSize + 2]);
                                                                                                                  var33 = 1;
                                                                                                               } else if(var7 != 3201) {
                                                                                                                  if(var7 == 3202) {
                                                                                                                     class81.intStackSize -= 2;
                                                                                                                     var34 = class81.intStack[class81.intStackSize];
                                                                                                                     var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                                     if(Client.field981 != 0 && var34 != -1) {
                                                                                                                        MouseRecorder.method1095(class66.indexTrack2, var34, 0, Client.field981, false);
                                                                                                                        Client.field970 = true;
                                                                                                                     }

                                                                                                                     var33 = 1;
                                                                                                                  } else {
                                                                                                                     var33 = 2;
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  var34 = class81.intStack[--class81.intStackSize];
                                                                                                                  if(var34 == -1 && !Client.field970) {
                                                                                                                     class197.method3836();
                                                                                                                  } else if(var34 != -1 && var34 != Client.field1115 && Client.field981 != 0 && !Client.field970) {
                                                                                                                     IndexData var78 = class154.indexTrack1;
                                                                                                                     var16 = Client.field981;
                                                                                                                     class229.field2694 = 1;
                                                                                                                     class229.field2687 = var78;
                                                                                                                     class229.field2691 = var34;
                                                                                                                     AttackOption.field1331 = 0;
                                                                                                                     class229.field2692 = var16;
                                                                                                                     class37.field506 = false;
                                                                                                                     class284.field3699 = 2;
                                                                                                                  }

                                                                                                                  Client.field1115 = var34;
                                                                                                                  var33 = 1;
                                                                                                               }

                                                                                                               var32 = var33;
                                                                                                            } else {
                                                                                                               int[] var91;
                                                                                                               if(var7 < 3400) {
                                                                                                                  if(var7 == 3300) {
                                                                                                                     class81.intStack[++class81.intStackSize - 1] = Client.gameCycle;
                                                                                                                     var33 = 1;
                                                                                                                  } else {
                                                                                                                     ItemContainer var85;
                                                                                                                     if(var7 == 3301) {
                                                                                                                        class81.intStackSize -= 2;
                                                                                                                        var34 = class81.intStack[class81.intStackSize];
                                                                                                                        var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                                        var91 = class81.intStack;
                                                                                                                        var35 = ++class81.intStackSize - 1;
                                                                                                                        var85 = (ItemContainer)ItemContainer.itemContainers.get((long)var34);
                                                                                                                        if(var85 == null) {
                                                                                                                           var18 = -1;
                                                                                                                        } else if(var15 >= 0 && var15 < var85.itemIds.length) {
                                                                                                                           var18 = var85.itemIds[var15];
                                                                                                                        } else {
                                                                                                                           var18 = -1;
                                                                                                                        }

                                                                                                                        var91[var35] = var18;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3302) {
                                                                                                                        class81.intStackSize -= 2;
                                                                                                                        var34 = class81.intStack[class81.intStackSize];
                                                                                                                        var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                                        var91 = class81.intStack;
                                                                                                                        var35 = ++class81.intStackSize - 1;
                                                                                                                        var85 = (ItemContainer)ItemContainer.itemContainers.get((long)var34);
                                                                                                                        if(var85 == null) {
                                                                                                                           var18 = 0;
                                                                                                                        } else if(var15 >= 0 && var15 < var85.stackSizes.length) {
                                                                                                                           var18 = var85.stackSizes[var15];
                                                                                                                        } else {
                                                                                                                           var18 = 0;
                                                                                                                        }

                                                                                                                        var91[var35] = var18;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3303) {
                                                                                                                        class81.intStackSize -= 2;
                                                                                                                        var34 = class81.intStack[class81.intStackSize];
                                                                                                                        var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = Projectile.method1956(var34, var15);
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3304) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        var74 = class81.intStack;
                                                                                                                        var16 = ++class81.intStackSize - 1;
                                                                                                                        InvType var40 = (InvType)InvType.inventoryCache.get((long)var34);
                                                                                                                        InvType var63;
                                                                                                                        if(var40 != null) {
                                                                                                                           var63 = var40;
                                                                                                                        } else {
                                                                                                                           byte[] var86 = InvType.field3443.getConfigData(5, var34);
                                                                                                                           var40 = new InvType();
                                                                                                                           if(var86 != null) {
                                                                                                                              var40.decode(new Buffer(var86));
                                                                                                                           }

                                                                                                                           InvType.inventoryCache.put(var40, (long)var34);
                                                                                                                           var63 = var40;
                                                                                                                        }

                                                                                                                        var74[var16] = var63.size;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3305) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = Client.boostedSkillLevels[var34];
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3306) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = Client.realSkillLevels[var34];
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3307) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = Client.skillExperiences[var34];
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3308) {
                                                                                                                        var34 = class36.plane;
                                                                                                                        var15 = (TotalQuantityComparator.localPlayer.x >> 7) + WorldMapType1.baseX;
                                                                                                                        var16 = (TotalQuantityComparator.localPlayer.y >> 7) + Enum.baseY;
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = (var15 << 14) + var16 + (var34 << 28);
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3309) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = var34 >> 14 & 16383;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3310) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = var34 >> 28;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3311) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = var34 & 16383;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3312) {
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = Client.isMembers?1:0;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3313) {
                                                                                                                        class81.intStackSize -= 2;
                                                                                                                        var34 = class81.intStack[class81.intStackSize] + 32768;
                                                                                                                        var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                                        var91 = class81.intStack;
                                                                                                                        var35 = ++class81.intStackSize - 1;
                                                                                                                        var85 = (ItemContainer)ItemContainer.itemContainers.get((long)var34);
                                                                                                                        if(var85 == null) {
                                                                                                                           var18 = -1;
                                                                                                                        } else if(var15 >= 0 && var15 < var85.itemIds.length) {
                                                                                                                           var18 = var85.itemIds[var15];
                                                                                                                        } else {
                                                                                                                           var18 = -1;
                                                                                                                        }

                                                                                                                        var91[var35] = var18;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 != 3314) {
                                                                                                                        if(var7 == 3315) {
                                                                                                                           class81.intStackSize -= 2;
                                                                                                                           var34 = class81.intStack[class81.intStackSize] + 32768;
                                                                                                                           var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = Projectile.method1956(var34, var15);
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3316) {
                                                                                                                           if(Client.rights >= 2) {
                                                                                                                              class81.intStack[++class81.intStackSize - 1] = Client.rights;
                                                                                                                           } else {
                                                                                                                              class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                           }

                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3317) {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = Client.field1069;
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3318) {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = Client.world;
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3321) {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = Client.energy;
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3322) {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = Client.weight;
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3323) {
                                                                                                                           if(Client.field1019) {
                                                                                                                              class81.intStack[++class81.intStackSize - 1] = 1;
                                                                                                                           } else {
                                                                                                                              class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                           }

                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3324) {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = Client.flags;
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3325) {
                                                                                                                           class81.intStackSize -= 4;
                                                                                                                           var34 = class81.intStack[class81.intStackSize];
                                                                                                                           var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                                           var16 = class81.intStack[class81.intStackSize + 2];
                                                                                                                           var35 = class81.intStack[class81.intStackSize + 3];
                                                                                                                           var34 += var15 << 14;
                                                                                                                           var34 += var16 << 28;
                                                                                                                           var34 += var35;
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = var34;
                                                                                                                           var33 = 1;
                                                                                                                        } else {
                                                                                                                           var33 = 2;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class81.intStackSize -= 2;
                                                                                                                        var34 = class81.intStack[class81.intStackSize] + 32768;
                                                                                                                        var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                                        var91 = class81.intStack;
                                                                                                                        var35 = ++class81.intStackSize - 1;
                                                                                                                        var85 = (ItemContainer)ItemContainer.itemContainers.get((long)var34);
                                                                                                                        if(var85 == null) {
                                                                                                                           var18 = 0;
                                                                                                                        } else if(var15 >= 0 && var15 < var85.stackSizes.length) {
                                                                                                                           var18 = var85.stackSizes[var15];
                                                                                                                        } else {
                                                                                                                           var18 = 0;
                                                                                                                        }

                                                                                                                        var91[var35] = var18;
                                                                                                                        var33 = 1;
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var32 = var33;
                                                                                                               } else {
                                                                                                                  int var65;
                                                                                                                  if(var7 < 3500) {
                                                                                                                     if(var7 == 3400) {
                                                                                                                        class81.intStackSize -= 2;
                                                                                                                        var34 = class81.intStack[class81.intStackSize];
                                                                                                                        var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                                        Enum var94 = PacketNode.method3491(var34);
                                                                                                                        if(var94.valType != 's') {
                                                                                                                           ;
                                                                                                                        }

                                                                                                                        for(var35 = 0; var35 < var94.size; ++var35) {
                                                                                                                           if(var15 == var94.keys[var35]) {
                                                                                                                              class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var94.stringVals[var35];
                                                                                                                              var94 = null;
                                                                                                                              break;
                                                                                                                           }
                                                                                                                        }

                                                                                                                        if(var94 != null) {
                                                                                                                           class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var94.defaultString;
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 != 3408) {
                                                                                                                        if(var7 == 3411) {
                                                                                                                           var34 = class81.intStack[--class81.intStackSize];
                                                                                                                           Enum var79 = PacketNode.method3491(var34);
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = var79.method5067();
                                                                                                                           var33 = 1;
                                                                                                                        } else {
                                                                                                                           var33 = 2;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class81.intStackSize -= 4;
                                                                                                                        var34 = class81.intStack[class81.intStackSize];
                                                                                                                        var15 = class81.intStack[class81.intStackSize + 1];
                                                                                                                        var16 = class81.intStack[class81.intStackSize + 2];
                                                                                                                        var35 = class81.intStack[class81.intStackSize + 3];
                                                                                                                        Enum var92 = PacketNode.method3491(var16);
                                                                                                                        if(var34 == var92.keyType && var15 == var92.valType) {
                                                                                                                           for(var65 = 0; var65 < var92.size; ++var65) {
                                                                                                                              if(var35 == var92.keys[var65]) {
                                                                                                                                 if(var15 == 115) {
                                                                                                                                    class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var92.stringVals[var65];
                                                                                                                                 } else {
                                                                                                                                    class81.intStack[++class81.intStackSize - 1] = var92.intVals[var65];
                                                                                                                                 }

                                                                                                                                 var92 = null;
                                                                                                                                 break;
                                                                                                                              }
                                                                                                                           }

                                                                                                                           if(var92 != null) {
                                                                                                                              if(var15 == 115) {
                                                                                                                                 class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var92.defaultString;
                                                                                                                              } else {
                                                                                                                                 class81.intStack[++class81.intStackSize - 1] = var92.defaultInt;
                                                                                                                              }
                                                                                                                           }

                                                                                                                           var33 = 1;
                                                                                                                        } else {
                                                                                                                           if(var15 == 115) {
                                                                                                                              class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = "null";
                                                                                                                           } else {
                                                                                                                              class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                           }

                                                                                                                           var33 = 1;
                                                                                                                        }
                                                                                                                     }

                                                                                                                     var32 = var33;
                                                                                                                  } else if(var7 < 3700) {
                                                                                                                     if(var7 == 3600) {
                                                                                                                        if(ContextMenuRow.friendManager.field1238 == 0) {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = -2;
                                                                                                                        } else if(ContextMenuRow.friendManager.field1238 == 1) {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = -1;
                                                                                                                        } else {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = ContextMenuRow.friendManager.field1235.getCount();
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3601) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        if(ContextMenuRow.friendManager.method1701() && var34 >= 0 && var34 < ContextMenuRow.friendManager.field1235.getCount()) {
                                                                                                                           Friend var81 = (Friend)ContextMenuRow.friendManager.field1235.get(var34);
                                                                                                                           class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var81.method5368();
                                                                                                                           class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var81.method5369();
                                                                                                                        } else {
                                                                                                                           class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = "";
                                                                                                                           class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3602) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        if(ContextMenuRow.friendManager.method1701() && var34 >= 0 && var34 < ContextMenuRow.friendManager.field1235.getCount()) {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = ((ChatPlayer)ContextMenuRow.friendManager.field1235.get(var34)).world;
                                                                                                                        } else {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3603) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        if(ContextMenuRow.friendManager.method1701() && var34 >= 0 && var34 < ContextMenuRow.friendManager.field1235.getCount()) {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = ((ChatPlayer)ContextMenuRow.friendManager.field1235.get(var34)).rank;
                                                                                                                        } else {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3604) {
                                                                                                                        var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                        var15 = class81.intStack[--class81.intStackSize];
                                                                                                                        MapIcon.method559(var55, var15);
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3605) {
                                                                                                                        var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                        ContextMenuRow.friendManager.method1731(var55);
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3606) {
                                                                                                                        var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                        ContextMenuRow.friendManager.method1712(var55);
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3607) {
                                                                                                                        var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                        ContextMenuRow.friendManager.method1710(var55);
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3608) {
                                                                                                                        var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                        ContextMenuRow.friendManager.method1713(var55);
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3609) {
                                                                                                                        var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                        var55 = class44.method625(var55);
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = ContextMenuRow.friendManager.isFriended(new Name(var55, class21.loginType), false)?1:0;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3611) {
                                                                                                                        if(WidgetNode.clanMemberManager != null) {
                                                                                                                           class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = WidgetNode.clanMemberManager.field3858;
                                                                                                                        } else {
                                                                                                                           class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3612) {
                                                                                                                        if(WidgetNode.clanMemberManager != null) {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = WidgetNode.clanMemberManager.getCount();
                                                                                                                        } else {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3613) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        if(WidgetNode.clanMemberManager != null && var34 < WidgetNode.clanMemberManager.getCount()) {
                                                                                                                           class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = WidgetNode.clanMemberManager.get(var34).method5385().getName();
                                                                                                                        } else {
                                                                                                                           class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3614) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        if(WidgetNode.clanMemberManager != null && var34 < WidgetNode.clanMemberManager.getCount()) {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = ((ChatPlayer)WidgetNode.clanMemberManager.get(var34)).method5502();
                                                                                                                        } else {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3615) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        if(WidgetNode.clanMemberManager != null && var34 < WidgetNode.clanMemberManager.getCount()) {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = ((ChatPlayer)WidgetNode.clanMemberManager.get(var34)).rank;
                                                                                                                        } else {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3616) {
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = WidgetNode.clanMemberManager != null?WidgetNode.clanMemberManager.field3860:0;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3617) {
                                                                                                                        var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                        GrandExchangeEvent.method86(var55);
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3618) {
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = WidgetNode.clanMemberManager != null?WidgetNode.clanMemberManager.field3861:0;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3619) {
                                                                                                                        var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                        class41.method560(var55);
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3620) {
                                                                                                                        PacketNode var64 = class31.method285(ClientPacket.field2375, Client.field899.field1470);
                                                                                                                        var64.packetBuffer.putByte(0);
                                                                                                                        Client.field899.method2082(var64);
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3621) {
                                                                                                                        if(!ContextMenuRow.friendManager.method1701()) {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = -1;
                                                                                                                        } else {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = ContextMenuRow.friendManager.field1233.getCount();
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3622) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        if(ContextMenuRow.friendManager.method1701() && var34 >= 0 && var34 < ContextMenuRow.friendManager.field1233.getCount()) {
                                                                                                                           Ignore var80 = (Ignore)ContextMenuRow.friendManager.field1233.get(var34);
                                                                                                                           class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var80.method5368();
                                                                                                                           class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var80.method5369();
                                                                                                                        } else {
                                                                                                                           class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = "";
                                                                                                                           class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3623) {
                                                                                                                        var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                        var55 = class44.method625(var55);
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = ContextMenuRow.friendManager.method1707(new Name(var55, class21.loginType))?1:0;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3624) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        if(WidgetNode.clanMemberManager != null && var34 < WidgetNode.clanMemberManager.getCount() && WidgetNode.clanMemberManager.get(var34).method5385().equals(TotalQuantityComparator.localPlayer.name)) {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = 1;
                                                                                                                        } else {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3625) {
                                                                                                                        if(WidgetNode.clanMemberManager != null && WidgetNode.clanMemberManager.field3856 != null) {
                                                                                                                           class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = WidgetNode.clanMemberManager.field3856;
                                                                                                                        } else {
                                                                                                                           class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3626) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        if(WidgetNode.clanMemberManager != null && var34 < WidgetNode.clanMemberManager.getCount() && ((ClanMember)WidgetNode.clanMemberManager.get(var34)).method5346()) {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = 1;
                                                                                                                        } else {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 != 3627) {
                                                                                                                        if(var7 == 3628) {
                                                                                                                           ContextMenuRow.friendManager.field1235.method5440();
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3629) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           ContextMenuRow.friendManager.field1235.method5430(new class321(var84));
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3630) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           ContextMenuRow.friendManager.field1235.method5430(new class322(var84));
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3631) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           ContextMenuRow.friendManager.field1235.method5430(new class155(var84));
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3632) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           ContextMenuRow.friendManager.field1235.method5430(new class149(var84));
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3633) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           ContextMenuRow.friendManager.field1235.method5430(new class154(var84));
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3634) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           ContextMenuRow.friendManager.field1235.method5430(new class157(var84));
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3635) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           ContextMenuRow.friendManager.field1235.method5430(new class153(var84));
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3636) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           ContextMenuRow.friendManager.field1235.method5430(new class151(var84));
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3637) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           ContextMenuRow.friendManager.field1235.method5430(new class150(var84));
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3638) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           ContextMenuRow.friendManager.field1235.method5430(new class152(var84));
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3639) {
                                                                                                                           ContextMenuRow.friendManager.field1235.method5421();
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3640) {
                                                                                                                           ContextMenuRow.friendManager.field1233.method5440();
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3641) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           ContextMenuRow.friendManager.field1233.method5430(new class321(var84));
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3642) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           ContextMenuRow.friendManager.field1233.method5430(new class322(var84));
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3643) {
                                                                                                                           ContextMenuRow.friendManager.field1233.method5421();
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3644) {
                                                                                                                           if(WidgetNode.clanMemberManager != null) {
                                                                                                                              WidgetNode.clanMemberManager.method5440();
                                                                                                                           }

                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3645) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           if(WidgetNode.clanMemberManager != null) {
                                                                                                                              WidgetNode.clanMemberManager.method5430(new class321(var84));
                                                                                                                           }

                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3646) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           if(WidgetNode.clanMemberManager != null) {
                                                                                                                              WidgetNode.clanMemberManager.method5430(new class322(var84));
                                                                                                                           }

                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3647) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           if(WidgetNode.clanMemberManager != null) {
                                                                                                                              WidgetNode.clanMemberManager.method5430(new class155(var84));
                                                                                                                           }

                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3648) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           if(WidgetNode.clanMemberManager != null) {
                                                                                                                              WidgetNode.clanMemberManager.method5430(new class149(var84));
                                                                                                                           }

                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3649) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           if(WidgetNode.clanMemberManager != null) {
                                                                                                                              WidgetNode.clanMemberManager.method5430(new class154(var84));
                                                                                                                           }

                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3650) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           if(WidgetNode.clanMemberManager != null) {
                                                                                                                              WidgetNode.clanMemberManager.method5430(new class157(var84));
                                                                                                                           }

                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3651) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           if(WidgetNode.clanMemberManager != null) {
                                                                                                                              WidgetNode.clanMemberManager.method5430(new class153(var84));
                                                                                                                           }

                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3652) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           if(WidgetNode.clanMemberManager != null) {
                                                                                                                              WidgetNode.clanMemberManager.method5430(new class151(var84));
                                                                                                                           }

                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3653) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           if(WidgetNode.clanMemberManager != null) {
                                                                                                                              WidgetNode.clanMemberManager.method5430(new class150(var84));
                                                                                                                           }

                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3654) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           if(WidgetNode.clanMemberManager != null) {
                                                                                                                              WidgetNode.clanMemberManager.method5430(new class152(var84));
                                                                                                                           }

                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3655) {
                                                                                                                           if(WidgetNode.clanMemberManager != null) {
                                                                                                                              WidgetNode.clanMemberManager.method5421();
                                                                                                                           }

                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3656) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           ContextMenuRow.friendManager.field1235.method5430(new class156(var84));
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3657) {
                                                                                                                           var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                           if(WidgetNode.clanMemberManager != null) {
                                                                                                                              WidgetNode.clanMemberManager.method5430(new class156(var84));
                                                                                                                           }

                                                                                                                           var33 = 1;
                                                                                                                        } else {
                                                                                                                           var33 = 2;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        if(WidgetNode.clanMemberManager != null && var34 < WidgetNode.clanMemberManager.getCount() && ((ClanMember)WidgetNode.clanMemberManager.get(var34)).method5349()) {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = 1;
                                                                                                                        } else {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     }

                                                                                                                     var32 = var33;
                                                                                                                  } else if(var7 < 4000) {
                                                                                                                     if(var7 == 3903) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = Client.grandExchangeOffers[var34].type();
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3904) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = Client.grandExchangeOffers[var34].itemId;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3905) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = Client.grandExchangeOffers[var34].price;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3906) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = Client.grandExchangeOffers[var34].totalQuantity;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3907) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = Client.grandExchangeOffers[var34].quantitySold;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3908) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = Client.grandExchangeOffers[var34].spent;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3910) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        var15 = Client.grandExchangeOffers[var34].status();
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = var15 == 0?1:0;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3911) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        var15 = Client.grandExchangeOffers[var34].status();
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = var15 == 2?1:0;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3912) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        var15 = Client.grandExchangeOffers[var34].status();
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = var15 == 5?1:0;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3913) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        var15 = Client.grandExchangeOffers[var34].status();
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = var15 == 1?1:0;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3914) {
                                                                                                                        var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                        if(GameObject.grandExchangeEvents != null) {
                                                                                                                           GameObject.grandExchangeEvents.sort(GrandExchangeEvents.field286, var84);
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3915) {
                                                                                                                        var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                        if(GameObject.grandExchangeEvents != null) {
                                                                                                                           GameObject.grandExchangeEvents.sort(GrandExchangeEvents.field283, var84);
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3916) {
                                                                                                                        class81.intStackSize -= 2;
                                                                                                                        var84 = class81.intStack[class81.intStackSize] == 1;
                                                                                                                        var56 = class81.intStack[class81.intStackSize + 1] == 1;
                                                                                                                        if(GameObject.grandExchangeEvents != null) {
                                                                                                                           Client.field858.field853 = var56;
                                                                                                                           GameObject.grandExchangeEvents.sort(Client.field858, var84);
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3917) {
                                                                                                                        var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                        if(GameObject.grandExchangeEvents != null) {
                                                                                                                           GameObject.grandExchangeEvents.sort(GrandExchangeEvents.field284, var84);
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3918) {
                                                                                                                        var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                        if(GameObject.grandExchangeEvents != null) {
                                                                                                                           GameObject.grandExchangeEvents.sort(GrandExchangeEvents.field285, var84);
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 3919) {
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = GameObject.grandExchangeEvents == null?0:GameObject.grandExchangeEvents.events.size();
                                                                                                                        var33 = 1;
                                                                                                                     } else {
                                                                                                                        GrandExchangeEvent var82;
                                                                                                                        if(var7 == 3920) {
                                                                                                                           var34 = class81.intStack[--class81.intStackSize];
                                                                                                                           var82 = (GrandExchangeEvent)GameObject.grandExchangeEvents.events.get(var34);
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = var82.world;
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3921) {
                                                                                                                           var34 = class81.intStack[--class81.intStackSize];
                                                                                                                           var82 = (GrandExchangeEvent)GameObject.grandExchangeEvents.events.get(var34);
                                                                                                                           class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var82.method85();
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3922) {
                                                                                                                           var34 = class81.intStack[--class81.intStackSize];
                                                                                                                           var82 = (GrandExchangeEvent)GameObject.grandExchangeEvents.events.get(var34);
                                                                                                                           class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var82.method84();
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3923) {
                                                                                                                           var34 = class81.intStack[--class81.intStackSize];
                                                                                                                           var82 = (GrandExchangeEvent)GameObject.grandExchangeEvents.events.get(var34);
                                                                                                                           long var41 = PendingSpawn.currentTimeMs() - class252.field3303 - var82.field289;
                                                                                                                           var18 = (int)(var41 / 3600000L);
                                                                                                                           var65 = (int)((var41 - (long)(var18 * 3600000)) / 60000L);
                                                                                                                           var20 = (int)((var41 - (long)(var18 * 3600000) - (long)(var65 * 60000)) / 1000L);
                                                                                                                           String var87 = var18 + ":" + var65 / 10 + var65 % 10 + ":" + var20 / 10 + var20 % 10;
                                                                                                                           class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var87;
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3924) {
                                                                                                                           var34 = class81.intStack[--class81.intStackSize];
                                                                                                                           var82 = (GrandExchangeEvent)GameObject.grandExchangeEvents.events.get(var34);
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = var82.grandExchangeOffer.totalQuantity;
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3925) {
                                                                                                                           var34 = class81.intStack[--class81.intStackSize];
                                                                                                                           var82 = (GrandExchangeEvent)GameObject.grandExchangeEvents.events.get(var34);
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = var82.grandExchangeOffer.price;
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 3926) {
                                                                                                                           var34 = class81.intStack[--class81.intStackSize];
                                                                                                                           var82 = (GrandExchangeEvent)GameObject.grandExchangeEvents.events.get(var34);
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = var82.grandExchangeOffer.itemId;
                                                                                                                           var33 = 1;
                                                                                                                        } else {
                                                                                                                           var33 = 2;
                                                                                                                        }
                                                                                                                     }

                                                                                                                     var32 = var33;
                                                                                                                  } else if(var7 < 4100) {
                                                                                                                     var32 = class153.method3216(var7, var3, var60);
                                                                                                                  } else if(var7 < 4200) {
                                                                                                                     if(var7 == 4100) {
                                                                                                                        var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                        var15 = class81.intStack[--class81.intStackSize];
                                                                                                                        class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var55 + var15;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 4101) {
                                                                                                                        UrlRequester.scriptStringStackSize -= 2;
                                                                                                                        var55 = class81.scriptStringStack[UrlRequester.scriptStringStackSize];
                                                                                                                        var75 = class81.scriptStringStack[UrlRequester.scriptStringStackSize + 1];
                                                                                                                        class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var55 + var75;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 4102) {
                                                                                                                        var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                        var15 = class81.intStack[--class81.intStackSize];
                                                                                                                        String[] var96 = class81.scriptStringStack;
                                                                                                                        var35 = ++UrlRequester.scriptStringStackSize - 1;
                                                                                                                        String var89;
                                                                                                                        if(var15 < 0) {
                                                                                                                           var89 = Integer.toString(var15);
                                                                                                                        } else {
                                                                                                                           var21 = var15;
                                                                                                                           String var43;
                                                                                                                           if(var15 < 0) {
                                                                                                                              var43 = Integer.toString(var15, 10);
                                                                                                                           } else {
                                                                                                                              var22 = 2;

                                                                                                                              for(var68 = var15 / 10; var68 != 0; ++var22) {
                                                                                                                                 var68 /= 10;
                                                                                                                              }

                                                                                                                              char[] var44 = new char[var22];
                                                                                                                              var44[0] = '+';

                                                                                                                              for(int var25 = var22 - 1; var25 > 0; --var25) {
                                                                                                                                 int var26 = var21;
                                                                                                                                 var21 /= 10;
                                                                                                                                 int var27 = var26 - var21 * 10;
                                                                                                                                 if(var27 >= 10) {
                                                                                                                                    var44[var25] = (char)(var27 + 87);
                                                                                                                                 } else {
                                                                                                                                    var44[var25] = (char)(var27 + 48);
                                                                                                                                 }
                                                                                                                              }

                                                                                                                              var43 = new String(var44);
                                                                                                                           }

                                                                                                                           var89 = var43;
                                                                                                                        }

                                                                                                                        var96[var35] = var55 + var89;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 4103) {
                                                                                                                        var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                        class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var55.toLowerCase();
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 4104) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        long var45 = ((long)var34 + 11745L) * 86400000L;
                                                                                                                        class81.field1268.setTime(new Date(var45));
                                                                                                                        var35 = class81.field1268.get(5);
                                                                                                                        var18 = class81.field1268.get(2);
                                                                                                                        var65 = class81.field1268.get(1);
                                                                                                                        class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var35 + "-" + class81.field1269[var18] + "-" + var65;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 4105) {
                                                                                                                        UrlRequester.scriptStringStackSize -= 2;
                                                                                                                        var55 = class81.scriptStringStack[UrlRequester.scriptStringStackSize];
                                                                                                                        var75 = class81.scriptStringStack[UrlRequester.scriptStringStackSize + 1];
                                                                                                                        if(TotalQuantityComparator.localPlayer.composition != null && TotalQuantityComparator.localPlayer.composition.isFemale) {
                                                                                                                           class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var75;
                                                                                                                        } else {
                                                                                                                           class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var55;
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 4106) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = Integer.toString(var34);
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 4107) {
                                                                                                                        UrlRequester.scriptStringStackSize -= 2;
                                                                                                                        var57 = class81.intStack;
                                                                                                                        var15 = ++class81.intStackSize - 1;
                                                                                                                        var35 = FileOnDisk.method2603(class81.scriptStringStack[UrlRequester.scriptStringStackSize], class81.scriptStringStack[UrlRequester.scriptStringStackSize + 1], Client.languageId);
                                                                                                                        byte var67;
                                                                                                                        if(var35 > 0) {
                                                                                                                           var67 = 1;
                                                                                                                        } else if(var35 < 0) {
                                                                                                                           var67 = -1;
                                                                                                                        } else {
                                                                                                                           var67 = 0;
                                                                                                                        }

                                                                                                                        var57[var15] = var67;
                                                                                                                        var33 = 1;
                                                                                                                     } else {
                                                                                                                        byte[] var66;
                                                                                                                        Font var95;
                                                                                                                        if(var7 == 4108) {
                                                                                                                           var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                           class81.intStackSize -= 2;
                                                                                                                           var15 = class81.intStack[class81.intStackSize];
                                                                                                                           var16 = class81.intStack[class81.intStackSize + 1];
                                                                                                                           var66 = class20.indexCache13.getConfigData(var16, 0);
                                                                                                                           var95 = new Font(var66);
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = var95.method5613(var55, var15);
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 4109) {
                                                                                                                           var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                           class81.intStackSize -= 2;
                                                                                                                           var15 = class81.intStack[class81.intStackSize];
                                                                                                                           var16 = class81.intStack[class81.intStackSize + 1];
                                                                                                                           var66 = class20.indexCache13.getConfigData(var16, 0);
                                                                                                                           var95 = new Font(var66);
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = var95.method5660(var55, var15);
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 4110) {
                                                                                                                           UrlRequester.scriptStringStackSize -= 2;
                                                                                                                           var55 = class81.scriptStringStack[UrlRequester.scriptStringStackSize];
                                                                                                                           var75 = class81.scriptStringStack[UrlRequester.scriptStringStackSize + 1];
                                                                                                                           if(class81.intStack[--class81.intStackSize] == 1) {
                                                                                                                              class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var55;
                                                                                                                           } else {
                                                                                                                              class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var75;
                                                                                                                           }

                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 4111) {
                                                                                                                           var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                           class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = FontTypeFace.appendTags(var55);
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 4112) {
                                                                                                                           var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                           var15 = class81.intStack[--class81.intStackSize];
                                                                                                                           class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var55 + (char)var15;
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 4113) {
                                                                                                                           var34 = class81.intStack[--class81.intStackSize];
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = OwnWorldComparator.method1184((char)var34)?1:0;
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 4114) {
                                                                                                                           var34 = class81.intStack[--class81.intStackSize];
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = class196.method3834((char)var34)?1:0;
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 4115) {
                                                                                                                           var34 = class81.intStack[--class81.intStackSize];
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = class204.method3931((char)var34)?1:0;
                                                                                                                           var33 = 1;
                                                                                                                        } else {
                                                                                                                           char var69;
                                                                                                                           if(var7 == 4116) {
                                                                                                                              var34 = class81.intStack[--class81.intStackSize];
                                                                                                                              var74 = class81.intStack;
                                                                                                                              var16 = ++class81.intStackSize - 1;
                                                                                                                              var69 = (char)var34;
                                                                                                                              var83 = var69 >= '0' && var69 <= '9';
                                                                                                                              var74[var16] = var83?1:0;
                                                                                                                              var33 = 1;
                                                                                                                           } else if(var7 == 4117) {
                                                                                                                              var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                              if(var55 != null) {
                                                                                                                                 class81.intStack[++class81.intStackSize - 1] = var55.length();
                                                                                                                              } else {
                                                                                                                                 class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                              }

                                                                                                                              var33 = 1;
                                                                                                                           } else if(var7 == 4118) {
                                                                                                                              var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                              class81.intStackSize -= 2;
                                                                                                                              var15 = class81.intStack[class81.intStackSize];
                                                                                                                              var16 = class81.intStack[class81.intStackSize + 1];
                                                                                                                              class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var55.substring(var15, var16);
                                                                                                                              var33 = 1;
                                                                                                                           } else if(var7 != 4119) {
                                                                                                                              if(var7 == 4120) {
                                                                                                                                 var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                                 var15 = class81.intStack[--class81.intStackSize];
                                                                                                                                 class81.intStack[++class81.intStackSize - 1] = var55.indexOf(var15);
                                                                                                                                 var33 = 1;
                                                                                                                              } else if(var7 == 4121) {
                                                                                                                                 UrlRequester.scriptStringStackSize -= 2;
                                                                                                                                 var55 = class81.scriptStringStack[UrlRequester.scriptStringStackSize];
                                                                                                                                 var75 = class81.scriptStringStack[UrlRequester.scriptStringStackSize + 1];
                                                                                                                                 var16 = class81.intStack[--class81.intStackSize];
                                                                                                                                 class81.intStack[++class81.intStackSize - 1] = var55.indexOf(var75, var16);
                                                                                                                                 var33 = 1;
                                                                                                                              } else {
                                                                                                                                 var33 = 2;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var55 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
                                                                                                                              StringBuilder var88 = new StringBuilder(var55.length());
                                                                                                                              var58 = false;

                                                                                                                              for(var35 = 0; var35 < var55.length(); ++var35) {
                                                                                                                                 var69 = var55.charAt(var35);
                                                                                                                                 if(var69 == '<') {
                                                                                                                                    var58 = true;
                                                                                                                                 } else if(var69 == '>') {
                                                                                                                                    var58 = false;
                                                                                                                                 } else if(!var58) {
                                                                                                                                    var88.append(var69);
                                                                                                                                 }
                                                                                                                              }

                                                                                                                              class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var88.toString();
                                                                                                                              var33 = 1;
                                                                                                                           }
                                                                                                                        }
                                                                                                                     }

                                                                                                                     var32 = var33;
                                                                                                                  } else if(var7 < 4300) {
                                                                                                                     var32 = BoundingBox3D.method57(var7, var3, var60);
                                                                                                                  } else if(var7 < 5100) {
                                                                                                                     var32 = class241.method4553(var7, var3, var60);
                                                                                                                  } else if(var7 < 5400) {
                                                                                                                     if(var7 == 5306) {
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = class29.method249();
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 5307) {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        if(var34 == 1 || var34 == 2) {
                                                                                                                           Client.field1061 = 0L;
                                                                                                                           if(var34 >= 2) {
                                                                                                                              Client.isResized = true;
                                                                                                                           } else {
                                                                                                                              Client.isResized = false;
                                                                                                                           }

                                                                                                                           if(class29.method249() == 1) {
                                                                                                                              class23.clientInstance.method891(765, 503);
                                                                                                                           } else {
                                                                                                                              class23.clientInstance.method891(7680, 2160);
                                                                                                                           }

                                                                                                                           if(Client.gameState >= 25) {
                                                                                                                              var76 = class31.method285(ClientPacket.field2415, Client.field899.field1470);
                                                                                                                              var76.packetBuffer.putByte(class29.method249());
                                                                                                                              var76.packetBuffer.putShort(GameEngine.canvasWidth);
                                                                                                                              var76.packetBuffer.putShort(class195.canvasHeight);
                                                                                                                              Client.field899.method2082(var76);
                                                                                                                           }
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 == 5308) {
                                                                                                                        class81.intStack[++class81.intStackSize - 1] = class55.preferences.screenType;
                                                                                                                        var33 = 1;
                                                                                                                     } else if(var7 != 5309) {
                                                                                                                        var33 = 2;
                                                                                                                     } else {
                                                                                                                        var34 = class81.intStack[--class81.intStackSize];
                                                                                                                        if(var34 == 1 || var34 == 2) {
                                                                                                                           class55.preferences.screenType = var34;
                                                                                                                           MessageNode.method1130();
                                                                                                                        }

                                                                                                                        var33 = 1;
                                                                                                                     }

                                                                                                                     var32 = var33;
                                                                                                                  } else if(var7 < 5600) {
                                                                                                                     var32 = class154.method3229(var7, var3, var60);
                                                                                                                  } else if(var7 < 5700) {
                                                                                                                     var32 = BoundingBox3DDrawMode.method64(var7, var3, var60);
                                                                                                                  } else if(var7 < 6300) {
                                                                                                                     var32 = class28.method236(var7, var3, var60);
                                                                                                                  } else if(var7 < 6600) {
                                                                                                                     var32 = WorldMapType1.method282(var7, var3, var60);
                                                                                                                  } else if(var7 < 6700) {
                                                                                                                     if(var7 == 6600) {
                                                                                                                        var34 = class36.plane;
                                                                                                                        var15 = (TotalQuantityComparator.localPlayer.x >> 7) + WorldMapType1.baseX;
                                                                                                                        var16 = (TotalQuantityComparator.localPlayer.y >> 7) + Enum.baseY;
                                                                                                                        Occluder.method3163().method6170(var34, var15, var16, true);
                                                                                                                        var33 = 1;
                                                                                                                     } else {
                                                                                                                        WorldMapData var97;
                                                                                                                        if(var7 == 6601) {
                                                                                                                           var34 = class81.intStack[--class81.intStackSize];
                                                                                                                           var75 = "";
                                                                                                                           var97 = Occluder.method3163().method6175(var34);
                                                                                                                           if(var97 != null) {
                                                                                                                              var75 = var97.method288();
                                                                                                                           }

                                                                                                                           class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var75;
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 6602) {
                                                                                                                           var34 = class81.intStack[--class81.intStackSize];
                                                                                                                           Occluder.method3163().method6079(var34);
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 6603) {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = Occluder.method3163().method6092();
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 6604) {
                                                                                                                           var34 = class81.intStack[--class81.intStackSize];
                                                                                                                           Occluder.method3163().method6089(var34);
                                                                                                                           var33 = 1;
                                                                                                                        } else if(var7 == 6605) {
                                                                                                                           class81.intStack[++class81.intStackSize - 1] = Occluder.method3163().method6114()?1:0;
                                                                                                                           var33 = 1;
                                                                                                                        } else {
                                                                                                                           Coordinates var70;
                                                                                                                           if(var7 == 6606) {
                                                                                                                              var70 = new Coordinates(class81.intStack[--class81.intStackSize]);
                                                                                                                              Occluder.method3163().method6096(var70.worldX, var70.worldY);
                                                                                                                              var33 = 1;
                                                                                                                           } else if(var7 == 6607) {
                                                                                                                              var70 = new Coordinates(class81.intStack[--class81.intStackSize]);
                                                                                                                              Occluder.method3163().method6073(var70.worldX, var70.worldY);
                                                                                                                              var33 = 1;
                                                                                                                           } else if(var7 == 6608) {
                                                                                                                              var70 = new Coordinates(class81.intStack[--class81.intStackSize]);
                                                                                                                              Occluder.method3163().method6161(var70.plane, var70.worldX, var70.worldY);
                                                                                                                              var33 = 1;
                                                                                                                           } else if(var7 == 6609) {
                                                                                                                              var70 = new Coordinates(class81.intStack[--class81.intStackSize]);
                                                                                                                              Occluder.method3163().method6099(var70.plane, var70.worldX, var70.worldY);
                                                                                                                              var33 = 1;
                                                                                                                           } else if(var7 == 6610) {
                                                                                                                              class81.intStack[++class81.intStackSize - 1] = Occluder.method3163().method6190();
                                                                                                                              class81.intStack[++class81.intStackSize - 1] = Occluder.method3163().method6101();
                                                                                                                              var33 = 1;
                                                                                                                           } else {
                                                                                                                              WorldMapData var93;
                                                                                                                              if(var7 == 6611) {
                                                                                                                                 var34 = class81.intStack[--class81.intStackSize];
                                                                                                                                 var93 = Occluder.method3163().method6175(var34);
                                                                                                                                 if(var93 == null) {
                                                                                                                                    class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                                 } else {
                                                                                                                                    class81.intStack[++class81.intStackSize - 1] = var93.method307().bitpack();
                                                                                                                                 }

                                                                                                                                 var33 = 1;
                                                                                                                              } else if(var7 == 6612) {
                                                                                                                                 var34 = class81.intStack[--class81.intStackSize];
                                                                                                                                 var93 = Occluder.method3163().method6175(var34);
                                                                                                                                 if(var93 == null) {
                                                                                                                                    class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                                    class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                                 } else {
                                                                                                                                    class81.intStack[++class81.intStackSize - 1] = (var93.method300() - var93.method312() + 1) * 64;
                                                                                                                                    class81.intStack[++class81.intStackSize - 1] = (var93.method348() - var93.method302() + 1) * 64;
                                                                                                                                 }

                                                                                                                                 var33 = 1;
                                                                                                                              } else if(var7 == 6613) {
                                                                                                                                 var34 = class81.intStack[--class81.intStackSize];
                                                                                                                                 var93 = Occluder.method3163().method6175(var34);
                                                                                                                                 if(var93 == null) {
                                                                                                                                    class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                                    class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                                    class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                                    class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                                 } else {
                                                                                                                                    class81.intStack[++class81.intStackSize - 1] = var93.method312() * 64;
                                                                                                                                    class81.intStack[++class81.intStackSize - 1] = var93.method302() * 64;
                                                                                                                                    class81.intStack[++class81.intStackSize - 1] = var93.method300() * 64 + 64 - 1;
                                                                                                                                    class81.intStack[++class81.intStackSize - 1] = var93.method348() * 64 + 64 - 1;
                                                                                                                                 }

                                                                                                                                 var33 = 1;
                                                                                                                              } else if(var7 == 6614) {
                                                                                                                                 var34 = class81.intStack[--class81.intStackSize];
                                                                                                                                 var93 = Occluder.method3163().method6175(var34);
                                                                                                                                 if(var93 == null) {
                                                                                                                                    class81.intStack[++class81.intStackSize - 1] = -1;
                                                                                                                                 } else {
                                                                                                                                    class81.intStack[++class81.intStackSize - 1] = var93.method329();
                                                                                                                                 }

                                                                                                                                 var33 = 1;
                                                                                                                              } else if(var7 == 6615) {
                                                                                                                                 var70 = Occluder.method3163().method6102();
                                                                                                                                 if(var70 == null) {
                                                                                                                                    class81.intStack[++class81.intStackSize - 1] = -1;
                                                                                                                                    class81.intStack[++class81.intStackSize - 1] = -1;
                                                                                                                                 } else {
                                                                                                                                    class81.intStack[++class81.intStackSize - 1] = var70.worldX;
                                                                                                                                    class81.intStack[++class81.intStackSize - 1] = var70.worldY;
                                                                                                                                 }

                                                                                                                                 var33 = 1;
                                                                                                                              } else if(var7 == 6616) {
                                                                                                                                 class81.intStack[++class81.intStackSize - 1] = Occluder.method3163().method6080();
                                                                                                                                 var33 = 1;
                                                                                                                              } else if(var7 == 6617) {
                                                                                                                                 var70 = new Coordinates(class81.intStack[--class81.intStackSize]);
                                                                                                                                 var93 = Occluder.method3163().method6081();
                                                                                                                                 if(var93 == null) {
                                                                                                                                    class81.intStack[++class81.intStackSize - 1] = -1;
                                                                                                                                    class81.intStack[++class81.intStackSize - 1] = -1;
                                                                                                                                    var33 = 1;
                                                                                                                                 } else {
                                                                                                                                    var91 = var93.method291(var70.plane, var70.worldX, var70.worldY);
                                                                                                                                    if(var91 == null) {
                                                                                                                                       class81.intStack[++class81.intStackSize - 1] = -1;
                                                                                                                                       class81.intStack[++class81.intStackSize - 1] = -1;
                                                                                                                                    } else {
                                                                                                                                       class81.intStack[++class81.intStackSize - 1] = var91[0];
                                                                                                                                       class81.intStack[++class81.intStackSize - 1] = var91[1];
                                                                                                                                    }

                                                                                                                                    var33 = 1;
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 Coordinates var99;
                                                                                                                                 if(var7 == 6618) {
                                                                                                                                    var70 = new Coordinates(class81.intStack[--class81.intStackSize]);
                                                                                                                                    var93 = Occluder.method3163().method6081();
                                                                                                                                    if(var93 == null) {
                                                                                                                                       class81.intStack[++class81.intStackSize - 1] = -1;
                                                                                                                                       class81.intStack[++class81.intStackSize - 1] = -1;
                                                                                                                                       var33 = 1;
                                                                                                                                    } else {
                                                                                                                                       var99 = var93.method292(var70.worldX, var70.worldY);
                                                                                                                                       if(var99 == null) {
                                                                                                                                          class81.intStack[++class81.intStackSize - 1] = -1;
                                                                                                                                       } else {
                                                                                                                                          class81.intStack[++class81.intStackSize - 1] = var99.bitpack();
                                                                                                                                       }

                                                                                                                                       var33 = 1;
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    Coordinates var98;
                                                                                                                                    Coordinates var100;
                                                                                                                                    if(var7 == 6619) {
                                                                                                                                       class81.intStackSize -= 2;
                                                                                                                                       var34 = class81.intStack[class81.intStackSize];
                                                                                                                                       var98 = new Coordinates(class81.intStack[class81.intStackSize + 1]);
                                                                                                                                       var97 = Occluder.method3163().method6175(var34);
                                                                                                                                       var35 = TotalQuantityComparator.localPlayer.field844;
                                                                                                                                       var18 = (TotalQuantityComparator.localPlayer.x >> 7) + WorldMapType1.baseX;
                                                                                                                                       var65 = (TotalQuantityComparator.localPlayer.y >> 7) + Enum.baseY;
                                                                                                                                       var100 = new Coordinates(var35, var18, var65);
                                                                                                                                       Occluder.method3163().method6084(var97, var100, var98, false);
                                                                                                                                       var33 = 1;
                                                                                                                                    } else if(var7 == 6620) {
                                                                                                                                       class81.intStackSize -= 2;
                                                                                                                                       var34 = class81.intStack[class81.intStackSize];
                                                                                                                                       var98 = new Coordinates(class81.intStack[class81.intStackSize + 1]);
                                                                                                                                       var97 = Occluder.method3163().method6175(var34);
                                                                                                                                       var35 = TotalQuantityComparator.localPlayer.field844;
                                                                                                                                       var18 = (TotalQuantityComparator.localPlayer.x >> 7) + WorldMapType1.baseX;
                                                                                                                                       var65 = (TotalQuantityComparator.localPlayer.y >> 7) + Enum.baseY;
                                                                                                                                       var100 = new Coordinates(var35, var18, var65);
                                                                                                                                       Occluder.method3163().method6084(var97, var100, var98, true);
                                                                                                                                       var33 = 1;
                                                                                                                                    } else if(var7 == 6621) {
                                                                                                                                       class81.intStackSize -= 2;
                                                                                                                                       var34 = class81.intStack[class81.intStackSize];
                                                                                                                                       var98 = new Coordinates(class81.intStack[class81.intStackSize + 1]);
                                                                                                                                       var97 = Occluder.method3163().method6175(var34);
                                                                                                                                       if(var97 == null) {
                                                                                                                                          class81.intStack[++class81.intStackSize - 1] = 0;
                                                                                                                                          var33 = 1;
                                                                                                                                       } else {
                                                                                                                                          class81.intStack[++class81.intStackSize - 1] = var97.method290(var98.plane, var98.worldX, var98.worldY)?1:0;
                                                                                                                                          var33 = 1;
                                                                                                                                       }
                                                                                                                                    } else if(var7 == 6622) {
                                                                                                                                       class81.intStack[++class81.intStackSize - 1] = Occluder.method3163().method6103();
                                                                                                                                       class81.intStack[++class81.intStackSize - 1] = Occluder.method3163().method6104();
                                                                                                                                       var33 = 1;
                                                                                                                                    } else if(var7 == 6623) {
                                                                                                                                       var70 = new Coordinates(class81.intStack[--class81.intStackSize]);
                                                                                                                                       var93 = Occluder.method3163().method6077(var70.plane, var70.worldX, var70.worldY);
                                                                                                                                       if(var93 == null) {
                                                                                                                                          class81.intStack[++class81.intStackSize - 1] = -1;
                                                                                                                                       } else {
                                                                                                                                          class81.intStack[++class81.intStackSize - 1] = var93.method294();
                                                                                                                                       }

                                                                                                                                       var33 = 1;
                                                                                                                                    } else if(var7 == 6624) {
                                                                                                                                       Occluder.method3163().method6105(class81.intStack[--class81.intStackSize]);
                                                                                                                                       var33 = 1;
                                                                                                                                    } else if(var7 == 6625) {
                                                                                                                                       Occluder.method3163().method6197();
                                                                                                                                       var33 = 1;
                                                                                                                                    } else if(var7 == 6626) {
                                                                                                                                       Occluder.method3163().method6149(class81.intStack[--class81.intStackSize]);
                                                                                                                                       var33 = 1;
                                                                                                                                    } else if(var7 == 6627) {
                                                                                                                                       Occluder.method3163().method6231();
                                                                                                                                       var33 = 1;
                                                                                                                                    } else if(var7 == 6628) {
                                                                                                                                       var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                                       Occluder.method3163().method6127(var84);
                                                                                                                                       var33 = 1;
                                                                                                                                    } else if(var7 == 6629) {
                                                                                                                                       var34 = class81.intStack[--class81.intStackSize];
                                                                                                                                       Occluder.method3163().method6224(var34);
                                                                                                                                       var33 = 1;
                                                                                                                                    } else if(var7 == 6630) {
                                                                                                                                       var34 = class81.intStack[--class81.intStackSize];
                                                                                                                                       Occluder.method3163().method6074(var34);
                                                                                                                                       var33 = 1;
                                                                                                                                    } else if(var7 == 6631) {
                                                                                                                                       Occluder.method3163().method6112();
                                                                                                                                       var33 = 1;
                                                                                                                                    } else if(var7 == 6632) {
                                                                                                                                       var84 = class81.intStack[--class81.intStackSize] == 1;
                                                                                                                                       Occluder.method3163().method6113(var84);
                                                                                                                                       var33 = 1;
                                                                                                                                    } else if(var7 == 6633) {
                                                                                                                                       class81.intStackSize -= 2;
                                                                                                                                       var34 = class81.intStack[class81.intStackSize];
                                                                                                                                       var56 = class81.intStack[class81.intStackSize + 1] == 1;
                                                                                                                                       Occluder.method3163().method6107(var34, var56);
                                                                                                                                       var33 = 1;
                                                                                                                                    } else if(var7 == 6634) {
                                                                                                                                       class81.intStackSize -= 2;
                                                                                                                                       var34 = class81.intStack[class81.intStackSize];
                                                                                                                                       var56 = class81.intStack[class81.intStackSize + 1] == 1;
                                                                                                                                       Occluder.method3163().method6115(var34, var56);
                                                                                                                                       var33 = 1;
                                                                                                                                    } else if(var7 == 6635) {
                                                                                                                                       class81.intStack[++class81.intStackSize - 1] = Occluder.method3163().method6166()?1:0;
                                                                                                                                       var33 = 1;
                                                                                                                                    } else if(var7 == 6636) {
                                                                                                                                       var34 = class81.intStack[--class81.intStackSize];
                                                                                                                                       class81.intStack[++class81.intStackSize - 1] = Occluder.method3163().method6083(var34)?1:0;
                                                                                                                                       var33 = 1;
                                                                                                                                    } else if(var7 == 6637) {
                                                                                                                                       var34 = class81.intStack[--class81.intStackSize];
                                                                                                                                       class81.intStack[++class81.intStackSize - 1] = Occluder.method3163().method6118(var34)?1:0;
                                                                                                                                       var33 = 1;
                                                                                                                                    } else if(var7 == 6638) {
                                                                                                                                       class81.intStackSize -= 2;
                                                                                                                                       var34 = class81.intStack[class81.intStackSize];
                                                                                                                                       var98 = new Coordinates(class81.intStack[class81.intStackSize + 1]);
                                                                                                                                       var99 = Occluder.method3163().method6121(var34, var98);
                                                                                                                                       if(var99 == null) {
                                                                                                                                          class81.intStack[++class81.intStackSize - 1] = -1;
                                                                                                                                       } else {
                                                                                                                                          class81.intStack[++class81.intStackSize - 1] = var99.bitpack();
                                                                                                                                       }

                                                                                                                                       var33 = 1;
                                                                                                                                    } else {
                                                                                                                                       MapIcon var71;
                                                                                                                                       if(var7 == 6639) {
                                                                                                                                          var71 = Occluder.method3163().method6109();
                                                                                                                                          if(var71 == null) {
                                                                                                                                             class81.intStack[++class81.intStackSize - 1] = -1;
                                                                                                                                             class81.intStack[++class81.intStackSize - 1] = -1;
                                                                                                                                          } else {
                                                                                                                                             class81.intStack[++class81.intStackSize - 1] = var71.areaId;
                                                                                                                                             class81.intStack[++class81.intStackSize - 1] = var71.field531.bitpack();
                                                                                                                                          }

                                                                                                                                          var33 = 1;
                                                                                                                                       } else if(var7 == 6640) {
                                                                                                                                          var71 = Occluder.method3163().method6124();
                                                                                                                                          if(var71 == null) {
                                                                                                                                             class81.intStack[++class81.intStackSize - 1] = -1;
                                                                                                                                             class81.intStack[++class81.intStackSize - 1] = -1;
                                                                                                                                          } else {
                                                                                                                                             class81.intStack[++class81.intStackSize - 1] = var71.areaId;
                                                                                                                                             class81.intStack[++class81.intStackSize - 1] = var71.field531.bitpack();
                                                                                                                                          }

                                                                                                                                          var33 = 1;
                                                                                                                                       } else {
                                                                                                                                          Area var101;
                                                                                                                                          if(var7 == 6693) {
                                                                                                                                             var34 = class81.intStack[--class81.intStackSize];
                                                                                                                                             var101 = Area.mapAreaType[var34];
                                                                                                                                             if(var101.name == null) {
                                                                                                                                                class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = "";
                                                                                                                                             } else {
                                                                                                                                                class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var101.name;
                                                                                                                                             }

                                                                                                                                             var33 = 1;
                                                                                                                                          } else if(var7 == 6694) {
                                                                                                                                             var34 = class81.intStack[--class81.intStackSize];
                                                                                                                                             var101 = Area.mapAreaType[var34];
                                                                                                                                             class81.intStack[++class81.intStackSize - 1] = var101.field3456;
                                                                                                                                             var33 = 1;
                                                                                                                                          } else if(var7 == 6695) {
                                                                                                                                             var34 = class81.intStack[--class81.intStackSize];
                                                                                                                                             var101 = Area.mapAreaType[var34];
                                                                                                                                             if(var101 == null) {
                                                                                                                                                class81.intStack[++class81.intStackSize - 1] = -1;
                                                                                                                                             } else {
                                                                                                                                                class81.intStack[++class81.intStackSize - 1] = var101.field3451;
                                                                                                                                             }

                                                                                                                                             var33 = 1;
                                                                                                                                          } else if(var7 == 6696) {
                                                                                                                                             var34 = class81.intStack[--class81.intStackSize];
                                                                                                                                             var101 = Area.mapAreaType[var34];
                                                                                                                                             if(var101 == null) {
                                                                                                                                                class81.intStack[++class81.intStackSize - 1] = -1;
                                                                                                                                             } else {
                                                                                                                                                class81.intStack[++class81.intStackSize - 1] = var101.spriteId;
                                                                                                                                             }

                                                                                                                                             var33 = 1;
                                                                                                                                          } else if(var7 == 6697) {
                                                                                                                                             class81.intStack[++class81.intStackSize - 1] = SoundTaskDataProvider.scriptMapIconReference.areaId;
                                                                                                                                             var33 = 1;
                                                                                                                                          } else if(var7 == 6698) {
                                                                                                                                             class81.intStack[++class81.intStackSize - 1] = SoundTaskDataProvider.scriptMapIconReference.field602.bitpack();
                                                                                                                                             var33 = 1;
                                                                                                                                          } else if(var7 == 6699) {
                                                                                                                                             class81.intStack[++class81.intStackSize - 1] = SoundTaskDataProvider.scriptMapIconReference.field596.bitpack();
                                                                                                                                             var33 = 1;
                                                                                                                                          } else {
                                                                                                                                             var33 = 2;
                                                                                                                                          }
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              }
                                                                                                                           }
                                                                                                                        }
                                                                                                                     }

                                                                                                                     var32 = var33;
                                                                                                                  } else {
                                                                                                                     var32 = 2;
                                                                                                                  }
                                                                                                               }
                                                                                                            }
                                                                                                         }
                                                                                                      }
                                                                                                   }
                                                                                                }
                                                                                             }

                                                                                             switch(var32) {
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
         } catch (Exception var49) {
            StringBuilder var48 = new StringBuilder(30);
            var48.append("").append(var3.hash).append(" ");

            for(var29 = class81.scriptStackCount - 1; var29 >= 0; --var29) {
               var48.append("").append(class81.scriptStack[var29].invokedFromScript.hash).append(" ");
            }

            var48.append("").append(var52);
            ItemLayer.method2658(var48.toString(), var49);
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1595688399"
   )
   static byte[] method54(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }
}
