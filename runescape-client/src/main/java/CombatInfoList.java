import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   Node field2448;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("node")
   Node node;

   public CombatInfoList() {
      this.node = new Node();
      this.node.next = this.node;
      this.node.previous = this.node;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgx;)Lgx;"
   )
   Node method3568(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.node.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.node) {
         this.field2448 = null;
         return null;
      } else {
         this.field2448 = var2.next;
         return var2;
      }
   }

   @ObfuscatedName("z")
   public boolean method3570() {
      return this.node.next == this.node;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "()Lgx;"
   )
   public Node method3567() {
      return this.method3568((Node)null);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Lgx;"
   )
   public Node method3569() {
      Node var1 = this.field2448;
      if(var1 == this.node) {
         this.field2448 = null;
         return null;
      } else {
         this.field2448 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgx;)V"
   )
   public void method3564(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgx;)V"
   )
   public void method3580(Node var1) {
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
      signature = "()Lgx;"
   )
   public Node method3584() {
      Node var1 = this.node.next;
      if(var1 == this.node) {
         return null;
      } else {
         var1.unlink();
         return var1;
      }
   }

   public Iterator iterator() {
      return new class189(this);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgx;Lgx;)V"
   )
   public static void method3576(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }
}
