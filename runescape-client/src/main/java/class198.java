import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gq")
public class class198 {
   @ObfuscatedName("e")
   class210 field3133 = new class210();
   @ObfuscatedName("l")
   class210 field3134;

   public class198() {
      this.field3133.field3159 = this.field3133;
      this.field3133.field3160 = this.field3133;
   }

   @ObfuscatedName("c")
   public class210 method3855() {
      class210 var1 = this.field3134;
      if(var1 == this.field3133) {
         this.field3134 = null;
         return null;
      } else {
         this.field3134 = var1.field3159;
         return var1;
      }
   }

   @ObfuscatedName("e")
   public void method3857(class210 var1) {
      if(var1.field3160 != null) {
         var1.method3997();
      }

      var1.field3160 = this.field3133.field3160;
      var1.field3159 = this.field3133;
      var1.field3160.field3159 = var1;
      var1.field3159.field3160 = var1;
   }

   @ObfuscatedName("l")
   public class210 method3861() {
      class210 var1 = this.field3133.field3159;
      if(var1 == this.field3133) {
         this.field3134 = null;
         return null;
      } else {
         this.field3134 = var1.field3159;
         return var1;
      }
   }
}
