import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public class class64 {
   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("indexTextures")
   static IndexData indexTextures;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Ljh;",
      garbageValue = "1644954726"
   )
   public static class261 method1105(int var0) {
      class261 var1 = (class261)class261.field3476.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class261.field3498.getConfigData(32, var0);
         var1 = new class261();
         if(var2 != null) {
            var1.method4686(new Buffer(var2));
         }

         class261.field3476.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1588862992"
   )
   static void method1103() {
      FileOnDisk var0 = null;

      try {
         var0 = class46.getPreferencesFile("", class36.field483.name, true);
         Buffer var1 = RSCanvas.preferences.serialize();
         var0.write(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.closeSync(true);
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfr;I)Ljava/lang/String;",
      garbageValue = "-2125426952"
   )
   public static String method1107(Buffer var0) {
      return GroundObject.method2599(var0, 32767);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-84"
   )
   public static boolean method1106(char var0) {
      return var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1997379495"
   )
   static void method1104(int var0) {
      if(var0 == -1 && !Client.field1095) {
         Ignore.method1126();
      } else if(var0 != -1 && var0 != Client.field1090 && Client.field1113 != 0 && !Client.field1095) {
         IndexData var1 = RSCanvas.indexTrack1;
         int var2 = Client.field1113;
         class210.field2598 = 1;
         class3.field22 = var1;
         BoundingBox2D.field237 = var0;
         class210.field2599 = 0;
         class111.field1588 = var2;
         class20.field322 = false;
         class164.field2216 = 2;
      }

      Client.field1090 = var0;
   }
}
