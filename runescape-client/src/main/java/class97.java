import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
public class class97 {
   @ObfuscatedName("f")
   static byte[] field1507;
   @ObfuscatedName("p")
   static byte[] field1508;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Lfb;"
   )
   static Buffer[] field1519;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1341524257
   )
   static int field1510;
   @ObfuscatedName("c")
   static int[] field1511;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -931868093
   )
   static int field1512;
   @ObfuscatedName("w")
   static int[] field1513;
   @ObfuscatedName("b")
   static int[] field1505;
   @ObfuscatedName("o")
   static int[] field1515;
   @ObfuscatedName("m")
   static int[] field1516;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 649652469
   )
   static int field1506;
   @ObfuscatedName("s")
   static int[] field1518;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   static Buffer field1509;

   static {
      field1507 = new byte[2048];
      field1508 = new byte[2048];
      field1519 = new Buffer[2048];
      field1510 = 0;
      field1511 = new int[2048];
      field1512 = 0;
      field1513 = new int[2048];
      field1505 = new int[2048];
      field1515 = new int[2048];
      field1516 = new int[2048];
      field1506 = 0;
      field1518 = new int[2048];
      field1509 = new Buffer(new byte[5000]);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "650678868"
   )
   static int method1815(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class99.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.method1885();
   }
}
