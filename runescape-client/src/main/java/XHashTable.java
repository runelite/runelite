import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gr")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("i")
   int field3146 = 0;
   @ObfuscatedName("r")
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("j")
   Node field3148;
   @ObfuscatedName("z")
   Node field3149;
   @ObfuscatedName("x")
   @Export("size")
   int size;

   public XHashTable(int var1) {
      this.size = var1;
      this.buckets = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.buckets[var2] = new Node();
         var3.next = var3;
         var3.previous = var3;
      }

   }

   @ObfuscatedName("r")
   public void method3819(Node var1, long var2) {
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

   @ObfuscatedName("j")
   void method3820() {
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

      this.field3148 = null;
      this.field3149 = null;
   }

   @ObfuscatedName("z")
   public Node method3821() {
      this.field3146 = 0;
      return this.method3822();
   }

   @ObfuscatedName("i")
   public Node method3822() {
      Node var1;
      if(this.field3146 > 0 && this.field3149 != this.buckets[this.field3146 - 1]) {
         var1 = this.field3149;
         this.field3149 = var1.next;
         return var1;
      } else {
         do {
            if(this.field3146 >= this.size) {
               return null;
            }

            var1 = this.buckets[this.field3146++].next;
         } while(var1 == this.buckets[this.field3146 - 1]);

         this.field3149 = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("x")
   public Node method3830(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field3148 = var3.next; this.field3148 != var3; this.field3148 = this.field3148.next) {
         if(this.field3148.hash == var1) {
            Node var4 = this.field3148;
            this.field3148 = this.field3148.next;
            return var4;
         }
      }

      this.field3148 = null;
      return null;
   }
}
