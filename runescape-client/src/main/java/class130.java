import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ek")
public class class130 {
   @ObfuscatedName("q")
   class131 field1887 = new class131();
   @ObfuscatedName("d")
   class131 field1888;

   @ObfuscatedName("q")
   public void method2487(class131 var1) {
      if(var1.field1889 != null) {
         var1.method2496();
      }

      var1.field1889 = this.field1887.field1889;
      var1.field1890 = this.field1887;
      var1.field1889.field1890 = var1;
      var1.field1890.field1889 = var1;
   }

   @ObfuscatedName("d")
   public class131 method2488() {
      class131 var1 = this.field1887.field1890;
      if(var1 == this.field1887) {
         this.field1888 = null;
         return null;
      } else {
         this.field1888 = var1.field1890;
         return var1;
      }
   }

   @ObfuscatedName("h")
   public class131 method2489() {
      class131 var1 = this.field1888;
      if(var1 == this.field1887) {
         this.field1888 = null;
         return null;
      } else {
         this.field1888 = var1.field1890;
         return var1;
      }
   }

   public class130() {
      this.field1887.field1890 = this.field1887;
      this.field1887.field1889 = this.field1887;
   }
}
