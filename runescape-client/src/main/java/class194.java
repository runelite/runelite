import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gs")
public class class194 implements Iterator {
   @ObfuscatedName("h")
   class208 field3093 = null;
   @ObfuscatedName("i")
   class208 field3094;
   @ObfuscatedName("g")
   int field3095;
   @ObfuscatedName("t")
   class198 field3096;

   public void remove() {
      if(this.field3093 == null) {
         throw new IllegalStateException();
      } else {
         this.field3093.method3870();
         this.field3093 = null;
      }
   }

   public Object next() {
      class208 var1;
      if(this.field3094 != this.field3096.field3106[this.field3095 - 1]) {
         var1 = this.field3094;
         this.field3094 = var1.field3126;
         this.field3093 = var1;
         return var1;
      } else {
         do {
            if(this.field3095 >= this.field3096.field3105) {
               return null;
            }

            var1 = this.field3096.field3106[this.field3095++].field3126;
         } while(var1 == this.field3096.field3106[this.field3095 - 1]);

         this.field3094 = var1.field3126;
         this.field3093 = var1;
         return var1;
      }
   }

   class194(class198 var1) {
      this.field3096 = var1;
      this.method3732();
   }

   @ObfuscatedName("t")
   void method3732() {
      this.field3094 = this.field3096.field3106[0].field3126;
      this.field3095 = 1;
      this.field3093 = null;
   }

   public boolean hasNext() {
      if(this.field3094 != this.field3096.field3106[this.field3095 - 1]) {
         return true;
      } else {
         while(this.field3095 < this.field3096.field3105) {
            if(this.field3096.field3106[this.field3095++].field3126 != this.field3096.field3106[this.field3095 - 1]) {
               this.field3094 = this.field3096.field3106[this.field3095 - 1].field3126;
               return true;
            }

            this.field3094 = this.field3096.field3106[this.field3095 - 1];
         }

         return false;
      }
   }
}
