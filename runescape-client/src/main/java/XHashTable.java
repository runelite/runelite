import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("db")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("b")
   Node field1886;
   @ObfuscatedName("h")
   int field1887 = 0;
   @ObfuscatedName("m")
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("g")
   Node field1889;
   @ObfuscatedName("o")
   @Export("size")
   int size;

   @ObfuscatedName("m")
   public void method2291(Node var1, long var2) {
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
   void method2292() {
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

      this.field1886 = null;
      this.field1889 = null;
   }

   @ObfuscatedName("g")
   public Node method2296() {
      this.field1887 = 0;
      return this.method2300();
   }

   @ObfuscatedName("o")
   public Node method2299(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field1886 = var3.next; this.field1886 != var3; this.field1886 = this.field1886.next) {
         if(this.field1886.hash == var1) {
            Node var4 = this.field1886;
            this.field1886 = this.field1886.next;
            return var4;
         }
      }

      this.field1886 = null;
      return null;
   }

   @ObfuscatedName("l")
   public Node method2300() {
      Node var1;
      if(this.field1887 > 0 && this.field1889 != this.buckets[this.field1887 - 1]) {
         var1 = this.field1889;
         this.field1889 = var1.next;
         return var1;
      } else {
         do {
            if(this.field1887 >= this.size) {
               return null;
            }

            var1 = this.buckets[this.field1887++].next;
         } while(var1 == this.buckets[this.field1887 - 1]);

         this.field1889 = var1.next;
         return var1;
      }
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
