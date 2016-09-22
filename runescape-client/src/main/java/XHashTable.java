import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("go")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("a")
   @Export("size")
   int size;
   @ObfuscatedName("d")
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("v")
   Node field3145;
   @ObfuscatedName("r")
   Node field3146;
   @ObfuscatedName("z")
   int field3147 = 0;

   @ObfuscatedName("a")
   public Node method3817(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field3145 = var3.next; this.field3145 != var3; this.field3145 = this.field3145.next) {
         if(this.field3145.hash == var1) {
            Node var4 = this.field3145;
            this.field3145 = this.field3145.next;
            return var4;
         }
      }

      this.field3145 = null;
      return null;
   }

   @ObfuscatedName("v")
   void method3819() {
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

      this.field3145 = null;
      this.field3146 = null;
   }

   @ObfuscatedName("r")
   public Node method3820() {
      this.field3147 = 0;
      return this.method3827();
   }

   @ObfuscatedName("d")
   public void method3823(Node var1, long var2) {
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

   @ObfuscatedName("z")
   public Node method3827() {
      Node var1;
      if(this.field3147 > 0 && this.field3146 != this.buckets[this.field3147 - 1]) {
         var1 = this.field3146;
         this.field3146 = var1.next;
         return var1;
      } else {
         do {
            if(this.field3147 >= this.size) {
               return null;
            }

            var1 = this.buckets[this.field3147++].next;
         } while(var1 == this.buckets[this.field3147 - 1]);

         this.field3146 = var1.next;
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
