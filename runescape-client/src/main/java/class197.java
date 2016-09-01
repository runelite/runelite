import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gp")
public class class197 implements Iterator {
   @ObfuscatedName("z")
   Node field3140 = null;
   @ObfuscatedName("r")
   Node field3141;
   @ObfuscatedName("x")
   class201 field3142;
   @ObfuscatedName("j")
   int field3143;

   @ObfuscatedName("x")
   void method3799() {
      this.field3141 = this.field3142.field3152[0].next;
      this.field3143 = 1;
      this.field3140 = null;
   }

   public Object next() {
      Node var1;
      if(this.field3141 != this.field3142.field3152[this.field3143 - 1]) {
         var1 = this.field3141;
         this.field3141 = var1.next;
         this.field3140 = var1;
         return var1;
      } else {
         do {
            if(this.field3143 >= this.field3142.field3154) {
               return null;
            }

            var1 = this.field3142.field3152[this.field3143++].next;
         } while(var1 == this.field3142.field3152[this.field3143 - 1]);

         this.field3141 = var1.next;
         this.field3140 = var1;
         return var1;
      }
   }

   public boolean hasNext() {
      if(this.field3141 != this.field3142.field3152[this.field3143 - 1]) {
         return true;
      } else {
         while(this.field3143 < this.field3142.field3154) {
            if(this.field3142.field3152[this.field3143++].next != this.field3142.field3152[this.field3143 - 1]) {
               this.field3141 = this.field3142.field3152[this.field3143 - 1].next;
               return true;
            }

            this.field3141 = this.field3142.field3152[this.field3143 - 1];
         }

         return false;
      }
   }

   public void remove() {
      this.field3140.unlink();
      this.field3140 = null;
   }

   class197(class201 var1) {
      this.field3142 = var1;
      this.method3799();
   }
}
