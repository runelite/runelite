import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eu")
public class class132 implements Iterator {
   @ObfuscatedName("x")
   class121 field1894;
   @ObfuscatedName("g")
   int field1895;
   @ObfuscatedName("n")
   Node field1896;
   @ObfuscatedName("v")
   Node field1897 = null;

   @ObfuscatedName("s")
   void method2526() {
      this.field1896 = this.field1894.field1864[0].next;
      this.field1895 = 1;
      this.field1897 = null;
   }

   public Object next() {
      Node var1;
      if(this.field1896 != this.field1894.field1864[this.field1895 - 1]) {
         var1 = this.field1896;
         this.field1896 = var1.next;
         this.field1897 = var1;
         return var1;
      } else {
         do {
            if(this.field1895 >= this.field1894.field1866) {
               return null;
            }

            var1 = this.field1894.field1864[this.field1895++].next;
         } while(var1 == this.field1894.field1864[this.field1895 - 1]);

         this.field1896 = var1.next;
         this.field1897 = var1;
         return var1;
      }
   }

   public boolean hasNext() {
      if(this.field1896 != this.field1894.field1864[this.field1895 - 1]) {
         return true;
      } else {
         while(this.field1895 < this.field1894.field1866) {
            if(this.field1894.field1864[this.field1895++].next != this.field1894.field1864[this.field1895 - 1]) {
               this.field1896 = this.field1894.field1864[this.field1895 - 1].next;
               return true;
            }

            this.field1896 = this.field1894.field1864[this.field1895 - 1];
         }

         return false;
      }
   }

   public void remove() {
      if(this.field1897 == null) {
         throw new IllegalStateException();
      } else {
         this.field1897.unlink();
         this.field1897 = null;
      }
   }

   class132(class121 var1) {
      this.field1894 = var1;
      this.method2526();
   }
}
