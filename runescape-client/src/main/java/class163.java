import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public class class163 {
   @ObfuscatedName("of")
   @ObfuscatedGetter(
      intValue = -1795481581
   )
   static int field2206;
   @ObfuscatedName("k")
   public static int[][] field2205;
   @ObfuscatedName("z")
   public static int[][] field2204;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -728868951
   )
   public static int field2203;
   @ObfuscatedName("t")
   public static int[] field2209;
   @ObfuscatedName("p")
   public static int[] field2207;
   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("indexInterfaces")
   static IndexData indexInterfaces;

   static {
      field2205 = new int[128][128];
      field2204 = new int[128][128];
      field2209 = new int[4096];
      field2207 = new int[4096];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lid;IIB)[Lkl;",
      garbageValue = "75"
   )
   static IndexedSprite[] method3187(IndexDataBase var0, int var1, int var2) {
      return !GroundObject.method2603(var0, var1, var2)?null:WorldMapType1.method271();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lid;I)V",
      garbageValue = "-2006210608"
   )
   public static void method3185(IndexDataBase var0) {
      Overlay.overlay_ref = var0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "1548676647"
   )
   @Export("getString")
   public static String getString(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class273.field3722[var6 - 128];
               if(var7 == 0) {
                  var7 = '?';
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }
}
