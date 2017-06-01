import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gq")
public final class class186 implements Iterable {
   @ObfuscatedName("b")
   int field2458;
   @ObfuscatedName("v")
   Node field2459;
   @ObfuscatedName("e")
   Node field2460;
   @ObfuscatedName("i")
   int field2461;
   @ObfuscatedName("c")
   Node[] field2462;

   @ObfuscatedName("i")
   public Node method3475(long var1) {
      Node var3 = this.field2462[(int)(var1 & (long)(this.field2461 - 1))];

      for(this.field2460 = var3.next; this.field2460 != var3; this.field2460 = this.field2460.next) {
         if(this.field2460.hash == var1) {
            Node var4 = this.field2460;
            this.field2460 = this.field2460.next;
            return var4;
         }
      }

      this.field2460 = null;
      return null;
   }

   @ObfuscatedName("c")
   public void method3476(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.field2462[(int)(var2 & (long)(this.field2461 - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }

   public class186(int var1) {
      this.field2458 = 0;
      this.field2461 = var1;
      this.field2462 = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.field2462[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   @ObfuscatedName("b")
   public Node method3478() {
      Node var1;
      if(this.field2458 > 0 && this.field2459 != this.field2462[this.field2458 - 1]) {
         var1 = this.field2459;
         this.field2459 = var1.next;
         return var1;
      } else {
         do {
            if(this.field2458 >= this.field2461) {
               return null;
            }

            var1 = this.field2462[this.field2458++].next;
         } while(var1 == this.field2462[this.field2458 - 1]);

         this.field2459 = var1.next;
         return var1;
      }
   }

   public Iterator iterator() {
      return new class197(this);
   }

   @ObfuscatedName("v")
   public Node method3482() {
      this.field2458 = 0;
      return this.method3478();
   }

   @ObfuscatedName("e")
   public void method3484() {
      for(int var1 = 0; var1 < this.field2461; ++var1) {
         Node var2 = this.field2462[var1];

         while(true) {
            Node var3 = var2.next;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field2460 = null;
      this.field2459 = null;
   }
}
