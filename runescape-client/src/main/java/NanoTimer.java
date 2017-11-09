import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
@Implements("NanoTimer")
public class NanoTimer extends Timer {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 332395258898066207L
   )
   @Export("nanoTime")
   long nanoTime;

   public NanoTimer() {
      this.nanoTime = System.nanoTime();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-3"
   )
   public void vmethod3096() {
      this.nanoTime = System.nanoTime();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-553632509"
   )
   public int vmethod3095(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.nanoTime - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class61.method1130(var5 / 1000000L);
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
