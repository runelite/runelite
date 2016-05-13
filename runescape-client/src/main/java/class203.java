import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ge")
@Implements("Node2LinkedList")
public final class class203 {
   @ObfuscatedName("s")
   @Export("sentinel")
   class204 field3113 = new class204();

   @ObfuscatedName("s")
   public void method3860(class204 var1) {
      if(var1.field3115 != null) {
         var1.method3876();
      }

      var1.field3115 = this.field3113.field3115;
      var1.field3114 = this.field3113;
      var1.field3115.field3114 = var1;
      var1.field3114.field3115 = var1;
   }

   @ObfuscatedName("j")
   public void method3861(class204 var1) {
      if(var1.field3115 != null) {
         var1.method3876();
      }

      var1.field3115 = this.field3113;
      var1.field3114 = this.field3113.field3114;
      var1.field3115.field3114 = var1;
      var1.field3114.field3115 = var1;
   }

   @ObfuscatedName("x")
   public class204 method3863() {
      class204 var1 = this.field3113.field3114;
      return var1 == this.field3113?null:var1;
   }

   @ObfuscatedName("d")
   void method3864() {
      while(true) {
         class204 var1 = this.field3113.field3114;
         if(var1 == this.field3113) {
            return;
         }

         var1.method3876();
      }
   }

   @ObfuscatedName("p")
   class204 method3871() {
      class204 var1 = this.field3113.field3114;
      if(var1 == this.field3113) {
         return null;
      } else {
         var1.method3876();
         return var1;
      }
   }

   public class203() {
      this.field3113.field3114 = this.field3113;
      this.field3113.field3115 = this.field3113;
   }
}
