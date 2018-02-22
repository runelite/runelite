import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   @Export("node")
   Node node;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   @Export("current")
   Node current;

   public CombatInfoList() {
      this.node = new Node();
      this.node.next = this.node;
      this.node.previous = this.node;
   }

   @ObfuscatedName("b")
   public void method4003() {
      while(this.node.next != this.node) {
         this.node.next.unlink();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lhe;)V"
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
      signature = "(Lhe;)V"
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "()Lhe;"
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "()Lhe;"
   )
   @Export("last")
   public Node last() {
      return this.previousOrLast((Node)null);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lhe;)Lhe;"
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

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "()Lhe;"
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

   @ObfuscatedName("g")
   @Export("isEmpty")
   public boolean isEmpty() {
      return this.node.next == this.node;
   }

   public Iterator iterator() {
      return new class208(this);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lhe;Lhe;)V"
   )
   public static void method4006(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }
}
