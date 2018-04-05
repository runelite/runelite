import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kp")
@Implements("FontName")
public class FontName {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   @Export("FontName_plain11")
   public static final FontName FontName_plain11;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   @Export("FontName_plain12")
   public static final FontName FontName_plain12;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   @Export("FontName_bold12")
   public static final FontName FontName_bold12;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   public static final FontName field3881;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   public static final FontName field3882;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   public static final FontName field3886;
   @ObfuscatedName("fz")
   @Export("landRegionFileIds")
   static int[] landRegionFileIds;
   @ObfuscatedName("z")
   final String field3884;
   @ObfuscatedName("i")
   String field3885;

   static {
      FontName_plain11 = new FontName("PLAIN11", "p11_full");
      FontName_plain12 = new FontName("PLAIN12", "p12_full");
      FontName_bold12 = new FontName("BOLD12", "b12_full");
      field3881 = new FontName("VERDANA11", "verdana_11pt_regular");
      field3882 = new FontName("VERDANA13", "verdana_13pt_regular");
      field3886 = new FontName("VERDANA15", "verdana_15pt_regular");
   }

   FontName(String var1, String var2) {
      this.field3884 = var1;
      this.field3885 = var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljf;Ljf;III)Lki;",
      garbageValue = "-2059883781"
   )
   public static Font method5488(IndexDataBase var0, IndexDataBase var1, int var2, int var3) {
      return !RunException.method3215(var0, var2, var3)?null:class57.method868(var1.getConfigData(var2, var3));
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)Lin;",
      garbageValue = "-662021914"
   )
   @Export("getWidgetChild")
   public static Widget getWidgetChild(int var0, int var1) {
      Widget var2 = class44.getWidget(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(Lin;I)V",
      garbageValue = "-771426395"
   )
   static void method5490(Widget var0) {
      if(var0.loopCycle == Client.field1071) {
         Client.field1072[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("ke")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1902496931"
   )
   static String method5489(String var0) {
      Permission[] var1 = new Permission[]{Permission.field3345, Permission.field3344, Permission.field3346, Permission.field3349, Permission.field3350, Permission.field3347};
      Permission[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Permission var4 = var2[var3];
         if(var4.field3348 != -1) {
            int var7 = var4.field3348;
            String var6 = "<img=" + var7 + ">";
            if(var0.startsWith(var6)) {
               var0 = var0.substring(6 + Integer.toString(var4.field3348).length());
               break;
            }
         }
      }

      return var0;
   }
}
