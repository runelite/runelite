import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gr")
public class class197 implements Iterator {
   @ObfuscatedName("o")
   class211 field3134 = null;
   @ObfuscatedName("w")
   class211 field3135;
   @ObfuscatedName("e")
   int field3136;
   @ObfuscatedName("m")
   class201 field3137;

   @ObfuscatedName("m")
   void method3827() {
      this.field3135 = this.field3137.field3147[0].field3168;
      this.field3136 = 1;
      this.field3134 = null;
   }

   public Object next() {
      class211 var1;
      if(this.field3135 != this.field3137.field3147[this.field3136 - 1]) {
         var1 = this.field3135;
         this.field3135 = var1.field3168;
         this.field3134 = var1;
         return var1;
      } else {
         do {
            if(this.field3136 >= this.field3137.field3146) {
               return null;
            }

            var1 = this.field3137.field3147[this.field3136++].field3168;
         } while(var1 == this.field3137.field3147[this.field3136 - 1]);

         this.field3135 = var1.field3168;
         this.field3134 = var1;
         return var1;
      }
   }

   public boolean hasNext() {
      if(this.field3135 != this.field3137.field3147[this.field3136 - 1]) {
         return true;
      } else {
         while(this.field3136 < this.field3137.field3146) {
            if(this.field3137.field3147[this.field3136++].field3168 != this.field3137.field3147[this.field3136 - 1]) {
               this.field3135 = this.field3137.field3147[this.field3136 - 1].field3168;
               return true;
            }

            this.field3135 = this.field3137.field3147[this.field3136 - 1];
         }

         return false;
      }
   }

   class197(class201 var1) {
      this.field3137 = var1;
      this.method3827();
   }

   public void remove() {
      this.field3134.method3990();
      this.field3134 = null;
   }
}
