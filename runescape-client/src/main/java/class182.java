import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
public class class182 {
   @ObfuscatedName("a")
   public static final String[][] field2440;
   @ObfuscatedName("j")
   public static final String[] field2436;
   @ObfuscatedName("n")
   public static Calendar field2438;
   @ObfuscatedName("cq")
   @Export("indexTrack1")
   static IndexData indexTrack1;

   static {
      field2440 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2436 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2438 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-1698345436"
   )
   static final void method3428(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = Graphics3D.SINE[var6];
         var12 = Graphics3D.COSINE[var6];
         var13 = var12 * var9 - var5 * var11 >> 16;
         var10 = var11 * var9 + var12 * var5 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = Graphics3D.SINE[var7];
         var12 = Graphics3D.COSINE[var7];
         var13 = var11 * var10 + var12 * var8 >> 16;
         var10 = var12 * var10 - var11 * var8 >> 16;
         var8 = var13;
      }

      class41.cameraX = var0 - var8;
      XItemContainer.cameraZ = var1 - var9;
      class7.cameraY = var2 - var10;
      class8.cameraPitch = var3;
      Friend.cameraYaw = var4;
   }
}
