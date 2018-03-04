import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
public class class221 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   class221 field2664;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   class221 field2663;

   @ObfuscatedName("d")
   public void method4183() {
      if(this.field2663 != null) {
         this.field2663.field2664 = this.field2664;
         this.field2664.field2663 = this.field2663;
         this.field2664 = null;
         this.field2663 = null;
      }
   }
}
