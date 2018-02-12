import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
public class class84 {
   @ObfuscatedName("i")
   static final BigInteger field1274;
   @ObfuscatedName("w")
   static final BigInteger field1275;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -661888319
   )
   @Export("priority")
   static int priority;
   @ObfuscatedName("u")
   static String[] field1281;
   @ObfuscatedName("ah")
   protected static String field1273;
   @ObfuscatedName("fa")
   @Export("landRegionFileIds")
   static int[] landRegionFileIds;

   static {
      field1274 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1275 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lbc;B)V",
      garbageValue = "101"
   )
   public static void method1868(ScriptEvent var0) {
      ScriptState.runScript(var0, 200000);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1912529323"
   )
   static void method1866() {
      class94.chatLineMap.clear();
      class94.messages.clear();
      class94.field1413.clear();
      class94.field1414 = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "4013"
   )
   static final void method1865() {
      BoundingBox3D.method49("You can\'t add yourself to your own ignore list");
   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "-1615911266"
   )
   @Export("prependIndices")
   static final String[] prependIndices(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }
}
