import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("h")
   public static class182 field1559;
   @ObfuscatedName("n")
   static String field1560;
   @ObfuscatedName("o")
   Frame[] field1562;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1537745157"
   )
   public boolean method1847(int var1) {
      return this.field1562[var1].field1312;
   }

   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IZ)V",
      garbageValue = "0"
   )
   public Frames(class182 var1, class182 var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method3245(var3);
      this.field1562 = new Frame[var6];
      int[] var7 = var1.method3212(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3203(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method2349(); null != var12; var12 = (FrameMap)var5.method2351()) {
            if(var11 == var12.field1459) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13 = var2.method3209(var11, 0);
            var10 = new FrameMap(var11, var13);
            var5.method2361(var10);
         }

         this.field1562[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZI)V",
      garbageValue = "-526959282"
   )
   static void method1849(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class114.field1799.startsWith("win") && !var3) {
            XItemContainer.method159(var0, 0, "openjs");
            return;
         }

         if(class114.field1799.startsWith("mac")) {
            XItemContainer.method159(var0, 1, var2);
            return;
         }

         XItemContainer.method159(var0, 2, "openjs");
      } else {
         XItemContainer.method159(var0, 3, "openjs");
      }

   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1279203437"
   )
   static void method1850() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         if(XGrandExchangeOffer.method52(Client.menuTypes[var0])) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var1 = var0; var1 < Client.menuOptionCount - 1; ++var1) {
                  Client.menuOptions[var1] = Client.menuOptions[1 + var1];
                  Client.menuTargets[var1] = Client.menuTargets[1 + var1];
                  Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
                  Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
                  Client.menuActionParams0[var1] = Client.menuActionParams0[1 + var1];
                  Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1178930606"
   )
   static final int method1851(int var0, int var1) {
      int var2 = class155.method2931(var0 - 1, var1 - 1) + class155.method2931(1 + var0, var1 - 1) + class155.method2931(var0 - 1, var1 + 1) + class155.method2931(1 + var0, var1 + 1);
      int var3 = class155.method2931(var0 - 1, var1) + class155.method2931(1 + var0, var1) + class155.method2931(var0, var1 - 1) + class155.method2931(var0, 1 + var1);
      int var4 = class155.method2931(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }
}
