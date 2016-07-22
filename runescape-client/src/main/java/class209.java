import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hq")
public class class209 implements Iterator {
   @ObfuscatedName("w")
   class207 field3161;
   @ObfuscatedName("m")
   class203 field3162;
   @ObfuscatedName("e")
   class207 field3163 = null;

   public void remove() {
      if(this.field3163 == null) {
         throw new IllegalStateException();
      } else {
         this.field3163.method3960();
         this.field3163 = null;
      }
   }

   public boolean hasNext() {
      return this.field3161 != this.field3162.field3151;
   }

   public Object next() {
      class207 var1 = this.field3161;
      if(var1 == this.field3162.field3151) {
         var1 = null;
         this.field3161 = null;
      } else {
         this.field3161 = var1.field3156;
      }

      this.field3163 = var1;
      return var1;
   }

   class209(class203 var1) {
      this.field3162 = var1;
      this.field3161 = this.field3162.field3151.field3156;
      this.field3163 = null;
   }
}
