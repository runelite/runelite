import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hg")
public final class class224 extends class223 {
   public class224(byte[] var1) {
      super(var1);
   }

   @ObfuscatedName("f")
   final void vmethod4120(byte[] var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var2 + var3 * class79.field1414;
      int var8 = class79.field1414 - var4;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var3 < class79.field1418) {
         var11 = class79.field1418 - var3;
         var5 -= var11;
         var3 = class79.field1418;
         var10 += var11 * var4;
         var7 += var11 * class79.field1414;
      }

      if(var3 + var5 > class79.field1413) {
         var5 -= var3 + var5 - class79.field1413;
      }

      if(var2 < class79.field1419) {
         var11 = class79.field1419 - var2;
         var4 -= var11;
         var2 = class79.field1419;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var2 + var4 > class79.field1417) {
         var11 = var2 + var4 - class79.field1417;
         var4 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var4 > 0 && var5 > 0) {
         class223.method4053(class79.field1416, var1, var6, var10, var7, var4, var5, var8, var9);
      }
   }

   @ObfuscatedName("r")
   final void vmethod4121(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var2 + var3 * class79.field1414;
      int var9 = class79.field1414 - var4;
      int var10 = 0;
      int var11 = 0;
      int var12;
      if(var3 < class79.field1418) {
         var12 = class79.field1418 - var3;
         var5 -= var12;
         var3 = class79.field1418;
         var11 += var12 * var4;
         var8 += var12 * class79.field1414;
      }

      if(var3 + var5 > class79.field1413) {
         var5 -= var3 + var5 - class79.field1413;
      }

      if(var2 < class79.field1419) {
         var12 = class79.field1419 - var2;
         var4 -= var12;
         var2 = class79.field1419;
         var11 += var12;
         var8 += var12;
         var10 += var12;
         var9 += var12;
      }

      if(var2 + var4 > class79.field1417) {
         var12 = var2 + var4 - class79.field1417;
         var4 -= var12;
         var10 += var12;
         var9 += var12;
      }

      if(var4 > 0 && var5 > 0) {
         class223.method4055(class79.field1416, var1, var6, var11, var8, var4, var5, var9, var10, var7);
      }
   }

   public class224(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      super(var1, var2, var3, var4, var5, var6, var7);
   }
}
