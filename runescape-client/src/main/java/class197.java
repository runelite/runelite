import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class197 implements Iterator {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   Node field2478;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   class186 field2475;
   @ObfuscatedName("n")
   int field2477;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   Node field2476;

   @ObfuscatedSignature(
      signature = "(Lgl;)V"
   )
   class197(class186 var1) {
      this.field2478 = null;
      this.field2475 = var1;
      this.method3644();
   }

   @ObfuscatedName("u")
   void method3644() {
      this.field2476 = this.field2475.field2444[0].next;
      this.field2477 = 1;
      this.field2478 = null;
   }

   public boolean hasNext() {
      if(this.field2475.field2444[this.field2477 - 1] != this.field2476) {
         return true;
      } else {
         while(this.field2477 < this.field2475.field2446) {
            if(this.field2475.field2444[this.field2477++].next != this.field2475.field2444[this.field2477 - 1]) {
               this.field2476 = this.field2475.field2444[this.field2477 - 1].next;
               return true;
            }

            this.field2476 = this.field2475.field2444[this.field2477 - 1];
         }

         return false;
      }
   }

   public void remove() {
      if(this.field2478 == null) {
         throw new IllegalStateException();
      } else {
         this.field2478.unlink();
         this.field2478 = null;
      }
   }

   public Object next() {
      Node var1;
      if(this.field2475.field2444[this.field2477 - 1] != this.field2476) {
         var1 = this.field2476;
         this.field2476 = var1.next;
         this.field2478 = var1;
         return var1;
      } else {
         do {
            if(this.field2477 >= this.field2475.field2446) {
               return null;
            }

            var1 = this.field2475.field2444[this.field2477++].next;
         } while(var1 == this.field2475.field2444[this.field2477 - 1]);

         this.field2476 = var1.next;
         this.field2478 = var1;
         return var1;
      }
   }
}
