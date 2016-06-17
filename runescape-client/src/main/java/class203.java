import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gk")
@Implements("Node2LinkedList")
public final class class203 {
   @ObfuscatedName("b")
   @Export("sentinel")
   class204 field3102 = new class204();

   public class203() {
      this.field3102.field3103 = this.field3102;
      this.field3102.field3104 = this.field3102;
   }

   @ObfuscatedName("b")
   public void method3873(class204 var1) {
      if(var1.field3104 != null) {
         var1.method3889();
      }

      var1.field3104 = this.field3102.field3104;
      var1.field3103 = this.field3102;
      var1.field3104.field3103 = var1;
      var1.field3103.field3104 = var1;
   }

   @ObfuscatedName("x")
   void method3877() {
      while(true) {
         class204 var1 = this.field3102.field3103;
         if(var1 == this.field3102) {
            return;
         }

         var1.method3889();
      }
   }

   @ObfuscatedName("g")
   public void method3880(class204 var1) {
      if(var1.field3104 != null) {
         var1.method3889();
      }

      var1.field3104 = this.field3102;
      var1.field3103 = this.field3102.field3103;
      var1.field3104.field3103 = var1;
      var1.field3103.field3104 = var1;
   }

   @ObfuscatedName("d")
   public class204 method3885() {
      class204 var1 = this.field3102.field3103;
      return var1 == this.field3102?null:var1;
   }

   @ObfuscatedName("j")
   class204 method3886() {
      class204 var1 = this.field3102.field3103;
      if(var1 == this.field3102) {
         return null;
      } else {
         var1.method3889();
         return var1;
      }
   }
}
