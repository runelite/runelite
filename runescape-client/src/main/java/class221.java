import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
public class class221 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   class221 field2647;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   class221 field2646;

   @ObfuscatedName("t")
   public void method4093() {
      if(this.field2646 != null) {
         this.field2646.field2647 = this.field2647;
         this.field2647.field2646 = this.field2646;
         this.field2647 = null;
         this.field2646 = null;
      }
   }
}
