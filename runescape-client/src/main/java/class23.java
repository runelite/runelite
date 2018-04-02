import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class23 {
   @ObfuscatedName("re")
   static short[] field340;
   @ObfuscatedName("kc")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   static Widget field331;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lhz;IIB)I",
      garbageValue = "-47"
   )
   static int method190(IterableHashTable var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         IntegerNode var3 = (IntegerNode)var0.get((long)var1);
         return var3 == null?var2:var3.value;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lbq;IB)V",
      garbageValue = "1"
   )
   @Export("runScript")
   static void runScript(ScriptEvent var0, int var1) {
      Object[] var2 = var0.objs;
      class245 var5 = var0.field789;
      boolean var4 = var5 == class245.field2950 || var5 == class245.field2951 || var5 == class245.field2959 || var5 == class245.field2949 || var5 == class245.field2953 || var5 == class245.field2952 || var5 == class245.field2955 || var5 == class245.field2956;
      Script var3;
      int var19;
      if(var4) {
         class36.scriptMapIconReference = (MapIconReference)var2[0];
         Area var6 = Area.mapAreaType[class36.scriptMapIconReference.areaId];
         var3 = class46.method688(var0.field789, var6.id, var6.field3463);
      } else {
         var19 = ((Integer)var2[0]).intValue();
         Script var8 = (Script)Script.field1449.get((long)var19);
         Script var7;
         if(var8 != null) {
            var7 = var8;
         } else {
            byte[] var9 = MapLabel.indexScripts.getConfigData(var19, 0);
            if(var9 == null) {
               var7 = null;
            } else {
               var8 = Projectile.newScript(var9);
               Script.field1449.put(var8, (long)var19);
               var7 = var8;
            }
         }

         var3 = var7;
      }

      if(var3 != null) {
         SceneTilePaint.intStackSize = 0;
         World.scriptStringStackSize = 0;
         var19 = -1;
         int[] var30 = var3.instructions;
         int[] var31 = var3.intOperands;
         byte var20 = -1;
         class81.scriptStackCount = 0;

         int var12;
         try {
            class55.scriptLocalInts = new int[var3.localIntCount];
            int var10 = 0;
            class234.scriptLocalStrings = new String[var3.localStringCount];
            int var11 = 0;

            int var13;
            String var21;
            for(var12 = 1; var12 < var2.length; ++var12) {
               if(var2[var12] instanceof Integer) {
                  var13 = ((Integer)var2[var12]).intValue();
                  if(var13 == -2147483647) {
                     var13 = var0.field783;
                  }

                  if(var13 == -2147483646) {
                     var13 = var0.field778;
                  }

                  if(var13 == -2147483645) {
                     var13 = var0.widget != null?var0.widget.id:-1;
                  }

                  if(var13 == -2147483644) {
                     var13 = var0.field791;
                  }

                  if(var13 == -2147483643) {
                     var13 = var0.widget != null?var0.widget.index:-1;
                  }

                  if(var13 == -2147483642) {
                     var13 = var0.field784 != null?var0.field784.id:-1;
                  }

                  if(var13 == -2147483641) {
                     var13 = var0.field784 != null?var0.field784.index:-1;
                  }

                  if(var13 == -2147483640) {
                     var13 = var0.pressedKey;
                  }

                  if(var13 == -2147483639) {
                     var13 = var0.typedKey;
                  }

                  class55.scriptLocalInts[var10++] = var13;
               } else if(var2[var12] instanceof String) {
                  var21 = (String)var2[var12];
                  if(var21.equals("event_opbase")) {
                     var21 = var0.string;
                  }

                  class234.scriptLocalStrings[var11++] = var21;
               }
            }

            var12 = 0;
            class81.field1278 = var0.field788;

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
                                                                                       label317:
                                                                                       while(true) {
                                                                                          ++var12;
                                                                                          if(var12 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var19;
                                                                                          int var36 = var30[var19];
                                                                                          int var23;
                                                                                          if(var36 < 100) {
                                                                                             if(var36 != 0) {
                                                                                                if(var36 != 1) {
                                                                                                   if(var36 != 2) {
                                                                                                      if(var36 != 3) {
                                                                                                         if(var36 != 6) {
                                                                                                            if(var36 != 7) {
                                                                                                               if(var36 != 8) {
                                                                                                                  if(var36 != 9) {
                                                                                                                     if(var36 != 10) {
                                                                                                                        if(var36 != 21) {
                                                                                                                           if(var36 != 25) {
                                                                                                                              if(var36 != 27) {
                                                                                                                                 if(var36 != 31) {
                                                                                                                                    if(var36 != 32) {
                                                                                                                                       if(var36 != 33) {
                                                                                                                                          if(var36 != 34) {
                                                                                                                                             if(var36 != 35) {
                                                                                                                                                if(var36 != 36) {
                                                                                                                                                   if(var36 != 37) {
                                                                                                                                                      if(var36 != 38) {
                                                                                                                                                         if(var36 != 39) {
                                                                                                                                                            if(var36 != 40) {
                                                                                                                                                               if(var36 != 42) {
                                                                                                                                                                  if(var36 != 43) {
                                                                                                                                                                     if(var36 == 44) {
                                                                                                                                                                        var13 = var31[var19] >> 16;
                                                                                                                                                                        var23 = var31[var19] & 65535;
                                                                                                                                                                        int var24 = class81.intStack[--SceneTilePaint.intStackSize];
                                                                                                                                                                        if(var24 >= 0 && var24 <= 5000) {
                                                                                                                                                                           class81.field1270[var13] = var24;
                                                                                                                                                                           byte var25 = -1;
                                                                                                                                                                           if(var23 == 105) {
                                                                                                                                                                              var25 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           int var26 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var26 >= var24) {
                                                                                                                                                                                 continue label317;
                                                                                                                                                                              }

                                                                                                                                                                              class81.SHAPE_VERTICES[var13][var26] = var25;
                                                                                                                                                                              ++var26;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var36 == 45) {
                                                                                                                                                                        var13 = var31[var19];
                                                                                                                                                                        var23 = class81.intStack[--SceneTilePaint.intStackSize];
                                                                                                                                                                        if(var23 < 0 || var23 >= class81.field1270[var13]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class81.intStack[++SceneTilePaint.intStackSize - 1] = class81.SHAPE_VERTICES[var13][var23];
                                                                                                                                                                     } else if(var36 == 46) {
                                                                                                                                                                        var13 = var31[var19];
                                                                                                                                                                        SceneTilePaint.intStackSize -= 2;
                                                                                                                                                                        var23 = class81.intStack[SceneTilePaint.intStackSize];
                                                                                                                                                                        if(var23 < 0 || var23 >= class81.field1270[var13]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class81.SHAPE_VERTICES[var13][var23] = class81.intStack[SceneTilePaint.intStackSize + 1];
                                                                                                                                                                     } else if(var36 == 47) {
                                                                                                                                                                        var21 = class158.varcs.getVarcString(var31[var19]);
                                                                                                                                                                        if(var21 == null) {
                                                                                                                                                                           var21 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class81.scriptStringStack[++World.scriptStringStackSize - 1] = var21;
                                                                                                                                                                     } else if(var36 == 48) {
                                                                                                                                                                        class158.varcs.putVarcString(var31[var19], class81.scriptStringStack[--World.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var36 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        IterableHashTable var38 = var3.switches[var31[var19]];
                                                                                                                                                                        IntegerNode var33 = (IntegerNode)var38.get((long)class81.intStack[--SceneTilePaint.intStackSize]);
                                                                                                                                                                        if(var33 != null) {
                                                                                                                                                                           var19 += var33.value;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     class158.varcs.putVarc(var31[var19], class81.intStack[--SceneTilePaint.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class81.intStack[++SceneTilePaint.intStackSize - 1] = class158.varcs.getVarc(var31[var19]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var13 = var31[var19];
                                                                                                                                                               Script var15 = (Script)Script.field1449.get((long)var13);
                                                                                                                                                               Script var32;
                                                                                                                                                               if(var15 != null) {
                                                                                                                                                                  var32 = var15;
                                                                                                                                                               } else {
                                                                                                                                                                  byte[] var16 = MapLabel.indexScripts.getConfigData(var13, 0);
                                                                                                                                                                  if(var16 == null) {
                                                                                                                                                                     var32 = null;
                                                                                                                                                                  } else {
                                                                                                                                                                     var15 = Projectile.newScript(var16);
                                                                                                                                                                     Script.field1449.put(var15, (long)var13);
                                                                                                                                                                     var32 = var15;
                                                                                                                                                                  }
                                                                                                                                                               }

                                                                                                                                                               var15 = var32;
                                                                                                                                                               int[] var34 = new int[var32.localIntCount];
                                                                                                                                                               String[] var17 = new String[var32.localStringCount];

                                                                                                                                                               int var18;
                                                                                                                                                               for(var18 = 0; var18 < var15.intStackCount; ++var18) {
                                                                                                                                                                  var34[var18] = class81.intStack[var18 + (SceneTilePaint.intStackSize - var15.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var18 = 0; var18 < var15.stringStackCount; ++var18) {
                                                                                                                                                                  var17[var18] = class81.scriptStringStack[var18 + (World.scriptStringStackSize - var15.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               SceneTilePaint.intStackSize -= var15.intStackCount;
                                                                                                                                                               World.scriptStringStackSize -= var15.stringStackCount;
                                                                                                                                                               ScriptState var22 = new ScriptState();
                                                                                                                                                               var22.invokedFromScript = var3;
                                                                                                                                                               var22.invokedFromPc = var19;
                                                                                                                                                               var22.savedLocalInts = class55.scriptLocalInts;
                                                                                                                                                               var22.savedLocalStrings = class234.scriptLocalStrings;
                                                                                                                                                               class81.scriptStack[++class81.scriptStackCount - 1] = var22;
                                                                                                                                                               var3 = var15;
                                                                                                                                                               var30 = var15.instructions;
                                                                                                                                                               var31 = var15.intOperands;
                                                                                                                                                               var19 = -1;
                                                                                                                                                               class55.scriptLocalInts = var34;
                                                                                                                                                               class234.scriptLocalStrings = var17;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --World.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --SceneTilePaint.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var13 = var31[var19];
                                                                                                                                                      World.scriptStringStackSize -= var13;
                                                                                                                                                      String var14 = class7.method43(class81.scriptStringStack, World.scriptStringStackSize, var13);
                                                                                                                                                      class81.scriptStringStack[++World.scriptStringStackSize - 1] = var14;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class234.scriptLocalStrings[var31[var19]] = class81.scriptStringStack[--World.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class81.scriptStringStack[++World.scriptStringStackSize - 1] = class234.scriptLocalStrings[var31[var19]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class55.scriptLocalInts[var31[var19]] = class81.intStack[--SceneTilePaint.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class81.intStack[++SceneTilePaint.intStackSize - 1] = class55.scriptLocalInts[var31[var19]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       SceneTilePaint.intStackSize -= 2;
                                                                                                                                       if(class81.intStack[SceneTilePaint.intStackSize] >= class81.intStack[SceneTilePaint.intStackSize + 1]) {
                                                                                                                                          var19 += var31[var19];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    SceneTilePaint.intStackSize -= 2;
                                                                                                                                    if(class81.intStack[SceneTilePaint.intStackSize] <= class81.intStack[SceneTilePaint.intStackSize + 1]) {
                                                                                                                                       var19 += var31[var19];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var13 = var31[var19];
                                                                                                                                 GameCanvas.method819(var13, class81.intStack[--SceneTilePaint.intStackSize]);
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var13 = var31[var19];
                                                                                                                              class81.intStack[++SceneTilePaint.intStackSize - 1] = class88.getVarbit(var13);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class81.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var37 = class81.scriptStack[--class81.scriptStackCount];
                                                                                                                           var3 = var37.invokedFromScript;
                                                                                                                           var30 = var3.instructions;
                                                                                                                           var31 = var3.intOperands;
                                                                                                                           var19 = var37.invokedFromPc;
                                                                                                                           class55.scriptLocalInts = var37.savedLocalInts;
                                                                                                                           class234.scriptLocalStrings = var37.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        SceneTilePaint.intStackSize -= 2;
                                                                                                                        if(class81.intStack[SceneTilePaint.intStackSize] > class81.intStack[SceneTilePaint.intStackSize + 1]) {
                                                                                                                           var19 += var31[var19];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     SceneTilePaint.intStackSize -= 2;
                                                                                                                     if(class81.intStack[SceneTilePaint.intStackSize] < class81.intStack[SceneTilePaint.intStackSize + 1]) {
                                                                                                                        var19 += var31[var19];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  SceneTilePaint.intStackSize -= 2;
                                                                                                                  if(class81.intStack[SceneTilePaint.intStackSize] == class81.intStack[SceneTilePaint.intStackSize + 1]) {
                                                                                                                     var19 += var31[var19];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               SceneTilePaint.intStackSize -= 2;
                                                                                                               if(class81.intStack[SceneTilePaint.intStackSize] != class81.intStack[SceneTilePaint.intStackSize + 1]) {
                                                                                                                  var19 += var31[var19];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var19 += var31[var19];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class81.scriptStringStack[++World.scriptStringStackSize - 1] = var3.stringOperands[var19];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var13 = var31[var19];
                                                                                                      class237.clientVarps[var13] = class81.intStack[--SceneTilePaint.intStackSize];
                                                                                                      class93.method1950(var13);
                                                                                                   }
                                                                                                } else {
                                                                                                   var13 = var31[var19];
                                                                                                   class81.intStack[++SceneTilePaint.intStackSize - 1] = class237.clientVarps[var13];
                                                                                                }
                                                                                             } else {
                                                                                                class81.intStack[++SceneTilePaint.intStackSize - 1] = var31[var19];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var35;
                                                                                             if(var3.intOperands[var19] == 1) {
                                                                                                var35 = true;
                                                                                             } else {
                                                                                                var35 = false;
                                                                                             }

                                                                                             var23 = class90.method1911(var36, var3, var35);
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
         } catch (Exception var29) {
            StringBuilder var28 = new StringBuilder(30);
            var28.append("").append(var3.hash).append(" ");

            for(var12 = class81.scriptStackCount - 1; var12 >= 0; --var12) {
               var28.append("").append(class81.scriptStack[var12].invokedFromScript.hash).append(" ");
            }

            var28.append("").append(var20);
            UrlRequest.processClientError(var28.toString(), var29);
         }
      }
   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(Lgf;I)V",
      garbageValue = "-974259551"
   )
   static final void method189(PacketBuffer var0) {
      for(int var1 = 0; var1 < Client.pendingNpcFlagsCount; ++var1) {
         int var2 = Client.pendingNpcFlagsIndices[var1];
         NPC var3 = Client.cachedNPCs[var2];
         int var4 = var0.readUnsignedByte();
         int var5;
         int var6;
         int var7;
         if((var4 & 32) != 0) {
            var5 = var0.readUnsignedShortOb1();
            if(var5 == 65535) {
               var5 = -1;
            }

            var6 = var0.method3548();
            if(var5 == var3.animation && var5 != -1) {
               var7 = ISAACCipher.getAnimation(var5).replyMode;
               if(var7 == 1) {
                  var3.actionFrame = 0;
                  var3.actionFrameCycle = 0;
                  var3.actionAnimationDisable = var6;
                  var3.field1186 = 0;
               }

               if(var7 == 2) {
                  var3.field1186 = 0;
               }
            } else if(var5 == -1 || var3.animation == -1 || ISAACCipher.getAnimation(var5).forcedPriority >= ISAACCipher.getAnimation(var3.animation).forcedPriority) {
               var3.animation = var5;
               var3.actionFrame = 0;
               var3.actionFrameCycle = 0;
               var3.actionAnimationDisable = var6;
               var3.field1186 = 0;
               var3.field1194 = var3.queueSize;
            }
         }

         if((var4 & 4) != 0) {
            var3.interacting = var0.readUnsignedShortOb1();
            if(var3.interacting == 65535) {
               var3.interacting = -1;
            }
         }

         int var8;
         if((var4 & 2) != 0) {
            var5 = var0.readUnsignedShortOb1();
            var6 = var0.readUnsignedShort();
            var7 = var3.x - (var5 - PacketNode.baseX - PacketNode.baseX) * 64;
            var8 = var3.y - (var6 - BaseVarType.baseY - BaseVarType.baseY) * 64;
            if(var7 != 0 || var8 != 0) {
               var3.field1165 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
            }
         }

         if((var4 & 64) != 0) {
            var3.composition = ScriptEvent.getNpcDefinition(var0.method3513());
            var3.field1153 = var3.composition.field3702;
            var3.field1203 = var3.composition.field3728;
            var3.field1158 = var3.composition.field3707;
            var3.field1172 = var3.composition.field3709;
            var3.field1160 = var3.composition.field3710;
            var3.field1161 = var3.composition.field3711;
            var3.idlePoseAnimation = var3.composition.field3716;
            var3.field1195 = var3.composition.field3706;
            var3.field1157 = var3.composition.field3721;
         }

         if((var4 & 1) != 0) {
            var3.graphic = var0.method3716();
            var5 = var0.method3564();
            var3.field1191 = var5 >> 16;
            var3.graphicsDelay = (var5 & 65535) + Client.gameCycle;
            var3.spotAnimFrame = 0;
            var3.spotAnimFrameCycle = 0;
            if(var3.graphicsDelay > Client.gameCycle) {
               var3.spotAnimFrame = -1;
            }

            if(var3.graphic == 65535) {
               var3.graphic = -1;
            }
         }

         if((var4 & 16) != 0) {
            var3.overhead = var0.readString();
            var3.overheadTextCyclesRemaining = 100;
         }

         if((var4 & 8) != 0) {
            var5 = var0.method3549();
            int var9;
            int var10;
            int var11;
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var8 = -1;
                  var9 = -1;
                  var10 = -1;
                  var7 = var0.getUSmart();
                  if(var7 == 32767) {
                     var7 = var0.getUSmart();
                     var9 = var0.getUSmart();
                     var8 = var0.getUSmart();
                     var10 = var0.getUSmart();
                  } else if(var7 != 32766) {
                     var9 = var0.getUSmart();
                  } else {
                     var7 = -1;
                  }

                  var11 = var0.getUSmart();
                  var3.method1586(var7, var9, var8, var10, Client.gameCycle, var11);
               }
            }

            var6 = var0.readUnsignedByte();
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var0.getUSmart();
                  var9 = var0.getUSmart();
                  if(var9 != 32767) {
                     var10 = var0.getUSmart();
                     var11 = var0.readUnsignedByte();
                     int var12 = var9 > 0?var0.method3548():var11;
                     var3.setCombatInfo(var8, Client.gameCycle, var9, var10, var11, var12);
                  } else {
                     var3.method1588(var8);
                  }
               }
            }
         }
      }

   }
}
