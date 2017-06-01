import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
public final class class61 {
   @ObfuscatedName("q")
   static int[] field756;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -93746347
   )
   static int field757;
   @ObfuscatedName("w")
   static final int[] field758;
   @ObfuscatedName("v")
   @Export("underlayIds")
   static byte[][][] underlayIds;
   @ObfuscatedName("g")
   static final int[] field760;
   @ObfuscatedName("y")
   @Export("overlayPaths")
   static byte[][][] overlayPaths;
   @ObfuscatedName("n")
   static int[] field762;
   @ObfuscatedName("a")
   static int[] field763;
   @ObfuscatedName("z")
   static int[] field764;
   @ObfuscatedName("i")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("l")
   static final int[] field766;
   @ObfuscatedName("s")
   static final int[] field767;
   @ObfuscatedName("c")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("b")
   @Export("overlayIds")
   static byte[][][] overlayIds;
   @ObfuscatedName("p")
   static final int[] field770;
   @ObfuscatedName("d")
   static final int[] field771;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 921797429
   )
   static int field772;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -476645827
   )
   static int field773;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field757 = 99;
      field771 = new int[]{1, 2, 4, 8};
      field767 = new int[]{16, 32, 64, 128};
      field760 = new int[]{1, 0, -1, 0};
      field758 = new int[]{0, -1, 0, 1};
      field770 = new int[]{1, -1, -1, 1};
      field766 = new int[]{-1, -1, 1, 1};
      field772 = (int)(Math.random() * 17.0D) - 8;
      field773 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-387323802"
   )
   static String method1022(int var0) {
      return var0 < 0?"":(Client.menuTargets[var0].length() > 0?Client.menuOptions[var0] + " " + Client.menuTargets[var0]:Client.menuOptions[var0]);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[LCollisionData;I)V",
      garbageValue = "-1548195060"
   )
   static final void method1042(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionData[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var9 + var2 > 0 && var9 + var2 < 103 && var3 + var10 > 0 && var10 + var3 < 103) {
               var8[var1].flags[var2 + var9][var3 + var10] &= -16777217;
            }
         }
      }

      Buffer var13 = new Buffer(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var4 == var10 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < var6 + 8) {
                  class90.method1706(var13, var1, var2 + class64.method1069(var11 & 7, var12 & 7, var7), var3 + class87.method1696(var11 & 7, var12 & 7, var7), 0, 0, var7);
               } else {
                  class90.method1706(var13, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }

   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "-5282"
   )
   static final void method1047(int var0, int var1, int var2, int var3) {
      ++Client.field1034;
      class60.method1004(class66.field827);
      boolean var4 = false;
      int var5;
      int var7;
      if(Client.field1059 >= 0) {
         var5 = class96.field1507;
         int[] var6 = class96.field1508;

         for(var7 = 0; var7 < var5; ++var7) {
            if(Client.field1059 == var6[var7]) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         class60.method1004(class66.field823);
      }

      class33.method338(true);
      class60.method1004(var4?class66.field826:class66.field825);
      class33.method338(false);

      for(Projectile var19 = (Projectile)Client.projectiles.method3576(); var19 != null; var19 = (Projectile)Client.projectiles.method3578()) {
         if(FaceNormal.plane == var19.floor && Client.gameCycle <= var19.field1471) {
            if(Client.gameCycle >= var19.startTime) {
               if(var19.interacting > 0) {
                  NPC var22 = Client.cachedNPCs[var19.interacting - 1];
                  if(var22 != null && var22.x >= 0 && var22.x < 13312 && var22.y >= 0 && var22.y < 13312) {
                     var19.method1737(var22.x, var22.y, class21.method139(var22.x, var22.y, var19.floor) - var19.field1476, Client.gameCycle);
                  }
               }

               if(var19.interacting < 0) {
                  var7 = -var19.interacting - 1;
                  Player var23;
                  if(var7 == Client.localInteractingIndex) {
                     var23 = World.localPlayer;
                  } else {
                     var23 = Client.cachedPlayers[var7];
                  }

                  if(var23 != null && var23.x >= 0 && var23.x < 13312 && var23.y >= 0 && var23.y < 13312) {
                     var19.method1737(var23.x, var23.y, class21.method139(var23.x, var23.y, var19.floor) - var19.field1476, Client.gameCycle);
                  }
               }

               var19.method1744(Client.field1119);
               class1.region.method2685(FaceNormal.plane, (int)var19.x, (int)var19.velocityZ, (int)var19.z, 60, var19, var19.field1491, -1, false);
            }
         } else {
            var19.unlink();
         }
      }

      ItemLayer.method2394();
      class91.method1710(var0, var1, var2, var3, true);
      var0 = Client.field1190;
      var1 = Client.field1191;
      var2 = Client.camera2;
      var3 = Client.camera3;
      Rasterizer2D.method4940(var0, var1, var0 + var2, var1 + var3);
      class136.method2595();
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var21;
      if(!Client.field989) {
         var5 = Client.field1013;
         if(Client.field1047 / 256 > var5) {
            var5 = Client.field1047 / 256;
         }

         if(Client.field1183[4] && Client.field1179[4] + 128 > var5) {
            var5 = Client.field1179[4] + 128;
         }

         var21 = Client.field1041 + Client.mapAngle & 2047;
         var7 = class2.field16;
         var8 = class21.method139(World.localPlayer.x, World.localPlayer.y, FaceNormal.plane) - Client.field1019;
         var9 = WorldMapType2.field515;
         var10 = var5 * 3 + 600;
         var11 = 2048 - var5 & 2047;
         var12 = 2048 - var21 & 2047;
         var13 = 0;
         var14 = 0;
         var15 = var10;
         int var16;
         int var17;
         int var18;
         if(var11 != 0) {
            var16 = class136.SINE[var11];
            var17 = class136.COSINE[var11];
            var18 = var14 * var17 - var10 * var16 >> 16;
            var15 = var10 * var17 + var14 * var16 >> 16;
            var14 = var18;
         }

         if(var12 != 0) {
            var16 = class136.SINE[var12];
            var17 = class136.COSINE[var12];
            var18 = var13 * var17 + var16 * var15 >> 16;
            var15 = var17 * var15 - var13 * var16 >> 16;
            var13 = var18;
         }

         TextureProvider.cameraX = var7 - var13;
         class19.cameraZ = var8 - var14;
         class67.cameraY = var9 - var15;
         Preferences.cameraPitch = var5;
         class13.cameraYaw = var21;
      }

      if(!Client.field989) {
         if(XGrandExchangeOffer.field303.field1333) {
            var21 = FaceNormal.plane;
         } else {
            label485: {
               var7 = 3;
               if(Preferences.cameraPitch < 310) {
                  var8 = TextureProvider.cameraX >> 7;
                  var9 = class67.cameraY >> 7;
                  var10 = World.localPlayer.x >> 7;
                  var11 = World.localPlayer.y >> 7;
                  if(var8 < 0 || var9 < 0 || var8 >= 104 || var9 >= 104) {
                     var21 = FaceNormal.plane;
                     break label485;
                  }

                  if((tileSettings[FaceNormal.plane][var8][var9] & 4) != 0) {
                     var7 = FaceNormal.plane;
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

                     while(var8 != var10) {
                        if(var8 < var10) {
                           ++var8;
                        } else if(var8 > var10) {
                           --var8;
                        }

                        if((tileSettings[FaceNormal.plane][var8][var9] & 4) != 0) {
                           var7 = FaceNormal.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var9 < var11) {
                              ++var9;
                           } else if(var9 > var11) {
                              --var9;
                           }

                           if((tileSettings[FaceNormal.plane][var8][var9] & 4) != 0) {
                              var7 = FaceNormal.plane;
                           }
                        }
                     }
                  } else {
                     var14 = var12 * 65536 / var13;
                     var15 = '耀';

                     while(var11 != var9) {
                        if(var9 < var11) {
                           ++var9;
                        } else if(var9 > var11) {
                           --var9;
                        }

                        if((tileSettings[FaceNormal.plane][var8][var9] & 4) != 0) {
                           var7 = FaceNormal.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var8 < var10) {
                              ++var8;
                           } else if(var8 > var10) {
                              --var8;
                           }

                           if((tileSettings[FaceNormal.plane][var8][var9] & 4) != 0) {
                              var7 = FaceNormal.plane;
                           }
                        }
                     }
                  }
               }

               if(World.localPlayer.x >= 0 && World.localPlayer.y >= 0 && World.localPlayer.x < 13312 && World.localPlayer.y < 13312) {
                  if((tileSettings[FaceNormal.plane][World.localPlayer.x >> 7][World.localPlayer.y >> 7] & 4) != 0) {
                     var7 = FaceNormal.plane;
                  }

                  var21 = var7;
               } else {
                  var21 = FaceNormal.plane;
               }
            }
         }

         var5 = var21;
      } else {
         if(XGrandExchangeOffer.field303.field1333) {
            var21 = FaceNormal.plane;
         } else {
            var7 = class21.method139(TextureProvider.cameraX, class67.cameraY, FaceNormal.plane);
            if(var7 - class19.cameraZ < 800 && (tileSettings[FaceNormal.plane][TextureProvider.cameraX >> 7][class67.cameraY >> 7] & 4) != 0) {
               var21 = FaceNormal.plane;
            } else {
               var21 = 3;
            }
         }

         var5 = var21;
      }

      var21 = TextureProvider.cameraX;
      var7 = class19.cameraZ;
      var8 = class67.cameraY;
      var9 = Preferences.cameraPitch;
      var10 = class13.cameraYaw;

      for(var11 = 0; var11 < 5; ++var11) {
         if(Client.field1183[var11]) {
            var12 = (int)(Math.random() * (double)(Client.field1178[var11] * 2 + 1) - (double)Client.field1178[var11] + Math.sin((double)Client.field1180[var11] / 100.0D * (double)Client.field1181[var11]) * (double)Client.field1179[var11]);
            if(var11 == 0) {
               TextureProvider.cameraX += var12;
            }

            if(var11 == 1) {
               class19.cameraZ += var12;
            }

            if(var11 == 2) {
               class67.cameraY += var12;
            }

            if(var11 == 3) {
               class13.cameraYaw = class13.cameraYaw + var12 & 2047;
            }

            if(var11 == 4) {
               Preferences.cameraPitch += var12;
               if(Preferences.cameraPitch < 128) {
                  Preferences.cameraPitch = 128;
               }

               if(Preferences.cameraPitch > 383) {
                  Preferences.cameraPitch = 383;
               }
            }
         }
      }

      var11 = class59.field737;
      var12 = class59.field738;
      if(class59.field732 != 0) {
         var11 = class59.field745;
         var12 = class59.field750;
      }

      if(var11 >= var0 && var11 < var2 + var0 && var12 >= var1 && var12 < var3 + var1) {
         var13 = var11 - var0;
         var14 = var12 - var1;
         class134.field2008 = var13;
         class134.field2007 = var14;
         class134.field2018 = true;
         class134.field2013 = 0;
         class134.field2015 = false;
      } else {
         class17.method104();
      }

      WidgetNode.method1084();
      Rasterizer2D.method4923(var0, var1, var2, var3, 0);
      WidgetNode.method1084();
      var13 = class136.field2038;
      class136.field2038 = Client.scale;
      class1.region.method2817(TextureProvider.cameraX, class19.cameraZ, class67.cameraY, Preferences.cameraPitch, class13.cameraYaw, var5);

      while(true) {
         class9 var20 = (class9)class7.field239.method3534();
         if(var20 == null) {
            class136.field2038 = var13;
            WidgetNode.method1084();
            class1.region.method2783();
            class66.method1079(var0, var1, var2, var3);
            if(Client.field945 == 2) {
               class34.method472(Client.field1127 + (Client.field948 - class41.baseX << 7), Client.field952 + (Client.field949 - WorldMapType3.baseY << 7), Client.field1176 * 2);
               if(Client.field1124 > -1 && Client.gameCycle % 20 < 10) {
                  class51.field670[0].method5047(var0 + Client.field1124 - 12, var1 + Client.field1093 - 28);
               }
            }

            ((TextureProvider)class136.field2049).method2373(Client.field1119);
            class202.method3644(var0, var1, var2, var3);
            TextureProvider.cameraX = var21;
            class19.cameraZ = var7;
            class67.cameraY = var8;
            Preferences.cameraPitch = var9;
            class13.cameraYaw = var10;
            if(Client.field978 && class23.method158(true, false) == 0) {
               Client.field978 = false;
            }

            if(Client.field978) {
               Rasterizer2D.method4923(var0, var1, var2, var3, 0);
               KitDefinition.method4378("Loading - please wait.", false);
            }

            return;
         }

         var20.vmethod44();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LModel;IIII)V",
      garbageValue = "-2087106477"
   )
   public static final void method1049(Model var0, int var1, int var2, int var3) {
      if(class228.method4085(var0, var1, var2, var3)) {
         GameEngine.method857(var0, var1, var2, var3, -65281);
      } else if(class11.field263 == class7.field240) {
         GameEngine.method857(var0, var1, var2, var3, -16776961);
      }

   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "-1012115712"
   )
   static final void method1050(Actor var0, int var1) {
      if(var0.field1250 > Client.gameCycle) {
         class109.method2058(var0);
      } else if(var0.field1289 >= Client.gameCycle) {
         Player.method1134(var0);
      } else {
         class96.method1763(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1250 = 0;
         var0.field1289 = 0;
         var0.x = var0.field1268 * 64 + var0.pathX[0] * 128;
         var0.y = var0.field1268 * 64 + var0.pathY[0] * 128;
         var0.method1514();
      }

      if(var0 == World.localPlayer && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1250 = 0;
         var0.field1289 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1268 * 64;
         var0.y = var0.field1268 * 64 + var0.pathY[0] * 128;
         var0.method1514();
      }

      if(var0.field1295 != 0) {
         if(var0.interacting != -1) {
            Object var2 = null;
            if(var0.interacting < '耀') {
               var2 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var2 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(var2 != null) {
               int var3 = var0.x - ((Actor)var2).x;
               int var4 = var0.y - ((Actor)var2).y;
               if(var3 != 0 || var4 != 0) {
                  var0.field1259 = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field1269) {
               var0.interacting = -1;
               var0.field1269 = false;
            }
         }

         if(var0.field1270 != -1 && (var0.field1263 == 0 || var0.field1300 > 0)) {
            var0.field1259 = var0.field1270;
            var0.field1270 = -1;
         }

         int var5 = var0.field1259 - var0.angle & 2047;
         if(var5 == 0 && var0.field1269) {
            var0.interacting = -1;
            var0.field1269 = false;
         }

         if(var5 != 0) {
            ++var0.field1267;
            boolean var7;
            if(var5 > 1024) {
               var0.angle -= var0.field1295;
               var7 = true;
               if(var5 < var0.field1295 || var5 > 2048 - var0.field1295) {
                  var0.angle = var0.field1259;
                  var7 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field1267 > 25 || var7)) {
                  if(var0.field1248 != -1) {
                     var0.poseAnimation = var0.field1248;
                  } else {
                     var0.poseAnimation = var0.field1242;
                  }
               }
            } else {
               var0.angle += var0.field1295;
               var7 = true;
               if(var5 < var0.field1295 || var5 > 2048 - var0.field1295) {
                  var0.angle = var0.field1259;
                  var7 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1267 > 25 || var7)) {
                  if(var0.field1249 != -1) {
                     var0.poseAnimation = var0.field1249;
                  } else {
                     var0.poseAnimation = var0.field1242;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1267 = 0;
         }
      }

      class6.method14(var0);
   }
}
