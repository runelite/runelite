import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("k")
   static ModIcon field769;
   @ObfuscatedName("o")
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IBB)V",
      garbageValue = "-1"
   )
   final void method691(int var1, byte var2) {
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

      if(super.animation != -1 && class31.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(super.field656 < 9) {
         ++super.field656;
      }

      for(int var5 = super.field656; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field661[var5] = super.field661[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field661[0] = var2;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "119415366"
   )
   static final void method692() {
      int var0 = GameObject.menuX;
      int var1 = class109.menuY;
      int var2 = class3.menuWidth;
      int var3 = class30.menuHeight;
      int var4 = 6116423;
      class219.method3899(var0, var1, var2, var3, var4);
      class219.method3899(1 + var0, 1 + var1, var2 - 2, 16, 0);
      class219.method3905(1 + var0, 18 + var1, var2 - 2, var3 - 19, 0);
      Ignore.field218.method3784("Choose Option", var0 + 3, 14 + var1, var4, -1);
      int var5 = class115.field1814;
      int var6 = class115.field1821;

      for(int var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         int var8 = var1 + 31 + 15 * (Client.menuOptionCount - 1 - var7);
         int var9 = 16777215;
         if(var5 > var0 && var5 < var2 + var0 && var6 > var8 - 13 && var6 < var8 + 3) {
            var9 = 16776960;
         }

         class208 var10 = Ignore.field218;
         String var11;
         if(Client.menuTargets[var7].length() > 0) {
            var11 = Client.menuOptions[var7] + " " + Client.menuTargets[var7];
         } else {
            var11 = Client.menuOptions[var7];
         }

         var10.method3784(var11, var0 + 3, var8, var9, 0);
      }

      class10.method142(GameObject.menuX, class109.menuY, class3.menuWidth, class30.menuHeight);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-12"
   )
   protected final Model getModel() {
      if(null == this.composition) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class31.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && (super.poseAnimation != super.idlePoseAnimation || var1 == null)?class31.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method3619(var1, super.actionFrame, var2, super.poseFrame);
         if(null == var3) {
            return null;
         } else {
            var3.method1521();
            super.field634 = var3.modelHeight;
            if(super.graphic != -1 && super.field642 != -1) {
               Model var4 = NPCComposition.method3645(super.graphic).method3387(super.field642);
               if(var4 != null) {
                  var4.method1536(0, -super.field654, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field2999 == 1) {
               var3.field1357 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "17"
   )
   final void method697(int var1, int var2, boolean var3) {
      if(super.animation != -1 && class31.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field656 < 9) {
               ++super.field656;
            }

            for(int var6 = super.field656; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.field661[var6] = super.field661[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field661[0] = 1;
            return;
         }
      }

      super.field656 = 0;
      super.field663 = 0;
      super.field662 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field612 * 64 + super.pathX[0] * 128;
      super.y = super.field612 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-240648388"
   )
   final boolean vmethod702() {
      return this.composition != null;
   }
}
