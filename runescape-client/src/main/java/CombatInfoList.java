import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   Node field2466;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   @Export("node")
   Node node;

   public CombatInfoList() {
      this.node = new Node();
      this.node.next = this.node;
      this.node.previous = this.node;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lga;)Lga;"
   )
   Node method3577(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.node.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.node) {
         this.field2466 = null;
         return null;
      } else {
         this.field2466 = var2.next;
         return var2;
      }
   }

   @ObfuscatedName("l")
   public boolean method3567() {
      return this.node.next == this.node;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "()Lga;"
   )
   public Node method3572() {
      return this.method3577((Node)null);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "()Lga;"
   )
   public Node method3589() {
      Node var1 = this.field2466;
      if(var1 == this.node) {
         this.field2466 = null;
         return null;
      } else {
         this.field2466 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lga;)V"
   )
   public void method3569(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lga;)V"
   )
   public void method3568(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node.previous;
      var1.next = this.node;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "()Lga;"
   )
   public Node method3571() {
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lga;Lga;)V"
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
