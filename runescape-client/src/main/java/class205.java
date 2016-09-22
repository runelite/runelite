import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gg")
public class class205 implements Iterable {
   @ObfuscatedName("d")
   Node field3156;
   @ObfuscatedName("a")
   Node field3157 = new Node();

   @ObfuscatedName("a")
   public void method3898(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.field3157.previous;
      var1.next = this.field3157;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("v")
   public static void method3900(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   @ObfuscatedName("r")
   public Node method3901() {
      return this.method3902((Node)null);
   }

   @ObfuscatedName("z")
   Node method3902(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.field3157.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.field3157) {
         this.field3156 = null;
         return null;
      } else {
         this.field3156 = var2.next;
         return var2;
      }
   }

   @ObfuscatedName("t")
   public Node method3903() {
      Node var1 = this.field3156;
      if(var1 == this.field3157) {
         this.field3156 = null;
         return null;
      } else {
         this.field3156 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("n")
   public boolean method3909() {
      return this.field3157.next == this.field3157;
   }

   public class205() {
      this.field3157.next = this.field3157;
      this.field3157.previous = this.field3157;
   }

   @ObfuscatedName("d")
   public void method3917(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.field3157;
      var1.next = this.field3157.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   public Iterator iterator() {
      return new class208(this);
   }
}
