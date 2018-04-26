import java.applet.Applet;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class57 {
   @ObfuscatedName("g")
   static Applet field661;
   @ObfuscatedName("e")
   static String field655;

   static {
      field661 = null;
      field655 = "";
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1883584994"
   )
   static void method883() {
      class62.field722 = 99;
      class62.tileUnderlayIds = new byte[4][104][104];
      class21.tileOverlayIds = new byte[4][104][104];
      class62.tileOverlayPath = new byte[4][104][104];
      class62.overlayRotations = new byte[4][104][104];
      BoundingBox3DDrawMode.field271 = new int[4][105][105];
      WorldMapType2.field519 = new byte[4][105][105];
      class297.field3834 = new int[105][105];
      class62.floorHues = new int[104];
      ItemContainer.floorSaturations = new int[104];
      GZipDecompressor.field2501 = new int[104];
      WorldComparator.floorMultiplier = new int[104];
      MapIconReference.field588 = new int[104];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;B)I",
      garbageValue = "-18"
   )
   static final int method879(long var0, String var2) {
      Random var3 = new Random();
      Buffer var4 = new Buffer(128);
      Buffer var5 = new Buffer(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.putByte(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.putInt(var3.nextInt());
      }

      var4.putInt(var6[0]);
      var4.putInt(var6[1]);
      var4.putLong(var0);
      var4.putLong(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.putInt(var3.nextInt());
      }

      var4.encryptRsa(class85.field1300, class85.field1301);
      var5.putByte(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.putInt(var3.nextInt());
      }

      var5.putLong(var3.nextLong());
      var5.method3587(var3.nextLong());
      Tile.method2777(var5);
      var5.putLong(var3.nextLong());
      var5.encryptRsa(class85.field1300, class85.field1301);
      var7 = class95.getLength(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      Buffer var8 = new Buffer(var7);
      var8.putString(var2);
      var8.offset = var7;
      var8.encryptXtea2(var6);
      Buffer var9 = new Buffer(var4.offset + var5.offset + var8.offset + 5);
      var9.putByte(2);
      var9.putByte(var4.offset);
      var9.putBytes(var4.payload, 0, var4.offset);
      var9.putByte(var5.offset);
      var9.putBytes(var5.payload, 0, var5.offset);
      var9.putShort(var8.offset);
      var9.putBytes(var8.payload, 0, var8.offset);
      byte[] var11 = var9.payload;
      String var10 = MessageNode.method1177(var11, 0, var11.length);
      String var12 = var10;

      try {
         URL var13 = new URL(IndexData.method4789("services", false) + "m=accountappeal/login.ws");
         URLConnection var14 = var13.openConnection();
         var14.setDoInput(true);
         var14.setDoOutput(true);
         var14.setConnectTimeout(5000);
         OutputStreamWriter var15 = new OutputStreamWriter(var14.getOutputStream());
         var15.write("data2=" + class160.method3263(var12) + "&dest=" + class160.method3263("passwordchoice.ws"));
         var15.flush();
         InputStream var16 = var14.getInputStream();
         var9 = new Buffer(new byte[1000]);

         do {
            int var17 = var16.read(var9.payload, var9.offset, 1000 - var9.offset);
            if(var17 == -1) {
               var15.close();
               var16.close();
               String var18 = new String(var9.payload);
               if(var18.startsWith("OFFLINE")) {
                  return 4;
               } else if(var18.startsWith("WRONG")) {
                  return 7;
               } else if(var18.startsWith("RELOAD")) {
                  return 3;
               } else if(var18.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var9.decryptXtea(var6);

                  while(var9.offset > 0 && var9.payload[var9.offset - 1] == 0) {
                     --var9.offset;
                  }

                  var18 = new String(var9.payload, 0, var9.offset);
                  if(MapLabel.method374(var18)) {
                     RunException.method3308(var18, true, false);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var9.offset += var17;
         } while(var9.offset < 1000);

         return 5;
      } catch (Throwable var19) {
         var19.printStackTrace();
         return 5;
      }
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-265899426"
   )
   static void method880(int var0, int var1) {
      int var2 = class22.fontBold12.getTextWidth("Choose Option");

      int var3;
      int var4;
      for(var3 = 0; var3 < Client.menuOptionCount; ++var3) {
         var4 = class22.fontBold12.getTextWidth(Huffman.method3524(var3));
         if(var4 > var2) {
            var2 = var4;
         }
      }

      var2 += 8;
      var3 = Client.menuOptionCount * 15 + 22;
      var4 = var0 - var2 / 2;
      if(var4 + var2 > FaceNormal.canvasWidth) {
         var4 = FaceNormal.canvasWidth - var2;
      }

      if(var4 < 0) {
         var4 = 0;
      }

      int var5 = var1;
      if(var1 + var3 > class19.canvasHeight) {
         var5 = class19.canvasHeight - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      Varcs.menuX = var4;
      class90.menuY = var5;
      ISAACCipher.field2620 = var2;
      GameEngine.field685 = Client.menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1988353280"
   )
   static final int method878() {
      return Client.menuOptionCount - 1;
   }
}
