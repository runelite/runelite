import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ew")
public class class130 {
   @ObfuscatedName("l")
   class131 field1883;
   @ObfuscatedName("b")
   class131 field1884 = new class131();

   @ObfuscatedName("b")
   public void method2499(class131 var1) {
      if(var1.field1886 != null) {
         var1.method2510();
      }

      var1.field1886 = this.field1884.field1886;
      var1.field1885 = this.field1884;
      var1.field1886.field1885 = var1;
      var1.field1885.field1886 = var1;
   }

   @ObfuscatedName("l")
   public class131 method2500() {
      class131 var1 = this.field1884.field1885;
      if(var1 == this.field1884) {
         this.field1883 = null;
         return null;
      } else {
         this.field1883 = var1.field1885;
         return var1;
      }
   }

   @ObfuscatedName("i")
   public class131 method2505() {
      class131 var1 = this.field1883;
      if(var1 == this.field1884) {
         this.field1883 = null;
         return null;
      } else {
         this.field1883 = var1.field1885;
         return var1;
      }
   }

   public class130() {
      this.field1884.field1885 = this.field1884;
      this.field1884.field1886 = this.field1884;
   }
}
