import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = -1037220651
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("i")
   @Export("stackSizes")
   int[] stackSizes = new int[]{0};
   @ObfuscatedName("u")
   @Export("itemContainers")
   static XHashTable itemContainers = new XHashTable(32);
   @ObfuscatedName("bw")
   static ModIcon[] field133;
   @ObfuscatedName("x")
   @Export("itemIds")
   int[] itemIds = new int[]{-1};
   @ObfuscatedName("bi")
   static class184 field136;

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass164;I)V",
      garbageValue = "-59962383"
   )
   static final void method159(int var0, int var1, int var2, int var3, SpritePixels var4, class164 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle + Client.mapScale & 2047;
         int var8 = class84.field1438[var7];
         int var9 = class84.field1428[var7];
         var8 = 256 * var8 / (Client.mapScaleDelta + 256);
         var9 = 256 * var9 / (256 + Client.mapScaleDelta);
         int var10 = var2 * var9 + var8 * var3 >> 16;
         int var11 = var9 * var3 - var2 * var8 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class45.field901.method4127(4 + var0 + 94 + var14 - 10, 83 + var1 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class203.method3801(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "-303806216"
   )
   static void method166(Widget var0) {
      Widget var1 = var0.parentId == -1?null:class44.method799(var0.parentId);
      int var2;
      int var3;
      if(var1 == null) {
         var2 = class0.field1;
         var3 = class65.field1099;
      } else {
         var2 = var1.width;
         var3 = var1.height;
      }

      class2.method17(var0, var2, var3, false);
      class1.method14(var0, var2, var3);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(LPlayer;III)V",
      garbageValue = "1305594321"
   )
   static void method167(Player var0, int var1, int var2) {
      if(var1 == var0.animation && var1 != -1) {
         int var3 = CombatInfo2.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field633 = 0;
            var0.actionAnimationDisable = var2;
            var0.field635 = 0;
         }

         if(var3 == 2) {
            var0.field635 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || CombatInfo2.getAnimation(var1).forcedPriority >= CombatInfo2.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field633 = 0;
         var0.actionAnimationDisable = var2;
         var0.field635 = 0;
         var0.field658 = var0.field653;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)LFrames;",
      garbageValue = "-878673312"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field3040.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         class182 var2 = Sequence.field3043;
         class182 var3 = Sequence.field3054;
         boolean var4 = true;
         int[] var5 = var2.method3314(var0);

         for(int var6 = 0; var6 < var5.length; ++var6) {
            byte[] var7 = var2.method3268(var0, var5[var6]);
            if(null == var7) {
               var4 = false;
            } else {
               int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
               byte[] var9 = var3.method3268(var8, 0);
               if(var9 == null) {
                  var4 = false;
               }
            }
         }

         Frames var11;
         if(!var4) {
            var11 = null;
         } else {
            try {
               var11 = new Frames(var2, var3, var0, false);
            } catch (Exception var10) {
               var11 = null;
            }
         }

         if(var11 != null) {
            Sequence.field3040.put(var11, (long)var0);
         }

         return var11;
      }
   }
}
