import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gi")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("i")
   @Export("node")
   Node node;
   @ObfuscatedName("c")
   Node field2478;

   @ObfuscatedName("b")
   public Node method3530() {
      return this.method3535((Node)null);
   }

   @ObfuscatedName("i")
   public void method3531(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node.previous;
      var1.next = this.node;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("c")
   public void method3532(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("v")
   public Node method3534() {
      Node var1 = this.node.next;
      if(var1 == this.node) {
         return null;
      } else {
         var1.unlink();
         return var1;
      }
   }

   @ObfuscatedName("y")
   Node method3535(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.node.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.node) {
         this.field2478 = null;
         return null;
      } else {
         this.field2478 = var2.next;
         return var2;
      }
   }

   @ObfuscatedName("x")
   public boolean method3538() {
      return this.node.next == this.node;
   }

   public Iterator iterator() {
      return new class188(this);
   }

   @ObfuscatedName("e")
   public static void method3539(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   @ObfuscatedName("h")
   public Node method3540() {
      Node var1 = this.field2478;
      if(var1 == this.node) {
         this.field2478 = null;
         return null;
      } else {
         this.field2478 = var1.next;
         return var1;
      }
   }

   public CombatInfoList() {
      this.node = new Node();
      this.node.next = this.node;
      this.node.previous = this.node;
   }
}
