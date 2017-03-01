import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 339688205
   )
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -753850319
   )
   @Export("y")
   int y;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1633604723
   )
   int field1341;
   @ObfuscatedName("y")
   class85 field1342;
   @ObfuscatedName("p")
   class77 field1343;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 748462313
   )
   int field1345;
   @ObfuscatedName("a")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("i")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("m")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("k")
   @Export("objects")
   GameObject[] objects = new GameObject[5];
   @ObfuscatedName("f")
   int[] field1350 = new int[5];
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1947850247
   )
   int field1351;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1601994905
   )
   int field1352;
   @ObfuscatedName("c")
   boolean field1353;
   @ObfuscatedName("b")
   boolean field1354;
   @ObfuscatedName("w")
   boolean field1355;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2021522185
   )
   int field1356;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 157863897
   )
   int field1357;
   @ObfuscatedName("bu")
   static class184 field1358;
   @ObfuscatedName("j")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("h")
   Tile field1360;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2072828543
   )
   int field1361;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -983688753
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2044933257
   )
   int field1364 = 0;

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1792865569"
   )
   static final void method1639(int var0, int var1, int var2, int var3) {
      ++Client.field502;
      class45.method913(class15.field160);
      boolean var4 = false;
      int var5;
      int var7;
      if(Client.field418 >= 0) {
         var5 = class45.field916;
         int[] var6 = class45.field913;

         for(var7 = 0; var7 < var5; ++var7) {
            if(var6[var7] == Client.field418) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         class45.method913(class15.field153);
      }

      Frames.method1993(true);
      class45.method913(var4?class15.field154:class15.field155);
      Frames.method1993(false);

      for(Projectile var19 = (Projectile)Client.projectiles.method2503(); var19 != null; var19 = (Projectile)Client.projectiles.method2492()) {
         if(CollisionData.plane == var19.floor && Client.gameCycle <= var19.field866) {
            if(Client.gameCycle >= var19.startTime) {
               if(var19.interacting > 0) {
                  NPC var21 = Client.cachedNPCs[var19.interacting - 1];
                  if(var21 != null && var21.x >= 0 && var21.x < 13312 && var21.y >= 0 && var21.y < 13312) {
                     var19.method866(var21.x, var21.y, class25.method615(var21.x, var21.y, var19.floor) - var19.field864, Client.gameCycle);
                  }
               }

               if(var19.interacting < 0) {
                  var7 = -var19.interacting - 1;
                  Player var22;
                  if(var7 == Client.localInteractingIndex) {
                     var22 = WidgetNode.localPlayer;
                  } else {
                     var22 = Client.cachedPlayers[var7];
                  }

                  if(var22 != null && var22.x >= 0 && var22.x < 13312 && var22.y >= 0 && var22.y < 13312) {
                     var19.method866(var22.x, var22.y, class25.method615(var22.x, var22.y, var19.floor) - var19.field864, Client.gameCycle);
                  }
               }

               var19.method867(Client.field365);
               Friend.region.method1878(CollisionData.plane, (int)var19.x, (int)var19.velocityZ, (int)var19.z, 60, var19, var19.field879, -1, false);
            }
         } else {
            var19.unlink();
         }
      }

      for(class33 var23 = (class33)Client.field422.method2503(); null != var23; var23 = (class33)Client.field422.method2492()) {
         if(var23.field751 == CollisionData.plane && !var23.field749) {
            if(Client.gameCycle >= var23.field741) {
               var23.method770(Client.field365);
               if(var23.field749) {
                  var23.unlink();
               } else {
                  Friend.region.method1878(var23.field751, var23.field743, var23.field744, var23.field745, 60, var23, 0, -1, false);
               }
            }
         } else {
            var23.unlink();
         }
      }

      FaceNormal.method1989(var0, var1, var2, var3, true);
      var0 = Client.field552;
      var1 = Client.field553;
      var2 = Client.camera2;
      var3 = Client.camera3;
      Rasterizer2D.method4091(var0, var1, var0 + var2, var1 + var3);
      class84.method1747();
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var20;
      if(!Client.field459) {
         var5 = Client.field372;
         if(Client.field381 / 256 > var5) {
            var5 = Client.field381 / 256;
         }

         if(Client.field539[4] && Client.field541[4] + 128 > var5) {
            var5 = Client.field541[4] + 128;
         }

         var20 = Client.field357 + Client.mapAngle & 2047;
         var7 = class49.field974;
         var8 = class25.method615(WidgetNode.localPlayer.x, WidgetNode.localPlayer.y, CollisionData.plane) - Client.field378;
         var9 = class189.field2791;
         var10 = 600 + var5 * 3;
         var11 = 2048 - var5 & 2047;
         var12 = 2048 - var20 & 2047;
         var13 = 0;
         var14 = 0;
         var15 = var10;
         int var16;
         int var17;
         int var18;
         if(var11 != 0) {
            var16 = class84.field1460[var11];
            var17 = class84.field1446[var11];
            var18 = var14 * var17 - var16 * var10 >> 16;
            var15 = var16 * var14 + var10 * var17 >> 16;
            var14 = var18;
         }

         if(var12 != 0) {
            var16 = class84.field1460[var12];
            var17 = class84.field1446[var12];
            var18 = var17 * var13 + var15 * var16 >> 16;
            var15 = var15 * var17 - var16 * var13 >> 16;
            var13 = var18;
         }

         FaceNormal.cameraX = var7 - var13;
         class45.cameraZ = var8 - var14;
         ChatLineBuffer.cameraY = var9 - var15;
         class10.cameraPitch = var5;
         Projectile.cameraYaw = var20;
      }

      if(!Client.field459) {
         if(ObjectComposition.field2944.field690) {
            var20 = CollisionData.plane;
         } else {
            label485: {
               var7 = 3;
               if(class10.cameraPitch < 310) {
                  var8 = FaceNormal.cameraX >> 7;
                  var9 = ChatLineBuffer.cameraY >> 7;
                  var10 = WidgetNode.localPlayer.x >> 7;
                  var11 = WidgetNode.localPlayer.y >> 7;
                  if(var8 < 0 || var9 < 0 || var8 >= 104 || var9 >= 104) {
                     var20 = CollisionData.plane;
                     break label485;
                  }

                  if((class10.tileSettings[CollisionData.plane][var8][var9] & 4) != 0) {
                     var7 = CollisionData.plane;
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
                     var14 = 65536 * var13 / var12;
                     var15 = '耀';

                     while(var8 != var10) {
                        if(var8 < var10) {
                           ++var8;
                        } else if(var8 > var10) {
                           --var8;
                        }

                        if((class10.tileSettings[CollisionData.plane][var8][var9] & 4) != 0) {
                           var7 = CollisionData.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var9 < var11) {
                              ++var9;
                           } else if(var9 > var11) {
                              --var9;
                           }

                           if((class10.tileSettings[CollisionData.plane][var8][var9] & 4) != 0) {
                              var7 = CollisionData.plane;
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

                        if((class10.tileSettings[CollisionData.plane][var8][var9] & 4) != 0) {
                           var7 = CollisionData.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var8 < var10) {
                              ++var8;
                           } else if(var8 > var10) {
                              --var8;
                           }

                           if((class10.tileSettings[CollisionData.plane][var8][var9] & 4) != 0) {
                              var7 = CollisionData.plane;
                           }
                        }
                     }
                  }
               }

               if(WidgetNode.localPlayer.x >= 0 && WidgetNode.localPlayer.y >= 0 && WidgetNode.localPlayer.x < 13312 && WidgetNode.localPlayer.y < 13312) {
                  if((class10.tileSettings[CollisionData.plane][WidgetNode.localPlayer.x >> 7][WidgetNode.localPlayer.y >> 7] & 4) != 0) {
                     var7 = CollisionData.plane;
                  }

                  var20 = var7;
               } else {
                  var20 = CollisionData.plane;
               }
            }
         }

         var5 = var20;
      } else {
         if(ObjectComposition.field2944.field690) {
            var20 = CollisionData.plane;
         } else {
            var7 = class25.method615(FaceNormal.cameraX, ChatLineBuffer.cameraY, CollisionData.plane);
            if(var7 - class45.cameraZ < 800 && (class10.tileSettings[CollisionData.plane][FaceNormal.cameraX >> 7][ChatLineBuffer.cameraY >> 7] & 4) != 0) {
               var20 = CollisionData.plane;
            } else {
               var20 = 3;
            }
         }

         var5 = var20;
      }

      var20 = FaceNormal.cameraX;
      var7 = class45.cameraZ;
      var8 = ChatLineBuffer.cameraY;
      var9 = class10.cameraPitch;
      var10 = Projectile.cameraYaw;

      for(var11 = 0; var11 < 5; ++var11) {
         if(Client.field539[var11]) {
            var12 = (int)(Math.random() * (double)(Client.field540[var11] * 2 + 1) - (double)Client.field540[var11] + Math.sin((double)Client.field292[var11] * ((double)Client.field542[var11] / 100.0D)) * (double)Client.field541[var11]);
            if(var11 == 0) {
               FaceNormal.cameraX += var12;
            }

            if(var11 == 1) {
               class45.cameraZ += var12;
            }

            if(var11 == 2) {
               ChatLineBuffer.cameraY += var12;
            }

            if(var11 == 3) {
               Projectile.cameraYaw = Projectile.cameraYaw + var12 & 2047;
            }

            if(var11 == 4) {
               class10.cameraPitch += var12;
               if(class10.cameraPitch < 128) {
                  class10.cameraPitch = 128;
               }

               if(class10.cameraPitch > 383) {
                  class10.cameraPitch = 383;
               }
            }
         }
      }

      var11 = class115.field1805;
      var12 = class115.field1806;
      if(class115.field1811 != 0) {
         var11 = class115.field1812;
         var12 = class115.field1813;
      }

      if(var11 >= var0 && var11 < var0 + var2 && var12 >= var1 && var12 < var1 + var3) {
         Model.field1373 = true;
         Model.field1423 = 0;
         Model.field1410 = var11 - var0;
         Model.field1368 = var12 - var1;
      } else {
         Model.field1373 = false;
         Model.field1423 = 0;
      }

      class112.method2179();
      Rasterizer2D.method4056(var0, var1, var2, var3, 0);
      class112.method2179();
      var13 = class84.field1453;
      class84.field1453 = Client.scale;
      Friend.region.method1830(FaceNormal.cameraX, class45.cameraZ, ChatLineBuffer.cameraY, class10.cameraPitch, Projectile.cameraYaw, var5);
      class84.field1453 = var13;
      class112.method2179();
      Friend.region.method1804();
      class145.method2810(var0, var1, var2, var3);
      class188.method3513(var0, var1);
      ((TextureProvider)class84.field1457).method1514(Client.field365);
      class26.method616(var0, var1, var2, var3);
      FaceNormal.cameraX = var20;
      class45.cameraZ = var7;
      ChatLineBuffer.cameraY = var8;
      class10.cameraPitch = var9;
      Projectile.cameraYaw = var10;
      if(Client.field294 && class85.method1785(true, false) == 0) {
         Client.field294 = false;
      }

      if(Client.field294) {
         Rasterizer2D.method4056(var0, var1, var2, var3, 0);
         XGrandExchangeOffer.method69("Loading - please wait.", false);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "324895847"
   )
   public static int method1640(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)Ljava/lang/String;",
      garbageValue = "8"
   )
   static String method1641(Buffer var0, int var1) {
      try {
         int var2 = var0.method3039();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class210.field3129.method2808(var0.payload, var0.offset, var3, 0, var2);
         String var4 = ChatMessages.method919(var3, 0, var2);
         return var4;
      } catch (Exception var6) {
         return "Cabbage";
      }
   }

   Tile(int var1, int var2, int var3) {
      this.field1341 = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1929434748"
   )
   static final void method1642(int var0) {
      if(Projectile.method874(var0)) {
         XClanMember.method259(class231.widgets[var0], -1);
      }
   }
}
