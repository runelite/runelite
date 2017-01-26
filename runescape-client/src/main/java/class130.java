import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ew")
public class class130 {
   @ObfuscatedName("g")
   class131 field1889;
   @ObfuscatedName("p")
   class131 field1890 = new class131();

   @ObfuscatedName("p")
   public void method2444(class131 var1) {
      if(var1.field1892 != null) {
         var1.method2451();
      }

      var1.field1892 = this.field1890.field1892;
      var1.field1891 = this.field1890;
      var1.field1892.field1891 = var1;
      var1.field1891.field1892 = var1;
   }

   @ObfuscatedName("g")
   public class131 method2446() {
      class131 var1 = this.field1890.field1891;
      if(var1 == this.field1890) {
         this.field1889 = null;
         return null;
      } else {
         this.field1889 = var1.field1891;
         return var1;
      }
   }

   @ObfuscatedName("x")
   public class131 method2448() {
      class131 var1 = this.field1889;
      if(var1 == this.field1890) {
         this.field1889 = null;
         return null;
      } else {
         this.field1889 = var1.field1891;
         return var1;
      }
   }

   public class130() {
      this.field1890.field1891 = this.field1890;
      this.field1890.field1892 = this.field1890;
   }
}
