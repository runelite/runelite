import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class205 extends Node {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1858434789
   )
   int field2549;
   @ObfuscatedName("p")
   class207 field2550;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1604548919
   )
   int field2551;
   @ObfuscatedName("j")
   class202 field2552;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -596487601
   )
   int field2553;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1201527931
   )
   int field2554;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 427601771
   )
   int field2555;
   @ObfuscatedName("i")
   class107 field2556;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1012194383
   )
   int field2557;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 568316949
   )
   int field2558;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2387753
   )
   int field2559;
   @ObfuscatedName("v")
   class117 field2560;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1074436995
   )
   int field2561;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -598511763
   )
   int field2562;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1160074279
   )
   int field2563;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1713682565
   )
   int field2564;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1341388707
   )
   int field2565;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -864173083
   )
   int field2566;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 445657519
   )
   int field2567;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -404758531
   )
   int field2568;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1782564501
   )
   int field2569;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "359808376"
   )
   void method3841() {
      this.field2550 = null;
      this.field2556 = null;
      this.field2552 = null;
      this.field2560 = null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "-62"
   )
   static int method3842(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 6600) {
         var3 = class92.plane;
         int var13 = (class168.localPlayer.x >> 7) + class61.baseX;
         int var5 = class23.baseY + (class168.localPlayer.y >> 7);
         WorldMapType1.method259().method5226(var3, var13, var5, true);
         return 1;
      } else {
         WorldMapData var16;
         if(var0 == 6601) {
            var3 = class83.intStack[--class165.intStackSize];
            String var20 = "";
            var16 = WorldMapType1.method259().method5272(var3);
            if(var16 != null) {
               var20 = var16.method299();
            }

            class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var20;
            return 1;
         } else if(var0 == 6602) {
            var3 = class83.intStack[--class165.intStackSize];
            WorldMapType1.method259().method5227(var3);
            return 1;
         } else if(var0 == 6603) {
            class83.intStack[++class165.intStackSize - 1] = WorldMapType1.method259().method5239();
            return 1;
         } else if(var0 == 6604) {
            var3 = class83.intStack[--class165.intStackSize];
            WorldMapType1.method259().method5221(var3);
            return 1;
         } else if(var0 == 6605) {
            class83.intStack[++class165.intStackSize - 1] = WorldMapType1.method259().method5241()?1:0;
            return 1;
         } else {
            Coordinates var15;
            if(var0 == 6606) {
               var15 = new Coordinates(class83.intStack[--class165.intStackSize]);
               WorldMapType1.method259().method5243(var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6607) {
               var15 = new Coordinates(class83.intStack[--class165.intStackSize]);
               WorldMapType1.method259().method5299(var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6608) {
               var15 = new Coordinates(class83.intStack[--class165.intStackSize]);
               WorldMapType1.method259().method5245(var15.plane, var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6609) {
               var15 = new Coordinates(class83.intStack[--class165.intStackSize]);
               WorldMapType1.method259().method5293(var15.plane, var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6610) {
               class83.intStack[++class165.intStackSize - 1] = WorldMapType1.method259().method5246();
               class83.intStack[++class165.intStackSize - 1] = WorldMapType1.method259().method5247();
               return 1;
            } else {
               WorldMapData var18;
               if(var0 == 6611) {
                  var3 = class83.intStack[--class165.intStackSize];
                  var18 = WorldMapType1.method259().method5272(var3);
                  if(var18 == null) {
                     class83.intStack[++class165.intStackSize - 1] = 0;
                  } else {
                     class83.intStack[++class165.intStackSize - 1] = var18.method343().method3955();
                  }

                  return 1;
               } else if(var0 == 6612) {
                  var3 = class83.intStack[--class165.intStackSize];
                  var18 = WorldMapType1.method259().method5272(var3);
                  if(var18 == null) {
                     class83.intStack[++class165.intStackSize - 1] = 0;
                     class83.intStack[++class165.intStackSize - 1] = 0;
                  } else {
                     class83.intStack[++class165.intStackSize - 1] = (var18.method322() - var18.method302() + 1) * 64;
                     class83.intStack[++class165.intStackSize - 1] = (var18.method305() - var18.method330() + 1) * 64;
                  }

                  return 1;
               } else if(var0 == 6613) {
                  var3 = class83.intStack[--class165.intStackSize];
                  var18 = WorldMapType1.method259().method5272(var3);
                  if(var18 == null) {
                     class83.intStack[++class165.intStackSize - 1] = 0;
                     class83.intStack[++class165.intStackSize - 1] = 0;
                     class83.intStack[++class165.intStackSize - 1] = 0;
                     class83.intStack[++class165.intStackSize - 1] = 0;
                  } else {
                     class83.intStack[++class165.intStackSize - 1] = var18.method302() * 64;
                     class83.intStack[++class165.intStackSize - 1] = var18.method330() * 64;
                     class83.intStack[++class165.intStackSize - 1] = var18.method322() * 64 + 64 - 1;
                     class83.intStack[++class165.intStackSize - 1] = var18.method305() * 64 + 64 - 1;
                  }

                  return 1;
               } else if(var0 == 6614) {
                  var3 = class83.intStack[--class165.intStackSize];
                  var18 = WorldMapType1.method259().method5272(var3);
                  if(var18 == null) {
                     class83.intStack[++class165.intStackSize - 1] = -1;
                  } else {
                     class83.intStack[++class165.intStackSize - 1] = var18.method301();
                  }

                  return 1;
               } else if(var0 == 6615) {
                  var15 = WorldMapType1.method259().method5248();
                  if(var15 == null) {
                     class83.intStack[++class165.intStackSize - 1] = -1;
                     class83.intStack[++class165.intStackSize - 1] = -1;
                  } else {
                     class83.intStack[++class165.intStackSize - 1] = var15.worldX;
                     class83.intStack[++class165.intStackSize - 1] = var15.worldY;
                  }

                  return 1;
               } else if(var0 == 6616) {
                  class83.intStack[++class165.intStackSize - 1] = WorldMapType1.method259().method5228();
                  return 1;
               } else if(var0 == 6617) {
                  var15 = new Coordinates(class83.intStack[--class165.intStackSize]);
                  var18 = WorldMapType1.method259().method5223();
                  if(var18 == null) {
                     class83.intStack[++class165.intStackSize - 1] = -1;
                     class83.intStack[++class165.intStackSize - 1] = -1;
                     return 1;
                  } else {
                     int[] var19 = var18.method336(var15.plane, var15.worldX, var15.worldY);
                     if(var19 == null) {
                        class83.intStack[++class165.intStackSize - 1] = -1;
                        class83.intStack[++class165.intStackSize - 1] = -1;
                     } else {
                        class83.intStack[++class165.intStackSize - 1] = var19[0];
                        class83.intStack[++class165.intStackSize - 1] = var19[1];
                     }

                     return 1;
                  }
               } else {
                  Coordinates var12;
                  if(var0 == 6618) {
                     var15 = new Coordinates(class83.intStack[--class165.intStackSize]);
                     var18 = WorldMapType1.method259().method5223();
                     if(var18 == null) {
                        class83.intStack[++class165.intStackSize - 1] = -1;
                        class83.intStack[++class165.intStackSize - 1] = -1;
                        return 1;
                     } else {
                        var12 = var18.method294(var15.worldX, var15.worldY);
                        if(var12 == null) {
                           class83.intStack[++class165.intStackSize - 1] = -1;
                        } else {
                           class83.intStack[++class165.intStackSize - 1] = var12.method3955();
                        }

                        return 1;
                     }
                  } else {
                     Coordinates var17;
                     if(var0 == 6619) {
                        class165.intStackSize -= 2;
                        var3 = class83.intStack[class165.intStackSize];
                        var17 = new Coordinates(class83.intStack[class165.intStackSize + 1]);
                        var16 = WorldMapType1.method259().method5272(var3);
                        int var6 = class168.localPlayer.field891;
                        int var7 = class61.baseX + (class168.localPlayer.x >> 7);
                        int var8 = (class168.localPlayer.y >> 7) + class23.baseY;
                        Coordinates var9 = new Coordinates(var6, var7, var8);
                        WorldMapType1.method259().method5232(var16, var9, var17, false);
                        return 1;
                     } else if(var0 == 6620) {
                        class165.intStackSize -= 2;
                        var3 = class83.intStack[class165.intStackSize];
                        var17 = new Coordinates(class83.intStack[class165.intStackSize + 1]);
                        class5.method18(var3, var17, true);
                        return 1;
                     } else if(var0 == 6621) {
                        class165.intStackSize -= 2;
                        var3 = class83.intStack[class165.intStackSize];
                        var17 = new Coordinates(class83.intStack[class165.intStackSize + 1]);
                        var16 = WorldMapType1.method259().method5272(var3);
                        if(var16 == null) {
                           class83.intStack[++class165.intStackSize - 1] = 0;
                           return 1;
                        } else {
                           class83.intStack[++class165.intStackSize - 1] = var16.method291(var17.plane, var17.worldX, var17.worldY)?1:0;
                           return 1;
                        }
                     } else if(var0 == 6622) {
                        class83.intStack[++class165.intStackSize - 1] = WorldMapType1.method259().method5249();
                        class83.intStack[++class165.intStackSize - 1] = WorldMapType1.method259().method5250();
                        return 1;
                     } else if(var0 == 6623) {
                        var15 = new Coordinates(class83.intStack[--class165.intStackSize]);
                        var18 = WorldMapType1.method259().method5225(var15.plane, var15.worldX, var15.worldY);
                        if(var18 == null) {
                           class83.intStack[++class165.intStackSize - 1] = -1;
                        } else {
                           class83.intStack[++class165.intStackSize - 1] = var18.method296();
                        }

                        return 1;
                     } else if(var0 == 6624) {
                        WorldMapType1.method259().method5251(class83.intStack[--class165.intStackSize]);
                        return 1;
                     } else if(var0 == 6625) {
                        WorldMapType1.method259().method5252();
                        return 1;
                     } else if(var0 == 6626) {
                        WorldMapType1.method259().method5219(class83.intStack[--class165.intStackSize]);
                        return 1;
                     } else if(var0 == 6627) {
                        WorldMapType1.method259().method5254();
                        return 1;
                     } else {
                        boolean var14;
                        if(var0 == 6628) {
                           var14 = class83.intStack[--class165.intStackSize] == 1;
                           WorldMapType1.method259().method5255(var14);
                           return 1;
                        } else if(var0 == 6629) {
                           var3 = class83.intStack[--class165.intStackSize];
                           WorldMapType1.method259().method5313(var3);
                           return 1;
                        } else if(var0 == 6630) {
                           var3 = class83.intStack[--class165.intStackSize];
                           WorldMapType1.method259().method5257(var3);
                           return 1;
                        } else if(var0 == 6631) {
                           WorldMapType1.method259().method5258();
                           return 1;
                        } else if(var0 == 6632) {
                           var14 = class83.intStack[--class165.intStackSize] == 1;
                           WorldMapType1.method259().method5259(var14);
                           return 1;
                        } else {
                           boolean var4;
                           if(var0 == 6633) {
                              class165.intStackSize -= 2;
                              var3 = class83.intStack[class165.intStackSize];
                              var4 = class83.intStack[class165.intStackSize + 1] == 1;
                              WorldMapType1.method259().method5260(var3, var4);
                              return 1;
                           } else if(var0 == 6634) {
                              class165.intStackSize -= 2;
                              var3 = class83.intStack[class165.intStackSize];
                              var4 = class83.intStack[class165.intStackSize + 1] == 1;
                              WorldMapType1.method259().method5261(var3, var4);
                              return 1;
                           } else if(var0 == 6635) {
                              class83.intStack[++class165.intStackSize - 1] = WorldMapType1.method259().method5262()?1:0;
                              return 1;
                           } else if(var0 == 6636) {
                              var3 = class83.intStack[--class165.intStackSize];
                              class83.intStack[++class165.intStackSize - 1] = WorldMapType1.method259().method5263(var3)?1:0;
                              return 1;
                           } else if(var0 == 6637) {
                              var3 = class83.intStack[--class165.intStackSize];
                              class83.intStack[++class165.intStackSize - 1] = WorldMapType1.method259().method5264(var3)?1:0;
                              return 1;
                           } else if(var0 == 6638) {
                              class165.intStackSize -= 2;
                              var3 = class83.intStack[class165.intStackSize];
                              var17 = new Coordinates(class83.intStack[class165.intStackSize + 1]);
                              var12 = WorldMapType1.method259().method5267(var3, var17);
                              if(var12 == null) {
                                 class83.intStack[++class165.intStackSize - 1] = -1;
                              } else {
                                 class83.intStack[++class165.intStackSize - 1] = var12.method3955();
                              }

                              return 1;
                           } else {
                              class39 var10;
                              if(var0 == 6639) {
                                 var10 = WorldMapType1.method259().method5269();
                                 if(var10 == null) {
                                    class83.intStack[++class165.intStackSize - 1] = -1;
                                    class83.intStack[++class165.intStackSize - 1] = -1;
                                 } else {
                                    class83.intStack[++class165.intStackSize - 1] = var10.field538;
                                    class83.intStack[++class165.intStackSize - 1] = var10.field527.method3955();
                                 }

                                 return 1;
                              } else if(var0 == 6640) {
                                 var10 = WorldMapType1.method259().method5270();
                                 if(var10 == null) {
                                    class83.intStack[++class165.intStackSize - 1] = -1;
                                    class83.intStack[++class165.intStackSize - 1] = -1;
                                 } else {
                                    class83.intStack[++class165.intStackSize - 1] = var10.field538;
                                    class83.intStack[++class165.intStackSize - 1] = var10.field527.method3955();
                                 }

                                 return 1;
                              } else {
                                 Area var11;
                                 if(var0 == 6693) {
                                    var3 = class83.intStack[--class165.intStackSize];
                                    var11 = World.field1300[var3];
                                    if(var11.name == null) {
                                       class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                                    } else {
                                       class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var11.name;
                                    }

                                    return 1;
                                 } else if(var0 == 6694) {
                                    var3 = class83.intStack[--class165.intStackSize];
                                    var11 = World.field1300[var3];
                                    class83.intStack[++class165.intStackSize - 1] = var11.field3301;
                                    return 1;
                                 } else if(var0 == 6695) {
                                    var3 = class83.intStack[--class165.intStackSize];
                                    var11 = World.field1300[var3];
                                    if(var11 == null) {
                                       class83.intStack[++class165.intStackSize - 1] = -1;
                                    } else {
                                       class83.intStack[++class165.intStackSize - 1] = var11.field3313;
                                    }

                                    return 1;
                                 } else if(var0 == 6696) {
                                    var3 = class83.intStack[--class165.intStackSize];
                                    var11 = World.field1300[var3];
                                    if(var11 == null) {
                                       class83.intStack[++class165.intStackSize - 1] = -1;
                                    } else {
                                       class83.intStack[++class165.intStackSize - 1] = var11.spriteId;
                                    }

                                    return 1;
                                 } else if(var0 == 6697) {
                                    class83.intStack[++class165.intStackSize - 1] = class83.field1352.field600;
                                    return 1;
                                 } else if(var0 == 6698) {
                                    class83.intStack[++class165.intStackSize - 1] = class83.field1352.field596.method3955();
                                    return 1;
                                 } else if(var0 == 6699) {
                                    class83.intStack[++class165.intStackSize - 1] = class83.field1352.field597.method3955();
                                    return 1;
                                 } else {
                                    return 2;
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "486785561"
   )
   public static int method3843(int var0) {
      Varbit var1 = XGrandExchangeOffer.method122(var0);
      int var2 = var1.configId;
      int var3 = var1.leastSignificantBit;
      int var4 = var1.mostSignificantBit;
      int var5 = class211.field2615[var4 - var3];
      return class211.widgetSettings[var2] >> var3 & var5;
   }
}
