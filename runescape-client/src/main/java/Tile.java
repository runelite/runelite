import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "[Lla;"
   )
   @Export("mapDots")
   static SpritePixels[] mapDots;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1403480605
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1551941791
   )
   @Export("x")
   int x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1677185025
   )
   @Export("y")
   int y;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -484572595
   )
   @Export("renderLevel")
   int renderLevel;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lei;"
   )
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ldv;"
   )
   @Export("overlay")
   SceneTileModel overlay;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lel;"
   )
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ldx;"
   )
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -416126809
   )
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Leo;"
   )
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("c")
   @Export("entityFlags")
   int[] entityFlags;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -208102625
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1546095017
   )
   @Export("physicalLevel")
   int physicalLevel;
   @ObfuscatedName("j")
   @Export("draw")
   boolean draw;
   @ObfuscatedName("k")
   @Export("visible")
   boolean visible;
   @ObfuscatedName("z")
   @Export("drawEntities")
   boolean drawEntities;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1632812017
   )
   @Export("wallCullDirection")
   int wallCullDirection;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -719997551
   )
   @Export("wallUncullDirection")
   int wallUncullDirection;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1534470819
   )
   @Export("wallCullOppositeDirection")
   int wallCullOppositeDirection;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1127237599
   )
   @Export("wallDrawFlags")
   int wallDrawFlags;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   @Export("bridge")
   Tile bridge;

   Tile(int var1, int var2, int var3) {
      this.objects = new GameObject[5];
      this.entityFlags = new int[5];
      this.flags = 0;
      this.renderLevel = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static void method2682() {
      if(class90.username == null || class90.username.length() <= 0) {
         if(MapIcon.preferences.rememberedUsername != null) {
            class90.username = MapIcon.preferences.rememberedUsername;
            class90.Login_isUsernameRemembered = true;
         } else {
            class90.Login_isUsernameRemembered = false;
         }

      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(ILcj;ZB)I",
      garbageValue = "115"
   )
   static int method2683(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 6600) {
         var3 = Ignore.plane;
         int var9 = (WorldMapData.localPlayer.x >> 7) + class38.baseX;
         int var5 = (WorldMapData.localPlayer.y >> 7) + PlayerComposition.baseY;
         class155.method3159().method6072(var3, var9, var5, true);
         return 1;
      } else {
         WorldMapData var11;
         if(var0 == 6601) {
            var3 = class81.intStack[--class5.intStackSize];
            String var16 = "";
            var11 = class155.method3159().getWorldMapDataByFileId(var3);
            if(var11 != null) {
               var16 = var11.getName();
            }

            class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var16;
            return 1;
         } else if(var0 == 6602) {
            var3 = class81.intStack[--class5.intStackSize];
            class155.method3159().method6160(var3);
            return 1;
         } else if(var0 == 6603) {
            class81.intStack[++class5.intStackSize - 1] = class155.method3159().method6005();
            return 1;
         } else if(var0 == 6604) {
            var3 = class81.intStack[--class5.intStackSize];
            class155.method3159().method6012(var3);
            return 1;
         } else if(var0 == 6605) {
            class81.intStack[++class5.intStackSize - 1] = class155.method3159().method6050()?1:0;
            return 1;
         } else {
            Coordinates var15;
            if(var0 == 6606) {
               var15 = new Coordinates(class81.intStack[--class5.intStackSize]);
               class155.method3159().method6047(var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6607) {
               var15 = new Coordinates(class81.intStack[--class5.intStackSize]);
               class155.method3159().method6019(var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6608) {
               var15 = new Coordinates(class81.intStack[--class5.intStackSize]);
               class155.method3159().method6020(var15.plane, var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6609) {
               var15 = new Coordinates(class81.intStack[--class5.intStackSize]);
               class155.method3159().method6021(var15.plane, var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6610) {
               class81.intStack[++class5.intStackSize - 1] = class155.method3159().method6132();
               class81.intStack[++class5.intStackSize - 1] = class155.method3159().method6023();
               return 1;
            } else {
               WorldMapData var13;
               if(var0 == 6611) {
                  var3 = class81.intStack[--class5.intStackSize];
                  var13 = class155.method3159().getWorldMapDataByFileId(var3);
                  if(var13 == null) {
                     class81.intStack[++class5.intStackSize - 1] = 0;
                  } else {
                     class81.intStack[++class5.intStackSize - 1] = var13.method360().bitpack();
                  }

                  return 1;
               } else if(var0 == 6612) {
                  var3 = class81.intStack[--class5.intStackSize];
                  var13 = class155.method3159().getWorldMapDataByFileId(var3);
                  if(var13 == null) {
                     class81.intStack[++class5.intStackSize - 1] = 0;
                     class81.intStack[++class5.intStackSize - 1] = 0;
                  } else {
                     class81.intStack[++class5.intStackSize - 1] = (var13.method304() - var13.getMinX() + 1) * 64;
                     class81.intStack[++class5.intStackSize - 1] = (var13.method306() - var13.getMinY() + 1) * 64;
                  }

                  return 1;
               } else if(var0 == 6613) {
                  var3 = class81.intStack[--class5.intStackSize];
                  var13 = class155.method3159().getWorldMapDataByFileId(var3);
                  if(var13 == null) {
                     class81.intStack[++class5.intStackSize - 1] = 0;
                     class81.intStack[++class5.intStackSize - 1] = 0;
                     class81.intStack[++class5.intStackSize - 1] = 0;
                     class81.intStack[++class5.intStackSize - 1] = 0;
                  } else {
                     class81.intStack[++class5.intStackSize - 1] = var13.getMinX() * 64;
                     class81.intStack[++class5.intStackSize - 1] = var13.getMinY() * 64;
                     class81.intStack[++class5.intStackSize - 1] = var13.method304() * 64 + 64 - 1;
                     class81.intStack[++class5.intStackSize - 1] = var13.method306() * 64 + 64 - 1;
                  }

                  return 1;
               } else if(var0 == 6614) {
                  var3 = class81.intStack[--class5.intStackSize];
                  var13 = class155.method3159().getWorldMapDataByFileId(var3);
                  if(var13 == null) {
                     class81.intStack[++class5.intStackSize - 1] = -1;
                  } else {
                     class81.intStack[++class5.intStackSize - 1] = var13.method367();
                  }

                  return 1;
               } else if(var0 == 6615) {
                  var15 = class155.method3159().method6024();
                  if(var15 == null) {
                     class81.intStack[++class5.intStackSize - 1] = -1;
                     class81.intStack[++class5.intStackSize - 1] = -1;
                  } else {
                     class81.intStack[++class5.intStackSize - 1] = var15.worldX;
                     class81.intStack[++class5.intStackSize - 1] = var15.worldY;
                  }

                  return 1;
               } else if(var0 == 6616) {
                  class81.intStack[++class5.intStackSize - 1] = class155.method3159().method6002();
                  return 1;
               } else if(var0 == 6617) {
                  var15 = new Coordinates(class81.intStack[--class5.intStackSize]);
                  var13 = class155.method3159().method6107();
                  if(var13 == null) {
                     class81.intStack[++class5.intStackSize - 1] = -1;
                     class81.intStack[++class5.intStackSize - 1] = -1;
                     return 1;
                  } else {
                     int[] var14 = var13.method299(var15.plane, var15.worldX, var15.worldY);
                     if(var14 == null) {
                        class81.intStack[++class5.intStackSize - 1] = -1;
                        class81.intStack[++class5.intStackSize - 1] = -1;
                     } else {
                        class81.intStack[++class5.intStackSize - 1] = var14[0];
                        class81.intStack[++class5.intStackSize - 1] = var14[1];
                     }

                     return 1;
                  }
               } else {
                  Coordinates var7;
                  if(var0 == 6618) {
                     var15 = new Coordinates(class81.intStack[--class5.intStackSize]);
                     var13 = class155.method3159().method6107();
                     if(var13 == null) {
                        class81.intStack[++class5.intStackSize - 1] = -1;
                        class81.intStack[++class5.intStackSize - 1] = -1;
                        return 1;
                     } else {
                        var7 = var13.method296(var15.worldX, var15.worldY);
                        if(var7 == null) {
                           class81.intStack[++class5.intStackSize - 1] = -1;
                        } else {
                           class81.intStack[++class5.intStackSize - 1] = var7.bitpack();
                        }

                        return 1;
                     }
                  } else {
                     Coordinates var12;
                     if(var0 == 6619) {
                        class5.intStackSize -= 2;
                        var3 = class81.intStack[class5.intStackSize];
                        var12 = new Coordinates(class81.intStack[class5.intStackSize + 1]);
                        WorldMapType2.method578(var3, var12, false);
                        return 1;
                     } else if(var0 == 6620) {
                        class5.intStackSize -= 2;
                        var3 = class81.intStack[class5.intStackSize];
                        var12 = new Coordinates(class81.intStack[class5.intStackSize + 1]);
                        WorldMapType2.method578(var3, var12, true);
                        return 1;
                     } else if(var0 == 6621) {
                        class5.intStackSize -= 2;
                        var3 = class81.intStack[class5.intStackSize];
                        var12 = new Coordinates(class81.intStack[class5.intStackSize + 1]);
                        var11 = class155.method3159().getWorldMapDataByFileId(var3);
                        if(var11 == null) {
                           class81.intStack[++class5.intStackSize - 1] = 0;
                           return 1;
                        } else {
                           class81.intStack[++class5.intStackSize - 1] = var11.containsCoord(var12.plane, var12.worldX, var12.worldY)?1:0;
                           return 1;
                        }
                     } else if(var0 == 6622) {
                        class81.intStack[++class5.intStackSize - 1] = class155.method3159().method6025();
                        class81.intStack[++class5.intStackSize - 1] = class155.method3159().method6026();
                        return 1;
                     } else if(var0 == 6623) {
                        var15 = new Coordinates(class81.intStack[--class5.intStackSize]);
                        var13 = class155.method3159().getWorldMapDataContainingCoord(var15.plane, var15.worldX, var15.worldY);
                        if(var13 == null) {
                           class81.intStack[++class5.intStackSize - 1] = -1;
                        } else {
                           class81.intStack[++class5.intStackSize - 1] = var13.getFileId();
                        }

                        return 1;
                     } else if(var0 == 6624) {
                        class155.method3159().method6027(class81.intStack[--class5.intStackSize]);
                        return 1;
                     } else if(var0 == 6625) {
                        class155.method3159().method6028();
                        return 1;
                     } else if(var0 == 6626) {
                        class155.method3159().method6030(class81.intStack[--class5.intStackSize]);
                        return 1;
                     } else if(var0 == 6627) {
                        class155.method3159().method6123();
                        return 1;
                     } else {
                        boolean var10;
                        if(var0 == 6628) {
                           var10 = class81.intStack[--class5.intStackSize] == 1;
                           class155.method3159().method6031(var10);
                           return 1;
                        } else if(var0 == 6629) {
                           var3 = class81.intStack[--class5.intStackSize];
                           class155.method3159().method6071(var3);
                           return 1;
                        } else if(var0 == 6630) {
                           var3 = class81.intStack[--class5.intStackSize];
                           class155.method3159().method6120(var3);
                           return 1;
                        } else if(var0 == 6631) {
                           class155.method3159().method6034();
                           return 1;
                        } else if(var0 == 6632) {
                           var10 = class81.intStack[--class5.intStackSize] == 1;
                           class155.method3159().method6149(var10);
                           return 1;
                        } else {
                           boolean var4;
                           if(var0 == 6633) {
                              class5.intStackSize -= 2;
                              var3 = class81.intStack[class5.intStackSize];
                              var4 = class81.intStack[class5.intStackSize + 1] == 1;
                              class155.method3159().method6036(var3, var4);
                              return 1;
                           } else if(var0 == 6634) {
                              class5.intStackSize -= 2;
                              var3 = class81.intStack[class5.intStackSize];
                              var4 = class81.intStack[class5.intStackSize + 1] == 1;
                              class155.method3159().method6037(var3, var4);
                              return 1;
                           } else if(var0 == 6635) {
                              class81.intStack[++class5.intStackSize - 1] = class155.method3159().method6038()?1:0;
                              return 1;
                           } else if(var0 == 6636) {
                              var3 = class81.intStack[--class5.intStackSize];
                              class81.intStack[++class5.intStackSize - 1] = class155.method3159().method6093(var3)?1:0;
                              return 1;
                           } else if(var0 == 6637) {
                              var3 = class81.intStack[--class5.intStackSize];
                              class81.intStack[++class5.intStackSize - 1] = class155.method3159().method6073(var3)?1:0;
                              return 1;
                           } else if(var0 == 6638) {
                              class5.intStackSize -= 2;
                              var3 = class81.intStack[class5.intStackSize];
                              var12 = new Coordinates(class81.intStack[class5.intStackSize + 1]);
                              var7 = class155.method3159().method6043(var3, var12);
                              if(var7 == null) {
                                 class81.intStack[++class5.intStackSize - 1] = -1;
                              } else {
                                 class81.intStack[++class5.intStackSize - 1] = var7.bitpack();
                              }

                              return 1;
                           } else {
                              MapIcon var8;
                              if(var0 == 6639) {
                                 var8 = class155.method3159().method6007();
                                 if(var8 == null) {
                                    class81.intStack[++class5.intStackSize - 1] = -1;
                                    class81.intStack[++class5.intStackSize - 1] = -1;
                                 } else {
                                    class81.intStack[++class5.intStackSize - 1] = var8.areaId;
                                    class81.intStack[++class5.intStackSize - 1] = var8.field510.bitpack();
                                 }

                                 return 1;
                              } else if(var0 == 6640) {
                                 var8 = class155.method3159().method6046();
                                 if(var8 == null) {
                                    class81.intStack[++class5.intStackSize - 1] = -1;
                                    class81.intStack[++class5.intStackSize - 1] = -1;
                                 } else {
                                    class81.intStack[++class5.intStackSize - 1] = var8.areaId;
                                    class81.intStack[++class5.intStackSize - 1] = var8.field510.bitpack();
                                 }

                                 return 1;
                              } else {
                                 Area var6;
                                 if(var0 == 6693) {
                                    var3 = class81.intStack[--class5.intStackSize];
                                    var6 = Area.mapAreaType[var3];
                                    if(var6.name == null) {
                                       class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
                                    } else {
                                       class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var6.name;
                                    }

                                    return 1;
                                 } else if(var0 == 6694) {
                                    var3 = class81.intStack[--class5.intStackSize];
                                    var6 = Area.mapAreaType[var3];
                                    class81.intStack[++class5.intStackSize - 1] = var6.field3462;
                                    return 1;
                                 } else if(var0 == 6695) {
                                    var3 = class81.intStack[--class5.intStackSize];
                                    var6 = Area.mapAreaType[var3];
                                    if(var6 == null) {
                                       class81.intStack[++class5.intStackSize - 1] = -1;
                                    } else {
                                       class81.intStack[++class5.intStackSize - 1] = var6.field3474;
                                    }

                                    return 1;
                                 } else if(var0 == 6696) {
                                    var3 = class81.intStack[--class5.intStackSize];
                                    var6 = Area.mapAreaType[var3];
                                    if(var6 == null) {
                                       class81.intStack[++class5.intStackSize - 1] = -1;
                                    } else {
                                       class81.intStack[++class5.intStackSize - 1] = var6.spriteId;
                                    }

                                    return 1;
                                 } else if(var0 == 6697) {
                                    class81.intStack[++class5.intStackSize - 1] = GrandExchangeEvents.scriptMapIconReference.areaId;
                                    return 1;
                                 } else if(var0 == 6698) {
                                    class81.intStack[++class5.intStackSize - 1] = GrandExchangeEvents.scriptMapIconReference.field568.bitpack();
                                    return 1;
                                 } else if(var0 == 6699) {
                                    class81.intStack[++class5.intStackSize - 1] = GrandExchangeEvents.scriptMapIconReference.field570.bitpack();
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
