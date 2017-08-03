import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
public class class54 {
   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("indexModels")
   static IndexData indexModels;
   @ObfuscatedName("p")
   static int[] field641;

   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "210263866"
   )
   static final void method804(int var0) {
      if(class7.loadWidget(var0)) {
         class31.method272(class170.widgets[var0], -1);
      }
   }
}
