import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eh")
public class class130 {
   @ObfuscatedName("n")
   class131 field1890;
   @ObfuscatedName("x")
   class131 field1891 = new class131();

   @ObfuscatedName("x")
   public void method2515(class131 var1) {
      if(var1.field1892 != null) {
         var1.method2525();
      }

      var1.field1892 = this.field1891.field1892;
      var1.field1893 = this.field1891;
      var1.field1892.field1893 = var1;
      var1.field1893.field1892 = var1;
   }

   @ObfuscatedName("n")
   public class131 method2516() {
      class131 var1 = this.field1891.field1893;
      if(var1 == this.field1891) {
         this.field1890 = null;
         return null;
      } else {
         this.field1890 = var1.field1893;
         return var1;
      }
   }

   @ObfuscatedName("g")
   public class131 method2520() {
      class131 var1 = this.field1890;
      if(var1 == this.field1891) {
         this.field1890 = null;
         return null;
      } else {
         this.field1890 = var1.field1893;
         return var1;
      }
   }

   public class130() {
      this.field1891.field1893 = this.field1891;
      this.field1891.field1892 = this.field1891;
   }
}
