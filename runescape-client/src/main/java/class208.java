import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hx")
public class class208 implements Iterator {
   @ObfuscatedName("i")
   class205 field3165;
   @ObfuscatedName("h")
   Node field3166;
   @ObfuscatedName("e")
   Node field3167 = null;

   public Object next() {
      Node var1 = this.field3166;
      if(var1 == this.field3165.field3161) {
         var1 = null;
         this.field3166 = null;
      } else {
         this.field3166 = var1.next;
      }

      this.field3167 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field3166 != this.field3165.field3161;
   }

   public void remove() {
      this.field3167.unlink();
      this.field3167 = null;
   }

   class208(class205 var1) {
      this.field3165 = var1;
      this.field3166 = this.field3165.field3161.next;
      this.field3167 = null;
   }
}
