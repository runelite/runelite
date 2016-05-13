import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class74 {
   @ObfuscatedName("es")
   static class80[] field1364;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -326300013
   )
   int field1367;
   @ObfuscatedName("ma")
   static class78 field1370;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 375879353
   )
   int field1373;
   @ObfuscatedName("u")
   int[][] field1375;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "-12"
   )
   byte[] method1570(byte[] var1) {
      if(this.field1375 != null) {
         int var2 = 14 + (int)((long)var1.length * (long)this.field1367 / (long)this.field1373);
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1375[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var7 * var8[var9];
            }

            var5 += this.field1367;
            var9 = var5 / this.field1373;
            var4 += var9;
            var5 -= var9 * this.field1373;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = '耀' + var3[var6] >> 16;
            if(var10 < -128) {
               var1[var6] = -128;
            } else if(var10 > 127) {
               var1[var6] = 127;
            } else {
               var1[var6] = (byte)var10;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-69"
   )
   int method1572(int var1) {
      if(this.field1375 != null) {
         var1 = (int)((long)this.field1367 * (long)var1 / (long)this.field1373);
      }

      return var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "0"
   )
   int method1573(int var1) {
      if(this.field1375 != null) {
         var1 = (int)((long)var1 * (long)this.field1367 / (long)this.field1373) + 6;
      }

      return var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1531157163"
   )
   public static void method1576(Component var0) {
      var0.removeKeyListener(class137.field2119);
      var0.removeFocusListener(class137.field2119);
      class137.field2136 = -1;
   }

   public class74(int var1, int var2) {
      if(var2 != var1) {
         int var3 = var1;
         int var4 = var2;
         if(var2 > var1) {
            var3 = var2;
            var4 = var1;
         }

         int var5;
         while(var4 != 0) {
            var5 = var3 % var4;
            var3 = var4;
            var4 = var5;
         }

         var1 /= var3;
         var2 /= var3;
         this.field1373 = var1;
         this.field1367 = var2;
         this.field1375 = new int[var1][14];

         for(var5 = 0; var5 < var1; ++var5) {
            int[] var6 = this.field1375[var5];
            double var7 = (double)var5 / (double)var1 + 6.0D;
            int var9 = (int)Math.floor(var7 - 7.0D + 1.0D);
            if(var9 < 0) {
               var9 = 0;
            }

            int var10 = (int)Math.ceil(7.0D + var7);
            if(var10 > 14) {
               var10 = 14;
            }

            for(double var11 = (double)var2 / (double)var1; var9 < var10; ++var9) {
               double var13 = 3.141592653589793D * ((double)var9 - var7);
               double var15 = var11;
               if(var13 < -1.0E-4D || var13 > 1.0E-4D) {
                  var15 = var11 * (Math.sin(var13) / var13);
               }

               var15 *= 0.54D + 0.46D * Math.cos(((double)var9 - var7) * 0.2243994752564138D);
               var6[var9] = (int)Math.floor(0.5D + 65536.0D * var15);
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass113;B)V",
      garbageValue = "-7"
   )
   public static void method1585(class113 var0) {
      class222.field3187 = var0;
   }
}
