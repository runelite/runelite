import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("h")
   static int[] field1379;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Lem;",
      garbageValue = "-1455933636"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class216.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && (super.poseAnimation != super.idlePoseAnimation || var1 == null)?class216.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method4619(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2515();
            super.field1279 = var3.modelHeight;
            if(super.graphic != -1 && super.field1267 != -1) {
               Model var4 = class15.getSpotAnimType(super.graphic).method4339(super.field1267);
               if(var4 != null) {
                  var4.method2526(0, -super.field1270, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3574 == 1) {
               var3.field1957 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-13887992"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "-797659210"
   )
   final void method1696(int var1, byte var2) {
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

      if(super.animation != -1 && class216.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var5 = super.queueSize; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field1286[var5] = super.field1286[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field1286[0] = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "0"
   )
   final void method1704(int var1, int var2, boolean var3) {
      if(super.animation != -1 && class216.getAnimation(super.animation).priority == 1) {
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
               super.field1286[var6] = super.field1286[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field1286[0] = 1;
            return;
         }
      }

      super.queueSize = 0;
      super.field1249 = 0;
      super.field1287 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.pathX[0] * 128 + super.field1233 * 64;
      super.y = super.field1233 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("i")
   public static final void method1702(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            MilliTimer.method2988(var0 - 1L);
            MilliTimer.method2988(1L);
         } else {
            MilliTimer.method2988(var0);
         }

      }
   }
}
