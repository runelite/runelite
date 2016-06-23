import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ge")
public class class195 {
   @ObfuscatedName("f")
   class207 field3088 = new class207();
   @ObfuscatedName("u")
   class207 field3089;

   public class195() {
      this.field3088.field3114 = this.field3088;
      this.field3088.field3113 = this.field3088;
   }

   @ObfuscatedName("f")
   public void method3809(class207 var1) {
      if(var1.field3113 != null) {
         var1.method3936();
      }

      var1.field3113 = this.field3088.field3113;
      var1.field3114 = this.field3088;
      var1.field3113.field3114 = var1;
      var1.field3114.field3113 = var1;
   }

   @ObfuscatedName("u")
   public class207 method3810() {
      class207 var1 = this.field3088.field3114;
      if(var1 == this.field3088) {
         this.field3089 = null;
         return null;
      } else {
         this.field3089 = var1.field3114;
         return var1;
      }
   }

   @ObfuscatedName("x")
   public class207 method3817() {
      class207 var1 = this.field3089;
      if(var1 == this.field3088) {
         this.field3089 = null;
         return null;
      } else {
         this.field3089 = var1.field3114;
         return var1;
      }
   }
}
