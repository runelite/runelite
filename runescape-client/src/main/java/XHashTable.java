import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("di")
@Implements("XHashTable")
public final class XHashTable {
   @ObfuscatedName("r")
   int field1896 = 0;
   @ObfuscatedName("i")
   @Export("buckets")
   Node[] buckets;
   @ObfuscatedName("f")
   @Export("size")
   int size;
   @ObfuscatedName("h")
   Node field1899;
   @ObfuscatedName("u")
   Node field1900;

   @ObfuscatedName("f")
   public Node method2417(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.field1900 = var3.next; this.field1900 != var3; this.field1900 = this.field1900.next) {
         if(this.field1900.hash == var1) {
            Node var4 = this.field1900;
            this.field1900 = this.field1900.next;
            return var4;
         }
      }

      this.field1900 = null;
      return null;
   }

   @ObfuscatedName("i")
   public void method2418(Node var1, long var2) {
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

   @ObfuscatedName("u")
   void method2419() {
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

      this.field1900 = null;
      this.field1899 = null;
   }

   @ObfuscatedName("r")
   public Node method2420() {
      this.field1896 = 0;
      return this.method2422();
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

   @ObfuscatedName("o")
   public Node method2422() {
      Node var1;
      if(this.field1896 > 0 && this.field1899 != this.buckets[this.field1896 - 1]) {
         var1 = this.field1899;
         this.field1899 = var1.next;
         return var1;
      } else {
         do {
            if(this.field1896 >= this.size) {
               return null;
            }

            var1 = this.buckets[this.field1896++].next;
         } while(var1 == this.buckets[this.field1896 - 1]);

         this.field1899 = var1.next;
         return var1;
      }
   }
}
