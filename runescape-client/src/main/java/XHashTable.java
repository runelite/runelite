import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dz")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("g")
   int field1869 = 0;
   @ObfuscatedName("e")
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("f")
   Node field1871;
   @ObfuscatedName("i")
   @Export("size")
   int size;
   @ObfuscatedName("k")
   Node field1873;

   @ObfuscatedName("f")
   void method2310() {
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

      this.field1871 = null;
      this.field1873 = null;
   }

   @ObfuscatedName("i")
   public Node method2311(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field1871 = var3.next; this.field1871 != var3; this.field1871 = this.field1871.next) {
         if(this.field1871.hash == var1) {
            Node var4 = this.field1871;
            this.field1871 = this.field1871.next;
            return var4;
         }
      }

      this.field1871 = null;
      return null;
   }

   @ObfuscatedName("e")
   public void method2312(Node var1, long var2) {
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

   @ObfuscatedName("k")
   public Node method2313() {
      this.field1869 = 0;
      return this.method2321();
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

   @ObfuscatedName("a")
   public Node method2321() {
      Node var1;
      if(this.field1869 > 0 && this.field1873 != this.buckets[this.field1869 - 1]) {
         var1 = this.field1873;
         this.field1873 = var1.next;
         return var1;
      } else {
         do {
            if(this.field1869 >= this.size) {
               return null;
            }

            var1 = this.buckets[this.field1869++].next;
         } while(var1 == this.buckets[this.field1869 - 1]);

         this.field1873 = var1.next;
         return var1;
      }
   }
}
