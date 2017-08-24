import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class197 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   class197 field2482;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   class197 field2481;

   @ObfuscatedName("i")
   public void method3726() {
      if(this.field2482 != null) {
         this.field2482.field2481 = this.field2481;
         this.field2481.field2482 = this.field2482;
         this.field2481 = null;
         this.field2482 = null;
      }
   }
}
