import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dd")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("h")
   Node field1879;
   @ObfuscatedName("a")
   int field1880 = 0;
   @ObfuscatedName("f")
   Node field1881;
   @ObfuscatedName("c")
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("s")
   @Export("size")
   int size;

   @ObfuscatedName("s")
   public Node method2274(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field1881 = var3.next; this.field1881 != var3; this.field1881 = this.field1881.next) {
         if(this.field1881.hash == var1) {
            Node var4 = this.field1881;
            this.field1881 = this.field1881.next;
            return var4;
         }
      }

      this.field1881 = null;
      return null;
   }

   public XHashTable(int var1) {
      this.size = var1;
      this.buckets = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.buckets[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   @ObfuscatedName("f")
   void method2275() {
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

      this.field1881 = null;
      this.field1879 = null;
   }

   @ObfuscatedName("k")
   public Node method2277() {
      Node var1;
      if(this.field1880 > 0 && this.field1879 != this.buckets[this.field1880 - 1]) {
         var1 = this.field1879;
         this.field1879 = var1.next;
         return var1;
      } else {
         do {
            if(this.field1880 >= this.size) {
               return null;
            }

            var1 = this.buckets[this.field1880++].next;
         } while(var1 == this.buckets[this.field1880 - 1]);

         this.field1879 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("c")
   public void method2282(Node var1, long var2) {
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

   @ObfuscatedName("g")
   public Node method2283() {
      this.field1880 = 0;
      return this.method2277();
   }
}
