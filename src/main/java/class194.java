import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gt")
public class class194 implements Iterator {
   @ObfuscatedName("e")
   class198 field3083;
   @ObfuscatedName("w")
   class208 field3084;
   @ObfuscatedName("s")
   class208 field3085 = null;
   @ObfuscatedName("f")
   int field3086;

   @ObfuscatedName("e")
   void method3766() {
      this.field3084 = this.field3083.field3096[0].field3114;
      this.field3086 = 1;
      this.field3085 = null;
   }

   public Object next() {
      class208 var1;
      if(this.field3084 != this.field3083.field3096[this.field3086 - 1]) {
         var1 = this.field3084;
         this.field3084 = var1.field3114;
         this.field3085 = var1;
         return var1;
      } else {
         do {
            if(this.field3086 >= this.field3083.field3095) {
               return null;
            }

            var1 = this.field3083.field3096[this.field3086++].field3114;
         } while(var1 == this.field3083.field3096[this.field3086 - 1]);

         this.field3084 = var1.field3114;
         this.field3085 = var1;
         return var1;
      }
   }

   public boolean hasNext() {
      if(this.field3084 != this.field3083.field3096[this.field3086 - 1]) {
         return true;
      } else {
         while(this.field3086 < this.field3083.field3095) {
            if(this.field3083.field3096[this.field3086++].field3114 != this.field3083.field3096[this.field3086 - 1]) {
               this.field3084 = this.field3083.field3096[this.field3086 - 1].field3114;
               return true;
            }

            this.field3084 = this.field3083.field3096[this.field3086 - 1];
         }

         return false;
      }
   }

   public void remove() {
      if(this.field3085 == null) {
         throw new IllegalStateException();
      } else {
         this.field3085.method3913();
         this.field3085 = null;
      }
   }

   class194(class198 var1) {
      this.field3083 = var1;
      this.method3766();
   }
}
