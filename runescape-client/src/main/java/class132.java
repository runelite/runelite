import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eh")
public class class132 implements Iterator {
   @ObfuscatedName("f")
   int field1897;
   @ObfuscatedName("c")
   Node field1898;
   @ObfuscatedName("s")
   class121 field1899;
   @ObfuscatedName("h")
   Node field1900 = null;

   @ObfuscatedName("u")
   void method2376() {
      this.field1898 = this.field1899.field1868[0].next;
      this.field1897 = 1;
      this.field1900 = null;
   }

   public boolean hasNext() {
      if(this.field1898 != this.field1899.field1868[this.field1897 - 1]) {
         return true;
      } else {
         while(this.field1897 < this.field1899.field1869) {
            if(this.field1899.field1868[this.field1897++].next != this.field1899.field1868[this.field1897 - 1]) {
               this.field1898 = this.field1899.field1868[this.field1897 - 1].next;
               return true;
            }

            this.field1898 = this.field1899.field1868[this.field1897 - 1];
         }

         return false;
      }
   }

   class132(class121 var1) {
      this.field1899 = var1;
      this.method2376();
   }

   public void remove() {
      if(this.field1900 == null) {
         throw new IllegalStateException();
      } else {
         this.field1900.unlink();
         this.field1900 = null;
      }
   }

   public Object next() {
      Node var1;
      if(this.field1898 != this.field1899.field1868[this.field1897 - 1]) {
         var1 = this.field1898;
         this.field1898 = var1.next;
         this.field1900 = var1;
         return var1;
      } else {
         do {
            if(this.field1897 >= this.field1899.field1869) {
               return null;
            }

            var1 = this.field1899.field1868[this.field1897++].next;
         } while(var1 == this.field1899.field1868[this.field1897 - 1]);

         this.field1898 = var1.next;
         this.field1900 = var1;
         return var1;
      }
   }
}
