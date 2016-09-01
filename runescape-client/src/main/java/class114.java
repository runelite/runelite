import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.URI;
import java.net.URL;
import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
public class class114 {
   @ObfuscatedName("q")
   public static boolean field2011;
   @ObfuscatedName("r")
   public static final String[] field2012 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("j")
   public static Calendar field2013;
   @ObfuscatedName("x")
   public static final String[][] field2015 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
   @ObfuscatedName("bu")
   static class171 field2017;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "-622223365"
   )
   public static void method2482(String var0, boolean var1, boolean var2) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var4) {
               ;
            }
         }

         if(class141.field2184.startsWith("win")) {
            class40.method770(var0, 0, "openjs");
         } else if(class141.field2184.startsWith("mac")) {
            class40.method770(var0, 1, "openjs");
         } else {
            class40.method770(var0, 2, "openjs");
         }
      } else {
         class40.method770(var0, 3, "openjs");
      }

   }

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2013 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "-333195570"
   )
   public static boolean method2483(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1745621337"
   )
   public static int method2484(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-428633542"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(class173.worldServersDownload == null) {
            class173.worldServersDownload = new class18(class127.field2086, new URL(ChatMessages.field278));
         } else {
            byte[] var0 = class173.worldServersDownload.method197();
            if(var0 != null) {
               Buffer var1 = new Buffer(var0);
               World.field646 = var1.method2551();
               class35.worldList = new World[World.field646];

               World var3;
               for(int var2 = 0; var2 < World.field646; var3.index = var2++) {
                  var3 = class35.worldList[var2] = new World();
                  var3.id = var1.method2551();
                  var3.mask = var1.method2561();
                  var3.address = var1.method2774();
                  var3.activity = var1.method2774();
                  var3.location = var1.method2556();
                  var3.playerCount = var1.method2759();
               }

               class116.method2498(class35.worldList, 0, class35.worldList.length - 1, World.field649, World.field652);
               class173.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class173.worldServersDownload = null;
      }

      return false;
   }
}
