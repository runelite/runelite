import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gi")
public class class195 {
   @ObfuscatedName("i")
   class196 field2480;
   @ObfuscatedName("w")
   class196 field2479;

   public class195() {
      this.field2480 = new class196();
      this.field2480.field2482 = this.field2480;
      this.field2480.field2481 = this.field2480;
   }

   @ObfuscatedName("w")
   public class196 method3612() {
      class196 var1 = this.field2480.field2482;
      if(var1 == this.field2480) {
         this.field2479 = null;
         return null;
      } else {
         this.field2479 = var1.field2482;
         return var1;
      }
   }

   @ObfuscatedName("i")
   public void method3608(class196 var1) {
      if(var1.field2481 != null) {
         var1.method3615();
      }

      var1.field2481 = this.field2480.field2481;
      var1.field2482 = this.field2480;
      var1.field2481.field2482 = var1;
      var1.field2482.field2481 = var1;
   }

   @ObfuscatedName("a")
   public class196 method3607() {
      class196 var1 = this.field2479;
      if(var1 == this.field2480) {
         this.field2479 = null;
         return null;
      } else {
         this.field2479 = var1.field2482;
         return var1;
      }
   }
}
