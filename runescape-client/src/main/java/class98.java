import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
public class class98 extends class109 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -288399409922971103L
   )
   long field1633 = System.nanoTime();

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1528878866"
   )
   void vmethod2090() {
      this.field1633 = System.nanoTime();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1778689612"
   )
   int vmethod2091(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.field1633 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class0.method12(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field1633 < var7); this.field1633 += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.field1633 < var7) {
         this.field1633 = var7;
      }

      return var9;
   }
}
