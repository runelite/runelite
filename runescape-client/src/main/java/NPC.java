import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("k")
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "637530507"
   )
   protected final Model getModel() {
      if(null == this.composition) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?TextureProvider.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && (super.poseAnimation != super.idlePoseAnimation || null == var1)?TextureProvider.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method3703(var1, super.actionFrame, var2, super.poseFrame);
         if(null == var3) {
            return null;
         } else {
            var3.method1568();
            super.field592 = var3.modelHeight;
            if(super.graphic != -1 && super.field647 != -1) {
               Model var4 = XItemContainer.method187(super.graphic).method3458(super.field647);
               if(null != var4) {
                  var4.method1578(0, -super.field631, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field2987 == 1) {
               var3.field1378 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "53"
   )
   final void method735(int var1, int var2, boolean var3) {
      if(super.animation != -1 && TextureProvider.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field644 < 9) {
               ++super.field644;
            }

            for(int var6 = super.field644; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.field594[var6] = super.field594[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field594[0] = 1;
            return;
         }
      }

      super.field644 = 0;
      super.field645 = 0;
      super.field638 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field597 * 64 + 128 * super.pathX[0];
      super.y = 128 * super.pathY[0] + super.field597 * 64;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1115393607"
   )
   final boolean vmethod736() {
      return this.composition != null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "1694275859"
   )
   final void method742(int var1, byte var2) {
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

      if(super.animation != -1 && TextureProvider.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(super.field644 < 9) {
         ++super.field644;
      }

      for(int var5 = super.field644; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field594[var5] = super.field594[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field594[0] = var2;
   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-842045567"
   )
   static final boolean method747(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field331 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field551.method2760(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field551.method2735(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field551.method2736(false);
         }

         if(var1 == 325) {
            Client.field551.method2736(true);
         }

         if(var1 == 326) {
            Client.field321.method3195(215);
            Client.field551.method2743(Client.field321);
            return true;
         } else {
            return false;
         }
      }
   }
}
