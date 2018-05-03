import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
public class class221 {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   class221 field2669;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   class221 field2668;

   @ObfuscatedName("g")
   public void method4165() {
      if(this.field2668 != null) {
         this.field2668.field2669 = this.field2669;
         this.field2669.field2668 = this.field2668;
         this.field2669 = null;
         this.field2668 = null;
      }
   }
}
