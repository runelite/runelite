import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
public class class213 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1691358721
   )
   static int field2590;
   @ObfuscatedName("p")
   byte[] field2585;
   @ObfuscatedName("i")
   byte[] field2582;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1985503275
   )
   int field2587;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1735391781
   )
   int field2584;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -640318261
   )
   int field2583;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -360789733
   )
   int field2586;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1672595381
   )
   int field2589;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 952268539
   )
   int field2588;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1191670925
   )
   int field2581;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lbk;IB)V",
      garbageValue = "13"
   )
   static void method3942(ScriptEvent var0, int var1) {
      Object[] var2 = var0.objs;
      class230 var5 = var0.field756;
      boolean var4 = var5 == class230.field2886 || var5 == class230.field2880 || var5 == class230.field2878 || var5 == class230.field2884 || var5 == class230.field2879 || var5 == class230.field2881 || var5 == class230.field2882 || var5 == class230.field2883;
      Script var3;
      int var19;
      if(var4) {
         class137.field1992 = (class47)var2[0];
         Area var6 = Area.mapAreaType[class137.field1992.field556];
         var3 = KeyFocusListener.method735(var0.field756, var6.field3360, var6.field3373);
      } else {
         var19 = ((Integer)var2[0]).intValue();
         Script var8 = (Script)Script.field1421.get((long)var19);
         Script var7;
         if(var8 != null) {
            var7 = var8;
         } else {
            byte[] var9 = class28.indexScripts.getConfigData(var19, 0);
            if(var9 == null) {
               var7 = null;
            } else {
               var8 = Client.newScript(var9);
               Script.field1421.put(var8, (long)var19);
               var7 = var8;
            }
         }

         var3 = var7;
      }

      if(var3 != null) {
         class80.intStackSize = 0;
         WorldComparator.scriptStringStackSize = 0;
         var19 = -1;
         int[] var30 = var3.instructions;
         int[] var31 = var3.intOperands;
         byte var20 = -1;
         class80.scriptStackCount = 0;

         int var12;
         try {
            class80.scriptLocalInts = new int[var3.localIntCount];
            int var10 = 0;
            class80.scriptLocalStrings = new String[var3.localStringCount];
            int var11 = 0;

            int var13;
            String var21;
            for(var12 = 1; var12 < var2.length; ++var12) {
               if(var2[var12] instanceof Integer) {
                  var13 = ((Integer)var2[var12]).intValue();
                  if(var13 == -2147483647) {
                     var13 = var0.field748;
                  }

                  if(var13 == -2147483646) {
                     var13 = var0.field746;
                  }

                  if(var13 == -2147483645) {
                     var13 = var0.widget != null?var0.widget.id:-1;
                  }

                  if(var13 == -2147483644) {
                     var13 = var0.field750;
                  }

                  if(var13 == -2147483643) {
                     var13 = var0.widget != null?var0.widget.index:-1;
                  }

                  if(var13 == -2147483642) {
                     var13 = var0.field752 != null?var0.field752.id:-1;
                  }

                  if(var13 == -2147483641) {
                     var13 = var0.field752 != null?var0.field752.index:-1;
                  }

                  if(var13 == -2147483640) {
                     var13 = var0.field745;
                  }

                  if(var13 == -2147483639) {
                     var13 = var0.field753;
                  }

                  class80.scriptLocalInts[var10++] = var13;
               } else if(var2[var12] instanceof String) {
                  var21 = (String)var2[var12];
                  if(var21.equals("event_opbase")) {
                     var21 = var0.string;
                  }

                  class80.scriptLocalStrings[var11++] = var21;
               }
            }

            var12 = 0;
            class80.field1227 = var0.field755;

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
                                                                                       label322:
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
                                                                                                                                                                        int var24 = class80.intStack[--class80.intStackSize];
                                                                                                                                                                        if(var24 >= 0 && var24 <= 5000) {
                                                                                                                                                                           class80.field1221[var13] = var24;
                                                                                                                                                                           byte var25 = -1;
                                                                                                                                                                           if(var23 == 105) {
                                                                                                                                                                              var25 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           int var26 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var26 >= var24) {
                                                                                                                                                                                 continue label322;
                                                                                                                                                                              }

                                                                                                                                                                              class80.SHAPE_VERTICES[var13][var26] = var25;
                                                                                                                                                                              ++var26;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var36 == 45) {
                                                                                                                                                                        var13 = var31[var19];
                                                                                                                                                                        var23 = class80.intStack[--class80.intStackSize];
                                                                                                                                                                        if(var23 < 0 || var23 >= class80.field1221[var13]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class80.intStack[++class80.intStackSize - 1] = class80.SHAPE_VERTICES[var13][var23];
                                                                                                                                                                     } else if(var36 == 46) {
                                                                                                                                                                        var13 = var31[var19];
                                                                                                                                                                        class80.intStackSize -= 2;
                                                                                                                                                                        var23 = class80.intStack[class80.intStackSize];
                                                                                                                                                                        if(var23 < 0 || var23 >= class80.field1221[var13]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class80.SHAPE_VERTICES[var13][var23] = class80.intStack[class80.intStackSize + 1];
                                                                                                                                                                     } else if(var36 == 47) {
                                                                                                                                                                        var21 = class61.chatMessages.getVarcString(var31[var19]);
                                                                                                                                                                        if(var21 == null) {
                                                                                                                                                                           var21 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var21;
                                                                                                                                                                     } else if(var36 == 48) {
                                                                                                                                                                        class61.chatMessages.putVarcString(var31[var19], class80.scriptStringStack[--WorldComparator.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var36 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        IterableHashTable var38 = var3.switches[var31[var19]];
                                                                                                                                                                        IntegerNode var33 = (IntegerNode)var38.get((long)class80.intStack[--class80.intStackSize]);
                                                                                                                                                                        if(var33 != null) {
                                                                                                                                                                           var19 += var33.value;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     class61.chatMessages.putVarc(var31[var19], class80.intStack[--class80.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class80.intStack[++class80.intStackSize - 1] = class61.chatMessages.getVarc(var31[var19]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var13 = var31[var19];
                                                                                                                                                               Script var15 = (Script)Script.field1421.get((long)var13);
                                                                                                                                                               Script var32;
                                                                                                                                                               if(var15 != null) {
                                                                                                                                                                  var32 = var15;
                                                                                                                                                               } else {
                                                                                                                                                                  byte[] var16 = class28.indexScripts.getConfigData(var13, 0);
                                                                                                                                                                  if(var16 == null) {
                                                                                                                                                                     var32 = null;
                                                                                                                                                                  } else {
                                                                                                                                                                     var15 = Client.newScript(var16);
                                                                                                                                                                     Script.field1421.put(var15, (long)var13);
                                                                                                                                                                     var32 = var15;
                                                                                                                                                                  }
                                                                                                                                                               }

                                                                                                                                                               var15 = var32;
                                                                                                                                                               int[] var34 = new int[var32.localIntCount];
                                                                                                                                                               String[] var17 = new String[var32.localStringCount];

                                                                                                                                                               int var18;
                                                                                                                                                               for(var18 = 0; var18 < var15.intStackCount; ++var18) {
                                                                                                                                                                  var34[var18] = class80.intStack[var18 + (class80.intStackSize - var15.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var18 = 0; var18 < var15.stringStackCount; ++var18) {
                                                                                                                                                                  var17[var18] = class80.scriptStringStack[var18 + (WorldComparator.scriptStringStackSize - var15.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class80.intStackSize -= var15.intStackCount;
                                                                                                                                                               WorldComparator.scriptStringStackSize -= var15.stringStackCount;
                                                                                                                                                               ScriptState var22 = new ScriptState();
                                                                                                                                                               var22.invokedFromScript = var3;
                                                                                                                                                               var22.invokedFromPc = var19;
                                                                                                                                                               var22.savedLocalInts = class80.scriptLocalInts;
                                                                                                                                                               var22.savedLocalStrings = class80.scriptLocalStrings;
                                                                                                                                                               class80.scriptStack[++class80.scriptStackCount - 1] = var22;
                                                                                                                                                               var3 = var15;
                                                                                                                                                               var30 = var15.instructions;
                                                                                                                                                               var31 = var15.intOperands;
                                                                                                                                                               var19 = -1;
                                                                                                                                                               class80.scriptLocalInts = var34;
                                                                                                                                                               class80.scriptLocalStrings = var17;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --WorldComparator.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class80.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var13 = var31[var19];
                                                                                                                                                      WorldComparator.scriptStringStackSize -= var13;
                                                                                                                                                      String var14 = CollisionData.method3272(class80.scriptStringStack, WorldComparator.scriptStringStackSize, var13);
                                                                                                                                                      class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var14;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class80.scriptLocalStrings[var31[var19]] = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = class80.scriptLocalStrings[var31[var19]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class80.scriptLocalInts[var31[var19]] = class80.intStack[--class80.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class80.intStack[++class80.intStackSize - 1] = class80.scriptLocalInts[var31[var19]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class80.intStackSize -= 2;
                                                                                                                                       if(class80.intStack[class80.intStackSize] >= class80.intStack[class80.intStackSize + 1]) {
                                                                                                                                          var19 += var31[var19];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class80.intStackSize -= 2;
                                                                                                                                    if(class80.intStack[class80.intStackSize] <= class80.intStack[class80.intStackSize + 1]) {
                                                                                                                                       var19 += var31[var19];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var13 = var31[var19];
                                                                                                                                 Frames.method3004(var13, class80.intStack[--class80.intStackSize]);
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var13 = var31[var19];
                                                                                                                              class80.intStack[++class80.intStackSize - 1] = LoginPacket.getVarbit(var13);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class80.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var37 = class80.scriptStack[--class80.scriptStackCount];
                                                                                                                           var3 = var37.invokedFromScript;
                                                                                                                           var30 = var3.instructions;
                                                                                                                           var31 = var3.intOperands;
                                                                                                                           var19 = var37.invokedFromPc;
                                                                                                                           class80.scriptLocalInts = var37.savedLocalInts;
                                                                                                                           class80.scriptLocalStrings = var37.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class80.intStackSize -= 2;
                                                                                                                        if(class80.intStack[class80.intStackSize] > class80.intStack[class80.intStackSize + 1]) {
                                                                                                                           var19 += var31[var19];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class80.intStackSize -= 2;
                                                                                                                     if(class80.intStack[class80.intStackSize] < class80.intStack[class80.intStackSize + 1]) {
                                                                                                                        var19 += var31[var19];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class80.intStackSize -= 2;
                                                                                                                  if(class80.intStack[class80.intStackSize] == class80.intStack[class80.intStackSize + 1]) {
                                                                                                                     var19 += var31[var19];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class80.intStackSize -= 2;
                                                                                                               if(class80.intStack[class80.intStackSize] != class80.intStack[class80.intStackSize + 1]) {
                                                                                                                  var19 += var31[var19];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var19 += var31[var19];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var3.stringOperands[var19];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var13 = var31[var19];
                                                                                                      class222.widgetSettings[var13] = class80.intStack[--class80.intStackSize];
                                                                                                      WorldMapType1.method283(var13);
                                                                                                   }
                                                                                                } else {
                                                                                                   var13 = var31[var19];
                                                                                                   class80.intStack[++class80.intStackSize - 1] = class222.widgetSettings[var13];
                                                                                                }
                                                                                             } else {
                                                                                                class80.intStack[++class80.intStackSize - 1] = var31[var19];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var35;
                                                                                             if(var3.intOperands[var19] == 1) {
                                                                                                var35 = true;
                                                                                             } else {
                                                                                                var35 = false;
                                                                                             }

                                                                                             var23 = class70.method1125(var36, var3, var35);
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

            for(var12 = class80.scriptStackCount - 1; var12 >= 0; --var12) {
               var28.append("").append(class80.scriptStack[var12].invokedFromScript.hash).append(" ");
            }

            var28.append("").append(var20);
            class89.method1900(var28.toString(), var29);
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2092473238"
   )
   @Export("loadWidget")
   public static boolean loadWidget(int var0) {
      if(Widget.validInterfaces[var0]) {
         return true;
      } else if(!Widget.widgetIndex.containsFile(var0)) {
         return false;
      } else {
         int var1 = Widget.widgetIndex.fileCount(var0);
         if(var1 == 0) {
            Widget.validInterfaces[var0] = true;
            return true;
         } else {
            if(FileRequest.widgets[var0] == null) {
               FileRequest.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(FileRequest.widgets[var0][var2] == null) {
                  byte[] var3 = Widget.widgetIndex.getConfigData(var0, var2);
                  if(var3 != null) {
                     FileRequest.widgets[var0][var2] = new Widget();
                     FileRequest.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        FileRequest.widgets[var0][var2].decodeActive(new Buffer(var3));
                     } else {
                        FileRequest.widgets[var0][var2].decode(new Buffer(var3));
                     }
                  }
               }
            }

            Widget.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-67"
   )
   static final void method3941() {
      for(int var0 = 0; var0 < Client.queuedSoundEffectCount; ++var0) {
         --Client.unknownSoundValues2[var0];
         if(Client.unknownSoundValues2[var0] >= -10) {
            SoundEffect var9 = Client.audioEffects[var0];
            if(var9 == null) {
               Object var10000 = null;
               var9 = SoundEffect.getTrack(class23.indexCache4, Client.queuedSoundEffectIDs[var0], 0);
               if(var9 == null) {
                  continue;
               }

               Client.unknownSoundValues2[var0] += var9.calculateDelay();
               Client.audioEffects[var0] = var9;
            }

            if(Client.unknownSoundValues2[var0] < 0) {
               int var2;
               if(Client.soundLocations[var0] != 0) {
                  int var3 = (Client.soundLocations[var0] & 255) * 128;
                  int var4 = Client.soundLocations[var0] >> 16 & 255;
                  int var5 = var4 * 128 + 64 - class36.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.soundLocations[var0] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - class36.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var5 + var7 - 128;
                  if(var8 > var3) {
                     Client.unknownSoundValues2[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * Client.field879 / var3;
               } else {
                  var2 = Client.field1008;
               }

               if(var2 > 0) {
                  RawAudioNode var10 = var9.method2109().applyResampler(PacketNode.field2406);
                  class114 var11 = class114.method2285(var10, 100, var2);
                  var11.method2288(Client.unknownSoundValues1[var0] - 1);
                  CombatInfoListHolder.field1251.method2080(var11);
               }

               Client.unknownSoundValues2[var0] = -100;
            }
         } else {
            --Client.queuedSoundEffectCount;

            for(int var1 = var0; var1 < Client.queuedSoundEffectCount; ++var1) {
               Client.queuedSoundEffectIDs[var1] = Client.queuedSoundEffectIDs[var1 + 1];
               Client.audioEffects[var1] = Client.audioEffects[var1 + 1];
               Client.unknownSoundValues1[var1] = Client.unknownSoundValues1[var1 + 1];
               Client.unknownSoundValues2[var1] = Client.unknownSoundValues2[var1 + 1];
               Client.soundLocations[var1] = Client.soundLocations[var1 + 1];
            }

            --var0;
         }
      }

      if(Client.field1014 && !DynamicObject.loadCurrentSong()) {
         if(Client.field1040 != 0 && Client.field1041 != -1) {
            class163.method3202(class148.indexTrack1, Client.field1041, 0, Client.field1040, false);
         }

         Client.field1014 = false;
      }

   }
}
