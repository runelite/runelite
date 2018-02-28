import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
public enum class277 implements Enumerated {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   field3624(0, 0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   field3627(1, 1),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   field3625(2, 2);

   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -543220471
   )
   public final int field3623;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1569753411
   )
   final int field3626;

   class277(int var3, int var4) {
      this.field3623 = var3;
      this.field3626 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1578971771"
   )
   public int rsOrdinal() {
      return this.field3626;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(ILca;ZI)I",
      garbageValue = "-1706130028"
   )
   static int method5061(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 6600) {
         var3 = class230.plane;
         int var13 = (OwnWorldComparator.localPlayer.x >> 7) + ScriptState.baseX;
         int var5 = (OwnWorldComparator.localPlayer.y >> 7) + WorldMapType1.baseY;
         World.method1681().method5972(var3, var13, var5, true);
         return 1;
      } else {
         WorldMapData var15;
         if(var0 == 6601) {
            var3 = class80.intStack[--class80.intStackSize];
            String var20 = "";
            var15 = World.method1681().method5994(var3);
            if(var15 != null) {
               var20 = var15.method315();
            }

            class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var20;
            return 1;
         } else if(var0 == 6602) {
            var3 = class80.intStack[--class80.intStackSize];
            World.method1681().method5977(var3);
            return 1;
         } else if(var0 == 6603) {
            class80.intStack[++class80.intStackSize - 1] = World.method1681().method5985();
            return 1;
         } else if(var0 == 6604) {
            var3 = class80.intStack[--class80.intStackSize];
            World.method1681().method5982(var3);
            return 1;
         } else if(var0 == 6605) {
            class80.intStack[++class80.intStackSize - 1] = World.method1681().method5987()?1:0;
            return 1;
         } else {
            Coordinates var19;
            if(var0 == 6606) {
               var19 = new Coordinates(class80.intStack[--class80.intStackSize]);
               World.method1681().method5989(var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6607) {
               var19 = new Coordinates(class80.intStack[--class80.intStackSize]);
               World.method1681().method6023(var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6608) {
               var19 = new Coordinates(class80.intStack[--class80.intStackSize]);
               World.method1681().method5991(var19.plane, var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6609) {
               var19 = new Coordinates(class80.intStack[--class80.intStackSize]);
               World.method1681().method5992(var19.plane, var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6610) {
               class80.intStack[++class80.intStackSize - 1] = World.method1681().method5993();
               class80.intStack[++class80.intStackSize - 1] = World.method1681().method6124();
               return 1;
            } else {
               WorldMapData var17;
               if(var0 == 6611) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var17 = World.method1681().method5994(var3);
                  if(var17 == null) {
                     class80.intStack[++class80.intStackSize - 1] = 0;
                  } else {
                     class80.intStack[++class80.intStackSize - 1] = var17.method320().bitpack();
                  }

                  return 1;
               } else if(var0 == 6612) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var17 = World.method1681().method5994(var3);
                  if(var17 == null) {
                     class80.intStack[++class80.intStackSize - 1] = 0;
                     class80.intStack[++class80.intStackSize - 1] = 0;
                  } else {
                     class80.intStack[++class80.intStackSize - 1] = (var17.method319() - var17.method318() + 1) * 64;
                     class80.intStack[++class80.intStackSize - 1] = (var17.method321() - var17.method355() + 1) * 64;
                  }

                  return 1;
               } else if(var0 == 6613) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var17 = World.method1681().method5994(var3);
                  if(var17 == null) {
                     class80.intStack[++class80.intStackSize - 1] = 0;
                     class80.intStack[++class80.intStackSize - 1] = 0;
                     class80.intStack[++class80.intStackSize - 1] = 0;
                     class80.intStack[++class80.intStackSize - 1] = 0;
                  } else {
                     class80.intStack[++class80.intStackSize - 1] = var17.method318() * 64;
                     class80.intStack[++class80.intStackSize - 1] = var17.method355() * 64;
                     class80.intStack[++class80.intStackSize - 1] = var17.method319() * 64 + 64 - 1;
                     class80.intStack[++class80.intStackSize - 1] = var17.method321() * 64 + 64 - 1;
                  }

                  return 1;
               } else if(var0 == 6614) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var17 = World.method1681().method5994(var3);
                  if(var17 == null) {
                     class80.intStack[++class80.intStackSize - 1] = -1;
                  } else {
                     class80.intStack[++class80.intStackSize - 1] = var17.method317();
                  }

                  return 1;
               } else if(var0 == 6615) {
                  var19 = World.method1681().method5995();
                  if(var19 == null) {
                     class80.intStack[++class80.intStackSize - 1] = -1;
                     class80.intStack[++class80.intStackSize - 1] = -1;
                  } else {
                     class80.intStack[++class80.intStackSize - 1] = var19.worldX;
                     class80.intStack[++class80.intStackSize - 1] = var19.worldY;
                  }

                  return 1;
               } else if(var0 == 6616) {
                  class80.intStack[++class80.intStackSize - 1] = World.method1681().method5974();
                  return 1;
               } else if(var0 == 6617) {
                  var19 = new Coordinates(class80.intStack[--class80.intStackSize]);
                  var17 = World.method1681().method6033();
                  if(var17 == null) {
                     class80.intStack[++class80.intStackSize - 1] = -1;
                     class80.intStack[++class80.intStackSize - 1] = -1;
                     return 1;
                  } else {
                     int[] var18 = var17.method329(var19.plane, var19.worldX, var19.worldY);
                     if(var18 == null) {
                        class80.intStack[++class80.intStackSize - 1] = -1;
                        class80.intStack[++class80.intStackSize - 1] = -1;
                     } else {
                        class80.intStack[++class80.intStackSize - 1] = var18[0];
                        class80.intStack[++class80.intStackSize - 1] = var18[1];
                     }

                     return 1;
                  }
               } else {
                  Coordinates var11;
                  if(var0 == 6618) {
                     var19 = new Coordinates(class80.intStack[--class80.intStackSize]);
                     var17 = World.method1681().method6033();
                     if(var17 == null) {
                        class80.intStack[++class80.intStackSize - 1] = -1;
                        class80.intStack[++class80.intStackSize - 1] = -1;
                        return 1;
                     } else {
                        var11 = var17.method310(var19.worldX, var19.worldY);
                        if(var11 == null) {
                           class80.intStack[++class80.intStackSize - 1] = -1;
                        } else {
                           class80.intStack[++class80.intStackSize - 1] = var11.bitpack();
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
                        class80.intStackSize -= 2;
                        var3 = class80.intStack[class80.intStackSize];
                        var16 = new Coordinates(class80.intStack[class80.intStackSize + 1]);
                        var15 = World.method1681().method5994(var3);
                        var6 = OwnWorldComparator.localPlayer.field802;
                        var7 = (OwnWorldComparator.localPlayer.x >> 7) + ScriptState.baseX;
                        var8 = (OwnWorldComparator.localPlayer.y >> 7) + WorldMapType1.baseY;
                        var9 = new Coordinates(var6, var7, var8);
                        World.method1681().method5978(var15, var9, var16, false);
                        return 1;
                     } else if(var0 == 6620) {
                        class80.intStackSize -= 2;
                        var3 = class80.intStack[class80.intStackSize];
                        var16 = new Coordinates(class80.intStack[class80.intStackSize + 1]);
                        var15 = World.method1681().method5994(var3);
                        var6 = OwnWorldComparator.localPlayer.field802;
                        var7 = (OwnWorldComparator.localPlayer.x >> 7) + ScriptState.baseX;
                        var8 = (OwnWorldComparator.localPlayer.y >> 7) + WorldMapType1.baseY;
                        var9 = new Coordinates(var6, var7, var8);
                        World.method1681().method5978(var15, var9, var16, true);
                        return 1;
                     } else if(var0 == 6621) {
                        class80.intStackSize -= 2;
                        var3 = class80.intStack[class80.intStackSize];
                        var16 = new Coordinates(class80.intStack[class80.intStackSize + 1]);
                        var15 = World.method1681().method5994(var3);
                        if(var15 == null) {
                           class80.intStack[++class80.intStackSize - 1] = 0;
                           return 1;
                        } else {
                           class80.intStack[++class80.intStackSize - 1] = var15.method332(var16.plane, var16.worldX, var16.worldY)?1:0;
                           return 1;
                        }
                     } else if(var0 == 6622) {
                        class80.intStack[++class80.intStackSize - 1] = World.method1681().method5996();
                        class80.intStack[++class80.intStackSize - 1] = World.method1681().method5981();
                        return 1;
                     } else if(var0 == 6623) {
                        var19 = new Coordinates(class80.intStack[--class80.intStackSize]);
                        var17 = World.method1681().method5971(var19.plane, var19.worldX, var19.worldY);
                        if(var17 == null) {
                           class80.intStack[++class80.intStackSize - 1] = -1;
                        } else {
                           class80.intStack[++class80.intStackSize - 1] = var17.method312();
                        }

                        return 1;
                     } else if(var0 == 6624) {
                        World.method1681().method5998(class80.intStack[--class80.intStackSize]);
                        return 1;
                     } else if(var0 == 6625) {
                        World.method1681().method6074();
                        return 1;
                     } else if(var0 == 6626) {
                        World.method1681().method6146(class80.intStack[--class80.intStackSize]);
                        return 1;
                     } else if(var0 == 6627) {
                        World.method1681().method6001();
                        return 1;
                     } else {
                        boolean var14;
                        if(var0 == 6628) {
                           var14 = class80.intStack[--class80.intStackSize] == 1;
                           World.method1681().method6081(var14);
                           return 1;
                        } else if(var0 == 6629) {
                           var3 = class80.intStack[--class80.intStackSize];
                           World.method1681().method6003(var3);
                           return 1;
                        } else if(var0 == 6630) {
                           var3 = class80.intStack[--class80.intStackSize];
                           World.method1681().method6004(var3);
                           return 1;
                        } else if(var0 == 6631) {
                           World.method1681().method6005();
                           return 1;
                        } else if(var0 == 6632) {
                           var14 = class80.intStack[--class80.intStackSize] == 1;
                           World.method1681().method6006(var14);
                           return 1;
                        } else {
                           boolean var4;
                           if(var0 == 6633) {
                              class80.intStackSize -= 2;
                              var3 = class80.intStack[class80.intStackSize];
                              var4 = class80.intStack[class80.intStackSize + 1] == 1;
                              World.method1681().method6007(var3, var4);
                              return 1;
                           } else if(var0 == 6634) {
                              class80.intStackSize -= 2;
                              var3 = class80.intStack[class80.intStackSize];
                              var4 = class80.intStack[class80.intStackSize + 1] == 1;
                              World.method1681().method6008(var3, var4);
                              return 1;
                           } else if(var0 == 6635) {
                              class80.intStack[++class80.intStackSize - 1] = World.method1681().method6022()?1:0;
                              return 1;
                           } else if(var0 == 6636) {
                              var3 = class80.intStack[--class80.intStackSize];
                              class80.intStack[++class80.intStackSize - 1] = World.method1681().method6010(var3)?1:0;
                              return 1;
                           } else if(var0 == 6637) {
                              var3 = class80.intStack[--class80.intStackSize];
                              class80.intStack[++class80.intStackSize - 1] = World.method1681().method6011(var3)?1:0;
                              return 1;
                           } else if(var0 == 6638) {
                              class80.intStackSize -= 2;
                              var3 = class80.intStack[class80.intStackSize];
                              var16 = new Coordinates(class80.intStack[class80.intStackSize + 1]);
                              var11 = World.method1681().method5983(var3, var16);
                              if(var11 == null) {
                                 class80.intStack[++class80.intStackSize - 1] = -1;
                              } else {
                                 class80.intStack[++class80.intStackSize - 1] = var11.bitpack();
                              }

                              return 1;
                           } else {
                              MapIcon var12;
                              if(var0 == 6639) {
                                 var12 = World.method1681().method6016();
                                 if(var12 == null) {
                                    class80.intStack[++class80.intStackSize - 1] = -1;
                                    class80.intStack[++class80.intStackSize - 1] = -1;
                                 } else {
                                    class80.intStack[++class80.intStackSize - 1] = var12.areaId;
                                    class80.intStack[++class80.intStackSize - 1] = var12.field490.bitpack();
                                 }

                                 return 1;
                              } else if(var0 == 6640) {
                                 var12 = World.method1681().method6027();
                                 if(var12 == null) {
                                    class80.intStack[++class80.intStackSize - 1] = -1;
                                    class80.intStack[++class80.intStackSize - 1] = -1;
                                 } else {
                                    class80.intStack[++class80.intStackSize - 1] = var12.areaId;
                                    class80.intStack[++class80.intStackSize - 1] = var12.field490.bitpack();
                                 }

                                 return 1;
                              } else {
                                 Area var10;
                                 if(var0 == 6693) {
                                    var3 = class80.intStack[--class80.intStackSize];
                                    var10 = class330.mapAreaType[var3];
                                    if(var10.name == null) {
                                       class80.scriptStringStack[++class43.scriptStringStackSize - 1] = "";
                                    } else {
                                       class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var10.name;
                                    }

                                    return 1;
                                 } else if(var0 == 6694) {
                                    var3 = class80.intStack[--class80.intStackSize];
                                    var10 = class330.mapAreaType[var3];
                                    class80.intStack[++class80.intStackSize - 1] = var10.field3399;
                                    return 1;
                                 } else if(var0 == 6695) {
                                    var3 = class80.intStack[--class80.intStackSize];
                                    var10 = class330.mapAreaType[var3];
                                    if(var10 == null) {
                                       class80.intStack[++class80.intStackSize - 1] = -1;
                                    } else {
                                       class80.intStack[++class80.intStackSize - 1] = var10.field3397;
                                    }

                                    return 1;
                                 } else if(var0 == 6696) {
                                    var3 = class80.intStack[--class80.intStackSize];
                                    var10 = class330.mapAreaType[var3];
                                    if(var10 == null) {
                                       class80.intStack[++class80.intStackSize - 1] = -1;
                                    } else {
                                       class80.intStack[++class80.intStackSize - 1] = var10.spriteId;
                                    }

                                    return 1;
                                 } else if(var0 == 6697) {
                                    class80.intStack[++class80.intStackSize - 1] = class299.scriptMapIconReference.areaId;
                                    return 1;
                                 } else if(var0 == 6698) {
                                    class80.intStack[++class80.intStackSize - 1] = class299.scriptMapIconReference.field554.bitpack();
                                    return 1;
                                 } else if(var0 == 6699) {
                                    class80.intStack[++class80.intStackSize - 1] = class299.scriptMapIconReference.field553.bitpack();
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
