import java.io.File;
import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public class class9 {
   @ObfuscatedName("b")
   static final BigInteger field146 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("i")
   static final BigInteger field149 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("po")
   static class163 field151;
   @ObfuscatedName("z")
   public static File field155;

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-2129425797"
   )
   static final void method119(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = Client.field498 + (Client.field331 - Client.field498) * var5 / 100;
      int var7 = 512 * var6 * var3 / (334 * var2);
      int var8;
      int var14;
      short var15;
      if(var7 < Client.field540) {
         var15 = Client.field540;
         var6 = 334 * var15 * var2 / (var3 * 512);
         if(var6 > Client.field539) {
            var6 = Client.field539;
            var8 = 512 * var6 * var3 / (var15 * 334);
            var14 = (var2 - var8) / 2;
            if(var4) {
               class82.method1824();
               class82.method1831(var0, var1, var14, var3, -16777216);
               class82.method1831(var0 + var2 - var14, var1, var14, var3, -16777216);
            }

            var0 += var14;
            var2 -= var14 * 2;
         }
      } else if(var7 > Client.field284) {
         var15 = Client.field284;
         var6 = var2 * var15 * 334 / (var3 * 512);
         if(var6 < Client.field538) {
            var6 = Client.field538;
            var8 = var2 * var15 * 334 / (512 * var6);
            var14 = (var3 - var8) / 2;
            if(var4) {
               class82.method1824();
               class82.method1831(var0, var1, var2, var14, -16777216);
               class82.method1831(var0, var3 + var1 - var14, var2, var14, -16777216);
            }

            var1 += var14;
            var3 -= 2 * var14;
         }
      }

      var8 = Client.field392 + var5 * (Client.field537 - Client.field392) / 100;
      Client.scale = var8 * var3 * var6 / 85504 << 1;
      if(Client.camera2 != var2 || Client.camera3 != var3) {
         int[] var9 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 15 + 128 + 32 * var10;
            int var12 = 600 + 3 * var11;
            int var13 = class94.field1639[var11];
            var9[var10] = var13 * var12 >> 16;
         }

         Region.method1983(var9, 500, 800, var2, var3);
      }

      Client.field542 = var0;
      Client.field347 = var1;
      Client.camera2 = var2;
      Client.camera3 = var3;
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(IS)Ljava/lang/String;",
      garbageValue = "32469"
   )
   static final String method120(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class154.method3185('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class154.method3185(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class154.method3185(16776960) + var1 + "</col>");
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1809509900"
   )
   static final void method121() {
      Region.field1562 = false;
      Client.field314 = false;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "-17343"
   )
   static int method122(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class11.chatLineMap.get(Integer.valueOf(var0));
      return null == var1?0:var1.method635();
   }
}
