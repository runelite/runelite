import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
public class class73 {
   @ObfuscatedName("f")
   static final BigInteger field1062;
   @ObfuscatedName("n")
   static final BigInteger field1060;

   static {
      field1062 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1060 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lge;B)I",
      garbageValue = "73"
   )
   static int method1843(PacketBuffer var0) {
      int var1 = var0.getBits(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.getBits(5);
      } else if(var1 == 2) {
         var2 = var0.getBits(8);
      } else {
         var2 = var0.getBits(11);
      }

      return var2;
   }
}
