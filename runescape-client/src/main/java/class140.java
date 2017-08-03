import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class class140 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   static IndexDataBase field2086;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1109816174"
   )
   static int method2891(int var0, int var1) {
      Overlay var2 = class219.method4073(var0);
      if(var2 == null) {
         return var1;
      } else if(var2.otherRgbColor >= 0) {
         return var2.otherRgbColor | -16777216;
      } else {
         int var3;
         int var4;
         byte var5;
         int var7;
         if(var2.texture >= 0) {
            var4 = Graphics3D.textureLoader.getAverageTextureRGB(var2.texture);
            var5 = 96;
            if(var4 == -2) {
               var3 = 12345678;
            } else if(var4 == -1) {
               if(var5 < 0) {
                  var5 = 0;
               } else if(var5 > 127) {
                  var5 = 127;
               }

               var7 = 127 - var5;
               var3 = var7;
            } else {
               var7 = var5 * (var4 & 127) / 128;
               if(var7 < 2) {
                  var7 = 2;
               } else if(var7 > 126) {
                  var7 = 126;
               }

               var3 = var7 + (var4 & 'ﾀ');
            }

            return Graphics3D.colorPalette[var3] | -16777216;
         } else if(var2.color == 16711935) {
            return var1;
         } else {
            var3 = Renderable.method2898(var2.hue, var2.saturation, var2.lightness);
            var5 = 96;
            if(var3 == -2) {
               var4 = 12345678;
            } else if(var3 == -1) {
               if(var5 < 0) {
                  var5 = 0;
               } else if(var5 > 127) {
                  var5 = 127;
               }

               var7 = 127 - var5;
               var4 = var7;
            } else {
               var7 = var5 * (var3 & 127) / 128;
               if(var7 < 2) {
                  var7 = 2;
               } else if(var7 > 126) {
                  var7 = 126;
               }

               var4 = var7 + (var3 & 'ﾀ');
            }

            return Graphics3D.colorPalette[var4] | -16777216;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)[Ljl;",
      garbageValue = "-448195440"
   )
   public static class276[] method2890() {
      return new class276[]{class276.field3719, class276.field3720, class276.field3718};
   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "32"
   )
   static final void method2889(int var0, int var1, boolean var2) {
      if(!var2 || var0 != class35.field474 || class73.field854 != var1) {
         class35.field474 = var0;
         class73.field854 = var1;
         class2.setGameState(25);
         ScriptVarType.drawStatusBox("Loading - please wait.", true);
         int var3 = class33.baseX;
         int var4 = class17.baseY;
         class33.baseX = (var0 - 6) * 8;
         class17.baseY = (var1 - 6) * 8;
         int var5 = class33.baseX - var3;
         int var6 = class17.baseY - var4;
         var3 = class33.baseX;
         var4 = class17.baseY;

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
            for(var14 = var10; var14 != var11; var14 += var12) {
               int var15 = var5 + var13;
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

         for(PendingSpawn var19 = (PendingSpawn)Client.pendingSpawns.getFront(); var19 != null; var19 = (PendingSpawn)Client.pendingSpawns.getNext()) {
            var19.x -= var5;
            var19.y -= var6;
            if(var19.x < 0 || var19.y < 0 || var19.x >= 104 || var19.y >= 104) {
               var19.unlink();
            }
         }

         if(Client.destinationX != 0) {
            Client.destinationX -= var5;
            Client.destinationY -= var6;
         }

         Client.field1124 = 0;
         Client.field1130 = false;
         Client.field1111 = -1;
         Client.graphicsObjectDeque.clear();
         Client.projectiles.clear();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].reset();
         }

      }
   }
}
