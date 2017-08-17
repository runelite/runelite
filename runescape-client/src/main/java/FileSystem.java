import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -330369103
   )
   int field3196;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   @Export("index")
   IndexFile index;
   @ObfuscatedName("h")
   byte[] field3194;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("data")
   IndexData data;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lia;Lia;III)Ljh;",
      garbageValue = "-1293828738"
   )
   public static Font method4108(IndexDataBase var0, IndexDataBase var1, int var2, int var3) {
      if(!FileOnDisk.method2386(var0, var2, var3)) {
         return null;
      } else {
         byte[] var5 = var1.getConfigData(var2, var3);
         Font var4;
         if(var5 == null) {
            var4 = null;
         } else {
            Font var6 = new Font(var5, class287.field3781, class211.offsetsY, class266.field3647, class287.field3782, class287.field3783, class274.spritePixels);
            class287.field3781 = null;
            class211.offsetsY = null;
            class266.field3647 = null;
            class287.field3782 = null;
            class287.field3783 = null;
            class274.spritePixels = null;
            var4 = var6;
         }

         return var4;
      }
   }
}
