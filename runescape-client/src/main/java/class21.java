import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class21 {
   @ObfuscatedName("q")
   @Export("javaVersion")
   public static String javaVersion;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Ljv;",
      garbageValue = "494655905"
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgu;I)V",
      garbageValue = "1081056255"
   )
   static final void method173(PacketBuffer var0) {
      for(int var1 = 0; var1 < class92.field1382; ++var1) {
         int var2 = class92.field1370[var1];
         Player var3 = Client.cachedPlayers[var2];
         int var4 = var0.readUnsignedByte();
         if((var4 & 1) != 0) {
            var4 += var0.readUnsignedByte() << 8;
         }

         Varcs.method1981(var0, var2, var3, var4);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "325118557"
   )
   static int method170(int var0, int var1, int var2) {
      return (class61.tileSettings[var0][var1][var2] & 8) != 0?0:(var0 > 0 && (class61.tileSettings[1][var1][var2] & 2) != 0?var0 - 1:var0);
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIS)V",
      garbageValue = "-1121"
   )
   @Export("addMenuEntry")
   @Hook("addMenuEntry")
   public static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      boolean var12 = false;
      if(!Client.isMenuOpen && Client.menuOptionCount < 500) {
         Client.menuOptions[Client.menuOptionCount] = var0;
         Client.menuTargets[Client.menuOptionCount] = var1;
         Client.menuTypes[Client.menuOptionCount] = var2;
         Client.menuIdentifiers[Client.menuOptionCount] = var3;
         Client.menuActionParams0[Client.menuOptionCount] = var4;
         Client.menuActionParams1[Client.menuOptionCount] = var5;
         Client.menuBooleanArray[Client.menuOptionCount] = var12;
         ++Client.menuOptionCount;
      }

   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "(IIIILlm;Lhq;B)V",
      garbageValue = "1"
   )
   @Export("drawDot")
   static final void drawDot(int var0, int var1, int var2, int var3, SpritePixels var4, class230 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = Graphics3D.SINE[var6];
            int var9 = Graphics3D.COSINE[var6];
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method5820(var10 + var5.field2732 / 2 - var4.maxWidth / 2, var5.field2730 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2732, var5.field2730, var5.field2733, var5.field2731);
            } else {
               var4.drawAt(var0 + var10 + var5.field2732 / 2 - var4.maxWidth / 2, var5.field2730 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }

   @ObfuscatedName("kr")
   @ObfuscatedSignature(
      signature = "([BIB)V",
      garbageValue = "-120"
   )
   static void method171(byte[] var0, int var1) {
      if(Client.field857 == null) {
         Client.field857 = new byte[24];
      }

      class203.method3896(var0, var1, Client.field857, 0, 24);
   }
}
