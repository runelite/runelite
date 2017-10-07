import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
public class class196 {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   class196 field2494;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   class196 field2493;

   @ObfuscatedName("d")
   public void method3757() {
      if(this.field2494 != null) {
         this.field2494.field2493 = this.field2493;
         this.field2493.field2494 = this.field2494;
         this.field2493 = null;
         this.field2494 = null;
      }
   }
}
