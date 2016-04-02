import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ga")
public class class195 {
   @ObfuscatedName("w")
   class207 field3087;
   @ObfuscatedName("e")
   class207 field3088 = new class207();

   @ObfuscatedName("e")
   public void method3778(class207 var1) {
      if(var1.field3113 != null) {
         var1.method3911();
      }

      var1.field3113 = this.field3088.field3113;
      var1.field3112 = this.field3088;
      var1.field3113.field3112 = var1;
      var1.field3112.field3113 = var1;
   }

   public class195() {
      this.field3088.field3112 = this.field3088;
      this.field3088.field3113 = this.field3088;
   }

   @ObfuscatedName("f")
   public class207 method3779() {
      class207 var1 = this.field3087;
      if(var1 == this.field3088) {
         this.field3087 = null;
         return null;
      } else {
         this.field3087 = var1.field3112;
         return var1;
      }
   }

   @ObfuscatedName("w")
   public class207 method3784() {
      class207 var1 = this.field3088.field3112;
      if(var1 == this.field3088) {
         this.field3087 = null;
         return null;
      } else {
         this.field3087 = var1.field3112;
         return var1;
      }
   }
}
