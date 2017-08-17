import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("j")
   @Export("size")
   int size;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "[Lga;"
   )
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("x")
   @Export("index")
   int index;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   Node field2463;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   Node field2461;

   public XHashTable(int var1) {
      this.index = 0;
      this.size = var1;
      this.buckets = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.buckets[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "()Lga;"
   )
   public Node method3558() {
      this.index = 0;
      return this.method3559();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(J)Lga;"
   )
   @Export("get")
   public Node get(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field2463 = var3.next; var3 != this.field2463; this.field2463 = this.field2463.next) {
         if(this.field2463.hash == var1) {
            Node var4 = this.field2463;
            this.field2463 = this.field2463.next;
            return var4;
         }
      }

      this.field2463 = null;
      return null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "()Lga;"
   )
   public Node method3559() {
      Node var1;
      if(this.index > 0 && this.buckets[this.index - 1] != this.field2461) {
         var1 = this.field2461;
         this.field2461 = var1.next;
         return var1;
      } else {
         do {
            if(this.index >= this.size) {
               return null;
            }

            var1 = this.buckets[this.index++].next;
         } while(var1 == this.buckets[this.index - 1]);

         this.field2461 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("f")
   void method3557() {
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

      this.field2463 = null;
      this.field2461 = null;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lga;J)V"
   )
   @Export("put")
   public void put(Node var1, long var2) {
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
}
