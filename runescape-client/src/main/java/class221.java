import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class221 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   class221 field2654;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   class221 field2653;

   @ObfuscatedName("c")
   public void method4069() {
      if(this.field2653 != null) {
         this.field2653.field2654 = this.field2654;
         this.field2654.field2653 = this.field2653;
         this.field2654 = null;
         this.field2653 = null;
      }
   }
}
