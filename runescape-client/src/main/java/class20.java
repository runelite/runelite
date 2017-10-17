import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class20 {
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = -831017185
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("ej")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   @Export("font_p12full")
   static Font font_p12full;
   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "[Lkr;"
   )
   static SpritePixels[] field335;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;I)V",
      garbageValue = "-179074001"
   )
   static void method148(File var0, File var1) {
      try {
         FileOnDisk var2 = new FileOnDisk(class155.field2255, "rw", 10000L);
         Buffer var3 = new Buffer(500);
         var3.putByte(3);
         var3.putByte(var1 != null?1:0);
         var3.putCESU8(var0.getPath());
         if(var1 != null) {
            var3.putCESU8("");
         }

         var2.write(var3.payload, 0, var3.offset);
         var2.close();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-3"
   )
   static final String method147(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class60.getColTags(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class60.getColTags(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class60.getColTags(16776960) + var1 + "</col>");
   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1100824678"
   )
   static final void method146(int var0, int var1) {
      if(Client.field938 == 2) {
         KeyFocusListener.method787((Client.hintArrowX - WallObject.baseX << 7) + Client.field944, (Client.hintArrowY - Varcs.baseY << 7) + Client.field945, Client.hintArrowType * 2);
         if(Client.screenY > -1 && Client.gameCycle % 20 < 10) {
            class28.pkIcons[0].method5172(var0 + Client.screenY - 12, Client.screenX + var1 - 28);
         }

      }
   }
}
