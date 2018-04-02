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
@Implements("MapLabel")
public class MapLabel {
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = 1665951815
   )
   static int field451;
   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexScripts")
   static IndexData indexScripts;
   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   @Export("mapedge")
   static SpritePixels mapedge;
   @ObfuscatedName("c")
   @Export("text")
   String text;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -767310791
   )
   int field446;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1470146063
   )
   int field452;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ly;"
   )
   @Export("fontSize")
   Size fontSize;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IILy;)V"
   )
   MapLabel(String var1, int var2, int var3, Size var4) {
      this.text = var1;
      this.field446 = var2;
      this.field452 = var3;
      this.fontSize = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljm;Ljm;B)I",
      garbageValue = "-13"
   )
   static int method388(IndexDataBase var0, IndexDataBase var1) {
      int var2 = 0;
      if(var0.tryLoadRecordByNames("title.jpg", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("logo", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("titlebox", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("titlebutton", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("runes", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("title_mute", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("options_radio_buttons,0", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("options_radio_buttons,2", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("options_radio_buttons,4", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("options_radio_buttons,6", "")) {
         ++var2;
      }

      var1.tryLoadRecordByNames("sl_back", "");
      var1.tryLoadRecordByNames("sl_flags", "");
      var1.tryLoadRecordByNames("sl_arrows", "");
      var1.tryLoadRecordByNames("sl_stars", "");
      var1.tryLoadRecordByNames("sl_button", "");
      return var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "1"
   )
   static long method387() {
      try {
         URL var0 = new URL(ClientPacket.method3421("services", false) + "m=accountappeal/login.ws");
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
}
