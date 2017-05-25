import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gc")
public class class195 {
   @ObfuscatedName("i")
   class196 field2472;
   @ObfuscatedName("h")
   class196 field2473;

   @ObfuscatedName("i")
   public void method3689(class196 var1) {
      if(var1.field2474 != null) {
         var1.method3699();
      }

      var1.field2474 = this.field2472.field2474;
      var1.field2475 = this.field2472;
      var1.field2474.field2475 = var1;
      var1.field2475.field2474 = var1;
   }

   @ObfuscatedName("h")
   public class196 method3690() {
      class196 var1 = this.field2472.field2475;
      if(var1 == this.field2472) {
         this.field2473 = null;
         return null;
      } else {
         this.field2473 = var1.field2475;
         return var1;
      }
   }

   @ObfuscatedName("u")
   public class196 method3691() {
      class196 var1 = this.field2473;
      if(var1 == this.field2472) {
         this.field2473 = null;
         return null;
      } else {
         this.field2473 = var1.field2475;
         return var1;
      }
   }

   public class195() {
      this.field2472 = new class196();
      this.field2472.field2475 = this.field2472;
      this.field2472.field2474 = this.field2472;
   }
}
