import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dk")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("p")
   Node field1873;
   @ObfuscatedName("q")
   @Export("size")
   int size;
   @ObfuscatedName("h")
   Node field1875;
   @ObfuscatedName("d")
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("j")
   int field1877 = 0;

   @ObfuscatedName("q")
   public Node method2399(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field1875 = var3.next; this.field1875 != var3; this.field1875 = this.field1875.next) {
         if(this.field1875.hash == var1) {
            Node var4 = this.field1875;
            this.field1875 = this.field1875.next;
            return var4;
         }
      }

      this.field1875 = null;
      return null;
   }

   @ObfuscatedName("d")
   public void method2400(Node var1, long var2) {
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

   @ObfuscatedName("h")
   void method2401() {
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

      this.field1875 = null;
      this.field1873 = null;
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

   @ObfuscatedName("p")
   public Node method2403() {
      this.field1877 = 0;
      return this.method2411();
   }

   @ObfuscatedName("j")
   public Node method2411() {
      Node var1;
      if(this.field1877 > 0 && this.field1873 != this.buckets[this.field1877 - 1]) {
         var1 = this.field1873;
         this.field1873 = var1.next;
         return var1;
      } else {
         do {
            if(this.field1877 >= this.size) {
               return null;
            }

            var1 = this.buckets[this.field1877++].next;
         } while(var1 == this.buckets[this.field1877 - 1]);

         this.field1873 = var1.next;
         return var1;
      }
   }
}
