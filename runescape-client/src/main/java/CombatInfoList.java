import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gb")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("p")
   @Export("node")
   Node node;
   @ObfuscatedName("m")
   Node field2480;

   public Iterator iterator() {
      return new class188(this);
   }

   @ObfuscatedName("p")
   public void method3441(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node.previous;
      var1.next = this.node;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("m")
   public void method3442(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("e")
   public static void method3443(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   @ObfuscatedName("t")
   public Node method3444() {
      Node var1 = this.node.next;
      if(this.node == var1) {
         return null;
      } else {
         var1.unlink();
         return var1;
      }
   }

   @ObfuscatedName("z")
   Node method3446(Node var1) {
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

   @ObfuscatedName("j")
   public Node method3448() {
      Node var1 = this.field2480;
      if(this.node == var1) {
         this.field2480 = null;
         return null;
      } else {
         this.field2480 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("c")
   public boolean method3449() {
      return this.node == this.node.next;
   }

   public CombatInfoList() {
      this.node = new Node();
      this.node.next = this.node;
      this.node.previous = this.node;
   }

   @ObfuscatedName("w")
   public Node method3457() {
      return this.method3446((Node)null);
   }
}
