import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public class class207 implements Iterator {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   class208 field2573;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   CacheableNode field2571;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   CacheableNode field2572;

   @ObfuscatedSignature(
      signature = "(Lhd;)V"
   )
   class207(class208 var1) {
      this.field2572 = null;
      this.field2573 = var1;
      this.field2571 = this.field2573.field2574.previous;
      this.field2572 = null;
   }

   public boolean hasNext() {
      return this.field2573.field2574 != this.field2571;
   }

   public void remove() {
      if(this.field2572 == null) {
         throw new IllegalStateException();
      } else {
         this.field2572.unlinkDual();
         this.field2572 = null;
      }
   }

   public Object next() {
      CacheableNode var1 = this.field2571;
      if(var1 == this.field2573.field2574) {
         var1 = null;
         this.field2571 = null;
      } else {
         this.field2571 = var1.previous;
      }

      this.field2572 = var1;
      return var1;
   }
}
