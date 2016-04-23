import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gm")
public class class205 implements Iterator {
   @ObfuscatedName("j")
   class202 field3114;
   @ObfuscatedName("h")
   class208 field3115;
   @ObfuscatedName("m")
   class208 field3116 = null;

   public boolean hasNext() {
      return this.field3115 != this.field3114.field3110;
   }

   public Object next() {
      class208 var1 = this.field3115;
      if(var1 == this.field3114.field3110) {
         var1 = null;
         this.field3115 = null;
      } else {
         this.field3115 = var1.field3123;
      }

      this.field3116 = var1;
      return var1;
   }

   class205(class202 var1) {
      this.field3114 = var1;
      this.field3115 = this.field3114.field3110.field3123;
      this.field3116 = null;
   }

   public void remove() {
      if(this.field3116 == null) {
         throw new IllegalStateException();
      } else {
         this.field3116.method3883();
         this.field3116 = null;
      }
   }
}
