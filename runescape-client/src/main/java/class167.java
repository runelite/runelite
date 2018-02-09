import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public class class167 {
   @ObfuscatedName("m")
   static int[][] field2224;
   @ObfuscatedName("h")
   static int[][] field2222;
   @ObfuscatedName("d")
   static int[] field2219;
   @ObfuscatedName("z")
   static int[] field2225;
   @ObfuscatedName("v")
   @Export("tt")
   static int[] tt;

   static {
      field2224 = new int[128][128];
      field2222 = new int[128][128];
      field2219 = new int[4096];
      field2225 = new int[4096];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "12"
   )
   public static boolean method3382(char var0) {
      return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "57"
   )
   public static String method3394(CharSequence var0) {
      return SoundTaskDataProvider.method734('*', var0.length());
   }

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "(Lhs;I)Lhs;",
      garbageValue = "-1852130151"
   )
   static Widget method3391(Widget var0) {
      Widget var1 = class160.method3261(var0);
      if(var1 == null) {
         var1 = var0.dragParent;
      }

      return var1;
   }

   @ObfuscatedName("kn")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "832311825"
   )
   static String method3392(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.socketType == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.socketType == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.socketType == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.socketType == 5) {
         var0 = var0 + "-wti";
      } else if(Client.socketType == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(IndexFile.sessionToken != null) {
         var3 = "/p=" + IndexFile.sessionToken;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.languageId + "/a=" + class265.field3502 + var3 + "/";
   }
}
