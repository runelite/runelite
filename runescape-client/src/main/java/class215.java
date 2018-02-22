import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
public class class215 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   class216 field2618;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   class216 field2617;

   public class215() {
      this.field2618 = new class216();
      this.field2618.field2619 = this.field2618;
      this.field2618.field2620 = this.field2618;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lhg;)V"
   )
   public void method4082(class216 var1) {
      if(var1.field2620 != null) {
         var1.method4092();
      }

      var1.field2620 = this.field2618.field2620;
      var1.field2619 = this.field2618;
      var1.field2620.field2619 = var1;
      var1.field2619.field2620 = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "()Lhg;"
   )
   public class216 method4083() {
      class216 var1 = this.field2618.field2619;
      if(var1 == this.field2618) {
         this.field2617 = null;
         return null;
      } else {
         this.field2617 = var1.field2619;
         return var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "()Lhg;"
   )
   public class216 method4084() {
      class216 var1 = this.field2617;
      if(var1 == this.field2618) {
         this.field2617 = null;
         return null;
      } else {
         this.field2617 = var1.field2619;
         return var1;
      }
   }
}
