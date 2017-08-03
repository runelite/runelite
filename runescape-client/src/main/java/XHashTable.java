import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("d")
   @Export("size")
   int size;
   @ObfuscatedName("e")
   @Export("index")
   int index;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "[Lgm;"
   )
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   Node field2433;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   Node field2434;

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

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "()Lgm;"
   )
   public Node method3564() {
      this.index = 0;
      return this.method3565();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(J)Lgm;"
   )
   @Export("get")
   public Node get(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field2433 = var3.next; var3 != this.field2433; this.field2433 = this.field2433.next) {
         if(this.field2433.hash == var1) {
            Node var4 = this.field2433;
            this.field2433 = this.field2433.next;
            return var4;
         }
      }

      this.field2433 = null;
      return null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "()Lgm;"
   )
   public Node method3565() {
      Node var1;
      if(this.index > 0 && this.buckets[this.index - 1] != this.field2434) {
         var1 = this.field2434;
         this.field2434 = var1.next;
         return var1;
      } else {
         do {
            if(this.index >= this.size) {
               return null;
            }

            var1 = this.buckets[this.index++].next;
         } while(this.buckets[this.index - 1] == var1);

         this.field2434 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("x")
   void method3563() {
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

      this.field2433 = null;
      this.field2434 = null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgm;J)V"
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
