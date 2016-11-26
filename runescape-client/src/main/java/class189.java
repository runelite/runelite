import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
public class class189 extends CacheableNode {
   @ObfuscatedName("m")
   public boolean field2786 = false;
   @ObfuscatedName("d")
   public static NodeCache field2787 = new NodeCache(64);
   @ObfuscatedName("bo")
   static class184 field2788;
   @ObfuscatedName("n")
   public static class182 field2789;
   @ObfuscatedName("bj")
   static class184 field2791;
   @ObfuscatedName("ep")
   static ModIcon[] field2793;

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-284154922"
   )
   static final void method3497(int var0, int var1, int var2, int var3) {
      ++Client.field548;
      World.method671(class15.field158);
      boolean var4 = false;
      int var5;
      int var7;
      if(Client.field525 >= 0) {
         var5 = class45.field897;
         int[] var6 = class45.field902;

         for(var7 = 0; var7 < var5; ++var7) {
            if(var6[var7] == Client.field525) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         World.method671(class15.field154);
      }

      class1.method15(true);
      World.method671(var4?class15.field155:class15.field152);
      class1.method15(false);

      for(Projectile var28 = (Projectile)Client.projectiles.method2466(); null != var28; var28 = (Projectile)Client.projectiles.method2461()) {
         if(class166.plane == var28.floor && Client.gameCycle <= var28.field860) {
            if(Client.gameCycle >= var28.startTime) {
               if(var28.interacting > 0) {
                  NPC var32 = Client.cachedNPCs[var28.interacting - 1];
                  if(null != var32 && var32.x >= 0 && var32.x < 13312 && var32.y >= 0 && var32.y < 13312) {
                     var28.method808(var32.x, var32.y, class11.method161(var32.x, var32.y, var28.floor) - var28.field858, Client.gameCycle);
                  }
               }

               if(var28.interacting < 0) {
                  var7 = -var28.interacting - 1;
                  Player var33;
                  if(Client.localInteractingIndex == var7) {
                     var33 = class40.localPlayer;
                  } else {
                     var33 = Client.cachedPlayers[var7];
                  }

                  if(var33 != null && var33.x >= 0 && var33.x < 13312 && var33.y >= 0 && var33.y < 13312) {
                     var28.method808(var33.x, var33.y, class11.method161(var33.x, var33.y, var28.floor) - var28.field858, Client.gameCycle);
                  }
               }

               var28.method809(Client.field517);
               class157.region.method1751(class166.plane, (int)var28.x, (int)var28.velocityZ, (int)var28.z, 60, var28, var28.field874, -1, false);
            }
         } else {
            var28.unlink();
         }
      }

      class36.method751();
      WidgetNode.method201(var0, var1, var2, var3, true);
      var0 = Client.field547;
      var1 = Client.field523;
      var2 = Client.camera2;
      var3 = Client.camera3;
      class219.method4041(var0, var1, var0 + var2, var1 + var3);
      class84.method1666();
      int var29;
      if(!Client.field533) {
         var5 = Client.field534;
         if(Client.field380 / 256 > var5) {
            var5 = Client.field380 / 256;
         }

         if(Client.field429[4] && 128 + Client.field536[4] > var5) {
            var5 = Client.field536[4] + 128;
         }

         var29 = Client.field355 + Client.mapAngle & 2047;
         class227.method4318(class47.field926, class11.method161(class40.localPlayer.x, class40.localPlayer.y, class166.plane) - Client.field377, MessageNode.field223, var5, var29, 600 + 3 * var5);
      }

      if(!Client.field533) {
         var5 = class2.method31();
      } else {
         var5 = class26.method609();
      }

      var29 = XGrandExchangeOffer.cameraX;
      var7 = Client.cameraZ;
      int var8 = Client.cameraY;
      int var9 = class40.cameraPitch;
      int var10 = class104.cameraYaw;

      int var11;
      int var12;
      for(var11 = 0; var11 < 5; ++var11) {
         if(Client.field429[var11]) {
            var12 = (int)(Math.random() * (double)(Client.field535[var11] * 2 + 1) - (double)Client.field535[var11] + Math.sin((double)Client.field537[var11] / 100.0D * (double)Client.field471[var11]) * (double)Client.field536[var11]);
            if(var11 == 0) {
               XGrandExchangeOffer.cameraX += var12;
            }

            if(var11 == 1) {
               Client.cameraZ += var12;
            }

            if(var11 == 2) {
               Client.cameraY += var12;
            }

            if(var11 == 3) {
               class104.cameraYaw = var12 + class104.cameraYaw & 2047;
            }

            if(var11 == 4) {
               class40.cameraPitch += var12;
               if(class40.cameraPitch < 128) {
                  class40.cameraPitch = 128;
               }

               if(class40.cameraPitch > 383) {
                  class40.cameraPitch = 383;
               }
            }
         }
      }

      var11 = class115.field1811;
      var12 = class115.field1810;
      if(class115.field1808 != 0) {
         var11 = class115.field1809;
         var12 = class115.field1806;
      }

      if(var11 >= var0 && var11 < var2 + var0 && var12 >= var1 && var12 < var3 + var1) {
         Model.field1348 = true;
         Model.field1407 = 0;
         Model.field1413 = var11 - var0;
         Model.field1404 = var12 - var1;
      } else {
         Model.field1348 = false;
         Model.field1407 = 0;
      }

      class13.method185();
      class219.method4071(var0, var1, var2, var3, 0);
      class13.method185();
      int var13 = class84.field1430;
      class84.field1430 = Client.scale;
      class157.region.method1778(XGrandExchangeOffer.cameraX, Client.cameraZ, Client.cameraY, class40.cameraPitch, class104.cameraYaw, var5);
      class84.field1430 = var13;
      class13.method185();
      class157.region.method1754();
      Client.field381 = 0;
      boolean var14 = false;
      int var15 = -1;
      int var16 = class45.field897;
      int[] var17 = class45.field902;

      int var18;
      for(var18 = 0; var18 < var16 + Client.field326; ++var18) {
         Object var19;
         if(var18 < var16) {
            var19 = Client.cachedPlayers[var17[var18]];
            if(var17[var18] == Client.field525) {
               var14 = true;
               var15 = var18;
               continue;
            }
         } else {
            var19 = Client.cachedNPCs[Client.field559[var18 - var16]];
         }

         class5.method78((Actor)var19, var18, var0, var1, var2, var3);
      }

      if(var14) {
         class5.method78(Client.cachedPlayers[Client.field525], var15, var0, var1, var2, var3);
      }

      for(var18 = 0; var18 < Client.field381; ++var18) {
         int var31 = Client.field530[var18];
         int var20 = Client.field384[var18];
         int var21 = Client.field386[var18];
         int var22 = Client.field385[var18];
         boolean var23 = true;

         while(var23) {
            var23 = false;

            for(int var30 = 0; var30 < var18; ++var30) {
               if(var20 + 2 > Client.field384[var30] - Client.field385[var30] && var20 - var22 < 2 + Client.field384[var30] && var31 - var21 < Client.field530[var30] + Client.field386[var30] && var31 + var21 > Client.field530[var30] - Client.field386[var30] && Client.field384[var30] - Client.field385[var30] < var20) {
                  var20 = Client.field384[var30] - Client.field385[var30];
                  var23 = true;
               }
            }
         }

         Client.field347 = Client.field530[var18];
         Client.field394 = Client.field384[var18] = var20;
         String var24 = Client.field307[var18];
         if(Client.field373 == 0) {
            int var25 = 16776960;
            if(Client.field387[var18] < 6) {
               var25 = Client.field321[Client.field387[var18]];
            }

            if(Client.field387[var18] == 6) {
               var25 = Client.field548 % 20 < 10?16711680:16776960;
            }

            if(Client.field387[var18] == 7) {
               var25 = Client.field548 % 20 < 10?255:'\uffff';
            }

            if(Client.field387[var18] == 8) {
               var25 = Client.field548 % 20 < 10?'뀀':8454016;
            }

            int var26;
            if(Client.field387[var18] == 9) {
               var26 = 150 - Client.field389[var18];
               if(var26 < 50) {
                  var25 = var26 * 1280 + 16711680;
               } else if(var26 < 100) {
                  var25 = 16776960 - (var26 - 50) * 327680;
               } else if(var26 < 150) {
                  var25 = '\uff00' + (var26 - 100) * 5;
               }
            }

            if(Client.field387[var18] == 10) {
               var26 = 150 - Client.field389[var18];
               if(var26 < 50) {
                  var25 = 16711680 + var26 * 5;
               } else if(var26 < 100) {
                  var25 = 16711935 - (var26 - 50) * 327680;
               } else if(var26 < 150) {
                  var25 = 255 + (var26 - 100) * 327680 - 5 * (var26 - 100);
               }
            }

            if(Client.field387[var18] == 11) {
               var26 = 150 - Client.field389[var18];
               if(var26 < 50) {
                  var25 = 16777215 - var26 * 327685;
               } else if(var26 < 100) {
                  var25 = '\uff00' + 327685 * (var26 - 50);
               } else if(var26 < 150) {
                  var25 = 16777215 - (var26 - 100) * 327680;
               }
            }

            if(Client.field293[var18] == 0) {
               class156.field2236.method3907(var24, var0 + Client.field347, var1 + Client.field394, var25, 0);
            }

            if(Client.field293[var18] == 1) {
               class156.field2236.method3922(var24, var0 + Client.field347, var1 + Client.field394, var25, 0, Client.field548);
            }

            if(Client.field293[var18] == 2) {
               class156.field2236.method3923(var24, var0 + Client.field347, Client.field394 + var1, var25, 0, Client.field548);
            }

            if(Client.field293[var18] == 3) {
               class156.field2236.method3924(var24, Client.field347 + var0, var1 + Client.field394, var25, 0, Client.field548, 150 - Client.field389[var18]);
            }

            if(Client.field293[var18] == 4) {
               var26 = (150 - Client.field389[var18]) * (class156.field2236.method3912(var24) + 100) / 150;
               class219.method4068(Client.field347 + var0 - 50, var1, var0 + Client.field347 + 50, var3 + var1);
               class156.field2236.method3920(var24, 50 + Client.field347 + var0 - var26, Client.field394 + var1, var25, 0);
               class219.method4041(var0, var1, var2 + var0, var1 + var3);
            }

            if(Client.field293[var18] == 5) {
               var26 = 150 - Client.field389[var18];
               int var27 = 0;
               if(var26 < 25) {
                  var27 = var26 - 25;
               } else if(var26 > 125) {
                  var27 = var26 - 125;
               }

               class219.method4068(var0, var1 + Client.field394 - class156.field2236.field3091 - 1, var2 + var0, 5 + Client.field394 + var1);
               class156.field2236.method3907(var24, Client.field347 + var0, var27 + Client.field394 + var1, var25, 0);
               class219.method4041(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            class156.field2236.method3907(var24, Client.field347 + var0, var1 + Client.field394, 16776960, 0);
         }
      }

      class22.method226(var0, var1);
      ((TextureProvider)class84.field1441).method1482(Client.field517);
      XClanMember.method262(var0, var1, var2, var3);
      XGrandExchangeOffer.cameraX = var29;
      Client.cameraZ = var7;
      Client.cameraY = var8;
      class40.cameraPitch = var9;
      class104.cameraYaw = var10;
      if(Client.field280) {
         byte var34 = 0;
         var15 = var34 + class185.field2749 + class185.field2745;
         if(var15 == 0) {
            Client.field280 = false;
         }
      }

      if(Client.field280) {
         class219.method4071(var0, var1, var2, var3, 0);
         World.method669("Loading - please wait.", false);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-26"
   )
   void method3498(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2786 = true;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-1825262453"
   )
   public static int method3500(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class196.method3649(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1826107363"
   )
   public void method3505(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3498(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)LModIcon;",
      garbageValue = "-1053392026"
   )
   public static ModIcon method3506(class182 var0, String var1, String var2) {
      int var3 = var0.method3350(var1);
      int var4 = var0.method3345(var3, var2);
      return class155.method2954(var0, var3, var4);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-177824773"
   )
   static void method3507() {
      class225.field3213 = null;
      class225.field3214 = null;
      class225.field3215 = null;
      class225.field3219 = null;
      class225.field3210 = null;
      class225.field3218 = null;
   }
}
