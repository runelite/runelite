import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
public class class218 {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "1249982002"
   )
   static int method4066(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 6600) {
         var3 = class35.plane;
         int var13 = (XGrandExchangeOffer.localPlayer.x >> 7) + class47.baseX;
         int var5 = (XGrandExchangeOffer.localPlayer.y >> 7) + class44.baseY;
         WorldMapType3.method225().method5229(var3, var13, var5, true);
         return 1;
      } else {
         WorldMapData var15;
         if(var0 == 6601) {
            var3 = class84.intStack[--class84.intStackSize];
            String var20 = "";
            var15 = WorldMapType3.method225().method5251(var3);
            if(var15 != null) {
               var20 = var15.method322();
            }

            class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var20;
            return 1;
         } else if(var0 == 6602) {
            var3 = class84.intStack[--class84.intStackSize];
            WorldMapType3.method225().method5236(var3);
            return 1;
         } else if(var0 == 6603) {
            class84.intStack[++class84.intStackSize - 1] = WorldMapType3.method225().method5384();
            return 1;
         } else if(var0 == 6604) {
            var3 = class84.intStack[--class84.intStackSize];
            WorldMapType3.method225().method5410(var3);
            return 1;
         } else if(var0 == 6605) {
            class84.intStack[++class84.intStackSize - 1] = WorldMapType3.method225().method5250()?1:0;
            return 1;
         } else {
            Coordinates var19;
            if(var0 == 6606) {
               var19 = new Coordinates(class84.intStack[--class84.intStackSize]);
               WorldMapType3.method225().method5252(var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6607) {
               var19 = new Coordinates(class84.intStack[--class84.intStackSize]);
               WorldMapType3.method225().method5253(var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6608) {
               var19 = new Coordinates(class84.intStack[--class84.intStackSize]);
               WorldMapType3.method225().method5254(var19.plane, var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6609) {
               var19 = new Coordinates(class84.intStack[--class84.intStackSize]);
               WorldMapType3.method225().method5255(var19.plane, var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6610) {
               class84.intStack[++class84.intStackSize - 1] = WorldMapType3.method225().method5256();
               class84.intStack[++class84.intStackSize - 1] = WorldMapType3.method225().method5312();
               return 1;
            } else {
               WorldMapData var17;
               if(var0 == 6611) {
                  var3 = class84.intStack[--class84.intStackSize];
                  var17 = WorldMapType3.method225().method5251(var3);
                  if(var17 == null) {
                     class84.intStack[++class84.intStackSize - 1] = 0;
                  } else {
                     class84.intStack[++class84.intStackSize - 1] = var17.method317().method3941();
                  }

                  return 1;
               } else if(var0 == 6612) {
                  var3 = class84.intStack[--class84.intStackSize];
                  var17 = WorldMapType3.method225().method5251(var3);
                  if(var17 == null) {
                     class84.intStack[++class84.intStackSize - 1] = 0;
                     class84.intStack[++class84.intStackSize - 1] = 0;
                  } else {
                     class84.intStack[++class84.intStackSize - 1] = (var17.method354() - var17.method310() + 1) * 64;
                     class84.intStack[++class84.intStackSize - 1] = (var17.method356() - var17.method327() + 1) * 64;
                  }

                  return 1;
               } else if(var0 == 6613) {
                  var3 = class84.intStack[--class84.intStackSize];
                  var17 = WorldMapType3.method225().method5251(var3);
                  if(var17 == null) {
                     class84.intStack[++class84.intStackSize - 1] = 0;
                     class84.intStack[++class84.intStackSize - 1] = 0;
                     class84.intStack[++class84.intStackSize - 1] = 0;
                     class84.intStack[++class84.intStackSize - 1] = 0;
                  } else {
                     class84.intStack[++class84.intStackSize - 1] = var17.method310() * 64;
                     class84.intStack[++class84.intStackSize - 1] = var17.method327() * 64;
                     class84.intStack[++class84.intStackSize - 1] = var17.method354() * 64 + 64 - 1;
                     class84.intStack[++class84.intStackSize - 1] = var17.method356() * 64 + 64 - 1;
                  }

                  return 1;
               } else if(var0 == 6614) {
                  var3 = class84.intStack[--class84.intStackSize];
                  var17 = WorldMapType3.method225().method5251(var3);
                  if(var17 == null) {
                     class84.intStack[++class84.intStackSize - 1] = -1;
                  } else {
                     class84.intStack[++class84.intStackSize - 1] = var17.method309();
                  }

                  return 1;
               } else if(var0 == 6615) {
                  var19 = WorldMapType3.method225().method5258();
                  if(var19 == null) {
                     class84.intStack[++class84.intStackSize - 1] = -1;
                     class84.intStack[++class84.intStackSize - 1] = -1;
                  } else {
                     class84.intStack[++class84.intStackSize - 1] = var19.worldX;
                     class84.intStack[++class84.intStackSize - 1] = var19.worldY;
                  }

                  return 1;
               } else if(var0 == 6616) {
                  class84.intStack[++class84.intStackSize - 1] = WorldMapType3.method225().method5237();
                  return 1;
               } else if(var0 == 6617) {
                  var19 = new Coordinates(class84.intStack[--class84.intStackSize]);
                  var17 = WorldMapType3.method225().method5342();
                  if(var17 == null) {
                     class84.intStack[++class84.intStackSize - 1] = -1;
                     class84.intStack[++class84.intStackSize - 1] = -1;
                     return 1;
                  } else {
                     int[] var18 = var17.method368(var19.plane, var19.worldX, var19.worldY);
                     if(var18 == null) {
                        class84.intStack[++class84.intStackSize - 1] = -1;
                        class84.intStack[++class84.intStackSize - 1] = -1;
                     } else {
                        class84.intStack[++class84.intStackSize - 1] = var18[0];
                        class84.intStack[++class84.intStackSize - 1] = var18[1];
                     }

                     return 1;
                  }
               } else {
                  Coordinates var11;
                  if(var0 == 6618) {
                     var19 = new Coordinates(class84.intStack[--class84.intStackSize]);
                     var17 = WorldMapType3.method225().method5342();
                     if(var17 == null) {
                        class84.intStack[++class84.intStackSize - 1] = -1;
                        class84.intStack[++class84.intStackSize - 1] = -1;
                        return 1;
                     } else {
                        var11 = var17.method302(var19.worldX, var19.worldY);
                        if(var11 == null) {
                           class84.intStack[++class84.intStackSize - 1] = -1;
                        } else {
                           class84.intStack[++class84.intStackSize - 1] = var11.method3941();
                        }

                        return 1;
                     }
                  } else {
                     int var6;
                     int var7;
                     int var8;
                     Coordinates var9;
                     Coordinates var16;
                     if(var0 == 6619) {
                        class84.intStackSize -= 2;
                        var3 = class84.intStack[class84.intStackSize];
                        var16 = new Coordinates(class84.intStack[class84.intStackSize + 1]);
                        var15 = WorldMapType3.method225().method5251(var3);
                        var6 = XGrandExchangeOffer.localPlayer.field918;
                        var7 = (XGrandExchangeOffer.localPlayer.x >> 7) + class47.baseX;
                        var8 = (XGrandExchangeOffer.localPlayer.y >> 7) + class44.baseY;
                        var9 = new Coordinates(var6, var7, var8);
                        WorldMapType3.method225().method5231(var15, var9, var16, false);
                        return 1;
                     } else if(var0 == 6620) {
                        class84.intStackSize -= 2;
                        var3 = class84.intStack[class84.intStackSize];
                        var16 = new Coordinates(class84.intStack[class84.intStackSize + 1]);
                        var15 = WorldMapType3.method225().method5251(var3);
                        var6 = XGrandExchangeOffer.localPlayer.field918;
                        var7 = (XGrandExchangeOffer.localPlayer.x >> 7) + class47.baseX;
                        var8 = (XGrandExchangeOffer.localPlayer.y >> 7) + class44.baseY;
                        var9 = new Coordinates(var6, var7, var8);
                        WorldMapType3.method225().method5231(var15, var9, var16, true);
                        return 1;
                     } else if(var0 == 6621) {
                        class84.intStackSize -= 2;
                        var3 = class84.intStack[class84.intStackSize];
                        var16 = new Coordinates(class84.intStack[class84.intStackSize + 1]);
                        var15 = WorldMapType3.method225().method5251(var3);
                        if(var15 == null) {
                           class84.intStack[++class84.intStackSize - 1] = 0;
                           return 1;
                        } else {
                           class84.intStack[++class84.intStackSize - 1] = var15.method299(var16.plane, var16.worldX, var16.worldY)?1:0;
                           return 1;
                        }
                     } else if(var0 == 6622) {
                        class84.intStack[++class84.intStackSize - 1] = WorldMapType3.method225().method5341();
                        class84.intStack[++class84.intStackSize - 1] = WorldMapType3.method225().method5238();
                        return 1;
                     } else if(var0 == 6623) {
                        var19 = new Coordinates(class84.intStack[--class84.intStackSize]);
                        var17 = WorldMapType3.method225().method5271(var19.plane, var19.worldX, var19.worldY);
                        if(var17 == null) {
                           class84.intStack[++class84.intStackSize - 1] = -1;
                        } else {
                           class84.intStack[++class84.intStackSize - 1] = var17.method311();
                        }

                        return 1;
                     } else if(var0 == 6624) {
                        WorldMapType3.method225().method5261(class84.intStack[--class84.intStackSize]);
                        return 1;
                     } else if(var0 == 6625) {
                        WorldMapType3.method225().method5351();
                        return 1;
                     } else if(var0 == 6626) {
                        WorldMapType3.method225().method5382(class84.intStack[--class84.intStackSize]);
                        return 1;
                     } else if(var0 == 6627) {
                        WorldMapType3.method225().method5264();
                        return 1;
                     } else {
                        boolean var14;
                        if(var0 == 6628) {
                           var14 = class84.intStack[--class84.intStackSize] == 1;
                           WorldMapType3.method225().method5265(var14);
                           return 1;
                        } else if(var0 == 6629) {
                           var3 = class84.intStack[--class84.intStackSize];
                           WorldMapType3.method225().method5305(var3);
                           return 1;
                        } else if(var0 == 6630) {
                           var3 = class84.intStack[--class84.intStackSize];
                           WorldMapType3.method225().method5267(var3);
                           return 1;
                        } else if(var0 == 6631) {
                           WorldMapType3.method225().method5346();
                           return 1;
                        } else if(var0 == 6632) {
                           var14 = class84.intStack[--class84.intStackSize] == 1;
                           WorldMapType3.method225().method5269(var14);
                           return 1;
                        } else {
                           boolean var4;
                           if(var0 == 6633) {
                              class84.intStackSize -= 2;
                              var3 = class84.intStack[class84.intStackSize];
                              var4 = 1 == class84.intStack[class84.intStackSize + 1];
                              WorldMapType3.method225().method5299(var3, var4);
                              return 1;
                           } else if(var0 == 6634) {
                              class84.intStackSize -= 2;
                              var3 = class84.intStack[class84.intStackSize];
                              var4 = 1 == class84.intStack[class84.intStackSize + 1];
                              WorldMapType3.method225().method5266(var3, var4);
                              return 1;
                           } else if(var0 == 6635) {
                              class84.intStack[++class84.intStackSize - 1] = WorldMapType3.method225().method5337()?1:0;
                              return 1;
                           } else if(var0 == 6636) {
                              var3 = class84.intStack[--class84.intStackSize];
                              class84.intStack[++class84.intStackSize - 1] = WorldMapType3.method225().method5372(var3)?1:0;
                              return 1;
                           } else if(var0 == 6637) {
                              var3 = class84.intStack[--class84.intStackSize];
                              class84.intStack[++class84.intStackSize - 1] = WorldMapType3.method225().method5259(var3)?1:0;
                              return 1;
                           } else if(var0 == 6638) {
                              class84.intStackSize -= 2;
                              var3 = class84.intStack[class84.intStackSize];
                              var16 = new Coordinates(class84.intStack[class84.intStackSize + 1]);
                              var11 = WorldMapType3.method225().method5399(var3, var16);
                              if(var11 == null) {
                                 class84.intStack[++class84.intStackSize - 1] = -1;
                              } else {
                                 class84.intStack[++class84.intStackSize - 1] = var11.method3941();
                              }

                              return 1;
                           } else {
                              class39 var12;
                              if(var0 == 6639) {
                                 var12 = WorldMapType3.method225().method5278();
                                 if(var12 == null) {
                                    class84.intStack[++class84.intStackSize - 1] = -1;
                                    class84.intStack[++class84.intStackSize - 1] = -1;
                                 } else {
                                    class84.intStack[++class84.intStackSize - 1] = var12.field544;
                                    class84.intStack[++class84.intStackSize - 1] = var12.field542.method3941();
                                 }

                                 return 1;
                              } else if(var0 == 6640) {
                                 var12 = WorldMapType3.method225().method5279();
                                 if(var12 == null) {
                                    class84.intStack[++class84.intStackSize - 1] = -1;
                                    class84.intStack[++class84.intStackSize - 1] = -1;
                                 } else {
                                    class84.intStack[++class84.intStackSize - 1] = var12.field544;
                                    class84.intStack[++class84.intStackSize - 1] = var12.field542.method3941();
                                 }

                                 return 1;
                              } else {
                                 Area var10;
                                 if(var0 == 6693) {
                                    var3 = class84.intStack[--class84.intStackSize];
                                    var10 = Area.field3284[var3];
                                    if(var10.name == null) {
                                       class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                                    } else {
                                       class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var10.name;
                                    }

                                    return 1;
                                 } else if(var0 == 6694) {
                                    var3 = class84.intStack[--class84.intStackSize];
                                    var10 = Area.field3284[var3];
                                    class84.intStack[++class84.intStackSize - 1] = var10.field3281;
                                    return 1;
                                 } else if(var0 == 6695) {
                                    var3 = class84.intStack[--class84.intStackSize];
                                    var10 = Area.field3284[var3];
                                    if(var10 == null) {
                                       class84.intStack[++class84.intStackSize - 1] = -1;
                                    } else {
                                       class84.intStack[++class84.intStackSize - 1] = var10.field3296;
                                    }

                                    return 1;
                                 } else if(var0 == 6696) {
                                    var3 = class84.intStack[--class84.intStackSize];
                                    var10 = Area.field3284[var3];
                                    if(var10 == null) {
                                       class84.intStack[++class84.intStackSize - 1] = -1;
                                    } else {
                                       class84.intStack[++class84.intStackSize - 1] = var10.spriteId;
                                    }

                                    return 1;
                                 } else if(var0 == 6697) {
                                    class84.intStack[++class84.intStackSize - 1] = SoundTask.field1666.field611;
                                    return 1;
                                 } else if(var0 == 6698) {
                                    class84.intStack[++class84.intStackSize - 1] = SoundTask.field1666.field602.method3941();
                                    return 1;
                                 } else if(var0 == 6699) {
                                    class84.intStack[++class84.intStackSize - 1] = SoundTask.field1666.field609.method3941();
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "551718684"
   )
   public static int method4051() {
      return ++MouseInput.mouseIdleTicks - 1;
   }
}
