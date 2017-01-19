import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -71003453
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("c")
   static NodeCache field2852 = new NodeCache(64);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -564486299
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1033854047
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;
   @ObfuscatedName("s")
   static class182 field2857;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lclass195;",
      garbageValue = "1621462875"
   )
   public static class195 method3427(int var0) {
      class195 var1 = (class195)class195.field2859.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class195.field2863.method3182(8, var0);
         var1 = new class195();
         if(null != var2) {
            var1.method3449(new Buffer(var2));
         }

         class195.field2859.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lclass48;",
      garbageValue = "-1265685436"
   )
   static class48 method3428(int var0) {
      class48 var1 = (class48)class48.field938.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = WidgetNode.field201.method3182(var0, 0);
         if(null == var2) {
            return null;
         } else {
            var1 = new class48();
            Buffer var3 = new Buffer(var2);
            var3.offset = var3.payload.length - 12;
            int var4 = var3.method2727();
            var1.field940 = var3.readUnsignedShort();
            var1.field937 = var3.readUnsignedShort();
            var1.field943 = var3.readUnsignedShort();
            var1.field939 = var3.readUnsignedShort();
            var3.offset = 0;
            var3.method2729();
            var1.field936 = new int[var4];
            var1.field934 = new int[var4];
            var1.field935 = new String[var4];

            int var6;
            for(int var5 = 0; var3.offset < var3.payload.length - 12; var1.field936[var5++] = var6) {
               var6 = var3.readUnsignedShort();
               if(var6 == 3) {
                  var1.field935[var5] = var3.method2911();
               } else if(var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.field934[var5] = var3.method2727();
               } else {
                  var1.field934[var5] = var3.readUnsignedByte();
               }
            }

            class48.field938.put(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "531004110"
   )
   void method3429(Buffer var1, int var2) {
      if(var2 == 1) {
         this.leastSignificantBit = var1.readUnsignedShort();
         this.configId = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-26"
   )
   void method3439(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3429(var1, var2);
      }
   }
}
