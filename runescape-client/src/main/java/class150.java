import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
public class class150 extends class136 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -2148280377516213599L
   )
   long field2281 = System.nanoTime();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public void vmethod3260() {
      this.field2281 = System.nanoTime();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1964270008"
   )
   int vmethod3261(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.field2281 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class22.method594(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2281 < var7); this.field2281 += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.field2281 < var7) {
         this.field2281 = var7;
      }

      return var9;
   }
}
