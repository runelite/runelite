import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gn")
public class class197 implements Iterator {
   @ObfuscatedName("r")
   int field3141;
   @ObfuscatedName("g")
   class211 field3142;
   @ObfuscatedName("e")
   class211 field3143 = null;
   @ObfuscatedName("l")
   class201 field3144;

   public void remove() {
      if(this.field3143 == null) {
         throw new IllegalStateException();
      } else {
         this.field3143.method4067();
         this.field3143 = null;
      }
   }

   @ObfuscatedName("l")
   void method3916() {
      this.field3142 = this.field3144.field3154[0].field3173;
      this.field3141 = 1;
      this.field3143 = null;
   }

   public Object next() {
      class211 var1;
      if(this.field3142 != this.field3144.field3154[this.field3141 - 1]) {
         var1 = this.field3142;
         this.field3142 = var1.field3173;
         this.field3143 = var1;
         return var1;
      } else {
         do {
            if(this.field3141 >= this.field3144.field3155) {
               return null;
            }

            var1 = this.field3144.field3154[this.field3141++].field3173;
         } while(var1 == this.field3144.field3154[this.field3141 - 1]);

         this.field3142 = var1.field3173;
         this.field3143 = var1;
         return var1;
      }
   }

   public boolean hasNext() {
      if(this.field3142 != this.field3144.field3154[this.field3141 - 1]) {
         return true;
      } else {
         while(this.field3141 < this.field3144.field3155) {
            if(this.field3144.field3154[this.field3141++].field3173 != this.field3144.field3154[this.field3141 - 1]) {
               this.field3142 = this.field3144.field3154[this.field3141 - 1].field3173;
               return true;
            }

            this.field3142 = this.field3144.field3154[this.field3141 - 1];
         }

         return false;
      }
   }

   class197(class201 var1) {
      this.field3144 = var1;
      this.method3916();
   }
}
