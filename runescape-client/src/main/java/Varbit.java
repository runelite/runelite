import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("varbits")
   public static NodeCache varbits;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   @Export("varbit_ref")
   public static IndexDataBase varbit_ref;
   @ObfuscatedName("b")
   static int[] field3387;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 462454339
   )
   static int field3386;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1864310077
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 515379015
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1610861949
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   static {
      varbits = new NodeCache(64);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "1377175363"
   )
   void method4425(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "-422098895"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4425(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "-108"
   )
   @Export("getString")
   public static String getString(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class267.field3660[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "1939858041"
   )
   static char method4429(char var0) {
      return var0 != 181 && var0 != 131?Character.toTitleCase(var0):var0;
   }
}
