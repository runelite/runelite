import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class64 {
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = 99733265
   )
   static int field761;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lbi;IB)V",
      garbageValue = "5"
   )
   static void method1147(ScriptEvent var0, int var1) {
      Object[] var2 = var0.field791;
      Script var3;
      int var20;
      if(method1146(var0.field796)) {
         class48.field587 = (class47)var2[0];
         Area var4 = Area.field3358[class48.field587.field578];
         var3 = GameObject.method3004(var0.field796, var4.field3352, var4.field3369);
      } else {
         var20 = ((Integer)var2[0]).intValue();
         Script var6 = (Script)Script.field1445.get((long)var20);
         Script var5;
         if(var6 != null) {
            var5 = var6;
         } else {
            byte[] var29 = class43.indexScripts.getConfigData(var20, 0);
            if(var29 == null) {
               var5 = null;
            } else {
               var6 = class156.method3073(var29);
               Script.field1445.put(var6, (long)var20);
               var5 = var6;
            }
         }

         var3 = var5;
      }

      if(var3 != null) {
         class56.intStackSize = 0;
         class24.scriptStringStackSize = 0;
         var20 = -1;
         int[] var33 = var3.instructions;
         int[] var34 = var3.intOperands;
         byte var7 = -1;
         class82.scriptStackCount = 0;

         int var10;
         try {
            class82.scriptLocalInts = new int[var3.localIntCount];
            int var8 = 0;
            class82.scriptLocalStrings = new String[var3.localStringCount];
            int var9 = 0;

            int var11;
            String var21;
            for(var10 = 1; var10 < var2.length; ++var10) {
               if(var2[var10] instanceof Integer) {
                  var11 = ((Integer)var2[var10]).intValue();
                  if(var11 == -2147483647) {
                     var11 = var0.field787;
                  }

                  if(var11 == -2147483646) {
                     var11 = var0.field788;
                  }

                  if(var11 == -2147483645) {
                     var11 = var0.widget != null?var0.widget.id:-1;
                  }

                  if(var11 == -2147483644) {
                     var11 = var0.field789;
                  }

                  if(var11 == -2147483643) {
                     var11 = var0.widget != null?var0.widget.index:-1;
                  }

                  if(var11 == -2147483642) {
                     var11 = var0.field790 != null?var0.field790.id:-1;
                  }

                  if(var11 == -2147483641) {
                     var11 = var0.field790 != null?var0.field790.index:-1;
                  }

                  if(var11 == -2147483640) {
                     var11 = var0.field795;
                  }

                  if(var11 == -2147483639) {
                     var11 = var0.field792;
                  }

                  class82.scriptLocalInts[var8++] = var11;
               } else if(var2[var10] instanceof String) {
                  var21 = (String)var2[var10];
                  if(var21.equals("event_opbase")) {
                     var21 = var0.field793;
                  }

                  class82.scriptLocalStrings[var9++] = var21;
               }
            }

            var10 = 0;
            class82.field1263 = var0.field784;

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
                                                                                       label335:
                                                                                       while(true) {
                                                                                          ++var10;
                                                                                          if(var10 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var20;
                                                                                          int var35 = var33[var20];
                                                                                          int var12;
                                                                                          if(var35 < 100) {
                                                                                             if(var35 != 0) {
                                                                                                if(var35 != 1) {
                                                                                                   if(var35 != 2) {
                                                                                                      if(var35 != 3) {
                                                                                                         if(var35 != 6) {
                                                                                                            if(var35 != 7) {
                                                                                                               if(var35 != 8) {
                                                                                                                  if(var35 != 9) {
                                                                                                                     if(var35 != 10) {
                                                                                                                        if(var35 != 21) {
                                                                                                                           if(var35 != 25) {
                                                                                                                              if(var35 != 27) {
                                                                                                                                 if(var35 != 31) {
                                                                                                                                    if(var35 != 32) {
                                                                                                                                       if(var35 != 33) {
                                                                                                                                          if(var35 != 34) {
                                                                                                                                             if(var35 != 35) {
                                                                                                                                                if(var35 != 36) {
                                                                                                                                                   int var16;
                                                                                                                                                   int var23;
                                                                                                                                                   if(var35 != 37) {
                                                                                                                                                      if(var35 != 38) {
                                                                                                                                                         if(var35 != 39) {
                                                                                                                                                            if(var35 != 40) {
                                                                                                                                                               if(var35 != 42) {
                                                                                                                                                                  if(var35 != 43) {
                                                                                                                                                                     if(var35 == 44) {
                                                                                                                                                                        var11 = var34[var20] >> 16;
                                                                                                                                                                        var12 = var34[var20] & 65535;
                                                                                                                                                                        int var28 = class82.intStack[--class56.intStackSize];
                                                                                                                                                                        if(var28 >= 0 && var28 <= 5000) {
                                                                                                                                                                           class82.field1254[var11] = var28;
                                                                                                                                                                           byte var37 = -1;
                                                                                                                                                                           if(var12 == 105) {
                                                                                                                                                                              var37 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var23 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var23 >= var28) {
                                                                                                                                                                                 continue label335;
                                                                                                                                                                              }

                                                                                                                                                                              class82.SHAPE_VERTICES[var11][var23] = var37;
                                                                                                                                                                              ++var23;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var35 == 45) {
                                                                                                                                                                        var11 = var34[var20];
                                                                                                                                                                        var12 = class82.intStack[--class56.intStackSize];
                                                                                                                                                                        if(var12 < 0 || var12 >= class82.field1254[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class82.intStack[++class56.intStackSize - 1] = class82.SHAPE_VERTICES[var11][var12];
                                                                                                                                                                     } else if(var35 == 46) {
                                                                                                                                                                        var11 = var34[var20];
                                                                                                                                                                        class56.intStackSize -= 2;
                                                                                                                                                                        var12 = class82.intStack[class56.intStackSize];
                                                                                                                                                                        if(var12 < 0 || var12 >= class82.field1254[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class82.SHAPE_VERTICES[var11][var12] = class82.intStack[class56.intStackSize + 1];
                                                                                                                                                                     } else if(var35 == 47) {
                                                                                                                                                                        var21 = class1.chatMessages.getVarcString(var34[var20]);
                                                                                                                                                                        if(var21 == null) {
                                                                                                                                                                           var21 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var21;
                                                                                                                                                                     } else if(var35 == 48) {
                                                                                                                                                                        class1.chatMessages.putVarcString(var34[var20], class82.scriptStringStack[--class24.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var35 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        IterableHashTable var41 = var3.switches[var34[var20]];
                                                                                                                                                                        IntegerNode var44 = (IntegerNode)var41.get((long)class82.intStack[--class56.intStackSize]);
                                                                                                                                                                        if(var44 != null) {
                                                                                                                                                                           var20 += var44.value;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     class1.chatMessages.putVarc(var34[var20], class82.intStack[--class56.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class82.intStack[++class56.intStackSize - 1] = class1.chatMessages.getVarc(var34[var20]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var11 = var34[var20];
                                                                                                                                                               Script var36 = (Script)Script.field1445.get((long)var11);
                                                                                                                                                               Script var42;
                                                                                                                                                               if(var36 != null) {
                                                                                                                                                                  var42 = var36;
                                                                                                                                                               } else {
                                                                                                                                                                  byte[] var24 = class43.indexScripts.getConfigData(var11, 0);
                                                                                                                                                                  if(var24 == null) {
                                                                                                                                                                     var42 = null;
                                                                                                                                                                  } else {
                                                                                                                                                                     var36 = class156.method3073(var24);
                                                                                                                                                                     Script.field1445.put(var36, (long)var11);
                                                                                                                                                                     var42 = var36;
                                                                                                                                                                  }
                                                                                                                                                               }

                                                                                                                                                               var36 = var42;
                                                                                                                                                               int[] var43 = new int[var42.localIntCount];
                                                                                                                                                               String[] var38 = new String[var42.localStringCount];

                                                                                                                                                               for(var16 = 0; var16 < var36.intStackCount; ++var16) {
                                                                                                                                                                  var43[var16] = class82.intStack[var16 + (class56.intStackSize - var36.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var16 = 0; var16 < var36.stringStackCount; ++var16) {
                                                                                                                                                                  var38[var16] = class82.scriptStringStack[var16 + (class24.scriptStringStackSize - var36.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class56.intStackSize -= var36.intStackCount;
                                                                                                                                                               class24.scriptStringStackSize -= var36.stringStackCount;
                                                                                                                                                               ScriptState var25 = new ScriptState();
                                                                                                                                                               var25.invokedFromScript = var3;
                                                                                                                                                               var25.invokedFromPc = var20;
                                                                                                                                                               var25.savedLocalInts = class82.scriptLocalInts;
                                                                                                                                                               var25.savedLocalStrings = class82.scriptLocalStrings;
                                                                                                                                                               class82.scriptStack[++class82.scriptStackCount - 1] = var25;
                                                                                                                                                               var3 = var36;
                                                                                                                                                               var33 = var36.instructions;
                                                                                                                                                               var34 = var36.intOperands;
                                                                                                                                                               var20 = -1;
                                                                                                                                                               class82.scriptLocalInts = var43;
                                                                                                                                                               class82.scriptLocalStrings = var38;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --class24.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class56.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var11 = var34[var20];
                                                                                                                                                      class24.scriptStringStackSize -= var11;
                                                                                                                                                      String[] var13 = class82.scriptStringStack;
                                                                                                                                                      int var14 = class24.scriptStringStackSize;
                                                                                                                                                      String var22;
                                                                                                                                                      if(var11 == 0) {
                                                                                                                                                         var22 = "";
                                                                                                                                                      } else if(var11 == 1) {
                                                                                                                                                         String var15 = var13[var14];
                                                                                                                                                         if(var15 == null) {
                                                                                                                                                            var22 = "null";
                                                                                                                                                         } else {
                                                                                                                                                            var22 = var15.toString();
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         var23 = var11 + var14;
                                                                                                                                                         var16 = 0;

                                                                                                                                                         for(int var17 = var14; var17 < var23; ++var17) {
                                                                                                                                                            String var18 = var13[var17];
                                                                                                                                                            if(var18 == null) {
                                                                                                                                                               var16 += 4;
                                                                                                                                                            } else {
                                                                                                                                                               var16 += var18.length();
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         StringBuilder var26 = new StringBuilder(var16);

                                                                                                                                                         for(int var27 = var14; var27 < var23; ++var27) {
                                                                                                                                                            String var19 = var13[var27];
                                                                                                                                                            if(var19 == null) {
                                                                                                                                                               var26.append("null");
                                                                                                                                                            } else {
                                                                                                                                                               var26.append(var19);
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         var22 = var26.toString();
                                                                                                                                                      }

                                                                                                                                                      class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var22;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class82.scriptLocalStrings[var34[var20]] = class82.scriptStringStack[--class24.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class82.scriptStringStack[++class24.scriptStringStackSize - 1] = class82.scriptLocalStrings[var34[var20]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class82.scriptLocalInts[var34[var20]] = class82.intStack[--class56.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class82.intStack[++class56.intStackSize - 1] = class82.scriptLocalInts[var34[var20]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class56.intStackSize -= 2;
                                                                                                                                       if(class82.intStack[class56.intStackSize] >= class82.intStack[class56.intStackSize + 1]) {
                                                                                                                                          var20 += var34[var20];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class56.intStackSize -= 2;
                                                                                                                                    if(class82.intStack[class56.intStackSize] <= class82.intStack[class56.intStackSize + 1]) {
                                                                                                                                       var20 += var34[var20];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var11 = var34[var20];
                                                                                                                                 TextureProvider.method2505(var11, class82.intStack[--class56.intStackSize]);
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var11 = var34[var20];
                                                                                                                              class82.intStack[++class56.intStackSize - 1] = Item.method1849(var11);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class82.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var40 = class82.scriptStack[--class82.scriptStackCount];
                                                                                                                           var3 = var40.invokedFromScript;
                                                                                                                           var33 = var3.instructions;
                                                                                                                           var34 = var3.intOperands;
                                                                                                                           var20 = var40.invokedFromPc;
                                                                                                                           class82.scriptLocalInts = var40.savedLocalInts;
                                                                                                                           class82.scriptLocalStrings = var40.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class56.intStackSize -= 2;
                                                                                                                        if(class82.intStack[class56.intStackSize] > class82.intStack[class56.intStackSize + 1]) {
                                                                                                                           var20 += var34[var20];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class56.intStackSize -= 2;
                                                                                                                     if(class82.intStack[class56.intStackSize] < class82.intStack[class56.intStackSize + 1]) {
                                                                                                                        var20 += var34[var20];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class56.intStackSize -= 2;
                                                                                                                  if(class82.intStack[class56.intStackSize] == class82.intStack[class56.intStackSize + 1]) {
                                                                                                                     var20 += var34[var20];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class56.intStackSize -= 2;
                                                                                                               if(class82.intStack[class56.intStackSize] != class82.intStack[class56.intStackSize + 1]) {
                                                                                                                  var20 += var34[var20];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var20 += var34[var20];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var3.stringOperands[var20];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var11 = var34[var20];
                                                                                                      class218.widgetSettings[var11] = class82.intStack[--class56.intStackSize];
                                                                                                      DynamicObject.method1934(var11);
                                                                                                   }
                                                                                                } else {
                                                                                                   var11 = var34[var20];
                                                                                                   class82.intStack[++class56.intStackSize - 1] = class218.widgetSettings[var11];
                                                                                                }
                                                                                             } else {
                                                                                                class82.intStack[++class56.intStackSize - 1] = var34[var20];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var39;
                                                                                             if(var3.intOperands[var20] == 1) {
                                                                                                var39 = true;
                                                                                             } else {
                                                                                                var39 = false;
                                                                                             }

                                                                                             var12 = class74.method1224(var35, var3, var39);
                                                                                             switch(var12) {
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

            for(var10 = class82.scriptStackCount - 1; var10 >= 0; --var10) {
               var31.append("").append(class82.scriptStack[var10].invokedFromScript.hash).append(" ");
            }

            var31.append("").append(var7);
            class33.method396(var31.toString(), var32);
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lhy;B)Z",
      garbageValue = "-82"
   )
   public static boolean method1146(class226 var0) {
      return class226.field2870 == var0 || class226.field2862 == var0 || class226.field2865 == var0 || class226.field2861 == var0 || class226.field2867 == var0 || class226.field2866 == var0 || class226.field2863 == var0 || class226.field2868 == var0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lko;I)V",
      garbageValue = "-1788215049"
   )
   static final void method1148(IndexedSprite var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < Permission.field3243.length; ++var2) {
         Permission.field3243[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         Permission.field3243[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class34.field466[var5] = (Permission.field3243[var5 - 128] + Permission.field3243[var5 + 1] + Permission.field3243[var5 + 128] + Permission.field3243[var5 - 1]) / 4;
            }
         }

         int[] var8 = Permission.field3243;
         Permission.field3243 = class34.field466;
         class34.field466 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + var0.offsetX + 16;
                  int var6 = var3 + var0.offsetY + 16;
                  int var7 = var5 + (var6 << 7);
                  Permission.field3243[var7] = 0;
               }
            }
         }
      }

   }
}
