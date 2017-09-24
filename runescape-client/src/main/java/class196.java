import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
public class class196 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   class197 field2480;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   class197 field2479;

   public class196() {
      this.field2480 = new class197();
      this.field2480.field2481 = this.field2480;
      this.field2480.field2482 = this.field2480;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "()Lgb;"
   )
   public class197 method3711() {
      class197 var1 = this.field2480.field2481;
      if(var1 == this.field2480) {
         this.field2479 = null;
         return null;
      } else {
         this.field2479 = var1.field2481;
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgb;)V"
   )
   public void method3710(class197 var1) {
      if(var1.field2482 != null) {
         var1.method3726();
      }

      var1.field2482 = this.field2480.field2482;
      var1.field2481 = this.field2480;
      var1.field2482.field2481 = var1;
      var1.field2481.field2482 = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "()Lgb;"
   )
   public class197 method3712() {
      class197 var1 = this.field2479;
      if(var1 == this.field2480) {
         this.field2479 = null;
         return null;
      } else {
         this.field2479 = var1.field2481;
         return var1;
      }
   }
}
