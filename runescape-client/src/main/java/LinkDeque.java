import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
@Implements("LinkDeque")
public class LinkDeque {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   Link field2570;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   Link field2571;

   public LinkDeque() {
      this.field2570 = new Link();
      this.field2570.field2572 = this.field2570;
      this.field2570.field2573 = this.field2570;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lga;)V"
   )
   public void method3787(Link var1) {
      if(var1.field2573 != null) {
         var1.remove();
      }

      var1.field2573 = this.field2570.field2573;
      var1.field2572 = this.field2570;
      var1.field2573.field2572 = var1;
      var1.field2572.field2573 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "()Lga;"
   )
   public Link method3788() {
      Link var1 = this.field2570.field2572;
      if(var1 == this.field2570) {
         this.field2571 = null;
         return null;
      } else {
         this.field2571 = var1.field2572;
         return var1;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "()Lga;"
   )
   public Link method3798() {
      Link var1 = this.field2571;
      if(var1 == this.field2570) {
         this.field2571 = null;
         return null;
      } else {
         this.field2571 = var1.field2572;
         return var1;
      }
   }
}
