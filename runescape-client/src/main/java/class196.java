import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
public class class196 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   class197 field2458;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   class197 field2457;

   public class196() {
      this.field2457 = new class197();
      this.field2457.field2459 = this.field2457;
      this.field2457.field2460 = this.field2457;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "()Lgd;"
   )
   public class197 method3637() {
      class197 var1 = this.field2457.field2459;
      if(var1 == this.field2457) {
         this.field2458 = null;
         return null;
      } else {
         this.field2458 = var1.field2459;
         return var1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgd;)V"
   )
   public void method3635(class197 var1) {
      if(var1.field2460 != null) {
         var1.method3644();
      }

      var1.field2460 = this.field2457.field2460;
      var1.field2459 = this.field2457;
      var1.field2460.field2459 = var1;
      var1.field2459.field2460 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Lgd;"
   )
   public class197 method3638() {
      class197 var1 = this.field2458;
      if(var1 == this.field2457) {
         this.field2458 = null;
         return null;
      } else {
         this.field2458 = var1.field2459;
         return var1;
      }
   }
}
