import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
@Implements("Link")
public class Link {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   Link field2598;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   Link field2597;

   @ObfuscatedName("a")
   @Export("remove")
   public void remove() {
      if(this.field2597 != null) {
         this.field2597.field2598 = this.field2598;
         this.field2598.field2597 = this.field2597;
         this.field2598 = null;
         this.field2597 = null;
      }
   }
}
