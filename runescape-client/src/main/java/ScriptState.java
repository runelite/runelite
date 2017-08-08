import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -892830925
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lcc;"
   )
   @Export("invokedFromScript")
   Script invokedFromScript;
   @ObfuscatedName("g")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("y")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;

   ScriptState() {
      this.invokedFromPc = -1;
   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-241879274"
   )
   static final void method1074(int var0, int var1, int var2, int var3) {
      ++Client.field1006;
      class90.method1735(class66.field811);
      boolean var4 = false;
      int var5;
      int var7;
      if(Client.field1031 >= 0) {
         var5 = class97.field1493;
         int[] var6 = class97.field1494;

         for(var7 = 0; var7 < var5; ++var7) {
            if(var6[var7] == Client.field1031) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         class90.method1735(class66.field806);
      }

      CollisionData.method3085(true);
      class90.method1735(var4?class66.field810:class66.field807);
      CollisionData.method3085(false);

      for(Projectile var19 = (Projectile)Client.projectiles.getFront(); var19 != null; var19 = (Projectile)Client.projectiles.getNext()) {
         if(var19.floor == class29.plane && Client.gameCycle <= var19.cycle) {
            if(Client.gameCycle >= var19.startTime) {
               if(var19.interacting > 0) {
                  NPC var21 = Client.cachedNPCs[var19.interacting - 1];
                  if(var21 != null && var21.x >= 0 && var21.x < 13312 && var21.y >= 0 && var21.y < 13312) {
                     var19.method1792(var21.x, var21.y, Friend.getTileHeight(var21.x, var21.y, var19.floor) - var19.endHeight, Client.gameCycle);
                  }
               }

               if(var19.interacting < 0) {
                  var7 = -var19.interacting - 1;
                  Player var22;
                  if(var7 == Client.localInteractingIndex) {
                     var22 = class54.localPlayer;
                  } else {
                     var22 = Client.cachedPlayers[var7];
                  }

                  if(var22 != null && var22.x >= 0 && var22.x < 13312 && var22.y >= 0 && var22.y < 13312) {
                     var19.method1792(var22.x, var22.y, Friend.getTileHeight(var22.x, var22.y, var19.floor) - var19.endHeight, Client.gameCycle);
                  }
               }

               var19.method1784(Client.field1020);
               class84.region.method2722(class29.plane, (int)var19.x, (int)var19.velocityZ, (int)var19.z, 60, var19, var19.rotationX, -1, false);
            }
         } else {
            var19.unlink();
         }
      }

      class22.method167();
      XGrandExchangeOffer.method98(var0, var1, var2, var3, true);
      var0 = Client.field1164;
      var1 = Client.field1165;
      var2 = Client.viewportHeight;
      var3 = Client.viewportWidth;
      Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
      Graphics3D.method2627();
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var20;
      if(!Client.field939) {
         var5 = Client.field985;
         if(Client.field994 / 256 > var5) {
            var5 = Client.field994 / 256;
         }

         if(Client.field1151[4] && Client.field1153[4] + 128 > var5) {
            var5 = Client.field1153[4] + 128;
         }

         var20 = Client.mapAngle & 2047;
         var7 = Huffman.field2305;
         var8 = Friend.getTileHeight(class54.localPlayer.x, class54.localPlayer.y, class29.plane) - Client.field978;
         var9 = AbstractSoundSystem.field1623;
         var10 = var5 * 3 + 600;
         var11 = 2048 - var5 & 2047;
         var12 = 2048 - var20 & 2047;
         var13 = 0;
         var14 = 0;
         var15 = var10;
         int var16;
         int var17;
         int var18;
         if(var11 != 0) {
            var16 = Graphics3D.SINE[var11];
            var17 = Graphics3D.COSINE[var11];
            var18 = var14 * var17 - var16 * var10 >> 16;
            var15 = var14 * var16 + var17 * var10 >> 16;
            var14 = var18;
         }

         if(var12 != 0) {
            var16 = Graphics3D.SINE[var12];
            var17 = Graphics3D.COSINE[var12];
            var18 = var15 * var16 + var13 * var17 >> 16;
            var15 = var17 * var15 - var16 * var13 >> 16;
            var13 = var18;
         }

         class273.cameraX = var7 - var13;
         PendingSpawn.cameraZ = var8 - var14;
         GZipDecompressor.cameraY = var9 - var15;
         class250.cameraPitch = var5;
         Player.cameraYaw = var20;
      }

      if(!Client.field939) {
         if(MilliTimer.preferences.hideRoofs) {
            var20 = class29.plane;
         } else {
            label407: {
               var7 = 3;
               if(class250.cameraPitch < 310) {
                  var8 = class273.cameraX >> 7;
                  var9 = GZipDecompressor.cameraY >> 7;
                  var10 = class54.localPlayer.x >> 7;
                  var11 = class54.localPlayer.y >> 7;
                  if(var8 < 0 || var9 < 0 || var8 >= 104 || var9 >= 104) {
                     var20 = class29.plane;
                     break label407;
                  }

                  if((class61.tileSettings[class29.plane][var8][var9] & 4) != 0) {
                     var7 = class29.plane;
                  }

                  if(var10 > var8) {
                     var12 = var10 - var8;
                  } else {
                     var12 = var8 - var10;
                  }

                  if(var11 > var9) {
                     var13 = var11 - var9;
                  } else {
                     var13 = var9 - var11;
                  }

                  if(var12 > var13) {
                     var14 = var13 * 65536 / var12;
                     var15 = '耀';

                     while(var10 != var8) {
                        if(var8 < var10) {
                           ++var8;
                        } else if(var8 > var10) {
                           --var8;
                        }

                        if((class61.tileSettings[class29.plane][var8][var9] & 4) != 0) {
                           var7 = class29.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var9 < var11) {
                              ++var9;
                           } else if(var9 > var11) {
                              --var9;
                           }

                           if((class61.tileSettings[class29.plane][var8][var9] & 4) != 0) {
                              var7 = class29.plane;
                           }
                        }
                     }
                  } else {
                     var14 = var12 * 65536 / var13;
                     var15 = '耀';

                     while(var9 != var11) {
                        if(var9 < var11) {
                           ++var9;
                        } else if(var9 > var11) {
                           --var9;
                        }

                        if((class61.tileSettings[class29.plane][var8][var9] & 4) != 0) {
                           var7 = class29.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var8 < var10) {
                              ++var8;
                           } else if(var8 > var10) {
                              --var8;
                           }

                           if((class61.tileSettings[class29.plane][var8][var9] & 4) != 0) {
                              var7 = class29.plane;
                           }
                        }
                     }
                  }
               }

               if(class54.localPlayer.x >= 0 && class54.localPlayer.y >= 0 && class54.localPlayer.x < 13312 && class54.localPlayer.y < 13312) {
                  if((class61.tileSettings[class29.plane][class54.localPlayer.x >> 7][class54.localPlayer.y >> 7] & 4) != 0) {
                     var7 = class29.plane;
                  }

                  var20 = var7;
               } else {
                  var20 = class29.plane;
               }
            }
         }

         var5 = var20;
      } else {
         if(MilliTimer.preferences.hideRoofs) {
            var20 = class29.plane;
         } else {
            var7 = Friend.getTileHeight(class273.cameraX, GZipDecompressor.cameraY, class29.plane);
            if(var7 - PendingSpawn.cameraZ < 800 && (class61.tileSettings[class29.plane][class273.cameraX >> 7][GZipDecompressor.cameraY >> 7] & 4) != 0) {
               var20 = class29.plane;
            } else {
               var20 = 3;
            }
         }

         var5 = var20;
      }

      var20 = class273.cameraX;
      var7 = PendingSpawn.cameraZ;
      var8 = GZipDecompressor.cameraY;
      var9 = class250.cameraPitch;
      var10 = Player.cameraYaw;

      for(var11 = 0; var11 < 5; ++var11) {
         if(Client.field1151[var11]) {
            var12 = (int)(Math.random() * (double)(Client.field1152[var11] * 2 + 1) - (double)Client.field1152[var11] + Math.sin((double)Client.field1154[var11] / 100.0D * (double)Client.field962[var11]) * (double)Client.field1153[var11]);
            if(var11 == 0) {
               class273.cameraX += var12;
            }

            if(var11 == 1) {
               PendingSpawn.cameraZ += var12;
            }

            if(var11 == 2) {
               GZipDecompressor.cameraY += var12;
            }

            if(var11 == 3) {
               Player.cameraYaw = var12 + Player.cameraYaw & 2047;
            }

            if(var11 == 4) {
               class250.cameraPitch += var12;
               if(class250.cameraPitch < 128) {
                  class250.cameraPitch = 128;
               }

               if(class250.cameraPitch > 383) {
                  class250.cameraPitch = 383;
               }
            }
         }
      }

      var11 = MouseInput.field718;
      var12 = MouseInput.field719;
      if(MouseInput.field734 != 0) {
         var11 = MouseInput.field725;
         var12 = MouseInput.field726;
      }

      if(var11 >= var0 && var11 < var0 + var2 && var12 >= var1 && var12 < var3 + var1) {
         var13 = var11 - var0;
         var14 = var12 - var1;
         class135.field1983 = var13;
         class135.field1991 = var14;
         class135.field1984 = true;
         class135.field1988 = 0;
         class135.field1993 = false;
      } else {
         Client.method1520();
      }

      class35.method495();
      Rasterizer2D.method4973(var0, var1, var2, var3, 0);
      class35.method495();
      var13 = Graphics3D.field2011;
      Graphics3D.field2011 = Client.scale;
      class84.region.draw(class273.cameraX, PendingSpawn.cameraZ, GZipDecompressor.cameraY, class250.cameraPitch, Player.cameraYaw, var5);
      MilliTimer.method2956();
      Graphics3D.field2011 = var13;
      class35.method495();
      class84.region.clearEntities();
      class11.method56(var0, var1, var2, var3);
      Huffman.method3117(var0, var1);
      ((TextureProvider)Graphics3D.textureLoader).method2398(Client.field1020);
      class44.method618(var0, var1, var2, var3);
      class273.cameraX = var20;
      PendingSpawn.cameraZ = var7;
      GZipDecompressor.cameraY = var8;
      class250.cameraPitch = var9;
      Player.cameraYaw = var10;
      if(Client.field923) {
         byte var23 = 0;
         var15 = var23 + class239.field3241 + class239.field3249;
         if(var15 == 0) {
            Client.field923 = false;
         }
      }

      if(Client.field923) {
         Rasterizer2D.method4973(var0, var1, var2, var3, 0);
         class23.drawStatusBox("Loading - please wait.", false);
      }

   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1775012903"
   )
   static final void method1073() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.getFront(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0.hitpoints == -1) {
            var0.delay = 0;
            Overlay.method4710(var0);
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "1295074291"
   )
   public static boolean method1072(char var0) {
      return var0 >= 32 && var0 <= 126?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }
}
