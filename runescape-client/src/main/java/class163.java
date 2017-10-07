import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public abstract class class163 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1043890977
   )
   public int field2317;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1668256127
   )
   public int field2318;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1590290837
   )
   public int field2319;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1986231923
   )
   public int field2320;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIILfq;I)Z",
      garbageValue = "1696204871"
   )
   protected abstract boolean vmethod3147(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(ILcv;ZS)I",
      garbageValue = "1831"
   )
   static int method3151(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 6600) {
         var3 = class5.plane;
         int var9 = (AbstractByteBuffer.localPlayer.x >> 7) + WallObject.baseX;
         int var5 = (AbstractByteBuffer.localPlayer.y >> 7) + Varcs.baseY;
         Friend.method1134().method5326(var3, var9, var5, true);
         return 1;
      } else {
         WorldMapData var11;
         if(var0 == 6601) {
            var3 = class81.intStack[--class81.intStackSize];
            String var16 = "";
            var11 = Friend.method1134().method5419(var3);
            if(var11 != null) {
               var16 = var11.method280();
            }

            class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var16;
            return 1;
         } else if(var0 == 6602) {
            var3 = class81.intStack[--class81.intStackSize];
            Friend.method1134().method5412(var3);
            return 1;
         } else if(var0 == 6603) {
            class81.intStack[++class81.intStackSize - 1] = Friend.method1134().method5338();
            return 1;
         } else if(var0 == 6604) {
            var3 = class81.intStack[--class81.intStackSize];
            Friend.method1134().method5335(var3);
            return 1;
         } else if(var0 == 6605) {
            class81.intStack[++class81.intStackSize - 1] = Friend.method1134().method5476()?1:0;
            return 1;
         } else {
            Coordinates var15;
            if(var0 == 6606) {
               var15 = new Coordinates(class81.intStack[--class81.intStackSize]);
               Friend.method1134().method5342(var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6607) {
               var15 = new Coordinates(class81.intStack[--class81.intStackSize]);
               Friend.method1134().method5381(var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6608) {
               var15 = new Coordinates(class81.intStack[--class81.intStackSize]);
               Friend.method1134().method5474(var15.plane, var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6609) {
               var15 = new Coordinates(class81.intStack[--class81.intStackSize]);
               Friend.method1134().method5345(var15.plane, var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6610) {
               class81.intStack[++class81.intStackSize - 1] = Friend.method1134().method5442();
               class81.intStack[++class81.intStackSize - 1] = Friend.method1134().method5347();
               return 1;
            } else {
               WorldMapData var13;
               if(var0 == 6611) {
                  var3 = class81.intStack[--class81.intStackSize];
                  var13 = Friend.method1134().method5419(var3);
                  if(var13 == null) {
                     class81.intStack[++class81.intStackSize - 1] = 0;
                  } else {
                     class81.intStack[++class81.intStackSize - 1] = var13.method326().method4058();
                  }

                  return 1;
               } else if(var0 == 6612) {
                  var3 = class81.intStack[--class81.intStackSize];
                  var13 = Friend.method1134().method5419(var3);
                  if(var13 == null) {
                     class81.intStack[++class81.intStackSize - 1] = 0;
                     class81.intStack[++class81.intStackSize - 1] = 0;
                  } else {
                     class81.intStack[++class81.intStackSize - 1] = (var13.method290() - var13.method316() + 1) * 64;
                     class81.intStack[++class81.intStackSize - 1] = (var13.method323() - var13.method333() + 1) * 64;
                  }

                  return 1;
               } else if(var0 == 6613) {
                  var3 = class81.intStack[--class81.intStackSize];
                  var13 = Friend.method1134().method5419(var3);
                  if(var13 == null) {
                     class81.intStack[++class81.intStackSize - 1] = 0;
                     class81.intStack[++class81.intStackSize - 1] = 0;
                     class81.intStack[++class81.intStackSize - 1] = 0;
                     class81.intStack[++class81.intStackSize - 1] = 0;
                  } else {
                     class81.intStack[++class81.intStackSize - 1] = var13.method316() * 64;
                     class81.intStack[++class81.intStackSize - 1] = var13.method333() * 64;
                     class81.intStack[++class81.intStackSize - 1] = var13.method290() * 64 + 64 - 1;
                     class81.intStack[++class81.intStackSize - 1] = var13.method323() * 64 + 64 - 1;
                  }

                  return 1;
               } else if(var0 == 6614) {
                  var3 = class81.intStack[--class81.intStackSize];
                  var13 = Friend.method1134().method5419(var3);
                  if(var13 == null) {
                     class81.intStack[++class81.intStackSize - 1] = -1;
                  } else {
                     class81.intStack[++class81.intStackSize - 1] = var13.method292();
                  }

                  return 1;
               } else if(var0 == 6615) {
                  var15 = Friend.method1134().method5348();
                  if(var15 == null) {
                     class81.intStack[++class81.intStackSize - 1] = -1;
                     class81.intStack[++class81.intStackSize - 1] = -1;
                  } else {
                     class81.intStack[++class81.intStackSize - 1] = var15.worldX;
                     class81.intStack[++class81.intStackSize - 1] = var15.worldY;
                  }

                  return 1;
               } else if(var0 == 6616) {
                  class81.intStack[++class81.intStackSize - 1] = Friend.method1134().method5328();
                  return 1;
               } else if(var0 == 6617) {
                  var15 = new Coordinates(class81.intStack[--class81.intStackSize]);
                  var13 = Friend.method1134().method5329();
                  if(var13 == null) {
                     class81.intStack[++class81.intStackSize - 1] = -1;
                     class81.intStack[++class81.intStackSize - 1] = -1;
                     return 1;
                  } else {
                     int[] var14 = var13.method285(var15.plane, var15.worldX, var15.worldY);
                     if(var14 == null) {
                        class81.intStack[++class81.intStackSize - 1] = -1;
                        class81.intStack[++class81.intStackSize - 1] = -1;
                     } else {
                        class81.intStack[++class81.intStackSize - 1] = var14[0];
                        class81.intStack[++class81.intStackSize - 1] = var14[1];
                     }

                     return 1;
                  }
               } else {
                  Coordinates var7;
                  if(var0 == 6618) {
                     var15 = new Coordinates(class81.intStack[--class81.intStackSize]);
                     var13 = Friend.method1134().method5329();
                     if(var13 == null) {
                        class81.intStack[++class81.intStackSize - 1] = -1;
                        class81.intStack[++class81.intStackSize - 1] = -1;
                        return 1;
                     } else {
                        var7 = var13.method275(var15.worldX, var15.worldY);
                        if(var7 == null) {
                           class81.intStack[++class81.intStackSize - 1] = -1;
                        } else {
                           class81.intStack[++class81.intStackSize - 1] = var7.method4058();
                        }

                        return 1;
                     }
                  } else {
                     Coordinates var12;
                     if(var0 == 6619) {
                        class81.intStackSize -= 2;
                        var3 = class81.intStack[class81.intStackSize];
                        var12 = new Coordinates(class81.intStack[class81.intStackSize + 1]);
                        class28.method219(var3, var12, false);
                        return 1;
                     } else if(var0 == 6620) {
                        class81.intStackSize -= 2;
                        var3 = class81.intStack[class81.intStackSize];
                        var12 = new Coordinates(class81.intStack[class81.intStackSize + 1]);
                        class28.method219(var3, var12, true);
                        return 1;
                     } else if(var0 == 6621) {
                        class81.intStackSize -= 2;
                        var3 = class81.intStack[class81.intStackSize];
                        var12 = new Coordinates(class81.intStack[class81.intStackSize + 1]);
                        var11 = Friend.method1134().method5419(var3);
                        if(var11 == null) {
                           class81.intStack[++class81.intStackSize - 1] = 0;
                           return 1;
                        } else {
                           class81.intStack[++class81.intStackSize - 1] = var11.method272(var12.plane, var12.worldX, var12.worldY)?1:0;
                           return 1;
                        }
                     } else if(var0 == 6622) {
                        class81.intStack[++class81.intStackSize - 1] = Friend.method1134().method5349();
                        class81.intStack[++class81.intStackSize - 1] = Friend.method1134().method5439();
                        return 1;
                     } else if(var0 == 6623) {
                        var15 = new Coordinates(class81.intStack[--class81.intStackSize]);
                        var13 = Friend.method1134().method5325(var15.plane, var15.worldX, var15.worldY);
                        if(var13 == null) {
                           class81.intStack[++class81.intStackSize - 1] = -1;
                        } else {
                           class81.intStack[++class81.intStackSize - 1] = var13.method313();
                        }

                        return 1;
                     } else if(var0 == 6624) {
                        Friend.method1134().method5445(class81.intStack[--class81.intStackSize]);
                        return 1;
                     } else if(var0 == 6625) {
                        Friend.method1134().method5352();
                        return 1;
                     } else if(var0 == 6626) {
                        Friend.method1134().method5492(class81.intStack[--class81.intStackSize]);
                        return 1;
                     } else if(var0 == 6627) {
                        Friend.method1134().method5354();
                        return 1;
                     } else {
                        boolean var10;
                        if(var0 == 6628) {
                           var10 = class81.intStack[--class81.intStackSize] == 1;
                           Friend.method1134().method5355(var10);
                           return 1;
                        } else if(var0 == 6629) {
                           var3 = class81.intStack[--class81.intStackSize];
                           Friend.method1134().method5356(var3);
                           return 1;
                        } else if(var0 == 6630) {
                           var3 = class81.intStack[--class81.intStackSize];
                           Friend.method1134().method5357(var3);
                           return 1;
                        } else if(var0 == 6631) {
                           Friend.method1134().method5358();
                           return 1;
                        } else if(var0 == 6632) {
                           var10 = class81.intStack[--class81.intStackSize] == 1;
                           Friend.method1134().method5388(var10);
                           return 1;
                        } else {
                           boolean var4;
                           if(var0 == 6633) {
                              class81.intStackSize -= 2;
                              var3 = class81.intStack[class81.intStackSize];
                              var4 = class81.intStack[class81.intStackSize + 1] == 1;
                              Friend.method1134().method5383(var3, var4);
                              return 1;
                           } else if(var0 == 6634) {
                              class81.intStackSize -= 2;
                              var3 = class81.intStack[class81.intStackSize];
                              var4 = class81.intStack[class81.intStackSize + 1] == 1;
                              Friend.method1134().method5361(var3, var4);
                              return 1;
                           } else if(var0 == 6635) {
                              class81.intStack[++class81.intStackSize - 1] = Friend.method1134().method5362()?1:0;
                              return 1;
                           } else if(var0 == 6636) {
                              var3 = class81.intStack[--class81.intStackSize];
                              class81.intStack[++class81.intStackSize - 1] = Friend.method1134().method5363(var3)?1:0;
                              return 1;
                           } else if(var0 == 6637) {
                              var3 = class81.intStack[--class81.intStackSize];
                              class81.intStack[++class81.intStackSize - 1] = Friend.method1134().method5364(var3)?1:0;
                              return 1;
                           } else if(var0 == 6638) {
                              class81.intStackSize -= 2;
                              var3 = class81.intStack[class81.intStackSize];
                              var12 = new Coordinates(class81.intStack[class81.intStackSize + 1]);
                              var7 = Friend.method1134().method5367(var3, var12);
                              if(var7 == null) {
                                 class81.intStack[++class81.intStackSize - 1] = -1;
                              } else {
                                 class81.intStack[++class81.intStackSize - 1] = var7.method4058();
                              }

                              return 1;
                           } else {
                              class39 var8;
                              if(var0 == 6639) {
                                 var8 = Friend.method1134().method5320();
                                 if(var8 == null) {
                                    class81.intStack[++class81.intStackSize - 1] = -1;
                                    class81.intStack[++class81.intStackSize - 1] = -1;
                                 } else {
                                    class81.intStack[++class81.intStackSize - 1] = var8.field552;
                                    class81.intStack[++class81.intStackSize - 1] = var8.field547.method4058();
                                 }

                                 return 1;
                              } else if(var0 == 6640) {
                                 var8 = Friend.method1134().method5370();
                                 if(var8 == null) {
                                    class81.intStack[++class81.intStackSize - 1] = -1;
                                    class81.intStack[++class81.intStackSize - 1] = -1;
                                 } else {
                                    class81.intStack[++class81.intStackSize - 1] = var8.field552;
                                    class81.intStack[++class81.intStackSize - 1] = var8.field547.method4058();
                                 }

                                 return 1;
                              } else {
                                 Area var6;
                                 if(var0 == 6693) {
                                    var3 = class81.intStack[--class81.intStackSize];
                                    var6 = class3.field24[var3];
                                    if(var6.name == null) {
                                       class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                                    } else {
                                       class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var6.name;
                                    }

                                    return 1;
                                 } else if(var0 == 6694) {
                                    var3 = class81.intStack[--class81.intStackSize];
                                    var6 = class3.field24[var3];
                                    class81.intStack[++class81.intStackSize - 1] = var6.field3298;
                                    return 1;
                                 } else if(var0 == 6695) {
                                    var3 = class81.intStack[--class81.intStackSize];
                                    var6 = class3.field24[var3];
                                    if(var6 == null) {
                                       class81.intStack[++class81.intStackSize - 1] = -1;
                                    } else {
                                       class81.intStack[++class81.intStackSize - 1] = var6.field3309;
                                    }

                                    return 1;
                                 } else if(var0 == 6696) {
                                    var3 = class81.intStack[--class81.intStackSize];
                                    var6 = class3.field24[var3];
                                    if(var6 == null) {
                                       class81.intStack[++class81.intStackSize - 1] = -1;
                                    } else {
                                       class81.intStack[++class81.intStackSize - 1] = var6.spriteId;
                                    }

                                    return 1;
                                 } else if(var0 == 6697) {
                                    class81.intStack[++class81.intStackSize - 1] = class147.field2194.field623;
                                    return 1;
                                 } else if(var0 == 6698) {
                                    class81.intStack[++class81.intStackSize - 1] = class147.field2194.field621.method4058();
                                    return 1;
                                 } else if(var0 == 6699) {
                                    class81.intStack[++class81.intStackSize - 1] = class147.field2194.field620.method4058();
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
}
