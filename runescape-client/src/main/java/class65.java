import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
public class class65 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1773364905
   )
   int field1117;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1055771371
   )
   int field1120;
   @ObfuscatedName("p")
   int[][] field1122;
   @ObfuscatedName("i")
   public static short[][] field1124;
   @ObfuscatedName("k")
   static int[] field1127;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = 1702989461
   )
   protected static int field1128;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "1"
   )
   int method1243(int var1) {
      if(this.field1122 != null) {
         var1 = (int)((long)var1 * (long)this.field1117 / (long)this.field1120);
      }

      return var1;
   }

   public class65(int var1, int var2) {
      if(var1 != var2) {
         int var4 = var1;
         int var5 = var2;
         if(var2 > var1) {
            var4 = var2;
            var5 = var1;
         }

         while(var5 != 0) {
            int var6 = var4 % var5;
            var4 = var5;
            var5 = var6;
         }

         var1 /= var4;
         var2 /= var4;
         this.field1120 = var1;
         this.field1117 = var2;
         this.field1122 = new int[var1][14];

         for(int var7 = 0; var7 < var1; ++var7) {
            int[] var8 = this.field1122[var7];
            double var9 = (double)var7 / (double)var1 + 6.0D;
            int var11 = (int)Math.floor(1.0D + (var9 - 7.0D));
            if(var11 < 0) {
               var11 = 0;
            }

            int var12 = (int)Math.ceil(var9 + 7.0D);
            if(var12 > 14) {
               var12 = 14;
            }

            for(double var13 = (double)var2 / (double)var1; var11 < var12; ++var11) {
               double var15 = 3.141592653589793D * ((double)var11 - var9);
               double var17 = var13;
               if(var15 < -1.0E-4D || var15 > 1.0E-4D) {
                  var17 = var13 * (Math.sin(var15) / var15);
               }

               var17 *= 0.54D + 0.46D * Math.cos(((double)var11 - var9) * 0.2243994752564138D);
               var8[var11] = (int)Math.floor(0.5D + var17 * 65536.0D);
            }
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1370712550"
   )
   int method1245(int var1) {
      if(null != this.field1122) {
         var1 = (int)((long)this.field1117 * (long)var1 / (long)this.field1120) + 6;
      }

      return var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1107038"
   )
   byte[] method1248(byte[] var1) {
      if(this.field1122 != null) {
         int var2 = 14 + (int)((long)var1.length * (long)this.field1117 / (long)this.field1120);
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1122[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var8[var9] * var7;
            }

            var5 += this.field1117;
            var9 = var5 / this.field1120;
            var4 += var9;
            var5 -= this.field1120 * var9;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = var3[var6] + '耀' >> 16;
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "99"
   )
   static void method1250() {
      class10.field82 = 99;
      class202.underlayIds = new byte[4][104][104];
      class10.overlayIds = new byte[4][104][104];
      class3.overlayPaths = new byte[4][104][104];
      class6.overlayRotations = new byte[4][104][104];
      class159.field2122 = new int[4][105][105];
      class10.field83 = new byte[4][105][105];
      class22.field230 = new int[105][105];
      class10.field89 = new int[104];
      class7.field56 = new int[104];
      field1127 = new int[104];
      class181.field2701 = new int[104];
      class7.field61 = new int[104];
   }
}
