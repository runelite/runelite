import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
public class class97 implements class158 {
   @ObfuscatedName("b")
   public static final class97 field1622 = new class97(3, 2);
   @ObfuscatedName("g")
   public static final class97 field1623 = new class97(0, 3);
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1651032367
   )
   final int field1625;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 419690945
   )
   public final int field1626;
   @ObfuscatedName("m")
   public static final class97 field1628 = new class97(2, 1);
   @ObfuscatedName("bd")
   static ModIcon[] field1630;
   @ObfuscatedName("o")
   public static final class97 field1632 = new class97(1, 0);
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = -1434191835
   )
   static int field1633;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "255"
   )
   public int vmethod3989() {
      return this.field1625;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class97(int var1, int var2) {
      this.field1626 = var1;
      this.field1625 = var2;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(LActor;B)V",
      garbageValue = "24"
   )
   static final void method1883(Actor var0) {
      if(var0.field657 != 0) {
         if(var0.interacting != -1) {
            Object var1 = null;
            if(var0.interacting < '耀') {
               var1 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var1 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(null != var1) {
               int var2 = var0.x - ((Actor)var1).x;
               int var3 = var0.y - ((Actor)var1).y;
               if(var2 != 0 || var3 != 0) {
                  var0.field655 = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field631) {
               var0.interacting = -1;
               var0.field631 = false;
            }
         }

         if(var0.field614 != -1 && (var0.field656 == 0 || var0.field662 > 0)) {
            var0.field655 = var0.field614;
            var0.field614 = -1;
         }

         int var4 = var0.field655 - var0.angle & 2047;
         if(var4 == 0 && var0.field631) {
            var0.interacting = -1;
            var0.field631 = false;
         }

         if(var4 != 0) {
            ++var0.field603;
            boolean var6;
            if(var4 > 1024) {
               var0.angle -= var0.field657;
               var6 = true;
               if(var4 < var0.field657 || var4 > 2048 - var0.field657) {
                  var0.angle = var0.field655;
                  var6 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field603 > 25 || var6)) {
                  if(var0.field646 != -1) {
                     var0.poseAnimation = var0.field646;
                  } else {
                     var0.poseAnimation = var0.field624;
                  }
               }
            } else {
               var0.angle += var0.field657;
               var6 = true;
               if(var4 < var0.field657 || var4 > 2048 - var0.field657) {
                  var0.angle = var0.field655;
                  var6 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field603 > 25 || var6)) {
                  if(var0.field610 != -1) {
                     var0.poseAnimation = var0.field610;
                  } else {
                     var0.poseAnimation = var0.field624;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field603 = 0;
         }

      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "956223968"
   )
   static final void method1885(Actor var0, int var1) {
      int var8;
      if(var0.field650 > Client.gameCycle) {
         Actor.method585(var0);
      } else if(var0.field651 >= Client.gameCycle) {
         if(Client.gameCycle == var0.field651 || var0.animation == -1 || var0.actionAnimationDisable != 0 || 1 + var0.field639 > class31.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
            var8 = var0.field651 - var0.field650;
            int var3 = Client.gameCycle - var0.field650;
            int var4 = var0.field658 * 128 + var0.field612 * 64;
            int var5 = var0.field612 * 64 + var0.field632 * 128;
            int var6 = var0.field647 * 128 + var0.field612 * 64;
            int var7 = var0.field649 * 128 + var0.field612 * 64;
            var0.x = (var4 * (var8 - var3) + var3 * var6) / var8;
            var0.y = (var3 * var7 + (var8 - var3) * var5) / var8;
         }

         var0.field662 = 0;
         var0.field655 = var0.field652;
         var0.angle = var0.field655;
      } else {
         class118.method2233(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field650 = 0;
         var0.field651 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field612 * 64;
         var0.y = var0.field612 * 64 + var0.pathY[0] * 128;
         var0.method572();
      }

      if(var0 == class5.localPlayer && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field650 = 0;
         var0.field651 = 0;
         var0.x = 128 * var0.pathX[0] + var0.field612 * 64;
         var0.y = var0.field612 * 64 + 128 * var0.pathY[0];
         var0.method572();
      }

      method1883(var0);
      var0.field606 = false;
      Sequence var2;
      if(var0.poseAnimation != -1) {
         var2 = class31.getAnimation(var0.poseAnimation);
         if(null != var2 && null != var2.frameIDs) {
            ++var0.field635;
            if(var0.poseFrame < var2.frameIDs.length && var0.field635 > var2.frameLenghts[var0.poseFrame]) {
               var0.field635 = 1;
               ++var0.poseFrame;
               FileOnDisk.method1404(var2, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var2.frameIDs.length) {
               var0.field635 = 0;
               var0.poseFrame = 0;
               FileOnDisk.method1404(var2, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.field644) {
         if(var0.field642 < 0) {
            var0.field642 = 0;
         }

         var8 = NPCComposition.method3645(var0.graphic).field2803;
         if(var8 != -1) {
            Sequence var9 = class31.getAnimation(var8);
            if(null != var9 && null != var9.frameIDs) {
               ++var0.field664;
               if(var0.field642 < var9.frameIDs.length && var0.field664 > var9.frameLenghts[var0.field642]) {
                  var0.field664 = 1;
                  ++var0.field642;
                  FileOnDisk.method1404(var9, var0.field642, var0.x, var0.y);
               }

               if(var0.field642 >= var9.frameIDs.length && (var0.field642 < 0 || var0.field642 >= var9.frameIDs.length)) {
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
         var2 = class31.getAnimation(var0.animation);
         if(var2.precedenceAnimating == 1 && var0.field663 > 0 && var0.field650 <= Client.gameCycle && var0.field651 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var2 = class31.getAnimation(var0.animation);
         if(null != var2 && null != var2.frameIDs) {
            ++var0.field639;
            if(var0.actionFrame < var2.frameIDs.length && var0.field639 > var2.frameLenghts[var0.actionFrame]) {
               var0.field639 = 1;
               ++var0.actionFrame;
               FileOnDisk.method1404(var2, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var2.frameIDs.length) {
               var0.actionFrame -= var2.frameStep;
               ++var0.field626;
               if(var0.field626 >= var2.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var2.frameIDs.length) {
                  FileOnDisk.method1404(var2, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field606 = var2.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(LWidget;S)V",
      garbageValue = "2189"
   )
   static void method1886(Widget var0) {
      if(Client.field488 == var0.field2339) {
         Client.field308[var0.boundsIndex] = true;
      }

   }
}
