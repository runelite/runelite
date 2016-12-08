import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ef")
public class class130 {
   @ObfuscatedName("o")
   class131 field1900 = new class131();
   @ObfuscatedName("m")
   class131 field1901;

   @ObfuscatedName("m")
   public class131 method2383() {
      class131 var1 = this.field1900.field1903;
      if(var1 == this.field1900) {
         this.field1901 = null;
         return null;
      } else {
         this.field1901 = var1.field1903;
         return var1;
      }
   }

   @ObfuscatedName("b")
   public class131 method2384() {
      class131 var1 = this.field1901;
      if(var1 == this.field1900) {
         this.field1901 = null;
         return null;
      } else {
         this.field1901 = var1.field1903;
         return var1;
      }
   }

   @ObfuscatedName("o")
   public void method2387(class131 var1) {
      if(var1.field1902 != null) {
         var1.method2395();
      }

      var1.field1902 = this.field1900.field1902;
      var1.field1903 = this.field1900;
      var1.field1902.field1903 = var1;
      var1.field1903.field1902 = var1;
   }

   public class130() {
      this.field1900.field1903 = this.field1900;
      this.field1900.field1902 = this.field1900;
   }
}
