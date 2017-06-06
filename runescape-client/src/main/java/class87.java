import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
public class class87 {
   @ObfuscatedName("y")
   static final BigInteger field1400;
   @ObfuscatedName("b")
   static final BigInteger field1403;
   @ObfuscatedName("a")
   public static boolean field1404;
   @ObfuscatedName("bu")
   static ModIcon field1407;

   static {
      field1403 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1400 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1870018023"
   )
   public static int method1696(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }
}
