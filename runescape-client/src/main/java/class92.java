import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("cb")
public class class92 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1881363123
   )
   static int field1416;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2122147737
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("k")
   static int[] field1427;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -727393829
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -513887517
   )
   static int field1403;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1757902535
   )
   static int field1402;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -679943343
   )
   static int field1405;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 947463197
   )
   static int field1406;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1722539971
   )
   static int field1413;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 560097865
   )
   static int field1408;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1135110637
   )
   @Export("loadingBarPercentage")
   static int loadingBarPercentage;
   @ObfuscatedName("ai")
   @Export("loadingText")
   static String loadingText;
   @ObfuscatedName("ad")
   static String field1412;
   @ObfuscatedName("ah")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("ao")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("av")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("az")
   @Export(
      value = "username",
      setter = true
   )
   static String username;
   @ObfuscatedName("al")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("aq")
   @Export("password")
   static String password;
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "Leu;"
   )
   static class149 field1418;
   @ObfuscatedName("aa")
   static boolean field1419;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 600266795
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "[Lji;"
   )
   static SpritePixels[] field1424;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -1188225981
   )
   static int field1404;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   static SpritePixels field1411;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   static SpritePixels field1399;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljw;"
   )
   static IndexedSprite field1396;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ljw;"
   )
   static IndexedSprite field1397;
   @ObfuscatedName("d")
   static boolean field1420;

   static {
      field1416 = 0;
      loginWindowX = field1416 + 202;
      field1427 = new int[256];
      field1403 = 0;
      field1402 = 0;
      field1405 = 0;
      field1406 = 0;
      field1413 = 0;
      field1408 = 0;
      loadingBarPercentage = 10;
      loadingText = "";
      loginIndex = 0;
      field1412 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      password = "";
      field1418 = class149.field2174;
      field1419 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field1404 = -1;
   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "20393"
   )
   static final void method1760() {
      Overlay.overlays.reset();
      FloorUnderlayDefinition.underlays.reset();
      KitDefinition.identKits.reset();
      ObjectComposition.objects.reset();
      ObjectComposition.field3447.reset();
      ObjectComposition.cachedModels.reset();
      ObjectComposition.field3420.reset();
      class71.method1129();
      class228.method4089();
      Sequence.sequences.reset();
      Sequence.skeletons.reset();
      WorldMapType1.method270();
      method1751();
      PacketBuffer.method3450();
      class254.field3392.reset();
      class254.field3391.reset();
      class254.field3393.reset();
      class35.method499();
      class252.field3373.reset();
      class217.method4066();
      Area.skeletonsIndex.reset();
      class40.method555();
      VertexNormal.method2603();
      ((TextureProvider)Graphics3D.textureLoader).reset();
      Script.field1501.reset();
      class67.indexInterfaces.reset();
      class64.indexSoundEffects.reset();
      class44.field551.reset();
      class207.field2555.reset();
      Client.indexMaps.reset();
      class2.indexTrack1.reset();
      class54.indexModels.reset();
      CombatInfo1.indexSprites.reset();
      SoundTask.indexTextures.reset();
      class221.field2806.reset();
      class3.indexTrack2.reset();
      Client.indexScripts.reset();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lbc;II)V",
      garbageValue = "-1663433161"
   )
   static void method1743(ScriptEvent var0, int var1) {
      Object[] var2 = var0.field818;
      Script var3;
      Script var5;
      int var7;
      int var8;
      int var9;
      int var11;
      int var20;
      if(class21.method149(var0.field819)) {
         class41.field519 = (class47)var2[0];
         Area var4 = Area.field3286[class41.field519.field568];
         class219 var6 = var0.field819;
         var7 = var4.field3278;
         var8 = var4.field3295;
         var9 = class17.method118(var7, var6);
         Script var10 = PendingSpawn.method1527(var9, var6);
         if(var10 != null) {
            var5 = var10;
         } else {
            var11 = (var8 + '鱀' << 8) + var6.field2776;
            var10 = PendingSpawn.method1527(var11, var6);
            if(var10 != null) {
               var5 = var10;
            } else {
               var5 = null;
            }
         }

         var3 = var5;
      } else {
         var20 = ((Integer)var2[0]).intValue();
         Script var34 = (Script)Script.field1501.get((long)var20);
         if(var34 != null) {
            var5 = var34;
         } else {
            byte[] var30 = Client.indexScripts.getConfigData(var20, 0);
            if(var30 == null) {
               var5 = null;
            } else {
               var34 = TextureProvider.method2414(var30);
               Script.field1501.put(var34, (long)var20);
               var5 = var34;
            }
         }

         var3 = var5;
      }

      if(var3 != null) {
         class83.intStackSize = 0;
         Timer.scriptStringStackSize = 0;
         var20 = -1;
         int[] var37 = var3.instructions;
         int[] var35 = var3.intOperands;
         byte var36 = -1;
         class83.scriptStackCount = 0;

         int var21;
         try {
            class83.scriptLocalInts = new int[var3.localIntCount];
            var8 = 0;
            class83.scriptLocalStrings = new String[var3.localStringCount];
            var9 = 0;

            String var22;
            for(var21 = 1; var21 < var2.length; ++var21) {
               if(var2[var21] instanceof Integer) {
                  var11 = ((Integer)var2[var21]).intValue();
                  if(var11 == -2147483647) {
                     var11 = var0.field813;
                  }

                  if(var11 == -2147483646) {
                     var11 = var0.field814;
                  }

                  if(var11 == -2147483645) {
                     var11 = var0.widget != null?var0.widget.id:-1;
                  }

                  if(var11 == -2147483644) {
                     var11 = var0.field822;
                  }

                  if(var11 == -2147483643) {
                     var11 = var0.widget != null?var0.widget.index:-1;
                  }

                  if(var11 == -2147483642) {
                     var11 = var0.field821 != null?var0.field821.id:-1;
                  }

                  if(var11 == -2147483641) {
                     var11 = var0.field821 != null?var0.field821.index:-1;
                  }

                  if(var11 == -2147483640) {
                     var11 = var0.field817;
                  }

                  if(var11 == -2147483639) {
                     var11 = var0.field810;
                  }

                  class83.scriptLocalInts[var8++] = var11;
               } else if(var2[var21] instanceof String) {
                  var22 = (String)var2[var21];
                  if(var22.equals("event_opbase")) {
                     var22 = var0.field826;
                  }

                  class83.scriptLocalStrings[var9++] = var22;
               }
            }

            var21 = 0;
            class83.field1306 = var0.field820;

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
                                                                                       label354:
                                                                                       while(true) {
                                                                                          ++var21;
                                                                                          if(var21 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var20;
                                                                                          var7 = var37[var20];
                                                                                          int var12;
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
                                                                                                                              int var14;
                                                                                                                              int var15;
                                                                                                                              int var16;
                                                                                                                              int var17;
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
                                                                                                                                                                        var11 = var35[var20] >> 16;
                                                                                                                                                                        var12 = var35[var20] & '\uffff';
                                                                                                                                                                        int var29 = class83.intStack[--class83.intStackSize];
                                                                                                                                                                        if(var29 >= 0 && var29 <= 5000) {
                                                                                                                                                                           class83.field1304[var11] = var29;
                                                                                                                                                                           byte var40 = -1;
                                                                                                                                                                           if(var12 == 105) {
                                                                                                                                                                              var40 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var15 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var15 >= var29) {
                                                                                                                                                                                 continue label354;
                                                                                                                                                                              }

                                                                                                                                                                              class83.SHAPE_VERTICIES[var11][var15] = var40;
                                                                                                                                                                              ++var15;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var7 == 45) {
                                                                                                                                                                        var11 = var35[var20];
                                                                                                                                                                        var12 = class83.intStack[--class83.intStackSize];
                                                                                                                                                                        if(var12 < 0 || var12 >= class83.field1304[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class83.intStack[++class83.intStackSize - 1] = class83.SHAPE_VERTICIES[var11][var12];
                                                                                                                                                                     } else if(var7 == 46) {
                                                                                                                                                                        var11 = var35[var20];
                                                                                                                                                                        class83.intStackSize -= 2;
                                                                                                                                                                        var12 = class83.intStack[class83.intStackSize];
                                                                                                                                                                        if(var12 < 0 || var12 >= class83.field1304[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class83.SHAPE_VERTICIES[var11][var12] = class83.intStack[class83.intStackSize + 1];
                                                                                                                                                                     } else if(var7 == 47) {
                                                                                                                                                                        var22 = class51.chatMessages.getVarcString(var35[var20]);
                                                                                                                                                                        if(var22 == null) {
                                                                                                                                                                           var22 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var22;
                                                                                                                                                                     } else if(var7 == 48) {
                                                                                                                                                                        class51.chatMessages.putVarcString(var35[var20], class83.scriptStringStack[--Timer.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var7 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        IterableHashTable var44 = var3.switches[var35[var20]];
                                                                                                                                                                        IntegerNode var47 = (IntegerNode)var44.get((long)class83.intStack[--class83.intStackSize]);
                                                                                                                                                                        if(var47 != null) {
                                                                                                                                                                           var20 += var47.value;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     class51.chatMessages.putVarc(var35[var20], class83.intStack[--class83.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class83.intStack[++class83.intStackSize - 1] = class51.chatMessages.getVarc(var35[var20]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var11 = var35[var20];
                                                                                                                                                               Script var39 = (Script)Script.field1501.get((long)var11);
                                                                                                                                                               Script var45;
                                                                                                                                                               if(var39 != null) {
                                                                                                                                                                  var45 = var39;
                                                                                                                                                               } else {
                                                                                                                                                                  byte[] var25 = Client.indexScripts.getConfigData(var11, 0);
                                                                                                                                                                  if(var25 == null) {
                                                                                                                                                                     var45 = null;
                                                                                                                                                                  } else {
                                                                                                                                                                     var39 = TextureProvider.method2414(var25);
                                                                                                                                                                     Script.field1501.put(var39, (long)var11);
                                                                                                                                                                     var45 = var39;
                                                                                                                                                                  }
                                                                                                                                                               }

                                                                                                                                                               var39 = var45;
                                                                                                                                                               int[] var46 = new int[var45.localIntCount];
                                                                                                                                                               String[] var43 = new String[var45.localStringCount];

                                                                                                                                                               for(var16 = 0; var16 < var39.intStackCount; ++var16) {
                                                                                                                                                                  var46[var16] = class83.intStack[var16 + (class83.intStackSize - var39.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var16 = 0; var16 < var39.stringStackCount; ++var16) {
                                                                                                                                                                  var43[var16] = class83.scriptStringStack[var16 + (Timer.scriptStringStackSize - var39.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class83.intStackSize -= var39.intStackCount;
                                                                                                                                                               Timer.scriptStringStackSize -= var39.stringStackCount;
                                                                                                                                                               ScriptState var26 = new ScriptState();
                                                                                                                                                               var26.invokedFromScript = var3;
                                                                                                                                                               var26.invokedFromPc = var20;
                                                                                                                                                               var26.savedLocalInts = class83.scriptLocalInts;
                                                                                                                                                               var26.savedLocalStrings = class83.scriptLocalStrings;
                                                                                                                                                               class83.scriptStack[++class83.scriptStackCount - 1] = var26;
                                                                                                                                                               var3 = var39;
                                                                                                                                                               var37 = var39.instructions;
                                                                                                                                                               var35 = var39.intOperands;
                                                                                                                                                               var20 = -1;
                                                                                                                                                               class83.scriptLocalInts = var46;
                                                                                                                                                               class83.scriptLocalStrings = var43;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --Timer.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class83.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var11 = var35[var20];
                                                                                                                                                      Timer.scriptStringStackSize -= var11;
                                                                                                                                                      String[] var38 = class83.scriptStringStack;
                                                                                                                                                      var14 = Timer.scriptStringStackSize;
                                                                                                                                                      String var23;
                                                                                                                                                      if(var11 == 0) {
                                                                                                                                                         var23 = "";
                                                                                                                                                      } else if(var11 == 1) {
                                                                                                                                                         String var24 = var38[var14];
                                                                                                                                                         if(var24 == null) {
                                                                                                                                                            var23 = "null";
                                                                                                                                                         } else {
                                                                                                                                                            var23 = var24.toString();
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         var15 = var14 + var11;
                                                                                                                                                         var16 = 0;

                                                                                                                                                         for(var17 = var14; var17 < var15; ++var17) {
                                                                                                                                                            String var18 = var38[var17];
                                                                                                                                                            if(var18 == null) {
                                                                                                                                                               var16 += 4;
                                                                                                                                                            } else {
                                                                                                                                                               var16 += var18.length();
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         StringBuilder var27 = new StringBuilder(var16);

                                                                                                                                                         for(int var28 = var14; var28 < var15; ++var28) {
                                                                                                                                                            String var19 = var38[var28];
                                                                                                                                                            if(var19 == null) {
                                                                                                                                                               var27.append("null");
                                                                                                                                                            } else {
                                                                                                                                                               var27.append(var19);
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         var23 = var27.toString();
                                                                                                                                                      }

                                                                                                                                                      class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var23;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class83.scriptLocalStrings[var35[var20]] = class83.scriptStringStack[--Timer.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = class83.scriptLocalStrings[var35[var20]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class83.scriptLocalInts[var35[var20]] = class83.intStack[--class83.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class83.intStack[++class83.intStackSize - 1] = class83.scriptLocalInts[var35[var20]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class83.intStackSize -= 2;
                                                                                                                                       if(class83.intStack[class83.intStackSize] >= class83.intStack[class83.intStackSize + 1]) {
                                                                                                                                          var20 += var35[var20];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class83.intStackSize -= 2;
                                                                                                                                    if(class83.intStack[class83.intStackSize] <= class83.intStack[class83.intStackSize + 1]) {
                                                                                                                                       var20 += var35[var20];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var11 = var35[var20];
                                                                                                                                 var12 = class83.intStack[--class83.intStackSize];
                                                                                                                                 Varbit var13 = Actor.method1533(var11);
                                                                                                                                 var14 = var13.configId;
                                                                                                                                 var15 = var13.leastSignificantBit;
                                                                                                                                 var16 = var13.mostSignificantBit;
                                                                                                                                 var17 = class211.field2582[var16 - var15];
                                                                                                                                 if(var12 < 0 || var12 > var17) {
                                                                                                                                    var12 = 0;
                                                                                                                                 }

                                                                                                                                 var17 <<= var15;
                                                                                                                                 class211.widgetSettings[var14] = class211.widgetSettings[var14] & ~var17 | var12 << var15 & var17;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var11 = var35[var20];
                                                                                                                              class83.intStack[++class83.intStackSize - 1] = class90.method1720(var11);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class83.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var42 = class83.scriptStack[--class83.scriptStackCount];
                                                                                                                           var3 = var42.invokedFromScript;
                                                                                                                           var37 = var3.instructions;
                                                                                                                           var35 = var3.intOperands;
                                                                                                                           var20 = var42.invokedFromPc;
                                                                                                                           class83.scriptLocalInts = var42.savedLocalInts;
                                                                                                                           class83.scriptLocalStrings = var42.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class83.intStackSize -= 2;
                                                                                                                        if(class83.intStack[class83.intStackSize] > class83.intStack[class83.intStackSize + 1]) {
                                                                                                                           var20 += var35[var20];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class83.intStackSize -= 2;
                                                                                                                     if(class83.intStack[class83.intStackSize] < class83.intStack[class83.intStackSize + 1]) {
                                                                                                                        var20 += var35[var20];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class83.intStackSize -= 2;
                                                                                                                  if(class83.intStack[class83.intStackSize] == class83.intStack[class83.intStackSize + 1]) {
                                                                                                                     var20 += var35[var20];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class83.intStackSize -= 2;
                                                                                                               if(class83.intStack[class83.intStackSize + 1] != class83.intStack[class83.intStackSize]) {
                                                                                                                  var20 += var35[var20];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var20 += var35[var20];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var3.stringOperands[var20];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var11 = var35[var20];
                                                                                                      class211.widgetSettings[var11] = class83.intStack[--class83.intStackSize];
                                                                                                      WidgetNode.method1114(var11);
                                                                                                   }
                                                                                                } else {
                                                                                                   var11 = var35[var20];
                                                                                                   class83.intStack[++class83.intStackSize - 1] = class211.widgetSettings[var11];
                                                                                                }
                                                                                             } else {
                                                                                                class83.intStack[++class83.intStackSize - 1] = var35[var20];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var41;
                                                                                             if(var3.intOperands[var20] == 1) {
                                                                                                var41 = true;
                                                                                             } else {
                                                                                                var41 = false;
                                                                                             }

                                                                                             var12 = class164.method3120(var7, var3, var41);
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
         } catch (Exception var33) {
            StringBuilder var32 = new StringBuilder(30);
            var32.append("").append(var3.hash).append(" ");

            for(var21 = class83.scriptStackCount - 1; var21 >= 0; --var21) {
               var32.append("").append(class83.scriptStack[var21].invokedFromScript.hash).append(" ");
            }

            var32.append("").append(var36);
            class23.method165(var32.toString(), var33);
         }
      }
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(Lhn;II)I",
      garbageValue = "-1146787423"
   )
   static final int method1758(Widget var0, int var1) {
      if(var0.dynamicValues != null && var1 < var0.dynamicValues.length) {
         try {
            int[] var2 = var0.dynamicValues[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = Client.boostedSkillLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = Client.realSkillLevels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = Client.skillExperiences[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = WallObject.method2901(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!Friend.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var10.itemIds[var12] == var11 + 1) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class211.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class222.field2817[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class211.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class224.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class222.field2816[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = WallObject.method2901(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!Friend.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = Client.energy;
               }

               if(var6 == 12) {
                  var7 = Client.weight;
               }

               if(var6 == 13) {
                  var9 = class211.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class90.method1720(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (class224.localPlayer.x >> 7) + class33.baseX;
               }

               if(var6 == 19) {
                  var7 = (class224.localPlayer.y >> 7) + class17.baseY;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "114"
   )
   public static void method1751() {
      Varbit.varbits.reset();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "2005428503"
   )
   static Class method1761(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }
}
