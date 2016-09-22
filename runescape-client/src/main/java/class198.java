import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gq")
public class class198 {
   @ObfuscatedName("a")
   class210 field3141 = new class210();
   @ObfuscatedName("d")
   class210 field3142;

   @ObfuscatedName("a")
   public void method3807(class210 var1) {
      if(var1.field3167 != null) {
         var1.method3962();
      }

      var1.field3167 = this.field3141.field3167;
      var1.field3168 = this.field3141;
      var1.field3167.field3168 = var1;
      var1.field3168.field3167 = var1;
   }

   @ObfuscatedName("d")
   public class210 method3809() {
      class210 var1 = this.field3141.field3168;
      if(var1 == this.field3141) {
         this.field3142 = null;
         return null;
      } else {
         this.field3142 = var1.field3168;
         return var1;
      }
   }

   @ObfuscatedName("v")
   public class210 method3810() {
      class210 var1 = this.field3142;
      if(var1 == this.field3141) {
         this.field3142 = null;
         return null;
      } else {
         this.field3142 = var1.field3168;
         return var1;
      }
   }

   public class198() {
      this.field3141.field3168 = this.field3141;
      this.field3141.field3167 = this.field3141;
   }
}
