import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
public class class85 {
   @ObfuscatedName("q")
   static final BigInteger field1376;
   @ObfuscatedName("s")
   static final BigInteger field1373;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 810489965
   )
   static int field1377;

   static {
      field1376 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1373 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgc;ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "105"
   )
   static String method1769(IterableHashTable var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         ObjectNode var3 = (ObjectNode)var0.get((long)var1);
         return var3 == null?var2:(String)var3.value;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(CIB)I",
      garbageValue = "0"
   )
   static int method1768(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}
