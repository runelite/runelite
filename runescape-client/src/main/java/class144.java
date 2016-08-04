import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public class class144 extends class136 {
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = -623009513
   )
   protected static int field2220;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2080984003
   )
   int field2221 = 256;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 826585105
   )
   public static int field2222;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 715961349
   )
   int field2223 = 1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -493237319
   )
   int field2224 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1857517585
   )
   int field2225;
   @ObfuscatedName("c")
   static int[] field2226;
   @ObfuscatedName("l")
   long[] field2230 = new long[10];
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 2719127333320880587L
   )
   long field2231 = class56.method1249();

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1611700541"
   )
   @Export("groundItemSpawned")
   static final void method3120(int var0, int var1) {
      class202 var2 = client.field426[class99.field1701][var0][var1];
      if(null == var2) {
         class136.field2126.method2012(class99.field1701, var0, var1);
      } else {
         long var3 = -99999999L;
         class30 var5 = null;

         class30 var6;
         for(var6 = (class30)var2.method3980(); null != var6; var6 = (class30)var2.method3970()) {
            class55 var7 = class1.method14(var6.field714);
            long var10 = (long)var7.field1212;
            if(var7.field1197 == 1) {
               var10 *= (long)(var6.field709 + 1);
            }

            if(var10 > var3) {
               var3 = var10;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class136.field2126.method2012(class99.field1701, var0, var1);
         } else {
            var2.method3964(var5);
            class30 var12 = null;
            class30 var8 = null;

            for(var6 = (class30)var2.method3980(); null != var6; var6 = (class30)var2.method3970()) {
               if(var5.field714 != var6.field714) {
                  if(var12 == null) {
                     var12 = var6;
                  }

                  if(var12.field714 != var6.field714 && null == var8) {
                     var8 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            class136.field2126.method2107(class99.field1701, var0, var1, class127.method2936(64 + 128 * var0, var1 * 128 + 64, class99.field1701), var5, var9, var12, var8);
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public void vmethod3260() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2230[var1] = 0L;
      }

   }

   class144() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2230[var1] = this.field2231;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1964270008"
   )
   int vmethod3261(int var1, int var2) {
      int var3 = this.field2221;
      int var4 = this.field2223;
      this.field2221 = 300;
      this.field2223 = 1;
      this.field2231 = class56.method1249();
      if(0L == this.field2230[this.field2225]) {
         this.field2221 = var3;
         this.field2223 = var4;
      } else if(this.field2231 > this.field2230[this.field2225]) {
         this.field2221 = (int)((long)(var1 * 2560) / (this.field2231 - this.field2230[this.field2225]));
      }

      if(this.field2221 < 25) {
         this.field2221 = 25;
      }

      if(this.field2221 > 256) {
         this.field2221 = 256;
         this.field2223 = (int)((long)var1 - (this.field2231 - this.field2230[this.field2225]) / 10L);
      }

      if(this.field2223 > var1) {
         this.field2223 = var1;
      }

      this.field2230[this.field2225] = this.field2231;
      this.field2225 = (this.field2225 + 1) % 10;
      int var5;
      if(this.field2223 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2230[var5]) {
               this.field2230[var5] += (long)this.field2223;
            }
         }
      }

      if(this.field2223 < var2) {
         this.field2223 = var2;
      }

      class22.method594((long)this.field2223);

      for(var5 = 0; this.field2224 < 256; this.field2224 += this.field2221) {
         ++var5;
      }

      this.field2224 &= 255;
      return var5;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "1"
   )
   static final int method3126(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class170.method3482(var3, var5);
      int var8 = class170.method3482(var3 + 1, var5);
      int var9 = class170.method3482(var3, 1 + var5);
      int var10 = class170.method3482(var3 + 1, var5 + 1);
      int var12 = 65536 - class94.field1662[1024 * var4 / var2] >> 1;
      int var11 = (var8 * var12 >> 16) + ((65536 - var12) * var7 >> 16);
      int var14 = 65536 - class94.field1662[1024 * var4 / var2] >> 1;
      int var13 = (var9 * (65536 - var14) >> 16) + (var14 * var10 >> 16);
      int var16 = 65536 - class94.field1662[var6 * 1024 / var2] >> 1;
      int var15 = (var16 * var13 >> 16) + (var11 * (65536 - var16) >> 16);
      return var15;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-265136797"
   )
   public static int method3127(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }
}
