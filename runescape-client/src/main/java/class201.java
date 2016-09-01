import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gc")
public final class class201 implements Iterable {
   @ObfuscatedName("r")
   Node[] field3152;
   @ObfuscatedName("j")
   Node field3153;
   @ObfuscatedName("x")
   int field3154;

   public class201(int var1) {
      this.field3154 = var1;
      this.field3152 = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.field3152[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   @ObfuscatedName("r")
   public void method3834(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.field3152[(int)(var2 & (long)(this.field3154 - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }

   public Iterator iterator() {
      return new class197(this);
   }

   @ObfuscatedName("j")
   public void method3835() {
      for(int var1 = 0; var1 < this.field3154; ++var1) {
         Node var2 = this.field3152[var1];

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

   @ObfuscatedName("x")
   public Node method3839(long var1) {
      Node var3 = this.field3152[(int)(var1 & (long)(this.field3154 - 1))];

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
