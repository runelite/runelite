import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
public class class135 {
   @ObfuscatedName("j")
   public static boolean field2001;
   @ObfuscatedName("g")
   @Export("highMemory")
   protected static boolean highMemory;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -231862869
   )
   public static int field1996;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 583539705
   )
   public static int field1998;
   @ObfuscatedName("p")
   public static boolean field1999;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1264914355
   )
   public static int field1997;
   @ObfuscatedName("r")
   public static int[] field2002;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 24041603
   )
   static int field2000;

   static {
      field2001 = false;
      field1996 = 0;
      field1998 = 0;
      field1999 = false;
      field1997 = 0;
      field2002 = new int[1000];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "16"
   )
   public static int method2612(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }
}
