import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hp")
public class class209 implements Iterator {
   @ObfuscatedName("c")
   class207 field3156 = null;
   @ObfuscatedName("l")
   class207 field3157;
   @ObfuscatedName("e")
   class203 field3158;

   public Object next() {
      class207 var1 = this.field3157;
      if(var1 == this.field3158.field3146) {
         var1 = null;
         this.field3157 = null;
      } else {
         this.field3157 = var1.field3152;
      }

      this.field3156 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field3157 != this.field3158.field3146;
   }

   public void remove() {
      if(this.field3156 == null) {
         throw new IllegalStateException();
      } else {
         this.field3156.method3978();
         this.field3156 = null;
      }
   }

   class209(class203 var1) {
      this.field3158 = var1;
      this.field3157 = this.field3158.field3146.field3152;
      this.field3156 = null;
   }
}
