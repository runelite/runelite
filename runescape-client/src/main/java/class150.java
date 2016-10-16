import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
public class class150 extends class136 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -5291939483838339947L
   )
   long field2262 = System.nanoTime();

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1749545983"
   )
   public void vmethod3110() {
      this.field2262 = System.nanoTime();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "179567807"
   )
   int vmethod3114(int var1, int var2) {
      long var3 = 1000000L * (long)var2;
      long var5 = this.field2262 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class16.method185(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2262 < var7); this.field2262 += 1000000L * (long)var1) {
         ++var9;
      }

      if(this.field2262 < var7) {
         this.field2262 = var7;
      }

      return var9;
   }
}
