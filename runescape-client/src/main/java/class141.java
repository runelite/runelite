import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public class class141 extends class133 {
   @ObfuscatedName("t")
   long[] field2195 = new long[10];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 638089907
   )
   int field2196 = 256;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -355584183
   )
   int field2197 = 1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -2055594639632621217L
   )
   long field2198 = class124.method2746();
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -823002463
   )
   int field2200;
   @ObfuscatedName("j")
   static class119 field2201;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1006330407
   )
   int field2202 = 0;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-497595368"
   )
   public static String method2946(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var1 + var5] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class165.field2696[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "255"
   )
   int vmethod3083(int var1, int var2) {
      int var3 = this.field2196;
      int var4 = this.field2197;
      this.field2196 = 300;
      this.field2197 = 1;
      this.field2198 = class124.method2746();
      if(this.field2195[this.field2200] == 0L) {
         this.field2196 = var3;
         this.field2197 = var4;
      } else if(this.field2198 > this.field2195[this.field2200]) {
         this.field2196 = (int)((long)(2560 * var1) / (this.field2198 - this.field2195[this.field2200]));
      }

      if(this.field2196 < 25) {
         this.field2196 = 25;
      }

      if(this.field2196 > 256) {
         this.field2196 = 256;
         this.field2197 = (int)((long)var1 - (this.field2198 - this.field2195[this.field2200]) / 10L);
      }

      if(this.field2197 > var1) {
         this.field2197 = var1;
      }

      this.field2195[this.field2200] = this.field2198;
      this.field2200 = (1 + this.field2200) % 10;
      int var5;
      if(this.field2197 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2195[var5]) {
               this.field2195[var5] += (long)this.field2197;
            }
         }
      }

      if(this.field2197 < var2) {
         this.field2197 = var2;
      }

      class45.method926((long)this.field2197);

      for(var5 = 0; this.field2202 < 256; this.field2202 += this.field2196) {
         ++var5;
      }

      this.field2202 &= 255;
      return var5;
   }

   class141() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2195[var1] = this.field2198;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-38"
   )
   void vmethod3081() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2195[var1] = 0L;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-40"
   )
   static final void method2953() {
      if(client.field335 > 0) {
         class211.method3879();
      } else {
         class2.method14(40);
         class89.field1561 = class51.field1112;
         class51.field1112 = null;
      }
   }
}
