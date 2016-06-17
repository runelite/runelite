import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gm")
public class class206 implements Iterator {
   @ObfuscatedName("g")
   class204 field3108;
   @ObfuscatedName("b")
   class200 field3109;
   @ObfuscatedName("j")
   class204 field3110 = null;

   class206(class200 var1) {
      this.field3109 = var1;
      this.field3108 = this.field3109.field3099.field3103;
      this.field3110 = null;
   }

   public Object next() {
      class204 var1 = this.field3108;
      if(var1 == this.field3109.field3099) {
         var1 = null;
         this.field3108 = null;
      } else {
         this.field3108 = var1.field3103;
      }

      this.field3110 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field3108 != this.field3109.field3099;
   }

   public void remove() {
      this.field3110.method3889();
      this.field3110 = null;
   }
}
