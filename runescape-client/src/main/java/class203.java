import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
public class class203 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1848448087
   )
   public static int field2521;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   public static class204 field2523;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ldi;"
   )
   public static class110 field2524;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   public static IndexDataBase field2522;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -849064175
   )
   public static int field2520;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   public static IndexDataBase field2517;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   public static IndexDataBase field2519;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   public static IndexDataBase field2518;

   static {
      field2521 = 0;
   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(IZZZB)Lij;",
      garbageValue = "69"
   )
   @Export("openCacheIndex")
   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class155.field2261 != null) {
         var4 = new IndexFile(var0, class155.field2261, class96.field1514[var0], 1000000);
      }

      return new IndexData(var4, class204.field2552, var0, var1, var2, var3);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "1285347962"
   )
   public static String method3795(CharSequence var0) {
      String var1 = CombatInfo1.method1610(class36.method491(var0));
      if(var1 == null) {
         var1 = "";
      }

      return var1;
   }
}
