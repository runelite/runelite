import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ei")
public class class153 implements Iterator {
   @ObfuscatedName("d")
   class142 field2042;
   @ObfuscatedName("c")
   Node field2043;
   @ObfuscatedName("q")
   Node field2044;
   @ObfuscatedName("n")
   int field2045;

   @ObfuscatedName("w")
   void method2867() {
      this.field2043 = this.field2042.field2011[0].next;
      this.field2045 = 1;
      this.field2044 = null;
   }

   public Object next() {
      Node var1;
      if(this.field2043 != this.field2042.field2011[this.field2045 - 1]) {
         var1 = this.field2043;
         this.field2043 = var1.next;
         this.field2044 = var1;
         return var1;
      } else {
         do {
            if(this.field2045 >= this.field2042.field2010) {
               return null;
            }

            var1 = this.field2042.field2011[this.field2045++].next;
         } while(var1 == this.field2042.field2011[this.field2045 - 1]);

         this.field2043 = var1.next;
         this.field2044 = var1;
         return var1;
      }
   }

   public void remove() {
      if(this.field2044 == null) {
         throw new IllegalStateException();
      } else {
         this.field2044.unlink();
         this.field2044 = null;
      }
   }

   public boolean hasNext() {
      if(this.field2043 != this.field2042.field2011[this.field2045 - 1]) {
         return true;
      } else {
         while(this.field2045 < this.field2042.field2010) {
            if(this.field2042.field2011[this.field2045++].next != this.field2042.field2011[this.field2045 - 1]) {
               this.field2043 = this.field2042.field2011[this.field2045 - 1].next;
               return true;
            }

            this.field2043 = this.field2042.field2011[this.field2045 - 1];
         }

         return false;
      }
   }

   class153(class142 var1) {
      this.field2044 = null;
      this.field2042 = var1;
      this.method2867();
   }
}
