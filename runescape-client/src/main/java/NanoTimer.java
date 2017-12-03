import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("NanoTimer")
public class NanoTimer extends Timer {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = 5541093550852491481L
   )
   @Export("nanoTime")
   long nanoTime;

   public NanoTimer() {
      this.nanoTime = System.nanoTime();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-515402785"
   )
   public void vmethod3074() {
      this.nanoTime = System.nanoTime();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "501278963"
   )
   public int vmethod3075(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.nanoTime - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      World.method1500(var5 / 1000000L);
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
}
