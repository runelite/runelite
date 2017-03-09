import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("en")
public class class132 implements Iterator {
   @ObfuscatedName("d")
   Node field1893 = null;
   @ObfuscatedName("x")
   class121 field1894;
   @ObfuscatedName("j")
   Node field1895;
   @ObfuscatedName("c")
   int field1896;

   public Object next() {
      Node var1;
      if(this.field1895 != this.field1894.field1865[this.field1896 - 1]) {
         var1 = this.field1895;
         this.field1895 = var1.next;
         this.field1893 = var1;
         return var1;
      } else {
         do {
            if(this.field1896 >= this.field1894.field1864) {
               return null;
            }

            var1 = this.field1894.field1865[this.field1896++].next;
         } while(var1 == this.field1894.field1865[this.field1896 - 1]);

         this.field1895 = var1.next;
         this.field1893 = var1;
         return var1;
      }
   }

   public void remove() {
      if(this.field1893 == null) {
         throw new IllegalStateException();
      } else {
         this.field1893.unlink();
         this.field1893 = null;
      }
   }

   class132(class121 var1) {
      this.field1894 = var1;
      this.method2503();
   }

   public boolean hasNext() {
      if(this.field1895 != this.field1894.field1865[this.field1896 - 1]) {
         return true;
      } else {
         while(this.field1896 < this.field1894.field1864) {
            if(this.field1894.field1865[this.field1896++].next != this.field1894.field1865[this.field1896 - 1]) {
               this.field1895 = this.field1894.field1865[this.field1896 - 1].next;
               return true;
            }

            this.field1895 = this.field1894.field1865[this.field1896 - 1];
         }

         return false;
      }
   }

   @ObfuscatedName("e")
   void method2503() {
      this.field1895 = this.field1894.field1865[0].next;
      this.field1896 = 1;
      this.field1893 = null;
   }
}
