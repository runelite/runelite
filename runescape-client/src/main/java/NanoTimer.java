import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
@Implements("NanoTimer")
public class NanoTimer extends Timer {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 8810956519110090769L
   )
   @Export("nanoTime")
   long nanoTime;

   public NanoTimer() {
      this.nanoTime = System.nanoTime();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "19136800"
   )
   public int vmethod3051(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.nanoTime - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      NPC.method1702(var5 / 1000000L);
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "61"
   )
   public void vmethod3050() {
      this.nanoTime = System.nanoTime();
   }
}
