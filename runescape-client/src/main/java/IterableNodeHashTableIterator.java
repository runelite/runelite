import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lk")
@Implements("IterableNodeHashTableIterator")
public class IterableNodeHashTableIterator implements Iterator {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   @Export("hashTable")
   IterableNodeHashTable hashTable;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   Node field442;
   @ObfuscatedName("q")
   int field443;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   Node field444;

   @ObfuscatedSignature(
      signature = "(Llh;)V"
   )
   IterableNodeHashTableIterator(IterableNodeHashTable var1) {
      this.field444 = null;
      this.hashTable = var1;
      this.method157();
   }

   @ObfuscatedName("u")
   void method157() {
      this.field442 = this.hashTable.buckets[0].previous;
      this.field443 = 1;
      this.field444 = null;
   }

   @Export("next")
   @ObfuscatedName("next")
   public Object next() {
      Node var1;
      if (this.hashTable.buckets[this.field443 - 1] != this.field442) {
         var1 = this.field442;
         this.field442 = var1.previous;
         this.field444 = var1;
         return var1;
      } else {
         while (this.field443 < this.hashTable.size) {
            var1 = this.hashTable.buckets[this.field443++].previous;
            if (var1 != this.hashTable.buckets[this.field443 - 1]) {
               this.field442 = var1.previous;
               this.field444 = var1;
               return var1;
            }
         }

         return null;
      }
   }

   @Export("hasNext")
   @ObfuscatedName("hasNext")
   public boolean hasNext() {
      if (this.hashTable.buckets[this.field443 - 1] != this.field442) {
         return true;
      } else {
         while (this.field443 < this.hashTable.size) {
            if (this.hashTable.buckets[this.field443++].previous != this.hashTable.buckets[this.field443 - 1]) {
               this.field442 = this.hashTable.buckets[this.field443 - 1].previous;
               return true;
            }

            this.field442 = this.hashTable.buckets[this.field443 - 1];
         }

         return false;
      }
   }

   @ObfuscatedName("remove")
   public void method158() {
      if (this.field444 == null) {
         throw new IllegalStateException();
      } else {
         this.field444.remove();
         this.field444 = null;
      }
   }
}
