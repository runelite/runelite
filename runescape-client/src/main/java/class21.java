import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public class class21 {
   @ObfuscatedName("g")
   static byte[][][] field324;
   @ObfuscatedName("fx")
   @Export("xteaKeys")
   static int[][] xteaKeys;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lby;IB)V",
      garbageValue = "12"
   )
   static void method153(ScriptEvent var0, int var1) {
      Object[] var2 = var0.objs;
      class230 var5 = var0.field779;
      boolean var4 = var5 == class230.field2900 || var5 == class230.field2897 || var5 == class230.field2906 || var5 == class230.field2899 || var5 == class230.field2903 || var5 == class230.field2901 || var5 == class230.field2902 || var5 == class230.field2896;
      Script var3;
      int var9;
      int var10;
      int var11;
      int var22;
      if(var4) {
         class82.field1238 = (class47)var2[0];
         Area var6 = Area.mapAreaType[class82.field1238.field564];
         class230 var8 = var0.field779;
         var9 = var6.field3395;
         var10 = var6.field3398;
         var11 = class48.method720(var9, var8);
         Script var12 = GrandExchangeEvent.method83(var11, var8);
         Script var7;
         if(var12 != null) {
            var7 = var12;
         } else {
            var11 = class180.method3231(var10, var8);
            var12 = GrandExchangeEvent.method83(var11, var8);
            if(var12 != null) {
               var7 = var12;
            } else {
               var7 = null;
            }
         }

         var3 = var7;
      } else {
         var22 = ((Integer)var2[0]).intValue();
         var3 = FriendLoginUpdate.method1043(var22);
      }

      if(var3 != null) {
         class82.intStackSize = 0;
         class35.scriptStringStackSize = 0;
         var22 = -1;
         int[] var34 = var3.instructions;
         int[] var35 = var3.intOperands;
         byte var36 = -1;
         class82.scriptStackCount = 0;

         int var23;
         try {
            class281.scriptLocalInts = new int[var3.localIntCount];
            var10 = 0;
            class82.scriptLocalStrings = new String[var3.localStringCount];
            var11 = 0;

            int var13;
            String var24;
            for(var23 = 1; var23 < var2.length; ++var23) {
               if(var2[var23] instanceof Integer) {
                  var13 = ((Integer)var2[var23]).intValue();
                  if(var13 == -2147483647) {
                     var13 = var0.field771;
                  }

                  if(var13 == -2147483646) {
                     var13 = var0.field772;
                  }

                  if(var13 == -2147483645) {
                     var13 = var0.widget != null?var0.widget.id:-1;
                  }

                  if(var13 == -2147483644) {
                     var13 = var0.field773;
                  }

                  if(var13 == -2147483643) {
                     var13 = var0.widget != null?var0.widget.index:-1;
                  }

                  if(var13 == -2147483642) {
                     var13 = var0.field776 != null?var0.field776.id:-1;
                  }

                  if(var13 == -2147483641) {
                     var13 = var0.field776 != null?var0.field776.index:-1;
                  }

                  if(var13 == -2147483640) {
                     var13 = var0.field768;
                  }

                  if(var13 == -2147483639) {
                     var13 = var0.field775;
                  }

                  class281.scriptLocalInts[var10++] = var13;
               } else if(var2[var23] instanceof String) {
                  var24 = (String)var2[var23];
                  if(var24.equals("event_opbase")) {
                     var24 = var0.string;
                  }

                  class82.scriptLocalStrings[var11++] = var24;
               }
            }

            var23 = 0;
            class82.field1250 = var0.field778;

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
                                                                                       label355:
                                                                                       while(true) {
                                                                                          ++var23;
                                                                                          if(var23 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var22;
                                                                                          var9 = var34[var22];
                                                                                          int var14;
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
                                                                                                                              int var18;
                                                                                                                              int var19;
                                                                                                                              int var20;
                                                                                                                              int var25;
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
                                                                                                                                                                        var13 = var35[var22] >> 16;
                                                                                                                                                                        var14 = var35[var22] & 65535;
                                                                                                                                                                        int var30 = class82.intStack[--class82.intStackSize];
                                                                                                                                                                        if(var30 >= 0 && var30 <= 5000) {
                                                                                                                                                                           class82.field1240[var13] = var30;
                                                                                                                                                                           byte var44 = -1;
                                                                                                                                                                           if(var14 == 105) {
                                                                                                                                                                              var44 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var25 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var25 >= var30) {
                                                                                                                                                                                 continue label355;
                                                                                                                                                                              }

                                                                                                                                                                              class82.SHAPE_VERTICES[var13][var25] = var44;
                                                                                                                                                                              ++var25;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var9 == 45) {
                                                                                                                                                                        var13 = var35[var22];
                                                                                                                                                                        var14 = class82.intStack[--class82.intStackSize];
                                                                                                                                                                        if(var14 < 0 || var14 >= class82.field1240[var13]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class82.intStack[++class82.intStackSize - 1] = class82.SHAPE_VERTICES[var13][var14];
                                                                                                                                                                     } else if(var9 == 46) {
                                                                                                                                                                        var13 = var35[var22];
                                                                                                                                                                        class82.intStackSize -= 2;
                                                                                                                                                                        var14 = class82.intStack[class82.intStackSize];
                                                                                                                                                                        if(var14 < 0 || var14 >= class82.field1240[var13]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class82.SHAPE_VERTICES[var13][var14] = class82.intStack[class82.intStackSize + 1];
                                                                                                                                                                     } else if(var9 == 47) {
                                                                                                                                                                        var24 = NetWriter.chatMessages.getVarcString(var35[var22]);
                                                                                                                                                                        if(var24 == null) {
                                                                                                                                                                           var24 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var24;
                                                                                                                                                                     } else if(var9 == 48) {
                                                                                                                                                                        NetWriter.chatMessages.putVarcString(var35[var22], class82.scriptStringStack[--class35.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var9 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        IterableHashTable var45 = var3.switches[var35[var22]];
                                                                                                                                                                        IntegerNode var47 = (IntegerNode)var45.get((long)class82.intStack[--class82.intStackSize]);
                                                                                                                                                                        if(var47 != null) {
                                                                                                                                                                           var22 += var47.value;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     NetWriter.chatMessages.putVarc(var35[var22], class82.intStack[--class82.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class82.intStack[++class82.intStackSize - 1] = NetWriter.chatMessages.getVarc(var35[var22]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var13 = var35[var22];
                                                                                                                                                               Script var46 = FriendLoginUpdate.method1043(var13);
                                                                                                                                                               int[] var38 = new int[var46.localIntCount];
                                                                                                                                                               String[] var39 = new String[var46.localStringCount];

                                                                                                                                                               for(var25 = 0; var25 < var46.intStackCount; ++var25) {
                                                                                                                                                                  var38[var25] = class82.intStack[var25 + (class82.intStackSize - var46.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var25 = 0; var25 < var46.stringStackCount; ++var25) {
                                                                                                                                                                  var39[var25] = class82.scriptStringStack[var25 + (class35.scriptStringStackSize - var46.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class82.intStackSize -= var46.intStackCount;
                                                                                                                                                               class35.scriptStringStackSize -= var46.stringStackCount;
                                                                                                                                                               ScriptState var41 = new ScriptState();
                                                                                                                                                               var41.invokedFromScript = var3;
                                                                                                                                                               var41.invokedFromPc = var22;
                                                                                                                                                               var41.savedLocalInts = class281.scriptLocalInts;
                                                                                                                                                               var41.savedLocalStrings = class82.scriptLocalStrings;
                                                                                                                                                               class82.scriptStack[++class82.scriptStackCount - 1] = var41;
                                                                                                                                                               var3 = var46;
                                                                                                                                                               var34 = var46.instructions;
                                                                                                                                                               var35 = var46.intOperands;
                                                                                                                                                               var22 = -1;
                                                                                                                                                               class281.scriptLocalInts = var38;
                                                                                                                                                               class82.scriptLocalStrings = var39;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --class35.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class82.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var13 = var35[var22];
                                                                                                                                                      class35.scriptStringStackSize -= var13;
                                                                                                                                                      String[] var37 = class82.scriptStringStack;
                                                                                                                                                      int var26 = class35.scriptStringStackSize;
                                                                                                                                                      String var27;
                                                                                                                                                      if(var13 == 0) {
                                                                                                                                                         var27 = "";
                                                                                                                                                      } else if(var13 == 1) {
                                                                                                                                                         String var40 = var37[var26];
                                                                                                                                                         if(var40 == null) {
                                                                                                                                                            var27 = "null";
                                                                                                                                                         } else {
                                                                                                                                                            var27 = var40.toString();
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         var25 = var26 + var13;
                                                                                                                                                         var18 = 0;

                                                                                                                                                         for(var19 = var26; var19 < var25; ++var19) {
                                                                                                                                                            String var28 = var37[var19];
                                                                                                                                                            if(var28 == null) {
                                                                                                                                                               var18 += 4;
                                                                                                                                                            } else {
                                                                                                                                                               var18 += var28.length();
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         StringBuilder var29 = new StringBuilder(var18);

                                                                                                                                                         for(var20 = var26; var20 < var25; ++var20) {
                                                                                                                                                            String var21 = var37[var20];
                                                                                                                                                            if(var21 == null) {
                                                                                                                                                               var29.append("null");
                                                                                                                                                            } else {
                                                                                                                                                               var29.append(var21);
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         var27 = var29.toString();
                                                                                                                                                      }

                                                                                                                                                      class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var27;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class82.scriptLocalStrings[var35[var22]] = class82.scriptStringStack[--class35.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class82.scriptStringStack[++class35.scriptStringStackSize - 1] = class82.scriptLocalStrings[var35[var22]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class281.scriptLocalInts[var35[var22]] = class82.intStack[--class82.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class82.intStack[++class82.intStackSize - 1] = class281.scriptLocalInts[var35[var22]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class82.intStackSize -= 2;
                                                                                                                                       if(class82.intStack[class82.intStackSize] >= class82.intStack[class82.intStackSize + 1]) {
                                                                                                                                          var22 += var35[var22];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class82.intStackSize -= 2;
                                                                                                                                    if(class82.intStack[class82.intStackSize] <= class82.intStack[class82.intStackSize + 1]) {
                                                                                                                                       var22 += var35[var22];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var13 = var35[var22];
                                                                                                                                 var14 = class82.intStack[--class82.intStackSize];
                                                                                                                                 Varbit var16 = (Varbit)Varbit.varbits.get((long)var13);
                                                                                                                                 Varbit var15;
                                                                                                                                 if(var16 != null) {
                                                                                                                                    var15 = var16;
                                                                                                                                 } else {
                                                                                                                                    byte[] var17 = Varbit.varbit_ref.getConfigData(14, var13);
                                                                                                                                    var16 = new Varbit();
                                                                                                                                    if(var17 != null) {
                                                                                                                                       var16.decode(new Buffer(var17));
                                                                                                                                    }

                                                                                                                                    Varbit.varbits.put(var16, (long)var13);
                                                                                                                                    var15 = var16;
                                                                                                                                 }

                                                                                                                                 var25 = var15.configId;
                                                                                                                                 var18 = var15.leastSignificantBit;
                                                                                                                                 var19 = var15.mostSignificantBit;
                                                                                                                                 var20 = class222.varpsMasks[var19 - var18];
                                                                                                                                 if(var14 < 0 || var14 > var20) {
                                                                                                                                    var14 = 0;
                                                                                                                                 }

                                                                                                                                 var20 <<= var18;
                                                                                                                                 class222.widgetSettings[var25] = class222.widgetSettings[var25] & ~var20 | var14 << var18 & var20;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var13 = var35[var22];
                                                                                                                              class82.intStack[++class82.intStackSize - 1] = class36.getVarbit(var13);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class82.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var43 = class82.scriptStack[--class82.scriptStackCount];
                                                                                                                           var3 = var43.invokedFromScript;
                                                                                                                           var34 = var3.instructions;
                                                                                                                           var35 = var3.intOperands;
                                                                                                                           var22 = var43.invokedFromPc;
                                                                                                                           class281.scriptLocalInts = var43.savedLocalInts;
                                                                                                                           class82.scriptLocalStrings = var43.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class82.intStackSize -= 2;
                                                                                                                        if(class82.intStack[class82.intStackSize] > class82.intStack[class82.intStackSize + 1]) {
                                                                                                                           var22 += var35[var22];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class82.intStackSize -= 2;
                                                                                                                     if(class82.intStack[class82.intStackSize] < class82.intStack[class82.intStackSize + 1]) {
                                                                                                                        var22 += var35[var22];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class82.intStackSize -= 2;
                                                                                                                  if(class82.intStack[class82.intStackSize] == class82.intStack[class82.intStackSize + 1]) {
                                                                                                                     var22 += var35[var22];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class82.intStackSize -= 2;
                                                                                                               if(class82.intStack[class82.intStackSize] != class82.intStack[class82.intStackSize + 1]) {
                                                                                                                  var22 += var35[var22];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var22 += var35[var22];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var3.stringOperands[var22];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var13 = var35[var22];
                                                                                                      class222.widgetSettings[var13] = class82.intStack[--class82.intStackSize];
                                                                                                      class150.method2933(var13);
                                                                                                   }
                                                                                                } else {
                                                                                                   var13 = var35[var22];
                                                                                                   class82.intStack[++class82.intStackSize - 1] = class222.widgetSettings[var13];
                                                                                                }
                                                                                             } else {
                                                                                                class82.intStack[++class82.intStackSize - 1] = var35[var22];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var42;
                                                                                             if(var3.intOperands[var22] == 1) {
                                                                                                var42 = true;
                                                                                             } else {
                                                                                                var42 = false;
                                                                                             }

                                                                                             var14 = Coordinates.method4091(var9, var3, var42);
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
         } catch (Exception var33) {
            StringBuilder var32 = new StringBuilder(30);
            var32.append("").append(var3.hash).append(" ");

            for(var23 = class82.scriptStackCount - 1; var23 >= 0; --var23) {
               var32.append("").append(class82.scriptStack[var23].invokedFromScript.hash).append(" ");
            }

            var32.append("").append(var36);
            PendingSpawn.method1461(var32.toString(), var33);
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "39"
   )
   static String method151() {
      return class2.preferences.hideUsername?UnitPriceComparator.method127(class91.username):class91.username;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1356447039"
   )
   public static void method155() {
      Spotanim.spotanims.reset();
      Spotanim.SpotAnimationDefinition_cachedModels.reset();
   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "723919213"
   )
   static final void method154(int var0, int var1) {
      if(Client.hintArrowTargetType == 2) {
         class285.worldToScreen((Client.hintArrowX - class46.baseX << 7) + Client.hintArrowOffsetX, (Client.hintArrowY - Client.baseY << 7) + Client.hintArrowOffsetY, Client.hintArrowType * 2);
         if(Client.screenY > -1 && Client.gameCycle % 20 < 10) {
            RenderOverview.headIconsHint[0].drawAt(var0 + Client.screenY - 12, Client.screenX + var1 - 28);
         }

      }
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "([Lhz;IIIIIIII)V",
      garbageValue = "-1308694813"
   )
   static final void method156(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2887 || class36.getWidgetConfig(var9) != 0 || var9 == Client.field1002 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !Occluder.method2905(var9))) {
            int var10 = var9.relativeX + var6;
            int var11 = var7 + var9.relativeY;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               int var18 = var10 + var9.width;
               int var19 = var11 + var9.height;
               if(var18 < var10) {
                  var16 = var18;
                  var18 = var10;
               }

               if(var19 < var11) {
                  var17 = var19;
                  var19 = var11;
               }

               ++var18;
               ++var19;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var18 < var4?var18:var4;
               var15 = var19 < var5?var19:var5;
            } else {
               var16 = var10 + var9.width;
               var17 = var11 + var9.height;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == Client.field1064) {
               Client.field1009 = true;
               Client.field1010 = var10;
               Client.field1011 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = MouseInput.field679;
               var17 = MouseInput.field682 * -469125321;
               if(MouseInput.mouseLastButton != 0) {
                  var16 = MouseInput.mouseLastPressedX;
                  var17 = MouseInput.mouseLastPressedY;
               }

               boolean var29 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               if(var9.contentType == 1337) {
                  if(!Client.field853 && !Client.isMenuOpen && var29) {
                     class44.method626(var16, var17, var12, var13);
                  }
               } else if(var9.contentType == 1338) {
                  AttackOption.method1678(var9, var10, var11);
               } else {
                  if(var9.contentType == 1400) {
                     class61.renderOverview.method5342(MouseInput.field679, MouseInput.field682 * -469125321, var29, var10, var11, var9.width, var9.height);
                  }

                  if(!Client.isMenuOpen && var29) {
                     if(var9.contentType == 1400) {
                        class61.renderOverview.method5442(var10, var11, var9.width, var9.height, var16, var17);
                     } else {
                        FaceNormal.method2883(var9, var16 - var10, var17 - var11);
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && Occluder.method2905(var9) && var9 != class29.field391) {
                        continue;
                     }

                     method156(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method156(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var25 = (WidgetNode)Client.componentTable.get((long)var9.id);
                     if(var25 != null) {
                        if(var25.owner == 0 && MouseInput.field679 >= var12 && MouseInput.field682 * -469125321 >= var13 && MouseInput.field679 < var14 && MouseInput.field682 * -469125321 < var15 && !Client.isMenuOpen && !Client.field978) {
                           for(ScriptEvent var28 = (ScriptEvent)Client.field1027.getFront(); var28 != null; var28 = (ScriptEvent)Client.field1027.getNext()) {
                              if(var28.boolean1) {
                                 var28.unlink();
                                 var28.widget.field2862 = false;
                              }
                           }

                           if(FriendLoginUpdate.field751 == 0) {
                              Client.field1064 = null;
                              Client.field1002 = null;
                           }

                           if(!Client.isMenuOpen) {
                              OwnWorldComparator.method1102();
                           }
                        }

                        DecorativeObject.method2907(var25.id, var12, var13, var14, var15, var10, var11);
                     }
                  }

                  if(var9.hasScript) {
                     ScriptEvent var32;
                     if(!var9.noClickThrough) {
                        if(var9.field2888 && MouseInput.field679 >= var12 && MouseInput.field682 * -469125321 >= var13 && MouseInput.field679 < var14 && MouseInput.field682 * -469125321 < var15) {
                           for(var32 = (ScriptEvent)Client.field1027.getFront(); var32 != null; var32 = (ScriptEvent)Client.field1027.getNext()) {
                              if(var32.boolean1 && var32.widget.scrollListener == var32.objs) {
                                 var32.unlink();
                              }
                           }
                        }
                     } else if(MouseInput.field679 >= var12 && MouseInput.field682 * -469125321 >= var13 && MouseInput.field679 < var14 && MouseInput.field682 * -469125321 < var15) {
                        for(var32 = (ScriptEvent)Client.field1027.getFront(); var32 != null; var32 = (ScriptEvent)Client.field1027.getNext()) {
                           if(var32.boolean1) {
                              var32.unlink();
                              var32.widget.field2862 = false;
                           }
                        }

                        if(FriendLoginUpdate.field751 == 0) {
                           Client.field1064 = null;
                           Client.field1002 = null;
                        }

                        if(!Client.isMenuOpen) {
                           OwnWorldComparator.method1102();
                        }
                     }

                     if(MouseInput.field679 >= var12 && MouseInput.field682 * -469125321 >= var13 && MouseInput.field679 < var14 && MouseInput.field682 * -469125321 < var15) {
                        var29 = true;
                     } else {
                        var29 = false;
                     }

                     boolean var30 = false;
                     if((MouseInput.mouseCurrentButton == 1 || !class34.field455 && MouseInput.mouseCurrentButton == 4) && var29) {
                        var30 = true;
                     }

                     boolean var20 = false;
                     if((MouseInput.mouseLastButton == 1 || !class34.field455 && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= var12 && MouseInput.mouseLastPressedY >= var13 && MouseInput.mouseLastPressedX < var14 && MouseInput.mouseLastPressedY < var15) {
                        var20 = true;
                     }

                     if(var20) {
                        WorldMapData.method341(var9, MouseInput.mouseLastPressedX - var10, MouseInput.mouseLastPressedY - var11);
                     }

                     if(var9.contentType == 1400) {
                        class61.renderOverview.method5343(MouseInput.field679, MouseInput.field682 * -469125321, var29 & var30, var29 & var20);
                     }

                     int var22;
                     if(Client.field1064 != null && var9 != Client.field1064 && var29) {
                        var22 = class36.getWidgetConfig(var9);
                        boolean var21 = (var22 >> 20 & 1) != 0;
                        if(var21) {
                           Client.field1005 = var9;
                        }
                     }

                     if(var9 == Client.field1002) {
                        Client.field992 = true;
                        Client.field1007 = var10;
                        Client.field950 = var11;
                     }

                     if(var9.field2887) {
                        ScriptEvent var26;
                        if(var29 && Client.mouseWheelRotation != 0 && var9.scrollListener != null) {
                           var26 = new ScriptEvent();
                           var26.boolean1 = true;
                           var26.widget = var9;
                           var26.field772 = Client.mouseWheelRotation;
                           var26.objs = var9.scrollListener;
                           Client.field1027.addFront(var26);
                        }

                        if(Client.field1064 != null || class39.field506 != null || Client.isMenuOpen) {
                           var20 = false;
                           var30 = false;
                           var29 = false;
                        }

                        if(!var9.field2762 && var20) {
                           var9.field2762 = true;
                           if(var9.field2847 != null) {
                              var26 = new ScriptEvent();
                              var26.boolean1 = true;
                              var26.widget = var9;
                              var26.field771 = MouseInput.mouseLastPressedX - var10;
                              var26.field772 = MouseInput.mouseLastPressedY - var11;
                              var26.objs = var9.field2847;
                              Client.field1027.addFront(var26);
                           }
                        }

                        if(var9.field2762 && var30 && var9.field2842 != null) {
                           var26 = new ScriptEvent();
                           var26.boolean1 = true;
                           var26.widget = var9;
                           var26.field771 = MouseInput.field679 - var10;
                           var26.field772 = MouseInput.field682 * -469125321 - var11;
                           var26.objs = var9.field2842;
                           Client.field1027.addFront(var26);
                        }

                        if(var9.field2762 && !var30) {
                           var9.field2762 = false;
                           if(var9.field2843 != null) {
                              var26 = new ScriptEvent();
                              var26.boolean1 = true;
                              var26.widget = var9;
                              var26.field771 = MouseInput.field679 - var10;
                              var26.field772 = MouseInput.field682 * -469125321 - var11;
                              var26.objs = var9.field2843;
                              Client.field1029.addFront(var26);
                           }
                        }

                        if(var30 && var9.field2873 != null) {
                           var26 = new ScriptEvent();
                           var26.boolean1 = true;
                           var26.widget = var9;
                           var26.field771 = MouseInput.field679 - var10;
                           var26.field772 = MouseInput.field682 * -469125321 - var11;
                           var26.objs = var9.field2873;
                           Client.field1027.addFront(var26);
                        }

                        if(!var9.field2862 && var29) {
                           var9.field2862 = true;
                           if(var9.mouseEnterListener != null) {
                              var26 = new ScriptEvent();
                              var26.boolean1 = true;
                              var26.widget = var9;
                              var26.field771 = MouseInput.field679 - var10;
                              var26.field772 = MouseInput.field682 * -469125321 - var11;
                              var26.objs = var9.mouseEnterListener;
                              Client.field1027.addFront(var26);
                           }
                        }

                        if(var9.field2862 && var29 && var9.mouseHoverListener != null) {
                           var26 = new ScriptEvent();
                           var26.boolean1 = true;
                           var26.widget = var9;
                           var26.field771 = MouseInput.field679 - var10;
                           var26.field772 = MouseInput.field682 * -469125321 - var11;
                           var26.objs = var9.mouseHoverListener;
                           Client.field1027.addFront(var26);
                        }

                        if(var9.field2862 && !var29) {
                           var9.field2862 = false;
                           if(var9.mouseExitListener != null) {
                              var26 = new ScriptEvent();
                              var26.boolean1 = true;
                              var26.widget = var9;
                              var26.field771 = MouseInput.field679 - var10;
                              var26.field772 = MouseInput.field682 * -469125321 - var11;
                              var26.objs = var9.mouseExitListener;
                              Client.field1029.addFront(var26);
                           }
                        }

                        if(var9.renderListener != null) {
                           var26 = new ScriptEvent();
                           var26.widget = var9;
                           var26.objs = var9.renderListener;
                           Client.field1028.addFront(var26);
                        }

                        int var23;
                        ScriptEvent var24;
                        int var31;
                        if(var9.configListenerArgs != null && Client.field1015 > var9.field2863) {
                           if(var9.configTriggers != null && Client.field1015 - var9.field2863 <= 32) {
                              label745:
                              for(var31 = var9.field2863; var31 < Client.field1015; ++var31) {
                                 var22 = Client.field988[var31 & 31];

                                 for(var23 = 0; var23 < var9.configTriggers.length; ++var23) {
                                    if(var22 == var9.configTriggers[var23]) {
                                       var24 = new ScriptEvent();
                                       var24.widget = var9;
                                       var24.objs = var9.configListenerArgs;
                                       Client.field1027.addFront(var24);
                                       break label745;
                                    }
                                 }
                              }
                           } else {
                              var26 = new ScriptEvent();
                              var26.widget = var9;
                              var26.objs = var9.configListenerArgs;
                              Client.field1027.addFront(var26);
                           }

                           var9.field2863 = Client.field1015;
                        }

                        if(var9.tableListenerArgs != null && Client.field1017 > var9.field2893) {
                           if(var9.tableModTriggers != null && Client.field1017 - var9.field2893 <= 32) {
                              label721:
                              for(var31 = var9.field2893; var31 < Client.field1017; ++var31) {
                                 var22 = Client.interfaceItemTriggers[var31 & 31];

                                 for(var23 = 0; var23 < var9.tableModTriggers.length; ++var23) {
                                    if(var22 == var9.tableModTriggers[var23]) {
                                       var24 = new ScriptEvent();
                                       var24.widget = var9;
                                       var24.objs = var9.tableListenerArgs;
                                       Client.field1027.addFront(var24);
                                       break label721;
                                    }
                                 }
                              }
                           } else {
                              var26 = new ScriptEvent();
                              var26.widget = var9;
                              var26.objs = var9.tableListenerArgs;
                              Client.field1027.addFront(var26);
                           }

                           var9.field2893 = Client.field1017;
                        }

                        if(var9.skillListenerArgs != null && Client.field922 > var9.field2885) {
                           if(var9.skillTriggers != null && Client.field922 - var9.field2885 <= 32) {
                              label697:
                              for(var31 = var9.field2885; var31 < Client.field922; ++var31) {
                                 var22 = Client.field1018[var31 & 31];

                                 for(var23 = 0; var23 < var9.skillTriggers.length; ++var23) {
                                    if(var22 == var9.skillTriggers[var23]) {
                                       var24 = new ScriptEvent();
                                       var24.widget = var9;
                                       var24.objs = var9.skillListenerArgs;
                                       Client.field1027.addFront(var24);
                                       break label697;
                                    }
                                 }
                              }
                           } else {
                              var26 = new ScriptEvent();
                              var26.widget = var9;
                              var26.objs = var9.skillListenerArgs;
                              Client.field1027.addFront(var26);
                           }

                           var9.field2885 = Client.field922;
                        }

                        if(Client.chatCycle > var9.field2886 && var9.field2861 != null) {
                           var26 = new ScriptEvent();
                           var26.widget = var9;
                           var26.objs = var9.field2861;
                           Client.field1027.addFront(var26);
                        }

                        if(Client.field1041 > var9.field2886 && var9.field2891 != null) {
                           var26 = new ScriptEvent();
                           var26.widget = var9;
                           var26.objs = var9.field2891;
                           Client.field1027.addFront(var26);
                        }

                        if(Client.field1022 > var9.field2886 && var9.field2864 != null) {
                           var26 = new ScriptEvent();
                           var26.widget = var9;
                           var26.objs = var9.field2864;
                           Client.field1027.addFront(var26);
                        }

                        if(Client.field1050 > var9.field2886 && var9.field2869 != null) {
                           var26 = new ScriptEvent();
                           var26.widget = var9;
                           var26.objs = var9.field2869;
                           Client.field1027.addFront(var26);
                        }

                        if(Client.field1024 > var9.field2886 && var9.field2801 != null) {
                           var26 = new ScriptEvent();
                           var26.widget = var9;
                           var26.objs = var9.field2801;
                           Client.field1027.addFront(var26);
                        }

                        if(Client.field1025 > var9.field2886 && var9.field2865 != null) {
                           var26 = new ScriptEvent();
                           var26.widget = var9;
                           var26.objs = var9.field2865;
                           Client.field1027.addFront(var26);
                        }

                        var9.field2886 = Client.cycleCntr;
                        if(var9.field2751 != null) {
                           for(var31 = 0; var31 < Client.field1049; ++var31) {
                              ScriptEvent var27 = new ScriptEvent();
                              var27.widget = var9;
                              var27.field768 = Client.field1051[var31];
                              var27.field775 = Client.field1085[var31];
                              var27.objs = var9.field2751;
                              Client.field1027.addFront(var27);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.field1064 == null && class39.field506 == null && !Client.isMenuOpen) {
                     if((var9.field2822 >= 0 || var9.field2786 != 0) && MouseInput.field679 >= var12 && MouseInput.field682 * -469125321 >= var13 && MouseInput.field679 < var14 && MouseInput.field682 * -469125321 < var15) {
                        if(var9.field2822 >= 0) {
                           class29.field391 = var0[var9.field2822];
                        } else {
                           class29.field391 = var9;
                        }
                     }

                     if(var9.type == 8 && MouseInput.field679 >= var12 && MouseInput.field682 * -469125321 >= var13 && MouseInput.field679 < var14 && MouseInput.field682 * -469125321 < var15) {
                        ContextMenuRow.field1299 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        class94.method1767(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, MouseInput.field679, MouseInput.field682 * -469125321);
                     }
                  }
               }
            }
         }
      }

   }
}
