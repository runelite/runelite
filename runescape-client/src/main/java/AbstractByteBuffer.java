import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
@Implements("AbstractByteBuffer")
public abstract class AbstractByteBuffer {
   @ObfuscatedName("i")
   @Export("directBufferUnavailable")
   static boolean directBufferUnavailable;

   static {
      directBufferUnavailable = false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "111437251"
   )
   @Export("get")
   abstract byte[] get();

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "71"
   )
   @Export("put")
   abstract void put(byte[] var1);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lbq;I)V",
      garbageValue = "606746769"
   )
   public static void method3757(ScriptEvent var0) {
      class23.runScript(var0, 500000);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lla;IIII)V",
      garbageValue = "1738352953"
   )
   static void method3773(SpritePixels var0, int var1, int var2, int var3) {
      class213 var4 = WorldMapRegion.field470;
      long var6 = (long)(var3 << 16 | var1 << 8 | var2);
      var4.method3943(var0, var6, var0.pixels.length * 4);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "-1232797607"
   )
   @Export("encodeStringCp1252")
   public static int encodeStringCp1252(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var6 + var4] = (byte)var7;
         } else if(var7 == 8364) {
            var3[var6 + var4] = -128;
         } else if(var7 == 8218) {
            var3[var6 + var4] = -126;
         } else if(var7 == 402) {
            var3[var6 + var4] = -125;
         } else if(var7 == 8222) {
            var3[var6 + var4] = -124;
         } else if(var7 == 8230) {
            var3[var6 + var4] = -123;
         } else if(var7 == 8224) {
            var3[var6 + var4] = -122;
         } else if(var7 == 8225) {
            var3[var6 + var4] = -121;
         } else if(var7 == 710) {
            var3[var6 + var4] = -120;
         } else if(var7 == 8240) {
            var3[var6 + var4] = -119;
         } else if(var7 == 352) {
            var3[var6 + var4] = -118;
         } else if(var7 == 8249) {
            var3[var6 + var4] = -117;
         } else if(var7 == 338) {
            var3[var6 + var4] = -116;
         } else if(var7 == 381) {
            var3[var6 + var4] = -114;
         } else if(var7 == 8216) {
            var3[var6 + var4] = -111;
         } else if(var7 == 8217) {
            var3[var6 + var4] = -110;
         } else if(var7 == 8220) {
            var3[var6 + var4] = -109;
         } else if(var7 == 8221) {
            var3[var6 + var4] = -108;
         } else if(var7 == 8226) {
            var3[var6 + var4] = -107;
         } else if(var7 == 8211) {
            var3[var6 + var4] = -106;
         } else if(var7 == 8212) {
            var3[var6 + var4] = -105;
         } else if(var7 == 732) {
            var3[var6 + var4] = -104;
         } else if(var7 == 8482) {
            var3[var6 + var4] = -103;
         } else if(var7 == 353) {
            var3[var6 + var4] = -102;
         } else if(var7 == 8250) {
            var3[var6 + var4] = -101;
         } else if(var7 == 339) {
            var3[var6 + var4] = -100;
         } else if(var7 == 382) {
            var3[var6 + var4] = -98;
         } else if(var7 == 376) {
            var3[var6 + var4] = -97;
         } else {
            var3[var6 + var4] = 63;
         }
      }

      return var5;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-516218991"
   )
   static void method3767(boolean var0) {
      class90.loginMessage1 = "";
      class90.loginMessage2 = "Enter your username/email & password.";
      class90.loginMessage3 = "";
      class90.loginIndex = 2;
      if(var0) {
         class90.password = "";
      }

      if(class90.username == null || class90.username.length() <= 0) {
         if(class46.preferences.rememberedUsername != null) {
            class90.username = class46.preferences.rememberedUsername;
            class90.Login_isUsernameRemembered = true;
         } else {
            class90.Login_isUsernameRemembered = false;
         }
      }

      class25.method200();
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "766674059"
   )
   static final int method3756() {
      if(class46.preferences.hideRoofs) {
         return class237.plane;
      } else {
         int var0 = class5.getTileHeight(Sequence.cameraX, ChatLineBuffer.cameraY, class237.plane);
         return var0 - Area.cameraZ < 800 && (class62.tileSettings[class237.plane][Sequence.cameraX >> 7][ChatLineBuffer.cameraY >> 7] & 4) != 0?class237.plane:3;
      }
   }
}
