import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
public class class200 implements Iterator {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   class201 field2482;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   CacheableNode field2483;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   CacheableNode field2481;

   @ObfuscatedSignature(
      signature = "(Lgz;)V"
   )
   class200(class201 var1) {
      this.field2481 = null;
      this.field2482 = var1;
      this.field2483 = this.field2482.field2484.previous;
      this.field2481 = null;
   }

   public Object next() {
      CacheableNode var1 = this.field2483;
      if(var1 == this.field2482.field2484) {
         var1 = null;
         this.field2483 = null;
      } else {
         this.field2483 = var1.previous;
      }

      this.field2481 = var1;
      return var1;
   }

   public void remove() {
      if(this.field2481 == null) {
         throw new IllegalStateException();
      } else {
         this.field2481.unlinkDual();
         this.field2481 = null;
      }
   }

   public boolean hasNext() {
      return this.field2482.field2484 != this.field2483;
   }
}
