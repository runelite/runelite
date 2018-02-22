import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
@Implements("Deque")
public class Deque {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   @Export("head")
   public Node head;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   @Export("current")
   Node current;

   public Deque() {
      this.head = new Node();
      this.head.next = this.head;
      this.head.previous = this.head;
   }

   @ObfuscatedName("b")
   @Export("clear")
   public void clear() {
      while(true) {
         Node var1 = this.head.next;
         if(var1 == this.head) {
            this.current = null;
            return;
         }

         var1.unlink();
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lhe;)V"
   )
   @Export("addFront")
   public void addFront(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.head.previous;
      var1.next = this.head;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lhe;)V"
   )
   @Export("addTail")
   public void addTail(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.head;
      var1.next = this.head.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "()Lhe;"
   )
   @Export("popFront")
   public Node popFront() {
      Node var1 = this.head.next;
      if(var1 == this.head) {
         return null;
      } else {
         var1.unlink();
         return var1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "()Lhe;"
   )
   @Export("popTail")
   public Node popTail() {
      Node var1 = this.head.previous;
      if(var1 == this.head) {
         return null;
      } else {
         var1.unlink();
         return var1;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "()Lhe;"
   )
   @Export("getFront")
   public Node getFront() {
      Node var1 = this.head.next;
      if(var1 == this.head) {
         this.current = null;
         return null;
      } else {
         this.current = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "()Lhe;"
   )
   @Export("getTail")
   public Node getTail() {
      Node var1 = this.head.previous;
      if(var1 == this.head) {
         this.current = null;
         return null;
      } else {
         this.current = var1.previous;
         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Lhe;"
   )
   @Export("getNext")
   public Node getNext() {
      Node var1 = this.current;
      if(var1 == this.head) {
         this.current = null;
         return null;
      } else {
         this.current = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "()Lhe;"
   )
   @Export("getPrevious")
   public Node getPrevious() {
      Node var1 = this.current;
      if(var1 == this.head) {
         this.current = null;
         return null;
      } else {
         this.current = var1.previous;
         return var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lhe;Lhe;)V"
   )
   public static void method4048(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1.previous;
      var0.next = var1;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }
}
