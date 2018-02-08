import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class213 {
   @ObfuscatedName("s")
   byte[] field2605;
   @ObfuscatedName("g")
   byte[] field2608;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1112043847
   )
   int field2606;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -624228527
   )
   int field2607;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 437251251
   )
   int field2604;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -214659781
   )
   int field2609;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 433160819
   )
   int field2610;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 844932579
   )
   int field2611;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1460218239
   )
   int field2612;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lij;II)V",
      garbageValue = "-742148690"
   )
   static void method4109(IndexData var0, int var1) {
      if(class150.NetCache_reference != null) {
         class150.NetCache_reference.offset = var1 * 8 + 5;
         int var2 = class150.NetCache_reference.readInt();
         int var3 = class150.NetCache_reference.readInt();
         var0.setInformation(var2, var3);
      } else {
         Varbit.requestNetFile((IndexData)null, 255, 255, 0, (byte)0, true);
         class249.NetCache_indexCaches[var1] = var0;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "100"
   )
   @Export("djb2Hash")
   public static int djb2Hash(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + ServerPacket.charToByteCp1252(var0.charAt(var3));
      }

      return var2;
   }
}
