import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class1 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   static final class1 field7;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   static final class1 field1;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   static final class1 field8;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   static final class1 field2;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   static final class1 field4;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   static final class1 field5;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   static final class1 field6;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 502601821
   )
   final int field0;

   static {
      field7 = new class1(1);
      field1 = new class1(3);
      field8 = new class1(5);
      field2 = new class1(4);
      field4 = new class1(6);
      field5 = new class1(0);
      field6 = new class1(2);
   }

   class1(int var1) {
      this.field0 = var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)Lln;",
      garbageValue = "-29"
   )
   public static class320 method1(int var0) {
      class320[] var1 = Ignore.method5386();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class320 var3 = var1[var2];
         if(var0 == var3.field3932) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "-1094703409"
   )
   static int method0(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 6600) {
         var3 = BoundingBox3DDrawMode.plane;
         int var9 = (SoundTaskDataProvider.localPlayer.x >> 7) + class138.baseX;
         int var5 = (SoundTaskDataProvider.localPlayer.y >> 7) + class23.baseY;
         class86.method1892().method6018(var3, var9, var5, true);
         return 1;
      } else {
         WorldMapData var11;
         if(var0 == 6601) {
            var3 = class81.intStack[--WorldComparator.intStackSize];
            String var16 = "";
            var11 = class86.method1892().getWorldMapDataByFileId(var3);
            if(var11 != null) {
               var16 = var11.getName();
            }

            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var16;
            return 1;
         } else if(var0 == 6602) {
            var3 = class81.intStack[--WorldComparator.intStackSize];
            class86.method1892().method6019(var3);
            return 1;
         } else if(var0 == 6603) {
            class81.intStack[++WorldComparator.intStackSize - 1] = class86.method1892().method6033();
            return 1;
         } else if(var0 == 6604) {
            var3 = class81.intStack[--WorldComparator.intStackSize];
            class86.method1892().method6030(var3);
            return 1;
         } else if(var0 == 6605) {
            class81.intStack[++WorldComparator.intStackSize - 1] = class86.method1892().method6035()?1:0;
            return 1;
         } else {
            Coordinates var15;
            if(var0 == 6606) {
               var15 = new Coordinates(class81.intStack[--WorldComparator.intStackSize]);
               class86.method1892().method6037(var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6607) {
               var15 = new Coordinates(class81.intStack[--WorldComparator.intStackSize]);
               class86.method1892().method6038(var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6608) {
               var15 = new Coordinates(class81.intStack[--WorldComparator.intStackSize]);
               class86.method1892().method6029(var15.plane, var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6609) {
               var15 = new Coordinates(class81.intStack[--WorldComparator.intStackSize]);
               class86.method1892().method6040(var15.plane, var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6610) {
               class81.intStack[++WorldComparator.intStackSize - 1] = class86.method1892().method6047();
               class81.intStack[++WorldComparator.intStackSize - 1] = class86.method1892().method6042();
               return 1;
            } else {
               WorldMapData var13;
               if(var0 == 6611) {
                  var3 = class81.intStack[--WorldComparator.intStackSize];
                  var13 = class86.method1892().getWorldMapDataByFileId(var3);
                  if(var13 == null) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                  } else {
                     class81.intStack[++WorldComparator.intStackSize - 1] = var13.method337().bitpack();
                  }

                  return 1;
               } else if(var0 == 6612) {
                  var3 = class81.intStack[--WorldComparator.intStackSize];
                  var13 = class86.method1892().getWorldMapDataByFileId(var3);
                  if(var13 == null) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                     class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                  } else {
                     class81.intStack[++WorldComparator.intStackSize - 1] = (var13.method360() - var13.getMinX() + 1) * 64;
                     class81.intStack[++WorldComparator.intStackSize - 1] = (var13.method331() - var13.getMinY() + 1) * 64;
                  }

                  return 1;
               } else if(var0 == 6613) {
                  var3 = class81.intStack[--WorldComparator.intStackSize];
                  var13 = class86.method1892().getWorldMapDataByFileId(var3);
                  if(var13 == null) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                     class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                     class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                     class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                  } else {
                     class81.intStack[++WorldComparator.intStackSize - 1] = var13.getMinX() * 64;
                     class81.intStack[++WorldComparator.intStackSize - 1] = var13.getMinY() * 64;
                     class81.intStack[++WorldComparator.intStackSize - 1] = var13.method360() * 64 + 64 - 1;
                     class81.intStack[++WorldComparator.intStackSize - 1] = var13.method331() * 64 + 64 - 1;
                  }

                  return 1;
               } else if(var0 == 6614) {
                  var3 = class81.intStack[--WorldComparator.intStackSize];
                  var13 = class86.method1892().getWorldMapDataByFileId(var3);
                  if(var13 == null) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                  } else {
                     class81.intStack[++WorldComparator.intStackSize - 1] = var13.method338();
                  }

                  return 1;
               } else if(var0 == 6615) {
                  var15 = class86.method1892().method6043();
                  if(var15 == null) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                     class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                  } else {
                     class81.intStack[++WorldComparator.intStackSize - 1] = var15.worldX;
                     class81.intStack[++WorldComparator.intStackSize - 1] = var15.worldY;
                  }

                  return 1;
               } else if(var0 == 6616) {
                  class81.intStack[++WorldComparator.intStackSize - 1] = class86.method1892().method6020();
                  return 1;
               } else if(var0 == 6617) {
                  var15 = new Coordinates(class81.intStack[--WorldComparator.intStackSize]);
                  var13 = class86.method1892().method6021();
                  if(var13 == null) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                     class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                     return 1;
                  } else {
                     int[] var14 = var13.method321(var15.plane, var15.worldX, var15.worldY);
                     if(var14 == null) {
                        class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                        class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                     } else {
                        class81.intStack[++WorldComparator.intStackSize - 1] = var14[0];
                        class81.intStack[++WorldComparator.intStackSize - 1] = var14[1];
                     }

                     return 1;
                  }
               } else {
                  Coordinates var7;
                  if(var0 == 6618) {
                     var15 = new Coordinates(class81.intStack[--WorldComparator.intStackSize]);
                     var13 = class86.method1892().method6021();
                     if(var13 == null) {
                        class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                        class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                        return 1;
                     } else {
                        var7 = var13.method322(var15.worldX, var15.worldY);
                        if(var7 == null) {
                           class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                        } else {
                           class81.intStack[++WorldComparator.intStackSize - 1] = var7.bitpack();
                        }

                        return 1;
                     }
                  } else {
                     Coordinates var12;
                     if(var0 == 6619) {
                        WorldComparator.intStackSize -= 2;
                        var3 = class81.intStack[WorldComparator.intStackSize];
                        var12 = new Coordinates(class81.intStack[WorldComparator.intStackSize + 1]);
                        WorldMapDecoration.method310(var3, var12, false);
                        return 1;
                     } else if(var0 == 6620) {
                        WorldComparator.intStackSize -= 2;
                        var3 = class81.intStack[WorldComparator.intStackSize];
                        var12 = new Coordinates(class81.intStack[WorldComparator.intStackSize + 1]);
                        WorldMapDecoration.method310(var3, var12, true);
                        return 1;
                     } else if(var0 == 6621) {
                        WorldComparator.intStackSize -= 2;
                        var3 = class81.intStack[WorldComparator.intStackSize];
                        var12 = new Coordinates(class81.intStack[WorldComparator.intStackSize + 1]);
                        var11 = class86.method1892().getWorldMapDataByFileId(var3);
                        if(var11 == null) {
                           class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                           return 1;
                        } else {
                           class81.intStack[++WorldComparator.intStackSize - 1] = var11.containsCoord(var12.plane, var12.worldX, var12.worldY)?1:0;
                           return 1;
                        }
                     } else if(var0 == 6622) {
                        class81.intStack[++WorldComparator.intStackSize - 1] = class86.method1892().method6044();
                        class81.intStack[++WorldComparator.intStackSize - 1] = class86.method1892().method6045();
                        return 1;
                     } else if(var0 == 6623) {
                        var15 = new Coordinates(class81.intStack[--WorldComparator.intStackSize]);
                        var13 = class86.method1892().getWorldMapDataContainingCoord(var15.plane, var15.worldX, var15.worldY);
                        if(var13 == null) {
                           class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                        } else {
                           class81.intStack[++WorldComparator.intStackSize - 1] = var13.getFileId();
                        }

                        return 1;
                     } else if(var0 == 6624) {
                        class86.method1892().method6118(class81.intStack[--WorldComparator.intStackSize]);
                        return 1;
                     } else if(var0 == 6625) {
                        class86.method1892().method6157();
                        return 1;
                     } else if(var0 == 6626) {
                        class86.method1892().method6048(class81.intStack[--WorldComparator.intStackSize]);
                        return 1;
                     } else if(var0 == 6627) {
                        class86.method1892().method6141();
                        return 1;
                     } else {
                        boolean var10;
                        if(var0 == 6628) {
                           var10 = class81.intStack[--WorldComparator.intStackSize] == 1;
                           class86.method1892().method6106(var10);
                           return 1;
                        } else if(var0 == 6629) {
                           var3 = class81.intStack[--WorldComparator.intStackSize];
                           class86.method1892().method6051(var3);
                           return 1;
                        } else if(var0 == 6630) {
                           var3 = class81.intStack[--WorldComparator.intStackSize];
                           class86.method1892().method6134(var3);
                           return 1;
                        } else if(var0 == 6631) {
                           class86.method1892().method6160();
                           return 1;
                        } else if(var0 == 6632) {
                           var10 = class81.intStack[--WorldComparator.intStackSize] == 1;
                           class86.method1892().method6054(var10);
                           return 1;
                        } else {
                           boolean var4;
                           if(var0 == 6633) {
                              WorldComparator.intStackSize -= 2;
                              var3 = class81.intStack[WorldComparator.intStackSize];
                              var4 = class81.intStack[WorldComparator.intStackSize + 1] == 1;
                              class86.method1892().method6055(var3, var4);
                              return 1;
                           } else if(var0 == 6634) {
                              WorldComparator.intStackSize -= 2;
                              var3 = class81.intStack[WorldComparator.intStackSize];
                              var4 = class81.intStack[WorldComparator.intStackSize + 1] == 1;
                              class86.method1892().method6056(var3, var4);
                              return 1;
                           } else if(var0 == 6635) {
                              class81.intStack[++WorldComparator.intStackSize - 1] = class86.method1892().method6074()?1:0;
                              return 1;
                           } else if(var0 == 6636) {
                              var3 = class81.intStack[--WorldComparator.intStackSize];
                              class81.intStack[++WorldComparator.intStackSize - 1] = class86.method1892().method6058(var3)?1:0;
                              return 1;
                           } else if(var0 == 6637) {
                              var3 = class81.intStack[--WorldComparator.intStackSize];
                              class81.intStack[++WorldComparator.intStackSize - 1] = class86.method1892().method6059(var3)?1:0;
                              return 1;
                           } else if(var0 == 6638) {
                              WorldComparator.intStackSize -= 2;
                              var3 = class81.intStack[WorldComparator.intStackSize];
                              var12 = new Coordinates(class81.intStack[WorldComparator.intStackSize + 1]);
                              var7 = class86.method1892().method6062(var3, var12);
                              if(var7 == null) {
                                 class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                              } else {
                                 class81.intStack[++WorldComparator.intStackSize - 1] = var7.bitpack();
                              }

                              return 1;
                           } else {
                              MapIcon var8;
                              if(var0 == 6639) {
                                 var8 = class86.method1892().method6064();
                                 if(var8 == null) {
                                    class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                                    class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                                 } else {
                                    class81.intStack[++WorldComparator.intStackSize - 1] = var8.areaId;
                                    class81.intStack[++WorldComparator.intStackSize - 1] = var8.field532.bitpack();
                                 }

                                 return 1;
                              } else if(var0 == 6640) {
                                 var8 = class86.method1892().method6065();
                                 if(var8 == null) {
                                    class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                                    class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                                 } else {
                                    class81.intStack[++WorldComparator.intStackSize - 1] = var8.areaId;
                                    class81.intStack[++WorldComparator.intStackSize - 1] = var8.field532.bitpack();
                                 }

                                 return 1;
                              } else {
                                 Area var6;
                                 if(var0 == 6693) {
                                    var3 = class81.intStack[--WorldComparator.intStackSize];
                                    var6 = Area.mapAreaType[var3];
                                    if(var6.name == null) {
                                       class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                    } else {
                                       class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var6.name;
                                    }

                                    return 1;
                                 } else if(var0 == 6694) {
                                    var3 = class81.intStack[--WorldComparator.intStackSize];
                                    var6 = Area.mapAreaType[var3];
                                    class81.intStack[++WorldComparator.intStackSize - 1] = var6.field3458;
                                    return 1;
                                 } else if(var0 == 6695) {
                                    var3 = class81.intStack[--WorldComparator.intStackSize];
                                    var6 = Area.mapAreaType[var3];
                                    if(var6 == null) {
                                       class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                                    } else {
                                       class81.intStack[++WorldComparator.intStackSize - 1] = var6.field3473;
                                    }

                                    return 1;
                                 } else if(var0 == 6696) {
                                    var3 = class81.intStack[--WorldComparator.intStackSize];
                                    var6 = Area.mapAreaType[var3];
                                    if(var6 == null) {
                                       class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                                    } else {
                                       class81.intStack[++WorldComparator.intStackSize - 1] = var6.spriteId;
                                    }

                                    return 1;
                                 } else if(var0 == 6697) {
                                    class81.intStack[++WorldComparator.intStackSize - 1] = class20.scriptMapIconReference.areaId;
                                    return 1;
                                 } else if(var0 == 6698) {
                                    class81.intStack[++WorldComparator.intStackSize - 1] = class20.scriptMapIconReference.field590.bitpack();
                                    return 1;
                                 } else if(var0 == 6699) {
                                    class81.intStack[++WorldComparator.intStackSize - 1] = class20.scriptMapIconReference.field591.bitpack();
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
