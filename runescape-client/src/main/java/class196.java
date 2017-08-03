import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class196 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   class196 field2448;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   class196 field2447;

   @ObfuscatedName("d")
   public void method3661() {
      if(this.field2448 != null) {
         this.field2448.field2447 = this.field2447;
         this.field2447.field2448 = this.field2448;
         this.field2447 = null;
         this.field2448 = null;
      }
   }
}
