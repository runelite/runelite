import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("hp")
@Implements("DuelNodeIterator")
public class DuelNodeIterator implements Iterator {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   @Export("queue")
   IterableDualNodeQueue queue;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   CacheableNode field2605;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   CacheableNode field2607;

   @ObfuscatedSignature(
      signature = "(Lhh;)V"
   )
   DuelNodeIterator(IterableDualNodeQueue var1) {
      this.field2607 = null;
      this.queue = var1;
      this.field2605 = this.queue.sentinel.previous;
      this.field2607 = null;
   }

   public Object next() {
      CacheableNode var1 = this.field2605;
      if(var1 == this.queue.sentinel) {
         var1 = null;
         this.field2605 = null;
      } else {
         this.field2605 = var1.previous;
      }

      this.field2607 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.queue.sentinel != this.field2605;
   }

   public void remove() {
      if(this.field2607 == null) {
         throw new IllegalStateException();
      } else {
         this.field2607.unlinkDual();
         this.field2607 = null;
      }
   }
}
