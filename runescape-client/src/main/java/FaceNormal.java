import java.awt.datatransfer.Clipboard;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 129576377
   )
   int field1534;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -516380591
   )
   int field1535;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1165613419
   )
   int field1537;
   @ObfuscatedName("pr")
   static Clipboard field1539;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)[LModIcon;",
      garbageValue = "-221263484"
   )
   static ModIcon[] method1939() {
      ModIcon[] var0 = new ModIcon[class79.field1464];

      for(int var1 = 0; var1 < class79.field1464; ++var1) {
         ModIcon var2 = var0[var1] = new ModIcon();
         var2.width = class79.field1460;
         var2.originalHeight = class79.field1456;
         var2.offsetX = class79.field1462[var1];
         var2.offsetY = class79.field1458[var1];
         var2.originalWidth = class59.field1268[var1];
         var2.height = class79.field1461[var1];
         var2.palette = class132.field2126;
         var2.pixels = class8.field139[var1];
      }

      class35.method747();
      return var0;
   }
}
