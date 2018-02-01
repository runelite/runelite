import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class206 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   class207 field2567;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   class207 field2568;

   public class206() {
      this.field2567 = new class207();
      this.field2567.field2570 = this.field2567;
      this.field2567.field2569 = this.field2567;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgu;)V"
   )
   public void method3896(class207 var1) {
      if(var1.field2569 != null) {
         var1.method3909();
      }

      var1.field2569 = this.field2567.field2569;
      var1.field2570 = this.field2567;
      var1.field2569.field2570 = var1;
      var1.field2570.field2569 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "()Lgu;"
   )
   public class207 method3895() {
      class207 var1 = this.field2567.field2570;
      if(var1 == this.field2567) {
         this.field2568 = null;
         return null;
      } else {
         this.field2568 = var1.field2570;
         return var1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "()Lgu;"
   )
   public class207 method3897() {
      class207 var1 = this.field2568;
      if(var1 == this.field2567) {
         this.field2568 = null;
         return null;
      } else {
         this.field2568 = var1.field2570;
         return var1;
      }
   }
}
