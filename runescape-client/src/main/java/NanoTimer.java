import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
@Implements("NanoTimer")
public class NanoTimer extends Timer {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -7916723330514626727L
   )
   @Export("nanoTime")
   long nanoTime;

   NanoTimer() {
      this.nanoTime = System.nanoTime();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1055561234"
   )
   public int vmethod3006(int var1, int var2) {
      long var3 = 1000000L * (long)var2;
      long var5 = this.nanoTime - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      GroundObject.method2492(var5 / 1000000L);
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "60"
   )
   public void vmethod3003() {
      this.nanoTime = System.nanoTime();
   }
}
