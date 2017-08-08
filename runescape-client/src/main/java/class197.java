import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
public class class197 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   class197 field2460;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   class197 field2459;

   @ObfuscatedName("e")
   public void method3644() {
      if(this.field2460 != null) {
         this.field2460.field2459 = this.field2459;
         this.field2459.field2460 = this.field2460;
         this.field2459 = null;
         this.field2460 = null;
      }
   }
}
