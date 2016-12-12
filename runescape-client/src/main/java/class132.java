import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eb")
public class class132 implements Iterator {
   @ObfuscatedName("f")
   int field1887;
   @ObfuscatedName("e")
   Node field1888;
   @ObfuscatedName("i")
   class121 field1889;
   @ObfuscatedName("k")
   Node field1890 = null;

   @ObfuscatedName("h")
   void method2408() {
      this.field1888 = this.field1889.field1858[0].next;
      this.field1887 = 1;
      this.field1890 = null;
   }

   class132(class121 var1) {
      this.field1889 = var1;
      this.method2408();
   }

   public boolean hasNext() {
      if(this.field1888 != this.field1889.field1858[this.field1887 - 1]) {
         return true;
      } else {
         while(this.field1887 < this.field1889.field1857) {
            if(this.field1889.field1858[this.field1887++].next != this.field1889.field1858[this.field1887 - 1]) {
               this.field1888 = this.field1889.field1858[this.field1887 - 1].next;
               return true;
            }

            this.field1888 = this.field1889.field1858[this.field1887 - 1];
         }

         return false;
      }
   }

   public void remove() {
      this.field1890.unlink();
      this.field1890 = null;
   }

   public Object next() {
      Node var1;
      if(this.field1888 != this.field1889.field1858[this.field1887 - 1]) {
         var1 = this.field1888;
         this.field1888 = var1.next;
         this.field1890 = var1;
         return var1;
      } else {
         do {
            if(this.field1887 >= this.field1889.field1857) {
               return null;
            }

            var1 = this.field1889.field1858[this.field1887++].next;
         } while(var1 == this.field1889.field1858[this.field1887 - 1]);

         this.field1888 = var1.next;
         this.field1890 = var1;
         return var1;
      }
   }
}
