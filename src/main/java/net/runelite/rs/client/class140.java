import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ei")
public class class140 extends class132 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1567700277
   )
   int field2173 = 0;
   @ObfuscatedName("j")
   long[] field2174 = new long[10];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -6667127697011564685L
   )
   long field2175 = class109.method2381();
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -385234901
   )
   int field2176 = 1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2065593005
   )
   int field2177;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2052904567
   )
   int field2178 = 256;

   @ObfuscatedName("l")
   void vmethod3066() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2174[var1] = 0L;
      }

   }

   @ObfuscatedName("a")
   int vmethod3067(int var1, int var2) {
      int var3 = this.field2178;
      int var4 = this.field2176;
      this.field2178 = 300;
      this.field2176 = 1;
      this.field2175 = class109.method2381();
      if(this.field2174[this.field2177] == 0L) {
         this.field2178 = var3;
         this.field2176 = var4;
      } else if(this.field2175 > this.field2174[this.field2177]) {
         this.field2178 = (int)((long)(2560 * var1) / (this.field2175 - this.field2174[this.field2177]));
      }

      if(this.field2178 < 25) {
         this.field2178 = 25;
      }

      if(this.field2178 > 256) {
         this.field2178 = 256;
         this.field2176 = (int)((long)var1 - (this.field2175 - this.field2174[this.field2177]) / 10L);
      }

      if(this.field2176 > var1) {
         this.field2176 = var1;
      }

      this.field2174[this.field2177] = this.field2175;
      this.field2177 = (1 + this.field2177) % 10;
      int var5;
      if(this.field2176 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(this.field2174[var5] != 0L) {
               this.field2174[var5] += (long)this.field2176;
            }
         }
      }

      if(this.field2176 < var2) {
         this.field2176 = var2;
      }

      class105.method2332((long)this.field2176);

      for(var5 = 0; this.field2173 < 256; this.field2173 += this.field2178) {
         ++var5;
      }

      this.field2173 &= 255;
      return var5;
   }

   class140() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2174[var1] = this.field2175;
      }

   }

   @ObfuscatedName("dm")
   static final void method2923(String var0) {
      if(var0 != null) {
         String var1 = class134.method2803(var0, client.field473);
         if(var1 != null) {
            for(int var2 = 0; var2 < client.field421; ++var2) {
               class17 var3 = client.field557[var2];
               String var4 = var3.field253;
               String var5 = class134.method2803(var4, client.field473);
               boolean var6;
               if(null != var0 && null != var4) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --client.field421;

                  for(int var7 = var2; var7 < client.field421; ++var7) {
                     client.field557[var7] = client.field557[var7 + 1];
                  }

                  client.field481 = client.field392;
                  client.field329.method2686(210);
                  client.field329.method2438(class36.method742(var0));
                  client.field329.method2444(var0);
                  break;
               }
            }

         }
      }
   }
}
