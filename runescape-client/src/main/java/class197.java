import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gi")
public class class197 implements Iterator {
   @ObfuscatedName("v")
   int field3137;
   @ObfuscatedName("a")
   class201 field3138;
   @ObfuscatedName("r")
   Node field3139 = null;
   @ObfuscatedName("d")
   Node field3140;

   public void remove() {
      if(this.field3139 == null) {
         throw new IllegalStateException();
      } else {
         this.field3139.unlink();
         this.field3139 = null;
      }
   }

   @ObfuscatedName("a")
   void method3795() {
      this.field3140 = this.field3138.field3149[0].next;
      this.field3137 = 1;
      this.field3139 = null;
   }

   public Object next() {
      Node var1;
      if(this.field3140 != this.field3138.field3149[this.field3137 - 1]) {
         var1 = this.field3140;
         this.field3140 = var1.next;
         this.field3139 = var1;
         return var1;
      } else {
         do {
            if(this.field3137 >= this.field3138.field3150) {
               return null;
            }

            var1 = this.field3138.field3149[this.field3137++].next;
         } while(var1 == this.field3138.field3149[this.field3137 - 1]);

         this.field3140 = var1.next;
         this.field3139 = var1;
         return var1;
      }
   }

   public boolean hasNext() {
      if(this.field3140 != this.field3138.field3149[this.field3137 - 1]) {
         return true;
      } else {
         while(this.field3137 < this.field3138.field3150) {
            if(this.field3138.field3149[this.field3137++].next != this.field3138.field3149[this.field3137 - 1]) {
               this.field3140 = this.field3138.field3149[this.field3137 - 1].next;
               return true;
            }

            this.field3140 = this.field3138.field3149[this.field3137 - 1];
         }

         return false;
      }
   }

   class197(class201 var1) {
      this.field3138 = var1;
      this.method3795();
   }
}
