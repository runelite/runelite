import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ds")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("c")
   Node field1884;
   @ObfuscatedName("s")
   @Export("node")
   Node node = new Node();

   @ObfuscatedName("u")
   public Node method2291() {
      Node var1 = this.field1884;
      if(var1 == this.node) {
         this.field1884 = null;
         return null;
      } else {
         this.field1884 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("s")
   public void method2292(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node.previous;
      var1.next = this.node;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("f")
   public static void method2294(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   @ObfuscatedName("g")
   public Node method2295() {
      return this.method2296((Node)null);
   }

   @ObfuscatedName("k")
   Node method2296(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.node.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.node) {
         this.field1884 = null;
         return null;
      } else {
         this.field1884 = var2.next;
         return var2;
      }
   }

   @ObfuscatedName("b")
   public boolean method2298() {
      return this.node.next == this.node;
   }

   public Iterator iterator() {
      return new class123(this);
   }

   @ObfuscatedName("c")
   public void method2304(Node var1) {
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
