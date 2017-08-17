import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class197 {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   class197 field2476;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   class197 field2477;

   @ObfuscatedName("j")
   public void method3644() {
      if(this.field2476 != null) {
         this.field2476.field2477 = this.field2477;
         this.field2477.field2476 = this.field2476;
         this.field2477 = null;
         this.field2476 = null;
      }
   }
}
