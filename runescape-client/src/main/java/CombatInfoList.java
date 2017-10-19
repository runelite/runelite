import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   Node field2461;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   @Export("node")
   Node node;

   public CombatInfoList() {
      this.node = new Node();
      this.node.next = this.node;
      this.node.previous = this.node;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lgd;)Lgd;"
   )
   Node method3656(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.node.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.node) {
         this.field2461 = null;
         return null;
      } else {
         this.field2461 = var2.next;
         return var2;
      }
   }

   @ObfuscatedName("e")
   public boolean method3658() {
      return this.node.next == this.node;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Lgd;"
   )
   public Node method3655() {
      return this.method3656((Node)null);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "()Lgd;"
   )
   public Node method3677() {
      Node var1 = this.field2461;
      if(var1 == this.node) {
         this.field2461 = null;
         return null;
      } else {
         this.field2461 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgd;)V"
   )
   public void method3652(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgd;)V"
   )
   public void method3651(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node.previous;
      var1.next = this.node;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "()Lgd;"
   )
   public Node method3654() {
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgd;Lgd;)V"
   )
   public static void method3680(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }
}
