import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public final class class61 {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static IndexDataBase field714;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   static SpritePixels field715;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   static Widget field713;
   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "[Llq;"
   )
   @Export("mapscene")
   static IndexedSprite[] mapscene;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BZS)Ljava/lang/Object;",
      garbageValue = "174"
   )
   @Export("byteArrayToObject")
   public static Object byteArrayToObject(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !AbstractByteBuffer.directBufferUnavailable) {
            try {
               DirectByteBuffer var2 = new DirectByteBuffer();
               var2.put(var0);
               return var2;
            } catch (Throwable var3) {
               AbstractByteBuffer.directBufferUnavailable = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "14"
   )
   static final void method1058(boolean var0) {
      if(var0) {
         Client.field1041 = class90.field1344?class158.field2150:class158.field2156;
      } else {
         Client.field1041 = class46.preferences.preferences.containsKey(Integer.valueOf(SceneTilePaint.method2873(class90.username)))?class158.field2157:class158.field2153;
      }

   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1863552416"
   )
   static final void method1055(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.widgetCount; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1060[var4] = true;
         }
      }

   }
}
