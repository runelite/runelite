import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public final class class8 extends class9 {
   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "[Ljp;"
   )
   static IndexedSprite[] field242;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1391469625
   )
   final int field238;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 928655415
   )
   final int field243;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2040141385
   )
   final int field237;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1230595401
   )
   final int field240;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 111062985
   )
   final int field241;

   public class8(int var1, int var2, int var3, int var4, int var5) {
      this.field238 = var1;
      this.field243 = var2;
      this.field237 = var3;
      this.field240 = var4;
      this.field241 = var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-36"
   )
   final void vmethod53() {
      Rasterizer2D.drawRectangle(this.field238 + Rasterizer2D.draw_region_x, this.field243 + Rasterizer2D.drawingAreaTop, this.field237 - this.field238, this.field240 - this.field243, this.field241);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lbl;IB)V",
      garbageValue = "14"
   )
   static void method40(ScriptEvent var0, int var1) {
      Object[] var2 = var0.field849;
      Script var3;
      int var20;
      if(class84.method1684(var0.field845)) {
         class40.field541 = (class47)var2[0];
         Area var4 = Area.field3276[class40.field541.field600];
         var3 = class25.method184(var0.field845, var4.field3297, var4.field3296);
      } else {
         var20 = ((Integer)var2[0]).intValue();
         var3 = class28.method243(var20);
      }

      if(var3 != null) {
         class84.intStackSize = 0;
         class84.scriptStringStackSize = 0;
         var20 = -1;
         int[] var5 = var3.instructions;
         int[] var6 = var3.intOperands;
         byte var7 = -1;
         class84.scriptStackCount = 0;

         int var10;
         try {
            class84.scriptLocalInts = new int[var3.localIntCount];
            int var8 = 0;
            class84.scriptLocalStrings = new String[var3.localStringCount];
            int var9 = 0;

            int var11;
            String var21;
            for(var10 = 1; var10 < var2.length; ++var10) {
               if(var2[var10] instanceof Integer) {
                  var11 = ((Integer)var2[var10]).intValue();
                  if(var11 == -2147483647) {
                     var11 = var0.field837;
                  }

                  if(var11 == -2147483646) {
                     var11 = var0.field844;
                  }

                  if(var11 == -2147483645) {
                     var11 = var0.widget != null?var0.widget.id:-1;
                  }

                  if(var11 == -2147483644) {
                     var11 = var0.field839;
                  }

                  if(var11 == -2147483643) {
                     var11 = var0.widget != null?var0.widget.index:-1;
                  }

                  if(var11 == -2147483642) {
                     var11 = var0.field835 != null?var0.field835.id:-1;
                  }

                  if(var11 == -2147483641) {
                     var11 = var0.field835 != null?var0.field835.index:-1;
                  }

                  if(var11 == -2147483640) {
                     var11 = var0.field841;
                  }

                  if(var11 == -2147483639) {
                     var11 = var0.field842;
                  }

                  class84.scriptLocalInts[var8++] = var11;
               } else if(var2[var10] instanceof String) {
                  var21 = (String)var2[var10];
                  if(var21.equals("event_opbase")) {
                     var21 = var0.field840;
                  }

                  class84.scriptLocalStrings[var9++] = var21;
               }
            }

            var10 = 0;
            class84.field1339 = var0.field848;

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
                                                                                       label311:
                                                                                       while(true) {
                                                                                          ++var10;
                                                                                          if(var10 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var20;
                                                                                          int var31 = var5[var20];
                                                                                          int var12;
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
                                                                                                                                                   int var23;
                                                                                                                                                   if(var31 != 37) {
                                                                                                                                                      if(var31 != 38) {
                                                                                                                                                         if(var31 != 39) {
                                                                                                                                                            if(var31 != 40) {
                                                                                                                                                               if(var31 != 42) {
                                                                                                                                                                  if(var31 != 43) {
                                                                                                                                                                     if(var31 == 44) {
                                                                                                                                                                        var11 = var6[var20] >> 16;
                                                                                                                                                                        var12 = var6[var20] & '\uffff';
                                                                                                                                                                        int var27 = class84.intStack[--class84.intStackSize];
                                                                                                                                                                        if(var27 >= 0 && var27 <= 5000) {
                                                                                                                                                                           class84.field1329[var11] = var27;
                                                                                                                                                                           byte var33 = -1;
                                                                                                                                                                           if(var12 == 105) {
                                                                                                                                                                              var33 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var23 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var23 >= var27) {
                                                                                                                                                                                 continue label311;
                                                                                                                                                                              }

                                                                                                                                                                              class84.SHAPE_VERTICIES[var11][var23] = var33;
                                                                                                                                                                              ++var23;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var31 == 45) {
                                                                                                                                                                        var11 = var6[var20];
                                                                                                                                                                        var12 = class84.intStack[--class84.intStackSize];
                                                                                                                                                                        if(var12 < 0 || var12 >= class84.field1329[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class84.intStack[++class84.intStackSize - 1] = class84.SHAPE_VERTICIES[var11][var12];
                                                                                                                                                                     } else if(var31 == 46) {
                                                                                                                                                                        var11 = var6[var20];
                                                                                                                                                                        class84.intStackSize -= 2;
                                                                                                                                                                        var12 = class84.intStack[class84.intStackSize];
                                                                                                                                                                        if(var12 < 0 || var12 >= class84.field1329[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class84.SHAPE_VERTICIES[var11][var12] = class84.intStack[class84.intStackSize + 1];
                                                                                                                                                                     } else if(var31 == 47) {
                                                                                                                                                                        var21 = class47.chatMessages.getVarcString(var6[var20]);
                                                                                                                                                                        if(var21 == null) {
                                                                                                                                                                           var21 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var21;
                                                                                                                                                                     } else if(var31 == 48) {
                                                                                                                                                                        class47.chatMessages.putVarcString(var6[var20], class84.scriptStringStack[--class84.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var31 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        IterableHashTable var37 = var3.switches[var6[var20]];
                                                                                                                                                                        IntegerNode var39 = (IntegerNode)var37.get((long)class84.intStack[--class84.intStackSize]);
                                                                                                                                                                        if(var39 != null) {
                                                                                                                                                                           var20 += var39.value;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     class47.chatMessages.putVarc(var6[var20], class84.intStack[--class84.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class84.intStack[++class84.intStackSize - 1] = class47.chatMessages.getVarc(var6[var20]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var11 = var6[var20];
                                                                                                                                                               Script var38 = class28.method243(var11);
                                                                                                                                                               int[] var32 = new int[var38.localIntCount];
                                                                                                                                                               String[] var24 = new String[var38.localStringCount];

                                                                                                                                                               for(var23 = 0; var23 < var38.intStackCount; ++var23) {
                                                                                                                                                                  var32[var23] = class84.intStack[var23 + (class84.intStackSize - var38.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var23 = 0; var23 < var38.stringStackCount; ++var23) {
                                                                                                                                                                  var24[var23] = class84.scriptStringStack[var23 + (class84.scriptStringStackSize - var38.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class84.intStackSize -= var38.intStackCount;
                                                                                                                                                               class84.scriptStringStackSize -= var38.stringStackCount;
                                                                                                                                                               ScriptState var34 = new ScriptState();
                                                                                                                                                               var34.invokedFromScript = var3;
                                                                                                                                                               var34.invokedFromPc = var20;
                                                                                                                                                               var34.savedLocalInts = class84.scriptLocalInts;
                                                                                                                                                               var34.savedLocalStrings = class84.scriptLocalStrings;
                                                                                                                                                               class84.scriptStack[++class84.scriptStackCount - 1] = var34;
                                                                                                                                                               var3 = var38;
                                                                                                                                                               var5 = var38.instructions;
                                                                                                                                                               var6 = var38.intOperands;
                                                                                                                                                               var20 = -1;
                                                                                                                                                               class84.scriptLocalInts = var32;
                                                                                                                                                               class84.scriptLocalStrings = var24;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --class84.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class84.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var11 = var6[var20];
                                                                                                                                                      class84.scriptStringStackSize -= var11;
                                                                                                                                                      String[] var13 = class84.scriptStringStack;
                                                                                                                                                      int var14 = class84.scriptStringStackSize;
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
                                                                                                                                                         int var16 = 0;

                                                                                                                                                         for(int var17 = var14; var17 < var23; ++var17) {
                                                                                                                                                            String var18 = var13[var17];
                                                                                                                                                            if(var18 == null) {
                                                                                                                                                               var16 += 4;
                                                                                                                                                            } else {
                                                                                                                                                               var16 += var18.length();
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         StringBuilder var25 = new StringBuilder(var16);

                                                                                                                                                         for(int var26 = var14; var26 < var23; ++var26) {
                                                                                                                                                            String var19 = var13[var26];
                                                                                                                                                            if(var19 == null) {
                                                                                                                                                               var25.append("null");
                                                                                                                                                            } else {
                                                                                                                                                               var25.append(var19);
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         var22 = var25.toString();
                                                                                                                                                      }

                                                                                                                                                      class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var22;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class84.scriptLocalStrings[var6[var20]] = class84.scriptStringStack[--class84.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class84.scriptStringStack[++class84.scriptStringStackSize - 1] = class84.scriptLocalStrings[var6[var20]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class84.scriptLocalInts[var6[var20]] = class84.intStack[--class84.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class84.intStack[++class84.intStackSize - 1] = class84.scriptLocalInts[var6[var20]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class84.intStackSize -= 2;
                                                                                                                                       if(class84.intStack[class84.intStackSize] >= class84.intStack[class84.intStackSize + 1]) {
                                                                                                                                          var20 += var6[var20];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class84.intStackSize -= 2;
                                                                                                                                    if(class84.intStack[class84.intStackSize] <= class84.intStack[class84.intStackSize + 1]) {
                                                                                                                                       var20 += var6[var20];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var11 = var6[var20];
                                                                                                                                 XGrandExchangeOffer.method114(var11, class84.intStack[--class84.intStackSize]);
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var11 = var6[var20];
                                                                                                                              class84.intStack[++class84.intStackSize - 1] = class209.method3887(var11);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class84.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var36 = class84.scriptStack[--class84.scriptStackCount];
                                                                                                                           var3 = var36.invokedFromScript;
                                                                                                                           var5 = var3.instructions;
                                                                                                                           var6 = var3.intOperands;
                                                                                                                           var20 = var36.invokedFromPc;
                                                                                                                           class84.scriptLocalInts = var36.savedLocalInts;
                                                                                                                           class84.scriptLocalStrings = var36.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class84.intStackSize -= 2;
                                                                                                                        if(class84.intStack[class84.intStackSize] > class84.intStack[class84.intStackSize + 1]) {
                                                                                                                           var20 += var6[var20];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class84.intStackSize -= 2;
                                                                                                                     if(class84.intStack[class84.intStackSize] < class84.intStack[class84.intStackSize + 1]) {
                                                                                                                        var20 += var6[var20];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class84.intStackSize -= 2;
                                                                                                                  if(class84.intStack[class84.intStackSize] == class84.intStack[class84.intStackSize + 1]) {
                                                                                                                     var20 += var6[var20];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class84.intStackSize -= 2;
                                                                                                               if(class84.intStack[class84.intStackSize] != class84.intStack[class84.intStackSize + 1]) {
                                                                                                                  var20 += var6[var20];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var20 += var6[var20];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var3.stringOperands[var20];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var11 = var6[var20];
                                                                                                      class212.widgetSettings[var11] = class84.intStack[--class84.intStackSize];
                                                                                                      class5.method10(var11);
                                                                                                   }
                                                                                                } else {
                                                                                                   var11 = var6[var20];
                                                                                                   class84.intStack[++class84.intStackSize - 1] = class212.widgetSettings[var11];
                                                                                                }
                                                                                             } else {
                                                                                                class84.intStack[++class84.intStackSize - 1] = var6[var20];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var35;
                                                                                             if(var3.intOperands[var20] == 1) {
                                                                                                var35 = true;
                                                                                             } else {
                                                                                                var35 = false;
                                                                                             }

                                                                                             var12 = class252.method4462(var31, var3, var35);
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
         } catch (Exception var30) {
            StringBuilder var29 = new StringBuilder(30);
            var29.append("").append(var3.hash).append(" ");

            for(var10 = class84.scriptStackCount - 1; var10 >= 0; --var10) {
               var29.append("").append(class84.scriptStack[var10].invokedFromScript.hash).append(" ");
            }

            var29.append("").append(var7);
            NPC.method1722(var29.toString(), var30);
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILej;[Lfo;B)V",
      garbageValue = "20"
   )
   static final void method37(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Region var8, CollisionData[] var9) {
      Buffer var10 = new Buffer(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.getUSmart();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.getUSmart();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.readUnsignedByte();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var17 == var4 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < var6 + 8) {
               ObjectComposition var21 = WorldMapType1.getObjectDefinition(var11);
               int var22 = var2 + class175.method3377(var16 & 7, var15 & 7, var7, var21.sizeX, var21.sizeY, var20);
               int var23 = var3 + class208.method3882(var16 & 7, var15 & 7, var7, var21.sizeX, var21.sizeY, var20);
               if(var22 > 0 && var23 > 0 && var22 < 103 && var23 < 103) {
                  int var24 = var1;
                  if((class61.tileSettings[1][var22][var23] & 2) == 2) {
                     var24 = var1 - 1;
                  }

                  CollisionData var25 = null;
                  if(var24 >= 0) {
                     var25 = var9[var24];
                  }

                  GroundObject.addObject(var1, var22, var23, var11, var20 + var7 & 3, var19, var8, var25);
               }
            }
         }
      }
   }
}
