import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class162 {
   @ObfuscatedName("p")
   public static final String[][] field2145 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
   @ObfuscatedName("x")
   public static Calendar field2146;
   @ObfuscatedName("g")
   public static final String[] field2148 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2146 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   class162() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(LActor;B)V",
      garbageValue = "1"
   )
   static final void method3080(Actor var0) {
      int var1 = var0.field652 - Client.gameCycle;
      int var2 = var0.field596 * 64 + var0.field634 * 128;
      int var3 = var0.field636 * 128 + var0.field596 * 64;
      var0.x += (var2 - var0.x) / var1;
      var0.y += (var3 - var0.y) / var1;
      var0.field627 = 0;
      var0.field643 = var0.field592;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1237057038"
   )
   static final void method3081(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class65.method1153(var0, var1, WallObject.plane) - var2;
         var0 -= GameEngine.cameraX;
         var3 -= class40.cameraZ;
         var1 -= class149.cameraY;
         int var4 = class84.field1438[class13.cameraPitch];
         int var5 = class84.field1452[class13.cameraPitch];
         int var6 = class84.field1438[World.cameraYaw];
         int var7 = class84.field1452[World.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var7 * var1 - var6 * var0 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var1 * var4 >> 16;
         var1 = var5 * var1 + var4 * var3 >> 16;
         if(var1 >= 50) {
            Client.field398 = Client.scale * var0 / var1 + Client.camera2 / 2;
            Client.field317 = var8 * Client.scale / var1 + Client.camera3 / 2;
         } else {
            Client.field398 = -1;
            Client.field317 = -1;
         }

      } else {
         Client.field398 = -1;
         Client.field317 = -1;
      }
   }
}
