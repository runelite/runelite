import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("go")
public class class195 {
   @ObfuscatedName("t")
   class207 field3097 = new class207();
   @ObfuscatedName("i")
   class207 field3098;

   @ObfuscatedName("i")
   public class207 method3735() {
      class207 var1 = this.field3097.field3123;
      if(var1 == this.field3097) {
         this.field3098 = null;
         return null;
      } else {
         this.field3098 = var1.field3123;
         return var1;
      }
   }

   public class195() {
      this.field3097.field3123 = this.field3097;
      this.field3097.field3122 = this.field3097;
   }

   @ObfuscatedName("g")
   public class207 method3737() {
      class207 var1 = this.field3098;
      if(var1 == this.field3097) {
         this.field3098 = null;
         return null;
      } else {
         this.field3098 = var1.field3123;
         return var1;
      }
   }

   @ObfuscatedName("t")
   public void method3739(class207 var1) {
      if(var1.field3122 != null) {
         var1.method3861();
      }

      var1.field3122 = this.field3097.field3122;
      var1.field3123 = this.field3097;
      var1.field3122.field3123 = var1;
      var1.field3123.field3122 = var1;
   }
}
