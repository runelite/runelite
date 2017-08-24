import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bb")
public class class71 implements Runnable {
   @ObfuscatedName("i")
   boolean field881;
   @ObfuscatedName("j")
   Object field878;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1218860241
   )
   int field880;
   @ObfuscatedName("r")
   int[] field879;
   @ObfuscatedName("o")
   int[] field882;

   class71() {
      this.field881 = true;
      this.field878 = new Object();
      this.field880 = 0;
      this.field879 = new int[500];
      this.field882 = new int[500];
   }

   public void run() {
      for(; this.field881; NPC.method1702(50L)) {
         Object var1 = this.field878;
         synchronized(this.field878) {
            if(this.field880 < 500) {
               this.field879[this.field880] = MouseInput.field752;
               this.field882[this.field880] = MouseInput.field747;
               ++this.field880;
            }
         }
      }

   }
}
