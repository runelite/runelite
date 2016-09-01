import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class0 extends Node {
   @ObfuscatedName("ar")
   static class146 field0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1980487643
   )
   int field1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -303226547
   )
   int field2;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1999265797
   )
   int field3;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1990420211
   )
   int field4;
   @ObfuscatedName("l")
   Widget field6;
   @ObfuscatedName("j")
   Widget field7;
   @ObfuscatedName("x")
   Object[] field8;
   @ObfuscatedName("f")
   String field9;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -120278629
   )
   int field10;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 214869599
   )
   int field11;
   @ObfuscatedName("e")
   static int[] field12;
   @ObfuscatedName("pw")
   @ObfuscatedGetter(
      intValue = 1796467229
   )
   static int field13;
   @ObfuscatedName("r")
   boolean field14;

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Lclass35;S)V",
      garbageValue = "4459"
   )
   static final void method0(class35 var0) {
      if(class48.localPlayer.x >> 7 == Client.flagX && Client.flagY == class48.localPlayer.y >> 7) {
         Client.flagX = 0;
      }

      int var1 = class34.field760;
      int[] var2 = class34.field755;
      int var3 = var1;
      if(var0 == class35.field782 || var0 == class35.field773) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(var0 == class35.field782) {
            var5 = class48.localPlayer;
            var6 = class48.localPlayer.field48 << 14;
         } else if(var0 == class35.field773) {
            var5 = Client.cachedPlayers[Client.field411];
            var6 = Client.field411 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(var0 == class35.field778 && Client.field411 == var2[var4]) {
               continue;
            }
         }

         if(var5 != null && var5.vmethod750() && !var5.field29) {
            var5.field44 = false;
            if((Client.field314 && var1 > 50 || var1 > 200) && var0 != class35.field782 && var5.poseAnimation == var5.idlePoseAnimation) {
               var5.field44 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.model != null && Client.gameCycle >= var5.totalLevel && Client.gameCycle < var5.field35) {
                  var5.field44 = false;
                  var5.field37 = KitDefinition.method936(var5.x, var5.y, FrameMap.plane);
                  Projectile.region.method1960(FrameMap.plane, var5.x, var5.y, var5.field37, 60, var5, var5.angle, var6, var5.field40, var5.field38, var5.field42, var5.field43);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field386 == Client.field385[var7][var8]) {
                        continue;
                     }

                     Client.field385[var7][var8] = Client.field386;
                  }

                  var5.field37 = KitDefinition.method936(var5.x, var5.y, FrameMap.plane);
                  Projectile.region.method2110(FrameMap.plane, var5.x, var5.y, var5.field37, 60, var5, var5.angle, var6, var5.field820);
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-728251454"
   )
   static void method1() {
      for(class24 var0 = (class24)class24.field604.method3850(); var0 != null; var0 = (class24)class24.field604.method3852()) {
         if(null != var0.field616) {
            var0.method568();
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIILObjectComposition;II)V",
      garbageValue = "761830080"
   )
   static void method2(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class24 var5 = new class24();
      var5.field602 = var0;
      var5.field614 = var1 * 128;
      var5.field605 = var2 * 128;
      int var6 = var3.field938;
      int var7 = var3.field939;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.field939;
         var7 = var3.field938;
      }

      var5.field606 = (var6 + var1) * 128;
      var5.field607 = (var7 + var2) * 128;
      var5.field611 = var3.field948;
      var5.field608 = var3.field968 * 128;
      var5.field603 = var3.field929;
      var5.field612 = var3.field974;
      var5.field619 = var3.field964;
      if(null != var3.impostorIds) {
         var5.field616 = var3;
         var5.method568();
      }

      class24.field604.method3844(var5);
      if(var5.field619 != null) {
         var5.field613 = var5.field603 + (int)(Math.random() * (double)(var5.field612 - var5.field603));
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(S)LSpritePixels;",
      garbageValue = "243"
   )
   static SpritePixels method3() {
      SpritePixels var0 = new SpritePixels();
      var0.field1440 = class79.field1422;
      var0.field1441 = class79.field1419;
      var0.field1439 = class79.field1421[0];
      var0.field1445 = class79.field1423[0];
      var0.width = class20.field567[0];
      var0.height = class79.field1424[0];
      int var1 = var0.width * var0.height;
      byte[] var2 = class13.field191[0];
      var0.image = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.image[var3] = class79.field1425[var2[var3] & 255];
      }

      Friend.method193();
      return var0;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "1245651120"
   )
   static final void method4(Actor var0, int var1) {
      int var3;
      int var4;
      int var8;
      if(var0.field863 > Client.gameCycle) {
         var8 = var0.field863 - Client.gameCycle;
         var3 = var0.field823 * 128 + var0.field821 * 64;
         var4 = var0.field821 * 64 + var0.field861 * 128;
         var0.x += (var3 - var0.x) / var8;
         var0.y += (var4 - var0.y) / var8;
         var0.field875 = 0;
         var0.field835 = var0.field865;
      } else if(var0.field864 >= Client.gameCycle) {
         if(var0.field864 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field842 + 1 > class113.getAnimation(var0.animation).field999[var0.actionFrame]) {
            var8 = var0.field864 - var0.field863;
            var3 = Client.gameCycle - var0.field863;
            var4 = var0.field823 * 128 + var0.field821 * 64;
            int var5 = var0.field861 * 128 + var0.field821 * 64;
            int var6 = var0.field860 * 128 + var0.field821 * 64;
            int var7 = var0.field874 * 128 + var0.field821 * 64;
            var0.x = ((var8 - var3) * var4 + var3 * var6) / var8;
            var0.y = (var7 * var3 + var5 * (var8 - var3)) / var8;
         }

         var0.field875 = 0;
         var0.field835 = var0.field865;
         var0.angle = var0.field835;
      } else {
         class11.method145(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field863 = 0;
         var0.field864 = 0;
         var0.x = 128 * var0.pathX[0] + var0.field821 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field821 * 64;
         var0.method749();
      }

      if(class48.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field863 = 0;
         var0.field864 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field821 * 64;
         var0.y = var0.field821 * 64 + var0.pathY[0] * 128;
         var0.method749();
      }

      ChatLineBuffer.method646(var0);
      var0.field820 = false;
      Sequence var2;
      if(var0.poseAnimation != -1) {
         var2 = class113.getAnimation(var0.poseAnimation);
         if(var2 != null && var2.field1001 != null) {
            ++var0.field848;
            if(var0.poseFrame < var2.field1001.length && var0.field848 > var2.field999[var0.poseFrame]) {
               var0.field848 = 1;
               ++var0.poseFrame;
               Item.method657(var2, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var2.field1001.length) {
               var0.field848 = 0;
               var0.poseFrame = 0;
               Item.method657(var2, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.field857) {
         if(var0.field855 < 0) {
            var0.field855 = 0;
         }

         var8 = Renderable.method1946(var0.graphic).field1017;
         if(var8 != -1) {
            Sequence var9 = class113.getAnimation(var8);
            if(var9 != null && var9.field1001 != null) {
               ++var0.field856;
               if(var0.field855 < var9.field1001.length && var0.field856 > var9.field999[var0.field855]) {
                  var0.field856 = 1;
                  ++var0.field855;
                  Item.method657(var9, var0.field855, var0.x, var0.y);
               }

               if(var0.field855 >= var9.field1001.length && (var0.field855 < 0 || var0.field855 >= var9.field1001.length)) {
                  var0.graphic = -1;
               }
            } else {
               var0.graphic = -1;
            }
         } else {
            var0.graphic = -1;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable <= 1) {
         var2 = class113.getAnimation(var0.animation);
         if(var2.precedenceAnimating == 1 && var0.field822 > 0 && var0.field863 <= Client.gameCycle && var0.field864 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var2 = class113.getAnimation(var0.animation);
         if(null != var2 && null != var2.field1001) {
            ++var0.field842;
            if(var0.actionFrame < var2.field1001.length && var0.field842 > var2.field999[var0.actionFrame]) {
               var0.field842 = 1;
               ++var0.actionFrame;
               Item.method657(var2, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var2.field1001.length) {
               var0.actionFrame -= var2.field1002;
               ++var0.field853;
               if(var0.field853 >= var2.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var2.field1001.length) {
                  Item.method657(var2, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field820 = var2.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }
}
