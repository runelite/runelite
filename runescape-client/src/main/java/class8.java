import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public final class class8 extends class9 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   static SpritePixels field250;
   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   @Export("configsIndex")
   static IndexData configsIndex;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -129520815
   )
   final int field258;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1806506721
   )
   final int field252;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1628721609
   )
   final int field251;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2002540485
   )
   final int field253;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1736566843
   )
   final int field254;

   public class8(int var1, int var2, int var3, int var4, int var5) {
      this.field258 = var1;
      this.field252 = var2;
      this.field251 = var3;
      this.field253 = var4;
      this.field254 = var5;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2004882891"
   )
   public final void vmethod57() {
      Rasterizer2D.drawRectangle(this.field258 + Rasterizer2D.draw_region_x, this.field252 + Rasterizer2D.drawingAreaTop, this.field251 - this.field258, this.field253 - this.field252, this.field254);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SI)V",
      garbageValue = "-1068259475"
   )
   public static void method39(String[] var0, short[] var1) {
      class45.method642(var0, var1, 0, var0.length - 1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILip;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "1634458397"
   )
   public static void method42(int var0, IndexDataBase var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.getFile(var2);
      int var7 = var1.getChild(var6, var3);
      IndexFile.method3070(var0, var1, var6, var7, var4, var5);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(ILct;ZB)I",
      garbageValue = "119"
   )
   static int method41(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 6600) {
         var3 = class46.plane;
         int var9 = (class66.localPlayer.x >> 7) + class22.baseX;
         int var5 = (class66.localPlayer.y >> 7) + class273.baseY;
         Ignore.method1102().method5366(var3, var9, var5, true);
         return 1;
      } else {
         WorldMapData var11;
         if(var0 == 6601) {
            var3 = class81.intStack[--class278.intStackSize];
            String var16 = "";
            var11 = Ignore.method1102().method5319(var3);
            if(var11 != null) {
               var16 = var11.method309();
            }

            class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var16;
            return 1;
         } else if(var0 == 6602) {
            var3 = class81.intStack[--class278.intStackSize];
            Ignore.method1102().method5304(var3);
            return 1;
         } else if(var0 == 6603) {
            class81.intStack[++class278.intStackSize - 1] = Ignore.method1102().method5298();
            return 1;
         } else if(var0 == 6604) {
            var3 = class81.intStack[--class278.intStackSize];
            Ignore.method1102().method5313(var3);
            return 1;
         } else if(var0 == 6605) {
            class81.intStack[++class278.intStackSize - 1] = Ignore.method1102().method5438()?1:0;
            return 1;
         } else {
            Coordinates var15;
            if(var0 == 6606) {
               var15 = new Coordinates(class81.intStack[--class278.intStackSize]);
               Ignore.method1102().method5320(var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6607) {
               var15 = new Coordinates(class81.intStack[--class278.intStackSize]);
               Ignore.method1102().method5321(var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6608) {
               var15 = new Coordinates(class81.intStack[--class278.intStackSize]);
               Ignore.method1102().method5470(var15.plane, var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6609) {
               var15 = new Coordinates(class81.intStack[--class278.intStackSize]);
               Ignore.method1102().method5323(var15.plane, var15.worldX, var15.worldY);
               return 1;
            } else if(var0 == 6610) {
               class81.intStack[++class278.intStackSize - 1] = Ignore.method1102().method5324();
               class81.intStack[++class278.intStackSize - 1] = Ignore.method1102().method5325();
               return 1;
            } else {
               WorldMapData var13;
               if(var0 == 6611) {
                  var3 = class81.intStack[--class278.intStackSize];
                  var13 = Ignore.method1102().method5319(var3);
                  if(var13 == null) {
                     class81.intStack[++class278.intStackSize - 1] = 0;
                  } else {
                     class81.intStack[++class278.intStackSize - 1] = var13.method298().method4014();
                  }

                  return 1;
               } else if(var0 == 6612) {
                  var3 = class81.intStack[--class278.intStackSize];
                  var13 = Ignore.method1102().method5319(var3);
                  if(var13 == null) {
                     class81.intStack[++class278.intStackSize - 1] = 0;
                     class81.intStack[++class278.intStackSize - 1] = 0;
                  } else {
                     class81.intStack[++class278.intStackSize - 1] = (var13.method292() - var13.method291() + 1) * 64;
                     class81.intStack[++class278.intStackSize - 1] = (var13.method294() - var13.method293() + 1) * 64;
                  }

                  return 1;
               } else if(var0 == 6613) {
                  var3 = class81.intStack[--class278.intStackSize];
                  var13 = Ignore.method1102().method5319(var3);
                  if(var13 == null) {
                     class81.intStack[++class278.intStackSize - 1] = 0;
                     class81.intStack[++class278.intStackSize - 1] = 0;
                     class81.intStack[++class278.intStackSize - 1] = 0;
                     class81.intStack[++class278.intStackSize - 1] = 0;
                  } else {
                     class81.intStack[++class278.intStackSize - 1] = var13.method291() * 64;
                     class81.intStack[++class278.intStackSize - 1] = var13.method293() * 64;
                     class81.intStack[++class278.intStackSize - 1] = var13.method292() * 64 + 64 - 1;
                     class81.intStack[++class278.intStackSize - 1] = var13.method294() * 64 + 64 - 1;
                  }

                  return 1;
               } else if(var0 == 6614) {
                  var3 = class81.intStack[--class278.intStackSize];
                  var13 = Ignore.method1102().method5319(var3);
                  if(var13 == null) {
                     class81.intStack[++class278.intStackSize - 1] = -1;
                  } else {
                     class81.intStack[++class278.intStackSize - 1] = var13.method303();
                  }

                  return 1;
               } else if(var0 == 6615) {
                  var15 = Ignore.method1102().method5293();
                  if(var15 == null) {
                     class81.intStack[++class278.intStackSize - 1] = -1;
                     class81.intStack[++class278.intStackSize - 1] = -1;
                  } else {
                     class81.intStack[++class278.intStackSize - 1] = var15.worldX;
                     class81.intStack[++class278.intStackSize - 1] = var15.worldY;
                  }

                  return 1;
               } else if(var0 == 6616) {
                  class81.intStack[++class278.intStackSize - 1] = Ignore.method1102().method5305();
                  return 1;
               } else if(var0 == 6617) {
                  var15 = new Coordinates(class81.intStack[--class278.intStackSize]);
                  var13 = Ignore.method1102().method5306();
                  if(var13 == null) {
                     class81.intStack[++class278.intStackSize - 1] = -1;
                     class81.intStack[++class278.intStackSize - 1] = -1;
                     return 1;
                  } else {
                     int[] var14 = var13.method324(var15.plane, var15.worldX, var15.worldY);
                     if(var14 == null) {
                        class81.intStack[++class278.intStackSize - 1] = -1;
                        class81.intStack[++class278.intStackSize - 1] = -1;
                     } else {
                        class81.intStack[++class278.intStackSize - 1] = var14[0];
                        class81.intStack[++class278.intStackSize - 1] = var14[1];
                     }

                     return 1;
                  }
               } else {
                  Coordinates var7;
                  if(var0 == 6618) {
                     var15 = new Coordinates(class81.intStack[--class278.intStackSize]);
                     var13 = Ignore.method1102().method5306();
                     if(var13 == null) {
                        class81.intStack[++class278.intStackSize - 1] = -1;
                        class81.intStack[++class278.intStackSize - 1] = -1;
                        return 1;
                     } else {
                        var7 = var13.method283(var15.worldX, var15.worldY);
                        if(var7 == null) {
                           class81.intStack[++class278.intStackSize - 1] = -1;
                        } else {
                           class81.intStack[++class278.intStackSize - 1] = var7.method4014();
                        }

                        return 1;
                     }
                  } else {
                     Coordinates var12;
                     if(var0 == 6619) {
                        class278.intStackSize -= 2;
                        var3 = class81.intStack[class278.intStackSize];
                        var12 = new Coordinates(class81.intStack[class278.intStackSize + 1]);
                        PendingSpawn.method1524(var3, var12, false);
                        return 1;
                     } else if(var0 == 6620) {
                        class278.intStackSize -= 2;
                        var3 = class81.intStack[class278.intStackSize];
                        var12 = new Coordinates(class81.intStack[class278.intStackSize + 1]);
                        PendingSpawn.method1524(var3, var12, true);
                        return 1;
                     } else if(var0 == 6621) {
                        class278.intStackSize -= 2;
                        var3 = class81.intStack[class278.intStackSize];
                        var12 = new Coordinates(class81.intStack[class278.intStackSize + 1]);
                        var11 = Ignore.method1102().method5319(var3);
                        if(var11 == null) {
                           class81.intStack[++class278.intStackSize - 1] = 0;
                           return 1;
                        } else {
                           class81.intStack[++class278.intStackSize - 1] = var11.method280(var12.plane, var12.worldX, var12.worldY)?1:0;
                           return 1;
                        }
                     } else if(var0 == 6622) {
                        class81.intStack[++class278.intStackSize - 1] = Ignore.method1102().method5358();
                        class81.intStack[++class278.intStackSize - 1] = Ignore.method1102().method5411();
                        return 1;
                     } else if(var0 == 6623) {
                        var15 = new Coordinates(class81.intStack[--class278.intStackSize]);
                        var13 = Ignore.method1102().method5482(var15.plane, var15.worldX, var15.worldY);
                        if(var13 == null) {
                           class81.intStack[++class278.intStackSize - 1] = -1;
                        } else {
                           class81.intStack[++class278.intStackSize - 1] = var13.method285();
                        }

                        return 1;
                     } else if(var0 == 6624) {
                        Ignore.method1102().method5329(class81.intStack[--class278.intStackSize]);
                        return 1;
                     } else if(var0 == 6625) {
                        Ignore.method1102().method5330();
                        return 1;
                     } else if(var0 == 6626) {
                        Ignore.method1102().method5331(class81.intStack[--class278.intStackSize]);
                        return 1;
                     } else if(var0 == 6627) {
                        Ignore.method1102().method5332();
                        return 1;
                     } else {
                        boolean var10;
                        if(var0 == 6628) {
                           var10 = class81.intStack[--class278.intStackSize] == 1;
                           Ignore.method1102().method5333(var10);
                           return 1;
                        } else if(var0 == 6629) {
                           var3 = class81.intStack[--class278.intStackSize];
                           Ignore.method1102().method5369(var3);
                           return 1;
                        } else if(var0 == 6630) {
                           var3 = class81.intStack[--class278.intStackSize];
                           Ignore.method1102().method5335(var3);
                           return 1;
                        } else if(var0 == 6631) {
                           Ignore.method1102().method5405();
                           return 1;
                        } else if(var0 == 6632) {
                           var10 = class81.intStack[--class278.intStackSize] == 1;
                           Ignore.method1102().method5360(var10);
                           return 1;
                        } else {
                           boolean var4;
                           if(var0 == 6633) {
                              class278.intStackSize -= 2;
                              var3 = class81.intStack[class278.intStackSize];
                              var4 = class81.intStack[class278.intStackSize + 1] == 1;
                              Ignore.method1102().method5338(var3, var4);
                              return 1;
                           } else if(var0 == 6634) {
                              class278.intStackSize -= 2;
                              var3 = class81.intStack[class278.intStackSize];
                              var4 = class81.intStack[class278.intStackSize + 1] == 1;
                              Ignore.method1102().method5451(var3, var4);
                              return 1;
                           } else if(var0 == 6635) {
                              class81.intStack[++class278.intStackSize - 1] = Ignore.method1102().method5340()?1:0;
                              return 1;
                           } else if(var0 == 6636) {
                              var3 = class81.intStack[--class278.intStackSize];
                              class81.intStack[++class278.intStackSize - 1] = Ignore.method1102().method5341(var3)?1:0;
                              return 1;
                           } else if(var0 == 6637) {
                              var3 = class81.intStack[--class278.intStackSize];
                              class81.intStack[++class278.intStackSize - 1] = Ignore.method1102().method5342(var3)?1:0;
                              return 1;
                           } else if(var0 == 6638) {
                              class278.intStackSize -= 2;
                              var3 = class81.intStack[class278.intStackSize];
                              var12 = new Coordinates(class81.intStack[class278.intStackSize + 1]);
                              var7 = Ignore.method1102().method5337(var3, var12);
                              if(var7 == null) {
                                 class81.intStack[++class278.intStackSize - 1] = -1;
                              } else {
                                 class81.intStack[++class278.intStackSize - 1] = var7.method4014();
                              }

                              return 1;
                           } else {
                              class39 var8;
                              if(var0 == 6639) {
                                 var8 = Ignore.method1102().method5296();
                                 if(var8 == null) {
                                    class81.intStack[++class278.intStackSize - 1] = -1;
                                    class81.intStack[++class278.intStackSize - 1] = -1;
                                 } else {
                                    class81.intStack[++class278.intStackSize - 1] = var8.field556;
                                    class81.intStack[++class278.intStackSize - 1] = var8.field548.method4014();
                                 }

                                 return 1;
                              } else if(var0 == 6640) {
                                 var8 = Ignore.method1102().method5348();
                                 if(var8 == null) {
                                    class81.intStack[++class278.intStackSize - 1] = -1;
                                    class81.intStack[++class278.intStackSize - 1] = -1;
                                 } else {
                                    class81.intStack[++class278.intStackSize - 1] = var8.field556;
                                    class81.intStack[++class278.intStackSize - 1] = var8.field548.method4014();
                                 }

                                 return 1;
                              } else {
                                 Area var6;
                                 if(var0 == 6693) {
                                    var3 = class81.intStack[--class278.intStackSize];
                                    var6 = Area.field3285[var3];
                                    if(var6.name == null) {
                                       class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                    } else {
                                       class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var6.name;
                                    }

                                    return 1;
                                 } else if(var0 == 6694) {
                                    var3 = class81.intStack[--class278.intStackSize];
                                    var6 = Area.field3285[var3];
                                    class81.intStack[++class278.intStackSize - 1] = var6.field3284;
                                    return 1;
                                 } else if(var0 == 6695) {
                                    var3 = class81.intStack[--class278.intStackSize];
                                    var6 = Area.field3285[var3];
                                    if(var6 == null) {
                                       class81.intStack[++class278.intStackSize - 1] = -1;
                                    } else {
                                       class81.intStack[++class278.intStackSize - 1] = var6.field3304;
                                    }

                                    return 1;
                                 } else if(var0 == 6696) {
                                    var3 = class81.intStack[--class278.intStackSize];
                                    var6 = Area.field3285[var3];
                                    if(var6 == null) {
                                       class81.intStack[++class278.intStackSize - 1] = -1;
                                    } else {
                                       class81.intStack[++class278.intStackSize - 1] = var6.spriteId;
                                    }

                                    return 1;
                                 } else if(var0 == 6697) {
                                    class81.intStack[++class278.intStackSize - 1] = class232.field3194.field615;
                                    return 1;
                                 } else if(var0 == 6698) {
                                    class81.intStack[++class278.intStackSize - 1] = class232.field3194.field616.method4014();
                                    return 1;
                                 } else if(var0 == 6699) {
                                    class81.intStack[++class278.intStackSize - 1] = class232.field3194.field617.method4014();
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

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-57"
   )
   static void method40(int var0) {
      class170.topContextMenuRow = new ContextMenuRow();
      class170.topContextMenuRow.param0 = Client.menuActionParams0[var0];
      class170.topContextMenuRow.param1 = Client.menuActionParams1[var0];
      class170.topContextMenuRow.type = Client.menuTypes[var0];
      class170.topContextMenuRow.identifier = Client.menuIdentifiers[var0];
      class170.topContextMenuRow.option = Client.menuOptions[var0];
   }

   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "-1829184648"
   )
   static final String[] method43(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }
}
