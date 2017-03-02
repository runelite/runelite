import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dv")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("l")
   Node field1874;
   @ObfuscatedName("b")
   @Export("node")
   Node node = new Node();

   @ObfuscatedName("b")
   public void method2432(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node.previous;
      var1.next = this.node;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("l")
   public void method2433(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("i")
   public static void method2434(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   @ObfuscatedName("k")
   Node method2436(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.node.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.node) {
         this.field1874 = null;
         return null;
      } else {
         this.field1874 = var2.next;
         return var2;
      }
   }

   @ObfuscatedName("x")
   public Node method2437() {
      Node var1 = this.field1874;
      if(var1 == this.node) {
         this.field1874 = null;
         return null;
      } else {
         this.field1874 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("z")
   public boolean method2438() {
      return this.node.next == this.node;
   }

   public Iterator iterator() {
      return new class123(this);
   }

   @ObfuscatedName("t")
   public Node method2455() {
      return this.method2436((Node)null);
   }

   public CombatInfoList() {
      this.node.next = this.node;
      this.node.previous = this.node;
   }
}
