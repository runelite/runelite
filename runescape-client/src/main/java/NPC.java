import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = -1803554751
   )
   static int field764;
   @ObfuscatedName("s")
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IBB)V",
      garbageValue = "53"
   )
   final void method734(int var1, byte var2) {
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

      if(super.animation != -1 && class4.getAnimation(super.animation).field980 == 1) {
         super.animation = -1;
      }

      if(super.field855 < 9) {
         ++super.field855;
      }

      for(int var5 = super.field855; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field858[var5] = super.field858[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field858[0] = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "909472363"
   )
   final boolean vmethod767() {
      return null != this.composition;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-26"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class4.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || super.poseAnimation == super.idlePoseAnimation && var1 != null?null:class4.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method788(var1, super.actionFrame, var2, super.poseFrame);
         if(null == var3) {
            return null;
         } else {
            var3.method2275();
            super.field851 = var3.modelHeight;
            if(super.graphic != -1 && super.field811 != -1) {
               Model var4 = class107.method2269(super.graphic).method915(super.field811);
               if(null != var4) {
                  var4.method2280(0, -super.field839, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field902 == 1) {
               var3.field1864 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "94"
   )
   final void method744(int var1, int var2, boolean var3) {
      if(super.animation != -1 && class4.getAnimation(super.animation).field980 == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field855 < 9) {
               ++super.field855;
            }

            for(int var6 = super.field855; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.field858[var6] = super.field858[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field858[0] = 1;
            return;
         }
      }

      super.field855 = 0;
      super.field821 = 0;
      super.field859 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.pathX[0] * 128 + super.field805 * 64;
      super.y = super.pathY[0] * 128 + super.field805 * 64;
   }
}
