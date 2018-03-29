import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "-1919876101"
   )
   final void method1825(int var1, byte var2) {
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

      if(super.animation != -1 && ISAACCipher.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var5 = super.queueSize; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.pathTraversed[var5] = super.pathTraversed[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.pathTraversed[0] = var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "1641490636"
   )
   final void method1827(int var1, int var2, boolean var3) {
      if(super.animation != -1 && ISAACCipher.getAnimation(super.animation).priority == 1) {
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
               super.pathTraversed[var6] = super.pathTraversed[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.pathTraversed[0] = 1;
            return;
         }
      }

      super.queueSize = 0;
      super.field1194 = 0;
      super.field1208 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field1153 * 64 + super.pathX[0] * 128;
      super.y = super.field1153 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Led;",
      garbageValue = "-83"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?ISAACCipher.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && (super.idlePoseAnimation != super.poseAnimation || var1 == null)?ISAACCipher.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.getModel(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.logicalHeight = var3.modelHeight;
            if(super.graphic != -1 && super.spotAnimFrame != -1) {
               Model var4 = class249.getSpotAnimType(super.graphic).getModel(super.spotAnimFrame);
               if(var4 != null) {
                  var4.offsetBy(0, -super.field1191, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3702 == 1) {
               var3.field1850 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1859897197"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(BI)C",
      garbageValue = "41649249"
   )
   public static char method1838(byte var0) {
      int var1 = var0 & 255;
      if(var1 == 0) {
         throw new IllegalArgumentException("");
      } else {
         if(var1 >= 128 && var1 < 160) {
            char var2 = class314.cp1252AsciiExtension[var1 - 128];
            if(var2 == 0) {
               var2 = '?';
            }

            var1 = var2;
         }

         return (char)var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-82"
   )
   static final void method1839(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class62.field725[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5 - 1][var4];
               }

               if(var0 + var2 == var5 && var5 < 103) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }
}
