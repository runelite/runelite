import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1834199369
   )
   static int field1290;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljg;"
   )
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "-335025159"
   )
   final void method1870(int var1, byte var2) {
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

      if(super.animation != -1 && class270.getAnimation(super.animation).priority == 1) {
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "-16"
   )
   final void method1866(int var1, int var2, boolean var3) {
      if(super.animation != -1 && class270.getAnimation(super.animation).priority == 1) {
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
      super.field1198 = 0;
      super.field1197 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field1193 * 64 + super.pathX[0] * 128;
      super.y = super.field1193 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lel;",
      garbageValue = "2099798459"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class270.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && (super.idlePoseAnimation != super.poseAnimation || var1 == null)?class270.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.getModel(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.logicalHeight = var3.modelHeight;
            if(super.graphic != -1 && super.field1177 != -1) {
               Model var4 = class55.getSpotAnimType(super.graphic).getModel(super.field1177);
               if(var4 != null) {
                  var4.offsetBy(0, -super.field1157, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3709 == 1) {
               var3.field1859 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "123425433"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-809701568"
   )
   static final void method1878(int var0) {
      short var1 = 256;
      class90.field1347 += var0 * 128;
      int var2;
      if(class90.field1347 > TotalQuantityComparator.field299.length) {
         class90.field1347 -= TotalQuantityComparator.field299.length;
         var2 = (int)(Math.random() * 12.0D);
         class138.method3120(class90.runeSprites[var2]);
      }

      var2 = 0;
      int var3 = var0 * 128;
      int var4 = (var1 - var0) * 128;

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = class1.field11[var3 + var2] - TotalQuantityComparator.field299[var2 + class90.field1347 & TotalQuantityComparator.field299.length - 1] * var0 / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         class1.field11[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = var5 * 128;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               class1.field11[var7 + var6] = 255;
            } else {
               class1.field11[var6 + var7] = 0;
            }
         }
      }

      if(class90.field1345 > 0) {
         class90.field1345 -= var0 * 4;
      }

      if(class90.field1346 > 0) {
         class90.field1346 -= var0 * 4;
      }

      if(class90.field1345 == 0 && class90.field1346 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class90.field1345 = 1024;
         }

         if(var5 == 1) {
            class90.field1346 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class90.field1344[var5] = class90.field1344[var0 + var5];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class90.field1344[var5] = (int)(Math.sin((double)class90.field1350 / 14.0D) * 16.0D + Math.sin((double)class90.field1350 / 15.0D) * 14.0D + Math.sin((double)class90.field1350 / 16.0D) * 12.0D);
         ++class90.field1350;
      }

      class90.field1352 += var0;
      var5 = (var0 + (Client.gameCycle & 1)) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class90.field1352 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            class1.field11[var7 + (var8 << 7)] = 192;
         }

         class90.field1352 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var5 + var9 < 128) {
                  var7 += class1.field11[var5 + var8 + var9];
               }

               if(var9 - (var5 + 1) >= 0) {
                  var7 -= class1.field11[var8 + var9 - (var5 + 1)];
               }

               if(var9 >= 0) {
                  class308.field3866[var8 + var9] = var7 / (var5 * 2 + 1);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = var8 * 128;
               if(var5 + var8 < var1) {
                  var7 += class308.field3866[var5 * 128 + var9 + var6];
               }

               if(var8 - (var5 + 1) >= 0) {
                  var7 -= class308.field3866[var9 + var6 - (var5 + 1) * 128];
               }

               if(var8 >= 0) {
                  class1.field11[var6 + var9] = var7 / (var5 * 2 + 1);
               }
            }
         }
      }

   }
}
