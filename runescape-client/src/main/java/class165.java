import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public final class class165 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -193879759
   )
   public static int field2689;
   @ObfuscatedName("k")
   static final char[] field2690 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
   @ObfuscatedName("hj")
   @Export("localPlayer")
   static Player localPlayer;

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2052375499"
   )
   static final void method3222(int var0, int var1) {
      if(var0 != Projectile.field117 || var1 != class8.field144) {
         Projectile.field117 = var0;
         class8.field144 = var1;
         class127.setGameState(25);
         class20.method570("Loading - please wait.", true);
         int var2 = class47.baseX;
         int var3 = class21.baseY;
         class47.baseX = (var0 - 6) * 8;
         class21.baseY = (var1 - 6) * 8;
         int var4 = class47.baseX - var2;
         int var5 = class21.baseY - var3;
         var2 = class47.baseX;
         var3 = class21.baseY;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            NPC var7 = Client.cachedNPCs[var6];
            if(null != var7) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.pathX[var8] -= var4;
                  var7.pathY[var8] -= var5;
               }

               var7.x -= 128 * var4;
               var7.y -= var5 * 128;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            Player var20 = Client.cachedPlayers[var6];
            if(var20 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var20.pathX[var8] -= var4;
                  var20.pathY[var8] -= var5;
               }

               var20.x -= var4 * 128;
               var20.y -= 128 * var5;
            }
         }

         byte var19 = 0;
         byte var18 = 104;
         byte var21 = 1;
         if(var4 < 0) {
            var19 = 103;
            var18 = -1;
            var21 = -1;
         }

         byte var9 = 0;
         byte var10 = 104;
         byte var11 = 1;
         if(var5 < 0) {
            var9 = 103;
            var10 = -1;
            var11 = -1;
         }

         int var13;
         for(int var17 = var19; var17 != var18; var17 += var21) {
            for(var13 = var9; var13 != var10; var13 += var11) {
               int var14 = var17 + var4;
               int var15 = var5 + var13;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     Client.groundItemDeque[var16][var17][var13] = Client.groundItemDeque[var16][var14][var15];
                  } else {
                     Client.groundItemDeque[var16][var17][var13] = null;
                  }
               }
            }
         }

         for(class16 var12 = (class16)Client.field413.method3864(); null != var12; var12 = (class16)Client.field413.method3851()) {
            var12.field228 -= var4;
            var12.field225 -= var5;
            if(var12.field228 < 0 || var12.field225 < 0 || var12.field228 >= 104 || var12.field225 >= 104) {
               var12.unlink();
            }
         }

         if(Client.flagX != 0) {
            Client.flagX -= var4;
            Client.flagY -= var5;
         }

         Client.field522 = 0;
         Client.field528 = false;
         Client.field509 = -1;
         Client.field415.method3850();
         Client.projectiles.method3850();

         for(var13 = 0; var13 < 4; ++var13) {
            Client.collisionMaps[var13].method2469();
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1849657587"
   )
   public static void method3230() {
      PlayerComposition.field2965.reset();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([LWorld;II[I[II)V",
      garbageValue = "-1992578419"
   )
   static void method3231(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = 1 + var2;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method621()?1:0;
                     var12 = var8.method621()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method621()?1:0;
                     var12 = var8.method621()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method3231(var0, var1, var6, var3, var4);
         method3231(var0, 1 + var6, var2, var3, var4);
      }

   }
}
