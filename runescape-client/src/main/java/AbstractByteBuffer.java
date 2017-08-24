import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
@Implements("AbstractByteBuffer")
public abstract class AbstractByteBuffer {
   @ObfuscatedName("j")
   static boolean field2414;

   static {
      field2414 = false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(S)[B",
      garbageValue = "-24790"
   )
   @Export("get")
   abstract byte[] get();

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1703354004"
   )
   @Export("put")
   abstract void put(byte[] var1);

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "([BS)[B",
      garbageValue = "5000"
   )
   @Export("decodeContainer")
   static final byte[] decodeContainer(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field3230 != 0 && var3 > IndexDataBase.field3230) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.readBytes(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 < 0 || IndexDataBase.field3230 != 0 && var6 > IndexDataBase.field3230) {
            throw new RuntimeException();
         } else {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               class168.method3179(var5, var6, var0, var3, 9);
            } else {
               IndexDataBase.gzip.decompress(var1, var5);
            }

            return var5;
         }
      }
   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "(Lhx;S)Ljava/lang/String;",
      garbageValue = "11375"
   )
   static String method3468(Widget var0) {
      int var2 = Coordinates.getWidgetConfig(var0);
      int var1 = var2 >> 11 & 63;
      return var1 == 0?null:(var0.selectedAction != null && var0.selectedAction.trim().length() != 0?var0.selectedAction:null);
   }
}
