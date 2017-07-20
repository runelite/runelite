import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   Node field2434;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("node")
   Node node;

   public CombatInfoList() {
      this.node = new Node();
      this.node.next = this.node;
      this.node.previous = this.node;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgh;)Lgh;"
   )
   Node method3514(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.node.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.node) {
         this.field2434 = null;
         return null;
      } else {
         this.field2434 = var2.next;
         return var2;
      }
   }

   @ObfuscatedName("x")
   public boolean method3516() {
      return this.node.next == this.node;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Lgh;"
   )
   public Node method3513() {
      return this.method3514((Node)null);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "()Lgh;"
   )
   public Node method3527() {
      Node var1 = this.field2434;
      if(var1 == this.node) {
         this.field2434 = null;
         return null;
      } else {
         this.field2434 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgh;)V"
   )
   public void method3523(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lgh;)V"
   )
   public void method3509(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node.previous;
      var1.next = this.node;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "()Lgh;"
   )
   public Node method3512() {
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgh;Lgh;)V"
   )
   public static void method3511(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }
}
