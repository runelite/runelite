import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gi")
public class class193 implements Iterator {
   @ObfuscatedName("a")
   class197 field3078;
   @ObfuscatedName("r")
   class207 field3079;
   @ObfuscatedName("f")
   int field3080;
   @ObfuscatedName("s")
   class207 field3081 = null;

   class193(class197 var1) {
      this.field3078 = var1;
      this.method3808();
   }

   public boolean hasNext() {
      if(this.field3079 != this.field3078.field3090[this.field3080 - 1]) {
         return true;
      } else {
         while(this.field3080 < this.field3078.field3092) {
            if(this.field3078.field3090[this.field3080++].field3110 != this.field3078.field3090[this.field3080 - 1]) {
               this.field3079 = this.field3078.field3090[this.field3080 - 1].field3110;
               return true;
            }

            this.field3079 = this.field3078.field3090[this.field3080 - 1];
         }

         return false;
      }
   }

   public void remove() {
      if(this.field3081 == null) {
         throw new IllegalStateException();
      } else {
         this.field3081.method3946();
         this.field3081 = null;
      }
   }

   @ObfuscatedName("a")
   void method3808() {
      this.field3079 = this.field3078.field3090[0].field3110;
      this.field3080 = 1;
      this.field3081 = null;
   }

   public Object next() {
      class207 var1;
      if(this.field3079 != this.field3078.field3090[this.field3080 - 1]) {
         var1 = this.field3079;
         this.field3079 = var1.field3110;
         this.field3081 = var1;
         return var1;
      } else {
         do {
            if(this.field3080 >= this.field3078.field3092) {
               return null;
            }

            var1 = this.field3078.field3090[this.field3080++].field3110;
         } while(var1 == this.field3078.field3090[this.field3080 - 1]);

         this.field3079 = var1.field3110;
         this.field3081 = var1;
         return var1;
      }
   }
}
