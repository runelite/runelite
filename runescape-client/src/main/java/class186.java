import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gn")
public final class class186 implements Iterable {
   @ObfuscatedName("i")
   int field2455;
   @ObfuscatedName("w")
   Node[] field2452;
   @ObfuscatedName("s")
   int field2451;
   @ObfuscatedName("a")
   Node field2453;
   @ObfuscatedName("t")
   Node field2454;

   public class186(int var1) {
      this.field2451 = 0;
      this.field2455 = var1;
      this.field2452 = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.field2452[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   @ObfuscatedName("i")
   public Node method3478(long var1) {
      Node var3 = this.field2452[(int)(var1 & (long)(this.field2455 - 1))];

      for(this.field2453 = var3.next; var3 != this.field2453; this.field2453 = this.field2453.next) {
         if(this.field2453.hash == var1) {
            Node var4 = this.field2453;
            this.field2453 = this.field2453.next;
            return var4;
         }
      }

      this.field2453 = null;
      return null;
   }

   @ObfuscatedName("s")
   public Node method3477() {
      Node var1;
      if(this.field2451 > 0 && this.field2452[this.field2451 - 1] != this.field2454) {
         var1 = this.field2454;
         this.field2454 = var1.next;
         return var1;
      } else {
         do {
            if(this.field2451 >= this.field2455) {
               return null;
            }

            var1 = this.field2452[this.field2451++].next;
         } while(this.field2452[this.field2451 - 1] == var1);

         this.field2454 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("w")
   public void method3479(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.field2452[(int)(var2 & (long)(this.field2455 - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }

   @ObfuscatedName("t")
   public Node method3481() {
      this.field2451 = 0;
      return this.method3477();
   }

   @ObfuscatedName("a")
   public void method3480() {
      for(int var1 = 0; var1 < this.field2455; ++var1) {
         Node var2 = this.field2452[var1];

         while(true) {
            Node var3 = var2.next;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field2453 = null;
      this.field2454 = null;
   }

   public Iterator iterator() {
      return new class197(this);
   }
}
