import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gy")
public final class class201 implements Iterable {
   @ObfuscatedName("h")
   Node[] field3153;
   @ObfuscatedName("i")
   int field3154;
   @ObfuscatedName("e")
   Node field3155;

   @ObfuscatedName("i")
   public Node method3827(long var1) {
      Node var3 = this.field3153[(int)(var1 & (long)(this.field3154 - 1))];

      for(this.field3155 = var3.next; this.field3155 != var3; this.field3155 = this.field3155.next) {
         if(this.field3155.hash == var1) {
            Node var4 = this.field3155;
            this.field3155 = this.field3155.next;
            return var4;
         }
      }

      this.field3155 = null;
      return null;
   }

   public class201(int var1) {
      this.field3154 = var1;
      this.field3153 = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.field3153[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   public Iterator iterator() {
      return new class197(this);
   }

   @ObfuscatedName("h")
   public void method3830(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.field3153[(int)(var2 & (long)(this.field3154 - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }

   @ObfuscatedName("e")
   public void method3836() {
      for(int var1 = 0; var1 < this.field3154; ++var1) {
         Node var2 = this.field3153[var1];

         while(true) {
            Node var3 = var2.next;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field3155 = null;
   }
}
