import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class220 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   class221 field2644;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   class221 field2645;

   public class220() {
      this.field2644 = new class221();
      this.field2644.field2647 = this.field2644;
      this.field2644.field2646 = this.field2644;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lha;)V"
   )
   public void method4083(class221 var1) {
      if(var1.field2646 != null) {
         var1.method4093();
      }

      var1.field2646 = this.field2644.field2646;
      var1.field2647 = this.field2644;
      var1.field2646.field2647 = var1;
      var1.field2647.field2646 = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "()Lha;"
   )
   public class221 method4084() {
      class221 var1 = this.field2644.field2647;
      if(var1 == this.field2644) {
         this.field2645 = null;
         return null;
      } else {
         this.field2645 = var1.field2647;
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "()Lha;"
   )
   public class221 method4085() {
      class221 var1 = this.field2645;
      if(var1 == this.field2644) {
         this.field2645 = null;
         return null;
      } else {
         this.field2645 = var1.field2647;
         return var1;
      }
   }
}
