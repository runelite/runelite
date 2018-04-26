import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public final class class62 {
   @ObfuscatedName("g")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("e")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1090968015
   )
   static int field722;
   @ObfuscatedName("z")
   @Export("tileUnderlayIds")
   static byte[][][] tileUnderlayIds;
   @ObfuscatedName("l")
   @Export("tileOverlayPath")
   static byte[][][] tileOverlayPath;
   @ObfuscatedName("s")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;
   @ObfuscatedName("h")
   @Export("floorHues")
   static int[] floorHues;
   @ObfuscatedName("v")
   static final int[] field727;
   @ObfuscatedName("u")
   static final int[] field728;
   @ObfuscatedName("k")
   static final int[] field731;
   @ObfuscatedName("w")
   static final int[] field721;
   @ObfuscatedName("m")
   static final int[] field726;
   @ObfuscatedName("a")
   static final int[] field729;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1572226269
   )
   static int field733;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2070838879
   )
   static int field734;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field722 = 99;
      field727 = new int[]{1, 2, 4, 8};
      field728 = new int[]{16, 32, 64, 128};
      field731 = new int[]{1, 0, -1, 0};
      field721 = new int[]{0, -1, 0, 1};
      field726 = new int[]{1, -1, -1, 1};
      field729 = new int[]{-1, -1, 1, 1};
      field733 = (int)(Math.random() * 17.0D) - 8;
      field734 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2079701228"
   )
   public static final void method1117() {
      class132.Viewport_containsMouse = false;
      class132.Viewport_entityCountAtMouse = 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljr;Ljava/lang/String;Ljava/lang/String;B)Llh;",
      garbageValue = "38"
   )
   @Export("getSprite")
   public static IndexedSprite getSprite(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      IndexedSprite var5;
      if(!class326.method5792(var0, var3, var4)) {
         var5 = null;
      } else {
         IndexedSprite var7 = new IndexedSprite();
         var7.originalWidth = class332.indexedSpriteWidth;
         var7.originalHeight = class332.indexedSpriteHeight;
         var7.offsetX = class332.indexedSpriteOffsetXs[0];
         var7.offsetY = WorldComparator.indexedSpriteOffsetYs[0];
         var7.width = class332.indexSpriteWidths[0];
         var7.height = GrandExchangeEvents.indexedSpriteHeights[0];
         var7.palette = class332.indexedSpritePalette;
         var7.pixels = ChatPlayer.spritePixels[0];
         class332.indexedSpriteOffsetXs = null;
         WorldComparator.indexedSpriteOffsetYs = null;
         class332.indexSpriteWidths = null;
         GrandExchangeEvents.indexedSpriteHeights = null;
         class332.indexedSpritePalette = null;
         ChatPlayer.spritePixels = null;
         var5 = var7;
      }

      return var5;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IZII)V",
      garbageValue = "2100578458"
   )
   public static final void method1120(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= 48000) {
         AbstractSoundSystem.sampleRate = var0;
         AbstractSoundSystem.audioHighMemory = var1;
         class278.field3550 = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }
}
