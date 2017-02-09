import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
public class class98 extends class109 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -5103383131222258889L
   )
   long field1640 = System.nanoTime();

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "96"
   )
   int vmethod2040(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.field1640 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class195.method3560(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field1640 < var7); this.field1640 += 1000000L * (long)var1) {
         ++var9;
      }

      if(this.field1640 < var7) {
         this.field1640 = var7;
      }

      return var9;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1203637754"
   )
   void vmethod2039() {
      this.field1640 = System.nanoTime();
   }
}
