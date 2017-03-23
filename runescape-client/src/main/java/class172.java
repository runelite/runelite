import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class class172 {
   @ObfuscatedName("u")
   public static int[] field2369 = new int[99];
   @ObfuscatedName("i")
   public static final boolean[] field2371 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
   @ObfuscatedName("w")
   static ModIcon field2373;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILclass116;Lclass184;B)V",
      garbageValue = "98"
   )
   static void method3305(int var0, class116 var1, class184 var2) {
      byte[] var3 = null;
      Deque var4 = class183.field2746;
      synchronized(class183.field2746) {
         for(class180 var5 = (class180)class183.field2746.method2464(); null != var5; var5 = (class180)class183.field2746.method2472()) {
            if((long)var0 == var5.hash && var5.field2716 == var1 && var5.field2719 == 0) {
               var3 = var5.field2715;
               break;
            }
         }
      }

      if(null != var3) {
         var2.method3426(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method2310(var0);
         var2.method3426(var1, var0, var8, true);
      }
   }

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = 1 + var1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2369[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(IIII)LWidgetNode;",
      garbageValue = "1752043686"
   )
   static final WidgetNode method3306(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.field187 = var2;
      Client.componentTable.method2418(var3, (long)var0);
      class176.method3314(var1);
      Widget var4 = FaceNormal.method1932(var0);
      class22.method197(var4);
      if(Client.field467 != null) {
         class22.method197(Client.field467);
         Client.field467 = null;
      }

      class22.method202();
      class2.method16(Widget.widgets[var0 >> 16], var4, false);
      class114.method2257(var1);
      if(Client.widgetRoot != -1) {
         class33.method718(Client.widgetRoot, 1);
      }

      return var3;
   }

   class172() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1718539827"
   )
   public static String method3307(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }
}
