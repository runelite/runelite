import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public class class90 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2139335339
   )
   int field1408;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1578980989
   )
   int field1406;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 457481577
   )
   int field1407;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -25314593
   )
   int field1409;
   @ObfuscatedName("x")
   String field1411;

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(Lhi;I)V",
      garbageValue = "-978053700"
   )
   static void method1723(Widget var0) {
      if(var0.loopCycle == Client.field1080) {
         Client.field1112[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "1008017307"
   )
   @Export("toByteArray")
   public static byte[] toByteArray(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var6 = (byte[])((byte[])var0);
         if(var1) {
            int var4 = var6.length;
            byte[] var5 = new byte[var4];
            System.arraycopy(var6, 0, var5, 0, var4);
            return var5;
         } else {
            return var6;
         }
      } else if(var0 instanceof AbstractByteBuffer) {
         AbstractByteBuffer var2 = (AbstractByteBuffer)var0;
         return var2.get();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2106658544"
   )
   static void method1721() {
      if(class93.field1465) {
         class93.field1446 = null;
         class93.field1436 = null;
         class93.field1437 = null;
         class244.field3300 = null;
         class92.field1425 = null;
         class12.logoSprite = null;
         class233.titlemuteSprite = null;
         class47.field601 = null;
         class3.field17 = null;
         WorldMapType2.field534 = null;
         class93.field1466 = null;
         class39.field538 = null;
         CombatInfoListHolder.field1372 = null;
         class44.field590 = null;
         WorldMapData.field473 = null;
         WorldMapType3.field399 = null;
         class93.field1440 = null;
         BaseVarType.field28 = null;
         class93.field1456 = null;
         class228.field3136 = null;
         Ignore.field871 = null;
         class93.field1444 = null;
         class204.field2507 = 1;
         class204.field2502 = null;
         class150.field2205 = -1;
         class153.field2222 = -1;
         class204.field2504 = 0;
         class99.field1532 = false;
         class204.field2505 = 2;
         class43.sendConInfo(true);
         class93.field1465 = false;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1744365321"
   )
   static void method1722() {
      class61.underlayIds = null;
      class61.overlayIds = null;
      class61.overlayPaths = null;
      class61.overlayRotations = null;
      class240.field3259 = null;
      class61.field784 = null;
      WorldMapType2.field530 = null;
      class61.blendedHue = null;
      WorldMapType1.blendedSaturation = null;
      class31.field456 = null;
      Huffman.field2325 = null;
      class51.field661 = null;
   }
}
