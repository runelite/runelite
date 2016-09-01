import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ht")
public class class208 implements Iterator {
   @ObfuscatedName("j")
   Node field3164 = null;
   @ObfuscatedName("x")
   class205 field3165;
   @ObfuscatedName("r")
   Node field3166;

   class208(class205 var1) {
      this.field3165 = var1;
      this.field3166 = this.field3165.field3160.next;
      this.field3164 = null;
   }

   public boolean hasNext() {
      return this.field3166 != this.field3165.field3160;
   }

   public void remove() {
      if(this.field3164 == null) {
         throw new IllegalStateException();
      } else {
         this.field3164.unlink();
         this.field3164 = null;
      }
   }

   public Object next() {
      Node var1 = this.field3166;
      if(var1 == this.field3165.field3160) {
         var1 = null;
         this.field3166 = null;
      } else {
         this.field3166 = var1.next;
      }

      this.field3164 = var1;
      return var1;
   }
}
