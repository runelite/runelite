import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dw")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("o")
   Node field1865;
   @ObfuscatedName("y")
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("w")
   int field1867 = 0;
   @ObfuscatedName("r")
   Node field1868;
   @ObfuscatedName("k")
   @Export("size")
   int size;

   @ObfuscatedName("k")
   public Node method2331(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field1865 = var3.next; this.field1865 != var3; this.field1865 = this.field1865.next) {
         if(this.field1865.hash == var1) {
            Node var4 = this.field1865;
            this.field1865 = this.field1865.next;
            return var4;
         }
      }

      this.field1865 = null;
      return null;
   }

   @ObfuscatedName("y")
   public void method2333(Node var1, long var2) {
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

   @ObfuscatedName("r")
   public Node method2334() {
      this.field1867 = 0;
      return this.method2335();
   }

   @ObfuscatedName("w")
   public Node method2335() {
      Node var1;
      if(this.field1867 > 0 && this.field1868 != this.buckets[this.field1867 - 1]) {
         var1 = this.field1868;
         this.field1868 = var1.next;
         return var1;
      } else {
         do {
            if(this.field1867 >= this.size) {
               return null;
            }

            var1 = this.buckets[this.field1867++].next;
         } while(var1 == this.buckets[this.field1867 - 1]);

         this.field1868 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("o")
   void method2340() {
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

      this.field1865 = null;
      this.field1868 = null;
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
