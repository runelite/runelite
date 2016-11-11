import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gv")
public class class198 {
   @ObfuscatedName("i")
   class210 field3145 = new class210();
   @ObfuscatedName("h")
   class210 field3146;

   @ObfuscatedName("i")
   public void method3803(class210 var1) {
      if(var1.field3171 != null) {
         var1.method3944();
      }

      var1.field3171 = this.field3145.field3171;
      var1.field3172 = this.field3145;
      var1.field3171.field3172 = var1;
      var1.field3172.field3171 = var1;
   }

   @ObfuscatedName("h")
   public class210 method3804() {
      class210 var1 = this.field3145.field3172;
      if(var1 == this.field3145) {
         this.field3146 = null;
         return null;
      } else {
         this.field3146 = var1.field3172;
         return var1;
      }
   }

   public class198() {
      this.field3145.field3172 = this.field3145;
      this.field3145.field3171 = this.field3145;
   }

   @ObfuscatedName("e")
   public class210 method3810() {
      class210 var1 = this.field3146;
      if(var1 == this.field3145) {
         this.field3146 = null;
         return null;
      } else {
         this.field3146 = var1.field3172;
         return var1;
      }
   }
}
