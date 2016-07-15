import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gw")
@Implements("Node2LinkedList")
public final class class206 {
   @ObfuscatedName("e")
   @Export("sentinel")
   class207 field3150 = new class207();

   @ObfuscatedName("e")
   public void method3963(class207 var1) {
      if(var1.field3151 != null) {
         var1.method3978();
      }

      var1.field3151 = this.field3150.field3151;
      var1.field3152 = this.field3150;
      var1.field3151.field3152 = var1;
      var1.field3152.field3151 = var1;
   }

   public class206() {
      this.field3150.field3152 = this.field3150;
      this.field3150.field3151 = this.field3150;
   }

   @ObfuscatedName("h")
   public class207 method3965() {
      class207 var1 = this.field3150.field3152;
      return var1 == this.field3150?null:var1;
   }

   @ObfuscatedName("r")
   void method3966() {
      while(true) {
         class207 var1 = this.field3150.field3152;
         if(var1 == this.field3150) {
            return;
         }

         var1.method3978();
      }
   }

   @ObfuscatedName("c")
   class207 method3969() {
      class207 var1 = this.field3150.field3152;
      if(var1 == this.field3150) {
         return null;
      } else {
         var1.method3978();
         return var1;
      }
   }

   @ObfuscatedName("l")
   public void method3973(class207 var1) {
      if(var1.field3151 != null) {
         var1.method3978();
      }

      var1.field3151 = this.field3150;
      var1.field3152 = this.field3150.field3152;
      var1.field3151.field3152 = var1;
      var1.field3152.field3151 = var1;
   }
}
