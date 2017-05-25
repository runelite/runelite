import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gu")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("h")
   Node field2463;
   @ObfuscatedName("i")
   @Export("node")
   Node node;

   @ObfuscatedName("h")
   public void method3619(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("g")
   public Node method3620() {
      return this.method3624((Node)null);
   }

   public CombatInfoList() {
      this.node = new Node();
      this.node.next = this.node;
      this.node.previous = this.node;
   }

   @ObfuscatedName("q")
   public Node method3622() {
      Node var1 = this.node.next;
      if(var1 == this.node) {
         return null;
      } else {
         var1.unlink();
         return var1;
      }
   }

   @ObfuscatedName("v")
   Node method3624(Node var1) {
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

   @ObfuscatedName("t")
   public Node method3625() {
      Node var1 = this.field2463;
      if(var1 == this.node) {
         this.field2463 = null;
         return null;
      } else {
         this.field2463 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("p")
   public boolean method3626() {
      return this.node.next == this.node;
   }

   @ObfuscatedName("u")
   public static void method3627(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   @ObfuscatedName("i")
   public void method3634(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node.previous;
      var1.next = this.node;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   public Iterator iterator() {
      return new class188(this);
   }
}
