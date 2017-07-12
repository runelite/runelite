import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gf")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("w")
   Node field2470;
   @ObfuscatedName("i")
   @Export("node")
   Node node;

   public CombatInfoList() {
      this.node = new Node();
      this.node.next = this.node;
      this.node.previous = this.node;
   }

   @ObfuscatedName("r")
   Node method3569(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.node.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.node) {
         this.field2470 = null;
         return null;
      } else {
         this.field2470 = var2.next;
         return var2;
      }
   }

   @ObfuscatedName("y")
   public boolean method3550() {
      return this.node.next == this.node;
   }

   @ObfuscatedName("s")
   public Node method3547() {
      return this.method3569((Node)null);
   }

   @ObfuscatedName("v")
   public Node method3558() {
      Node var1 = this.field2470;
      if(var1 == this.node) {
         this.field2470 = null;
         return null;
      } else {
         this.field2470 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("w")
   public void method3544(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("i")
   public void method3543(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node.previous;
      var1.next = this.node;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("t")
   public Node method3546() {
      Node var1 = this.node.next;
      if(var1 == this.node) {
         return null;
      } else {
         var1.unlink();
         return var1;
      }
   }

   public Iterator iterator() {
      return new class188(this);
   }

   @ObfuscatedName("a")
   public static void method3545(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }
}
