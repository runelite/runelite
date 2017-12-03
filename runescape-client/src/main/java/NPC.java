import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IBB)V",
      garbageValue = "-20"
   )
   final void method1640(int var1, byte var2) {
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

      if(super.animation != -1 && Permission.getAnimation(super.animation).priority == 1) {
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-1468017787"
   )
   final void method1646(int var1, int var2, boolean var3) {
      if(super.animation != -1 && Permission.getAnimation(super.animation).priority == 1) {
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
      super.field1155 = 0;
      super.field1180 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field1126 * 64 + super.pathX[0] * 128;
      super.y = super.field1126 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lef;",
      garbageValue = "620909653"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?Permission.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || super.idlePoseAnimation == super.poseAnimation && var1 != null?null:Permission.getAnimation(super.poseAnimation);
         Model var3 = this.composition.getModel(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.field1136 = var3.modelHeight;
            if(super.graphic != -1 && super.field1160 != -1) {
               Model var4 = class250.getSpotAnimType(super.graphic).getModel(super.field1160);
               if(var4 != null) {
                  var4.offsetBy(0, -super.field1163, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3620 == 1) {
               var3.field1851 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "591771192"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Liu;IB)V",
      garbageValue = "8"
   )
   static void method1634(IndexData var0, int var1) {
      if(SoundTask.NetCache_reference != null) {
         SoundTask.NetCache_reference.offset = var1 * 8 + 5;
         int var2 = SoundTask.NetCache_reference.readInt();
         int var3 = SoundTask.NetCache_reference.readInt();
         var0.setInformation(var2, var3);
      } else {
         OwnWorldComparator.requestNetFile((IndexData)null, 255, 255, 0, (byte)0, true);
         class249.NetCache_indexCaches[var1] = var0;
      }
   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-698415250"
   )
   static final void method1648() {
      if(VertexNormal.soundSystem1 != null) {
         VertexNormal.soundSystem1.method2003();
      }

      if(class36.soundSystem0 != null) {
         class36.soundSystem0.method2003();
      }

   }
}
