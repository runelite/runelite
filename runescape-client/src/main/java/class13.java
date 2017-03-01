import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public class class13 {
   @ObfuscatedName("nr")
   @ObfuscatedGetter(
      intValue = 1723534909
   )
   static int field130;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 2052231883
   )
   public static int field131;
   @ObfuscatedName("rt")
   protected static boolean field133;

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "2135192024"
   )
   static final String method186(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class37.method813('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class37.method813(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class37.method813(16776960) + var1 + "</col>");
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "53"
   )
   static final void method187(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field468; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field495[var4] = true;
         }
      }

   }

   class13() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-625871106"
   )
   static final void method188() {
      for(int var0 = 0; var0 < Client.field328; ++var0) {
         int var1 = Client.field285[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(var2 != null) {
            class138.method2573(var2, var2.composition.field3040);
         }
      }

   }
}
