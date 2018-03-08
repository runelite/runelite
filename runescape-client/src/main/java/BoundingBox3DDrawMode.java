import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("BoundingBox3DDrawMode")
public class BoundingBox3DDrawMode {
   @ObfuscatedName("qt")
   @ObfuscatedSignature(
      signature = "Llp;"
   )
   @Export("platformInfo")
   static MachineInfo platformInfo;
   @ObfuscatedName("pw")
   @ObfuscatedGetter(
      intValue = -1872840801
   )
   static int field251;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   @Export("ON_MOUSEOVER")
   public static final BoundingBox3DDrawMode ON_MOUSEOVER;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   @Export("ALWAYS")
   public static final BoundingBox3DDrawMode ALWAYS;
   @ObfuscatedName("ai")
   protected static String field253;

   static {
      ON_MOUSEOVER = new BoundingBox3DDrawMode();
      ALWAYS = new BoundingBox3DDrawMode();
   }

   @ObfuscatedName("t")
   public static final int method62(double var0, double var2, double var4) {
      double var6 = var4;
      double var8 = var4;
      double var10 = var4;
      if(0.0D != var2) {
         double var12;
         if(var4 < 0.5D) {
            var12 = (var2 + 1.0D) * var4;
         } else {
            var12 = var4 + var2 - var4 * var2;
         }

         double var14 = 2.0D * var4 - var12;
         double var16 = 0.3333333333333333D + var0;
         if(var16 > 1.0D) {
            --var16;
         }

         double var20 = var0 - 0.3333333333333333D;
         if(var20 < 0.0D) {
            ++var20;
         }

         if(var16 * 6.0D < 1.0D) {
            var6 = var14 + (var12 - var14) * 6.0D * var16;
         } else if(var16 * 2.0D < 1.0D) {
            var6 = var12;
         } else if(var16 * 3.0D < 2.0D) {
            var6 = 6.0D * (0.6666666666666666D - var16) * (var12 - var14) + var14;
         } else {
            var6 = var14;
         }

         if(var0 * 6.0D < 1.0D) {
            var8 = var0 * (var12 - var14) * 6.0D + var14;
         } else if(var0 * 2.0D < 1.0D) {
            var8 = var12;
         } else if(var0 * 3.0D < 2.0D) {
            var8 = var14 + (var12 - var14) * (0.6666666666666666D - var0) * 6.0D;
         } else {
            var8 = var14;
         }

         if(var20 * 6.0D < 1.0D) {
            var10 = var14 + var20 * 6.0D * (var12 - var14);
         } else if(var20 * 2.0D < 1.0D) {
            var10 = var12;
         } else if(3.0D * var20 < 2.0D) {
            var10 = (0.6666666666666666D - var20) * (var12 - var14) * 6.0D + var14;
         } else {
            var10 = var14;
         }
      }

      int var22 = (int)(256.0D * var6);
      int var13 = (int)(256.0D * var8);
      int var23 = (int)(256.0D * var10);
      int var15 = var23 + (var13 << 8) + (var22 << 16);
      return var15;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-48436272"
   )
   static long method58() {
      try {
         URL var0 = new URL(ClanMember.method5226("services", false) + "m=accountappeal/login.ws");
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "54"
   )
   static int method63(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1917578550"
   )
   static int method60(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var2 == null) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.stackSizes.length; ++var4) {
            if(var2.itemIds[var4] == var1) {
               var3 += var2.stackSizes[var4];
            }
         }

         return var3;
      }
   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(Lbw;I)V",
      garbageValue = "-2094794601"
   )
   static final void method61(Actor var0) {
      int var1 = var0.field1183 - Client.gameCycle;
      int var2 = var0.field1159 * 128 + var0.field1139 * 64;
      int var3 = var0.field1181 * 128 + var0.field1139 * 64;
      var0.x += (var2 - var0.x) / var1;
      var0.y += (var3 - var0.y) / var1;
      var0.field1195 = 0;
      var0.orientation = var0.field1185;
   }

   @ObfuscatedName("kk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1504278871"
   )
   static void method59() {
      Client.field1072.method2073(class33.method382(ClientPacket.field2389, Client.field1072.field1456));
      Client.field923 = 0;
   }
}
