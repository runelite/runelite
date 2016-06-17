import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gu")
public class class194 implements Iterator {
   @ObfuscatedName("g")
   class208 field3082;
   @ObfuscatedName("d")
   class208 field3083 = null;
   @ObfuscatedName("j")
   int field3084;
   @ObfuscatedName("b")
   class198 field3085;

   @ObfuscatedName("b")
   void method3775() {
      this.field3082 = this.field3085.field3094[0].field3114;
      this.field3084 = 1;
      this.field3083 = null;
   }

   public Object next() {
      class208 var1;
      if(this.field3082 != this.field3085.field3094[this.field3084 - 1]) {
         var1 = this.field3082;
         this.field3082 = var1.field3114;
         this.field3083 = var1;
         return var1;
      } else {
         do {
            if(this.field3084 >= this.field3085.field3096) {
               return null;
            }

            var1 = this.field3085.field3094[this.field3084++].field3114;
         } while(var1 == this.field3085.field3094[this.field3084 - 1]);

         this.field3082 = var1.field3114;
         this.field3083 = var1;
         return var1;
      }
   }

   public boolean hasNext() {
      if(this.field3082 != this.field3085.field3094[this.field3084 - 1]) {
         return true;
      } else {
         while(this.field3084 < this.field3085.field3096) {
            if(this.field3085.field3094[this.field3084++].field3114 != this.field3085.field3094[this.field3084 - 1]) {
               this.field3082 = this.field3085.field3094[this.field3084 - 1].field3114;
               return true;
            }

            this.field3082 = this.field3085.field3094[this.field3084 - 1];
         }

         return false;
      }
   }

   class194(class198 var1) {
      this.field3085 = var1;
      this.method3775();
   }

   public void remove() {
      if(this.field3083 == null) {
         throw new IllegalStateException();
      } else {
         this.field3083.method3916();
         this.field3083 = null;
      }
   }
}
