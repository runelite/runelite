import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gm")
public final class class186 implements Iterable {
   @ObfuscatedName("g")
   int field2444;
   @ObfuscatedName("h")
   Node[] field2445;
   @ObfuscatedName("u")
   Node field2446;
   @ObfuscatedName("i")
   int field2447;
   @ObfuscatedName("q")
   Node field2448;

   @ObfuscatedName("g")
   public Node method3558() {
      Node var1;
      if(this.field2444 > 0 && this.field2448 != this.field2445[this.field2444 - 1]) {
         var1 = this.field2448;
         this.field2448 = var1.next;
         return var1;
      } else {
         do {
            if(this.field2444 >= this.field2447) {
               return null;
            }

            var1 = this.field2445[this.field2444++].next;
         } while(var1 == this.field2445[this.field2444 - 1]);

         this.field2448 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("i")
   public Node method3559(long var1) {
      Node var3 = this.field2445[(int)(var1 & (long)(this.field2447 - 1))];

      for(this.field2446 = var3.next; this.field2446 != var3; this.field2446 = this.field2446.next) {
         if(this.field2446.hash == var1) {
            Node var4 = this.field2446;
            this.field2446 = this.field2446.next;
            return var4;
         }
      }

      this.field2446 = null;
      return null;
   }

   @ObfuscatedName("u")
   public void method3561() {
      for(int var1 = 0; var1 < this.field2447; ++var1) {
         Node var2 = this.field2445[var1];

         while(true) {
            Node var3 = var2.next;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field2446 = null;
      this.field2448 = null;
   }

   @ObfuscatedName("q")
   public Node method3562() {
      this.field2444 = 0;
      return this.method3558();
   }

   public class186(int var1) {
      this.field2444 = 0;
      this.field2447 = var1;
      this.field2445 = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.field2445[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   public Iterator iterator() {
      return new class197(this);
   }

   @ObfuscatedName("h")
   public void method3575(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.field2445[(int)(var2 & (long)(this.field2447 - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }
}
