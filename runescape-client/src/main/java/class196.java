import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
public class class196 {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   class196 field2445;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   class196 field2446;

   @ObfuscatedName("c")
   public void method3588() {
      if(this.field2445 != null) {
         this.field2445.field2446 = this.field2446;
         this.field2446.field2445 = this.field2445;
         this.field2446 = null;
         this.field2445 = null;
      }
   }
}
