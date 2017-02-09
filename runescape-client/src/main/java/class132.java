import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ed")
public class class132 implements Iterator {
   @ObfuscatedName("r")
   Node field1883 = null;
   @ObfuscatedName("y")
   Node field1884;
   @ObfuscatedName("k")
   class121 field1885;
   @ObfuscatedName("o")
   int field1886;

   @ObfuscatedName("i")
   void method2429() {
      this.field1884 = this.field1885.field1855[0].next;
      this.field1886 = 1;
      this.field1883 = null;
   }

   public Object next() {
      Node var1;
      if(this.field1884 != this.field1885.field1855[this.field1886 - 1]) {
         var1 = this.field1884;
         this.field1884 = var1.next;
         this.field1883 = var1;
         return var1;
      } else {
         do {
            if(this.field1886 >= this.field1885.field1854) {
               return null;
            }

            var1 = this.field1885.field1855[this.field1886++].next;
         } while(var1 == this.field1885.field1855[this.field1886 - 1]);

         this.field1884 = var1.next;
         this.field1883 = var1;
         return var1;
      }
   }

   class132(class121 var1) {
      this.field1885 = var1;
      this.method2429();
   }

   public void remove() {
      this.field1883.unlink();
      this.field1883 = null;
   }

   public boolean hasNext() {
      if(this.field1884 != this.field1885.field1855[this.field1886 - 1]) {
         return true;
      } else {
         while(this.field1886 < this.field1885.field1854) {
            if(this.field1885.field1855[this.field1886++].next != this.field1885.field1855[this.field1886 - 1]) {
               this.field1884 = this.field1885.field1855[this.field1886 - 1].next;
               return true;
            }

            this.field1884 = this.field1885.field1855[this.field1886 - 1];
         }

         return false;
      }
   }
}
