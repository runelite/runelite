import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
@Implements("HashTable")
public final class HashTable {
   @ObfuscatedName("w")
   @Export("size")
   int size;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[Lgl;"
   )
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("currentGet")
   Node currentGet;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("current")
   Node current;
   @ObfuscatedName("f")
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(J)Lgl;"
   )
   @Export("get")
   public Node get(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.currentGet = var3.next; var3 != this.currentGet; this.currentGet = this.currentGet.next) {
         if(this.currentGet.hash == var1) {
            Node var4 = this.currentGet;
            this.currentGet = this.currentGet.next;
            return var4;
         }
      }

      this.currentGet = null;
      return null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgl;J)V"
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

   @ObfuscatedName("q")
   @Export("clear")
   void clear() {
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

      this.currentGet = null;
      this.current = null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "()Lgl;"
   )
   @Export("first")
   public Node first() {
      this.index = 0;
      return this.next();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "()Lgl;"
   )
   @Export("next")
   public Node next() {
      Node var1;
      if(this.index > 0 && this.buckets[this.index - 1] != this.current) {
         var1 = this.current;
         this.current = var1.next;
         return var1;
      } else {
         do {
            if(this.index >= this.size) {
               return null;
            }

            var1 = this.buckets[this.index++].next;
         } while(var1 == this.buckets[this.index - 1]);

         this.current = var1.next;
         return var1;
      }
   }
}
