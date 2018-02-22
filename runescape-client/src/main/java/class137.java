import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public class class137 {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(BI)C",
      garbageValue = "48849594"
   )
   public static char method3041(byte var0) {
      int var1 = var0 & 255;
      if(var1 == 0) {
         throw new IllegalArgumentException("");
      } else {
         if(var1 >= 128 && var1 < 160) {
            char var2 = class300.cp1252AsciiExtension[var1 - 128];
            if(var2 == 0) {
               var2 = '?';
            }

            var1 = var2;
         }

         return (char)var1;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-88"
   )
   static int method3042(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class94.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.size();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lie;Ljava/lang/String;Ljava/lang/String;I)Llv;",
      garbageValue = "1758891624"
   )
   @Export("getSprite")
   public static IndexedSprite getSprite(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return Preferences.method1693(var0, var3, var4);
   }
}
