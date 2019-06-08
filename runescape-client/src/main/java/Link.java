import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
@Implements("Link")
public class Link {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("__m")
   public Link __m;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("__f")
   public Link __f;

   @ObfuscatedName("m")
   @Export("remove")
   public void remove() {
      if(this.__f != null) {
         this.__f.__m = this.__m;
         this.__m.__f = this.__f;
         this.__m = null;
         this.__f = null;
      }
   }
}
