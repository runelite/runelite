import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IBS)V",
      garbageValue = "19748"
   )
   final void method1820(int var1, byte var2) {
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

      if(super.animation != -1 && CacheFile.getAnimation(super.animation).priority == 1) {
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
      garbageValue = "-2007777583"
   )
   final void method1821(int var1, int var2, boolean var3) {
      if(super.animation != -1 && CacheFile.getAnimation(super.animation).priority == 1) {
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
      super.field1156 = 0;
      super.field1136 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field1127 * 64 + super.pathX[0] * 128;
      super.y = super.field1127 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Len;",
      garbageValue = "-2096748380"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?CacheFile.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && (super.idlePoseAnimation != super.poseAnimation || var1 == null)?CacheFile.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.getModel(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.logicalHeight = var3.modelHeight;
            if(super.graphic != -1 && super.field1135 != -1) {
               Model var4 = GrandExchangeEvents.getSpotAnimType(super.graphic).getModel(super.field1135);
               if(var4 != null) {
                  var4.offsetBy(0, -super.field1138, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3611 == 1) {
               var3.field1825 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1872154705"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "14"
   )
   static char method1833(char var0) {
      return (char)(var0 == 198?69:(var0 == 230?101:(var0 == 223?115:(var0 == 338?69:(var0 == 339?'e':'\u0000')))));
   }
}
