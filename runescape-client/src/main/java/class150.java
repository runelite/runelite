import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public class class150 extends class136 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -2481659439398723251L
   )
   long field2269 = System.nanoTime();

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1507060313"
   )
   int vmethod3137(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.field2269 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class127.method2846(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2269 < var7); this.field2269 += 1000000L * (long)var1) {
         ++var9;
      }

      if(this.field2269 < var7) {
         this.field2269 = var7;
      }

      return var9;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-355225866"
   )
   void vmethod3139() {
      this.field2269 = System.nanoTime();
   }
}
