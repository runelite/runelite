import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class203 {
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   class203 field2572;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   class203 field2573;

   @ObfuscatedName("d")
   public void method3799() {
      if(this.field2573 != null) {
         this.field2573.field2572 = this.field2572;
         this.field2572.field2573 = this.field2573;
         this.field2572 = null;
         this.field2573 = null;
      }
   }
}
