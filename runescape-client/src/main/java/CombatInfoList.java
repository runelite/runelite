import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   @Export("node")
   Node node;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   Node field2553;

   public CombatInfoList() {
      this.node = new Node();
      this.node.next = this.node;
      this.node.previous = this.node;
   }

   @ObfuscatedName("b")
   public void method3606() {
      while(this.node.next != this.node) {
         this.node.next.unlink();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgt;)V"
   )
   public void method3618(Node var1) {
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
      signature = "(Lgt;)V"
   )
   public void method3608(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "()Lgt;"
   )
   public Node method3605() {
      Node var1 = this.node.next;
      if(var1 == this.node) {
         return null;
      } else {
         var1.unlink();
         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "()Lgt;"
   )
   public Node method3611() {
      return this.method3612((Node)null);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lgt;)Lgt;"
   )
   Node method3612(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.node.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.node) {
         this.field2553 = null;
         return null;
      } else {
         this.field2553 = var2.next;
         return var2;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "()Lgt;"
   )
   public Node method3613() {
      Node var1 = this.field2553;
      if(var1 == this.node) {
         this.field2553 = null;
         return null;
      } else {
         this.field2553 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("k")
   public boolean method3614() {
      return this.node.next == this.node;
   }

   public Iterator iterator() {
      return new class195(this);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgt;Lgt;)V"
   )
   public static void method3609(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }
}
