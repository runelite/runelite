import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
public class class150 extends class136 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -5478896417047107669L
   )
   long field2267 = System.nanoTime();

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-93"
   )
   public void vmethod3141() {
      this.field2267 = System.nanoTime();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1894113900"
   )
   int vmethod3142(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.field2267 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class110.method2407(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2267 < var7); this.field2267 += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.field2267 < var7) {
         this.field2267 = var7;
      }

      return var9;
   }
}
