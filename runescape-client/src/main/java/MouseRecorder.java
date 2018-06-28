import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
   @ObfuscatedName("g")
   static int[][][] field534;
   @ObfuscatedName("w")
   @Export("isRunning")
   boolean isRunning;
   @ObfuscatedName("m")
   @Export("lock")
   Object lock;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -528874791
   )
   @Export("index")
   int index;
   @ObfuscatedName("b")
   @Export("xs")
   int[] xs;
   @ObfuscatedName("f")
   @Export("ys")
   int[] ys;

   MouseRecorder() {
      this.isRunning = true;
      this.lock = new Object();
      this.index = 0;
      this.xs = new int[500];
      this.ys = new int[500];
   }

   public void run() {
      for(; this.isRunning; WorldMapType1.method218(50L)) {
         Object var1 = this.lock;
         synchronized(this.lock) {
            if(this.index < 500) {
               this.xs[this.index] = MouseInput.mouseLastX;
               this.ys[this.index] = MouseInput.mouseLastY;
               ++this.index;
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lbr;II)V",
      garbageValue = "-406786730"
   )
   @Export("runScript")
   static void runScript(ScriptEvent var0, int var1) {
      Object[] var2 = var0.params;
      Script var3;
      int var20;
      if(FileSystem.method4620(var0.field518)) {
         class173.scriptMapIconReference = (MapIconReference)var2[0];
         Area var4 = Area.mapAreaType[class173.scriptMapIconReference.areaId];
         var3 = WorldMapType2.method495(var0.field518, var4.id, var4.field3277);
      } else {
         var20 = ((Integer)var2[0]).intValue();
         var3 = GraphicsObject.method1806(var20);
      }

      if(var3 != null) {
         class45.intStackSize = 0;
         class83.scriptStringStackSize = 0;
         var20 = -1;
         int[] var5 = var3.instructions;
         int[] var6 = var3.intOperands;
         byte var7 = -1;
         class69.scriptStackCount = 0;

         int var10;
         try {
            class69.scriptLocalInts = new int[var3.localIntCount];
            int var8 = 0;
            class69.scriptLocalStrings = new String[var3.localStringCount];
            int var9 = 0;

            int var11;
            String var21;
            for(var10 = 1; var10 < var2.length; ++var10) {
               if(var2[var10] instanceof Integer) {
                  var11 = ((Integer)var2[var10]).intValue();
                  if(var11 == -2147483647) {
                     var11 = var0.mouseX;
                  }

                  if(var11 == -2147483646) {
                     var11 = var0.mouseY;
                  }

                  if(var11 == -2147483645) {
                     var11 = var0.source != null?var0.source.id:-1;
                  }

                  if(var11 == -2147483644) {
                     var11 = var0.op;
                  }

                  if(var11 == -2147483643) {
                     var11 = var0.source != null?var0.source.index:-1;
                  }

                  if(var11 == -2147483642) {
                     var11 = var0.target != null?var0.target.id:-1;
                  }

                  if(var11 == -2147483641) {
                     var11 = var0.target != null?var0.target.index:-1;
                  }

                  if(var11 == -2147483640) {
                     var11 = var0.typedKeyCode;
                  }

                  if(var11 == -2147483639) {
                     var11 = var0.typedKeyChar;
                  }

                  class69.scriptLocalInts[var8++] = var11;
               } else if(var2[var10] instanceof String) {
                  var21 = (String)var2[var10];
                  if(var21.equals("event_opbase")) {
                     var21 = var0.opbase;
                  }

                  class69.scriptLocalStrings[var9++] = var21;
               }
            }

            var10 = 0;
            class69.field1025 = var0.field519;

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
                                                                                       label315:
                                                                                       while(true) {
                                                                                          ++var10;
                                                                                          if(var10 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var20;
                                                                                          int var31 = var5[var20];
                                                                                          int var26;
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
                                                                                                                              if(var31 != 27) {
                                                                                                                                 if(var31 != 31) {
                                                                                                                                    if(var31 != 32) {
                                                                                                                                       if(var31 != 33) {
                                                                                                                                          if(var31 != 34) {
                                                                                                                                             if(var31 != 35) {
                                                                                                                                                if(var31 != 36) {
                                                                                                                                                   int var22;
                                                                                                                                                   if(var31 != 37) {
                                                                                                                                                      if(var31 != 38) {
                                                                                                                                                         if(var31 != 39) {
                                                                                                                                                            if(var31 != 40) {
                                                                                                                                                               if(var31 != 42) {
                                                                                                                                                                  if(var31 != 43) {
                                                                                                                                                                     if(var31 == 44) {
                                                                                                                                                                        var11 = var6[var20] >> 16;
                                                                                                                                                                        var26 = var6[var20] & 65535;
                                                                                                                                                                        int var27 = class69.intStack[--class45.intStackSize];
                                                                                                                                                                        if(var27 >= 0 && var27 <= 5000) {
                                                                                                                                                                           class69.field1019[var11] = var27;
                                                                                                                                                                           byte var35 = -1;
                                                                                                                                                                           if(var26 == 105) {
                                                                                                                                                                              var35 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var22 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var22 >= var27) {
                                                                                                                                                                                 continue label315;
                                                                                                                                                                              }

                                                                                                                                                                              class69.SHAPE_VERTICES[var11][var22] = var35;
                                                                                                                                                                              ++var22;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var31 == 45) {
                                                                                                                                                                        var11 = var6[var20];
                                                                                                                                                                        var26 = class69.intStack[--class45.intStackSize];
                                                                                                                                                                        if(var26 < 0 || var26 >= class69.field1019[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class69.intStack[++class45.intStackSize - 1] = class69.SHAPE_VERTICES[var11][var26];
                                                                                                                                                                     } else if(var31 == 46) {
                                                                                                                                                                        var11 = var6[var20];
                                                                                                                                                                        class45.intStackSize -= 2;
                                                                                                                                                                        var26 = class69.intStack[class45.intStackSize];
                                                                                                                                                                        if(var26 < 0 || var26 >= class69.field1019[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class69.SHAPE_VERTICES[var11][var26] = class69.intStack[class45.intStackSize + 1];
                                                                                                                                                                     } else if(var31 == 47) {
                                                                                                                                                                        var21 = Permission.varcs.getVarcString(var6[var20]);
                                                                                                                                                                        if(var21 == null) {
                                                                                                                                                                           var21 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var21;
                                                                                                                                                                     } else if(var31 == 48) {
                                                                                                                                                                        Permission.varcs.putVarcString(var6[var20], class69.scriptStringStack[--class83.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var31 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        IterableHashTable var39 = var3.switches[var6[var20]];
                                                                                                                                                                        IntegerNode var34 = (IntegerNode)var39.get((long)class69.intStack[--class45.intStackSize]);
                                                                                                                                                                        if(var34 != null) {
                                                                                                                                                                           var20 += var34.value;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     Permission.varcs.putVarc(var6[var20], class69.intStack[--class45.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class69.intStack[++class45.intStackSize - 1] = Permission.varcs.getVarc(var6[var20]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var11 = var6[var20];
                                                                                                                                                               Script var33 = GraphicsObject.method1806(var11);
                                                                                                                                                               int[] var32 = new int[var33.localIntCount];
                                                                                                                                                               String[] var25 = new String[var33.localStringCount];

                                                                                                                                                               for(var22 = 0; var22 < var33.intStackCount; ++var22) {
                                                                                                                                                                  var32[var22] = class69.intStack[var22 + (class45.intStackSize - var33.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var22 = 0; var22 < var33.stringStackCount; ++var22) {
                                                                                                                                                                  var25[var22] = class69.scriptStringStack[var22 + (class83.scriptStringStackSize - var33.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class45.intStackSize -= var33.intStackCount;
                                                                                                                                                               class83.scriptStringStackSize -= var33.stringStackCount;
                                                                                                                                                               ScriptState var36 = new ScriptState();
                                                                                                                                                               var36.invokedFromScript = var3;
                                                                                                                                                               var36.invokedFromPc = var20;
                                                                                                                                                               var36.savedLocalInts = class69.scriptLocalInts;
                                                                                                                                                               var36.savedLocalStrings = class69.scriptLocalStrings;
                                                                                                                                                               class69.scriptStack[++class69.scriptStackCount - 1] = var36;
                                                                                                                                                               var3 = var33;
                                                                                                                                                               var5 = var33.instructions;
                                                                                                                                                               var6 = var33.intOperands;
                                                                                                                                                               var20 = -1;
                                                                                                                                                               class69.scriptLocalInts = var32;
                                                                                                                                                               class69.scriptLocalStrings = var25;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --class83.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class45.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var11 = var6[var20];
                                                                                                                                                      class83.scriptStringStackSize -= var11;
                                                                                                                                                      String[] var13 = class69.scriptStringStack;
                                                                                                                                                      int var14 = class83.scriptStringStackSize;
                                                                                                                                                      String var12;
                                                                                                                                                      if(var11 == 0) {
                                                                                                                                                         var12 = "";
                                                                                                                                                      } else if(var11 == 1) {
                                                                                                                                                         String var15 = var13[var14];
                                                                                                                                                         if(var15 == null) {
                                                                                                                                                            var12 = "null";
                                                                                                                                                         } else {
                                                                                                                                                            var12 = var15.toString();
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         var22 = var11 + var14;
                                                                                                                                                         int var16 = 0;

                                                                                                                                                         for(int var17 = var14; var17 < var22; ++var17) {
                                                                                                                                                            String var18 = var13[var17];
                                                                                                                                                            if(var18 == null) {
                                                                                                                                                               var16 += 4;
                                                                                                                                                            } else {
                                                                                                                                                               var16 += var18.length();
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         StringBuilder var23 = new StringBuilder(var16);

                                                                                                                                                         for(int var24 = var14; var24 < var22; ++var24) {
                                                                                                                                                            String var19 = var13[var24];
                                                                                                                                                            if(var19 == null) {
                                                                                                                                                               var23.append("null");
                                                                                                                                                            } else {
                                                                                                                                                               var23.append(var19);
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         var12 = var23.toString();
                                                                                                                                                      }

                                                                                                                                                      class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var12;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class69.scriptLocalStrings[var6[var20]] = class69.scriptStringStack[--class83.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class69.scriptStringStack[++class83.scriptStringStackSize - 1] = class69.scriptLocalStrings[var6[var20]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class69.scriptLocalInts[var6[var20]] = class69.intStack[--class45.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class69.intStack[++class45.intStackSize - 1] = class69.scriptLocalInts[var6[var20]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class45.intStackSize -= 2;
                                                                                                                                       if(class69.intStack[class45.intStackSize] >= class69.intStack[class45.intStackSize + 1]) {
                                                                                                                                          var20 += var6[var20];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class45.intStackSize -= 2;
                                                                                                                                    if(class69.intStack[class45.intStackSize] <= class69.intStack[class45.intStackSize + 1]) {
                                                                                                                                       var20 += var6[var20];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var11 = var6[var20];
                                                                                                                                 class187.method3844(var11, class69.intStack[--class45.intStackSize]);
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var11 = var6[var20];
                                                                                                                              class69.intStack[++class45.intStackSize - 1] = class138.getVarbit(var11);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class69.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var38 = class69.scriptStack[--class69.scriptStackCount];
                                                                                                                           var3 = var38.invokedFromScript;
                                                                                                                           var5 = var3.instructions;
                                                                                                                           var6 = var3.intOperands;
                                                                                                                           var20 = var38.invokedFromPc;
                                                                                                                           class69.scriptLocalInts = var38.savedLocalInts;
                                                                                                                           class69.scriptLocalStrings = var38.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class45.intStackSize -= 2;
                                                                                                                        if(class69.intStack[class45.intStackSize] > class69.intStack[class45.intStackSize + 1]) {
                                                                                                                           var20 += var6[var20];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class45.intStackSize -= 2;
                                                                                                                     if(class69.intStack[class45.intStackSize] < class69.intStack[class45.intStackSize + 1]) {
                                                                                                                        var20 += var6[var20];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class45.intStackSize -= 2;
                                                                                                                  if(class69.intStack[class45.intStackSize] == class69.intStack[class45.intStackSize + 1]) {
                                                                                                                     var20 += var6[var20];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class45.intStackSize -= 2;
                                                                                                               if(class69.intStack[class45.intStackSize] != class69.intStack[class45.intStackSize + 1]) {
                                                                                                                  var20 += var6[var20];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var20 += var6[var20];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var3.stringOperands[var20];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var11 = var6[var20];
                                                                                                      class225.clientVarps[var11] = class69.intStack[--class45.intStackSize];
                                                                                                      Widget.method4537(var11);
                                                                                                   }
                                                                                                } else {
                                                                                                   var11 = var6[var20];
                                                                                                   class69.intStack[++class45.intStackSize - 1] = class225.clientVarps[var11];
                                                                                                }
                                                                                             } else {
                                                                                                class69.intStack[++class45.intStackSize - 1] = var6[var20];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var37;
                                                                                             if(var3.intOperands[var20] == 1) {
                                                                                                var37 = true;
                                                                                             } else {
                                                                                                var37 = false;
                                                                                             }

                                                                                             var26 = class126.method3072(var31, var3, var37);
                                                                                             switch(var26) {
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
            var29.append("").append(var3.hash).append(" ");

            for(var10 = class69.scriptStackCount - 1; var10 >= 0; --var10) {
               var29.append("").append(class69.scriptStack[var10].invokedFromScript.hash).append(" ");
            }

            var29.append("").append(var7);
            class43.processClientError(var29.toString(), var30);
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-9"
   )
   static String method1085() {
      return ScriptState.preferences.hideUsername?TextureProvider.method2592(class78.username):class78.username;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILcs;ZI)I",
      garbageValue = "-2106134469"
   )
   static int method1090(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = OwnWorldComparator.getWidget(class69.intStack[--class45.intStackSize]);
      } else {
         var3 = var2?class184.field2379:FriendManager.field996;
      }

      String var4 = class69.scriptStringStack[--class83.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
         int var6 = class69.intStack[--class45.intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class69.intStack[--class45.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 's') {
            var8[var7] = class69.scriptStringStack[--class83.scriptStringStackSize];
         } else {
            var8[var7] = new Integer(class69.intStack[--class45.intStackSize]);
         }
      }

      var7 = class69.intStack[--class45.intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.onClickListener = var8;
      } else if(var0 == 1401) {
         var3.onHoldListener = var8;
      } else if(var0 == 1402) {
         var3.onReleaseListener = var8;
      } else if(var0 == 1403) {
         var3.onMouseOverListener = var8;
      } else if(var0 == 1404) {
         var3.onMouseLeaveListener = var8;
      } else if(var0 == 1405) {
         var3.onDragListener = var8;
      } else if(var0 == 1406) {
         var3.onTargetLeaveListener = var8;
      } else if(var0 == 1407) {
         var3.onVarTransmitListener = var8;
         var3.varTransmitTriggers = var5;
      } else if(var0 == 1408) {
         var3.onTimerListener = var8;
      } else if(var0 == 1409) {
         var3.onOpListener = var8;
      } else if(var0 == 1410) {
         var3.onDragCompleteListener = var8;
      } else if(var0 == 1411) {
         var3.onClickRepeatListener = var8;
      } else if(var0 == 1412) {
         var3.onMouseRepeatListener = var8;
      } else if(var0 == 1414) {
         var3.onInvTransmitListener = var8;
         var3.invTransmitTriggers = var5;
      } else if(var0 == 1415) {
         var3.onStatTransmitListener = var8;
         var3.statTransmitTriggers = var5;
      } else if(var0 == 1416) {
         var3.onTargetEnterListener = var8;
      } else if(var0 == 1417) {
         var3.onScrollWheelListener = var8;
      } else if(var0 == 1418) {
         var3.onChatTransmitListener = var8;
      } else if(var0 == 1419) {
         var3.onKeyListener = var8;
      } else if(var0 == 1420) {
         var3.onFriendTransmitListener = var8;
      } else if(var0 == 1421) {
         var3.onClanTransmitListener = var8;
      } else if(var0 == 1422) {
         var3.onMiscTransmitListener = var8;
      } else if(var0 == 1423) {
         var3.onDialogAbortListener = var8;
      } else if(var0 == 1424) {
         var3.onSubChangeListener = var8;
      } else if(var0 == 1425) {
         var3.onStockTransmitListener = var8;
      } else if(var0 == 1426) {
         var3.onCamFinishedListener = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.onResizeListener = var8;
      }

      var3.hasListener = true;
      return 1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "825066086"
   )
   public static String method1089(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if(var5 != 181 && var5 != 131) {
               var6 = Character.toTitleCase(var5);
            } else {
               var6 = var5;
            }

            var5 = var6;
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != '.' && var5 != '?' && var5 != '!') {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }
}
