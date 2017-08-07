import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public class class97 {
   @ObfuscatedName("g")
   static byte[] field1490;
   @ObfuscatedName("y")
   static byte[] field1491;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfh;"
   )
   static Buffer[] field1492;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 772188147
   )
   static int field1493;
   @ObfuscatedName("v")
   static int[] field1494;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 145974641
   )
   static int field1495;
   @ObfuscatedName("r")
   static int[] field1498;
   @ObfuscatedName("u")
   static int[] field1497;
   @ObfuscatedName("d")
   static int[] field1496;
   @ObfuscatedName("o")
   static int[] field1499;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1897842445
   )
   static int field1500;
   @ObfuscatedName("h")
   static int[] field1501;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lfh;"
   )
   static Buffer field1502;
   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "[Ljp;"
   )
   static IndexedSprite[] field1504;
   @ObfuscatedName("q")
   static int[] field1503;

   static {
      field1490 = new byte[2048];
      field1491 = new byte[2048];
      field1492 = new Buffer[2048];
      field1493 = 0;
      field1494 = new int[2048];
      field1495 = 0;
      field1498 = new int[2048];
      field1497 = new int[2048];
      field1496 = new int[2048];
      field1499 = new int[2048];
      field1500 = 0;
      field1501 = new int[2048];
      field1502 = new Buffer(new byte[5000]);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-97"
   )
   static final void method1821() {
      if(!class135.field1993) {
         int var0 = Region.pitchSin;
         int var1 = Region.pitchCos;
         int var2 = Region.yawSin;
         int var3 = Region.yawCos;
         byte var4 = 50;
         short var5 = 3500;
         int var6 = (class135.field1983 - Graphics3D.centerX) * var4 / Graphics3D.field2011;
         int var7 = (class135.field1991 - Graphics3D.centerY) * var4 / Graphics3D.field2011;
         int var8 = (class135.field1983 - Graphics3D.centerX) * var5 / Graphics3D.field2011;
         int var9 = (class135.field1991 - Graphics3D.centerY) * var5 / Graphics3D.field2011;
         int var10 = Graphics3D.method2649(var7, var4, var1, var0);
         int var11 = Graphics3D.method2698(var7, var4, var1, var0);
         var7 = var10;
         var10 = Graphics3D.method2649(var9, var5, var1, var0);
         int var12 = Graphics3D.method2698(var9, var5, var1, var0);
         var9 = var10;
         var10 = Graphics3D.method2647(var6, var11, var3, var2);
         var11 = Graphics3D.method2648(var6, var11, var3, var2);
         var6 = var10;
         var10 = Graphics3D.method2647(var8, var12, var3, var2);
         var12 = Graphics3D.method2648(var8, var12, var3, var2);
         class135.field1986 = (var10 + var6) / 2;
         class20.field326 = (var7 + var9) / 2;
         class5.field32 = (var12 + var11) / 2;
         class93.field1428 = (var10 - var6) / 2;
         class237.field3218 = (var9 - var7) / 2;
         SceneTilePaint.field2027 = (var12 - var11) / 2;
         class135.field1987 = Math.abs(class93.field1428);
         class19.field325 = Math.abs(class237.field3218);
         class64.field790 = Math.abs(SceneTilePaint.field2027);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BI)Lcc;",
      garbageValue = "1710789966"
   )
   static Script method1829(byte[] var0) {
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
         var1.switches = var1.method1882(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.readUnsignedShort();
            IterableHashTable var9 = new IterableHashTable(class14.method81(var8));
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "576058545"
   )
   public static boolean method1831(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
