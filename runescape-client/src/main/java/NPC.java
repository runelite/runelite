import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   static IndexDataBase field1380;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Leo;",
      garbageValue = "1214595416"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?PendingSpawn.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && (super.poseAnimation != super.idlePoseAnimation || var1 == null)?PendingSpawn.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method4668(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2528();
            super.field1231 = var3.modelHeight;
            if(super.graphic != -1 && super.field1256 != -1) {
               Model var4 = class36.getSpotAnimType(super.graphic).method4367(super.field1256);
               if(var4 != null) {
                  var4.method2538(0, -super.field1259, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3543 == 1) {
               var3.field1990 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1465758862"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "-1171353256"
   )
   final void method1686(int var1, byte var2) {
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

      if(super.animation != -1 && PendingSpawn.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var5 = super.queueSize; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field1251[var5] = super.field1251[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field1251[0] = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "1590881445"
   )
   final void method1685(int var1, int var2, boolean var3) {
      if(super.animation != -1 && PendingSpawn.getAnimation(super.animation).priority == 1) {
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
               super.field1251[var6] = super.field1251[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field1251[0] = 1;
            return;
         }
      }

      super.queueSize = 0;
      super.field1277 = 0;
      super.field1276 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.pathX[0] * 128 + super.field1219 * 64;
      super.y = super.field1219 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-740036661"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      class34.addChatMessage(var0, var1, var2, (String)null);
   }
}
