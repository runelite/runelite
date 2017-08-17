import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class40 {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lal;"
   )
   public static final class40 field559;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lal;"
   )
   public static final class40 field550;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lal;"
   )
   public static final class40 field552;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lal;"
   )
   public static final class40 field554;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lal;"
   )
   public static final class40 field553;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   public static Buffer field555;
   @ObfuscatedName("g")
   public final String field551;

   static {
      field559 = new class40("details");
      field550 = new class40("compositemap");
      field554 = new class40("compositetexture");
      field552 = new class40("area");
      field553 = new class40("labels");
   }

   class40(String var1) {
      this.field551 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lbm;II)V",
      garbageValue = "1536525254"
   )
   static void method567(ScriptEvent var0, int var1) {
      Object[] var2 = var0.field856;
      class220 var5 = var0.field863;
      boolean var4 = var5 == class220.field2798 || var5 == class220.field2792 || var5 == class220.field2790 || var5 == class220.field2791 || var5 == class220.field2789 || var5 == class220.field2793 || var5 == class220.field2794 || var5 == class220.field2795;
      Script var3;
      int var22;
      if(var4) {
         SoundTask.field1666 = (class47)var2[0];
         Area var6 = Area.field3284[SoundTask.field1666.field611];
         var3 = class15.method97(var0.field863, var6.field3287, var6.field3296);
      } else {
         var22 = ((Integer)var2[0]).intValue();
         var3 = Preferences.method1597(var22);
      }

      if(var3 != null) {
         class84.intStackSize = 0;
         class91.scriptStringStackSize = 0;
         var22 = -1;
         int[] var7 = var3.instructions;
         int[] var8 = var3.intOperands;
         byte var9 = -1;
         class84.scriptStackCount = 0;

         int var12;
         try {
            class84.scriptLocalInts = new int[var3.localIntCount];
            int var10 = 0;
            class84.scriptLocalStrings = new String[var3.localStringCount];
            int var11 = 0;

            int var13;
            String var23;
            for(var12 = 1; var12 < var2.length; ++var12) {
               if(var2[var12] instanceof Integer) {
                  var13 = ((Integer)var2[var12]).intValue();
                  if(var13 == -2147483647) {
                     var13 = var0.field857;
                  }

                  if(var13 == -2147483646) {
                     var13 = var0.field858;
                  }

                  if(var13 == -2147483645) {
                     var13 = var0.widget != null?var0.widget.id:-1;
                  }

                  if(var13 == -2147483644) {
                     var13 = var0.field859;
                  }

                  if(var13 == -2147483643) {
                     var13 = var0.widget != null?var0.widget.index:-1;
                  }

                  if(var13 == -2147483642) {
                     var13 = var0.field860 != null?var0.field860.id:-1;
                  }

                  if(var13 == -2147483641) {
                     var13 = var0.field860 != null?var0.field860.index:-1;
                  }

                  if(var13 == -2147483640) {
                     var13 = var0.field861;
                  }

                  if(var13 == -2147483639) {
                     var13 = var0.field862;
                  }

                  class84.scriptLocalInts[var10++] = var13;
               } else if(var2[var12] instanceof String) {
                  var23 = (String)var2[var12];
                  if(var23.equals("event_opbase")) {
                     var23 = var0.field854;
                  }

                  class84.scriptLocalStrings[var11++] = var23;
               }
            }

            var12 = 0;
            class84.field1349 = var0.field864;

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
                                                                                       label337:
                                                                                       while(true) {
                                                                                          ++var12;
                                                                                          if(var12 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var22;
                                                                                          int var33 = var7[var22];
                                                                                          int var14;
                                                                                          if(var33 < 100) {
                                                                                             if(var33 != 0) {
                                                                                                if(var33 != 1) {
                                                                                                   if(var33 != 2) {
                                                                                                      if(var33 != 3) {
                                                                                                         if(var33 != 6) {
                                                                                                            if(var33 != 7) {
                                                                                                               if(var33 != 8) {
                                                                                                                  if(var33 != 9) {
                                                                                                                     if(var33 != 10) {
                                                                                                                        if(var33 != 21) {
                                                                                                                           if(var33 != 25) {
                                                                                                                              if(var33 != 27) {
                                                                                                                                 if(var33 != 31) {
                                                                                                                                    if(var33 != 32) {
                                                                                                                                       if(var33 != 33) {
                                                                                                                                          if(var33 != 34) {
                                                                                                                                             if(var33 != 35) {
                                                                                                                                                if(var33 != 36) {
                                                                                                                                                   int var25;
                                                                                                                                                   if(var33 != 37) {
                                                                                                                                                      if(var33 != 38) {
                                                                                                                                                         if(var33 != 39) {
                                                                                                                                                            if(var33 != 40) {
                                                                                                                                                               if(var33 != 42) {
                                                                                                                                                                  if(var33 != 43) {
                                                                                                                                                                     if(var33 == 44) {
                                                                                                                                                                        var13 = var8[var22] >> 16;
                                                                                                                                                                        var14 = var8[var22] & '\uffff';
                                                                                                                                                                        int var29 = class84.intStack[--class84.intStackSize];
                                                                                                                                                                        if(var29 >= 0 && var29 <= 5000) {
                                                                                                                                                                           class84.field1344[var13] = var29;
                                                                                                                                                                           byte var35 = -1;
                                                                                                                                                                           if(var14 == 105) {
                                                                                                                                                                              var35 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var25 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var25 >= var29) {
                                                                                                                                                                                 continue label337;
                                                                                                                                                                              }

                                                                                                                                                                              class84.SHAPE_VERTICES[var13][var25] = var35;
                                                                                                                                                                              ++var25;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var33 == 45) {
                                                                                                                                                                        var13 = var8[var22];
                                                                                                                                                                        var14 = class84.intStack[--class84.intStackSize];
                                                                                                                                                                        if(var14 < 0 || var14 >= class84.field1344[var13]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class84.intStack[++class84.intStackSize - 1] = class84.SHAPE_VERTICES[var13][var14];
                                                                                                                                                                     } else if(var33 == 46) {
                                                                                                                                                                        var13 = var8[var22];
                                                                                                                                                                        class84.intStackSize -= 2;
                                                                                                                                                                        var14 = class84.intStack[class84.intStackSize];
                                                                                                                                                                        if(var14 < 0 || var14 >= class84.field1344[var13]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class84.SHAPE_VERTICES[var13][var14] = class84.intStack[class84.intStackSize + 1];
                                                                                                                                                                     } else if(var33 == 47) {
                                                                                                                                                                        var23 = class156.chatMessages.getVarcString(var8[var22]);
                                                                                                                                                                        if(var23 == null) {
                                                                                                                                                                           var23 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var23;
                                                                                                                                                                     } else if(var33 == 48) {
                                                                                                                                                                        class156.chatMessages.putVarcString(var8[var22], class84.scriptStringStack[--class91.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var33 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        IterableHashTable var39 = var3.switches[var8[var22]];
                                                                                                                                                                        IntegerNode var41 = (IntegerNode)var39.get((long)class84.intStack[--class84.intStackSize]);
                                                                                                                                                                        if(var41 != null) {
                                                                                                                                                                           var22 += var41.value;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     class156.chatMessages.putVarc(var8[var22], class84.intStack[--class84.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class84.intStack[++class84.intStackSize - 1] = class156.chatMessages.getVarc(var8[var22]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var13 = var8[var22];
                                                                                                                                                               Script var40 = Preferences.method1597(var13);
                                                                                                                                                               int[] var34 = new int[var40.localIntCount];
                                                                                                                                                               String[] var26 = new String[var40.localStringCount];

                                                                                                                                                               for(var25 = 0; var25 < var40.intStackCount; ++var25) {
                                                                                                                                                                  var34[var25] = class84.intStack[var25 + (class84.intStackSize - var40.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var25 = 0; var25 < var40.stringStackCount; ++var25) {
                                                                                                                                                                  var26[var25] = class84.scriptStringStack[var25 + (class91.scriptStringStackSize - var40.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class84.intStackSize -= var40.intStackCount;
                                                                                                                                                               class91.scriptStringStackSize -= var40.stringStackCount;
                                                                                                                                                               ScriptState var36 = new ScriptState();
                                                                                                                                                               var36.invokedFromScript = var3;
                                                                                                                                                               var36.invokedFromPc = var22;
                                                                                                                                                               var36.savedLocalInts = class84.scriptLocalInts;
                                                                                                                                                               var36.savedLocalStrings = class84.scriptLocalStrings;
                                                                                                                                                               class84.scriptStack[++class84.scriptStackCount - 1] = var36;
                                                                                                                                                               var3 = var40;
                                                                                                                                                               var7 = var40.instructions;
                                                                                                                                                               var8 = var40.intOperands;
                                                                                                                                                               var22 = -1;
                                                                                                                                                               class84.scriptLocalInts = var34;
                                                                                                                                                               class84.scriptLocalStrings = var26;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --class91.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class84.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var13 = var8[var22];
                                                                                                                                                      class91.scriptStringStackSize -= var13;
                                                                                                                                                      String[] var15 = class84.scriptStringStack;
                                                                                                                                                      int var16 = class91.scriptStringStackSize;
                                                                                                                                                      String var24;
                                                                                                                                                      if(var13 == 0) {
                                                                                                                                                         var24 = "";
                                                                                                                                                      } else if(var13 == 1) {
                                                                                                                                                         String var17 = var15[var16];
                                                                                                                                                         if(var17 == null) {
                                                                                                                                                            var24 = "null";
                                                                                                                                                         } else {
                                                                                                                                                            var24 = var17.toString();
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         var25 = var16 + var13;
                                                                                                                                                         int var18 = 0;

                                                                                                                                                         for(int var19 = var16; var19 < var25; ++var19) {
                                                                                                                                                            String var20 = var15[var19];
                                                                                                                                                            if(var20 == null) {
                                                                                                                                                               var18 += 4;
                                                                                                                                                            } else {
                                                                                                                                                               var18 += var20.length();
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         StringBuilder var27 = new StringBuilder(var18);

                                                                                                                                                         for(int var28 = var16; var28 < var25; ++var28) {
                                                                                                                                                            String var21 = var15[var28];
                                                                                                                                                            if(var21 == null) {
                                                                                                                                                               var27.append("null");
                                                                                                                                                            } else {
                                                                                                                                                               var27.append(var21);
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         var24 = var27.toString();
                                                                                                                                                      }

                                                                                                                                                      class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var24;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class84.scriptLocalStrings[var8[var22]] = class84.scriptStringStack[--class91.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class84.scriptStringStack[++class91.scriptStringStackSize - 1] = class84.scriptLocalStrings[var8[var22]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class84.scriptLocalInts[var8[var22]] = class84.intStack[--class84.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class84.intStack[++class84.intStackSize - 1] = class84.scriptLocalInts[var8[var22]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class84.intStackSize -= 2;
                                                                                                                                       if(class84.intStack[class84.intStackSize] >= class84.intStack[class84.intStackSize + 1]) {
                                                                                                                                          var22 += var8[var22];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class84.intStackSize -= 2;
                                                                                                                                    if(class84.intStack[class84.intStackSize] <= class84.intStack[class84.intStackSize + 1]) {
                                                                                                                                       var22 += var8[var22];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var13 = var8[var22];
                                                                                                                                 class27.method234(var13, class84.intStack[--class84.intStackSize]);
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var13 = var8[var22];
                                                                                                                              class84.intStack[++class84.intStackSize - 1] = BaseVarType.method12(var13);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class84.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var38 = class84.scriptStack[--class84.scriptStackCount];
                                                                                                                           var3 = var38.invokedFromScript;
                                                                                                                           var7 = var3.instructions;
                                                                                                                           var8 = var3.intOperands;
                                                                                                                           var22 = var38.invokedFromPc;
                                                                                                                           class84.scriptLocalInts = var38.savedLocalInts;
                                                                                                                           class84.scriptLocalStrings = var38.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class84.intStackSize -= 2;
                                                                                                                        if(class84.intStack[class84.intStackSize] > class84.intStack[class84.intStackSize + 1]) {
                                                                                                                           var22 += var8[var22];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class84.intStackSize -= 2;
                                                                                                                     if(class84.intStack[class84.intStackSize] < class84.intStack[class84.intStackSize + 1]) {
                                                                                                                        var22 += var8[var22];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class84.intStackSize -= 2;
                                                                                                                  if(class84.intStack[class84.intStackSize] == class84.intStack[class84.intStackSize + 1]) {
                                                                                                                     var22 += var8[var22];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class84.intStackSize -= 2;
                                                                                                               if(class84.intStack[class84.intStackSize] != class84.intStack[class84.intStackSize + 1]) {
                                                                                                                  var22 += var8[var22];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var22 += var8[var22];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var3.stringOperands[var22];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var13 = var8[var22];
                                                                                                      class212.widgetSettings[var13] = class84.intStack[--class84.intStackSize];
                                                                                                      class12.method60(var13);
                                                                                                   }
                                                                                                } else {
                                                                                                   var13 = var8[var22];
                                                                                                   class84.intStack[++class84.intStackSize - 1] = class212.widgetSettings[var13];
                                                                                                }
                                                                                             } else {
                                                                                                class84.intStack[++class84.intStackSize - 1] = var8[var22];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var37;
                                                                                             if(var3.intOperands[var22] == 1) {
                                                                                                var37 = true;
                                                                                             } else {
                                                                                                var37 = false;
                                                                                             }

                                                                                             var14 = VarPlayerType.method4287(var33, var3, var37);
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
         } catch (Exception var32) {
            StringBuilder var31 = new StringBuilder(30);
            var31.append("").append(var3.hash).append(" ");

            for(var12 = class84.scriptStackCount - 1; var12 >= 0; --var12) {
               var31.append("").append(class84.scriptStack[var12].invokedFromScript.hash).append(" ");
            }

            var31.append("").append(var9);
            Varcs.method1853(var31.toString(), var32);
         }
      }
   }
}
