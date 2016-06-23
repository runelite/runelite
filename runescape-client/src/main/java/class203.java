import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gj")
@Implements("Node2LinkedList")
public final class class203 {
   @ObfuscatedName("f")
   @Export("sentinel")
   class204 field3104 = new class204();

   @ObfuscatedName("x")
   class204 method3902() {
      class204 var1 = this.field3104.field3105;
      if(var1 == this.field3104) {
         return null;
      } else {
         var1.method3922();
         return var1;
      }
   }

   @ObfuscatedName("l")
   void method3904() {
      while(true) {
         class204 var1 = this.field3104.field3105;
         if(var1 == this.field3104) {
            return;
         }

         var1.method3922();
      }
   }

   @ObfuscatedName("f")
   public void method3908(class204 var1) {
      if(var1.field3106 != null) {
         var1.method3922();
      }

      var1.field3106 = this.field3104.field3106;
      var1.field3105 = this.field3104;
      var1.field3106.field3105 = var1;
      var1.field3105.field3106 = var1;
   }

   @ObfuscatedName("u")
   public void method3912(class204 var1) {
      if(var1.field3106 != null) {
         var1.method3922();
      }

      var1.field3106 = this.field3104;
      var1.field3105 = this.field3104.field3105;
      var1.field3106.field3105 = var1;
      var1.field3105.field3106 = var1;
   }

   @ObfuscatedName("b")
   public class204 method3915() {
      class204 var1 = this.field3104.field3105;
      return var1 == this.field3104?null:var1;
   }

   public class203() {
      this.field3104.field3105 = this.field3104;
      this.field3104.field3106 = this.field3104;
   }
}
