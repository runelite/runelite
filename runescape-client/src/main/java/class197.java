import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gj")
public class class197 implements Iterator {
   @ObfuscatedName("t")
   Node field2483;
   @ObfuscatedName("w")
   Node field2484;
   @ObfuscatedName("a")
   int field2485;
   @ObfuscatedName("i")
   class186 field2486;

   @ObfuscatedName("e")
   void method3618() {
      this.field2484 = this.field2486.field2452[0].next;
      this.field2485 = 1;
      this.field2483 = null;
   }

   public Object next() {
      Node var1;
      if(this.field2486.field2452[this.field2485 - 1] != this.field2484) {
         var1 = this.field2484;
         this.field2484 = var1.next;
         this.field2483 = var1;
         return var1;
      } else {
         do {
            if(this.field2485 >= this.field2486.field2455) {
               return null;
            }

            var1 = this.field2486.field2452[this.field2485++].next;
         } while(this.field2486.field2452[this.field2485 - 1] == var1);

         this.field2484 = var1.next;
         this.field2483 = var1;
         return var1;
      }
   }

   public boolean hasNext() {
      if(this.field2486.field2452[this.field2485 - 1] != this.field2484) {
         return true;
      } else {
         while(this.field2485 < this.field2486.field2455) {
            if(this.field2486.field2452[this.field2485++].next != this.field2486.field2452[this.field2485 - 1]) {
               this.field2484 = this.field2486.field2452[this.field2485 - 1].next;
               return true;
            }

            this.field2484 = this.field2486.field2452[this.field2485 - 1];
         }

         return false;
      }
   }

   public void remove() {
      this.field2483.unlink();
      this.field2483 = null;
   }

   class197(class186 var1) {
      this.field2483 = null;
      this.field2486 = var1;
      this.method3618();
   }
}
