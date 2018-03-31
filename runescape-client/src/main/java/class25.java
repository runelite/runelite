import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public class class25 {
   @ObfuscatedName("x")
   @Export("indexSpriteWidths")
   static int[] indexSpriteWidths;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -400098911
   )
   static int field357;
   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "[Lla;"
   )
   static SpritePixels[] field356;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -424882495
   )
   int field355;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   Coordinates field354;

   @ObfuscatedSignature(
      signature = "(ILim;)V"
   )
   class25(int var1, Coordinates var2) {
      this.field355 = var1;
      this.field354 = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "-1708710488"
   )
   static void method201(int var0, boolean var1, int var2, boolean var3) {
      if(FaceNormal.worldList != null) {
         MapIcon.method568(0, FaceNormal.worldList.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1929042985"
   )
   static void method200() {
      if(class90.Login_isUsernameRemembered && class90.username != null && class90.username.length() > 0) {
         class90.field1367 = 1;
      } else {
         class90.field1367 = 0;
      }

   }
}
