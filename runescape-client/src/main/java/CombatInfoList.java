import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dl")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("q")
   @Export("node")
   Node node = new Node();
   @ObfuscatedName("d")
   Node field1879;

   @ObfuscatedName("n")
   public Node method2415() {
      Node var1 = this.field1879;
      if(var1 == this.node) {
         this.field1879 = null;
         return null;
      } else {
         this.field1879 = var1.next;
         return var1;
      }
   }

   public CombatInfoList() {
      this.node.next = this.node;
      this.node.previous = this.node;
   }

   @ObfuscatedName("j")
   Node method2419(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.node.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.node) {
         this.field1879 = null;
         return null;
      } else {
         this.field1879 = var2.next;
         return var2;
      }
   }

   @ObfuscatedName("p")
   public Node method2420() {
      return this.method2419((Node)null);
   }

   @ObfuscatedName("c")
   public boolean method2421() {
      return this.node.next == this.node;
   }

   public Iterator iterator() {
      return new class123(this);
   }

   @ObfuscatedName("d")
   public void method2422(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("h")
   public static void method2429(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   @ObfuscatedName("q")
   public void method2435(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node.previous;
      var1.next = this.node;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }
}
