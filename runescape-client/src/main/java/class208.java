import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hd")
public class class208 implements Iterator {
   @ObfuscatedName("z")
   Node field3157;
   @ObfuscatedName("t")
   Node field3158 = null;
   @ObfuscatedName("s")
   class205 field3159;

   public Object next() {
      Node var1 = this.field3157;
      if(var1 == this.field3159.field3152) {
         var1 = null;
         this.field3157 = null;
      } else {
         this.field3157 = var1.next;
      }

      this.field3158 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field3157 != this.field3159.field3152;
   }

   public void remove() {
      if(this.field3158 == null) {
         throw new IllegalStateException();
      } else {
         this.field3158.unlink();
         this.field3158 = null;
      }
   }

   class208(class205 var1) {
      this.field3159 = var1;
      this.field3157 = this.field3159.field3152.next;
      this.field3158 = null;
   }
}
