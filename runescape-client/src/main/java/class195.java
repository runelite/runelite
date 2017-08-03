import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class195 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   class196 field2445;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   class196 field2446;

   public class195() {
      this.field2445 = new class196();
      this.field2445.field2447 = this.field2445;
      this.field2445.field2448 = this.field2445;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "()Lge;"
   )
   public class196 method3652() {
      class196 var1 = this.field2445.field2447;
      if(var1 == this.field2445) {
         this.field2446 = null;
         return null;
      } else {
         this.field2446 = var1.field2447;
         return var1;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lge;)V"
   )
   public void method3651(class196 var1) {
      if(var1.field2448 != null) {
         var1.method3661();
      }

      var1.field2448 = this.field2445.field2448;
      var1.field2447 = this.field2445;
      var1.field2448.field2447 = var1;
      var1.field2447.field2448 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "()Lge;"
   )
   public class196 method3657() {
      class196 var1 = this.field2446;
      if(var1 == this.field2445) {
         this.field2446 = null;
         return null;
      } else {
         this.field2446 = var1.field2447;
         return var1;
      }
   }
}
