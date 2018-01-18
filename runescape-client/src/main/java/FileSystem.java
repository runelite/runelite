import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      intValue = -2057531233
   )
   @Export("clanChatCount")
   static int clanChatCount;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -232372331
   )
   static int field3301;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1608342227
   )
   @Export("type")
   int type;
   @ObfuscatedName("v")
   byte[] field3299;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   @Export("index")
   IndexFile index;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   @Export("data")
   IndexData data;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lil;Lil;Ljava/lang/String;Ljava/lang/String;I)Ljz;",
      garbageValue = "-54154712"
   )
   public static Font method4299(IndexDataBase var0, IndexDataBase var1, String var2, String var3) {
      int var4 = var0.getFile(var2);
      int var5 = var0.getChild(var4, var3);
      Font var6;
      if(!class288.method5126(var0, var4, var5)) {
         var6 = null;
      } else {
         byte[] var8 = var1.getConfigData(var4, var5);
         Font var7;
         if(var8 == null) {
            var7 = null;
         } else {
            Font var9 = new Font(var8, class299.field3870, class299.offsetsY, class54.field635, UrlRequester.field2099, class299.field3869, class188.spritePixels);
            class139.method2922();
            var7 = var9;
         }

         var6 = var7;
      }

      return var6;
   }
}
