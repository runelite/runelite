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
   Node field440;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   Node field441;

   @ObfuscatedSignature(
      signature = "(Lja;)V"
   )
   IterableNodeDequeDescendingIterator(IterableNodeDeque var1) {
      this.field441 = null;
      this.method154(var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lja;)V"
   )
   void method154(IterableNodeDeque var1) {
      this.deque = var1;
      this.method155();
   }

   @ObfuscatedName("g")
   void method155() {
      this.field440 = this.deque != null ? this.deque.sentinel.previous : null;
      this.field441 = null;
   }

   @Export("hasNext")
   @ObfuscatedName("hasNext")
   public boolean hasNext() {
      return this.deque.sentinel != this.field440;
   }

   @Export("next")
   @ObfuscatedName("next")
   public Object next() {
      Node var1 = this.field440;
      if (var1 == this.deque.sentinel) {
         var1 = null;
         this.field440 = null;
      } else {
         this.field440 = var1.previous;
      }

      this.field441 = var1;
      return var1;
   }

   @ObfuscatedName("remove")
   public void method156() {
      if (this.field441 == null) {
         throw new IllegalStateException();
      } else {
         this.field441.remove();
         this.field441 = null;
      }
   }
}
