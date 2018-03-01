import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
public class class220 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   class221 field2661;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   class221 field2662;

   public class220() {
      this.field2661 = new class221();
      this.field2661.field2664 = this.field2661;
      this.field2661.field2663 = this.field2661;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lha;)V"
   )
   public void method4175(class221 var1) {
      if(var1.field2663 != null) {
         var1.method4183();
      }

      var1.field2663 = this.field2661.field2663;
      var1.field2664 = this.field2661;
      var1.field2663.field2664 = var1;
      var1.field2664.field2663 = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "()Lha;"
   )
   public class221 method4174() {
      class221 var1 = this.field2661.field2664;
      if(var1 == this.field2661) {
         this.field2662 = null;
         return null;
      } else {
         this.field2662 = var1.field2664;
         return var1;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "()Lha;"
   )
   public class221 method4180() {
      class221 var1 = this.field2662;
      if(var1 == this.field2661) {
         this.field2662 = null;
         return null;
      } else {
         this.field2662 = var1.field2664;
         return var1;
      }
   }
}
