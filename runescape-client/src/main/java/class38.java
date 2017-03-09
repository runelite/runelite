import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class38 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1178134225
   )
   int field822;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1308363655
   )
   int field823;
   @ObfuscatedName("w")
   String field825;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1011784871
   )
   int field830;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1799779351
   )
   int field831;

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1864990935"
   )
   static final void method811(int var0) {
      if(class44.method892(var0)) {
         class6.method92(Widget.widgets[var0], -1);
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(LActor;B)V",
      garbageValue = "40"
   )
   static final void method812(Actor var0) {
      var0.field628 = false;
      Sequence var1;
      if(var0.poseAnimation != -1) {
         var1 = class168.getAnimation(var0.poseAnimation);
         if(null != var1 && null != var1.frameIDs) {
            ++var0.field656;
            if(var0.poseFrame < var1.frameIDs.length && var0.field656 > var1.frameLenghts[var0.poseFrame]) {
               var0.field656 = 1;
               ++var0.poseFrame;
               class149.method2796(var1, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var1.frameIDs.length) {
               var0.field656 = 0;
               var0.poseFrame = 0;
               class149.method2796(var1, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.field665) {
         if(var0.field662 < 0) {
            var0.field662 = 0;
         }

         int var3 = Widget.method3245(var0.graphic).field2792;
         if(var3 != -1) {
            Sequence var2 = class168.getAnimation(var3);
            if(var2 != null && null != var2.frameIDs) {
               ++var0.field664;
               if(var0.field662 < var2.frameIDs.length && var0.field664 > var2.frameLenghts[var0.field662]) {
                  var0.field664 = 1;
                  ++var0.field662;
                  class149.method2796(var2, var0.field662, var0.x, var0.y);
               }

               if(var0.field662 >= var2.frameIDs.length && (var0.field662 < 0 || var0.field662 >= var2.frameIDs.length)) {
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
         var1 = class168.getAnimation(var0.animation);
         if(var1.precedenceAnimating == 1 && var0.field636 > 0 && var0.field671 <= Client.gameCycle && var0.field647 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var1 = class168.getAnimation(var0.animation);
         if(var1 != null && null != var1.frameIDs) {
            ++var0.field659;
            if(var0.actionFrame < var1.frameIDs.length && var0.field659 > var1.frameLenghts[var0.actionFrame]) {
               var0.field659 = 1;
               ++var0.actionFrame;
               class149.method2796(var1, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var1.frameIDs.length) {
               var0.actionFrame -= var1.frameStep;
               ++var0.field629;
               if(var0.field629 >= var1.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var1.frameIDs.length) {
                  class149.method2796(var1, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field628 = var1.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BZB)Ljava/lang/Object;",
      garbageValue = "-27"
   )
   public static Object method813(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class156.field2106) {
            try {
               class151 var2 = new class151();
               var2.vmethod3049(var0);
               return var2;
            } catch (Throwable var3) {
               class156.field2106 = true;
            }
         }

         return var0;
      }
   }
}
