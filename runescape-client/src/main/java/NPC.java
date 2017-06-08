import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("cc")
   static IndexData field1374;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = 885445275
   )
   static int field1375;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -738156399
   )
   static int field1377;
   @ObfuscatedName("n")
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "1155013564"
   )
   final void method1666(int var1, byte var2) {
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

      if(super.animation != -1 && class169.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(super.field1280 < 9) {
         ++super.field1280;
      }

      for(int var5 = super.field1280; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field1283[var5] = super.field1283[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field1283[0] = var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-610016412"
   )
   final void method1667(int var1, int var2, boolean var3) {
      if(super.animation != -1 && class169.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field1280 < 9) {
               ++super.field1280;
            }

            for(int var6 = super.field1280; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.field1283[var6] = super.field1283[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field1283[0] = 1;
            return;
         }
      }

      super.field1280 = 0;
      super.field1285 = 0;
      super.field1258 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field1230 * 64 + super.pathX[0] * 128;
      super.y = super.pathY[0] * 128 + super.field1230 * 64;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(S)LModel;",
      garbageValue = "-1617"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class169.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && (super.idlePoseAnimation != super.poseAnimation || var1 == null)?class169.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method4665(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2515();
            super.field1276 = var3.modelHeight;
            if(super.graphic != -1 && super.field1264 != -1) {
               Model var4 = class100.method1840(super.graphic).method4358(super.field1264);
               if(var4 != null) {
                  var4.method2519(0, -super.field1279, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3577 == 1) {
               var3.field1957 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-41"
   )
   final boolean vmethod1669() {
      return this.composition != null;
   }

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "(LWidget;IB)Ljava/lang/String;",
      garbageValue = "0"
   )
   static String method1672(Widget var0, int var1) {
      return !class286.method5182(class251.method4472(var0), var1) && var0.field2752 == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }
}
