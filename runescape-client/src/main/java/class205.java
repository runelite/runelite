import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gr")
public class class205 implements Iterable {
   @ObfuscatedName("h")
   Node field3160;
   @ObfuscatedName("i")
   Node field3161 = new Node();

   @ObfuscatedName("i")
   public void method3878(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.field3161.previous;
      var1.next = this.field3161;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("g")
   public Node method3881() {
      return this.method3882((Node)null);
   }

   @ObfuscatedName("n")
   Node method3882(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.field3161.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.field3161) {
         this.field3160 = null;
         return null;
      } else {
         this.field3160 = var2.next;
         return var2;
      }
   }

   @ObfuscatedName("u")
   public Node method3883() {
      Node var1 = this.field3160;
      if(var1 == this.field3161) {
         this.field3160 = null;
         return null;
      } else {
         this.field3160 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("d")
   public boolean method3884() {
      return this.field3161.next == this.field3161;
   }

   public Iterator iterator() {
      return new class208(this);
   }

   @ObfuscatedName("e")
   public static void method3890(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   public class205() {
      this.field3161.next = this.field3161;
      this.field3161.previous = this.field3161;
   }

   @ObfuscatedName("h")
   public void method3899(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.field3161;
      var1.next = this.field3161.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }
}
