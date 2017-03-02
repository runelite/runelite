import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("di")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("l")
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("t")
   Node field1870;
   @ObfuscatedName("i")
   Node field1871;
   @ObfuscatedName("k")
   int field1872 = 0;
   @ObfuscatedName("b")
   @Export("size")
   int size;

   @ObfuscatedName("i")
   void method2422() {
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
      this.field1870 = null;
   }

   @ObfuscatedName("t")
   public Node method2423() {
      this.field1872 = 0;
      return this.method2424();
   }

   @ObfuscatedName("k")
   public Node method2424() {
      Node var1;
      if(this.field1872 > 0 && this.field1870 != this.buckets[this.field1872 - 1]) {
         var1 = this.field1870;
         this.field1870 = var1.next;
         return var1;
      } else {
         do {
            if(this.field1872 >= this.size) {
               return null;
            }

            var1 = this.buckets[this.field1872++].next;
         } while(var1 == this.buckets[this.field1872 - 1]);

         this.field1870 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("l")
   public void method2425(Node var1, long var2) {
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

   @ObfuscatedName("b")
   public Node method2428(long var1) {
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
