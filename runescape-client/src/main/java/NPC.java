import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("s")
   @Export("composition")
   NPCComposition composition;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = 1278854075
   )
   static int field760;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "32768"
   )
   public static void method695(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "2075849867"
   )
   final void method696(int var1, byte var2) {
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

      if(super.animation != -1 && class110.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(super.field658 < 9) {
         ++super.field658;
      }

      for(int var5 = super.field658; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field624[var5] = super.field624[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field624[0] = var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1373848960"
   )
   public static int method697(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "2062912069"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class110.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || super.poseAnimation == super.idlePoseAnimation && null != var1?null:class110.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3591(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method1518();
            super.field654 = var3.modelHeight;
            if(super.graphic != -1 && super.field642 != -1) {
               Model var4 = class48.method844(super.graphic).method3353(super.field642);
               if(var4 != null) {
                  var4.method1517(0, -super.field631, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3010 == 1) {
               var3.field1382 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1377545017"
   )
   final boolean vmethod699() {
      return null != this.composition;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "91"
   )
   final void method704(int var1, int var2, boolean var3) {
      if(super.animation != -1 && class110.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field658 < 9) {
               ++super.field658;
            }

            for(int var6 = super.field658; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.field624[var6] = super.field624[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field624[0] = 1;
            return;
         }
      }

      super.field658 = 0;
      super.field663 = 0;
      super.field647 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field645 * 64 + 128 * super.pathX[0];
      super.y = super.field645 * 64 + 128 * super.pathY[0];
   }

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass164;I)V",
      garbageValue = "1971693514"
   )
   static final void method706(int var0, int var1, int var2, int var3, SpritePixels var4, class164 var5) {
      if(null != var4) {
         int var6 = Client.mapAngle + Client.mapScale & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class84.field1444[var6];
            int var9 = class84.field1453[var6];
            var8 = 256 * var8 / (256 + Client.mapScaleDelta);
            var9 = 256 * var9 / (Client.mapScaleDelta + 256);
            int var10 = var9 * var2 + var8 * var3 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method3967(var10 + var5.field2164 / 2 - var4.maxWidth / 2, var5.field2165 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2164, var5.field2165, var5.field2172, var5.field2166);
            } else {
               var4.method3971(var10 + var0 + var5.field2164 / 2 - var4.maxWidth / 2, var5.field2165 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "-1785019990"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field2986.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Ignore.field224.method3182(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(null != var2) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method3525();
         if(var1.notedTemplate != -1) {
            var1.method3528(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.field2954 != -1) {
            var1.method3529(getItemDefinition(var1.field2954), getItemDefinition(var1.field2999));
         }

         if(var1.field3002 != -1) {
            var1.method3530(getItemDefinition(var1.field3002), getItemDefinition(var1.field3001));
         }

         if(!ItemComposition.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field2998 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = 0;
         }

         ItemComposition.field2986.put(var1, (long)var0);
         return var1;
      }
   }
}
