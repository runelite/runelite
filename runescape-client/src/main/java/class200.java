import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
public class class200 implements Iterator {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   class201 field2502;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   CacheableNode field2503;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   CacheableNode field2501;

   @ObfuscatedSignature(
      signature = "(Lgu;)V"
   )
   class200(class201 var1) {
      this.field2501 = null;
      this.field2502 = var1;
      this.field2503 = this.field2502.field2504.previous;
      this.field2501 = null;
   }

   public Object next() {
      CacheableNode var1 = this.field2503;
      if(var1 == this.field2502.field2504) {
         var1 = null;
         this.field2503 = null;
      } else {
         this.field2503 = var1.previous;
      }

      this.field2501 = var1;
      return var1;
   }

   public void remove() {
      this.field2501.unlinkDual();
      this.field2501 = null;
   }

   public boolean hasNext() {
      return this.field2502.field2504 != this.field2503;
   }
}
