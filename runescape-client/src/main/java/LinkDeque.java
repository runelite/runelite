import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
@Implements("LinkDeque")
public class LinkDeque {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   Link field2596;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   Link field2595;

   public LinkDeque() {
      this.field2596 = new Link();
      this.field2596.field2598 = this.field2596;
      this.field2596.field2597 = this.field2596;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgc;)V"
   )
   public void method3790(Link var1) {
      if(var1.field2597 != null) {
         var1.remove();
      }

      var1.field2597 = this.field2596.field2597;
      var1.field2598 = this.field2596;
      var1.field2597.field2598 = var1;
      var1.field2598.field2597 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "()Lgc;"
   )
   public Link method3791() {
      Link var1 = this.field2596.field2598;
      if(var1 == this.field2596) {
         this.field2595 = null;
         return null;
      } else {
         this.field2595 = var1.field2598;
         return var1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "()Lgc;"
   )
   public Link method3794() {
      Link var1 = this.field2595;
      if(var1 == this.field2596) {
         this.field2595 = null;
         return null;
      } else {
         this.field2595 = var1.field2598;
         return var1;
      }
   }
}
