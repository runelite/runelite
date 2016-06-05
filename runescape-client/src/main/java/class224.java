import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hv")
public final class class224 extends class223 {
   public class224(byte[] var1) {
      super(var1);
   }

   @ObfuscatedName("v")
   final void vmethod4062(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var2 + var3 * class79.field1421;
      int var9 = class79.field1421 - var4;
      int var10 = 0;
      int var11 = 0;
      int var12;
      if(var3 < class79.field1416) {
         var12 = class79.field1416 - var3;
         var5 -= var12;
         var3 = class79.field1416;
         var11 += var12 * var4;
         var8 += var12 * class79.field1421;
      }

      if(var3 + var5 > class79.field1419) {
         var5 -= var3 + var5 - class79.field1419;
      }

      if(var2 < class79.field1420) {
         var12 = class79.field1420 - var2;
         var4 -= var12;
         var2 = class79.field1420;
         var11 += var12;
         var8 += var12;
         var10 += var12;
         var9 += var12;
      }

      if(var2 + var4 > class79.field1415) {
         var12 = var2 + var4 - class79.field1415;
         var4 -= var12;
         var10 += var12;
         var9 += var12;
      }

      if(var4 > 0 && var5 > 0) {
         class223.method3986(class79.field1418, var1, var6, var11, var8, var4, var5, var9, var10, var7);
      }
   }

   @ObfuscatedName("x")
   final void vmethod4065(byte[] var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var2 + var3 * class79.field1421;
      int var8 = class79.field1421 - var4;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var3 < class79.field1416) {
         var11 = class79.field1416 - var3;
         var5 -= var11;
         var3 = class79.field1416;
         var10 += var11 * var4;
         var7 += var11 * class79.field1421;
      }

      if(var3 + var5 > class79.field1419) {
         var5 -= var3 + var5 - class79.field1419;
      }

      if(var2 < class79.field1420) {
         var11 = class79.field1420 - var2;
         var4 -= var11;
         var2 = class79.field1420;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var2 + var4 > class79.field1415) {
         var11 = var2 + var4 - class79.field1415;
         var4 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var4 > 0 && var5 > 0) {
         class223.method3984(class79.field1418, var1, var6, var10, var7, var4, var5, var8, var9);
      }
   }

   public class224(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      super(var1, var2, var3, var4, var5, var6, var7);
   }
}
