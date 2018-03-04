import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
public class class226 implements Iterator {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   IterableDualNodeQueue field2674;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   CacheableNode field2672;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   CacheableNode field2673;

   @ObfuscatedSignature(
      signature = "(Lhn;)V"
   )
   class226(IterableDualNodeQueue var1) {
      this.field2673 = null;
      this.field2674 = var1;
      this.field2672 = this.field2674.sentinel.previous;
      this.field2673 = null;
   }

   public void remove() {
      if(this.field2673 == null) {
         throw new IllegalStateException();
      } else {
         this.field2673.unlinkDual();
         this.field2673 = null;
      }
   }

   public boolean hasNext() {
      return this.field2674.sentinel != this.field2672;
   }

   public Object next() {
      CacheableNode var1 = this.field2672;
      if(var1 == this.field2674.sentinel) {
         var1 = null;
         this.field2672 = null;
      } else {
         this.field2672 = var1.previous;
      }

      this.field2673 = var1;
      return var1;
   }
}
