import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("e")
   @Export("size")
   int size;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Lgx;"
   )
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("w")
   @Export("index")
   int index;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   Node field2445;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   Node field2446;

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
      signature = "()Lgx;"
   )
   public Node method3549() {
      this.index = 0;
      return this.method3556();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(J)Lgx;"
   )
   @Export("get")
   public Node get(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field2445 = var3.next; var3 != this.field2445; this.field2445 = this.field2445.next) {
         if(this.field2445.hash == var1) {
            Node var4 = this.field2445;
            this.field2445 = this.field2445.next;
            return var4;
         }
      }

      this.field2445 = null;
      return null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "()Lgx;"
   )
   public Node method3556() {
      Node var1;
      if(this.index > 0 && this.buckets[this.index - 1] != this.field2446) {
         var1 = this.field2446;
         this.field2446 = var1.next;
         return var1;
      } else {
         do {
            if(this.index >= this.size) {
               return null;
            }

            var1 = this.buckets[this.index++].next;
         } while(var1 == this.buckets[this.index - 1]);

         this.field2446 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("g")
   void method3550() {
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

      this.field2445 = null;
      this.field2446 = null;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgx;J)V"
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
