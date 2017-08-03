import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   Node field2437;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   @Export("node")
   Node node;

   public CombatInfoList() {
      this.node = new Node();
      this.node.next = this.node;
      this.node.previous = this.node;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgm;)Lgm;"
   )
   Node method3582(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.node.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.node) {
         this.field2437 = null;
         return null;
      } else {
         this.field2437 = var2.next;
         return var2;
      }
   }

   @ObfuscatedName("t")
   public boolean method3584() {
      return this.node.next == this.node;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "()Lgm;"
   )
   public Node method3581() {
      return this.method3582((Node)null);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Lgm;"
   )
   public Node method3576() {
      Node var1 = this.field2437;
      if(var1 == this.node) {
         this.field2437 = null;
         return null;
      } else {
         this.field2437 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgm;)V"
   )
   public void method3590(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgm;)V"
   )
   public void method3577(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node.previous;
      var1.next = this.node;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "()Lgm;"
   )
   public Node method3595() {
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgm;Lgm;)V"
   )
   public static void method3579(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }
}
