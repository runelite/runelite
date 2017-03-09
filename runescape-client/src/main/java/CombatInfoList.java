import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dh")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("x")
   @Export("node")
   Node node = new Node();
   @ObfuscatedName("j")
   Node field1881;

   @ObfuscatedName("c")
   public static void method2409(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   @ObfuscatedName("d")
   public Node method2411() {
      return this.method2412((Node)null);
   }

   @ObfuscatedName("w")
   Node method2412(Node var1) {
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

   @ObfuscatedName("y")
   public boolean method2414() {
      return this.node.next == this.node;
   }

   public Iterator iterator() {
      return new class123(this);
   }

   @ObfuscatedName("j")
   public void method2415(Node var1) {
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

   @ObfuscatedName("u")
   public Node method2423() {
      Node var1 = this.field1881;
      if(var1 == this.node) {
         this.field1881 = null;
         return null;
      } else {
         this.field1881 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("x")
   public void method2424(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node.previous;
      var1.next = this.node;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }
}
