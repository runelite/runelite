import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hv")
public class class209 implements Iterator {
   @ObfuscatedName("l")
   class203 field3168;
   @ObfuscatedName("g")
   class207 field3169;
   @ObfuscatedName("r")
   class207 field3170 = null;

   class209(class203 var1) {
      this.field3168 = var1;
      this.field3169 = this.field3168.field3158.field3164;
      this.field3170 = null;
   }

   public Object next() {
      class207 var1 = this.field3169;
      if(var1 == this.field3168.field3158) {
         var1 = null;
         this.field3169 = null;
      } else {
         this.field3169 = var1.field3164;
      }

      this.field3170 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field3169 != this.field3168.field3158;
   }

   public void remove() {
      if(this.field3170 == null) {
         throw new IllegalStateException();
      } else {
         this.field3170.method4045();
         this.field3170 = null;
      }
   }
}
