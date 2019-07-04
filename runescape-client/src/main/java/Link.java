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
   @Export("previous")
   public Link previous;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("next")
   public Link next;

   @ObfuscatedName("m")
   @Export("remove")
   public void remove() {
      if (this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }

   }
}
