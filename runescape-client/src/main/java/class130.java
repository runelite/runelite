import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ec")
public class class130 {
   @ObfuscatedName("x")
   class131 field1873;
   @ObfuscatedName("u")
   class131 field1874 = new class131();

   @ObfuscatedName("x")
   public class131 method2416() {
      class131 var1 = this.field1874.field1876;
      if(var1 == this.field1874) {
         this.field1873 = null;
         return null;
      } else {
         this.field1873 = var1.field1876;
         return var1;
      }
   }

   @ObfuscatedName("u")
   public void method2417(class131 var1) {
      if(var1.field1875 != null) {
         var1.method2431();
      }

      var1.field1875 = this.field1874.field1875;
      var1.field1876 = this.field1874;
      var1.field1875.field1876 = var1;
      var1.field1876.field1875 = var1;
   }

   @ObfuscatedName("i")
   public class131 method2419() {
      class131 var1 = this.field1873;
      if(var1 == this.field1874) {
         this.field1873 = null;
         return null;
      } else {
         this.field1873 = var1.field1876;
         return var1;
      }
   }

   public class130() {
      this.field1874.field1876 = this.field1874;
      this.field1874.field1875 = this.field1874;
   }
}
