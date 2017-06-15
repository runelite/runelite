import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class11 {
   @ObfuscatedName("m")
   public static final class11 field270;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      longValue = 7048983841874505589L
   )
   static long field272;
   @ObfuscatedName("cf")
   @Export("indexTrack2")
   static IndexData indexTrack2;
   @ObfuscatedName("p")
   public static final class11 field274;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1402341252"
   )
   static int method60(int var0, Script var1, boolean var2) {
      if(var0 == 5630) {
         Client.field957 = 250;
         return 1;
      } else {
         return 2;
      }
   }

   static {
      field274 = new class11();
      field270 = new class11();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILIndexFile;LIndexData;I)V",
      garbageValue = "-1565864933"
   )
   static void method61(int var0, IndexFile var1, IndexData var2) {
      FileSystem var3 = new FileSystem();
      var3.field3211 = 1;
      var3.hash = (long)var0;
      var3.index = var1;
      var3.data = var2;
      Deque var4 = class236.field3245;
      synchronized(class236.field3245) {
         class236.field3245.method3505(var3);
      }

      class112.method2005();
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(LWidget;IIII)V",
      garbageValue = "-1053805704"
   )
   static final void method62(Widget var0, int var1, int var2, int var3) {
      class210 var4 = var0.method3888(false);
      if(var4 != null) {
         if(Client.field1087 < 3) {
            class158.field2277.method4946(var1, var2, var4.field2607, var4.field2611, 25, 25, Client.mapAngle, 256, var4.field2609, var4.field2608);
         } else {
            Rasterizer2D.method4840(var1, var2, 0, var4.field2609, var4.field2608);
         }

      }
   }
}
