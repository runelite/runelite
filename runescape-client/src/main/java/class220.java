import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
public class class220 {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   class221 field2667;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   class221 field2666;

   public class220() {
      this.field2667 = new class221();
      this.field2667.field2669 = this.field2667;
      this.field2667.field2668 = this.field2667;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lhv;)V"
   )
   public void method4153(class221 var1) {
      if(var1.field2668 != null) {
         var1.method4165();
      }

      var1.field2668 = this.field2667.field2668;
      var1.field2669 = this.field2667;
      var1.field2668.field2669 = var1;
      var1.field2669.field2668 = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "()Lhv;"
   )
   public class221 method4154() {
      class221 var1 = this.field2667.field2669;
      if(var1 == this.field2667) {
         this.field2666 = null;
         return null;
      } else {
         this.field2666 = var1.field2669;
         return var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "()Lhv;"
   )
   public class221 method4152() {
      class221 var1 = this.field2666;
      if(var1 == this.field2667) {
         this.field2666 = null;
         return null;
      } else {
         this.field2666 = var1.field2669;
         return var1;
      }
   }
}
