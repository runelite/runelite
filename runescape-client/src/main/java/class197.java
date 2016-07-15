import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gy")
public class class197 implements Iterator {
   @ObfuscatedName("e")
   class201 field3129;
   @ObfuscatedName("l")
   class211 field3130;
   @ObfuscatedName("c")
   int field3131;
   @ObfuscatedName("h")
   class211 field3132 = null;

   public boolean hasNext() {
      if(this.field3130 != this.field3129.field3142[this.field3131 - 1]) {
         return true;
      } else {
         while(this.field3131 < this.field3129.field3141) {
            if(this.field3129.field3142[this.field3131++].field3162 != this.field3129.field3142[this.field3131 - 1]) {
               this.field3130 = this.field3129.field3142[this.field3131 - 1].field3162;
               return true;
            }

            this.field3130 = this.field3129.field3142[this.field3131 - 1];
         }

         return false;
      }
   }

   public Object next() {
      class211 var1;
      if(this.field3130 != this.field3129.field3142[this.field3131 - 1]) {
         var1 = this.field3130;
         this.field3130 = var1.field3162;
         this.field3132 = var1;
         return var1;
      } else {
         do {
            if(this.field3131 >= this.field3129.field3141) {
               return null;
            }

            var1 = this.field3129.field3142[this.field3131++].field3162;
         } while(var1 == this.field3129.field3142[this.field3131 - 1]);

         this.field3130 = var1.field3162;
         this.field3132 = var1;
         return var1;
      }
   }

   @ObfuscatedName("e")
   void method3843() {
      this.field3130 = this.field3129.field3142[0].field3162;
      this.field3131 = 1;
      this.field3132 = null;
   }

   public void remove() {
      if(this.field3132 == null) {
         throw new IllegalStateException();
      } else {
         this.field3132.method4000();
         this.field3132 = null;
      }
   }

   class197(class201 var1) {
      this.field3129 = var1;
      this.method3843();
   }
}
