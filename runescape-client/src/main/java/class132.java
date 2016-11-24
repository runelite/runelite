import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("et")
public class class132 implements Iterator {
   @ObfuscatedName("d")
   Node field1888;
   @ObfuscatedName("n")
   class121 field1889;
   @ObfuscatedName("m")
   int field1890;
   @ObfuscatedName("h")
   Node field1891 = null;

   @ObfuscatedName("z")
   void method2505() {
      this.field1888 = this.field1889.field1858[0].next;
      this.field1890 = 1;
      this.field1891 = null;
   }

   public Object next() {
      Node var1;
      if(this.field1888 != this.field1889.field1858[this.field1890 - 1]) {
         var1 = this.field1888;
         this.field1888 = var1.next;
         this.field1891 = var1;
         return var1;
      } else {
         do {
            if(this.field1890 >= this.field1889.field1859) {
               return null;
            }

            var1 = this.field1889.field1858[this.field1890++].next;
         } while(var1 == this.field1889.field1858[this.field1890 - 1]);

         this.field1888 = var1.next;
         this.field1891 = var1;
         return var1;
      }
   }

   public boolean hasNext() {
      if(this.field1888 != this.field1889.field1858[this.field1890 - 1]) {
         return true;
      } else {
         while(this.field1890 < this.field1889.field1859) {
            if(this.field1889.field1858[this.field1890++].next != this.field1889.field1858[this.field1890 - 1]) {
               this.field1888 = this.field1889.field1858[this.field1890 - 1].next;
               return true;
            }

            this.field1888 = this.field1889.field1858[this.field1890 - 1];
         }

         return false;
      }
   }

   class132(class121 var1) {
      this.field1889 = var1;
      this.method2505();
   }

   public void remove() {
      if(this.field1891 == null) {
         throw new IllegalStateException();
      } else {
         this.field1891.unlink();
         this.field1891 = null;
      }
   }
}
