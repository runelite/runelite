import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ek")
public class class151 {
   @ObfuscatedName("c")
   class152 field2038;
   @ObfuscatedName("d")
   class152 field2039;

   @ObfuscatedName("d")
   public void method2856(class152 var1) {
      if(var1.field2040 != null) {
         var1.method2865();
      }

      var1.field2040 = this.field2039.field2040;
      var1.field2041 = this.field2039;
      var1.field2040.field2041 = var1;
      var1.field2041.field2040 = var1;
   }

   @ObfuscatedName("c")
   public class152 method2857() {
      class152 var1 = this.field2039.field2041;
      if(var1 == this.field2039) {
         this.field2038 = null;
         return null;
      } else {
         this.field2038 = var1.field2041;
         return var1;
      }
   }

   @ObfuscatedName("n")
   public class152 method2858() {
      class152 var1 = this.field2038;
      if(var1 == this.field2039) {
         this.field2038 = null;
         return null;
      } else {
         this.field2038 = var1.field2041;
         return var1;
      }
   }

   public class151() {
      this.field2039 = new class152();
      this.field2039.field2041 = this.field2039;
      this.field2039.field2040 = this.field2039;
   }
}
