import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
@Implements("TextureProvider")
public class TextureProvider implements class93 {
   @ObfuscatedName("w")
   public static String field1212;
   @ObfuscatedName("d")
   Deque field1213 = new Deque();
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -282199397
   )
   int field1214;
   @ObfuscatedName("q")
   class79[] field1215;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 684615535
   )
   int field1217 = 128;
   @ObfuscatedName("r")
   class182 field1218;
   @ObfuscatedName("j")
   double field1221 = 1.0D;
   @ObfuscatedName("b")
   public static class72[] field1222;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1631494145
   )
   int field1225 = 0;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "9793"
   )
   public boolean vmethod1971(int var1) {
      return this.field1217 == 64;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method1487(double var1) {
      this.field1221 = var1;
      this.method1491();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-632171036"
   )
   @Export("load")
   public int[] load(int var1) {
      class79 var2 = this.field1215[var1];
      if(null != var2) {
         if(null != var2.field1333) {
            this.field1213.method2454(var2);
            var2.field1321 = true;
            return var2.field1333;
         }

         boolean var3 = var2.method1600(this.field1221, this.field1217, this.field1218);
         if(var3) {
            if(this.field1225 == 0) {
               class79 var4 = (class79)this.field1213.method2457();
               var4.method1598();
            } else {
               --this.field1225;
            }

            this.field1213.method2454(var2);
            var2.field1321 = true;
            return var2.field1333;
         }
      }

      return null;
   }

   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IDI)V",
      garbageValue = "128"
   )
   public TextureProvider(class182 var1, class182 var2, int var3, double var4, int var6) {
      this.field1218 = var2;
      this.field1214 = var3;
      this.field1225 = this.field1214;
      this.field1221 = var4;
      this.field1217 = var6;
      int[] var7 = var1.method3312(0);
      int var8 = var7.length;
      this.field1215 = new class79[var1.method3313(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.getConfigData(0, var7[var9]));
         this.field1215[var7[var9]] = new class79(var10);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1923199887"
   )
   static int method1489(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method2399((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "23"
   )
   public void method1491() {
      for(int var1 = 0; var1 < this.field1215.length; ++var1) {
         if(this.field1215[var1] != null) {
            this.field1215[var1].method1598();
         }
      }

      this.field1213 = new Deque();
      this.field1225 = this.field1214;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "18509"
   )
   public void method1492(int var1) {
      for(int var2 = 0; var2 < this.field1215.length; ++var2) {
         class79 var3 = this.field1215[var2];
         if(null != var3 && var3.field1331 != 0 && var3.field1321) {
            var3.method1604(var1);
            var3.field1321 = false;
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1122495559"
   )
   public boolean vmethod1965(int var1) {
      return this.field1215[var1].field1326;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZI)V",
      garbageValue = "1930777692"
   )
   public static void method1507(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class114.field1791.startsWith("win")) {
            class30.method695(var0, 0, "openjs");
            return;
         }

         if(class114.field1791.startsWith("mac")) {
            class30.method695(var0, 1, var2);
            return;
         }

         class30.method695(var0, 2, "openjs");
      } else {
         class30.method695(var0, 3, "openjs");
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-94"
   )
   static final int method1508(int var0, int var1) {
      int var2 = class13.method175(var0 - 1, var1 - 1) + class13.method175(1 + var0, var1 - 1) + class13.method175(var0 - 1, 1 + var1) + class13.method175(var0 + 1, 1 + var1);
      int var3 = class13.method175(var0 - 1, var1) + class13.method175(var0 + 1, var1) + class13.method175(var0, var1 - 1) + class13.method175(var0, 1 + var1);
      int var4 = class13.method175(var0, var1);
      return var3 / 8 + var2 / 16 + var4 / 4;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-45"
   )
   public int vmethod1964(int var1) {
      return this.field1215[var1] != null?this.field1215[var1].field1323:0;
   }
}
