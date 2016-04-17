import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gn")
public final class class203 {
   @ObfuscatedName("a")
   class204 field3112 = new class204();

   @ObfuscatedName("a")
   public void method3963(class204 var1) {
      if(var1.field3113 != null) {
         var1.method3979();
      }

      var1.field3113 = this.field3112.field3113;
      var1.field3114 = this.field3112;
      var1.field3113.field3114 = var1;
      var1.field3114.field3113 = var1;
   }

   @ObfuscatedName("w")
   public void method3964(class204 var1) {
      if(var1.field3113 != null) {
         var1.method3979();
      }

      var1.field3113 = this.field3112;
      var1.field3114 = this.field3112.field3114;
      var1.field3113.field3114 = var1;
      var1.field3114.field3113 = var1;
   }

   @ObfuscatedName("c")
   public class204 method3966() {
      class204 var1 = this.field3112.field3114;
      return var1 == this.field3112?null:var1;
   }

   @ObfuscatedName("y")
   void method3967() {
      while(true) {
         class204 var1 = this.field3112.field3114;
         if(var1 == this.field3112) {
            return;
         }

         var1.method3979();
      }
   }

   public class203() {
      this.field3112.field3114 = this.field3112;
      this.field3112.field3113 = this.field3112;
   }

   @ObfuscatedName("d")
   class204 method3977() {
      class204 var1 = this.field3112.field3114;
      if(var1 == this.field3112) {
         return null;
      } else {
         var1.method3979();
         return var1;
      }
   }
}
