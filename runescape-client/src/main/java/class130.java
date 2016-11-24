import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ef")
public class class130 {
   @ObfuscatedName("n")
   class131 field1884 = new class131();
   @ObfuscatedName("d")
   class131 field1885;

   @ObfuscatedName("n")
   public void method2487(class131 var1) {
      if(var1.field1887 != null) {
         var1.method2501();
      }

      var1.field1887 = this.field1884.field1887;
      var1.field1886 = this.field1884;
      var1.field1887.field1886 = var1;
      var1.field1886.field1887 = var1;
   }

   @ObfuscatedName("m")
   public class131 method2488() {
      class131 var1 = this.field1885;
      if(var1 == this.field1884) {
         this.field1885 = null;
         return null;
      } else {
         this.field1885 = var1.field1886;
         return var1;
      }
   }

   @ObfuscatedName("d")
   public class131 method2489() {
      class131 var1 = this.field1884.field1886;
      if(var1 == this.field1884) {
         this.field1885 = null;
         return null;
      } else {
         this.field1885 = var1.field1886;
         return var1;
      }
   }

   public class130() {
      this.field1884.field1886 = this.field1884;
      this.field1884.field1887 = this.field1884;
   }
}
