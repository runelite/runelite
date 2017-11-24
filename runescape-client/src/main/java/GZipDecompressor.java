import java.util.zip.Inflater;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
@Implements("GZipDecompressor")
public class GZipDecompressor {
   @ObfuscatedName("d")
   @Export("inflator")
   Inflater inflator;

   public GZipDecompressor() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   GZipDecompressor(int var1, int var2, int var3) {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfr;[BI)V",
      garbageValue = "2086142834"
   )
   @Export("decompress")
   public void decompress(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
         if(this.inflator == null) {
            this.inflator = new Inflater(true);
         }

         try {
            this.inflator.setInput(var1.payload, var1.offset + 10, var1.payload.length - (var1.offset + 8 + 10));
            this.inflator.inflate(var2);
         } catch (Exception var4) {
            this.inflator.reset();
            throw new RuntimeException("");
         }

         this.inflator.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lbx;II)V",
      garbageValue = "-45833708"
   )
   static void method3234(ScriptEvent var0, int var1) {
      Object[] var2 = var0.field797;
      Script var3;
      Script var5;
      int var7;
      int var8;
      int var9;
      int var10;
      Script var12;
      int var16;
      int var18;
      Script var35;
      if(class20.method169(var0.field808)) {
         class28.field380 = (class47)var2[0];
         Area var4 = Area.mapAreaType[class28.field380.field572];
         class226 var6 = var0.field808;
         var7 = var4.field3366;
         var8 = var4.field3384;
         var9 = (var7 << 8) + var6.field2874;
         var12 = (Script)Script.field1441.get((long)(var9 << 16));
         Script var11;
         if(var12 != null) {
            var11 = var12;
         } else {
            String var13 = String.valueOf(var9);
            int var23 = class1.indexScripts.getFile(var13);
            if(var23 == -1) {
               var11 = null;
            } else {
               label576: {
                  byte[] var15 = class1.indexScripts.method4271(var23);
                  if(var15 != null) {
                     if(var15.length <= 1) {
                        var11 = null;
                        break label576;
                     }

                     var12 = class12.method81(var15);
                     if(var12 != null) {
                        Script.field1441.put(var12, (long)(var9 << 16));
                        var11 = var12;
                        break label576;
                     }
                  }

                  var11 = null;
               }
            }
         }

         if(var11 != null) {
            var5 = var11;
         } else {
            var10 = class217.method4099(var8, var6);
            Script var14 = (Script)Script.field1441.get((long)(var10 << 16));
            if(var14 != null) {
               var35 = var14;
            } else {
               String var40 = String.valueOf(var10);
               var16 = class1.indexScripts.getFile(var40);
               if(var16 == -1) {
                  var35 = null;
               } else {
                  label521: {
                     byte[] var17 = class1.indexScripts.method4271(var16);
                     if(var17 != null) {
                        if(var17.length <= 1) {
                           var35 = null;
                           break label521;
                        }

                        var14 = class12.method81(var17);
                        if(var14 != null) {
                           Script.field1441.put(var14, (long)(var10 << 16));
                           var35 = var14;
                           break label521;
                        }
                     }

                     var35 = null;
                  }
               }
            }

            if(var35 != null) {
               var5 = var35;
            } else {
               var5 = null;
            }
         }

         var3 = var5;
      } else {
         var18 = ((Integer)var2[0]).intValue();
         Script var29 = (Script)Script.field1441.get((long)var18);
         if(var29 != null) {
            var5 = var29;
         } else {
            byte[] var25 = class1.indexScripts.getConfigData(var18, 0);
            if(var25 == null) {
               var5 = null;
            } else {
               var29 = class12.method81(var25);
               Script.field1441.put(var29, (long)var18);
               var5 = var29;
            }
         }

         var3 = var5;
      }

      if(var3 != null) {
         class13.intStackSize = 0;
         class82.scriptStringStackSize = 0;
         var18 = -1;
         int[] var32 = var3.instructions;
         int[] var30 = var3.intOperands;
         byte var31 = -1;
         class82.scriptStackCount = 0;

         try {
            class82.scriptLocalInts = new int[var3.localIntCount];
            var8 = 0;
            class51.scriptLocalStrings = new String[var3.localStringCount];
            var9 = 0;

            int var19;
            String var34;
            for(var10 = 1; var10 < var2.length; ++var10) {
               if(var2[var10] instanceof Integer) {
                  var19 = ((Integer)var2[var10]).intValue();
                  if(var19 == -2147483647) {
                     var19 = var0.field800;
                  }

                  if(var19 == -2147483646) {
                     var19 = var0.field801;
                  }

                  if(var19 == -2147483645) {
                     var19 = var0.widget != null?var0.widget.id:-1;
                  }

                  if(var19 == -2147483644) {
                     var19 = var0.field806;
                  }

                  if(var19 == -2147483643) {
                     var19 = var0.widget != null?var0.widget.index:-1;
                  }

                  if(var19 == -2147483642) {
                     var19 = var0.field803 != null?var0.field803.id:-1;
                  }

                  if(var19 == -2147483641) {
                     var19 = var0.field803 != null?var0.field803.index:-1;
                  }

                  if(var19 == -2147483640) {
                     var19 = var0.field802;
                  }

                  if(var19 == -2147483639) {
                     var19 = var0.field810;
                  }

                  class82.scriptLocalInts[var8++] = var19;
               } else if(var2[var10] instanceof String) {
                  var34 = (String)var2[var10];
                  if(var34.equals("event_opbase")) {
                     var34 = var0.field805;
                  }

                  class51.scriptLocalStrings[var9++] = var34;
               }
            }

            var10 = 0;
            class82.field1272 = var0.field807;

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
                                                                                       label348:
                                                                                       while(true) {
                                                                                          ++var10;
                                                                                          if(var10 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var18;
                                                                                          var7 = var32[var18];
                                                                                          int var20;
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
                                                                                                                                                                        var19 = var30[var18] >> 16;
                                                                                                                                                                        var20 = var30[var18] & 65535;
                                                                                                                                                                        int var22 = class82.intStack[--class13.intStackSize];
                                                                                                                                                                        if(var22 >= 0 && var22 <= 5000) {
                                                                                                                                                                           class82.field1262[var19] = var22;
                                                                                                                                                                           byte var43 = -1;
                                                                                                                                                                           if(var20 == 105) {
                                                                                                                                                                              var43 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           int var24 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var24 >= var22) {
                                                                                                                                                                                 continue label348;
                                                                                                                                                                              }

                                                                                                                                                                              class82.SHAPE_VERTICES[var19][var24] = var43;
                                                                                                                                                                              ++var24;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var7 == 45) {
                                                                                                                                                                        var19 = var30[var18];
                                                                                                                                                                        var20 = class82.intStack[--class13.intStackSize];
                                                                                                                                                                        if(var20 < 0 || var20 >= class82.field1262[var19]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class82.intStack[++class13.intStackSize - 1] = class82.SHAPE_VERTICES[var19][var20];
                                                                                                                                                                     } else if(var7 == 46) {
                                                                                                                                                                        var19 = var30[var18];
                                                                                                                                                                        class13.intStackSize -= 2;
                                                                                                                                                                        var20 = class82.intStack[class13.intStackSize];
                                                                                                                                                                        if(var20 < 0 || var20 >= class82.field1262[var19]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class82.SHAPE_VERTICES[var19][var20] = class82.intStack[class13.intStackSize + 1];
                                                                                                                                                                     } else if(var7 == 47) {
                                                                                                                                                                        var34 = class28.chatMessages.getVarcString(var30[var18]);
                                                                                                                                                                        if(var34 == null) {
                                                                                                                                                                           var34 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var34;
                                                                                                                                                                     } else if(var7 == 48) {
                                                                                                                                                                        class28.chatMessages.putVarcString(var30[var18], class82.scriptStringStack[--class82.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var7 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        IterableHashTable var41 = var3.switches[var30[var18]];
                                                                                                                                                                        IntegerNode var37 = (IntegerNode)var41.get((long)class82.intStack[--class13.intStackSize]);
                                                                                                                                                                        if(var37 != null) {
                                                                                                                                                                           var18 += var37.value;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     class28.chatMessages.putVarc(var30[var18], class82.intStack[--class13.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class82.intStack[++class13.intStackSize - 1] = class28.chatMessages.getVarc(var30[var18]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var19 = var30[var18];
                                                                                                                                                               var35 = (Script)Script.field1441.get((long)var19);
                                                                                                                                                               if(var35 != null) {
                                                                                                                                                                  var12 = var35;
                                                                                                                                                               } else {
                                                                                                                                                                  byte[] var38 = class1.indexScripts.getConfigData(var19, 0);
                                                                                                                                                                  if(var38 == null) {
                                                                                                                                                                     var12 = null;
                                                                                                                                                                  } else {
                                                                                                                                                                     var35 = class12.method81(var38);
                                                                                                                                                                     Script.field1441.put(var35, (long)var19);
                                                                                                                                                                     var12 = var35;
                                                                                                                                                                  }
                                                                                                                                                               }

                                                                                                                                                               var35 = var12;
                                                                                                                                                               int[] var39 = new int[var12.localIntCount];
                                                                                                                                                               String[] var42 = new String[var12.localStringCount];

                                                                                                                                                               for(var16 = 0; var16 < var35.intStackCount; ++var16) {
                                                                                                                                                                  var39[var16] = class82.intStack[var16 + (class13.intStackSize - var35.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var16 = 0; var16 < var35.stringStackCount; ++var16) {
                                                                                                                                                                  var42[var16] = class82.scriptStringStack[var16 + (class82.scriptStringStackSize - var35.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class13.intStackSize -= var35.intStackCount;
                                                                                                                                                               class82.scriptStringStackSize -= var35.stringStackCount;
                                                                                                                                                               ScriptState var21 = new ScriptState();
                                                                                                                                                               var21.invokedFromScript = var3;
                                                                                                                                                               var21.invokedFromPc = var18;
                                                                                                                                                               var21.savedLocalInts = class82.scriptLocalInts;
                                                                                                                                                               var21.savedLocalStrings = class51.scriptLocalStrings;
                                                                                                                                                               class82.scriptStack[++class82.scriptStackCount - 1] = var21;
                                                                                                                                                               var3 = var35;
                                                                                                                                                               var32 = var35.instructions;
                                                                                                                                                               var30 = var35.intOperands;
                                                                                                                                                               var18 = -1;
                                                                                                                                                               class82.scriptLocalInts = var39;
                                                                                                                                                               class51.scriptLocalStrings = var42;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --class82.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class13.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var19 = var30[var18];
                                                                                                                                                      class82.scriptStringStackSize -= var19;
                                                                                                                                                      String var33 = ScriptVarType.method22(class82.scriptStringStack, class82.scriptStringStackSize, var19);
                                                                                                                                                      class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var33;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class51.scriptLocalStrings[var30[var18]] = class82.scriptStringStack[--class82.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class82.scriptStringStack[++class82.scriptStringStackSize - 1] = class51.scriptLocalStrings[var30[var18]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class82.scriptLocalInts[var30[var18]] = class82.intStack[--class13.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class82.intStack[++class13.intStackSize - 1] = class82.scriptLocalInts[var30[var18]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class13.intStackSize -= 2;
                                                                                                                                       if(class82.intStack[class13.intStackSize] >= class82.intStack[class13.intStackSize + 1]) {
                                                                                                                                          var18 += var30[var18];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class13.intStackSize -= 2;
                                                                                                                                    if(class82.intStack[class13.intStackSize] <= class82.intStack[class13.intStackSize + 1]) {
                                                                                                                                       var18 += var30[var18];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var19 = var30[var18];
                                                                                                                                 Varcs.method1883(var19, class82.intStack[--class13.intStackSize]);
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var19 = var30[var18];
                                                                                                                              class82.intStack[++class13.intStackSize - 1] = Friend.method1109(var19);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class82.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var36 = class82.scriptStack[--class82.scriptStackCount];
                                                                                                                           var3 = var36.invokedFromScript;
                                                                                                                           var32 = var3.instructions;
                                                                                                                           var30 = var3.intOperands;
                                                                                                                           var18 = var36.invokedFromPc;
                                                                                                                           class82.scriptLocalInts = var36.savedLocalInts;
                                                                                                                           class51.scriptLocalStrings = var36.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class13.intStackSize -= 2;
                                                                                                                        if(class82.intStack[class13.intStackSize] > class82.intStack[class13.intStackSize + 1]) {
                                                                                                                           var18 += var30[var18];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class13.intStackSize -= 2;
                                                                                                                     if(class82.intStack[class13.intStackSize] < class82.intStack[class13.intStackSize + 1]) {
                                                                                                                        var18 += var30[var18];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class13.intStackSize -= 2;
                                                                                                                  if(class82.intStack[class13.intStackSize] == class82.intStack[class13.intStackSize + 1]) {
                                                                                                                     var18 += var30[var18];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class13.intStackSize -= 2;
                                                                                                               if(class82.intStack[class13.intStackSize] != class82.intStack[class13.intStackSize + 1]) {
                                                                                                                  var18 += var30[var18];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var18 += var30[var18];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class82.scriptStringStack[++class82.scriptStringStackSize - 1] = var3.stringOperands[var18];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var19 = var30[var18];
                                                                                                      class218.widgetSettings[var19] = class82.intStack[--class13.intStackSize];
                                                                                                      GraphicsObject.method1724(var19);
                                                                                                   }
                                                                                                } else {
                                                                                                   var19 = var30[var18];
                                                                                                   class82.intStack[++class13.intStackSize - 1] = class218.widgetSettings[var19];
                                                                                                }
                                                                                             } else {
                                                                                                class82.intStack[++class13.intStackSize - 1] = var30[var18];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var44;
                                                                                             if(var3.intOperands[var18] == 1) {
                                                                                                var44 = true;
                                                                                             } else {
                                                                                                var44 = false;
                                                                                             }

                                                                                             var20 = class82.method1715(var7, var3, var44);
                                                                                             switch(var20) {
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
         } catch (Exception var28) {
            StringBuilder var27 = new StringBuilder(30);
            var27.append("").append(var3.hash).append(" ");

            for(var10 = class82.scriptStackCount - 1; var10 >= 0; --var10) {
               var27.append("").append(class82.scriptStack[var10].invokedFromScript.hash).append(" ");
            }

            var27.append("").append(var31);
            Item.method1829(var27.toString(), var28);
         }
      }
   }
}
