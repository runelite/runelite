import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
public class class226 implements Iterator {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   IterableDualNodeQueue field2662;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   CacheableNode field2663;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   CacheableNode field2664;

   @ObfuscatedSignature(
      signature = "(Lhb;)V"
   )
   class226(IterableDualNodeQueue var1) {
      this.field2664 = null;
      this.field2662 = var1;
      this.field2663 = this.field2662.sentinel.previous;
      this.field2664 = null;
   }

   public Object next() {
      CacheableNode var1 = this.field2663;
      if(var1 == this.field2662.sentinel) {
         var1 = null;
         this.field2663 = null;
      } else {
         this.field2663 = var1.previous;
      }

      this.field2664 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2662.sentinel != this.field2663;
   }

   public void remove() {
      if(this.field2664 == null) {
         throw new IllegalStateException();
      } else {
         this.field2664.unlinkDual();
         this.field2664 = null;
      }
   }
}
