import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
public class class54 {
   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "Lbk;"
   )
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "[Lkn;"
   )
   static SpritePixels[] field655;
   @ObfuscatedName("ni")
   @ObfuscatedSignature(
      signature = "Ljg;"
   )
   static class277 field653;

   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(Lhg;I)Lhg;",
      garbageValue = "651142881"
   )
   static Widget method789(Widget var0) {
      Widget var1 = Ignore.method1115(var0);
      if(var1 == null) {
         var1 = var0.dragParent;
      }

      return var1;
   }
}
