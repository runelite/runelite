import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jl")
@Implements("IterableDualNodeQueueIterator")
public class IterableDualNodeQueueIterator implements Iterator {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   @Export("queue")
   IterableDualNodeQueue queue;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("head")
   DualNode head;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("last")
   DualNode last;

   @ObfuscatedSignature(
      signature = "(Ljc;)V"
   )
   IterableDualNodeQueueIterator(IterableDualNodeQueue var1) {
      this.last = null;
      this.queue = var1;
      this.head = this.queue.sentinel.previousDual;
      this.last = null;
   }

   @Export("next")
   @ObfuscatedName("next")
   public Object next() {
      DualNode var1 = this.head;
      if (var1 == this.queue.sentinel) {
         var1 = null;
         this.head = null;
      } else {
         this.head = var1.previousDual;
      }

      this.last = var1;
      return var1;
   }

   @Export("hasNext")
   @ObfuscatedName("hasNext")
   public boolean hasNext() {
      return this.queue.sentinel != this.head;
   }

   @ObfuscatedName("remove")
   @Export("remove")
   public void remove() {
      if (this.last == null) {
         throw new IllegalStateException();
      } else {
         this.last.removeDual();
         this.last = null;
      }
   }
}
