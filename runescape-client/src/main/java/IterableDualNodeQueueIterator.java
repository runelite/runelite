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
   DualNode field438;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   DualNode field439;

   @ObfuscatedSignature(
      signature = "(Ljc;)V"
   )
   IterableDualNodeQueueIterator(IterableDualNodeQueue var1) {
      this.field439 = null;
      this.queue = var1;
      this.field438 = this.queue.sentinel.previousDual;
      this.field439 = null;
   }

   @Export("next")
   @ObfuscatedName("next")
   public Object next() {
      DualNode var1 = this.field438;
      if (var1 == this.queue.sentinel) {
         var1 = null;
         this.field438 = null;
      } else {
         this.field438 = var1.previousDual;
      }

      this.field439 = var1;
      return var1;
   }

   @Export("hasNext")
   @ObfuscatedName("hasNext")
   public boolean hasNext() {
      return this.queue.sentinel != this.field438;
   }

   @ObfuscatedName("remove")
   public void method153() {
      if (this.field439 == null) {
         throw new IllegalStateException();
      } else {
         this.field439.removeDual();
         this.field439 = null;
      }
   }
}
