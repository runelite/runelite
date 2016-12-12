import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dr")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("i")
   @Export("node")
   Node node = new Node();
   @ObfuscatedName("e")
   Node field1875;

   public Iterator iterator() {
      return new class123(this);
   }

   @ObfuscatedName("i")
   public void method2325(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node.previous;
      var1.next = this.node;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("k")
   public Node method2326() {
      return this.method2335((Node)null);
   }

   public CombatInfoList() {
      this.node.next = this.node;
      this.node.previous = this.node;
   }

   @ObfuscatedName("q")
   public Node method2327() {
      Node var1 = this.field1875;
      if(var1 == this.node) {
         this.field1875 = null;
         return null;
      } else {
         this.field1875 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("w")
   public boolean method2328() {
      return this.node.next == this.node;
   }

   @ObfuscatedName("e")
   public void method2329(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("f")
   public static void method2332(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   @ObfuscatedName("a")
   Node method2335(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.node.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.node) {
         this.field1875 = null;
         return null;
      } else {
         this.field1875 = var2.next;
         return var2;
      }
   }
}
