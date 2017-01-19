import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ei")
public class class130 {
   @ObfuscatedName("c")
   class131 field1893;
   @ObfuscatedName("s")
   class131 field1894 = new class131();

   @ObfuscatedName("s")
   public void method2366(class131 var1) {
      if(var1.field1896 != null) {
         var1.method2373();
      }

      var1.field1896 = this.field1894.field1896;
      var1.field1895 = this.field1894;
      var1.field1896.field1895 = var1;
      var1.field1895.field1896 = var1;
   }

   @ObfuscatedName("c")
   public class131 method2367() {
      class131 var1 = this.field1894.field1895;
      if(var1 == this.field1894) {
         this.field1893 = null;
         return null;
      } else {
         this.field1893 = var1.field1895;
         return var1;
      }
   }

   @ObfuscatedName("f")
   public class131 method2368() {
      class131 var1 = this.field1893;
      if(var1 == this.field1894) {
         this.field1893 = null;
         return null;
      } else {
         this.field1893 = var1.field1895;
         return var1;
      }
   }

   public class130() {
      this.field1894.field1895 = this.field1894;
      this.field1894.field1896 = this.field1894;
   }
}
