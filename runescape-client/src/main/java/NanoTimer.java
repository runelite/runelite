import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
@Implements("NanoTimer")
public class NanoTimer extends Timer {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -2688411897373911911L
   )
   @Export("nanoTime")
   long nanoTime;

   public NanoTimer() {
      this.nanoTime = System.nanoTime();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2072405029"
   )
   public void vmethod3369() {
      this.nanoTime = System.nanoTime();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2142133773"
   )
   public int vmethod3370(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.nanoTime - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      PacketBuffer.method3907(var5 / 1000000L);
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
