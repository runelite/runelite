import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gm")
public class class195 {
   @ObfuscatedName("a")
   class196 field2471;
   @ObfuscatedName("j")
   class196 field2472;

   public class195() {
      this.field2471 = new class196();
      this.field2471.field2474 = this.field2471;
      this.field2471.field2473 = this.field2471;
   }

   @ObfuscatedName("j")
   public class196 method3636() {
      class196 var1 = this.field2471.field2474;
      if(var1 == this.field2471) {
         this.field2472 = null;
         return null;
      } else {
         this.field2472 = var1.field2474;
         return var1;
      }
   }

   @ObfuscatedName("a")
   public void method3627(class196 var1) {
      if(var1.field2473 != null) {
         var1.method3639();
      }

      var1.field2473 = this.field2471.field2473;
      var1.field2474 = this.field2471;
      var1.field2473.field2474 = var1;
      var1.field2474.field2473 = var1;
   }

   @ObfuscatedName("n")
   public class196 method3629() {
      class196 var1 = this.field2472;
      if(var1 == this.field2471) {
         this.field2472 = null;
         return null;
      } else {
         this.field2472 = var1.field2474;
         return var1;
      }
   }
}
