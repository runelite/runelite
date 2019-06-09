import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
@Implements("NodeDeque")
public class NodeDeque {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   @Export("sentinel")
   public Node sentinel;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   @Export("current")
   Node current;

   public NodeDeque() {
      this.sentinel = new Node();
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   @ObfuscatedName("m")
   @Export("clear")
   public void clear() {
      while(true) {
         Node var1 = this.sentinel.previous;
         if(var1 == this.sentinel) {
            this.current = null;
            return;
         }

         var1.remove();
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
   @Export("removeLast")
   public Node removeLast() {
      Node var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.remove();
         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "()Lgw;"
   )
   @Export("removeFirst")
   public Node removeFirst() {
      Node var1 = this.sentinel.next;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.remove();
         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Lgw;"
   )
   @Export("last")
   public Node last() {
      Node var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         this.current = null;
         return null;
      } else {
         this.current = var1.previous;
         return var1;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "()Lgw;"
   )
   @Export("first")
   public Node first() {
      Node var1 = this.sentinel.next;
      if(var1 == this.sentinel) {
         this.current = null;
         return null;
      } else {
         this.current = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("e")
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "()Lgw;"
   )
   @Export("next")
   public Node next() {
      Node var1 = this.current;
      if(var1 == this.sentinel) {
         this.current = null;
         return null;
      } else {
         this.current = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgw;Lgw;)V"
   )
   public static void method5270(Node var0, Node var1) {
      if(var0.next != null) {
         var0.remove();
      }

      var0.next = var1.next;
      var0.previous = var1;
      var0.next.previous = var0;
      var0.previous.next = var0;
   }
}
