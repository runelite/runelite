import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jr")
public class class265 {
   @ObfuscatedName("p")
   static class165 field3660;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;IB)LModIcon;",
      garbageValue = "1"
   )
   public static ModIcon method4726(IndexDataBase var0, int var1) {
      byte[] var3 = var0.method4001(var1);
      boolean var2;
      if(var3 == null) {
         var2 = false;
      } else {
         ISAACCipher.method3321(var3);
         var2 = true;
      }

      if(!var2) {
         return null;
      } else {
         ModIcon var4 = new ModIcon();
         var4.width = class220.field2818;
         var4.originalHeight = class286.field3792;
         var4.offsetX = class286.field3793[0];
         var4.offsetY = class286.field3794[0];
         var4.originalWidth = class286.field3791[0];
         var4.height = class149.field2211[0];
         var4.palette = class116.field1686;
         var4.pixels = class286.field3797[0];
         class286.field3793 = null;
         class286.field3794 = null;
         class286.field3791 = null;
         class149.field2211 = null;
         class116.field1686 = null;
         class286.field3797 = null;
         return var4;
      }
   }
}
