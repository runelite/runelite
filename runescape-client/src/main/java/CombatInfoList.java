import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("du")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("i")
   Node field1901;
   @ObfuscatedName("f")
   @Export("node")
   Node node = new Node();

   @ObfuscatedName("n")
   public boolean method2429() {
      return this.node.next == this.node;
   }

   @ObfuscatedName("f")
   public void method2430(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node.previous;
      var1.next = this.node;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("u")
   public static void method2432(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   @ObfuscatedName("l")
   public Node method2433() {
      Node var1 = this.field1901;
      if(var1 == this.node) {
         this.field1901 = null;
         return null;
      } else {
         this.field1901 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("o")
   Node method2434(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.node.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.node) {
         this.field1901 = null;
         return null;
      } else {
         this.field1901 = var2.next;
         return var2;
      }
   }

   public Iterator iterator() {
      return new class123(this);
   }

   @ObfuscatedName("r")
   public Node method2442() {
      return this.method2434((Node)null);
   }

   @ObfuscatedName("i")
   public void method2443(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   public CombatInfoList() {
      this.node.next = this.node;
      this.node.previous = this.node;
   }
}
