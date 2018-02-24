import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = -64726671
   )
   @Export("myWorldPort")
   static int myWorldPort;
   @ObfuscatedName("b")
   @Export("objs")
   Object[] objs;
   @ObfuscatedName("q")
   @Export("boolean1")
   boolean boolean1;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   @Export("widget")
   Widget widget;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1545435759
   )
   int field744;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -24982637
   )
   int field745;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 192971083
   )
   int field753;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   Widget field747;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1684983799
   )
   int field754;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -209247861
   )
   int field749;
   @ObfuscatedName("c")
   @Export("string")
   String string;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -135392509
   )
   int field751;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   class239 field752;

   public ScriptEvent() {
      this.field752 = class239.field2925;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;I)V",
      garbageValue = "613815162"
   )
   public void method1134(Object[] var1) {
      this.objs = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Liu;B)V",
      garbageValue = "-81"
   )
   public void method1130(class239 var1) {
      this.field752 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)[Lfw;",
      garbageValue = "778828253"
   )
   public static ServerPacket[] method1137() {
      return new ServerPacket[]{ServerPacket.field2289, ServerPacket.field2256, ServerPacket.field2257, ServerPacket.field2258, ServerPacket.field2263, ServerPacket.field2260, ServerPacket.field2319, ServerPacket.field2300, ServerPacket.field2337, ServerPacket.field2317, ServerPacket.field2265, ServerPacket.field2266, ServerPacket.field2267, ServerPacket.field2268, ServerPacket.field2269, ServerPacket.field2279, ServerPacket.field2271, ServerPacket.field2272, ServerPacket.field2273, ServerPacket.field2290, ServerPacket.field2277, ServerPacket.field2276, ServerPacket.field2259, ServerPacket.field2278, ServerPacket.field2262, ServerPacket.field2280, ServerPacket.field2275, ServerPacket.field2282, ServerPacket.field2283, ServerPacket.field2284, ServerPacket.field2285, ServerPacket.field2286, ServerPacket.field2287, ServerPacket.field2288, ServerPacket.field2261, ServerPacket.field2270, ServerPacket.field2291, ServerPacket.field2292, ServerPacket.field2331, ServerPacket.field2294, ServerPacket.field2295, ServerPacket.field2296, ServerPacket.field2281, ServerPacket.field2298, ServerPacket.field2299, ServerPacket.field2333, ServerPacket.field2301, ServerPacket.field2302, ServerPacket.field2303, ServerPacket.field2329, ServerPacket.field2305, ServerPacket.field2306, ServerPacket.field2307, ServerPacket.field2308, ServerPacket.field2309, ServerPacket.field2310, ServerPacket.field2320, ServerPacket.field2312, ServerPacket.field2313, ServerPacket.field2314, ServerPacket.field2315, ServerPacket.field2316, ServerPacket.field2304, ServerPacket.field2322, ServerPacket.field2293, ServerPacket.field2297, ServerPacket.field2321, ServerPacket.field2334, ServerPacket.field2323, ServerPacket.field2324, ServerPacket.field2311, ServerPacket.field2326, ServerPacket.field2327, ServerPacket.field2328, ServerPacket.field2325, ServerPacket.field2330, ServerPacket.field2264, ServerPacket.field2332, ServerPacket.field2274, ServerPacket.field2318, ServerPacket.field2335};
   }

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "([Lim;IB)V",
      garbageValue = "-93"
   )
   static final void method1138(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method1138(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  FrameMap.method2881(var4.id, var1);
               }
            }

            ScriptEvent var5;
            if(var1 == 0 && var3.field2884 != null) {
               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.objs = var3.field2884;
               class194.method3791(var5);
            }

            if(var1 == 1 && var3.field2900 != null) {
               if(var3.index >= 0) {
                  Widget var6 = NetWriter.getWidget(var3.id);
                  if(var6 == null || var6.children == null || var3.index >= var6.children.length || var3 != var6.children[var3.index]) {
                     continue;
                  }
               }

               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.objs = var3.field2900;
               class194.method3791(var5);
            }
         }
      }

   }

   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "(Lim;B)V",
      garbageValue = "88"
   )
   static void method1132(Widget var0) {
      if(var0.loopCycle == Client.field877) {
         Client.field979[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("kb")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "-2030511551"
   )
   static String method1136(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.socketType == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.socketType == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.socketType == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.socketType == 5) {
         var0 = var0 + "-wti";
      } else if(Client.socketType == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class45.sessionToken != null) {
         var3 = "/p=" + class45.sessionToken;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.languageId + "/a=" + WorldMapManager.field512 + var3 + "/";
   }
}
