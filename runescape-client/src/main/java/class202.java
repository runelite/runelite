import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public class class202 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   class203 field2570;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   class203 field2571;

   public class202() {
      this.field2570 = new class203();
      this.field2570.field2572 = this.field2570;
      this.field2570.field2573 = this.field2570;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lga;)V"
   )
   public void method3787(class203 var1) {
      if(var1.field2573 != null) {
         var1.method3799();
      }

      var1.field2573 = this.field2570.field2573;
      var1.field2572 = this.field2570;
      var1.field2573.field2572 = var1;
      var1.field2572.field2573 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "()Lga;"
   )
   public class203 method3788() {
      class203 var1 = this.field2570.field2572;
      if(var1 == this.field2570) {
         this.field2571 = null;
         return null;
      } else {
         this.field2571 = var1.field2572;
         return var1;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "()Lga;"
   )
   public class203 method3798() {
      class203 var1 = this.field2571;
      if(var1 == this.field2570) {
         this.field2571 = null;
         return null;
      } else {
         this.field2571 = var1.field2572;
         return var1;
      }
   }
}
