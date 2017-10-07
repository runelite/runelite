import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
public class class219 implements class218 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public static final class219 field2806;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public static final class219 field2801;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public static final class219 field2797;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public static final class219 field2798;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public static final class219 field2799;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public static final class219 field2800;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public static final class219 field2804;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public static final class219 field2802;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public static final class219 field2803;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   static final class219 field2805;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 437553647
   )
   public final int field2796;

   static {
      field2806 = new class219("", 10);
      field2797 = new class219("", 11);
      field2798 = new class219("", 12);
      field2799 = new class219("", 13);
      field2800 = new class219("", 14);
      field2804 = new class219("", 15, new ScriptVarType[]{ScriptVarType.field231, ScriptVarType.field231}, (ScriptVarType[])null);
      field2802 = new class219("", 16, new ScriptVarType[]{ScriptVarType.field231, ScriptVarType.field231}, (ScriptVarType[])null);
      field2803 = new class219("", 17, new ScriptVarType[]{ScriptVarType.field231, ScriptVarType.field231}, (ScriptVarType[])null);
      field2805 = new class219("", 73, true, true);
      field2801 = new class219("", 76, true, false);
   }

   class219(String var1, int var2) {
      this(var1, var2, false, (ScriptVarType[])null, false, (ScriptVarType[])null);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZ[Lr;Z[Lr;)V"
   )
   class219(String var1, int var2, boolean var3, ScriptVarType[] var4, boolean var5, ScriptVarType[] var6) {
      this.field2796 = var2;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I[Lr;[Lr;)V"
   )
   class219(String var1, int var2, ScriptVarType[] var3, ScriptVarType[] var4) {
      this(var1, var2, var3 != null, var3, null != var4, var4);
   }

   class219(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (ScriptVarType[])null, var4, (ScriptVarType[])null);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-41"
   )
   public int rsOrdinal() {
      return this.field2796;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BI)Lcv;",
      garbageValue = "-1528227773"
   )
   static Script method4177(byte[] var0) {
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
            IterableHashTable var9 = new IterableHashTable(class88.method1780(var8));
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
