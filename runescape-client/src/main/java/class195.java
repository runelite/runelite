import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public class class195 {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   class196 field2491;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   class196 field2492;

   public class195() {
      this.field2492 = new class196();
      this.field2492.field2493 = this.field2492;
      this.field2492.field2494 = this.field2492;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "()Lgz;"
   )
   public class196 method3745() {
      class196 var1 = this.field2492.field2493;
      if(var1 == this.field2492) {
         this.field2491 = null;
         return null;
      } else {
         this.field2491 = var1.field2493;
         return var1;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgz;)V"
   )
   public void method3754(class196 var1) {
      if(var1.field2494 != null) {
         var1.method3757();
      }

      var1.field2494 = this.field2492.field2494;
      var1.field2493 = this.field2492;
      var1.field2494.field2493 = var1;
      var1.field2493.field2494 = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "()Lgz;"
   )
   public class196 method3751() {
      class196 var1 = this.field2491;
      if(var1 == this.field2492) {
         this.field2491 = null;
         return null;
      } else {
         this.field2491 = var1.field2493;
         return var1;
      }
   }
}
