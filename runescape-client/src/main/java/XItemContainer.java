import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("d")
   @Export("itemIds")
   int[] itemIds = new int[]{-1};
   @ObfuscatedName("m")
   @Export("stackSizes")
   int[] stackSizes = new int[]{0};
   @ObfuscatedName("n")
   @Export("itemContainers")
   static XHashTable itemContainers = new XHashTable(32);
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = -360226857
   )
   static int field125;
   @ObfuscatedName("np")
   @ObfuscatedGetter(
      intValue = 1382850311
   )
   static int field128;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-79"
   )
   static final void method179() {
      class138.method2547();
      class191.field2811.reset();
      KitDefinition.field2821.reset();
      ObjectComposition.field2902.reset();
      ObjectComposition.field2904.reset();
      ObjectComposition.field2890.reset();
      ObjectComposition.field2896.reset();
      class41.method786();
      ItemComposition.field2945.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
      Sequence.field3045.reset();
      Sequence.field3046.reset();
      class39.method774();
      Actor.method631();
      class187.field2774.reset();
      WallObject.method1922();
      RSCanvas.method2131();
      class45.method844();
      class11.method160();
      ((TextureProvider)class84.field1441).method1465();
      class48.field936.reset();
      class139.field1952.method3342();
      class186.field2766.method3342();
      class172.field2363.method3342();
      PlayerComposition.field2036.method3342();
      Client.field413.method3342();
      class34.field746.method3342();
      ItemLayer.field1202.method3342();
      class156.field2240.method3342();
      class189.field2788.method3342();
      Client.field317.method3342();
      Client.field332.method3342();
      XClanMember.field275.method3342();
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "1550116856"
   )
   static final void method180(Actor var0) {
      var0.field598 = false;
      Sequence var1;
      if(var0.poseAnimation != -1) {
         var1 = class9.getAnimation(var0.poseAnimation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.field626;
            if(var0.poseFrame < var1.frameIDs.length && var0.field626 > var1.frameLenghts[var0.poseFrame]) {
               var0.field626 = 1;
               ++var0.poseFrame;
               class16.method200(var1, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var1.frameIDs.length) {
               var0.field626 = 0;
               var0.poseFrame = 0;
               class16.method200(var1, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.field608) {
         if(var0.field633 < 0) {
            var0.field633 = 0;
         }

         int var3 = class179.method3320(var0.graphic).field2800;
         if(var3 != -1) {
            Sequence var2 = class9.getAnimation(var3);
            if(null != var2 && null != var2.frameIDs) {
               ++var0.field616;
               if(var0.field633 < var2.frameIDs.length && var0.field616 > var2.frameLenghts[var0.field633]) {
                  var0.field616 = 1;
                  ++var0.field633;
                  class16.method200(var2, var0.field633, var0.x, var0.y);
               }

               if(var0.field633 >= var2.frameIDs.length && (var0.field633 < 0 || var0.field633 >= var2.frameIDs.length)) {
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
         var1 = class9.getAnimation(var0.animation);
         if(var1.precedenceAnimating == 1 && var0.field654 > 0 && var0.field648 <= Client.gameCycle && var0.field642 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var1 = class9.getAnimation(var0.animation);
         if(null != var1 && null != var1.frameIDs) {
            ++var0.field595;
            if(var0.actionFrame < var1.frameIDs.length && var0.field595 > var1.frameLenghts[var0.actionFrame]) {
               var0.field595 = 1;
               ++var0.actionFrame;
               class16.method200(var1, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var1.frameIDs.length) {
               var0.actionFrame -= var1.frameStep;
               ++var0.field631;
               if(var0.field631 >= var1.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var1.frameIDs.length) {
                  class16.method200(var1, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field598 = var1.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1110940106"
   )
   static final void method181(int var0, int var1) {
      if(class60.method1127(var0)) {
         class15.method191(Widget.widgets[var0], var1);
      }
   }
}
