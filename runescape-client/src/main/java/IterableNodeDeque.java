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
      while(this.sentinel.previous != this.sentinel) {
         this.sentinel.previous.remove();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgw;)V"
   )
   @Export("addFirst")
   public void addFirst(Node var1) {
      if(var1.next != null) {
         var1.remove();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgw;)V"
   )
   @Export("addLast")
   public void addLast(Node var1) {
      if(var1.next != null) {
         var1.remove();
      }

      var1.next = this.sentinel;
      var1.previous = this.sentinel.previous;
      var1.next.previous = var1;
      var1.previous.next = var1;
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
   Node previousOrLast(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.sentinel.previous;
      } else {
         var2 = var1;
      }

      if(var2 == this.sentinel) {
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
      if(var1 == this.sentinel) {
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
   public static void IterableNodeDeque_addBefore(Node var0, Node var1) {
      if(var0.next != null) {
         var0.remove();
      }

      var0.next = var1;
      var0.previous = var1.previous;
      var0.next.previous = var0;
      var0.previous.next = var0;
   }
}
