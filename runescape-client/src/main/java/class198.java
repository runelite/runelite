import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gc")
public class class198 {
   @ObfuscatedName("e")
   class210 field3137;
   @ObfuscatedName("f")
   class210 field3138 = new class210();

   @ObfuscatedName("f")
   public void method3837(class210 var1) {
      if(var1.field3163 != null) {
         var1.method3984();
      }

      var1.field3163 = this.field3138.field3163;
      var1.field3164 = this.field3138;
      var1.field3163.field3164 = var1;
      var1.field3164.field3163 = var1;
   }

   @ObfuscatedName("n")
   public class210 method3839() {
      class210 var1 = this.field3137;
      if(var1 == this.field3138) {
         this.field3137 = null;
         return null;
      } else {
         this.field3137 = var1.field3164;
         return var1;
      }
   }

   public class198() {
      this.field3138.field3164 = this.field3138;
      this.field3138.field3163 = this.field3138;
   }

   @ObfuscatedName("e")
   public class210 method3846() {
      class210 var1 = this.field3138.field3164;
      if(var1 == this.field3138) {
         this.field3137 = null;
         return null;
      } else {
         this.field3137 = var1.field3164;
         return var1;
      }
   }
}
