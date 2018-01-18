import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("p")
   static int[] field788;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1416062019
   )
   @Export("id")
   int id;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 421860697
   )
   @Export("owner")
   int owner;
   @ObfuscatedName("y")
   boolean field792;

   WidgetNode() {
      this.field792 = false;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "781538510"
   )
   static int method1104(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "1254292922"
   )
   static int method1105(int var0, Script var1, boolean var2) {
      Widget var3 = UrlRequester.getWidget(class82.intStack[--class82.intStackSize]);
      if(var0 == 2800) {
         int[] var4 = class82.intStack;
         int var5 = ++class82.intStackSize - 1;
         int var7 = GraphicsObject.getWidgetConfig(var3);
         int var6 = var7 >> 11 & 63;
         var4[var5] = var6;
         return 1;
      } else if(var0 != 2801) {
         if(var0 == 2802) {
            if(var3.name == null) {
               class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
            } else {
               class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var8 = class82.intStack[--class82.intStackSize];
         --var8;
         if(var3.actions != null && var8 < var3.actions.length && var3.actions[var8] != null) {
            class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var3.actions[var8];
         } else {
            class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(Lfe;I)V",
      garbageValue = "-110827604"
   )
   static final void method1103(class173 var0) {
      PacketBuffer var1 = Client.field915.packetBuffer;
      int var2;
      int var3;
      int var4;
      int var5;
      int var7;
      int var37;
      if(class173.field2440 == var0) {
         var2 = var1.method3363();
         var3 = (var2 >> 4 & 7) + WorldMapType2.field505;
         var4 = (var2 & 7) + CombatInfo1.field1215;
         var5 = var1.readUnsignedShortOb1();
         var37 = var1.method3518();
         var7 = var1.method3337();
         if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
            Deque var38 = Client.groundItemDeque[class7.plane][var3][var4];
            if(var38 != null) {
               for(Item var9 = (Item)var38.getFront(); var9 != null; var9 = (Item)var38.getNext()) {
                  if((var7 & 32767) == var9.id && var5 == var9.quantity) {
                     var9.quantity = var37;
                     break;
                  }
               }

               MessageNode.groundItemSpawned(var3, var4);
            }
         }

      } else {
         Item var32;
         if(class173.field2442 == var0) {
            var2 = var1.method3374();
            var3 = (var2 >> 4 & 7) + WorldMapType2.field505;
            var4 = (var2 & 7) + CombatInfo1.field1215;
            var5 = var1.method3518();
            if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
               Deque var31 = Client.groundItemDeque[class7.plane][var3][var4];
               if(var31 != null) {
                  for(var32 = (Item)var31.getFront(); var32 != null; var32 = (Item)var31.getNext()) {
                     if((var5 & 32767) == var32.id) {
                        var32.unlink();
                        break;
                     }
                  }

                  if(var31.getFront() == null) {
                     Client.groundItemDeque[class7.plane][var3][var4] = null;
                  }

                  MessageNode.groundItemSpawned(var3, var4);
               }
            }

         } else {
            byte var6;
            int var10;
            int var11;
            int var12;
            int var13;
            byte var33;
            int var34;
            if(class173.field2438 == var0) {
               var2 = var1.readUnsignedByte();
               var3 = (var2 >> 4 & 7) + WorldMapType2.field505;
               var4 = (var2 & 7) + CombatInfo1.field1215;
               var5 = var1.method3337();
               var6 = var1.method3368();
               var7 = var1.readUnsignedShort();
               var33 = var1.method3395();
               var34 = var1.method3374();
               var10 = var34 >> 2;
               var11 = var34 & 3;
               var12 = Client.field930[var10];
               var13 = var1.method3518();
               byte var14 = var1.readByte();
               int var15 = var1.method3337();
               byte var16 = var1.method3367();
               Player var17;
               if(var7 == Client.localInteractingIndex) {
                  var17 = GrandExchangeOffer.localPlayer;
               } else {
                  var17 = Client.cachedPlayers[var7];
               }

               if(var17 != null) {
                  ObjectComposition var18 = NPC.getObjectDefinition(var15);
                  int var19;
                  int var20;
                  if(var11 != 1 && var11 != 3) {
                     var19 = var18.width;
                     var20 = var18.length;
                  } else {
                     var19 = var18.length;
                     var20 = var18.width;
                  }

                  int var21 = var3 + (var19 >> 1);
                  int var22 = var3 + (var19 + 1 >> 1);
                  int var23 = var4 + (var20 >> 1);
                  int var24 = var4 + (var20 + 1 >> 1);
                  int[][] var25 = class61.tileHeights[class7.plane];
                  int var26 = var25[var22][var23] + var25[var21][var23] + var25[var21][var24] + var25[var22][var24] >> 2;
                  int var27 = (var3 << 7) + (var19 << 6);
                  int var28 = (var4 << 7) + (var20 << 6);
                  Model var29 = var18.method4711(var10, var11, var25, var27, var26, var28);
                  if(var29 != null) {
                     class19.method144(class7.plane, var3, var4, var12, -1, 0, 0, var13 + 1, var5 + 1);
                     var17.animationCycleStart = var13 + Client.gameCycle;
                     var17.animationCycleEnd = var5 + Client.gameCycle;
                     var17.model = var29;
                     var17.field845 = var3 * 128 + var19 * 64;
                     var17.field847 = var4 * 128 + var20 * 64;
                     var17.field846 = var26;
                     byte var30;
                     if(var33 > var16) {
                        var30 = var33;
                        var33 = var16;
                        var16 = var30;
                     }

                     if(var14 > var6) {
                        var30 = var14;
                        var14 = var6;
                        var6 = var30;
                     }

                     var17.field849 = var33 + var3;
                     var17.field851 = var16 + var3;
                     var17.field850 = var14 + var4;
                     var17.field852 = var4 + var6;
                  }
               }
            }

            int var40;
            if(class173.field2447 == var0) {
               var2 = var1.method3374();
               var3 = var1.readShort();
               var4 = var1.readUnsignedByte() * 4;
               var5 = var1.readUnsignedShortOb1();
               var6 = var1.method3395();
               var7 = var1.readUnsignedShortOb1();
               var33 = var1.method3395();
               var34 = var1.method3363();
               var10 = var1.method3374() * 4;
               var11 = var1.method3363();
               var12 = (var11 >> 4 & 7) + WorldMapType2.field505;
               var13 = (var11 & 7) + CombatInfo1.field1215;
               int var39 = var1.method3337();
               var37 = var6 + var12;
               var40 = var33 + var13;
               if(var12 >= 0 && var13 >= 0 && var12 < 104 && var13 < 104 && var37 >= 0 && var40 >= 0 && var37 < 104 && var40 < 104 && var5 != 65535) {
                  var12 = var12 * 128 + 64;
                  var13 = var13 * 128 + 64;
                  var37 = var37 * 128 + 64;
                  var40 = var40 * 128 + 64;
                  Projectile var35 = new Projectile(var5, class7.plane, var12, var13, MouseInput.getTileHeight(var12, var13, class7.plane) - var4, var39 + Client.gameCycle, var7 + Client.gameCycle, var34, var2, var3, var10);
                  var35.moveProjectile(var37, var40, MouseInput.getTileHeight(var37, var40, class7.plane) - var10, var39 + Client.gameCycle);
                  Client.projectiles.addFront(var35);
               }

            } else if(class173.field2439 != var0) {
               if(class173.field2444 == var0) {
                  var2 = var1.readUnsignedShort();
                  var3 = var1.method3363();
                  var4 = var1.readUnsignedByteNegate();
                  var5 = (var4 >> 4 & 7) + WorldMapType2.field505;
                  var37 = (var4 & 7) + CombatInfo1.field1215;
                  var7 = var1.readUnsignedShortOb1();
                  if(var5 >= 0 && var37 >= 0 && var5 < 104 && var37 < 104) {
                     var5 = var5 * 128 + 64;
                     var37 = var37 * 128 + 64;
                     GraphicsObject var8 = new GraphicsObject(var2, class7.plane, var5, var37, MouseInput.getTileHeight(var5, var37, class7.plane) - var3, var7, Client.gameCycle);
                     Client.graphicsObjectDeque.addFront(var8);
                  }

               } else if(class173.field2437 == var0) {
                  var2 = var1.readUnsignedByte();
                  var3 = var2 >> 2;
                  var4 = var2 & 3;
                  var5 = Client.field930[var3];
                  var37 = var1.readUnsignedByteNegate();
                  var7 = (var37 >> 4 & 7) + WorldMapType2.field505;
                  var40 = (var37 & 7) + CombatInfo1.field1215;
                  var34 = var1.method3337();
                  if(var7 >= 0 && var40 >= 0 && var7 < 104 && var40 < 104) {
                     class19.method144(class7.plane, var7, var40, var5, var34, var3, var4, 0, -1);
                  }

               } else if(class173.field2443 == var0) {
                  var2 = var1.method3374();
                  var3 = var2 >> 2;
                  var4 = var2 & 3;
                  var5 = Client.field930[var3];
                  var37 = var1.method3363();
                  var7 = (var37 >> 4 & 7) + WorldMapType2.field505;
                  var40 = (var37 & 7) + CombatInfo1.field1215;
                  if(var7 >= 0 && var40 >= 0 && var7 < 104 && var40 < 104) {
                     class19.method144(class7.plane, var7, var40, var5, -1, var3, var4, 0, -1);
                  }

               } else if(class173.field2436 == var0) {
                  var2 = var1.method3337();
                  var3 = var1.readUnsignedShortOb1();
                  var4 = var1.readUnsignedByte();
                  var5 = (var4 >> 4 & 7) + WorldMapType2.field505;
                  var37 = (var4 & 7) + CombatInfo1.field1215;
                  if(var5 >= 0 && var37 >= 0 && var5 < 104 && var37 < 104) {
                     var32 = new Item();
                     var32.id = var3;
                     var32.quantity = var2;
                     if(Client.groundItemDeque[class7.plane][var5][var37] == null) {
                        Client.groundItemDeque[class7.plane][var5][var37] = new Deque();
                     }

                     Client.groundItemDeque[class7.plane][var5][var37].addFront(var32);
                     MessageNode.groundItemSpawned(var5, var37);
                  }

               } else {
                  if(class173.field2445 == var0) {
                     var2 = var1.readUnsignedByte();
                     var3 = var2 >> 4 & 15;
                     var4 = var2 & 7;
                     var5 = var1.readUnsignedShortOb1();
                     var37 = var1.method3363();
                     var7 = (var37 >> 4 & 7) + WorldMapType2.field505;
                     var40 = (var37 & 7) + CombatInfo1.field1215;
                     var34 = var1.readUnsignedByteNegate();
                     if(var7 >= 0 && var40 >= 0 && var7 < 104 && var40 < 104) {
                        var10 = var3 + 1;
                        if(GrandExchangeOffer.localPlayer.pathX[0] >= var7 - var10 && GrandExchangeOffer.localPlayer.pathX[0] <= var10 + var7 && GrandExchangeOffer.localPlayer.pathY[0] >= var40 - var10 && GrandExchangeOffer.localPlayer.pathY[0] <= var10 + var40 && Client.field1094 != 0 && var4 > 0 && Client.field1025 < 50) {
                           Client.field1096[Client.field1025] = var5;
                           Client.field1027[Client.field1025] = var4;
                           Client.field1098[Client.field1025] = var34;
                           Client.audioEffects[Client.field1025] = null;
                           Client.field1099[Client.field1025] = var3 + (var40 << 8) + (var7 << 16);
                           ++Client.field1025;
                        }
                     }
                  }

               }
            } else {
               var2 = var1.readUnsignedShort();
               var3 = var1.readUnsignedByte();
               var4 = (var3 >> 4 & 7) + WorldMapType2.field505;
               var5 = (var3 & 7) + CombatInfo1.field1215;
               var37 = var1.readUnsignedByte();
               var7 = var37 >> 2;
               var40 = var37 & 3;
               var34 = Client.field930[var7];
               if(var4 >= 0 && var5 >= 0 && var4 < 103 && var5 < 103) {
                  if(var34 == 0) {
                     WallObject var36 = class45.region.method2768(class7.plane, var4, var5);
                     if(var36 != null) {
                        var11 = var36.hash >> 14 & 32767;
                        if(var7 == 2) {
                           var36.renderable1 = new DynamicObject(var11, 2, var40 + 4, class7.plane, var4, var5, var2, false, var36.renderable1);
                           var36.renderable2 = new DynamicObject(var11, 2, var40 + 1 & 3, class7.plane, var4, var5, var2, false, var36.renderable2);
                        } else {
                           var36.renderable1 = new DynamicObject(var11, var7, var40, class7.plane, var4, var5, var2, false, var36.renderable1);
                        }
                     }
                  }

                  if(var34 == 1) {
                     DecorativeObject var41 = class45.region.method2769(class7.plane, var4, var5);
                     if(var41 != null) {
                        var11 = var41.hash >> 14 & 32767;
                        if(var7 != 4 && var7 != 5) {
                           if(var7 == 6) {
                              var41.renderable1 = new DynamicObject(var11, 4, var40 + 4, class7.plane, var4, var5, var2, false, var41.renderable1);
                           } else if(var7 == 7) {
                              var41.renderable1 = new DynamicObject(var11, 4, (var40 + 2 & 3) + 4, class7.plane, var4, var5, var2, false, var41.renderable1);
                           } else if(var7 == 8) {
                              var41.renderable1 = new DynamicObject(var11, 4, var40 + 4, class7.plane, var4, var5, var2, false, var41.renderable1);
                              var41.renderable2 = new DynamicObject(var11, 4, (var40 + 2 & 3) + 4, class7.plane, var4, var5, var2, false, var41.renderable2);
                           }
                        } else {
                           var41.renderable1 = new DynamicObject(var11, 4, var40, class7.plane, var4, var5, var2, false, var41.renderable1);
                        }
                     }
                  }

                  if(var34 == 2) {
                     GameObject var42 = class45.region.method2853(class7.plane, var4, var5);
                     if(var7 == 11) {
                        var7 = 10;
                     }

                     if(var42 != null) {
                        var42.renderable = new DynamicObject(var42.hash >> 14 & 32767, var7, var40, class7.plane, var4, var5, var2, false, var42.renderable);
                     }
                  }

                  if(var34 == 3) {
                     GroundObject var43 = class45.region.getFloorDecoration(class7.plane, var4, var5);
                     if(var43 != null) {
                        var43.renderable = new DynamicObject(var43.hash >> 14 & 32767, 22, var40, class7.plane, var4, var5, var2, false, var43.renderable);
                     }
                  }
               }

            }
         }
      }
   }
}
