import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gj")
public class class206 implements Iterator {
   @ObfuscatedName("j")
   class200 field3117;
   @ObfuscatedName("h")
   class204 field3118;
   @ObfuscatedName("m")
   class204 field3119 = null;

   public void remove() {
      this.field3119.method3863();
      this.field3119 = null;
   }

   public boolean hasNext() {
      return this.field3118 != this.field3117.field3108;
   }

   class206(class200 var1) {
      this.field3117 = var1;
      this.field3118 = this.field3117.field3108.field3112;
      this.field3119 = null;
   }

   public Object next() {
      class204 var1 = this.field3118;
      if(var1 == this.field3117.field3108) {
         var1 = null;
         this.field3118 = null;
      } else {
         this.field3118 = var1.field3112;
      }

      this.field3119 = var1;
      return var1;
   }
}
