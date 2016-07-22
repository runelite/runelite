import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hg")
public class class208 implements Iterator {
   @ObfuscatedName("e")
   class211 field3158 = null;
   @ObfuscatedName("w")
   class211 field3159;
   @ObfuscatedName("m")
   class205 field3160;

   public boolean hasNext() {
      return this.field3159 != this.field3160.field3154;
   }

   public void remove() {
      this.field3158.method3990();
      this.field3158 = null;
   }

   class208(class205 var1) {
      this.field3160 = var1;
      this.field3159 = this.field3160.field3154.field3168;
      this.field3158 = null;
   }

   public Object next() {
      class211 var1 = this.field3159;
      if(var1 == this.field3160.field3154) {
         var1 = null;
         this.field3159 = null;
      } else {
         this.field3159 = var1.field3168;
      }

      this.field3158 = var1;
      return var1;
   }
}
