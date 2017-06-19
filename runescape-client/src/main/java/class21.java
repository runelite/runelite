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
         if(var30.floor == Player.plane && Client.gameCycle <= var30.cycle) {
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
      Rasterizer2D.method4833(var0, var1, var0 + var2, var3 + var1);
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

         var15 = Client.mapAngle + Client.field1114 & 2047;
         var6 = class23.field367;
         var16 = class77.method1438(class20.localPlayer.x, class20.localPlayer.y, Player.plane) - Client.field995;
         var17 = DecorativeObject.field2178;
         var33 = var5 * 3 + 600;
         var34 = 2048 - var5 & 2047;
         var9 = 2048 - var15 & 2047;
         var10 = 0;
         var11 = 0;
         var12 = var33;
         int var18;
         if(var34 != 0) {
            var13 = class136.SINE[var34];
            var18 = class136.COSINE[var34];
            var14 = var18 * var11 - var13 * var33 >> 16;
            var12 = var13 * var11 + var18 * var33 >> 16;
            var11 = var14;
         }

         if(var9 != 0) {
            var13 = class136.SINE[var9];
            var18 = class136.COSINE[var9];
            var14 = var12 * var13 + var18 * var10 >> 16;
            var12 = var18 * var12 - var13 * var10 >> 16;
            var10 = var14;
         }

         class14.cameraX = var6 - var10;
         class112.cameraZ = var16 - var11;
         class66.cameraY = var17 - var12;
         class203.cameraPitch = var5;
         class13.cameraYaw = var15;
      }

      if(!Client.field1152) {
         if(Item.field1481.field1299) {
            var15 = Player.plane;
         } else {
            label534: {
               var6 = 3;
               if(class203.cameraPitch < 310) {
                  var16 = class14.cameraX >> 7;
                  var17 = class66.cameraY >> 7;
                  var33 = class20.localPlayer.x >> 7;
                  var34 = class20.localPlayer.y >> 7;
                  if(var16 < 0 || var17 < 0 || var16 >= 104 || var17 >= 104) {
                     var15 = Player.plane;
                     break label534;
                  }

                  if((class61.tileSettings[Player.plane][var16][var17] & 4) != 0) {
                     var6 = Player.plane;
                  }

                  if(var33 > var16) {
                     var9 = var33 - var16;
                  } else {
                     var9 = var16 - var33;
                  }

                  if(var34 > var17) {
                     var10 = var34 - var17;
                  } else {
                     var10 = var17 - var34;
                  }

                  if(var9 > var10) {
                     var11 = var10 * 65536 / var9;
                     var12 = '耀';

                     while(var16 != var33) {
                        if(var16 < var33) {
                           ++var16;
                        } else if(var16 > var33) {
                           --var16;
                        }

                        if((class61.tileSettings[Player.plane][var16][var17] & 4) != 0) {
                           var6 = Player.plane;
                        }

                        var12 += var11;
                        if(var12 >= 65536) {
                           var12 -= 65536;
                           if(var17 < var34) {
                              ++var17;
                           } else if(var17 > var34) {
                              --var17;
                           }

                           if((class61.tileSettings[Player.plane][var16][var17] & 4) != 0) {
                              var6 = Player.plane;
                           }
                        }
                     }
                  } else {
                     var11 = var9 * 65536 / var10;
                     var12 = '耀';

                     while(var17 != var34) {
                        if(var17 < var34) {
                           ++var17;
                        } else if(var17 > var34) {
                           --var17;
                        }

                        if((class61.tileSettings[Player.plane][var16][var17] & 4) != 0) {
                           var6 = Player.plane;
                        }

                        var12 += var11;
                        if(var12 >= 65536) {
                           var12 -= 65536;
                           if(var16 < var33) {
                              ++var16;
                           } else if(var16 > var33) {
                              --var16;
                           }

                           if((class61.tileSettings[Player.plane][var16][var17] & 4) != 0) {
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

                  var15 = var6;
               } else {
                  var15 = Player.plane;
               }
            }
         }

         var5 = var15;
      } else {
         if(Item.field1481.field1299) {
            var15 = Player.plane;
         } else {
            var6 = class77.method1438(class14.cameraX, class66.cameraY, Player.plane);
            if(var6 - class112.cameraZ < 800 && (class61.tileSettings[Player.plane][class14.cameraX >> 7][class66.cameraY >> 7] & 4) != 0) {
               var15 = Player.plane;
            } else {
               var15 = 3;
            }
         }

         var5 = var15;
      }

      var15 = class14.cameraX;
      var6 = class112.cameraZ;
      var16 = class66.cameraY;
      var17 = class203.cameraPitch;
      var33 = class13.cameraYaw;

      for(var34 = 0; var34 < 5; ++var34) {
         if(Client.field1153[var34]) {
            var9 = (int)(Math.random() * (double)(Client.field1129[var34] * 2 + 1) - (double)Client.field1129[var34] + Math.sin((double)Client.field982[var34] * ((double)Client.field1156[var34] / 100.0D)) * (double)Client.field1015[var34]);
            if(var34 == 0) {
               class14.cameraX += var9;
            }

            if(var34 == 1) {
               class112.cameraZ += var9;
            }

            if(var34 == 2) {
               class66.cameraY += var9;
            }

            if(var34 == 3) {
               class13.cameraYaw = var9 + class13.cameraYaw & 2047;
            }

            if(var34 == 4) {
               class203.cameraPitch += var9;
               if(class203.cameraPitch < 128) {
                  class203.cameraPitch = 128;
               }

               if(class203.cameraPitch > 383) {
                  class203.cameraPitch = 383;
               }
            }
         }
      }

      var34 = class59.field730;
      var9 = class59.field731;
      if(class59.field736 != 0) {
         var34 = class59.field737;
         var9 = class59.field732;
      }

      if(var34 >= var0 && var34 < var0 + var2 && var9 >= var1 && var9 < var3 + var1) {
         var10 = var34 - var0;
         var11 = var9 - var1;
         class134.field1994 = var10;
         class134.field1995 = var11;
         class134.field2006 = true;
         class134.field2000 = 0;
         class134.field2004 = false;
      } else {
         class36.method482();
      }

      class69.method1035();
      Rasterizer2D.method4826(var0, var1, var2, var3, 0);
      class69.method1035();
      var10 = class136.field2024;
      class136.field2024 = Client.scale;
      class17.region.method2619(class14.cameraX, class112.cameraZ, class66.cameraY, class203.cameraPitch, class13.cameraYaw, var5);

      while(true) {
         class9 var35 = (class9)class7.field237.method3444();
         if(var35 == null) {
            class136.field2024 = var10;
            class69.method1035();
            class17.region.method2694();
            Client.field1074 = 0;
            boolean var19 = false;
            var12 = -1;
            var13 = class96.field1487;
            int[] var20 = class96.field1491;

            for(var14 = 0; var14 < var13 + Client.field930; ++var14) {
               Object var21;
               if(var14 < var13) {
                  var21 = Client.cachedPlayers[var20[var14]];
                  if(var20[var14] == Client.field1035) {
                     var19 = true;
                     var12 = var14;
                     continue;
                  }
               } else {
                  var21 = Client.cachedNPCs[Client.npcIndices[var14 - var13]];
               }

               CombatInfo1.method1456((Actor)var21, var14, var0, var1, var2, var3);
            }

            if(var19) {
               CombatInfo1.method1456(Client.cachedPlayers[Client.field1035], var12, var0, var1, var2, var3);
            }

            for(var14 = 0; var14 < Client.field1074; ++var14) {
               int var36 = Client.field962[var14];
               int var22 = Client.field1002[var14];
               int var23 = Client.field1004[var14];
               int var24 = Client.field1003[var14];
               boolean var25 = true;

               while(var25) {
                  var25 = false;

                  for(int var26 = 0; var26 < var14; ++var26) {
                     if(var22 + 2 > Client.field1002[var26] - Client.field1003[var26] && var22 - var24 < Client.field1002[var26] + 2 && var36 - var23 < Client.field1004[var26] + Client.field962[var26] && var23 + var36 > Client.field962[var26] - Client.field1004[var26] && Client.field1002[var26] - Client.field1003[var26] < var22) {
                        var22 = Client.field1002[var26] - Client.field1003[var26];
                        var25 = true;
                     }
                  }
               }

               Client.field1011 = Client.field962[var14];
               Client.field1049 = Client.field1002[var14] = var22;
               String var38 = Client.field903[var14];
               if(Client.field1068 == 0) {
                  int var27 = 16776960;
                  if(Client.field1005[var14] < 6) {
                     var27 = Client.field1121[Client.field1005[var14]];
                  }

                  if(Client.field1005[var14] == 6) {
                     var27 = Client.field1010 % 20 < 10?16711680:16776960;
                  }

                  if(Client.field1005[var14] == 7) {
                     var27 = Client.field1010 % 20 < 10?255:'\uffff';
                  }

                  if(Client.field1005[var14] == 8) {
                     var27 = Client.field1010 % 20 < 10?'뀀':8454016;
                  }

                  int var28;
                  if(Client.field1005[var14] == 9) {
                     var28 = 150 - Client.field1007[var14];
                     if(var28 < 50) {
                        var27 = var28 * 1280 + 16711680;
                     } else if(var28 < 100) {
                        var27 = 16776960 - (var28 - 50) * 327680;
                     } else if(var28 < 150) {
                        var27 = (var28 - 100) * 5 + '\uff00';
                     }
                  }

                  if(Client.field1005[var14] == 10) {
                     var28 = 150 - Client.field1007[var14];
                     if(var28 < 50) {
                        var27 = var28 * 5 + 16711680;
                     } else if(var28 < 100) {
                        var27 = 16711935 - (var28 - 50) * 327680;
                     } else if(var28 < 150) {
                        var27 = (var28 - 100) * 327680 + 255 - (var28 - 100) * 5;
                     }
                  }

                  if(Client.field1005[var14] == 11) {
                     var28 = 150 - Client.field1007[var14];
                     if(var28 < 50) {
                        var27 = 16777215 - var28 * 327685;
                     } else if(var28 < 100) {
                        var27 = (var28 - 50) * 327685 + '\uff00';
                     } else if(var28 < 150) {
                        var27 = 16777215 - (var28 - 100) * 327680;
                     }
                  }

                  if(Client.field1006[var14] == 0) {
                     class64.field788.method4635(var38, var0 + Client.field1011, Client.field1049 + var1, var27, 0);
                  }

                  if(Client.field1006[var14] == 1) {
                     class64.field788.method4641(var38, var0 + Client.field1011, Client.field1049 + var1, var27, 0, Client.field1010);
                  }

                  if(Client.field1006[var14] == 2) {
                     class64.field788.method4638(var38, var0 + Client.field1011, Client.field1049 + var1, var27, 0, Client.field1010);
                  }

                  if(Client.field1006[var14] == 3) {
                     class64.field788.method4639(var38, var0 + Client.field1011, Client.field1049 + var1, var27, 0, Client.field1010, 150 - Client.field1007[var14]);
                  }

                  if(Client.field1006[var14] == 4) {
                     var28 = (150 - Client.field1007[var14]) * (class64.field788.method4696(var38) + 100) / 150;
                     Rasterizer2D.method4862(var0 + Client.field1011 - 50, var1, var0 + Client.field1011 + 50, var3 + var1);
                     class64.field788.method4647(var38, var0 + Client.field1011 + 50 - var28, Client.field1049 + var1, var27, 0);
                     Rasterizer2D.method4833(var0, var1, var0 + var2, var3 + var1);
                  }

                  if(Client.field1006[var14] == 5) {
                     var28 = 150 - Client.field1007[var14];
                     int var29 = 0;
                     if(var28 < 25) {
                        var29 = var28 - 25;
                     } else if(var28 > 125) {
                        var29 = var28 - 125;
                     }

                     Rasterizer2D.method4862(var0, Client.field1049 + var1 - class64.field788.field3643 - 1, var0 + var2, Client.field1049 + var1 + 5);
                     class64.field788.method4635(var38, var0 + Client.field1011, var1 + var29 + Client.field1049, var27, 0);
                     Rasterizer2D.method4833(var0, var1, var0 + var2, var3 + var1);
                  }
               } else {
                  class64.field788.method4635(var38, var0 + Client.field1011, Client.field1049 + var1, 16776960, 0);
               }
            }

            class17.method139(var0, var1);
            ((TextureProvider)class136.field2028).method2286(Client.field1125);
            class92.method1646(var0, var1, var2, var3);
            class14.cameraX = var15;
            class112.cameraZ = var6;
            class66.cameraY = var16;
            class203.cameraPitch = var17;
            class13.cameraYaw = var33;
            if(Client.field960) {
               byte var37 = 0;
               var12 = var37 + class238.field3267 + class238.field3269;
               if(var12 == 0) {
                  Client.field960 = false;
               }
            }

            if(Client.field960) {
               Rasterizer2D.method4826(var0, var1, var2, var3, 0);
               class158.drawStatusBox("Loading - please wait.", false);
            }

            return;
         }

         var35.vmethod55();
      }
   }
}
