import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("node")
   Node node;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   Node field2560;

   public CombatInfoList() {
      this.node = new Node();
      this.node.next = this.node;
      this.node.previous = this.node;
   }

   @ObfuscatedName("m")
   public void method3736() {
      while(this.node.next != this.node) {
         this.node.next.unlink();
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgh;)V"
   )
   public void method3749(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node.previous;
      var1.next = this.node;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgh;)V"
   )
   public void method3740(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Lgh;"
   )
   public Node method3756() {
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
      signature = "()Lgh;"
   )
   public Node method3741() {
      return this.method3742((Node)null);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgh;)Lgh;"
   )
   Node method3742(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.node.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.node) {
         this.field2560 = null;
         return null;
      } else {
         this.field2560 = var2.next;
         return var2;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "()Lgh;"
   )
   public Node method3743() {
      Node var1 = this.field2560;
      if(var1 == this.node) {
         this.field2560 = null;
         return null;
      } else {
         this.field2560 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("b")
   public boolean method3744() {
      return this.node.next == this.node;
   }

   public Iterator iterator() {
      return new class195(this);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgh;Lgh;)V"
   )
   public static void method3738(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }
}
