import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public abstract class class9 extends Node {
   @ObfuscatedName("nu")
   @Export("clanChatRank")
   static byte clanChatRank;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1655186679
   )
   protected static int field249;
   @ObfuscatedName("ae")
   @Export("clientInstance")
   @ObfuscatedSignature(
      signature = "Lclient;"
   )
   static Client clientInstance;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = -1619552991
   )
   @Export("myWorldPort")
   static int myWorldPort;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2102608092"
   )
   abstract void vmethod54();

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lik;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "-121042616"
   )
   public static void method53(IndexDataBase var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.getFile(var1);
      int var6 = var0.getChild(var5, var2);
      class182.method3518(var0, var5, var6, var3, var4);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(CIB)I",
      garbageValue = "-103"
   )
   static int method50(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}
