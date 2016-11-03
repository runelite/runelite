import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hj")
public class class208 implements Iterator {
   @ObfuscatedName("q")
   Node field3157;
   @ObfuscatedName("f")
   Node field3158 = null;
   @ObfuscatedName("k")
   class205 field3159;

   public boolean hasNext() {
      return this.field3157 != this.field3159.field3152;
   }

   public void remove() {
      this.field3158.unlink();
      this.field3158 = null;
   }

   class208(class205 var1) {
      this.field3159 = var1;
      this.field3157 = this.field3159.field3152.next;
      this.field3158 = null;
   }

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
}
