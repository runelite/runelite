import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
@Implements("Link")
public class Link {
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   Link field2572;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   Link field2573;

   @ObfuscatedName("d")
   @Export("remove")
   public void remove() {
      if(this.field2573 != null) {
         this.field2573.field2572 = this.field2572;
         this.field2572.field2573 = this.field2573;
         this.field2572 = null;
         this.field2573 = null;
      }
   }
}
