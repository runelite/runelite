import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
public class class147 extends class133 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -2877603993594681117L
   )
   long field2231 = System.nanoTime();

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   void vmethod3104() {
      this.field2231 = System.nanoTime();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-650846426"
   )
   int vmethod3106(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.field2231 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class116.method2448(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2231 < var7); this.field2231 += 1000000L * (long)var1) {
         ++var9;
      }

      if(this.field2231 < var7) {
         this.field2231 = var7;
      }

      return var9;
   }
}
