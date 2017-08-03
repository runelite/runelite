import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
public class class200 implements Iterator {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   class201 field2457;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   CacheableNode field2456;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   CacheableNode field2455;

   @ObfuscatedSignature(
      signature = "(Lgf;)V"
   )
   class200(class201 var1) {
      this.field2455 = null;
      this.field2457 = var1;
      this.field2456 = this.field2457.field2458.previous;
      this.field2455 = null;
   }

   public Object next() {
      CacheableNode var1 = this.field2456;
      if(var1 == this.field2457.field2458) {
         var1 = null;
         this.field2456 = null;
      } else {
         this.field2456 = var1.previous;
      }

      this.field2455 = var1;
      return var1;
   }

   public void remove() {
      this.field2455.unlinkDual();
      this.field2455 = null;
   }

   public boolean hasNext() {
      return this.field2457.field2458 != this.field2456;
   }
}
