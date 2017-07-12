import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class31 {
   @ObfuscatedName("gn")
   @Export("mapedge")
   static SpritePixels mapedge;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1253884571
   )
   final int field453;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1462557629
   )
   final int field454;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1920504659
   )
   final int field455;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = -650567781
   )
   static int field456;
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      intValue = -966178393
   )
   static int field457;
   @ObfuscatedName("gf")
   static SpritePixels[] field458;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1978284950"
   )
   static void method265(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      FileRequest var4 = (FileRequest)class238.field3268.get(var2);
      if(var4 != null) {
         class238.field3267.setHead(var4);
      }

   }

   class31(int var1, int var2, int var3) {
      this.field454 = var1;
      this.field453 = var2;
      this.field455 = var3;
   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "44"
   )
   static void method266() {
      Client.secretPacketBuffer1.offset = 0;
      Client.secretPacketBuffer2.offset = 0;
      Client.packetType = -1;
      Client.lastFrameId = 1;
      Client.secondLastFrameId = -1;
      Client.thridLastFrameId = -1;
      Client.packetLength = 0;
      Client.field973 = 0;
      Client.field942 = 0;
      class60.method1055();
      Client.field1161 = 0;
      Client.destinationX = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      XItemContainer.localPlayer = null;

      for(var0 = 0; var0 < Client.cachedNPCs.length; ++var0) {
         NPC var1 = Client.cachedNPCs[var0];
         if(var1 != null) {
            var1.interacting = -1;
            var1.field1265 = false;
         }
      }

      class1.method0();
      TextureProvider.setGameState(30);

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field1132[var0] = true;
      }

      class5.method18();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LScriptEvent;II)V",
      garbageValue = "-1681320379"
   )
   static void method267(ScriptEvent var0, int var1) {
      Object[] var2 = var0.field857;
      class219 var3 = var0.field858;
      boolean var4 = var3 == class219.field2801 || var3 == class219.field2795 || var3 == class219.field2796 || var3 == class219.field2797 || var3 == class219.field2798 || var3 == class219.field2799 || var3 == class219.field2800 || var3 == class219.field2794;
      Script var5;
      int var6;
      if(var4) {
         WorldMapType1.field449 = (class47)var2[0];
         Area var7 = Area.field3303[WorldMapType1.field449.field633];
         var5 = Client.method1231(var0.field858, var7.field3297, var7.field3307);
      } else {
         var6 = ((Integer)var2[0]).intValue();
         Script var46 = (Script)Script.field1551.get((long)var6);
         Script var8;
         if(var46 != null) {
            var8 = var46;
         } else {
            byte[] var9 = class169.indexScripts.getConfigData(var6, 0);
            if(var9 == null) {
               var8 = null;
            } else {
               var46 = class48.method738(var9);
               Script.field1551.put(var46, (long)var6);
               var8 = var46;
            }
         }

         var5 = var8;
      }

      if(var5 != null) {
         class46.intStackSize = 0;
         KeyFocusListener.scriptStringStackSize = 0;
         var6 = -1;
         int[] var47 = var5.instructions;
         int[] var48 = var5.intOperands;
         byte var49 = -1;
         class83.scriptStackCount = 0;

         int var10;
         try {
            class83.scriptLocalInts = new int[var5.localIntCount];
            int var11 = 0;
            class83.scriptLocalStrings = new String[var5.localStringCount];
            int var50 = 0;

            int var13;
            String var14;
            for(var10 = 1; var10 < var2.length; ++var10) {
               if(var2[var10] instanceof Integer) {
                  var13 = ((Integer)var2[var10]).intValue();
                  if(var13 == -2147483647) {
                     var13 = var0.field850;
                  }

                  if(var13 == -2147483646) {
                     var13 = var0.field853;
                  }

                  if(var13 == -2147483645) {
                     var13 = var0.widget != null?var0.widget.id:-1;
                  }

                  if(var13 == -2147483644) {
                     var13 = var0.field852;
                  }

                  if(var13 == -2147483643) {
                     var13 = var0.widget != null?var0.widget.index:-1;
                  }

                  if(var13 == -2147483642) {
                     var13 = var0.field859 != null?var0.field859.id:-1;
                  }

                  if(var13 == -2147483641) {
                     var13 = var0.field859 != null?var0.field859.index:-1;
                  }

                  if(var13 == -2147483640) {
                     var13 = var0.field854;
                  }

                  if(var13 == -2147483639) {
                     var13 = var0.field855;
                  }

                  class83.scriptLocalInts[var11++] = var13;
               } else if(var2[var10] instanceof String) {
                  var14 = (String)var2[var10];
                  if(var14.equals("event_opbase")) {
                     var14 = var0.field856;
                  }

                  class83.scriptLocalStrings[var50++] = var14;
               }
            }

            var10 = 0;
            class83.field1367 = var0.field851;

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
                                                                                       label2058:
                                                                                       while(true) {
                                                                                          ++var10;
                                                                                          if(var10 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var6;
                                                                                          int var15 = var47[var6];
                                                                                          int var16;
                                                                                          int var17;
                                                                                          int var18;
                                                                                          int var19;
                                                                                          int var20;
                                                                                          int var21;
                                                                                          String var22;
                                                                                          String var23;
                                                                                          String var24;
                                                                                          if(var15 < 100) {
                                                                                             if(var15 != 0) {
                                                                                                if(var15 != 1) {
                                                                                                   if(var15 != 2) {
                                                                                                      if(var15 != 3) {
                                                                                                         if(var15 != 6) {
                                                                                                            if(var15 != 7) {
                                                                                                               if(var15 != 8) {
                                                                                                                  if(var15 != 9) {
                                                                                                                     if(var15 != 10) {
                                                                                                                        if(var15 != 21) {
                                                                                                                           if(var15 != 25) {
                                                                                                                              if(var15 != 27) {
                                                                                                                                 if(var15 != 31) {
                                                                                                                                    if(var15 != 32) {
                                                                                                                                       if(var15 != 33) {
                                                                                                                                          if(var15 != 34) {
                                                                                                                                             if(var15 != 35) {
                                                                                                                                                if(var15 != 36) {
                                                                                                                                                   if(var15 != 37) {
                                                                                                                                                      if(var15 != 38) {
                                                                                                                                                         if(var15 != 39) {
                                                                                                                                                            if(var15 != 40) {
                                                                                                                                                               if(var15 != 42) {
                                                                                                                                                                  if(var15 != 43) {
                                                                                                                                                                     if(var15 == 44) {
                                                                                                                                                                        var13 = var48[var6] >> 16;
                                                                                                                                                                        var16 = var48[var6] & '\uffff';
                                                                                                                                                                        int var64 = class83.intStack[--class46.intStackSize];
                                                                                                                                                                        if(var64 >= 0 && var64 <= 5000) {
                                                                                                                                                                           class83.field1358[var13] = var64;
                                                                                                                                                                           byte var88 = -1;
                                                                                                                                                                           if(var16 == 105) {
                                                                                                                                                                              var88 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var21 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var21 >= var64) {
                                                                                                                                                                                 continue label2058;
                                                                                                                                                                              }

                                                                                                                                                                              class83.SHAPE_VERTICIES[var13][var21] = var88;
                                                                                                                                                                              ++var21;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var15 == 45) {
                                                                                                                                                                        var13 = var48[var6];
                                                                                                                                                                        var16 = class83.intStack[--class46.intStackSize];
                                                                                                                                                                        if(var16 < 0 || var16 >= class83.field1358[var13]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class83.intStack[++class46.intStackSize - 1] = class83.SHAPE_VERTICIES[var13][var16];
                                                                                                                                                                     } else if(var15 == 46) {
                                                                                                                                                                        var13 = var48[var6];
                                                                                                                                                                        class46.intStackSize -= 2;
                                                                                                                                                                        var16 = class83.intStack[class46.intStackSize];
                                                                                                                                                                        if(var16 < 0 || var16 >= class83.field1358[var13]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class83.SHAPE_VERTICIES[var13][var16] = class83.intStack[class46.intStackSize + 1];
                                                                                                                                                                     } else if(var15 == 47) {
                                                                                                                                                                        var14 = class71.chatMessages.getVarcString(var48[var6]);
                                                                                                                                                                        if(var14 == null) {
                                                                                                                                                                           var14 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var14;
                                                                                                                                                                     } else if(var15 == 48) {
                                                                                                                                                                        class71.chatMessages.putVarcString(var48[var6], class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var15 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        class186 var63 = var5.switches[var48[var6]];
                                                                                                                                                                        WidgetConfig var87 = (WidgetConfig)var63.method3478((long)class83.intStack[--class46.intStackSize]);
                                                                                                                                                                        if(var87 != null) {
                                                                                                                                                                           var6 += var87.config;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     class71.chatMessages.putVarc(var48[var6], class83.intStack[--class46.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class83.intStack[++class46.intStackSize - 1] = class71.chatMessages.getVarc(var48[var6]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var13 = var48[var6];
                                                                                                                                                               Script var61 = (Script)Script.field1551.get((long)var13);
                                                                                                                                                               Script var86;
                                                                                                                                                               if(var61 != null) {
                                                                                                                                                                  var86 = var61;
                                                                                                                                                               } else {
                                                                                                                                                                  byte[] var52 = class169.indexScripts.getConfigData(var13, 0);
                                                                                                                                                                  if(var52 == null) {
                                                                                                                                                                     var86 = null;
                                                                                                                                                                  } else {
                                                                                                                                                                     var61 = class48.method738(var52);
                                                                                                                                                                     Script.field1551.put(var61, (long)var13);
                                                                                                                                                                     var86 = var61;
                                                                                                                                                                  }
                                                                                                                                                               }

                                                                                                                                                               var61 = var86;
                                                                                                                                                               int[] var53 = new int[var86.localIntCount];
                                                                                                                                                               String[] var55 = new String[var86.localStringCount];

                                                                                                                                                               for(var18 = 0; var18 < var61.intStackCount; ++var18) {
                                                                                                                                                                  var53[var18] = class83.intStack[var18 + (class46.intStackSize - var61.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var18 = 0; var18 < var61.stringStackCount; ++var18) {
                                                                                                                                                                  var55[var18] = class83.scriptStringStack[var18 + (KeyFocusListener.scriptStringStackSize - var61.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class46.intStackSize -= var61.intStackCount;
                                                                                                                                                               KeyFocusListener.scriptStringStackSize -= var61.stringStackCount;
                                                                                                                                                               ScriptState var54 = new ScriptState();
                                                                                                                                                               var54.invokedFromScript = var5;
                                                                                                                                                               var54.invokedFromPc = var6;
                                                                                                                                                               var54.savedLocalInts = class83.scriptLocalInts;
                                                                                                                                                               var54.savedLocalStrings = class83.scriptLocalStrings;
                                                                                                                                                               class83.scriptStack[++class83.scriptStackCount - 1] = var54;
                                                                                                                                                               var5 = var61;
                                                                                                                                                               var47 = var61.instructions;
                                                                                                                                                               var48 = var61.intOperands;
                                                                                                                                                               var6 = -1;
                                                                                                                                                               class83.scriptLocalInts = var53;
                                                                                                                                                               class83.scriptLocalStrings = var55;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --KeyFocusListener.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class46.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var13 = var48[var6];
                                                                                                                                                      KeyFocusListener.scriptStringStackSize -= var13;
                                                                                                                                                      String[] var59 = class83.scriptStringStack;
                                                                                                                                                      var17 = KeyFocusListener.scriptStringStackSize;
                                                                                                                                                      String var85;
                                                                                                                                                      if(var13 == 0) {
                                                                                                                                                         var85 = "";
                                                                                                                                                      } else if(var13 == 1) {
                                                                                                                                                         var23 = var59[var17];
                                                                                                                                                         if(var23 == null) {
                                                                                                                                                            var85 = "null";
                                                                                                                                                         } else {
                                                                                                                                                            var85 = var23.toString();
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         var21 = var13 + var17;
                                                                                                                                                         var18 = 0;

                                                                                                                                                         for(var20 = var17; var20 < var21; ++var20) {
                                                                                                                                                            var22 = var59[var20];
                                                                                                                                                            if(var22 == null) {
                                                                                                                                                               var18 += 4;
                                                                                                                                                            } else {
                                                                                                                                                               var18 += var22.length();
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         StringBuilder var51 = new StringBuilder(var18);

                                                                                                                                                         for(var19 = var17; var19 < var21; ++var19) {
                                                                                                                                                            var24 = var59[var19];
                                                                                                                                                            if(var24 == null) {
                                                                                                                                                               var51.append("null");
                                                                                                                                                            } else {
                                                                                                                                                               var51.append(var24);
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         var85 = var51.toString();
                                                                                                                                                      }

                                                                                                                                                      class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var85;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class83.scriptLocalStrings[var48[var6]] = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = class83.scriptLocalStrings[var48[var6]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class83.scriptLocalInts[var48[var6]] = class83.intStack[--class46.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = class83.scriptLocalInts[var48[var6]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class46.intStackSize -= 2;
                                                                                                                                       if(class83.intStack[class46.intStackSize] >= class83.intStack[class46.intStackSize + 1]) {
                                                                                                                                          var6 += var48[var6];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class46.intStackSize -= 2;
                                                                                                                                    if(class83.intStack[class46.intStackSize] <= class83.intStack[class46.intStackSize + 1]) {
                                                                                                                                       var6 += var48[var6];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var13 = var48[var6];
                                                                                                                                 DynamicObject.method1874(var13, class83.intStack[--class46.intStackSize]);
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var13 = var48[var6];
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = WorldMapType1.method264(var13);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class83.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var58 = class83.scriptStack[--class83.scriptStackCount];
                                                                                                                           var5 = var58.invokedFromScript;
                                                                                                                           var47 = var5.instructions;
                                                                                                                           var48 = var5.intOperands;
                                                                                                                           var6 = var58.invokedFromPc;
                                                                                                                           class83.scriptLocalInts = var58.savedLocalInts;
                                                                                                                           class83.scriptLocalStrings = var58.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class46.intStackSize -= 2;
                                                                                                                        if(class83.intStack[class46.intStackSize] > class83.intStack[class46.intStackSize + 1]) {
                                                                                                                           var6 += var48[var6];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class46.intStackSize -= 2;
                                                                                                                     if(class83.intStack[class46.intStackSize] < class83.intStack[class46.intStackSize + 1]) {
                                                                                                                        var6 += var48[var6];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class46.intStackSize -= 2;
                                                                                                                  if(class83.intStack[class46.intStackSize] == class83.intStack[class46.intStackSize + 1]) {
                                                                                                                     var6 += var48[var6];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class46.intStackSize -= 2;
                                                                                                               if(class83.intStack[class46.intStackSize] != class83.intStack[1 + class46.intStackSize]) {
                                                                                                                  var6 += var48[var6];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var6 += var48[var6];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var5.stringOperands[var6];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var13 = var48[var6];
                                                                                                      class211.widgetSettings[var13] = class83.intStack[--class46.intStackSize];
                                                                                                      Preferences.method1614(var13);
                                                                                                   }
                                                                                                } else {
                                                                                                   var13 = var48[var6];
                                                                                                   class83.intStack[++class46.intStackSize - 1] = class211.widgetSettings[var13];
                                                                                                }
                                                                                             } else {
                                                                                                class83.intStack[++class46.intStackSize - 1] = var48[var6];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var25;
                                                                                             if(var5.intOperands[var6] == 1) {
                                                                                                var25 = true;
                                                                                             } else {
                                                                                                var25 = false;
                                                                                             }

                                                                                             if(var15 < 1000) {
                                                                                                var16 = class33.method345(var15, var5, var25);
                                                                                             } else if(var15 < 1100) {
                                                                                                var16 = class170.method3117(var15, var5, var25);
                                                                                             } else if(var15 < 1200) {
                                                                                                var16 = class261.method4736(var15, var5, var25);
                                                                                             } else if(var15 < 1300) {
                                                                                                var16 = PacketBuffer.method3414(var15, var5, var25);
                                                                                             } else if(var15 < 1400) {
                                                                                                var16 = class39.method559(var15, var5, var25);
                                                                                             } else if(var15 < 1500) {
                                                                                                var16 = SoundTask.method2081(var15, var5, var25);
                                                                                             } else {
                                                                                                byte var26;
                                                                                                Widget var27;
                                                                                                if(var15 < 1600) {
                                                                                                   var27 = var25?class83.field1364:class60.field766;
                                                                                                   if(var15 == 1500) {
                                                                                                      class83.intStack[++class46.intStackSize - 1] = var27.relativeX;
                                                                                                      var26 = 1;
                                                                                                   } else if(var15 == 1501) {
                                                                                                      class83.intStack[++class46.intStackSize - 1] = var27.relativeY;
                                                                                                      var26 = 1;
                                                                                                   } else if(var15 == 1502) {
                                                                                                      class83.intStack[++class46.intStackSize - 1] = var27.width;
                                                                                                      var26 = 1;
                                                                                                   } else if(var15 == 1503) {
                                                                                                      class83.intStack[++class46.intStackSize - 1] = var27.height;
                                                                                                      var26 = 1;
                                                                                                   } else if(var15 == 1504) {
                                                                                                      class83.intStack[++class46.intStackSize - 1] = var27.isHidden?1:0;
                                                                                                      var26 = 1;
                                                                                                   } else if(var15 == 1505) {
                                                                                                      class83.intStack[++class46.intStackSize - 1] = var27.parentId;
                                                                                                      var26 = 1;
                                                                                                   } else {
                                                                                                      var26 = 2;
                                                                                                   }

                                                                                                   var16 = var26;
                                                                                                } else if(var15 < 1700) {
                                                                                                   var16 = class61.method1101(var15, var5, var25);
                                                                                                } else if(var15 < 1800) {
                                                                                                   var27 = var25?class83.field1364:class60.field766;
                                                                                                   if(var15 == 1700) {
                                                                                                      class83.intStack[++class46.intStackSize - 1] = var27.itemId;
                                                                                                      var26 = 1;
                                                                                                   } else if(var15 == 1701) {
                                                                                                      if(var27.itemId != -1) {
                                                                                                         class83.intStack[++class46.intStackSize - 1] = var27.itemQuantity;
                                                                                                      } else {
                                                                                                         class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                      }

                                                                                                      var26 = 1;
                                                                                                   } else if(var15 == 1702) {
                                                                                                      class83.intStack[++class46.intStackSize - 1] = var27.index;
                                                                                                      var26 = 1;
                                                                                                   } else {
                                                                                                      var26 = 2;
                                                                                                   }

                                                                                                   var16 = var26;
                                                                                                } else if(var15 < 1900) {
                                                                                                   var16 = FileOnDisk.method2366(var15, var5, var25);
                                                                                                } else {
                                                                                                   Widget var28;
                                                                                                   ScriptEvent var29;
                                                                                                   if(var15 < 2000) {
                                                                                                      var17 = var15;
                                                                                                      if(var15 >= 2000) {
                                                                                                         var17 = var15 - 1000;
                                                                                                         var28 = PacketBuffer.method3403(class83.intStack[--class46.intStackSize]);
                                                                                                      } else {
                                                                                                         var28 = var25?class83.field1364:class60.field766;
                                                                                                      }

                                                                                                      if(var17 == 1927) {
                                                                                                         if(class83.field1367 >= 10) {
                                                                                                            throw new RuntimeException();
                                                                                                         }

                                                                                                         if(var28.field2763 == null) {
                                                                                                            var26 = 0;
                                                                                                         } else {
                                                                                                            var29 = new ScriptEvent();
                                                                                                            var29.widget = var28;
                                                                                                            var29.field857 = var28.field2763;
                                                                                                            var29.field851 = class83.field1367 + 1;
                                                                                                            Client.field1035.addFront(var29);
                                                                                                            var26 = 1;
                                                                                                         }
                                                                                                      } else {
                                                                                                         var26 = 2;
                                                                                                      }

                                                                                                      var16 = var26;
                                                                                                   } else if(var15 < 2100) {
                                                                                                      var16 = class170.method3117(var15, var5, var25);
                                                                                                   } else if(var15 < 2200) {
                                                                                                      var16 = class261.method4736(var15, var5, var25);
                                                                                                   } else if(var15 < 2300) {
                                                                                                      var16 = PacketBuffer.method3414(var15, var5, var25);
                                                                                                   } else if(var15 < 2400) {
                                                                                                      var16 = class39.method559(var15, var5, var25);
                                                                                                   } else if(var15 < 2500) {
                                                                                                      var16 = SoundTask.method2081(var15, var5, var25);
                                                                                                   } else if(var15 < 2600) {
                                                                                                      var16 = class207.method3862(var15, var5, var25);
                                                                                                   } else if(var15 < 2700) {
                                                                                                      var16 = class71.method1141(var15, var5, var25);
                                                                                                   } else {
                                                                                                      Widget var30;
                                                                                                      if(var15 < 2800) {
                                                                                                         if(var15 == 2700) {
                                                                                                            var30 = PacketBuffer.method3403(class83.intStack[--class46.intStackSize]);
                                                                                                            class83.intStack[++class46.intStackSize - 1] = var30.itemId;
                                                                                                            var26 = 1;
                                                                                                         } else if(var15 == 2701) {
                                                                                                            var30 = PacketBuffer.method3403(class83.intStack[--class46.intStackSize]);
                                                                                                            if(var30.itemId != -1) {
                                                                                                               class83.intStack[++class46.intStackSize - 1] = var30.itemQuantity;
                                                                                                            } else {
                                                                                                               class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                            }

                                                                                                            var26 = 1;
                                                                                                         } else if(var15 == 2702) {
                                                                                                            var17 = class83.intStack[--class46.intStackSize];
                                                                                                            WidgetNode var31 = (WidgetNode)Client.componentTable.get((long)var17);
                                                                                                            if(var31 != null) {
                                                                                                               class83.intStack[++class46.intStackSize - 1] = 1;
                                                                                                            } else {
                                                                                                               class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                            }

                                                                                                            var26 = 1;
                                                                                                         } else if(var15 == 2706) {
                                                                                                            class83.intStack[++class46.intStackSize - 1] = Client.widgetRoot;
                                                                                                            var26 = 1;
                                                                                                         } else {
                                                                                                            var26 = 2;
                                                                                                         }

                                                                                                         var16 = var26;
                                                                                                      } else if(var15 < 2900) {
                                                                                                         var30 = PacketBuffer.method3403(class83.intStack[--class46.intStackSize]);
                                                                                                         if(var15 == 2800) {
                                                                                                            int[] var56 = class83.intStack;
                                                                                                            var18 = ++class46.intStackSize - 1;
                                                                                                            var19 = WorldMapType3.getWidgetConfig(var30);
                                                                                                            var20 = var19 >> 11 & 63;
                                                                                                            var56[var18] = var20;
                                                                                                            var26 = 1;
                                                                                                         } else if(var15 != 2801) {
                                                                                                            if(var15 == 2802) {
                                                                                                               if(var30.name == null) {
                                                                                                                  class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                               } else {
                                                                                                                  class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var30.name;
                                                                                                               }

                                                                                                               var26 = 1;
                                                                                                            } else {
                                                                                                               var26 = 2;
                                                                                                            }
                                                                                                         } else {
                                                                                                            var21 = class83.intStack[--class46.intStackSize];
                                                                                                            --var21;
                                                                                                            if(var30.actions != null && var21 < var30.actions.length && var30.actions[var21] != null) {
                                                                                                               class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var30.actions[var21];
                                                                                                            } else {
                                                                                                               class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                            }

                                                                                                            var26 = 1;
                                                                                                         }

                                                                                                         var16 = var26;
                                                                                                      } else if(var15 < 3000) {
                                                                                                         var17 = var15;
                                                                                                         if(var15 >= 2000) {
                                                                                                            var17 = var15 - 1000;
                                                                                                            var28 = PacketBuffer.method3403(class83.intStack[--class46.intStackSize]);
                                                                                                         } else {
                                                                                                            var28 = var25?class83.field1364:class60.field766;
                                                                                                         }

                                                                                                         if(var17 == 1927) {
                                                                                                            if(class83.field1367 >= 10) {
                                                                                                               throw new RuntimeException();
                                                                                                            }

                                                                                                            if(var28.field2763 == null) {
                                                                                                               var26 = 0;
                                                                                                            } else {
                                                                                                               var29 = new ScriptEvent();
                                                                                                               var29.widget = var28;
                                                                                                               var29.field857 = var28.field2763;
                                                                                                               var29.field851 = class83.field1367 + 1;
                                                                                                               Client.field1035.addFront(var29);
                                                                                                               var26 = 1;
                                                                                                            }
                                                                                                         } else {
                                                                                                            var26 = 2;
                                                                                                         }

                                                                                                         var16 = var26;
                                                                                                      } else {
                                                                                                         String var32;
                                                                                                         boolean var33;
                                                                                                         String var57;
                                                                                                         if(var15 < 3200) {
                                                                                                            if(var15 == 3100) {
                                                                                                               var32 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                               class152.sendGameMessage(0, "", var32);
                                                                                                               var26 = 1;
                                                                                                            } else if(var15 == 3101) {
                                                                                                               class46.intStackSize -= 2;
                                                                                                               RSCanvas.method810(XItemContainer.localPlayer, class83.intStack[class46.intStackSize], class83.intStack[class46.intStackSize + 1]);
                                                                                                               var26 = 1;
                                                                                                            } else if(var15 == 3103) {
                                                                                                               class112.method2097();
                                                                                                               var26 = 1;
                                                                                                            } else if(var15 == 3104) {
                                                                                                               var32 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                               var21 = 0;
                                                                                                               boolean var34 = class51.method795(var32, 10, true);
                                                                                                               if(var34) {
                                                                                                                  var21 = ScriptState.method1103(var32);
                                                                                                               }

                                                                                                               Client.secretPacketBuffer1.putOpcode(205);
                                                                                                               Client.secretPacketBuffer1.putInt(var21);
                                                                                                               var26 = 1;
                                                                                                            } else if(var15 == 3105) {
                                                                                                               var32 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                               Client.secretPacketBuffer1.putOpcode(43);
                                                                                                               Client.secretPacketBuffer1.putByte(var32.length() + 1);
                                                                                                               Client.secretPacketBuffer1.putString(var32);
                                                                                                               var26 = 1;
                                                                                                            } else if(var15 == 3106) {
                                                                                                               var32 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                               Client.secretPacketBuffer1.putOpcode(107);
                                                                                                               Client.secretPacketBuffer1.putByte(var32.length() + 1);
                                                                                                               Client.secretPacketBuffer1.putString(var32);
                                                                                                               var26 = 1;
                                                                                                            } else if(var15 == 3107) {
                                                                                                               var17 = class83.intStack[--class46.intStackSize];
                                                                                                               var23 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                               class60.method1051(var17, var23);
                                                                                                               var26 = 1;
                                                                                                            } else if(var15 == 3108) {
                                                                                                               class46.intStackSize -= 3;
                                                                                                               var17 = class83.intStack[class46.intStackSize];
                                                                                                               var21 = class83.intStack[class46.intStackSize + 1];
                                                                                                               var18 = class83.intStack[class46.intStackSize + 2];
                                                                                                               var27 = PacketBuffer.method3403(var18);
                                                                                                               class140.method2856(var27, var17, var21);
                                                                                                               var26 = 1;
                                                                                                            } else if(var15 == 3109) {
                                                                                                               class46.intStackSize -= 2;
                                                                                                               var17 = class83.intStack[class46.intStackSize];
                                                                                                               var21 = class83.intStack[class46.intStackSize + 1];
                                                                                                               Widget var60 = var25?class83.field1364:class60.field766;
                                                                                                               class140.method2856(var60, var17, var21);
                                                                                                               var26 = 1;
                                                                                                            } else if(var15 == 3110) {
                                                                                                               class34.field499 = class83.intStack[--class46.intStackSize] == 1;
                                                                                                               var26 = 1;
                                                                                                            } else if(var15 == 3111) {
                                                                                                               class83.intStack[++class46.intStackSize - 1] = class8.settings.hideRoofs?1:0;
                                                                                                               var26 = 1;
                                                                                                            } else if(var15 == 3112) {
                                                                                                               class8.settings.hideRoofs = class83.intStack[--class46.intStackSize] == 1;
                                                                                                               class1.method3();
                                                                                                               var26 = 1;
                                                                                                            } else if(var15 == 3113) {
                                                                                                               var32 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                               var33 = class83.intStack[--class46.intStackSize] == 1;
                                                                                                               Player.method1175(var32, var33, false);
                                                                                                               var26 = 1;
                                                                                                            } else if(var15 == 3115) {
                                                                                                               var17 = class83.intStack[--class46.intStackSize];
                                                                                                               Client.secretPacketBuffer1.putOpcode(55);
                                                                                                               Client.secretPacketBuffer1.putShort(var17);
                                                                                                               var26 = 1;
                                                                                                            } else if(var15 == 3116) {
                                                                                                               var17 = class83.intStack[--class46.intStackSize];
                                                                                                               KeyFocusListener.scriptStringStackSize -= 2;
                                                                                                               var23 = class83.scriptStringStack[KeyFocusListener.scriptStringStackSize];
                                                                                                               var57 = class83.scriptStringStack[KeyFocusListener.scriptStringStackSize + 1];
                                                                                                               if(var23.length() > 500) {
                                                                                                                  var26 = 1;
                                                                                                               } else if(var57.length() > 500) {
                                                                                                                  var26 = 1;
                                                                                                               } else {
                                                                                                                  Client.secretPacketBuffer1.putOpcode(102);
                                                                                                                  Client.secretPacketBuffer1.putShort(1 + class261.getLength(var23) + class261.getLength(var57));
                                                                                                                  Client.secretPacketBuffer1.putString(var57);
                                                                                                                  Client.secretPacketBuffer1.putString(var23);
                                                                                                                  Client.secretPacketBuffer1.putByte(var17);
                                                                                                                  var26 = 1;
                                                                                                               }
                                                                                                            } else if(var15 == 3117) {
                                                                                                               Client.field1075 = class83.intStack[--class46.intStackSize] == 1;
                                                                                                               var26 = 1;
                                                                                                            } else {
                                                                                                               var26 = 2;
                                                                                                            }

                                                                                                            var16 = var26;
                                                                                                         } else if(var15 < 3300) {
                                                                                                            if(var15 == 3200) {
                                                                                                               class46.intStackSize -= 3;
                                                                                                               class34.method356(class83.intStack[class46.intStackSize], class83.intStack[class46.intStackSize + 1], class83.intStack[class46.intStackSize + 2]);
                                                                                                               var26 = 1;
                                                                                                            } else if(var15 == 3201) {
                                                                                                               class266.method4842(class83.intStack[--class46.intStackSize]);
                                                                                                               var26 = 1;
                                                                                                            } else if(var15 == 3202) {
                                                                                                               class46.intStackSize -= 2;
                                                                                                               var17 = class83.intStack[class46.intStackSize];
                                                                                                               var21 = class83.intStack[class46.intStackSize + 1];
                                                                                                               if(Client.field1162 != 0 && var17 != -1) {
                                                                                                                  class29.method232(XGrandExchangeOffer.indexTrack2, var17, 0, Client.field1162, false);
                                                                                                                  Client.field1014 = true;
                                                                                                               }

                                                                                                               var26 = 1;
                                                                                                            } else {
                                                                                                               var26 = 2;
                                                                                                            }

                                                                                                            var16 = var26;
                                                                                                         } else {
                                                                                                            int[] var62;
                                                                                                            if(var15 < 3400) {
                                                                                                               if(var15 == 3300) {
                                                                                                                  class83.intStack[++class46.intStackSize - 1] = Client.gameCycle;
                                                                                                                  var26 = 1;
                                                                                                               } else {
                                                                                                                  XItemContainer var35;
                                                                                                                  if(var15 == 3301) {
                                                                                                                     class46.intStackSize -= 2;
                                                                                                                     var17 = class83.intStack[class46.intStackSize];
                                                                                                                     var21 = class83.intStack[class46.intStackSize + 1];
                                                                                                                     var62 = class83.intStack;
                                                                                                                     var20 = ++class46.intStackSize - 1;
                                                                                                                     var35 = (XItemContainer)XItemContainer.itemContainers.get((long)var17);
                                                                                                                     if(var35 == null) {
                                                                                                                        var19 = -1;
                                                                                                                     } else if(var21 >= 0 && var21 < var35.itemIds.length) {
                                                                                                                        var19 = var35.itemIds[var21];
                                                                                                                     } else {
                                                                                                                        var19 = -1;
                                                                                                                     }

                                                                                                                     var62[var20] = var19;
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3302) {
                                                                                                                     class46.intStackSize -= 2;
                                                                                                                     var17 = class83.intStack[class46.intStackSize];
                                                                                                                     var21 = class83.intStack[class46.intStackSize + 1];
                                                                                                                     var62 = class83.intStack;
                                                                                                                     var20 = ++class46.intStackSize - 1;
                                                                                                                     var35 = (XItemContainer)XItemContainer.itemContainers.get((long)var17);
                                                                                                                     if(var35 == null) {
                                                                                                                        var19 = 0;
                                                                                                                     } else if(var21 >= 0 && var21 < var35.stackSizes.length) {
                                                                                                                        var19 = var35.stackSizes[var21];
                                                                                                                     } else {
                                                                                                                        var19 = 0;
                                                                                                                     }

                                                                                                                     var62[var20] = var19;
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3303) {
                                                                                                                     class46.intStackSize -= 2;
                                                                                                                     var17 = class83.intStack[class46.intStackSize];
                                                                                                                     var21 = class83.intStack[class46.intStackSize + 1];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = BaseVarType.method17(var17, var21);
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3304) {
                                                                                                                     var17 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = class211.method3908(var17).field3287;
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3305) {
                                                                                                                     var17 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.boostedSkillLevels[var17];
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3306) {
                                                                                                                     var17 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.realSkillLevels[var17];
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3307) {
                                                                                                                     var17 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.skillExperiences[var17];
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3308) {
                                                                                                                     var17 = WallObject.plane;
                                                                                                                     var21 = (XItemContainer.localPlayer.x >> 7) + KeyFocusListener.baseX;
                                                                                                                     var18 = (XItemContainer.localPlayer.y >> 7) + class266.baseY;
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = var18 + (var21 << 14) + (var17 << 28);
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3309) {
                                                                                                                     var17 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = var17 >> 14 & 16383;
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3310) {
                                                                                                                     var17 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = var17 >> 28;
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3311) {
                                                                                                                     var17 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = var17 & 16383;
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3312) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.isMembers?1:0;
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3313) {
                                                                                                                     class46.intStackSize -= 2;
                                                                                                                     var17 = class83.intStack[class46.intStackSize] + '耀';
                                                                                                                     var21 = class83.intStack[class46.intStackSize + 1];
                                                                                                                     var62 = class83.intStack;
                                                                                                                     var20 = ++class46.intStackSize - 1;
                                                                                                                     var35 = (XItemContainer)XItemContainer.itemContainers.get((long)var17);
                                                                                                                     if(var35 == null) {
                                                                                                                        var19 = -1;
                                                                                                                     } else if(var21 >= 0 && var21 < var35.itemIds.length) {
                                                                                                                        var19 = var35.itemIds[var21];
                                                                                                                     } else {
                                                                                                                        var19 = -1;
                                                                                                                     }

                                                                                                                     var62[var20] = var19;
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 != 3314) {
                                                                                                                     if(var15 == 3315) {
                                                                                                                        class46.intStackSize -= 2;
                                                                                                                        var17 = class83.intStack[class46.intStackSize] + '耀';
                                                                                                                        var21 = class83.intStack[class46.intStackSize + 1];
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = BaseVarType.method17(var17, var21);
                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 == 3316) {
                                                                                                                        if(Client.rights >= 2) {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = Client.rights;
                                                                                                                        } else {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                        }

                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 == 3317) {
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = Client.field942;
                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 == 3318) {
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = Client.world;
                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 == 3321) {
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = Client.energy;
                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 == 3322) {
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = Client.weight;
                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 == 3323) {
                                                                                                                        if(Client.field1096) {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = 1;
                                                                                                                        } else {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                        }

                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 == 3324) {
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = Client.flags;
                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 == 3325) {
                                                                                                                        class46.intStackSize -= 4;
                                                                                                                        var17 = class83.intStack[class46.intStackSize];
                                                                                                                        var21 = class83.intStack[class46.intStackSize + 1];
                                                                                                                        var18 = class83.intStack[class46.intStackSize + 2];
                                                                                                                        var20 = class83.intStack[class46.intStackSize + 3];
                                                                                                                        var17 += var21 << 14;
                                                                                                                        var17 += var18 << 28;
                                                                                                                        var17 += var20;
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = var17;
                                                                                                                        var26 = 1;
                                                                                                                     } else {
                                                                                                                        var26 = 2;
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class46.intStackSize -= 2;
                                                                                                                     var17 = class83.intStack[class46.intStackSize] + '耀';
                                                                                                                     var21 = class83.intStack[class46.intStackSize + 1];
                                                                                                                     var62 = class83.intStack;
                                                                                                                     var20 = ++class46.intStackSize - 1;
                                                                                                                     var35 = (XItemContainer)XItemContainer.itemContainers.get((long)var17);
                                                                                                                     if(var35 == null) {
                                                                                                                        var19 = 0;
                                                                                                                     } else if(var21 >= 0 && var21 < var35.stackSizes.length) {
                                                                                                                        var19 = var35.stackSizes[var21];
                                                                                                                     } else {
                                                                                                                        var19 = 0;
                                                                                                                     }

                                                                                                                     var62[var20] = var19;
                                                                                                                     var26 = 1;
                                                                                                                  }
                                                                                                               }

                                                                                                               var16 = var26;
                                                                                                            } else if(var15 < 3500) {
                                                                                                               var16 = class96.method1800(var15, var5, var25);
                                                                                                            } else if(var15 < 3700) {
                                                                                                               if(var15 == 3600) {
                                                                                                                  if(Client.field1193 == 0) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = -2;
                                                                                                                  } else if(Client.field1193 == 1) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.friendCount;
                                                                                                                  }

                                                                                                                  var26 = 1;
                                                                                                               } else if(var15 == 3601) {
                                                                                                                  var17 = class83.intStack[--class46.intStackSize];
                                                                                                                  if(Client.field1193 == 2 && var17 < Client.friendCount) {
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = Client.friends[var17].name;
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = Client.friends[var17].previousName;
                                                                                                                  } else {
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var26 = 1;
                                                                                                               } else if(var15 == 3602) {
                                                                                                                  var17 = class83.intStack[--class46.intStackSize];
                                                                                                                  if(Client.field1193 == 2 && var17 < Client.friendCount) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.friends[var17].world;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var26 = 1;
                                                                                                               } else if(var15 == 3603) {
                                                                                                                  var17 = class83.intStack[--class46.intStackSize];
                                                                                                                  if(Client.field1193 == 2 && var17 < Client.friendCount) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.friends[var17].rank;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var26 = 1;
                                                                                                               } else if(var15 == 3604) {
                                                                                                                  var32 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                  var21 = class83.intStack[--class46.intStackSize];
                                                                                                                  Client.secretPacketBuffer1.putOpcode(136);
                                                                                                                  Client.secretPacketBuffer1.putByte(class261.getLength(var32) + 1);
                                                                                                                  Client.secretPacketBuffer1.putString(var32);
                                                                                                                  Client.secretPacketBuffer1.putByte(var21);
                                                                                                                  var26 = 1;
                                                                                                               } else if(var15 == 3605) {
                                                                                                                  var32 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                  if(var32 != null) {
                                                                                                                     if((Client.friendCount < 200 || Client.field1049 == 1) && Client.friendCount < 400) {
                                                                                                                        var23 = Player.method1179(var32, Client.field928);
                                                                                                                        if(var23 != null) {
                                                                                                                           var18 = 0;

                                                                                                                           label1874:
                                                                                                                           while(true) {
                                                                                                                              if(var18 >= Client.friendCount) {
                                                                                                                                 for(var18 = 0; var18 < Client.ignoreCount; ++var18) {
                                                                                                                                    Ignore var68 = Client.ignores[var18];
                                                                                                                                    var22 = Player.method1179(var68.name, Client.field928);
                                                                                                                                    if(var22 != null && var22.equals(var23)) {
                                                                                                                                       class152.sendGameMessage(30, "", "Please remove " + var32 + " from your ignore list first");
                                                                                                                                       break label1874;
                                                                                                                                    }

                                                                                                                                    if(var68.previousName != null) {
                                                                                                                                       var24 = Player.method1179(var68.previousName, Client.field928);
                                                                                                                                       if(var24 != null && var24.equals(var23)) {
                                                                                                                                          class152.sendGameMessage(30, "", "Please remove " + var32 + " from your ignore list first");
                                                                                                                                          break label1874;
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 }

                                                                                                                                 if(Player.method1179(XItemContainer.localPlayer.name, Client.field928).equals(var23)) {
                                                                                                                                    class152.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
                                                                                                                                 } else {
                                                                                                                                    Client.secretPacketBuffer1.putOpcode(240);
                                                                                                                                    Client.secretPacketBuffer1.putByte(class261.getLength(var32));
                                                                                                                                    Client.secretPacketBuffer1.putString(var32);
                                                                                                                                 }
                                                                                                                                 break;
                                                                                                                              }

                                                                                                                              Friend var67 = Client.friends[var18];
                                                                                                                              var22 = Player.method1179(var67.name, Client.field928);
                                                                                                                              if(var22 != null && var22.equals(var23)) {
                                                                                                                                 class152.sendGameMessage(30, "", var32 + " is already on your friend list");
                                                                                                                                 break;
                                                                                                                              }

                                                                                                                              if(var67.previousName != null) {
                                                                                                                                 var24 = Player.method1179(var67.previousName, Client.field928);
                                                                                                                                 if(var24 != null && var24.equals(var23)) {
                                                                                                                                    class152.sendGameMessage(30, "", var32 + " is already on your friend list");
                                                                                                                                    break;
                                                                                                                                 }
                                                                                                                              }

                                                                                                                              ++var18;
                                                                                                                           }
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class152.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var26 = 1;
                                                                                                               } else if(var15 == 3606) {
                                                                                                                  var32 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                  DynamicObject.method1873(var32);
                                                                                                                  var26 = 1;
                                                                                                               } else if(var15 == 3607) {
                                                                                                                  var32 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                  GameObject.method2891(var32, false);
                                                                                                                  var26 = 1;
                                                                                                               } else if(var15 == 3608) {
                                                                                                                  var32 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                  KeyFocusListener.method789(var32);
                                                                                                                  var26 = 1;
                                                                                                               } else if(var15 == 3609) {
                                                                                                                  var32 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                  Permission[] var65 = Widget.method4032();

                                                                                                                  for(var18 = 0; var18 < var65.length; ++var18) {
                                                                                                                     Permission var36 = var65[var18];
                                                                                                                     if(var36.field3186 != -1 && var32.startsWith(class41.method609(var36.field3186))) {
                                                                                                                        var32 = var32.substring(6 + Integer.toString(var36.field3186).length());
                                                                                                                        break;
                                                                                                                     }
                                                                                                                  }

                                                                                                                  class83.intStack[++class46.intStackSize - 1] = class25.isFriended(var32, false)?1:0;
                                                                                                                  var26 = 1;
                                                                                                               } else if(var15 == 3611) {
                                                                                                                  if(Client.clanChatOwner != null) {
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = CombatInfoListHolder.method1690(Client.clanChatOwner);
                                                                                                                  } else {
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var26 = 1;
                                                                                                               } else if(var15 == 3612) {
                                                                                                                  if(Client.clanChatOwner != null) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = class28.clanChatCount;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var26 = 1;
                                                                                                               } else if(var15 == 3613) {
                                                                                                                  var17 = class83.intStack[--class46.intStackSize];
                                                                                                                  if(Client.clanChatOwner != null && var17 < class28.clanChatCount) {
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = class11.clanMembers[var17].username;
                                                                                                                  } else {
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var26 = 1;
                                                                                                               } else if(var15 == 3614) {
                                                                                                                  var17 = class83.intStack[--class46.intStackSize];
                                                                                                                  if(Client.clanChatOwner != null && var17 < class28.clanChatCount) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = class11.clanMembers[var17].world;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var26 = 1;
                                                                                                               } else if(var15 == 3615) {
                                                                                                                  var17 = class83.intStack[--class46.intStackSize];
                                                                                                                  if(Client.clanChatOwner != null && var17 < class28.clanChatCount) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = class11.clanMembers[var17].rank;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var26 = 1;
                                                                                                               } else if(var15 == 3616) {
                                                                                                                  class83.intStack[++class46.intStackSize - 1] = class12.field271;
                                                                                                                  var26 = 1;
                                                                                                               } else if(var15 == 3617) {
                                                                                                                  var32 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                  XGrandExchangeOffer.method111(var32);
                                                                                                                  var26 = 1;
                                                                                                               } else if(var15 == 3618) {
                                                                                                                  class83.intStack[++class46.intStackSize - 1] = class35.clanChatRank;
                                                                                                                  var26 = 1;
                                                                                                               } else if(var15 == 3619) {
                                                                                                                  var32 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                  class96.method1797(var32);
                                                                                                                  var26 = 1;
                                                                                                               } else if(var15 == 3620) {
                                                                                                                  Actor.method1548();
                                                                                                                  var26 = 1;
                                                                                                               } else if(var15 == 3621) {
                                                                                                                  if(Client.field1193 == 0) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.ignoreCount;
                                                                                                                  }

                                                                                                                  var26 = 1;
                                                                                                               } else if(var15 == 3622) {
                                                                                                                  var17 = class83.intStack[--class46.intStackSize];
                                                                                                                  if(Client.field1193 != 0 && var17 < Client.ignoreCount) {
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = Client.ignores[var17].name;
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = Client.ignores[var17].previousName;
                                                                                                                  } else {
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var26 = 1;
                                                                                                               } else if(var15 == 3623) {
                                                                                                                  var32 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                  if(var32.startsWith(class41.method609(0)) || var32.startsWith(class41.method609(1))) {
                                                                                                                     var32 = var32.substring(7);
                                                                                                                  }

                                                                                                                  class83.intStack[++class46.intStackSize - 1] = class1.isIgnored(var32)?1:0;
                                                                                                                  var26 = 1;
                                                                                                               } else if(var15 != 3624) {
                                                                                                                  if(var15 == 3625) {
                                                                                                                     if(Client.clanChatName != null) {
                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = CombatInfoListHolder.method1690(Client.clanChatName);
                                                                                                                     } else {
                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var26 = 1;
                                                                                                                  } else {
                                                                                                                     var26 = 2;
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  var17 = class83.intStack[--class46.intStackSize];
                                                                                                                  if(class11.clanMembers != null && var17 < class28.clanChatCount && class11.clanMembers[var17].username.equalsIgnoreCase(XItemContainer.localPlayer.name)) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = 1;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var26 = 1;
                                                                                                               }

                                                                                                               var16 = var26;
                                                                                                            } else {
                                                                                                               boolean var66;
                                                                                                               int var69;
                                                                                                               if(var15 < 4000) {
                                                                                                                  if(var15 == 3903) {
                                                                                                                     var17 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.grandExchangeOffers[var17].method91();
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3904) {
                                                                                                                     var17 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.grandExchangeOffers[var17].itemId;
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3905) {
                                                                                                                     var17 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.grandExchangeOffers[var17].price;
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3906) {
                                                                                                                     var17 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.grandExchangeOffers[var17].totalQuantity;
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3907) {
                                                                                                                     var17 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.grandExchangeOffers[var17].quantitySold;
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3908) {
                                                                                                                     var17 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.grandExchangeOffers[var17].spent;
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3910) {
                                                                                                                     var17 = class83.intStack[--class46.intStackSize];
                                                                                                                     var21 = Client.grandExchangeOffers[var17].method87();
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = var21 == 0?1:0;
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3911) {
                                                                                                                     var17 = class83.intStack[--class46.intStackSize];
                                                                                                                     var21 = Client.grandExchangeOffers[var17].method87();
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = var21 == 2?1:0;
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3912) {
                                                                                                                     var17 = class83.intStack[--class46.intStackSize];
                                                                                                                     var21 = Client.grandExchangeOffers[var17].method87();
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = var21 == 5?1:0;
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3913) {
                                                                                                                     var17 = class83.intStack[--class46.intStackSize];
                                                                                                                     var21 = Client.grandExchangeOffers[var17].method87();
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = var21 == 1?1:0;
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3914) {
                                                                                                                     var66 = class83.intStack[--class46.intStackSize] == 1;
                                                                                                                     if(class66.field833 != null) {
                                                                                                                        class66.field833.method61(class13.field279, var66);
                                                                                                                     }

                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3915) {
                                                                                                                     var66 = class83.intStack[--class46.intStackSize] == 1;
                                                                                                                     if(class66.field833 != null) {
                                                                                                                        class66.field833.method61(class13.field278, var66);
                                                                                                                     }

                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3916) {
                                                                                                                     class46.intStackSize -= 2;
                                                                                                                     var66 = class83.intStack[class46.intStackSize] == 1;
                                                                                                                     var33 = class83.intStack[class46.intStackSize + 1] == 1;
                                                                                                                     if(class66.field833 != null) {
                                                                                                                        class66.field833.method61(new class95(var33), var66);
                                                                                                                     }

                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3917) {
                                                                                                                     var66 = class83.intStack[--class46.intStackSize] == 1;
                                                                                                                     if(class66.field833 != null) {
                                                                                                                        class66.field833.method61(class13.field277, var66);
                                                                                                                     }

                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3918) {
                                                                                                                     var66 = class83.intStack[--class46.intStackSize] == 1;
                                                                                                                     if(class66.field833 != null) {
                                                                                                                        class66.field833.method61(class13.field280, var66);
                                                                                                                     }

                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 3919) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = class66.field833 == null?0:class66.field833.field283.size();
                                                                                                                     var26 = 1;
                                                                                                                  } else {
                                                                                                                     class14 var37;
                                                                                                                     if(var15 == 3920) {
                                                                                                                        var17 = class83.intStack[--class46.intStackSize];
                                                                                                                        var37 = (class14)class66.field833.field283.get(var17);
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = var37.field291;
                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 == 3921) {
                                                                                                                        var17 = class83.intStack[--class46.intStackSize];
                                                                                                                        var37 = (class14)class66.field833.field283.get(var17);
                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var37.method66();
                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 == 3922) {
                                                                                                                        var17 = class83.intStack[--class46.intStackSize];
                                                                                                                        var37 = (class14)class66.field833.field283.get(var17);
                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var37.method78();
                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 == 3923) {
                                                                                                                        var17 = class83.intStack[--class46.intStackSize];
                                                                                                                        var37 = (class14)class66.field833.field283.get(var17);
                                                                                                                        long var38 = DState.currentTimeMs() - class43.field599 - var37.field286;
                                                                                                                        var19 = (int)(var38 / 3600000L);
                                                                                                                        var69 = (int)((var38 - (long)(var19 * 3600000)) / 60000L);
                                                                                                                        int var40 = (int)((var38 - (long)(var19 * 3600000) - (long)(var69 * '\uea60')) / 1000L);
                                                                                                                        String var41 = var19 + ":" + var69 / 10 + var69 % 10 + ":" + var40 / 10 + var40 % 10;
                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var41;
                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 == 3924) {
                                                                                                                        var17 = class83.intStack[--class46.intStackSize];
                                                                                                                        var37 = (class14)class66.field833.field283.get(var17);
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = var37.field285.totalQuantity;
                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 == 3925) {
                                                                                                                        var17 = class83.intStack[--class46.intStackSize];
                                                                                                                        var37 = (class14)class66.field833.field283.get(var17);
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = var37.field285.price;
                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 == 3926) {
                                                                                                                        var17 = class83.intStack[--class46.intStackSize];
                                                                                                                        var37 = (class14)class66.field833.field283.get(var17);
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = var37.field285.itemId;
                                                                                                                        var26 = 1;
                                                                                                                     } else {
                                                                                                                        var26 = 2;
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var16 = var26;
                                                                                                               } else if(var15 < 4100) {
                                                                                                                  var16 = GameObject.method2890(var15, var5, var25);
                                                                                                               } else if(var15 < 4200) {
                                                                                                                  var16 = class261.method4735(var15, var5, var25);
                                                                                                               } else if(var15 < 4300) {
                                                                                                                  var16 = class24.method163(var15, var5, var25);
                                                                                                               } else if(var15 < 5100) {
                                                                                                                  if(var15 == 5000) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.field1143;
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 5001) {
                                                                                                                     class46.intStackSize -= 3;
                                                                                                                     Client.field1143 = class83.intStack[class46.intStackSize];
                                                                                                                     class61.field787 = Ignore.method1137(class83.intStack[class46.intStackSize + 1]);
                                                                                                                     if(class61.field787 == null) {
                                                                                                                        class61.field787 = class276.field3740;
                                                                                                                     }

                                                                                                                     Client.field1032 = class83.intStack[class46.intStackSize + 2];
                                                                                                                     Client.secretPacketBuffer1.putOpcode(180);
                                                                                                                     Client.secretPacketBuffer1.putByte(Client.field1143);
                                                                                                                     Client.secretPacketBuffer1.putByte(class61.field787.field3738);
                                                                                                                     Client.secretPacketBuffer1.putByte(Client.field1032);
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 5002) {
                                                                                                                     var32 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                     class46.intStackSize -= 2;
                                                                                                                     var21 = class83.intStack[class46.intStackSize];
                                                                                                                     var18 = class83.intStack[class46.intStackSize + 1];
                                                                                                                     Client.secretPacketBuffer1.putOpcode(153);
                                                                                                                     Client.secretPacketBuffer1.putByte(class261.getLength(var32) + 2);
                                                                                                                     Client.secretPacketBuffer1.putString(var32);
                                                                                                                     Client.secretPacketBuffer1.putByte(var21 - 1);
                                                                                                                     Client.secretPacketBuffer1.putByte(var18);
                                                                                                                     var26 = 1;
                                                                                                                  } else {
                                                                                                                     MessageNode var82;
                                                                                                                     if(var15 == 5003) {
                                                                                                                        class46.intStackSize -= 2;
                                                                                                                        var17 = class83.intStack[class46.intStackSize];
                                                                                                                        var21 = class83.intStack[class46.intStackSize + 1];
                                                                                                                        var82 = KeyFocusListener.method790(var17, var21);
                                                                                                                        if(var82 != null) {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = var82.id;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = var82.tick;
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var82.name != null?var82.name:"";
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var82.sender != null?var82.sender:"";
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var82.value != null?var82.value:"";
                                                                                                                        } else {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 == 5004) {
                                                                                                                        var17 = class83.intStack[--class46.intStackSize];
                                                                                                                        var82 = (MessageNode)class98.field1546.method3478((long)var17);
                                                                                                                        if(var82 != null) {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = var82.type;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = var82.tick;
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var82.name != null?var82.name:"";
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var82.sender != null?var82.sender:"";
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var82.value != null?var82.value:"";
                                                                                                                        } else {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 == 5005) {
                                                                                                                        if(class61.field787 == null) {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                        } else {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = class61.field787.field3738;
                                                                                                                        }

                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 == 5008) {
                                                                                                                        var32 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                        var21 = class83.intStack[--class46.intStackSize];
                                                                                                                        var57 = var32.toLowerCase();
                                                                                                                        byte var71 = 0;
                                                                                                                        if(var57.startsWith("yellow:")) {
                                                                                                                           var71 = 0;
                                                                                                                           var32 = var32.substring("yellow:".length());
                                                                                                                        } else if(var57.startsWith("red:")) {
                                                                                                                           var71 = 1;
                                                                                                                           var32 = var32.substring("red:".length());
                                                                                                                        } else if(var57.startsWith("green:")) {
                                                                                                                           var71 = 2;
                                                                                                                           var32 = var32.substring("green:".length());
                                                                                                                        } else if(var57.startsWith("cyan:")) {
                                                                                                                           var71 = 3;
                                                                                                                           var32 = var32.substring("cyan:".length());
                                                                                                                        } else if(var57.startsWith("purple:")) {
                                                                                                                           var71 = 4;
                                                                                                                           var32 = var32.substring("purple:".length());
                                                                                                                        } else if(var57.startsWith("white:")) {
                                                                                                                           var71 = 5;
                                                                                                                           var32 = var32.substring("white:".length());
                                                                                                                        } else if(var57.startsWith("flash1:")) {
                                                                                                                           var71 = 6;
                                                                                                                           var32 = var32.substring("flash1:".length());
                                                                                                                        } else if(var57.startsWith("flash2:")) {
                                                                                                                           var71 = 7;
                                                                                                                           var32 = var32.substring("flash2:".length());
                                                                                                                        } else if(var57.startsWith("flash3:")) {
                                                                                                                           var71 = 8;
                                                                                                                           var32 = var32.substring("flash3:".length());
                                                                                                                        } else if(var57.startsWith("glow1:")) {
                                                                                                                           var71 = 9;
                                                                                                                           var32 = var32.substring("glow1:".length());
                                                                                                                        } else if(var57.startsWith("glow2:")) {
                                                                                                                           var71 = 10;
                                                                                                                           var32 = var32.substring("glow2:".length());
                                                                                                                        } else if(var57.startsWith("glow3:")) {
                                                                                                                           var71 = 11;
                                                                                                                           var32 = var32.substring("glow3:".length());
                                                                                                                        } else if(Client.languageId != 0) {
                                                                                                                           if(var57.startsWith("yellow:")) {
                                                                                                                              var71 = 0;
                                                                                                                              var32 = var32.substring("yellow:".length());
                                                                                                                           } else if(var57.startsWith("red:")) {
                                                                                                                              var71 = 1;
                                                                                                                              var32 = var32.substring("red:".length());
                                                                                                                           } else if(var57.startsWith("green:")) {
                                                                                                                              var71 = 2;
                                                                                                                              var32 = var32.substring("green:".length());
                                                                                                                           } else if(var57.startsWith("cyan:")) {
                                                                                                                              var71 = 3;
                                                                                                                              var32 = var32.substring("cyan:".length());
                                                                                                                           } else if(var57.startsWith("purple:")) {
                                                                                                                              var71 = 4;
                                                                                                                              var32 = var32.substring("purple:".length());
                                                                                                                           } else if(var57.startsWith("white:")) {
                                                                                                                              var71 = 5;
                                                                                                                              var32 = var32.substring("white:".length());
                                                                                                                           } else if(var57.startsWith("flash1:")) {
                                                                                                                              var71 = 6;
                                                                                                                              var32 = var32.substring("flash1:".length());
                                                                                                                           } else if(var57.startsWith("flash2:")) {
                                                                                                                              var71 = 7;
                                                                                                                              var32 = var32.substring("flash2:".length());
                                                                                                                           } else if(var57.startsWith("flash3:")) {
                                                                                                                              var71 = 8;
                                                                                                                              var32 = var32.substring("flash3:".length());
                                                                                                                           } else if(var57.startsWith("glow1:")) {
                                                                                                                              var71 = 9;
                                                                                                                              var32 = var32.substring("glow1:".length());
                                                                                                                           } else if(var57.startsWith("glow2:")) {
                                                                                                                              var71 = 10;
                                                                                                                              var32 = var32.substring("glow2:".length());
                                                                                                                           } else if(var57.startsWith("glow3:")) {
                                                                                                                              var71 = 11;
                                                                                                                              var32 = var32.substring("glow3:".length());
                                                                                                                           }
                                                                                                                        }

                                                                                                                        var57 = var32.toLowerCase();
                                                                                                                        byte var70 = 0;
                                                                                                                        if(var57.startsWith("wave:")) {
                                                                                                                           var70 = 1;
                                                                                                                           var32 = var32.substring("wave:".length());
                                                                                                                        } else if(var57.startsWith("wave2:")) {
                                                                                                                           var70 = 2;
                                                                                                                           var32 = var32.substring("wave2:".length());
                                                                                                                        } else if(var57.startsWith("shake:")) {
                                                                                                                           var70 = 3;
                                                                                                                           var32 = var32.substring("shake:".length());
                                                                                                                        } else if(var57.startsWith("scroll:")) {
                                                                                                                           var70 = 4;
                                                                                                                           var32 = var32.substring("scroll:".length());
                                                                                                                        } else if(var57.startsWith("slide:")) {
                                                                                                                           var70 = 5;
                                                                                                                           var32 = var32.substring("slide:".length());
                                                                                                                        } else if(Client.languageId != 0) {
                                                                                                                           if(var57.startsWith("wave:")) {
                                                                                                                              var70 = 1;
                                                                                                                              var32 = var32.substring("wave:".length());
                                                                                                                           } else if(var57.startsWith("wave2:")) {
                                                                                                                              var70 = 2;
                                                                                                                              var32 = var32.substring("wave2:".length());
                                                                                                                           } else if(var57.startsWith("shake:")) {
                                                                                                                              var70 = 3;
                                                                                                                              var32 = var32.substring("shake:".length());
                                                                                                                           } else if(var57.startsWith("scroll:")) {
                                                                                                                              var70 = 4;
                                                                                                                              var32 = var32.substring("scroll:".length());
                                                                                                                           } else if(var57.startsWith("slide:")) {
                                                                                                                              var70 = 5;
                                                                                                                              var32 = var32.substring("slide:".length());
                                                                                                                           }
                                                                                                                        }

                                                                                                                        Client.secretPacketBuffer1.putOpcode(213);
                                                                                                                        Client.secretPacketBuffer1.putByte(0);
                                                                                                                        var69 = Client.secretPacketBuffer1.offset;
                                                                                                                        Client.secretPacketBuffer1.putByte(var21);
                                                                                                                        Client.secretPacketBuffer1.putByte(var71);
                                                                                                                        Client.secretPacketBuffer1.putByte(var70);
                                                                                                                        MessageNode.method1142(Client.secretPacketBuffer1, var32);
                                                                                                                        Client.secretPacketBuffer1.putLength(Client.secretPacketBuffer1.offset - var69);
                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 == 5009) {
                                                                                                                        KeyFocusListener.scriptStringStackSize -= 2;
                                                                                                                        var32 = class83.scriptStringStack[KeyFocusListener.scriptStringStackSize];
                                                                                                                        var23 = class83.scriptStringStack[KeyFocusListener.scriptStringStackSize + 1];
                                                                                                                        Client.secretPacketBuffer1.putOpcode(239);
                                                                                                                        Client.secretPacketBuffer1.putShort(0);
                                                                                                                        var18 = Client.secretPacketBuffer1.offset;
                                                                                                                        Client.secretPacketBuffer1.putString(var32);
                                                                                                                        MessageNode.method1142(Client.secretPacketBuffer1, var23);
                                                                                                                        Client.secretPacketBuffer1.putShortLength(Client.secretPacketBuffer1.offset - var18);
                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 != 5015) {
                                                                                                                        if(var15 == 5016) {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = Client.field1032;
                                                                                                                           var26 = 1;
                                                                                                                        } else if(var15 == 5017) {
                                                                                                                           var17 = class83.intStack[--class46.intStackSize];
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = KitDefinition.method4399(var17);
                                                                                                                           var26 = 1;
                                                                                                                        } else if(var15 == 5018) {
                                                                                                                           var17 = class83.intStack[--class46.intStackSize];
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = GZipDecompressor.method3076(var17);
                                                                                                                           var26 = 1;
                                                                                                                        } else if(var15 == 5019) {
                                                                                                                           var17 = class83.intStack[--class46.intStackSize];
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = class269.method4863(var17);
                                                                                                                           var26 = 1;
                                                                                                                        } else if(var15 == 5020) {
                                                                                                                           var32 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                           if(var32.equalsIgnoreCase("toggleroof")) {
                                                                                                                              class8.settings.hideRoofs = !class8.settings.hideRoofs;
                                                                                                                              class1.method3();
                                                                                                                              if(class8.settings.hideRoofs) {
                                                                                                                                 class152.sendGameMessage(99, "", "Roofs are now all hidden");
                                                                                                                              } else {
                                                                                                                                 class152.sendGameMessage(99, "", "Roofs will only be removed selectively");
                                                                                                                              }
                                                                                                                           }

                                                                                                                           if(var32.equalsIgnoreCase("displayfps")) {
                                                                                                                              Client.displayFps = !Client.displayFps;
                                                                                                                           }

                                                                                                                           if(var32.equalsIgnoreCase("clickbox")) {
                                                                                                                              Model.field1992 = !Model.field1992;
                                                                                                                              class152.sendGameMessage(99, "", "Clickbox Mode: " + (Model.field1992?"AABB":"Legacy"));
                                                                                                                           }

                                                                                                                           if(Client.rights >= 2) {
                                                                                                                              if(var32.equalsIgnoreCase("aabb")) {
                                                                                                                                 if(!class7.field236) {
                                                                                                                                    class7.field236 = true;
                                                                                                                                    class7.field233 = class11.field263;
                                                                                                                                    class152.sendGameMessage(99, "", "AABB boxes: All");
                                                                                                                                 } else if(class7.field233 == class11.field263) {
                                                                                                                                    class7.field236 = true;
                                                                                                                                    class7.field233 = class11.field268;
                                                                                                                                    class152.sendGameMessage(99, "", "AABB boxes: Mouse Over");
                                                                                                                                 } else {
                                                                                                                                    class7.field236 = false;
                                                                                                                                    class152.sendGameMessage(99, "", "AABB boxes: Off");
                                                                                                                                 }
                                                                                                                              }

                                                                                                                              if(var32.equalsIgnoreCase("legacyboxes")) {
                                                                                                                                 class7.field238 = !class7.field238;
                                                                                                                                 class152.sendGameMessage(99, "", "Show legacy boxes: " + class7.field238);
                                                                                                                              }

                                                                                                                              if(var32.equalsIgnoreCase("geotests")) {
                                                                                                                                 class7.field232 = !class7.field232;
                                                                                                                                 class152.sendGameMessage(99, "", "Show geometry tests: " + class7.field232);
                                                                                                                              }

                                                                                                                              if(var32.equalsIgnoreCase("fpson")) {
                                                                                                                                 Client.displayFps = true;
                                                                                                                              }

                                                                                                                              if(var32.equalsIgnoreCase("fpsoff")) {
                                                                                                                                 Client.displayFps = false;
                                                                                                                              }

                                                                                                                              if(var32.equalsIgnoreCase("gc")) {
                                                                                                                                 System.gc();
                                                                                                                              }

                                                                                                                              if(var32.equalsIgnoreCase("clientdrop")) {
                                                                                                                                 class13.method60();
                                                                                                                              }

                                                                                                                              if(var32.equalsIgnoreCase("errortest") && Client.socketType == 2) {
                                                                                                                                 throw new RuntimeException();
                                                                                                                              }
                                                                                                                           }

                                                                                                                           Client.secretPacketBuffer1.putOpcode(232);
                                                                                                                           Client.secretPacketBuffer1.putByte(var32.length() + 1);
                                                                                                                           Client.secretPacketBuffer1.putString(var32);
                                                                                                                           var26 = 1;
                                                                                                                        } else if(var15 == 5021) {
                                                                                                                           Client.field1145 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize].toLowerCase().trim();
                                                                                                                           var26 = 1;
                                                                                                                        } else if(var15 == 5022) {
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = Client.field1145;
                                                                                                                           var26 = 1;
                                                                                                                        } else {
                                                                                                                           var26 = 2;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        if(XItemContainer.localPlayer != null && XItemContainer.localPlayer.name != null) {
                                                                                                                           var32 = XItemContainer.localPlayer.name;
                                                                                                                        } else {
                                                                                                                           var32 = "";
                                                                                                                        }

                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var32;
                                                                                                                        var26 = 1;
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var16 = var26;
                                                                                                               } else if(var15 < 5400) {
                                                                                                                  var16 = class37.method510(var15, var5, var25);
                                                                                                               } else if(var15 < 5600) {
                                                                                                                  if(var15 == 5504) {
                                                                                                                     class46.intStackSize -= 2;
                                                                                                                     var20 = class83.intStack[class46.intStackSize];
                                                                                                                     var19 = class83.intStack[class46.intStackSize + 1];
                                                                                                                     if(!Client.field1173) {
                                                                                                                        Client.field1052 = var20;
                                                                                                                        Client.mapAngle = var19;
                                                                                                                     }

                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 5505) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.field1052;
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 5506) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.mapAngle;
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 5530) {
                                                                                                                     var20 = class83.intStack[--class46.intStackSize];
                                                                                                                     if(var20 < 0) {
                                                                                                                        var20 = 0;
                                                                                                                     }

                                                                                                                     Client.field1015 = var20;
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 5531) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.field1015;
                                                                                                                     var26 = 1;
                                                                                                                  } else {
                                                                                                                     var26 = 2;
                                                                                                                  }

                                                                                                                  var16 = var26;
                                                                                                               } else if(var15 < 5700) {
                                                                                                                  if(var15 == 5630) {
                                                                                                                     Client.field978 = 250;
                                                                                                                     var26 = 1;
                                                                                                                  } else {
                                                                                                                     var26 = 2;
                                                                                                                  }

                                                                                                                  var16 = var26;
                                                                                                               } else if(var15 < 6300) {
                                                                                                                  if(var15 == 6200) {
                                                                                                                     class46.intStackSize -= 2;
                                                                                                                     Client.field1179 = (short)class83.intStack[class46.intStackSize];
                                                                                                                     if(Client.field1179 <= 0) {
                                                                                                                        Client.field1179 = 256;
                                                                                                                     }

                                                                                                                     Client.field1180 = (short)class83.intStack[class46.intStackSize + 1];
                                                                                                                     if(Client.field1180 <= 0) {
                                                                                                                        Client.field1180 = 205;
                                                                                                                     }

                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 6201) {
                                                                                                                     class46.intStackSize -= 2;
                                                                                                                     Client.field1126 = (short)class83.intStack[class46.intStackSize];
                                                                                                                     if(Client.field1126 <= 0) {
                                                                                                                        Client.field1126 = 256;
                                                                                                                     }

                                                                                                                     Client.field1182 = (short)class83.intStack[class46.intStackSize + 1];
                                                                                                                     if(Client.field1182 <= 0) {
                                                                                                                        Client.field1182 = 320;
                                                                                                                     }

                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 6202) {
                                                                                                                     class46.intStackSize -= 4;
                                                                                                                     Client.field1166 = (short)class83.intStack[class46.intStackSize];
                                                                                                                     if(Client.field1166 <= 0) {
                                                                                                                        Client.field1166 = 1;
                                                                                                                     }

                                                                                                                     Client.field1184 = (short)class83.intStack[class46.intStackSize + 1];
                                                                                                                     if(Client.field1184 <= 0) {
                                                                                                                        Client.field1184 = 32767;
                                                                                                                     } else if(Client.field1184 < Client.field1166) {
                                                                                                                        Client.field1184 = Client.field1166;
                                                                                                                     }

                                                                                                                     Client.field1185 = (short)class83.intStack[class46.intStackSize + 2];
                                                                                                                     if(Client.field1185 <= 0) {
                                                                                                                        Client.field1185 = 1;
                                                                                                                     }

                                                                                                                     Client.field1186 = (short)class83.intStack[class46.intStackSize + 3];
                                                                                                                     if(Client.field1186 <= 0) {
                                                                                                                        Client.field1186 = 32767;
                                                                                                                     } else if(Client.field1186 < Client.field1185) {
                                                                                                                        Client.field1186 = Client.field1185;
                                                                                                                     }

                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 6203) {
                                                                                                                     if(Client.field1099 != null) {
                                                                                                                        Item.method1773(0, 0, Client.field1099.width, Client.field1099.height, false);
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = Client.viewportHeight;
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = Client.viewportWidth;
                                                                                                                     } else {
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                     }

                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 6204) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.field1126;
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.field1182;
                                                                                                                     var26 = 1;
                                                                                                                  } else if(var15 == 6205) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.field1179;
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.field1180;
                                                                                                                     var26 = 1;
                                                                                                                  } else {
                                                                                                                     var26 = 2;
                                                                                                                  }

                                                                                                                  var16 = var26;
                                                                                                               } else if(var15 < 6600) {
                                                                                                                  if(var15 == 6500) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = class1.loadWorlds()?1:0;
                                                                                                                     var26 = 1;
                                                                                                                  } else {
                                                                                                                     World var83;
                                                                                                                     if(var15 == 6501) {
                                                                                                                        var83 = Preferences.method1615();
                                                                                                                        if(var83 != null) {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = var83.id;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = var83.mask;
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var83.activity;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = var83.location;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = var83.playerCount;
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var83.address;
                                                                                                                        } else {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 == 6502) {
                                                                                                                        var83 = Actor.method1556();
                                                                                                                        if(var83 != null) {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = var83.id;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = var83.mask;
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var83.activity;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = var83.location;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = var83.playerCount;
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var83.address;
                                                                                                                        } else {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var26 = 1;
                                                                                                                     } else {
                                                                                                                        World var78;
                                                                                                                        if(var15 == 6506) {
                                                                                                                           var17 = class83.intStack[--class46.intStackSize];
                                                                                                                           var78 = null;

                                                                                                                           for(var18 = 0; var18 < World.worldCount; ++var18) {
                                                                                                                              if(World.worldList[var18].id == var17) {
                                                                                                                                 var78 = World.worldList[var18];
                                                                                                                                 break;
                                                                                                                              }
                                                                                                                           }

                                                                                                                           if(var78 != null) {
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = var78.id;
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = var78.mask;
                                                                                                                              class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var78.activity;
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = var78.location;
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = var78.playerCount;
                                                                                                                              class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var78.address;
                                                                                                                           } else {
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                              class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                              class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                           }

                                                                                                                           var26 = 1;
                                                                                                                        } else if(var15 == 6507) {
                                                                                                                           class46.intStackSize -= 4;
                                                                                                                           var17 = class83.intStack[class46.intStackSize];
                                                                                                                           var33 = class83.intStack[1 + class46.intStackSize] == 1;
                                                                                                                           var18 = class83.intStack[class46.intStackSize + 2];
                                                                                                                           boolean var72 = class83.intStack[class46.intStackSize + 3] == 1;
                                                                                                                           if(World.worldList != null) {
                                                                                                                              XGrandExchangeOffer.method112(0, World.worldList.length - 1, var17, var33, var18, var72);
                                                                                                                           }

                                                                                                                           var26 = 1;
                                                                                                                        } else if(var15 != 6511) {
                                                                                                                           if(var15 == 6512) {
                                                                                                                              Client.field1073 = class83.intStack[--class46.intStackSize] == 1;
                                                                                                                              var26 = 1;
                                                                                                                           } else {
                                                                                                                              class251 var39;
                                                                                                                              if(var15 == 6513) {
                                                                                                                                 class46.intStackSize -= 2;
                                                                                                                                 var17 = class83.intStack[class46.intStackSize];
                                                                                                                                 var21 = class83.intStack[class46.intStackSize + 1];
                                                                                                                                 var39 = FaceNormal.method2869(var21);
                                                                                                                                 if(var39.method4440()) {
                                                                                                                                    class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = class35.getNpcDefinition(var17).method4649(var21, var39.field3401);
                                                                                                                                 } else {
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = class35.getNpcDefinition(var17).method4648(var21, var39.field3398);
                                                                                                                                 }

                                                                                                                                 var26 = 1;
                                                                                                                              } else if(var15 == 6514) {
                                                                                                                                 class46.intStackSize -= 2;
                                                                                                                                 var17 = class83.intStack[class46.intStackSize];
                                                                                                                                 var21 = class83.intStack[class46.intStackSize + 1];
                                                                                                                                 var39 = FaceNormal.method2869(var21);
                                                                                                                                 if(var39.method4440()) {
                                                                                                                                    class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = class251.getObjectDefinition(var17).method4525(var21, var39.field3401);
                                                                                                                                 } else {
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = class251.getObjectDefinition(var17).method4548(var21, var39.field3398);
                                                                                                                                 }

                                                                                                                                 var26 = 1;
                                                                                                                              } else if(var15 == 6515) {
                                                                                                                                 class46.intStackSize -= 2;
                                                                                                                                 var17 = class83.intStack[class46.intStackSize];
                                                                                                                                 var21 = class83.intStack[class46.intStackSize + 1];
                                                                                                                                 var39 = FaceNormal.method2869(var21);
                                                                                                                                 if(var39.method4440()) {
                                                                                                                                    class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = AbstractByteBuffer.getItemDefinition(var17).method4589(var21, var39.field3401);
                                                                                                                                 } else {
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = AbstractByteBuffer.getItemDefinition(var17).method4586(var21, var39.field3398);
                                                                                                                                 }

                                                                                                                                 var26 = 1;
                                                                                                                              } else if(var15 == 6516) {
                                                                                                                                 class46.intStackSize -= 2;
                                                                                                                                 var17 = class83.intStack[class46.intStackSize];
                                                                                                                                 var21 = class83.intStack[class46.intStackSize + 1];
                                                                                                                                 var39 = FaceNormal.method2869(var21);
                                                                                                                                 if(var39.method4440()) {
                                                                                                                                    String[] var73 = class83.scriptStringStack;
                                                                                                                                    var19 = ++KeyFocusListener.scriptStringStackSize - 1;
                                                                                                                                    class252 var76 = (class252)class252.field3402.get((long)var17);
                                                                                                                                    class252 var42;
                                                                                                                                    if(var76 != null) {
                                                                                                                                       var42 = var76;
                                                                                                                                    } else {
                                                                                                                                       byte[] var43 = class252.field3406.getConfigData(34, var17);
                                                                                                                                       var76 = new class252();
                                                                                                                                       if(var43 != null) {
                                                                                                                                          var76.method4459(new Buffer(var43));
                                                                                                                                       }

                                                                                                                                       var76.method4458();
                                                                                                                                       class252.field3402.put(var76, (long)var17);
                                                                                                                                       var42 = var76;
                                                                                                                                    }

                                                                                                                                    var73[var19] = var42.method4462(var21, var39.field3401);
                                                                                                                                 } else {
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = class17.method115(var17).method4457(var21, var39.field3398);
                                                                                                                                 }

                                                                                                                                 var26 = 1;
                                                                                                                              } else {
                                                                                                                                 var26 = 2;
                                                                                                                              }
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           var17 = class83.intStack[--class46.intStackSize];
                                                                                                                           if(var17 >= 0 && var17 < World.worldCount) {
                                                                                                                              var78 = World.worldList[var17];
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = var78.id;
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = var78.mask;
                                                                                                                              class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var78.activity;
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = var78.location;
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = var78.playerCount;
                                                                                                                              class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var78.address;
                                                                                                                           } else {
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                              class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                              class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                           }

                                                                                                                           var26 = 1;
                                                                                                                        }
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var16 = var26;
                                                                                                               } else if(var15 < 6700) {
                                                                                                                  if(var15 == 6600) {
                                                                                                                     var17 = WallObject.plane;
                                                                                                                     var21 = (XItemContainer.localPlayer.x >> 7) + KeyFocusListener.baseX;
                                                                                                                     var18 = (XItemContainer.localPlayer.y >> 7) + class266.baseY;
                                                                                                                     class44.method651().method5187(var17, var21, var18, true);
                                                                                                                     var26 = 1;
                                                                                                                  } else {
                                                                                                                     WorldMapData var84;
                                                                                                                     if(var15 == 6601) {
                                                                                                                        var17 = class83.intStack[--class46.intStackSize];
                                                                                                                        var23 = "";
                                                                                                                        var84 = class44.method651().method5179(var17);
                                                                                                                        if(var84 != null) {
                                                                                                                           var23 = var84.method283();
                                                                                                                        }

                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var23;
                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 == 6602) {
                                                                                                                        var17 = class83.intStack[--class46.intStackSize];
                                                                                                                        class44.method651().method5188(var17);
                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 == 6603) {
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = class44.method651().method5325();
                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 == 6604) {
                                                                                                                        var17 = class83.intStack[--class46.intStackSize];
                                                                                                                        class44.method651().method5250(var17);
                                                                                                                        var26 = 1;
                                                                                                                     } else if(var15 == 6605) {
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = class44.method651().method5202()?1:0;
                                                                                                                        var26 = 1;
                                                                                                                     } else {
                                                                                                                        Coordinates var81;
                                                                                                                        if(var15 == 6606) {
                                                                                                                           var81 = new Coordinates(class83.intStack[--class46.intStackSize]);
                                                                                                                           class44.method651().method5204(var81.worldX, var81.worldY);
                                                                                                                           var26 = 1;
                                                                                                                        } else if(var15 == 6607) {
                                                                                                                           var81 = new Coordinates(class83.intStack[--class46.intStackSize]);
                                                                                                                           class44.method651().method5205(var81.worldX, var81.worldY);
                                                                                                                           var26 = 1;
                                                                                                                        } else if(var15 == 6608) {
                                                                                                                           var81 = new Coordinates(class83.intStack[--class46.intStackSize]);
                                                                                                                           class44.method651().method5206(var81.plane, var81.worldX, var81.worldY);
                                                                                                                           var26 = 1;
                                                                                                                        } else if(var15 == 6609) {
                                                                                                                           var81 = new Coordinates(class83.intStack[--class46.intStackSize]);
                                                                                                                           class44.method651().method5212(var81.plane, var81.worldX, var81.worldY);
                                                                                                                           var26 = 1;
                                                                                                                        } else if(var15 == 6610) {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = class44.method651().method5299();
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = class44.method651().method5209();
                                                                                                                           var26 = 1;
                                                                                                                        } else {
                                                                                                                           WorldMapData var74;
                                                                                                                           if(var15 == 6611) {
                                                                                                                              var17 = class83.intStack[--class46.intStackSize];
                                                                                                                              var74 = class44.method651().method5179(var17);
                                                                                                                              if(var74 == null) {
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                              } else {
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = var74.method334().method3913();
                                                                                                                              }

                                                                                                                              var26 = 1;
                                                                                                                           } else if(var15 == 6612) {
                                                                                                                              var17 = class83.intStack[--class46.intStackSize];
                                                                                                                              var74 = class44.method651().method5179(var17);
                                                                                                                              if(var74 == null) {
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                              } else {
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = (var74.method287() - var74.method305() + 1) * 64;
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = (var74.method289() - var74.method288() + 1) * 64;
                                                                                                                              }

                                                                                                                              var26 = 1;
                                                                                                                           } else if(var15 == 6613) {
                                                                                                                              var17 = class83.intStack[--class46.intStackSize];
                                                                                                                              var74 = class44.method651().method5179(var17);
                                                                                                                              if(var74 == null) {
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                              } else {
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = var74.method305() * 64;
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = var74.method288() * 64;
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = var74.method287() * 64 + 64 - 1;
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = var74.method289() * 64 + 64 - 1;
                                                                                                                              }

                                                                                                                              var26 = 1;
                                                                                                                           } else if(var15 == 6614) {
                                                                                                                              var17 = class83.intStack[--class46.intStackSize];
                                                                                                                              var74 = class44.method651().method5179(var17);
                                                                                                                              if(var74 == null) {
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                              } else {
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = var74.method285();
                                                                                                                              }

                                                                                                                              var26 = 1;
                                                                                                                           } else if(var15 == 6615) {
                                                                                                                              var81 = class44.method651().method5210();
                                                                                                                              if(var81 == null) {
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                              } else {
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = var81.worldX;
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = var81.worldY;
                                                                                                                              }

                                                                                                                              var26 = 1;
                                                                                                                           } else if(var15 == 6616) {
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = class44.method651().method5189();
                                                                                                                              var26 = 1;
                                                                                                                           } else if(var15 == 6617) {
                                                                                                                              var81 = new Coordinates(class83.intStack[--class46.intStackSize]);
                                                                                                                              var74 = class44.method651().method5260();
                                                                                                                              if(var74 == null) {
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                 var26 = 1;
                                                                                                                              } else {
                                                                                                                                 var62 = var74.method317(var81.plane, var81.worldX, var81.worldY);
                                                                                                                                 if(var62 == null) {
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                 } else {
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = var62[0];
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = var62[1];
                                                                                                                                 }

                                                                                                                                 var26 = 1;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              Coordinates var75;
                                                                                                                              if(var15 == 6618) {
                                                                                                                                 var81 = new Coordinates(class83.intStack[--class46.intStackSize]);
                                                                                                                                 var74 = class44.method651().method5260();
                                                                                                                                 if(var74 == null) {
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                    var26 = 1;
                                                                                                                                 } else {
                                                                                                                                    var75 = var74.method278(var81.worldX, var81.worldY);
                                                                                                                                    if(var75 == null) {
                                                                                                                                       class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                    } else {
                                                                                                                                       class83.intStack[++class46.intStackSize - 1] = var75.method3913();
                                                                                                                                    }

                                                                                                                                    var26 = 1;
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 Coordinates var77;
                                                                                                                                 Coordinates var79;
                                                                                                                                 if(var15 == 6619) {
                                                                                                                                    class46.intStackSize -= 2;
                                                                                                                                    var17 = class83.intStack[class46.intStackSize];
                                                                                                                                    var77 = new Coordinates(class83.intStack[class46.intStackSize + 1]);
                                                                                                                                    var84 = class44.method651().method5179(var17);
                                                                                                                                    var20 = XItemContainer.localPlayer.field911;
                                                                                                                                    var19 = (XItemContainer.localPlayer.x >> 7) + KeyFocusListener.baseX;
                                                                                                                                    var69 = (XItemContainer.localPlayer.y >> 7) + class266.baseY;
                                                                                                                                    var79 = new Coordinates(var20, var19, var69);
                                                                                                                                    class44.method651().method5193(var84, var79, var77, false);
                                                                                                                                    var26 = 1;
                                                                                                                                 } else if(var15 == 6620) {
                                                                                                                                    class46.intStackSize -= 2;
                                                                                                                                    var17 = class83.intStack[class46.intStackSize];
                                                                                                                                    var77 = new Coordinates(class83.intStack[class46.intStackSize + 1]);
                                                                                                                                    var84 = class44.method651().method5179(var17);
                                                                                                                                    var20 = XItemContainer.localPlayer.field911;
                                                                                                                                    var19 = (XItemContainer.localPlayer.x >> 7) + KeyFocusListener.baseX;
                                                                                                                                    var69 = (XItemContainer.localPlayer.y >> 7) + class266.baseY;
                                                                                                                                    var79 = new Coordinates(var20, var19, var69);
                                                                                                                                    class44.method651().method5193(var84, var79, var77, true);
                                                                                                                                    var26 = 1;
                                                                                                                                 } else if(var15 == 6621) {
                                                                                                                                    class46.intStackSize -= 2;
                                                                                                                                    var17 = class83.intStack[class46.intStackSize];
                                                                                                                                    var77 = new Coordinates(class83.intStack[class46.intStackSize + 1]);
                                                                                                                                    var84 = class44.method651().method5179(var17);
                                                                                                                                    if(var84 == null) {
                                                                                                                                       class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                                       var26 = 1;
                                                                                                                                    } else {
                                                                                                                                       class83.intStack[++class46.intStackSize - 1] = var84.method275(var77.plane, var77.worldX, var77.worldY)?1:0;
                                                                                                                                       var26 = 1;
                                                                                                                                    }
                                                                                                                                 } else if(var15 == 6622) {
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = class44.method651().method5284();
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = class44.method651().method5333();
                                                                                                                                    var26 = 1;
                                                                                                                                 } else if(var15 == 6623) {
                                                                                                                                    var81 = new Coordinates(class83.intStack[--class46.intStackSize]);
                                                                                                                                    var74 = class44.method651().method5214(var81.plane, var81.worldX, var81.worldY);
                                                                                                                                    if(var74 == null) {
                                                                                                                                       class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                    } else {
                                                                                                                                       class83.intStack[++class46.intStackSize - 1] = var74.method280();
                                                                                                                                    }

                                                                                                                                    var26 = 1;
                                                                                                                                 } else if(var15 == 6624) {
                                                                                                                                    class44.method651().method5254(class83.intStack[--class46.intStackSize]);
                                                                                                                                    var26 = 1;
                                                                                                                                 } else if(var15 == 6625) {
                                                                                                                                    class44.method651().method5181();
                                                                                                                                    var26 = 1;
                                                                                                                                 } else if(var15 == 6626) {
                                                                                                                                    class44.method651().method5319(class83.intStack[--class46.intStackSize]);
                                                                                                                                    var26 = 1;
                                                                                                                                 } else if(var15 == 6627) {
                                                                                                                                    class44.method651().method5283();
                                                                                                                                    var26 = 1;
                                                                                                                                 } else if(var15 == 6628) {
                                                                                                                                    var66 = class83.intStack[--class46.intStackSize] == 1;
                                                                                                                                    class44.method651().method5217(var66);
                                                                                                                                    var26 = 1;
                                                                                                                                 } else if(var15 == 6629) {
                                                                                                                                    var17 = class83.intStack[--class46.intStackSize];
                                                                                                                                    class44.method651().method5339(var17);
                                                                                                                                    var26 = 1;
                                                                                                                                 } else if(var15 == 6630) {
                                                                                                                                    var17 = class83.intStack[--class46.intStackSize];
                                                                                                                                    class44.method651().method5219(var17);
                                                                                                                                    var26 = 1;
                                                                                                                                 } else if(var15 == 6631) {
                                                                                                                                    class44.method651().method5220();
                                                                                                                                    var26 = 1;
                                                                                                                                 } else if(var15 == 6632) {
                                                                                                                                    var66 = class83.intStack[--class46.intStackSize] == 1;
                                                                                                                                    class44.method651().method5365(var66);
                                                                                                                                    var26 = 1;
                                                                                                                                 } else if(var15 == 6633) {
                                                                                                                                    class46.intStackSize -= 2;
                                                                                                                                    var17 = class83.intStack[class46.intStackSize];
                                                                                                                                    var33 = class83.intStack[class46.intStackSize + 1] == 1;
                                                                                                                                    class44.method651().method5222(var17, var33);
                                                                                                                                    var26 = 1;
                                                                                                                                 } else if(var15 == 6634) {
                                                                                                                                    class46.intStackSize -= 2;
                                                                                                                                    var17 = class83.intStack[class46.intStackSize];
                                                                                                                                    var33 = class83.intStack[class46.intStackSize + 1] == 1;
                                                                                                                                    class44.method651().method5223(var17, var33);
                                                                                                                                    var26 = 1;
                                                                                                                                 } else if(var15 == 6635) {
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = class44.method651().method5224()?1:0;
                                                                                                                                    var26 = 1;
                                                                                                                                 } else if(var15 == 6636) {
                                                                                                                                    var17 = class83.intStack[--class46.intStackSize];
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = class44.method651().method5225(var17)?1:0;
                                                                                                                                    var26 = 1;
                                                                                                                                 } else if(var15 == 6637) {
                                                                                                                                    var17 = class83.intStack[--class46.intStackSize];
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = class44.method651().method5226(var17)?1:0;
                                                                                                                                    var26 = 1;
                                                                                                                                 } else if(var15 == 6638) {
                                                                                                                                    class46.intStackSize -= 2;
                                                                                                                                    var17 = class83.intStack[class46.intStackSize];
                                                                                                                                    var77 = new Coordinates(class83.intStack[class46.intStackSize + 1]);
                                                                                                                                    var75 = class44.method651().method5321(var17, var77);
                                                                                                                                    if(var75 == null) {
                                                                                                                                       class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                    } else {
                                                                                                                                       class83.intStack[++class46.intStackSize - 1] = var75.method3913();
                                                                                                                                    }

                                                                                                                                    var26 = 1;
                                                                                                                                 } else {
                                                                                                                                    class39 var80;
                                                                                                                                    if(var15 == 6639) {
                                                                                                                                       var80 = class44.method651().method5231();
                                                                                                                                       if(var80 == null) {
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                       } else {
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = var80.field548;
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = var80.field550.method3913();
                                                                                                                                       }

                                                                                                                                       var26 = 1;
                                                                                                                                    } else if(var15 == 6640) {
                                                                                                                                       var80 = class44.method651().method5232();
                                                                                                                                       if(var80 == null) {
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                       } else {
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = var80.field548;
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = var80.field550.method3913();
                                                                                                                                       }

                                                                                                                                       var26 = 1;
                                                                                                                                    } else {
                                                                                                                                       Area var44;
                                                                                                                                       if(var15 == 6693) {
                                                                                                                                          var17 = class83.intStack[--class46.intStackSize];
                                                                                                                                          var44 = Area.field3303[var17];
                                                                                                                                          if(var44.name == null) {
                                                                                                                                             class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                                          } else {
                                                                                                                                             class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var44.name;
                                                                                                                                          }

                                                                                                                                          var26 = 1;
                                                                                                                                       } else if(var15 == 6694) {
                                                                                                                                          var17 = class83.intStack[--class46.intStackSize];
                                                                                                                                          var44 = Area.field3303[var17];
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = var44.field3302;
                                                                                                                                          var26 = 1;
                                                                                                                                       } else if(var15 == 6695) {
                                                                                                                                          var17 = class83.intStack[--class46.intStackSize];
                                                                                                                                          var44 = Area.field3303[var17];
                                                                                                                                          if(var44 == null) {
                                                                                                                                             class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                          } else {
                                                                                                                                             class83.intStack[++class46.intStackSize - 1] = var44.field3307;
                                                                                                                                          }

                                                                                                                                          var26 = 1;
                                                                                                                                       } else if(var15 == 6696) {
                                                                                                                                          var17 = class83.intStack[--class46.intStackSize];
                                                                                                                                          var44 = Area.field3303[var17];
                                                                                                                                          if(var44 == null) {
                                                                                                                                             class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                          } else {
                                                                                                                                             class83.intStack[++class46.intStackSize - 1] = var44.spriteId;
                                                                                                                                          }

                                                                                                                                          var26 = 1;
                                                                                                                                       } else if(var15 == 6697) {
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = WorldMapType1.field449.field633;
                                                                                                                                          var26 = 1;
                                                                                                                                       } else if(var15 == 6698) {
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = WorldMapType1.field449.field635.method3913();
                                                                                                                                          var26 = 1;
                                                                                                                                       } else if(var15 == 6699) {
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = WorldMapType1.field449.field632.method3913();
                                                                                                                                          var26 = 1;
                                                                                                                                       } else {
                                                                                                                                          var26 = 2;
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              }
                                                                                                                           }
                                                                                                                        }
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var16 = var26;
                                                                                                               } else {
                                                                                                                  var16 = 2;
                                                                                                               }
                                                                                                            }
                                                                                                         }
                                                                                                      }
                                                                                                   }
                                                                                                }
                                                                                             }

                                                                                             switch(var16) {
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
         } catch (Exception var45) {
            StringBuilder var12 = new StringBuilder(30);
            var12.append("").append(var5.hash).append(" ");

            for(var10 = class83.scriptStackCount - 1; var10 >= 0; --var10) {
               var12.append("").append(class83.scriptStack[var10].invokedFromScript.hash).append(" ");
            }

            var12.append("").append(var49);
            MilliTimer.method2912(var12.toString(), var45);
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2105829881"
   )
   public static boolean method268(int var0) {
      return var0 >= class221.field2828.field2842 && var0 <= class221.field2822.field2842 || var0 == class221.field2823.field2842;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;B)Z",
      garbageValue = "106"
   )
   public static boolean method269(IndexDataBase var0, IndexDataBase var1) {
      class15.field298 = var1;
      if(!var0.method4111()) {
         return false;
      } else {
         Area.field3295 = var0.fileCount(35);
         Area.field3303 = new Area[Area.field3295];

         for(int var2 = 0; var2 < Area.field3295; ++var2) {
            byte[] var3 = var0.getConfigData(35, var2);
            if(var3 != null) {
               Area.field3303[var2] = new Area(var2);
               Area.field3303[var2].method4288(new Buffer(var3));
               Area.field3303[var2].method4310();
            }
         }

         return true;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-18"
   )
   public static final void method270() {
      class134.field2003 = false;
      class134.field2010 = 0;
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-2119057082"
   )
   static final void method271(int var0, int var1, int var2, int var3) {
      ++Client.field957;
      class43.method642(class66.field830);
      boolean var4 = false;
      int var5;
      int var6;
      if(Client.field1056 >= 0) {
         var5 = class96.field1521;
         int[] var7 = class96.field1531;

         for(var6 = 0; var6 < var5; ++var6) {
            if(var7[var6] == Client.field1056) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         class43.method642(class66.field828);
      }

      class82.method1616(true);
      class43.method642(var4?class66.field829:class66.field834);
      class82.method1616(false);

      for(Projectile var29 = (Projectile)Client.projectiles.getFront(); var29 != null; var29 = (Projectile)Client.projectiles.getNext()) {
         if(var29.floor == WallObject.plane && Client.gameCycle <= var29.cycle) {
            if(Client.gameCycle >= var29.startTime) {
               if(var29.interacting > 0) {
                  NPC var8 = Client.cachedNPCs[var29.interacting - 1];
                  if(var8 != null && var8.x >= 0 && var8.x < 13312 && var8.y >= 0 && var8.y < 13312) {
                     var29.method1758(var8.x, var8.y, WorldMapData.getTileHeight(var8.x, var8.y, var29.floor) - var29.endHeight, Client.gameCycle);
                  }
               }

               if(var29.interacting < 0) {
                  var6 = -var29.interacting - 1;
                  Player var31;
                  if(var6 == Client.localInteractingIndex) {
                     var31 = XItemContainer.localPlayer;
                  } else {
                     var31 = Client.cachedPlayers[var6];
                  }

                  if(var31 != null && var31.x >= 0 && var31.x < 13312 && var31.y >= 0 && var31.y < 13312) {
                     var29.method1758(var31.x, var31.y, WorldMapData.getTileHeight(var31.x, var31.y, var29.floor) - var29.endHeight, Client.gameCycle);
                  }
               }

               var29.method1759(Client.field1002);
               class2.region.method2677(WallObject.plane, (int)var29.x, (int)var29.velocityZ, (int)var29.z, 60, var29, var29.rotationX, -1, false);
            }
         } else {
            var29.unlink();
         }
      }

      for(GraphicsObject var30 = (GraphicsObject)Client.graphicsObjectDeque.getFront(); var30 != null; var30 = (GraphicsObject)Client.graphicsObjectDeque.getNext()) {
         if(var30.level == WallObject.plane && !var30.finished) {
            if(Client.gameCycle >= var30.startCycle) {
               var30.method1682(Client.field1002);
               if(var30.finished) {
                  var30.unlink();
               } else {
                  class2.region.method2677(var30.level, var30.x, var30.y, var30.height, 60, var30, 0, -1, false);
               }
            }
         } else {
            var30.unlink();
         }
      }

      Item.method1773(var0, var1, var2, var3, true);
      var0 = Client.field1187;
      var1 = Client.field1188;
      var2 = Client.viewportHeight;
      var3 = Client.viewportWidth;
      Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
      Graphics3D.method2582();
      int var32;
      if(!Client.field1173) {
         var5 = Client.field1052;
         if(Client.field1018 / 256 > var5) {
            var5 = Client.field1018 / 256;
         }

         if(Client.field1174[4] && Client.field996[4] + 128 > var5) {
            var5 = Client.field996[4] + 128;
         }

         var32 = Client.mapAngle + Client.field951 & 2047;
         ScriptEvent.method1126(Ignore.field860, WorldMapData.getTileHeight(XItemContainer.localPlayer.x, XItemContainer.localPlayer.y, WallObject.plane) - Client.field1015, field456, var5, var32, var5 * 3 + 600);
      }

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var33;
      if(!Client.field1173) {
         if(class8.settings.hideRoofs) {
            var32 = WallObject.plane;
         } else {
            label511: {
               var6 = 3;
               if(Player.cameraPitch < 310) {
                  var33 = class155.cameraX >> 7;
                  var9 = class157.cameraY >> 7;
                  var10 = XItemContainer.localPlayer.x >> 7;
                  var11 = XItemContainer.localPlayer.y >> 7;
                  if(var33 < 0 || var9 < 0 || var33 >= 104 || var9 >= 104) {
                     var32 = WallObject.plane;
                     break label511;
                  }

                  if((class61.tileSettings[WallObject.plane][var33][var9] & 4) != 0) {
                     var6 = WallObject.plane;
                  }

                  if(var10 > var33) {
                     var12 = var10 - var33;
                  } else {
                     var12 = var33 - var10;
                  }

                  if(var11 > var9) {
                     var13 = var11 - var9;
                  } else {
                     var13 = var9 - var11;
                  }

                  if(var12 > var13) {
                     var14 = var13 * 65536 / var12;
                     var15 = '耀';

                     while(var10 != var33) {
                        if(var33 < var10) {
                           ++var33;
                        } else if(var33 > var10) {
                           --var33;
                        }

                        if((class61.tileSettings[WallObject.plane][var33][var9] & 4) != 0) {
                           var6 = WallObject.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var9 < var11) {
                              ++var9;
                           } else if(var9 > var11) {
                              --var9;
                           }

                           if((class61.tileSettings[WallObject.plane][var33][var9] & 4) != 0) {
                              var6 = WallObject.plane;
                           }
                        }
                     }
                  } else {
                     var14 = var12 * 65536 / var13;
                     var15 = '耀';

                     while(var11 != var9) {
                        if(var9 < var11) {
                           ++var9;
                        } else if(var9 > var11) {
                           --var9;
                        }

                        if((class61.tileSettings[WallObject.plane][var33][var9] & 4) != 0) {
                           var6 = WallObject.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var33 < var10) {
                              ++var33;
                           } else if(var33 > var10) {
                              --var33;
                           }

                           if((class61.tileSettings[WallObject.plane][var33][var9] & 4) != 0) {
                              var6 = WallObject.plane;
                           }
                        }
                     }
                  }
               }

               if(XItemContainer.localPlayer.x >= 0 && XItemContainer.localPlayer.y >= 0 && XItemContainer.localPlayer.x < 13312 && XItemContainer.localPlayer.y < 13312) {
                  if((class61.tileSettings[WallObject.plane][XItemContainer.localPlayer.x >> 7][XItemContainer.localPlayer.y >> 7] & 4) != 0) {
                     var6 = WallObject.plane;
                  }

                  var32 = var6;
               } else {
                  var32 = WallObject.plane;
               }
            }
         }

         var5 = var32;
      } else {
         if(class8.settings.hideRoofs) {
            var32 = WallObject.plane;
         } else {
            var6 = WorldMapData.getTileHeight(class155.cameraX, class157.cameraY, WallObject.plane);
            if(var6 - class60.cameraZ < 800 && (class61.tileSettings[WallObject.plane][class155.cameraX >> 7][class157.cameraY >> 7] & 4) != 0) {
               var32 = WallObject.plane;
            } else {
               var32 = 3;
            }
         }

         var5 = var32;
      }

      var32 = class155.cameraX;
      var6 = class60.cameraZ;
      var33 = class157.cameraY;
      var9 = Player.cameraPitch;
      var10 = class22.cameraYaw;

      for(var11 = 0; var11 < 5; ++var11) {
         if(Client.field1174[var11]) {
            var12 = (int)(Math.random() * (double)(Client.field1164[var11] * 2 + 1) - (double)Client.field1164[var11] + Math.sin((double)Client.field1177[var11] / 100.0D * (double)Client.field1178[var11]) * (double)Client.field996[var11]);
            if(var11 == 0) {
               class155.cameraX += var12;
            }

            if(var11 == 1) {
               class60.cameraZ += var12;
            }

            if(var11 == 2) {
               class157.cameraY += var12;
            }

            if(var11 == 3) {
               class22.cameraYaw = var12 + class22.cameraYaw & 2047;
            }

            if(var11 == 4) {
               Player.cameraPitch += var12;
               if(Player.cameraPitch < 128) {
                  Player.cameraPitch = 128;
               }

               if(Player.cameraPitch > 383) {
                  Player.cameraPitch = 383;
               }
            }
         }
      }

      var11 = MouseInput.field748;
      var12 = MouseInput.field749;
      if(MouseInput.field742 != 0) {
         var11 = MouseInput.field747;
         var12 = MouseInput.field756;
      }

      if(var11 >= var0 && var11 < var0 + var2 && var12 >= var1 && var12 < var3 + var1) {
         var13 = var11 - var0;
         var14 = var12 - var1;
         class134.field2014 = var13;
         class134.field2008 = var14;
         class134.field2003 = true;
         class134.field2010 = 0;
         class134.field2004 = false;
      } else {
         method270();
      }

      class14.method67();
      Rasterizer2D.method4983(var0, var1, var2, var3, 0);
      class14.method67();
      var13 = Graphics3D.field2031;
      Graphics3D.field2031 = Client.scale;
      class2.region.draw(class155.cameraX, class60.cameraZ, class157.cameraY, Player.cameraPitch, class22.cameraYaw, var5);
      ScriptVarType.method28();
      Graphics3D.field2031 = var13;
      class14.method67();
      class2.region.clearEntities();
      Client.field1046 = 0;
      boolean var16 = false;
      var15 = -1;
      int var17 = class96.field1521;
      int[] var18 = class96.field1531;

      int var19;
      for(var19 = 0; var19 < var17 + Client.field937; ++var19) {
         Object var20;
         if(var19 < var17) {
            var20 = Client.cachedPlayers[var18[var19]];
            if(var18[var19] == Client.field1056) {
               var16 = true;
               var15 = var19;
               continue;
            }
         } else {
            var20 = Client.cachedNPCs[Client.npcIndices[var19 - var17]];
         }

         WorldMapType3.method200((Actor)var20, var19, var0, var1, var2, var3);
      }

      if(var16) {
         WorldMapType3.method200(Client.cachedPlayers[Client.field1056], var15, var0, var1, var2, var3);
      }

      for(var19 = 0; var19 < Client.field1046; ++var19) {
         int var34 = Client.field1021[var19];
         int var21 = Client.field1022[var19];
         int var22 = Client.field1024[var19];
         int var23 = Client.field1009[var19];
         boolean var24 = true;

         while(var24) {
            var24 = false;

            for(int var25 = 0; var25 < var19; ++var25) {
               if(var21 + 2 > Client.field1022[var25] - Client.field1009[var25] && var21 - var23 < Client.field1022[var25] + 2 && var34 - var22 < Client.field1021[var25] + Client.field1024[var25] && var34 + var22 > Client.field1021[var25] - Client.field1024[var25] && Client.field1022[var25] - Client.field1009[var25] < var21) {
                  var21 = Client.field1022[var25] - Client.field1009[var25];
                  var24 = true;
               }
            }
         }

         Client.screenY = Client.field1021[var19];
         Client.screenX = Client.field1022[var19] = var21;
         String var36 = Client.field1028[var19];
         if(Client.field1089 == 0) {
            int var26 = 16776960;
            if(Client.field938[var19] < 6) {
               var26 = Client.field1142[Client.field938[var19]];
            }

            if(Client.field938[var19] == 6) {
               var26 = Client.field957 % 20 < 10?16711680:16776960;
            }

            if(Client.field938[var19] == 7) {
               var26 = Client.field957 % 20 < 10?255:'\uffff';
            }

            if(Client.field938[var19] == 8) {
               var26 = Client.field957 % 20 < 10?'뀀':8454016;
            }

            int var27;
            if(Client.field938[var19] == 9) {
               var27 = 150 - Client.field1027[var19];
               if(var27 < 50) {
                  var26 = var27 * 1280 + 16711680;
               } else if(var27 < 100) {
                  var26 = 16776960 - (var27 - 50) * 327680;
               } else if(var27 < 150) {
                  var26 = (var27 - 100) * 5 + '\uff00';
               }
            }

            if(Client.field938[var19] == 10) {
               var27 = 150 - Client.field1027[var19];
               if(var27 < 50) {
                  var26 = var27 * 5 + 16711680;
               } else if(var27 < 100) {
                  var26 = 16711935 - (var27 - 50) * 327680;
               } else if(var27 < 150) {
                  var26 = (var27 - 100) * 327680 + 255 - (var27 - 100) * 5;
               }
            }

            if(Client.field938[var19] == 11) {
               var27 = 150 - Client.field1027[var19];
               if(var27 < 50) {
                  var26 = 16777215 - var27 * 327685;
               } else if(var27 < 100) {
                  var26 = (var27 - 50) * 327685 + '\uff00';
               } else if(var27 < 150) {
                  var26 = 16777215 - (var27 - 100) * 327680;
               }
            }

            if(Client.field1151[var19] == 0) {
               World.field1322.method4757(var36, var0 + Client.screenY, Client.screenX + var1, var26, 0);
            }

            if(Client.field1151[var19] == 1) {
               World.field1322.method4759(var36, var0 + Client.screenY, Client.screenX + var1, var26, 0, Client.field957);
            }

            if(Client.field1151[var19] == 2) {
               World.field1322.method4760(var36, var0 + Client.screenY, Client.screenX + var1, var26, 0, Client.field957);
            }

            if(Client.field1151[var19] == 3) {
               World.field1322.method4770(var36, var0 + Client.screenY, Client.screenX + var1, var26, 0, Client.field957, 150 - Client.field1027[var19]);
            }

            if(Client.field1151[var19] == 4) {
               var27 = (150 - Client.field1027[var19]) * (World.field1322.method4773(var36) + 100) / 150;
               Rasterizer2D.setInnerDrawRegion(var0 + Client.screenY - 50, var1, var0 + Client.screenY + 50, var3 + var1);
               World.field1322.method4790(var36, var0 + Client.screenY + 50 - var27, Client.screenX + var1, var26, 0);
               Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
            }

            if(Client.field1151[var19] == 5) {
               var27 = 150 - Client.field1027[var19];
               int var28 = 0;
               if(var27 < 25) {
                  var28 = var27 - 25;
               } else if(var27 > 125) {
                  var28 = var27 - 125;
               }

               Rasterizer2D.setInnerDrawRegion(var0, Client.screenX + var1 - World.field1322.verticalSpace - 1, var0 + var2, Client.screenX + var1 + 5);
               World.field1322.method4757(var36, var0 + Client.screenY, Client.screenX + var1 + var28, var26, 0);
               Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            World.field1322.method4757(var36, var0 + Client.screenY, Client.screenX + var1, 16776960, 0);
         }
      }

      if(Client.field943 == 2) {
         class82.method1626((Client.hintArrowX - KeyFocusListener.baseX << 7) + Client.field980, (Client.hintArrowY - class266.baseY << 7) + Client.field950, Client.hintArrowType * 2);
         if(Client.screenY > -1 && Client.gameCycle % 20 < 10) {
            class43.pkIcons[0].method5042(var0 + Client.screenY - 12, Client.screenX + var1 - 28);
         }
      }

      ((TextureProvider)Graphics3D.textureLoader).method2390(Client.field1002);
      class270.method4894(var0, var1, var2, var3);
      class155.cameraX = var32;
      class60.cameraZ = var6;
      class157.cameraY = var33;
      Player.cameraPitch = var9;
      class22.cameraYaw = var10;
      if(Client.field934) {
         byte var35 = 0;
         var15 = class238.field3265 + class238.field3266 + var35;
         if(var15 == 0) {
            Client.field934 = false;
         }
      }

      if(Client.field934) {
         Rasterizer2D.method4983(var0, var1, var2, var3, 0);
         class2.drawStatusBox("Loading - please wait.", false);
      }

   }
}
