import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public class class151 extends class158 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1889141861
   )
   int field2189;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -510507085
   )
   int field2190;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1472603129
   )
   int field2191;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1069263519
   )
   int field2192;
   @ObfuscatedName("i")
   long[] field2193;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -3694528475591951749L
   )
   long field2194;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public void vmethod3024() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2193[var1] = 0L;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1657249328"
   )
   public int vmethod3022(int var1, int var2) {
      int var3 = this.field2192;
      int var4 = this.field2191;
      this.field2192 = 300;
      this.field2191 = 1;
      this.field2194 = class226.method4147();
      if(0L == this.field2193[this.field2189]) {
         this.field2192 = var3;
         this.field2191 = var4;
      } else if(this.field2194 > this.field2193[this.field2189]) {
         this.field2192 = (int)((long)(var1 * 2560) / (this.field2194 - this.field2193[this.field2189]));
      }

      if(this.field2192 < 25) {
         this.field2192 = 25;
      }

      if(this.field2192 > 256) {
         this.field2192 = 256;
         this.field2191 = (int)((long)var1 - (this.field2194 - this.field2193[this.field2189]) / 10L);
      }

      if(this.field2191 > var1) {
         this.field2191 = var1;
      }

      this.field2193[this.field2189] = this.field2194;
      this.field2189 = (this.field2189 + 1) % 10;
      int var5;
      if(this.field2191 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(this.field2193[var5] != 0L) {
               this.field2193[var5] += (long)this.field2191;
            }
         }
      }

      if(this.field2191 < var2) {
         this.field2191 = var2;
      }

      class19.method145((long)this.field2191);

      for(var5 = 0; this.field2190 < 256; this.field2190 += this.field2192) {
         ++var5;
      }

      this.field2190 &= 255;
      return var5;
   }

   public class151() {
      this.field2193 = new long[10];
      this.field2192 = 256;
      this.field2191 = 1;
      this.field2190 = 0;
      this.field2194 = class226.method4147();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2193[var1] = this.field2194;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "1272440506"
   )
   static MessageNode method2960(int var0) {
      return (MessageNode)class98.field1519.method3559((long)var0);
   }
}
