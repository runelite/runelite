import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public class class9 {
   @ObfuscatedName("l")
   static final BigInteger field155 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("co")
   static class143 field158;
   @ObfuscatedName("d")
   static final BigInteger field160 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = -785470337
   )
   static int field161;
   @ObfuscatedName("el")
   static class78[] field164;
   @ObfuscatedName("et")
   static class78 field165;

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "801403665"
   )
   static final void method132(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = class91.field1597[var6];
         var12 = class91.field1577[var6];
         var13 = var12 * var9 - var5 * var11 >> 16;
         var10 = var5 * var12 + var9 * var11 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = class91.field1597[var7];
         var12 = class91.field1577[var7];
         var13 = var10 * var11 + var12 * var8 >> 16;
         var10 = var12 * var10 - var11 * var8 >> 16;
         var8 = var13;
      }

      class216.field3160 = var0 - var8;
      class1.field27 = var1 - var9;
      class26.field665 = var2 - var10;
      class134.field2082 = var3;
      class42.field1018 = var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)[Lclass152;",
      garbageValue = "100"
   )
   public static class152[] method135() {
      return new class152[]{class152.field2256, class152.field2258, class152.field2263, class152.field2254, class152.field2255};
   }
}
