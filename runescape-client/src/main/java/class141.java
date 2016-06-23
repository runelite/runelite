import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public class class141 extends class133 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1643279177
   )
   int field2163 = 1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -164144043
   )
   int field2164 = 256;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 513533521
   )
   int field2165;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -6072573127864566043L
   )
   long field2166 = class130.method2846();
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1018059717
   )
   int field2167 = 0;
   @ObfuscatedName("f")
   long[] field2168 = new long[10];

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IS)Lclass51;",
      garbageValue = "23633"
   )
   @Export("getItemDefinition")
   public static class51 method3001(int var0) {
      class51 var1 = (class51)class51.field1116.method3797((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class51.field1115.method3286(10, var0);
         var1 = new class51();
         var1.field1167 = var0;
         if(null != var2) {
            var1.method1077(new class119(var2));
         }

         var1.method1076();
         if(var1.field1153 != -1) {
            var1.method1079(method3001(var1.field1153), method3001(var1.field1152));
         }

         if(var1.field1162 != -1) {
            var1.method1128(method3001(var1.field1162), method3001(var1.field1161));
         }

         if(var1.field1164 != -1) {
            var1.method1081(method3001(var1.field1164), method3001(var1.field1163));
         }

         if(!class131.field2066 && var1.field1146) {
            var1.field1128 = "Members object";
            var1.field1160 = false;
            var1.field1136 = null;
            var1.field1149 = null;
            var1.field1159 = 0;
         }

         class51.field1116.method3788(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1973561307"
   )
   void vmethod3146() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2168[var1] = 0L;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1829064411"
   )
   int vmethod3147(int var1, int var2) {
      int var3 = this.field2164;
      int var4 = this.field2163;
      this.field2164 = 300;
      this.field2163 = 1;
      this.field2166 = class130.method2846();
      if(0L == this.field2168[this.field2165]) {
         this.field2164 = var3;
         this.field2163 = var4;
      } else if(this.field2166 > this.field2168[this.field2165]) {
         this.field2164 = (int)((long)(var1 * 2560) / (this.field2166 - this.field2168[this.field2165]));
      }

      if(this.field2164 < 25) {
         this.field2164 = 25;
      }

      if(this.field2164 > 256) {
         this.field2164 = 256;
         this.field2163 = (int)((long)var1 - (this.field2166 - this.field2168[this.field2165]) / 10L);
      }

      if(this.field2163 > var1) {
         this.field2163 = var1;
      }

      this.field2168[this.field2165] = this.field2166;
      this.field2165 = (this.field2165 + 1) % 10;
      int var5;
      if(this.field2163 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2168[var5]) {
               this.field2168[var5] += (long)this.field2163;
            }
         }
      }

      if(this.field2163 < var2) {
         this.field2163 = var2;
      }

      class98.method2264((long)this.field2163);

      for(var5 = 0; this.field2167 < 256; this.field2167 += this.field2164) {
         ++var5;
      }

      this.field2167 &= 255;
      return var5;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-128"
   )
   public static void method3009() {
      class47.field1081.method3796();
   }

   class141() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2168[var1] = this.field2166;
      }

   }
}
