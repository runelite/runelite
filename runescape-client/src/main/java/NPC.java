import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "-1269137902"
   )
   final void method1742(int var1, byte var2) {
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

      if(super.animation != -1 && class13.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var5 = super.queueSize; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field1203[var5] = super.field1203[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field1203[0] = var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "1971703670"
   )
   final void method1738(int var1, int var2, boolean var3) {
      if(super.animation != -1 && class13.getAnimation(super.animation).priority == 1) {
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
               super.field1203[var6] = super.field1203[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field1203[0] = 1;
            return;
         }
      }

      super.queueSize = 0;
      super.field1159 = 0;
      super.field1204 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field1147 * 64 + super.pathX[0] * 128;
      super.y = super.field1147 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Leh;",
      garbageValue = "-473112722"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class13.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && (super.idlePoseAnimation != super.poseAnimation || var1 == null)?class13.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method4827(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2623();
            super.field1179 = var3.modelHeight;
            if(super.graphic != -1 && super.field1184 != -1) {
               Model var4 = class227.getSpotAnimType(super.graphic).method4494(super.field1184);
               if(var4 != null) {
                  var4.method2635(0, -super.field1187, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3619 == 1) {
               var3.field1855 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "120"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "14"
   )
   static void method1749(String var0, String var1, String var2) {
      class91.loginMessage1 = var0;
      class91.loginMessage2 = var1;
      class91.loginMessage3 = var2;
   }
}
