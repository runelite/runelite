import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class31 {
   @ObfuscatedName("gn")
   @Export("mapedge")
   static SpritePixels mapedge;
   @ObfuscatedName("gf")
   static SpritePixels[] field458;
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      intValue = -966178393
   )
   static int field457;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = -650567781
   )
   static int field456;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1462557629
   )
   final int field454;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1253884571
   )
   final int field453;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1920504659
   )
   final int field455;

   class31(int var1, int var2, int var3) {
      this.field454 = var1;
      this.field453 = var2;
      this.field455 = var3;
   }

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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2105829881"
   )
   public static boolean method268(int var0) {
      return var0 >= class221.field2828.field2842 && var0 <= class221.field2822.field2842 || var0 == class221.field2823.field2842;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LScriptEvent;II)V",
      garbageValue = "-1681320379"
   )
   static void method267(ScriptEvent var0, int var1) {
      Object[] var2 = var0.field857;
      class219 var5 = var0.field858;
      boolean var4 = var5 == class219.field2801 || var5 == class219.field2795 || var5 == class219.field2796 || var5 == class219.field2797 || var5 == class219.field2798 || var5 == class219.field2799 || var5 == class219.field2800 || var5 == class219.field2794;
      Script var3;
      int var24;
      if(var4) {
         WorldMapType1.field449 = (class47)var2[0];
         Area var6 = Area.field3303[WorldMapType1.field449.field633];
         var3 = Client.method1231(var0.field858, var6.field3297, var6.field3307);
      } else {
         var24 = ((Integer)var2[0]).intValue();
         Script var8 = (Script)Script.field1551.get((long)var24);
         Script var7;
         if(var8 != null) {
            var7 = var8;
         } else {
            byte[] var37 = class169.indexScripts.getConfigData(var24, 0);
            if(var37 == null) {
               var7 = null;
            } else {
               var8 = class48.method738(var37);
               Script.field1551.put(var8, (long)var24);
               var7 = var8;
            }
         }

         var3 = var7;
      }

      if(var3 != null) {
         class46.intStackSize = 0;
         KeyFocusListener.scriptStringStackSize = 0;
         var24 = -1;
         int[] var41 = var3.instructions;
         int[] var42 = var3.intOperands;
         byte var9 = -1;
         class83.scriptStackCount = 0;

         int var12;
         try {
            class83.scriptLocalInts = new int[var3.localIntCount];
            int var10 = 0;
            class83.scriptLocalStrings = new String[var3.localStringCount];
            int var11 = 0;

            int var13;
            String var25;
            for(var12 = 1; var12 < var2.length; ++var12) {
               if(var2[var12] instanceof Integer) {
                  var13 = ((Integer)var2[var12]).intValue();
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

                  class83.scriptLocalInts[var10++] = var13;
               } else if(var2[var12] instanceof String) {
                  var25 = (String)var2[var12];
                  if(var25.equals("event_opbase")) {
                     var25 = var0.field856;
                  }

                  class83.scriptLocalStrings[var11++] = var25;
               }
            }

            var12 = 0;
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
                                                                                       label2630:
                                                                                       while(true) {
                                                                                          ++var12;
                                                                                          if(var12 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var24;
                                                                                          int var43 = var41[var24];
                                                                                          int var14;
                                                                                          int var16;
                                                                                          int var18;
                                                                                          int var20;
                                                                                          int var28;
                                                                                          int var31;
                                                                                          String var32;
                                                                                          String var48;
                                                                                          String var56;
                                                                                          if(var43 < 100) {
                                                                                             if(var43 != 0) {
                                                                                                if(var43 != 1) {
                                                                                                   if(var43 != 2) {
                                                                                                      if(var43 != 3) {
                                                                                                         if(var43 != 6) {
                                                                                                            if(var43 != 7) {
                                                                                                               if(var43 != 8) {
                                                                                                                  if(var43 != 9) {
                                                                                                                     if(var43 != 10) {
                                                                                                                        if(var43 != 21) {
                                                                                                                           if(var43 != 25) {
                                                                                                                              if(var43 != 27) {
                                                                                                                                 if(var43 != 31) {
                                                                                                                                    if(var43 != 32) {
                                                                                                                                       if(var43 != 33) {
                                                                                                                                          if(var43 != 34) {
                                                                                                                                             if(var43 != 35) {
                                                                                                                                                if(var43 != 36) {
                                                                                                                                                   if(var43 != 37) {
                                                                                                                                                      if(var43 != 38) {
                                                                                                                                                         if(var43 != 39) {
                                                                                                                                                            if(var43 != 40) {
                                                                                                                                                               if(var43 != 42) {
                                                                                                                                                                  if(var43 != 43) {
                                                                                                                                                                     if(var43 == 44) {
                                                                                                                                                                        var13 = var42[var24] >> 16;
                                                                                                                                                                        var14 = var42[var24] & '\uffff';
                                                                                                                                                                        int var91 = class83.intStack[--class46.intStackSize];
                                                                                                                                                                        if(var91 >= 0 && var91 <= 5000) {
                                                                                                                                                                           class83.field1358[var13] = var91;
                                                                                                                                                                           byte var86 = -1;
                                                                                                                                                                           if(var14 == 105) {
                                                                                                                                                                              var86 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var31 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var31 >= var91) {
                                                                                                                                                                                 continue label2630;
                                                                                                                                                                              }

                                                                                                                                                                              class83.SHAPE_VERTICIES[var13][var31] = var86;
                                                                                                                                                                              ++var31;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var43 == 45) {
                                                                                                                                                                        var13 = var42[var24];
                                                                                                                                                                        var14 = class83.intStack[--class46.intStackSize];
                                                                                                                                                                        if(var14 < 0 || var14 >= class83.field1358[var13]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class83.intStack[++class46.intStackSize - 1] = class83.SHAPE_VERTICIES[var13][var14];
                                                                                                                                                                     } else if(var43 == 46) {
                                                                                                                                                                        var13 = var42[var24];
                                                                                                                                                                        class46.intStackSize -= 2;
                                                                                                                                                                        var14 = class83.intStack[class46.intStackSize];
                                                                                                                                                                        if(var14 < 0 || var14 >= class83.field1358[var13]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class83.SHAPE_VERTICIES[var13][var14] = class83.intStack[class46.intStackSize + 1];
                                                                                                                                                                     } else if(var43 == 47) {
                                                                                                                                                                        var25 = class71.chatMessages.getVarcString(var42[var24]);
                                                                                                                                                                        if(var25 == null) {
                                                                                                                                                                           var25 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var25;
                                                                                                                                                                     } else if(var43 == 48) {
                                                                                                                                                                        class71.chatMessages.putVarcString(var42[var24], class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var43 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        class186 var66 = var3.switches[var42[var24]];
                                                                                                                                                                        WidgetConfig var80 = (WidgetConfig)var66.method3478((long)class83.intStack[--class46.intStackSize]);
                                                                                                                                                                        if(var80 != null) {
                                                                                                                                                                           var24 += var80.config;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     class71.chatMessages.putVarc(var42[var24], class83.intStack[--class46.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class83.intStack[++class46.intStackSize - 1] = class71.chatMessages.getVarc(var42[var24]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var13 = var42[var24];
                                                                                                                                                               Script var70 = (Script)Script.field1551.get((long)var13);
                                                                                                                                                               Script var76;
                                                                                                                                                               if(var70 != null) {
                                                                                                                                                                  var76 = var70;
                                                                                                                                                               } else {
                                                                                                                                                                  byte[] var89 = class169.indexScripts.getConfigData(var13, 0);
                                                                                                                                                                  if(var89 == null) {
                                                                                                                                                                     var76 = null;
                                                                                                                                                                  } else {
                                                                                                                                                                     var70 = class48.method738(var89);
                                                                                                                                                                     Script.field1551.put(var70, (long)var13);
                                                                                                                                                                     var76 = var70;
                                                                                                                                                                  }
                                                                                                                                                               }

                                                                                                                                                               var70 = var76;
                                                                                                                                                               int[] var90 = new int[var76.localIntCount];
                                                                                                                                                               String[] var77 = new String[var76.localStringCount];

                                                                                                                                                               for(var18 = 0; var18 < var70.intStackCount; ++var18) {
                                                                                                                                                                  var90[var18] = class83.intStack[var18 + (class46.intStackSize - var70.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var18 = 0; var18 < var70.stringStackCount; ++var18) {
                                                                                                                                                                  var77[var18] = class83.scriptStringStack[var18 + (KeyFocusListener.scriptStringStackSize - var70.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class46.intStackSize -= var70.intStackCount;
                                                                                                                                                               KeyFocusListener.scriptStringStackSize -= var70.stringStackCount;
                                                                                                                                                               ScriptState var81 = new ScriptState();
                                                                                                                                                               var81.invokedFromScript = var3;
                                                                                                                                                               var81.invokedFromPc = var24;
                                                                                                                                                               var81.savedLocalInts = class83.scriptLocalInts;
                                                                                                                                                               var81.savedLocalStrings = class83.scriptLocalStrings;
                                                                                                                                                               class83.scriptStack[++class83.scriptStackCount - 1] = var81;
                                                                                                                                                               var3 = var70;
                                                                                                                                                               var41 = var70.instructions;
                                                                                                                                                               var42 = var70.intOperands;
                                                                                                                                                               var24 = -1;
                                                                                                                                                               class83.scriptLocalInts = var90;
                                                                                                                                                               class83.scriptLocalStrings = var77;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --KeyFocusListener.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class46.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var13 = var42[var24];
                                                                                                                                                      KeyFocusListener.scriptStringStackSize -= var13;
                                                                                                                                                      String[] var29 = class83.scriptStringStack;
                                                                                                                                                      var16 = KeyFocusListener.scriptStringStackSize;
                                                                                                                                                      String var30;
                                                                                                                                                      if(var13 == 0) {
                                                                                                                                                         var30 = "";
                                                                                                                                                      } else if(var13 == 1) {
                                                                                                                                                         var48 = var29[var16];
                                                                                                                                                         if(var48 == null) {
                                                                                                                                                            var30 = "null";
                                                                                                                                                         } else {
                                                                                                                                                            var30 = var48.toString();
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         var31 = var16 + var13;
                                                                                                                                                         var18 = 0;

                                                                                                                                                         for(var28 = var16; var28 < var31; ++var28) {
                                                                                                                                                            var32 = var29[var28];
                                                                                                                                                            if(var32 == null) {
                                                                                                                                                               var18 += 4;
                                                                                                                                                            } else {
                                                                                                                                                               var18 += var32.length();
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         StringBuilder var55 = new StringBuilder(var18);

                                                                                                                                                         for(var20 = var16; var20 < var31; ++var20) {
                                                                                                                                                            var56 = var29[var20];
                                                                                                                                                            if(var56 == null) {
                                                                                                                                                               var55.append("null");
                                                                                                                                                            } else {
                                                                                                                                                               var55.append(var56);
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         var30 = var55.toString();
                                                                                                                                                      }

                                                                                                                                                      class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var30;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class83.scriptLocalStrings[var42[var24]] = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = class83.scriptLocalStrings[var42[var24]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class83.scriptLocalInts[var42[var24]] = class83.intStack[--class46.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = class83.scriptLocalInts[var42[var24]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class46.intStackSize -= 2;
                                                                                                                                       if(class83.intStack[class46.intStackSize] >= class83.intStack[class46.intStackSize + 1]) {
                                                                                                                                          var24 += var42[var24];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class46.intStackSize -= 2;
                                                                                                                                    if(class83.intStack[class46.intStackSize] <= class83.intStack[class46.intStackSize + 1]) {
                                                                                                                                       var24 += var42[var24];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var13 = var42[var24];
                                                                                                                                 DynamicObject.method1874(var13, class83.intStack[--class46.intStackSize]);
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var13 = var42[var24];
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = WorldMapType1.method264(var13);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class83.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var61 = class83.scriptStack[--class83.scriptStackCount];
                                                                                                                           var3 = var61.invokedFromScript;
                                                                                                                           var41 = var3.instructions;
                                                                                                                           var42 = var3.intOperands;
                                                                                                                           var24 = var61.invokedFromPc;
                                                                                                                           class83.scriptLocalInts = var61.savedLocalInts;
                                                                                                                           class83.scriptLocalStrings = var61.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class46.intStackSize -= 2;
                                                                                                                        if(class83.intStack[class46.intStackSize] > class83.intStack[class46.intStackSize + 1]) {
                                                                                                                           var24 += var42[var24];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class46.intStackSize -= 2;
                                                                                                                     if(class83.intStack[class46.intStackSize] < class83.intStack[class46.intStackSize + 1]) {
                                                                                                                        var24 += var42[var24];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class46.intStackSize -= 2;
                                                                                                                  if(class83.intStack[class46.intStackSize] == class83.intStack[class46.intStackSize + 1]) {
                                                                                                                     var24 += var42[var24];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class46.intStackSize -= 2;
                                                                                                               if(class83.intStack[class46.intStackSize] != class83.intStack[class46.intStackSize + 1]) {
                                                                                                                  var24 += var42[var24];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var24 += var42[var24];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3.stringOperands[var24];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var13 = var42[var24];
                                                                                                      class211.widgetSettings[var13] = class83.intStack[--class46.intStackSize];
                                                                                                      Preferences.method1614(var13);
                                                                                                   }
                                                                                                } else {
                                                                                                   var13 = var42[var24];
                                                                                                   class83.intStack[++class46.intStackSize - 1] = class211.widgetSettings[var13];
                                                                                                }
                                                                                             } else {
                                                                                                class83.intStack[++class46.intStackSize - 1] = var42[var24];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var47;
                                                                                             if(var3.intOperands[var24] == 1) {
                                                                                                var47 = true;
                                                                                             } else {
                                                                                                var47 = false;
                                                                                             }

                                                                                             if(var43 < 1000) {
                                                                                                var14 = class33.method345(var43, var3, var47);
                                                                                             } else if(var43 < 1100) {
                                                                                                var14 = class170.method3117(var43, var3, var47);
                                                                                             } else if(var43 < 1200) {
                                                                                                var14 = class261.method4736(var43, var3, var47);
                                                                                             } else if(var43 < 1300) {
                                                                                                var14 = PacketBuffer.method3414(var43, var3, var47);
                                                                                             } else if(var43 < 1400) {
                                                                                                var14 = class39.method559(var43, var3, var47);
                                                                                             } else if(var43 < 1500) {
                                                                                                var14 = SoundTask.method2081(var43, var3, var47);
                                                                                             } else {
                                                                                                byte var15;
                                                                                                Widget var19;
                                                                                                if(var43 < 1600) {
                                                                                                   var19 = var47?class83.field1364:class60.field766;
                                                                                                   if(var43 == 1500) {
                                                                                                      class83.intStack[++class46.intStackSize - 1] = var19.relativeX;
                                                                                                      var15 = 1;
                                                                                                   } else if(var43 == 1501) {
                                                                                                      class83.intStack[++class46.intStackSize - 1] = var19.relativeY;
                                                                                                      var15 = 1;
                                                                                                   } else if(var43 == 1502) {
                                                                                                      class83.intStack[++class46.intStackSize - 1] = var19.width;
                                                                                                      var15 = 1;
                                                                                                   } else if(var43 == 1503) {
                                                                                                      class83.intStack[++class46.intStackSize - 1] = var19.height;
                                                                                                      var15 = 1;
                                                                                                   } else if(var43 == 1504) {
                                                                                                      class83.intStack[++class46.intStackSize - 1] = var19.isHidden?1:0;
                                                                                                      var15 = 1;
                                                                                                   } else if(var43 == 1505) {
                                                                                                      class83.intStack[++class46.intStackSize - 1] = var19.parentId;
                                                                                                      var15 = 1;
                                                                                                   } else {
                                                                                                      var15 = 2;
                                                                                                   }

                                                                                                   var14 = var15;
                                                                                                } else if(var43 < 1700) {
                                                                                                   var14 = class61.method1101(var43, var3, var47);
                                                                                                } else if(var43 < 1800) {
                                                                                                   var19 = var47?class83.field1364:class60.field766;
                                                                                                   if(var43 == 1700) {
                                                                                                      class83.intStack[++class46.intStackSize - 1] = var19.itemId;
                                                                                                      var15 = 1;
                                                                                                   } else if(var43 == 1701) {
                                                                                                      if(var19.itemId != -1) {
                                                                                                         class83.intStack[++class46.intStackSize - 1] = var19.itemQuantity;
                                                                                                      } else {
                                                                                                         class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                      }

                                                                                                      var15 = 1;
                                                                                                   } else if(var43 == 1702) {
                                                                                                      class83.intStack[++class46.intStackSize - 1] = var19.index;
                                                                                                      var15 = 1;
                                                                                                   } else {
                                                                                                      var15 = 2;
                                                                                                   }

                                                                                                   var14 = var15;
                                                                                                } else if(var43 < 1900) {
                                                                                                   var14 = FileOnDisk.method2366(var43, var3, var47);
                                                                                                } else {
                                                                                                   Widget var17;
                                                                                                   ScriptEvent var26;
                                                                                                   if(var43 < 2000) {
                                                                                                      var16 = var43;
                                                                                                      if(var43 >= 2000) {
                                                                                                         var16 = var43 - 1000;
                                                                                                         var17 = PacketBuffer.method3403(class83.intStack[--class46.intStackSize]);
                                                                                                      } else {
                                                                                                         var17 = var47?class83.field1364:class60.field766;
                                                                                                      }

                                                                                                      if(var16 == 1927) {
                                                                                                         if(class83.field1367 >= 10) {
                                                                                                            throw new RuntimeException();
                                                                                                         }

                                                                                                         if(var17.field2763 == null) {
                                                                                                            var15 = 0;
                                                                                                         } else {
                                                                                                            var26 = new ScriptEvent();
                                                                                                            var26.widget = var17;
                                                                                                            var26.field857 = var17.field2763;
                                                                                                            var26.field851 = class83.field1367 + 1;
                                                                                                            Client.field1035.addFront(var26);
                                                                                                            var15 = 1;
                                                                                                         }
                                                                                                      } else {
                                                                                                         var15 = 2;
                                                                                                      }

                                                                                                      var14 = var15;
                                                                                                   } else if(var43 < 2100) {
                                                                                                      var14 = class170.method3117(var43, var3, var47);
                                                                                                   } else if(var43 < 2200) {
                                                                                                      var14 = class261.method4736(var43, var3, var47);
                                                                                                   } else if(var43 < 2300) {
                                                                                                      var14 = PacketBuffer.method3414(var43, var3, var47);
                                                                                                   } else if(var43 < 2400) {
                                                                                                      var14 = class39.method559(var43, var3, var47);
                                                                                                   } else if(var43 < 2500) {
                                                                                                      var14 = SoundTask.method2081(var43, var3, var47);
                                                                                                   } else if(var43 < 2600) {
                                                                                                      var14 = class207.method3862(var43, var3, var47);
                                                                                                   } else if(var43 < 2700) {
                                                                                                      var14 = class71.method1141(var43, var3, var47);
                                                                                                   } else {
                                                                                                      Widget var27;
                                                                                                      if(var43 < 2800) {
                                                                                                         if(var43 == 2700) {
                                                                                                            var27 = PacketBuffer.method3403(class83.intStack[--class46.intStackSize]);
                                                                                                            class83.intStack[++class46.intStackSize - 1] = var27.itemId;
                                                                                                            var15 = 1;
                                                                                                         } else if(var43 == 2701) {
                                                                                                            var27 = PacketBuffer.method3403(class83.intStack[--class46.intStackSize]);
                                                                                                            if(var27.itemId != -1) {
                                                                                                               class83.intStack[++class46.intStackSize - 1] = var27.itemQuantity;
                                                                                                            } else {
                                                                                                               class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                            }

                                                                                                            var15 = 1;
                                                                                                         } else if(var43 == 2702) {
                                                                                                            var16 = class83.intStack[--class46.intStackSize];
                                                                                                            WidgetNode var44 = (WidgetNode)Client.componentTable.get((long)var16);
                                                                                                            if(var44 != null) {
                                                                                                               class83.intStack[++class46.intStackSize - 1] = 1;
                                                                                                            } else {
                                                                                                               class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                            }

                                                                                                            var15 = 1;
                                                                                                         } else if(var43 == 2706) {
                                                                                                            class83.intStack[++class46.intStackSize - 1] = Client.widgetRoot;
                                                                                                            var15 = 1;
                                                                                                         } else {
                                                                                                            var15 = 2;
                                                                                                         }

                                                                                                         var14 = var15;
                                                                                                      } else if(var43 < 2900) {
                                                                                                         var27 = PacketBuffer.method3403(class83.intStack[--class46.intStackSize]);
                                                                                                         if(var43 == 2800) {
                                                                                                            int[] var45 = class83.intStack;
                                                                                                            var18 = ++class46.intStackSize - 1;
                                                                                                            var20 = WorldMapType3.getWidgetConfig(var27);
                                                                                                            var28 = var20 >> 11 & 63;
                                                                                                            var45[var18] = var28;
                                                                                                            var15 = 1;
                                                                                                         } else if(var43 != 2801) {
                                                                                                            if(var43 == 2802) {
                                                                                                               if(var27.name == null) {
                                                                                                                  class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                               } else {
                                                                                                                  class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var27.name;
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else {
                                                                                                               var15 = 2;
                                                                                                            }
                                                                                                         } else {
                                                                                                            var31 = class83.intStack[--class46.intStackSize];
                                                                                                            --var31;
                                                                                                            if(var27.actions != null && var31 < var27.actions.length && var27.actions[var31] != null) {
                                                                                                               class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var27.actions[var31];
                                                                                                            } else {
                                                                                                               class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                            }

                                                                                                            var15 = 1;
                                                                                                         }

                                                                                                         var14 = var15;
                                                                                                      } else if(var43 < 3000) {
                                                                                                         var16 = var43;
                                                                                                         if(var43 >= 2000) {
                                                                                                            var16 = var43 - 1000;
                                                                                                            var17 = PacketBuffer.method3403(class83.intStack[--class46.intStackSize]);
                                                                                                         } else {
                                                                                                            var17 = var47?class83.field1364:class60.field766;
                                                                                                         }

                                                                                                         if(var16 == 1927) {
                                                                                                            if(class83.field1367 >= 10) {
                                                                                                               throw new RuntimeException();
                                                                                                            }

                                                                                                            if(var17.field2763 == null) {
                                                                                                               var15 = 0;
                                                                                                            } else {
                                                                                                               var26 = new ScriptEvent();
                                                                                                               var26.widget = var17;
                                                                                                               var26.field857 = var17.field2763;
                                                                                                               var26.field851 = class83.field1367 + 1;
                                                                                                               Client.field1035.addFront(var26);
                                                                                                               var15 = 1;
                                                                                                            }
                                                                                                         } else {
                                                                                                            var15 = 2;
                                                                                                         }

                                                                                                         var14 = var15;
                                                                                                      } else {
                                                                                                         String var65;
                                                                                                         String var68;
                                                                                                         boolean var82;
                                                                                                         if(var43 < 3200) {
                                                                                                            if(var43 == 3100) {
                                                                                                               var68 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                               class152.sendGameMessage(0, "", var68);
                                                                                                               var15 = 1;
                                                                                                            } else if(var43 == 3101) {
                                                                                                               class46.intStackSize -= 2;
                                                                                                               RSCanvas.method810(XItemContainer.localPlayer, class83.intStack[class46.intStackSize], class83.intStack[class46.intStackSize + 1]);
                                                                                                               var15 = 1;
                                                                                                            } else if(var43 == 3103) {
                                                                                                               class112.method2097();
                                                                                                               var15 = 1;
                                                                                                            } else if(var43 == 3104) {
                                                                                                               var68 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                               var31 = 0;
                                                                                                               boolean var46 = class51.method795(var68, 10, true);
                                                                                                               if(var46) {
                                                                                                                  var31 = ScriptState.method1103(var68);
                                                                                                               }

                                                                                                               Client.secretPacketBuffer1.putOpcode(205);
                                                                                                               Client.secretPacketBuffer1.putInt(var31);
                                                                                                               var15 = 1;
                                                                                                            } else if(var43 == 3105) {
                                                                                                               var68 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                               Client.secretPacketBuffer1.putOpcode(43);
                                                                                                               Client.secretPacketBuffer1.putByte(var68.length() + 1);
                                                                                                               Client.secretPacketBuffer1.putString(var68);
                                                                                                               var15 = 1;
                                                                                                            } else if(var43 == 3106) {
                                                                                                               var68 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                               Client.secretPacketBuffer1.putOpcode(107);
                                                                                                               Client.secretPacketBuffer1.putByte(var68.length() + 1);
                                                                                                               Client.secretPacketBuffer1.putString(var68);
                                                                                                               var15 = 1;
                                                                                                            } else if(var43 == 3107) {
                                                                                                               var16 = class83.intStack[--class46.intStackSize];
                                                                                                               var48 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                               class60.method1051(var16, var48);
                                                                                                               var15 = 1;
                                                                                                            } else if(var43 == 3108) {
                                                                                                               class46.intStackSize -= 3;
                                                                                                               var16 = class83.intStack[class46.intStackSize];
                                                                                                               var31 = class83.intStack[class46.intStackSize + 1];
                                                                                                               var18 = class83.intStack[class46.intStackSize + 2];
                                                                                                               var19 = PacketBuffer.method3403(var18);
                                                                                                               class140.method2856(var19, var16, var31);
                                                                                                               var15 = 1;
                                                                                                            } else if(var43 == 3109) {
                                                                                                               class46.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[class46.intStackSize];
                                                                                                               var31 = class83.intStack[class46.intStackSize + 1];
                                                                                                               Widget var64 = var47?class83.field1364:class60.field766;
                                                                                                               class140.method2856(var64, var16, var31);
                                                                                                               var15 = 1;
                                                                                                            } else if(var43 == 3110) {
                                                                                                               class34.field499 = class83.intStack[--class46.intStackSize] == 1;
                                                                                                               var15 = 1;
                                                                                                            } else if(var43 == 3111) {
                                                                                                               class83.intStack[++class46.intStackSize - 1] = class8.settings.hideRoofs?1:0;
                                                                                                               var15 = 1;
                                                                                                            } else if(var43 == 3112) {
                                                                                                               class8.settings.hideRoofs = class83.intStack[--class46.intStackSize] == 1;
                                                                                                               class1.method3();
                                                                                                               var15 = 1;
                                                                                                            } else if(var43 == 3113) {
                                                                                                               var68 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                               var82 = class83.intStack[--class46.intStackSize] == 1;
                                                                                                               Player.method1175(var68, var82, false);
                                                                                                               var15 = 1;
                                                                                                            } else if(var43 == 3115) {
                                                                                                               var16 = class83.intStack[--class46.intStackSize];
                                                                                                               Client.secretPacketBuffer1.putOpcode(55);
                                                                                                               Client.secretPacketBuffer1.putShort(var16);
                                                                                                               var15 = 1;
                                                                                                            } else if(var43 == 3116) {
                                                                                                               var16 = class83.intStack[--class46.intStackSize];
                                                                                                               KeyFocusListener.scriptStringStackSize -= 2;
                                                                                                               var48 = class83.scriptStringStack[KeyFocusListener.scriptStringStackSize];
                                                                                                               var65 = class83.scriptStringStack[KeyFocusListener.scriptStringStackSize + 1];
                                                                                                               if(var48.length() > 500) {
                                                                                                                  var15 = 1;
                                                                                                               } else if(var65.length() > 500) {
                                                                                                                  var15 = 1;
                                                                                                               } else {
                                                                                                                  Client.secretPacketBuffer1.putOpcode(102);
                                                                                                                  Client.secretPacketBuffer1.putShort(1 + class261.getLength(var48) + class261.getLength(var65));
                                                                                                                  Client.secretPacketBuffer1.putString(var65);
                                                                                                                  Client.secretPacketBuffer1.putString(var48);
                                                                                                                  Client.secretPacketBuffer1.putByte(var16);
                                                                                                                  var15 = 1;
                                                                                                               }
                                                                                                            } else if(var43 == 3117) {
                                                                                                               Client.field1075 = class83.intStack[--class46.intStackSize] == 1;
                                                                                                               var15 = 1;
                                                                                                            } else {
                                                                                                               var15 = 2;
                                                                                                            }

                                                                                                            var14 = var15;
                                                                                                         } else if(var43 < 3300) {
                                                                                                            if(var43 == 3200) {
                                                                                                               class46.intStackSize -= 3;
                                                                                                               class34.method356(class83.intStack[class46.intStackSize], class83.intStack[class46.intStackSize + 1], class83.intStack[class46.intStackSize + 2]);
                                                                                                               var15 = 1;
                                                                                                            } else if(var43 == 3201) {
                                                                                                               class266.method4842(class83.intStack[--class46.intStackSize]);
                                                                                                               var15 = 1;
                                                                                                            } else if(var43 == 3202) {
                                                                                                               class46.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[class46.intStackSize];
                                                                                                               var31 = class83.intStack[class46.intStackSize + 1];
                                                                                                               if(Client.field1162 != 0 && var16 != -1) {
                                                                                                                  class29.method232(XGrandExchangeOffer.indexTrack2, var16, 0, Client.field1162, false);
                                                                                                                  Client.field1014 = true;
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else {
                                                                                                               var15 = 2;
                                                                                                            }

                                                                                                            var14 = var15;
                                                                                                         } else {
                                                                                                            int[] var67;
                                                                                                            if(var43 < 3400) {
                                                                                                               if(var43 == 3300) {
                                                                                                                  class83.intStack[++class46.intStackSize - 1] = Client.gameCycle;
                                                                                                                  var15 = 1;
                                                                                                               } else {
                                                                                                                  XItemContainer var21;
                                                                                                                  if(var43 == 3301) {
                                                                                                                     class46.intStackSize -= 2;
                                                                                                                     var16 = class83.intStack[class46.intStackSize];
                                                                                                                     var31 = class83.intStack[class46.intStackSize + 1];
                                                                                                                     var67 = class83.intStack;
                                                                                                                     var28 = ++class46.intStackSize - 1;
                                                                                                                     var21 = (XItemContainer)XItemContainer.itemContainers.get((long)var16);
                                                                                                                     if(var21 == null) {
                                                                                                                        var20 = -1;
                                                                                                                     } else if(var31 >= 0 && var31 < var21.itemIds.length) {
                                                                                                                        var20 = var21.itemIds[var31];
                                                                                                                     } else {
                                                                                                                        var20 = -1;
                                                                                                                     }

                                                                                                                     var67[var28] = var20;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3302) {
                                                                                                                     class46.intStackSize -= 2;
                                                                                                                     var16 = class83.intStack[class46.intStackSize];
                                                                                                                     var31 = class83.intStack[class46.intStackSize + 1];
                                                                                                                     var67 = class83.intStack;
                                                                                                                     var28 = ++class46.intStackSize - 1;
                                                                                                                     var21 = (XItemContainer)XItemContainer.itemContainers.get((long)var16);
                                                                                                                     if(var21 == null) {
                                                                                                                        var20 = 0;
                                                                                                                     } else if(var31 >= 0 && var31 < var21.stackSizes.length) {
                                                                                                                        var20 = var21.stackSizes[var31];
                                                                                                                     } else {
                                                                                                                        var20 = 0;
                                                                                                                     }

                                                                                                                     var67[var28] = var20;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3303) {
                                                                                                                     class46.intStackSize -= 2;
                                                                                                                     var16 = class83.intStack[class46.intStackSize];
                                                                                                                     var31 = class83.intStack[class46.intStackSize + 1];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = BaseVarType.method17(var16, var31);
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3304) {
                                                                                                                     var16 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = class211.method3908(var16).field3287;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3305) {
                                                                                                                     var16 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.boostedSkillLevels[var16];
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3306) {
                                                                                                                     var16 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.realSkillLevels[var16];
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3307) {
                                                                                                                     var16 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.skillExperiences[var16];
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3308) {
                                                                                                                     var16 = WallObject.plane;
                                                                                                                     var31 = (XItemContainer.localPlayer.x >> 7) + KeyFocusListener.baseX;
                                                                                                                     var18 = (XItemContainer.localPlayer.y >> 7) + class266.baseY;
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = (var31 << 14) + (var16 << 28) + var18;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3309) {
                                                                                                                     var16 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = var16 >> 14 & 16383;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3310) {
                                                                                                                     var16 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = var16 >> 28;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3311) {
                                                                                                                     var16 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = var16 & 16383;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3312) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.isMembers?1:0;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3313) {
                                                                                                                     class46.intStackSize -= 2;
                                                                                                                     var16 = class83.intStack[class46.intStackSize] + '耀';
                                                                                                                     var31 = class83.intStack[class46.intStackSize + 1];
                                                                                                                     var67 = class83.intStack;
                                                                                                                     var28 = ++class46.intStackSize - 1;
                                                                                                                     var21 = (XItemContainer)XItemContainer.itemContainers.get((long)var16);
                                                                                                                     if(var21 == null) {
                                                                                                                        var20 = -1;
                                                                                                                     } else if(var31 >= 0 && var31 < var21.itemIds.length) {
                                                                                                                        var20 = var21.itemIds[var31];
                                                                                                                     } else {
                                                                                                                        var20 = -1;
                                                                                                                     }

                                                                                                                     var67[var28] = var20;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 != 3314) {
                                                                                                                     if(var43 == 3315) {
                                                                                                                        class46.intStackSize -= 2;
                                                                                                                        var16 = class83.intStack[class46.intStackSize] + '耀';
                                                                                                                        var31 = class83.intStack[class46.intStackSize + 1];
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = BaseVarType.method17(var16, var31);
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 3316) {
                                                                                                                        if(Client.rights >= 2) {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = Client.rights;
                                                                                                                        } else {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                        }

                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 3317) {
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = Client.field942;
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 3318) {
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = Client.world;
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 3321) {
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = Client.energy;
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 3322) {
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = Client.weight;
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 3323) {
                                                                                                                        if(Client.field1096) {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = 1;
                                                                                                                        } else {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                        }

                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 3324) {
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = Client.flags;
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 3325) {
                                                                                                                        class46.intStackSize -= 4;
                                                                                                                        var16 = class83.intStack[class46.intStackSize];
                                                                                                                        var31 = class83.intStack[class46.intStackSize + 1];
                                                                                                                        var18 = class83.intStack[class46.intStackSize + 2];
                                                                                                                        var28 = class83.intStack[class46.intStackSize + 3];
                                                                                                                        var16 += var31 << 14;
                                                                                                                        var16 += var18 << 28;
                                                                                                                        var16 += var28;
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = var16;
                                                                                                                        var15 = 1;
                                                                                                                     } else {
                                                                                                                        var15 = 2;
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class46.intStackSize -= 2;
                                                                                                                     var16 = class83.intStack[class46.intStackSize] + '耀';
                                                                                                                     var31 = class83.intStack[class46.intStackSize + 1];
                                                                                                                     var67 = class83.intStack;
                                                                                                                     var28 = ++class46.intStackSize - 1;
                                                                                                                     var21 = (XItemContainer)XItemContainer.itemContainers.get((long)var16);
                                                                                                                     if(var21 == null) {
                                                                                                                        var20 = 0;
                                                                                                                     } else if(var31 >= 0 && var31 < var21.stackSizes.length) {
                                                                                                                        var20 = var21.stackSizes[var31];
                                                                                                                     } else {
                                                                                                                        var20 = 0;
                                                                                                                     }

                                                                                                                     var67[var28] = var20;
                                                                                                                     var15 = 1;
                                                                                                                  }
                                                                                                               }

                                                                                                               var14 = var15;
                                                                                                            } else if(var43 < 3500) {
                                                                                                               var14 = class96.method1800(var43, var3, var47);
                                                                                                            } else if(var43 < 3700) {
                                                                                                               if(var43 == 3600) {
                                                                                                                  if(Client.field1193 == 0) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = -2;
                                                                                                                  } else if(Client.field1193 == 1) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.friendCount;
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var43 == 3601) {
                                                                                                                  var16 = class83.intStack[--class46.intStackSize];
                                                                                                                  if(Client.field1193 == 2 && var16 < Client.friendCount) {
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = Client.friends[var16].name;
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = Client.friends[var16].previousName;
                                                                                                                  } else {
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var43 == 3602) {
                                                                                                                  var16 = class83.intStack[--class46.intStackSize];
                                                                                                                  if(Client.field1193 == 2 && var16 < Client.friendCount) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.friends[var16].world;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var43 == 3603) {
                                                                                                                  var16 = class83.intStack[--class46.intStackSize];
                                                                                                                  if(Client.field1193 == 2 && var16 < Client.friendCount) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.friends[var16].rank;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var43 == 3604) {
                                                                                                                  var68 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                  var31 = class83.intStack[--class46.intStackSize];
                                                                                                                  Client.secretPacketBuffer1.putOpcode(136);
                                                                                                                  Client.secretPacketBuffer1.putByte(class261.getLength(var68) + 1);
                                                                                                                  Client.secretPacketBuffer1.putString(var68);
                                                                                                                  Client.secretPacketBuffer1.putByte(var31);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var43 == 3605) {
                                                                                                                  var68 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                  if(var68 != null) {
                                                                                                                     if((Client.friendCount < 200 || Client.field1049 == 1) && Client.friendCount < 400) {
                                                                                                                        var48 = Player.method1179(var68, Client.field928);
                                                                                                                        if(var48 != null) {
                                                                                                                           var18 = 0;

                                                                                                                           label2446:
                                                                                                                           while(true) {
                                                                                                                              if(var18 >= Client.friendCount) {
                                                                                                                                 for(var18 = 0; var18 < Client.ignoreCount; ++var18) {
                                                                                                                                    Ignore var52 = Client.ignores[var18];
                                                                                                                                    var32 = Player.method1179(var52.name, Client.field928);
                                                                                                                                    if(var32 != null && var32.equals(var48)) {
                                                                                                                                       class152.sendGameMessage(30, "", "Please remove " + var68 + " from your ignore list first");
                                                                                                                                       break label2446;
                                                                                                                                    }

                                                                                                                                    if(var52.previousName != null) {
                                                                                                                                       var56 = Player.method1179(var52.previousName, Client.field928);
                                                                                                                                       if(var56 != null && var56.equals(var48)) {
                                                                                                                                          class152.sendGameMessage(30, "", "Please remove " + var68 + " from your ignore list first");
                                                                                                                                          break label2446;
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 }

                                                                                                                                 if(Player.method1179(XItemContainer.localPlayer.name, Client.field928).equals(var48)) {
                                                                                                                                    class152.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
                                                                                                                                 } else {
                                                                                                                                    Client.secretPacketBuffer1.putOpcode(240);
                                                                                                                                    Client.secretPacketBuffer1.putByte(class261.getLength(var68));
                                                                                                                                    Client.secretPacketBuffer1.putString(var68);
                                                                                                                                 }
                                                                                                                                 break;
                                                                                                                              }

                                                                                                                              Friend var51 = Client.friends[var18];
                                                                                                                              var32 = Player.method1179(var51.name, Client.field928);
                                                                                                                              if(var32 != null && var32.equals(var48)) {
                                                                                                                                 class152.sendGameMessage(30, "", var68 + " is already on your friend list");
                                                                                                                                 break;
                                                                                                                              }

                                                                                                                              if(var51.previousName != null) {
                                                                                                                                 var56 = Player.method1179(var51.previousName, Client.field928);
                                                                                                                                 if(var56 != null && var56.equals(var48)) {
                                                                                                                                    class152.sendGameMessage(30, "", var68 + " is already on your friend list");
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

                                                                                                                  var15 = 1;
                                                                                                               } else if(var43 == 3606) {
                                                                                                                  var68 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                  DynamicObject.method1873(var68);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var43 == 3607) {
                                                                                                                  var68 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                  GameObject.method2891(var68, false);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var43 == 3608) {
                                                                                                                  var68 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                  KeyFocusListener.method789(var68);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var43 == 3609) {
                                                                                                                  var68 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                  Permission[] var50 = Widget.method4032();

                                                                                                                  for(var18 = 0; var18 < var50.length; ++var18) {
                                                                                                                     Permission var49 = var50[var18];
                                                                                                                     if(var49.field3186 != -1 && var68.startsWith(class41.method609(var49.field3186))) {
                                                                                                                        var68 = var68.substring(6 + Integer.toString(var49.field3186).length());
                                                                                                                        break;
                                                                                                                     }
                                                                                                                  }

                                                                                                                  class83.intStack[++class46.intStackSize - 1] = class25.isFriended(var68, false)?1:0;
                                                                                                                  var15 = 1;
                                                                                                               } else if(var43 == 3611) {
                                                                                                                  if(Client.clanChatOwner != null) {
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = CombatInfoListHolder.method1690(Client.clanChatOwner);
                                                                                                                  } else {
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var43 == 3612) {
                                                                                                                  if(Client.clanChatOwner != null) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = class28.clanChatCount;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var43 == 3613) {
                                                                                                                  var16 = class83.intStack[--class46.intStackSize];
                                                                                                                  if(Client.clanChatOwner != null && var16 < class28.clanChatCount) {
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = class11.clanMembers[var16].username;
                                                                                                                  } else {
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var43 == 3614) {
                                                                                                                  var16 = class83.intStack[--class46.intStackSize];
                                                                                                                  if(Client.clanChatOwner != null && var16 < class28.clanChatCount) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = class11.clanMembers[var16].world;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var43 == 3615) {
                                                                                                                  var16 = class83.intStack[--class46.intStackSize];
                                                                                                                  if(Client.clanChatOwner != null && var16 < class28.clanChatCount) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = class11.clanMembers[var16].rank;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var43 == 3616) {
                                                                                                                  class83.intStack[++class46.intStackSize - 1] = class12.field271;
                                                                                                                  var15 = 1;
                                                                                                               } else if(var43 == 3617) {
                                                                                                                  var68 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                  XGrandExchangeOffer.method111(var68);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var43 == 3618) {
                                                                                                                  class83.intStack[++class46.intStackSize - 1] = class35.clanChatRank;
                                                                                                                  var15 = 1;
                                                                                                               } else if(var43 == 3619) {
                                                                                                                  var68 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                  class96.method1797(var68);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var43 == 3620) {
                                                                                                                  Actor.method1548();
                                                                                                                  var15 = 1;
                                                                                                               } else if(var43 == 3621) {
                                                                                                                  if(Client.field1193 == 0) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.ignoreCount;
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var43 == 3622) {
                                                                                                                  var16 = class83.intStack[--class46.intStackSize];
                                                                                                                  if(Client.field1193 != 0 && var16 < Client.ignoreCount) {
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = Client.ignores[var16].name;
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = Client.ignores[var16].previousName;
                                                                                                                  } else {
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var43 == 3623) {
                                                                                                                  var68 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                  if(var68.startsWith(class41.method609(0)) || var68.startsWith(class41.method609(1))) {
                                                                                                                     var68 = var68.substring(7);
                                                                                                                  }

                                                                                                                  class83.intStack[++class46.intStackSize - 1] = class1.isIgnored(var68)?1:0;
                                                                                                                  var15 = 1;
                                                                                                               } else if(var43 != 3624) {
                                                                                                                  if(var43 == 3625) {
                                                                                                                     if(Client.clanChatName != null) {
                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = CombatInfoListHolder.method1690(Client.clanChatName);
                                                                                                                     } else {
                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var15 = 1;
                                                                                                                  } else {
                                                                                                                     var15 = 2;
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  var16 = class83.intStack[--class46.intStackSize];
                                                                                                                  if(class11.clanMembers != null && var16 < class28.clanChatCount && class11.clanMembers[var16].username.equalsIgnoreCase(XItemContainer.localPlayer.name)) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = 1;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               }

                                                                                                               var14 = var15;
                                                                                                            } else {
                                                                                                               int var33;
                                                                                                               boolean var79;
                                                                                                               if(var43 < 4000) {
                                                                                                                  if(var43 == 3903) {
                                                                                                                     var16 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.grandExchangeOffers[var16].method91();
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3904) {
                                                                                                                     var16 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.grandExchangeOffers[var16].itemId;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3905) {
                                                                                                                     var16 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.grandExchangeOffers[var16].price;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3906) {
                                                                                                                     var16 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.grandExchangeOffers[var16].totalQuantity;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3907) {
                                                                                                                     var16 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.grandExchangeOffers[var16].quantitySold;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3908) {
                                                                                                                     var16 = class83.intStack[--class46.intStackSize];
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.grandExchangeOffers[var16].spent;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3910) {
                                                                                                                     var16 = class83.intStack[--class46.intStackSize];
                                                                                                                     var31 = Client.grandExchangeOffers[var16].method87();
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = var31 == 0?1:0;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3911) {
                                                                                                                     var16 = class83.intStack[--class46.intStackSize];
                                                                                                                     var31 = Client.grandExchangeOffers[var16].method87();
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = var31 == 2?1:0;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3912) {
                                                                                                                     var16 = class83.intStack[--class46.intStackSize];
                                                                                                                     var31 = Client.grandExchangeOffers[var16].method87();
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = var31 == 5?1:0;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3913) {
                                                                                                                     var16 = class83.intStack[--class46.intStackSize];
                                                                                                                     var31 = Client.grandExchangeOffers[var16].method87();
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = var31 == 1?1:0;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3914) {
                                                                                                                     var79 = class83.intStack[--class46.intStackSize] == 1;
                                                                                                                     if(class66.field833 != null) {
                                                                                                                        class66.field833.method61(class13.field279, var79);
                                                                                                                     }

                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3915) {
                                                                                                                     var79 = class83.intStack[--class46.intStackSize] == 1;
                                                                                                                     if(class66.field833 != null) {
                                                                                                                        class66.field833.method61(class13.field278, var79);
                                                                                                                     }

                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3916) {
                                                                                                                     class46.intStackSize -= 2;
                                                                                                                     var79 = class83.intStack[class46.intStackSize] == 1;
                                                                                                                     var82 = class83.intStack[class46.intStackSize + 1] == 1;
                                                                                                                     if(class66.field833 != null) {
                                                                                                                        class66.field833.method61(new class95(var82), var79);
                                                                                                                     }

                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3917) {
                                                                                                                     var79 = class83.intStack[--class46.intStackSize] == 1;
                                                                                                                     if(class66.field833 != null) {
                                                                                                                        class66.field833.method61(class13.field277, var79);
                                                                                                                     }

                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3918) {
                                                                                                                     var79 = class83.intStack[--class46.intStackSize] == 1;
                                                                                                                     if(class66.field833 != null) {
                                                                                                                        class66.field833.method61(class13.field280, var79);
                                                                                                                     }

                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 3919) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = class66.field833 == null?0:class66.field833.field283.size();
                                                                                                                     var15 = 1;
                                                                                                                  } else {
                                                                                                                     class14 var53;
                                                                                                                     if(var43 == 3920) {
                                                                                                                        var16 = class83.intStack[--class46.intStackSize];
                                                                                                                        var53 = (class14)class66.field833.field283.get(var16);
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = var53.field291;
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 3921) {
                                                                                                                        var16 = class83.intStack[--class46.intStackSize];
                                                                                                                        var53 = (class14)class66.field833.field283.get(var16);
                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var53.method66();
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 3922) {
                                                                                                                        var16 = class83.intStack[--class46.intStackSize];
                                                                                                                        var53 = (class14)class66.field833.field283.get(var16);
                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var53.method78();
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 3923) {
                                                                                                                        var16 = class83.intStack[--class46.intStackSize];
                                                                                                                        var53 = (class14)class66.field833.field283.get(var16);
                                                                                                                        long var34 = DState.currentTimeMs() - class43.field599 - var53.field286;
                                                                                                                        var20 = (int)(var34 / 3600000L);
                                                                                                                        var33 = (int)((var34 - (long)(var20 * 3600000)) / 60000L);
                                                                                                                        int var22 = (int)((var34 - (long)(var20 * 3600000) - (long)(var33 * '\uea60')) / 1000L);
                                                                                                                        String var23 = var20 + ":" + var33 / 10 + var33 % 10 + ":" + var22 / 10 + var22 % 10;
                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var23;
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 3924) {
                                                                                                                        var16 = class83.intStack[--class46.intStackSize];
                                                                                                                        var53 = (class14)class66.field833.field283.get(var16);
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = var53.field285.totalQuantity;
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 3925) {
                                                                                                                        var16 = class83.intStack[--class46.intStackSize];
                                                                                                                        var53 = (class14)class66.field833.field283.get(var16);
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = var53.field285.price;
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 3926) {
                                                                                                                        var16 = class83.intStack[--class46.intStackSize];
                                                                                                                        var53 = (class14)class66.field833.field283.get(var16);
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = var53.field285.itemId;
                                                                                                                        var15 = 1;
                                                                                                                     } else {
                                                                                                                        var15 = 2;
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var14 = var15;
                                                                                                               } else if(var43 < 4100) {
                                                                                                                  var14 = GameObject.method2890(var43, var3, var47);
                                                                                                               } else if(var43 < 4200) {
                                                                                                                  var14 = class261.method4735(var43, var3, var47);
                                                                                                               } else if(var43 < 4300) {
                                                                                                                  var14 = class24.method163(var43, var3, var47);
                                                                                                               } else if(var43 < 5100) {
                                                                                                                  if(var43 == 5000) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.field1143;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 5001) {
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
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 5002) {
                                                                                                                     var68 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                     class46.intStackSize -= 2;
                                                                                                                     var31 = class83.intStack[class46.intStackSize];
                                                                                                                     var18 = class83.intStack[class46.intStackSize + 1];
                                                                                                                     Client.secretPacketBuffer1.putOpcode(153);
                                                                                                                     Client.secretPacketBuffer1.putByte(class261.getLength(var68) + 2);
                                                                                                                     Client.secretPacketBuffer1.putString(var68);
                                                                                                                     Client.secretPacketBuffer1.putByte(var31 - 1);
                                                                                                                     Client.secretPacketBuffer1.putByte(var18);
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 5003) {
                                                                                                                     class46.intStackSize -= 2;
                                                                                                                     var16 = class83.intStack[class46.intStackSize];
                                                                                                                     var31 = class83.intStack[class46.intStackSize + 1];
                                                                                                                     MessageNode var71 = KeyFocusListener.method790(var16, var31);
                                                                                                                     if(var71 != null) {
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = var71.id;
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = var71.tick;
                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var71.name != null?var71.name:"";
                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var71.sender != null?var71.sender:"";
                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var71.value != null?var71.value:"";
                                                                                                                     } else {
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 5004) {
                                                                                                                     var16 = class83.intStack[--class46.intStackSize];
                                                                                                                     MessageNode var59 = (MessageNode)class98.field1546.method3478((long)var16);
                                                                                                                     if(var59 != null) {
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = var59.type;
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = var59.tick;
                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var59.name != null?var59.name:"";
                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var59.sender != null?var59.sender:"";
                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var59.value != null?var59.value:"";
                                                                                                                     } else {
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 5005) {
                                                                                                                     if(class61.field787 == null) {
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                     } else {
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = class61.field787.field3738;
                                                                                                                     }

                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 5008) {
                                                                                                                     var68 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                     var31 = class83.intStack[--class46.intStackSize];
                                                                                                                     var65 = var68.toLowerCase();
                                                                                                                     byte var73 = 0;
                                                                                                                     if(var65.startsWith("yellow:")) {
                                                                                                                        var73 = 0;
                                                                                                                        var68 = var68.substring("yellow:".length());
                                                                                                                     } else if(var65.startsWith("red:")) {
                                                                                                                        var73 = 1;
                                                                                                                        var68 = var68.substring("red:".length());
                                                                                                                     } else if(var65.startsWith("green:")) {
                                                                                                                        var73 = 2;
                                                                                                                        var68 = var68.substring("green:".length());
                                                                                                                     } else if(var65.startsWith("cyan:")) {
                                                                                                                        var73 = 3;
                                                                                                                        var68 = var68.substring("cyan:".length());
                                                                                                                     } else if(var65.startsWith("purple:")) {
                                                                                                                        var73 = 4;
                                                                                                                        var68 = var68.substring("purple:".length());
                                                                                                                     } else if(var65.startsWith("white:")) {
                                                                                                                        var73 = 5;
                                                                                                                        var68 = var68.substring("white:".length());
                                                                                                                     } else if(var65.startsWith("flash1:")) {
                                                                                                                        var73 = 6;
                                                                                                                        var68 = var68.substring("flash1:".length());
                                                                                                                     } else if(var65.startsWith("flash2:")) {
                                                                                                                        var73 = 7;
                                                                                                                        var68 = var68.substring("flash2:".length());
                                                                                                                     } else if(var65.startsWith("flash3:")) {
                                                                                                                        var73 = 8;
                                                                                                                        var68 = var68.substring("flash3:".length());
                                                                                                                     } else if(var65.startsWith("glow1:")) {
                                                                                                                        var73 = 9;
                                                                                                                        var68 = var68.substring("glow1:".length());
                                                                                                                     } else if(var65.startsWith("glow2:")) {
                                                                                                                        var73 = 10;
                                                                                                                        var68 = var68.substring("glow2:".length());
                                                                                                                     } else if(var65.startsWith("glow3:")) {
                                                                                                                        var73 = 11;
                                                                                                                        var68 = var68.substring("glow3:".length());
                                                                                                                     } else if(Client.languageId != 0) {
                                                                                                                        if(var65.startsWith("yellow:")) {
                                                                                                                           var73 = 0;
                                                                                                                           var68 = var68.substring("yellow:".length());
                                                                                                                        } else if(var65.startsWith("red:")) {
                                                                                                                           var73 = 1;
                                                                                                                           var68 = var68.substring("red:".length());
                                                                                                                        } else if(var65.startsWith("green:")) {
                                                                                                                           var73 = 2;
                                                                                                                           var68 = var68.substring("green:".length());
                                                                                                                        } else if(var65.startsWith("cyan:")) {
                                                                                                                           var73 = 3;
                                                                                                                           var68 = var68.substring("cyan:".length());
                                                                                                                        } else if(var65.startsWith("purple:")) {
                                                                                                                           var73 = 4;
                                                                                                                           var68 = var68.substring("purple:".length());
                                                                                                                        } else if(var65.startsWith("white:")) {
                                                                                                                           var73 = 5;
                                                                                                                           var68 = var68.substring("white:".length());
                                                                                                                        } else if(var65.startsWith("flash1:")) {
                                                                                                                           var73 = 6;
                                                                                                                           var68 = var68.substring("flash1:".length());
                                                                                                                        } else if(var65.startsWith("flash2:")) {
                                                                                                                           var73 = 7;
                                                                                                                           var68 = var68.substring("flash2:".length());
                                                                                                                        } else if(var65.startsWith("flash3:")) {
                                                                                                                           var73 = 8;
                                                                                                                           var68 = var68.substring("flash3:".length());
                                                                                                                        } else if(var65.startsWith("glow1:")) {
                                                                                                                           var73 = 9;
                                                                                                                           var68 = var68.substring("glow1:".length());
                                                                                                                        } else if(var65.startsWith("glow2:")) {
                                                                                                                           var73 = 10;
                                                                                                                           var68 = var68.substring("glow2:".length());
                                                                                                                        } else if(var65.startsWith("glow3:")) {
                                                                                                                           var73 = 11;
                                                                                                                           var68 = var68.substring("glow3:".length());
                                                                                                                        }
                                                                                                                     }

                                                                                                                     var65 = var68.toLowerCase();
                                                                                                                     byte var62 = 0;
                                                                                                                     if(var65.startsWith("wave:")) {
                                                                                                                        var62 = 1;
                                                                                                                        var68 = var68.substring("wave:".length());
                                                                                                                     } else if(var65.startsWith("wave2:")) {
                                                                                                                        var62 = 2;
                                                                                                                        var68 = var68.substring("wave2:".length());
                                                                                                                     } else if(var65.startsWith("shake:")) {
                                                                                                                        var62 = 3;
                                                                                                                        var68 = var68.substring("shake:".length());
                                                                                                                     } else if(var65.startsWith("scroll:")) {
                                                                                                                        var62 = 4;
                                                                                                                        var68 = var68.substring("scroll:".length());
                                                                                                                     } else if(var65.startsWith("slide:")) {
                                                                                                                        var62 = 5;
                                                                                                                        var68 = var68.substring("slide:".length());
                                                                                                                     } else if(Client.languageId != 0) {
                                                                                                                        if(var65.startsWith("wave:")) {
                                                                                                                           var62 = 1;
                                                                                                                           var68 = var68.substring("wave:".length());
                                                                                                                        } else if(var65.startsWith("wave2:")) {
                                                                                                                           var62 = 2;
                                                                                                                           var68 = var68.substring("wave2:".length());
                                                                                                                        } else if(var65.startsWith("shake:")) {
                                                                                                                           var62 = 3;
                                                                                                                           var68 = var68.substring("shake:".length());
                                                                                                                        } else if(var65.startsWith("scroll:")) {
                                                                                                                           var62 = 4;
                                                                                                                           var68 = var68.substring("scroll:".length());
                                                                                                                        } else if(var65.startsWith("slide:")) {
                                                                                                                           var62 = 5;
                                                                                                                           var68 = var68.substring("slide:".length());
                                                                                                                        }
                                                                                                                     }

                                                                                                                     Client.secretPacketBuffer1.putOpcode(213);
                                                                                                                     Client.secretPacketBuffer1.putByte(0);
                                                                                                                     var33 = Client.secretPacketBuffer1.offset;
                                                                                                                     Client.secretPacketBuffer1.putByte(var31);
                                                                                                                     Client.secretPacketBuffer1.putByte(var73);
                                                                                                                     Client.secretPacketBuffer1.putByte(var62);
                                                                                                                     MessageNode.method1142(Client.secretPacketBuffer1, var68);
                                                                                                                     Client.secretPacketBuffer1.putLength(Client.secretPacketBuffer1.offset - var33);
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 5009) {
                                                                                                                     KeyFocusListener.scriptStringStackSize -= 2;
                                                                                                                     var68 = class83.scriptStringStack[KeyFocusListener.scriptStringStackSize];
                                                                                                                     var48 = class83.scriptStringStack[KeyFocusListener.scriptStringStackSize + 1];
                                                                                                                     Client.secretPacketBuffer1.putOpcode(239);
                                                                                                                     Client.secretPacketBuffer1.putShort(0);
                                                                                                                     var18 = Client.secretPacketBuffer1.offset;
                                                                                                                     Client.secretPacketBuffer1.putString(var68);
                                                                                                                     MessageNode.method1142(Client.secretPacketBuffer1, var48);
                                                                                                                     Client.secretPacketBuffer1.putShortLength(Client.secretPacketBuffer1.offset - var18);
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 != 5015) {
                                                                                                                     if(var43 == 5016) {
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = Client.field1032;
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 5017) {
                                                                                                                        var16 = class83.intStack[--class46.intStackSize];
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = KitDefinition.method4399(var16);
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 5018) {
                                                                                                                        var16 = class83.intStack[--class46.intStackSize];
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = GZipDecompressor.method3076(var16);
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 5019) {
                                                                                                                        var16 = class83.intStack[--class46.intStackSize];
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = class269.method4863(var16);
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 5020) {
                                                                                                                        var68 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                        if(var68.equalsIgnoreCase("toggleroof")) {
                                                                                                                           class8.settings.hideRoofs = !class8.settings.hideRoofs;
                                                                                                                           class1.method3();
                                                                                                                           if(class8.settings.hideRoofs) {
                                                                                                                              class152.sendGameMessage(99, "", "Roofs are now all hidden");
                                                                                                                           } else {
                                                                                                                              class152.sendGameMessage(99, "", "Roofs will only be removed selectively");
                                                                                                                           }
                                                                                                                        }

                                                                                                                        if(var68.equalsIgnoreCase("displayfps")) {
                                                                                                                           Client.displayFps = !Client.displayFps;
                                                                                                                        }

                                                                                                                        if(var68.equalsIgnoreCase("clickbox")) {
                                                                                                                           Model.field1992 = !Model.field1992;
                                                                                                                           class152.sendGameMessage(99, "", "Clickbox Mode: " + (Model.field1992?"AABB":"Legacy"));
                                                                                                                        }

                                                                                                                        if(Client.rights >= 2) {
                                                                                                                           if(var68.equalsIgnoreCase("aabb")) {
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

                                                                                                                           if(var68.equalsIgnoreCase("legacyboxes")) {
                                                                                                                              class7.field238 = !class7.field238;
                                                                                                                              class152.sendGameMessage(99, "", "Show legacy boxes: " + class7.field238);
                                                                                                                           }

                                                                                                                           if(var68.equalsIgnoreCase("geotests")) {
                                                                                                                              class7.field232 = !class7.field232;
                                                                                                                              class152.sendGameMessage(99, "", "Show geometry tests: " + class7.field232);
                                                                                                                           }

                                                                                                                           if(var68.equalsIgnoreCase("fpson")) {
                                                                                                                              Client.displayFps = true;
                                                                                                                           }

                                                                                                                           if(var68.equalsIgnoreCase("fpsoff")) {
                                                                                                                              Client.displayFps = false;
                                                                                                                           }

                                                                                                                           if(var68.equalsIgnoreCase("gc")) {
                                                                                                                              System.gc();
                                                                                                                           }

                                                                                                                           if(var68.equalsIgnoreCase("clientdrop")) {
                                                                                                                              class13.method60();
                                                                                                                           }

                                                                                                                           if(var68.equalsIgnoreCase("errortest") && Client.socketType == 2) {
                                                                                                                              throw new RuntimeException();
                                                                                                                           }
                                                                                                                        }

                                                                                                                        Client.secretPacketBuffer1.putOpcode(232);
                                                                                                                        Client.secretPacketBuffer1.putByte(var68.length() + 1);
                                                                                                                        Client.secretPacketBuffer1.putString(var68);
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 5021) {
                                                                                                                        Client.field1145 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize].toLowerCase().trim();
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 5022) {
                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = Client.field1145;
                                                                                                                        var15 = 1;
                                                                                                                     } else {
                                                                                                                        var15 = 2;
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     if(XItemContainer.localPlayer != null && XItemContainer.localPlayer.name != null) {
                                                                                                                        var68 = XItemContainer.localPlayer.name;
                                                                                                                     } else {
                                                                                                                        var68 = "";
                                                                                                                     }

                                                                                                                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var68;
                                                                                                                     var15 = 1;
                                                                                                                  }

                                                                                                                  var14 = var15;
                                                                                                               } else if(var43 < 5400) {
                                                                                                                  var14 = class37.method510(var43, var3, var47);
                                                                                                               } else if(var43 < 5600) {
                                                                                                                  if(var43 == 5504) {
                                                                                                                     class46.intStackSize -= 2;
                                                                                                                     var28 = class83.intStack[class46.intStackSize];
                                                                                                                     var20 = class83.intStack[class46.intStackSize + 1];
                                                                                                                     if(!Client.field1173) {
                                                                                                                        Client.field1052 = var28;
                                                                                                                        Client.mapAngle = var20;
                                                                                                                     }

                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 5505) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.field1052;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 5506) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.mapAngle;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 5530) {
                                                                                                                     var28 = class83.intStack[--class46.intStackSize];
                                                                                                                     if(var28 < 0) {
                                                                                                                        var28 = 0;
                                                                                                                     }

                                                                                                                     Client.field1015 = var28;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 5531) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.field1015;
                                                                                                                     var15 = 1;
                                                                                                                  } else {
                                                                                                                     var15 = 2;
                                                                                                                  }

                                                                                                                  var14 = var15;
                                                                                                               } else if(var43 < 5700) {
                                                                                                                  if(var43 == 5630) {
                                                                                                                     Client.field978 = 250;
                                                                                                                     var15 = 1;
                                                                                                                  } else {
                                                                                                                     var15 = 2;
                                                                                                                  }

                                                                                                                  var14 = var15;
                                                                                                               } else if(var43 < 6300) {
                                                                                                                  if(var43 == 6200) {
                                                                                                                     class46.intStackSize -= 2;
                                                                                                                     Client.field1179 = (short)class83.intStack[class46.intStackSize];
                                                                                                                     if(Client.field1179 <= 0) {
                                                                                                                        Client.field1179 = 256;
                                                                                                                     }

                                                                                                                     Client.field1180 = (short)class83.intStack[class46.intStackSize + 1];
                                                                                                                     if(Client.field1180 <= 0) {
                                                                                                                        Client.field1180 = 205;
                                                                                                                     }

                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 6201) {
                                                                                                                     class46.intStackSize -= 2;
                                                                                                                     Client.field1126 = (short)class83.intStack[class46.intStackSize];
                                                                                                                     if(Client.field1126 <= 0) {
                                                                                                                        Client.field1126 = 256;
                                                                                                                     }

                                                                                                                     Client.field1182 = (short)class83.intStack[class46.intStackSize + 1];
                                                                                                                     if(Client.field1182 <= 0) {
                                                                                                                        Client.field1182 = 320;
                                                                                                                     }

                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 6202) {
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

                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 6203) {
                                                                                                                     if(Client.field1099 != null) {
                                                                                                                        Item.method1773(0, 0, Client.field1099.width, Client.field1099.height, false);
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = Client.viewportHeight;
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = Client.viewportWidth;
                                                                                                                     } else {
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                     }

                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 6204) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.field1126;
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.field1182;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var43 == 6205) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.field1179;
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = Client.field1180;
                                                                                                                     var15 = 1;
                                                                                                                  } else {
                                                                                                                     var15 = 2;
                                                                                                                  }

                                                                                                                  var14 = var15;
                                                                                                               } else if(var43 < 6600) {
                                                                                                                  if(var43 == 6500) {
                                                                                                                     class83.intStack[++class46.intStackSize - 1] = class1.loadWorlds()?1:0;
                                                                                                                     var15 = 1;
                                                                                                                  } else {
                                                                                                                     World var85;
                                                                                                                     if(var43 == 6501) {
                                                                                                                        var85 = Preferences.method1615();
                                                                                                                        if(var85 != null) {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = var85.id;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = var85.mask;
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var85.activity;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = var85.location;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = var85.playerCount;
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var85.address;
                                                                                                                        } else {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 6502) {
                                                                                                                        var85 = Actor.method1556();
                                                                                                                        if(var85 != null) {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = var85.id;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = var85.mask;
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var85.activity;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = var85.location;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = var85.playerCount;
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var85.address;
                                                                                                                        } else {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var15 = 1;
                                                                                                                     } else {
                                                                                                                        World var60;
                                                                                                                        if(var43 == 6506) {
                                                                                                                           var16 = class83.intStack[--class46.intStackSize];
                                                                                                                           var60 = null;

                                                                                                                           for(var18 = 0; var18 < World.worldCount; ++var18) {
                                                                                                                              if(var16 == World.worldList[var18].id) {
                                                                                                                                 var60 = World.worldList[var18];
                                                                                                                                 break;
                                                                                                                              }
                                                                                                                           }

                                                                                                                           if(var60 != null) {
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = var60.id;
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = var60.mask;
                                                                                                                              class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var60.activity;
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = var60.location;
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = var60.playerCount;
                                                                                                                              class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var60.address;
                                                                                                                           } else {
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                              class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                              class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                           }

                                                                                                                           var15 = 1;
                                                                                                                        } else if(var43 == 6507) {
                                                                                                                           class46.intStackSize -= 4;
                                                                                                                           var16 = class83.intStack[class46.intStackSize];
                                                                                                                           var82 = class83.intStack[1 + class46.intStackSize] == 1;
                                                                                                                           var18 = class83.intStack[class46.intStackSize + 2];
                                                                                                                           boolean var84 = class83.intStack[class46.intStackSize + 3] == 1;
                                                                                                                           if(World.worldList != null) {
                                                                                                                              XGrandExchangeOffer.method112(0, World.worldList.length - 1, var16, var82, var18, var84);
                                                                                                                           }

                                                                                                                           var15 = 1;
                                                                                                                        } else if(var43 != 6511) {
                                                                                                                           if(var43 == 6512) {
                                                                                                                              Client.field1073 = class83.intStack[--class46.intStackSize] == 1;
                                                                                                                              var15 = 1;
                                                                                                                           } else {
                                                                                                                              class251 var72;
                                                                                                                              if(var43 == 6513) {
                                                                                                                                 class46.intStackSize -= 2;
                                                                                                                                 var16 = class83.intStack[class46.intStackSize];
                                                                                                                                 var31 = class83.intStack[class46.intStackSize + 1];
                                                                                                                                 var72 = FaceNormal.method2869(var31);
                                                                                                                                 if(var72.method4440()) {
                                                                                                                                    class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = class35.getNpcDefinition(var16).method4649(var31, var72.field3401);
                                                                                                                                 } else {
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = class35.getNpcDefinition(var16).method4648(var31, var72.field3398);
                                                                                                                                 }

                                                                                                                                 var15 = 1;
                                                                                                                              } else if(var43 == 6514) {
                                                                                                                                 class46.intStackSize -= 2;
                                                                                                                                 var16 = class83.intStack[class46.intStackSize];
                                                                                                                                 var31 = class83.intStack[class46.intStackSize + 1];
                                                                                                                                 var72 = FaceNormal.method2869(var31);
                                                                                                                                 if(var72.method4440()) {
                                                                                                                                    class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = class251.getObjectDefinition(var16).method4525(var31, var72.field3401);
                                                                                                                                 } else {
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = class251.getObjectDefinition(var16).method4548(var31, var72.field3398);
                                                                                                                                 }

                                                                                                                                 var15 = 1;
                                                                                                                              } else if(var43 == 6515) {
                                                                                                                                 class46.intStackSize -= 2;
                                                                                                                                 var16 = class83.intStack[class46.intStackSize];
                                                                                                                                 var31 = class83.intStack[class46.intStackSize + 1];
                                                                                                                                 var72 = FaceNormal.method2869(var31);
                                                                                                                                 if(var72.method4440()) {
                                                                                                                                    class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = AbstractByteBuffer.getItemDefinition(var16).method4589(var31, var72.field3401);
                                                                                                                                 } else {
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = AbstractByteBuffer.getItemDefinition(var16).method4586(var31, var72.field3398);
                                                                                                                                 }

                                                                                                                                 var15 = 1;
                                                                                                                              } else if(var43 == 6516) {
                                                                                                                                 class46.intStackSize -= 2;
                                                                                                                                 var16 = class83.intStack[class46.intStackSize];
                                                                                                                                 var31 = class83.intStack[class46.intStackSize + 1];
                                                                                                                                 var72 = FaceNormal.method2869(var31);
                                                                                                                                 if(var72.method4440()) {
                                                                                                                                    String[] var54 = class83.scriptStringStack;
                                                                                                                                    var20 = ++KeyFocusListener.scriptStringStackSize - 1;
                                                                                                                                    class252 var36 = (class252)class252.field3402.get((long)var16);
                                                                                                                                    class252 var57;
                                                                                                                                    if(var36 != null) {
                                                                                                                                       var57 = var36;
                                                                                                                                    } else {
                                                                                                                                       byte[] var58 = class252.field3406.getConfigData(34, var16);
                                                                                                                                       var36 = new class252();
                                                                                                                                       if(var58 != null) {
                                                                                                                                          var36.method4459(new Buffer(var58));
                                                                                                                                       }

                                                                                                                                       var36.method4458();
                                                                                                                                       class252.field3402.put(var36, (long)var16);
                                                                                                                                       var57 = var36;
                                                                                                                                    }

                                                                                                                                    var54[var20] = var57.method4462(var31, var72.field3401);
                                                                                                                                 } else {
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = class17.method115(var16).method4457(var31, var72.field3398);
                                                                                                                                 }

                                                                                                                                 var15 = 1;
                                                                                                                              } else {
                                                                                                                                 var15 = 2;
                                                                                                                              }
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           var16 = class83.intStack[--class46.intStackSize];
                                                                                                                           if(var16 >= 0 && var16 < World.worldCount) {
                                                                                                                              var60 = World.worldList[var16];
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = var60.id;
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = var60.mask;
                                                                                                                              class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var60.activity;
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = var60.location;
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = var60.playerCount;
                                                                                                                              class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var60.address;
                                                                                                                           } else {
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                              class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                              class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                           }

                                                                                                                           var15 = 1;
                                                                                                                        }
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var14 = var15;
                                                                                                               } else if(var43 < 6700) {
                                                                                                                  if(var43 == 6600) {
                                                                                                                     var16 = WallObject.plane;
                                                                                                                     var31 = (XItemContainer.localPlayer.x >> 7) + KeyFocusListener.baseX;
                                                                                                                     var18 = (XItemContainer.localPlayer.y >> 7) + class266.baseY;
                                                                                                                     class44.method651().method5187(var16, var31, var18, true);
                                                                                                                     var15 = 1;
                                                                                                                  } else {
                                                                                                                     WorldMapData var75;
                                                                                                                     if(var43 == 6601) {
                                                                                                                        var16 = class83.intStack[--class46.intStackSize];
                                                                                                                        var48 = "";
                                                                                                                        var75 = class44.method651().method5179(var16);
                                                                                                                        if(var75 != null) {
                                                                                                                           var48 = var75.method283();
                                                                                                                        }

                                                                                                                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var48;
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 6602) {
                                                                                                                        var16 = class83.intStack[--class46.intStackSize];
                                                                                                                        class44.method651().method5188(var16);
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 6603) {
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = class44.method651().method5325();
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 6604) {
                                                                                                                        var16 = class83.intStack[--class46.intStackSize];
                                                                                                                        class44.method651().method5250(var16);
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var43 == 6605) {
                                                                                                                        class83.intStack[++class46.intStackSize - 1] = class44.method651().method5202()?1:0;
                                                                                                                        var15 = 1;
                                                                                                                     } else {
                                                                                                                        Coordinates var87;
                                                                                                                        if(var43 == 6606) {
                                                                                                                           var87 = new Coordinates(class83.intStack[--class46.intStackSize]);
                                                                                                                           class44.method651().method5204(var87.worldX, var87.worldY);
                                                                                                                           var15 = 1;
                                                                                                                        } else if(var43 == 6607) {
                                                                                                                           var87 = new Coordinates(class83.intStack[--class46.intStackSize]);
                                                                                                                           class44.method651().method5205(var87.worldX, var87.worldY);
                                                                                                                           var15 = 1;
                                                                                                                        } else if(var43 == 6608) {
                                                                                                                           var87 = new Coordinates(class83.intStack[--class46.intStackSize]);
                                                                                                                           class44.method651().method5206(var87.plane, var87.worldX, var87.worldY);
                                                                                                                           var15 = 1;
                                                                                                                        } else if(var43 == 6609) {
                                                                                                                           var87 = new Coordinates(class83.intStack[--class46.intStackSize]);
                                                                                                                           class44.method651().method5212(var87.plane, var87.worldX, var87.worldY);
                                                                                                                           var15 = 1;
                                                                                                                        } else if(var43 == 6610) {
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = class44.method651().method5299();
                                                                                                                           class83.intStack[++class46.intStackSize - 1] = class44.method651().method5209();
                                                                                                                           var15 = 1;
                                                                                                                        } else {
                                                                                                                           WorldMapData var63;
                                                                                                                           if(var43 == 6611) {
                                                                                                                              var16 = class83.intStack[--class46.intStackSize];
                                                                                                                              var63 = class44.method651().method5179(var16);
                                                                                                                              if(var63 == null) {
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                              } else {
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = var63.method334().method3913();
                                                                                                                              }

                                                                                                                              var15 = 1;
                                                                                                                           } else if(var43 == 6612) {
                                                                                                                              var16 = class83.intStack[--class46.intStackSize];
                                                                                                                              var63 = class44.method651().method5179(var16);
                                                                                                                              if(var63 == null) {
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                              } else {
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = (var63.method287() - var63.method305() + 1) * 64;
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = (var63.method289() - var63.method288() + 1) * 64;
                                                                                                                              }

                                                                                                                              var15 = 1;
                                                                                                                           } else if(var43 == 6613) {
                                                                                                                              var16 = class83.intStack[--class46.intStackSize];
                                                                                                                              var63 = class44.method651().method5179(var16);
                                                                                                                              if(var63 == null) {
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                              } else {
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = var63.method305() * 64;
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = var63.method288() * 64;
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = var63.method287() * 64 + 64 - 1;
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = var63.method289() * 64 + 64 - 1;
                                                                                                                              }

                                                                                                                              var15 = 1;
                                                                                                                           } else if(var43 == 6614) {
                                                                                                                              var16 = class83.intStack[--class46.intStackSize];
                                                                                                                              var63 = class44.method651().method5179(var16);
                                                                                                                              if(var63 == null) {
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                              } else {
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = var63.method285();
                                                                                                                              }

                                                                                                                              var15 = 1;
                                                                                                                           } else if(var43 == 6615) {
                                                                                                                              var87 = class44.method651().method5210();
                                                                                                                              if(var87 == null) {
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                              } else {
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = var87.worldX;
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = var87.worldY;
                                                                                                                              }

                                                                                                                              var15 = 1;
                                                                                                                           } else if(var43 == 6616) {
                                                                                                                              class83.intStack[++class46.intStackSize - 1] = class44.method651().method5189();
                                                                                                                              var15 = 1;
                                                                                                                           } else if(var43 == 6617) {
                                                                                                                              var87 = new Coordinates(class83.intStack[--class46.intStackSize]);
                                                                                                                              var63 = class44.method651().method5260();
                                                                                                                              if(var63 == null) {
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                 class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                 var15 = 1;
                                                                                                                              } else {
                                                                                                                                 var67 = var63.method317(var87.plane, var87.worldX, var87.worldY);
                                                                                                                                 if(var67 == null) {
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                 } else {
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = var67[0];
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = var67[1];
                                                                                                                                 }

                                                                                                                                 var15 = 1;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              Coordinates var78;
                                                                                                                              if(var43 == 6618) {
                                                                                                                                 var87 = new Coordinates(class83.intStack[--class46.intStackSize]);
                                                                                                                                 var63 = class44.method651().method5260();
                                                                                                                                 if(var63 == null) {
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                    var15 = 1;
                                                                                                                                 } else {
                                                                                                                                    var78 = var63.method278(var87.worldX, var87.worldY);
                                                                                                                                    if(var78 == null) {
                                                                                                                                       class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                    } else {
                                                                                                                                       class83.intStack[++class46.intStackSize - 1] = var78.method3913();
                                                                                                                                    }

                                                                                                                                    var15 = 1;
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 Coordinates var69;
                                                                                                                                 Coordinates var83;
                                                                                                                                 if(var43 == 6619) {
                                                                                                                                    class46.intStackSize -= 2;
                                                                                                                                    var16 = class83.intStack[class46.intStackSize];
                                                                                                                                    var69 = new Coordinates(class83.intStack[class46.intStackSize + 1]);
                                                                                                                                    var75 = class44.method651().method5179(var16);
                                                                                                                                    var28 = XItemContainer.localPlayer.field911;
                                                                                                                                    var20 = (XItemContainer.localPlayer.x >> 7) + KeyFocusListener.baseX;
                                                                                                                                    var33 = (XItemContainer.localPlayer.y >> 7) + class266.baseY;
                                                                                                                                    var83 = new Coordinates(var28, var20, var33);
                                                                                                                                    class44.method651().method5193(var75, var83, var69, false);
                                                                                                                                    var15 = 1;
                                                                                                                                 } else if(var43 == 6620) {
                                                                                                                                    class46.intStackSize -= 2;
                                                                                                                                    var16 = class83.intStack[class46.intStackSize];
                                                                                                                                    var69 = new Coordinates(class83.intStack[class46.intStackSize + 1]);
                                                                                                                                    var75 = class44.method651().method5179(var16);
                                                                                                                                    var28 = XItemContainer.localPlayer.field911;
                                                                                                                                    var20 = (XItemContainer.localPlayer.x >> 7) + KeyFocusListener.baseX;
                                                                                                                                    var33 = (XItemContainer.localPlayer.y >> 7) + class266.baseY;
                                                                                                                                    var83 = new Coordinates(var28, var20, var33);
                                                                                                                                    class44.method651().method5193(var75, var83, var69, true);
                                                                                                                                    var15 = 1;
                                                                                                                                 } else if(var43 == 6621) {
                                                                                                                                    class46.intStackSize -= 2;
                                                                                                                                    var16 = class83.intStack[class46.intStackSize];
                                                                                                                                    var69 = new Coordinates(class83.intStack[class46.intStackSize + 1]);
                                                                                                                                    var75 = class44.method651().method5179(var16);
                                                                                                                                    if(var75 == null) {
                                                                                                                                       class83.intStack[++class46.intStackSize - 1] = 0;
                                                                                                                                       var15 = 1;
                                                                                                                                    } else {
                                                                                                                                       class83.intStack[++class46.intStackSize - 1] = var75.method275(var69.plane, var69.worldX, var69.worldY)?1:0;
                                                                                                                                       var15 = 1;
                                                                                                                                    }
                                                                                                                                 } else if(var43 == 6622) {
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = class44.method651().method5284();
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = class44.method651().method5333();
                                                                                                                                    var15 = 1;
                                                                                                                                 } else if(var43 == 6623) {
                                                                                                                                    var87 = new Coordinates(class83.intStack[--class46.intStackSize]);
                                                                                                                                    var63 = class44.method651().method5214(var87.plane, var87.worldX, var87.worldY);
                                                                                                                                    if(var63 == null) {
                                                                                                                                       class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                    } else {
                                                                                                                                       class83.intStack[++class46.intStackSize - 1] = var63.method280();
                                                                                                                                    }

                                                                                                                                    var15 = 1;
                                                                                                                                 } else if(var43 == 6624) {
                                                                                                                                    class44.method651().method5254(class83.intStack[--class46.intStackSize]);
                                                                                                                                    var15 = 1;
                                                                                                                                 } else if(var43 == 6625) {
                                                                                                                                    class44.method651().method5181();
                                                                                                                                    var15 = 1;
                                                                                                                                 } else if(var43 == 6626) {
                                                                                                                                    class44.method651().method5319(class83.intStack[--class46.intStackSize]);
                                                                                                                                    var15 = 1;
                                                                                                                                 } else if(var43 == 6627) {
                                                                                                                                    class44.method651().method5283();
                                                                                                                                    var15 = 1;
                                                                                                                                 } else if(var43 == 6628) {
                                                                                                                                    var79 = class83.intStack[--class46.intStackSize] == 1;
                                                                                                                                    class44.method651().method5217(var79);
                                                                                                                                    var15 = 1;
                                                                                                                                 } else if(var43 == 6629) {
                                                                                                                                    var16 = class83.intStack[--class46.intStackSize];
                                                                                                                                    class44.method651().method5339(var16);
                                                                                                                                    var15 = 1;
                                                                                                                                 } else if(var43 == 6630) {
                                                                                                                                    var16 = class83.intStack[--class46.intStackSize];
                                                                                                                                    class44.method651().method5219(var16);
                                                                                                                                    var15 = 1;
                                                                                                                                 } else if(var43 == 6631) {
                                                                                                                                    class44.method651().method5220();
                                                                                                                                    var15 = 1;
                                                                                                                                 } else if(var43 == 6632) {
                                                                                                                                    var79 = class83.intStack[--class46.intStackSize] == 1;
                                                                                                                                    class44.method651().method5365(var79);
                                                                                                                                    var15 = 1;
                                                                                                                                 } else if(var43 == 6633) {
                                                                                                                                    class46.intStackSize -= 2;
                                                                                                                                    var16 = class83.intStack[class46.intStackSize];
                                                                                                                                    var82 = class83.intStack[class46.intStackSize + 1] == 1;
                                                                                                                                    class44.method651().method5222(var16, var82);
                                                                                                                                    var15 = 1;
                                                                                                                                 } else if(var43 == 6634) {
                                                                                                                                    class46.intStackSize -= 2;
                                                                                                                                    var16 = class83.intStack[class46.intStackSize];
                                                                                                                                    var82 = class83.intStack[class46.intStackSize + 1] == 1;
                                                                                                                                    class44.method651().method5223(var16, var82);
                                                                                                                                    var15 = 1;
                                                                                                                                 } else if(var43 == 6635) {
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = class44.method651().method5224()?1:0;
                                                                                                                                    var15 = 1;
                                                                                                                                 } else if(var43 == 6636) {
                                                                                                                                    var16 = class83.intStack[--class46.intStackSize];
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = class44.method651().method5225(var16)?1:0;
                                                                                                                                    var15 = 1;
                                                                                                                                 } else if(var43 == 6637) {
                                                                                                                                    var16 = class83.intStack[--class46.intStackSize];
                                                                                                                                    class83.intStack[++class46.intStackSize - 1] = class44.method651().method5226(var16)?1:0;
                                                                                                                                    var15 = 1;
                                                                                                                                 } else if(var43 == 6638) {
                                                                                                                                    class46.intStackSize -= 2;
                                                                                                                                    var16 = class83.intStack[class46.intStackSize];
                                                                                                                                    var69 = new Coordinates(class83.intStack[class46.intStackSize + 1]);
                                                                                                                                    var78 = class44.method651().method5321(var16, var69);
                                                                                                                                    if(var78 == null) {
                                                                                                                                       class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                    } else {
                                                                                                                                       class83.intStack[++class46.intStackSize - 1] = var78.method3913();
                                                                                                                                    }

                                                                                                                                    var15 = 1;
                                                                                                                                 } else {
                                                                                                                                    class39 var88;
                                                                                                                                    if(var43 == 6639) {
                                                                                                                                       var88 = class44.method651().method5231();
                                                                                                                                       if(var88 == null) {
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                       } else {
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = var88.field548;
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = var88.field550.method3913();
                                                                                                                                       }

                                                                                                                                       var15 = 1;
                                                                                                                                    } else if(var43 == 6640) {
                                                                                                                                       var88 = class44.method651().method5232();
                                                                                                                                       if(var88 == null) {
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                       } else {
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = var88.field548;
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = var88.field550.method3913();
                                                                                                                                       }

                                                                                                                                       var15 = 1;
                                                                                                                                    } else {
                                                                                                                                       Area var74;
                                                                                                                                       if(var43 == 6693) {
                                                                                                                                          var16 = class83.intStack[--class46.intStackSize];
                                                                                                                                          var74 = Area.field3303[var16];
                                                                                                                                          if(var74.name == null) {
                                                                                                                                             class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                                                                                                          } else {
                                                                                                                                             class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var74.name;
                                                                                                                                          }

                                                                                                                                          var15 = 1;
                                                                                                                                       } else if(var43 == 6694) {
                                                                                                                                          var16 = class83.intStack[--class46.intStackSize];
                                                                                                                                          var74 = Area.field3303[var16];
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = var74.field3302;
                                                                                                                                          var15 = 1;
                                                                                                                                       } else if(var43 == 6695) {
                                                                                                                                          var16 = class83.intStack[--class46.intStackSize];
                                                                                                                                          var74 = Area.field3303[var16];
                                                                                                                                          if(var74 == null) {
                                                                                                                                             class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                          } else {
                                                                                                                                             class83.intStack[++class46.intStackSize - 1] = var74.field3307;
                                                                                                                                          }

                                                                                                                                          var15 = 1;
                                                                                                                                       } else if(var43 == 6696) {
                                                                                                                                          var16 = class83.intStack[--class46.intStackSize];
                                                                                                                                          var74 = Area.field3303[var16];
                                                                                                                                          if(var74 == null) {
                                                                                                                                             class83.intStack[++class46.intStackSize - 1] = -1;
                                                                                                                                          } else {
                                                                                                                                             class83.intStack[++class46.intStackSize - 1] = var74.spriteId;
                                                                                                                                          }

                                                                                                                                          var15 = 1;
                                                                                                                                       } else if(var43 == 6697) {
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = WorldMapType1.field449.field633;
                                                                                                                                          var15 = 1;
                                                                                                                                       } else if(var43 == 6698) {
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = WorldMapType1.field449.field635.method3913();
                                                                                                                                          var15 = 1;
                                                                                                                                       } else if(var43 == 6699) {
                                                                                                                                          class83.intStack[++class46.intStackSize - 1] = WorldMapType1.field449.field632.method3913();
                                                                                                                                          var15 = 1;
                                                                                                                                       } else {
                                                                                                                                          var15 = 2;
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              }
                                                                                                                           }
                                                                                                                        }
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var14 = var15;
                                                                                                               } else {
                                                                                                                  var14 = 2;
                                                                                                               }
                                                                                                            }
                                                                                                         }
                                                                                                      }
                                                                                                   }
                                                                                                }
                                                                                             }

                                                                                             switch(var14) {
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
         } catch (Exception var40) {
            StringBuilder var39 = new StringBuilder(30);
            var39.append("").append(var3.hash).append(" ");

            for(var12 = class83.scriptStackCount - 1; var12 >= 0; --var12) {
               var39.append("").append(class83.scriptStack[var12].invokedFromScript.hash).append(" ");
            }

            var39.append("").append(var9);
            MilliTimer.method2912(var39.toString(), var40);
         }
      }
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
      int var7;
      if(Client.field1056 >= 0) {
         var5 = class96.field1521;
         int[] var6 = class96.field1531;

         for(var7 = 0; var7 < var5; ++var7) {
            if(var6[var7] == Client.field1056) {
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

      for(Projectile var28 = (Projectile)Client.projectiles.getFront(); var28 != null; var28 = (Projectile)Client.projectiles.getNext()) {
         if(var28.floor == WallObject.plane && Client.gameCycle <= var28.cycle) {
            if(Client.gameCycle >= var28.startTime) {
               if(var28.interacting > 0) {
                  NPC var32 = Client.cachedNPCs[var28.interacting - 1];
                  if(var32 != null && var32.x >= 0 && var32.x < 13312 && var32.y >= 0 && var32.y < 13312) {
                     var28.method1758(var32.x, var32.y, WorldMapData.getTileHeight(var32.x, var32.y, var28.floor) - var28.endHeight, Client.gameCycle);
                  }
               }

               if(var28.interacting < 0) {
                  var7 = -var28.interacting - 1;
                  Player var33;
                  if(var7 == Client.localInteractingIndex) {
                     var33 = XItemContainer.localPlayer;
                  } else {
                     var33 = Client.cachedPlayers[var7];
                  }

                  if(var33 != null && var33.x >= 0 && var33.x < 13312 && var33.y >= 0 && var33.y < 13312) {
                     var28.method1758(var33.x, var33.y, WorldMapData.getTileHeight(var33.x, var33.y, var28.floor) - var28.endHeight, Client.gameCycle);
                  }
               }

               var28.method1759(Client.field1002);
               class2.region.method2677(WallObject.plane, (int)var28.x, (int)var28.velocityZ, (int)var28.z, 60, var28, var28.rotationX, -1, false);
            }
         } else {
            var28.unlink();
         }
      }

      for(GraphicsObject var36 = (GraphicsObject)Client.graphicsObjectDeque.getFront(); var36 != null; var36 = (GraphicsObject)Client.graphicsObjectDeque.getNext()) {
         if(var36.level == WallObject.plane && !var36.finished) {
            if(Client.gameCycle >= var36.startCycle) {
               var36.method1682(Client.field1002);
               if(var36.finished) {
                  var36.unlink();
               } else {
                  class2.region.method2677(var36.level, var36.x, var36.y, var36.height, 60, var36, 0, -1, false);
               }
            }
         } else {
            var36.unlink();
         }
      }

      Item.method1773(var0, var1, var2, var3, true);
      var0 = Client.field1187;
      var1 = Client.field1188;
      var2 = Client.viewportHeight;
      var3 = Client.viewportWidth;
      Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
      Graphics3D.method2582();
      int var29;
      if(!Client.field1173) {
         var5 = Client.field1052;
         if(Client.field1018 / 256 > var5) {
            var5 = Client.field1018 / 256;
         }

         if(Client.field1174[4] && Client.field996[4] + 128 > var5) {
            var5 = Client.field996[4] + 128;
         }

         var29 = Client.mapAngle + Client.field951 & 2047;
         ScriptEvent.method1126(Ignore.field860, WorldMapData.getTileHeight(XItemContainer.localPlayer.x, XItemContainer.localPlayer.y, WallObject.plane) - Client.field1015, field456, var5, var29, var5 * 3 + 600);
      }

      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      if(!Client.field1173) {
         if(class8.settings.hideRoofs) {
            var29 = WallObject.plane;
         } else {
            label671: {
               var7 = 3;
               if(Player.cameraPitch < 310) {
                  var8 = class155.cameraX >> 7;
                  var9 = class157.cameraY >> 7;
                  var10 = XItemContainer.localPlayer.x >> 7;
                  var11 = XItemContainer.localPlayer.y >> 7;
                  if(var8 < 0 || var9 < 0 || var8 >= 104 || var9 >= 104) {
                     var29 = WallObject.plane;
                     break label671;
                  }

                  if((class61.tileSettings[WallObject.plane][var8][var9] & 4) != 0) {
                     var7 = WallObject.plane;
                  }

                  if(var10 > var8) {
                     var12 = var10 - var8;
                  } else {
                     var12 = var8 - var10;
                  }

                  if(var11 > var9) {
                     var13 = var11 - var9;
                  } else {
                     var13 = var9 - var11;
                  }

                  if(var12 > var13) {
                     var14 = var13 * 65536 / var12;
                     var15 = '耀';

                     while(var8 != var10) {
                        if(var8 < var10) {
                           ++var8;
                        } else if(var8 > var10) {
                           --var8;
                        }

                        if((class61.tileSettings[WallObject.plane][var8][var9] & 4) != 0) {
                           var7 = WallObject.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var9 < var11) {
                              ++var9;
                           } else if(var9 > var11) {
                              --var9;
                           }

                           if((class61.tileSettings[WallObject.plane][var8][var9] & 4) != 0) {
                              var7 = WallObject.plane;
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

                        if((class61.tileSettings[WallObject.plane][var8][var9] & 4) != 0) {
                           var7 = WallObject.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var8 < var10) {
                              ++var8;
                           } else if(var8 > var10) {
                              --var8;
                           }

                           if((class61.tileSettings[WallObject.plane][var8][var9] & 4) != 0) {
                              var7 = WallObject.plane;
                           }
                        }
                     }
                  }
               }

               if(XItemContainer.localPlayer.x >= 0 && XItemContainer.localPlayer.y >= 0 && XItemContainer.localPlayer.x < 13312 && XItemContainer.localPlayer.y < 13312) {
                  if((class61.tileSettings[WallObject.plane][XItemContainer.localPlayer.x >> 7][XItemContainer.localPlayer.y >> 7] & 4) != 0) {
                     var7 = WallObject.plane;
                  }

                  var29 = var7;
               } else {
                  var29 = WallObject.plane;
               }
            }
         }

         var5 = var29;
      } else {
         if(class8.settings.hideRoofs) {
            var29 = WallObject.plane;
         } else {
            var7 = WorldMapData.getTileHeight(class155.cameraX, class157.cameraY, WallObject.plane);
            if(var7 - class60.cameraZ < 800 && (class61.tileSettings[WallObject.plane][class155.cameraX >> 7][class157.cameraY >> 7] & 4) != 0) {
               var29 = WallObject.plane;
            } else {
               var29 = 3;
            }
         }

         var5 = var29;
      }

      var29 = class155.cameraX;
      var7 = class60.cameraZ;
      var8 = class157.cameraY;
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
      boolean var34 = false;
      var15 = -1;
      int var16 = class96.field1521;
      int[] var17 = class96.field1531;

      int var18;
      for(var18 = 0; var18 < var16 + Client.field937; ++var18) {
         Object var19;
         if(var18 < var16) {
            var19 = Client.cachedPlayers[var17[var18]];
            if(var17[var18] == Client.field1056) {
               var34 = true;
               var15 = var18;
               continue;
            }
         } else {
            var19 = Client.cachedNPCs[Client.npcIndices[var18 - var16]];
         }

         WorldMapType3.method200((Actor)var19, var18, var0, var1, var2, var3);
      }

      if(var34) {
         WorldMapType3.method200(Client.cachedPlayers[Client.field1056], var15, var0, var1, var2, var3);
      }

      for(var18 = 0; var18 < Client.field1046; ++var18) {
         int var30 = Client.field1021[var18];
         int var20 = Client.field1022[var18];
         int var21 = Client.field1024[var18];
         int var22 = Client.field1009[var18];
         boolean var23 = true;

         while(var23) {
            var23 = false;

            for(int var24 = 0; var24 < var18; ++var24) {
               if(var20 + 2 > Client.field1022[var24] - Client.field1009[var24] && var20 - var22 < Client.field1022[var24] + 2 && var30 - var21 < Client.field1021[var24] + Client.field1024[var24] && var30 + var21 > Client.field1021[var24] - Client.field1024[var24] && Client.field1022[var24] - Client.field1009[var24] < var20) {
                  var20 = Client.field1022[var24] - Client.field1009[var24];
                  var23 = true;
               }
            }
         }

         Client.screenY = Client.field1021[var18];
         Client.screenX = Client.field1022[var18] = var20;
         String var31 = Client.field1028[var18];
         if(Client.field1089 == 0) {
            int var25 = 16776960;
            if(Client.field938[var18] < 6) {
               var25 = Client.field1142[Client.field938[var18]];
            }

            if(Client.field938[var18] == 6) {
               var25 = Client.field957 % 20 < 10?16711680:16776960;
            }

            if(Client.field938[var18] == 7) {
               var25 = Client.field957 % 20 < 10?255:'\uffff';
            }

            if(Client.field938[var18] == 8) {
               var25 = Client.field957 % 20 < 10?'뀀':8454016;
            }

            int var26;
            if(Client.field938[var18] == 9) {
               var26 = 150 - Client.field1027[var18];
               if(var26 < 50) {
                  var25 = var26 * 1280 + 16711680;
               } else if(var26 < 100) {
                  var25 = 16776960 - (var26 - 50) * 327680;
               } else if(var26 < 150) {
                  var25 = (var26 - 100) * 5 + '\uff00';
               }
            }

            if(Client.field938[var18] == 10) {
               var26 = 150 - Client.field1027[var18];
               if(var26 < 50) {
                  var25 = 5 * var26 + 16711680;
               } else if(var26 < 100) {
                  var25 = 16711935 - (var26 - 50) * 327680;
               } else if(var26 < 150) {
                  var25 = (var26 - 100) * 327680 + 255 - (var26 - 100) * 5;
               }
            }

            if(Client.field938[var18] == 11) {
               var26 = 150 - Client.field1027[var18];
               if(var26 < 50) {
                  var25 = 16777215 - var26 * 327685;
               } else if(var26 < 100) {
                  var25 = (var26 - 50) * 327685 + '\uff00';
               } else if(var26 < 150) {
                  var25 = 16777215 - (var26 - 100) * 327680;
               }
            }

            if(Client.field1151[var18] == 0) {
               World.field1322.method4757(var31, var0 + Client.screenY, Client.screenX + var1, var25, 0);
            }

            if(Client.field1151[var18] == 1) {
               World.field1322.method4759(var31, var0 + Client.screenY, Client.screenX + var1, var25, 0, Client.field957);
            }

            if(Client.field1151[var18] == 2) {
               World.field1322.method4760(var31, var0 + Client.screenY, Client.screenX + var1, var25, 0, Client.field957);
            }

            if(Client.field1151[var18] == 3) {
               World.field1322.method4770(var31, var0 + Client.screenY, Client.screenX + var1, var25, 0, Client.field957, 150 - Client.field1027[var18]);
            }

            if(Client.field1151[var18] == 4) {
               var26 = (150 - Client.field1027[var18]) * (World.field1322.method4773(var31) + 100) / 150;
               Rasterizer2D.setInnerDrawRegion(var0 + Client.screenY - 50, var1, var0 + Client.screenY + 50, var3 + var1);
               World.field1322.method4790(var31, var0 + Client.screenY + 50 - var26, Client.screenX + var1, var25, 0);
               Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
            }

            if(Client.field1151[var18] == 5) {
               var26 = 150 - Client.field1027[var18];
               int var27 = 0;
               if(var26 < 25) {
                  var27 = var26 - 25;
               } else if(var26 > 125) {
                  var27 = var26 - 125;
               }

               Rasterizer2D.setInnerDrawRegion(var0, Client.screenX + var1 - World.field1322.verticalSpace - 1, var0 + var2, Client.screenX + var1 + 5);
               World.field1322.method4757(var31, var0 + Client.screenY, var27 + Client.screenX + var1, var25, 0);
               Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            World.field1322.method4757(var31, var0 + Client.screenY, Client.screenX + var1, 16776960, 0);
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
      class155.cameraX = var29;
      class60.cameraZ = var7;
      class157.cameraY = var8;
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
}
