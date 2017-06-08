import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gz")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("i")
   Node field2474;
   @ObfuscatedName("p")
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("j")
   Node field2476;
   @ObfuscatedName("f")
   int field2477;
   @ObfuscatedName("n")
   @Export("size")
   int size;

   @ObfuscatedName("n")
   public Node method3545(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field2474 = var3.next; this.field2474 != var3; this.field2474 = this.field2474.next) {
         if(this.field2474.hash == var1) {
            Node var4 = this.field2474;
            this.field2474 = this.field2474.next;
            return var4;
         }
      }

      this.field2474 = null;
      return null;
   }

   @ObfuscatedName("p")
   public void method3546(Node var1, long var2) {
      if(var1.previous != null) {
         var1.unlink();
      }

      Node var4 = this.buckets[(int)(var2 & (long)(this.size - 1))];
      var1.previous = var4.previous;
      var1.next = var4;
      var1.previous.next = var1;
      var1.next.previous = var1;
      var1.hash = var2;
   }

   @ObfuscatedName("j")
   public Node method3548() {
      this.field2477 = 0;
      return this.method3556();
   }

   public XHashTable(int var1) {
      this.field2477 = 0;
      this.size = var1;
      this.buckets = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.buckets[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   @ObfuscatedName("f")
   public Node method3556() {
      Node var1;
      if(this.field2477 > 0 && this.field2476 != this.buckets[this.field2477 - 1]) {
         var1 = this.field2476;
         this.field2476 = var1.next;
         return var1;
      } else {
         do {
            if(this.field2477 >= this.size) {
               return null;
            }

            var1 = this.buckets[this.field2477++].next;
         } while(var1 == this.buckets[this.field2477 - 1]);

         this.field2476 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("i")
   void method3563() {
      for(int var1 = 0; var1 < this.size; ++var1) {
         Node var2 = this.buckets[var1];

         while(true) {
            Node var3 = var2.next;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.field2474 = null;
      this.field2476 = null;
   }
}
