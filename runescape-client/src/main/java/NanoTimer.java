import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
@Implements("NanoTimer")
public class NanoTimer extends Timer {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -8135542824352080067L
   )
   @Export("nanoTime")
   long nanoTime;

   public NanoTimer() {
      this.nanoTime = System.nanoTime();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "18922"
   )
   public void vmethod2996() {
      this.nanoTime = System.nanoTime();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1469616290"
   )
   public int vmethod2993(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.nanoTime - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      GZipDecompressor.method3129(var5 / 1000000L);
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
