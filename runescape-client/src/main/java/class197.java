import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
public class class197 implements Iterator {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   Node field2447;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   IterableHashTable field2449;
   @ObfuscatedName("i")
   int field2450;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   Node field2448;

   @ObfuscatedSignature(
      signature = "(Lgk;)V"
   )
   class197(IterableHashTable var1) {
      this.field2447 = null;
      this.field2449 = var1;
      this.method3592();
   }

   @ObfuscatedName("k")
   void method3592() {
      this.field2448 = this.field2449.buckets[0].next;
      this.field2450 = 1;
      this.field2447 = null;
   }

   public Object next() {
      Node var1;
      if(this.field2449.buckets[this.field2450 - 1] != this.field2448) {
         var1 = this.field2448;
         this.field2448 = var1.next;
         this.field2447 = var1;
         return var1;
      } else {
         do {
            if(this.field2450 >= this.field2449.size) {
               return null;
            }

            var1 = this.field2449.buckets[this.field2450++].next;
         } while(var1 == this.field2449.buckets[this.field2450 - 1]);

         this.field2448 = var1.next;
         this.field2447 = var1;
         return var1;
      }
   }

   public boolean hasNext() {
      if(this.field2449.buckets[this.field2450 - 1] != this.field2448) {
         return true;
      } else {
         while(this.field2450 < this.field2449.size) {
            if(this.field2449.buckets[this.field2450++].next != this.field2449.buckets[this.field2450 - 1]) {
               this.field2448 = this.field2449.buckets[this.field2450 - 1].next;
               return true;
            }

            this.field2448 = this.field2449.buckets[this.field2450 - 1];
         }

         return false;
      }
   }

   public void remove() {
      if(this.field2447 == null) {
         throw new IllegalStateException();
      } else {
         this.field2447.unlink();
         this.field2447 = null;
      }
   }
}
