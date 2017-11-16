import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
public class class96 {
   @ObfuscatedName("b")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   static final IterableHashTable field1425;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   static final class208 field1424;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1631100405
   )
   static int field1422;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1405491047
   )
   static int field1423;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 473818279
   )
   public static int field1426;
   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   @Export("compass")
   static SpritePixels compass;

   static {
      chatLineMap = new HashMap();
      field1425 = new IterableHashTable(1024);
      field1424 = new class208();
      field1422 = 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BI)Lcx;",
      garbageValue = "-2141719315"
   )
   static Script method1822(byte[] var0) {
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
         var1.switches = var1.method1824(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.readUnsignedShort();
            IterableHashTable var9 = new IterableHashTable(class23.method168(var8));
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "110"
   )
   public static void method1815(int var0) {
      class210.field2585 = 1;
      class70.field802 = null;
      class210.field2586 = -1;
      class31.field414 = -1;
      class230.field2909 = 0;
      class230.field2905 = false;
      FrameMap.field1952 = var0;
   }
}
