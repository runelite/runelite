import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gy")
@Implements("Deque")
public class Deque {
   @ObfuscatedName("p")
   @Export("head")
   public Node head;
   @ObfuscatedName("m")
   @Export("current")
   Node current;

   @ObfuscatedName("p")
   public void method3481() {
      while(true) {
         Node var1 = this.head.next;
         if(this.head == var1) {
            this.current = null;
            return;
         }

         var1.unlink();
      }
   }

   @ObfuscatedName("w")
   public Node method3485() {
      Node var1 = this.head.next;
      if(this.head == var1) {
         return null;
      } else {
         var1.unlink();
         return var1;
      }
   }

   @ObfuscatedName("j")
   public Node method3487() {
      Node var1 = this.head.next;
      if(this.head == var1) {
         this.current = null;
         return null;
      } else {
         this.current = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("c")
   public Node method3488() {
      Node var1 = this.head.previous;
      if(this.head == var1) {
         this.current = null;
         return null;
      } else {
         this.current = var1.previous;
         return var1;
      }
   }

   @ObfuscatedName("q")
   public Node method3490() {
      Node var1 = this.current;
      if(this.head == var1) {
         this.current = null;
         return null;
      } else {
         this.current = var1.previous;
         return var1;
      }
   }

   @ObfuscatedName("e")
   public void method3501(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.head;
      var1.next = this.head.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("m")
   public void method3505(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.head.previous;
      var1.next = this.head;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   public Deque() {
      this.head = new Node();
      this.head.next = this.head;
      this.head.previous = this.head;
   }

   @ObfuscatedName("o")
   public Node method3512() {
      Node var1 = this.current;
      if(this.head == var1) {
         this.current = null;
         return null;
      } else {
         this.current = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("z")
   public Node method3513() {
      Node var1 = this.head.previous;
      if(this.head == var1) {
         return null;
      } else {
         var1.unlink();
         return var1;
      }
   }

   @ObfuscatedName("t")
   public static void method3518(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1.previous;
      var0.next = var1;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }
}
