import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("em")
public class class130 {
   @ObfuscatedName("y")
   class131 field1879;
   @ObfuscatedName("k")
   class131 field1880 = new class131();

   @ObfuscatedName("k")
   public void method2416(class131 var1) {
      if(var1.field1881 != null) {
         var1.method2426();
      }

      var1.field1881 = this.field1880.field1881;
      var1.field1882 = this.field1880;
      var1.field1881.field1882 = var1;
      var1.field1882.field1881 = var1;
   }

   @ObfuscatedName("y")
   public class131 method2417() {
      class131 var1 = this.field1880.field1882;
      if(var1 == this.field1880) {
         this.field1879 = null;
         return null;
      } else {
         this.field1879 = var1.field1882;
         return var1;
      }
   }

   @ObfuscatedName("o")
   public class131 method2418() {
      class131 var1 = this.field1879;
      if(var1 == this.field1880) {
         this.field1879 = null;
         return null;
      } else {
         this.field1879 = var1.field1882;
         return var1;
      }
   }

   public class130() {
      this.field1880.field1882 = this.field1880;
      this.field1880.field1881 = this.field1880;
   }
}
