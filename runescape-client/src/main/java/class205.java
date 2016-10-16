import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gz")
public class class205 implements Iterable {
   @ObfuscatedName("s")
   Node field3152 = new Node();
   @ObfuscatedName("z")
   Node field3153;

   @ObfuscatedName("t")
   public static void method3846(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   @ObfuscatedName("s")
   public void method3847(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.field3152.previous;
      var1.next = this.field3152;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("y")
   public Node method3850() {
      return this.method3854((Node)null);
   }

   @ObfuscatedName("z")
   public void method3851(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.field3152;
      var1.next = this.field3152.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("g")
   public Node method3852() {
      Node var1 = this.field3153;
      if(var1 == this.field3152) {
         this.field3153 = null;
         return null;
      } else {
         this.field3153 = var1.next;
         return var1;
      }
   }

   public class205() {
      this.field3152.next = this.field3152;
      this.field3152.previous = this.field3152;
   }

   @ObfuscatedName("p")
   Node method3854(Node var1) {
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

   @ObfuscatedName("m")
   public boolean method3866() {
      return this.field3152.next == this.field3152;
   }

   public Iterator iterator() {
      return new class208(this);
   }
}
