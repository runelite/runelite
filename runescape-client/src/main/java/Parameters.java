import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ky")
@Implements("Parameters")
public class Parameters {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   public static final Parameters field3793;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   public static final Parameters field3800;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   public static final Parameters field3802;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   public static final Parameters field3795;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   public static final Parameters field3796;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   public static final Parameters field3797;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   public static final Parameters field3794;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   public static final Parameters field3792;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   public static final Parameters field3807;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   public static final Parameters field3801;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   public static final Parameters field3798;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   public static final Parameters field3803;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   public static final Parameters field3804;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   public static final Parameters field3805;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   public static final Parameters field3806;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   public static final Parameters field3799;
   @ObfuscatedName("b")
   @Export("key")
   public final String key;

   static {
      field3793 = new Parameters("9", "9");
      field3800 = new Parameters("11", "11");
      field3802 = new Parameters("10", "10");
      field3795 = new Parameters("4", "4");
      field3796 = new Parameters("16", "16");
      field3797 = new Parameters("14", "14");
      field3794 = new Parameters("12", "12");
      field3792 = new Parameters("15", "15");
      field3807 = new Parameters("1", "1");
      field3801 = new Parameters("6", "6");
      field3798 = new Parameters("3", "3");
      field3803 = new Parameters("7", "7");
      field3804 = new Parameters("13", "13");
      field3805 = new Parameters("5", "5");
      field3806 = new Parameters("2", "2");
      field3799 = new Parameters("8", "8");
   }

   Parameters(String var1, String var2) {
      this.key = var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljm;IIB)[Lla;",
      garbageValue = "-60"
   )
   static SpritePixels[] method5208(IndexDataBase var0, int var1, int var2) {
      if(!class288.method5204(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels[] var4 = new SpritePixels[WorldComparator.indexedSpriteCount];

         for(int var5 = 0; var5 < WorldComparator.indexedSpriteCount; ++var5) {
            SpritePixels var6 = var4[var5] = new SpritePixels();
            var6.maxWidth = class332.indexedSpriteWidth;
            var6.maxHeight = class81.indexedSpriteHeight;
            var6.offsetX = GameCanvas.indexedSpriteOffsetXs[var5];
            var6.offsetY = class332.indexedSpriteOffsetYs[var5];
            var6.width = class25.indexSpriteWidths[var5];
            var6.height = class332.indexedSpriteHeights[var5];
            int var7 = var6.height * var6.width;
            byte[] var8 = class332.spritePixels[var5];
            var6.pixels = new int[var7];

            for(int var9 = 0; var9 < var7; ++var9) {
               var6.pixels[var9] = class332.indexedSpritePalette[var8[var9] & 255];
            }
         }

         FileSystem.method4544();
         return var4;
      }
   }
}
