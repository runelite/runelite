import java.awt.Graphics;
import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class38 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -342745875
   )
   static int field824 = 0;
   @ObfuscatedName("r")
   static String[] field826;
   @ObfuscatedName("z")
   static int[] field827 = new int[5];
   @ObfuscatedName("t")
   static int[][] field828 = new int[5][5000];
   @ObfuscatedName("k")
   static Widget field829;
   @ObfuscatedName("i")
   @Export("chatboxSegments")
   static String[] chatboxSegments = new String[1000];
   @ObfuscatedName("j")
   static final String[] field831 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("n")
   static int[] field833 = new int[1000];
   @ObfuscatedName("u")
   static Calendar field834 = Calendar.getInstance();
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1782030879
   )
   static int field835 = 0;
   @ObfuscatedName("m")
   static class14[] field838 = new class14[50];

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static final void method774() {
      for(class31 var0 = (class31)Client.field416.method3854(); null != var0; var0 = (class31)Client.field416.method3869()) {
         if(Item.plane == var0.field710 && !var0.field719) {
            if(Client.gameCycle >= var0.field712) {
               var0.method685(Client.field358);
               if(var0.field719) {
                  var0.unlink();
               } else {
                  class16.region.method1959(var0.field710, var0.field721, var0.field718, var0.field715, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-1903659349"
   )
   static final void method779(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = 6 + var2;
      int var5 = class0.field14.method4067(var0, 250);
      int var6 = class0.field14.method4068(var0, 250) * 13;
      class82.method1883(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2, 0);
      class82.method1834(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var2 + var6, 16777215);
      class0.field14.method4073(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class113.method2446(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2);
      if(var1) {
         try {
            Graphics var7 = class79.canvas.getGraphics();
            Buffer.bufferProvider.draw(var7, 0, 0);
         } catch (Exception var8) {
            class79.canvas.repaint();
         }
      } else {
         class152.method3180(var3, var4, var5, var6);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)LWidget;",
      garbageValue = "-280223033"
   )
   public static Widget method781(int var0, int var1) {
      Widget var2 = class24.method600(var0);
      return var1 == -1?var2:(var2 != null && null != var2.children && var1 < var2.children.length?var2.children[var1]:null);
   }
}
