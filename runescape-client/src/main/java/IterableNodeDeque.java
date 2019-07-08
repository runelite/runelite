import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ja")
@Implements("IterableNodeDeque")
public class IterableNodeDeque implements Iterable {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   @Export("sentinel")
   Node sentinel;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   @Export("current")
   Node current;

   public IterableNodeDeque() {
      this.sentinel = new Node();
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   @ObfuscatedName("m")
   @Export("clear")
   public void clear() {
      while (this.sentinel.previous != this.sentinel) {
         this.sentinel.previous.remove();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgw;)V"
   )
   @Export("addFirst")
   public void addFirst(Node node) {
      if (node.next != null) {
         node.remove();
      }

      node.next = this.sentinel.next;
      node.previous = this.sentinel;
      node.next.previous = node;
      node.previous.next = node;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgw;)V"
   )
   @Export("addLast")
   public void addLast(Node node) {
      if (node.next != null) {
         node.remove();
      }

      node.next = this.sentinel;
      node.previous = this.sentinel.previous;
      node.next.previous = node;
      node.previous.next = node;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "()Lgw;"
   )
   @Export("last")
   public Node last() {
      return this.previousOrLast((Node)null);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lgw;)Lgw;"
   )
   @Export("previousOrLast")
   Node previousOrLast(Node node) {
      Node var2;
      if (node == null) {
         var2 = this.sentinel.previous;
      } else {
         var2 = node;
      }

      if (var2 == this.sentinel) {
         this.current = null;
         return null;
      } else {
         this.current = var2.previous;
         return var2;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Lgw;"
   )
   @Export("previous")
   public Node previous() {
      Node var1 = this.current;
      if (var1 == this.sentinel) {
         this.current = null;
         return null;
      } else {
         this.current = var1.previous;
         return var1;
      }
   }

   @ObfuscatedName("l")
   @Export("isEmpty")
   public boolean isEmpty() {
      return this.sentinel.previous == this.sentinel;
   }

   @Export("iterator")
   @ObfuscatedName("iterator")
   public Iterator iterator() {
      return new IterableNodeDequeDescendingIterator(this);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgw;Lgw;)V"
   )
   @Export("IterableNodeDeque_addBefore")
   public static void IterableNodeDeque_addBefore(Node node, Node old) {
      if (node.next != null) {
         node.remove();
      }

      node.next = old;
      node.previous = old.previous;
      node.next.previous = node;
      node.previous.next = node;
   }
}
