import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.Replace;

@ObfuscatedName("dn")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("q")
   Component field1763;

   public final void update(Graphics var1) {
      this.field1763.update(var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILclass48;ZI)I",
      garbageValue = "1354352096"
   )
   static int method2139(int var0, class48 var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class179.method3296(class32.field747[--class103.field1686]);
      } else {
         var3 = var2?XGrandExchangeOffer.field58:class24.field297;
      }

      class174.method3276(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class32.field747[--class103.field1686];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = class36.localPlayer.composition.method3178();
            return 1;
         } else {
            return 2;
         }
      } else {
         class103.field1686 -= 2;
         int var4 = class32.field747[class103.field1686];
         int var5 = class32.field747[class103.field1686 + 1];
         var3.item = var4;
         var3.stackSize = var5;
         ItemComposition var6 = class103.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2254 = var6.offsetX2d;
         var3.field2255 = var6.offsetY2d;
         var3.field2259 = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2263 = 0;
         } else if(var0 == 1212 | var6.isStackable == 1) {
            var3.field2263 = 1;
         } else {
            var3.field2263 = 2;
         }

         if(var3.field2260 > 0) {
            var3.field2259 = var3.field2259 * 32 / var3.field2260;
         } else if(var3.originalWidth > 0) {
            var3.field2259 = var3.field2259 * 32 / var3.originalWidth;
         }

         return 1;
      }
   }

   RSCanvas(Component var1) {
      this.field1763 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIZB)Ljava/lang/String;",
      garbageValue = "-28"
   )
   static String method2143(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var2 && var0 >= 0) {
            int var3 = 2;

            for(int var4 = var0 / var1; var4 != 0; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = 43;

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var0;
               var0 /= var1;
               int var8 = var7 - var0 * var1;
               if(var8 >= 10) {
                  var5[var6] = (char)(var8 + 87);
               } else {
                  var5[var6] = (char)(var8 + 48);
               }
            }

            return new String(var5);
         } else {
            return Integer.toString(var0, var1);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   public final void paint(Graphics var1) {
      this.field1763.paint(var1);
   }
}
