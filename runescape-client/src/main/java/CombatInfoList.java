import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   @Export("node")
   Node node;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   @Export("current")
   Node current;

   public CombatInfoList() {
      this.node = new Node();
      this.node.next = this.node;
      this.node.previous = this.node;
   }

   @ObfuscatedName("c")
   public void method3983() {
      while(this.node.next != this.node) {
         this.node.next.unlink();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lhg;)V"
   )
   @Export("addFirst")
   public void addFirst(Node var1) {
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
      signature = "(Lhg;)V"
   )
   @Export("addLast")
   public void addLast(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "()Lhg;"
   )
   @Export("removeLast")
   public Node removeLast() {
      Node var1 = this.node.next;
      if(var1 == this.node) {
         return null;
      } else {
         var1.unlink();
         return var1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "()Lhg;"
   )
   @Export("last")
   public Node last() {
      return this.previousOrLast((Node)null);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lhg;)Lhg;"
   )
   @Export("previousOrLast")
   Node previousOrLast(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.node.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.node) {
         this.current = null;
         return null;
      } else {
         this.current = var2.next;
         return var2;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "()Lhg;"
   )
   @Export("previous")
   public Node previous() {
      Node var1 = this.current;
      if(var1 == this.node) {
         this.current = null;
         return null;
      } else {
         this.current = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("w")
   @Export("isEmpty")
   public boolean isEmpty() {
      return this.node.next == this.node;
   }

   public Iterator iterator() {
      return new class211(this);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lhg;Lhg;)V"
   )
   public static void method3986(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }
}
