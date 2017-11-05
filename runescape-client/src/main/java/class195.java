import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
public class class195 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   class196 field2471;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   class196 field2470;

   public class195() {
      this.field2471 = new class196();
      this.field2471.field2472 = this.field2471;
      this.field2471.field2473 = this.field2471;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgw;)V"
   )
   public void method3721(class196 var1) {
      if(var1.field2473 != null) {
         var1.method3726();
      }

      var1.field2473 = this.field2471.field2473;
      var1.field2472 = this.field2471;
      var1.field2473.field2472 = var1;
      var1.field2472.field2473 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "()Lgw;"
   )
   public class196 method3722() {
      class196 var1 = this.field2471.field2472;
      if(var1 == this.field2471) {
         this.field2470 = null;
         return null;
      } else {
         this.field2470 = var1.field2472;
         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "()Lgw;"
   )
   public class196 method3725() {
      class196 var1 = this.field2470;
      if(var1 == this.field2471) {
         this.field2470 = null;
         return null;
      } else {
         this.field2470 = var1.field2472;
         return var1;
      }
   }
}
