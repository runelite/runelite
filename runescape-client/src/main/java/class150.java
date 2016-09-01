import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
public class class150 extends class136 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 6385516175698876275L
   )
   long field2275 = System.nanoTime();

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "10"
   )
   int vmethod3169(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.field2275 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class125.method2820(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2275 < var7); this.field2275 += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.field2275 < var7) {
         this.field2275 = var7;
      }

      return var9;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1920699192"
   )
   void vmethod3173() {
      this.field2275 = System.nanoTime();
   }
}
