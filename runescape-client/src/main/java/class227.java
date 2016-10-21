import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hq")
public final class class227 extends class226 {
   public class227(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      super(var1, var2, var3, var4, var5, var6, var7);
   }

   @ObfuscatedName("p")
   final void vmethod4183(byte[] var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var2 + var3 * class82.graphicsPixelsWidth;
      int var8 = class82.graphicsPixelsWidth - var4;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var3 < class82.field1466) {
         var11 = class82.field1466 - var3;
         var5 -= var11;
         var3 = class82.field1466;
         var10 += var11 * var4;
         var7 += var11 * class82.graphicsPixelsWidth;
      }

      if(var3 + var5 > class82.field1463) {
         var5 -= var3 + var5 - class82.field1463;
      }

      if(var2 < class82.field1468) {
         var11 = class82.field1468 - var2;
         var4 -= var11;
         var2 = class82.field1468;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var2 + var4 > class82.field1469) {
         var11 = var2 + var4 - class82.field1469;
         var4 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var4 > 0 && var5 > 0) {
         class226.method4124(class82.graphicsPixels, var1, var6, var10, var7, var4, var5, var8, var9);
      }
   }

   @ObfuscatedName("y")
   final void vmethod4184(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var2 + var3 * class82.graphicsPixelsWidth;
      int var9 = class82.graphicsPixelsWidth - var4;
      int var10 = 0;
      int var11 = 0;
      int var12;
      if(var3 < class82.field1466) {
         var12 = class82.field1466 - var3;
         var5 -= var12;
         var3 = class82.field1466;
         var11 += var12 * var4;
         var8 += var12 * class82.graphicsPixelsWidth;
      }

      if(var3 + var5 > class82.field1463) {
         var5 -= var3 + var5 - class82.field1463;
      }

      if(var2 < class82.field1468) {
         var12 = class82.field1468 - var2;
         var4 -= var12;
         var2 = class82.field1468;
         var11 += var12;
         var8 += var12;
         var10 += var12;
         var9 += var12;
      }

      if(var2 + var4 > class82.field1469) {
         var12 = var2 + var4 - class82.field1469;
         var4 -= var12;
         var10 += var12;
         var9 += var12;
      }

      if(var4 > 0 && var5 > 0) {
         class226.method4115(class82.graphicsPixels, var1, var6, var11, var8, var4, var5, var9, var10, var7);
      }
   }

   public class227(byte[] var1) {
      super(var1);
   }
}
