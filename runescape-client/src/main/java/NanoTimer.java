import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
@Implements("NanoTimer")
public class NanoTimer extends Timer {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 3003208737681535683L
   )
   @Export("nanoTime")
   long nanoTime;

   NanoTimer() {
      this.nanoTime = System.nanoTime();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2139277964"
   )
   public int vmethod2910(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.nanoTime - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      Occluder.method2829(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.nanoTime < var7); this.nanoTime += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.nanoTime < var7) {
         this.nanoTime = var7;
      }

      return var9;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2145399515"
   )
   public void vmethod2909() {
      this.nanoTime = System.nanoTime();
   }
}
