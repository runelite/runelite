import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class20 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   static Widget field338;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   @Export("NetCache_reference")
   public static Buffer NetCache_reference;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "Llr;"
   )
   @Export("rasterProvider")
   public static BufferProvider rasterProvider;
   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexCache13")
   static IndexData indexCache13;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lbq;Lbq;IZI)I",
      garbageValue = "725512358"
   )
   static int method154(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1672()?(var1.method1672()?0:1):(var1.method1672()?-1:0)):(var2 == 5?(var0.method1654()?(var1.method1654()?0:1):(var1.method1654()?-1:0)):(var2 == 6?(var0.method1655()?(var1.method1655()?0:1):(var1.method1655()?-1:0)):(var2 == 7?(var0.method1653()?(var1.method1653()?0:1):(var1.method1653()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1029147786"
   )
   static void method153(boolean var0) {
      class90.loginMessage1 = "";
      class90.loginMessage2 = "Enter your username/email & password.";
      class90.loginMessage3 = "";
      class90.loginIndex = 2;
      if(var0) {
         class90.password = "";
      }

      if(class90.username == null || class90.username.length() <= 0) {
         if(class55.preferences.rememberedUsername != null) {
            class90.username = class55.preferences.rememberedUsername;
            class90.Login_isUsernameRemembered = true;
         } else {
            class90.Login_isUsernameRemembered = false;
         }
      }

      FontName.method5595();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "381351369"
   )
   public static void method152() {
      ItemComposition.items.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
   }
}
