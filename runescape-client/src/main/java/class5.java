import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public final class class5 {
   @ObfuscatedName("b")
   static byte[][][] field76;
   @ObfuscatedName("bk")
   static class171 field77;
   @ObfuscatedName("f")
   @Export("tileHeights")
   static int[][][] tileHeights = new int[4][105][105];
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1666486451
   )
   static int field79 = 99;
   @ObfuscatedName("m")
   static byte[][][] field80;
   @ObfuscatedName("k")
   static byte[][][] field81;
   @ObfuscatedName("e")
   @Export("tileSettings")
   static byte[][][] tileSettings = new byte[4][104][104];
   @ObfuscatedName("l")
   static int[] field83;
   @ObfuscatedName("a")
   static final int[] field85 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("q")
   static final int[] field86 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("r")
   static final int[] field87 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("w")
   static int[] field88;
   @ObfuscatedName("z")
   static final int[] field89 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("h")
   static int[] field90;
   @ObfuscatedName("y")
   static final int[] field91 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1904120225
   )
   static int field93 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1440510635
   )
   static int field94 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("u")
   public static class175 field95;
   @ObfuscatedName("p")
   static final int[] field98 = new int[]{1, -1, -1, 1};

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-119"
   )
   static final String method63(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class92.method2126('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class92.method2126(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class92.method2126(16776960) + var1 + "</col>");
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-32"
   )
   static final void method76() {
      if(class23.field604 != null) {
         class23.field604.method3010();
         class23.field604 = null;
      }

      BufferProvider.method1746();
      class9.region.method1965();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].method2432();
      }

      System.gc();
      class12.method146(2);
      Client.field517 = -1;
      Client.field470 = false;
      class21.method574();
      KitDefinition.setGameState(10);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BIB)I",
      garbageValue = "-107"
   )
   public static int method78(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var6 + var4] = (byte)var7;
         } else if(var7 == 8364) {
            var3[var4 + var6] = -128;
         } else if(var7 == 8218) {
            var3[var6 + var4] = -126;
         } else if(var7 == 402) {
            var3[var6 + var4] = -125;
         } else if(var7 == 8222) {
            var3[var6 + var4] = -124;
         } else if(var7 == 8230) {
            var3[var6 + var4] = -123;
         } else if(var7 == 8224) {
            var3[var4 + var6] = -122;
         } else if(var7 == 8225) {
            var3[var6 + var4] = -121;
         } else if(var7 == 710) {
            var3[var4 + var6] = -120;
         } else if(var7 == 8240) {
            var3[var6 + var4] = -119;
         } else if(var7 == 352) {
            var3[var6 + var4] = -118;
         } else if(var7 == 8249) {
            var3[var6 + var4] = -117;
         } else if(var7 == 338) {
            var3[var6 + var4] = -116;
         } else if(var7 == 381) {
            var3[var4 + var6] = -114;
         } else if(var7 == 8216) {
            var3[var4 + var6] = -111;
         } else if(var7 == 8217) {
            var3[var6 + var4] = -110;
         } else if(var7 == 8220) {
            var3[var4 + var6] = -109;
         } else if(var7 == 8221) {
            var3[var4 + var6] = -108;
         } else if(var7 == 8226) {
            var3[var4 + var6] = -107;
         } else if(var7 == 8211) {
            var3[var6 + var4] = -106;
         } else if(var7 == 8212) {
            var3[var6 + var4] = -105;
         } else if(var7 == 732) {
            var3[var4 + var6] = -104;
         } else if(var7 == 8482) {
            var3[var4 + var6] = -103;
         } else if(var7 == 353) {
            var3[var6 + var4] = -102;
         } else if(var7 == 8250) {
            var3[var4 + var6] = -101;
         } else if(var7 == 339) {
            var3[var6 + var4] = -100;
         } else if(var7 == 382) {
            var3[var4 + var6] = -98;
         } else if(var7 == 376) {
            var3[var6 + var4] = -97;
         } else {
            var3[var4 + var6] = 63;
         }
      }

      return var5;
   }

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "-1062945014"
   )
   static boolean method79(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class47.method967(var0, RSCanvas.field2188);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(class47.method967(Client.friends[var3].name, RSCanvas.field2188)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class47.method967(class34.localPlayer.name, RSCanvas.field2188))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "1630294043"
   )
   static final boolean method80(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field335 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field305.method3541(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field305.method3542(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field305.method3543(false);
         }

         if(var1 == 325) {
            Client.field305.method3543(true);
         }

         if(var1 == 326) {
            Client.field397.method2768(135);
            Client.field305.method3544(Client.field397);
            return true;
         } else {
            return false;
         }
      }
   }
}
