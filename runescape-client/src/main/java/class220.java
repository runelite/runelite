import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
public class class220 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   class221 field2661;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   class221 field2660;

   public class220() {
      this.field2661 = new class221();
      this.field2661.field2663 = this.field2661;
      this.field2661.field2662 = this.field2661;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lhl;)V"
   )
   public void method4057(class221 var1) {
      if(var1.field2662 != null) {
         var1.method4067();
      }

      var1.field2662 = this.field2661.field2662;
      var1.field2663 = this.field2661;
      var1.field2662.field2663 = var1;
      var1.field2663.field2662 = var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "()Lhl;"
   )
   public class221 method4061() {
      class221 var1 = this.field2661.field2663;
      if(var1 == this.field2661) {
         this.field2660 = null;
         return null;
      } else {
         this.field2660 = var1.field2663;
         return var1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "()Lhl;"
   )
   public class221 method4060() {
      class221 var1 = this.field2660;
      if(var1 == this.field2661) {
         this.field2660 = null;
         return null;
      } else {
         this.field2660 = var1.field2663;
         return var1;
      }
   }
}
