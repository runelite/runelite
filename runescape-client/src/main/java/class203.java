import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gk")
@Implements("Node2LinkedList")
public final class class203 {
   @ObfuscatedName("t")
   @Export("sentinel")
   class204 field3113 = new class204();

   @ObfuscatedName("g")
   class204 method3830() {
      class204 var1 = this.field3113.field3114;
      if(var1 == this.field3113) {
         return null;
      } else {
         var1.method3844();
         return var1;
      }
   }

   @ObfuscatedName("i")
   public void method3831(class204 var1) {
      if(var1.field3115 != null) {
         var1.method3844();
      }

      var1.field3115 = this.field3113;
      var1.field3114 = this.field3113.field3114;
      var1.field3115.field3114 = var1;
      var1.field3114.field3115 = var1;
   }

   @ObfuscatedName("h")
   public class204 method3834() {
      class204 var1 = this.field3113.field3114;
      return var1 == this.field3113?null:var1;
   }

   @ObfuscatedName("z")
   void method3835() {
      while(true) {
         class204 var1 = this.field3113.field3114;
         if(var1 == this.field3113) {
            return;
         }

         var1.method3844();
      }
   }

   @ObfuscatedName("t")
   public void method3837(class204 var1) {
      if(var1.field3115 != null) {
         var1.method3844();
      }

      var1.field3115 = this.field3113.field3115;
      var1.field3114 = this.field3113;
      var1.field3115.field3114 = var1;
      var1.field3114.field3115 = var1;
   }

   public class203() {
      this.field3113.field3114 = this.field3113;
      this.field3113.field3115 = this.field3113;
   }
}
