import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("SecondaryBufferProvider")
public final class SecondaryBufferProvider extends BufferProvider implements ImageProducer, ImageObserver {
   @ObfuscatedName("dh")
   static byte[][] field1446;
   @ObfuscatedName("d")
   ImageConsumer field1451;
   @ObfuscatedName("a")
   ColorModel field1453;
   @ObfuscatedName("ak")
   @Export("authCode")
   static String authCode;

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field1451 = var1;
      var1.setDimensions(super.width, super.height);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field1453);
      var1.setHints(14);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "-557590795"
   )
   final void init(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[var2 * var1 + 1];
      this.field1453 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.image = var3.createImage(this);
      this.method1675();
      var3.prepareImage(super.image, this);
      this.method1675();
      var3.prepareImage(super.image, this);
      this.method1675();
      var3.prepareImage(super.image, this);
      this.method1716();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "138016631"
   )
   @Export("draw")
   public final void draw(Graphics var1, int var2, int var3) {
      this.method1675();
      var1.drawImage(super.image, var2, var3, this);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIB)V",
      garbageValue = "1"
   )
   @Export("drawSub")
   public final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method1649(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.image, 0, 0, this);
      var1.setClip(var6);
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(this.field1451 == var1) {
         this.field1451 = null;
      }

   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-540366189"
   )
   synchronized void method1649(int var1, int var2, int var3, int var4) {
      if(null != this.field1451) {
         this.field1451.setPixels(var1, var2, var3, var4, this.field1453, super.pixels, var1 + var2 * super.width, super.width);
         this.field1451.imageComplete(2);
      }
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return this.field1451 == var1;
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-564176538"
   )
   public static boolean method1668(char var0) {
      return var0 >= 48 && var0 <= 57;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1266061489"
   )
   synchronized void method1675() {
      if(this.field1451 != null) {
         this.field1451.setPixels(0, 0, super.width, super.height, this.field1453, super.pixels, 0, super.width);
         this.field1451.imageComplete(2);
      }
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "-94"
   )
   static boolean method1676(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = Frames.method2312(var0, Client.field283);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(Frames.method2312(var3.name, Client.field283))) {
               return true;
            }

            if(var1.equalsIgnoreCase(Frames.method2312(var3.previousName, Client.field283))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1184691103"
   )
   static final void method1678(int var0, int var1, int var2, int var3) {
      ++Client.field387;
      class16.method187(class35.field802);
      boolean var4 = false;
      int var5;
      int var7;
      if(Client.field555 >= 0) {
         var5 = class34.field779;
         int[] var6 = class34.field780;

         for(var7 = 0; var7 < var5; ++var7) {
            if(var6[var7] == Client.field555) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         class16.method187(class35.field795);
      }

      WallObject.method2111(true);
      class16.method187(var4?class35.field798:class35.field797);
      WallObject.method2111(false);

      for(Projectile var28 = (Projectile)Client.projectiles.method3854(); var28 != null; var28 = (Projectile)Client.projectiles.method3869()) {
         if(Item.plane == var28.floor && Client.gameCycle <= var28.field98) {
            if(Client.gameCycle >= var28.startTime) {
               if(var28.interacting > 0) {
                  NPC var33 = Client.cachedNPCs[var28.interacting - 1];
                  if(var33 != null && var33.x >= 0 && var33.x < 13312 && var33.y >= 0 && var33.y < 13312) {
                     var28.method89(var33.x, var33.y, class116.method2462(var33.x, var33.y, var28.floor) - var28.field102, Client.gameCycle);
                  }
               }

               if(var28.interacting < 0) {
                  var7 = -var28.interacting - 1;
                  Player var34;
                  if(var7 == Client.localInteractingIndex) {
                     var34 = WidgetNode.localPlayer;
                  } else {
                     var34 = Client.cachedPlayers[var7];
                  }

                  if(null != var34 && var34.x >= 0 && var34.x < 13312 && var34.y >= 0 && var34.y < 13312) {
                     var28.method89(var34.x, var34.y, class116.method2462(var34.x, var34.y, var28.floor) - var28.field102, Client.gameCycle);
                  }
               }

               var28.method90(Client.field358);
               class16.region.method1959(Item.plane, (int)var28.x, (int)var28.velocityZ, (int)var28.z, 60, var28, var28.field110, -1, false);
            }
         } else {
            var28.unlink();
         }
      }

      class38.method774();
      class110.method2404(var0, var1, var2, var3, true);
      var0 = Client.field543;
      var1 = Client.field297;
      var2 = Client.camera2;
      var3 = Client.camera3;
      class82.method1830(var0, var1, var0 + var2, var1 + var3);
      class94.method2118();
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var15;
      int var16;
      int var18;
      int var29;
      if(!Client.field528) {
         var5 = Client.field366;
         if(Client.field375 / 256 > var5) {
            var5 = Client.field375 / 256;
         }

         if(Client.field539[4] && Client.field481[4] + 128 > var5) {
            var5 = Client.field481[4] + 128;
         }

         var29 = Client.field350 + Client.mapAngle & 2047;
         var7 = class8.field137;
         var8 = class116.method2462(WidgetNode.localPlayer.x, WidgetNode.localPlayer.y, Item.plane) - Client.field372;
         var9 = class35.field807;
         var10 = 600 + 3 * var5;
         var11 = 2048 - var5 & 2047;
         var12 = 2048 - var29 & 2047;
         var13 = 0;
         int var14 = 0;
         var15 = var10;
         int var17;
         if(var11 != 0) {
            var16 = class94.field1670[var11];
            var17 = class94.field1676[var11];
            var18 = var14 * var17 - var10 * var16 >> 16;
            var15 = var17 * var10 + var16 * var14 >> 16;
            var14 = var18;
         }

         if(var12 != 0) {
            var16 = class94.field1670[var12];
            var17 = class94.field1676[var12];
            var18 = var15 * var16 + var13 * var17 >> 16;
            var15 = var17 * var15 - var16 * var13 >> 16;
            var13 = var18;
         }

         class165.cameraX = var7 - var13;
         class125.cameraZ = var8 - var14;
         class9.cameraY = var9 - var15;
         class18.cameraPitch = var5;
         class33.cameraYaw = var29;
      }

      if(!Client.field528) {
         var5 = class173.method3419();
      } else {
         var5 = Projectile.method93();
      }

      var29 = class165.cameraX;
      var7 = class125.cameraZ;
      var8 = class9.cameraY;
      var9 = class18.cameraPitch;
      var10 = class33.cameraYaw;

      for(var11 = 0; var11 < 5; ++var11) {
         if(Client.field539[var11]) {
            var12 = (int)(Math.random() * (double)(2 * Client.field531[var11] + 1) - (double)Client.field531[var11] + Math.sin((double)Client.field534[var11] * ((double)Client.field533[var11] / 100.0D)) * (double)Client.field481[var11]);
            if(var11 == 0) {
               class165.cameraX += var12;
            }

            if(var11 == 1) {
               class125.cameraZ += var12;
            }

            if(var11 == 2) {
               class9.cameraY += var12;
            }

            if(var11 == 3) {
               class33.cameraYaw = var12 + class33.cameraYaw & 2047;
            }

            if(var11 == 4) {
               class18.cameraPitch += var12;
               if(class18.cameraPitch < 128) {
                  class18.cameraPitch = 128;
               }

               if(class18.cameraPitch > 383) {
                  class18.cameraPitch = 383;
               }
            }
         }
      }

      var11 = class143.field2225;
      var12 = class143.field2222;
      if(class143.field2227 != 0) {
         var11 = class143.field2223;
         var12 = class143.field2226;
      }

      if(var11 >= var0 && var11 < var2 + var0 && var12 >= var1 && var12 < var1 + var3) {
         Model.field1882 = true;
         Model.field1940 = 0;
         Model.field1938 = var11 - var0;
         Model.field1939 = var12 - var1;
      } else {
         Model.field1882 = false;
         Model.field1940 = 0;
      }

      WidgetNode.method41();
      class82.method1883(var0, var1, var2, var3, 0);
      WidgetNode.method41();
      var13 = class94.field1661;
      class94.field1661 = Client.scale;
      class16.region.method1985(class165.cameraX, class125.cameraZ, class9.cameraY, class18.cameraPitch, class33.cameraYaw, var5);
      class94.field1661 = var13;
      WidgetNode.method41();
      class16.region.method1962();
      Client.field376 = 0;
      boolean var35 = false;
      var15 = -1;
      var16 = class34.field779;
      int[] var30 = class34.field780;

      for(var18 = 0; var18 < Client.field319 + var16; ++var18) {
         Object var19;
         if(var18 < var16) {
            var19 = Client.cachedPlayers[var30[var18]];
            if(var30[var18] == Client.field555) {
               var35 = true;
               var15 = var18;
               continue;
            }
         } else {
            var19 = Client.cachedNPCs[Client.field320[var18 - var16]];
         }

         Widget.method3496((Actor)var19, var18, var0, var1, var2, var3);
      }

      if(var35) {
         Widget.method3496(Client.cachedPlayers[Client.field555], var15, var0, var1, var2, var3);
      }

      for(var18 = 0; var18 < Client.field376; ++var18) {
         int var32 = Client.field378[var18];
         int var20 = Client.field447[var18];
         int var21 = Client.field305[var18];
         int var22 = Client.field380[var18];
         boolean var23 = true;

         while(var23) {
            var23 = false;

            for(int var31 = 0; var31 < var18; ++var31) {
               if(2 + var20 > Client.field447[var31] - Client.field380[var31] && var20 - var22 < 2 + Client.field447[var31] && var32 - var21 < Client.field305[var31] + Client.field378[var31] && var21 + var32 > Client.field378[var31] - Client.field305[var31] && Client.field447[var31] - Client.field380[var31] < var20) {
                  var20 = Client.field447[var31] - Client.field380[var31];
                  var23 = true;
               }
            }
         }

         Client.field388 = Client.field378[var18];
         Client.field389 = Client.field447[var18] = var20;
         String var24 = Client.field385[var18];
         if(Client.field536 == 0) {
            int var25 = 16776960;
            if(Client.field382[var18] < 6) {
               var25 = Client.field497[Client.field382[var18]];
            }

            if(Client.field382[var18] == 6) {
               var25 = Client.field387 % 20 < 10?16711680:16776960;
            }

            if(Client.field382[var18] == 7) {
               var25 = Client.field387 % 20 < 10?255:'\uffff';
            }

            if(Client.field382[var18] == 8) {
               var25 = Client.field387 % 20 < 10?'뀀':8454016;
            }

            int var26;
            if(Client.field382[var18] == 9) {
               var26 = 150 - Client.field384[var18];
               if(var26 < 50) {
                  var25 = 16711680 + 1280 * var26;
               } else if(var26 < 100) {
                  var25 = 16776960 - 327680 * (var26 - 50);
               } else if(var26 < 150) {
                  var25 = '\uff00' + 5 * (var26 - 100);
               }
            }

            if(Client.field382[var18] == 10) {
               var26 = 150 - Client.field384[var18];
               if(var26 < 50) {
                  var25 = 16711680 + 5 * var26;
               } else if(var26 < 100) {
                  var25 = 16711935 - 327680 * (var26 - 50);
               } else if(var26 < 150) {
                  var25 = 255 + (var26 - 100) * 327680 - (var26 - 100) * 5;
               }
            }

            if(Client.field382[var18] == 11) {
               var26 = 150 - Client.field384[var18];
               if(var26 < 50) {
                  var25 = 16777215 - var26 * 327685;
               } else if(var26 < 100) {
                  var25 = '\uff00' + (var26 - 50) * 327685;
               } else if(var26 < 150) {
                  var25 = 16777215 - (var26 - 100) * 327680;
               }
            }

            if(Client.field383[var18] == 0) {
               Frames.field1850.method4080(var24, var0 + Client.field388, var1 + Client.field389, var25, 0);
            }

            if(Client.field383[var18] == 1) {
               Frames.field1850.method4074(var24, Client.field388 + var0, var1 + Client.field389, var25, 0, Client.field387);
            }

            if(Client.field383[var18] == 2) {
               Frames.field1850.method4075(var24, Client.field388 + var0, var1 + Client.field389, var25, 0, Client.field387);
            }

            if(Client.field383[var18] == 3) {
               Frames.field1850.method4076(var24, var0 + Client.field388, Client.field389 + var1, var25, 0, Client.field387, 150 - Client.field384[var18]);
            }

            if(Client.field383[var18] == 4) {
               var26 = (150 - Client.field384[var18]) * (Frames.field1850.method4065(var24) + 100) / 150;
               class82.method1824(var0 + Client.field388 - 50, var1, 50 + Client.field388 + var0, var3 + var1);
               Frames.field1850.method4157(var24, var0 + Client.field388 + 50 - var26, var1 + Client.field389, var25, 0);
               class82.method1830(var0, var1, var2 + var0, var1 + var3);
            }

            if(Client.field383[var18] == 5) {
               var26 = 150 - Client.field384[var18];
               int var27 = 0;
               if(var26 < 25) {
                  var27 = var26 - 25;
               } else if(var26 > 125) {
                  var27 = var26 - 125;
               }

               class82.method1824(var0, var1 + Client.field389 - Frames.field1850.field3237 - 1, var0 + var2, var1 + Client.field389 + 5);
               Frames.field1850.method4080(var24, var0 + Client.field388, Client.field389 + var1 + var27, var25, 0);
               class82.method1830(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            Frames.field1850.method4080(var24, Client.field388 + var0, Client.field389 + var1, 16776960, 0);
         }
      }

      class4.method47(var0, var1);
      ((TextureProvider)class94.field1672).method2200(Client.field358);
      if(Client.field393 == 1) {
         Client.field276[Client.field392 / 100].method1746(Client.field521 - 8, Client.field394 - 8);
      }

      if(Client.field393 == 2) {
         Client.field276[Client.field392 / 100 + 4].method1746(Client.field521 - 8, Client.field394 - 8);
      }

      class118.method2471();
      class165.cameraX = var29;
      class125.cameraZ = var7;
      class9.cameraY = var8;
      class18.cameraPitch = var9;
      class33.cameraYaw = var10;
      if(Client.field411 && class173.method3418(true, false) == 0) {
         Client.field411 = false;
      }

      if(Client.field411) {
         class82.method1883(var0, var1, var2, var3, 0);
         class38.method779("Loading - please wait.", false);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIIIILRegion;LCollisionData;I)V",
      garbageValue = "369005172"
   )
   static final void method1679(int var0, int var1, int var2, int var3, int var4, int var5, int var6, Region var7, CollisionData var8) {
      ObjectComposition var9 = class165.getObjectDefinition(var4);
      int var10;
      int var11;
      if(var5 != 1 && var5 != 3) {
         var10 = var9.field963;
         var11 = var9.field964;
      } else {
         var10 = var9.field964;
         var11 = var9.field963;
      }

      int var12;
      int var13;
      if(var2 + var10 <= 104) {
         var12 = (var10 >> 1) + var2;
         var13 = (1 + var10 >> 1) + var2;
      } else {
         var12 = var2;
         var13 = var2 + 1;
      }

      int var14;
      int var15;
      if(var11 + var3 <= 104) {
         var14 = (var11 >> 1) + var3;
         var15 = (1 + var11 >> 1) + var3;
      } else {
         var14 = var3;
         var15 = 1 + var3;
      }

      int[][] var16 = class5.tileHeights[var1];
      int var17 = var16[var12][var14] + var16[var13][var14] + var16[var12][var15] + var16[var13][var15] >> 2;
      int var18 = (var10 << 6) + (var2 << 7);
      int var19 = (var11 << 6) + (var3 << 7);
      int var20 = (var4 << 14) + (var3 << 7) + var2 + 1073741824;
      if(var9.field967 == 0) {
         var20 -= Integer.MIN_VALUE;
      }

      int var21 = (var5 << 6) + var6;
      if(var9.field988 == 1) {
         var21 += 256;
      }

      Object var27;
      if(var6 == 22) {
         if(var9.field989 == -1 && null == var9.impostorIds) {
            var27 = var9.method843(22, var5, var16, var18, var17, var19);
         } else {
            var27 = new class12(var4, 22, var5, var1, var2, var3, var9.field989, true, (Renderable)null);
         }

         var7.groundObjectSpawned(var0, var2, var3, var17, (Renderable)var27, var20, var21);
         if(var9.field965 == 1) {
            var8.method2414(var2, var3);
         }

      } else if(var6 != 10 && var6 != 11) {
         if(var6 >= 12) {
            if(var9.field989 == -1 && null == var9.impostorIds) {
               var27 = var9.method843(var6, var5, var16, var18, var17, var19);
            } else {
               var27 = new class12(var4, var6, var5, var1, var2, var3, var9.field989, true, (Renderable)null);
            }

            var7.method1958(var0, var2, var3, var17, 1, 1, (Renderable)var27, 0, var20, var21);
            if(var9.field965 != 0) {
               var8.method2412(var2, var3, var10, var11, var9.field966);
            }

         } else if(var6 == 0) {
            if(var9.field989 == -1 && var9.impostorIds == null) {
               var27 = var9.method843(0, var5, var16, var18, var17, var19);
            } else {
               var27 = new class12(var4, 0, var5, var1, var2, var3, var9.field989, true, (Renderable)null);
            }

            var7.method1956(var0, var2, var3, var17, (Renderable)var27, (Renderable)null, class5.field82[var5], 0, var20, var21);
            if(var9.field965 != 0) {
               var8.method2411(var2, var3, var6, var5, var9.field966);
            }

         } else if(var6 == 1) {
            if(var9.field989 == -1 && null == var9.impostorIds) {
               var27 = var9.method843(1, var5, var16, var18, var17, var19);
            } else {
               var27 = new class12(var4, 1, var5, var1, var2, var3, var9.field989, true, (Renderable)null);
            }

            var7.method1956(var0, var2, var3, var17, (Renderable)var27, (Renderable)null, class5.field91[var5], 0, var20, var21);
            if(var9.field965 != 0) {
               var8.method2411(var2, var3, var6, var5, var9.field966);
            }

         } else {
            int var22;
            Object var24;
            if(var6 == 2) {
               var22 = 1 + var5 & 3;
               Object var28;
               if(var9.field989 == -1 && var9.impostorIds == null) {
                  var28 = var9.method843(2, 4 + var5, var16, var18, var17, var19);
                  var24 = var9.method843(2, var22, var16, var18, var17, var19);
               } else {
                  var28 = new class12(var4, 2, var5 + 4, var1, var2, var3, var9.field989, true, (Renderable)null);
                  var24 = new class12(var4, 2, var22, var1, var2, var3, var9.field989, true, (Renderable)null);
               }

               var7.method1956(var0, var2, var3, var17, (Renderable)var28, (Renderable)var24, class5.field82[var5], class5.field82[var22], var20, var21);
               if(var9.field965 != 0) {
                  var8.method2411(var2, var3, var6, var5, var9.field966);
               }

            } else if(var6 == 3) {
               if(var9.field989 == -1 && var9.impostorIds == null) {
                  var27 = var9.method843(3, var5, var16, var18, var17, var19);
               } else {
                  var27 = new class12(var4, 3, var5, var1, var2, var3, var9.field989, true, (Renderable)null);
               }

               var7.method1956(var0, var2, var3, var17, (Renderable)var27, (Renderable)null, class5.field91[var5], 0, var20, var21);
               if(var9.field965 != 0) {
                  var8.method2411(var2, var3, var6, var5, var9.field966);
               }

            } else if(var6 == 9) {
               if(var9.field989 == -1 && var9.impostorIds == null) {
                  var27 = var9.method843(var6, var5, var16, var18, var17, var19);
               } else {
                  var27 = new class12(var4, var6, var5, var1, var2, var3, var9.field989, true, (Renderable)null);
               }

               var7.method1958(var0, var2, var3, var17, 1, 1, (Renderable)var27, 0, var20, var21);
               if(var9.field965 != 0) {
                  var8.method2412(var2, var3, var10, var11, var9.field966);
               }

            } else if(var6 == 4) {
               if(var9.field989 == -1 && var9.impostorIds == null) {
                  var27 = var9.method843(4, var5, var16, var18, var17, var19);
               } else {
                  var27 = new class12(var4, 4, var5, var1, var2, var3, var9.field989, true, (Renderable)null);
               }

               var7.method2077(var0, var2, var3, var17, (Renderable)var27, (Renderable)null, class5.field82[var5], 0, 0, 0, var20, var21);
            } else {
               int var23;
               if(var6 == 5) {
                  var22 = 16;
                  var23 = var7.method2022(var0, var2, var3);
                  if(var23 != 0) {
                     var22 = class165.getObjectDefinition(var23 >> 14 & 32767).field972;
                  }

                  if(var9.field989 == -1 && null == var9.impostorIds) {
                     var24 = var9.method843(4, var5, var16, var18, var17, var19);
                  } else {
                     var24 = new class12(var4, 4, var5, var1, var2, var3, var9.field989, true, (Renderable)null);
                  }

                  var7.method2077(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, class5.field82[var5], 0, var22 * class5.field78[var5], var22 * class5.field85[var5], var20, var21);
               } else if(var6 == 6) {
                  var22 = 8;
                  var23 = var7.method2022(var0, var2, var3);
                  if(var23 != 0) {
                     var22 = class165.getObjectDefinition(var23 >> 14 & 32767).field972 / 2;
                  }

                  if(var9.field989 == -1 && var9.impostorIds == null) {
                     var24 = var9.method843(4, var5 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new class12(var4, 4, var5 + 4, var1, var2, var3, var9.field989, true, (Renderable)null);
                  }

                  var7.method2077(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, 256, var5, class5.field86[var5] * var22, var22 * class5.field76[var5], var20, var21);
               } else if(var6 == 7) {
                  var23 = var5 + 2 & 3;
                  if(var9.field989 == -1 && var9.impostorIds == null) {
                     var27 = var9.method843(4, 4 + var23, var16, var18, var17, var19);
                  } else {
                     var27 = new class12(var4, 4, 4 + var23, var1, var2, var3, var9.field989, true, (Renderable)null);
                  }

                  var7.method2077(var0, var2, var3, var17, (Renderable)var27, (Renderable)null, 256, var23, 0, 0, var20, var21);
               } else if(var6 == 8) {
                  var22 = 8;
                  var23 = var7.method2022(var0, var2, var3);
                  if(var23 != 0) {
                     var22 = class165.getObjectDefinition(var23 >> 14 & 32767).field972 / 2;
                  }

                  int var26 = 2 + var5 & 3;
                  Object var25;
                  if(var9.field989 == -1 && var9.impostorIds == null) {
                     var24 = var9.method843(4, 4 + var5, var16, var18, var17, var19);
                     var25 = var9.method843(4, var26 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new class12(var4, 4, var5 + 4, var1, var2, var3, var9.field989, true, (Renderable)null);
                     var25 = new class12(var4, 4, var26 + 4, var1, var2, var3, var9.field989, true, (Renderable)null);
                  }

                  var7.method2077(var0, var2, var3, var17, (Renderable)var24, (Renderable)var25, 256, var5, class5.field86[var5] * var22, var22 * class5.field76[var5], var20, var21);
               }
            }
         }
      } else {
         if(var9.field989 == -1 && null == var9.impostorIds) {
            var27 = var9.method843(10, var5, var16, var18, var17, var19);
         } else {
            var27 = new class12(var4, 10, var5, var1, var2, var3, var9.field989, true, (Renderable)null);
         }

         if(var27 != null) {
            var7.method1958(var0, var2, var3, var17, var10, var11, (Renderable)var27, var6 == 11?256:0, var20, var21);
         }

         if(var9.field965 != 0) {
            var8.method2412(var2, var3, var10, var11, var9.field966);
         }

      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1513192111"
   )
   public static int method1681(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZS)V",
      garbageValue = "32124"
   )
   public static void method1682(String var0, boolean var1, boolean var2) {
      World.method633(var0, var1, "openjs", var2);
   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "23"
   )
   static void method1683() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3820(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3827()) {
         int var1 = var0.id;
         if(class93.method2114(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(null != var3[var4]) {
                  var2 = var3[var4].field2815;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class24.method600(var4);
               if(var5 != null) {
                  class53.method1101(var5);
               }
            }
         }
      }

   }
}
