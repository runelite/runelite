import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
public class class233 {
   @ObfuscatedName("g")
   public static final boolean[] field2940;
   @ObfuscatedName("m")
   public static int[] field2941;

   static {
      field2940 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field2941 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2941[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZS)V",
      garbageValue = "5259"
   )
   public static void method4474(String var0, boolean var1, boolean var2) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var4) {
               ;
            }
         }

         if(class56.field638.startsWith("win")) {
            Nameable.method5146(var0, 0);
         } else if(class56.field638.startsWith("mac")) {
            MouseRecorder.method1078(var0, 1, "openjs");
         } else {
            Nameable.method5146(var0, 2);
         }
      } else {
         Nameable.method5146(var0, 3);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lir;Ljava/lang/String;Ljava/lang/String;B)[Lkh;",
      garbageValue = "7"
   )
   @Export("getIndexedSprites")
   public static IndexedSprite[] getIndexedSprites(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      IndexedSprite[] var5;
      if(!class35.method484(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class31.method270();
      }

      return var5;
   }
}
