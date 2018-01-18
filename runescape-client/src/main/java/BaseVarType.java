import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
@Implements("BaseVarType")
public enum BaseVarType implements Enumerated {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   @Export("INTEGER")
   INTEGER(0, 0, Integer.class, new class2()),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   @Export("LONG")
   LONG(1, 1, Long.class, new class3()),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   @Export("STRING")
   STRING(2, 2, String.class, new class5());

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "[Lkg;"
   )
   @Export("mapMarkers")
   static SpritePixels[] mapMarkers;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 460744097
   )
   @Export("id2")
   final int id2;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -423127387
   )
   @Export("id")
   final int id;

   @ObfuscatedSignature(
      signature = "(IILjava/lang/Class;Ln;)V"
   )
   BaseVarType(int var3, int var4, Class var5, class0 var6) {
      this.id2 = var3;
      this.id = var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2130441585"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lbn;II)V",
      garbageValue = "-602502401"
   )
   static void method7(ScriptEvent var0, int var1) {
      Object[] var2 = var0.objs;
      class230 var5 = var0.field802;
      boolean var4 = var5 == class230.field2904 || var5 == class230.field2900 || var5 == class230.field2901 || var5 == class230.field2909 || var5 == class230.field2903 || var5 == class230.field2899 || var5 == class230.field2905 || var5 == class230.field2906;
      Script var3;
      int var9;
      int var10;
      int var11;
      int var13;
      int var27;
      if(var4) {
         class82.field1270 = (class47)var2[0];
         Area var6 = Area.mapAreaType[class82.field1270.field573];
         class230 var8 = var0.field802;
         var9 = var6.field3384;
         var10 = var6.field3401;
         var11 = class2.method2(var9, var8);
         Script var12 = class91.method1752(var11, var8);
         Script var7;
         if(var12 != null) {
            var7 = var12;
         } else {
            var13 = (var10 + 40000 << 8) + var8.field2902;
            var12 = class91.method1752(var13, var8);
            if(var12 != null) {
               var7 = var12;
            } else {
               var7 = null;
            }
         }

         var3 = var7;
      } else {
         var27 = ((Integer)var2[0]).intValue();
         var3 = UrlRequester.method2965(var27);
      }

      if(var3 != null) {
         class82.intStackSize = 0;
         FileOnDisk.scriptStringStackSize = 0;
         var27 = -1;
         int[] var51 = var3.instructions;
         int[] var52 = var3.intOperands;
         byte var53 = -1;
         class82.scriptStackCount = 0;

         int var28;
         try {
            class82.scriptLocalInts = new int[var3.localIntCount];
            var10 = 0;
            class82.scriptLocalStrings = new String[var3.localStringCount];
            var11 = 0;

            String var29;
            for(var28 = 1; var28 < var2.length; ++var28) {
               if(var2[var28] instanceof Integer) {
                  var13 = ((Integer)var2[var28]).intValue();
                  if(var13 == -2147483647) {
                     var13 = var0.field795;
                  }

                  if(var13 == -2147483646) {
                     var13 = var0.field793;
                  }

                  if(var13 == -2147483645) {
                     var13 = var0.widget != null?var0.widget.id:-1;
                  }

                  if(var13 == -2147483644) {
                     var13 = var0.field798;
                  }

                  if(var13 == -2147483643) {
                     var13 = var0.widget != null?var0.widget.index:-1;
                  }

                  if(var13 == -2147483642) {
                     var13 = var0.field797 != null?var0.field797.id:-1;
                  }

                  if(var13 == -2147483641) {
                     var13 = var0.field797 != null?var0.field797.index:-1;
                  }

                  if(var13 == -2147483640) {
                     var13 = var0.field800;
                  }

                  if(var13 == -2147483639) {
                     var13 = var0.field801;
                  }

                  class82.scriptLocalInts[var10++] = var13;
               } else if(var2[var28] instanceof String) {
                  var29 = (String)var2[var28];
                  if(var29.equals("event_opbase")) {
                     var29 = var0.string;
                  }

                  class82.scriptLocalStrings[var11++] = var29;
               }
            }

            var28 = 0;
            class82.field1271 = var0.field803;

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
                                                                                       label2085:
                                                                                       while(true) {
                                                                                          ++var28;
                                                                                          if(var28 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var27;
                                                                                          var9 = var51[var27];
                                                                                          int var14;
                                                                                          int var18;
                                                                                          int var19;
                                                                                          int var20;
                                                                                          String var21;
                                                                                          int var30;
                                                                                          int var31;
                                                                                          String var60;
                                                                                          String[] var63;
                                                                                          String var79;
                                                                                          if(var9 < 100) {
                                                                                             if(var9 != 0) {
                                                                                                if(var9 != 1) {
                                                                                                   if(var9 != 2) {
                                                                                                      if(var9 != 3) {
                                                                                                         if(var9 != 6) {
                                                                                                            if(var9 != 7) {
                                                                                                               if(var9 != 8) {
                                                                                                                  if(var9 != 9) {
                                                                                                                     if(var9 != 10) {
                                                                                                                        if(var9 != 21) {
                                                                                                                           if(var9 != 25) {
                                                                                                                              if(var9 != 27) {
                                                                                                                                 if(var9 != 31) {
                                                                                                                                    if(var9 != 32) {
                                                                                                                                       if(var9 != 33) {
                                                                                                                                          if(var9 != 34) {
                                                                                                                                             if(var9 != 35) {
                                                                                                                                                if(var9 != 36) {
                                                                                                                                                   if(var9 != 37) {
                                                                                                                                                      if(var9 != 38) {
                                                                                                                                                         if(var9 != 39) {
                                                                                                                                                            if(var9 != 40) {
                                                                                                                                                               if(var9 != 42) {
                                                                                                                                                                  if(var9 != 43) {
                                                                                                                                                                     if(var9 == 44) {
                                                                                                                                                                        var13 = var52[var27] >> 16;
                                                                                                                                                                        var14 = var52[var27] & 65535;
                                                                                                                                                                        int var100 = class82.intStack[--class82.intStackSize];
                                                                                                                                                                        if(var100 >= 0 && var100 <= 5000) {
                                                                                                                                                                           class82.field1260[var13] = var100;
                                                                                                                                                                           byte var99 = -1;
                                                                                                                                                                           if(var14 == 105) {
                                                                                                                                                                              var99 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var30 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var30 >= var100) {
                                                                                                                                                                                 continue label2085;
                                                                                                                                                                              }

                                                                                                                                                                              class82.SHAPE_VERTICES[var13][var30] = var99;
                                                                                                                                                                              ++var30;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var9 == 45) {
                                                                                                                                                                        var13 = var52[var27];
                                                                                                                                                                        var14 = class82.intStack[--class82.intStackSize];
                                                                                                                                                                        if(var14 < 0 || var14 >= class82.field1260[var13]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class82.intStack[++class82.intStackSize - 1] = class82.SHAPE_VERTICES[var13][var14];
                                                                                                                                                                     } else if(var9 == 46) {
                                                                                                                                                                        var13 = var52[var27];
                                                                                                                                                                        class82.intStackSize -= 2;
                                                                                                                                                                        var14 = class82.intStack[class82.intStackSize];
                                                                                                                                                                        if(var14 < 0 || var14 >= class82.field1260[var13]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class82.SHAPE_VERTICES[var13][var14] = class82.intStack[class82.intStackSize + 1];
                                                                                                                                                                     } else if(var9 == 47) {
                                                                                                                                                                        var29 = class159.chatMessages.getVarcString(var52[var27]);
                                                                                                                                                                        if(var29 == null) {
                                                                                                                                                                           var29 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var29;
                                                                                                                                                                     } else if(var9 == 48) {
                                                                                                                                                                        class159.chatMessages.putVarcString(var52[var27], class82.scriptStringStack[--FileOnDisk.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var9 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        IterableHashTable var74 = var3.switches[var52[var27]];
                                                                                                                                                                        IntegerNode var77 = (IntegerNode)var74.get((long)class82.intStack[--class82.intStackSize]);
                                                                                                                                                                        if(var77 != null) {
                                                                                                                                                                           var27 += var77.value;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     class159.chatMessages.putVarc(var52[var27], class82.intStack[--class82.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class82.intStack[++class82.intStackSize - 1] = class159.chatMessages.getVarc(var52[var27]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var13 = var52[var27];
                                                                                                                                                               Script var76 = UrlRequester.method2965(var13);
                                                                                                                                                               int[] var55 = new int[var76.localIntCount];
                                                                                                                                                               var63 = new String[var76.localStringCount];

                                                                                                                                                               for(var30 = 0; var30 < var76.intStackCount; ++var30) {
                                                                                                                                                                  var55[var30] = class82.intStack[var30 + (class82.intStackSize - var76.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var30 = 0; var30 < var76.stringStackCount; ++var30) {
                                                                                                                                                                  var63[var30] = class82.scriptStringStack[var30 + (FileOnDisk.scriptStringStackSize - var76.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class82.intStackSize -= var76.intStackCount;
                                                                                                                                                               FileOnDisk.scriptStringStackSize -= var76.stringStackCount;
                                                                                                                                                               ScriptState var72 = new ScriptState();
                                                                                                                                                               var72.invokedFromScript = var3;
                                                                                                                                                               var72.invokedFromPc = var27;
                                                                                                                                                               var72.savedLocalInts = class82.scriptLocalInts;
                                                                                                                                                               var72.savedLocalStrings = class82.scriptLocalStrings;
                                                                                                                                                               class82.scriptStack[++class82.scriptStackCount - 1] = var72;
                                                                                                                                                               var3 = var76;
                                                                                                                                                               var51 = var76.instructions;
                                                                                                                                                               var52 = var76.intOperands;
                                                                                                                                                               var27 = -1;
                                                                                                                                                               class82.scriptLocalInts = var55;
                                                                                                                                                               class82.scriptLocalStrings = var63;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --FileOnDisk.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class82.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var13 = var52[var27];
                                                                                                                                                      FileOnDisk.scriptStringStackSize -= var13;
                                                                                                                                                      String[] var54 = class82.scriptStringStack;
                                                                                                                                                      var31 = FileOnDisk.scriptStringStackSize;
                                                                                                                                                      String var32;
                                                                                                                                                      if(var13 == 0) {
                                                                                                                                                         var32 = "";
                                                                                                                                                      } else if(var13 == 1) {
                                                                                                                                                         var60 = var54[var31];
                                                                                                                                                         if(var60 == null) {
                                                                                                                                                            var32 = "null";
                                                                                                                                                         } else {
                                                                                                                                                            var32 = var60.toString();
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         var30 = var13 + var31;
                                                                                                                                                         var18 = 0;

                                                                                                                                                         for(var19 = var31; var19 < var30; ++var19) {
                                                                                                                                                            var79 = var54[var19];
                                                                                                                                                            if(var79 == null) {
                                                                                                                                                               var18 += 4;
                                                                                                                                                            } else {
                                                                                                                                                               var18 += var79.length();
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         StringBuilder var87 = new StringBuilder(var18);

                                                                                                                                                         for(var20 = var31; var20 < var30; ++var20) {
                                                                                                                                                            var21 = var54[var20];
                                                                                                                                                            if(var21 == null) {
                                                                                                                                                               var87.append("null");
                                                                                                                                                            } else {
                                                                                                                                                               var87.append(var21);
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         var32 = var87.toString();
                                                                                                                                                      }

                                                                                                                                                      class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var32;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class82.scriptLocalStrings[var52[var27]] = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = class82.scriptLocalStrings[var52[var27]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class82.scriptLocalInts[var52[var27]] = class82.intStack[--class82.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class82.intStack[++class82.intStackSize - 1] = class82.scriptLocalInts[var52[var27]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class82.intStackSize -= 2;
                                                                                                                                       if(class82.intStack[class82.intStackSize] >= class82.intStack[class82.intStackSize + 1]) {
                                                                                                                                          var27 += var52[var27];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class82.intStackSize -= 2;
                                                                                                                                    if(class82.intStack[class82.intStackSize] <= class82.intStack[class82.intStackSize + 1]) {
                                                                                                                                       var27 += var52[var27];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var13 = var52[var27];
                                                                                                                                 var14 = class82.intStack[--class82.intStackSize];
                                                                                                                                 Varbit var98 = (Varbit)Varbit.varbits.get((long)var13);
                                                                                                                                 Varbit var15;
                                                                                                                                 if(var98 != null) {
                                                                                                                                    var15 = var98;
                                                                                                                                 } else {
                                                                                                                                    byte[] var70 = Varbit.varbit_ref.getConfigData(14, var13);
                                                                                                                                    var98 = new Varbit();
                                                                                                                                    if(var70 != null) {
                                                                                                                                       var98.decode(new Buffer(var70));
                                                                                                                                    }

                                                                                                                                    Varbit.varbits.put(var98, (long)var13);
                                                                                                                                    var15 = var98;
                                                                                                                                 }

                                                                                                                                 var30 = var15.configId;
                                                                                                                                 var18 = var15.leastSignificantBit;
                                                                                                                                 var19 = var15.mostSignificantBit;
                                                                                                                                 var20 = class222.varpsMasks[var19 - var18];
                                                                                                                                 if(var14 < 0 || var14 > var20) {
                                                                                                                                    var14 = 0;
                                                                                                                                 }

                                                                                                                                 var20 <<= var18;
                                                                                                                                 class222.widgetSettings[var30] = class222.widgetSettings[var30] & ~var20 | var14 << var18 & var20;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var13 = var52[var27];
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = PendingSpawn.getVarbit(var13);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class82.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var73 = class82.scriptStack[--class82.scriptStackCount];
                                                                                                                           var3 = var73.invokedFromScript;
                                                                                                                           var51 = var3.instructions;
                                                                                                                           var52 = var3.intOperands;
                                                                                                                           var27 = var73.invokedFromPc;
                                                                                                                           class82.scriptLocalInts = var73.savedLocalInts;
                                                                                                                           class82.scriptLocalStrings = var73.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class82.intStackSize -= 2;
                                                                                                                        if(class82.intStack[class82.intStackSize] > class82.intStack[class82.intStackSize + 1]) {
                                                                                                                           var27 += var52[var27];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     if(class82.intStack[class82.intStackSize] < class82.intStack[class82.intStackSize + 1]) {
                                                                                                                        var27 += var52[var27];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class82.intStackSize -= 2;
                                                                                                                  if(class82.intStack[class82.intStackSize] == class82.intStack[class82.intStackSize + 1]) {
                                                                                                                     var27 += var52[var27];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class82.intStackSize -= 2;
                                                                                                               if(class82.intStack[class82.intStackSize] != class82.intStack[class82.intStackSize + 1]) {
                                                                                                                  var27 += var52[var27];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var27 += var52[var27];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var3.stringOperands[var27];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var13 = var52[var27];
                                                                                                      class222.widgetSettings[var13] = class82.intStack[--class82.intStackSize];
                                                                                                      class7.method34(var13);
                                                                                                   }
                                                                                                } else {
                                                                                                   var13 = var52[var27];
                                                                                                   class82.intStack[++class82.intStackSize - 1] = class222.widgetSettings[var13];
                                                                                                }
                                                                                             } else {
                                                                                                class82.intStack[++class82.intStackSize - 1] = var52[var27];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var61;
                                                                                             if(var3.intOperands[var27] == 1) {
                                                                                                var61 = true;
                                                                                             } else {
                                                                                                var61 = false;
                                                                                             }

                                                                                             if(var9 < 1000) {
                                                                                                var14 = class64.method1099(var9, var3, var61);
                                                                                             } else if(var9 < 1100) {
                                                                                                var14 = class47.method692(var9, var3, var61);
                                                                                             } else if(var9 < 1200) {
                                                                                                var14 = class44.method624(var9, var3, var61);
                                                                                             } else if(var9 < 1300) {
                                                                                                var14 = class11.method54(var9, var3, var61);
                                                                                             } else if(var9 < 1400) {
                                                                                                var14 = Preferences.method1634(var9, var3, var61);
                                                                                             } else if(var9 < 1500) {
                                                                                                var14 = class5.method11(var9, var3, var61);
                                                                                             } else if(var9 < 1600) {
                                                                                                var14 = Frames.method2941(var9, var3, var61);
                                                                                             } else {
                                                                                                Widget var16;
                                                                                                byte var35;
                                                                                                if(var9 < 1700) {
                                                                                                   var16 = var61?class82.field1267:CombatInfo1.field1216;
                                                                                                   if(var9 == 1600) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var16.scrollX;
                                                                                                      var35 = 1;
                                                                                                   } else if(var9 == 1601) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var16.scrollY;
                                                                                                      var35 = 1;
                                                                                                   } else if(var9 == 1602) {
                                                                                                      class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var16.text;
                                                                                                      var35 = 1;
                                                                                                   } else if(var9 == 1603) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var16.scrollWidth;
                                                                                                      var35 = 1;
                                                                                                   } else if(var9 == 1604) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var16.scrollHeight;
                                                                                                      var35 = 1;
                                                                                                   } else if(var9 == 1605) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var16.modelZoom;
                                                                                                      var35 = 1;
                                                                                                   } else if(var9 == 1606) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var16.rotationX;
                                                                                                      var35 = 1;
                                                                                                   } else if(var9 == 1607) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var16.rotationY;
                                                                                                      var35 = 1;
                                                                                                   } else if(var9 == 1608) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var16.rotationZ;
                                                                                                      var35 = 1;
                                                                                                   } else if(var9 == 1609) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var16.opacity;
                                                                                                      var35 = 1;
                                                                                                   } else if(var9 == 1610) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var16.field2896;
                                                                                                      var35 = 1;
                                                                                                   } else if(var9 == 1611) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var16.textColor;
                                                                                                      var35 = 1;
                                                                                                   } else if(var9 == 1612) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var16.field2788;
                                                                                                      var35 = 1;
                                                                                                   } else if(var9 == 1613) {
                                                                                                      class82.intStack[++class82.intStackSize - 1] = var16.field2792.rsOrdinal();
                                                                                                      var35 = 1;
                                                                                                   } else {
                                                                                                      var35 = 2;
                                                                                                   }

                                                                                                   var14 = var35;
                                                                                                } else if(var9 < 1800) {
                                                                                                   var14 = class7.method30(var9, var3, var61);
                                                                                                } else {
                                                                                                   int[] var17;
                                                                                                   if(var9 < 1900) {
                                                                                                      var16 = var61?class82.field1267:CombatInfo1.field1216;
                                                                                                      if(var9 == 1800) {
                                                                                                         var17 = class82.intStack;
                                                                                                         var18 = ++class82.intStackSize - 1;
                                                                                                         var20 = GraphicsObject.getWidgetConfig(var16);
                                                                                                         var19 = var20 >> 11 & 63;
                                                                                                         var17[var18] = var19;
                                                                                                         var35 = 1;
                                                                                                      } else if(var9 != 1801) {
                                                                                                         if(var9 == 1802) {
                                                                                                            if(var16.name == null) {
                                                                                                               class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
                                                                                                            } else {
                                                                                                               class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var16.name;
                                                                                                            }

                                                                                                            var35 = 1;
                                                                                                         } else {
                                                                                                            var35 = 2;
                                                                                                         }
                                                                                                      } else {
                                                                                                         var30 = class82.intStack[--class82.intStackSize];
                                                                                                         --var30;
                                                                                                         if(var16.actions != null && var30 < var16.actions.length && var16.actions[var30] != null) {
                                                                                                            class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var16.actions[var30];
                                                                                                         } else {
                                                                                                            class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
                                                                                                         }

                                                                                                         var35 = 1;
                                                                                                      }

                                                                                                      var14 = var35;
                                                                                                   } else if(var9 < 2000) {
                                                                                                      var14 = Client.method1546(var9, var3, var61);
                                                                                                   } else if(var9 < 2100) {
                                                                                                      var14 = class47.method692(var9, var3, var61);
                                                                                                   } else if(var9 < 2200) {
                                                                                                      var14 = class44.method624(var9, var3, var61);
                                                                                                   } else if(var9 < 2300) {
                                                                                                      var14 = class11.method54(var9, var3, var61);
                                                                                                   } else if(var9 < 2400) {
                                                                                                      var14 = Preferences.method1634(var9, var3, var61);
                                                                                                   } else if(var9 < 2500) {
                                                                                                      var14 = class5.method11(var9, var3, var61);
                                                                                                   } else if(var9 < 2600) {
                                                                                                      var16 = UrlRequester.getWidget(class82.intStack[--class82.intStackSize]);
                                                                                                      if(var9 == 2500) {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = var16.relativeX;
                                                                                                         var35 = 1;
                                                                                                      } else if(var9 == 2501) {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = var16.relativeY;
                                                                                                         var35 = 1;
                                                                                                      } else if(var9 == 2502) {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = var16.width;
                                                                                                         var35 = 1;
                                                                                                      } else if(var9 == 2503) {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = var16.height;
                                                                                                         var35 = 1;
                                                                                                      } else if(var9 == 2504) {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = var16.isHidden?1:0;
                                                                                                         var35 = 1;
                                                                                                      } else if(var9 == 2505) {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = var16.parentId;
                                                                                                         var35 = 1;
                                                                                                      } else {
                                                                                                         var35 = 2;
                                                                                                      }

                                                                                                      var14 = var35;
                                                                                                   } else if(var9 < 2700) {
                                                                                                      var16 = UrlRequester.getWidget(class82.intStack[--class82.intStackSize]);
                                                                                                      if(var9 == 2600) {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = var16.scrollX;
                                                                                                         var35 = 1;
                                                                                                      } else if(var9 == 2601) {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = var16.scrollY;
                                                                                                         var35 = 1;
                                                                                                      } else if(var9 == 2602) {
                                                                                                         class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var16.text;
                                                                                                         var35 = 1;
                                                                                                      } else if(var9 == 2603) {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = var16.scrollWidth;
                                                                                                         var35 = 1;
                                                                                                      } else if(var9 == 2604) {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = var16.scrollHeight;
                                                                                                         var35 = 1;
                                                                                                      } else if(var9 == 2605) {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = var16.modelZoom;
                                                                                                         var35 = 1;
                                                                                                      } else if(var9 == 2606) {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = var16.rotationX;
                                                                                                         var35 = 1;
                                                                                                      } else if(var9 == 2607) {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = var16.rotationY;
                                                                                                         var35 = 1;
                                                                                                      } else if(var9 == 2608) {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = var16.rotationZ;
                                                                                                         var35 = 1;
                                                                                                      } else if(var9 == 2609) {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = var16.opacity;
                                                                                                         var35 = 1;
                                                                                                      } else if(var9 == 2610) {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = var16.field2896;
                                                                                                         var35 = 1;
                                                                                                      } else if(var9 == 2611) {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = var16.textColor;
                                                                                                         var35 = 1;
                                                                                                      } else if(var9 == 2612) {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = var16.field2788;
                                                                                                         var35 = 1;
                                                                                                      } else if(var9 == 2613) {
                                                                                                         class82.intStack[++class82.intStackSize - 1] = var16.field2792.rsOrdinal();
                                                                                                         var35 = 1;
                                                                                                      } else {
                                                                                                         var35 = 2;
                                                                                                      }

                                                                                                      var14 = var35;
                                                                                                   } else {
                                                                                                      WidgetNode var56;
                                                                                                      if(var9 < 2800) {
                                                                                                         if(var9 == 2700) {
                                                                                                            var16 = UrlRequester.getWidget(class82.intStack[--class82.intStackSize]);
                                                                                                            class82.intStack[++class82.intStackSize - 1] = var16.itemId;
                                                                                                            var35 = 1;
                                                                                                         } else if(var9 == 2701) {
                                                                                                            var16 = UrlRequester.getWidget(class82.intStack[--class82.intStackSize]);
                                                                                                            if(var16.itemId != -1) {
                                                                                                               class82.intStack[++class82.intStackSize - 1] = var16.itemQuantity;
                                                                                                            } else {
                                                                                                               class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                            }

                                                                                                            var35 = 1;
                                                                                                         } else if(var9 == 2702) {
                                                                                                            var31 = class82.intStack[--class82.intStackSize];
                                                                                                            var56 = (WidgetNode)Client.componentTable.get((long)var31);
                                                                                                            if(var56 != null) {
                                                                                                               class82.intStack[++class82.intStackSize - 1] = 1;
                                                                                                            } else {
                                                                                                               class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                            }

                                                                                                            var35 = 1;
                                                                                                         } else if(var9 == 2706) {
                                                                                                            class82.intStack[++class82.intStackSize - 1] = Client.widgetRoot;
                                                                                                            var35 = 1;
                                                                                                         } else {
                                                                                                            var35 = 2;
                                                                                                         }

                                                                                                         var14 = var35;
                                                                                                      } else if(var9 < 2900) {
                                                                                                         var14 = WidgetNode.method1105(var9, var3, var61);
                                                                                                      } else if(var9 < 3000) {
                                                                                                         var14 = Client.method1546(var9, var3, var61);
                                                                                                      } else {
                                                                                                         PacketNode var36;
                                                                                                         PacketNode var57;
                                                                                                         String var58;
                                                                                                         PacketNode var59;
                                                                                                         PacketNode var80;
                                                                                                         String var89;
                                                                                                         if(var9 < 3200) {
                                                                                                            if(var9 == 3100) {
                                                                                                               var58 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                                                                                                               Preferences.sendGameMessage(0, "", var58);
                                                                                                               var35 = 1;
                                                                                                            } else if(var9 == 3101) {
                                                                                                               class82.intStackSize -= 2;
                                                                                                               class27.method207(GrandExchangeOffer.localPlayer, class82.intStack[class82.intStackSize], class82.intStack[class82.intStackSize + 1]);
                                                                                                               var35 = 1;
                                                                                                            } else if(var9 != 3103) {
                                                                                                               if(var9 == 3104) {
                                                                                                                  var58 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                                                                                                                  var30 = 0;
                                                                                                                  if(AbstractByteBuffer.method3585(var58)) {
                                                                                                                     var18 = PacketNode.parseInt(var58, 10, true);
                                                                                                                     var30 = var18;
                                                                                                                  }

                                                                                                                  var36 = class235.method4272(ClientPacket.field2361, Client.field915.field1462);
                                                                                                                  var36.packetBuffer.putInt(var30);
                                                                                                                  Client.field915.method1898(var36);
                                                                                                                  var35 = 1;
                                                                                                               } else if(var9 == 3105) {
                                                                                                                  var58 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                                                                                                                  var59 = class235.method4272(ClientPacket.field2392, Client.field915.field1462);
                                                                                                                  var59.packetBuffer.putByte(var58.length() + 1);
                                                                                                                  var59.packetBuffer.putString(var58);
                                                                                                                  Client.field915.method1898(var59);
                                                                                                                  var35 = 1;
                                                                                                               } else if(var9 == 3106) {
                                                                                                                  var58 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                                                                                                                  var59 = class235.method4272(ClientPacket.field2400, Client.field915.field1462);
                                                                                                                  var59.packetBuffer.putByte(var58.length() + 1);
                                                                                                                  var59.packetBuffer.putString(var58);
                                                                                                                  Client.field915.method1898(var59);
                                                                                                                  var35 = 1;
                                                                                                               } else if(var9 == 3107) {
                                                                                                                  var31 = class82.intStack[--class82.intStackSize];
                                                                                                                  var60 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                                                                                                                  Client.method1548(var31, var60);
                                                                                                                  var35 = 1;
                                                                                                               } else if(var9 == 3108) {
                                                                                                                  class82.intStackSize -= 3;
                                                                                                                  var31 = class82.intStack[class82.intStackSize];
                                                                                                                  var30 = class82.intStack[class82.intStackSize + 1];
                                                                                                                  var18 = class82.intStack[class82.intStackSize + 2];
                                                                                                                  Widget var34 = UrlRequester.getWidget(var18);
                                                                                                                  Occluder.method2959(var34, var31, var30);
                                                                                                                  var35 = 1;
                                                                                                               } else if(var9 == 3109) {
                                                                                                                  class82.intStackSize -= 2;
                                                                                                                  var31 = class82.intStack[class82.intStackSize];
                                                                                                                  var30 = class82.intStack[class82.intStackSize + 1];
                                                                                                                  Widget var88 = var61?class82.field1267:CombatInfo1.field1216;
                                                                                                                  Occluder.method2959(var88, var31, var30);
                                                                                                                  var35 = 1;
                                                                                                               } else if(var9 == 3110) {
                                                                                                                  class45.middleMouseMovesCamera = class82.intStack[--class82.intStackSize] == 1;
                                                                                                                  var35 = 1;
                                                                                                               } else if(var9 == 3111) {
                                                                                                                  class82.intStack[++class82.intStackSize - 1] = class222.preferences.hideRoofs?1:0;
                                                                                                                  var35 = 1;
                                                                                                               } else if(var9 == 3112) {
                                                                                                                  class222.preferences.hideRoofs = class82.intStack[--class82.intStackSize] == 1;
                                                                                                                  World.method1616();
                                                                                                                  var35 = 1;
                                                                                                               } else if(var9 == 3113) {
                                                                                                                  var58 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                                                                                                                  boolean var75 = class82.intStack[--class82.intStackSize] == 1;
                                                                                                                  GameObject.method2964(var58, var75, false);
                                                                                                                  var35 = 1;
                                                                                                               } else if(var9 == 3115) {
                                                                                                                  var31 = class82.intStack[--class82.intStackSize];
                                                                                                                  var59 = class235.method4272(ClientPacket.field2415, Client.field915.field1462);
                                                                                                                  var59.packetBuffer.putShort(var31);
                                                                                                                  Client.field915.method1898(var59);
                                                                                                                  var35 = 1;
                                                                                                               } else if(var9 == 3116) {
                                                                                                                  var31 = class82.intStack[--class82.intStackSize];
                                                                                                                  FileOnDisk.scriptStringStackSize -= 2;
                                                                                                                  var60 = class82.scriptStringStack[FileOnDisk.scriptStringStackSize];
                                                                                                                  var89 = class82.scriptStringStack[FileOnDisk.scriptStringStackSize + 1];
                                                                                                                  if(var60.length() > 500) {
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var89.length() > 500) {
                                                                                                                     var35 = 1;
                                                                                                                  } else {
                                                                                                                     var80 = class235.method4272(ClientPacket.field2373, Client.field915.field1462);
                                                                                                                     var80.packetBuffer.putShort(1 + Size.getLength(var60) + Size.getLength(var89));
                                                                                                                     var80.packetBuffer.putString(var89);
                                                                                                                     var80.packetBuffer.putString(var60);
                                                                                                                     var80.packetBuffer.method3360(var31);
                                                                                                                     Client.field915.method1898(var80);
                                                                                                                     var35 = 1;
                                                                                                                  }
                                                                                                               } else if(var9 == 3117) {
                                                                                                                  Client.field1003 = class82.intStack[--class82.intStackSize] == 1;
                                                                                                                  var35 = 1;
                                                                                                               } else {
                                                                                                                  var35 = 2;
                                                                                                               }
                                                                                                            } else {
                                                                                                               var57 = class235.method4272(ClientPacket.field2355, Client.field915.field1462);
                                                                                                               Client.field915.method1898(var57);
                                                                                                               var56 = (WidgetNode)Client.componentTable.first();

                                                                                                               while(true) {
                                                                                                                  if(var56 == null) {
                                                                                                                     if(Client.field1019 != null) {
                                                                                                                        class28.method220(Client.field1019);
                                                                                                                        Client.field1019 = null;
                                                                                                                     }

                                                                                                                     var35 = 1;
                                                                                                                     break;
                                                                                                                  }

                                                                                                                  if(var56.owner == 0 || var56.owner == 3) {
                                                                                                                     class19.method138(var56, true);
                                                                                                                  }

                                                                                                                  var56 = (WidgetNode)Client.componentTable.next();
                                                                                                               }
                                                                                                            }

                                                                                                            var14 = var35;
                                                                                                         } else if(var9 < 3300) {
                                                                                                            if(var9 == 3200) {
                                                                                                               class82.intStackSize -= 3;
                                                                                                               var31 = class82.intStack[class82.intStackSize];
                                                                                                               var30 = class82.intStack[class82.intStackSize + 1];
                                                                                                               var18 = class82.intStack[class82.intStackSize + 2];
                                                                                                               if(Client.field903 != 0 && var30 != 0 && Client.field1025 < 50) {
                                                                                                                  Client.field1096[Client.field1025] = var31;
                                                                                                                  Client.field1027[Client.field1025] = var30;
                                                                                                                  Client.field1098[Client.field1025] = var18;
                                                                                                                  Client.audioEffects[Client.field1025] = null;
                                                                                                                  Client.field1099[Client.field1025] = 0;
                                                                                                                  ++Client.field1025;
                                                                                                               }

                                                                                                               var35 = 1;
                                                                                                            } else if(var9 == 3201) {
                                                                                                               class45.method655(class82.intStack[--class82.intStackSize]);
                                                                                                               var35 = 1;
                                                                                                            } else if(var9 == 3202) {
                                                                                                               class82.intStackSize -= 2;
                                                                                                               class35.method488(class82.intStack[class82.intStackSize], class82.intStack[class82.intStackSize + 1]);
                                                                                                               var35 = 1;
                                                                                                            } else {
                                                                                                               var35 = 2;
                                                                                                            }

                                                                                                            var14 = var35;
                                                                                                         } else if(var9 < 3400) {
                                                                                                            var14 = Overlay.method4892(var9, var3, var61);
                                                                                                         } else {
                                                                                                            int var37;
                                                                                                            if(var9 < 3500) {
                                                                                                               if(var9 == 3400) {
                                                                                                                  class82.intStackSize -= 2;
                                                                                                                  var31 = class82.intStack[class82.intStackSize];
                                                                                                                  var30 = class82.intStack[class82.intStackSize + 1];
                                                                                                                  Enum var90 = class34.method487(var31);
                                                                                                                  if(var90.valType != 's') {
                                                                                                                     ;
                                                                                                                  }

                                                                                                                  for(var19 = 0; var19 < var90.size; ++var19) {
                                                                                                                     if(var30 == var90.keys[var19]) {
                                                                                                                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var90.stringVals[var19];
                                                                                                                        var90 = null;
                                                                                                                        break;
                                                                                                                     }
                                                                                                                  }

                                                                                                                  if(var90 != null) {
                                                                                                                     class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var90.defaultString;
                                                                                                                  }

                                                                                                                  var35 = 1;
                                                                                                               } else if(var9 != 3408) {
                                                                                                                  if(var9 == 3411) {
                                                                                                                     var31 = class82.intStack[--class82.intStackSize];
                                                                                                                     Enum var62 = class34.method487(var31);
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = var62.method4671();
                                                                                                                     var35 = 1;
                                                                                                                  } else {
                                                                                                                     var35 = 2;
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class82.intStackSize -= 4;
                                                                                                                  var31 = class82.intStack[class82.intStackSize];
                                                                                                                  var30 = class82.intStack[class82.intStackSize + 1];
                                                                                                                  var18 = class82.intStack[class82.intStackSize + 2];
                                                                                                                  var19 = class82.intStack[class82.intStackSize + 3];
                                                                                                                  Enum var33 = class34.method487(var18);
                                                                                                                  if(var31 == var33.keyType && var30 == var33.valType) {
                                                                                                                     for(var37 = 0; var37 < var33.size; ++var37) {
                                                                                                                        if(var19 == var33.keys[var37]) {
                                                                                                                           if(var30 == 115) {
                                                                                                                              class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var33.stringVals[var37];
                                                                                                                           } else {
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = var33.intVals[var37];
                                                                                                                           }

                                                                                                                           var33 = null;
                                                                                                                           break;
                                                                                                                        }
                                                                                                                     }

                                                                                                                     if(var33 != null) {
                                                                                                                        if(var30 == 115) {
                                                                                                                           class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var33.defaultString;
                                                                                                                        } else {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = var33.defaultInt;
                                                                                                                        }
                                                                                                                     }

                                                                                                                     var35 = 1;
                                                                                                                  } else {
                                                                                                                     if(var30 == 115) {
                                                                                                                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "null";
                                                                                                                     } else {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                     }

                                                                                                                     var35 = 1;
                                                                                                                  }
                                                                                                               }

                                                                                                               var14 = var35;
                                                                                                            } else {
                                                                                                               int var22;
                                                                                                               int var24;
                                                                                                               if(var9 < 3700) {
                                                                                                                  if(var9 == 3600) {
                                                                                                                     if(Client.field1077 == 0) {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = -2;
                                                                                                                     } else if(Client.field1077 == 1) {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                     } else {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = Client.friendCount;
                                                                                                                     }

                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 3601) {
                                                                                                                     var31 = class82.intStack[--class82.intStackSize];
                                                                                                                     if(Client.field1077 == 2 && var31 < Client.friendCount) {
                                                                                                                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = Client.friends[var31].name;
                                                                                                                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = Client.friends[var31].previousName;
                                                                                                                     } else {
                                                                                                                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
                                                                                                                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 3602) {
                                                                                                                     var31 = class82.intStack[--class82.intStackSize];
                                                                                                                     if(Client.field1077 == 2 && var31 < Client.friendCount) {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = Client.friends[var31].world;
                                                                                                                     } else {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                     }

                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 3603) {
                                                                                                                     var31 = class82.intStack[--class82.intStackSize];
                                                                                                                     if(Client.field1077 == 2 && var31 < Client.friendCount) {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = Client.friends[var31].rank;
                                                                                                                     } else {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                     }

                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 3604) {
                                                                                                                     var58 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                                                                                                                     var30 = class82.intStack[--class82.intStackSize];
                                                                                                                     MilliTimer.method3006(var58, var30);
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 3605) {
                                                                                                                     var58 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                                                                                                                     class54.method781(var58);
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 3606) {
                                                                                                                     var58 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                                                                                                                     if(var58 != null) {
                                                                                                                        var60 = WorldMapData.cleanUsername(var58, GrandExchangeOffer.jagexLoginType);
                                                                                                                        if(var60 != null) {
                                                                                                                           for(var18 = 0; var18 < Client.friendCount; ++var18) {
                                                                                                                              Friend var84 = Client.friends[var18];
                                                                                                                              var79 = var84.name;
                                                                                                                              var21 = WorldMapData.cleanUsername(var79, GrandExchangeOffer.jagexLoginType);
                                                                                                                              if(class36.method490(var58, var60, var79, var21)) {
                                                                                                                                 --Client.friendCount;

                                                                                                                                 for(var22 = var18; var22 < Client.friendCount; ++var22) {
                                                                                                                                    Client.friends[var22] = Client.friends[var22 + 1];
                                                                                                                                 }

                                                                                                                                 Client.field880 = Client.cycleCntr;
                                                                                                                                 PacketNode var95 = class235.method4272(ClientPacket.field2365, Client.field915.field1462);
                                                                                                                                 var95.packetBuffer.putByte(Size.getLength(var58));
                                                                                                                                 var95.packetBuffer.putString(var58);
                                                                                                                                 Client.field915.method1898(var95);
                                                                                                                                 break;
                                                                                                                              }
                                                                                                                           }
                                                                                                                        }
                                                                                                                     }

                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 3607) {
                                                                                                                     var58 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                                                                                                                     class87.method1740(var58, false);
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 3608) {
                                                                                                                     var58 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                                                                                                                     class41.method580(var58);
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 3609) {
                                                                                                                     var58 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                                                                                                                     Permission[] var64 = new Permission[]{Permission.field3273, Permission.field3275, Permission.field3282, Permission.field3278, Permission.field3272, Permission.field3276};
                                                                                                                     Permission[] var91 = var64;

                                                                                                                     for(var19 = 0; var19 < var91.length; ++var19) {
                                                                                                                        Permission var78 = var91[var19];
                                                                                                                        if(var78.field3279 != -1 && var58.startsWith(CombatInfoListHolder.method1706(var78.field3279))) {
                                                                                                                           var58 = var58.substring(6 + Integer.toString(var78.field3279).length());
                                                                                                                           break;
                                                                                                                        }
                                                                                                                     }

                                                                                                                     class82.intStack[++class82.intStackSize - 1] = class91.isFriended(var58, false)?1:0;
                                                                                                                     var35 = 1;
                                                                                                                  } else {
                                                                                                                     int var25;
                                                                                                                     char var26;
                                                                                                                     String var38;
                                                                                                                     long var39;
                                                                                                                     String var82;
                                                                                                                     if(var9 == 3611) {
                                                                                                                        if(Client.clanChatOwner != null) {
                                                                                                                           var63 = class82.scriptStringStack;
                                                                                                                           var30 = ++FileOnDisk.scriptStringStackSize - 1;
                                                                                                                           var82 = Client.clanChatOwner;
                                                                                                                           var39 = 0L;
                                                                                                                           var24 = var82.length();

                                                                                                                           for(var25 = 0; var25 < var24; ++var25) {
                                                                                                                              var39 *= 37L;
                                                                                                                              var26 = var82.charAt(var25);
                                                                                                                              if(var26 >= 'A' && var26 <= 'Z') {
                                                                                                                                 var39 += (long)(var26 + 1 - 65);
                                                                                                                              } else if(var26 >= 'a' && var26 <= 'z') {
                                                                                                                                 var39 += (long)(var26 + 1 - 97);
                                                                                                                              } else if(var26 >= '0' && var26 <= '9') {
                                                                                                                                 var39 += (long)(var26 + 27 - 48);
                                                                                                                              }

                                                                                                                              if(var39 >= 177917621779460413L) {
                                                                                                                                 break;
                                                                                                                              }
                                                                                                                           }

                                                                                                                           while(0L == var39 % 37L && var39 != 0L) {
                                                                                                                              var39 /= 37L;
                                                                                                                           }

                                                                                                                           var38 = UnitPriceComparator.method126(var39);
                                                                                                                           if(var38 == null) {
                                                                                                                              var38 = "";
                                                                                                                           }

                                                                                                                           var63[var30] = var38;
                                                                                                                        } else {
                                                                                                                           class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var35 = 1;
                                                                                                                     } else if(var9 == 3612) {
                                                                                                                        if(Client.clanChatOwner != null) {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = FileSystem.clanChatCount;
                                                                                                                        } else {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                        }

                                                                                                                        var35 = 1;
                                                                                                                     } else if(var9 == 3613) {
                                                                                                                        var31 = class82.intStack[--class82.intStackSize];
                                                                                                                        if(Client.clanChatOwner != null && var31 < FileSystem.clanChatCount) {
                                                                                                                           class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = AbstractSoundSystem.clanMembers[var31].username;
                                                                                                                        } else {
                                                                                                                           class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var35 = 1;
                                                                                                                     } else if(var9 == 3614) {
                                                                                                                        var31 = class82.intStack[--class82.intStackSize];
                                                                                                                        if(Client.clanChatOwner != null && var31 < FileSystem.clanChatCount) {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = AbstractSoundSystem.clanMembers[var31].world;
                                                                                                                        } else {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                        }

                                                                                                                        var35 = 1;
                                                                                                                     } else if(var9 == 3615) {
                                                                                                                        var31 = class82.intStack[--class82.intStackSize];
                                                                                                                        if(Client.clanChatOwner != null && var31 < FileSystem.clanChatCount) {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = AbstractSoundSystem.clanMembers[var31].rank;
                                                                                                                        } else {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                        }

                                                                                                                        var35 = 1;
                                                                                                                     } else if(var9 == 3616) {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = class40.field526;
                                                                                                                        var35 = 1;
                                                                                                                     } else if(var9 == 3617) {
                                                                                                                        var58 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                                                                                                                        class72.method1123(var58);
                                                                                                                        var35 = 1;
                                                                                                                     } else if(var9 == 3618) {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = WorldMapType3.clanChatRank;
                                                                                                                        var35 = 1;
                                                                                                                     } else if(var9 == 3619) {
                                                                                                                        var58 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                                                                                                                        if(!var58.equals("")) {
                                                                                                                           var59 = class235.method4272(ClientPacket.field2341, Client.field915.field1462);
                                                                                                                           var59.packetBuffer.putByte(Size.getLength(var58));
                                                                                                                           var59.packetBuffer.putString(var58);
                                                                                                                           Client.field915.method1898(var59);
                                                                                                                        }

                                                                                                                        var35 = 1;
                                                                                                                     } else if(var9 == 3620) {
                                                                                                                        var57 = class235.method4272(ClientPacket.field2341, Client.field915.field1462);
                                                                                                                        var57.packetBuffer.putByte(0);
                                                                                                                        Client.field915.method1898(var57);
                                                                                                                        var35 = 1;
                                                                                                                     } else if(var9 == 3621) {
                                                                                                                        if(Client.field1077 == 0) {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                        } else {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = Client.ignoreCount;
                                                                                                                        }

                                                                                                                        var35 = 1;
                                                                                                                     } else if(var9 == 3622) {
                                                                                                                        var31 = class82.intStack[--class82.intStackSize];
                                                                                                                        if(Client.field1077 != 0 && var31 < Client.ignoreCount) {
                                                                                                                           class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = Client.ignores[var31].name;
                                                                                                                           class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = Client.ignores[var31].previousName;
                                                                                                                        } else {
                                                                                                                           class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
                                                                                                                           class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var35 = 1;
                                                                                                                     } else if(var9 == 3623) {
                                                                                                                        var58 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                                                                                                                        if(var58.startsWith(CombatInfoListHolder.method1706(0)) || var58.startsWith(CombatInfoListHolder.method1706(1))) {
                                                                                                                           var58 = var58.substring(7);
                                                                                                                        }

                                                                                                                        class82.intStack[++class82.intStackSize - 1] = class33.isIgnored(var58)?1:0;
                                                                                                                        var35 = 1;
                                                                                                                     } else if(var9 == 3624) {
                                                                                                                        var31 = class82.intStack[--class82.intStackSize];
                                                                                                                        if(AbstractSoundSystem.clanMembers != null && var31 < FileSystem.clanChatCount && AbstractSoundSystem.clanMembers[var31].username.equalsIgnoreCase(GrandExchangeOffer.localPlayer.name)) {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = 1;
                                                                                                                        } else {
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                        }

                                                                                                                        var35 = 1;
                                                                                                                     } else if(var9 != 3625) {
                                                                                                                        var35 = 2;
                                                                                                                     } else {
                                                                                                                        if(Client.clanChatName != null) {
                                                                                                                           var63 = class82.scriptStringStack;
                                                                                                                           var30 = ++FileOnDisk.scriptStringStackSize - 1;
                                                                                                                           var82 = Client.clanChatName;
                                                                                                                           var39 = 0L;
                                                                                                                           var24 = var82.length();

                                                                                                                           for(var25 = 0; var25 < var24; ++var25) {
                                                                                                                              var39 *= 37L;
                                                                                                                              var26 = var82.charAt(var25);
                                                                                                                              if(var26 >= 'A' && var26 <= 'Z') {
                                                                                                                                 var39 += (long)(var26 + 1 - 65);
                                                                                                                              } else if(var26 >= 'a' && var26 <= 'z') {
                                                                                                                                 var39 += (long)(var26 + 1 - 97);
                                                                                                                              } else if(var26 >= '0' && var26 <= '9') {
                                                                                                                                 var39 += (long)(var26 + 27 - 48);
                                                                                                                              }

                                                                                                                              if(var39 >= 177917621779460413L) {
                                                                                                                                 break;
                                                                                                                              }
                                                                                                                           }

                                                                                                                           while(var39 % 37L == 0L && var39 != 0L) {
                                                                                                                              var39 /= 37L;
                                                                                                                           }

                                                                                                                           var38 = UnitPriceComparator.method126(var39);
                                                                                                                           if(var38 == null) {
                                                                                                                              var38 = "";
                                                                                                                           }

                                                                                                                           var63[var30] = var38;
                                                                                                                        } else {
                                                                                                                           class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var35 = 1;
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var14 = var35;
                                                                                                               } else if(var9 < 4000) {
                                                                                                                  var14 = WorldMapType3.method175(var9, var3, var61);
                                                                                                               } else if(var9 < 4100) {
                                                                                                                  if(var9 == 4000) {
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     var31 = class82.intStack[class82.intStackSize];
                                                                                                                     var30 = class82.intStack[class82.intStackSize + 1];
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = var30 + var31;
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 4001) {
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     var31 = class82.intStack[class82.intStackSize];
                                                                                                                     var30 = class82.intStack[class82.intStackSize + 1];
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = var31 - var30;
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 4002) {
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     var31 = class82.intStack[class82.intStackSize];
                                                                                                                     var30 = class82.intStack[class82.intStackSize + 1];
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = var30 * var31;
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 4003) {
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     var31 = class82.intStack[class82.intStackSize];
                                                                                                                     var30 = class82.intStack[class82.intStackSize + 1];
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = var31 / var30;
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 4004) {
                                                                                                                     var31 = class82.intStack[--class82.intStackSize];
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = (int)(Math.random() * (double)var31);
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 4005) {
                                                                                                                     var31 = class82.intStack[--class82.intStackSize];
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = (int)(Math.random() * (double)(var31 + 1));
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 4006) {
                                                                                                                     class82.intStackSize -= 5;
                                                                                                                     var31 = class82.intStack[class82.intStackSize];
                                                                                                                     var30 = class82.intStack[class82.intStackSize + 1];
                                                                                                                     var18 = class82.intStack[class82.intStackSize + 2];
                                                                                                                     var19 = class82.intStack[class82.intStackSize + 3];
                                                                                                                     var20 = class82.intStack[class82.intStackSize + 4];
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = var31 + (var20 - var18) * (var30 - var31) / (var19 - var18);
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 4007) {
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     var31 = class82.intStack[class82.intStackSize];
                                                                                                                     var30 = class82.intStack[class82.intStackSize + 1];
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = var31 + var30 * var31 / 100;
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 4008) {
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     var31 = class82.intStack[class82.intStackSize];
                                                                                                                     var30 = class82.intStack[class82.intStackSize + 1];
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = var31 | 1 << var30;
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 4009) {
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     var31 = class82.intStack[class82.intStackSize];
                                                                                                                     var30 = class82.intStack[class82.intStackSize + 1];
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = var31 & -1 - (1 << var30);
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 4010) {
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     var31 = class82.intStack[class82.intStackSize];
                                                                                                                     var30 = class82.intStack[class82.intStackSize + 1];
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = (var31 & 1 << var30) != 0?1:0;
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 4011) {
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     var31 = class82.intStack[class82.intStackSize];
                                                                                                                     var30 = class82.intStack[class82.intStackSize + 1];
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = var31 % var30;
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 4012) {
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     var31 = class82.intStack[class82.intStackSize];
                                                                                                                     var30 = class82.intStack[class82.intStackSize + 1];
                                                                                                                     if(var31 == 0) {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                     } else {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = (int)Math.pow((double)var31, (double)var30);
                                                                                                                     }

                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 4013) {
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     var31 = class82.intStack[class82.intStackSize];
                                                                                                                     var30 = class82.intStack[class82.intStackSize + 1];
                                                                                                                     if(var31 == 0) {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                        var35 = 1;
                                                                                                                     } else {
                                                                                                                        switch(var30) {
                                                                                                                        case 0:
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = Integer.MAX_VALUE;
                                                                                                                           break;
                                                                                                                        case 1:
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = var31;
                                                                                                                           break;
                                                                                                                        case 2:
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = (int)Math.sqrt((double)var31);
                                                                                                                           break;
                                                                                                                        case 3:
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = (int)Math.cbrt((double)var31);
                                                                                                                           break;
                                                                                                                        case 4:
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var31));
                                                                                                                           break;
                                                                                                                        default:
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = (int)Math.pow((double)var31, 1.0D / (double)var30);
                                                                                                                        }

                                                                                                                        var35 = 1;
                                                                                                                     }
                                                                                                                  } else if(var9 == 4014) {
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     var31 = class82.intStack[class82.intStackSize];
                                                                                                                     var30 = class82.intStack[class82.intStackSize + 1];
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = var31 & var30;
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 4015) {
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     var31 = class82.intStack[class82.intStackSize];
                                                                                                                     var30 = class82.intStack[class82.intStackSize + 1];
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = var31 | var30;
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 4018) {
                                                                                                                     class82.intStackSize -= 3;
                                                                                                                     long var43 = (long)class82.intStack[class82.intStackSize];
                                                                                                                     long var45 = (long)class82.intStack[class82.intStackSize + 1];
                                                                                                                     long var41 = (long)class82.intStack[class82.intStackSize + 2];
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = (int)(var43 * var41 / var45);
                                                                                                                     var35 = 1;
                                                                                                                  } else {
                                                                                                                     var35 = 2;
                                                                                                                  }

                                                                                                                  var14 = var35;
                                                                                                               } else if(var9 < 4200) {
                                                                                                                  var14 = class238.method4273(var9, var3, var61);
                                                                                                               } else if(var9 < 4300) {
                                                                                                                  if(var9 == 4200) {
                                                                                                                     var31 = class82.intStack[--class82.intStackSize];
                                                                                                                     class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = class115.getItemDefinition(var31).name;
                                                                                                                     var35 = 1;
                                                                                                                  } else {
                                                                                                                     ItemComposition var92;
                                                                                                                     if(var9 == 4201) {
                                                                                                                        class82.intStackSize -= 2;
                                                                                                                        var31 = class82.intStack[class82.intStackSize];
                                                                                                                        var30 = class82.intStack[class82.intStackSize + 1];
                                                                                                                        var92 = class115.getItemDefinition(var31);
                                                                                                                        if(var30 >= 1 && var30 <= 5 && var92.groundActions[var30 - 1] != null) {
                                                                                                                           class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var92.groundActions[var30 - 1];
                                                                                                                        } else {
                                                                                                                           class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var35 = 1;
                                                                                                                     } else if(var9 == 4202) {
                                                                                                                        class82.intStackSize -= 2;
                                                                                                                        var31 = class82.intStack[class82.intStackSize];
                                                                                                                        var30 = class82.intStack[class82.intStackSize + 1];
                                                                                                                        var92 = class115.getItemDefinition(var31);
                                                                                                                        if(var30 >= 1 && var30 <= 5 && var92.inventoryActions[var30 - 1] != null) {
                                                                                                                           class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var92.inventoryActions[var30 - 1];
                                                                                                                        } else {
                                                                                                                           class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var35 = 1;
                                                                                                                     } else if(var9 == 4203) {
                                                                                                                        var31 = class82.intStack[--class82.intStackSize];
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = class115.getItemDefinition(var31).price;
                                                                                                                        var35 = 1;
                                                                                                                     } else if(var9 == 4204) {
                                                                                                                        var31 = class82.intStack[--class82.intStackSize];
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = class115.getItemDefinition(var31).isStackable == 1?1:0;
                                                                                                                        var35 = 1;
                                                                                                                     } else {
                                                                                                                        ItemComposition var66;
                                                                                                                        if(var9 == 4205) {
                                                                                                                           var31 = class82.intStack[--class82.intStackSize];
                                                                                                                           var66 = class115.getItemDefinition(var31);
                                                                                                                           if(var66.notedTemplate == -1 && var66.note >= 0) {
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = var66.note;
                                                                                                                           } else {
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = var31;
                                                                                                                           }

                                                                                                                           var35 = 1;
                                                                                                                        } else if(var9 == 4206) {
                                                                                                                           var31 = class82.intStack[--class82.intStackSize];
                                                                                                                           var66 = class115.getItemDefinition(var31);
                                                                                                                           if(var66.notedTemplate >= 0 && var66.note >= 0) {
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = var66.note;
                                                                                                                           } else {
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = var31;
                                                                                                                           }

                                                                                                                           var35 = 1;
                                                                                                                        } else if(var9 == 4207) {
                                                                                                                           var31 = class82.intStack[--class82.intStackSize];
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = class115.getItemDefinition(var31).isMembers?1:0;
                                                                                                                           var35 = 1;
                                                                                                                        } else if(var9 == 4208) {
                                                                                                                           var31 = class82.intStack[--class82.intStackSize];
                                                                                                                           var66 = class115.getItemDefinition(var31);
                                                                                                                           if(var66.int3 == -1 && var66.int2 >= 0) {
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = var66.int2;
                                                                                                                           } else {
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = var31;
                                                                                                                           }

                                                                                                                           var35 = 1;
                                                                                                                        } else if(var9 == 4209) {
                                                                                                                           var31 = class82.intStack[--class82.intStackSize];
                                                                                                                           var66 = class115.getItemDefinition(var31);
                                                                                                                           if(var66.int3 >= 0 && var66.int2 >= 0) {
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = var66.int2;
                                                                                                                           } else {
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = var31;
                                                                                                                           }

                                                                                                                           var35 = 1;
                                                                                                                        } else if(var9 == 4210) {
                                                                                                                           var58 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                                                                                                                           var30 = class82.intStack[--class82.intStackSize];
                                                                                                                           class175.method3265(var58, var30 == 1);
                                                                                                                           class82.intStack[++class82.intStackSize - 1] = BoundingBox.field242;
                                                                                                                           var35 = 1;
                                                                                                                        } else if(var9 != 4211) {
                                                                                                                           if(var9 == 4212) {
                                                                                                                              class60.field726 = 0;
                                                                                                                              var35 = 1;
                                                                                                                           } else {
                                                                                                                              var35 = 2;
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class232.field2926 != null && class60.field726 < BoundingBox.field242) {
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = class232.field2926[++class60.field726 - 1] & '\uffff';
                                                                                                                           } else {
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                           }

                                                                                                                           var35 = 1;
                                                                                                                        }
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var14 = var35;
                                                                                                               } else if(var9 < 5100) {
                                                                                                                  if(var9 == 5000) {
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = Client.publicChatMode;
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 5001) {
                                                                                                                     class82.intStackSize -= 3;
                                                                                                                     Client.publicChatMode = class82.intStack[class82.intStackSize];
                                                                                                                     var30 = class82.intStack[class82.intStackSize + 1];
                                                                                                                     class289[] var96 = new class289[]{class289.field3813, class289.field3812, class289.field3814};
                                                                                                                     class289[] var86 = var96;
                                                                                                                     var20 = 0;

                                                                                                                     class289 var93;
                                                                                                                     while(true) {
                                                                                                                        if(var20 >= var86.length) {
                                                                                                                           var93 = null;
                                                                                                                           break;
                                                                                                                        }

                                                                                                                        class289 var68 = var86[var20];
                                                                                                                        if(var30 == var68.field3815) {
                                                                                                                           var93 = var68;
                                                                                                                           break;
                                                                                                                        }

                                                                                                                        ++var20;
                                                                                                                     }

                                                                                                                     class48.field580 = var93;
                                                                                                                     if(class48.field580 == null) {
                                                                                                                        class48.field580 = class289.field3813;
                                                                                                                     }

                                                                                                                     Client.field1072 = class82.intStack[class82.intStackSize + 2];
                                                                                                                     var36 = class235.method4272(ClientPacket.field2405, Client.field915.field1462);
                                                                                                                     var36.packetBuffer.putByte(Client.publicChatMode);
                                                                                                                     var36.packetBuffer.putByte(class48.field580.field3815);
                                                                                                                     var36.packetBuffer.putByte(Client.field1072);
                                                                                                                     Client.field915.method1898(var36);
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 5002) {
                                                                                                                     var58 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     var30 = class82.intStack[class82.intStackSize];
                                                                                                                     var18 = class82.intStack[class82.intStackSize + 1];
                                                                                                                     var80 = class235.method4272(ClientPacket.field2409, Client.field915.field1462);
                                                                                                                     var80.packetBuffer.putByte(Size.getLength(var58) + 2);
                                                                                                                     var80.packetBuffer.putString(var58);
                                                                                                                     var80.packetBuffer.putByte(var30 - 1);
                                                                                                                     var80.packetBuffer.putByte(var18);
                                                                                                                     Client.field915.method1898(var80);
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 5003) {
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     var31 = class82.intStack[class82.intStackSize];
                                                                                                                     var30 = class82.intStack[class82.intStackSize + 1];
                                                                                                                     MessageNode var94 = Coordinates.method4165(var31, var30);
                                                                                                                     if(var94 != null) {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = var94.id;
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = var94.tick;
                                                                                                                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var94.name != null?var94.name:"";
                                                                                                                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var94.sender != null?var94.sender:"";
                                                                                                                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var94.value != null?var94.value:"";
                                                                                                                     } else {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
                                                                                                                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
                                                                                                                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 5004) {
                                                                                                                     var31 = class82.intStack[--class82.intStackSize];
                                                                                                                     MessageNode var69 = (MessageNode)class96.messages.get((long)var31);
                                                                                                                     if(var69 != null) {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = var69.type;
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = var69.tick;
                                                                                                                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var69.name != null?var69.name:"";
                                                                                                                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var69.sender != null?var69.sender:"";
                                                                                                                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var69.value != null?var69.value:"";
                                                                                                                     } else {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = 0;
                                                                                                                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
                                                                                                                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
                                                                                                                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 5005) {
                                                                                                                     if(class48.field580 == null) {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                     } else {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = class48.field580.field3815;
                                                                                                                     }

                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 5008) {
                                                                                                                     var58 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                                                                                                                     var30 = class82.intStack[--class82.intStackSize];
                                                                                                                     var89 = var58.toLowerCase();
                                                                                                                     byte var71 = 0;
                                                                                                                     if(var89.startsWith("yellow:")) {
                                                                                                                        var71 = 0;
                                                                                                                        var58 = var58.substring("yellow:".length());
                                                                                                                     } else if(var89.startsWith("red:")) {
                                                                                                                        var71 = 1;
                                                                                                                        var58 = var58.substring("red:".length());
                                                                                                                     } else if(var89.startsWith("green:")) {
                                                                                                                        var71 = 2;
                                                                                                                        var58 = var58.substring("green:".length());
                                                                                                                     } else if(var89.startsWith("cyan:")) {
                                                                                                                        var71 = 3;
                                                                                                                        var58 = var58.substring("cyan:".length());
                                                                                                                     } else if(var89.startsWith("purple:")) {
                                                                                                                        var71 = 4;
                                                                                                                        var58 = var58.substring("purple:".length());
                                                                                                                     } else if(var89.startsWith("white:")) {
                                                                                                                        var71 = 5;
                                                                                                                        var58 = var58.substring("white:".length());
                                                                                                                     } else if(var89.startsWith("flash1:")) {
                                                                                                                        var71 = 6;
                                                                                                                        var58 = var58.substring("flash1:".length());
                                                                                                                     } else if(var89.startsWith("flash2:")) {
                                                                                                                        var71 = 7;
                                                                                                                        var58 = var58.substring("flash2:".length());
                                                                                                                     } else if(var89.startsWith("flash3:")) {
                                                                                                                        var71 = 8;
                                                                                                                        var58 = var58.substring("flash3:".length());
                                                                                                                     } else if(var89.startsWith("glow1:")) {
                                                                                                                        var71 = 9;
                                                                                                                        var58 = var58.substring("glow1:".length());
                                                                                                                     } else if(var89.startsWith("glow2:")) {
                                                                                                                        var71 = 10;
                                                                                                                        var58 = var58.substring("glow2:".length());
                                                                                                                     } else if(var89.startsWith("glow3:")) {
                                                                                                                        var71 = 11;
                                                                                                                        var58 = var58.substring("glow3:".length());
                                                                                                                     } else if(Client.languageId != 0) {
                                                                                                                        if(var89.startsWith("yellow:")) {
                                                                                                                           var71 = 0;
                                                                                                                           var58 = var58.substring("yellow:".length());
                                                                                                                        } else if(var89.startsWith("red:")) {
                                                                                                                           var71 = 1;
                                                                                                                           var58 = var58.substring("red:".length());
                                                                                                                        } else if(var89.startsWith("green:")) {
                                                                                                                           var71 = 2;
                                                                                                                           var58 = var58.substring("green:".length());
                                                                                                                        } else if(var89.startsWith("cyan:")) {
                                                                                                                           var71 = 3;
                                                                                                                           var58 = var58.substring("cyan:".length());
                                                                                                                        } else if(var89.startsWith("purple:")) {
                                                                                                                           var71 = 4;
                                                                                                                           var58 = var58.substring("purple:".length());
                                                                                                                        } else if(var89.startsWith("white:")) {
                                                                                                                           var71 = 5;
                                                                                                                           var58 = var58.substring("white:".length());
                                                                                                                        } else if(var89.startsWith("flash1:")) {
                                                                                                                           var71 = 6;
                                                                                                                           var58 = var58.substring("flash1:".length());
                                                                                                                        } else if(var89.startsWith("flash2:")) {
                                                                                                                           var71 = 7;
                                                                                                                           var58 = var58.substring("flash2:".length());
                                                                                                                        } else if(var89.startsWith("flash3:")) {
                                                                                                                           var71 = 8;
                                                                                                                           var58 = var58.substring("flash3:".length());
                                                                                                                        } else if(var89.startsWith("glow1:")) {
                                                                                                                           var71 = 9;
                                                                                                                           var58 = var58.substring("glow1:".length());
                                                                                                                        } else if(var89.startsWith("glow2:")) {
                                                                                                                           var71 = 10;
                                                                                                                           var58 = var58.substring("glow2:".length());
                                                                                                                        } else if(var89.startsWith("glow3:")) {
                                                                                                                           var71 = 11;
                                                                                                                           var58 = var58.substring("glow3:".length());
                                                                                                                        }
                                                                                                                     }

                                                                                                                     var89 = var58.toLowerCase();
                                                                                                                     byte var65 = 0;
                                                                                                                     if(var89.startsWith("wave:")) {
                                                                                                                        var65 = 1;
                                                                                                                        var58 = var58.substring("wave:".length());
                                                                                                                     } else if(var89.startsWith("wave2:")) {
                                                                                                                        var65 = 2;
                                                                                                                        var58 = var58.substring("wave2:".length());
                                                                                                                     } else if(var89.startsWith("shake:")) {
                                                                                                                        var65 = 3;
                                                                                                                        var58 = var58.substring("shake:".length());
                                                                                                                     } else if(var89.startsWith("scroll:")) {
                                                                                                                        var65 = 4;
                                                                                                                        var58 = var58.substring("scroll:".length());
                                                                                                                     } else if(var89.startsWith("slide:")) {
                                                                                                                        var65 = 5;
                                                                                                                        var58 = var58.substring("slide:".length());
                                                                                                                     } else if(Client.languageId != 0) {
                                                                                                                        if(var89.startsWith("wave:")) {
                                                                                                                           var65 = 1;
                                                                                                                           var58 = var58.substring("wave:".length());
                                                                                                                        } else if(var89.startsWith("wave2:")) {
                                                                                                                           var65 = 2;
                                                                                                                           var58 = var58.substring("wave2:".length());
                                                                                                                        } else if(var89.startsWith("shake:")) {
                                                                                                                           var65 = 3;
                                                                                                                           var58 = var58.substring("shake:".length());
                                                                                                                        } else if(var89.startsWith("scroll:")) {
                                                                                                                           var65 = 4;
                                                                                                                           var58 = var58.substring("scroll:".length());
                                                                                                                        } else if(var89.startsWith("slide:")) {
                                                                                                                           var65 = 5;
                                                                                                                           var58 = var58.substring("slide:".length());
                                                                                                                        }
                                                                                                                     }

                                                                                                                     PacketNode var67 = class235.method4272(ClientPacket.field2424, Client.field915.field1462);
                                                                                                                     var67.packetBuffer.putByte(0);
                                                                                                                     var22 = var67.packetBuffer.offset;
                                                                                                                     var67.packetBuffer.putByte(var30);
                                                                                                                     var67.packetBuffer.putByte(var71);
                                                                                                                     var67.packetBuffer.putByte(var65);
                                                                                                                     PacketBuffer var23 = var67.packetBuffer;
                                                                                                                     var24 = var23.offset;
                                                                                                                     byte[] var47 = class87.method1741(var58);
                                                                                                                     var23.putShortSmart(var47.length);
                                                                                                                     var23.offset += class276.huffman.compress(var47, 0, var47.length, var23.payload, var23.offset);
                                                                                                                     var67.packetBuffer.method3332(var67.packetBuffer.offset - var22);
                                                                                                                     Client.field915.method1898(var67);
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 5009) {
                                                                                                                     FileOnDisk.scriptStringStackSize -= 2;
                                                                                                                     var58 = class82.scriptStringStack[FileOnDisk.scriptStringStackSize];
                                                                                                                     var60 = class82.scriptStringStack[FileOnDisk.scriptStringStackSize + 1];
                                                                                                                     var36 = class235.method4272(ClientPacket.field2417, Client.field915.field1462);
                                                                                                                     var36.packetBuffer.putShort(0);
                                                                                                                     var19 = var36.packetBuffer.offset;
                                                                                                                     var36.packetBuffer.putString(var58);
                                                                                                                     PacketBuffer var85 = var36.packetBuffer;
                                                                                                                     var37 = var85.offset;
                                                                                                                     byte[] var97 = class87.method1741(var60);
                                                                                                                     var85.putShortSmart(var97.length);
                                                                                                                     var85.offset += class276.huffman.compress(var97, 0, var97.length, var85.payload, var85.offset);
                                                                                                                     var36.packetBuffer.method3331(var36.packetBuffer.offset - var19);
                                                                                                                     Client.field915.method1898(var36);
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 != 5015) {
                                                                                                                     if(var9 == 5016) {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = Client.field1072;
                                                                                                                        var35 = 1;
                                                                                                                     } else if(var9 == 5017) {
                                                                                                                        var31 = class82.intStack[--class82.intStackSize];
                                                                                                                        var17 = class82.intStack;
                                                                                                                        var18 = ++class82.intStackSize - 1;
                                                                                                                        ChatLineBuffer var81 = (ChatLineBuffer)class96.chatLineMap.get(Integer.valueOf(var31));
                                                                                                                        if(var81 == null) {
                                                                                                                           var19 = 0;
                                                                                                                        } else {
                                                                                                                           var19 = var81.size();
                                                                                                                        }

                                                                                                                        var17[var18] = var19;
                                                                                                                        var35 = 1;
                                                                                                                     } else if(var9 == 5018) {
                                                                                                                        var31 = class82.intStack[--class82.intStackSize];
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = MilliTimer.method3000(var31);
                                                                                                                        var35 = 1;
                                                                                                                     } else if(var9 == 5019) {
                                                                                                                        var31 = class82.intStack[--class82.intStackSize];
                                                                                                                        var17 = class82.intStack;
                                                                                                                        var18 = ++class82.intStackSize - 1;
                                                                                                                        MessageNode var83 = (MessageNode)class96.messages.get((long)var31);
                                                                                                                        if(var83 == null) {
                                                                                                                           var19 = -1;
                                                                                                                        } else if(var83.next == class96.field1424.sentinel) {
                                                                                                                           var19 = -1;
                                                                                                                        } else {
                                                                                                                           var19 = ((MessageNode)var83.next).id;
                                                                                                                        }

                                                                                                                        var17[var18] = var19;
                                                                                                                        var35 = 1;
                                                                                                                     } else if(var9 == 5020) {
                                                                                                                        var58 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                                                                                                                        VertexNormal.method2665(var58);
                                                                                                                        var35 = 1;
                                                                                                                     } else if(var9 == 5021) {
                                                                                                                        Client.field885 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize].toLowerCase().trim();
                                                                                                                        var35 = 1;
                                                                                                                     } else if(var9 == 5022) {
                                                                                                                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = Client.field885;
                                                                                                                        var35 = 1;
                                                                                                                     } else {
                                                                                                                        var35 = 2;
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     if(GrandExchangeOffer.localPlayer != null && GrandExchangeOffer.localPlayer.name != null) {
                                                                                                                        var58 = GrandExchangeOffer.localPlayer.name;
                                                                                                                     } else {
                                                                                                                        var58 = "";
                                                                                                                     }

                                                                                                                     class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var58;
                                                                                                                     var35 = 1;
                                                                                                                  }

                                                                                                                  var14 = var35;
                                                                                                               } else if(var9 < 5400) {
                                                                                                                  if(var9 == 5306) {
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = class43.method612();
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 5307) {
                                                                                                                     var31 = class82.intStack[--class82.intStackSize];
                                                                                                                     if(var31 == 1 || var31 == 2) {
                                                                                                                        Client.field1068 = 0L;
                                                                                                                        if(var31 >= 2) {
                                                                                                                           Client.isResized = true;
                                                                                                                        } else {
                                                                                                                           Client.isResized = false;
                                                                                                                        }

                                                                                                                        if(class43.method612() == 1) {
                                                                                                                           class160.clientInstance.method832(765, 503);
                                                                                                                        } else {
                                                                                                                           class160.clientInstance.method832(7680, 2160);
                                                                                                                        }

                                                                                                                        if(Client.gameState >= 25) {
                                                                                                                           ISAACCipher.method3638();
                                                                                                                        }
                                                                                                                     }

                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 5308) {
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = class222.preferences.screenType;
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 != 5309) {
                                                                                                                     var35 = 2;
                                                                                                                  } else {
                                                                                                                     var31 = class82.intStack[--class82.intStackSize];
                                                                                                                     if(var31 == 1 || var31 == 2) {
                                                                                                                        class222.preferences.screenType = var31;
                                                                                                                        World.method1616();
                                                                                                                     }

                                                                                                                     var35 = 1;
                                                                                                                  }

                                                                                                                  var14 = var35;
                                                                                                               } else if(var9 < 5600) {
                                                                                                                  var14 = class5.method15(var9, var3, var61);
                                                                                                               } else if(var9 < 5700) {
                                                                                                                  if(var9 == 5630) {
                                                                                                                     Client.field1084 = 250;
                                                                                                                     var35 = 1;
                                                                                                                  } else {
                                                                                                                     var35 = 2;
                                                                                                                  }

                                                                                                                  var14 = var35;
                                                                                                               } else if(var9 < 6300) {
                                                                                                                  if(var9 == 6200) {
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     Client.field1107 = (short)class82.intStack[class82.intStackSize];
                                                                                                                     if(Client.field1107 <= 0) {
                                                                                                                        Client.field1107 = 256;
                                                                                                                     }

                                                                                                                     Client.field1108 = (short)class82.intStack[class82.intStackSize + 1];
                                                                                                                     if(Client.field1108 <= 0) {
                                                                                                                        Client.field1108 = 205;
                                                                                                                     }

                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 6201) {
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     Client.field1046 = (short)class82.intStack[class82.intStackSize];
                                                                                                                     if(Client.field1046 <= 0) {
                                                                                                                        Client.field1046 = 256;
                                                                                                                     }

                                                                                                                     Client.field1110 = (short)class82.intStack[class82.intStackSize + 1];
                                                                                                                     if(Client.field1110 <= 0) {
                                                                                                                        Client.field1110 = 320;
                                                                                                                     }

                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 6202) {
                                                                                                                     class82.intStackSize -= 4;
                                                                                                                     Client.field1111 = (short)class82.intStack[class82.intStackSize];
                                                                                                                     if(Client.field1111 <= 0) {
                                                                                                                        Client.field1111 = 1;
                                                                                                                     }

                                                                                                                     Client.field1112 = (short)class82.intStack[class82.intStackSize + 1];
                                                                                                                     if(Client.field1112 <= 0) {
                                                                                                                        Client.field1112 = 32767;
                                                                                                                     } else if(Client.field1112 < Client.field1111) {
                                                                                                                        Client.field1112 = Client.field1111;
                                                                                                                     }

                                                                                                                     Client.field1113 = (short)class82.intStack[class82.intStackSize + 2];
                                                                                                                     if(Client.field1113 <= 0) {
                                                                                                                        Client.field1113 = 1;
                                                                                                                     }

                                                                                                                     Client.field948 = (short)class82.intStack[class82.intStackSize + 3];
                                                                                                                     if(Client.field948 <= 0) {
                                                                                                                        Client.field948 = 32767;
                                                                                                                     } else if(Client.field948 < Client.field1113) {
                                                                                                                        Client.field948 = Client.field1113;
                                                                                                                     }

                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 6203) {
                                                                                                                     if(Client.field980 != null) {
                                                                                                                        Player.method1159(0, 0, Client.field980.width, Client.field980.height, false);
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = Client.viewportHeight;
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = Client.viewportWidth;
                                                                                                                     } else {
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                        class82.intStack[++class82.intStackSize - 1] = -1;
                                                                                                                     }

                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 6204) {
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = Client.field1046;
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = Client.field1110;
                                                                                                                     var35 = 1;
                                                                                                                  } else if(var9 == 6205) {
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = Client.field1107;
                                                                                                                     class82.intStack[++class82.intStackSize - 1] = Client.field1108;
                                                                                                                     var35 = 1;
                                                                                                                  } else {
                                                                                                                     var35 = 2;
                                                                                                                  }

                                                                                                                  var14 = var35;
                                                                                                               } else if(var9 < 6600) {
                                                                                                                  var14 = class64.method1102(var9, var3, var61);
                                                                                                               } else if(var9 < 6700) {
                                                                                                                  var14 = class60.method1036(var9, var3, var61);
                                                                                                               } else {
                                                                                                                  var14 = 2;
                                                                                                               }
                                                                                                            }
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
         } catch (Exception var50) {
            StringBuilder var49 = new StringBuilder(30);
            var49.append("").append(var3.hash).append(" ");

            for(var28 = class82.scriptStackCount - 1; var28 >= 0; --var28) {
               var49.append("").append(class82.scriptStack[var28].invokedFromScript.hash).append(" ");
            }

            var49.append("").append(var53);
            Bounds.method5132(var49.toString(), var50);
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "2099841608"
   )
   static void method8(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(class94.method1810(World.worldList[var9], var8, var2, var3, var4, var5) <= 0) {
               World var10 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var10;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method8(var0, var7 - 1, var2, var3, var4, var5);
         method8(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "50704554"
   )
   public static void method9() {
      Spotanim.spotanims.reset();
      Spotanim.SpotAnimationDefinition_cachedModels.reset();
   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1978701351"
   )
   static final void method4(int var0, int var1, int var2, int var3) {
      Client.overheadTextCount = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class94.playerIndexesCount;
      int[] var7 = class94.playerIndices;

      int var8;
      for(var8 = 0; var8 < var6 + Client.npcIndexesCount; ++var8) {
         Object var9;
         if(var8 < var6) {
            var9 = Client.cachedPlayers[var7[var8]];
            if(var7[var8] == Client.field974) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var9 = Client.cachedNPCs[Client.npcIndices[var8 - var6]];
         }

         GrandExchangeEvents.draw2DExtras((Actor)var9, var8, var0, var1, var2, var3);
      }

      if(var4) {
         GrandExchangeEvents.draw2DExtras(Client.cachedPlayers[Client.field974], var5, var0, var1, var2, var3);
      }

      for(var8 = 0; var8 < Client.overheadTextCount; ++var8) {
         int var18 = Client.overheadTextsX[var8];
         int var10 = Client.overheadTextsY[var8];
         int var11 = Client.overheadTextsOffsetX[var8];
         int var12 = Client.overheadTextsOffsetY[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var14 = 0; var14 < var8; ++var14) {
               if(var10 + 2 > Client.overheadTextsY[var14] - Client.overheadTextsOffsetY[var14] && var10 - var12 < Client.overheadTextsY[var14] + 2 && var18 - var11 < Client.overheadTextsOffsetX[var14] + Client.overheadTextsX[var14] && var18 + var11 > Client.overheadTextsX[var14] - Client.overheadTextsOffsetX[var14] && Client.overheadTextsY[var14] - Client.overheadTextsOffsetY[var14] < var10) {
                  var10 = Client.overheadTextsY[var14] - Client.overheadTextsOffsetY[var14];
                  var13 = true;
               }
            }
         }

         Client.screenX = Client.overheadTextsX[var8];
         Client.screenY = Client.overheadTextsY[var8] = var10;
         String var19 = Client.overheadTexts[var8];
         if(Client.field1017 == 0) {
            int var15 = 16776960;
            if(Client.field1114[var8] < 6) {
               var15 = Client.field1070[Client.field1114[var8]];
            }

            if(Client.field1114[var8] == 6) {
               var15 = Client.field919 % 20 < 10?16711680:16776960;
            }

            if(Client.field1114[var8] == 7) {
               var15 = Client.field919 % 20 < 10?255:'\uffff';
            }

            if(Client.field1114[var8] == 8) {
               var15 = Client.field919 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(Client.field1114[var8] == 9) {
               var16 = 150 - Client.overheadTextsCyclesRemaining[var8];
               if(var16 < 50) {
                  var15 = var16 * 1280 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16776960 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = (var16 - 100) * 5 + 65280;
               }
            }

            if(Client.field1114[var8] == 10) {
               var16 = 150 - Client.overheadTextsCyclesRemaining[var8];
               if(var16 < 50) {
                  var15 = var16 * 5 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16711935 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = (var16 - 100) * 327680 + 255 - (var16 - 100) * 5;
               }
            }

            if(Client.field1114[var8] == 11) {
               var16 = 150 - Client.overheadTextsCyclesRemaining[var8];
               if(var16 < 50) {
                  var15 = 16777215 - var16 * 327685;
               } else if(var16 < 100) {
                  var15 = (var16 - 50) * 327685 + 65280;
               } else if(var16 < 150) {
                  var15 = 16777215 - (var16 - 100) * 327680;
               }
            }

            if(Client.field955[var8] == 0) {
               class36.fontBold12.drawTextCentered(var19, var0 + Client.screenX, Client.screenY + var1, var15, 0);
            }

            if(Client.field955[var8] == 1) {
               class36.fontBold12.method4955(var19, var0 + Client.screenX, Client.screenY + var1, var15, 0, Client.field919);
            }

            if(Client.field955[var8] == 2) {
               class36.fontBold12.method4956(var19, var0 + Client.screenX, Client.screenY + var1, var15, 0, Client.field919);
            }

            if(Client.field955[var8] == 3) {
               class36.fontBold12.method4941(var19, var0 + Client.screenX, Client.screenY + var1, var15, 0, Client.field919, 150 - Client.overheadTextsCyclesRemaining[var8]);
            }

            if(Client.field955[var8] == 4) {
               var16 = (150 - Client.overheadTextsCyclesRemaining[var8]) * (class36.fontBold12.getTextWidth(var19) + 100) / 150;
               Rasterizer2D.setInnerDrawRegion(var0 + Client.screenX - 50, var1, var0 + Client.screenX + 50, var3 + var1);
               class36.fontBold12.method4950(var19, var0 + Client.screenX + 50 - var16, Client.screenY + var1, var15, 0);
               Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
            }

            if(Client.field955[var8] == 5) {
               var16 = 150 - Client.overheadTextsCyclesRemaining[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               Rasterizer2D.setInnerDrawRegion(var0, Client.screenY + var1 - class36.fontBold12.verticalSpace - 1, var0 + var2, Client.screenY + var1 + 5);
               class36.fontBold12.drawTextCentered(var19, var0 + Client.screenX, var17 + Client.screenY + var1, var15, 0);
               Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            class36.fontBold12.drawTextCentered(var19, var0 + Client.screenX, Client.screenY + var1, 16776960, 0);
         }
      }

   }
}
