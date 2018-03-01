import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
@Implements("SoundTaskDataProvider")
public class SoundTaskDataProvider implements class101 {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "[Lde;"
   )
   @Export("idxFiles")
   public static CacheFile[] idxFiles;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lay;"
   )
   @Export("scriptMapIconReference")
   static MapIconReference scriptMapIconReference;
   @ObfuscatedName("ei")
   @ObfuscatedSignature(
      signature = "Lkw;"
   )
   @Export("font_p12full")
   static Font font_p12full;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Ldg;",
      garbageValue = "2126620152"
   )
   public AbstractSoundSystem vmethod2149() {
      return new SourceDataSoundSystem();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1485152806"
   )
   @Export("adjustHSLListness0")
   static final int adjustHSLListness0(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }

   @ObfuscatedName("eo")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "494264573"
   )
   static final void method781() {
      if(Client.field886 > 0) {
         GrandExchangeEvents.method80();
      } else {
         Client.field1077.method5343();
         Enum.setGameState(40);
         VertexNormal.field1912 = Client.field899.getSocket();
         Client.field899.method2083();
      }
   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "302029890"
   )
   static final void method783(String var0, boolean var1) {
      if(Client.field965) {
         byte var2 = 4;
         int var3 = var2 + 6;
         int var4 = var2 + 6;
         int var5 = font_p12full.method5660(var0, 250);
         int var6 = font_p12full.method5613(var0, 250) * 13;
         Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2, 0);
         Rasterizer2D.drawRectangle(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2, 16777215);
         font_p12full.method5627(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
         class149.method3192(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2);
         if(var1) {
            class20.rasterProvider.drawFull(0, 0);
         } else {
            LoginPacket.method3483(var3, var4, var5, var6);
         }

      }
   }

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-1721515276"
   )
   static void method784(Buffer var0, int var1) {
      World.method1688(var0.payload, var1);
      if(class167.randomDat != null) {
         try {
            class167.randomDat.seek(0L);
            class167.randomDat.write(var0.payload, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }
}
