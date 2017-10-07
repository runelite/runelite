import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Leb;",
      garbageValue = "1172124455"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class204.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && (super.poseAnimation != super.idlePoseAnimation || var1 == null)?class204.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method4727(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2594();
            super.field1257 = var3.modelHeight;
            if(super.graphic != -1 && super.field1249 != -1) {
               Model var4 = class155.getSpotAnimType(super.graphic).method4436(super.field1249);
               if(var4 != null) {
                  var4.method2665(0, -super.field1214, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3559 == 1) {
               var3.field1938 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1832994201"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IBB)V",
      garbageValue = "-20"
   )
   final void method1753(int var1, byte var2) {
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

      if(super.animation != -1 && class204.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var5 = super.queueSize; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field1264[var5] = super.field1264[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field1264[0] = var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "117"
   )
   final void method1754(int var1, int var2, boolean var3) {
      if(super.animation != -1 && class204.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.queueSize < 9) {
               ++super.queueSize;
            }

            for(int var6 = super.queueSize; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.field1264[var6] = super.field1264[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field1264[0] = 1;
            return;
         }
      }

      super.queueSize = 0;
      super.field1241 = 0;
      super.field1251 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field1211 * 64 + super.pathX[0] * 128;
      super.y = super.pathY[0] * 128 + super.field1211 * 64;
   }
}
