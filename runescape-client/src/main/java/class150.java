import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
public class class150 extends class136 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 9139991545930062493L
   )
   long field2271 = System.nanoTime();

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-53"
   )
   void vmethod3147() {
      this.field2271 = System.nanoTime();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-9037346"
   )
   int vmethod3148(int var1, int var2) {
      long var3 = 1000000L * (long)var2;
      long var5 = this.field2271 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      PlayerComposition.method3511(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2271 < var7); this.field2271 += 1000000L * (long)var1) {
         ++var9;
      }

      if(this.field2271 < var7) {
         this.field2271 = var7;
      }

      return var9;
   }
}
