import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gm")
public class class205 implements Iterable {
   @ObfuscatedName("e")
   Node field3152;
   @ObfuscatedName("f")
   Node field3153 = new Node();

   @ObfuscatedName("b")
   public Node method3928() {
      Node var1 = this.field3152;
      if(var1 == this.field3153) {
         this.field3152 = null;
         return null;
      } else {
         this.field3152 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("f")
   public void method3929(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.field3153.previous;
      var1.next = this.field3153;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("e")
   public void method3930(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.field3153;
      var1.next = this.field3153.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("t")
   public Node method3932() {
      return this.method3933((Node)null);
   }

   @ObfuscatedName("v")
   Node method3933(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.field3153.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.field3153) {
         this.field3152 = null;
         return null;
      } else {
         this.field3152 = var2.next;
         return var2;
      }
   }

   @ObfuscatedName("m")
   public boolean method3935() {
      return this.field3153.next == this.field3153;
   }

   public Iterator iterator() {
      return new class208(this);
   }

   public class205() {
      this.field3153.next = this.field3153;
      this.field3153.previous = this.field3153;
   }

   @ObfuscatedName("n")
   public static void method3936(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }
}
