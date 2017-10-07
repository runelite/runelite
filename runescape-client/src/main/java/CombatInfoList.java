import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   Node field2482;
   @ObfuscatedName("d")
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgs;)Lgs;"
   )
   Node method3678(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.node.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.node) {
         this.field2482 = null;
         return null;
      } else {
         this.field2482 = var2.next;
         return var2;
      }
   }

   @ObfuscatedName("g")
   public boolean method3667() {
      return this.node.next == this.node;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "()Lgs;"
   )
   public Node method3664() {
      return this.method3678((Node)null);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "()Lgs;"
   )
   public Node method3665() {
      Node var1 = this.field2482;
      if(var1 == this.node) {
         this.field2482 = null;
         return null;
      } else {
         this.field2482 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgs;)V"
   )
   public void method3661(Node var1) {
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
      signature = "(Lgs;)V"
   )
   public void method3660(Node var1) {
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
      signature = "()Lgs;"
   )
   public Node method3663() {
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgs;Lgs;)V"
   )
   public static void method3662(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }
}
