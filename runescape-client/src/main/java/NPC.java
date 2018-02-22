import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "-256143225"
   )
   final void method1834(int var1, byte var2) {
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

      if(super.animation != -1 && Occluder.getAnimation(super.animation).priority == 1) {
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-85858035"
   )
   final void method1835(int var1, int var2, boolean var3) {
      if(super.animation != -1 && Occluder.getAnimation(super.animation).priority == 1) {
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
      super.field1153 = 0;
      super.field1128 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field1098 * 64 + super.pathX[0] * 128;
      super.y = super.field1098 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lee;",
      garbageValue = "582025400"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?Occluder.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && (super.idlePoseAnimation != super.poseAnimation || var1 == null)?Occluder.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.getModel(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.logicalHeight = var3.modelHeight;
            if(super.graphic != -1 && super.field1104 != -1) {
               Model var4 = IndexFile.getSpotAnimType(super.graphic).getModel(super.field1104);
               if(var4 != null) {
                  var4.offsetBy(0, -super.field1135, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3661 == 1) {
               var3.field1827 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "51"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Ljs;",
      garbageValue = "-3431467"
   )
   public static class274 method1847(int var0) {
      class274 var1 = (class274)class274.field3498.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class274.field3515.getConfigData(32, var0);
         var1 = new class274();
         if(var2 != null) {
            var1.method4918(new Buffer(var2));
         }

         class274.field3498.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-78023149"
   )
   static void method1846() {
      if(class89.Login_isUsernameRemembered && class89.username != null && class89.username.length() > 0) {
         class89.field1331 = 1;
      } else {
         class89.field1331 = 0;
      }

   }
}
