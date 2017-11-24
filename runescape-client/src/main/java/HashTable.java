import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
@Implements("HashTable")
public final class HashTable {
   @ObfuscatedName("d")
   @Export("size")
   int size;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Lgf;"
   )
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   Node field2558;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   Node field2560;
   @ObfuscatedName("v")
   @Export("index")
   int index;

   public HashTable(int var1) {
      this.index = 0;
      this.size = var1;
      this.buckets = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.buckets[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(J)Lgf;"
   )
   @Export("get")
   public Node get(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field2558 = var3.next; var3 != this.field2558; this.field2558 = this.field2558.next) {
         if(this.field2558.hash == var1) {
            Node var4 = this.field2558;
            this.field2558 = this.field2558.next;
            return var4;
         }
      }

      this.field2558 = null;
      return null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgf;J)V"
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

   @ObfuscatedName("k")
   void method3711() {
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

      this.field2558 = null;
      this.field2560 = null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "()Lgf;"
   )
   public Node method3707() {
      this.index = 0;
      return this.method3703();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Lgf;"
   )
   public Node method3703() {
      Node var1;
      if(this.index > 0 && this.buckets[this.index - 1] != this.field2560) {
         var1 = this.field2560;
         this.field2560 = var1.next;
         return var1;
      } else {
         do {
            if(this.index >= this.size) {
               return null;
            }

            var1 = this.buckets[this.index++].next;
         } while(var1 == this.buckets[this.index - 1]);

         this.field2560 = var1.next;
         return var1;
      }
   }
}
