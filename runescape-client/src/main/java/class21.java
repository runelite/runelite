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
      int var7;
      if(Client.field1035 >= 0) {
         var5 = class96.field1487;
         int[] var6 = class96.field1491;

         for(var7 = 0; var7 < var5; ++var7) {
            if(var6[var7] == Client.field1035) {
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

      for(Projectile var28 = (Projectile)Client.projectiles.method3487(); var28 != null; var28 = (Projectile)Client.projectiles.method3512()) {
         if(Player.plane == var28.floor && Client.gameCycle <= var28.cycle) {
            if(Client.gameCycle >= var28.startTime) {
               if(var28.interacting > 0) {
                  NPC var34 = Client.cachedNPCs[var28.interacting - 1];
                  if(var34 != null && var34.x >= 0 && var34.x < 13312 && var34.y >= 0 && var34.y < 13312) {
                     var28.method1653(var34.x, var34.y, class77.method1438(var34.x, var34.y, var28.floor) - var28.field1454, Client.gameCycle);
                  }
               }

               if(var28.interacting < 0) {
                  var7 = -var28.interacting - 1;
                  Player var35;
                  if(Client.localInteractingIndex == var7) {
                     var35 = class20.localPlayer;
                  } else {
                     var35 = Client.cachedPlayers[var7];
                  }

                  if(var35 != null && var35.x >= 0 && var35.x < 13312 && var35.y >= 0 && var35.y < 13312) {
                     var28.method1653(var35.x, var35.y, class77.method1438(var35.x, var35.y, var28.floor) - var28.field1454, Client.gameCycle);
                  }
               }

               var28.method1654(Client.field1125);
               class17.region.method2610(Player.plane, (int)var28.x, (int)var28.velocityZ, (int)var28.z, 60, var28, var28.rotationX, -1, false);
            }
         } else {
            var28.unlink();
         }
      }

      for(GraphicsObject var38 = (GraphicsObject)Client.field1033.method3487(); var38 != null; var38 = (GraphicsObject)Client.field1033.method3512()) {
         if(var38.level == Player.plane && !var38.field1342) {
            if(Client.gameCycle >= var38.field1343) {
               var38.method1562(Client.field1125);
               if(var38.field1342) {
                  var38.unlink();
               } else {
                  class17.region.method2610(var38.level, var38.x, var38.y, var38.height, 60, var38, 0, -1, false);
               }
            }
         } else {
            var38.unlink();
         }
      }

      Player.method1069(var0, var1, var2, var3, true);
      var0 = Client.field1166;
      var1 = Client.field1167;
      var2 = Client.viewportHeight;
      var3 = Client.viewportWidth;
      Rasterizer2D.method4833(var0, var1, var2 + var0, var3 + var1);
      class136.method2493();
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var18;
      int var29;
      if(!Client.field1152) {
         var5 = Client.field1159;
         if(Client.field998 / 256 > var5) {
            var5 = Client.field998 / 256;
         }

         if(Client.field1153[4] && Client.field1015[4] + 128 > var5) {
            var5 = Client.field1015[4] + 128;
         }

         var29 = Client.mapAngle + Client.field1114 & 2047;
         var7 = class23.field367;
         var8 = class77.method1438(class20.localPlayer.x, class20.localPlayer.y, Player.plane) - Client.field995;
         var9 = DecorativeObject.field2178;
         var10 = var5 * 3 + 600;
         var11 = 2048 - var5 & 2047;
         var12 = 2048 - var29 & 2047;
         var13 = 0;
         var14 = 0;
         var15 = var10;
         int var17;
         if(var11 != 0) {
            var16 = class136.SINE[var11];
            var17 = class136.COSINE[var11];
            var18 = var17 * var14 - var16 * var10 >> 16;
            var15 = var14 * var16 + var17 * var10 >> 16;
            var14 = var18;
         }

         if(var12 != 0) {
            var16 = class136.SINE[var12];
            var17 = class136.COSINE[var12];
            var18 = var13 * var17 + var15 * var16 >> 16;
            var15 = var17 * var15 - var16 * var13 >> 16;
            var13 = var18;
         }

         class14.cameraX = var7 - var13;
         class112.cameraZ = var8 - var14;
         class66.cameraY = var9 - var15;
         class203.cameraPitch = var5;
         class13.cameraYaw = var29;
      }

      if(!Client.field1152) {
         if(Item.field1481.field1299) {
            var29 = Player.plane;
         } else {
            label717: {
               var7 = 3;
               if(class203.cameraPitch < 310) {
                  var8 = class14.cameraX >> 7;
                  var9 = class66.cameraY >> 7;
                  var10 = class20.localPlayer.x >> 7;
                  var11 = class20.localPlayer.y >> 7;
                  if(var8 < 0 || var9 < 0 || var8 >= 104 || var9 >= 104) {
                     var29 = Player.plane;
                     break label717;
                  }

                  if((class61.tileSettings[Player.plane][var8][var9] & 4) != 0) {
                     var7 = Player.plane;
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

                        if((class61.tileSettings[Player.plane][var8][var9] & 4) != 0) {
                           var7 = Player.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var9 < var11) {
                              ++var9;
                           } else if(var9 > var11) {
                              --var9;
                           }

                           if((class61.tileSettings[Player.plane][var8][var9] & 4) != 0) {
                              var7 = Player.plane;
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

                        if((class61.tileSettings[Player.plane][var8][var9] & 4) != 0) {
                           var7 = Player.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var8 < var10) {
                              ++var8;
                           } else if(var8 > var10) {
                              --var8;
                           }

                           if((class61.tileSettings[Player.plane][var8][var9] & 4) != 0) {
                              var7 = Player.plane;
                           }
                        }
                     }
                  }
               }

               if(class20.localPlayer.x >= 0 && class20.localPlayer.y >= 0 && class20.localPlayer.x < 13312 && class20.localPlayer.y < 13312) {
                  if((class61.tileSettings[Player.plane][class20.localPlayer.x >> 7][class20.localPlayer.y >> 7] & 4) != 0) {
                     var7 = Player.plane;
                  }

                  var29 = var7;
               } else {
                  var29 = Player.plane;
               }
            }
         }

         var5 = var29;
      } else {
         if(Item.field1481.field1299) {
            var29 = Player.plane;
         } else {
            var7 = class77.method1438(class14.cameraX, class66.cameraY, Player.plane);
            if(var7 - class112.cameraZ < 800 && (class61.tileSettings[Player.plane][class14.cameraX >> 7][class66.cameraY >> 7] & 4) != 0) {
               var29 = Player.plane;
            } else {
               var29 = 3;
            }
         }

         var5 = var29;
      }

      var29 = class14.cameraX;
      var7 = class112.cameraZ;
      var8 = class66.cameraY;
      var9 = class203.cameraPitch;
      var10 = class13.cameraYaw;

      for(var11 = 0; var11 < 5; ++var11) {
         if(Client.field1153[var11]) {
            var12 = (int)(Math.random() * (double)(Client.field1129[var11] * 2 + 1) - (double)Client.field1129[var11] + Math.sin((double)Client.field982[var11] * ((double)Client.field1156[var11] / 100.0D)) * (double)Client.field1015[var11]);
            if(var11 == 0) {
               class14.cameraX += var12;
            }

            if(var11 == 1) {
               class112.cameraZ += var12;
            }

            if(var11 == 2) {
               class66.cameraY += var12;
            }

            if(var11 == 3) {
               class13.cameraYaw = class13.cameraYaw + var12 & 2047;
            }

            if(var11 == 4) {
               class203.cameraPitch += var12;
               if(class203.cameraPitch < 128) {
                  class203.cameraPitch = 128;
               }

               if(class203.cameraPitch > 383) {
                  class203.cameraPitch = 383;
               }
            }
         }
      }

      var11 = class59.field730;
      var12 = class59.field731;
      if(class59.field736 != 0) {
         var11 = class59.field737;
         var12 = class59.field732;
      }

      if(var11 >= var0 && var11 < var2 + var0 && var12 >= var1 && var12 < var1 + var3) {
         var13 = var11 - var0;
         var14 = var12 - var1;
         class134.field1994 = var13;
         class134.field1995 = var14;
         class134.field2006 = true;
         class134.field2000 = 0;
         class134.field2004 = false;
      } else {
         class36.method482();
      }

      class69.method1035();
      Rasterizer2D.method4826(var0, var1, var2, var3, 0);
      class69.method1035();
      var13 = class136.field2024;
      class136.field2024 = Client.scale;
      class17.region.method2619(class14.cameraX, class112.cameraZ, class66.cameraY, class203.cameraPitch, class13.cameraYaw, var5);

      while(true) {
         class9 var30 = (class9)class7.field237.method3444();
         if(var30 == null) {
            class136.field2024 = var13;
            class69.method1035();
            class17.region.method2694();
            Client.field1074 = 0;
            boolean var36 = false;
            var15 = -1;
            var16 = class96.field1487;
            int[] var31 = class96.field1491;

            for(var18 = 0; var18 < var16 + Client.field930; ++var18) {
               Object var19;
               if(var18 < var16) {
                  var19 = Client.cachedPlayers[var31[var18]];
                  if(var31[var18] == Client.field1035) {
                     var36 = true;
                     var15 = var18;
                     continue;
                  }
               } else {
                  var19 = Client.cachedNPCs[Client.npcIndices[var18 - var16]];
               }

               CombatInfo1.method1456((Actor)var19, var18, var0, var1, var2, var3);
            }

            if(var36) {
               CombatInfo1.method1456(Client.cachedPlayers[Client.field1035], var15, var0, var1, var2, var3);
            }

            for(var18 = 0; var18 < Client.field1074; ++var18) {
               int var32 = Client.field962[var18];
               int var20 = Client.field1002[var18];
               int var21 = Client.field1004[var18];
               int var22 = Client.field1003[var18];
               boolean var23 = true;

               while(var23) {
                  var23 = false;

                  for(int var24 = 0; var24 < var18; ++var24) {
                     if(var20 + 2 > Client.field1002[var24] - Client.field1003[var24] && var20 - var22 < Client.field1002[var24] + 2 && var32 - var21 < Client.field1004[var24] + Client.field962[var24] && var21 + var32 > Client.field962[var24] - Client.field1004[var24] && Client.field1002[var24] - Client.field1003[var24] < var20) {
                        var20 = Client.field1002[var24] - Client.field1003[var24];
                        var23 = true;
                     }
                  }
               }

               Client.field1011 = Client.field962[var18];
               Client.field1049 = Client.field1002[var18] = var20;
               String var33 = Client.field903[var18];
               if(Client.field1068 == 0) {
                  int var25 = 16776960;
                  if(Client.field1005[var18] < 6) {
                     var25 = Client.field1121[Client.field1005[var18]];
                  }

                  if(Client.field1005[var18] == 6) {
                     var25 = Client.field1010 % 20 < 10?16711680:16776960;
                  }

                  if(Client.field1005[var18] == 7) {
                     var25 = Client.field1010 % 20 < 10?255:'\uffff';
                  }

                  if(Client.field1005[var18] == 8) {
                     var25 = Client.field1010 % 20 < 10?'뀀':8454016;
                  }

                  int var26;
                  if(Client.field1005[var18] == 9) {
                     var26 = 150 - Client.field1007[var18];
                     if(var26 < 50) {
                        var25 = var26 * 1280 + 16711680;
                     } else if(var26 < 100) {
                        var25 = 16776960 - (var26 - 50) * 327680;
                     } else if(var26 < 150) {
                        var25 = (var26 - 100) * 5 + '\uff00';
                     }
                  }

                  if(Client.field1005[var18] == 10) {
                     var26 = 150 - Client.field1007[var18];
                     if(var26 < 50) {
                        var25 = var26 * 5 + 16711680;
                     } else if(var26 < 100) {
                        var25 = 16711935 - (var26 - 50) * 327680;
                     } else if(var26 < 150) {
                        var25 = (var26 - 100) * 327680 + 255 - (var26 - 100) * 5;
                     }
                  }

                  if(Client.field1005[var18] == 11) {
                     var26 = 150 - Client.field1007[var18];
                     if(var26 < 50) {
                        var25 = 16777215 - var26 * 327685;
                     } else if(var26 < 100) {
                        var25 = (var26 - 50) * 327685 + '\uff00';
                     } else if(var26 < 150) {
                        var25 = 16777215 - (var26 - 100) * 327680;
                     }
                  }

                  if(Client.field1006[var18] == 0) {
                     class64.field788.method4635(var33, var0 + Client.field1011, Client.field1049 + var1, var25, 0);
                  }

                  if(Client.field1006[var18] == 1) {
                     class64.field788.method4641(var33, var0 + Client.field1011, var1 + Client.field1049, var25, 0, Client.field1010);
                  }

                  if(Client.field1006[var18] == 2) {
                     class64.field788.method4638(var33, var0 + Client.field1011, var1 + Client.field1049, var25, 0, Client.field1010);
                  }

                  if(Client.field1006[var18] == 3) {
                     class64.field788.method4639(var33, var0 + Client.field1011, Client.field1049 + var1, var25, 0, Client.field1010, 150 - Client.field1007[var18]);
                  }

                  if(Client.field1006[var18] == 4) {
                     var26 = (150 - Client.field1007[var18]) * (class64.field788.method4696(var33) + 100) / 150;
                     Rasterizer2D.method4862(Client.field1011 + var0 - 50, var1, var0 + Client.field1011 + 50, var1 + var3);
                     class64.field788.method4647(var33, var0 + Client.field1011 + 50 - var26, var1 + Client.field1049, var25, 0);
                     Rasterizer2D.method4833(var0, var1, var2 + var0, var1 + var3);
                  }

                  if(Client.field1006[var18] == 5) {
                     var26 = 150 - Client.field1007[var18];
                     int var27 = 0;
                     if(var26 < 25) {
                        var27 = var26 - 25;
                     } else if(var26 > 125) {
                        var27 = var26 - 125;
                     }

                     Rasterizer2D.method4862(var0, var1 + Client.field1049 - class64.field788.field3643 - 1, var2 + var0, Client.field1049 + var1 + 5);
                     class64.field788.method4635(var33, var0 + Client.field1011, var27 + Client.field1049 + var1, var25, 0);
                     Rasterizer2D.method4833(var0, var1, var2 + var0, var1 + var3);
                  }
               } else {
                  class64.field788.method4635(var33, var0 + Client.field1011, var1 + Client.field1049, 16776960, 0);
               }
            }

            class17.method139(var0, var1);
            ((TextureProvider)class136.field2028).method2286(Client.field1125);
            class92.method1646(var0, var1, var2, var3);
            class14.cameraX = var29;
            class112.cameraZ = var7;
            class66.cameraY = var8;
            class203.cameraPitch = var9;
            class13.cameraYaw = var10;
            if(Client.field960) {
               byte var37 = 0;
               var15 = var37 + class238.field3267 + class238.field3269;
               if(var15 == 0) {
                  Client.field960 = false;
               }
            }

            if(Client.field960) {
               Rasterizer2D.method4826(var0, var1, var2, var3, 0);
               class158.method2877("Loading - please wait.", false);
            }

            return;
         }

         var30.vmethod55();
      }
   }
}
