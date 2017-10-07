import java.awt.FontMetrics;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class170 {
   @ObfuscatedName("ad")
   static FontMetrics field2360;
   @ObfuscatedName("t")
   @Export("blendedHue")
   static int[] blendedHue;
   @ObfuscatedName("pl")
   @ObfuscatedGetter(
      intValue = -345722249
   )
   static int field2359;

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "638912594"
   )
   @Export("decodeContainer")
   static final byte[] decodeContainer(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field3229 != 0 && var3 > IndexDataBase.field3229) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.readBytes(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 < 0 || IndexDataBase.field3229 != 0 && var6 > IndexDataBase.field3229) {
            throw new RuntimeException();
         } else {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               class167.method3200(var5, var6, var0, var3, 9);
            } else {
               IndexDataBase.gzip.decompress(var1, var5);
            }

            return var5;
         }
      }
   }
}
