import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
public class class206 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   class207 field2590;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   class207 field2591;

   public class206() {
      this.field2590 = new class207();
      this.field2590.field2593 = this.field2590;
      this.field2590.field2592 = this.field2590;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgr;)V"
   )
   public void method4065(class207 var1) {
      if(var1.field2592 != null) {
         var1.method4076();
      }

      var1.field2592 = this.field2590.field2592;
      var1.field2593 = this.field2590;
      var1.field2592.field2593 = var1;
      var1.field2593.field2592 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Lgr;"
   )
   public class207 method4069() {
      class207 var1 = this.field2590.field2593;
      if(var1 == this.field2590) {
         this.field2591 = null;
         return null;
      } else {
         this.field2591 = var1.field2593;
         return var1;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "()Lgr;"
   )
   public class207 method4066() {
      class207 var1 = this.field2591;
      if(var1 == this.field2590) {
         this.field2591 = null;
         return null;
      } else {
         this.field2591 = var1.field2593;
         return var1;
      }
   }
}
