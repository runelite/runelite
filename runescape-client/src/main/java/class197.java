import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gi")
public class class197 implements Iterator {
   @ObfuscatedName("t")
   int field3133;
   @ObfuscatedName("z")
   Node field3134;
   @ObfuscatedName("s")
   class201 field3135;
   @ObfuscatedName("y")
   Node field3136 = null;

   class197(class201 var1) {
      this.field3135 = var1;
      this.method3756();
   }

   @ObfuscatedName("s")
   void method3756() {
      this.field3134 = this.field3135.field3146[0].next;
      this.field3133 = 1;
      this.field3136 = null;
   }

   public Object next() {
      Node var1;
      if(this.field3134 != this.field3135.field3146[this.field3133 - 1]) {
         var1 = this.field3134;
         this.field3134 = var1.next;
         this.field3136 = var1;
         return var1;
      } else {
         do {
            if(this.field3133 >= this.field3135.field3145) {
               return null;
            }

            var1 = this.field3135.field3146[this.field3133++].next;
         } while(var1 == this.field3135.field3146[this.field3133 - 1]);

         this.field3134 = var1.next;
         this.field3136 = var1;
         return var1;
      }
   }

   public boolean hasNext() {
      if(this.field3134 != this.field3135.field3146[this.field3133 - 1]) {
         return true;
      } else {
         while(this.field3133 < this.field3135.field3145) {
            if(this.field3135.field3146[this.field3133++].next != this.field3135.field3146[this.field3133 - 1]) {
               this.field3134 = this.field3135.field3146[this.field3133 - 1].next;
               return true;
            }

            this.field3134 = this.field3135.field3146[this.field3133 - 1];
         }

         return false;
      }
   }

   public void remove() {
      if(this.field3136 == null) {
         throw new IllegalStateException();
      } else {
         this.field3136.unlink();
         this.field3136 = null;
      }
   }
}
