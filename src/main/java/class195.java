import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ge")
public class class195 {
   @ObfuscatedName("x")
   class207 field3096;
   @ObfuscatedName("w")
   class207 field3097 = new class207();

   @ObfuscatedName("w")
   public void method3797(class207 var1) {
      if(var1.field3122 != null) {
         var1.method3929();
      }

      var1.field3122 = this.field3097.field3122;
      var1.field3121 = this.field3097;
      var1.field3122.field3121 = var1;
      var1.field3121.field3122 = var1;
   }

   @ObfuscatedName("x")
   public class207 method3798() {
      class207 var1 = this.field3097.field3121;
      if(var1 == this.field3097) {
         this.field3096 = null;
         return null;
      } else {
         this.field3096 = var1.field3121;
         return var1;
      }
   }

   public class195() {
      this.field3097.field3121 = this.field3097;
      this.field3097.field3122 = this.field3097;
   }

   @ObfuscatedName("t")
   public class207 method3801() {
      class207 var1 = this.field3096;
      if(var1 == this.field3097) {
         this.field3096 = null;
         return null;
      } else {
         this.field3096 = var1.field3121;
         return var1;
      }
   }
}
