import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
@Implements("NanoTimer")
public class NanoTimer extends Timer {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -5948326346392005639L
   )
   @Export("nanoTime")
   long nanoTime;

   public NanoTimer() {
      this.nanoTime = System.nanoTime();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "16776960"
   )
   public void vmethod3305() {
      this.nanoTime = System.nanoTime();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-13"
   )
   public int vmethod3306(int var1, int var2) {
      long var3 = 1000000L * (long)var2;
      long var5 = this.nanoTime - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class19.method152(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.nanoTime < var7); this.nanoTime += 1000000L * (long)var1) {
         ++var9;
      }

      if(this.nanoTime < var7) {
         this.nanoTime = var7;
      }

      return var9;
   }
}
