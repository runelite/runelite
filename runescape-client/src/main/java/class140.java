import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
public class class140 extends Node {
   @ObfuscatedName("y")
   class142 field1949;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2031446033
   )
   int field1950;
   @ObfuscatedName("r")
   class137 field1951;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -395912093
   )
   int field1952;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1361522805
   )
   int field1953;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1020469627
   )
   int field1954;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -733758451
   )
   int field1955;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1728679693
   )
   int field1956;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1592778831
   )
   int field1957;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -316828837
   )
   int field1958;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -211009617
   )
   int field1959;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1595194559
   )
   int field1960;
   @ObfuscatedName("o")
   class55 field1961;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1790939323
   )
   int field1962;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1348417117
   )
   int field1963;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 520768635
   )
   int field1964;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2060480643
   )
   int field1965;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -296499661
   )
   int field1966;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1998882217
   )
   int field1967;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 867063341
   )
   int field1968;
   @ObfuscatedName("f")
   class66 field1970;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-393602003"
   )
   void method2612() {
      this.field1949 = null;
      this.field1961 = null;
      this.field1951 = null;
      this.field1970 = null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Lclass48;",
      garbageValue = "2125432917"
   )
   static class48 method2613(int var0) {
      class48 var1 = (class48)class48.field944.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class112.field1763.getConfigData(var0, 0);
         if(null == var2) {
            return null;
         } else {
            var1 = new class48();
            Buffer var3 = new Buffer(var2);
            var3.offset = var3.payload.length - 12;
            int var4 = var3.method3062();
            var1.field942 = var3.readUnsignedShort();
            var1.field938 = var3.readUnsignedShort();
            var1.field939 = var3.readUnsignedShort();
            var1.field941 = var3.readUnsignedShort();
            var3.offset = 0;
            var3.method3113();
            var1.field934 = new int[var4];
            var1.field935 = new int[var4];
            var1.field937 = new String[var4];

            int var6;
            for(int var5 = 0; var3.offset < var3.payload.length - 12; var1.field934[var5++] = var6) {
               var6 = var3.readUnsignedShort();
               if(var6 == 3) {
                  var1.field937[var5] = var3.method2934();
               } else if(var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.field935[var5] = var3.method3062();
               } else {
                  var1.field935[var5] = var3.readUnsignedByte();
               }
            }

            class48.field944.put(var1, (long)var0);
            return var1;
         }
      }
   }
}
