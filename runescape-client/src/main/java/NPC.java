import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("n")
   @Export("composition")
   NPCComposition composition;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = -1809960847
   )
   static int field757;
   @ObfuscatedName("g")
   static class179 field758;
   @ObfuscatedName("y")
   public static class60 field760;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IBS)V",
      garbageValue = "19445"
   )
   final void method734(int var1, byte var2) {
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

      if(super.animation != -1 && class9.getAnimation(super.animation).field3062 == 1) {
         super.animation = -1;
      }

      if(super.field649 < 9) {
         ++super.field649;
      }

      for(int var5 = super.field649; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field625[var5] = super.field625[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field625[0] = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "1672156994"
   )
   protected final Model getModel() {
      if(null == this.composition) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class9.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || super.poseAnimation == super.idlePoseAnimation && var1 != null?null:class9.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3756(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method1584();
            super.field621 = var3.modelHeight;
            if(super.graphic != -1 && super.field633 != -1) {
               Model var4 = class179.method3320(super.graphic).method3510(super.field633);
               if(var4 != null) {
                  var4.method1588(0, -super.field636, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3009 == 1) {
               var3.field1399 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "7"
   )
   final void method738(int var1, int var2, boolean var3) {
      if(super.animation != -1 && class9.getAnimation(super.animation).field3062 == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field649 < 9) {
               ++super.field649;
            }

            for(int var6 = super.field649; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.field625[var6] = super.field625[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field625[0] = 1;
            return;
         }
      }

      super.field649 = 0;
      super.field654 = 0;
      super.field634 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field599 * 64 + 128 * super.pathX[0];
      super.y = super.field599 * 64 + 128 * super.pathY[0];
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1389298352"
   )
   final boolean vmethod746() {
      return null != this.composition;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "4"
   )
   public static final boolean method748() {
      class105 var0 = class105.keyboard;
      synchronized(class105.keyboard) {
         if(class105.field1699 == class105.field1696) {
            return false;
         } else {
            class2.field25 = class105.field1712[class105.field1699];
            class164.field2317 = class105.field1713[class105.field1699];
            class105.field1699 = 1 + class105.field1699 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZB)I",
      garbageValue = "0"
   )
   static int method749(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method640()?(var1.method640()?0:1):(var1.method640()?-1:0)):(var2 == 5?(var0.method653()?(var1.method653()?0:1):(var1.method653()?-1:0)):(var2 == 6?(var0.method639()?(var1.method639()?0:1):(var1.method639()?-1:0)):(var2 == 7?(var0.method637()?(var1.method637()?0:1):(var1.method637()?-1:0)):var0.id - var1.id)))));
      }
   }
}
