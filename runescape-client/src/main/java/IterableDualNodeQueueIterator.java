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
   @Export("__f")
   DualNode __f;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("__q")
   DualNode __q;

   @ObfuscatedSignature(
      signature = "(Ljc;)V"
   )
   IterableDualNodeQueueIterator(IterableDualNodeQueue var1) {
      this.__q = null;
      this.queue = var1;
      this.__f = this.queue.sentinel.previousDual;
      this.__q = null;
   }

   @Export("next")
   @ObfuscatedName("next")
   public Object next() {
      DualNode var1 = this.__f;
      if(var1 == this.queue.sentinel) {
         var1 = null;
         this.__f = null;
      } else {
         this.__f = var1.previousDual;
      }

      this.__q = var1;
      return var1;
   }

   @Export("hasNext")
   @ObfuscatedName("hasNext")
   public boolean hasNext() {
      return this.queue.sentinel != this.__f;
   }

   @Export("__remove_442")
   @ObfuscatedName("remove")
   public void __remove_442() {
      if(this.__q == null) {
         throw new IllegalStateException();
      } else {
         this.__q.removeDual();
         this.__q = null;
      }
   }
}
