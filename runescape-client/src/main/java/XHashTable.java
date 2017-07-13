import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gd")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("a")
   @Export("size")
   int size;
   @ObfuscatedName("j")
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("v")
   @Export("index")
   int index;
   @ObfuscatedName("n")
   Node field2461;
   @ObfuscatedName("r")
   Node field2460;

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

   @ObfuscatedName("r")
   public Node method3538() {
      this.index = 0;
      return this.method3539();
   }

   @ObfuscatedName("a")
   @Export("get")
   public Node get(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field2461 = var3.next; var3 != this.field2461; this.field2461 = this.field2461.next) {
         if(this.field2461.hash == var1) {
            Node var4 = this.field2461;
            this.field2461 = this.field2461.next;
            return var4;
         }
      }

      this.field2461 = null;
      return null;
   }

   @ObfuscatedName("v")
   public Node method3539() {
      Node var1;
      if(this.index > 0 && this.buckets[this.index - 1] != this.field2460) {
         var1 = this.field2460;
         this.field2460 = var1.next;
         return var1;
      } else {
         do {
            if(this.index >= this.size) {
               return null;
            }

            var1 = this.buckets[this.index++].next;
         } while(this.buckets[this.index - 1] == var1);

         this.field2460 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("n")
   void method3537() {
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

      this.field2461 = null;
      this.field2460 = null;
   }

   @ObfuscatedName("j")
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
