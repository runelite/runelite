import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hq")
public final class class227 extends class226 {
   @ObfuscatedName("l")
   final void vmethod4108(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var2 + var3 * class82.graphicsPixelsWidth;
      int var9 = class82.graphicsPixelsWidth - var4;
      int var10 = 0;
      int var11 = 0;
      int var12;
      if(var3 < class82.field1452) {
         var12 = class82.field1452 - var3;
         var5 -= var12;
         var3 = class82.field1452;
         var11 += var12 * var4;
         var8 += var12 * class82.graphicsPixelsWidth;
      }

      if(var3 + var5 > class82.field1454) {
         var5 -= var3 + var5 - class82.field1454;
      }

      if(var2 < class82.field1456) {
         var12 = class82.field1456 - var2;
         var4 -= var12;
         var2 = class82.field1456;
         var11 += var12;
         var8 += var12;
         var10 += var12;
         var9 += var12;
      }

      if(var2 + var4 > class82.field1455) {
         var12 = var2 + var4 - class82.field1455;
         var4 -= var12;
         var10 += var12;
         var9 += var12;
      }

      if(var4 > 0 && var5 > 0) {
         class226.method4033(class82.graphicsPixels, var1, var6, var11, var8, var4, var5, var9, var10, var7);
      }
   }

   public class227(byte[] var1) {
      super(var1);
   }

   public class227(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      super(var1, var2, var3, var4, var5, var6, var7);
   }

   @ObfuscatedName("v")
   final void vmethod4112(byte[] var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var2 + var3 * class82.graphicsPixelsWidth;
      int var8 = class82.graphicsPixelsWidth - var4;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var3 < class82.field1452) {
         var11 = class82.field1452 - var3;
         var5 -= var11;
         var3 = class82.field1452;
         var10 += var11 * var4;
         var7 += var11 * class82.graphicsPixelsWidth;
      }

      if(var3 + var5 > class82.field1454) {
         var5 -= var3 + var5 - class82.field1454;
      }

      if(var2 < class82.field1456) {
         var11 = class82.field1456 - var2;
         var4 -= var11;
         var2 = class82.field1456;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var2 + var4 > class82.field1455) {
         var11 = var2 + var4 - class82.field1455;
         var4 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var4 > 0 && var5 > 0) {
         class226.method4048(class82.graphicsPixels, var1, var6, var10, var7, var4, var5, var8, var9);
      }
   }
}
