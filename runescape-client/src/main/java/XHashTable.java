import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dc")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("m")
   Node field1870;
   @ObfuscatedName("d")
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("n")
   @Export("size")
   int size;
   @ObfuscatedName("h")
   Node field1873;
   @ObfuscatedName("w")
   int field1874 = 0;

   @ObfuscatedName("n")
   public Node method2405(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field1870 = var3.next; this.field1870 != var3; this.field1870 = this.field1870.next) {
         if(this.field1870.hash == var1) {
            Node var4 = this.field1870;
            this.field1870 = this.field1870.next;
            return var4;
         }
      }

      this.field1870 = null;
      return null;
   }

   @ObfuscatedName("d")
   public void method2406(Node var1, long var2) {
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

   @ObfuscatedName("m")
   void method2407() {
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

      this.field1870 = null;
      this.field1873 = null;
   }

   @ObfuscatedName("w")
   public Node method2409() {
      Node var1;
      if(this.field1874 > 0 && this.field1873 != this.buckets[this.field1874 - 1]) {
         var1 = this.field1873;
         this.field1873 = var1.next;
         return var1;
      } else {
         do {
            if(this.field1874 >= this.size) {
               return null;
            }

            var1 = this.buckets[this.field1874++].next;
         } while(var1 == this.buckets[this.field1874 - 1]);

         this.field1873 = var1.next;
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

   @ObfuscatedName("h")
   public Node method2414() {
      this.field1874 = 0;
      return this.method2409();
   }
}
