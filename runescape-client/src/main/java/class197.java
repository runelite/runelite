import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gk")
public class class197 implements Iterator {
   @ObfuscatedName("t")
   Node field2492;
   @ObfuscatedName("m")
   Node field2493;
   @ObfuscatedName("e")
   int field2494;
   @ObfuscatedName("p")
   class186 field2495;

   @ObfuscatedName("o")
   void method3534() {
      this.field2493 = this.field2495.field2461[0].next;
      this.field2494 = 1;
      this.field2492 = null;
   }

   public Object next() {
      Node var1;
      if(this.field2493 != this.field2495.field2461[this.field2494 - 1]) {
         var1 = this.field2493;
         this.field2493 = var1.next;
         this.field2492 = var1;
         return var1;
      } else {
         while(this.field2494 < this.field2495.field2460) {
            var1 = this.field2495.field2461[this.field2494++].next;
            if(var1 != this.field2495.field2461[this.field2494 - 1]) {
               this.field2493 = var1.next;
               this.field2492 = var1;
               return var1;
            }
         }

         return null;
      }
   }

   public boolean hasNext() {
      if(this.field2493 != this.field2495.field2461[this.field2494 - 1]) {
         return true;
      } else {
         while(this.field2494 < this.field2495.field2460) {
            if(this.field2495.field2461[this.field2494++].next != this.field2495.field2461[this.field2494 - 1]) {
               this.field2493 = this.field2495.field2461[this.field2494 - 1].next;
               return true;
            }

            this.field2493 = this.field2495.field2461[this.field2494 - 1];
         }

         return false;
      }
   }

   class197(class186 var1) {
      this.field2492 = null;
      this.field2495 = var1;
      this.method3534();
   }

   public void remove() {
      this.field2492.unlink();
      this.field2492 = null;
   }
}
