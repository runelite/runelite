import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gp")
public class class197 implements Iterator {
   @ObfuscatedName("i")
   class201 field3141;
   @ObfuscatedName("h")
   Node field3142;
   @ObfuscatedName("e")
   int field3143;
   @ObfuscatedName("g")
   Node field3144 = null;

   @ObfuscatedName("i")
   void method3792() {
      this.field3142 = this.field3141.field3153[0].next;
      this.field3143 = 1;
      this.field3144 = null;
   }

   public Object next() {
      Node var1;
      if(this.field3142 != this.field3141.field3153[this.field3143 - 1]) {
         var1 = this.field3142;
         this.field3142 = var1.next;
         this.field3144 = var1;
         return var1;
      } else {
         do {
            if(this.field3143 >= this.field3141.field3154) {
               return null;
            }

            var1 = this.field3141.field3153[this.field3143++].next;
         } while(var1 == this.field3141.field3153[this.field3143 - 1]);

         this.field3142 = var1.next;
         this.field3144 = var1;
         return var1;
      }
   }

   public boolean hasNext() {
      if(this.field3142 != this.field3141.field3153[this.field3143 - 1]) {
         return true;
      } else {
         while(this.field3143 < this.field3141.field3154) {
            if(this.field3141.field3153[this.field3143++].next != this.field3141.field3153[this.field3143 - 1]) {
               this.field3142 = this.field3141.field3153[this.field3143 - 1].next;
               return true;
            }

            this.field3142 = this.field3141.field3153[this.field3143 - 1];
         }

         return false;
      }
   }

   public void remove() {
      if(this.field3144 == null) {
         throw new IllegalStateException();
      } else {
         this.field3144.unlink();
         this.field3144 = null;
      }
   }

   class197(class201 var1) {
      this.field3141 = var1;
      this.method3792();
   }
}
