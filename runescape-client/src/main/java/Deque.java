import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ga")
@Implements("Deque")
public class Deque {
   @ObfuscatedName("q")
   @Export("current")
   Node current;
   @ObfuscatedName("k")
   @Export("head")
   public Node head = new Node();

   @ObfuscatedName("q")
   public void method3844(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.head.previous;
      var1.next = this.head;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("f")
   public void method3845(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.head;
      var1.next = this.head.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("j")
   public Node method3848() {
      Node var1 = this.head.previous;
      if(var1 == this.head) {
         return null;
      } else {
         var1.unlink();
         return var1;
      }
   }

   @ObfuscatedName("k")
   public void method3850() {
      while(true) {
         Node var1 = this.head.next;
         if(var1 == this.head) {
            this.current = null;
            return;
         }

         var1.unlink();
      }
   }

   @ObfuscatedName("u")
   public Node method3851() {
      Node var1 = this.current;
      if(var1 == this.head) {
         this.current = null;
         return null;
      } else {
         this.current = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("y")
   public Node method3852() {
      Node var1 = this.head.previous;
      if(var1 == this.head) {
         this.current = null;
         return null;
      } else {
         this.current = var1.previous;
         return var1;
      }
   }

   @ObfuscatedName("c")
   public static void method3854(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1.previous;
      var0.next = var1;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   @ObfuscatedName("h")
   public Node method3856() {
      Node var1 = this.current;
      if(var1 == this.head) {
         this.current = null;
         return null;
      } else {
         this.current = var1.previous;
         return var1;
      }
   }

   @ObfuscatedName("v")
   public Node method3860() {
      Node var1 = this.head.next;
      if(var1 == this.head) {
         return null;
      } else {
         var1.unlink();
         return var1;
      }
   }

   public Deque() {
      this.head.next = this.head;
      this.head.previous = this.head;
   }

   @ObfuscatedName("m")
   public Node method3864() {
      Node var1 = this.head.next;
      if(var1 == this.head) {
         this.current = null;
         return null;
      } else {
         this.current = var1.next;
         return var1;
      }
   }
}
