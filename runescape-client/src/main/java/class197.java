import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gn")
public class class197 implements Iterator {
   @ObfuscatedName("r")
   int field3141;
   @ObfuscatedName("g")
   Node field3142;
   @ObfuscatedName("e")
   Node field3143 = null;
   @ObfuscatedName("l")
   class201 field3144;

   public void remove() {
      if(this.field3143 == null) {
         throw new IllegalStateException();
      } else {
         this.field3143.unlink();
         this.field3143 = null;
      }
   }

   @ObfuscatedName("l")
   void method3916() {
      this.field3142 = this.field3144.field3154[0].next;
      this.field3141 = 1;
      this.field3143 = null;
   }

   public Object next() {
      Node var1;
      if(this.field3142 != this.field3144.field3154[this.field3141 - 1]) {
         var1 = this.field3142;
         this.field3142 = var1.next;
         this.field3143 = var1;
         return var1;
      } else {
         while(this.field3141 < this.field3144.field3155) {
            var1 = this.field3144.field3154[this.field3141++].next;
            if(var1 != this.field3144.field3154[this.field3141 - 1]) {
               this.field3142 = var1.next;
               this.field3143 = var1;
               return var1;
            }
         }

         return null;
      }
   }

   public boolean hasNext() {
      if(this.field3142 != this.field3144.field3154[this.field3141 - 1]) {
         return true;
      } else {
         while(this.field3141 < this.field3144.field3155) {
            if(this.field3144.field3154[this.field3141++].next != this.field3144.field3154[this.field3141 - 1]) {
               this.field3142 = this.field3144.field3154[this.field3141 - 1].next;
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
