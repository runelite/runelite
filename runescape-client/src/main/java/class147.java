import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
public class class147 extends class133 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = -6876303366425337813L
   )
   long field2254 = System.nanoTime();

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-38"
   )
   void vmethod3081() {
      this.field2254 = System.nanoTime();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "255"
   )
   int vmethod3083(int var1, int var2) {
      long var3 = 1000000L * (long)var2;
      long var5 = this.field2254 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class45.method926(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2254 < var7); this.field2254 += 1000000L * (long)var1) {
         ++var9;
      }

      if(this.field2254 < var7) {
         this.field2254 = var7;
      }

      return var9;
   }
}
