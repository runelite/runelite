import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1991224839
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("x")
   static class182 field2845;
   @ObfuscatedName("j")
   public static NodeCache field2846 = new NodeCache(64);
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1435971449
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1592532861
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-47"
   )
   static void method3557(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class225.field3235 = var1.readUnsignedShort();
      XItemContainer.field147 = new int[class225.field3235];
      class203.field3085 = new int[class225.field3235];
      class225.field3233 = new int[class225.field3235];
      class225.field3231 = new int[class225.field3235];
      RSCanvas.field1766 = new byte[class225.field3235][];
      var1.offset = var0.length - 7 - class225.field3235 * 8;
      class203.field3083 = var1.readUnsignedShort();
      class225.field3232 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class225.field3235; ++var3) {
         XItemContainer.field147[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3235; ++var3) {
         class203.field3085[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3235; ++var3) {
         class225.field3233[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3235; ++var3) {
         class225.field3231[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class225.field3235 * 8 - (var2 - 1) * 3;
      class225.field3237 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class225.field3237[var3] = var1.read24BitInt();
         if(class225.field3237[var3] == 0) {
            class225.field3237[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class225.field3235; ++var3) {
         int var4 = class225.field3233[var3];
         int var5 = class225.field3231[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         RSCanvas.field1766[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var4 * var10 + var9] = var1.readByte();
               }
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "2002014101"
   )
   void method3558(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3559(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-604912937"
   )
   void method3559(Buffer var1, int var2) {
      if(var2 == 1) {
         this.leastSignificantBit = var1.readUnsignedShort();
         this.configId = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Ljava/lang/String;Ljava/lang/String;B)LFont;",
      garbageValue = "1"
   )
   public static Font method3567(class182 var0, class182 var1, String var2, String var3) {
      int var4 = var0.method3321(var2);
      int var5 = var0.method3322(var4, var3);
      return TextureProvider.method1516(var0, var1, var4, var5);
   }
}
