import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gv")
public class class197 implements Iterator {
   @ObfuscatedName("i")
   int field2492;
   @ObfuscatedName("p")
   Node field2493;
   @ObfuscatedName("j")
   Node field2494;
   @ObfuscatedName("n")
   class186 field2495;

   public void remove() {
      if(this.field2494 == null) {
         throw new IllegalStateException();
      } else {
         this.field2494.unlink();
         this.field2494 = null;
      }
   }

   @ObfuscatedName("e")
   void method3657() {
      this.field2493 = this.field2495.field2463[0].next;
      this.field2492 = 1;
      this.field2494 = null;
   }

   public boolean hasNext() {
      if(this.field2493 != this.field2495.field2463[this.field2492 - 1]) {
         return true;
      } else {
         while(this.field2492 < this.field2495.field2460) {
            if(this.field2495.field2463[this.field2492++].next != this.field2495.field2463[this.field2492 - 1]) {
               this.field2493 = this.field2495.field2463[this.field2492 - 1].next;
               return true;
            }

            this.field2493 = this.field2495.field2463[this.field2492 - 1];
         }

         return false;
      }
   }

   class197(class186 var1) {
      this.field2494 = null;
      this.field2495 = var1;
      this.method3657();
   }

   public Object next() {
      Node var1;
      if(this.field2493 != this.field2495.field2463[this.field2492 - 1]) {
         var1 = this.field2493;
         this.field2493 = var1.next;
         this.field2494 = var1;
         return var1;
      } else {
         do {
            if(this.field2492 >= this.field2495.field2460) {
               return null;
            }

            var1 = this.field2495.field2463[this.field2492++].next;
         } while(var1 == this.field2495.field2463[this.field2492 - 1]);

         this.field2493 = var1.next;
         this.field2494 = var1;
         return var1;
      }
   }
}
