import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ei")
public class class132 implements Iterator {
   @ObfuscatedName("x")
   int field1893;
   @ObfuscatedName("q")
   Node field1894 = null;
   @ObfuscatedName("g")
   Node field1895;
   @ObfuscatedName("p")
   class121 field1896;

   @ObfuscatedName("c")
   void method2455() {
      this.field1895 = this.field1896.field1864[0].next;
      this.field1893 = 1;
      this.field1894 = null;
   }

   public Object next() {
      Node var1;
      if(this.field1895 != this.field1896.field1864[this.field1893 - 1]) {
         var1 = this.field1895;
         this.field1895 = var1.next;
         this.field1894 = var1;
         return var1;
      } else {
         do {
            if(this.field1893 >= this.field1896.field1865) {
               return null;
            }

            var1 = this.field1896.field1864[this.field1893++].next;
         } while(var1 == this.field1896.field1864[this.field1893 - 1]);

         this.field1895 = var1.next;
         this.field1894 = var1;
         return var1;
      }
   }

   public void remove() {
      if(this.field1894 == null) {
         throw new IllegalStateException();
      } else {
         this.field1894.unlink();
         this.field1894 = null;
      }
   }

   public boolean hasNext() {
      if(this.field1895 != this.field1896.field1864[this.field1893 - 1]) {
         return true;
      } else {
         while(this.field1893 < this.field1896.field1865) {
            if(this.field1896.field1864[this.field1893++].next != this.field1896.field1864[this.field1893 - 1]) {
               this.field1895 = this.field1896.field1864[this.field1893 - 1].next;
               return true;
            }

            this.field1895 = this.field1896.field1864[this.field1893 - 1];
         }

         return false;
      }
   }

   class132(class121 var1) {
      this.field1896 = var1;
      this.method2455();
   }
}
