import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("y")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1163703573
   )
   @Export("x")
   int x;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1156559775
   )
   @Export("height")
   int height;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 273814457
   )
   @Export("y")
   int y;
   @ObfuscatedName("p")
   @Export("top")
   Renderable top;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -876700893
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("v")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2095608921
   )
   @Export("hash")
   int hash;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-214823573"
   )
   static int method1545(int var0, Script var1, boolean var2) {
      if(var0 == 6200) {
         class32.field735 -= 2;
         Client.field472 = (short)class32.field726[class32.field735];
         if(Client.field472 <= 0) {
            Client.field472 = 256;
         }

         Client.field545 = (short)class32.field726[class32.field735 + 1];
         if(Client.field545 <= 0) {
            Client.field545 = 205;
         }

         return 1;
      } else if(var0 == 6201) {
         class32.field735 -= 2;
         Client.field571 = (short)class32.field726[class32.field735];
         if(Client.field571 <= 0) {
            Client.field571 = 256;
         }

         Client.field547 = (short)class32.field726[1 + class32.field735];
         if(Client.field547 <= 0) {
            Client.field547 = 320;
         }

         return 1;
      } else if(var0 == 6202) {
         class32.field735 -= 4;
         Client.field548 = (short)class32.field726[class32.field735];
         if(Client.field548 <= 0) {
            Client.field548 = 1;
         }

         Client.field549 = (short)class32.field726[1 + class32.field735];
         if(Client.field549 <= 0) {
            Client.field549 = 32767;
         } else if(Client.field549 < Client.field548) {
            Client.field549 = Client.field548;
         }

         Client.field550 = (short)class32.field726[class32.field735 + 2];
         if(Client.field550 <= 0) {
            Client.field550 = 1;
         }

         Client.field551 = (short)class32.field726[class32.field735 + 3];
         if(Client.field551 <= 0) {
            Client.field551 = 32767;
         } else if(Client.field551 < Client.field550) {
            Client.field551 = Client.field550;
         }

         return 1;
      } else if(var0 == 6203) {
         if(null != Client.field461) {
            FaceNormal.method1989(0, 0, Client.field461.width, Client.field461.height, false);
            class32.field726[++class32.field735 - 1] = Client.camera2;
            class32.field726[++class32.field735 - 1] = Client.camera3;
         } else {
            class32.field726[++class32.field735 - 1] = -1;
            class32.field726[++class32.field735 - 1] = -1;
         }

         return 1;
      } else if(var0 == 6204) {
         class32.field726[++class32.field735 - 1] = Client.field571;
         class32.field726[++class32.field735 - 1] = Client.field547;
         return 1;
      } else if(var0 == 6205) {
         class32.field726[++class32.field735 - 1] = Client.field472;
         class32.field726[++class32.field735 - 1] = Client.field545;
         return 1;
      } else {
         return 2;
      }
   }
}
