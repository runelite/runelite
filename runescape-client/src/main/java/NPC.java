import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("er")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   static RSSocket field1339;
   @ObfuscatedName("v")
   @Export("colorsToFind")
   public static short[] colorsToFind;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   public static IndexDataBase field1337;
   @ObfuscatedName("ez")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   static Font field1340;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lev;",
      garbageValue = "1458652918"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class40.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && (super.poseAnimation != super.idlePoseAnimation || var1 == null)?class40.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method4627(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2509();
            super.field1239 = var3.modelHeight;
            if(super.graphic != -1 && super.field1227 != -1) {
               Model var4 = class36.getSpotAnimType(super.graphic).method4310(super.field1227);
               if(var4 != null) {
                  var4.method2520(0, -super.field1230, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3535 == 1) {
               var3.field1902 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "2"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IBB)V",
      garbageValue = "111"
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

      if(super.animation != -1 && class40.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var5 = super.queueSize; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field1246[var5] = super.field1246[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field1246[0] = var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "15"
   )
   final void method1697(int var1, int var2, boolean var3) {
      if(super.animation != -1 && class40.getAnimation(super.animation).priority == 1) {
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
               super.field1246[var6] = super.field1246[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field1246[0] = 1;
            return;
         }
      }

      super.queueSize = 0;
      super.field1248 = 0;
      super.field1247 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field1216 * 64 + super.pathX[0] * 128;
      super.y = super.pathY[0] * 128 + super.field1216 * 64;
   }
}
