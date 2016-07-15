import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
public class class144 extends class136 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 787254171
   )
   int field2215 = 256;
   @ObfuscatedName("e")
   long[] field2216 = new long[10];
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1499424829
   )
   int field2217 = 1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1968872901
   )
   int field2219 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -189368661
   )
   int field2220;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 7677315090656579923L
   )
   long field2222 = client.method424();

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1099668861"
   )
   int vmethod3207(int var1, int var2) {
      int var3 = this.field2215;
      int var4 = this.field2217;
      this.field2215 = 300;
      this.field2217 = 1;
      this.field2222 = client.method424();
      if(this.field2216[this.field2220] == 0L) {
         this.field2215 = var3;
         this.field2217 = var4;
      } else if(this.field2222 > this.field2216[this.field2220]) {
         this.field2215 = (int)((long)(2560 * var1) / (this.field2222 - this.field2216[this.field2220]));
      }

      if(this.field2215 < 25) {
         this.field2215 = 25;
      }

      if(this.field2215 > 256) {
         this.field2215 = 256;
         this.field2217 = (int)((long)var1 - (this.field2222 - this.field2216[this.field2220]) / 10L);
      }

      if(this.field2217 > var1) {
         this.field2217 = var1;
      }

      this.field2216[this.field2220] = this.field2222;
      this.field2220 = (1 + this.field2220) % 10;
      int var5;
      if(this.field2217 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2216[var5]) {
               this.field2216[var5] += (long)this.field2217;
            }
         }
      }

      if(this.field2217 < var2) {
         this.field2217 = var2;
      }

      class125.method2881((long)this.field2217);

      for(var5 = 0; this.field2219 < 256; this.field2219 += this.field2215) {
         ++var5;
      }

      this.field2219 &= 255;
      return var5;
   }

   class144() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2216[var1] = this.field2222;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1910694462"
   )
   public void vmethod3206() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2216[var1] = 0L;
      }

   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(Lclass176;IIZB)V",
      garbageValue = "66"
   )
   static void method3078(class176 var0, int var1, int var2, boolean var3) {
      int var4 = var0.field2866;
      int var5 = var0.field2810;
      if(var0.field2823 == 0) {
         var0.field2866 = var0.field2805;
      } else if(var0.field2823 == 1) {
         var0.field2866 = var1 - var0.field2805;
      } else if(var0.field2823 == 2) {
         var0.field2866 = var1 * var0.field2805 >> 14;
      }

      if(var0.field2802 == 0) {
         var0.field2810 = var0.field2806;
      } else if(var0.field2802 == 1) {
         var0.field2810 = var2 - var0.field2806;
      } else if(var0.field2802 == 2) {
         var0.field2810 = var0.field2806 * var2 >> 14;
      }

      if(var0.field2823 == 4) {
         var0.field2866 = var0.field2860 * var0.field2810 / var0.field2812;
      }

      if(var0.field2802 == 4) {
         var0.field2810 = var0.field2866 * var0.field2812 / var0.field2860;
      }

      if(client.field464 && var0.field2796 == 0) {
         if(var0.field2810 < 5 && var0.field2866 < 5) {
            var0.field2810 = 5;
            var0.field2866 = 5;
         } else {
            if(var0.field2810 <= 0) {
               var0.field2810 = 5;
            }

            if(var0.field2866 <= 0) {
               var0.field2866 = 5;
            }
         }
      }

      if(var0.field2916 == 1337) {
         client.field445 = var0;
      }

      if(var3 && null != var0.field2903 && (var4 != var0.field2866 || var0.field2810 != var5)) {
         class0 var6 = new class0();
         var6.field2 = var0;
         var6.field4 = var0.field2903;
         client.field357.method3895(var6);
      }

   }
}
