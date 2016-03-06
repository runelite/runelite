import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gx")
public class class204 implements Iterator {
   @ObfuscatedName("j")
   class201 field3102;
   @ObfuscatedName("l")
   class207 field3103;
   @ObfuscatedName("a")
   class207 field3104 = null;

   public Object next() {
      class207 var1 = this.field3103;
      if(var1 == this.field3102.field3098) {
         var1 = null;
         this.field3103 = null;
      } else {
         this.field3103 = var1.field3111;
      }

      this.field3104 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field3103 != this.field3102.field3098;
   }

   public void remove() {
      if(this.field3104 == null) {
         throw new IllegalStateException();
      } else {
         this.field3104.method3853();
         this.field3104 = null;
      }
   }

   class204(class201 var1) {
      this.field3102 = var1;
      this.field3103 = this.field3102.field3098.field3111;
      this.field3104 = null;
   }
}
