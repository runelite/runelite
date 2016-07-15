import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class150 extends class136 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 764777266152215311L
   )
   long field2269 = System.nanoTime();

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1910694462"
   )
   public void vmethod3206() {
      this.field2269 = System.nanoTime();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1099668861"
   )
   int vmethod3207(int var1, int var2) {
      long var3 = 1000000L * (long)var2;
      long var5 = this.field2269 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class125.method2881(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2269 < var7); this.field2269 += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.field2269 < var7) {
         this.field2269 = var7;
      }

      return var9;
   }
}
