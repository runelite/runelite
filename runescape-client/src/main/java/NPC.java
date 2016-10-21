import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("f")
   @Export("composition")
   NPCComposition composition;
   @ObfuscatedName("gj")
   static Widget field787;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 919436235
   )
   static int field788;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "-2000458418"
   )
   final void method740(int var1, byte var2) {
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

      if(super.animation != -1 && class62.getAnimation(super.animation).field997 == 1) {
         super.animation = -1;
      }

      if(super.field867 < 9) {
         ++super.field867;
      }

      for(int var5 = super.field867; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field857[var5] = super.field857[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field857[0] = var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "1759093458"
   )
   final void method741(int var1, int var2, boolean var3) {
      if(super.animation != -1 && class62.getAnimation(super.animation).field997 == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field867 < 9) {
               ++super.field867;
            }

            for(int var6 = super.field867; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.field857[var6] = super.field857[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field857[0] = 1;
            return;
         }
      }

      super.field867 = 0;
      super.field875 = 0;
      super.field872 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.pathX[0] * 128 + super.field842 * 64;
      super.y = 128 * super.pathY[0] + super.field842 * 64;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)[Lclass85;",
      garbageValue = "796929935"
   )
   public static class85[] method742() {
      return new class85[]{class85.field1486, class85.field1483, class85.field1479, class85.field1485, class85.field1482};
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1315988205"
   )
   final boolean vmethod787() {
      return this.composition != null;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "3"
   )
   protected final Model getModel() {
      if(null == this.composition) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class62.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || super.idlePoseAnimation == super.poseAnimation && var1 != null?null:class62.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method796(var1, super.actionFrame, var2, super.poseFrame);
         if(null == var3) {
            return null;
         } else {
            var3.method2377();
            super.field839 = var3.modelHeight;
            if(super.graphic != -1 && super.field835 != -1) {
               Model var4 = GameEngine.method3084(super.graphic).method921(super.field835);
               if(var4 != null) {
                  var4.method2337(0, -super.field860, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field894 == 1) {
               var3.field1915 = true;
            }

            return var3;
         }
      }
   }
}
