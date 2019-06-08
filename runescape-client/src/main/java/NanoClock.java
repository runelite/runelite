import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
@Implements("NanoClock")
public class NanoClock extends Clock {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 7586221391557635221L
   )
   @Export("lastTimeNano")
   long lastTimeNano;

   public NanoClock() {
      this.lastTimeNano = System.nanoTime();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "61"
   )
   public void mark() {
      this.lastTimeNano = System.nanoTime();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-126803683"
   )
   public int wait(int var1, int var2) {
      long var3 = 1000000L * (long)var2;
      long var5 = this.lastTimeNano - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      class203.method4010(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.lastTimeNano < var7); this.lastTimeNano += 1000000L * (long)var1) {
         ++var9;
      }

      if(this.lastTimeNano < var7) {
         this.lastTimeNano = var7;
      }

      return var9;
   }
}
