import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ga")
public class class195 {
   @ObfuscatedName("b")
   class207 field3086 = new class207();
   @ObfuscatedName("g")
   class207 field3087;

   public class195() {
      this.field3086.field3111 = this.field3086;
      this.field3086.field3112 = this.field3086;
   }

   @ObfuscatedName("j")
   public class207 method3786() {
      class207 var1 = this.field3087;
      if(var1 == this.field3086) {
         this.field3087 = null;
         return null;
      } else {
         this.field3087 = var1.field3111;
         return var1;
      }
   }

   @ObfuscatedName("g")
   public class207 method3793() {
      class207 var1 = this.field3086.field3111;
      if(var1 == this.field3086) {
         this.field3087 = null;
         return null;
      } else {
         this.field3087 = var1.field3111;
         return var1;
      }
   }

   @ObfuscatedName("b")
   public void method3794(class207 var1) {
      if(var1.field3112 != null) {
         var1.method3905();
      }

      var1.field3112 = this.field3086.field3112;
      var1.field3111 = this.field3086;
      var1.field3112.field3111 = var1;
      var1.field3111.field3112 = var1;
   }
}
