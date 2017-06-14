import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
public class class211 {
   @ObfuscatedName("h")
   public static short[] field2611;
   @ObfuscatedName("p")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("i")
   @Export("widgetSettings")
   public static int[] widgetSettings;
   @ObfuscatedName("n")
   public static int[] field2615;

   static {
      field2615 = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2615[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "133792559"
   )
   public static final void method3948() {
      while(true) {
         class9 var0 = (class9)class7.field236.method3570();
         if(var0 == null) {
            return;
         }

         var0.vmethod62();
      }
   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-383040511"
   )
   static final void method3949(Widget var0, int var1, int var2) {
      if(Client.field1016 == 0 || Client.field1016 == 3) {
         if(class59.field713 == 1 || !ItemLayer.field1798 && class59.field713 == 4) {
            class210 var3 = var0.method4053(true);
            if(var3 == null) {
               return;
            }

            int var4 = class59.field723 - var1;
            int var5 = class59.field724 - var2;
            if(var3.method3943(var4, var5)) {
               var4 -= var3.field2610 / 2;
               var5 -= var3.field2605 / 2;
               int var6 = Client.mapScale + Client.mapAngle & 2047;
               int var7 = class136.SINE[var6];
               int var8 = class136.COSINE[var6];
               var7 = var7 * (Client.mapScaleDelta + 256) >> 8;
               var8 = var8 * (Client.mapScaleDelta + 256) >> 8;
               int var9 = var8 * var4 + var5 * var7 >> 11;
               int var10 = var8 * var5 - var4 * var7 >> 11;
               int var11 = class168.localPlayer.x + var9 >> 7;
               int var12 = class168.localPlayer.y - var10 >> 7;
               Client.secretPacketBuffer1.putOpcode(224);
               Client.secretPacketBuffer1.putByte(18);
               Client.secretPacketBuffer1.method3192(var11 + class61.baseX);
               Client.secretPacketBuffer1.method3192(class23.baseY + var12);
               Client.secretPacketBuffer1.method3183(class50.field624[82]?(class50.field624[81]?2:1):0);
               Client.secretPacketBuffer1.putByte(var4);
               Client.secretPacketBuffer1.putByte(var5);
               Client.secretPacketBuffer1.putShort(Client.mapAngle);
               Client.secretPacketBuffer1.putByte(57);
               Client.secretPacketBuffer1.putByte(Client.mapScale);
               Client.secretPacketBuffer1.putByte(Client.mapScaleDelta);
               Client.secretPacketBuffer1.putByte(89);
               Client.secretPacketBuffer1.putShort(class168.localPlayer.x);
               Client.secretPacketBuffer1.putShort(class168.localPlayer.y);
               Client.secretPacketBuffer1.putByte(63);
               Client.detinationX = var11;
               Client.destinationY = var12;
            }
         }

      }
   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1274649186"
   )
   static final void method3950(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (Client.field1057 - Client.field1169) * var5 / 100 + Client.field1169;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field1175) {
         var15 = Client.field1175;
         var6 = var2 * var15 * 334 / (var3 * 512);
         if(var6 > Client.field1192) {
            var6 = Client.field1192;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.method4960();
               Rasterizer2D.method5040(var0, var1, var9, var3, -16777216);
               Rasterizer2D.method5040(var2 + var0 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field975) {
         var15 = Client.field975;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field1173) {
            var6 = Client.field1173;
            var8 = var2 * var15 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.method4960();
               Rasterizer2D.method5040(var0, var1, var2, var9, -16777216);
               Rasterizer2D.method5040(var0, var1 + var3 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = Client.field1037 + var5 * (Client.field1172 - Client.field1037) / 100;
      Client.scale = var8 * var3 * var6 / 85504 << 1;
      if(Client.viewportHeight != var2 || var3 != Client.viewportWidth) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 128 + 15;
            int var12 = var11 * 3 + 600;
            int var13 = class136.SINE[var11];
            var14[var10] = var12 * var13 >> 16;
         }

         Region.method2710(var14, 500, 800, var2, var3);
      }

      Client.field1177 = var0;
      Client.field1150 = var1;
      Client.viewportHeight = var2;
      Client.viewportWidth = var3;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LModel;II)V",
      garbageValue = "111999441"
   )
   public static final void method3951(Model var0, int var1) {
      for(int var2 = 0; var2 < var0.field1939; ++var2) {
         if(var0.field1947[var2] != -2) {
            int var3 = var0.indices1[var2];
            int var4 = var0.indices2[var2];
            int var5 = var0.indices3[var2];
            int var6 = Model.field1972[var3];
            int var7 = Model.field1972[var4];
            int var8 = Model.field1972[var5];
            SceneTilePaint.method2671(Model.field1973[var3], Model.field1973[var4], Model.field1973[var5], var6, var7, var8, var1);
         }
      }

   }
}
