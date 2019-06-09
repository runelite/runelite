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
   @Export("__f")
   Node __f;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   @Export("__q")
   Node __q;

   @ObfuscatedSignature(
      signature = "(Lja;)V"
   )
   IterableNodeDequeDescendingIterator(IterableNodeDeque var1) {
      this.__q = null;
      this.__u_443(var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lja;)V"
   )
   @Export("__u_443")
   void __u_443(IterableNodeDeque var1) {
      this.deque = var1;
      this.__g_444();
   }

   @ObfuscatedName("g")
   @Export("__g_444")
   void __g_444() {
      this.__f = this.deque != null?this.deque.sentinel.previous:null;
      this.__q = null;
   }

   @Export("hasNext")
   @ObfuscatedName("hasNext")
   public boolean hasNext() {
      return this.deque.sentinel != this.__f;
   }

   @Export("next")
   @ObfuscatedName("next")
   public Object next() {
      Node var1 = this.__f;
      if(var1 == this.deque.sentinel) {
         var1 = null;
         this.__f = null;
      } else {
         this.__f = var1.previous;
      }

      this.__q = var1;
      return var1;
   }

   @Export("__remove_447")
   @ObfuscatedName("remove")
   public void __remove_447() {
      if(this.__q == null) {
         throw new IllegalStateException();
      } else {
         this.__q.remove();
         this.__q = null;
      }
   }
}
