import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dl")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("n")
   Node field1881;
   @ObfuscatedName("x")
   @Export("node")
   Node node = new Node();

   @ObfuscatedName("v")
   public Node method2453() {
      return this.method2458((Node)null);
   }

   @ObfuscatedName("x")
   public void method2454(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node.previous;
      var1.next = this.node;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("n")
   public void method2455(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("g")
   public static void method2456(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   @ObfuscatedName("y")
   Node method2458(Node var1) {
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

   @ObfuscatedName("j")
   public boolean method2460() {
      return this.node.next == this.node;
   }

   public CombatInfoList() {
      this.node.next = this.node;
      this.node.previous = this.node;
   }

   @ObfuscatedName("p")
   public Node method2468() {
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
}
