import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jf")
@Implements("FontName")
public class FontName {
   @ObfuscatedName("ly")
   @ObfuscatedSignature(
      signature = "[Lhq;"
   )
   static Widget[] field3710;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   @Export("FontName_plain11")
   public static final FontName FontName_plain11;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   @Export("FontName_plain12")
   public static final FontName FontName_plain12;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   @Export("FontName_bold12")
   public static final FontName FontName_bold12;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   public static final FontName field3704;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   public static final FontName field3706;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   public static final FontName field3707;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1274856945
   )
   public static int field3711;
   @ObfuscatedName("s")
   final String field3708;
   @ObfuscatedName("b")
   String field3705;

   static {
      FontName_plain11 = new FontName("PLAIN11", "p11_full");
      FontName_plain12 = new FontName("PLAIN12", "p12_full");
      FontName_bold12 = new FontName("BOLD12", "b12_full");
      field3704 = new FontName("VERDANA11", "verdana_11pt_regular");
      field3706 = new FontName("VERDANA13", "verdana_13pt_regular");
      field3707 = new FontName("VERDANA15", "verdana_15pt_regular");
   }

   FontName(String var1, String var2) {
      this.field3708 = var1;
      this.field3705 = var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)[Ljf;",
      garbageValue = "1924756347"
   )
   public static FontName[] method4929() {
      return new FontName[]{field3706, FontName_plain11, FontName_bold12, field3704, FontName_plain12, field3707};
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "-1191790426"
   )
   @Export("initializeGPI")
   static final void initializeGPI(PacketBuffer var0) {
      var0.bitAccess();
      int var1 = Client.localInteractingIndex;
      Player var2 = GrandExchangeOffer.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field842 = var1;
      int var3 = var0.getBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class175.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.getSize() << 6);
      var2.pathY[0] = var6 - GraphicsObject.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.getSize() << 6);
      class7.plane = var2.field856 = var4;
      if(class94.field1404[var1] != null) {
         var2.decodeApperance(class94.field1404[var1]);
      }

      class94.playerIndexesCount = 0;
      class94.playerIndices[++class94.playerIndexesCount - 1] = var1;
      class94.field1402[var1] = 0;
      class94.field1407 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.getBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class94.Players_regions[var7] = (var10 << 14) + var11 + (var9 << 28);
            class94.Players_orientations[var7] = 0;
            class94.Players_targetIndices[var7] = -1;
            class94.field1412[++class94.field1407 - 1] = var7;
            class94.field1402[var7] = 0;
         }
      }

      var0.byteAccess();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "554311311"
   )
   @Export("loadWidget")
   public static boolean loadWidget(int var0) {
      if(class254.validInterfaces[var0]) {
         return true;
      } else if(!Widget.widgetIndex.containsFile(var0)) {
         return false;
      } else {
         int var1 = Widget.widgetIndex.fileCount(var0);
         if(var1 == 0) {
            class254.validInterfaces[var0] = true;
            return true;
         } else {
            if(Widget.widgets[var0] == null) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(Widget.widgets[var0][var2] == null) {
                  byte[] var3 = Widget.widgetIndex.getConfigData(var0, var2);
                  if(var3 != null) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].decodeActive(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].decode(new Buffer(var3));
                     }
                  }
               }
            }

            class254.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static final void method4928() {
      if(UrlRequester.soundSystem1 != null) {
         UrlRequester.soundSystem1.method2078();
      }

      if(Renderable.soundSystem0 != null) {
         Renderable.soundSystem0.method2078();
      }

   }
}
