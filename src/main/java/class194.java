import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gl")
public class class194 implements Iterator {
   @ObfuscatedName("t")
   int field3092;
   @ObfuscatedName("w")
   class198 field3093;
   @ObfuscatedName("x")
   class208 field3094;
   @ObfuscatedName("p")
   class208 field3095 = null;

   public void remove() {
      this.field3095.method3935();
      this.field3095 = null;
   }

   @ObfuscatedName("w")
   void method3786() {
      this.field3094 = this.field3093.field3105[0].field3124;
      this.field3092 = 1;
      this.field3095 = null;
   }

   public Object next() {
      class208 var1;
      if(this.field3094 != this.field3093.field3105[this.field3092 - 1]) {
         var1 = this.field3094;
         this.field3094 = var1.field3124;
         this.field3095 = var1;
         return var1;
      } else {
         do {
            if(this.field3092 >= this.field3093.field3104) {
               return null;
            }

            var1 = this.field3093.field3105[this.field3092++].field3124;
         } while(var1 == this.field3093.field3105[this.field3092 - 1]);

         this.field3094 = var1.field3124;
         this.field3095 = var1;
         return var1;
      }
   }

   public boolean hasNext() {
      if(this.field3094 != this.field3093.field3105[this.field3092 - 1]) {
         return true;
      } else {
         while(this.field3092 < this.field3093.field3104) {
            if(this.field3093.field3105[this.field3092++].field3124 != this.field3093.field3105[this.field3092 - 1]) {
               this.field3094 = this.field3093.field3105[this.field3092 - 1].field3124;
               return true;
            }

            this.field3094 = this.field3093.field3105[this.field3092 - 1];
         }

         return false;
      }
   }

   class194(class198 var1) {
      this.field3093 = var1;
      this.method3786();
   }
}
