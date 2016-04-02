import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
public class class141 extends class133 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1421103597
   )
   int field2153 = 256;
   @ObfuscatedName("e")
   long[] field2154 = new long[10];
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1798367551
   )
   int field2156 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -244389403
   )
   int field2157;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = -166837905
   )
   public static int field2158;
   @ObfuscatedName("md")
   static class78 field2160;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 3824313929753359217L
   )
   long field2162 = class140.method2967();
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1905406083
   )
   int field2163 = 1;

   class141() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2154[var1] = this.field2162;
      }

   }

   @ObfuscatedName("w")
   int vmethod3116(int var1, int var2) {
      int var3 = this.field2153;
      int var4 = this.field2163;
      this.field2153 = 300;
      this.field2163 = 1;
      this.field2162 = class140.method2967();
      if(0L == this.field2154[this.field2157]) {
         this.field2153 = var3;
         this.field2163 = var4;
      } else if(this.field2162 > this.field2154[this.field2157]) {
         this.field2153 = (int)((long)(var1 * 2560) / (this.field2162 - this.field2154[this.field2157]));
      }

      if(this.field2153 < 25) {
         this.field2153 = 25;
      }

      if(this.field2153 > 256) {
         this.field2153 = 256;
         this.field2163 = (int)((long)var1 - (this.field2162 - this.field2154[this.field2157]) / 10L);
      }

      if(this.field2163 > var1) {
         this.field2163 = var1;
      }

      this.field2154[this.field2157] = this.field2162;
      this.field2157 = (this.field2157 + 1) % 10;
      int var5;
      if(this.field2163 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(this.field2154[var5] != 0L) {
               this.field2154[var5] += (long)this.field2163;
            }
         }
      }

      if(this.field2163 < var2) {
         this.field2163 = var2;
      }

      class130.method2818((long)this.field2163);

      for(var5 = 0; this.field2156 < 256; this.field2156 += this.field2153) {
         ++var5;
      }

      this.field2156 &= 255;
      return var5;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-832924516"
   )
   static void method2971(int var0) {
      if(client.field287 != var0) {
         if(client.field287 == 0) {
            class13.field206 = null;
            class34.field754 = null;
            class135.field2076 = null;
         }

         if(20 == var0 || var0 == 40 || 45 == var0) {
            client.field542 = 0;
            client.field424 = 0;
            client.field314 = 0;
         }

         if(20 != var0 && 40 != var0 && null != class87.field1516) {
            class87.field1516.method2982();
            class87.field1516 = null;
         }

         if(client.field287 == 25) {
            client.field337 = 0;
            client.field333 = 0;
            client.field334 = 1;
            client.field335 = 0;
            client.field336 = 1;
         }

         if(5 != var0 && var0 != 10) {
            if(20 == var0) {
               class110.method2445(class12.field192, class108.field1880, class17.field246, true, client.field287 == 11?4:0);
            } else if(11 == var0) {
               class110.method2445(class12.field192, class108.field1880, class17.field246, false, 4);
            } else if(class163.field2650) {
               class31.field694 = null;
               class189.field3044 = null;
               class31.field695 = null;
               class31.field720 = null;
               class13.field199 = null;
               class31.field704 = null;
               class18.field260 = null;
               class31.field705 = null;
               class34.field757 = null;
               class119.field1983 = null;
               class89.field1536 = null;
               class12.field182 = null;
               class52.field1138 = null;
               class99.field1662 = null;
               class27.field655 = null;
               class14.field212 = null;
               class143.field2187 = null;
               class48.field1061 = null;
               class27.field656 = null;
               class115.field1957 = null;
               class77.field1369 = null;
               class47.field1047 = null;
               class4.method44(2);
               class22.method585(true);
               class163.field2650 = false;
            }
         } else {
            class110.method2445(class12.field192, class108.field1880, class17.field246, true, 0);
         }

         client.field287 = var0;
      }
   }

   @ObfuscatedName("ac")
   static final void method2976(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = client.field532 + var5 * (client.field533 - client.field532) / 100;
      int var7 = var6 * var3 * 512 / (334 * var2);
      int var8;
      int var9;
      short var14;
      if(var7 < client.field538) {
         var14 = client.field538;
         var6 = 334 * var14 * var2 / (var3 * 512);
         if(var6 > client.field456) {
            var6 = client.field456;
            var8 = var6 * var3 * 512 / (334 * var14);
            var9 = (var2 - var8) / 2;
            if(var4) {
               class79.method1802();
               class79.method1809(var0, var1, var9, var3, -16777216);
               class79.method1809(var2 + var0 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= 2 * var9;
         }
      } else if(var7 > client.field526) {
         var14 = client.field526;
         var6 = var14 * var2 * 334 / (512 * var3);
         if(var6 < client.field461) {
            var6 = client.field461;
            var8 = var2 * var14 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               class79.method1802();
               class79.method1809(var0, var1, var2, var9, -16777216);
               class79.method1809(var0, var1 + var3 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= 2 * var9;
         }
      }

      var8 = client.field534 + (client.field535 - client.field534) * var5 / 100;
      client.field544 = var8 * var6 * var3 / 85504 << 1;
      if(var2 != client.field371 || client.field543 != var3) {
         int[] var15 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 32 * var10 + 128 + 15;
            int var12 = 3 * var11 + 600;
            int var13 = class91.field1568[var11];
            var15[var10] = var13 * var12 >> 16;
         }

         class86.method1962(var15, 500, 800, var2, var3);
      }

      client.field540 = var0;
      client.field541 = var1;
      client.field371 = var2;
      client.field543 = var3;
   }

   @ObfuscatedName("e")
   public void vmethod3115() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2154[var1] = 0L;
      }

   }

   @ObfuscatedName("e")
   public static int method2978(byte[] var0, int var1) {
      int var3 = -1;

      for(int var4 = 0; var4 < var1; ++var4) {
         var3 = var3 >>> 8 ^ class119.field1979[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }
}
