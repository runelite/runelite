import java.applet.Applet;
import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
public class class152 extends RuntimeException {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1710656243
   )
   @Export("revision")
   public static int revision;
   @ObfuscatedName("a")
   public static Applet field2213;
   @ObfuscatedName("j")
   public static String field2208;
   @ObfuscatedName("r")
   String field2207;
   @ObfuscatedName("v")
   Throwable field2211;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)Ldk;",
      garbageValue = "-127441284"
   )
   @Export("getPreferencesFile")
   public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(class155.field2243, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(WorldMapType2.field512 == 33) {
         var4 = "_rc";
      } else if(WorldMapType2.field512 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class66.userHome, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-297500112"
   )
   public static int method2922(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "502301824"
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1024443705"
   )
   public static void method2917() {
      Object var0 = class236.field3231;
      synchronized(class236.field3231) {
         if(class236.field3233 != 0) {
            class236.field3233 = 1;

            try {
               class236.field3231.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-224244370"
   )
   static final void method2924() {
      if(!class134.field1990) {
         int var0 = Region.pitchSin;
         int var1 = Region.pitchCos;
         int var2 = Region.yawSin;
         int var3 = Region.yawCos;
         byte var4 = 50;
         short var5 = 3500;
         int var6 = (class134.field1991 - Graphics3D.centerX) * var4 / Graphics3D.field2026;
         int var7 = (class134.field1996 - Graphics3D.centerY) * var4 / Graphics3D.field2026;
         int var8 = (class134.field1991 - Graphics3D.centerX) * var5 / Graphics3D.field2026;
         int var9 = (class134.field1996 - Graphics3D.centerY) * var5 / Graphics3D.field2026;
         int var10 = Graphics3D.method2606(var7, var4, var1, var0);
         int var11 = Graphics3D.method2616(var7, var4, var1, var0);
         var7 = var10;
         var10 = Graphics3D.method2606(var9, var5, var1, var0);
         int var12 = Graphics3D.method2616(var9, var5, var1, var0);
         var9 = var10;
         var10 = Graphics3D.method2595(var6, var11, var3, var2);
         var11 = Graphics3D.method2622(var6, var11, var3, var2);
         var6 = var10;
         var10 = Graphics3D.method2595(var8, var12, var3, var2);
         var12 = Graphics3D.method2622(var8, var12, var3, var2);
         class134.field1987 = (var6 + var10) / 2;
         class134.field1992 = (var7 + var9) / 2;
         class18.field322 = (var12 + var11) / 2;
         FileRequest.field3207 = (var10 - var6) / 2;
         class60.field737 = (var9 - var7) / 2;
         class181.field2435 = (var12 - var11) / 2;
         FileOnDisk.field1754 = Math.abs(FileRequest.field3207);
         class134.field1993 = Math.abs(class60.field737);
         class134.field1994 = Math.abs(class181.field2435);
      }
   }
}
