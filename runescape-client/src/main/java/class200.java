import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
public class class200 implements Iterator {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   class201 field2481;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   CacheableNode field2482;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   CacheableNode field2480;

   @ObfuscatedSignature(
      signature = "(Lge;)V"
   )
   class200(class201 var1) {
      this.field2480 = null;
      this.field2481 = var1;
      this.field2482 = this.field2481.field2483.previous;
      this.field2480 = null;
   }

   public Object next() {
      CacheableNode var1 = this.field2482;
      if(var1 == this.field2481.field2483) {
         var1 = null;
         this.field2482 = null;
      } else {
         this.field2482 = var1.previous;
      }

      this.field2480 = var1;
      return var1;
   }

   public void remove() {
      if(this.field2480 == null) {
         throw new IllegalStateException();
      } else {
         this.field2480.unlinkDual();
         this.field2480 = null;
      }
   }

   public boolean hasNext() {
      return this.field2481.field2483 != this.field2482;
   }
}
