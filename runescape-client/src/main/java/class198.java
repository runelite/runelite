import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gy")
public class class198 {
   @ObfuscatedName("x")
   class210 field3144 = new class210();
   @ObfuscatedName("r")
   class210 field3145;

   public class198() {
      this.field3144.field3170 = this.field3144;
      this.field3144.field3171 = this.field3144;
   }

   @ObfuscatedName("r")
   public class210 method3809() {
      class210 var1 = this.field3144.field3170;
      if(var1 == this.field3144) {
         this.field3145 = null;
         return null;
      } else {
         this.field3145 = var1.field3170;
         return var1;
      }
   }

   @ObfuscatedName("j")
   public class210 method3810() {
      class210 var1 = this.field3145;
      if(var1 == this.field3144) {
         this.field3145 = null;
         return null;
      } else {
         this.field3145 = var1.field3170;
         return var1;
      }
   }

   @ObfuscatedName("x")
   public void method3812(class210 var1) {
      if(var1.field3171 != null) {
         var1.method3941();
      }

      var1.field3171 = this.field3144.field3171;
      var1.field3170 = this.field3144;
      var1.field3171.field3170 = var1;
      var1.field3170.field3171 = var1;
   }
}
