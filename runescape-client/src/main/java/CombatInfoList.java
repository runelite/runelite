import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   Node field2471;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("node")
   Node node;

   public CombatInfoList() {
      this.node = new Node();
      this.node.next = this.node;
      this.node.previous = this.node;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgs;)Lgs;"
   )
   Node method3643(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.node.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.node) {
         this.field2471 = null;
         return null;
      } else {
         this.field2471 = var2.next;
         return var2;
      }
   }

   @ObfuscatedName("b")
   public boolean method3645() {
      return this.node.next == this.node;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "()Lgs;"
   )
   public Node method3642() {
      return this.method3643((Node)null);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "()Lgs;"
   )
   public Node method3644() {
      Node var1 = this.field2471;
      if(var1 == this.node) {
         this.field2471 = null;
         return null;
      } else {
         this.field2471 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgs;)V"
   )
   public void method3639(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgs;)V"
   )
   public void method3638(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node.previous;
      var1.next = this.node;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "()Lgs;"
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
      return new class189(this);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgs;Lgs;)V"
   )
   public static void method3640(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }
}
