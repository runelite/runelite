import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dv")
@Implements("Deque")
public class Deque {
   @ObfuscatedName("m")
   @Export("current")
   Node current;
   @ObfuscatedName("o")
   @Export("head")
   public Node head = new Node();

   @ObfuscatedName("b")
   public void method2345(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.head;
      var1.next = this.head.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("g")
   public static void method2346(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1.previous;
      var0.next = var1;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   @ObfuscatedName("l")
   public Node method2347() {
      Node var1 = this.head.next;
      if(var1 == this.head) {
         return null;
      } else {
         var1.unlink();
         return var1;
      }
   }

   @ObfuscatedName("o")
   public void method2348() {
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
   public Node method2349() {
      Node var1 = this.head.next;
      if(var1 == this.head) {
         this.current = null;
         return null;
      } else {
         this.current = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("z")
   public Node method2351() {
      Node var1 = this.current;
      if(var1 == this.head) {
         this.current = null;
         return null;
      } else {
         this.current = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("m")
   public void method2361(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.head.previous;
      var1.next = this.head;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("y")
   public Node method2362() {
      Node var1 = this.current;
      if(var1 == this.head) {
         this.current = null;
         return null;
      } else {
         this.current = var1.previous;
         return var1;
      }
   }

   public Deque() {
      this.head.next = this.head;
      this.head.previous = this.head;
   }

   @ObfuscatedName("k")
   public Node method2372() {
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
   public Node method2373() {
      Node var1 = this.head.previous;
      if(var1 == this.head) {
         return null;
      } else {
         var1.unlink();
         return var1;
      }
   }
}
