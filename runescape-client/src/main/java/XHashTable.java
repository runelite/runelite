import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dy")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("a")
   Node field1859;
   @ObfuscatedName("x")
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("i")
   Node field1861;
   @ObfuscatedName("u")
   @Export("size")
   int size;
   @ObfuscatedName("f")
   int field1863 = 0;

   @ObfuscatedName("u")
   public Node method2339(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field1861 = var3.next; this.field1861 != var3; this.field1861 = this.field1861.next) {
         if(this.field1861.hash == var1) {
            Node var4 = this.field1861;
            this.field1861 = this.field1861.next;
            return var4;
         }
      }

      this.field1861 = null;
      return null;
   }

   @ObfuscatedName("x")
   public void method2340(Node var1, long var2) {
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

   @ObfuscatedName("i")
   void method2341() {
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

      this.field1861 = null;
      this.field1859 = null;
   }

   @ObfuscatedName("c")
   public Node method2343() {
      Node var1;
      if(this.field1863 > 0 && this.field1859 != this.buckets[this.field1863 - 1]) {
         var1 = this.field1859;
         this.field1859 = var1.next;
         return var1;
      } else {
         do {
            if(this.field1863 >= this.size) {
               return null;
            }

            var1 = this.buckets[this.field1863++].next;
         } while(var1 == this.buckets[this.field1863 - 1]);

         this.field1859 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("a")
   public Node method2344() {
      this.field1863 = 0;
      return this.method2343();
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
}
