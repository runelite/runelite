import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
public class class150 extends class136 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 1618660608418860907L
   )
   long field2283 = System.nanoTime();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public void vmethod3165() {
      this.field2283 = System.nanoTime();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1590628949"
   )
   int vmethod3166(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.field2283 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class141.method2993(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2283 < var7); this.field2283 += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.field2283 < var7) {
         this.field2283 = var7;
      }

      return var9;
   }
}
