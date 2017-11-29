import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
//@Implements("IterableNodeDequeDescendingIterator")
public class IterableNodeDequeDescendingIterator implements Iterator {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   @Export("queue")
   IterableDualNodeQueue queue;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   CacheableNode field2581;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   CacheableNode field2580;

   @ObfuscatedSignature(
      signature = "(Lhu;)V"
   )
   IterableNodeDequeDescendingIterator(IterableDualNodeQueue var1) {
      this.field2580 = null;
      this.queue = var1;
      this.field2581 = this.queue.sentinel.previous;
      this.field2580 = null;
   }

   public boolean hasNext() {
      return this.queue.sentinel != this.field2581;
   }

   public Object next() {
      CacheableNode var1 = this.field2581;
      if(var1 == this.queue.sentinel) {
         var1 = null;
         this.field2581 = null;
      } else {
         this.field2581 = var1.previous;
      }

      this.field2580 = var1;
      return var1;
   }

   public void remove() {
      if(this.field2580 == null) {
         throw new IllegalStateException();
      } else {
         this.field2580.unlinkDual();
         this.field2580 = null;
      }
   }
}
