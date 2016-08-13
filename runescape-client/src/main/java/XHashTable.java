import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gt")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("r")
   Node field3147;
   @ObfuscatedName("g")
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("e")
   Node field3149;
   @ObfuscatedName("l")
   @Export("size")
   int size;
   @ObfuscatedName("h")
   int field3151 = 0;

   @ObfuscatedName("h")
   public Node method3935() {
      Node var1;
      if(this.field3151 > 0 && this.field3149 != this.buckets[this.field3151 - 1]) {
         var1 = this.field3149;
         this.field3149 = var1.next;
         return var1;
      } else {
         while(this.field3151 < this.size) {
            var1 = this.buckets[this.field3151++].next;
            if(var1 != this.buckets[this.field3151 - 1]) {
               this.field3149 = var1.next;
               return var1;
            }
         }

         return null;
      }
   }

   @ObfuscatedName("l")
   public Node method3936(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field3147 = var3.next; this.field3147 != var3; this.field3147 = this.field3147.next) {
         if(this.field3147.hash == var1) {
            Node var4 = this.field3147;
            this.field3147 = this.field3147.next;
            return var4;
         }
      }

      this.field3147 = null;
      return null;
   }

   @ObfuscatedName("r")
   void method3938() {
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

      this.field3147 = null;
      this.field3149 = null;
   }

   @ObfuscatedName("e")
   public Node method3939() {
      this.field3151 = 0;
      return this.method3935();
   }

   @ObfuscatedName("g")
   public void method3940(Node var1, long var2) {
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
