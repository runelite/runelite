import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gz")
public final class class201 implements Iterable {
   @ObfuscatedName("d")
   Node[] field3149;
   @ObfuscatedName("a")
   int field3150;
   @ObfuscatedName("v")
   Node field3151;

   @ObfuscatedName("a")
   public Node method3836(long var1) {
      Node var3 = this.field3149[(int)(var1 & (long)(this.field3150 - 1))];

      for(this.field3151 = var3.next; this.field3151 != var3; this.field3151 = this.field3151.next) {
         if(this.field3151.hash == var1) {
            Node var4 = this.field3151;
            this.field3151 = this.field3151.next;
            return var4;
         }
      }

      this.field3151 = null;
      return null;
   }

   @ObfuscatedName("d")
   public void method3837(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.field3149[(int)(var2 & (long)(this.field3150 - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }

   @ObfuscatedName("v")
   public void method3838() {
      for(int var1 = 0; var1 < this.field3150; ++var1) {
         Node var2 = this.field3149[var1];

         while(true) {
            Node var3 = var2.next;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field3151 = null;
   }

   public class201(int var1) {
      this.field3150 = var1;
      this.field3149 = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.field3149[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   public Iterator iterator() {
      return new class197(this);
   }
}
