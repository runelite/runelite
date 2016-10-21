import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("e")
   String field631;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1986281855
   )
   @Export("world")
   int world;
   @ObfuscatedName("t")
   @Export("rank")
   byte rank;
   @ObfuscatedName("qs")
   @Export("bufferProvider")
   public static BufferProvider bufferProvider;
   @ObfuscatedName("f")
   @Export("username")
   String username;

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1638515916"
   )
   static final void method603() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var9;
      if(Client.packetOpcode == 229) {
         var0 = Client.field327.method2562();
         var1 = (var0 >> 4 & 7) + class85.field1487;
         var2 = (var0 & 7) + ChatMessages.field274;
         var3 = Client.field327.method2535();
         var4 = Client.field327.method2677();
         var5 = var4 >> 2;
         var6 = var4 & 3;
         var7 = Client.field345[var5];
         if(var1 >= 0 && var2 >= 0 && var1 < 103 && var2 < 103) {
            if(var7 == 0) {
               WallObject var29 = class9.region.method2014(XItemContainer.plane, var1, var2);
               if(null != var29) {
                  var9 = var29.hash >> 14 & 32767;
                  if(var5 == 2) {
                     var29.renderable1 = new class12(var9, 2, var6 + 4, XItemContainer.plane, var1, var2, var3, false, var29.renderable1);
                     var29.renderable2 = new class12(var9, 2, var6 + 1 & 3, XItemContainer.plane, var1, var2, var3, false, var29.renderable2);
                  } else {
                     var29.renderable1 = new class12(var9, var5, var6, XItemContainer.plane, var1, var2, var3, false, var29.renderable1);
                  }
               }
            }

            if(var7 == 1) {
               DecorativeObject var39 = class9.region.method1987(XItemContainer.plane, var1, var2);
               if(null != var39) {
                  var9 = var39.hash >> 14 & 32767;
                  if(var5 != 4 && var5 != 5) {
                     if(var5 == 6) {
                        var39.renderable1 = new class12(var9, 4, var6 + 4, XItemContainer.plane, var1, var2, var3, false, var39.renderable1);
                     } else if(var5 == 7) {
                        var39.renderable1 = new class12(var9, 4, 4 + (var6 + 2 & 3), XItemContainer.plane, var1, var2, var3, false, var39.renderable1);
                     } else if(var5 == 8) {
                        var39.renderable1 = new class12(var9, 4, 4 + var6, XItemContainer.plane, var1, var2, var3, false, var39.renderable1);
                        var39.renderable2 = new class12(var9, 4, 4 + (2 + var6 & 3), XItemContainer.plane, var1, var2, var3, false, var39.renderable2);
                     }
                  } else {
                     var39.renderable1 = new class12(var9, 4, var6, XItemContainer.plane, var1, var2, var3, false, var39.renderable1);
                  }
               }
            }

            if(var7 == 2) {
               GameObject var40 = class9.region.method1988(XItemContainer.plane, var1, var2);
               if(var5 == 11) {
                  var5 = 10;
               }

               if(var40 != null) {
                  var40.renderable = new class12(var40.hash >> 14 & 32767, var5, var6, XItemContainer.plane, var1, var2, var3, false, var40.renderable);
               }
            }

            if(var7 == 3) {
               GroundObject var41 = class9.region.method1989(XItemContainer.plane, var1, var2);
               if(var41 != null) {
                  var41.renderable = new class12(var41.hash >> 14 & 32767, 22, var6, XItemContainer.plane, var1, var2, var3, false, var41.renderable);
               }
            }
         }

      } else {
         Item var32;
         if(Client.packetOpcode == 50) {
            var0 = Client.field327.method2535();
            var1 = Client.field327.method2656();
            var2 = class85.field1487 + (var1 >> 4 & 7);
            var3 = (var1 & 7) + ChatMessages.field274;
            var4 = Client.field327.method2570();
            if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
               var32 = new Item();
               var32.id = var0;
               var32.quantity = var4;
               if(null == Client.groundItemDeque[XItemContainer.plane][var2][var3]) {
                  Client.groundItemDeque[XItemContainer.plane][var2][var3] = new Deque();
               }

               Client.groundItemDeque[XItemContainer.plane][var2][var3].method3886(var32);
               class23.groundItemSpawned(var2, var3);
            }

         } else if(Client.packetOpcode == 254) {
            var0 = Client.field327.method2535();
            var1 = Client.field327.method2562();
            var2 = class85.field1487 + (var1 >> 4 & 7);
            var3 = ChatMessages.field274 + (var1 & 7);
            if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
               Deque var31 = Client.groundItemDeque[XItemContainer.plane][var2][var3];
               if(null != var31) {
                  for(var32 = (Item)var31.method3890(); null != var32; var32 = (Item)var31.method3892()) {
                     if(var32.id == (var0 & 32767)) {
                        var32.unlink();
                        break;
                     }
                  }

                  if(var31.method3890() == null) {
                     Client.groundItemDeque[XItemContainer.plane][var2][var3] = null;
                  }

                  class23.groundItemSpawned(var2, var3);
               }
            }

         } else if(Client.packetOpcode == 81) {
            var0 = Client.field327.method2677();
            var1 = var0 >> 2;
            var2 = var0 & 3;
            var3 = Client.field345[var1];
            var4 = Client.field327.method2561();
            var5 = class85.field1487 + (var4 >> 4 & 7);
            var6 = (var4 & 7) + ChatMessages.field274;
            if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
               NPCComposition.method820(XItemContainer.plane, var5, var6, var3, -1, var1, var2, 0, -1);
            }

         } else if(Client.packetOpcode == 149) {
            var0 = Client.field327.method2656();
            var1 = (var0 >> 4 & 7) + class85.field1487;
            var2 = ChatMessages.field274 + (var0 & 7);
            var3 = Client.field327.method2535();
            var4 = Client.field327.method2535();
            var5 = Client.field327.method2535();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               Deque var42 = Client.groundItemDeque[XItemContainer.plane][var1][var2];
               if(var42 != null) {
                  for(Item var33 = (Item)var42.method3890(); null != var33; var33 = (Item)var42.method3892()) {
                     if((var3 & 32767) == var33.id && var4 == var33.quantity) {
                        var33.quantity = var5;
                        break;
                     }
                  }

                  class23.groundItemSpawned(var1, var2);
               }
            }

         } else {
            int var8;
            int var11;
            int var12;
            if(Client.packetOpcode == 107) {
               var0 = Client.field327.method2656();
               var1 = class85.field1487 + (var0 >> 4 & 7);
               var2 = (var0 & 7) + ChatMessages.field274;
               var3 = var1 + Client.field327.method2534();
               var4 = var2 + Client.field327.method2534();
               var5 = Client.field327.method2633();
               var6 = Client.field327.method2535();
               var7 = Client.field327.method2656() * 4;
               var8 = Client.field327.method2656() * 4;
               var9 = Client.field327.method2535();
               int var38 = Client.field327.method2535();
               var11 = Client.field327.method2656();
               var12 = Client.field327.method2656();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
                  var1 = 128 * var1 + 64;
                  var2 = var2 * 128 + 64;
                  var3 = 128 * var3 + 64;
                  var4 = 64 + 128 * var4;
                  Projectile var34 = new Projectile(var6, XItemContainer.plane, var1, var2, Renderable.method1960(var1, var2, XItemContainer.plane) - var7, Client.gameCycle + var9, var38 + Client.gameCycle, var11, var12, var5, var8);
                  var34.method82(var3, var4, Renderable.method1960(var3, var4, XItemContainer.plane) - var8, var9 + Client.gameCycle);
                  Client.projectiles.method3886(var34);
               }

            } else {
               if(Client.packetOpcode == 142) {
                  var0 = Client.field327.method2656();
                  var1 = class85.field1487 + (var0 >> 4 & 7);
                  var2 = (var0 & 7) + ChatMessages.field274;
                  var3 = Client.field327.method2535();
                  var4 = Client.field327.method2656();
                  var5 = var4 >> 4 & 15;
                  var6 = var4 & 7;
                  var7 = Client.field327.method2656();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var8 = var5 + 1;
                     if(class34.localPlayer.pathX[0] >= var1 - var8 && class34.localPlayer.pathX[0] <= var1 + var8 && class34.localPlayer.pathY[0] >= var2 - var8 && class34.localPlayer.pathY[0] <= var8 + var2 && Client.field520 != 0 && var6 > 0 && Client.field363 < 50) {
                        Client.field522[Client.field363] = var3;
                        Client.field523[Client.field363] = var6;
                        Client.field524[Client.field363] = var7;
                        Client.field313[Client.field363] = null;
                        Client.field525[Client.field363] = (var2 << 8) + (var1 << 16) + var5;
                        ++Client.field363;
                     }
                  }
               }

               if(Client.packetOpcode == 153) {
                  var0 = Client.field327.method2570();
                  byte var35 = Client.field327.method2726();
                  byte var36 = Client.field327.method2564();
                  var3 = Client.field327.method2569();
                  var4 = Client.field327.method2569();
                  byte var37 = Client.field327.method2726();
                  var6 = Client.field327.method2561();
                  var7 = var6 >> 2;
                  var8 = var6 & 3;
                  var9 = Client.field345[var7];
                  byte var10 = Client.field327.method2726();
                  var11 = Client.field327.method2570();
                  var12 = Client.field327.method2656();
                  int var13 = class85.field1487 + (var12 >> 4 & 7);
                  int var14 = (var12 & 7) + ChatMessages.field274;
                  Player var15;
                  if(var4 == Client.localInteractingIndex) {
                     var15 = class34.localPlayer;
                  } else {
                     var15 = Client.cachedPlayers[var4];
                  }

                  if(null != var15) {
                     ObjectComposition var16 = class8.getObjectDefinition(var3);
                     int var17;
                     int var18;
                     if(var8 != 1 && var8 != 3) {
                        var17 = var16.field936;
                        var18 = var16.field937;
                     } else {
                        var17 = var16.field937;
                        var18 = var16.field936;
                     }

                     int var19 = (var17 >> 1) + var13;
                     int var20 = var13 + (1 + var17 >> 1);
                     int var21 = var14 + (var18 >> 1);
                     int var22 = (var18 + 1 >> 1) + var14;
                     int[][] var23 = class5.tileHeights[XItemContainer.plane];
                     int var24 = var23[var19][var22] + var23[var20][var21] + var23[var19][var21] + var23[var20][var22] >> 2;
                     int var25 = (var17 << 6) + (var13 << 7);
                     int var26 = (var14 << 7) + (var18 << 6);
                     Model var27 = var16.method828(var7, var8, var23, var25, var24, var26);
                     if(var27 != null) {
                        NPCComposition.method820(XItemContainer.plane, var13, var14, var9, -1, 0, 0, 1 + var11, var0 + 1);
                        var15.totalLevel = Client.gameCycle + var11;
                        var15.field40 = Client.gameCycle + var0;
                        var15.model = var27;
                        var15.field42 = 128 * var13 + 64 * var17;
                        var15.field43 = var14 * 128 + var18 * 64;
                        var15.field32 = var24;
                        byte var28;
                        if(var36 > var10) {
                           var28 = var36;
                           var36 = var10;
                           var10 = var28;
                        }

                        if(var37 > var35) {
                           var28 = var37;
                           var37 = var35;
                           var35 = var28;
                        }

                        var15.field45 = var36 + var13;
                        var15.field47 = var10 + var13;
                        var15.field46 = var14 + var37;
                        var15.field30 = var35 + var14;
                     }
                  }
               }

               if(Client.packetOpcode == 172) {
                  var0 = Client.field327.method2561();
                  var1 = (var0 >> 4 & 7) + class85.field1487;
                  var2 = ChatMessages.field274 + (var0 & 7);
                  var3 = Client.field327.method2677();
                  var4 = var3 >> 2;
                  var5 = var3 & 3;
                  var6 = Client.field345[var4];
                  var7 = Client.field327.method2568();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     NPCComposition.method820(XItemContainer.plane, var1, var2, var6, var7, var4, var5, 0, -1);
                  }

               } else if(Client.packetOpcode == 241) {
                  var0 = Client.field327.method2656();
                  var1 = class85.field1487 + (var0 >> 4 & 7);
                  var2 = ChatMessages.field274 + (var0 & 7);
                  var3 = Client.field327.method2535();
                  var4 = Client.field327.method2656();
                  var5 = Client.field327.method2535();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var1 = 64 + var1 * 128;
                     var2 = 64 + var2 * 128;
                     class31 var30 = new class31(var3, XItemContainer.plane, var1, var2, Renderable.method1960(var1, var2, XItemContainer.plane) - var4, var5, Client.gameCycle);
                     Client.field415.method3886(var30);
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)V",
      garbageValue = "1011987612"
   )
   static final void method604(class125 var0) {
      var0.method2770();
      int var1 = Client.localInteractingIndex;
      Player var2 = class34.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field57 = var1;
      int var3 = var0.method2771(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class32.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.method40() << 6);
      var2.pathY[0] = var6 - class8.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.method40() << 6);
      XItemContainer.plane = var2.field41 = var4;
      if(null != class34.field761[var1]) {
         var2.method18(class34.field761[var1]);
      }

      class34.field763 = 0;
      class34.field758[++class34.field763 - 1] = var1;
      class34.field759[var1] = 0;
      class34.field764 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.method2771(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 255;
            int var11 = var8 & 255;
            class34.field769[var7] = var11 + (var9 << 28) + (var10 << 14);
            class34.field767[var7] = 0;
            class34.field768[var7] = -1;
            class34.field765[++class34.field764 - 1] = var7;
            class34.field759[var7] = 0;
         }
      }

      var0.method2778();
   }
}
