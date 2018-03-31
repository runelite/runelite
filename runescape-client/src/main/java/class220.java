import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
public class class220 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   class221 field2652;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   class221 field2651;

   public class220() {
      this.field2652 = new class221();
      this.field2652.field2654 = this.field2652;
      this.field2652.field2653 = this.field2652;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lhn;)V"
   )
   public void method4067(class221 var1) {
      if(var1.field2653 != null) {
         var1.method4069();
      }

      var1.field2653 = this.field2652.field2653;
      var1.field2654 = this.field2652;
      var1.field2653.field2654 = var1;
      var1.field2654.field2653 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "()Lhn;"
   )
   public class221 method4061() {
      class221 var1 = this.field2652.field2654;
      if(var1 == this.field2652) {
         this.field2651 = null;
         return null;
      } else {
         this.field2651 = var1.field2654;
         return var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "()Lhn;"
   )
   public class221 method4062() {
      class221 var1 = this.field2651;
      if(var1 == this.field2652) {
         this.field2651 = null;
         return null;
      } else {
         this.field2651 = var1.field2654;
         return var1;
      }
   }
}
