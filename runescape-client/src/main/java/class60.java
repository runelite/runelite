import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
public final class class60 {
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = -903211569
   )
   static int field719;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = -850660479
   )
   static int field726;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   public static IndexDataBase field723;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   public static IndexDataBase field725;
   @ObfuscatedName("f")
   static int[] field721;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = -1192095613
   )
   static int field724;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1322106633"
   )
   @Export("currentTimeMs")
   public static synchronized long currentTimeMs() {
      long var0 = System.currentTimeMillis();
      if(var0 < class186.currentTimeMsLast) {
         class186.currentTimeMsOffset += class186.currentTimeMsLast - var0;
      }

      class186.currentTimeMsLast = var0;
      return var0 + class186.currentTimeMsOffset;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1577236825"
   )
   static final void method1026(int var0) {
      class133.Viewport_entityIdsAtMouse[++class133.Viewport_entityCountAtMouse - 1] = var0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILcv;ZB)I",
      garbageValue = "30"
   )
   static int method1036(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 6600) {
         var3 = class7.plane;
         int var13 = (GrandExchangeOffer.localPlayer.x >> 7) + class175.baseX;
         int var5 = (GrandExchangeOffer.localPlayer.y >> 7) + GraphicsObject.baseY;
         class47.method693().method5597(var3, var13, var5, true);
         return 1;
      } else {
         WorldMapData var15;
         if(var0 == 6601) {
            var3 = class82.intStack[--class82.intStackSize];
            String var20 = "";
            var15 = class47.method693().method5449(var3);
            if(var15 != null) {
               var20 = var15.method284();
            }

            class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var20;
            return 1;
         } else if(var0 == 6602) {
            var3 = class82.intStack[--class82.intStackSize];
            class47.method693().method5434(var3);
            return 1;
         } else if(var0 == 6603) {
            class82.intStack[++class82.intStackSize - 1] = class47.method693().method5446();
            return 1;
         } else if(var0 == 6604) {
            var3 = class82.intStack[--class82.intStackSize];
            class47.method693().method5459(var3);
            return 1;
         } else if(var0 == 6605) {
            class82.intStack[++class82.intStackSize - 1] = class47.method693().method5448()?1:0;
            return 1;
         } else {
            Coordinates var19;
            if(var0 == 6606) {
               var19 = new Coordinates(class82.intStack[--class82.intStackSize]);
               class47.method693().method5450(var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6607) {
               var19 = new Coordinates(class82.intStack[--class82.intStackSize]);
               class47.method693().method5477(var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6608) {
               var19 = new Coordinates(class82.intStack[--class82.intStackSize]);
               class47.method693().method5441(var19.plane, var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6609) {
               var19 = new Coordinates(class82.intStack[--class82.intStackSize]);
               class47.method693().method5581(var19.plane, var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6610) {
               class82.intStack[++class82.intStackSize - 1] = class47.method693().method5454();
               class82.intStack[++class82.intStackSize - 1] = class47.method693().method5455();
               return 1;
            } else {
               WorldMapData var17;
               if(var0 == 6611) {
                  var3 = class82.intStack[--class82.intStackSize];
                  var17 = class47.method693().method5449(var3);
                  if(var17 == null) {
                     class82.intStack[++class82.intStackSize - 1] = 0;
                  } else {
                     class82.intStack[++class82.intStackSize - 1] = var17.method294().method4160();
                  }

                  return 1;
               } else if(var0 == 6612) {
                  var3 = class82.intStack[--class82.intStackSize];
                  var17 = class47.method693().method5449(var3);
                  if(var17 == null) {
                     class82.intStack[++class82.intStackSize - 1] = 0;
                     class82.intStack[++class82.intStackSize - 1] = 0;
                  } else {
                     class82.intStack[++class82.intStackSize - 1] = (var17.method326() - var17.method297() + 1) * 64;
                     class82.intStack[++class82.intStackSize - 1] = (var17.method290() - var17.method289() + 1) * 64;
                  }

                  return 1;
               } else if(var0 == 6613) {
                  var3 = class82.intStack[--class82.intStackSize];
                  var17 = class47.method693().method5449(var3);
                  if(var17 == null) {
                     class82.intStack[++class82.intStackSize - 1] = 0;
                     class82.intStack[++class82.intStackSize - 1] = 0;
                     class82.intStack[++class82.intStackSize - 1] = 0;
                     class82.intStack[++class82.intStackSize - 1] = 0;
                  } else {
                     class82.intStack[++class82.intStackSize - 1] = var17.method297() * 64;
                     class82.intStack[++class82.intStackSize - 1] = var17.method289() * 64;
                     class82.intStack[++class82.intStackSize - 1] = var17.method326() * 64 + 64 - 1;
                     class82.intStack[++class82.intStackSize - 1] = var17.method290() * 64 + 64 - 1;
                  }

                  return 1;
               } else if(var0 == 6614) {
                  var3 = class82.intStack[--class82.intStackSize];
                  var17 = class47.method693().method5449(var3);
                  if(var17 == null) {
                     class82.intStack[++class82.intStackSize - 1] = -1;
                  } else {
                     class82.intStack[++class82.intStackSize - 1] = var17.method288();
                  }

                  return 1;
               } else if(var0 == 6615) {
                  var19 = class47.method693().method5437();
                  if(var19 == null) {
                     class82.intStack[++class82.intStackSize - 1] = -1;
                     class82.intStack[++class82.intStackSize - 1] = -1;
                  } else {
                     class82.intStack[++class82.intStackSize - 1] = var19.worldX;
                     class82.intStack[++class82.intStackSize - 1] = var19.worldY;
                  }

                  return 1;
               } else if(var0 == 6616) {
                  class82.intStack[++class82.intStackSize - 1] = class47.method693().method5554();
                  return 1;
               } else if(var0 == 6617) {
                  var19 = new Coordinates(class82.intStack[--class82.intStackSize]);
                  var17 = class47.method693().method5436();
                  if(var17 == null) {
                     class82.intStack[++class82.intStackSize - 1] = -1;
                     class82.intStack[++class82.intStackSize - 1] = -1;
                     return 1;
                  } else {
                     int[] var18 = var17.method322(var19.plane, var19.worldX, var19.worldY);
                     if(var18 == null) {
                        class82.intStack[++class82.intStackSize - 1] = -1;
                        class82.intStack[++class82.intStackSize - 1] = -1;
                     } else {
                        class82.intStack[++class82.intStackSize - 1] = var18[0];
                        class82.intStack[++class82.intStackSize - 1] = var18[1];
                     }

                     return 1;
                  }
               } else {
                  Coordinates var11;
                  if(var0 == 6618) {
                     var19 = new Coordinates(class82.intStack[--class82.intStackSize]);
                     var17 = class47.method693().method5436();
                     if(var17 == null) {
                        class82.intStack[++class82.intStackSize - 1] = -1;
                        class82.intStack[++class82.intStackSize - 1] = -1;
                        return 1;
                     } else {
                        var11 = var17.method279(var19.worldX, var19.worldY);
                        if(var11 == null) {
                           class82.intStack[++class82.intStackSize - 1] = -1;
                        } else {
                           class82.intStack[++class82.intStackSize - 1] = var11.method4160();
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
                        class82.intStackSize -= 2;
                        var3 = class82.intStack[class82.intStackSize];
                        var16 = new Coordinates(class82.intStack[class82.intStackSize + 1]);
                        var15 = class47.method693().method5449(var3);
                        var6 = GrandExchangeOffer.localPlayer.field856;
                        var7 = (GrandExchangeOffer.localPlayer.x >> 7) + class175.baseX;
                        var8 = (GrandExchangeOffer.localPlayer.y >> 7) + GraphicsObject.baseY;
                        var9 = new Coordinates(var6, var7, var8);
                        class47.method693().method5439(var15, var9, var16, false);
                        return 1;
                     } else if(var0 == 6620) {
                        class82.intStackSize -= 2;
                        var3 = class82.intStack[class82.intStackSize];
                        var16 = new Coordinates(class82.intStack[class82.intStackSize + 1]);
                        var15 = class47.method693().method5449(var3);
                        var6 = GrandExchangeOffer.localPlayer.field856;
                        var7 = (GrandExchangeOffer.localPlayer.x >> 7) + class175.baseX;
                        var8 = (GrandExchangeOffer.localPlayer.y >> 7) + GraphicsObject.baseY;
                        var9 = new Coordinates(var6, var7, var8);
                        class47.method693().method5439(var15, var9, var16, true);
                        return 1;
                     } else if(var0 == 6621) {
                        class82.intStackSize -= 2;
                        var3 = class82.intStack[class82.intStackSize];
                        var16 = new Coordinates(class82.intStack[class82.intStackSize + 1]);
                        var15 = class47.method693().method5449(var3);
                        if(var15 == null) {
                           class82.intStack[++class82.intStackSize - 1] = 0;
                           return 1;
                        } else {
                           class82.intStack[++class82.intStackSize - 1] = var15.method276(var16.plane, var16.worldX, var16.worldY)?1:0;
                           return 1;
                        }
                     } else if(var0 == 6622) {
                        class82.intStack[++class82.intStackSize - 1] = class47.method693().method5457();
                        class82.intStack[++class82.intStackSize - 1] = class47.method693().method5458();
                        return 1;
                     } else if(var0 == 6623) {
                        var19 = new Coordinates(class82.intStack[--class82.intStackSize]);
                        var17 = class47.method693().method5432(var19.plane, var19.worldX, var19.worldY);
                        if(var17 == null) {
                           class82.intStack[++class82.intStackSize - 1] = -1;
                        } else {
                           class82.intStack[++class82.intStackSize - 1] = var17.method281();
                        }

                        return 1;
                     } else if(var0 == 6624) {
                        class47.method693().method5443(class82.intStack[--class82.intStackSize]);
                        return 1;
                     } else if(var0 == 6625) {
                        class47.method693().method5460();
                        return 1;
                     } else if(var0 == 6626) {
                        class47.method693().method5601(class82.intStack[--class82.intStackSize]);
                        return 1;
                     } else if(var0 == 6627) {
                        class47.method693().method5462();
                        return 1;
                     } else {
                        boolean var14;
                        if(var0 == 6628) {
                           var14 = class82.intStack[--class82.intStackSize] == 1;
                           class47.method693().method5463(var14);
                           return 1;
                        } else if(var0 == 6629) {
                           var3 = class82.intStack[--class82.intStackSize];
                           class47.method693().method5453(var3);
                           return 1;
                        } else if(var0 == 6630) {
                           var3 = class82.intStack[--class82.intStackSize];
                           class47.method693().method5465(var3);
                           return 1;
                        } else if(var0 == 6631) {
                           class47.method693().method5466();
                           return 1;
                        } else if(var0 == 6632) {
                           var14 = class82.intStack[--class82.intStackSize] == 1;
                           class47.method693().method5467(var14);
                           return 1;
                        } else {
                           boolean var4;
                           if(var0 == 6633) {
                              class82.intStackSize -= 2;
                              var3 = class82.intStack[class82.intStackSize];
                              var4 = class82.intStack[class82.intStackSize + 1] == 1;
                              class47.method693().method5578(var3, var4);
                              return 1;
                           } else if(var0 == 6634) {
                              class82.intStackSize -= 2;
                              var3 = class82.intStack[class82.intStackSize];
                              var4 = class82.intStack[class82.intStackSize + 1] == 1;
                              class47.method693().method5557(var3, var4);
                              return 1;
                           } else if(var0 == 6635) {
                              class82.intStack[++class82.intStackSize - 1] = class47.method693().method5470()?1:0;
                              return 1;
                           } else if(var0 == 6636) {
                              var3 = class82.intStack[--class82.intStackSize];
                              class82.intStack[++class82.intStackSize - 1] = class47.method693().method5471(var3)?1:0;
                              return 1;
                           } else if(var0 == 6637) {
                              var3 = class82.intStack[--class82.intStackSize];
                              class82.intStack[++class82.intStackSize - 1] = class47.method693().method5433(var3)?1:0;
                              return 1;
                           } else if(var0 == 6638) {
                              class82.intStackSize -= 2;
                              var3 = class82.intStack[class82.intStackSize];
                              var16 = new Coordinates(class82.intStack[class82.intStackSize + 1]);
                              var11 = class47.method693().method5475(var3, var16);
                              if(var11 == null) {
                                 class82.intStack[++class82.intStackSize - 1] = -1;
                              } else {
                                 class82.intStack[++class82.intStackSize - 1] = var11.method4160();
                              }

                              return 1;
                           } else {
                              class39 var12;
                              if(var0 == 6639) {
                                 var12 = class47.method693().method5478();
                                 if(var12 == null) {
                                    class82.intStack[++class82.intStackSize - 1] = -1;
                                    class82.intStack[++class82.intStackSize - 1] = -1;
                                 } else {
                                    class82.intStack[++class82.intStackSize - 1] = var12.field512;
                                    class82.intStack[++class82.intStackSize - 1] = var12.field514.method4160();
                                 }

                                 return 1;
                              } else if(var0 == 6640) {
                                 var12 = class47.method693().method5596();
                                 if(var12 == null) {
                                    class82.intStack[++class82.intStackSize - 1] = -1;
                                    class82.intStack[++class82.intStackSize - 1] = -1;
                                 } else {
                                    class82.intStack[++class82.intStackSize - 1] = var12.field512;
                                    class82.intStack[++class82.intStackSize - 1] = var12.field514.method4160();
                                 }

                                 return 1;
                              } else {
                                 Area var10;
                                 if(var0 == 6693) {
                                    var3 = class82.intStack[--class82.intStackSize];
                                    var10 = Area.mapAreaType[var3];
                                    if(var10.name == null) {
                                       class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
                                    } else {
                                       class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var10.name;
                                    }

                                    return 1;
                                 } else if(var0 == 6694) {
                                    var3 = class82.intStack[--class82.intStackSize];
                                    var10 = Area.mapAreaType[var3];
                                    class82.intStack[++class82.intStackSize - 1] = var10.field3389;
                                    return 1;
                                 } else if(var0 == 6695) {
                                    var3 = class82.intStack[--class82.intStackSize];
                                    var10 = Area.mapAreaType[var3];
                                    if(var10 == null) {
                                       class82.intStack[++class82.intStackSize - 1] = -1;
                                    } else {
                                       class82.intStack[++class82.intStackSize - 1] = var10.field3401;
                                    }

                                    return 1;
                                 } else if(var0 == 6696) {
                                    var3 = class82.intStack[--class82.intStackSize];
                                    var10 = Area.mapAreaType[var3];
                                    if(var10 == null) {
                                       class82.intStack[++class82.intStackSize - 1] = -1;
                                    } else {
                                       class82.intStack[++class82.intStackSize - 1] = var10.spriteId;
                                    }

                                    return 1;
                                 } else if(var0 == 6697) {
                                    class82.intStack[++class82.intStackSize - 1] = class82.field1270.field573;
                                    return 1;
                                 } else if(var0 == 6698) {
                                    class82.intStack[++class82.intStackSize - 1] = class82.field1270.field574.method4160();
                                    return 1;
                                 } else if(var0 == 6699) {
                                    class82.intStack[++class82.intStackSize - 1] = class82.field1270.field575.method4160();
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

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "(IIII)Lbp;",
      garbageValue = "459261024"
   )
   static final WidgetNode method1032(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.owner = var2;
      Client.componentTable.put(var3, (long)var0);
      class18.method129(var1);
      Widget var4 = UrlRequester.getWidget(var0);
      class28.method220(var4);
      if(Client.field1019 != null) {
         class28.method220(Client.field1019);
         Client.field1019 = null;
      }

      GameCanvas.method779();
      class160.method3094(Widget.widgets[var0 >> 16], var4, false);
      BoundingBox.method45(var1);
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(FontName.loadWidget(var5)) {
            SoundTaskDataProvider.method762(Widget.widgets[var5], 1);
         }
      }

      return var3;
   }
}
