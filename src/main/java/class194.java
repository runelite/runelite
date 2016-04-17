import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gk")
public class class194 implements Iterator {
   @ObfuscatedName("d")
   int field3092;
   @ObfuscatedName("w")
   class208 field3093;
   @ObfuscatedName("a")
   class198 field3094;
   @ObfuscatedName("c")
   class208 field3095 = null;

   @ObfuscatedName("a")
   void method3853() {
      this.field3093 = this.field3094.field3104[0].field3124;
      this.field3092 = 1;
      this.field3095 = null;
   }

   public Object next() {
      class208 var1;
      if(this.field3093 != this.field3094.field3104[this.field3092 - 1]) {
         var1 = this.field3093;
         this.field3093 = var1.field3124;
         this.field3095 = var1;
         return var1;
      } else {
         do {
            if(this.field3092 >= this.field3094.field3106) {
               return null;
            }

            var1 = this.field3094.field3104[this.field3092++].field3124;
         } while(var1 == this.field3094.field3104[this.field3092 - 1]);

         this.field3093 = var1.field3124;
         this.field3095 = var1;
         return var1;
      }
   }

   class194(class198 var1) {
      this.field3094 = var1;
      this.method3853();
   }

   public void remove() {
      this.field3095.method3998();
      this.field3095 = null;
   }

   public boolean hasNext() {
      if(this.field3093 != this.field3094.field3104[this.field3092 - 1]) {
         return true;
      } else {
         while(this.field3092 < this.field3094.field3106) {
            if(this.field3094.field3104[this.field3092++].field3124 != this.field3094.field3104[this.field3092 - 1]) {
               this.field3093 = this.field3094.field3104[this.field3092 - 1].field3124;
               return true;
            }

            this.field3093 = this.field3094.field3104[this.field3092 - 1];
         }

         return false;
      }
   }
}
