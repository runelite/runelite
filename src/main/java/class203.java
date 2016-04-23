import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gn")
public final class class203 {
   @ObfuscatedName("j")
   class204 field3111 = new class204();

   @ObfuscatedName("j")
   public void method3844(class204 var1) {
      if(var1.field3113 != null) {
         var1.method3863();
      }

      var1.field3113 = this.field3111.field3113;
      var1.field3112 = this.field3111;
      var1.field3113.field3112 = var1;
      var1.field3112.field3113 = var1;
   }

   @ObfuscatedName("z")
   public class204 method3848() {
      class204 var1 = this.field3111.field3112;
      return var1 == this.field3111?null:var1;
   }

   @ObfuscatedName("x")
   void method3849() {
      while(true) {
         class204 var1 = this.field3111.field3112;
         if(var1 == this.field3111) {
            return;
         }

         var1.method3863();
      }
   }

   public class203() {
      this.field3111.field3112 = this.field3111;
      this.field3111.field3113 = this.field3111;
   }

   @ObfuscatedName("m")
   class204 method3852() {
      class204 var1 = this.field3111.field3112;
      if(var1 == this.field3111) {
         return null;
      } else {
         var1.method3863();
         return var1;
      }
   }

   @ObfuscatedName("h")
   public void method3855(class204 var1) {
      if(var1.field3113 != null) {
         var1.method3863();
      }

      var1.field3113 = this.field3111;
      var1.field3112 = this.field3111.field3112;
      var1.field3113.field3112 = var1;
      var1.field3112.field3113 = var1;
   }
}
