import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gk")
public final class class203 {
   @ObfuscatedName("w")
   class204 field3112 = new class204();

   @ObfuscatedName("t")
   class204 method3894() {
      class204 var1 = this.field3112.field3114;
      if(var1 == this.field3112) {
         return null;
      } else {
         var1.method3909();
         return var1;
      }
   }

   public class203() {
      this.field3112.field3114 = this.field3112;
      this.field3112.field3113 = this.field3112;
   }

   @ObfuscatedName("p")
   public class204 method3896() {
      class204 var1 = this.field3112.field3114;
      return var1 == this.field3112?null:var1;
   }

   @ObfuscatedName("e")
   void method3897() {
      while(true) {
         class204 var1 = this.field3112.field3114;
         if(var1 == this.field3112) {
            return;
         }

         var1.method3909();
      }
   }

   @ObfuscatedName("w")
   public void method3905(class204 var1) {
      if(var1.field3113 != null) {
         var1.method3909();
      }

      var1.field3113 = this.field3112.field3113;
      var1.field3114 = this.field3112;
      var1.field3113.field3114 = var1;
      var1.field3114.field3113 = var1;
   }

   @ObfuscatedName("x")
   public void method3907(class204 var1) {
      if(var1.field3113 != null) {
         var1.method3909();
      }

      var1.field3113 = this.field3112;
      var1.field3114 = this.field3112.field3114;
      var1.field3113.field3114 = var1;
      var1.field3114.field3113 = var1;
   }
}
