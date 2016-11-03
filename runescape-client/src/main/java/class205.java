import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gg")
public class class205 implements Iterable {
   @ObfuscatedName("k")
   Node field3152 = new Node();
   @ObfuscatedName("q")
   Node field3153;

   @ObfuscatedName("k")
   public void method3884(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.field3152.previous;
      var1.next = this.field3152;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("f")
   public static void method3887(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   @ObfuscatedName("v")
   Node method3888(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.field3152.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.field3152) {
         this.field3153 = null;
         return null;
      } else {
         this.field3153 = var2.next;
         return var2;
      }
   }

   public class205() {
      this.field3152.next = this.field3152;
      this.field3152.previous = this.field3152;
   }

   public Iterator iterator() {
      return new class208(this);
   }

   @ObfuscatedName("c")
   public Node method3893() {
      return this.method3888((Node)null);
   }

   @ObfuscatedName("u")
   public boolean method3897() {
      return this.field3152.next == this.field3152;
   }

   @ObfuscatedName("q")
   public void method3902(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.field3152;
      var1.next = this.field3152.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("y")
   public Node method3913() {
      Node var1 = this.field3153;
      if(var1 == this.field3152) {
         this.field3153 = null;
         return null;
      } else {
         this.field3153 = var1.next;
         return var1;
      }
   }
}
