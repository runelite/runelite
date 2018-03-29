import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
@Implements("BoundingBox")
public abstract class BoundingBox extends Node {
   @ObfuscatedName("au")
   @Export("clientInstance")
   @ObfuscatedSignature(
      signature = "Lclient;"
   )
   static Client clientInstance;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-254890889"
   )
   abstract void vmethod63();

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljm;Ljm;Ljm;Ljm;I)V",
      garbageValue = "408545515"
   )
   public static void method60(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2, IndexDataBase var3) {
      UnitPriceComparator.widgetIndex = var0;
      Widget.field2805 = var1;
      Widget.field2917 = var2;
      Widget.field2807 = var3;
      class189.widgets = new Widget[UnitPriceComparator.widgetIndex.size()][];
      class314.validInterfaces = new boolean[UnitPriceComparator.widgetIndex.size()];
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static void method57() {
      WorldMapRegion.field470.method3954();
      WorldMapRegion.field458.method3954();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "1291592460"
   )
   static int method53(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 100) {
         SceneTilePaint.intStackSize -= 3;
         var3 = class81.intStack[SceneTilePaint.intStackSize];
         var4 = class81.intStack[SceneTilePaint.intStackSize + 1];
         int var5 = class81.intStack[SceneTilePaint.intStackSize + 2];
         if(var4 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = class3.getWidget(var3);
            if(var6.children == null) {
               var6.children = new Widget[var5 + 1];
            }

            if(var6.children.length <= var5) {
               Widget[] var7 = new Widget[var5 + 1];

               for(int var8 = 0; var8 < var6.children.length; ++var8) {
                  var7[var8] = var6.children[var8];
               }

               var6.children = var7;
            }

            if(var5 > 0 && var6.children[var5 - 1] == null) {
               throw new RuntimeException("" + (var5 - 1));
            } else {
               Widget var12 = new Widget();
               var12.type = var4;
               var12.parentId = var12.id = var6.id;
               var12.index = var5;
               var12.hasScript = true;
               var6.children[var5] = var12;
               if(var2) {
                  class336.field4073 = var12;
               } else {
                  class61.field713 = var12;
               }

               WorldMapType1.method274(var6);
               return 1;
            }
         }
      } else {
         Widget var9;
         if(var0 == 101) {
            var9 = var2?class336.field4073:class61.field713;
            Widget var10 = class3.getWidget(var9.id);
            var10.children[var9.index] = null;
            WorldMapType1.method274(var10);
            return 1;
         } else if(var0 == 102) {
            var9 = class3.getWidget(class81.intStack[--SceneTilePaint.intStackSize]);
            var9.children = null;
            WorldMapType1.method274(var9);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var9 = class3.getWidget(class81.intStack[--SceneTilePaint.intStackSize]);
               if(var9 != null) {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = 1;
                  if(var2) {
                     class336.field4073 = var9;
                  } else {
                     class61.field713 = var9;
                  }
               } else {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            SceneTilePaint.intStackSize -= 2;
            var3 = class81.intStack[SceneTilePaint.intStackSize];
            var4 = class81.intStack[SceneTilePaint.intStackSize + 1];
            Widget var11 = ClientPacket.getWidgetChild(var3, var4);
            if(var11 != null && var4 != -1) {
               class81.intStack[++SceneTilePaint.intStackSize - 1] = 1;
               if(var2) {
                  class336.field4073 = var11;
               } else {
                  class61.field713 = var11;
               }
            } else {
               class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(Lgk;I)V",
      garbageValue = "448825946"
   )
   static final void method58(class183 var0) {
      PacketBuffer var1 = Client.field902.packetBuffer;
      int var2;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var37;
      int var42;
      if(class183.field2489 == var0) {
         var2 = var1.readUnsignedByte();
         var37 = (var2 >> 4 & 7) + WorldMapManager.field533;
         var4 = (var2 & 7) + GameEngine.field673;
         var5 = var1.readUnsignedShortOb1();
         var6 = var1.readUnsignedByte();
         var7 = var6 >> 2;
         var8 = var6 & 3;
         var9 = Client.field1058[var7];
         if(var37 >= 0 && var4 >= 0 && var37 < 103 && var4 < 103) {
            if(var9 == 0) {
               WallObject var10 = class308.region.method2996(class237.plane, var37, var4);
               if(var10 != null) {
                  var42 = var10.hash >> 14 & 32767;
                  if(var7 == 2) {
                     var10.renderable1 = new DynamicObject(var42, 2, var8 + 4, class237.plane, var37, var4, var5, false, var10.renderable1);
                     var10.renderable2 = new DynamicObject(var42, 2, var8 + 1 & 3, class237.plane, var37, var4, var5, false, var10.renderable2);
                  } else {
                     var10.renderable1 = new DynamicObject(var42, var7, var8, class237.plane, var37, var4, var5, false, var10.renderable1);
                  }
               }
            }

            if(var9 == 1) {
               DecorativeObject var39 = class308.region.method2899(class237.plane, var37, var4);
               if(var39 != null) {
                  var42 = var39.hash >> 14 & 32767;
                  if(var7 != 4 && var7 != 5) {
                     if(var7 == 6) {
                        var39.renderable1 = new DynamicObject(var42, 4, var8 + 4, class237.plane, var37, var4, var5, false, var39.renderable1);
                     } else if(var7 == 7) {
                        var39.renderable1 = new DynamicObject(var42, 4, (var8 + 2 & 3) + 4, class237.plane, var37, var4, var5, false, var39.renderable1);
                     } else if(var7 == 8) {
                        var39.renderable1 = new DynamicObject(var42, 4, var8 + 4, class237.plane, var37, var4, var5, false, var39.renderable1);
                        var39.renderable2 = new DynamicObject(var42, 4, (var8 + 2 & 3) + 4, class237.plane, var37, var4, var5, false, var39.renderable2);
                     }
                  } else {
                     var39.renderable1 = new DynamicObject(var42, 4, var8, class237.plane, var37, var4, var5, false, var39.renderable1);
                  }
               }
            }

            if(var9 == 2) {
               GameObject var40 = class308.region.method2900(class237.plane, var37, var4);
               if(var7 == 11) {
                  var7 = 10;
               }

               if(var40 != null) {
                  var40.renderable = new DynamicObject(var40.hash >> 14 & 32767, var7, var8, class237.plane, var37, var4, var5, false, var40.renderable);
               }
            }

            if(var9 == 3) {
               GroundObject var41 = class308.region.getFloorDecoration(class237.plane, var37, var4);
               if(var41 != null) {
                  var41.renderable = new DynamicObject(var41.hash >> 14 & 32767, 22, var8, class237.plane, var37, var4, var5, false, var41.renderable);
               }
            }
         }

      } else {
         int var12;
         int var13;
         int var14;
         int var31;
         if(class183.field2487 == var0) {
            var2 = var1.readUnsignedShort();
            byte var3 = var1.readByte();
            var4 = var1.method3548();
            var5 = var4 >> 2;
            var6 = var4 & 3;
            var7 = Client.field1058[var5];
            var8 = var1.method3673();
            var9 = (var8 >> 4 & 7) + WorldMapManager.field533;
            var31 = (var8 & 7) + GameEngine.field673;
            byte var11 = var1.method3551();
            var12 = var1.readUnsignedShort();
            var13 = var1.method3513();
            var14 = var1.method3513();
            byte var15 = var1.method3552();
            byte var16 = var1.method3551();
            Player var17;
            if(var13 == Client.localInteractingIndex) {
               var17 = WorldComparator.localPlayer;
            } else {
               var17 = Client.cachedPlayers[var13];
            }

            if(var17 != null) {
               ObjectComposition var18 = FileRequest.getObjectDefinition(var14);
               int var19;
               int var20;
               if(var6 != 1 && var6 != 3) {
                  var19 = var18.width;
                  var20 = var18.length;
               } else {
                  var19 = var18.length;
                  var20 = var18.width;
               }

               int var21 = var9 + (var19 >> 1);
               int var22 = var9 + (var19 + 1 >> 1);
               int var23 = var31 + (var20 >> 1);
               int var24 = var31 + (var20 + 1 >> 1);
               int[][] var25 = class62.tileHeights[class237.plane];
               int var26 = var25[var22][var24] + var25[var21][var23] + var25[var22][var23] + var25[var21][var24] >> 2;
               int var27 = (var9 << 7) + (var19 << 6);
               int var28 = (var31 << 7) + (var20 << 6);
               Model var29 = var18.method5005(var5, var6, var25, var27, var26, var28);
               if(var29 != null) {
                  class231.method4260(class237.plane, var9, var31, var7, -1, 0, 0, var12 + 1, var2 + 1);
                  var17.animationCycleStart = var12 + Client.gameCycle;
                  var17.animationCycleEnd = var2 + Client.gameCycle;
                  var17.model = var29;
                  var17.field831 = var9 * 128 + var19 * 64;
                  var17.field833 = var31 * 128 + var20 * 64;
                  var17.field821 = var26;
                  byte var30;
                  if(var3 > var15) {
                     var30 = var3;
                     var3 = var15;
                     var15 = var30;
                  }

                  if(var16 > var11) {
                     var30 = var16;
                     var16 = var11;
                     var11 = var30;
                  }

                  var17.field835 = var9 + var3;
                  var17.field848 = var9 + var15;
                  var17.field826 = var31 + var16;
                  var17.field838 = var31 + var11;
               }
            }
         }

         if(class183.field2481 == var0) {
            var2 = var1.method3716();
            var37 = var1.method3548();
            var4 = (var37 >> 4 & 7) + WorldMapManager.field533;
            var5 = (var37 & 7) + GameEngine.field673;
            var6 = var1.method3673();
            var7 = var1.method3513();
            if(var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
               var4 = var4 * 128 + 64;
               var5 = var5 * 128 + 64;
               GraphicsObject var44 = new GraphicsObject(var2, class237.plane, var4, var5, class5.getTileHeight(var4, var5, class237.plane) - var6, var7, Client.gameCycle);
               Client.graphicsObjectDeque.addFront(var44);
            }

         } else if(class183.field2482 == var0) {
            var2 = var1.method3548();
            var37 = (var2 >> 4 & 7) + WorldMapManager.field533;
            var4 = (var2 & 7) + GameEngine.field673;
            var5 = var1.method3716();
            var6 = var1.method3513();
            var7 = var1.readUnsignedShort();
            if(var37 >= 0 && var4 >= 0 && var37 < 104 && var4 < 104) {
               Deque var32 = Client.groundItemDeque[class237.plane][var37][var4];
               if(var32 != null) {
                  for(Item var33 = (Item)var32.getFront(); var33 != null; var33 = (Item)var32.getNext()) {
                     if((var7 & 32767) == var33.id && var5 == var33.quantity) {
                        var33.quantity = var6;
                        break;
                     }
                  }

                  WorldComparator.groundItemSpawned(var37, var4);
               }
            }

         } else {
            if(class183.field2488 == var0) {
               var2 = var1.method3549();
               var37 = (var2 >> 4 & 7) + WorldMapManager.field533;
               var4 = (var2 & 7) + GameEngine.field673;
               var5 = var1.method3673();
               var6 = var1.readUnsignedShort();
               var7 = var1.readUnsignedByte();
               var8 = var7 >> 4 & 15;
               var9 = var7 & 7;
               if(var37 >= 0 && var4 >= 0 && var37 < 104 && var4 < 104) {
                  var31 = var8 + 1;
                  if(WorldComparator.localPlayer.pathX[0] >= var37 - var31 && WorldComparator.localPlayer.pathX[0] <= var31 + var37 && WorldComparator.localPlayer.pathY[0] >= var4 - var31 && WorldComparator.localPlayer.pathY[0] <= var31 + var4 && Client.field1034 != 0 && var9 > 0 && Client.queuedSoundEffectCount < 50) {
                     Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var6;
                     Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var9;
                     Client.unknownSoundValues2[Client.queuedSoundEffectCount] = var5;
                     Client.audioEffects[Client.queuedSoundEffectCount] = null;
                     Client.soundLocations[Client.queuedSoundEffectCount] = var8 + (var4 << 8) + (var37 << 16);
                     ++Client.queuedSoundEffectCount;
                  }
               }
            }

            if(class183.field2485 == var0) {
               byte var38 = var1.method3552();
               var37 = var1.method3549() * 4;
               var4 = var1.method3626();
               var5 = var1.method3549();
               var6 = (var5 >> 4 & 7) + WorldMapManager.field533;
               var7 = (var5 & 7) + GameEngine.field673;
               var8 = var1.readUnsignedByte();
               var9 = var1.readUnsignedByte() * 4;
               var31 = var1.readUnsignedByte();
               var42 = var1.method3716();
               byte var43 = var1.method3550();
               var13 = var1.readUnsignedShort();
               var14 = var1.readUnsignedShort();
               var2 = var38 + var6;
               var12 = var43 + var7;
               if(var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104 && var2 >= 0 && var12 >= 0 && var2 < 104 && var12 < 104 && var14 != 65535) {
                  var6 = var6 * 128 + 64;
                  var7 = var7 * 128 + 64;
                  var2 = var2 * 128 + 64;
                  var12 = var12 * 128 + 64;
                  Projectile var34 = new Projectile(var14, class237.plane, var6, var7, class5.getTileHeight(var6, var7, class237.plane) - var9, var42 + Client.gameCycle, var13 + Client.gameCycle, var8, var31, var4, var37);
                  var34.moveProjectile(var2, var12, class5.getTileHeight(var2, var12, class237.plane) - var37, var42 + Client.gameCycle);
                  Client.projectiles.addFront(var34);
               }

            } else {
               Item var35;
               if(class183.field2486 == var0) {
                  var2 = var1.readUnsignedShortOb1();
                  var37 = var1.method3716();
                  var4 = var1.method3548();
                  var5 = (var4 >> 4 & 7) + WorldMapManager.field533;
                  var6 = (var4 & 7) + GameEngine.field673;
                  if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                     var35 = new Item();
                     var35.id = var2;
                     var35.quantity = var37;
                     if(Client.groundItemDeque[class237.plane][var5][var6] == null) {
                        Client.groundItemDeque[class237.plane][var5][var6] = new Deque();
                     }

                     Client.groundItemDeque[class237.plane][var5][var6].addFront(var35);
                     WorldComparator.groundItemSpawned(var5, var6);
                  }

               } else if(class183.field2484 == var0) {
                  var2 = var1.method3673();
                  var37 = (var2 >> 4 & 7) + WorldMapManager.field533;
                  var4 = (var2 & 7) + GameEngine.field673;
                  var5 = var1.method3548();
                  var6 = var5 >> 2;
                  var7 = var5 & 3;
                  var8 = Client.field1058[var6];
                  if(var37 >= 0 && var4 >= 0 && var37 < 104 && var4 < 104) {
                     class231.method4260(class237.plane, var37, var4, var8, -1, var6, var7, 0, -1);
                  }

               } else if(class183.field2490 == var0) {
                  var2 = var1.method3673();
                  var37 = (var2 >> 4 & 7) + WorldMapManager.field533;
                  var4 = (var2 & 7) + GameEngine.field673;
                  var5 = var1.method3716();
                  var6 = var1.method3549();
                  var7 = var6 >> 2;
                  var8 = var6 & 3;
                  var9 = Client.field1058[var7];
                  if(var37 >= 0 && var4 >= 0 && var37 < 104 && var4 < 104) {
                     class231.method4260(class237.plane, var37, var4, var9, var5, var7, var8, 0, -1);
                  }

               } else if(class183.field2483 == var0) {
                  var2 = var1.readUnsignedShortOb1();
                  var37 = var1.method3548();
                  var4 = (var37 >> 4 & 7) + WorldMapManager.field533;
                  var5 = (var37 & 7) + GameEngine.field673;
                  if(var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
                     Deque var36 = Client.groundItemDeque[class237.plane][var4][var5];
                     if(var36 != null) {
                        for(var35 = (Item)var36.getFront(); var35 != null; var35 = (Item)var36.getNext()) {
                           if((var2 & 32767) == var35.id) {
                              var35.unlink();
                              break;
                           }
                        }

                        if(var36.getFront() == null) {
                           Client.groundItemDeque[class237.plane][var4][var5] = null;
                        }

                        WorldComparator.groundItemSpawned(var4, var5);
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "1432765235"
   )
   static final void method61(int var0, int var1, int var2, boolean var3) {
      if(Name.loadWidget(var0)) {
         Tile.method2679(class189.widgets[var0], -1, var1, var2, var3);
      }
   }
}
