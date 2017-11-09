import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
public class class202 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   class203 field2569;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   class203 field2568;

   public class202() {
      this.field2569 = new class203();
      this.field2569.field2571 = this.field2569;
      this.field2569.field2570 = this.field2569;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgb;)V"
   )
   public void method3804(class203 var1) {
      if(var1.field2570 != null) {
         var1.method3814();
      }

      var1.field2570 = this.field2569.field2570;
      var1.field2571 = this.field2569;
      var1.field2570.field2571 = var1;
      var1.field2571.field2570 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "()Lgb;"
   )
   public class203 method3806() {
      class203 var1 = this.field2569.field2571;
      if(var1 == this.field2569) {
         this.field2568 = null;
         return null;
      } else {
         this.field2568 = var1.field2571;
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "()Lgb;"
   )
   public class203 method3803() {
      class203 var1 = this.field2568;
      if(var1 == this.field2569) {
         this.field2568 = null;
         return null;
      } else {
         this.field2568 = var1.field2571;
         return var1;
      }
   }
}
