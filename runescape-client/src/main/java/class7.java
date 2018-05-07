import java.applet.Applet;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("y")
public class class7 {
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      intValue = -344426897
   )
   static int field233;
   @ObfuscatedName("g")
   @Export("drawBoundingBoxes3D")
   public static boolean drawBoundingBoxes3D;
   @ObfuscatedName("e")
   @Export("drawBoundingBoxes2D")
   public static boolean drawBoundingBoxes2D;
   @ObfuscatedName("b")
   @Export("drawObjectGeometry2D")
   public static boolean drawObjectGeometry2D;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   @Export("boundingBox3DDrawMode")
   public static BoundingBox3DDrawMode boundingBox3DDrawMode;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   @Export("boundingBoxes")
   public static CombatInfoList boundingBoxes;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "[Ldm;"
   )
   @Export("idxFiles")
   public static CacheFile[] idxFiles;
   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("indexCache3")
   static IndexData indexCache3;
   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("indexTrack1")
   static IndexData indexTrack1;
   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "[Llh;"
   )
   @Export("scrollbarSprites")
   static IndexedSprite[] scrollbarSprites;

   static {
      drawBoundingBoxes3D = false;
      drawBoundingBoxes2D = false;
      drawObjectGeometry2D = false;
      boundingBox3DDrawMode = BoundingBox3DDrawMode.ON_MOUSEOVER;
      boundingBoxes = new CombatInfoList();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lbs;II)V",
      garbageValue = "118530150"
   )
   @Export("runScript")
   static void runScript(ScriptEvent var0, int var1) {
      Object[] var2 = var0.objs;
      Script var3;
      int var19;
      if(GameObject.method3165(var0.field781)) {
         class81.scriptMapIconReference = (MapIconReference)var2[0];
         Area var4 = class190.mapAreaType[class81.scriptMapIconReference.areaId];
         var3 = class153.method3218(var0.field781, var4.id, var4.field3463);
      } else {
         var19 = ((Integer)var2[0]).intValue();
         Script var6 = (Script)Script.field1437.get((long)var19);
         Script var5;
         if(var6 != null) {
            var5 = var6;
         } else {
            byte[] var7 = MapIcon.indexScripts.getConfigData(var19, 0);
            if(var7 == null) {
               var5 = null;
            } else {
               var6 = SoundTaskDataProvider.newScript(var7);
               Script.field1437.put(var6, (long)var19);
               var5 = var6;
            }
         }

         var3 = var5;
      }

      if(var3 != null) {
         class171.intStackSize = 0;
         class81.scriptStringStackSize = 0;
         var19 = -1;
         int[] var30 = var3.instructions;
         int[] var31 = var3.intOperands;
         byte var20 = -1;
         class81.scriptStackCount = 0;

         int var10;
         try {
            AbstractByteBuffer.scriptLocalInts = new int[var3.localIntCount];
            int var8 = 0;
            class81.scriptLocalStrings = new String[var3.localStringCount];
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
                     var11 = var0.field776 != null?var0.field776.id:-1;
                  }

                  if(var11 == -2147483641) {
                     var11 = var0.field776 != null?var0.field776.index:-1;
                  }

                  if(var11 == -2147483640) {
                     var11 = var0.pressedKey;
                  }

                  if(var11 == -2147483639) {
                     var11 = var0.typedKey;
                  }

                  AbstractByteBuffer.scriptLocalInts[var8++] = var11;
               } else if(var2[var10] instanceof String) {
                  var21 = (String)var2[var10];
                  if(var21.equals("event_opbase")) {
                     var21 = var0.string;
                  }

                  class81.scriptLocalStrings[var9++] = var21;
               }
            }

            var10 = 0;
            class81.field1274 = var0.field784;

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
                                                                                       label307:
                                                                                       while(true) {
                                                                                          ++var10;
                                                                                          if(var10 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var19;
                                                                                          int var37 = var30[var19];
                                                                                          int var12;
                                                                                          if(var37 < 100) {
                                                                                             if(var37 != 0) {
                                                                                                if(var37 != 1) {
                                                                                                   if(var37 != 2) {
                                                                                                      if(var37 != 3) {
                                                                                                         if(var37 != 6) {
                                                                                                            if(var37 != 7) {
                                                                                                               if(var37 != 8) {
                                                                                                                  if(var37 != 9) {
                                                                                                                     if(var37 != 10) {
                                                                                                                        if(var37 != 21) {
                                                                                                                           if(var37 != 25) {
                                                                                                                              int var16;
                                                                                                                              int var22;
                                                                                                                              if(var37 != 27) {
                                                                                                                                 if(var37 != 31) {
                                                                                                                                    if(var37 != 32) {
                                                                                                                                       if(var37 != 33) {
                                                                                                                                          if(var37 != 34) {
                                                                                                                                             if(var37 != 35) {
                                                                                                                                                if(var37 != 36) {
                                                                                                                                                   if(var37 != 37) {
                                                                                                                                                      if(var37 != 38) {
                                                                                                                                                         if(var37 != 39) {
                                                                                                                                                            if(var37 != 40) {
                                                                                                                                                               if(var37 != 42) {
                                                                                                                                                                  if(var37 != 43) {
                                                                                                                                                                     if(var37 == 44) {
                                                                                                                                                                        var11 = var31[var19] >> 16;
                                                                                                                                                                        var12 = var31[var19] & 65535;
                                                                                                                                                                        int var25 = class81.intStack[--class171.intStackSize];
                                                                                                                                                                        if(var25 >= 0 && var25 <= 5000) {
                                                                                                                                                                           class81.field1277[var11] = var25;
                                                                                                                                                                           byte var26 = -1;
                                                                                                                                                                           if(var12 == 105) {
                                                                                                                                                                              var26 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var22 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var22 >= var25) {
                                                                                                                                                                                 continue label307;
                                                                                                                                                                              }

                                                                                                                                                                              class81.SHAPE_VERTICES[var11][var22] = var26;
                                                                                                                                                                              ++var22;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var37 == 45) {
                                                                                                                                                                        var11 = var31[var19];
                                                                                                                                                                        var12 = class81.intStack[--class171.intStackSize];
                                                                                                                                                                        if(var12 < 0 || var12 >= class81.field1277[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class81.intStack[++class171.intStackSize - 1] = class81.SHAPE_VERTICES[var11][var12];
                                                                                                                                                                     } else if(var37 == 46) {
                                                                                                                                                                        var11 = var31[var19];
                                                                                                                                                                        class171.intStackSize -= 2;
                                                                                                                                                                        var12 = class81.intStack[class171.intStackSize];
                                                                                                                                                                        if(var12 < 0 || var12 >= class81.field1277[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class81.SHAPE_VERTICES[var11][var12] = class81.intStack[class171.intStackSize + 1];
                                                                                                                                                                     } else if(var37 == 47) {
                                                                                                                                                                        var21 = class160.varcs.getVarcString(var31[var19]);
                                                                                                                                                                        if(var21 == null) {
                                                                                                                                                                           var21 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var21;
                                                                                                                                                                     } else if(var37 == 48) {
                                                                                                                                                                        class160.varcs.putVarcString(var31[var19], class81.scriptStringStack[--class81.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var37 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        IterableHashTable var40 = var3.switches[var31[var19]];
                                                                                                                                                                        IntegerNode var41 = (IntegerNode)var40.get((long)class81.intStack[--class171.intStackSize]);
                                                                                                                                                                        if(var41 != null) {
                                                                                                                                                                           var19 += var41.value;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     class160.varcs.putVarc(var31[var19], class81.intStack[--class171.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class81.intStack[++class171.intStackSize - 1] = class160.varcs.getVarc(var31[var19]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var11 = var31[var19];
                                                                                                                                                               Script var32 = (Script)Script.field1437.get((long)var11);
                                                                                                                                                               Script var39;
                                                                                                                                                               if(var32 != null) {
                                                                                                                                                                  var39 = var32;
                                                                                                                                                               } else {
                                                                                                                                                                  byte[] var33 = MapIcon.indexScripts.getConfigData(var11, 0);
                                                                                                                                                                  if(var33 == null) {
                                                                                                                                                                     var39 = null;
                                                                                                                                                                  } else {
                                                                                                                                                                     var32 = SoundTaskDataProvider.newScript(var33);
                                                                                                                                                                     Script.field1437.put(var32, (long)var11);
                                                                                                                                                                     var39 = var32;
                                                                                                                                                                  }
                                                                                                                                                               }

                                                                                                                                                               var32 = var39;
                                                                                                                                                               int[] var34 = new int[var39.localIntCount];
                                                                                                                                                               String[] var35 = new String[var39.localStringCount];

                                                                                                                                                               for(var16 = 0; var16 < var32.intStackCount; ++var16) {
                                                                                                                                                                  var34[var16] = class81.intStack[var16 + (class171.intStackSize - var32.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var16 = 0; var16 < var32.stringStackCount; ++var16) {
                                                                                                                                                                  var35[var16] = class81.scriptStringStack[var16 + (class81.scriptStringStackSize - var32.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class171.intStackSize -= var32.intStackCount;
                                                                                                                                                               class81.scriptStringStackSize -= var32.stringStackCount;
                                                                                                                                                               ScriptState var24 = new ScriptState();
                                                                                                                                                               var24.invokedFromScript = var3;
                                                                                                                                                               var24.invokedFromPc = var19;
                                                                                                                                                               var24.savedLocalInts = AbstractByteBuffer.scriptLocalInts;
                                                                                                                                                               var24.savedLocalStrings = class81.scriptLocalStrings;
                                                                                                                                                               class81.scriptStack[++class81.scriptStackCount - 1] = var24;
                                                                                                                                                               var3 = var32;
                                                                                                                                                               var30 = var32.instructions;
                                                                                                                                                               var31 = var32.intOperands;
                                                                                                                                                               var19 = -1;
                                                                                                                                                               AbstractByteBuffer.scriptLocalInts = var34;
                                                                                                                                                               class81.scriptLocalStrings = var35;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --class81.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class171.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var11 = var31[var19];
                                                                                                                                                      class81.scriptStringStackSize -= var11;
                                                                                                                                                      String var23 = Ignore.method5441(class81.scriptStringStack, class81.scriptStringStackSize, var11);
                                                                                                                                                      class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var23;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class81.scriptLocalStrings[var31[var19]] = class81.scriptStringStack[--class81.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class81.scriptStringStack[++class81.scriptStringStackSize - 1] = class81.scriptLocalStrings[var31[var19]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             AbstractByteBuffer.scriptLocalInts[var31[var19]] = class81.intStack[--class171.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class81.intStack[++class171.intStackSize - 1] = AbstractByteBuffer.scriptLocalInts[var31[var19]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class171.intStackSize -= 2;
                                                                                                                                       if(class81.intStack[class171.intStackSize] >= class81.intStack[class171.intStackSize + 1]) {
                                                                                                                                          var19 += var31[var19];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class171.intStackSize -= 2;
                                                                                                                                    if(class81.intStack[class171.intStackSize] <= class81.intStack[class171.intStackSize + 1]) {
                                                                                                                                       var19 += var31[var19];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var11 = var31[var19];
                                                                                                                                 var12 = class81.intStack[--class171.intStackSize];
                                                                                                                                 Varbit var14 = (Varbit)Varbit.varbits.get((long)var11);
                                                                                                                                 Varbit var13;
                                                                                                                                 if(var14 != null) {
                                                                                                                                    var13 = var14;
                                                                                                                                 } else {
                                                                                                                                    byte[] var15 = Varbit.varbit_ref.getConfigData(14, var11);
                                                                                                                                    var14 = new Varbit();
                                                                                                                                    if(var15 != null) {
                                                                                                                                       var14.decode(new Buffer(var15));
                                                                                                                                    }

                                                                                                                                    Varbit.varbits.put(var14, (long)var11);
                                                                                                                                    var13 = var14;
                                                                                                                                 }

                                                                                                                                 var22 = var13.configId;
                                                                                                                                 var16 = var13.leastSignificantBit;
                                                                                                                                 int var17 = var13.mostSignificantBit;
                                                                                                                                 int var18 = class237.varpsMasks[var17 - var16];
                                                                                                                                 if(var12 < 0 || var12 > var18) {
                                                                                                                                    var12 = 0;
                                                                                                                                 }

                                                                                                                                 var18 <<= var16;
                                                                                                                                 class237.clientVarps[var22] = class237.clientVarps[var22] & ~var18 | var12 << var16 & var18;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var11 = var31[var19];
                                                                                                                              class81.intStack[++class171.intStackSize - 1] = VarCString.getVarbit(var11);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class81.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var38 = class81.scriptStack[--class81.scriptStackCount];
                                                                                                                           var3 = var38.invokedFromScript;
                                                                                                                           var30 = var3.instructions;
                                                                                                                           var31 = var3.intOperands;
                                                                                                                           var19 = var38.invokedFromPc;
                                                                                                                           AbstractByteBuffer.scriptLocalInts = var38.savedLocalInts;
                                                                                                                           class81.scriptLocalStrings = var38.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class171.intStackSize -= 2;
                                                                                                                        if(class81.intStack[class171.intStackSize] > class81.intStack[class171.intStackSize + 1]) {
                                                                                                                           var19 += var31[var19];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class171.intStackSize -= 2;
                                                                                                                     if(class81.intStack[class171.intStackSize] < class81.intStack[class171.intStackSize + 1]) {
                                                                                                                        var19 += var31[var19];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class171.intStackSize -= 2;
                                                                                                                  if(class81.intStack[class171.intStackSize] == class81.intStack[class171.intStackSize + 1]) {
                                                                                                                     var19 += var31[var19];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class171.intStackSize -= 2;
                                                                                                               if(class81.intStack[class171.intStackSize] != class81.intStack[class171.intStackSize + 1]) {
                                                                                                                  var19 += var31[var19];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var19 += var31[var19];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var3.stringOperands[var19];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var11 = var31[var19];
                                                                                                      class237.clientVarps[var11] = class81.intStack[--class171.intStackSize];
                                                                                                      DynamicObject.method2113(var11);
                                                                                                   }
                                                                                                } else {
                                                                                                   var11 = var31[var19];
                                                                                                   class81.intStack[++class171.intStackSize - 1] = class237.clientVarps[var11];
                                                                                                }
                                                                                             } else {
                                                                                                class81.intStack[++class171.intStackSize - 1] = var31[var19];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var36;
                                                                                             if(var3.intOperands[var19] == 1) {
                                                                                                var36 = true;
                                                                                             } else {
                                                                                                var36 = false;
                                                                                             }

                                                                                             var12 = ScriptVarType.method24(var37, var3, var36);
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
         } catch (Exception var29) {
            StringBuilder var28 = new StringBuilder(30);
            var28.append("").append(var3.hash).append(" ");

            for(var10 = class81.scriptStackCount - 1; var10 >= 0; --var10) {
               var28.append("").append(class81.scriptStack[var10].invokedFromScript.hash).append(" ");
            }

            var28.append("").append(var20);
            class253.processClientError(var28.toString(), var29);
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "-1298799207"
   )
   static boolean method28(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class57.field655.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var13 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var13.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var8) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Applet var7 = class57.field661;
            Object[] var5 = new Object[]{(new URL(class57.field661.getCodeBase(), var0)).toString()};
            Object var3 = JSObject.getWindow(var7).call(var2, var5);
            return var3 != null;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class57.field661.getAppletContext().showDocument(new URL(class57.field661.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class53.method833(class57.field661, "loggedout");
         } catch (Throwable var12) {
            ;
         }

         try {
            class57.field661.getAppletContext().showDocument(new URL(class57.field661.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "110188929"
   )
   public static void method29(int var0) {
      MouseInput.mouseIdleTicks = var0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "-1798550255"
   )
   static int method36(int var0, Script var1, boolean var2) {
      Widget var3 = UnitPriceComparator.getWidget(class81.intStack[--class171.intStackSize]);
      if(var0 == 2500) {
         class81.intStack[++class171.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 2501) {
         class81.intStack[++class171.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 2502) {
         class81.intStack[++class171.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         class81.intStack[++class171.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         class81.intStack[++class171.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         class81.intStack[++class171.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "1190184498"
   )
   static final void method33(int var0, int var1, boolean var2) {
      if(!var2 || var0 != class169.field2206 || class36.field493 != var1) {
         class169.field2206 = var0;
         class36.field493 = var1;
         class55.setGameState(25);
         class5.method16("Loading - please wait.", true);
         int var3 = ClientPacket.baseX;
         int var4 = MapIconReference.baseY;
         ClientPacket.baseX = (var0 - 6) * 8;
         MapIconReference.baseY = (var1 - 6) * 8;
         int var5 = ClientPacket.baseX - var3;
         int var6 = MapIconReference.baseY - var4;
         var3 = ClientPacket.baseX;
         var4 = MapIconReference.baseY;

         int var7;
         int var9;
         for(var7 = 0; var7 < 32768; ++var7) {
            NPC var8 = Client.cachedNPCs[var7];
            if(var8 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var8.pathX[var9] -= var5;
                  var8.pathY[var9] -= var6;
               }

               var8.x -= var5 * 128;
               var8.y -= var6 * 128;
            }
         }

         for(var7 = 0; var7 < 2048; ++var7) {
            Player var21 = Client.cachedPlayers[var7];
            if(var21 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var21.pathX[var9] -= var5;
                  var21.pathY[var9] -= var6;
               }

               var21.x -= var5 * 128;
               var21.y -= var6 * 128;
            }
         }

         byte var20 = 0;
         byte var18 = 104;
         byte var22 = 1;
         if(var5 < 0) {
            var20 = 103;
            var18 = -1;
            var22 = -1;
         }

         byte var10 = 0;
         byte var11 = 104;
         byte var12 = 1;
         if(var6 < 0) {
            var10 = 103;
            var11 = -1;
            var12 = -1;
         }

         int var14;
         for(int var13 = var20; var18 != var13; var13 += var22) {
            for(var14 = var10; var14 != var11; var14 += var12) {
               int var15 = var13 + var5;
               int var16 = var14 + var6;

               for(int var17 = 0; var17 < 4; ++var17) {
                  if(var15 >= 0 && var16 >= 0 && var15 < 104 && var16 < 104) {
                     Client.groundItemDeque[var17][var13][var14] = Client.groundItemDeque[var17][var15][var16];
                  } else {
                     Client.groundItemDeque[var17][var13][var14] = null;
                  }
               }
            }
         }

         for(PendingSpawn var19 = (PendingSpawn)Client.pendingSpawns.getFront(); var19 != null; var19 = (PendingSpawn)Client.pendingSpawns.getNext()) {
            var19.x -= var5;
            var19.y -= var6;
            if(var19.x < 0 || var19.y < 0 || var19.x >= 104 || var19.y >= 104) {
               var19.unlink();
            }
         }

         if(Client.destinationX != 0) {
            Client.destinationX -= var5;
            Client.destinationY -= var6;
         }

         Client.queuedSoundEffectCount = 0;
         Client.field1094 = false;
         UrlRequest.cameraX -= var5 << 7;
         Signlink.cameraY -= var6 << 7;
         Size.field367 -= var5 << 7;
         class236.field2783 -= var6 << 7;
         Client.field1075 = -1;
         Client.graphicsObjectDeque.clear();
         Client.projectiles.clear();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].reset();
         }

      }
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-26"
   )
   static final void method26() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < Client.menuOptionCount - 1; ++var1) {
            if(Client.menuTypes[var1] < 1000 && Client.menuTypes[var1 + 1] > 1000) {
               String var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
               Client.menuTargets[var1 + 1] = var2;
               String var3 = Client.menuOptions[var1];
               Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
               Client.menuOptions[var1 + 1] = var3;
               int var4 = Client.menuTypes[var1];
               Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
               Client.menuTypes[var1 + 1] = var4;
               var4 = Client.menuActionParams0[var1];
               Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
               Client.menuActionParams0[var1 + 1] = var4;
               var4 = Client.menuActionParams1[var1];
               Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               Client.menuActionParams1[var1 + 1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
               Client.menuIdentifiers[var1 + 1] = var4;
               boolean var5 = Client.menuBooleanArray[var1];
               Client.menuBooleanArray[var1] = Client.menuBooleanArray[var1 + 1];
               Client.menuBooleanArray[var1 + 1] = var5;
               var0 = false;
            }
         }
      }

   }
}
