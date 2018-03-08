import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class25 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 571933153
   )
   int field347;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   Coordinates field345;

   @ObfuscatedSignature(
      signature = "(ILik;)V"
   )
   class25(int var1, Coordinates var2) {
      this.field347 = var1;
      this.field345 = var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lbx;IB)V",
      garbageValue = "6"
   )
   @Export("runScript")
   public static void runScript(ScriptEvent var0, int var1) {
      Object[] var2 = var0.objs;
      Script var3;
      Script var5;
      int var7;
      int var8;
      int var9;
      int var10;
      Script var12;
      int var16;
      int var19;
      Script var35;
      if(GZipDecompressor.method3472(var0.field779)) {
         GrandExchangeEvents.scriptMapIconReference = (MapIconReference)var2[0];
         Area var4 = Area.mapAreaType[GrandExchangeEvents.scriptMapIconReference.areaId];
         class245 var6 = var0.field779;
         var7 = var4.id;
         var8 = var4.field3474;
         var9 = (var7 << 8) + var6.field2961;
         var12 = (Script)Script.field1433.get((long)(var9 << 16));
         Script var11;
         if(var12 != null) {
            var11 = var12;
         } else {
            String var13 = String.valueOf(var9);
            int var14 = BoundingBox2D.indexScripts.getFile(var13);
            if(var14 == -1) {
               var11 = null;
            } else {
               label568: {
                  byte[] var15 = BoundingBox2D.indexScripts.takeRecordFlat(var14);
                  if(var15 != null) {
                     if(var15.length <= 1) {
                        var11 = null;
                        break label568;
                     }

                     var12 = class1.newScript(var15);
                     if(var12 != null) {
                        Script.field1433.put(var12, (long)(var9 << 16));
                        var11 = var12;
                        break label568;
                     }
                  }

                  var11 = null;
               }
            }
         }

         if(var11 != null) {
            var5 = var11;
         } else {
            var10 = ItemLayer.method2591(var8, var6);
            Script var18 = (Script)Script.field1433.get((long)(var10 << 16));
            if(var18 != null) {
               var35 = var18;
            } else {
               String var39 = String.valueOf(var10);
               var16 = BoundingBox2D.indexScripts.getFile(var39);
               if(var16 == -1) {
                  var35 = null;
               } else {
                  label513: {
                     byte[] var17 = BoundingBox2D.indexScripts.takeRecordFlat(var16);
                     if(var17 != null) {
                        if(var17.length <= 1) {
                           var35 = null;
                           break label513;
                        }

                        var18 = class1.newScript(var17);
                        if(var18 != null) {
                           Script.field1433.put(var18, (long)(var10 << 16));
                           var35 = var18;
                           break label513;
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
         var19 = ((Integer)var2[0]).intValue();
         Script var29 = (Script)Script.field1433.get((long)var19);
         if(var29 != null) {
            var5 = var29;
         } else {
            byte[] var20 = BoundingBox2D.indexScripts.getConfigData(var19, 0);
            if(var20 == null) {
               var5 = null;
            } else {
               var29 = class1.newScript(var20);
               Script.field1433.put(var29, (long)var19);
               var5 = var29;
            }
         }

         var3 = var5;
      }

      if(var3 != null) {
         class5.intStackSize = 0;
         class316.scriptStringStackSize = 0;
         var19 = -1;
         int[] var32 = var3.instructions;
         int[] var30 = var3.intOperands;
         byte var31 = -1;
         class81.scriptStackCount = 0;

         try {
            class55.scriptLocalInts = new int[var3.localIntCount];
            var8 = 0;
            class191.scriptLocalStrings = new String[var3.localStringCount];
            var9 = 0;

            int var21;
            String var34;
            for(var10 = 1; var10 < var2.length; ++var10) {
               if(var2[var10] instanceof Integer) {
                  var21 = ((Integer)var2[var10]).intValue();
                  if(var21 == -2147483647) {
                     var21 = var0.field782;
                  }

                  if(var21 == -2147483646) {
                     var21 = var0.field789;
                  }

                  if(var21 == -2147483645) {
                     var21 = var0.widget != null?var0.widget.id:-1;
                  }

                  if(var21 == -2147483644) {
                     var21 = var0.field784;
                  }

                  if(var21 == -2147483643) {
                     var21 = var0.widget != null?var0.widget.index:-1;
                  }

                  if(var21 == -2147483642) {
                     var21 = var0.field785 != null?var0.field785.id:-1;
                  }

                  if(var21 == -2147483641) {
                     var21 = var0.field785 != null?var0.field785.index:-1;
                  }

                  if(var21 == -2147483640) {
                     var21 = var0.field780;
                  }

                  if(var21 == -2147483639) {
                     var21 = var0.field781;
                  }

                  class55.scriptLocalInts[var8++] = var21;
               } else if(var2[var10] instanceof String) {
                  var34 = (String)var2[var10];
                  if(var34.equals("event_opbase")) {
                     var34 = var0.string;
                  }

                  class191.scriptLocalStrings[var9++] = var34;
               }
            }

            var10 = 0;
            class81.field1263 = var0.field786;

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
                                                                                       label340:
                                                                                       while(true) {
                                                                                          ++var10;
                                                                                          if(var10 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var19;
                                                                                          var7 = var32[var19];
                                                                                          int var23;
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
                                                                                                                                                                        var21 = var30[var19] >> 16;
                                                                                                                                                                        var23 = var30[var19] & 65535;
                                                                                                                                                                        int var24 = class81.intStack[--class5.intStackSize];
                                                                                                                                                                        if(var24 >= 0 && var24 <= 5000) {
                                                                                                                                                                           class81.field1254[var21] = var24;
                                                                                                                                                                           byte var37 = -1;
                                                                                                                                                                           if(var23 == 105) {
                                                                                                                                                                              var37 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           int var25 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var25 >= var24) {
                                                                                                                                                                                 continue label340;
                                                                                                                                                                              }

                                                                                                                                                                              class81.SHAPE_VERTICES[var21][var25] = var37;
                                                                                                                                                                              ++var25;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var7 == 45) {
                                                                                                                                                                        var21 = var30[var19];
                                                                                                                                                                        var23 = class81.intStack[--class5.intStackSize];
                                                                                                                                                                        if(var23 < 0 || var23 >= class81.field1254[var21]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class81.intStack[++class5.intStackSize - 1] = class81.SHAPE_VERTICES[var21][var23];
                                                                                                                                                                     } else if(var7 == 46) {
                                                                                                                                                                        var21 = var30[var19];
                                                                                                                                                                        class5.intStackSize -= 2;
                                                                                                                                                                        var23 = class81.intStack[class5.intStackSize];
                                                                                                                                                                        if(var23 < 0 || var23 >= class81.field1254[var21]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class81.SHAPE_VERTICES[var21][var23] = class81.intStack[class5.intStackSize + 1];
                                                                                                                                                                     } else if(var7 == 47) {
                                                                                                                                                                        var34 = BoundingBox.chatMessages.getVarcString(var30[var19]);
                                                                                                                                                                        if(var34 == null) {
                                                                                                                                                                           var34 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var34;
                                                                                                                                                                     } else if(var7 == 48) {
                                                                                                                                                                        BoundingBox.chatMessages.putVarcString(var30[var19], class81.scriptStringStack[--class316.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var7 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        IterableHashTable var40 = var3.switches[var30[var19]];
                                                                                                                                                                        IntegerNode var38 = (IntegerNode)var40.get((long)class81.intStack[--class5.intStackSize]);
                                                                                                                                                                        if(var38 != null) {
                                                                                                                                                                           var19 += var38.value;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     BoundingBox.chatMessages.putVarc(var30[var19], class81.intStack[--class5.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class81.intStack[++class5.intStackSize - 1] = BoundingBox.chatMessages.getVarc(var30[var19]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var21 = var30[var19];
                                                                                                                                                               var35 = (Script)Script.field1433.get((long)var21);
                                                                                                                                                               if(var35 != null) {
                                                                                                                                                                  var12 = var35;
                                                                                                                                                               } else {
                                                                                                                                                                  byte[] var42 = BoundingBox2D.indexScripts.getConfigData(var21, 0);
                                                                                                                                                                  if(var42 == null) {
                                                                                                                                                                     var12 = null;
                                                                                                                                                                  } else {
                                                                                                                                                                     var35 = class1.newScript(var42);
                                                                                                                                                                     Script.field1433.put(var35, (long)var21);
                                                                                                                                                                     var12 = var35;
                                                                                                                                                                  }
                                                                                                                                                               }

                                                                                                                                                               var35 = var12;
                                                                                                                                                               int[] var43 = new int[var12.localIntCount];
                                                                                                                                                               String[] var41 = new String[var12.localStringCount];

                                                                                                                                                               for(var16 = 0; var16 < var35.intStackCount; ++var16) {
                                                                                                                                                                  var43[var16] = class81.intStack[var16 + (class5.intStackSize - var35.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var16 = 0; var16 < var35.stringStackCount; ++var16) {
                                                                                                                                                                  var41[var16] = class81.scriptStringStack[var16 + (class316.scriptStringStackSize - var35.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class5.intStackSize -= var35.intStackCount;
                                                                                                                                                               class316.scriptStringStackSize -= var35.stringStackCount;
                                                                                                                                                               ScriptState var22 = new ScriptState();
                                                                                                                                                               var22.invokedFromScript = var3;
                                                                                                                                                               var22.invokedFromPc = var19;
                                                                                                                                                               var22.savedLocalInts = class55.scriptLocalInts;
                                                                                                                                                               var22.savedLocalStrings = class191.scriptLocalStrings;
                                                                                                                                                               class81.scriptStack[++class81.scriptStackCount - 1] = var22;
                                                                                                                                                               var3 = var35;
                                                                                                                                                               var32 = var35.instructions;
                                                                                                                                                               var30 = var35.intOperands;
                                                                                                                                                               var19 = -1;
                                                                                                                                                               class55.scriptLocalInts = var43;
                                                                                                                                                               class191.scriptLocalStrings = var41;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --class316.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class5.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var21 = var30[var19];
                                                                                                                                                      class316.scriptStringStackSize -= var21;
                                                                                                                                                      String var33 = ChatPlayer.method5389(class81.scriptStringStack, class316.scriptStringStackSize, var21);
                                                                                                                                                      class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var33;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class191.scriptLocalStrings[var30[var19]] = class81.scriptStringStack[--class316.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class81.scriptStringStack[++class316.scriptStringStackSize - 1] = class191.scriptLocalStrings[var30[var19]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class55.scriptLocalInts[var30[var19]] = class81.intStack[--class5.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class81.intStack[++class5.intStackSize - 1] = class55.scriptLocalInts[var30[var19]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class5.intStackSize -= 2;
                                                                                                                                       if(class81.intStack[class5.intStackSize] >= class81.intStack[class5.intStackSize + 1]) {
                                                                                                                                          var19 += var30[var19];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class5.intStackSize -= 2;
                                                                                                                                    if(class81.intStack[class5.intStackSize] <= class81.intStack[class5.intStackSize + 1]) {
                                                                                                                                       var19 += var30[var19];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var21 = var30[var19];
                                                                                                                                 Timer.method3330(var21, class81.intStack[--class5.intStackSize]);
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var21 = var30[var19];
                                                                                                                              class81.intStack[++class5.intStackSize - 1] = World.getVarbit(var21);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class81.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var36 = class81.scriptStack[--class81.scriptStackCount];
                                                                                                                           var3 = var36.invokedFromScript;
                                                                                                                           var32 = var3.instructions;
                                                                                                                           var30 = var3.intOperands;
                                                                                                                           var19 = var36.invokedFromPc;
                                                                                                                           class55.scriptLocalInts = var36.savedLocalInts;
                                                                                                                           class191.scriptLocalStrings = var36.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class5.intStackSize -= 2;
                                                                                                                        if(class81.intStack[class5.intStackSize] > class81.intStack[class5.intStackSize + 1]) {
                                                                                                                           var19 += var30[var19];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class5.intStackSize -= 2;
                                                                                                                     if(class81.intStack[class5.intStackSize] < class81.intStack[class5.intStackSize + 1]) {
                                                                                                                        var19 += var30[var19];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class5.intStackSize -= 2;
                                                                                                                  if(class81.intStack[class5.intStackSize] == class81.intStack[class5.intStackSize + 1]) {
                                                                                                                     var19 += var30[var19];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class5.intStackSize -= 2;
                                                                                                               if(class81.intStack[class5.intStackSize] != class81.intStack[class5.intStackSize + 1]) {
                                                                                                                  var19 += var30[var19];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var19 += var30[var19];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var3.stringOperands[var19];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var21 = var30[var19];
                                                                                                      class237.widgetSettings[var21] = class81.intStack[--class5.intStackSize];
                                                                                                      class5.method14(var21);
                                                                                                   }
                                                                                                } else {
                                                                                                   var21 = var30[var19];
                                                                                                   class81.intStack[++class5.intStackSize - 1] = class237.widgetSettings[var21];
                                                                                                }
                                                                                             } else {
                                                                                                class81.intStack[++class5.intStackSize - 1] = var30[var19];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var44;
                                                                                             if(var3.intOperands[var19] == 1) {
                                                                                                var44 = true;
                                                                                             } else {
                                                                                                var44 = false;
                                                                                             }

                                                                                             var23 = class55.method855(var7, var3, var44);
                                                                                             switch(var23) {
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

            for(var10 = class81.scriptStackCount - 1; var10 >= 0; --var10) {
               var27.append("").append(class81.scriptStack[var10].invokedFromScript.hash).append(" ");
            }

            var27.append("").append(var31);
            GroundObject.processClientError(var27.toString(), var28);
         }
      }
   }

   @ObfuscatedName("i")
   public static String method200(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class316.field3924[(int)(var6 - 37L * var0)];
               if(var8 == '_') {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1439027924"
   )
   static void method197(int var0) {
      ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var1 != null) {
         var1.unlink();
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)Lla;",
      garbageValue = "-487148509"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var3 << 42) + (long)var0 + ((long)var1 << 16) + ((long)var2 << 38) + ((long)var4 << 40);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = class81.getItemDefinition(var0);
      if(var1 > 1 && var9.countObj != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var10 = var9.countObj[var11];
            }
         }

         if(var10 != -1) {
            var9 = class81.getItemDefinition(var10);
         }
      }

      Model var19 = var9.getModel(1);
      if(var19 == null) {
         return null;
      } else {
         SpritePixels var20 = null;
         if(var9.notedTemplate != -1) {
            var20 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var20 == null) {
               return null;
            }
         } else if(var9.notedId != -1) {
            var20 = createSprite(var9.unnotedId, var1, var2, var3, 0, false);
            if(var20 == null) {
               return null;
            }
         } else if(var9.int3 != -1) {
            var20 = createSprite(var9.int2, var1, 0, 0, 0, false);
            if(var20 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.copyDrawRegion(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.pixels, 36, 32);
         Rasterizer2D.reset();
         Graphics3D.Rasterizer3D_method1();
         Graphics3D.method2780(16, 16);
         Graphics3D.rasterGouraudLowRes = false;
         if(var9.int3 != -1) {
            var20.drawAt(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = var16 * Graphics3D.SINE[var9.xan2d] >> 16;
         int var18 = var16 * Graphics3D.COSINE[var9.xan2d] >> 16;
         var19.calculateBoundsCylinder();
         var19.method2702(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var19.modelHeight / 2 + var17 + var9.offsetY2d, var18 + var9.offsetY2d);
         if(var9.notedId != -1) {
            var20.drawAt(0, 0);
         }

         if(var2 >= 1) {
            var8.method5838(1);
         }

         if(var2 >= 2) {
            var8.method5838(16777215);
         }

         if(var3 != 0) {
            var8.method5886(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.pixels, 36, 32);
         if(var9.notedTemplate != -1) {
            var20.drawAt(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            Resampler.field1590.method5500(Client.method1645(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.setDrawRegion(var15);
         Graphics3D.Rasterizer3D_method1();
         Graphics3D.rasterGouraudLowRes = true;
         return var8;
      }
   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-62"
   )
   @Export("worldToScreen")
   static final void worldToScreen(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class149.getTileHeight(var0, var1, Ignore.plane) - var2;
         var0 -= Varcs.cameraX;
         var3 -= class160.cameraZ;
         var1 -= BoundingBox3D.cameraY;
         int var4 = Graphics3D.SINE[class33.cameraPitch];
         int var5 = Graphics3D.COSINE[class33.cameraPitch];
         int var6 = Graphics3D.SINE[class62.cameraYaw];
         int var7 = Graphics3D.COSINE[class62.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var4 * var1 >> 16;
         var1 = var4 * var3 + var5 * var1 >> 16;
         if(var1 >= 50) {
            Client.screenX = var0 * Client.scale / var1 + Client.viewportWidth / 2;
            Client.screenY = var8 * Client.scale / var1 + Client.viewportHeight / 2;
         } else {
            Client.screenX = -1;
            Client.screenY = -1;
         }

      } else {
         Client.screenX = -1;
         Client.screenY = -1;
      }
   }
}
