import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dc")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("u")
   @Export("node")
   Node node = new Node();
   @ObfuscatedName("x")
   Node field1865;

   @ObfuscatedName("x")
   public void method2356(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("i")
   public static void method2357(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   @ObfuscatedName("a")
   public Node method2358() {
      return this.method2359((Node)null);
   }

   @ObfuscatedName("c")
   Node method2359(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.node.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.node) {
         this.field1865 = null;
         return null;
      } else {
         this.field1865 = var2.next;
         return var2;
      }
   }

   @ObfuscatedName("g")
   public Node method2360() {
      Node var1 = this.field1865;
      if(var1 == this.node) {
         this.field1865 = null;
         return null;
      } else {
         this.field1865 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("z")
   public boolean method2362() {
      return this.node.next == this.node;
   }

   public Iterator iterator() {
      return new class123(this);
   }

   public CombatInfoList() {
      this.node.next = this.node;
      this.node.previous = this.node;
   }

   @ObfuscatedName("u")
   public void method2371(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node.previous;
      var1.next = this.node;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }
}
