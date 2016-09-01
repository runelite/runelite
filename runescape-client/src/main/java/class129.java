import java.awt.Canvas;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
public class class129 {
   @ObfuscatedName("qy")
   @Export("canvas")
   public static Canvas canvas;
   @ObfuscatedName("bk")
   static class171 field2094;
   @ObfuscatedName("z")
   static String[] field2096;

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "6"
   )
   static final void method2870() {
      int var0;
      int var1;
      int var2;
      int var3;
      Item var29;
      if(Client.packetOpcode == 109) {
         var0 = Client.field446.method2752();
         var1 = (var0 >> 4 & 7) + class13.field196;
         var2 = class112.field1969 + (var0 & 7);
         var3 = Client.field446.method2591();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            Deque var4 = Client.groundItemDeque[FrameMap.plane][var1][var2];
            if(var4 != null) {
               for(var29 = (Item)var4.method3850(); var29 != null; var29 = (Item)var4.method3852()) {
                  if((var3 & 32767) == var29.id) {
                     var29.unlink();
                     break;
                  }
               }

               if(var4.method3850() == null) {
                  Client.groundItemDeque[FrameMap.plane][var1][var2] = null;
               }

               class116.groundItemSpawned(var1, var2);
            }
         }

      } else {
         int var5;
         int var7;
         int var8;
         int var30;
         int var31;
         if(Client.packetOpcode == 113) {
            var0 = Client.field446.method2556();
            var1 = class13.field196 + (var0 >> 4 & 7);
            var2 = class112.field1969 + (var0 & 7);
            var3 = Client.field446.method2551();
            var30 = Client.field446.method2556();
            var5 = var30 >> 4 & 15;
            var31 = var30 & 7;
            var7 = Client.field446.method2556();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               var8 = 1 + var5;
               if(class48.localPlayer.pathX[0] >= var1 - var8 && class48.localPlayer.pathX[0] <= var1 + var8 && class48.localPlayer.pathY[0] >= var2 - var8 && class48.localPlayer.pathY[0] <= var2 + var8 && Client.field520 != 0 && var31 > 0 && Client.field521 < 50) {
                  Client.field325[Client.field521] = var3;
                  Client.field523[Client.field521] = var31;
                  Client.field286[Client.field521] = var7;
                  Client.field526[Client.field521] = null;
                  Client.field434[Client.field521] = var5 + (var1 << 16) + (var2 << 8);
                  ++Client.field521;
               }
            }
         }

         if(Client.packetOpcode == 42) {
            var0 = Client.field446.method2752();
            var1 = var0 >> 2;
            var2 = var0 & 3;
            var3 = Client.field343[var1];
            var30 = Client.field446.method2556();
            var5 = (var30 >> 4 & 7) + class13.field196;
            var31 = (var30 & 7) + class112.field1969;
            if(var5 >= 0 && var31 >= 0 && var5 < 104 && var31 < 104) {
               class49.method1001(FrameMap.plane, var5, var31, var3, -1, var1, var2, 0, -1);
            }

         } else if(Client.packetOpcode == 225) {
            var0 = Client.field446.method2556();
            var1 = (var0 >> 4 & 7) + class13.field196;
            var2 = class112.field1969 + (var0 & 7);
            var3 = Client.field446.method2551();
            var30 = Client.field446.method2551();
            var5 = Client.field446.method2551();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               Deque var36 = Client.groundItemDeque[FrameMap.plane][var1][var2];
               if(null != var36) {
                  for(Item var33 = (Item)var36.method3850(); null != var33; var33 = (Item)var36.method3852()) {
                     if(var33.id == (var3 & 32767) && var30 == var33.quantity) {
                        var33.quantity = var5;
                        break;
                     }
                  }

                  class116.groundItemSpawned(var1, var2);
               }
            }

         } else {
            int var10;
            int var11;
            int var12;
            int var38;
            if(Client.packetOpcode == 250) {
               var0 = Client.field446.method2556();
               var1 = (var0 >> 4 & 7) + class13.field196;
               var2 = (var0 & 7) + class112.field1969;
               var3 = var1 + Client.field446.method2557();
               var30 = var2 + Client.field446.method2557();
               var5 = Client.field446.method2759();
               var31 = Client.field446.method2551();
               var7 = Client.field446.method2556() * 4;
               var8 = Client.field446.method2556() * 4;
               var38 = Client.field446.method2551();
               var10 = Client.field446.method2551();
               var11 = Client.field446.method2556();
               var12 = Client.field446.method2556();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var30 >= 0 && var3 < 104 && var30 < 104 && var31 != '\uffff') {
                  var1 = 64 + 128 * var1;
                  var2 = 128 * var2 + 64;
                  var3 = 64 + var3 * 128;
                  var30 = 128 * var30 + 64;
                  Projectile var13 = new Projectile(var31, FrameMap.plane, var1, var2, KitDefinition.method936(var1, var2, FrameMap.plane) - var7, var38 + Client.gameCycle, Client.gameCycle + var10, var11, var12, var5, var8);
                  var13.method101(var3, var30, KitDefinition.method936(var3, var30, FrameMap.plane) - var8, Client.gameCycle + var38);
                  Client.projectiles.method3844(var13);
               }

            } else if(Client.packetOpcode == 168) {
               var0 = Client.field446.method2592();
               var1 = Client.field446.method2583();
               var2 = var1 >> 2;
               var3 = var1 & 3;
               var30 = Client.field343[var2];
               var5 = Client.field446.method2556();
               var31 = (var5 >> 4 & 7) + class13.field196;
               var7 = class112.field1969 + (var5 & 7);
               if(var31 >= 0 && var7 >= 0 && var31 < 103 && var7 < 103) {
                  if(var30 == 0) {
                     WallObject var32 = Projectile.region.method1970(FrameMap.plane, var31, var7);
                     if(var32 != null) {
                        var38 = var32.hash >> 14 & 32767;
                        if(var2 == 2) {
                           var32.renderable1 = new class12(var38, 2, 4 + var3, FrameMap.plane, var31, var7, var0, false, var32.renderable1);
                           var32.renderable2 = new class12(var38, 2, 1 + var3 & 3, FrameMap.plane, var31, var7, var0, false, var32.renderable2);
                        } else {
                           var32.renderable1 = new class12(var38, var2, var3, FrameMap.plane, var31, var7, var0, false, var32.renderable1);
                        }
                     }
                  }

                  if(var30 == 1) {
                     DecorativeObject var40 = Projectile.region.method1971(FrameMap.plane, var31, var7);
                     if(var40 != null) {
                        var38 = var40.hash >> 14 & 32767;
                        if(var2 != 4 && var2 != 5) {
                           if(var2 == 6) {
                              var40.renderable1 = new class12(var38, 4, 4 + var3, FrameMap.plane, var31, var7, var0, false, var40.renderable1);
                           } else if(var2 == 7) {
                              var40.renderable1 = new class12(var38, 4, (2 + var3 & 3) + 4, FrameMap.plane, var31, var7, var0, false, var40.renderable1);
                           } else if(var2 == 8) {
                              var40.renderable1 = new class12(var38, 4, var3 + 4, FrameMap.plane, var31, var7, var0, false, var40.renderable1);
                              var40.renderable2 = new class12(var38, 4, (var3 + 2 & 3) + 4, FrameMap.plane, var31, var7, var0, false, var40.renderable2);
                           }
                        } else {
                           var40.renderable1 = new class12(var38, 4, var3, FrameMap.plane, var31, var7, var0, false, var40.renderable1);
                        }
                     }
                  }

                  if(var30 == 2) {
                     GameObject var41 = Projectile.region.method2084(FrameMap.plane, var31, var7);
                     if(var2 == 11) {
                        var2 = 10;
                     }

                     if(var41 != null) {
                        var41.renderable = new class12(var41.hash >> 14 & 32767, var2, var3, FrameMap.plane, var31, var7, var0, false, var41.renderable);
                     }
                  }

                  if(var30 == 3) {
                     GroundObject var42 = Projectile.region.method2037(FrameMap.plane, var31, var7);
                     if(null != var42) {
                        var42.renderable = new class12(var42.hash >> 14 & 32767, 22, var3, FrameMap.plane, var31, var7, var0, false, var42.renderable);
                     }
                  }
               }

            } else {
               if(Client.packetOpcode == 95) {
                  byte var35 = Client.field446.method2686();
                  var1 = Client.field446.method2593();
                  var2 = Client.field446.method2593();
                  var3 = Client.field446.method2591();
                  byte var39 = Client.field446.method2587();
                  var5 = Client.field446.method2556();
                  var31 = (var5 >> 4 & 7) + class13.field196;
                  var7 = class112.field1969 + (var5 & 7);
                  byte var37 = Client.field446.method2587();
                  byte var9 = Client.field446.method2586();
                  var10 = Client.field446.method2583();
                  var11 = var10 >> 2;
                  var12 = var10 & 3;
                  int var34 = Client.field343[var11];
                  int var14 = Client.field446.method2592();
                  Player var15;
                  if(var2 == Client.localInteractingIndex) {
                     var15 = class48.localPlayer;
                  } else {
                     var15 = Client.cachedPlayers[var2];
                  }

                  if(null != var15) {
                     ObjectComposition var16 = class1.getObjectDefinition(var3);
                     int var17;
                     int var18;
                     if(var12 != 1 && var12 != 3) {
                        var17 = var16.field938;
                        var18 = var16.field939;
                     } else {
                        var17 = var16.field939;
                        var18 = var16.field938;
                     }

                     int var19 = (var17 >> 1) + var31;
                     int var20 = var31 + (var17 + 1 >> 1);
                     int var21 = var7 + (var18 >> 1);
                     int var22 = var7 + (var18 + 1 >> 1);
                     int[][] var23 = class5.tileHeights[FrameMap.plane];
                     int var24 = var23[var20][var21] + var23[var19][var21] + var23[var19][var22] + var23[var20][var22] >> 2;
                     int var25 = (var31 << 7) + (var17 << 6);
                     int var26 = (var7 << 7) + (var18 << 6);
                     Model var27 = var16.method812(var11, var12, var23, var25, var24, var26);
                     if(null != var27) {
                        class49.method1001(FrameMap.plane, var31, var7, var34, -1, 0, 0, var14 + 1, 1 + var1);
                        var15.totalLevel = Client.gameCycle + var14;
                        var15.field35 = Client.gameCycle + var1;
                        var15.model = var27;
                        var15.field36 = 64 * var17 + 128 * var31;
                        var15.field30 = var18 * 64 + var7 * 128;
                        var15.field45 = var24;
                        byte var28;
                        if(var9 > var37) {
                           var28 = var9;
                           var9 = var37;
                           var37 = var28;
                        }

                        if(var35 > var39) {
                           var28 = var35;
                           var35 = var39;
                           var39 = var28;
                        }

                        var15.field40 = var31 + var9;
                        var15.field42 = var31 + var37;
                        var15.field38 = var35 + var7;
                        var15.field43 = var39 + var7;
                     }
                  }
               }

               if(Client.packetOpcode == 152) {
                  var0 = Client.field446.method2556();
                  var1 = (var0 >> 4 & 7) + class13.field196;
                  var2 = (var0 & 7) + class112.field1969;
                  var3 = Client.field446.method2551();
                  var30 = Client.field446.method2556();
                  var5 = Client.field446.method2551();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var1 = 64 + 128 * var1;
                     var2 = 128 * var2 + 64;
                     class31 var6 = new class31(var3, FrameMap.plane, var1, var2, KitDefinition.method936(var1, var2, FrameMap.plane) - var30, var5, Client.gameCycle);
                     Client.field357.method3844(var6);
                  }

               } else if(Client.packetOpcode == 142) {
                  var0 = Client.field446.method2592();
                  var1 = Client.field446.method2556();
                  var2 = (var1 >> 4 & 7) + class13.field196;
                  var3 = class112.field1969 + (var1 & 7);
                  var30 = Client.field446.method2599();
                  var5 = var30 >> 2;
                  var31 = var30 & 3;
                  var7 = Client.field343[var5];
                  if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
                     class49.method1001(FrameMap.plane, var2, var3, var7, var0, var5, var31, 0, -1);
                  }

               } else if(Client.packetOpcode == 82) {
                  var0 = Client.field446.method2556();
                  var1 = (var0 >> 4 & 7) + class13.field196;
                  var2 = class112.field1969 + (var0 & 7);
                  var3 = Client.field446.method2591();
                  var30 = Client.field446.method2593();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var29 = new Item();
                     var29.id = var3;
                     var29.quantity = var30;
                     if(Client.groundItemDeque[FrameMap.plane][var1][var2] == null) {
                        Client.groundItemDeque[FrameMap.plane][var1][var2] = new Deque();
                     }

                     Client.groundItemDeque[FrameMap.plane][var1][var2].method3844(var29);
                     class116.groundItemSpawned(var1, var2);
                  }

               }
            }
         }
      }
   }
}
