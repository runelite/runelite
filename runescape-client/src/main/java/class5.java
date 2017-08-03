import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
final class class5 implements class0 {
   @ObfuscatedName("r")
   public static short[][] field33;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -856137223
   )
   static int field34;

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "10128141"
   )
   static final void method13(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuActionParams0[var0];
         int var2 = Client.menuActionParams1[var0];
         int var3 = Client.menuTypes[var0];
         int var4 = Client.menuIdentifiers[var0];
         String var5 = Client.menuOptions[var0];
         String var6 = Client.menuTargets[var0];
         class214.menuAction(var1, var2, var3, var4, var5, var6, MouseInput.field709, MouseInput.field713);
      }
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-117"
   )
   static final String method14(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + CacheFile.getColTags('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + CacheFile.getColTags(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + CacheFile.getColTags(16776960) + var1 + "</col>");
   }
}
