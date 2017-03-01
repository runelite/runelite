import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
public class class98 extends class109 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -5268077134712532419L
   )
   long field1643 = System.nanoTime();

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1258551841"
   )
   int vmethod2133(int var1, int var2) {
      long var3 = 1000000L * (long)var2;
      long var5 = this.field1643 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class47.method970(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field1643 < var7); this.field1643 += 1000000L * (long)var1) {
         ++var9;
      }

      if(this.field1643 < var7) {
         this.field1643 = var7;
      }

      return var9;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "558296171"
   )
   void vmethod2132() {
      this.field1643 = System.nanoTime();
   }
}
