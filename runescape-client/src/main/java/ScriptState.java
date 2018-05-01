import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      intValue = 1044279445
   )
   static int field742;
   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   static SpritePixels[] field744;
   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("crossSprites")
   static SpritePixels[] crossSprites;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lcr;"
   )
   @Export("invokedFromScript")
   Script invokedFromScript;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1027512821
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("b")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("z")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;

   ScriptState() {
      this.invokedFromPc = -1;
   }

   @ObfuscatedName("e")
   public static String method1132(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5 = new StringBuilder(var2);

            while(var0 != 0L) {
               long var6 = var0;
               var0 /= 37L;
               var5.append(class316.field3925[(int)(var6 - var0 * 37L)]);
            }

            return var5.reverse().toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-652159623"
   )
   static void method1129() {
      if(class90.username == null || class90.username.length() <= 0) {
         if(Client.preferences.rememberedUsername != null) {
            class90.username = Client.preferences.rememberedUsername;
            class90.Login_isUsernameRemembered = true;
         } else {
            class90.Login_isUsernameRemembered = false;
         }

      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgg;IB)Ljava/lang/String;",
      garbageValue = "-46"
   )
   public static String method1131(Buffer var0, int var1) {
      try {
         int var2 = var0.getUSmart();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class313.huffman.decompress(var0.payload, var0.offset, var3, 0, var2);
         String var4 = VarCString.getString(var3, 0, var2);
         return var4;
      } catch (Exception var6) {
         return "Cabbage";
      }
   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1319799809"
   )
   static void method1130(int var0, int var1) {
      WorldComparator.method73(class264.topContextMenuRow, var0, var1);
      class264.topContextMenuRow = null;
   }
}
