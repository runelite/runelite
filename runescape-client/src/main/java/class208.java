import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("he")
public class class208 implements Iterator {
   @ObfuscatedName("g")
   class211 field3165;
   @ObfuscatedName("l")
   class205 field3166;
   @ObfuscatedName("r")
   class211 field3167 = null;

   class208(class205 var1) {
      this.field3166 = var1;
      this.field3165 = this.field3166.field3161.field3173;
      this.field3167 = null;
   }

   public Object next() {
      class211 var1 = this.field3165;
      if(var1 == this.field3166.field3161) {
         var1 = null;
         this.field3165 = null;
      } else {
         this.field3165 = var1.field3173;
      }

      this.field3167 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field3165 != this.field3166.field3161;
   }

   public void remove() {
      if(this.field3167 == null) {
         throw new IllegalStateException();
      } else {
         this.field3167.method4067();
         this.field3167 = null;
      }
   }
}
