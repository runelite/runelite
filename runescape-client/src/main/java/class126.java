import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("di")
public class class126 implements Iterable {
   @ObfuscatedName("n")
   Node field1875 = new Node();
   @ObfuscatedName("d")
   Node field1876;

   @ObfuscatedName("r")
   public Node method2420() {
      Node var1 = this.field1876;
      if(var1 == this.field1875) {
         this.field1876 = null;
         return null;
      } else {
         this.field1876 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("n")
   public void method2421(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.field1875.previous;
      var1.next = this.field1875;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("m")
   public static void method2423(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   @ObfuscatedName("w")
   Node method2425(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.field1875.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.field1875) {
         this.field1876 = null;
         return null;
      } else {
         this.field1876 = var2.next;
         return var2;
      }
   }

   @ObfuscatedName("c")
   public boolean method2427() {
      return this.field1875.next == this.field1875;
   }

   public Iterator iterator() {
      return new class123(this);
   }

   @ObfuscatedName("h")
   public Node method2428() {
      return this.method2425((Node)null);
   }

   @ObfuscatedName("d")
   public void method2434(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.field1875;
      var1.next = this.field1875.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   public class126() {
      this.field1875.next = this.field1875;
      this.field1875.previous = this.field1875;
   }
}
