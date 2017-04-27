import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ed")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("n")
   Node field2024;
   @ObfuscatedName("d")
   @Export("size")
   int size;
   @ObfuscatedName("q")
   Node field2026;
   @ObfuscatedName("c")
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("t")
   int field2028 = 0;

   @ObfuscatedName("d")
   public Node method2773(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field2024 = var3.next; this.field2024 != var3; this.field2024 = this.field2024.next) {
         if(this.field2024.hash == var1) {
            Node var4 = this.field2024;
            this.field2024 = this.field2024.next;
            return var4;
         }
      }

      this.field2024 = null;
      return null;
   }

   @ObfuscatedName("c")
   public void method2774(Node var1, long var2) {
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

   @ObfuscatedName("n")
   void method2775() {
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

      this.field2024 = null;
      this.field2026 = null;
   }

   @ObfuscatedName("q")
   public Node method2776() {
      this.field2028 = 0;
      return this.method2777();
   }

   @ObfuscatedName("t")
   public Node method2777() {
      Node var1;
      if(this.field2028 > 0 && this.field2026 != this.buckets[this.field2028 - 1]) {
         var1 = this.field2026;
         this.field2026 = var1.next;
         return var1;
      } else {
         do {
            if(this.field2028 >= this.size) {
               return null;
            }

            var1 = this.buckets[this.field2028++].next;
         } while(var1 == this.buckets[this.field2028 - 1]);

         this.field2026 = var1.next;
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
