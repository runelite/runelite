import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("go")
public class class195 {
   @ObfuscatedName("s")
   class207 field3097 = new class207();
   @ObfuscatedName("j")
   class207 field3098;

   @ObfuscatedName("s")
   public void method3763(class207 var1) {
      if(var1.field3123 != null) {
         var1.method3894();
      }

      var1.field3123 = this.field3097.field3123;
      var1.field3122 = this.field3097;
      var1.field3123.field3122 = var1;
      var1.field3122.field3123 = var1;
   }

   @ObfuscatedName("j")
   public class207 method3764() {
      class207 var1 = this.field3097.field3122;
      if(var1 == this.field3097) {
         this.field3098 = null;
         return null;
      } else {
         this.field3098 = var1.field3122;
         return var1;
      }
   }

   @ObfuscatedName("p")
   public class207 method3765() {
      class207 var1 = this.field3098;
      if(var1 == this.field3097) {
         this.field3098 = null;
         return null;
      } else {
         this.field3098 = var1.field3122;
         return var1;
      }
   }

   public class195() {
      this.field3097.field3122 = this.field3097;
      this.field3097.field3123 = this.field3097;
   }
}
