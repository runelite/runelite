import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gl")
public class class194 {
   @ObfuscatedName("j")
   class206 field3083 = new class206();
   @ObfuscatedName("l")
   class206 field3084;

   @ObfuscatedName("j")
   public void method3734(class206 var1) {
      if(var1.field3108 != null) {
         var1.method3850();
      }

      var1.field3108 = this.field3083.field3108;
      var1.field3109 = this.field3083;
      var1.field3108.field3109 = var1;
      var1.field3109.field3108 = var1;
   }

   @ObfuscatedName("a")
   public class206 method3736() {
      class206 var1 = this.field3084;
      if(var1 == this.field3083) {
         this.field3084 = null;
         return null;
      } else {
         this.field3084 = var1.field3109;
         return var1;
      }
   }

   public class194() {
      this.field3083.field3109 = this.field3083;
      this.field3083.field3108 = this.field3083;
   }

   @ObfuscatedName("l")
   public class206 method3740() {
      class206 var1 = this.field3083.field3109;
      if(var1 == this.field3083) {
         this.field3084 = null;
         return null;
      } else {
         this.field3084 = var1.field3109;
         return var1;
      }
   }
}
