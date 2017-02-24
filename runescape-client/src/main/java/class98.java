import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
public class class98 extends class109 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = 3870568993586117417L
   )
   long field1642 = System.nanoTime();

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1005407619"
   )
   public void vmethod2107() {
      this.field1642 = System.nanoTime();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "-4340"
   )
   int vmethod2108(int var1, int var2) {
      long var3 = 1000000L * (long)var2;
      long var5 = this.field1642 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class115.method2292(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field1642 < var7); this.field1642 += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.field1642 < var7) {
         this.field1642 = var7;
      }

      return var9;
   }
}
