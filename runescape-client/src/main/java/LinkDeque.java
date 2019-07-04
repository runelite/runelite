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
   Link field463;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   Link field464;

   public LinkDeque() {
      this.field463 = new Link();
      this.field463.field461 = this.field463;
      this.field463.field462 = this.field463;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgh;)V"
   )
   public void method163(Link var1) {
      if (var1.field462 != null) {
         var1.remove();
      }

      var1.field462 = this.field463.field462;
      var1.field461 = this.field463;
      var1.field462.field461 = var1;
      var1.field461.field462 = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "()Lgh;"
   )
   public Link method164() {
      Link var1 = this.field463.field461;
      if (var1 == this.field463) {
         this.field464 = null;
         return null;
      } else {
         this.field464 = var1.field461;
         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "()Lgh;"
   )
   public Link method165() {
      Link var1 = this.field464;
      if (var1 == this.field463) {
         this.field464 = null;
         return null;
      } else {
         this.field464 = var1.field461;
         return var1;
      }
   }
}
