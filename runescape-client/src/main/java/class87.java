import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
public class class87 {
   @ObfuscatedName("m")
   static final BigInteger field1382;
   @ObfuscatedName("f")
   static final BigInteger field1383;
   @ObfuscatedName("am")
   protected static String field1385;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = 46653139
   )
   static int field1386;

   static {
      field1383 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1382 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1328634444"
   )
   static String method1682(int var0) {
      return var0 < 0?"":(Client.menuTargets[var0].length() > 0?Client.menuOptions[var0] + " " + Client.menuTargets[var0]:Client.menuOptions[var0]);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;II)Z",
      garbageValue = "-576341849"
   )
   static boolean method1684(PacketBuffer var0, int var1) {
      int var2 = var0.method3400(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method3400(1) != 0) {
            method1684(var0, var1);
         }

         var3 = var0.method3400(13);
         var4 = var0.method3400(13);
         boolean var12 = var0.method3400(1) == 1;
         if(var12) {
            class96.field1508[++class96.field1507 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field892 = var1;
            if(class96.field1497[var1] != null) {
               var6.method1109(class96.field1497[var1]);
            }

            var6.field1252 = class96.field1505[var1];
            var6.interacting = class96.field1495[var1];
            var7 = class96.field1504[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field1283[0] = class96.field1498[var1];
            var6.field891 = (byte)var8;
            var6.method1123((var9 << 13) + var3 - class61.baseX, var4 + (var10 << 13) - class23.baseY);
            var6.field893 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method3400(2);
         var4 = class96.field1504[var1];
         class96.field1504[var1] = ((var3 + (var4 >> 28) & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.method3400(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class96.field1504[var1];
            var7 = var4 + (var11 >> 28) & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class96.field1504[var1] = var9 + (var7 << 28) + (var8 << 14);
            return false;
         } else {
            var3 = var0.method3400(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class96.field1504[var1];
            var8 = var4 + (var7 >> 28) & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var11 + var7 & 255;
            class96.field1504[var1] = var10 + (var8 << 28) + (var9 << 14);
            return false;
         }
      }
   }
}
