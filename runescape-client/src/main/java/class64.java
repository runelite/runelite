import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
public class class64 {
   @ObfuscatedName("gi")
   static SpritePixels[] field799;

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "0"
   )
   static final void method1082(int var0, int var1, int var2, int var3) {
      ++Client.field1010;
      class29.method238(class66.field809);
      boolean var4 = false;
      int var5;
      int var7;
      if(Client.field925 >= 0) {
         var5 = class96.field1499;
         int[] var6 = class96.field1492;

         for(var7 = 0; var7 < var5; ++var7) {
            if(var6[var7] == Client.field925) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         class29.method238(class66.field808);
      }

      class112.method2073(true);
      class29.method238(var4?class66.field811:class66.field810);
      class112.method2073(false);
      Timer.method2979();

      for(GraphicsObject var28 = (GraphicsObject)Client.graphicsObjectDeque.getFront(); var28 != null; var28 = (GraphicsObject)Client.graphicsObjectDeque.getNext()) {
         if(var28.level == class45.plane && !var28.finished) {
            if(Client.gameCycle >= var28.startCycle) {
               var28.method1645(Client.field982);
               if(var28.finished) {
                  var28.unlink();
               } else {
                  class29.region.method2677(var28.level, var28.x, var28.y, var28.height, 60, var28, 0, -1, false);
               }
            }
         } else {
            var28.unlink();
         }
      }

      class25.method175(var0, var1, var2, var3, true);
      var0 = Client.field1166;
      var1 = Client.field1143;
      var2 = Client.viewportHeight;
      var3 = Client.viewportWidth;
      Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
      Graphics3D.method2594();
      int var29;
      if(!Client.field1152) {
         var5 = Client.field989;
         if(Client.field998 / 256 > var5) {
            var5 = Client.field998 / 256;
         }

         if(Client.field1153[4] && Client.field1155[4] + 128 > var5) {
            var5 = Client.field1155[4] + 128;
         }

         var29 = Client.field969 + Client.mapAngle & 2047;
         class182.method3428(class54.field659, Actor.getTileHeight(Script.localPlayer.x, Script.localPlayer.y, class45.plane) - Client.field995, class48.field605, var5, var29, var5 * 3 + 600);
      }

      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      if(!Client.field1152) {
         if(class23.preferences.hideRoofs) {
            var29 = class45.plane;
         } else {
            label600: {
               var7 = 3;
               if(class8.cameraPitch < 310) {
                  var8 = class41.cameraX >> 7;
                  var9 = class7.cameraY >> 7;
                  var10 = Script.localPlayer.x >> 7;
                  var11 = Script.localPlayer.y >> 7;
                  if(var8 < 0 || var9 < 0 || var8 >= 104 || var9 >= 104) {
                     var29 = class45.plane;
                     break label600;
                  }

                  if((class61.tileSettings[class45.plane][var8][var9] & 4) != 0) {
                     var7 = class45.plane;
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

                        if((class61.tileSettings[class45.plane][var8][var9] & 4) != 0) {
                           var7 = class45.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var9 < var11) {
                              ++var9;
                           } else if(var9 > var11) {
                              --var9;
                           }

                           if((class61.tileSettings[class45.plane][var8][var9] & 4) != 0) {
                              var7 = class45.plane;
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

                        if((class61.tileSettings[class45.plane][var8][var9] & 4) != 0) {
                           var7 = class45.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var8 < var10) {
                              ++var8;
                           } else if(var8 > var10) {
                              --var8;
                           }

                           if((class61.tileSettings[class45.plane][var8][var9] & 4) != 0) {
                              var7 = class45.plane;
                           }
                        }
                     }
                  }
               }

               if(Script.localPlayer.x >= 0 && Script.localPlayer.y >= 0 && Script.localPlayer.x < 13312 && Script.localPlayer.y < 13312) {
                  if((class61.tileSettings[class45.plane][Script.localPlayer.x >> 7][Script.localPlayer.y >> 7] & 4) != 0) {
                     var7 = class45.plane;
                  }

                  var29 = var7;
               } else {
                  var29 = class45.plane;
               }
            }
         }

         var5 = var29;
      } else {
         var5 = WorldMapType2.method535();
      }

      var29 = class41.cameraX;
      var7 = XItemContainer.cameraZ;
      var8 = class7.cameraY;
      var9 = class8.cameraPitch;
      var10 = Friend.cameraYaw;

      for(var11 = 0; var11 < 5; ++var11) {
         if(Client.field1153[var11]) {
            var12 = (int)(Math.random() * (double)(Client.field1154[var11] * 2 + 1) - (double)Client.field1154[var11] + Math.sin((double)Client.field1156[var11] / 100.0D * (double)Client.field1157[var11]) * (double)Client.field1155[var11]);
            if(var11 == 0) {
               class41.cameraX += var12;
            }

            if(var11 == 1) {
               XItemContainer.cameraZ += var12;
            }

            if(var11 == 2) {
               class7.cameraY += var12;
            }

            if(var11 == 3) {
               Friend.cameraYaw = var12 + Friend.cameraYaw & 2047;
            }

            if(var11 == 4) {
               class8.cameraPitch += var12;
               if(class8.cameraPitch < 128) {
                  class8.cameraPitch = 128;
               }

               if(class8.cameraPitch > 383) {
                  class8.cameraPitch = 383;
               }
            }
         }
      }

      var11 = MouseInput.field722;
      var12 = MouseInput.field723;
      if(MouseInput.field728 != 0) {
         var11 = MouseInput.field735;
         var12 = MouseInput.field730;
      }

      if(var11 >= var0 && var11 < var0 + var2 && var12 >= var1 && var12 < var3 + var1) {
         class155.method2961(var11 - var0, var12 - var1);
      } else {
         GameEngine.method972();
      }

      class46.method712();
      Rasterizer2D.method4921(var0, var1, var2, var3, 0);
      class46.method712();
      var13 = Graphics3D.field2026;
      Graphics3D.field2026 = Client.scale;
      class29.region.draw(class41.cameraX, XItemContainer.cameraZ, class7.cameraY, class8.cameraPitch, Friend.cameraYaw, var5);
      class1.method2();
      Graphics3D.field2026 = var13;
      class46.method712();
      class29.region.clearEntities();
      Client.field999 = 0;
      boolean var32 = false;
      var15 = -1;
      int var16 = class96.field1499;
      int[] var17 = class96.field1492;

      int var18;
      for(var18 = 0; var18 < var16 + Client.field944; ++var18) {
         Object var19;
         if(var18 < var16) {
            var19 = Client.cachedPlayers[var17[var18]];
            if(var17[var18] == Client.field925) {
               var32 = true;
               var15 = var18;
               continue;
            }
         } else {
            var19 = Client.cachedNPCs[Client.npcIndices[var18 - var16]];
         }

         RSCanvas.method791((Actor)var19, var18, var0, var1, var2, var3);
      }

      if(var32) {
         RSCanvas.method791(Client.cachedPlayers[Client.field925], var15, var0, var1, var2, var3);
      }

      for(var18 = 0; var18 < Client.field999; ++var18) {
         int var30 = Client.field1186[var18];
         int var20 = Client.field1002[var18];
         int var21 = Client.field1004[var18];
         int var22 = Client.field1003[var18];
         boolean var23 = true;

         while(var23) {
            var23 = false;

            for(int var24 = 0; var24 < var18; ++var24) {
               if(var20 + 2 > Client.field1002[var24] - Client.field1003[var24] && var20 - var22 < Client.field1002[var24] + 2 && var30 - var21 < Client.field1186[var24] + Client.field1004[var24] && var30 + var21 > Client.field1186[var24] - Client.field1004[var24] && Client.field1002[var24] - Client.field1003[var24] < var20) {
                  var20 = Client.field1002[var24] - Client.field1003[var24];
                  var23 = true;
               }
            }
         }

         Client.screenY = Client.field1186[var18];
         Client.screenX = Client.field1002[var18] = var20;
         String var31 = Client.field1008[var18];
         if(Client.field1068 == 0) {
            int var25 = 16776960;
            if(Client.field1005[var18] < 6) {
               var25 = Client.field1024[Client.field1005[var18]];
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
               var26 = 150 - Client.field1167[var18];
               if(var26 < 50) {
                  var25 = var26 * 1280 + 16711680;
               } else if(var26 < 100) {
                  var25 = 16776960 - (var26 - 50) * 327680;
               } else if(var26 < 150) {
                  var25 = (var26 - 100) * 5 + '\uff00';
               }
            }

            if(Client.field1005[var18] == 10) {
               var26 = 150 - Client.field1167[var18];
               if(var26 < 50) {
                  var25 = var26 * 5 + 16711680;
               } else if(var26 < 100) {
                  var25 = 16711935 - (var26 - 50) * 327680;
               } else if(var26 < 150) {
                  var25 = (var26 - 100) * 327680 + 255 - (var26 - 100) * 5;
               }
            }

            if(Client.field1005[var18] == 11) {
               var26 = 150 - Client.field1167[var18];
               if(var26 < 50) {
                  var25 = 16777215 - var26 * 327685;
               } else if(var26 < 100) {
                  var25 = (var26 - 50) * 327685 + '\uff00';
               } else if(var26 < 150) {
                  var25 = 16777215 - (var26 - 100) * 327680;
               }
            }

            if(Client.field1163[var18] == 0) {
               class21.field338.method4734(var31, var0 + Client.screenY, Client.screenX + var1, var25, 0);
            }

            if(Client.field1163[var18] == 1) {
               class21.field338.method4724(var31, var0 + Client.screenY, Client.screenX + var1, var25, 0, Client.field1010);
            }

            if(Client.field1163[var18] == 2) {
               class21.field338.method4729(var31, var0 + Client.screenY, Client.screenX + var1, var25, 0, Client.field1010);
            }

            if(Client.field1163[var18] == 3) {
               class21.field338.method4737(var31, var0 + Client.screenY, Client.screenX + var1, var25, 0, Client.field1010, 150 - Client.field1167[var18]);
            }

            if(Client.field1163[var18] == 4) {
               var26 = (150 - Client.field1167[var18]) * (class21.field338.method4721(var31) + 100) / 150;
               Rasterizer2D.setInnerDrawRegion(var0 + Client.screenY - 50, var1, var0 + Client.screenY + 50, var3 + var1);
               class21.field338.method4725(var31, var0 + Client.screenY + 50 - var26, Client.screenX + var1, var25, 0);
               Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
            }

            if(Client.field1163[var18] == 5) {
               var26 = 150 - Client.field1167[var18];
               int var27 = 0;
               if(var26 < 25) {
                  var27 = var26 - 25;
               } else if(var26 > 125) {
                  var27 = var26 - 125;
               }

               Rasterizer2D.setInnerDrawRegion(var0, Client.screenX + var1 - class21.field338.verticalSpace - 1, var0 + var2, Client.screenX + var1 + 5);
               class21.field338.method4734(var31, var0 + Client.screenY, var27 + Client.screenX + var1, var25, 0);
               Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            class21.field338.method4734(var31, var0 + Client.screenY, Client.screenX + var1, 16776960, 0);
         }
      }

      class13.method77(var0, var1);
      ((TextureProvider)Graphics3D.textureLoader).method2369(Client.field982);
      if(Client.cursorState == 1) {
         CombatInfoListHolder.field1359[Client.field1015 / 100].method5032(Client.field1013 - 8, Client.field1071 - 8);
      }

      if(Client.cursorState == 2) {
         CombatInfoListHolder.field1359[Client.field1015 / 100 + 4].method5032(Client.field1013 - 8, Client.field1071 - 8);
      }

      Client.field1025 = 0;
      var14 = (Script.localPlayer.x >> 7) + class163.baseX;
      var15 = (Script.localPlayer.y >> 7) + class10.baseY;
      if(var14 >= 3053 && var14 <= 3156 && var15 >= 3056 && var15 <= 3136) {
         Client.field1025 = 1;
      }

      if(var14 >= 3072 && var14 <= 3118 && var15 >= 9492 && var15 <= 9535) {
         Client.field1025 = 1;
      }

      if(Client.field1025 == 1 && var14 >= 3139 && var14 <= 3199 && var15 >= 3008 && var15 <= 3062) {
         Client.field1025 = 0;
      }

      class41.cameraX = var29;
      XItemContainer.cameraZ = var7;
      class7.cameraY = var8;
      class8.cameraPitch = var9;
      Friend.cameraYaw = var10;
      if(Client.field987 && class47.method717(true, false) == 0) {
         Client.field987 = false;
      }

      if(Client.field987) {
         Rasterizer2D.method4921(var0, var1, var2, var3, 0);
         class89.drawStatusBox("Loading - please wait.", false);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "15053"
   )
   public static boolean method1081(int var0) {
      return (var0 >> 20 & 1) != 0;
   }
}
