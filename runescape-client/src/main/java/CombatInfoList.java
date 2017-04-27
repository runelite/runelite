import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ey")
@Implements("CombatInfoList")
public class CombatInfoList implements Iterable {
   @ObfuscatedName("c")
   Node field2029;
   @ObfuscatedName("d")
   @Export("node")
   Node node = new Node();

   @ObfuscatedName("d")
   public void method2787(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node.previous;
      var1.next = this.node;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("c")
   public void method2788(Node var1) {
      if(var1.previous != null) {
         var1.unlink();
      }

      var1.previous = this.node;
      var1.next = this.node.next;
      var1.previous.next = var1;
      var1.next.previous = var1;
   }

   @ObfuscatedName("n")
   public static void method2789(Node var0, Node var1) {
      if(var0.previous != null) {
         var0.unlink();
      }

      var0.previous = var1;
      var0.next = var1.next;
      var0.previous.next = var0;
      var0.next.previous = var0;
   }

   @ObfuscatedName("q")
   public Node method2790() {
      return this.method2794((Node)null);
   }

   @ObfuscatedName("p")
   public Node method2791() {
      Node var1 = this.field2029;
      if(var1 == this.node) {
         this.field2029 = null;
         return null;
      } else {
         this.field2029 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("u")
   public boolean method2793() {
      return this.node.next == this.node;
   }

   @ObfuscatedName("t")
   Node method2794(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.node.next;
      } else {
         var2 = var1;
      }

      if(var2 == this.node) {
         this.field2029 = null;
         return null;
      } else {
         this.field2029 = var2.next;
         return var2;
      }
   }

   public CombatInfoList() {
      this.node.next = this.node;
      this.node.previous = this.node;
   }

   public Iterator iterator() {
      return new class144(this);
   }
}
