import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class193 {
   @ObfuscatedName("p")
   public static final String[][] field2534;
   @ObfuscatedName("i")
   public static final String[] field2533;
   @ObfuscatedName("w")
   public static Calendar field2532;

   static {
      field2534 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2533 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2532 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1884491476"
   )
   static final void method3702(int var0, int var1, int var2, int var3, int var4) {
      class79.scrollbarSprites[0].method5504(var0, var1);
      class79.scrollbarSprites[1].method5504(var0, var3 + var1 - 16);
      Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1 + 16, 16, var3 - 32, Client.field885);
      int var5 = var3 * (var3 - 32) / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
      Rasterizer2D.Rasterizer2D_fillRectangle(var0, var6 + var1 + 16, 16, var5, Client.field884);
      Rasterizer2D.method5464(var0, var6 + var1 + 16, var5, Client.field886);
      Rasterizer2D.method5464(var0 + 1, var6 + var1 + 16, var5, Client.field886);
      Rasterizer2D.method5410(var0, var6 + var1 + 16, 16, Client.field886);
      Rasterizer2D.method5410(var0, var6 + var1 + 17, 16, Client.field886);
      Rasterizer2D.method5464(var0 + 15, var6 + var1 + 16, var5, Client.field925);
      Rasterizer2D.method5464(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field925);
      Rasterizer2D.method5410(var0, var6 + var5 + var1 + 15, 16, Client.field925);
      Rasterizer2D.method5410(var0 + 1, var5 + var6 + var1 + 14, 15, Client.field925);
   }
}
