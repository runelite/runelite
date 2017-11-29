import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
@Implements("IterableDualNodeQueue")
public class IterableDualNodeQueue implements Iterable {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   @Export("sentinel")
   public CacheableNode sentinel;

   public IterableDualNodeQueue() {
      this.sentinel = new CacheableNode();
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   @ObfuscatedName("d")
   @Export("clear")
   public void clear() {
      while(this.sentinel.previous != this.sentinel) {
         this.sentinel.previous.unlinkDual();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgt;)V"
   )
   @Export("add")
   public void add(CacheableNode var1) {
      if(var1.next != null) {
         var1.unlinkDual();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Iterator iterator() {
      return new IterableNodeDequeDescendingIterator(this);
   }
}
