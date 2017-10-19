import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
public class class196 {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   class196 field2473;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   class196 field2472;

   @ObfuscatedName("w")
   public void method3726() {
      if(this.field2473 != null) {
         this.field2473.field2472 = this.field2472;
         this.field2472.field2473 = this.field2473;
         this.field2472 = null;
         this.field2473 = null;
      }
   }
}
