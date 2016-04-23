import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ga")
public class class194 implements Iterator {
   @ObfuscatedName("h")
   class208 field3091;
   @ObfuscatedName("j")
   class198 field3092;
   @ObfuscatedName("m")
   int field3093;
   @ObfuscatedName("z")
   class208 field3094 = null;

   @ObfuscatedName("j")
   void method3720() {
      this.field3091 = this.field3092.field3104[0].field3123;
      this.field3093 = 1;
      this.field3094 = null;
   }

   class194(class198 var1) {
      this.field3092 = var1;
      this.method3720();
   }

   public void remove() {
      this.field3094.method3883();
      this.field3094 = null;
   }

   public boolean hasNext() {
      if(this.field3091 != this.field3092.field3104[this.field3093 - 1]) {
         return true;
      } else {
         while(this.field3093 < this.field3092.field3105) {
            if(this.field3092.field3104[this.field3093++].field3123 != this.field3092.field3104[this.field3093 - 1]) {
               this.field3091 = this.field3092.field3104[this.field3093 - 1].field3123;
               return true;
            }

            this.field3091 = this.field3092.field3104[this.field3093 - 1];
         }

         return false;
      }
   }

   public Object next() {
      class208 var1;
      if(this.field3091 != this.field3092.field3104[this.field3093 - 1]) {
         var1 = this.field3091;
         this.field3091 = var1.field3123;
         this.field3094 = var1;
         return var1;
      } else {
         do {
            if(this.field3093 >= this.field3092.field3105) {
               return null;
            }

            var1 = this.field3092.field3104[this.field3093++].field3123;
         } while(var1 == this.field3092.field3104[this.field3093 - 1]);

         this.field3091 = var1.field3123;
         this.field3094 = var1;
         return var1;
      }
   }
}
