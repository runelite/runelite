import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
public class class21 implements class115 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2147294353
   )
   final int field591;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -991239487
   )
   public static int field592;
   @ObfuscatedName("c")
   static final class21 field593 = new class21(2);
   @ObfuscatedName("h")
   static final class21 field594 = new class21(3);
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = 308070813
   )
   static int field596;
   @ObfuscatedName("e")
   static final class21 field597 = new class21(0);
   @ObfuscatedName("l")
   static final class21 field598 = new class21(1);
   @ObfuscatedName("pl")
   static short[] field600;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2010364784"
   )
   public int vmethod3262() {
      return this.field591;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass125;II)Z",
      garbageValue = "-1967531172"
   )
   static boolean method546(class125 var0, int var1) {
      int var2 = var0.method2859(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method2859(1) != 0) {
            method546(var0, var1);
         }

         var3 = var0.method2859(6);
         var4 = var0.method2859(6);
         boolean var12 = var0.method2859(1) == 1;
         if(var12) {
            class34.field796[++class34.field806 - 1] = var1;
         }

         if(null != client.field467[var1]) {
            throw new RuntimeException();
         } else {
            class2 var11 = client.field467[var1] = new class2();
            var11.field39 = var1;
            if(null != class34.field798[var1]) {
               var11.method22(class34.field798[var1]);
            }

            var11.field889 = class34.field800[var1];
            var11.field876 = class34.field805[var1];
            var7 = class34.field803[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var11.field907[0] = class34.field799[var1];
            var11.field57 = (byte)var8;
            var11.method23((var9 << 6) + var3 - class19.field286, (var10 << 6) + var4 - class6.field128);
            var11.field37 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method2859(2);
         var4 = class34.field803[var1];
         class34.field803[var1] = (((var4 >> 28) + var3 & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var6;
         if(var2 == 2) {
            var3 = var0.method2859(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var6 = class34.field803[var1];
            var7 = var4 + (var6 >> 28) & 3;
            var8 = var6 >> 14 & 255;
            var9 = var6 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class34.field803[var1] = var9 + (var8 << 14) + (var7 << 28);
            return false;
         } else {
            var3 = var0.method2859(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var6 = var3 & 255;
            var7 = class34.field803[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var6 + var7 & 255;
            class34.field803[var1] = var10 + (var9 << 14) + (var8 << 28);
            return false;
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class21(int var1) {
      this.field591 = var1;
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "60"
   )
   static final void method553(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class10.method112(var0)) {
         class8.field145 = null;
         class24.method581(class176.field2811[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(null != class8.field145) {
            class24.method581(class8.field145, -1412584499, var1, var2, var3, var4, class62.field1286, class141.field2186, var7);
            class8.field145 = null;
         }

      } else {
         if(var7 != -1) {
            client.field500[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               client.field500[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "1413046582"
   )
   public static int method554(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ class122.field2055[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IB)I",
      garbageValue = "41"
   )
   public static int method556(CharSequence var0, int var1) {
      return class153.method3230(var0, var1, true);
   }
}
