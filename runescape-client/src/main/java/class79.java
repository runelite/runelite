import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
public class class79 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1292291641
   )
   static int field1436;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1130639969
   )
   static int field1437;
   @ObfuscatedName("v")
   static int[] field1438;
   @ObfuscatedName("j")
   static int[] field1439;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1675681209
   )
   static int field1441;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = -506869801
   )
   @Export("cameraX")
   static int cameraX;

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-43"
   )
   static void method1694(int var0, int var1, int var2, int var3) {
      Widget var4 = class162.method3195(var0, var1);
      if(null != var4 && null != var4.field2914) {
         class0 var5 = new class0();
         var5.field11 = var4;
         var5.field0 = var4.field2914;
         SecondaryBufferProvider.method1661(var5);
      }

      Client.field299 = var3;
      Client.field435 = true;
      class85.field1490 = var0;
      Client.field436 = var1;
      class145.field2220 = var2;
      class166.method3253(var4);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "-7942"
   )
   static int method1716(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method3828((long)var0);
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;B)V",
      garbageValue = "16"
   )
   static void method1717(File var0) {
      class222.field3217 = var0;
      if(!class222.field3217.exists()) {
         throw new RuntimeException("");
      } else {
         class138.field2141 = true;
      }
   }
}
