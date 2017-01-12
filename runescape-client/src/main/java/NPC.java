import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("i")
   static class182 field758;
   @ObfuscatedName("f")
   static ModIcon[] field759;
   @ObfuscatedName("u")
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIZS)V",
      garbageValue = "-22630"
   )
   final void method715(int var1, int var2, boolean var3) {
      if(super.animation != -1 && CombatInfo2.getAnimation(super.animation).priority == 1) {
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
               super.field656[var6] = super.field656[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field656[0] = 1;
            return;
         }
      }

      super.field653 = 0;
      super.field658 = 0;
      super.field657 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field603 * 64 + 128 * super.pathX[0];
      super.y = super.field603 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1734693659"
   )
   final boolean vmethod718() {
      return this.composition != null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "25"
   )
   protected final Model getModel() {
      if(null == this.composition) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?CombatInfo2.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || super.idlePoseAnimation == super.poseAnimation && var1 != null?null:CombatInfo2.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3701(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method1532();
            super.field649 = var3.modelHeight;
            if(super.graphic != -1 && super.field634 != -1) {
               Model var4 = class185.method3389(super.graphic).method3446(super.field634);
               if(null != var4) {
                  var4.method1550(0, -super.field640, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3007 == 1) {
               var3.field1381 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "-2095781558"
   )
   final void method725(int var1, byte var2) {
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

      if(super.animation != -1 && CombatInfo2.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(super.field653 < 9) {
         ++super.field653;
      }

      for(int var5 = super.field653; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field656[var5] = super.field656[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field656[0] = var2;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1017735531"
   )
   static final void method727() {
      for(class33 var0 = (class33)Client.field405.method2391(); null != var0; var0 = (class33)Client.field405.method2393()) {
         if(class60.plane == var0.field735 && !var0.field742) {
            if(Client.gameCycle >= var0.field733) {
               var0.method693(Client.field462);
               if(var0.field742) {
                  var0.unlink();
               } else {
                  class6.region.method1686(var0.field735, var0.field736, var0.field737, var0.field738, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZZB)I",
      garbageValue = "3"
   )
   public static int method728(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + class185.field2741 + class185.field2725;
      return var3;
   }
}
