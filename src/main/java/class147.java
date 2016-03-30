import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eb")
public class class147 extends class133 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 7460354891777167527L
   )
   long field2240 = System.nanoTime();

   @ObfuscatedName("x")
   int vmethod3132(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.field2240 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class104.method2291(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2240 < var7); this.field2240 += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.field2240 < var7) {
         this.field2240 = var7;
      }

      return var9;
   }

   @ObfuscatedName("w")
   public void vmethod3139() {
      this.field2240 = System.nanoTime();
   }
}
