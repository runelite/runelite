import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
public class class150 extends class158 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -592005909965381929L
   )
   long field2212;

   public class150() {
      this.field2212 = System.nanoTime();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1057188703"
   )
   public void vmethod2872() {
      this.field2212 = System.nanoTime();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1409293417"
   )
   public int vmethod2868(int var1, int var2) {
      long var3 = 1000000L * (long)var2;
      long var5 = this.field2212 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class172.method3014(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2212 < var7); this.field2212 += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.field2212 < var7) {
         this.field2212 = var7;
      }

      return var9;
   }
}
