import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public class class98 extends class109 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 6424265186537277851L
   )
   long field1648 = System.nanoTime();

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "531304005"
   )
   int vmethod2108(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.field1648 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class140.method2660(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field1648 < var7); this.field1648 += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.field1648 < var7) {
         this.field1648 = var7;
      }

      return var9;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-42"
   )
   public void vmethod2107() {
      this.field1648 = System.nanoTime();
   }
}
