import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gy")
public class class194 implements Iterator {
   @ObfuscatedName("u")
   class208 field3084;
   @ObfuscatedName("f")
   class198 field3085;
   @ObfuscatedName("x")
   int field3086;
   @ObfuscatedName("b")
   class208 field3087 = null;

   @ObfuscatedName("f")
   void method3800() {
      this.field3084 = this.field3085.field3096[0].field3116;
      this.field3086 = 1;
      this.field3087 = null;
   }

   public Object next() {
      class208 var1;
      if(this.field3084 != this.field3085.field3096[this.field3086 - 1]) {
         var1 = this.field3084;
         this.field3084 = var1.field3116;
         this.field3087 = var1;
         return var1;
      } else {
         do {
            if(this.field3086 >= this.field3085.field3097) {
               return null;
            }

            var1 = this.field3085.field3096[this.field3086++].field3116;
         } while(var1 == this.field3085.field3096[this.field3086 - 1]);

         this.field3084 = var1.field3116;
         this.field3087 = var1;
         return var1;
      }
   }

   public void remove() {
      if(this.field3087 == null) {
         throw new IllegalStateException();
      } else {
         this.field3087.method3946();
         this.field3087 = null;
      }
   }

   public boolean hasNext() {
      if(this.field3084 != this.field3085.field3096[this.field3086 - 1]) {
         return true;
      } else {
         while(this.field3086 < this.field3085.field3097) {
            if(this.field3085.field3096[this.field3086++].field3116 != this.field3085.field3096[this.field3086 - 1]) {
               this.field3084 = this.field3085.field3096[this.field3086 - 1].field3116;
               return true;
            }

            this.field3084 = this.field3085.field3096[this.field3086 - 1];
         }

         return false;
      }
   }

   class194(class198 var1) {
      this.field3085 = var1;
      this.method3800();
   }
}
