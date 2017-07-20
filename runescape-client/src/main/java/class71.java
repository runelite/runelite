import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("be")
public class class71 implements Runnable {
   @ObfuscatedName("c")
   boolean field854;
   @ObfuscatedName("o")
   Object field849;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 924871467
   )
   int field850;
   @ObfuscatedName("u")
   int[] field853;
   @ObfuscatedName("g")
   int[] field852;

   class71() {
      this.field854 = true;
      this.field849 = new Object();
      this.field850 = 0;
      this.field853 = new int[500];
      this.field852 = new int[500];
   }

   public void run() {
      for(; this.field854; Occluder.method2829(50L)) {
         Object var1 = this.field849;
         synchronized(this.field849) {
            if(this.field850 < 500) {
               this.field853[this.field850] = MouseInput.field730;
               this.field852[this.field850] = MouseInput.field731;
               ++this.field850;
            }
         }
      }

   }
}
