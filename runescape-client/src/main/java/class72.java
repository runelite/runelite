import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class72 implements Runnable {
   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   static Widget field879;
   @ObfuscatedName("j")
   boolean field877;
   @ObfuscatedName("h")
   Object field875;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1207632709
   )
   int field876;
   @ObfuscatedName("p")
   int[] field878;
   @ObfuscatedName("x")
   int[] field874;

   class72() {
      this.field877 = true;
      this.field875 = new Object();
      this.field876 = 0;
      this.field878 = new int[500];
      this.field874 = new int[500];
   }

   public void run() {
      for(; this.field877; class10.method51(50L)) {
         Object var1 = this.field875;
         synchronized(this.field875) {
            if(this.field876 < 500) {
               this.field878[this.field876] = MouseInput.field734;
               this.field874[this.field876] = MouseInput.field735;
               ++this.field876;
            }
         }
      }

   }
}
