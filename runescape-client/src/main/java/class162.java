import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public class class162 {
   @ObfuscatedName("x")
   public static int[][] field2272;
   @ObfuscatedName("y")
   public static int[][] field2273;
   @ObfuscatedName("t")
   public static int[] field2271;
   @ObfuscatedName("i")
   public static int[] field2282;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1408020403
   )
   public static int field2277;

   static {
      field2272 = new int[128][128];
      field2273 = new int[128][128];
      field2271 = new int[4096];
      field2282 = new int[4096];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lim;Ljava/lang/String;Ljava/lang/String;I)Ljw;",
      garbageValue = "617924862"
   )
   @Export("getSprite")
   public static IndexedSprite getSprite(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return class31.method273(var0, var3, var4);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "561933219"
   )
   public static int method3101(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}
