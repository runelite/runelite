import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dx")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("p")
   @Export("node")
   Node node = new Node();
   @ObfuscatedName("g")
   Node field1881;

   @ObfuscatedName("x")
   public static void method2380(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   @ObfuscatedName("q")
   public Node method2381() {
      return this.method2382((Node)null);
   }

   @ObfuscatedName("d")
   Node method2382(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.node.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.node) {
         this.field1881 = null;
         return null;
      } else {
         this.field1881 = var2.next;
         return var2;
      }
   }

   public CombatInfoList() {
      this.node.next = this.node;
      this.node.previous = this.node;
   }

   @ObfuscatedName("j")
   public boolean method2383() {
      return this.node.next == this.node;
   }

   @ObfuscatedName("g")
   public void method2384(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("k")
   public Node method2389() {
      Node var1 = this.field1881;
      if(var1 == this.node) {
         this.field1881 = null;
         return null;
      } else {
         this.field1881 = var1.next;
         return var1;
      }
   }

   public Iterator iterator() {
      return new class123(this);
   }

   @ObfuscatedName("p")
   public void method2398(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node.previous;
      var1.next = this.node;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }
}
