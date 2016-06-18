import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class171 {
   @ObfuscatedName("w")
   static boolean field2708;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1150398647
   )
   public static int field2709 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2067359895
   )
   public static int field2710 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -619871081
   )
   public static int field2711 = 0;
   @ObfuscatedName("y")
   public static class196 field2712 = new class196(32);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -493859925
   )
   public static int field2713 = 0;
   @ObfuscatedName("l")
   public static class196 field2715 = new class196(4096);
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1165276647
   )
   public static int field2716 = 0;
   @ObfuscatedName("p")
   public static class196 field2717 = new class196(4096);
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -778798729
   )
   public static int field2718 = 0;
   @ObfuscatedName("b")
   public static class143 field2719;
   @ObfuscatedName("d")
   public static class196 field2720 = new class196(4096);
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2133047637
   )
   public static int field2721 = 0;
   @ObfuscatedName("v")
   static CRC32 field2722 = new CRC32();
   @ObfuscatedName("f")
   static class168[] field2723 = new class168[256];
   @ObfuscatedName("q")
   public static byte field2724 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 449134541
   )
   public static int field2725 = 0;
   @ObfuscatedName("k")
   public static class119 field2726 = new class119(8);
   @ObfuscatedName("c")
   public static class203 field2728 = new class203();

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass167;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "-1790957668"
   )
   public static void method3388(class167 var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.method3281(var1);
      int var6 = var0.method3282(var5, var2);
      class85.method1922(var0, var5, var6, var3, var4);
   }
}
