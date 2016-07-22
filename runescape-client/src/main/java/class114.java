import java.io.File;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
public class class114 {
   @ObfuscatedName("nq")
   @ObfuscatedGetter(
      intValue = 711383581
   )
   static int field2006;
   @ObfuscatedName("w")
   public static final String[] field2007 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("e")
   public static Calendar field2008;
   @ObfuscatedName("m")
   public static final String[][] field2009 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
   @ObfuscatedName("hg")
   @Export("localPlayer")
   static class2 field2010;

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2008 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "87"
   )
   static final int method2489(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return (var2 * (var1 & '\uff00') + var3 * (var0 & '\uff00') & 16711680) + ((var0 & 16711935) * var3 + var2 * (var1 & 16711935) & -16711936) >> 8;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZB)Z",
      garbageValue = "79"
   )
   public static boolean method2490(File var0, boolean var1) {
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
}
