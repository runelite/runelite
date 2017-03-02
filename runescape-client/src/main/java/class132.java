import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("em")
public class class132 implements Iterator {
   @ObfuscatedName("b")
   class121 field1887;
   @ObfuscatedName("l")
   Node field1888;
   @ObfuscatedName("i")
   int field1889;
   @ObfuscatedName("t")
   Node field1890 = null;

   @ObfuscatedName("p")
   void method2513() {
      this.field1888 = this.field1887.field1858[0].next;
      this.field1889 = 1;
      this.field1890 = null;
   }

   class132(class121 var1) {
      this.field1887 = var1;
      this.method2513();
   }

   public Object next() {
      Node var1;
      if(this.field1888 != this.field1887.field1858[this.field1889 - 1]) {
         var1 = this.field1888;
         this.field1888 = var1.next;
         this.field1890 = var1;
         return var1;
      } else {
         do {
            if(this.field1889 >= this.field1887.field1857) {
               return null;
            }

            var1 = this.field1887.field1858[this.field1889++].next;
         } while(var1 == this.field1887.field1858[this.field1889 - 1]);

         this.field1888 = var1.next;
         this.field1890 = var1;
         return var1;
      }
   }

   public void remove() {
      if(this.field1890 == null) {
         throw new IllegalStateException();
      } else {
         this.field1890.unlink();
         this.field1890 = null;
      }
   }

   public boolean hasNext() {
      if(this.field1888 != this.field1887.field1858[this.field1889 - 1]) {
         return true;
      } else {
         while(this.field1889 < this.field1887.field1857) {
            if(this.field1887.field1858[this.field1889++].next != this.field1887.field1858[this.field1889 - 1]) {
               this.field1888 = this.field1887.field1858[this.field1889 - 1].next;
               return true;
            }

            this.field1888 = this.field1887.field1858[this.field1889 - 1];
         }

         return false;
      }
   }
}
