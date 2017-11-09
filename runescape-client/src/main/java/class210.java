import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
public class class210 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field2600;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field2597;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public static class211 field2596;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 497449019
   )
   public static int field2594;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1260621381
   )
   public static int field2598;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -363515367
   )
   public static int field2599;
   @ObfuscatedName("c")
   public static boolean field2595;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   public static Track1 field2601;

   static {
      field2594 = 0;
   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1575455560"
   )
   static final void method3852() {
      int var0 = class48.localPlayer.x;
      int var1 = class48.localPlayer.y;
      if(WorldMapType3.field375 - var0 < -500 || WorldMapType3.field375 - var0 > 500 || class34.field465 - var1 < -500 || class34.field465 - var1 > 500) {
         WorldMapType3.field375 = var0;
         class34.field465 = var1;
      }

      if(var0 != WorldMapType3.field375) {
         WorldMapType3.field375 += (var0 - WorldMapType3.field375) / 16;
      }

      if(var1 != class34.field465) {
         class34.field465 += (var1 - class34.field465) / 16;
      }

      int var2;
      int var3;
      if(MouseInput.field706 == 4 && Item.field1399) {
         var2 = MouseInput.field708 - Client.field1019;
         Client.field1077 = var2 * 2;
         Client.field1019 = var2 != -1 && var2 != 1?(MouseInput.field708 + Client.field1019) / 2:MouseInput.field708;
         var3 = Client.field936 - MouseInput.field704;
         Client.field934 = var3 * 2;
         Client.field936 = var3 != -1 && var3 != 1?(Client.field936 + MouseInput.field704) / 2:MouseInput.field704;
      } else {
         if(KeyFocusListener.field618[96]) {
            Client.field934 += (-24 - Client.field934) / 2;
         } else if(KeyFocusListener.field618[97]) {
            Client.field934 += (24 - Client.field934) / 2;
         } else {
            Client.field934 /= 2;
         }

         if(KeyFocusListener.field618[98]) {
            Client.field1077 += (12 - Client.field1077) / 2;
         } else if(KeyFocusListener.field618[99]) {
            Client.field1077 += (-12 - Client.field1077) / 2;
         } else {
            Client.field1077 /= 2;
         }

         Client.field1019 = MouseInput.field708;
         Client.field936 = MouseInput.field704;
      }

      Client.mapAngle = Client.field934 / 2 + Client.mapAngle & 2047;
      Client.field932 += Client.field1077 / 2;
      if(Client.field932 < 128) {
         Client.field932 = 128;
      }

      if(Client.field932 > 383) {
         Client.field932 = 383;
      }

      var2 = WorldMapType3.field375 >> 7;
      var3 = class34.field465 >> 7;
      int var4 = class70.getTileHeight(WorldMapType3.field375, class34.field465, Ignore.plane);
      int var5 = 0;
      int var6;
      if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
         for(var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
            for(int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
               int var8 = Ignore.plane;
               if(var8 < 3 && (class61.tileSettings[1][var6][var7] & 2) == 2) {
                  ++var8;
               }

               int var9 = var4 - class61.tileHeights[var8][var6][var7];
               if(var9 > var5) {
                  var5 = var9;
               }
            }
         }
      }

      var6 = var5 * 192;
      if(var6 > 98048) {
         var6 = 98048;
      }

      if(var6 < 32768) {
         var6 = 32768;
      }

      if(var6 > Client.field1102) {
         Client.field1102 += (var6 - Client.field1102) / 24;
      } else if(var6 < Client.field1102) {
         Client.field1102 += (var6 - Client.field1102) / 80;
      }

   }
}
