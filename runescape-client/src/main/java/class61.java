import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
public final class class61 {
   @ObfuscatedName("bc")
   static ModIcon[] field768;
   @ObfuscatedName("w")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -390026021
   )
   static int field770;
   @ObfuscatedName("y")
   static byte[][][] field771;
   @ObfuscatedName("d")
   static final int[] field772;
   @ObfuscatedName("t")
   @Export("underlayIds")
   static byte[][][] underlayIds;
   @ObfuscatedName("j")
   static int[][] field774;
   @ObfuscatedName("n")
   static final int[] field775;
   @ObfuscatedName("u")
   static final int[] field776;
   @ObfuscatedName("p")
   static final int[] field777;
   @ObfuscatedName("q")
   static final int[] field778;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 161032159
   )
   static int field779;
   @ObfuscatedName("s")
   @Export("overlayIds")
   static byte[][][] overlayIds;
   @ObfuscatedName("i")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1137929227
   )
   static int field782;
   @ObfuscatedName("di")
   @Export("indexWorldMap")
   static IndexData indexWorldMap;
   @ObfuscatedName("r")
   public static IndexDataBase field785;
   @ObfuscatedName("h")
   static final int[] field786;
   @ObfuscatedName("nh")
   static class276 field787;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field770 = 99;
      field775 = new int[]{1, 2, 4, 8};
      field776 = new int[]{16, 32, 64, 128};
      field777 = new int[]{1, 0, -1, 0};
      field778 = new int[]{0, -1, 0, 1};
      field772 = new int[]{1, -1, -1, 1};
      field786 = new int[]{-1, -1, 1, 1};
      field779 = (int)(Math.random() * 17.0D) - 8;
      field782 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "2112541472"
   )
   public static boolean method1100(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "598404115"
   )
   static int method1101(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class83.field1364:class60.field766;
      if(var0 == 1600) {
         class83.intStack[++class46.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 1601) {
         class83.intStack[++class46.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 1602) {
         class83.scriptStringStack[++class50.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 1603) {
         class83.intStack[++class46.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 1604) {
         class83.intStack[++class46.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 1605) {
         class83.intStack[++class46.intStackSize - 1] = var3.field2650;
         return 1;
      } else if(var0 == 1606) {
         class83.intStack[++class46.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 1607) {
         class83.intStack[++class46.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 1608) {
         class83.intStack[++class46.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 1609) {
         class83.intStack[++class46.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 1610) {
         class83.intStack[++class46.intStackSize - 1] = var3.field2686;
         return 1;
      } else if(var0 == 1611) {
         class83.intStack[++class46.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 1612) {
         class83.intStack[++class46.intStackSize - 1] = var3.field2680;
         return 1;
      } else if(var0 == 1613) {
         class83.intStack[++class46.intStackSize - 1] = var3.field2757.rsOrdinal();
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-62"
   )
   static final int method1102(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
