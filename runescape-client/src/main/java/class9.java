import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public class class9 {
   @ObfuscatedName("v")
   static final BigInteger field146 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("j")
   static final BigInteger field147 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("z")
   static String field149;
   @ObfuscatedName("bt")
   static class171 field151;
   @ObfuscatedName("ez")
   static SpritePixels[] field152;
   @ObfuscatedName("aq")
   static int[] field153;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIILObjectComposition;II)V",
      garbageValue = "1612986201"
   )
   static void method113(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class24 var5 = new class24();
      var5.field616 = var0;
      var5.field603 = var1 * 128;
      var5.field604 = var2 * 128;
      int var6 = var3.field950;
      int var7 = var3.field948;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.field948;
         var7 = var3.field950;
      }

      var5.field605 = (var6 + var1) * 128;
      var5.field607 = (var7 + var2) * 128;
      var5.field608 = var3.field979;
      var5.field606 = var3.field980 * 128;
      var5.field610 = var3.field981;
      var5.field611 = var3.field943;
      var5.field612 = var3.field983;
      if(null != var3.impostorIds) {
         var5.field615 = var3;
         var5.method598();
      }

      class24.field609.method3844(var5);
      if(var5.field612 != null) {
         var5.field613 = var5.field610 + (int)(Math.random() * (double)(var5.field611 - var5.field610));
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "1310600698"
   )
   public static void method116(class170 var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.method3327(var1);
      int var6 = var0.method3325(var5, var2);
      class140.method2961(var0, var5, var6, var3, var4);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "102"
   )
   static void method117(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.method3828((long)var0);
      if(null == var4) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.method3822(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[1 + var1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }
}
