import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ho")
public class class208 implements Iterator {
   @ObfuscatedName("n")
   Node field3157 = null;
   @ObfuscatedName("e")
   Node field3158;
   @ObfuscatedName("f")
   class205 field3159;

   public boolean hasNext() {
      return this.field3158 != this.field3159.field3153;
   }

   class208(class205 var1) {
      this.field3159 = var1;
      this.field3158 = this.field3159.field3153.next;
      this.field3157 = null;
   }

   public Object next() {
      Node var1 = this.field3158;
      if(var1 == this.field3159.field3153) {
         var1 = null;
         this.field3158 = null;
      } else {
         this.field3158 = var1.next;
      }

      this.field3157 = var1;
      return var1;
   }

   public void remove() {
      if(this.field3157 == null) {
         throw new IllegalStateException();
      } else {
         this.field3157.unlink();
         this.field3157 = null;
      }
   }
}
