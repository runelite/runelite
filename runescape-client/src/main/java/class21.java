import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public class class21 {
   @ObfuscatedName("c")
   static ModIcon field351;
   @ObfuscatedName("z")
   static Thread field352;
   @ObfuscatedName("p")
   public static IndexDataBase field353;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = 1312939941
   )
   @Export("baseY")
   static int baseY;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;S)I",
      garbageValue = "-14608"
   )
   static int method169(IndexDataBase var0, IndexDataBase var1) {
      int var2 = 0;
      if(var0.method4026("title.jpg", "")) {
         ++var2;
      }

      if(var1.method4026("logo", "")) {
         ++var2;
      }

      if(var1.method4026("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method4026("titlebox", "")) {
         ++var2;
      }

      if(var1.method4026("titlebutton", "")) {
         ++var2;
      }

      if(var1.method4026("runes", "")) {
         ++var2;
      }

      if(var1.method4026("title_mute", "")) {
         ++var2;
      }

      if(var1.method4026("options_radio_buttons,0", "")) {
         ++var2;
      }

      if(var1.method4026("options_radio_buttons,2", "")) {
         ++var2;
      }

      var1.method4026("sl_back", "");
      var1.method4026("sl_flags", "");
      var1.method4026("sl_arrows", "");
      var1.method4026("sl_stars", "");
      var1.method4026("sl_button", "");
      return var2;
   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "67"
   )
   static final void method173(int var0, int var1, int var2, int var3) {
      ++Client.field1010;
      CombatInfoListHolder.method1572(class66.field802);
      boolean var4 = false;
      int var5;
      int var6;
      if(Client.field1035 >= 0) {
         var5 = class96.field1487;
         int[] var7 = class96.field1491;

         for(var6 = 0; var6 < var5; ++var6) {
            if(var7[var6] == Client.field1035) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         CombatInfoListHolder.method1572(class66.field804);
      }

      class5.method15(true);
      CombatInfoListHolder.method1572(var4?class66.field798:class66.field800);
      class5.method15(false);

      for(Projectile var30 = (Projectile)Client.projectiles.method3487(); var30 != null; var30 = (Projectile)Client.projectiles.method3512()) {
         if(Player.plane == var30.floor && Client.gameCycle <= var30.cycle) {
            if(Client.gameCycle >= var30.startTime) {
               if(var30.interacting > 0) {
                  NPC var8 = Client.cachedNPCs[var30.interacting - 1];
                  if(var8 != null && var8.x >= 0 && var8.x < 13312 && var8.y >= 0 && var8.y < 13312) {
                     var30.method1653(var8.x, var8.y, class77.method1438(var8.x, var8.y, var30.floor) - var30.field1454, Client.gameCycle);
                  }
               }

               if(var30.interacting < 0) {
                  var6 = -var30.interacting - 1;
                  Player var32;
                  if(Client.localInteractingIndex == var6) {
                     var32 = class20.localPlayer;
                  } else {
                     var32 = Client.cachedPlayers[var6];
                  }

                  if(var32 != null && var32.x >= 0 && var32.x < 13312 && var32.y >= 0 && var32.y < 13312) {
                     var30.method1653(var32.x, var32.y, class77.method1438(var32.x, var32.y, var30.floor) - var30.field1454, Client.gameCycle);
                  }
               }

               var30.method1654(Client.field1125);
               class17.region.method2610(Player.plane, (int)var30.x, (int)var30.velocityZ, (int)var30.z, 60, var30, var30.rotationX, -1, false);
            }
         } else {
            var30.unlink();
         }
      }

      for(GraphicsObject var31 = (GraphicsObject)Client.field1033.method3487(); var31 != null; var31 = (GraphicsObject)Client.field1033.method3512()) {
         if(var31.level == Player.plane && !var31.field1342) {
            if(Client.gameCycle >= var31.field1343) {
               var31.method1562(Client.field1125);
               if(var31.field1342) {
                  var31.unlink();
               } else {
                  class17.region.method2610(var31.level, var31.x, var31.y, var31.height, 60, var31, 0, -1, false);
               }
            }
         } else {
            var31.unlink();
         }
      }

      Player.method1069(var0, var1, var2, var3, true);
      var0 = Client.field1166;
      var1 = Client.field1167;
      var2 = Client.viewportHeight;
      var3 = Client.viewportWidth;
      Rasterizer2D.method4833(var0, var1, var2 + var0, var3 + var1);
      class136.method2493();
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      int var33;
      int var34;
      if(!Client.field1152) {
         var5 = Client.field1159;
         if(Client.field998 / 256 > var5) {
            var5 = Client.field998 / 256;
         }

         if(Client.field1153[4] && Client.field1015[4] + 128 > var5) {
            var5 = Client.field1015[4] + 128;
         }

         var17 = Client.mapAngle + Client.field1114 & 2047;
         var6 = class23.field367;
         var33 = class77.method1438(class20.localPlayer.x, class20.localPlayer.y, Player.plane) - Client.field995;
         var34 = DecorativeObject.field2178;
         var9 = var5 * 3 + 600;
         var10 = 2048 - var5 & 2047;
         var11 = 2048 - var17 & 2047;
         var12 = 0;
         var13 = 0;
         var14 = var9;
         int var18;
         if(var10 != 0) {
            var15 = class136.SINE[var10];
            var18 = class136.COSINE[var10];
            var16 = var18 * var13 - var15 * var9 >> 16;
            var14 = var13 * var15 + var18 * var9 >> 16;
            var13 = var16;
         }

         if(var11 != 0) {
            var15 = class136.SINE[var11];
            var18 = class136.COSINE[var11];
            var16 = var12 * var18 + var14 * var15 >> 16;
            var14 = var18 * var14 - var15 * var12 >> 16;
            var12 = var16;
         }

         class14.cameraX = var6 - var12;
         class112.cameraZ = var33 - var13;
         class66.cameraY = var34 - var14;
         class203.cameraPitch = var5;
         class13.cameraYaw = var17;
      }

      if(!Client.field1152) {
         if(Item.field1481.field1299) {
            var17 = Player.plane;
         } else {
            label534: {
               var6 = 3;
               if(class203.cameraPitch < 310) {
                  var33 = class14.cameraX >> 7;
                  var34 = class66.cameraY >> 7;
                  var9 = class20.localPlayer.x >> 7;
                  var10 = class20.localPlayer.y >> 7;
                  if(var33 < 0 || var34 < 0 || var33 >= 104 || var34 >= 104) {
                     var17 = Player.plane;
                     break label534;
                  }

                  if((class61.tileSettings[Player.plane][var33][var34] & 4) != 0) {
                     var6 = Player.plane;
                  }

                  if(var9 > var33) {
                     var11 = var9 - var33;
                  } else {
                     var11 = var33 - var9;
                  }

                  if(var10 > var34) {
                     var12 = var10 - var34;
                  } else {
                     var12 = var34 - var10;
                  }

                  if(var11 > var12) {
                     var13 = var12 * 65536 / var11;
                     var14 = '耀';

                     while(var33 != var9) {
                        if(var33 < var9) {
                           ++var33;
                        } else if(var33 > var9) {
                           --var33;
                        }

                        if((class61.tileSettings[Player.plane][var33][var34] & 4) != 0) {
                           var6 = Player.plane;
                        }

                        var14 += var13;
                        if(var14 >= 65536) {
                           var14 -= 65536;
                           if(var34 < var10) {
                              ++var34;
                           } else if(var34 > var10) {
                              --var34;
                           }

                           if((class61.tileSettings[Player.plane][var33][var34] & 4) != 0) {
                              var6 = Player.plane;
                           }
                        }
                     }
                  } else {
                     var13 = var11 * 65536 / var12;
                     var14 = '耀';

                     while(var34 != var10) {
                        if(var34 < var10) {
                           ++var34;
                        } else if(var34 > var10) {
                           --var34;
                        }

                        if((class61.tileSettings[Player.plane][var33][var34] & 4) != 0) {
                           var6 = Player.plane;
                        }

                        var14 += var13;
                        if(var14 >= 65536) {
                           var14 -= 65536;
                           if(var33 < var9) {
                              ++var33;
                           } else if(var33 > var9) {
                              --var33;
                           }

                           if((class61.tileSettings[Player.plane][var33][var34] & 4) != 0) {
                              var6 = Player.plane;
                           }
                        }
                     }
                  }
               }

               if(class20.localPlayer.x >= 0 && class20.localPlayer.y >= 0 && class20.localPlayer.x < 13312 && class20.localPlayer.y < 13312) {
                  if((class61.tileSettings[Player.plane][class20.localPlayer.x >> 7][class20.localPlayer.y >> 7] & 4) != 0) {
                     var6 = Player.plane;
                  }

                  var17 = var6;
               } else {
                  var17 = Player.plane;
               }
            }
         }

         var5 = var17;
      } else {
         if(Item.field1481.field1299) {
            var17 = Player.plane;
         } else {
            var6 = class77.method1438(class14.cameraX, class66.cameraY, Player.plane);
            if(var6 - class112.cameraZ < 800 && (class61.tileSettings[Player.plane][class14.cameraX >> 7][class66.cameraY >> 7] & 4) != 0) {
               var17 = Player.plane;
            } else {
               var17 = 3;
            }
         }

         var5 = var17;
      }

      var17 = class14.cameraX;
      var6 = class112.cameraZ;
      var33 = class66.cameraY;
      var34 = class203.cameraPitch;
      var9 = class13.cameraYaw;

      for(var10 = 0; var10 < 5; ++var10) {
         if(Client.field1153[var10]) {
            var11 = (int)(Math.random() * (double)(Client.field1129[var10] * 2 + 1) - (double)Client.field1129[var10] + Math.sin((double)Client.field982[var10] * ((double)Client.field1156[var10] / 100.0D)) * (double)Client.field1015[var10]);
            if(var10 == 0) {
               class14.cameraX += var11;
            }

            if(var10 == 1) {
               class112.cameraZ += var11;
            }

            if(var10 == 2) {
               class66.cameraY += var11;
            }

            if(var10 == 3) {
               class13.cameraYaw = class13.cameraYaw + var11 & 2047;
            }

            if(var10 == 4) {
               class203.cameraPitch += var11;
               if(class203.cameraPitch < 128) {
                  class203.cameraPitch = 128;
               }

               if(class203.cameraPitch > 383) {
                  class203.cameraPitch = 383;
               }
            }
         }
      }

      var10 = class59.field730;
      var11 = class59.field731;
      if(class59.field736 != 0) {
         var10 = class59.field737;
         var11 = class59.field732;
      }

      if(var10 >= var0 && var10 < var2 + var0 && var11 >= var1 && var11 < var1 + var3) {
         var12 = var10 - var0;
         var13 = var11 - var1;
         class134.field1994 = var12;
         class134.field1995 = var13;
         class134.field2006 = true;
         class134.field2000 = 0;
         class134.field2004 = false;
      } else {
         class36.method482();
      }

      class69.method1035();
      Rasterizer2D.method4826(var0, var1, var2, var3, 0);
      class69.method1035();
      var12 = class136.field2024;
      class136.field2024 = Client.scale;
      class17.region.method2619(class14.cameraX, class112.cameraZ, class66.cameraY, class203.cameraPitch, class13.cameraYaw, var5);

      while(true) {
         class9 var35 = (class9)class7.field237.method3444();
         if(var35 == null) {
            class136.field2024 = var12;
            class69.method1035();
            class17.region.method2694();
            Client.field1074 = 0;
            boolean var19 = false;
            var14 = -1;
            var15 = class96.field1487;
            int[] var20 = class96.field1491;

            for(var16 = 0; var16 < var15 + Client.field930; ++var16) {
               Object var21;
               if(var16 < var15) {
                  var21 = Client.cachedPlayers[var20[var16]];
                  if(var20[var16] == Client.field1035) {
                     var19 = true;
                     var14 = var16;
                     continue;
                  }
               } else {
                  var21 = Client.cachedNPCs[Client.npcIndices[var16 - var15]];
               }

               CombatInfo1.method1456((Actor)var21, var16, var0, var1, var2, var3);
            }

            if(var19) {
               CombatInfo1.method1456(Client.cachedPlayers[Client.field1035], var14, var0, var1, var2, var3);
            }

            for(var16 = 0; var16 < Client.field1074; ++var16) {
               int var36 = Client.field962[var16];
               int var22 = Client.field1002[var16];
               int var23 = Client.field1004[var16];
               int var24 = Client.field1003[var16];
               boolean var25 = true;

               while(var25) {
                  var25 = false;

                  for(int var26 = 0; var26 < var16; ++var26) {
                     if(var22 + 2 > Client.field1002[var26] - Client.field1003[var26] && var22 - var24 < Client.field1002[var26] + 2 && var36 - var23 < Client.field1004[var26] + Client.field962[var26] && var23 + var36 > Client.field962[var26] - Client.field1004[var26] && Client.field1002[var26] - Client.field1003[var26] < var22) {
                        var22 = Client.field1002[var26] - Client.field1003[var26];
                        var25 = true;
                     }
                  }
               }

               Client.field1011 = Client.field962[var16];
               Client.field1049 = Client.field1002[var16] = var22;
               String var38 = Client.field903[var16];
               if(Client.field1068 == 0) {
                  int var27 = 16776960;
                  if(Client.field1005[var16] < 6) {
                     var27 = Client.field1121[Client.field1005[var16]];
                  }

                  if(Client.field1005[var16] == 6) {
                     var27 = Client.field1010 % 20 < 10?16711680:16776960;
                  }

                  if(Client.field1005[var16] == 7) {
                     var27 = Client.field1010 % 20 < 10?255:'\uffff';
                  }

                  if(Client.field1005[var16] == 8) {
                     var27 = Client.field1010 % 20 < 10?'뀀':8454016;
                  }

                  int var28;
                  if(Client.field1005[var16] == 9) {
                     var28 = 150 - Client.field1007[var16];
                     if(var28 < 50) {
                        var27 = var28 * 1280 + 16711680;
                     } else if(var28 < 100) {
                        var27 = 16776960 - (var28 - 50) * 327680;
                     } else if(var28 < 150) {
                        var27 = (var28 - 100) * 5 + '\uff00';
                     }
                  }

                  if(Client.field1005[var16] == 10) {
                     var28 = 150 - Client.field1007[var16];
                     if(var28 < 50) {
                        var27 = var28 * 5 + 16711680;
                     } else if(var28 < 100) {
                        var27 = 16711935 - (var28 - 50) * 327680;
                     } else if(var28 < 150) {
                        var27 = (var28 - 100) * 327680 + 255 - (var28 - 100) * 5;
                     }
                  }

                  if(Client.field1005[var16] == 11) {
                     var28 = 150 - Client.field1007[var16];
                     if(var28 < 50) {
                        var27 = 16777215 - var28 * 327685;
                     } else if(var28 < 100) {
                        var27 = (var28 - 50) * 327685 + '\uff00';
                     } else if(var28 < 150) {
                        var27 = 16777215 - (var28 - 100) * 327680;
                     }
                  }

                  if(Client.field1006[var16] == 0) {
                     class64.field788.method4635(var38, var0 + Client.field1011, Client.field1049 + var1, var27, 0);
                  }

                  if(Client.field1006[var16] == 1) {
                     class64.field788.method4641(var38, var0 + Client.field1011, var1 + Client.field1049, var27, 0, Client.field1010);
                  }

                  if(Client.field1006[var16] == 2) {
                     class64.field788.method4638(var38, var0 + Client.field1011, var1 + Client.field1049, var27, 0, Client.field1010);
                  }

                  if(Client.field1006[var16] == 3) {
                     class64.field788.method4639(var38, var0 + Client.field1011, Client.field1049 + var1, var27, 0, Client.field1010, 150 - Client.field1007[var16]);
                  }

                  if(Client.field1006[var16] == 4) {
                     var28 = (150 - Client.field1007[var16]) * (class64.field788.method4696(var38) + 100) / 150;
                     Rasterizer2D.method4862(Client.field1011 + var0 - 50, var1, var0 + Client.field1011 + 50, var1 + var3);
                     class64.field788.method4647(var38, var0 + Client.field1011 + 50 - var28, var1 + Client.field1049, var27, 0);
                     Rasterizer2D.method4833(var0, var1, var2 + var0, var1 + var3);
                  }

                  if(Client.field1006[var16] == 5) {
                     var28 = 150 - Client.field1007[var16];
                     int var29 = 0;
                     if(var28 < 25) {
                        var29 = var28 - 25;
                     } else if(var28 > 125) {
                        var29 = var28 - 125;
                     }

                     Rasterizer2D.method4862(var0, var1 + Client.field1049 - class64.field788.field3643 - 1, var2 + var0, Client.field1049 + var1 + 5);
                     class64.field788.method4635(var38, var0 + Client.field1011, var29 + Client.field1049 + var1, var27, 0);
                     Rasterizer2D.method4833(var0, var1, var2 + var0, var1 + var3);
                  }
               } else {
                  class64.field788.method4635(var38, var0 + Client.field1011, var1 + Client.field1049, 16776960, 0);
               }
            }

            class17.method139(var0, var1);
            ((TextureProvider)class136.field2028).method2286(Client.field1125);
            class92.method1646(var0, var1, var2, var3);
            class14.cameraX = var17;
            class112.cameraZ = var6;
            class66.cameraY = var33;
            class203.cameraPitch = var34;
            class13.cameraYaw = var9;
            if(Client.field960) {
               byte var37 = 0;
               var14 = var37 + class238.field3267 + class238.field3269;
               if(var14 == 0) {
                  Client.field960 = false;
               }
            }

            if(Client.field960) {
               Rasterizer2D.method4826(var0, var1, var2, var3, 0);
               class158.method2877("Loading - please wait.", false);
            }

            return;
         }

         var35.vmethod55();
      }
   }
}
