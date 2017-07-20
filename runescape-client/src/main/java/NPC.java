import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Leo;",
      garbageValue = "1"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class31.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && (super.idlePoseAnimation != super.poseAnimation || var1 == null)?class31.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method4514(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2433();
            super.field1259 = var3.modelHeight;
            if(super.graphic != -1 && super.field1247 != -1) {
               Model var4 = class205.getSpotAnimType(super.graphic).method4231(super.field1247);
               if(var4 != null) {
                  var4.method2479(0, -super.field1250, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3532 == 1) {
               var3.field1879 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "1382211404"
   )
   final void method1633(int var1, byte var2) {
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

      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var5 = super.queueSize; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field1266[var5] = super.field1266[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field1266[0] = var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "307360793"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-868443418"
   )
   final void method1634(int var1, int var2, boolean var3) {
      if(super.animation != -1 && class31.getAnimation(super.animation).priority == 1) {
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
               super.field1266[var6] = super.field1266[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field1266[0] = 1;
            return;
         }
      }

      super.queueSize = 0;
      super.field1219 = 0;
      super.field1267 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field1213 * 64 + super.pathX[0] * 128;
      super.y = super.field1213 * 64 + 128 * super.pathY[0];
   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "62"
   )
   static final String method1650(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class8.getColTags('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class8.getColTags(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class8.getColTags(16776960) + var1 + "</col>");
   }
}
