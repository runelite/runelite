import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gj")
public class class205 implements Iterable {
   @ObfuscatedName("r")
   Node field3159;
   @ObfuscatedName("x")
   Node field3160 = new Node();

   @ObfuscatedName("b")
   public Node method3882() {
      Node var1 = this.field3159;
      if(var1 == this.field3160) {
         this.field3159 = null;
         return null;
      } else {
         this.field3159 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("x")
   public void method3883(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.field3160.previous;
      var1.next = this.field3160;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("r")
   public void method3884(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.field3160;
      var1.next = this.field3160.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("j")
   public static void method3885(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   @ObfuscatedName("i")
   Node method3887(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.field3160.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.field3160) {
         this.field3159 = null;
         return null;
      } else {
         this.field3159 = var2.next;
         return var2;
      }
   }

   public class205() {
      this.field3160.next = this.field3160;
      this.field3160.previous = this.field3160;
   }

   @ObfuscatedName("l")
   public boolean method3889() {
      return this.field3160.next == this.field3160;
   }

   @ObfuscatedName("z")
   public Node method3897() {
      return this.method3887((Node)null);
   }

   public Iterator iterator() {
      return new class208(this);
   }
}
