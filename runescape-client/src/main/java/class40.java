import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class40 implements class158 {
   @ObfuscatedName("a")
   static final class40 field798 = new class40(3);
   @ObfuscatedName("u")
   static final class40 field799 = new class40(0);
   @ObfuscatedName("i")
   static final class40 field800 = new class40(2);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -748089019
   )
   final int field801;
   @ObfuscatedName("x")
   static final class40 field802 = new class40(1);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int vmethod4062() {
      return this.field801;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)Ljava/lang/String;",
      garbageValue = "-125"
   )
   public static String method738(Buffer var0) {
      String var1;
      try {
         int var2 = var0.method2963();
         if(var2 > 32767) {
            var2 = 32767;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class210.field3106.method2706(var0.payload, var0.offset, var3, 0, var2);
         String var4 = class183.method3346(var3, 0, var2);
         var1 = var4;
      } catch (Exception var5) {
         var1 = "Cabbage";
      }

      return var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1215531311"
   )
   public static void method740(Component var0) {
      var0.removeMouseListener(class115.mouse);
      var0.removeMouseMotionListener(class115.mouse);
      var0.removeFocusListener(class115.mouse);
      class115.field1784 = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "77"
   )
   static final void method741() {
      if(null != class13.field150) {
         class13.field150.method1019();
      }

      if(null != Client.field522) {
         Client.field522.method1019();
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1399139386"
   )
   static final void method742(int var0, int var1, int var2, int var3) {
      ++Client.field387;
      class6.method83(class15.field172);
      boolean var4 = false;
      int var5;
      int var6;
      if(Client.field412 >= 0) {
         var6 = class45.field888;
         int[] var7 = class45.field892;

         for(var5 = 0; var5 < var6; ++var5) {
            if(var7[var5] == Client.field412) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         class6.method83(class15.field167);
      }

      Friend.method174(true);
      class6.method83(var4?class15.field168:class15.field165);
      Friend.method174(false);

      for(Projectile var16 = (Projectile)Client.projectiles.method2391(); null != var16; var16 = (Projectile)Client.projectiles.method2393()) {
         if(class60.plane == var16.floor && Client.gameCycle <= var16.field854) {
            if(Client.gameCycle >= var16.startTime) {
               if(var16.interacting > 0) {
                  NPC var8 = Client.cachedNPCs[var16.interacting - 1];
                  if(null != var8 && var8.x >= 0 && var8.x < 13312 && var8.y >= 0 && var8.y < 13312) {
                     var16.method775(var8.x, var8.y, class176.method3243(var8.x, var8.y, var16.floor) - var16.field876, Client.gameCycle);
                  }
               }

               if(var16.interacting < 0) {
                  var5 = -var16.interacting - 1;
                  Player var18;
                  if(var5 == Client.localInteractingIndex) {
                     var18 = class148.localPlayer;
                  } else {
                     var18 = Client.cachedPlayers[var5];
                  }

                  if(var18 != null && var18.x >= 0 && var18.x < 13312 && var18.y >= 0 && var18.y < 13312) {
                     var16.method775(var18.x, var18.y, class176.method3243(var18.x, var18.y, var16.floor) - var16.field876, Client.gameCycle);
                  }
               }

               var16.method776(Client.field462);
               class6.region.method1686(class60.plane, (int)var16.x, (int)var16.velocityZ, (int)var16.z, 60, var16, var16.field867, -1, false);
            }
         } else {
            var16.unlink();
         }
      }

      NPC.method727();
      ItemComposition.method3697(var0, var1, var2, var3, true);
      var0 = Client.field420;
      var1 = Client.field518;
      var2 = Client.camera2;
      var3 = Client.camera3;
      class219.method3965(var0, var1, var2 + var0, var1 + var3);
      class84.method1614();
      int var17;
      if(!Client.field529) {
         var6 = Client.field520;
         if(Client.field406 / 256 > var6) {
            var6 = Client.field406 / 256;
         }

         if(Client.field493[4] && 128 + Client.field532[4] > var6) {
            var6 = 128 + Client.field532[4];
         }

         var17 = Client.field351 + Client.mapAngle & 2047;
         ItemComposition.method3686(class22.field236, class176.method3243(class148.localPlayer.x, class148.localPlayer.y, class60.plane) - Client.field372, class152.field2068, var6, var17, 600 + 3 * var6);
      }

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var19;
      if(!Client.field529) {
         if(class2.field21.field690) {
            var17 = class60.plane;
         } else {
            label294: {
               var5 = 3;
               if(class165.cameraPitch < 310) {
                  var19 = class36.cameraX >> 7;
                  var9 = GroundObject.cameraY >> 7;
                  var10 = class148.localPlayer.x >> 7;
                  var11 = class148.localPlayer.y >> 7;
                  if(var19 < 0 || var9 < 0 || var19 >= 104 || var9 >= 104) {
                     var17 = class60.plane;
                     break label294;
                  }

                  if((class10.tileSettings[class60.plane][var19][var9] & 4) != 0) {
                     var5 = class60.plane;
                  }

                  if(var10 > var19) {
                     var12 = var10 - var19;
                  } else {
                     var12 = var19 - var10;
                  }

                  if(var11 > var9) {
                     var13 = var11 - var9;
                  } else {
                     var13 = var9 - var11;
                  }

                  int var14;
                  int var15;
                  if(var12 > var13) {
                     var14 = 65536 * var13 / var12;
                     var15 = '耀';

                     while(var19 != var10) {
                        if(var19 < var10) {
                           ++var19;
                        } else if(var19 > var10) {
                           --var19;
                        }

                        if((class10.tileSettings[class60.plane][var19][var9] & 4) != 0) {
                           var5 = class60.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var9 < var11) {
                              ++var9;
                           } else if(var9 > var11) {
                              --var9;
                           }

                           if((class10.tileSettings[class60.plane][var19][var9] & 4) != 0) {
                              var5 = class60.plane;
                           }
                        }
                     }
                  } else {
                     var14 = 65536 * var12 / var13;
                     var15 = '耀';

                     while(var11 != var9) {
                        if(var9 < var11) {
                           ++var9;
                        } else if(var9 > var11) {
                           --var9;
                        }

                        if((class10.tileSettings[class60.plane][var19][var9] & 4) != 0) {
                           var5 = class60.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var19 < var10) {
                              ++var19;
                           } else if(var19 > var10) {
                              --var19;
                           }

                           if((class10.tileSettings[class60.plane][var19][var9] & 4) != 0) {
                              var5 = class60.plane;
                           }
                        }
                     }
                  }
               }

               if(class148.localPlayer.x >= 0 && class148.localPlayer.y >= 0 && class148.localPlayer.x < 13312 && class148.localPlayer.y < 13312) {
                  if((class10.tileSettings[class60.plane][class148.localPlayer.x >> 7][class148.localPlayer.y >> 7] & 4) != 0) {
                     var5 = class60.plane;
                  }

                  var17 = var5;
               } else {
                  var17 = class60.plane;
               }
            }
         }

         var6 = var17;
      } else {
         var6 = class10.method119();
      }

      var17 = class36.cameraX;
      var5 = class36.cameraZ;
      var19 = GroundObject.cameraY;
      var9 = class165.cameraPitch;
      var10 = XClanMember.cameraYaw;

      for(var11 = 0; var11 < 5; ++var11) {
         if(Client.field493[var11]) {
            var12 = (int)(Math.random() * (double)(2 * Client.field368[var11] + 1) - (double)Client.field368[var11] + Math.sin((double)Client.field315[var11] / 100.0D * (double)Client.field510[var11]) * (double)Client.field532[var11]);
            if(var11 == 0) {
               class36.cameraX += var12;
            }

            if(var11 == 1) {
               class36.cameraZ += var12;
            }

            if(var11 == 2) {
               GroundObject.cameraY += var12;
            }

            if(var11 == 3) {
               XClanMember.cameraYaw = XClanMember.cameraYaw + var12 & 2047;
            }

            if(var11 == 4) {
               class165.cameraPitch += var12;
               if(class165.cameraPitch < 128) {
                  class165.cameraPitch = 128;
               }

               if(class165.cameraPitch > 383) {
                  class165.cameraPitch = 383;
               }
            }
         }
      }

      var11 = class115.field1788;
      var12 = class115.field1789;
      if(class115.field1794 != 0) {
         var11 = class115.field1791;
         var12 = class115.field1796;
      }

      if(var11 >= var0 && var11 < var0 + var2 && var12 >= var1 && var12 < var1 + var3) {
         Model.field1410 = true;
         Model.field1413 = 0;
         Model.field1411 = var11 - var0;
         Model.field1412 = var12 - var1;
      } else {
         Model.field1410 = false;
         Model.field1413 = 0;
      }

      method741();
      class219.method3993(var0, var1, var2, var3, 0);
      method741();
      var13 = class84.field1437;
      class84.field1437 = Client.scale;
      class6.region.method1708(class36.cameraX, class36.cameraZ, GroundObject.cameraY, class165.cameraPitch, XClanMember.cameraYaw, var6);
      class84.field1437 = var13;
      method741();
      class6.region.method1684();
      class2.method28(var0, var1, var2, var3);
      class26.method596(var0, var1);
      ((TextureProvider)class84.field1434).method1402(Client.field462);
      class26.method599(var0, var1, var2, var3);
      class36.cameraX = var17;
      class36.cameraZ = var5;
      GroundObject.cameraY = var19;
      class165.cameraPitch = var9;
      XClanMember.cameraYaw = var10;
      if(Client.field301 && NPC.method728(true, false) == 0) {
         Client.field301 = false;
      }

      if(Client.field301) {
         class219.method3993(var0, var1, var2, var3, 0);
         VertexNormal.method1599("Loading - please wait.", false);
      }

   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class40(int var1) {
      this.field801 = var1;
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-1632096945"
   )
   static final void method743(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class94.method1870(var0)) {
         class11.field122 = null;
         class13.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(null != class11.field122) {
            class13.gameDraw(class11.field122, -1412584499, var1, var2, var3, var4, class107.field1721, Friend.field163, var7);
            class11.field122 = null;
         }
      } else if(var7 != -1) {
         Client.field485[var7] = true;
      } else {
         for(int var8 = 0; var8 < 100; ++var8) {
            Client.field485[var8] = true;
         }
      }

   }
}
