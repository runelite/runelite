import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
@Implements("BoundingBox")
public abstract class BoundingBox extends Node {
   @ObfuscatedName("om")
   static boolean field249;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 786855509
   )
   static int field253;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 1779836391
   )
   static int field251;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "45976309"
   )
   public abstract void vmethod46();

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "0"
   )
   static int method41(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(Lba;B)V",
      garbageValue = "0"
   )
   static final void method44(Actor var0) {
      var0.field1159 = false;
      Sequence var1;
      if(var0.poseAnimation != -1) {
         var1 = CombatInfo1.getAnimation(var0.poseAnimation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.poseFrameCycle;
            if(var0.poseFrame < var1.frameIDs.length && var0.poseFrameCycle > var1.frameLengths[var0.poseFrame]) {
               var0.poseFrameCycle = 1;
               ++var0.poseFrame;
               class278.queueAnimationSound(var1, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var1.frameIDs.length) {
               var0.poseFrameCycle = 0;
               var0.poseFrame = 0;
               class278.queueAnimationSound(var1, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.graphicsDelay) {
         if(var0.spotAnimFrame < 0) {
            var0.spotAnimFrame = 0;
         }

         int var3 = class86.getSpotAnimType(var0.graphic).field3497;
         if(var3 != -1) {
            Sequence var2 = CombatInfo1.getAnimation(var3);
            if(var2 != null && var2.frameIDs != null) {
               ++var0.spotAnimFrameCycle;
               if(var0.spotAnimFrame < var2.frameIDs.length && var0.spotAnimFrameCycle > var2.frameLengths[var0.spotAnimFrame]) {
                  var0.spotAnimFrameCycle = 1;
                  ++var0.spotAnimFrame;
                  class278.queueAnimationSound(var2, var0.spotAnimFrame, var0.x, var0.y);
               }

               if(var0.spotAnimFrame >= var2.frameIDs.length && (var0.spotAnimFrame < 0 || var0.spotAnimFrame >= var2.frameIDs.length)) {
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
         var1 = CombatInfo1.getAnimation(var0.animation);
         if(var1.precedenceAnimating == 1 && var0.field1216 > 0 && var0.field1166 <= Client.gameCycle && var0.field1204 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var1 = CombatInfo1.getAnimation(var0.animation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.actionFrameCycle;
            if(var0.actionFrame < var1.frameIDs.length && var0.actionFrameCycle > var1.frameLengths[var0.actionFrame]) {
               var0.actionFrameCycle = 1;
               ++var0.actionFrame;
               class278.queueAnimationSound(var1, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var1.frameIDs.length) {
               var0.actionFrame -= var1.frameStep;
               ++var0.field1193;
               if(var0.field1193 >= var1.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var1.frameIDs.length) {
                  class278.queueAnimationSound(var1, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field1159 = var1.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1868318865"
   )
   static final void method45(int var0) {
      if(class189.loadWidget(var0)) {
         Widget[] var1 = MouseRecorder.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2935 = 0;
               var3.field2945 = 0;
            }
         }

      }
   }
}
