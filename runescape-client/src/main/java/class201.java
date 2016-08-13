import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gx")
public final class class201 implements Iterable {
   @ObfuscatedName("r")
   Node field3153;
   @ObfuscatedName("g")
   Node[] field3154;
   @ObfuscatedName("l")
   int field3155;

   public Iterator iterator() {
      return new class197(this);
   }

   public class201(int var1) {
      this.field3155 = var1;
      this.field3154 = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.field3154[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   @ObfuscatedName("g")
   public void method3948(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.field3154[(int)(var2 & (long)(this.field3155 - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }

   @ObfuscatedName("r")
   public void method3949() {
      for(int var1 = 0; var1 < this.field3155; ++var1) {
         Node var2 = this.field3154[var1];

         while(true) {
            Node var3 = var2.next;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field3153 = null;
   }

   @ObfuscatedName("l")
   public Node method3950(long var1) {
      Node var3 = this.field3154[(int)(var1 & (long)(this.field3155 - 1))];

      for(this.field3153 = var3.next; this.field3153 != var3; this.field3153 = this.field3153.next) {
         if(this.field3153.hash == var1) {
            Node var4 = this.field3153;
            this.field3153 = this.field3153.next;
            return var4;
         }
      }

      this.field3153 = null;
      return null;
   }
}
