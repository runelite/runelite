import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("l")
   static class232 field757;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = -1476087781
   )
   static int field760;
   @ObfuscatedName("d")
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "1686577468"
   )
   final void method734(int var1, int var2, boolean var3) {
      if(super.animation != -1 && NPCComposition.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field653 < 9) {
               ++super.field653;
            }

            for(int var6 = super.field653; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.field618[var6] = super.field618[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field618[0] = 1;
            return;
         }
      }

      super.field653 = 0;
      super.field658 = 0;
      super.field657 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field603 * 64 + super.pathX[0] * 128;
      super.y = super.pathY[0] * 128 + super.field603 * 64;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IBB)V",
      garbageValue = "-20"
   )
   final void method735(int var1, byte var2) {
      int var3 = super.pathX[0];
      int var4 = super.pathY[0];
      if(var1 == 0) {
         --var3;
         ++var4;
      }

      if(var1 == 1) {
         ++var4;
      }

      if(var1 == 2) {
         ++var3;
         ++var4;
      }

      if(var1 == 3) {
         --var3;
      }

      if(var1 == 4) {
         ++var3;
      }

      if(var1 == 5) {
         --var3;
         --var4;
      }

      if(var1 == 6) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(super.animation != -1 && NPCComposition.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(super.field653 < 9) {
         ++super.field653;
      }

      for(int var5 = super.field653; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field618[var5] = super.field618[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field618[0] = var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-18"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?NPCComposition.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || super.idlePoseAnimation == super.poseAnimation && var1 != null?null:NPCComposition.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3813(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method1574();
            super.field607 = var3.modelHeight;
            if(super.graphic != -1 && super.field637 != -1) {
               Model var4 = class190.method3462(super.graphic).method3478(super.field637);
               if(var4 != null) {
                  var4.method1584(0, -super.field622, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3042 == 1) {
               var3.field1370 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "225621132"
   )
   final boolean vmethod737() {
      return this.composition != null;
   }
}
