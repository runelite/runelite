import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("gl")
public class class203 {
   @ObfuscatedName("x")
   public static final char[] field3084 = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};
   @ObfuscatedName("n")
   public static class182 field3085;

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-407082080"
   )
   static final void method3847(String var0) {
      if(Friend.clanMembers != null) {
         Client.field332.method3144(181);
         Client.field332.method2873(class165.method3233(var0));
         Client.field332.method2915(var0);
      }
   }

   class203() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass18;II)V",
      garbageValue = "1039924782"
   )
   static void method3853(class18 var0, int var1) {
      Object[] var2 = var0.field196;
      int var3 = ((Integer)var2[0]).intValue();
      Script var4 = class30.method695(var3);
      if(var4 != null) {
         class32.field735 = 0;
         class30.scriptStringStackSize = 0;
         int var5 = -1;
         int[] var6 = var4.instructions;
         int[] var7 = var4.intOperands;
         byte var8 = -1;
         class32.scriptStackCount = 0;

         int var11;
         try {
            class32.field720 = new int[var4.localIntCount];
            int var9 = 0;
            class32.field723 = new String[var4.localStringCount];
            int var10 = 0;

            int var12;
            String var21;
            for(var11 = 1; var11 < var2.length; ++var11) {
               if(var2[var11] instanceof Integer) {
                  var12 = ((Integer)var2[var11]).intValue();
                  if(var12 == -2147483647) {
                     var12 = var0.field189;
                  }

                  if(var12 == -2147483646) {
                     var12 = var0.field190;
                  }

                  if(var12 == -2147483645) {
                     var12 = var0.field188 != null?var0.field188.id:-1;
                  }

                  if(var12 == -2147483644) {
                     var12 = var0.field191;
                  }

                  if(var12 == -2147483643) {
                     var12 = var0.field188 != null?var0.field188.index:-1;
                  }

                  if(var12 == -2147483642) {
                     var12 = null != var0.field192?var0.field192.id:-1;
                  }

                  if(var12 == -2147483641) {
                     var12 = null != var0.field192?var0.field192.index:-1;
                  }

                  if(var12 == -2147483640) {
                     var12 = var0.field193;
                  }

                  if(var12 == -2147483639) {
                     var12 = var0.field194;
                  }

                  class32.field720[var9++] = var12;
               } else if(var2[var11] instanceof String) {
                  var21 = (String)var2[var11];
                  if(var21.equals("event_opbase")) {
                     var21 = var0.field195;
                  }

                  class32.field723[var10++] = var21;
               }
            }

            var11 = 0;
            class32.field730 = var0.field187;

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
                                                                                       label306:
                                                                                       while(true) {
                                                                                          ++var11;
                                                                                          if(var11 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var5;
                                                                                          int var31 = var6[var5];
                                                                                          int var13;
                                                                                          if(var31 < 100) {
                                                                                             if(var31 != 0) {
                                                                                                if(var31 != 1) {
                                                                                                   if(var31 != 2) {
                                                                                                      if(var31 != 3) {
                                                                                                         if(var31 != 6) {
                                                                                                            if(var31 != 7) {
                                                                                                               if(var31 != 8) {
                                                                                                                  if(var31 != 9) {
                                                                                                                     if(var31 != 10) {
                                                                                                                        if(var31 != 21) {
                                                                                                                           if(var31 != 25) {
                                                                                                                              int var15;
                                                                                                                              int var16;
                                                                                                                              int var17;
                                                                                                                              int var18;
                                                                                                                              if(var31 != 27) {
                                                                                                                                 if(var31 != 31) {
                                                                                                                                    if(var31 != 32) {
                                                                                                                                       if(var31 != 33) {
                                                                                                                                          if(var31 != 34) {
                                                                                                                                             if(var31 != 35) {
                                                                                                                                                if(var31 != 36) {
                                                                                                                                                   if(var31 != 37) {
                                                                                                                                                      if(var31 != 38) {
                                                                                                                                                         if(var31 != 39) {
                                                                                                                                                            if(var31 != 40) {
                                                                                                                                                               if(var31 != 42) {
                                                                                                                                                                  if(var31 != 43) {
                                                                                                                                                                     if(var31 == 44) {
                                                                                                                                                                        var12 = var7[var5] >> 16;
                                                                                                                                                                        var13 = var7[var5] & '\uffff';
                                                                                                                                                                        int var27 = class32.field726[--class32.field735];
                                                                                                                                                                        if(var27 >= 0 && var27 <= 5000) {
                                                                                                                                                                           class32.field724[var12] = var27;
                                                                                                                                                                           byte var34 = -1;
                                                                                                                                                                           if(var13 == 105) {
                                                                                                                                                                              var34 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var16 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var16 >= var27) {
                                                                                                                                                                                 continue label306;
                                                                                                                                                                              }

                                                                                                                                                                              class32.field727[var12][var16] = var34;
                                                                                                                                                                              ++var16;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var31 == 45) {
                                                                                                                                                                        var12 = var7[var5];
                                                                                                                                                                        var13 = class32.field726[--class32.field735];
                                                                                                                                                                        if(var13 < 0 || var13 >= class32.field724[var12]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class32.field726[++class32.field735 - 1] = class32.field727[var12][var13];
                                                                                                                                                                     } else if(var31 == 46) {
                                                                                                                                                                        var12 = var7[var5];
                                                                                                                                                                        class32.field735 -= 2;
                                                                                                                                                                        var13 = class32.field726[class32.field735];
                                                                                                                                                                        if(var13 < 0 || var13 >= class32.field724[var12]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class32.field727[var12][var13] = class32.field726[1 + class32.field735];
                                                                                                                                                                     } else if(var31 == 47) {
                                                                                                                                                                        var21 = class22.chatMessages.method922(var7[var5]);
                                                                                                                                                                        if(var21 == null) {
                                                                                                                                                                           var21 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var21;
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var31 != 48) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        class22.chatMessages.method921(var7[var5], class32.scriptStringStack[--class30.scriptStringStackSize]);
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     class22.chatMessages.method949(var7[var5], class32.field726[--class32.field735]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class32.field726[++class32.field735 - 1] = class22.chatMessages.method920(var7[var5]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var12 = var7[var5];
                                                                                                                                                               Script var38 = class30.method695(var12);
                                                                                                                                                               int[] var33 = new int[var38.localIntCount];
                                                                                                                                                               String[] var26 = new String[var38.localStringCount];

                                                                                                                                                               for(var16 = 0; var16 < var38.intStackCount; ++var16) {
                                                                                                                                                                  var33[var16] = class32.field726[var16 + (class32.field735 - var38.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var16 = 0; var16 < var38.stringStackCount; ++var16) {
                                                                                                                                                                  var26[var16] = class32.scriptStringStack[class30.scriptStringStackSize - var38.stringStackCount + var16];
                                                                                                                                                               }

                                                                                                                                                               class32.field735 -= var38.intStackCount;
                                                                                                                                                               class30.scriptStringStackSize -= var38.stringStackCount;
                                                                                                                                                               ScriptState var37 = new ScriptState();
                                                                                                                                                               var37.field105 = var4;
                                                                                                                                                               var37.field96 = var5;
                                                                                                                                                               var37.field102 = class32.field720;
                                                                                                                                                               var37.field98 = class32.field723;
                                                                                                                                                               class32.scriptStack[++class32.scriptStackCount - 1] = var37;
                                                                                                                                                               var4 = var38;
                                                                                                                                                               var6 = var38.instructions;
                                                                                                                                                               var7 = var38.intOperands;
                                                                                                                                                               var5 = -1;
                                                                                                                                                               class32.field720 = var33;
                                                                                                                                                               class32.field723 = var26;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --class30.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class32.field735;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var12 = var7[var5];
                                                                                                                                                      class30.scriptStringStackSize -= var12;
                                                                                                                                                      String[] var32 = class32.scriptStringStack;
                                                                                                                                                      var15 = class30.scriptStringStackSize;
                                                                                                                                                      String var22;
                                                                                                                                                      if(var12 == 0) {
                                                                                                                                                         var22 = "";
                                                                                                                                                      } else if(var12 == 1) {
                                                                                                                                                         String var23 = var32[var15];
                                                                                                                                                         if(null == var23) {
                                                                                                                                                            var22 = "null";
                                                                                                                                                         } else {
                                                                                                                                                            var22 = var23.toString();
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         var16 = var15 + var12;
                                                                                                                                                         var17 = 0;

                                                                                                                                                         for(var18 = var15; var18 < var16; ++var18) {
                                                                                                                                                            String var19 = var32[var18];
                                                                                                                                                            if(var19 == null) {
                                                                                                                                                               var17 += 4;
                                                                                                                                                            } else {
                                                                                                                                                               var17 += var19.length();
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         StringBuilder var24 = new StringBuilder(var17);

                                                                                                                                                         for(int var25 = var15; var25 < var16; ++var25) {
                                                                                                                                                            String var20 = var32[var25];
                                                                                                                                                            if(var20 == null) {
                                                                                                                                                               var24.append("null");
                                                                                                                                                            } else {
                                                                                                                                                               var24.append(var20);
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         var22 = var24.toString();
                                                                                                                                                      }

                                                                                                                                                      class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var22;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class32.field723[var7[var5]] = class32.scriptStringStack[--class30.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class32.scriptStringStack[++class30.scriptStringStackSize - 1] = class32.field723[var7[var5]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class32.field720[var7[var5]] = class32.field726[--class32.field735];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class32.field726[++class32.field735 - 1] = class32.field720[var7[var5]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class32.field735 -= 2;
                                                                                                                                       if(class32.field726[class32.field735] >= class32.field726[1 + class32.field735]) {
                                                                                                                                          var5 += var7[var5];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class32.field735 -= 2;
                                                                                                                                    if(class32.field726[class32.field735] <= class32.field726[class32.field735 + 1]) {
                                                                                                                                       var5 += var7[var5];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var12 = var7[var5];
                                                                                                                                 var13 = class32.field726[--class32.field735];
                                                                                                                                 Varbit var14 = class30.method704(var12);
                                                                                                                                 var15 = var14.leastSignificantBit;
                                                                                                                                 var16 = var14.configId;
                                                                                                                                 var17 = var14.mostSignificantBit;
                                                                                                                                 var18 = class165.field2163[var17 - var16];
                                                                                                                                 if(var13 < 0 || var13 > var18) {
                                                                                                                                    var13 = 0;
                                                                                                                                 }

                                                                                                                                 var18 <<= var16;
                                                                                                                                 class165.widgetSettings[var15] = class165.widgetSettings[var15] & ~var18 | var13 << var16 & var18;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var12 = var7[var5];
                                                                                                                              class32.field726[++class32.field735 - 1] = class18.method202(var12);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class32.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var36 = class32.scriptStack[--class32.scriptStackCount];
                                                                                                                           var4 = var36.field105;
                                                                                                                           var6 = var4.instructions;
                                                                                                                           var7 = var4.intOperands;
                                                                                                                           var5 = var36.field96;
                                                                                                                           class32.field720 = var36.field102;
                                                                                                                           class32.field723 = var36.field98;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class32.field735 -= 2;
                                                                                                                        if(class32.field726[class32.field735] > class32.field726[class32.field735 + 1]) {
                                                                                                                           var5 += var7[var5];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class32.field735 -= 2;
                                                                                                                     if(class32.field726[class32.field735] < class32.field726[class32.field735 + 1]) {
                                                                                                                        var5 += var7[var5];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class32.field735 -= 2;
                                                                                                                  if(class32.field726[class32.field735] == class32.field726[class32.field735 + 1]) {
                                                                                                                     var5 += var7[var5];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class32.field735 -= 2;
                                                                                                               if(class32.field726[class32.field735 + 1] != class32.field726[class32.field735]) {
                                                                                                                  var5 += var7[var5];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var5 += var7[var5];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var4.stringOperands[var5];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var12 = var7[var5];
                                                                                                      class165.widgetSettings[var12] = class32.field726[--class32.field735];
                                                                                                      class139.method2577(var12);
                                                                                                   }
                                                                                                } else {
                                                                                                   var12 = var7[var5];
                                                                                                   class32.field726[++class32.field735 - 1] = class165.widgetSettings[var12];
                                                                                                }
                                                                                             } else {
                                                                                                class32.field726[++class32.field735 - 1] = var7[var5];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var35;
                                                                                             if(var4.intOperands[var5] == 1) {
                                                                                                var35 = true;
                                                                                             } else {
                                                                                                var35 = false;
                                                                                             }

                                                                                             var13 = class0.method8(var31, var4, var35);
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
         } catch (Exception var30) {
            StringBuilder var29 = new StringBuilder(30);
            var29.append("").append(var4.hash).append(" ");

            for(var11 = class32.scriptStackCount - 1; var11 >= 0; --var11) {
               var29.append("").append(class32.scriptStack[var11].field105.hash).append(" ");
            }

            var29.append("").append(var8);
            class97.method2025(var29.toString(), var30);
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass159;I)V",
      garbageValue = "648164338"
   )
   public static void method3856(class159 var0) {
      ClassInfo var1 = (ClassInfo)class227.field3246.method2453();
      if(null != var1) {
         int var2 = var0.offset;
         var0.method2874(var1.field3243);

         for(int var3 = 0; var3 < var1.field3239; ++var3) {
            if(var1.field3241[var3] != 0) {
               var0.method2873(var1.field3241[var3]);
            } else {
               try {
                  int var4 = var1.field3238[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = Reflection.getInt(var5, (Object)null);
                     var0.method2873(0);
                     var0.method2874(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     Reflection.setInt(var5, (Object)null, var1.field3244[var3]);
                     var0.method2873(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.method2873(0);
                     var0.method2874(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.method2873(0);
                        var0.method2874(var6);
                     }
                  } else {
                     var25 = var1.methods[var3];
                     byte[][] var10 = var1.args[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = Reflection.invoke(var25, (Object)null, var7);
                     if(var11 == null) {
                        var0.method2873(0);
                     } else if(var11 instanceof Number) {
                        var0.method2873(1);
                        var0.method3085(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.method2873(2);
                        var0.method2915((String)var11);
                     } else {
                        var0.method2873(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.method2873(-10);
               } catch (InvalidClassException var14) {
                  var0.method2873(-11);
               } catch (StreamCorruptedException var15) {
                  var0.method2873(-12);
               } catch (OptionalDataException var16) {
                  var0.method2873(-13);
               } catch (IllegalAccessException var17) {
                  var0.method2873(-14);
               } catch (IllegalArgumentException var18) {
                  var0.method2873(-15);
               } catch (InvocationTargetException var19) {
                  var0.method2873(-16);
               } catch (SecurityException var20) {
                  var0.method2873(-17);
               } catch (IOException var21) {
                  var0.method2873(-18);
               } catch (NullPointerException var22) {
                  var0.method2873(-19);
               } catch (Exception var23) {
                  var0.method2873(-20);
               } catch (Throwable var24) {
                  var0.method2873(-21);
               }
            }
         }

         var0.method2908(var2);
         var1.unlink();
      }
   }
}
