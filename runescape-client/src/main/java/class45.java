import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class45 {
   @ObfuscatedName("l")
   static int[] field896 = new int[2048];
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 7945299
   )
   static int field897 = 0;
   @ObfuscatedName("m")
   static byte[] field898 = new byte[2048];
   @ObfuscatedName("x")
   static Buffer field899 = new Buffer(new byte[5000]);
   @ObfuscatedName("w")
   static Buffer[] field900 = new Buffer[2048];
   @ObfuscatedName("h")
   static byte[] field901 = new byte[2048];
   @ObfuscatedName("c")
   static int[] field902 = new int[2048];
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -521852255
   )
   static int field903 = 0;
   @ObfuscatedName("g")
   static int[] field904 = new int[2048];
   @ObfuscatedName("z")
   static int[] field905 = new int[2048];
   @ObfuscatedName("q")
   static int[] field906 = new int[2048];
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2139419699
   )
   static int field908 = 0;
   @ObfuscatedName("e")
   static int[] field909 = new int[2048];

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-951421891"
   )
   static final void method835(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field488; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field490[var4] = true;
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2042333997"
   )
   public static void method844() {
      PlayerComposition.field2038.reset();
   }
}
