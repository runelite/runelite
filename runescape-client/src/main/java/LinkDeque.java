import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
@Implements("LinkDeque")
public class LinkDeque {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("__m")
   Link __m;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("__f")
   Link __f;

   public LinkDeque() {
      this.__m = new Link();
      this.__m.__m = this.__m;
      this.__m.__f = this.__m;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgh;)V"
   )
   @Export("__m_437")
   public void __m_437(Link var1) {
      if(var1.__f != null) {
         var1.remove();
      }

      var1.__f = this.__m.__f;
      var1.__m = this.__m;
      var1.__f.__m = var1;
      var1.__m.__f = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "()Lgh;"
   )
   @Export("__f_438")
   public Link __f_438() {
      Link var1 = this.__m.__m;
      if(var1 == this.__m) {
         this.__f = null;
         return null;
      } else {
         this.__f = var1.__m;
         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "()Lgh;"
   )
   @Export("__q_439")
   public Link __q_439() {
      Link var1 = this.__f;
      if(var1 == this.__m) {
         this.__f = null;
         return null;
      } else {
         this.__f = var1.__m;
         return var1;
      }
   }
}
