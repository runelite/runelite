import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ej")
public class class132 implements Iterator {
   @ObfuscatedName("h")
   int field1891;
   @ObfuscatedName("d")
   Node field1892;
   @ObfuscatedName("p")
   Node field1893 = null;
   @ObfuscatedName("q")
   class121 field1894;

   class132(class121 var1) {
      this.field1894 = var1;
      this.method2501();
   }

   @ObfuscatedName("c")
   void method2501() {
      this.field1892 = this.field1894.field1861[0].next;
      this.field1891 = 1;
      this.field1893 = null;
   }

   public void remove() {
      if(this.field1893 == null) {
         throw new IllegalStateException();
      } else {
         this.field1893.unlink();
         this.field1893 = null;
      }
   }

   public boolean hasNext() {
      if(this.field1892 != this.field1894.field1861[this.field1891 - 1]) {
         return true;
      } else {
         while(this.field1891 < this.field1894.field1862) {
            if(this.field1894.field1861[this.field1891++].next != this.field1894.field1861[this.field1891 - 1]) {
               this.field1892 = this.field1894.field1861[this.field1891 - 1].next;
               return true;
            }

            this.field1892 = this.field1894.field1861[this.field1891 - 1];
         }

         return false;
      }
   }

   public Object next() {
      Node var1;
      if(this.field1892 != this.field1894.field1861[this.field1891 - 1]) {
         var1 = this.field1892;
         this.field1892 = var1.next;
         this.field1893 = var1;
         return var1;
      } else {
         do {
            if(this.field1891 >= this.field1894.field1862) {
               return null;
            }

            var1 = this.field1894.field1861[this.field1891++].next;
         } while(var1 == this.field1894.field1861[this.field1891 - 1]);

         this.field1892 = var1.next;
         this.field1893 = var1;
         return var1;
      }
   }
}
