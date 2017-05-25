import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gs")
public class class197 implements Iterator {
   @ObfuscatedName("u")
   int field2476;
   @ObfuscatedName("i")
   class186 field2477;
   @ObfuscatedName("h")
   Node field2478;
   @ObfuscatedName("q")
   Node field2479;

   public void remove() {
      this.field2479.unlink();
      this.field2479 = null;
   }

   public Object next() {
      Node var1;
      if(this.field2478 != this.field2477.field2445[this.field2476 - 1]) {
         var1 = this.field2478;
         this.field2478 = var1.next;
         this.field2479 = var1;
         return var1;
      } else {
         do {
            if(this.field2476 >= this.field2477.field2447) {
               return null;
            }

            var1 = this.field2477.field2445[this.field2476++].next;
         } while(var1 == this.field2477.field2445[this.field2476 - 1]);

         this.field2478 = var1.next;
         this.field2479 = var1;
         return var1;
      }
   }

   public boolean hasNext() {
      if(this.field2478 != this.field2477.field2445[this.field2476 - 1]) {
         return true;
      } else {
         while(this.field2476 < this.field2477.field2447) {
            if(this.field2477.field2445[this.field2476++].next != this.field2477.field2445[this.field2476 - 1]) {
               this.field2478 = this.field2477.field2445[this.field2476 - 1].next;
               return true;
            }

            this.field2478 = this.field2477.field2445[this.field2476 - 1];
         }

         return false;
      }
   }

   @ObfuscatedName("a")
   void method3701() {
      this.field2478 = this.field2477.field2445[0].next;
      this.field2476 = 1;
      this.field2479 = null;
   }

   class197(class186 var1) {
      this.field2479 = null;
      this.field2477 = var1;
      this.method3701();
   }
}
