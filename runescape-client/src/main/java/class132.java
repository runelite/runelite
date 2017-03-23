import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("et")
public class class132 implements Iterator {
   @ObfuscatedName("h")
   Node field1914 = null;
   @ObfuscatedName("i")
   Node field1915;
   @ObfuscatedName("u")
   int field1916;
   @ObfuscatedName("f")
   class121 field1917;

   public void remove() {
      if(this.field1914 == null) {
         throw new IllegalStateException();
      } else {
         this.field1914.unlink();
         this.field1914 = null;
      }
   }

   @ObfuscatedName("w")
   void method2514() {
      this.field1915 = this.field1917.field1885[0].next;
      this.field1916 = 1;
      this.field1914 = null;
   }

   public boolean hasNext() {
      if(this.field1915 != this.field1917.field1885[this.field1916 - 1]) {
         return true;
      } else {
         while(this.field1916 < this.field1917.field1886) {
            if(this.field1917.field1885[this.field1916++].next != this.field1917.field1885[this.field1916 - 1]) {
               this.field1915 = this.field1917.field1885[this.field1916 - 1].next;
               return true;
            }

            this.field1915 = this.field1917.field1885[this.field1916 - 1];
         }

         return false;
      }
   }

   class132(class121 var1) {
      this.field1917 = var1;
      this.method2514();
   }

   public Object next() {
      Node var1;
      if(this.field1915 != this.field1917.field1885[this.field1916 - 1]) {
         var1 = this.field1915;
         this.field1915 = var1.next;
         this.field1914 = var1;
         return var1;
      } else {
         do {
            if(this.field1916 >= this.field1917.field1886) {
               return null;
            }

            var1 = this.field1917.field1885[this.field1916++].next;
         } while(var1 == this.field1917.field1885[this.field1916 - 1]);

         this.field1915 = var1.next;
         this.field1914 = var1;
         return var1;
      }
   }
}
