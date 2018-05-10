import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
public class class208 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   class209 field2456;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   class209 field2457;

   public class208() {
      this.field2456 = new class209();
      this.field2456.field2458 = this.field2456;
      this.field2456.field2459 = this.field2456;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lhm;)V"
   )
   public void method4149(class209 var1) {
      if(var1.field2459 != null) {
         var1.method4156();
      }

      var1.field2459 = this.field2456.field2459;
      var1.field2458 = this.field2456;
      var1.field2459.field2458 = var1;
      var1.field2458.field2459 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "()Lhm;"
   )
   public class209 method4147() {
      class209 var1 = this.field2456.field2458;
      if(var1 == this.field2456) {
         this.field2457 = null;
         return null;
      } else {
         this.field2457 = var1.field2458;
         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "()Lhm;"
   )
   public class209 method4146() {
      class209 var1 = this.field2457;
      if(var1 == this.field2456) {
         this.field2457 = null;
         return null;
      } else {
         this.field2457 = var1.field2458;
         return var1;
      }
   }
}
