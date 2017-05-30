import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
public class class261 {
   @ObfuscatedName("h")
   public static final class261 field3615;
   @ObfuscatedName("u")
   public static final class261 field3616;
   @ObfuscatedName("g")
   public static final class261 field3618;
   @ObfuscatedName("q")
   public static final class261 field3619;
   @ObfuscatedName("t")
   final String field3620;
   @ObfuscatedName("p")
   String field3621;
   @ObfuscatedName("v")
   public static final class261 field3622;
   @ObfuscatedName("i")
   public static final class261 field3624;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1168947301
   )
   public static int field3626;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "386944817"
   )
   public static void method4789(int var0) {
      class59.mouseIdleTicks = var0;
   }

   static {
      field3624 = new class261("PLAIN11", "p11_full");
      field3615 = new class261("PLAIN12", "p12_full");
      field3616 = new class261("BOLD12", "b12_full");
      field3619 = new class261("VERDANA11", "verdana_11pt_regular");
      field3618 = new class261("VERDANA13", "verdana_13pt_regular");
      field3622 = new class261("VERDANA15", "verdana_15pt_regular");
   }

   class261(String var1, String var2) {
      this.field3620 = var1;
      this.field3621 = var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-127"
   )
   static int method4790(int var0, int var1, int var2) {
      return (class61.tileSettings[var0][var1][var2] & 8) != 0?0:(var0 > 0 && (class61.tileSettings[1][var1][var2] & 2) != 0?var0 - 1:var0);
   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "21402"
   )
   static final void method4791(String var0) {
      if(var0 != null) {
         String var1 = class27.method214(var0, WorldMapType1.field423);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
               Ignore var3 = Client.ignores[var2];
               String var4 = var3.name;
               String var5 = class27.method214(var4, WorldMapType1.field423);
               if(class21.method151(var0, var1, var4, var5)) {
                  --Client.ignoreCount;

                  for(int var6 = var2; var6 < Client.ignoreCount; ++var6) {
                     Client.ignores[var6] = Client.ignores[var6 + 1];
                  }

                  Client.field1083 = Client.field1075;
                  Client.secretPacketBuffer1.putOpcode(118);
                  Client.secretPacketBuffer1.putByte(class46.method711(var0));
                  Client.secretPacketBuffer1.method3191(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)LWidget;",
      garbageValue = "-982102981"
   )
   public static Widget method4792(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(class90.widgets[var1] == null || class90.widgets[var1][var2] == null) {
         boolean var3 = class14.method75(var1);
         if(!var3) {
            return null;
         }
      }

      return class90.widgets[var1][var2];
   }
}
