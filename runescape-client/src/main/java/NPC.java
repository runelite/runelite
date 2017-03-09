import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("j")
   @Export("validInterfaces")
   public static boolean[] validInterfaces;
   @ObfuscatedName("x")
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)LModel;",
      garbageValue = "-10054"
   )
   protected final Model getModel() {
      if(null == this.composition) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class168.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || super.idlePoseAnimation == super.poseAnimation && var1 != null?null:class168.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3708(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method1617();
            super.field654 = var3.modelHeight;
            if(super.graphic != -1 && super.field662 != -1) {
               Model var4 = Widget.method3245(super.graphic).method3474(super.field662);
               if(var4 != null) {
                  var4.method1630(0, -super.field666, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3008 == 1) {
               var3.field1390 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "1917932657"
   )
   final void method779(int var1, byte var2) {
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

      if(super.animation != -1 && class168.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(super.field679 < 9) {
         ++super.field679;
      }

      for(int var5 = super.field679; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field682[var5] = super.field682[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field682[0] = var2;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-107"
   )
   final boolean vmethod782() {
      return this.composition != null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "783293339"
   )
   final void method783(int var1, int var2, boolean var3) {
      if(super.animation != -1 && class168.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field679 < 9) {
               ++super.field679;
            }

            for(int var6 = super.field679; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.field682[var6] = super.field682[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field682[0] = 1;
            return;
         }
      }

      super.field679 = 0;
      super.field636 = 0;
      super.field683 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field672 * 64 + 128 * super.pathX[0];
      super.y = super.field672 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(LWidget;IIIIIII)V",
      garbageValue = "1001961934"
   )
   static final void method794(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field394) {
         Client.field395 = 32;
      } else {
         Client.field395 = 0;
      }

      Client.field394 = false;
      int var7;
      if(class115.field1806 == 1 || !class202.field3076 && class115.field1806 == 4) {
         if(var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < 16 + var2) {
            var0.scrollY -= 4;
            class2.method36(var0);
         } else if(var5 >= var1 && var5 < 16 + var1 && var6 >= var3 + var2 - 16 && var6 < var2 + var3) {
            var0.scrollY += 4;
            class2.method36(var0);
         } else if(var5 >= var1 - Client.field395 && var5 < 16 + var1 + Client.field395 && var6 >= 16 + var2 && var6 < var2 + var3 - 16) {
            var7 = (var3 - 32) * var3 / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = (var4 - var3) * var8 / var9;
            class2.method36(var0);
            Client.field394 = true;
         }
      }

      if(Client.field511 != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < 16 + var1 && var6 <= var2 + var3) {
            var0.scrollY += Client.field511 * 45;
            class2.method36(var0);
         }
      }

   }
}
