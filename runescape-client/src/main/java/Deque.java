import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gw")
@Implements("Deque")
public class Deque {
   @ObfuscatedName("w")
   @Export("current")
   Node current;
   @ObfuscatedName("i")
   @Export("head")
   public Node head;

   @ObfuscatedName("j")
   public Node method3578() {
      Node var1 = this.current;
      if(this.head == var1) {
         this.current = null;
         return null;
      } else {
         this.current = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("a")
   public void method3580(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.head;
      var1.next = this.head.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("t")
   public static void method3581(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1.previous;
      var0.next = var1;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   @ObfuscatedName("i")
   public void method3582() {
      while(true) {
         Node var1 = this.head.next;
         if(this.head == var1) {
            this.current = null;
            return;
         }

         var1.unlink();
      }
   }

   @ObfuscatedName("r")
   public Node method3583() {
      Node var1 = this.head.previous;
      if(this.head == var1) {
         return null;
      } else {
         var1.unlink();
         return var1;
      }
   }

   @ObfuscatedName("v")
   public Node method3584() {
      Node var1 = this.head.next;
      if(this.head == var1) {
         this.current = null;
         return null;
      } else {
         this.current = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("y")
   public Node method3585() {
      Node var1 = this.head.previous;
      if(this.head == var1) {
         this.current = null;
         return null;
      } else {
         this.current = var1.previous;
         return var1;
      }
   }

   @ObfuscatedName("s")
   public Node method3587() {
      Node var1 = this.head.next;
      if(this.head == var1) {
         return null;
      } else {
         var1.unlink();
         return var1;
      }
   }

   public Deque() {
      this.head = new Node();
      this.head.next = this.head;
      this.head.previous = this.head;
   }

   @ObfuscatedName("k")
   public Node method3591() {
      Node var1 = this.current;
      if(this.head == var1) {
         this.current = null;
         return null;
      } else {
         this.current = var1.previous;
         return var1;
      }
   }

   @ObfuscatedName("w")
   public void method3603(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.head.previous;
      var1.next = this.head;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }
}
