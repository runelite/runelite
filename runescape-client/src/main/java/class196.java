import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
public class class196 {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   class197 field2475;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   class197 field2474;

   public class196() {
      this.field2475 = new class197();
      this.field2475.field2477 = this.field2475;
      this.field2475.field2476 = this.field2475;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "()Lgb;"
   )
   public class197 method3634() {
      class197 var1 = this.field2475.field2477;
      if(var1 == this.field2475) {
         this.field2474 = null;
         return null;
      } else {
         this.field2474 = var1.field2477;
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgb;)V"
   )
   public void method3636(class197 var1) {
      if(var1.field2476 != null) {
         var1.method3644();
      }

      var1.field2476 = this.field2475.field2476;
      var1.field2477 = this.field2475;
      var1.field2476.field2477 = var1;
      var1.field2477.field2476 = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "()Lgb;"
   )
   public class197 method3642() {
      class197 var1 = this.field2474;
      if(var1 == this.field2475) {
         this.field2474 = null;
         return null;
      } else {
         this.field2474 = var1.field2477;
         return var1;
      }
   }
}
