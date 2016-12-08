import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ej")
public class class132 implements Iterator {
   @ObfuscatedName("b")
   int field1904;
   @ObfuscatedName("m")
   Node field1905;
   @ObfuscatedName("o")
   class121 field1906;
   @ObfuscatedName("g")
   Node field1907 = null;

   public boolean hasNext() {
      if(this.field1905 != this.field1906.field1875[this.field1904 - 1]) {
         return true;
      } else {
         while(this.field1904 < this.field1906.field1876) {
            if(this.field1906.field1875[this.field1904++].next != this.field1906.field1875[this.field1904 - 1]) {
               this.field1905 = this.field1906.field1875[this.field1904 - 1].next;
               return true;
            }

            this.field1905 = this.field1906.field1875[this.field1904 - 1];
         }

         return false;
      }
   }

   class132(class121 var1) {
      this.field1906 = var1;
      this.method2398();
   }

   public void remove() {
      if(this.field1907 == null) {
         throw new IllegalStateException();
      } else {
         this.field1907.unlink();
         this.field1907 = null;
      }
   }

   public Object next() {
      Node var1;
      if(this.field1905 != this.field1906.field1875[this.field1904 - 1]) {
         var1 = this.field1905;
         this.field1905 = var1.next;
         this.field1907 = var1;
         return var1;
      } else {
         do {
            if(this.field1904 >= this.field1906.field1876) {
               return null;
            }

            var1 = this.field1906.field1875[this.field1904++].next;
         } while(var1 == this.field1906.field1875[this.field1904 - 1]);

         this.field1905 = var1.next;
         this.field1907 = var1;
         return var1;
      }
   }

   @ObfuscatedName("l")
   void method2398() {
      this.field1905 = this.field1906.field1875[0].next;
      this.field1904 = 1;
      this.field1907 = null;
   }
}
