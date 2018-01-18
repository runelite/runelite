import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
public class class206 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   class207 field2602;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   class207 field2603;

   public class206() {
      this.field2602 = new class207();
      this.field2602.field2604 = this.field2602;
      this.field2602.field2605 = this.field2602;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgf;)V"
   )
   public void method3844(class207 var1) {
      if(var1.field2605 != null) {
         var1.method3855();
      }

      var1.field2605 = this.field2602.field2605;
      var1.field2604 = this.field2602;
      var1.field2605.field2604 = var1;
      var1.field2604.field2605 = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Lgf;"
   )
   public class207 method3845() {
      class207 var1 = this.field2602.field2604;
      if(var1 == this.field2602) {
         this.field2603 = null;
         return null;
      } else {
         this.field2603 = var1.field2604;
         return var1;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "()Lgf;"
   )
   public class207 method3846() {
      class207 var1 = this.field2603;
      if(var1 == this.field2602) {
         this.field2603 = null;
         return null;
      } else {
         this.field2603 = var1.field2604;
         return var1;
      }
   }
}
