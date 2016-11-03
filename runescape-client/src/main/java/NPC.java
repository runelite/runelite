import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("k")
   @Export("composition")
   NPCComposition composition;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 308547063
   )
   static int field794;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1714992488"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && (super.poseAnimation != super.idlePoseAnimation || var1 == null)?getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method808(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2366();
            super.field857 = var3.modelHeight;
            if(super.graphic != -1 && super.field827 != -1) {
               Model var4 = class156.method3182(super.graphic).method938(super.field827);
               if(var4 != null) {
                  var4.method2375(0, -super.field866, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field899 == 1) {
               var3.field1911 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "237256028"
   )
   final boolean vmethod774() {
      return this.composition != null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1822722338"
   )
   static void method745() {
      class134.field2117 = null;
      class79.field1438 = null;
      class79.field1439 = null;
      ChatLineBuffer.field693 = null;
      class26.field634 = null;
      class110.field1936 = null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "-1428235930"
   )
   final void method747(int var1, byte var2) {
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

      if(super.animation != -1 && getAnimation(super.animation).field1018 == 1) {
         super.animation = -1;
      }

      if(super.field851 < 9) {
         ++super.field851;
      }

      for(int var5 = super.field851; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field882[var5] = super.field882[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field882[0] = var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "2"
   )
   final void method748(int var1, int var2, boolean var3) {
      if(super.animation != -1 && getAnimation(super.animation).field1018 == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field851 < 9) {
               ++super.field851;
            }

            for(int var6 = super.field851; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.field882[var6] = super.field882[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field882[0] = 1;
            return;
         }
      }

      super.field851 = 0;
      super.field863 = 0;
      super.field883 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field841 * 64 + super.pathX[0] * 128;
      super.y = super.field841 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)LSequence;",
      garbageValue = "1975010075"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field1023.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = Sequence.field1007.method3305(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.method913(new Buffer(var2));
         }

         var1.method932();
         Sequence.field1023.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "1469689482"
   )
   static final void method756(Widget var0, int var1, int var2) {
      if(null == Client.field453 && !Client.isMenuOpen) {
         if(null != var0) {
            Widget var4 = class21.method573(var0);
            if(null == var4) {
               var4 = var0.parent;
            }

            if(var4 != null) {
               Client.field453 = var0;
               var4 = class21.method573(var0);
               if(var4 == null) {
                  var4 = var0.parent;
               }

               Client.field388 = var4;
               Client.field504 = var1;
               Client.field456 = var2;
               Friend.field248 = 0;
               Client.field375 = false;
               if(Client.menuOptionCount > 0) {
                  class10.method121(Client.menuOptionCount - 1);
               }

               return;
            }
         }

      }
   }
}
