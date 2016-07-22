import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gd")
@Implements("Node2LinkedList")
public final class class206 {
   @ObfuscatedName("m")
   @Export("sentinel")
   class207 field3155 = new class207();

   @ObfuscatedName("g")
   void method3940() {
      while(true) {
         class207 var1 = this.field3155.field3156;
         if(var1 == this.field3155) {
            return;
         }

         var1.method3960();
      }
   }

   @ObfuscatedName("e")
   class207 method3941() {
      class207 var1 = this.field3155.field3156;
      if(var1 == this.field3155) {
         return null;
      } else {
         var1.method3960();
         return var1;
      }
   }

   @ObfuscatedName("w")
   public void method3942(class207 var1) {
      if(var1.field3157 != null) {
         var1.method3960();
      }

      var1.field3157 = this.field3155;
      var1.field3156 = this.field3155.field3156;
      var1.field3157.field3156 = var1;
      var1.field3156.field3157 = var1;
   }

   @ObfuscatedName("o")
   public class207 method3944() {
      class207 var1 = this.field3155.field3156;
      return var1 == this.field3155?null:var1;
   }

   public class206() {
      this.field3155.field3156 = this.field3155;
      this.field3155.field3157 = this.field3155;
   }

   @ObfuscatedName("m")
   public void method3946(class207 var1) {
      if(var1.field3157 != null) {
         var1.method3960();
      }

      var1.field3157 = this.field3155.field3157;
      var1.field3156 = this.field3155;
      var1.field3157.field3156 = var1;
      var1.field3156.field3157 = var1;
   }
}
