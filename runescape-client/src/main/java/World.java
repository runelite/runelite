import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("World")
public class World {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1897151511
   )
   @Export("id")
   int id;
   @ObfuscatedName("u")
   @Export("activity")
   String activity;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -64035187
   )
   static int field668 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1716549741
   )
   @Export("index")
   int index;
   @ObfuscatedName("s")
   static int[] field670 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("o")
   static int[] field671 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1049377089
   )
   static int field673 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 427144867
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("r")
   @Export("address")
   String address;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1296405457
   )
   @Export("location")
   int location;
   @ObfuscatedName("ey")
   static SpritePixels[] field678;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -60972233
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = -1636305433
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("a")
   public static short[][] field683;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "428141129"
   )
   boolean method609() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "263158288"
   )
   public static String method610(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class203.field3069[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1926545597"
   )
   boolean method611() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1003055120"
   )
   boolean method612() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "74"
   )
   boolean method613() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2070656754"
   )
   boolean method627() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass159;B)V",
      garbageValue = "1"
   )
   static final void method628(class159 var0) {
      var0.method3054();
      int var1 = Client.localInteractingIndex;
      Player var2 = class16.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field260 = var1;
      int var3 = var0.method3061(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - Projectile.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.method221() << 6);
      var2.pathY[0] = var6 - class3.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.method221() << 6);
      WallObject.plane = var2.field259 = var4;
      if(null != class45.field897[var1]) {
         var2.method220(class45.field897[var1]);
      }

      class45.field898 = 0;
      class45.field895[++class45.field898 - 1] = var1;
      class45.field908[var1] = 0;
      class45.field900 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.method3061(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class45.field902[var7] = (var10 << 14) + (var9 << 28) + var11;
            class45.field903[var7] = 0;
            class45.field904[var7] = -1;
            class45.field905[++class45.field900 - 1] = var7;
            class45.field908[var7] = 0;
         }
      }

      var0.method3043();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "957772771"
   )
   boolean method651() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "33"
   )
   static long method652() {
      try {
         URL var0 = new URL(MessageNode.method203("services", false) + "m=accountappeal/login.ws");
         URLConnection var1 = var0.openConnection();
         var1.setRequestProperty("connection", "close");
         var1.setDoInput(true);
         var1.setDoOutput(true);
         var1.setConnectTimeout(5000);
         OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
         var2.write("data1=req");
         var2.flush();
         InputStream var3 = var1.getInputStream();
         Buffer var4 = new Buffer(new byte[1000]);

         do {
            int var5 = var3.read(var4.payload, var4.offset, 1000 - var4.offset);
            if(var5 == -1) {
               var4.offset = 0;
               long var7 = var4.method2820();
               return var7;
            }

            var4.offset += var5;
         } while(var4.offset < 1000);

         return 0L;
      } catch (Exception var9) {
         return 0L;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "-854742745"
   )
   public static Object method653(byte[] var0, boolean var1) {
      if(null == var0) {
         return null;
      } else {
         if(var0.length > 136 && !class156.field2113) {
            try {
               class151 var2 = new class151();
               var2.vmethod3014(var0);
               return var2;
            } catch (Throwable var3) {
               class156.field2113 = true;
            }
         }

         return var0;
      }
   }
}
