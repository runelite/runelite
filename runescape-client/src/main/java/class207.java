import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class207 implements Iterator {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   class208 field2582;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   CacheableNode field2581;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   CacheableNode field2580;

   @ObfuscatedSignature(
      signature = "(Lhu;)V"
   )
   class207(class208 var1) {
      this.field2580 = null;
      this.field2582 = var1;
      this.field2581 = this.field2582.field2583.previous;
      this.field2580 = null;
   }

   public boolean hasNext() {
      return this.field2582.field2583 != this.field2581;
   }

   public Object next() {
      CacheableNode var1 = this.field2581;
      if(var1 == this.field2582.field2583) {
         var1 = null;
         this.field2581 = null;
      } else {
         this.field2581 = var1.previous;
      }

      this.field2580 = var1;
      return var1;
   }

   public void remove() {
      if(this.field2580 == null) {
         throw new IllegalStateException();
      } else {
         this.field2580.unlinkDual();
         this.field2580 = null;
      }
   }
}
