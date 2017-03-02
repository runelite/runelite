import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("b")
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "737121026"
   )
   public static void method778() {
      FloorUnderlayDefinition.field2812.reset();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-8"
   )
   protected final Model getModel() {
      if(null == this.composition) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?XClanMember.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && (super.poseAnimation != super.idlePoseAnimation || null == var1)?XClanMember.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method3805(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method1684();
            super.field609 = var3.modelHeight;
            if(super.graphic != -1 && super.field639 != -1) {
               Model var4 = class160.method3154(super.graphic).method3539(super.field639);
               if(var4 != null) {
                  var4.method1624(0, -super.field642, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3012 == 1) {
               var3.field1360 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "916392693"
   )
   final void method780(int var1, int var2, boolean var3) {
      if(super.animation != -1 && XClanMember.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field655 < 9) {
               ++super.field655;
            }

            for(int var6 = super.field655; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.field658[var6] = super.field658[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field658[0] = 1;
            return;
         }
      }

      super.field655 = 0;
      super.field660 = 0;
      super.field601 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = 128 * super.pathX[0] + super.field634 * 64;
      super.y = 128 * super.pathY[0] + super.field634 * 64;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IBS)V",
      garbageValue = "14479"
   )
   final void method789(int var1, byte var2) {
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

      if(super.animation != -1 && XClanMember.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(super.field655 < 9) {
         ++super.field655;
      }

      for(int var5 = super.field655; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field658[var5] = super.field658[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field658[0] = var2;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "686840496"
   )
   static final void method794() {
      for(int var0 = 0; var0 < Client.field323; ++var0) {
         int var1 = Client.field324[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(var2 != null) {
            class5.method83(var2, var2.composition.field3012);
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-274573938"
   )
   final boolean vmethod795() {
      return null != this.composition;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-1206081215"
   )
   public static int method796(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + Varbit.method3627(var0.charAt(var3));
      }

      return var2;
   }
}
