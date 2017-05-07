import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class45 {
   @ObfuscatedName("l")
   static int[] field886;
   @ObfuscatedName("n")
   static byte[] field888;
   @ObfuscatedName("q")
   static byte[] field889;
   @ObfuscatedName("t")
   static Buffer[] field890;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1877472863
   )
   static int field891;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1976076969
   )
   static int field893;
   @ObfuscatedName("u")
   static int[] field894;
   @ObfuscatedName("v")
   static int[] field895;
   @ObfuscatedName("pi")
   public static class103 field896;
   @ObfuscatedName("w")
   static int[] field897;
   @ObfuscatedName("s")
   static int[] field899;
   @ObfuscatedName("g")
   static int[] field900;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -555243237
   )
   static int field902;
   @ObfuscatedName("bw")
   @Export("indexModels")
   static IndexData indexModels;
   @ObfuscatedName("k")
   static Buffer field904;

   static {
      field888 = new byte[2048];
      field889 = new byte[2048];
      field890 = new Buffer[2048];
      field891 = 0;
      field894 = new int[2048];
      field893 = 0;
      field886 = new int[2048];
      field895 = new int[2048];
      field900 = new int[2048];
      field897 = new int[2048];
      field902 = 0;
      field899 = new int[2048];
      field904 = new Buffer(new byte[5000]);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1540176824"
   )
   public static void method838(boolean var0) {
      if(ItemComposition.isMembersWorld != var0) {
         ItemComposition.field2982.reset();
         ItemComposition.itemModelCache.reset();
         ItemComposition.itemSpriteCache.reset();
         ItemComposition.isMembersWorld = var0;
      }

   }

   class45() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "510962208"
   )
   static int method850(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class32.intStack[--class32.intStackSize];
         var4 = class128.method2364(var3);
      } else {
         var4 = var2?class200.field2894:Script.field942;
      }

      if(var0 == 1000) {
         class32.intStackSize -= 4;
         var4.originalX = class32.intStack[class32.intStackSize];
         var4.originalY = class32.intStack[class32.intStackSize + 1];
         var4.field2212 = class32.intStack[class32.intStackSize + 2];
         var4.field2206 = class32.intStack[class32.intStackSize + 3];
         class124.method2350(var4);
         FileOnDisk.method1441(var4);
         if(var3 != -1 && var4.type == 0) {
            class164.method3116(class133.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class32.intStackSize -= 4;
         var4.originalWidth = class32.intStack[class32.intStackSize];
         var4.field2219 = class32.intStack[class32.intStackSize + 1];
         var4.field2280 = class32.intStack[class32.intStackSize + 2];
         var4.field2215 = class32.intStack[class32.intStackSize + 3];
         class124.method2350(var4);
         FileOnDisk.method1441(var4);
         if(var3 != -1 && var4.type == 0) {
            class164.method3116(class133.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class32.intStack[--class32.intStackSize] == 1;
         if(var4.isHidden != var5) {
            var4.isHidden = var5;
            class124.method2350(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.field2275 = class32.intStack[--class32.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2203 = class32.intStack[--class32.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1621163061"
   )
   static void method854(String var0, String var1, String var2) {
      class41.loginMessage1 = var0;
      class41.loginMessage2 = var1;
      class41.loginMessage3 = var2;
   }
}
