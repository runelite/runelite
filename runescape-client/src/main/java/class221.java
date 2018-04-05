import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
public class class221 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   class221 field2663;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   class221 field2662;

   @ObfuscatedName("o")
   public void method4067() {
      if(this.field2662 != null) {
         this.field2662.field2663 = this.field2663;
         this.field2663.field2662 = this.field2662;
         this.field2663 = null;
         this.field2662 = null;
      }
   }
}
