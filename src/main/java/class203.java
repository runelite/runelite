import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gm")
public final class class203 {
   @ObfuscatedName("e")
   class204 field3103 = new class204();

   @ObfuscatedName("e")
   public void method3875(class204 var1) {
      if(var1.field3104 != null) {
         var1.method3891();
      }

      var1.field3104 = this.field3103.field3104;
      var1.field3105 = this.field3103;
      var1.field3104.field3105 = var1;
      var1.field3105.field3104 = var1;
   }

   @ObfuscatedName("w")
   public void method3876(class204 var1) {
      if(var1.field3104 != null) {
         var1.method3891();
      }

      var1.field3104 = this.field3103;
      var1.field3105 = this.field3103.field3105;
      var1.field3104.field3105 = var1;
      var1.field3105.field3104 = var1;
   }

   @ObfuscatedName("f")
   class204 method3877() {
      class204 var1 = this.field3103.field3105;
      if(var1 == this.field3103) {
         return null;
      } else {
         var1.method3891();
         return var1;
      }
   }

   @ObfuscatedName("s")
   public class204 method3878() {
      class204 var1 = this.field3103.field3105;
      return var1 == this.field3103?null:var1;
   }

   @ObfuscatedName("p")
   void method3890() {
      while(true) {
         class204 var1 = this.field3103.field3105;
         if(var1 == this.field3103) {
            return;
         }

         var1.method3891();
      }
   }

   public class203() {
      this.field3103.field3105 = this.field3103;
      this.field3103.field3104 = this.field3103;
   }
}
