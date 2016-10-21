import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gk")
public class class197 implements Iterator {
   @ObfuscatedName("t")
   Node field3133 = null;
   @ObfuscatedName("e")
   Node field3134;
   @ObfuscatedName("n")
   int field3135;
   @ObfuscatedName("f")
   class201 field3136;

   @ObfuscatedName("f")
   void method3827() {
      this.field3134 = this.field3136.field3146[0].next;
      this.field3135 = 1;
      this.field3133 = null;
   }

   public boolean hasNext() {
      if(this.field3134 != this.field3136.field3146[this.field3135 - 1]) {
         return true;
      } else {
         while(this.field3135 < this.field3136.field3145) {
            if(this.field3136.field3146[this.field3135++].next != this.field3136.field3146[this.field3135 - 1]) {
               this.field3134 = this.field3136.field3146[this.field3135 - 1].next;
               return true;
            }

            this.field3134 = this.field3136.field3146[this.field3135 - 1];
         }

         return false;
      }
   }

   public void remove() {
      if(this.field3133 == null) {
         throw new IllegalStateException();
      } else {
         this.field3133.unlink();
         this.field3133 = null;
      }
   }

   class197(class201 var1) {
      this.field3136 = var1;
      this.method3827();
   }

   public Object next() {
      Node var1;
      if(this.field3134 != this.field3136.field3146[this.field3135 - 1]) {
         var1 = this.field3134;
         this.field3134 = var1.next;
         this.field3133 = var1;
         return var1;
      } else {
         do {
            if(this.field3135 >= this.field3136.field3145) {
               return null;
            }

            var1 = this.field3136.field3146[this.field3135++].next;
         } while(var1 == this.field3136.field3146[this.field3135 - 1]);

         this.field3134 = var1.next;
         this.field3133 = var1;
         return var1;
      }
   }
}
