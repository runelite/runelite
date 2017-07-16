import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
public class class196 {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   class196 field2473;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   class196 field2474;

   @ObfuscatedName("a")
   public void method3639() {
      if(this.field2473 != null) {
         this.field2473.field2474 = this.field2474;
         this.field2474.field2473 = this.field2473;
         this.field2474 = null;
         this.field2473 = null;
      }
   }
}
