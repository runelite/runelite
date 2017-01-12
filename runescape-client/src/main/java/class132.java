import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ek")
public class class132 implements Iterator {
   @ObfuscatedName("a")
   Node field1877 = null;
   @ObfuscatedName("x")
   Node field1878;
   @ObfuscatedName("i")
   int field1879;
   @ObfuscatedName("u")
   class121 field1880;

   public void remove() {
      if(this.field1877 == null) {
         throw new IllegalStateException();
      } else {
         this.field1877.unlink();
         this.field1877 = null;
      }
   }

   @ObfuscatedName("z")
   void method2432() {
      this.field1878 = this.field1880.field1848[0].next;
      this.field1879 = 1;
      this.field1877 = null;
   }

   public Object next() {
      Node var1;
      if(this.field1878 != this.field1880.field1848[this.field1879 - 1]) {
         var1 = this.field1878;
         this.field1878 = var1.next;
         this.field1877 = var1;
         return var1;
      } else {
         do {
            if(this.field1879 >= this.field1880.field1847) {
               return null;
            }

            var1 = this.field1880.field1848[this.field1879++].next;
         } while(var1 == this.field1880.field1848[this.field1879 - 1]);

         this.field1878 = var1.next;
         this.field1877 = var1;
         return var1;
      }
   }

   public boolean hasNext() {
      if(this.field1878 != this.field1880.field1848[this.field1879 - 1]) {
         return true;
      } else {
         while(this.field1879 < this.field1880.field1847) {
            if(this.field1880.field1848[this.field1879++].next != this.field1880.field1848[this.field1879 - 1]) {
               this.field1878 = this.field1880.field1848[this.field1879 - 1].next;
               return true;
            }

            this.field1878 = this.field1880.field1848[this.field1879 - 1];
         }

         return false;
      }
   }

   class132(class121 var1) {
      this.field1880 = var1;
      this.method2432();
   }
}
