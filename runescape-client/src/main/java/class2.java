import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
final class class2 implements class0 {
   @ObfuscatedName("i")
   public static IndexDataBase field15;
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = 1590789317
   )
   static int field19;
   @ObfuscatedName("ce")
   @Export("rssocket")
   static RSSocket rssocket;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;II)V",
      garbageValue = "-2085722219"
   )
   static void method4(PacketBuffer var0, int var1) {
      boolean var2 = var0.method3290(1) == 1;
      if(var2) {
         class96.field1500[++class96.field1493 - 1] = var1;
      }

      int var3 = var0.method3290(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field877 = false;
         } else {
            if(var1 == Client.localInteractingIndex) {
               throw new RuntimeException();
            }

            class96.field1490[var1] = (var4.pathY[0] + class21.baseY >> 13) + (var4.field884 << 28) + (class19.baseX + var4.pathX[0] >> 13 << 14);
            if(var4.field1236 != -1) {
               class96.field1497[var1] = var4.field1236;
            } else {
               class96.field1497[var1] = var4.orientation;
            }

            class96.field1492[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method3290(1) != 0) {
               class29.method253(var0, var1);
            }
         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method3290(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1083(var6, var7);
               var4.field877 = false;
            } else if(var2) {
               var4.field877 = true;
               var4.field887 = var6;
               var4.field888 = var7;
            } else {
               var4.field877 = false;
               var4.method1071(var6, var7, class96.field1494[var1]);
            }
         } else if(var3 == 2) {
            var5 = var0.method3290(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field877 = true;
                  var4.field887 = var6;
                  var4.field888 = var7;
               } else {
                  var4.field877 = false;
                  var4.method1071(var6, var7, class96.field1494[var1]);
               }
            } else {
               var4.method1083(var6, var7);
               var4.field877 = false;
            }
         } else {
            var5 = var0.method3290(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method3290(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.pathX[0];
               var11 = var4.pathY[0] + var9;
               if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field877 = true;
                     var4.field887 = var10;
                     var4.field888 = var11;
                  } else {
                     var4.field877 = false;
                     var4.method1071(var10, var11, class96.field1494[var1]);
                  }
               } else {
                  var4.method1083(var10, var11);
                  var4.field877 = false;
               }

               var4.field884 = (byte)(var4.field884 + var7 & 3);
               if(Client.localInteractingIndex == var1) {
                  Player.plane = var4.field884;
               }
            } else {
               var6 = var0.method3290(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + class19.baseX + var4.pathX[0] & 16383) - class19.baseX;
               var11 = (var9 + var4.pathY[0] + class21.baseY & 16383) - class21.baseY;
               if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method1083(var10, var11);
                  var4.field877 = false;
               } else if(var2) {
                  var4.field877 = true;
                  var4.field887 = var10;
                  var4.field888 = var11;
               } else {
                  var4.field877 = false;
                  var4.method1071(var10, var11, class96.field1494[var1]);
               }

               var4.field884 = (byte)(var4.field884 + var7 & 3);
               if(Client.localInteractingIndex == var1) {
                  Player.plane = var4.field884;
               }
            }
         }
      }

   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-1732530426"
   )
   static final void method5(int var0, int var1, boolean var2) {
      if(!var2 || class34.field501 != var0 || class13.field289 != var1) {
         class34.field501 = var0;
         class13.field289 = var1;
         class23.setGameState(25);
         class158.drawStatusBox("Loading - please wait.", true);
         int var3 = class19.baseX;
         int var4 = class21.baseY;
         class19.baseX = (var0 - 6) * 8;
         class21.baseY = (var1 - 6) * 8;
         int var5 = class19.baseX - var3;
         int var6 = class21.baseY - var4;
         var3 = class19.baseX;
         var4 = class21.baseY;

         int var7;
         int var8;
         for(var7 = 0; var7 < '耀'; ++var7) {
            NPC var9 = Client.cachedNPCs[var7];
            if(var9 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var9.pathX[var8] -= var5;
                  var9.pathY[var8] -= var6;
               }

               var9.x -= var5 * 128;
               var9.y -= var6 * 128;
            }
         }

         for(var7 = 0; var7 < 2048; ++var7) {
            Player var20 = Client.cachedPlayers[var7];
            if(var20 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var20.pathX[var8] -= var5;
                  var20.pathY[var8] -= var6;
               }

               var20.x -= var5 * 128;
               var20.y -= var6 * 128;
            }
         }

         byte var21 = 0;
         byte var10 = 104;
         byte var11 = 1;
         if(var5 < 0) {
            var21 = 103;
            var10 = -1;
            var11 = -1;
         }

         byte var12 = 0;
         byte var13 = 104;
         byte var14 = 1;
         if(var6 < 0) {
            var12 = 103;
            var13 = -1;
            var14 = -1;
         }

         int var15;
         for(int var16 = var21; var16 != var10; var16 += var11) {
            for(var15 = var12; var13 != var15; var15 += var14) {
               int var17 = var16 + var5;
               int var18 = var6 + var15;

               for(int var19 = 0; var19 < 4; ++var19) {
                  if(var17 >= 0 && var18 >= 0 && var17 < 104 && var18 < 104) {
                     Client.groundItemDeque[var19][var16][var15] = Client.groundItemDeque[var19][var17][var18];
                  } else {
                     Client.groundItemDeque[var19][var16][var15] = null;
                  }
               }
            }
         }

         for(PendingSpawn var22 = (PendingSpawn)Client.pendingSpawns.method3487(); var22 != null; var22 = (PendingSpawn)Client.pendingSpawns.method3512()) {
            var22.x -= var5;
            var22.y -= var6;
            if(var22.x < 0 || var22.y < 0 || var22.x >= 104 || var22.y >= 104) {
               var22.unlink();
            }
         }

         if(Client.destinationX != 0) {
            Client.destinationX -= var5;
            Client.destinationY -= var6;
         }

         Client.field931 = 0;
         Client.field1152 = false;
         Client.field944 = -1;
         Client.field1033.method3481();
         Client.projectiles.method3481();

         for(var15 = 0; var15 < 4; ++var15) {
            Client.collisionMaps[var15].method2912();
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LWorld;B)V",
      garbageValue = "91"
   )
   static void method6(World var0) {
      if(var0.method1461() != Client.isMembers) {
         Client.isMembers = var0.method1461();
         class95.method1682(var0.method1461());
      }

      class40.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class47.field610 = Client.field1161 == 0?'ꩊ':var0.id + '鱀';
      class87.field1373 = Client.field1161 == 0?443:var0.id + '썐';
      Buffer.field2411 = class47.field610;
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;B)[Ljava/lang/String;",
      garbageValue = "68"
   )
   static final String[] method7(String[] var0) {
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
