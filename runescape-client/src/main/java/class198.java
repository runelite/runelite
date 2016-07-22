import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gk")
public class class198 {
   @ObfuscatedName("w")
   class210 field3138;
   @ObfuscatedName("m")
   class210 field3139 = new class210();

   public class198() {
      this.field3139.field3165 = this.field3139;
      this.field3139.field3164 = this.field3139;
   }

   @ObfuscatedName("w")
   public class210 method3841() {
      class210 var1 = this.field3139.field3165;
      if(var1 == this.field3139) {
         this.field3138 = null;
         return null;
      } else {
         this.field3138 = var1.field3165;
         return var1;
      }
   }

   @ObfuscatedName("e")
   public class210 method3842() {
      class210 var1 = this.field3138;
      if(var1 == this.field3139) {
         this.field3138 = null;
         return null;
      } else {
         this.field3138 = var1.field3165;
         return var1;
      }
   }

   @ObfuscatedName("m")
   public void method3845(class210 var1) {
      if(var1.field3164 != null) {
         var1.method3984();
      }

      var1.field3164 = this.field3139.field3164;
      var1.field3165 = this.field3139;
      var1.field3164.field3165 = var1;
      var1.field3165.field3164 = var1;
   }
}
