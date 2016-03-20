import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gx")
public class class205 implements Iterator {
   @ObfuscatedName("f")
   class203 field3104 = null;
   @ObfuscatedName("a")
   class199 field3105;
   @ObfuscatedName("r")
   class203 field3106;

   public Object next() {
      class203 var1 = this.field3106;
      if(var1 == this.field3105.field3095) {
         var1 = null;
         this.field3106 = null;
      } else {
         this.field3106 = var1.field3100;
      }

      this.field3104 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field3106 != this.field3105.field3095;
   }

   public void remove() {
      this.field3104.method3920();
      this.field3104 = null;
   }

   class205(class199 var1) {
      this.field3105 = var1;
      this.field3106 = this.field3105.field3095.field3100;
      this.field3104 = null;
   }
}
