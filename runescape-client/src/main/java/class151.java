import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
public class class151 extends class158 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = 385531456729930505L
   )
   long field2213;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1317975031
   )
   int field2214;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 864382979
   )
   int field2216;
   @ObfuscatedName("p")
   long[] field2217;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -333898393
   )
   int field2218;
   @ObfuscatedName("bp")
   static String field2219;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -862031493
   )
   int field2222;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1057188703"
   )
   public void vmethod2872() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2217[var1] = 0L;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1409293417"
   )
   public int vmethod2868(int var1, int var2) {
      int var3 = this.field2214;
      int var4 = this.field2222;
      this.field2214 = 300;
      this.field2222 = 1;
      this.field2213 = class166.method2970();
      if(this.field2217[this.field2218] == 0L) {
         this.field2214 = var3;
         this.field2222 = var4;
      } else if(this.field2213 > this.field2217[this.field2218]) {
         this.field2214 = (int)((long)(var1 * 2560) / (this.field2213 - this.field2217[this.field2218]));
      }

      if(this.field2214 < 25) {
         this.field2214 = 25;
      }

      if(this.field2214 > 256) {
         this.field2214 = 256;
         this.field2222 = (int)((long)var1 - (this.field2213 - this.field2217[this.field2218]) / 10L);
      }

      if(this.field2222 > var1) {
         this.field2222 = var1;
      }

      this.field2217[this.field2218] = this.field2213;
      this.field2218 = (this.field2218 + 1) % 10;
      int var5;
      if(this.field2222 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(this.field2217[var5] != 0L) {
               this.field2217[var5] += (long)this.field2222;
            }
         }
      }

      if(this.field2222 < var2) {
         this.field2222 = var2;
      }

      class172.method3014((long)this.field2222);

      for(var5 = 0; this.field2216 < 256; this.field2216 += this.field2214) {
         ++var5;
      }

      this.field2216 &= 255;
      return var5;
   }

   public class151() {
      this.field2217 = new long[10];
      this.field2214 = 256;
      this.field2222 = 1;
      this.field2216 = 0;
      this.field2213 = class166.method2970();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2217[var1] = this.field2213;
      }

   }
}
