import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eu")
public class class130 {
   @ObfuscatedName("i")
   class131 field1883 = new class131();
   @ObfuscatedName("e")
   class131 field1884;

   @ObfuscatedName("i")
   public void method2393(class131 var1) {
      if(var1.field1885 != null) {
         var1.method2406();
      }

      var1.field1885 = this.field1883.field1885;
      var1.field1886 = this.field1883;
      var1.field1885.field1886 = var1;
      var1.field1886.field1885 = var1;
   }

   @ObfuscatedName("f")
   public class131 method2395() {
      class131 var1 = this.field1884;
      if(var1 == this.field1883) {
         this.field1884 = null;
         return null;
      } else {
         this.field1884 = var1.field1886;
         return var1;
      }
   }

   public class130() {
      this.field1883.field1886 = this.field1883;
      this.field1883.field1885 = this.field1883;
   }

   @ObfuscatedName("e")
   public class131 method2399() {
      class131 var1 = this.field1883.field1886;
      if(var1 == this.field1883) {
         this.field1884 = null;
         return null;
      } else {
         this.field1884 = var1.field1886;
         return var1;
      }
   }
}
