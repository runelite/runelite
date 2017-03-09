import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eb")
public class class130 {
   @ObfuscatedName("x")
   class131 field1889 = new class131();
   @ObfuscatedName("j")
   class131 field1890;

   public class130() {
      this.field1889.field1891 = this.field1889;
      this.field1889.field1892 = this.field1889;
   }

   @ObfuscatedName("j")
   public class131 method2479() {
      class131 var1 = this.field1889.field1891;
      if(var1 == this.field1889) {
         this.field1890 = null;
         return null;
      } else {
         this.field1890 = var1.field1891;
         return var1;
      }
   }

   @ObfuscatedName("x")
   public void method2480(class131 var1) {
      if(var1.field1892 != null) {
         var1.method2491();
      }

      var1.field1892 = this.field1889.field1892;
      var1.field1891 = this.field1889;
      var1.field1892.field1891 = var1;
      var1.field1891.field1892 = var1;
   }

   @ObfuscatedName("c")
   public class131 method2481() {
      class131 var1 = this.field1890;
      if(var1 == this.field1889) {
         this.field1890 = null;
         return null;
      } else {
         this.field1890 = var1.field1891;
         return var1;
      }
   }
}
