import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   Node field2463;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   @Export("node")
   Node node;

   public CombatInfoList() {
      this.node = new Node();
      this.node.next = this.node;
      this.node.previous = this.node;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lge;)Lge;"
   )
   Node method3579(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.node.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.node) {
         this.field2463 = null;
         return null;
      } else {
         this.field2463 = var2.next;
         return var2;
      }
   }

   @ObfuscatedName("s")
   public boolean method3575() {
      return this.node.next == this.node;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Lge;"
   )
   public Node method3558() {
      return this.method3579((Node)null);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "()Lge;"
   )
   public Node method3560() {
      Node var1 = this.field2463;
      if(var1 == this.node) {
         this.field2463 = null;
         return null;
      } else {
         this.field2463 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lge;)V"
   )
   public void method3555(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lge;)V"
   )
   public void method3563(Node var1) {
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
      signature = "()Lge;"
   )
   public Node method3559() {
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lge;Lge;)V"
   )
   public static void method3556(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }
}
