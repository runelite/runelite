import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
public class class134 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1857824587
   )
   static int field1979;
   @ObfuscatedName("i")
   static boolean field1980;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -565997421
   )
   static int field1981;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1325186875
   )
   static int field1982;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 768292897
   )
   static int field1983;
   @ObfuscatedName("q")
   static boolean field1984;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 836314185
   )
   static int field1985;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 12893219
   )
   public static int field1986;
   @ObfuscatedName("o")
   public static int[] field1987;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1934210365
   )
   static int field1988;
   @ObfuscatedName("rb")
   static Preferences field1989;

   static {
      field1980 = false;
      field1979 = 0;
      field1988 = 0;
      field1984 = false;
      field1986 = 0;
      field1987 = new int[1000];
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "-21"
   )
   public static byte[] method2618() {
      byte[] var0 = new byte[24];

      try {
         class155.field2221.method2358(0L);
         class155.field2221.method2380(var0);

         int var1;
         for(var1 = 0; var1 < 24 && var0[var1] == 0; ++var1) {
            ;
         }

         if(var1 >= 24) {
            throw new IOException();
         }
      } catch (Exception var4) {
         for(int var2 = 0; var2 < 24; ++var2) {
            var0[var2] = -1;
         }
      }

      return var0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-2135300288"
   )
   public static String method2619(CharSequence var0) {
      int var2 = var0.length();
      char[] var3 = new char[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = 42;
      }

      String var1 = new String(var3);
      return var1;
   }
}
