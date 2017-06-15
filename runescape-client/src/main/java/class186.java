import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gj")
public final class class186 implements Iterable {
   @ObfuscatedName("p")
   int field2460;
   @ObfuscatedName("m")
   Node[] field2461;
   @ObfuscatedName("t")
   Node field2462;
   @ObfuscatedName("e")
   Node field2463;
   @ObfuscatedName("w")
   int field2464;

   @ObfuscatedName("p")
   public Node method3389(long var1) {
      Node var3 = this.field2461[(int)(var1 & (long)(this.field2460 - 1))];

      for(this.field2463 = var3.next; this.field2463 != var3; this.field2463 = this.field2463.next) {
         if(this.field2463.hash == var1) {
            Node var4 = this.field2463;
            this.field2463 = this.field2463.next;
            return var4;
         }
      }

      this.field2463 = null;
      return null;
   }

   @ObfuscatedName("t")
   public Node method3390() {
      this.field2464 = 0;
      return this.method3392();
   }

   @ObfuscatedName("e")
   public void method3391() {
      for(int var1 = 0; var1 < this.field2460; ++var1) {
         Node var2 = this.field2461[var1];

         while(true) {
            Node var3 = var2.next;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field2463 = null;
      this.field2462 = null;
   }

   @ObfuscatedName("w")
   public Node method3392() {
      Node var1;
      if(this.field2464 > 0 && this.field2462 != this.field2461[this.field2464 - 1]) {
         var1 = this.field2462;
         this.field2462 = var1.next;
         return var1;
      } else {
         do {
            if(this.field2464 >= this.field2460) {
               return null;
            }

            var1 = this.field2461[this.field2464++].next;
         } while(var1 == this.field2461[this.field2464 - 1]);

         this.field2462 = var1.next;
         return var1;
      }
   }

   public Iterator iterator() {
      return new class197(this);
   }

   public class186(int var1) {
      this.field2464 = 0;
      this.field2460 = var1;
      this.field2461 = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.field2461[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   @ObfuscatedName("m")
   public void method3394(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.field2461[(int)(var2 & (long)(this.field2460 - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }
}
