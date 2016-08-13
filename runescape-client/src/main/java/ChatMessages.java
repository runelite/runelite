import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = -2064338507
   )
   static int field275;
   @ObfuscatedName("r")
   boolean[] field276;
   @ObfuscatedName("ia")
   static Widget field278;
   @ObfuscatedName("s")
   @Export("messages")
   String[] messages;
   @ObfuscatedName("k")
   boolean field280 = false;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 8145679604000701241L
   )
   long field281;
   @ObfuscatedName("em")
   static SpritePixels[] field283;
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = 1472241741
   )
   static int field286;
   @ObfuscatedName("e")
   boolean[] field288;
   @ObfuscatedName("h")
   int[] field289;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-378871676"
   )
   String method219(int var1) {
      return this.messages[var1];
   }

   ChatMessages() {
      this.field289 = new int[SecondaryBufferProvider.field1448.method3405(19)];
      this.messages = new String[SecondaryBufferProvider.field1448.method3405(15)];
      this.field276 = new boolean[this.field289.length];

      int var1;
      for(var1 = 0; var1 < this.field289.length; ++var1) {
         class47 var2 = CollisionData.method2533(var1);
         this.field276[var1] = var2.field1071;
      }

      this.field288 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class53 var3 = ChatLineBuffer.method679(var1);
         this.field288[var1] = var3.field1166;
      }

      for(var1 = 0; var1 < this.field289.length; ++var1) {
         this.field289[var1] = -1;
      }

      this.method222();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-955955899"
   )
   int method220(int var1) {
      return this.field289[var1];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ZI)LFileOnDisk;",
      garbageValue = "-2124001515"
   )
   FileOnDisk method221(boolean var1) {
      return class114.method2540("2", Client.field298.field2346, var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   void method222() {
      FileOnDisk var1 = this.method221(false);

      label194: {
         try {
            byte[] var2 = new byte[(int)var1.method4273()];

            int var3;
            for(int var4 = 0; var4 < var2.length; var4 += var3) {
               var3 = var1.method4274(var2, var4, var2.length - var4);
               if(var3 == -1) {
                  throw new EOFException();
               }
            }

            Buffer var23 = new Buffer(var2);
            if(var23.payload.length - var23.offset < 1) {
               return;
            }

            int var5 = var23.method2633();
            if(var5 >= 0 && var5 <= 1) {
               int var6 = var23.method2635();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var23.method2635();
                  var9 = var23.method2620();
                  if(this.field276[var8]) {
                     this.field289[var8] = var9;
                  }
               }

               var7 = var23.method2635();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label194;
                  }

                  var9 = var23.method2635();
                  String var10 = var23.method2663();
                  if(this.field288[var9]) {
                     this.messages[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var21) {
            break label194;
         } finally {
            try {
               var1.method4283();
            } catch (Exception var20) {
               ;
            }

         }

         return;
      }

      this.field280 = false;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "119"
   )
   void method223() {
      int var1;
      for(var1 = 0; var1 < this.field289.length; ++var1) {
         if(!this.field276[var1]) {
            this.field289[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field288[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "-34"
   )
   void method224(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field288[var1]) {
         this.field280 = true;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "73"
   )
   void method225() {
      FileOnDisk var1 = this.method221(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field289.length; ++var4) {
            if(this.field276[var4] && this.field289[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field288[var5] && null != this.messages[var5]) {
               var2 += 2 + class54.method1165(this.messages[var5]);
               ++var4;
            }
         }

         Buffer var17 = new Buffer(var2);
         var17.method2783(1);
         var17.method2619(var3);

         int var6;
         for(var6 = 0; var6 < this.field289.length; ++var6) {
            if(this.field276[var6] && this.field289[var6] != -1) {
               var17.method2619(var6);
               var17.method2728(this.field289[var6]);
            }
         }

         var17.method2619(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field288[var6] && null != this.messages[var6]) {
               var17.method2619(var6);
               var17.method2703(this.messages[var6]);
            }
         }

         var1.method4275(var17.payload, 0, var17.offset);
      } catch (Exception var15) {
         ;
      } finally {
         try {
            var1.method4283();
         } catch (Exception var14) {
            ;
         }

      }

      this.field280 = false;
      this.field281 = class56.method1249();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1715716233"
   )
   static void method226() {
      if(class33.field754) {
         class33.field760 = null;
         class33.field763 = null;
         class33.field744 = null;
         class33.field745 = null;
         class33.field746 = null;
         Frames.field1847 = null;
         class33.field747 = null;
         class47.field1075 = null;
         class22.field596 = null;
         class32.field731 = null;
         class174.field2789 = null;
         class33.field773 = null;
         class48.field1081 = null;
         class33.field774 = null;
         class153.field2310 = null;
         class18.field269 = null;
         class33.field750 = null;
         class138.field2141 = null;
         class26.field649 = null;
         class144.field2226 = null;
         ChatLineBuffer.field699 = null;
         PlayerComposition.field2970 = null;
         class34.method755(2);
         class161.method3314(true);
         class33.field754 = false;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method227() {
      if(this.field280 && this.field281 < class56.method1249() - 60000L) {
         this.method225();
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "101"
   )
   boolean method228() {
      return this.field280;
   }

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "1733580720"
   )
   static final String[] method241(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "921799473"
   )
   static final void method246(int var0, int var1, int var2, int var3) {
      ++Client.field400;
      class172.method3515(class35.field796);
      boolean var4 = false;
      int var5;
      int var6;
      if(Client.field425 >= 0) {
         var5 = class34.field783;
         int[] var7 = class34.field784;

         for(var6 = 0; var6 < var5; ++var6) {
            if(var7[var6] == Client.field425) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         class172.method3515(class35.field800);
      }

      class16.method206(true);
      class172.method3515(var4?class35.field798:class35.field797);
      class16.method206(false);

      for(Projectile var19 = (Projectile)Client.projectiles.method3980(); null != var19; var19 = (Projectile)Client.projectiles.method3970()) {
         if(VertexNormal.plane == var19.floor && Client.gameCycle <= var19.field124) {
            if(Client.gameCycle >= var19.startTime) {
               if(var19.interacting > 0) {
                  NPC var8 = Client.cachedNPCs[var19.interacting - 1];
                  if(null != var8 && var8.x >= 0 && var8.x < 13312 && var8.y >= 0 && var8.y < 13312) {
                     var19.method98(var8.x, var8.y, class127.method2936(var8.x, var8.y, var19.floor) - var19.field105, Client.gameCycle);
                  }
               }

               if(var19.interacting < 0) {
                  var6 = -var19.interacting - 1;
                  Player var21;
                  if(Client.localInteractingIndex == var6) {
                     var21 = WidgetNode.localPlayer;
                  } else {
                     var21 = Client.cachedPlayers[var6];
                  }

                  if(var21 != null && var21.x >= 0 && var21.x < 13312 && var21.y >= 0 && var21.y < 13312) {
                     var19.method98(var21.x, var21.y, class127.method2936(var21.x, var21.y, var19.floor) - var19.field105, Client.gameCycle);
                  }
               }

               var19.method94(Client.field370);
               class136.region.method2003(VertexNormal.plane, (int)var19.x, (int)var19.velocityZ, (int)var19.z, 60, var19, var19.field120, -1, false);
            }
         } else {
            var19.unlink();
         }
      }

      class62.method1397();
      class110.method2487(var0, var1, var2, var3, true);
      var0 = Client.field556;
      var1 = Client.field557;
      var2 = Client.camera2;
      var3 = Client.camera3;
      class82.method1908(var0, var1, var0 + var2, var1 + var3);
      class94.method2183();
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var20;
      int var22;
      if(!Client.field542) {
         var5 = Client.field462;
         if(Client.field540 / 256 > var5) {
            var5 = Client.field540 / 256;
         }

         if(Client.field331[4] && 128 + Client.field393[4] > var5) {
            var5 = Client.field393[4] + 128;
         }

         var15 = Client.field362 + Client.mapAngle & 2047;
         var6 = MessageNode.field817;
         var20 = class127.method2936(WidgetNode.localPlayer.x, WidgetNode.localPlayer.y, VertexNormal.plane) - Client.field338;
         var22 = class167.field2710;
         var9 = 3 * var5 + 600;
         var10 = 2048 - var5 & 2047;
         var11 = 2048 - var15 & 2047;
         var12 = 0;
         var13 = 0;
         var14 = var9;
         int var16;
         int var17;
         int var18;
         if(var10 != 0) {
            var16 = class94.field1661[var10];
            var17 = class94.field1662[var10];
            var18 = var13 * var17 - var9 * var16 >> 16;
            var14 = var16 * var13 + var9 * var17 >> 16;
            var13 = var18;
         }

         if(var11 != 0) {
            var16 = class94.field1661[var11];
            var17 = class94.field1662[var11];
            var18 = var17 * var12 + var14 * var16 >> 16;
            var14 = var14 * var17 - var16 * var12 >> 16;
            var12 = var18;
         }

         class151.cameraX = var6 - var12;
         class8.cameraZ = var20 - var13;
         GroundObject.cameraY = var22 - var14;
         ItemLayer.cameraPitch = var5;
         class59.cameraYaw = var15;
      }

      if(!Client.field542) {
         if(class136.field2123.field143) {
            var15 = VertexNormal.plane;
         } else {
            label333: {
               var6 = 3;
               if(ItemLayer.cameraPitch < 310) {
                  var20 = class151.cameraX >> 7;
                  var22 = GroundObject.cameraY >> 7;
                  var9 = WidgetNode.localPlayer.x >> 7;
                  var10 = WidgetNode.localPlayer.y >> 7;
                  if(var20 < 0 || var22 < 0 || var20 >= 104 || var22 >= 104) {
                     var15 = VertexNormal.plane;
                     break label333;
                  }

                  if((class5.tileSettings[VertexNormal.plane][var20][var22] & 4) != 0) {
                     var6 = VertexNormal.plane;
                  }

                  if(var9 > var20) {
                     var11 = var9 - var20;
                  } else {
                     var11 = var20 - var9;
                  }

                  if(var10 > var22) {
                     var12 = var10 - var22;
                  } else {
                     var12 = var22 - var10;
                  }

                  if(var11 > var12) {
                     var13 = var12 * 65536 / var11;
                     var14 = '耀';

                     while(var9 != var20) {
                        if(var20 < var9) {
                           ++var20;
                        } else if(var20 > var9) {
                           --var20;
                        }

                        if((class5.tileSettings[VertexNormal.plane][var20][var22] & 4) != 0) {
                           var6 = VertexNormal.plane;
                        }

                        var14 += var13;
                        if(var14 >= 65536) {
                           var14 -= 65536;
                           if(var22 < var10) {
                              ++var22;
                           } else if(var22 > var10) {
                              --var22;
                           }

                           if((class5.tileSettings[VertexNormal.plane][var20][var22] & 4) != 0) {
                              var6 = VertexNormal.plane;
                           }
                        }
                     }
                  } else {
                     var13 = 65536 * var11 / var12;
                     var14 = '耀';

                     while(var22 != var10) {
                        if(var22 < var10) {
                           ++var22;
                        } else if(var22 > var10) {
                           --var22;
                        }

                        if((class5.tileSettings[VertexNormal.plane][var20][var22] & 4) != 0) {
                           var6 = VertexNormal.plane;
                        }

                        var14 += var13;
                        if(var14 >= 65536) {
                           var14 -= 65536;
                           if(var20 < var9) {
                              ++var20;
                           } else if(var20 > var9) {
                              --var20;
                           }

                           if((class5.tileSettings[VertexNormal.plane][var20][var22] & 4) != 0) {
                              var6 = VertexNormal.plane;
                           }
                        }
                     }
                  }
               }

               if(WidgetNode.localPlayer.x >= 0 && WidgetNode.localPlayer.y >= 0 && WidgetNode.localPlayer.x < 13312 && WidgetNode.localPlayer.y < 13312) {
                  if((class5.tileSettings[VertexNormal.plane][WidgetNode.localPlayer.x >> 7][WidgetNode.localPlayer.y >> 7] & 4) != 0) {
                     var6 = VertexNormal.plane;
                  }

                  var15 = var6;
               } else {
                  var15 = VertexNormal.plane;
               }
            }
         }

         var5 = var15;
      } else {
         if(class136.field2123.field143) {
            var15 = VertexNormal.plane;
         } else {
            var6 = class127.method2936(class151.cameraX, GroundObject.cameraY, VertexNormal.plane);
            if(var6 - class8.cameraZ < 800 && (class5.tileSettings[VertexNormal.plane][class151.cameraX >> 7][GroundObject.cameraY >> 7] & 4) != 0) {
               var15 = VertexNormal.plane;
            } else {
               var15 = 3;
            }
         }

         var5 = var15;
      }

      var15 = class151.cameraX;
      var6 = class8.cameraZ;
      var20 = GroundObject.cameraY;
      var22 = ItemLayer.cameraPitch;
      var9 = class59.cameraYaw;

      for(var10 = 0; var10 < 5; ++var10) {
         if(Client.field331[var10]) {
            var11 = (int)(Math.random() * (double)(2 * Client.field544[var10] + 1) - (double)Client.field544[var10] + Math.sin((double)Client.field547[var10] * ((double)Client.field546[var10] / 100.0D)) * (double)Client.field393[var10]);
            if(var10 == 0) {
               class151.cameraX += var11;
            }

            if(var10 == 1) {
               class8.cameraZ += var11;
            }

            if(var10 == 2) {
               GroundObject.cameraY += var11;
            }

            if(var10 == 3) {
               class59.cameraYaw = var11 + class59.cameraYaw & 2047;
            }

            if(var10 == 4) {
               ItemLayer.cameraPitch += var11;
               if(ItemLayer.cameraPitch < 128) {
                  ItemLayer.cameraPitch = 128;
               }

               if(ItemLayer.cameraPitch > 383) {
                  ItemLayer.cameraPitch = 383;
               }
            }
         }
      }

      var10 = class143.field2206;
      var11 = class143.field2209;
      if(class143.field2217 != 0) {
         var10 = class143.field2215;
         var11 = class143.field2216;
      }

      if(var10 >= var0 && var10 < var0 + var2 && var11 >= var1 && var11 < var3 + var1) {
         Model.field1924 = true;
         Model.field1931 = 0;
         Model.field1875 = var10 - var0;
         Model.field1926 = var11 - var1;
      } else {
         Model.field1924 = false;
         Model.field1931 = 0;
      }

      class47.method1009();
      class82.method1907(var0, var1, var2, var3, 0);
      class47.method1009();
      var12 = class94.field1660;
      class94.field1660 = Client.scale;
      class136.region.method2011(class151.cameraX, class8.cameraZ, GroundObject.cameraY, ItemLayer.cameraPitch, class59.cameraYaw, var5);
      class94.field1660 = var12;
      class47.method1009();
      class136.region.method2006();
      class31.method698(var0, var1, var2, var3);
      if(Client.field313 == 2) {
         class35.method756(Client.field375 + (Client.field316 - class0.baseX << 7), (Client.field317 - class21.baseY << 7) + Client.field384, Client.field517 * 2);
         if(Client.field401 > -1 && Client.gameCycle % 20 < 10) {
            class158.field2353[0].method1824(var0 + Client.field401 - 12, Client.field402 + var1 - 28);
         }
      }

      ((TextureProvider)class94.field1658).method2264(Client.field370);
      if(Client.field406 == 1) {
         class130.field2101[Client.field537 / 100].method1824(Client.field480 - 8, Client.field404 - 8);
      }

      if(Client.field406 == 2) {
         class130.field2101[Client.field537 / 100 + 4].method1824(Client.field480 - 8, Client.field404 - 8);
      }

      TextureProvider.method2283();
      class151.cameraX = var15;
      class8.cameraZ = var6;
      GroundObject.cameraY = var20;
      ItemLayer.cameraPitch = var22;
      class59.cameraYaw = var9;
      if(Client.field304 && class172.method3513(true, false) == 0) {
         Client.field304 = false;
      }

      if(Client.field304) {
         class82.method1907(var0, var1, var2, var3, 0);
         class9.method131("Loading - please wait.", false);
      }

   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(Lclass16;I)V",
      garbageValue = "-846244703"
   )
   static final void method253(class16 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field229 == 0) {
         var1 = class136.region.method1998(var0.field239, var0.field238, var0.field231);
      }

      if(var0.field229 == 1) {
         var1 = class136.region.method2018(var0.field239, var0.field238, var0.field231);
      }

      if(var0.field229 == 2) {
         var1 = class136.region.method2019(var0.field239, var0.field238, var0.field231);
      }

      if(var0.field229 == 3) {
         var1 = class136.region.method2014(var0.field239, var0.field238, var0.field231);
      }

      if(var1 != 0) {
         int var5 = class136.region.method2081(var0.field239, var0.field238, var0.field231, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field232 = var2;
      var0.field228 = var3;
      var0.field233 = var4;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "375489337"
   )
   void method254(int var1, int var2) {
      this.field289[var1] = var2;
      if(this.field276[var1]) {
         this.field280 = true;
      }

   }
}
