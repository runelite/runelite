import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public enum class150 implements Enumerated {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   field2111(0, 0),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   field2106(2, 1),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   field2107(1, 2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   field2108(3, 3);

   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = 1621142415
   )
   @Export("port2")
   static int port2;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 810031425
   )
   public final int field2109;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1493067457
   )
   final int field2105;

   class150(int var3, int var4) {
      this.field2109 = var3;
      this.field2105 = var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2130441585"
   )
   public int rsOrdinal() {
      return this.field2105;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "105"
   )
   static long method2992() {
      try {
         URL var0 = new URL(Actor.method1573("services", false) + "m=accountappeal/login.ws");
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
               long var7 = var4.readLong();
               return var7;
            }

            var4.offset += var5;
         } while(var4.offset < 1000);

         return 0L;
      } catch (Exception var9) {
         return 0L;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)Ljy;",
      garbageValue = "0"
   )
   @Export("getOverlayDefinition")
   public static Overlay getOverlayDefinition(int var0) {
      Overlay var1 = (Overlay)Overlay.overlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Overlay.overlay_ref.getConfigData(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         Overlay.overlays.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)[Lid;",
      garbageValue = "-197419366"
   )
   public static JagexGame[] method2990() {
      return new JagexGame[]{JagexGame.field3290, JagexGame.field3292, JagexGame.field3293, JagexGame.field3289, JagexGame.field3294, JagexGame.field3291};
   }
}
