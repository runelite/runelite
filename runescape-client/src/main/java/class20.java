import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("a")
public class class20 implements Runnable {
   @ObfuscatedName("j")
   int[] field224 = new int[500];
   @ObfuscatedName("d")
   Object field225 = new Object();
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -87264857
   )
   int field226 = 0;
   @ObfuscatedName("av")
   static class184 field228;
   @ObfuscatedName("kv")
   @Export("chatMessages")
   static ChatMessages chatMessages;
   @ObfuscatedName("q")
   boolean field233 = true;
   @ObfuscatedName("p")
   int[] field234 = new int[500];

   public void run() {
      for(; this.field233; class115.method2292(50L)) {
         Object var1 = this.field225;
         synchronized(this.field225) {
            if(this.field226 < 500) {
               this.field234[this.field226] = class115.field1792;
               this.field224[this.field226] = class115.field1799;
               ++this.field226;
            }
         }
      }

   }
}
