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
   public Link field461;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   public Link field462;

   @ObfuscatedName("m")
   @Export("remove")
   public void remove() {
      if (this.field462 != null) {
         this.field462.field461 = this.field461;
         this.field461.field462 = this.field462;
         this.field461 = null;
         this.field462 = null;
      }

   }
}
