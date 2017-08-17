import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class20 {
   @ObfuscatedName("eo")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   static RSSocket field337;
   @ObfuscatedName("lj")
   @ObfuscatedSignature(
      signature = "[Lhi;"
   )
   static Widget[] field338;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILia;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "-747916623"
   )
   public static void method166(int var0, IndexDataBase var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.getFile(var2);
      int var7 = var1.getChild(var6, var3);
      class204.field2507 = 1;
      class204.field2502 = var1;
      class150.field2205 = var6;
      class153.field2222 = var7;
      class204.field2504 = var4;
      class99.field1532 = var5;
      class204.field2505 = var0;
   }
}
