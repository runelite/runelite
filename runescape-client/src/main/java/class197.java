import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gy")
public class class197 implements Iterator {
   @ObfuscatedName("i")
   class186 field2490;
   @ObfuscatedName("c")
   Node field2491;
   @ObfuscatedName("e")
   int field2492;
   @ObfuscatedName("v")
   Node field2493;

   public void remove() {
      if(this.field2493 == null) {
         throw new IllegalStateException();
      } else {
         this.field2493.unlink();
         this.field2493 = null;
      }
   }

   public Object next() {
      Node var1;
      if(this.field2491 != this.field2490.field2462[this.field2492 - 1]) {
         var1 = this.field2491;
         this.field2491 = var1.next;
         this.field2493 = var1;
         return var1;
      } else {
         do {
            if(this.field2492 >= this.field2490.field2461) {
               return null;
            }

            var1 = this.field2490.field2462[this.field2492++].next;
         } while(var1 == this.field2490.field2462[this.field2492 - 1]);

         this.field2491 = var1.next;
         this.field2493 = var1;
         return var1;
      }
   }

   class197(class186 var1) {
      this.field2493 = null;
      this.field2490 = var1;
      this.method3617();
   }

   @ObfuscatedName("h")
   void method3617() {
      this.field2491 = this.field2490.field2462[0].next;
      this.field2492 = 1;
      this.field2493 = null;
   }

   public boolean hasNext() {
      if(this.field2491 != this.field2490.field2462[this.field2492 - 1]) {
         return true;
      } else {
         while(this.field2492 < this.field2490.field2461) {
            if(this.field2490.field2462[this.field2492++].next != this.field2490.field2462[this.field2492 - 1]) {
               this.field2491 = this.field2490.field2462[this.field2492 - 1].next;
               return true;
            }

            this.field2491 = this.field2490.field2462[this.field2492 - 1];
         }

         return false;
      }
   }
}
