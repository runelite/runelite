import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
public class class98 extends class109 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 7127579269344509837L
   )
   long field1625 = System.nanoTime();

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1760425484"
   )
   void vmethod2017() {
      this.field1625 = System.nanoTime();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-4"
   )
   int vmethod2018(int var1, int var2) {
      long var3 = 1000000L * (long)var2;
      long var5 = this.field1625 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class10.method149(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field1625 < var7); this.field1625 += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.field1625 < var7) {
         this.field1625 = var7;
      }

      return var9;
   }
}
