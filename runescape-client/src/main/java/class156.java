import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class156 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 68748407
   )
   public static int field2158;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ldy;"
   )
   public static CacheFile field2160;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ldy;"
   )
   public static CacheFile field2162;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ldy;"
   )
   public static CacheFile field2159;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "[Ldy;"
   )
   public static CacheFile[] field2156;
   @ObfuscatedName("u")
   public static String[] field2164;

   static {
      field2160 = null;
      field2162 = null;
      field2159 = null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI)Lcw;",
      garbageValue = "-1225711739"
   )
   static Script method3073(byte[] var0) {
      Script var1 = new Script();
      Buffer var2 = new Buffer(var0);
      var2.offset = var2.payload.length - 2;
      int var3 = var2.readUnsignedShort();
      int var4 = var2.payload.length - 2 - var3 - 12;
      var2.offset = var4;
      int var5 = var2.readInt();
      var1.localIntCount = var2.readUnsignedShort();
      var1.localStringCount = var2.readUnsignedShort();
      var1.intStackCount = var2.readUnsignedShort();
      var1.stringStackCount = var2.readUnsignedShort();
      int var6 = var2.readUnsignedByte();
      int var7;
      int var8;
      if(var6 > 0) {
         var1.switches = var1.method1919(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.readUnsignedShort();
            IterableHashTable var9 = new IterableHashTable(class163.method3173(var8));
            var1.switches[var7] = var9;

            while(var8-- > 0) {
               int var10 = var2.readInt();
               int var11 = var2.readInt();
               var9.put(new IntegerNode(var11), (long)var10);
            }
         }
      }

      var2.offset = 0;
      var2.getNullString();
      var1.instructions = new int[var5];
      var1.intOperands = new int[var5];
      var1.stringOperands = new String[var5];

      for(var7 = 0; var2.offset < var4; var1.instructions[var7++] = var8) {
         var8 = var2.readUnsignedShort();
         if(var8 == 3) {
            var1.stringOperands[var7] = var2.readString();
         } else if(var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
            var1.intOperands[var7] = var2.readInt();
         } else {
            var1.intOperands[var7] = var2.readUnsignedByte();
         }
      }

      return var1;
   }
}
