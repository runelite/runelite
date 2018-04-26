import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "273102965"
   )
   final void method1940(int var1, byte var2) {
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

      if(super.animation != -1 && getAnimation(super.animation).priority == 1) {
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "80"
   )
   final void method1941(int var1, int var2, boolean var3) {
      if(super.animation != -1 && getAnimation(super.animation).priority == 1) {
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
      super.field1178 = 0;
      super.field1192 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field1143 * 64 + super.pathX[0] * 128;
      super.y = super.field1143 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lee;",
      garbageValue = "-1967116980"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && (super.idlePoseAnimation != super.poseAnimation || var1 == null)?getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.getModel(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.logicalHeight = var3.modelHeight;
            if(super.graphic != -1 && super.spotAnimFrame != -1) {
               Model var4 = WidgetNode.getSpotAnimType(super.graphic).getModel(super.spotAnimFrame);
               if(var4 != null) {
                  var4.offsetBy(0, -super.field1187, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.size == 1) {
               var3.field1847 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "14"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljr;Ljr;ZLkh;I)V",
      garbageValue = "-1069427600"
   )
   public static void method1950(IndexDataBase var0, IndexDataBase var1, boolean var2, Font var3) {
      ItemComposition.item_ref = var0;
      Frames.ItemDefinition_modelIndexCache = var1;
      ItemComposition.isMembersWorld = var2;
      ItemComposition.field3643 = ItemComposition.item_ref.fileCount(10);
      ItemComposition.field3652 = var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Lkc;",
      garbageValue = "88"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.sequences.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.seq_ref.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         Sequence.sequences.put(var1, (long)var0);
         return var1;
      }
   }
}
