import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ge")
public class class198 {
   @ObfuscatedName("l")
   class210 field3145 = new class210();
   @ObfuscatedName("g")
   class210 field3146;

   @ObfuscatedName("l")
   public void method3926(class210 var1) {
      if(var1.field3172 != null) {
         var1.method4063();
      }

      var1.field3172 = this.field3145.field3172;
      var1.field3171 = this.field3145;
      var1.field3172.field3171 = var1;
      var1.field3171.field3172 = var1;
   }

   @ObfuscatedName("g")
   public class210 method3928() {
      class210 var1 = this.field3145.field3171;
      if(var1 == this.field3145) {
         this.field3146 = null;
         return null;
      } else {
         this.field3146 = var1.field3171;
         return var1;
      }
   }

   @ObfuscatedName("r")
   public class210 method3933() {
      class210 var1 = this.field3146;
      if(var1 == this.field3145) {
         this.field3146 = null;
         return null;
      } else {
         this.field3146 = var1.field3171;
         return var1;
      }
   }

   public class198() {
      this.field3145.field3171 = this.field3145;
      this.field3145.field3172 = this.field3145;
   }
}
