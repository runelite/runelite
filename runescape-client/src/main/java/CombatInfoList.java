import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gm")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("n")
   @Export("node")
   Node node;
   @ObfuscatedName("p")
   Node field2480;

   @ObfuscatedName("z")
   public boolean method3568() {
      return this.node.next == this.node;
   }

   @ObfuscatedName("j")
   public Node method3570() {
      Node var1 = this.node.next;
      if(var1 == this.node) {
         return null;
      } else {
         var1.unlink();
         return var1;
      }
   }

   @ObfuscatedName("f")
   public Node method3571() {
      return this.method3588((Node)null);
   }

   @ObfuscatedName("c")
   public Node method3573() {
      Node var1 = this.field2480;
      if(var1 == this.node) {
         this.field2480 = null;
         return null;
      } else {
         this.field2480 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("n")
   public void method3574(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node.previous;
      var1.next = this.node;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   public Iterator iterator() {
      return new class188(this);
   }

   @ObfuscatedName("p")
   public void method3576(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("i")
   public static void method3585(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   public CombatInfoList() {
      this.node = new Node();
      this.node.next = this.node;
      this.node.previous = this.node;
   }

   @ObfuscatedName("m")
   Node method3588(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.node.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.node) {
         this.field2480 = null;
         return null;
      } else {
         this.field2480 = var2.next;
         return var2;
      }
   }
}
