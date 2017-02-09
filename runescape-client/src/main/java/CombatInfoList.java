import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("do")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("y")
   Node field1870;
   @ObfuscatedName("k")
   @Export("node")
   Node node = new Node();

   @ObfuscatedName("k")
   public void method2347(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node.previous;
      var1.next = this.node;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("y")
   public void method2348(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("o")
   public static void method2350(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   @ObfuscatedName("r")
   public Node method2351() {
      return this.method2352((Node)null);
   }

   @ObfuscatedName("w")
   Node method2352(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.node.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.node) {
         this.field1870 = null;
         return null;
      } else {
         this.field1870 = var2.next;
         return var2;
      }
   }

   @ObfuscatedName("j")
   public Node method2353() {
      Node var1 = this.field1870;
      if(var1 == this.node) {
         this.field1870 = null;
         return null;
      } else {
         this.field1870 = var1.next;
         return var1;
      }
   }

   public Iterator iterator() {
      return new class123(this);
   }

   public CombatInfoList() {
      this.node.next = this.node;
      this.node.previous = this.node;
   }

   @ObfuscatedName("c")
   public boolean method2368() {
      return this.node.next == this.node;
   }
}
