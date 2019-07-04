import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
@Implements("IterableNodeDequeDescendingIterator")
public class IterableNodeDequeDescendingIterator implements Iterator {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   @Export("deque")
   IterableNodeDeque deque;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   @Export("head")
   Node head;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   @Export("last")
   Node last;

   @ObfuscatedSignature(
      signature = "(Lja;)V"
   )
   IterableNodeDequeDescendingIterator(IterableNodeDeque var1) {
      this.last = null;
      this.setDeque(var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lja;)V"
   )
   @Export("setDeque")
   void setDeque(IterableNodeDeque var1) {
      this.deque = var1;
      this.start();
   }

   @ObfuscatedName("g")
   @Export("start")
   void start() {
      this.head = this.deque != null ? this.deque.sentinel.previous : null;
      this.last = null;
   }

   @Export("hasNext")
   @ObfuscatedName("hasNext")
   public boolean hasNext() {
      return this.deque.sentinel != this.head;
   }

   @Export("next")
   @ObfuscatedName("next")
   public Object next() {
      Node var1 = this.head;
      if (var1 == this.deque.sentinel) {
         var1 = null;
         this.head = null;
      } else {
         this.head = var1.previous;
      }

      this.last = var1;
      return var1;
   }

   @ObfuscatedName("remove")
   @Export("remove")
   public void remove() {
      if (this.last == null) {
         throw new IllegalStateException();
      } else {
         this.last.remove();
         this.last = null;
      }
   }
}
