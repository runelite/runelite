import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public class class147 extends class133 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 8295654595722667411L
   )
   long field2204 = System.nanoTime();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "85"
   )
   int vmethod3123(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.field2204 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class116.method2459(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2204 < var7); this.field2204 += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.field2204 < var7) {
         this.field2204 = var7;
      }

      return var9;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   public void vmethod3124() {
      this.field2204 = System.nanoTime();
   }
}
