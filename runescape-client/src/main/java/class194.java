import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gq")
public class class194 implements Iterator {
   @ObfuscatedName("j")
   class208 field3093;
   @ObfuscatedName("p")
   int field3094;
   @ObfuscatedName("s")
   class198 field3095;
   @ObfuscatedName("x")
   class208 field3096 = null;

   public void remove() {
      if(this.field3096 == null) {
         throw new IllegalStateException();
      } else {
         this.field3096.method3898();
         this.field3096 = null;
      }
   }

   public Object next() {
      class208 var1;
      if(this.field3093 != this.field3095.field3105[this.field3094 - 1]) {
         var1 = this.field3093;
         this.field3093 = var1.field3124;
         this.field3096 = var1;
         return var1;
      } else {
         do {
            if(this.field3094 >= this.field3095.field3106) {
               return null;
            }

            var1 = this.field3095.field3105[this.field3094++].field3124;
         } while(var1 == this.field3095.field3105[this.field3094 - 1]);

         this.field3093 = var1.field3124;
         this.field3096 = var1;
         return var1;
      }
   }

   public boolean hasNext() {
      if(this.field3093 != this.field3095.field3105[this.field3094 - 1]) {
         return true;
      } else {
         while(this.field3094 < this.field3095.field3106) {
            if(this.field3095.field3105[this.field3094++].field3124 != this.field3095.field3105[this.field3094 - 1]) {
               this.field3093 = this.field3095.field3105[this.field3094 - 1].field3124;
               return true;
            }

            this.field3093 = this.field3095.field3105[this.field3094 - 1];
         }

         return false;
      }
   }

   @ObfuscatedName("s")
   void method3753() {
      this.field3093 = this.field3095.field3105[0].field3124;
      this.field3094 = 1;
      this.field3096 = null;
   }

   class194(class198 var1) {
      this.field3095 = var1;
      this.method3753();
   }
}
