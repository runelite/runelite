import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public class class150 extends class158 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -5858017694520729597L
   )
   long field2188;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1657249328"
   )
   public int vmethod3022(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.field2188 - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class19.method145(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.field2188 < var7); this.field2188 += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.field2188 < var7) {
         this.field2188 = var7;
      }

      return var9;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public void vmethod3024() {
      this.field2188 = System.nanoTime();
   }

   public class150() {
      this.field2188 = System.nanoTime();
   }
}
