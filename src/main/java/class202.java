import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gz")
public final class class202 {
   @ObfuscatedName("a")
   class203 field3098 = new class203();

   @ObfuscatedName("a")
   public void method3908(class203 var1) {
      if(var1.field3099 != null) {
         var1.method3920();
      }

      var1.field3099 = this.field3098.field3099;
      var1.field3100 = this.field3098;
      var1.field3099.field3100 = var1;
      var1.field3100.field3099 = var1;
   }

   @ObfuscatedName("r")
   public void method3909(class203 var1) {
      if(var1.field3099 != null) {
         var1.method3920();
      }

      var1.field3099 = this.field3098;
      var1.field3100 = this.field3098.field3100;
      var1.field3099.field3100 = var1;
      var1.field3100.field3099 = var1;
   }

   @ObfuscatedName("f")
   class203 method3910() {
      class203 var1 = this.field3098.field3100;
      if(var1 == this.field3098) {
         return null;
      } else {
         var1.method3920();
         return var1;
      }
   }

   @ObfuscatedName("s")
   public class203 method3912() {
      class203 var1 = this.field3098.field3100;
      return var1 == this.field3098?null:var1;
   }

   @ObfuscatedName("y")
   void method3917() {
      while(true) {
         class203 var1 = this.field3098.field3100;
         if(var1 == this.field3098) {
            return;
         }

         var1.method3920();
      }
   }

   public class202() {
      this.field3098.field3100 = this.field3098;
      this.field3098.field3099 = this.field3098;
   }
}
