import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gp")
public class class198 {
   @ObfuscatedName("z")
   class210 field3137;
   @ObfuscatedName("s")
   class210 field3138 = new class210();

   @ObfuscatedName("s")
   public void method3767(class210 var1) {
      if(var1.field3163 != null) {
         var1.method3916();
      }

      var1.field3163 = this.field3138.field3163;
      var1.field3164 = this.field3138;
      var1.field3163.field3164 = var1;
      var1.field3164.field3163 = var1;
   }

   @ObfuscatedName("z")
   public class210 method3768() {
      class210 var1 = this.field3138.field3164;
      if(var1 == this.field3138) {
         this.field3137 = null;
         return null;
      } else {
         this.field3137 = var1.field3164;
         return var1;
      }
   }

   @ObfuscatedName("t")
   public class210 method3770() {
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
}
