import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public final class class105 implements KeyListener, FocusListener {
   @ObfuscatedName("pf")
   @ObfuscatedGetter(
      intValue = -1564488977
   )
   static int field1691;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -1157085211
   )
   static int field1694 = 0;
   @ObfuscatedName("ct")
   public static boolean[] field1695 = new boolean[112];
   @ObfuscatedName("cy")
   static int[] field1696 = new int[128];
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = -1364225793
   )
   static int field1697 = 0;
   @ObfuscatedName("ca")
   static int[] field1698 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("cn")
   static char[] field1699 = new char[128];
   @ObfuscatedName("cr")
   public static int[] field1700 = new int[128];
   @ObfuscatedName("d")
   @Export("keyboard")
   static class105 keyboard = new class105();
   @ObfuscatedName("ce")
   static int[] field1702 = new int[128];
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 1336859887
   )
   static int field1703 = 0;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -892155645
   )
   static int field1704 = 0;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 824728937
   )
   @Export("keyboardIdleTicks")
   static volatile int keyboardIdleTicks = 0;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 1714482781
   )
   public static int field1707 = 0;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 2111976535
   )
   static int field1711 = 0;

   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field1698.length) {
            var2 = field1698[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field1711 >= 0 && var2 >= 0) {
            field1696[field1711] = var2;
            field1711 = field1711 + 1 & 127;
            if(field1697 == field1711) {
               field1711 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field1704 + 1 & 127;
            if(var3 != field1703) {
               field1702[field1704] = var2;
               field1699[field1704] = 0;
               field1704 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field1698.length) {
            var2 = field1698[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field1711 >= 0 && var2 >= 0) {
            field1696[field1711] = ~var2;
            field1711 = field1711 + 1 & 127;
            if(field1711 == field1697) {
               field1711 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field1711 = -1;
      }

   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(Lclass25;B)V",
      garbageValue = "34"
   )
   static final void method2020(class25 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field572 == 0) {
         var1 = class172.region.method1747(var0.field579, var0.field573, var0.field574);
      }

      if(var0.field572 == 1) {
         var1 = class172.region.method1805(var0.field579, var0.field573, var0.field574);
      }

      if(var0.field572 == 2) {
         var1 = class172.region.method1818(var0.field579, var0.field573, var0.field574);
      }

      if(var0.field572 == 3) {
         var1 = class172.region.method1750(var0.field579, var0.field573, var0.field574);
      }

      if(var1 != 0) {
         int var5 = class172.region.method1751(var0.field579, var0.field573, var0.field574, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field575 = var2;
      var0.field576 = var3;
      var0.field585 = var4;
   }

   @ObfuscatedName("er")
   @ObfuscatedSignature(
      signature = "(LWidget;S)LWidget;",
      garbageValue = "-4508"
   )
   static Widget method2027(Widget var0) {
      int var2 = class103.method1988(var0);
      int var1 = var2 >> 17 & 7;
      int var3 = var1;
      if(var1 == 0) {
         return null;
      } else {
         for(int var4 = 0; var4 < var3; ++var4) {
            var0 = class128.method2364(var0.parentId);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "550190429"
   )
   static final void method2030(int var0, int var1, int var2, int var3) {
      ++Client.field309;
      Game.method3289(class15.field168);
      boolean var4 = false;
      int var5;
      int var7;
      if(Client.field472 >= 0) {
         var5 = class45.field891;
         int[] var6 = class45.field894;

         for(var7 = 0; var7 < var5; ++var7) {
            if(Client.field472 == var6[var7]) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         Game.method3289(class15.field165);
      }

      class108.method2060(true);
      Game.method3289(var4?class15.field167:class15.field166);
      class108.method2060(false);

      for(Projectile var20 = (Projectile)Client.projectiles.method2828(); var20 != null; var20 = (Projectile)Client.projectiles.method2830()) {
         if(var20.floor == Client.plane && Client.gameCycle <= var20.field854) {
            if(Client.gameCycle >= var20.startTime) {
               if(var20.interacting > 0) {
                  NPC var21 = Client.cachedNPCs[var20.interacting - 1];
                  if(var21 != null && var21.x >= 0 && var21.x < 13312 && var21.y >= 0 && var21.y < 13312) {
                     var20.method818(var21.x, var21.y, CombatInfo1.method600(var21.x, var21.y, var20.floor) - var20.field852, Client.gameCycle);
                  }
               }

               if(var20.interacting < 0) {
                  var7 = -var20.interacting - 1;
                  Player var22;
                  if(var7 == Client.localInteractingIndex) {
                     var22 = class22.localPlayer;
                  } else {
                     var22 = Client.cachedPlayers[var7];
                  }

                  if(var22 != null && var22.x >= 0 && var22.x < 13312 && var22.y >= 0 && var22.y < 13312) {
                     var20.method818(var22.x, var22.y, CombatInfo1.method600(var22.x, var22.y, var20.floor) - var20.field852, Client.gameCycle);
                  }
               }

               var20.method810(Client.field358);
               class172.region.method1732(Client.plane, (int)var20.x, (int)var20.velocityZ, (int)var20.z, 60, var20, var20.field867, -1, false);
            }
         } else {
            var20.unlink();
         }
      }

      class9.method109();
      class173.method3257(var0, var1, var2, var3, true);
      var0 = Client.field548;
      var1 = Client.field549;
      var2 = Client.camera2;
      var3 = Client.camera3;
      Rasterizer2D.method4083(var0, var1, var0 + var2, var1 + var3);
      class84.method1649();
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var19;
      if(!Client.field534) {
         var5 = Client.field366;
         if(Client.field375 / 256 > var5) {
            var5 = Client.field375 / 256;
         }

         if(Client.field535[4] && Client.field401[4] + 128 > var5) {
            var5 = Client.field401[4] + 128;
         }

         var19 = Client.mapAngle + Client.field425 & 2047;
         var7 = XItemContainer.field120;
         var8 = CombatInfo1.method600(class22.localPlayer.x, class22.localPlayer.y, Client.plane) - Client.field372;
         var9 = class8.field79;
         var10 = var5 * 3 + 600;
         var11 = 2048 - var5 & 2047;
         var12 = 2048 - var19 & 2047;
         var13 = 0;
         var14 = 0;
         var15 = var10;
         int var16;
         int var17;
         int var18;
         if(var11 != 0) {
            var16 = class84.field1433[var11];
            var17 = class84.field1441[var11];
            var18 = var17 * var14 - var10 * var16 >> 16;
            var15 = var14 * var16 + var17 * var10 >> 16;
            var14 = var18;
         }

         if(var12 != 0) {
            var16 = class84.field1433[var12];
            var17 = class84.field1441[var12];
            var18 = var16 * var15 + var13 * var17 >> 16;
            var15 = var17 * var15 - var16 * var13 >> 16;
            var13 = var18;
         }

         class22.cameraX = var7 - var13;
         class1.cameraZ = var8 - var14;
         class13.cameraY = var9 - var15;
         class108.cameraPitch = var5;
         class13.cameraYaw = var19;
      }

      if(!Client.field534) {
         if(Actor.field656.field690) {
            var19 = Client.plane;
         } else {
            label457: {
               var7 = 3;
               if(class108.cameraPitch < 310) {
                  var8 = class22.cameraX >> 7;
                  var9 = class13.cameraY >> 7;
                  var10 = class22.localPlayer.x >> 7;
                  var11 = class22.localPlayer.y >> 7;
                  if(var8 < 0 || var9 < 0 || var8 >= 104 || var9 >= 104) {
                     var19 = Client.plane;
                     break label457;
                  }

                  if((class10.tileSettings[Client.plane][var8][var9] & 4) != 0) {
                     var7 = Client.plane;
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

                        if((class10.tileSettings[Client.plane][var8][var9] & 4) != 0) {
                           var7 = Client.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var9 < var11) {
                              ++var9;
                           } else if(var9 > var11) {
                              --var9;
                           }

                           if((class10.tileSettings[Client.plane][var8][var9] & 4) != 0) {
                              var7 = Client.plane;
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

                        if((class10.tileSettings[Client.plane][var8][var9] & 4) != 0) {
                           var7 = Client.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var8 < var10) {
                              ++var8;
                           } else if(var8 > var10) {
                              --var8;
                           }

                           if((class10.tileSettings[Client.plane][var8][var9] & 4) != 0) {
                              var7 = Client.plane;
                           }
                        }
                     }
                  }
               }

               if(class22.localPlayer.x >= 0 && class22.localPlayer.y >= 0 && class22.localPlayer.x < 13312 && class22.localPlayer.y < 13312) {
                  if((class10.tileSettings[Client.plane][class22.localPlayer.x >> 7][class22.localPlayer.y >> 7] & 4) != 0) {
                     var7 = Client.plane;
                  }

                  var19 = var7;
               } else {
                  var19 = Client.plane;
               }
            }
         }

         var5 = var19;
      } else {
         if(Actor.field656.field690) {
            var19 = Client.plane;
         } else {
            var7 = CombatInfo1.method600(class22.cameraX, class13.cameraY, Client.plane);
            if(var7 - class1.cameraZ < 800 && (class10.tileSettings[Client.plane][class22.cameraX >> 7][class13.cameraY >> 7] & 4) != 0) {
               var19 = Client.plane;
            } else {
               var19 = 3;
            }
         }

         var5 = var19;
      }

      var19 = class22.cameraX;
      var7 = class1.cameraZ;
      var8 = class13.cameraY;
      var9 = class108.cameraPitch;
      var10 = class13.cameraYaw;

      for(var11 = 0; var11 < 5; ++var11) {
         if(Client.field535[var11]) {
            var12 = (int)(Math.random() * (double)(Client.field536[var11] * 2 + 1) - (double)Client.field536[var11] + Math.sin((double)Client.field545[var11] / 100.0D * (double)Client.field539[var11]) * (double)Client.field401[var11]);
            if(var11 == 0) {
               class22.cameraX += var12;
            }

            if(var11 == 1) {
               class1.cameraZ += var12;
            }

            if(var11 == 2) {
               class13.cameraY += var12;
            }

            if(var11 == 3) {
               class13.cameraYaw = class13.cameraYaw + var12 & 2047;
            }

            if(var11 == 4) {
               class108.cameraPitch += var12;
               if(class108.cameraPitch < 128) {
                  class108.cameraPitch = 128;
               }

               if(class108.cameraPitch > 383) {
                  class108.cameraPitch = 383;
               }
            }
         }
      }

      var11 = class115.field1805;
      var12 = class115.field1806;
      if(class115.field1811 != 0) {
         var11 = class115.field1802;
         var12 = class115.field1813;
      }

      if(var11 >= var0 && var11 < var2 + var0 && var12 >= var1 && var12 < var3 + var1) {
         Model.field1399 = true;
         Model.field1402 = 0;
         Model.field1354 = var11 - var0;
         Model.field1401 = var12 - var1;
      } else {
         Model.field1399 = false;
         Model.field1402 = 0;
      }

      GameEngine.method2201();
      Rasterizer2D.method4089(var0, var1, var2, var3, 0);
      GameEngine.method2201();
      var13 = class84.field1426;
      class84.field1426 = Client.scale;
      class172.region.method1784(class22.cameraX, class1.cameraZ, class13.cameraY, class108.cameraPitch, class13.cameraYaw, var5);
      class84.field1426 = var13;
      GameEngine.method2201();
      class172.region.method1735();
      XClanMember.method256(var0, var1, var2, var3);
      Preferences.method649(var0, var1);
      ((TextureProvider)class84.field1437).method1453(Client.field358);
      class190.method3463(var0, var1, var2, var3);
      class22.cameraX = var19;
      class1.cameraZ = var7;
      class13.cameraY = var8;
      class108.cameraPitch = var9;
      class13.cameraYaw = var10;
      if(Client.field289) {
         byte var23 = 0;
         var15 = var23 + class187.field2755 + class187.field2768;
         if(var15 == 0) {
            Client.field289 = false;
         }
      }

      if(Client.field289) {
         Rasterizer2D.method4089(var0, var1, var2, var3, 0);
         class38.method769("Loading - please wait.", false);
      }

   }

   @ObfuscatedName("en")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1107835411"
   )
   static final void method2036(String var0) {
      if(var0 != null) {
         if((Client.friendCount < 200 || Client.field406 == 1) && Client.friendCount < 400) {
            String var1 = class108.method2059(var0, NPC.field757);
            if(var1 != null) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < Client.friendCount; ++var2) {
                  Friend var3 = Client.friends[var2];
                  var4 = class108.method2059(var3.name, NPC.field757);
                  if(var4 != null && var4.equals(var1)) {
                     WidgetNode.sendGameMessage(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(var3.previousName != null) {
                     var5 = class108.method2059(var3.previousName, NPC.field757);
                     if(var5 != null && var5.equals(var1)) {
                        WidgetNode.sendGameMessage(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < Client.ignoreCount; ++var2) {
                  Ignore var6 = Client.ignores[var2];
                  var4 = class108.method2059(var6.name, NPC.field757);
                  if(var4 != null && var4.equals(var1)) {
                     WidgetNode.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(var6.previousName != null) {
                     var5 = class108.method2059(var6.previousName, NPC.field757);
                     if(var5 != null && var5.equals(var1)) {
                        WidgetNode.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class108.method2059(class22.localPlayer.name, NPC.field757).equals(var1)) {
                  WidgetNode.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  Client.secretCipherBuffer1.putOpcode(209);
                  Client.secretCipherBuffer1.putByte(class36.method753(var0));
                  Client.secretCipherBuffer1.method2504(var0);
               }
            }
         } else {
            WidgetNode.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Lclass200;",
      garbageValue = "497882505"
   )
   public static class200 method2038(int var0) {
      class200 var1 = (class200)class200.field2892.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = CombatInfoListHolder.field753.getConfigData(8, var0);
         var1 = new class200();
         if(var2 != null) {
            var1.method3624(new Buffer(var2));
         }

         class200.field2892.put(var1, (long)var0);
         return var1;
      }
   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff') {
            boolean var3;
            if(var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
               var3 = true;
            } else {
               label71: {
                  if(var2 != 0) {
                     char[] var7 = class210.field3134;

                     for(int var5 = 0; var5 < var7.length; ++var5) {
                        char var6 = var7[var5];
                        if(var6 == var2) {
                           var3 = true;
                           break label71;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var4 = field1704 + 1 & 127;
               if(var4 != field1703) {
                  field1702[field1704] = -1;
                  field1699[field1704] = var2;
                  field1704 = var4;
               }
            }
         }
      }

      var1.consume();
   }
}
