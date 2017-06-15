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
         } else if(var1 == Client.localInteractingIndex) {
            throw new RuntimeException();
         } else {
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

            if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
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

            if(var1 == Client.localInteractingIndex && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
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
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
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
         class158.method2877("Loading - please wait.", true);
         int var3 = class19.baseX;
         int var4 = class21.baseY;
         class19.baseX = (var0 - 6) * 8;
         class21.baseY = (var1 - 6) * 8;
         int var5 = class19.baseX - var3;
         int var6 = class21.baseY - var4;
         var3 = class19.baseX;
         var4 = class21.baseY;

         int var7;
         int var9;
         for(var7 = 0; var7 < '耀'; ++var7) {
            NPC var8 = Client.cachedNPCs[var7];
            if(var8 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var8.pathX[var9] -= var5;
                  var8.pathY[var9] -= var6;
               }

               var8.x -= var5 * 128;
               var8.y -= var6 * 128;
            }
         }

         for(var7 = 0; var7 < 2048; ++var7) {
            Player var21 = Client.cachedPlayers[var7];
            if(var21 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var21.pathX[var9] -= var5;
                  var21.pathY[var9] -= var6;
               }

               var21.x -= var5 * 128;
               var21.y -= var6 * 128;
            }
         }

         byte var20 = 0;
         byte var18 = 104;
         byte var22 = 1;
         if(var5 < 0) {
            var20 = 103;
            var18 = -1;
            var22 = -1;
         }

         byte var10 = 0;
         byte var11 = 104;
         byte var12 = 1;
         if(var6 < 0) {
            var10 = 103;
            var11 = -1;
            var12 = -1;
         }

         int var14;
         for(int var13 = var20; var13 != var18; var13 += var22) {
            for(var14 = var10; var11 != var14; var14 += var12) {
               int var15 = var13 + var5;
               int var16 = var6 + var14;

               for(int var17 = 0; var17 < 4; ++var17) {
                  if(var15 >= 0 && var16 >= 0 && var15 < 104 && var16 < 104) {
                     Client.groundItemDeque[var17][var13][var14] = Client.groundItemDeque[var17][var15][var16];
                  } else {
                     Client.groundItemDeque[var17][var13][var14] = null;
                  }
               }
            }
         }

         for(PendingSpawn var19 = (PendingSpawn)Client.pendingSpawns.method3487(); var19 != null; var19 = (PendingSpawn)Client.pendingSpawns.method3512()) {
            var19.x -= var5;
            var19.y -= var6;
            if(var19.x < 0 || var19.y < 0 || var19.x >= 104 || var19.y >= 104) {
               var19.unlink();
            }
         }

         if(Client.detinationX != 0) {
            Client.detinationX -= var5;
            Client.destinationY -= var6;
         }

         Client.field931 = 0;
         Client.field1152 = false;
         Client.field944 = -1;
         Client.field1033.method3481();
         Client.projectiles.method3481();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].method2912();
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
