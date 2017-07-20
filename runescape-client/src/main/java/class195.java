import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
public class class195 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   class196 field2444;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   class196 field2443;

   public class195() {
      this.field2444 = new class196();
      this.field2444.field2446 = this.field2444;
      this.field2444.field2445 = this.field2444;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "()Lgp;"
   )
   public class196 method3576() {
      class196 var1 = this.field2444.field2446;
      if(var1 == this.field2444) {
         this.field2443 = null;
         return null;
      } else {
         this.field2443 = var1.field2446;
         return var1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lgp;)V"
   )
   public void method3580(class196 var1) {
      if(var1.field2445 != null) {
         var1.method3588();
      }

      var1.field2445 = this.field2444.field2445;
      var1.field2446 = this.field2444;
      var1.field2445.field2446 = var1;
      var1.field2446.field2445 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "()Lgp;"
   )
   public class196 method3577() {
      class196 var1 = this.field2443;
      if(var1 == this.field2444) {
         this.field2443 = null;
         return null;
      } else {
         this.field2443 = var1.field2446;
         return var1;
      }
   }
}
