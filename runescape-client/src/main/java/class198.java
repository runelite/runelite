import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gm")
public class class198 {
   @ObfuscatedName("q")
   class210 field3137;
   @ObfuscatedName("k")
   class210 field3138 = new class210();

   @ObfuscatedName("q")
   public class210 method3810() {
      class210 var1 = this.field3138.field3164;
      if(var1 == this.field3138) {
         this.field3137 = null;
         return null;
      } else {
         this.field3137 = var1.field3164;
         return var1;
      }
   }

   @ObfuscatedName("f")
   public class210 method3811() {
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

   @ObfuscatedName("k")
   public void method3816(class210 var1) {
      if(var1.field3163 != null) {
         var1.method3945();
      }

      var1.field3163 = this.field3138.field3163;
      var1.field3164 = this.field3138;
      var1.field3163.field3164 = var1;
      var1.field3164.field3163 = var1;
   }
}
