import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public class class202 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   class203 field2561;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   class203 field2562;

   public class202() {
      this.field2561 = new class203();
      this.field2561.field2563 = this.field2561;
      this.field2561.field2564 = this.field2561;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgo;)V"
   )
   public void method3680(class203 var1) {
      if(var1.field2564 != null) {
         var1.method3689();
      }

      var1.field2564 = this.field2561.field2564;
      var1.field2563 = this.field2561;
      var1.field2564.field2563 = var1;
      var1.field2563.field2564 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "()Lgo;"
   )
   public class203 method3684() {
      class203 var1 = this.field2561.field2563;
      if(var1 == this.field2561) {
         this.field2562 = null;
         return null;
      } else {
         this.field2562 = var1.field2563;
         return var1;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "()Lgo;"
   )
   public class203 method3681() {
      class203 var1 = this.field2562;
      if(var1 == this.field2561) {
         this.field2562 = null;
         return null;
      } else {
         this.field2562 = var1.field2563;
         return var1;
      }
   }
}
